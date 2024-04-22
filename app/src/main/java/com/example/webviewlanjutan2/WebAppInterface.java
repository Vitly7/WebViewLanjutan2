package com.example.webviewlanjutan2;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.net.Uri;
import android.webkit.JavascriptInterface;


import androidx.core.app.NotificationCompat;


public class WebAppInterface
{
    private Activity _activity;
    private Context _context;


    public WebAppInterface(Context context, Activity activity)
    {
        _context = context;
        _activity = activity;

    }

    @JavascriptInterface
    public void showNotification(String title, String message) {
        NotificationChannel channel = new NotificationChannel("twChannel", "TW", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager) _context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(_context, "twChannel")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setChannelId(channel.getId());
        manager.createNotificationChannel(channel);
        manager.notify(1, builder.build());
    }


    @JavascriptInterface
    public void showCall()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showWhatsApp()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        _context.startActivity(Intent.createChooser(intent, ""));
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        _context.startActivity(intent);
    }
}
