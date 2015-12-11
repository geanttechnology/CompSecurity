// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.pager.JazzyViewPager;
import com.aio.downloader.pager.OutlineContainer;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.LFrameLayout;
import com.aio.downloader.views.LImageButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;
import com.umeng.analytics.MobclickAgent;
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
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            FunChapingActivity, AppDetailsActivity

public class FunImagePagerActivity extends Activity
    implements android.support.v4.view.ViewPager.OnPageChangeListener, AdListener, com.facebook.ads.AdListener
{
    private class MyPageAdapter extends PagerAdapter
    {

        static final boolean $assertionsDisabled;
        private AdView adView;
        ArrayList list;
        final FunImagePagerActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView(viewPager.findViewFromObject(i));
        }

        public int getCount()
        {
            if (list == null || list.size() == 0)
            {
                return list.size();
            } else
            {
                return list.size();
            }
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view = inflater.inflate(0x7f030059, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            } else
            {
                Log.e("qwer", "fdfdfdf");
                ImageView imageview = (ImageView)view.findViewById(0x7f070245);
                appbanner = (LinearLayout)view.findViewById(0x7f070246);
                adView = new AdView(FunImagePagerActivity.this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/1272210540");
                appbanner.addView(adView);
                adView.loadAd(new AdRequest());
                Log.e("qwer", (new StringBuilder("adView=")).append(adView).toString());
                imageview.setOnClickListener(new android.view.View.OnClickListener() {

                    final MyPageAdapter this$1;

                    public void onClick(View view)
                    {
                        if (iv_detail_back.getVisibility() == 0)
                        {
                            iv_detail_back.setVisibility(8);
                            tv_detail_title.setVisibility(8);
                            tv_detail_jingdu.setVisibility(8);
                            rl_fun_gongneng.setVisibility(8);
                            appbanner.setVisibility(8);
                            return;
                        } else
                        {
                            iv_detail_back.setVisibility(0);
                            tv_detail_title.setVisibility(0);
                            tv_detail_jingdu.setVisibility(0);
                            rl_fun_gongneng.setVisibility(0);
                            appbanner.setVisibility(0);
                            return;
                        }
                    }

            
            {
                this$1 = MyPageAdapter.this;
                super();
            }
                });
                Log.e("picture", (new StringBuilder("++++++list.get(position)=")).append((String)list.get(i)).toString());
                app.asyncLoadImage1((String)list.get(i), imageview);
                ((JazzyViewPager)viewgroup).addView(view, -1, -1);
                viewPager.setObjectForPosition(view, i);
                return view;
            }
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            if (!(view instanceof OutlineContainer)) goto _L2; else goto _L1
_L1:
            if (((OutlineContainer)view).getChildAt(0) != obj) goto _L4; else goto _L3
_L3:
            return true;
_L4:
            return false;
_L2:
            if (view != obj)
            {
                return false;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        static 
        {
            boolean flag;
            if (!com/aio/downloader/activity/FunImagePagerActivity.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }


        public MyPageAdapter(ArrayList arraylist)
        {
            this$0 = FunImagePagerActivity.this;
            super();
            list = arraylist;
            inflater = getLayoutInflater();
        }
    }


    private File AIOGALLERY;
    private File AIOGALLERYAPK;
    private MyApplcation app;
    private LinearLayout appbanner;
    private Bitmap bitmap;
    private int dPicture;
    private int detailcount;
    private String detailserial;
    private String detailtitle;
    private int gag;
    private Handler handler;
    private LayoutInflater inflater;
    private InterstitialAd interstitial;
    private LImageButton iv_detail_back;
    private ImageView iv_fun_likeshow;
    private ImageView iv_mygift;
    private ImageView iv_mygift_gallery;
    private LFrameLayout lf_fun_download;
    private LFrameLayout lf_fun_like;
    private LFrameLayout lf_fun_share;
    private ArrayList list;
    private LinearLayout ll_mygift;
    private LinearLayout ll_mygift_gallery;
    private NativeAd nativeAd;
    private String picture_name;
    private RelativeLayout rl_fun_gongneng;
    private int screenshotpos;
    private Animation shake;
    private TextView tv_detail_jingdu;
    private TextView tv_detail_title;
    private String url;
    private String url_gallery;
    private JazzyViewPager viewPager;

    public FunImagePagerActivity()
    {
        AIOGALLERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.swf").toString());
        AIOGALLERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.apk").toString());
        bitmap = null;
        dPicture = 0;
        handler = new Handler() {

            final FunImagePagerActivity this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 1 3: default 32
            //                           1 33
            //                           2 194
            //                           3 211;
                   goto _L1 _L2 _L3 _L4
_L1:
                return;
_L2:
                Toast.makeText(getApplicationContext(), "Download Complete", 0).show();
                try
                {
                    android.provider.MediaStore.Images.Media.insertImage(getContentResolver(), (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").toString(), (new StringBuilder(String.valueOf(picture_name))).append(".jpg").toString(), null);
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
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").append("/").append(picture_name).append(".jpg").toString())));
                return;
_L3:
                Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
                return;
_L4:
                Toast.makeText(getApplicationContext(), "File does not exist!", 0).show();
                return;
            }

            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        };
    }

    private void facebookad()
    {
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), iv_mygift);
        nativeAd.registerViewForInteraction(iv_mygift);
    }

    private void getImage(final String uri)
    {
        if ((new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").append("/").append(picture_name).append(".jpg").toString())).exists())
        {
            Toast.makeText(this, "ALREADY EXISTS", 0).show();
            return;
        } else
        {
            (new Thread(new Runnable() {

                final FunImagePagerActivity this$0;
                private final String val$uri;

                public void run()
                {
                    Object obj = null;
                    URL url1 = new URL(uri);
                    obj = url1;
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
                        obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").append("/").append(picture_name).append(".jpg").toString());
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
                this$0 = FunImagePagerActivity.this;
                uri = s;
                super();
            }
            })).start();
            return;
        }
    }

    private void init()
    {
        app = (MyApplcation)getApplicationContext();
        viewPager = (JazzyViewPager)findViewById(0x7f070111);
        tv_detail_title = (TextView)findViewById(0x7f070116);
        tv_detail_jingdu = (TextView)findViewById(0x7f070113);
        iv_detail_back = (LImageButton)findViewById(0x7f070114);
        ll_mygift = (LinearLayout)findViewById(0x7f07011b);
        iv_mygift = (ImageView)findViewById(0x7f07011c);
        lf_fun_download = (LFrameLayout)findViewById(0x7f070119);
        rl_fun_gongneng = (RelativeLayout)findViewById(0x7f070112);
        lf_fun_like = (LFrameLayout)findViewById(0x7f070117);
        lf_fun_share = (LFrameLayout)findViewById(0x7f07011a);
        iv_fun_likeshow = (ImageView)findViewById(0x7f070118);
        ll_mygift_gallery = (LinearLayout)findViewById(0x7f07011d);
        iv_mygift_gallery = (ImageView)findViewById(0x7f07011e);
        iv_mygift_gallery.setOnClickListener(new android.view.View.OnClickListener() {

            final FunImagePagerActivity this$0;

            public void onClick(View view)
            {
                Log.e("qwer", "fun_gallery");
                MobclickAgent.onEvent(getApplicationContext(), "fun_gallery");
                try
                {
                    if (AIOGALLERYAPK.exists() && getFileSizes(AIOGALLERYAPK) >= 0x1bff04L)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
                        view.addFlags(0x10000000);
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                if (AIOGALLERY.exists() && getFileSizes(AIOGALLERYAPK) >= 0x1bff04L)
                {
                    (new AsyncTask() {

                        final _cls3 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOGALLERY, AIOGALLERYAPK, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.androidapp.gallary3d");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }


            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        });
        iv_detail_back.setOnClickListener(new android.view.View.OnClickListener() {

            final FunImagePagerActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        });
        tv_detail_title.setText(detailtitle);
        com.aio.downloader.pager.JazzyViewPager.TransitionEffect transitioneffect = com.aio.downloader.pager.JazzyViewPager.TransitionEffect.Tablet;
        viewPager.setTransitionEffect(transitioneffect);
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(new MyPageAdapter(list));
        viewPager.setCurrentItem(screenshotpos);
    }

    private void show_big_ad()
    {
        interstitial = new InterstitialAd(this, "ca-app-pub-2192624499353475/7318744145");
        AdRequest adrequest = new AdRequest();
        interstitial.loadAd(adrequest);
        interstitial.setAdListener(this);
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        } else
        {
            nativeAd.unregisterView();
            ll_mygift.setVisibility(8);
            ll_mygift_gallery.setVisibility(8);
            ll_mygift_gallery.clearAnimation();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001c);
        list = (ArrayList)getIntent().getSerializableExtra("screenshotlist");
        screenshotpos = getIntent().getIntExtra("screenshotpos", 0);
        detailtitle = getIntent().getStringExtra("detailtitle");
        detailcount = getIntent().getIntExtra("detailcount", 0);
        detailserial = getIntent().getStringExtra("detailserial");
        gag = getIntent().getIntExtra("gag", 0);
        init();
        if (gag == 0)
        {
            url = (new StringBuilder("http://welaf.com/fun/stat.php?type=gallery&serial=")).append(detailserial).append("&page=1").toString();
            (new Thread() {

                final FunImagePagerActivity this$0;

                public void run()
                {
                    super.run();
                    Log.e("ggg", (new StringBuilder("url=")).append(url).toString());
                    publicTools.getUrl(url);
                }

            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
            }).start();
        }
        if (detailcount == 1)
        {
            tv_detail_jingdu.setText("1/1");
            return;
        } else
        {
            tv_detail_jingdu.setText((new StringBuilder("1/")).append(detailcount).toString());
            return;
        }
    }

    public void onDismissScreen(com.google.ads.Ad ad)
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
        Log.e("qwer", (new StringBuilder(String.valueOf(aderror.getErrorMessage()))).append("++++++").toString());
    }

    public void onFailedToReceiveAd(com.google.ads.Ad ad, com.google.ads.AdRequest.ErrorCode errorcode)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            finish();
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onLeaveApplication(com.google.ads.Ad ad)
    {
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(final int arg0)
    {
        iv_fun_likeshow.setImageResource(0x7f0200b9);
        dPicture = 1;
        String as[] = ((String)list.get(arg0)).split("/");
        picture_name = as[as.length - 1].split(".jpg")[0];
        lf_fun_download.setOnClickListener(new android.view.View.OnClickListener() {

            final FunImagePagerActivity this$0;
            private final int val$arg0;

            public void onClick(View view)
            {
                getImage((String)list.get(arg0));
            }

            
            {
                this$0 = FunImagePagerActivity.this;
                arg0 = i;
                super();
            }
        });
        lf_fun_like.setOnClickListener(new android.view.View.OnClickListener() {

            final FunImagePagerActivity this$0;
            private String url_like;

            public void onClick(View view)
            {
                iv_fun_likeshow.setImageResource(0x7f0200ba);
                url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(detailserial).toString();
                (new Thread() {

                    final _cls6 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                        publicTools.getUrl(url_like);
                    }

            
            {
                this$1 = _cls6.this;
                super();
            }
                }).start();
            }


            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        });
        lf_fun_share.setOnClickListener(new android.view.View.OnClickListener() {

            final FunImagePagerActivity this$0;
            private String url_share;

            public void onClick(View view)
            {
                url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(detailserial).toString();
                (new Thread() {

                    final _cls7 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                        publicTools.getUrl(url_share);
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                }).start();
                view = (new StringBuilder("Share: ")).append(detailtitle).append("\nhttp://welaf.com/fun/share.php?id=").append(detailserial).toString();
                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("text/plain");
                intent1.putExtra("android.intent.extra.TEXT", view);
                startActivity(Intent.createChooser(intent1, "AIO Downloaded"));
            }


            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        });
        screenshotpos = arg0;
        tv_detail_jingdu.setText((new StringBuilder(String.valueOf(arg0 + 1))).append("/").append(detailcount).toString());
        url_gallery = (new StringBuilder("http://welaf.com/fun/stat.php?type=gallery&serial=")).append(detailserial).append("&page=").append(arg0 + 1).toString();
        (new Thread() {

            final FunImagePagerActivity this$0;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=")).append(url_gallery).toString());
                publicTools.getUrl(url_gallery);
            }

            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        }).start();
        if (arg0 == 5 || arg0 == 10 || arg0 == 20 || arg0 == 40)
        {
            Intent intent = new Intent(getApplicationContext(), com/aio/downloader/activity/FunChapingActivity);
            intent.setFlags(0x10000000);
            startActivity(intent);
        }
        if ((arg0 + 1) % 10 == 0)
        {
            shake = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040017);
            ll_mygift.setAnimation(shake);
            if (ll_mygift_gallery.getVisibility() == 0)
            {
                ll_mygift_gallery.setAnimation(shake);
            }
        }
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onPresentScreen(com.google.ads.Ad ad)
    {
    }

    public void onReceiveAd(com.google.ads.Ad ad)
    {
        if (ad == interstitial)
        {
            interstitial.show();
        }
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        if (dPicture == 0)
        {
            String as[] = ((String)list.get(0)).split("/");
            picture_name = as[as.length - 1].split(".jpg")[0];
            lf_fun_download.setOnClickListener(new android.view.View.OnClickListener() {

                final FunImagePagerActivity this$0;

                public void onClick(View view)
                {
                    getImage((String)list.get(0));
                }

            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
            });
            lf_fun_like.setOnClickListener(new android.view.View.OnClickListener() {

                final FunImagePagerActivity this$0;
                private String url_like;

                public void onClick(View view)
                {
                    iv_fun_likeshow.setImageResource(0x7f0200ba);
                    url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(detailserial).toString();
                    (new Thread() {

                        final _cls10 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                            publicTools.getUrl(url_like);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    }).start();
                }


            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
            });
            lf_fun_share.setOnClickListener(new android.view.View.OnClickListener() {

                final FunImagePagerActivity this$0;
                private String url_share;

                public void onClick(View view)
                {
                    url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(detailserial).toString();
                    (new Thread() {

                        final _cls11 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                            publicTools.getUrl(url_share);
                        }

            
            {
                this$1 = _cls11.this;
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
                this$0 = FunImagePagerActivity.this;
                super();
            }
            });
        }
    }






















}
