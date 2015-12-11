// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.views.LImageButton;
import com.aio.downloader.views.Rotate3dAnimation;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShowCleanActivity1 extends Activity
    implements android.view.View.OnClickListener
{
    private final class DisplayNextView
        implements android.view.animation.Animation.AnimationListener
    {

        final ShowCleanActivity1 this$0;

        public void onAnimationEnd(Animation animation)
        {
            mContainer.post(new SwapViews(null));
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        private DisplayNextView()
        {
            this$0 = ShowCleanActivity1.this;
            super();
        }

        DisplayNextView(DisplayNextView displaynextview)
        {
            this();
        }
    }

    private final class SwapViews
        implements Runnable
    {

        final ShowCleanActivity1 this$0;

        public void run()
        {
            mImageView1.setVisibility(4);
            mImageView2.setVisibility(4);
            Object obj = ShowCleanActivity1.this;
            obj.mIndex = ((ShowCleanActivity1) (obj)).mIndex + 1;
            if (mIndex % 2 == 0)
            {
                mStartAnimView = mImageView1;
            } else
            {
                mStartAnimView = mImageView2;
            }
            mStartAnimView.setVisibility(0);
            mStartAnimView.requestFocus();
            obj = new Rotate3dAnimation(-90F, 0.0F, mCenterX, mCenterY, mDepthZ, false);
            ((Rotate3dAnimation) (obj)).setDuration(mDuration);
            ((Rotate3dAnimation) (obj)).setFillAfter(true);
            ((Rotate3dAnimation) (obj)).setInterpolator(new DecelerateInterpolator());
            mStartAnimView.startAnimation(((Animation) (obj)));
        }

        private SwapViews()
        {
            this$0 = ShowCleanActivity1.this;
            super();
        }

        SwapViews(SwapViews swapviews)
        {
            this();
        }
    }


    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private Animation animation1;
    private Button button1;
    private int cishu;
    private double cont;
    private int fankui;
    private Button finish;
    private boolean flag;
    private Handler handler;
    private LImageButton header_left_showclean;
    private ImageView iv_cleanfinish;
    private ImageView iv_star;
    private android.view.ViewGroup.LayoutParams lp;
    private float mCenterX;
    private float mCenterY;
    private View mContainer;
    private float mDepthZ;
    private int mDuration;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private int mIndex;
    private ImageView mStartAnimView;
    private LImageButton maintotop;
    private int pingfen;
    private RelativeLayout rl;
    private RelativeLayout rl_rub_bottomm;
    private Double roundDouble;
    private Double roundDouble1;
    private TextView textView1;
    private TextView tv_jieguo;
    private TextView tv_junk_title;

    public ShowCleanActivity1()
    {
        flag = true;
        cont = 0.0D;
        mImageView1 = null;
        mImageView2 = null;
        mStartAnimView = null;
        mContainer = null;
        mDuration = 500;
        mCenterX = 0.0F;
        mCenterY = 0.0F;
        mDepthZ = 0.0F;
        mIndex = 0;
        handler = new Handler() {

            final ShowCleanActivity1 this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 100)
                {
                    button1.performClick();
                    finish.setVisibility(0);
                }
            }

            
            {
                this$0 = ShowCleanActivity1.this;
                super();
            }
        };
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    private void applyRotation(View view, float f, float f1)
    {
        Rotate3dAnimation rotate3danimation = new Rotate3dAnimation(f, f1, mCenterX, mCenterY, mDepthZ, true);
        rotate3danimation.setDuration(mDuration);
        rotate3danimation.setFillAfter(true);
        rotate3danimation.setInterpolator(new AccelerateInterpolator());
        rotate3danimation.setAnimationListener(new DisplayNextView(null));
        view.startAnimation(rotate3danimation);
    }

    public static long getmem_TOLAL()
    {
        Object obj;
        Object obj2;
        Object obj4;
        String s;
        Object obj5;
        obj4 = null;
        obj2 = null;
        obj5 = null;
        obj = null;
        s = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/meminfo"), 8);
        s = ((BufferedReader) (obj1)).readLine();
        Object obj3;
        obj = obj2;
        if (s != null)
        {
            obj = s;
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((IOException) (obj1)).printStackTrace();
            }
        }
        return (long)Integer.parseInt(((String) (obj)).substring(((String) (obj)).indexOf(':') + 1, ((String) (obj)).indexOf('k')).trim());
        obj3;
        obj1 = s;
_L6:
        obj = obj1;
        ((FileNotFoundException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_55;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_55;
        obj3;
        obj1 = obj5;
_L4:
        obj = obj1;
        ((IOException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_55;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_55;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Double roundDouble(double d, int i)
    {
        double d1 = i;
        try
        {
            d1 = Math.pow(10D, d1);
            d = Math.floor(d * d1 + 0.5D) / d1;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return Double.valueOf(d);
    }

    public void onClick(View view)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b0);
        mImageView1 = (ImageView)findViewById(0x7f070037);
        mImageView2 = (ImageView)findViewById(0x7f0703c7);
        mContainer = findViewById(0x7f070075);
        finish = (Button)findViewById(0x7f0703ca);
        mStartAnimView = mImageView1;
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 2);
        button1 = (Button)findViewById(0x7f0702c4);
        findViewById(0x7f0702c4).setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity1 this$0;

            public void onClick(View view)
            {
                mCenterX = (float)(mContainer.getWidth() / 2);
                mCenterY = (float)(mContainer.getHeight() / 2);
                applyRotation(mStartAnimView, 0.0F, 90F);
            }

            
            {
                this$0 = ShowCleanActivity1.this;
                super();
            }
        });
        header_left_showclean = (LImageButton)findViewById(0x7f0703c3);
        header_left_showclean.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity1 this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = ShowCleanActivity1.this;
                super();
            }
        });
        tv_junk_title = (TextView)findViewById(0x7f0703c4);
        tv_jieguo = (TextView)findViewById(0x7f0703c8);
        bundle = (TextView)findViewById(0x7f0703c9);
        int i = getIntent().getIntExtra("juti", 0);
        if (getIntent().getIntExtra("junk", 0) == 1)
        {
            tv_junk_title.setText("Junk Files");
        }
        Log.e("fff", (new StringBuilder(String.valueOf(i))).append("---0000juti000---").toString());
        roundDouble1 = roundDouble((double)i / 1024D, 2);
        Log.e("fff", (new StringBuilder()).append(roundDouble1).append("---0000000---").toString());
        if (roundDouble1.doubleValue() < 20D)
        {
            tv_jieguo.setText("Very clean!");
            bundle.setVisibility(8);
        }
        (new Thread() {

            final ShowCleanActivity1 this$0;

            public void run()
            {
                super.run();
                do
                {
                    do
                    {
                        if (!flag)
                        {
                            handler.sendEmptyMessage(100);
                            return;
                        }
                        ShowCleanActivity1 showcleanactivity1 = ShowCleanActivity1.this;
                        showcleanactivity1.cont = showcleanactivity1.cont + 2.1000000000000001D;
                        cont = ShowCleanActivity1.roundDouble(cont, 2).doubleValue();
                        Log.e("fff", (new StringBuilder("cont")).append(cont).toString());
                        tv_jieguo.post(new Runnable() {

                            final _cls4 this$1;

                            public void run()
                            {
                                if (cont < 1024D)
                                {
                                    tv_jieguo.setText((new StringBuilder("Cleaned: ")).append(cont).append("MB").toString());
                                    return;
                                } else
                                {
                                    tv_jieguo.setText((new StringBuilder("Cleaned: ")).append(ShowCleanActivity1.roundDouble(cont / 1024D, 2)).append("GB").toString());
                                    return;
                                }
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        });
                        try
                        {
                            sleep(15L);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            interruptedexception.printStackTrace();
                        }
                    } while (cont < roundDouble1.doubleValue());
                    flag = false;
                } while (true);
            }


            
            {
                this$0 = ShowCleanActivity1.this;
                super();
            }
        }).start();
        if (getmem_TOLAL() / 1024L / 1024L >= 1L)
        {
            roundDouble = roundDouble((double)getmem_TOLAL() / 1024D / 1024D, 2);
            bundle.setText((new StringBuilder(String.valueOf(getResources().getString(0x7f0b0079)))).append(roundDouble).append("GB").toString());
        } else
        {
            roundDouble = roundDouble((double)getmem_TOLAL() / 1024D, 2);
            bundle.setText((new StringBuilder(String.valueOf(getResources().getString(0x7f0b0079)))).append(roundDouble).append("MB").toString());
        }
        finish.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity1 this$0;

            public void onClick(View view)
            {
                view = null;
                android.content.pm.PackageInfo packageinfo;
                try
                {
                    packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    namenotfoundexception.printStackTrace();
                    continue; /* Loop/switch isn't completed */
                }
                view = packageinfo;
_L6:
                if (view != null)
                {
                    break MISSING_BLOCK_LABEL_142;
                }
                if (!PRO_DIR_FOME.exists()) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
_L4:
                return;
_L2:
                if (!PRO_DIR_TO.exists()) goto _L4; else goto _L3
_L3:
                (new AsyncTask() {

                    final _cls5 this$1;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
                        return null;
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                        void1 = new Intent("android.intent.action.VIEW");
                        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                        void1.addFlags(0x10000000);
                        startActivity(void1);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                }).execute(new Void[0]);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
                if (true) goto _L6; else goto _L5
_L5:
            }


            
            {
                this$0 = ShowCleanActivity1.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }


























}
