// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Streams;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdAlertReporter
{

    private static final String BODY_SEPARATOR = "\n=================\n";
    private static final String DATE_FORMAT_PATTERN = "M/d/yy hh:mm:ss a z";
    private static final String EMAIL_RECIPIENT = "creative-review@mopub.com";
    private static final String EMAIL_SCHEME = "mailto:";
    private static final int IMAGE_QUALITY = 25;
    private static final String MARKUP_FILENAME = "mp_adalert_markup.html";
    private static final String PARAMETERS_FILENAME = "mp_adalert_parameters.txt";
    private static final String SCREEN_SHOT_FILENAME = "mp_adalert_screenshot.png";
    private final Context mContext;
    private final String mDateString;
    private ArrayList mEmailAttachments;
    private Intent mEmailIntent;
    private String mParameters;
    private String mResponse;
    private final View mView;

    public AdAlertReporter(Context context, View view, AdReport adreport)
    {
        mView = view;
        mContext = context;
        mEmailAttachments = new ArrayList();
        mDateString = (new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US)).format(DateAndTime.now());
        initEmailIntent();
        context = takeScreenShot();
        view = convertBitmapInWEBPToBase64EncodedString(context);
        mParameters = "";
        mResponse = "";
        if (adreport != null)
        {
            mParameters = adreport.toString();
            mResponse = adreport.getResponseString();
        }
        addEmailSubject();
        addEmailBody(new String[] {
            mParameters, mResponse, view
        });
        addTextAttachment("mp_adalert_parameters.txt", mParameters);
        addTextAttachment("mp_adalert_markup.html", mResponse);
        addImageAttachment("mp_adalert_screenshot.png", context);
    }

    private transient void addEmailBody(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < as.length; i++)
        {
            stringbuilder.append(as[i]);
            if (i != as.length - 1)
            {
                stringbuilder.append("\n=================\n");
            }
        }

        mEmailIntent.putExtra("android.intent.extra.TEXT", stringbuilder.toString());
    }

    private void addEmailSubject()
    {
        mEmailIntent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append("New creative violation report - ").append(mDateString).toString());
    }

    private void addImageAttachment(String s, Bitmap bitmap)
    {
        FileOutputStream fileoutputstream;
        FileOutputStream fileoutputstream1;
        fileoutputstream1 = null;
        fileoutputstream = null;
        if (s == null || bitmap == null)
        {
            return;
        }
        FileOutputStream fileoutputstream2 = mContext.openFileOutput(s, 1);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 25, fileoutputstream2);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        bitmap = Uri.fromFile(new File((new StringBuilder()).append(mContext.getFilesDir()).append(File.separator).append(s).toString()));
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        mEmailAttachments.add(bitmap);
        Streams.closeStream(fileoutputstream2);
        return;
        bitmap;
        fileoutputstream1 = fileoutputstream;
        MoPubLog.d((new StringBuilder()).append("Unable to write text attachment to file: ").append(s).toString());
        Streams.closeStream(fileoutputstream);
        return;
        s;
        Streams.closeStream(fileoutputstream1);
        throw s;
    }

    private void addTextAttachment(String s, String s1)
    {
        FileOutputStream fileoutputstream;
        FileOutputStream fileoutputstream1;
        fileoutputstream1 = null;
        fileoutputstream = null;
        if (s == null || s1 == null)
        {
            return;
        }
        FileOutputStream fileoutputstream2 = mContext.openFileOutput(s, 1);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        fileoutputstream2.write(s1.getBytes());
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        s1 = Uri.fromFile(new File((new StringBuilder()).append(mContext.getFilesDir()).append(File.separator).append(s).toString()));
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        mEmailAttachments.add(s1);
        Streams.closeStream(fileoutputstream2);
        return;
        s1;
        fileoutputstream1 = fileoutputstream;
        MoPubLog.d((new StringBuilder()).append("Unable to write text attachment to file: ").append(s).toString());
        Streams.closeStream(fileoutputstream);
        return;
        s;
        Streams.closeStream(fileoutputstream1);
        throw s;
    }

    private String convertBitmapInWEBPToBase64EncodedString(Bitmap bitmap)
    {
        Object obj = null;
        if (bitmap != null)
        {
            try
            {
                obj = new ByteArrayOutputStream();
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 25, ((java.io.OutputStream) (obj)));
                obj = Base64.encodeToString(((ByteArrayOutputStream) (obj)).toByteArray(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                return null;
            }
        }
        return ((String) (obj));
    }

    private void initEmailIntent()
    {
        Uri uri = Uri.parse("mailto:");
        mEmailIntent = new Intent("android.intent.action.SEND_MULTIPLE");
        mEmailIntent.setDataAndType(uri, "plain/text");
        mEmailIntent.putExtra("android.intent.extra.EMAIL", new String[] {
            "creative-review@mopub.com"
        });
    }

    private Bitmap takeScreenShot()
    {
        if (mView != null && mView.getRootView() != null)
        {
            View view = mView.getRootView();
            boolean flag = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = view.getDrawingCache();
            if (bitmap != null)
            {
                bitmap = Bitmap.createBitmap(bitmap);
                view.setDrawingCacheEnabled(flag);
                return bitmap;
            }
        }
        return null;
    }

    ArrayList getEmailAttachments()
    {
        return mEmailAttachments;
    }

    Intent getEmailIntent()
    {
        return mEmailIntent;
    }

    String getParameters()
    {
        return mParameters;
    }

    String getResponse()
    {
        return mResponse;
    }

    public void send()
    {
        mEmailIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", mEmailAttachments);
        Intent intent = Intent.createChooser(mEmailIntent, "Send Email...");
        intent.addFlags(0x10000000);
        mContext.startActivity(intent);
    }
}
