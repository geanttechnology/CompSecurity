// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.LFrameLayout;
import com.aio.downloader.views.LImageButton;
import com.ant.liao.GifImageType;
import com.ant.liao.GifView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FunGifActivity extends Activity
    implements android.view.View.OnClickListener, android.view.GestureDetector.OnGestureListener
{
    private class AnimateFirstDisplayListener extends SimpleImageLoadingListener
    {

        final List displayedImages;
        final FunGifActivity this$0;

        public void onLoadingComplete(String s, View view, Bitmap bitmap1)
        {
            if (bitmap1 != null)
            {
                view = (ImageView)view;
                boolean flag;
                if (displayedImages.contains(s))
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    FadeInBitmapDisplayer.animate(view, 500);
                    displayedImages.add(s);
                }
            }
        }

        private AnimateFirstDisplayListener()
        {
            this$0 = FunGifActivity.this;
            super();
            displayedImages = Collections.synchronizedList(new LinkedList());
        }

        AnimateFirstDisplayListener(AnimateFirstDisplayListener animatefirstdisplaylistener)
        {
            this();
        }
    }


    public static final int GIF_LOAD_FINISH = 291;
    private ImageLoadingListener animateFirstListener;
    private String apath;
    private MyApplcation app;
    private LinearLayout appbanner;
    private Bitmap bitmap;
    private int detailcount;
    private String detailserial;
    private String detailtitle;
    private String fullPath;
    private GifView gifView;
    private String gif_name;
    private Handler handler;
    private ImageLoader imageLoader;
    private LImageButton iv_detail_back;
    private ImageView iv_gif;
    private ImageView iv_gif_likeshow;
    private LFrameLayout lf_gif_download;
    private LFrameLayout lf_gif_like;
    private LFrameLayout lf_gif_share;
    private LinearLayout ll_gif_detail;
    private DisplayImageOptions options;
    android.view.ViewGroup.LayoutParams para;
    private ProgressWheel progress_wheel_gif;
    private RelativeLayout rl_gif_gongneng;
    private TextView tv_detail_title;
    private ViewTreeObserver viewTreeObserver;
    private int window_height;
    private int window_width;

    public FunGifActivity()
    {
        imageLoader = ImageLoader.getInstance();
        animateFirstListener = new AnimateFirstDisplayListener(null);
        bitmap = null;
        handler = new Handler() {

            final FunGifActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what != 291 && message.what != 1) goto _L2; else goto _L1
_L1:
                progress_wheel_gif.setVisibility(8);
                iv_gif.setVisibility(8);
                if (message.what != 291) goto _L4; else goto _L3
_L3:
                message = (File)message.obj;
                gifView.setGifImage(message.getAbsolutePath());
                viewTreeObserver = gifView.getViewTreeObserver();
_L6:
                return;
_L4:
                message = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(gif_name).append(".gif").toString();
                gifView.setGifImage(message);
                viewTreeObserver = gifView.getViewTreeObserver();
                Toast.makeText(getApplicationContext(), "Download Complete", 0).show();
                try
                {
                    android.provider.MediaStore.Images.Media.insertImage(getContentResolver(), (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").toString(), (new StringBuilder(String.valueOf(gif_name))).append(".gif").toString(), null);
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    try
                    {
                        message.printStackTrace();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        message.printStackTrace();
                        return;
                    }
                }
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(gif_name).append(".gif").toString())));
                return;
_L2:
                if (message.what == 2)
                {
                    Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
                    return;
                }
                if (message.what == 3)
                {
                    Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
                    return;
                }
                if (message.what == 4)
                {
                    progress_wheel_gif.setVisibility(8);
                    iv_gif.setVisibility(8);
                    message = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(gif_name).append(".gif").toString();
                    gifView.setGifImage(message);
                    viewTreeObserver = gifView.getViewTreeObserver();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        };
    }

    private void getImage(final String uri)
    {
        if ((new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(gif_name).append(".gif").toString())).exists())
        {
            Toast.makeText(this, "ALREADY EXISTS", 0).show();
            return;
        } else
        {
            (new Thread(new Runnable() {

                final FunGifActivity this$0;
                private final String val$uri;

                public void run()
                {
                    Object obj = null;
                    URL url = new URL(uri);
                    obj = url;
_L3:
                    Object obj2;
                    byte abyte0[];
                    int i;
                    Object obj1;
                    MalformedURLException malformedurlexception;
                    InputStream inputstream;
                    boolean flag;
                    try
                    {
                        obj1 = (HttpURLConnection)((URL) (obj)).openConnection();
                        ((HttpURLConnection) (obj1)).connect();
                        inputstream = ((HttpURLConnection) (obj1)).getInputStream();
                        obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(gif_name).append(".gif").toString());
                        if (!((File) (obj)).getParentFile().exists())
                        {
                            ((File) (obj)).getParentFile().mkdirs();
                        }
                        flag = ((File) (obj)).exists();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((IOException) (obj)).printStackTrace();
                        handler.sendEmptyMessage(3);
                        return;
                    }
                    if (flag)
                    {
                        break MISSING_BLOCK_LABEL_121;
                    }
                    ((File) (obj)).createNewFile();
_L4:
                    obj2 = new FileOutputStream(((File) (obj)));
                    abyte0 = new byte[1024];
_L5:
                    i = inputstream.read(abyte0);
                    if (i > 0) goto _L2; else goto _L1
_L1:
                    ((FileOutputStream) (obj2)).flush();
                    ((FileOutputStream) (obj2)).close();
                    inputstream.close();
                    ((HttpURLConnection) (obj1)).disconnect();
                    obj1 = new FileInputStream(((File) (obj)));
                    new android.graphics.BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeStream(((InputStream) (obj1)));
                    ((FileInputStream) (obj1)).close();
                    obj1 = new Message();
                    obj1.what = 1;
                    handler.sendMessage(((Message) (obj1)));
_L7:
                    return;
                    malformedurlexception;
                    malformedurlexception.printStackTrace();
                      goto _L3
                    obj2;
                    ((IOException) (obj2)).printStackTrace();
                      goto _L4
_L2:
                    System.out.println((new StringBuilder("ffd ")).append(i).toString());
                    ((FileOutputStream) (obj2)).write(abyte0, 0, i);
                      goto _L5
                    obj;
                    ((FileNotFoundException) (obj)).printStackTrace();
                    handler.sendEmptyMessage(2);
                    return;
                    IOException ioexception;
                    ioexception;
                    ioexception.printStackTrace();
                    if (!((File) (obj)).exists()) goto _L7; else goto _L6
_L6:
                    ((File) (obj)).delete();
                    return;
                      goto _L3
                }

            
            {
                this$0 = FunGifActivity.this;
                uri = s;
                super();
            }
            })).start();
            return;
        }
    }

    private void initDatas()
    {
        fullPath = getIntent().getStringExtra("fullpath");
        apath = getIntent().getStringExtra("apath");
        detailtitle = getIntent().getStringExtra("detailtitle");
        detailcount = getIntent().getIntExtra("detailcount", 0);
        detailserial = getIntent().getStringExtra("detailserial");
        String as[] = fullPath.split("/");
        gif_name = as[as.length - 1].split(".gif")[0];
        lf_gif_download.setOnClickListener(new android.view.View.OnClickListener() {

            final FunGifActivity this$0;

            public void onClick(View view)
            {
                getImage(fullPath);
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
        app.asyncLoadImage(apath, iv_gif);
        Log.e("www", (new StringBuilder("fullPath=")).append(fullPath).toString());
        gifView.setLoopAnimation();
        gifView.setGifImageType(GifImageType.COVER);
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheOnDisc().showStubImage(0x7f02006f).showImageOnFail(0x7f02006f).build();
        if ((new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").append("/").append(gif_name).append(".gif").toString())).exists())
        {
            Message message = new Message();
            message.what = 4;
            handler.sendMessage(message);
            return;
        } else
        {
            getImage(fullPath);
            return;
        }
    }

    private void setListener()
    {
        gifView.setOnClickListener(this);
        (new GestureDetector(this, this)).setOnDoubleTapListener(new android.view.GestureDetector.OnDoubleTapListener() {

            final FunGifActivity this$0;

            public boolean onDoubleTap(MotionEvent motionevent)
            {
                return false;
            }

            public boolean onDoubleTapEvent(MotionEvent motionevent)
            {
                return false;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                finish();
                return false;
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165709: 
            break;
        }
        if (ll_gif_detail.getVisibility() == 0)
        {
            ll_gif_detail.setVisibility(8);
            rl_gif_gongneng.setVisibility(8);
            appbanner.setVisibility(8);
            iv_detail_back.setVisibility(8);
            return;
        } else
        {
            ll_gif_detail.setVisibility(0);
            rl_gif_gongneng.setVisibility(0);
            appbanner.setVisibility(0);
            iv_detail_back.setVisibility(0);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030050);
        ll_gif_detail = (LinearLayout)findViewById(0x7f07020f);
        rl_gif_gongneng = (RelativeLayout)findViewById(0x7f07020e);
        gifView = (GifView)findViewById(0x7f07020d);
        progress_wheel_gif = (ProgressWheel)findViewById(0x7f070211);
        tv_detail_title = (TextView)findViewById(0x7f070116);
        lf_gif_like = (LFrameLayout)findViewById(0x7f070212);
        lf_gif_download = (LFrameLayout)findViewById(0x7f070214);
        lf_gif_share = (LFrameLayout)findViewById(0x7f070215);
        iv_gif_likeshow = (ImageView)findViewById(0x7f070213);
        iv_detail_back = (LImageButton)findViewById(0x7f070114);
        iv_detail_back.setOnClickListener(new android.view.View.OnClickListener() {

            final FunGifActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
        lf_gif_like.setOnClickListener(new android.view.View.OnClickListener() {

            final FunGifActivity this$0;
            private String url_like;

            public void onClick(View view)
            {
                iv_gif_likeshow.setImageResource(0x7f0200ba);
                url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(detailserial).toString();
                (new Thread() {

                    final _cls3 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                        publicTools.getUrl(url_like);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                }).start();
            }


            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
        lf_gif_share.setOnClickListener(new android.view.View.OnClickListener() {

            final FunGifActivity this$0;
            private String url_share;

            public void onClick(View view)
            {
                url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(detailserial).toString();
                (new Thread() {

                    final _cls4 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                        publicTools.getUrl(url_share);
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                }).start();
                view = (new StringBuilder("Share: ")).append(detailtitle).append("\nhttp://welaf.com/fun/share.php?id=").append(detailserial).toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", view);
                startActivity(Intent.createChooser(intent, "AIO Downloaded"));
            }


            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
        appbanner = (LinearLayout)findViewById(0x7f070070);
        bundle = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/1272210540");
        appbanner.addView(bundle);
        bundle.loadAd(new AdRequest());
        progress_wheel_gif.setVisibility(0);
        iv_gif = (ImageView)findViewById(0x7f070210);
        bundle = getWindowManager();
        window_width = bundle.getDefaultDisplay().getWidth();
        window_height = bundle.getDefaultDisplay().getHeight();
        try
        {
            app = (MyApplcation)getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        initDatas();
        setListener();
        tv_detail_title.setText(detailtitle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            finish();
            overridePendingTransition(0, 0);
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        finish();
        return false;
    }












}
