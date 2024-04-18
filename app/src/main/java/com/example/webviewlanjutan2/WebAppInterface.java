package com.example.webviewlanjutan2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface
{
    private Activity _activity;
    private Context _context;

    public WebAppInterface(Context context, Activity activity)
    {
        _context = context;
        _activity = activity;
    }

//    @JavascriptInterface
//    public void showToast(String message)
//    {
//        Toast.makeText(_context, message, Toast.LENGTH_LONG).show();
//    }
//
//    @JavascriptInterface
//    public void showSms()
//    {
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
//        _context.startActivity(intent);
//    }
    @JavascriptInterface
    public void showNotification(String message)
        {
        Toast.makeText(_context, message, Toast.LENGTH_LONG).show();
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
        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=PHONE_NUMBER"));
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        _context.startActivity(intent);
    }
}
