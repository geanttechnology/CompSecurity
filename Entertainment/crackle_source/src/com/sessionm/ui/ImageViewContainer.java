// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sessionm.b.a;
import com.sessionm.net.Request;
import com.sessionm.net.c;
import com.sessionm.net.http.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.sessionm.ui:
//            ProgressViewController

public class ImageViewContainer extends RelativeLayout
{
    static interface Listener
    {

        public abstract void onCanceled(ImageViewContainer imageviewcontainer);

        public abstract void onError(ImageViewContainer imageviewcontainer);

        public abstract void onImageSaved(ImageViewContainer imageviewcontainer);
    }


    private static final String ALBUM = "album";
    private static final String M_POINTS = "mPoints";
    private static final String TAG = "SessionM.ImageView";
    private String albumDir;
    private Bitmap bmp;
    private Button cancelButton;
    private ImageView imageView;
    private Listener listener;
    private a message;
    private ProgressViewController progressView;
    private Button saveButton;
    private String url;

    public ImageViewContainer(Activity activity, String s, a a1, Listener listener1)
    {
        super(activity);
        albumDir = "mPoints";
        message = a1;
        if (a1.has("album"))
        {
            albumDir = a1.getString("album");
        }
        listener = listener1;
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(0xff000000);
        url = s;
        progressView = new ProgressViewController(activity, this, new ProgressViewController.Listener() {

            final ImageViewContainer this$0;

            public void onCancel()
            {
                if (listener != null)
                {
                    listener.onCanceled(ImageViewContainer.this);
                }
            }

            public void onReloadStarted()
            {
                startImageDownload();
            }

            
            {
                this$0 = ImageViewContainer.this;
                super();
            }
        }, true);
        startImageDownload();
        progressView.present(ProgressViewController.ReloadPromptState.LOADING);
        s = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
            0xff444444, 0xff000000
        });
        saveButton = new Button(activity);
        saveButton.setText("Save");
        saveButton.setTextColor(-1);
        saveButton.setBackgroundColor(0xff000000);
        saveButton.setEnabled(false);
        a1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        a1.addRule(11);
        a1.setMargins(5, 5, 5, 5);
        saveButton.setLayoutParams(a1);
        saveButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ImageViewContainer this$0;

            public void onClick(View view)
            {
                view = createImageFile();
                if (view != null)
                {
                    galleryAddPic(view);
                }
_L2:
                return;
                view;
                if (Log.isLoggable("SessionM.ImageView", 6))
                {
                    Log.e("SessionM.ImageView", "error saving image.", view);
                }
                if (listener != null)
                {
                    listener.onError(ImageViewContainer.this);
                    return;
                }
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = ImageViewContainer.this;
                super();
            }
        });
        cancelButton = new Button(activity);
        cancelButton.setText("Cancel");
        cancelButton.setTextColor(-1);
        cancelButton.setBackgroundColor(0xff000000);
        a1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        a1.addRule(9);
        a1.setMargins(5, 5, 5, 5);
        cancelButton.setLayoutParams(a1);
        cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ImageViewContainer this$0;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    listener.onCanceled(ImageViewContainer.this);
                }
            }

            
            {
                this$0 = ImageViewContainer.this;
                super();
            }
        });
        activity = new RelativeLayout(activity);
        a1 = new android.widget.RelativeLayout.LayoutParams(-1, 80);
        activity.setLayoutParams(a1);
        a1.addRule(12);
        activity.addView(saveButton);
        activity.addView(cancelButton);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            activity.setBackgroundDrawable(s);
        } else
        {
            activity.setBackground(s);
        }
        addView(activity);
    }

    private File createImageFile()
        throws IOException
    {
        Object obj = (new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)).format(new Date());
        obj = (new StringBuilder()).append("IMG").append(((String) (obj))).toString();
        Object obj1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), albumDir);
        ((File) (obj1)).mkdirs();
        if (Log.isLoggable("SessionM.ImageView", 4))
        {
            Log.i("SessionM.ImageView", (new StringBuilder()).append("file saved to: ").append(obj1).toString());
        }
        obj = File.createTempFile(((String) (obj)), ".jpg", ((File) (obj1)));
        obj1 = new FileOutputStream(((File) (obj)));
        bmp.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (obj1)));
        ((FileOutputStream) (obj1)).flush();
        ((FileOutputStream) (obj1)).close();
        return ((File) (obj));
    }

    private void galleryAddPic(File file)
    {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        if (intent.resolveActivity(getContext().getPackageManager()) == null)
        {
            if (listener != null)
            {
                listener.onError(this);
            }
            return;
        } else
        {
            getContext().sendBroadcast(intent);
            return;
        }
    }

    private void startImageDownload()
    {
        Request request = new Request(com.sessionm.net.Request.Type.fm, new Object[] {
            url
        });
        request.d(com.sessionm.net.Request.Header.eM.getKey(), "no-cache");
        request.a(new c() {

            final ImageViewContainer this$0;

            public void onReplyReceived(Request request1)
            {
                if (Log.isLoggable("SessionM.ImageView", 3))
                {
                    Log.d("SessionM.ImageView", String.format(Locale.US, "finished image request: %s", new Object[] {
                        request1.getURL()
                    }));
                }
                if (request1.ba() == com.sessionm.net.Request.State.fg)
                {
                    byte abyte0[] = new byte[0];
                    if (request1.aR() != null)
                    {
                        abyte0 = request1.aR().bB();
                    }
                    bmp = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
                    ((Activity)getContext()).runOnUiThread(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            progressView.dismiss();
                            imageView = new ImageView(getContext());
                            imageView.setPadding(1, 1, 1, 1);
                            imageView.setBackgroundColor(-1);
                            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                            layoutparams.setMargins(20, 30, 20, 90);
                            layoutparams.addRule(13);
                            imageView.setImageBitmap(bmp);
                            imageView.setLayoutParams(layoutparams);
                            addView(imageView);
                            saveButton.setEnabled(true);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                } else
                {
                    ((Activity)getContext()).runOnUiThread(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            progressView.setReloadPropmptState(ProgressViewController.ReloadPromptState.UNAVAILABLE);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = ImageViewContainer.this;
                super();
            }
        });
        request.send();
    }

    a getMessage()
    {
        return message;
    }







/*
    static Bitmap access$402(ImageViewContainer imageviewcontainer, Bitmap bitmap)
    {
        imageviewcontainer.bmp = bitmap;
        return bitmap;
    }

*/




/*
    static ImageView access$602(ImageViewContainer imageviewcontainer, ImageView imageview)
    {
        imageviewcontainer.imageView = imageview;
        return imageview;
    }

*/

}
