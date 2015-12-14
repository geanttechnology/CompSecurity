// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.HomeWallFactory;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.FacebookShareInfo;
import com.wantu.model.res.InstagramShareInfo;
import com.wantu.model.res.QQShareInfo;
import com.wantu.model.res.ShareInfoToline;
import com.wantu.model.res.SinaweiboShareInfo;
import com.wantu.model.res.TencentweiboShareInfo;
import com.wantu.model.res.TumblrShareInfo;
import com.wantu.model.res.TwitterShareInfo;
import com.wantu.model.res.WXMomentsShareInfo;
import com.wantu.model.res.WechatShareInfo;
import com.wantu.view.CommonActionBarView1;
import com.wantu.view.NewTShareScrollView;
import en;
import eo;
import ev;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import kf;
import kp;
import kv;
import la;
import oc;
import od;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb;
import rt;
import ta;
import uc;
import uz;
import yg;
import yl;
import yo;
import yp;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity, BigPicAdViewItem, PIPCameraActivity, PhotoShareToInstagramActivity, 
//            FbNativeAdViewItem, SavePageBigPicAdadapter

public class NewPhotoShareActivity extends FullscreenActivity
    implements com.fotoable.ad.HomeWallFactory.HomeWallClickListener, com.fotoable.ad.HomeWallFactory.fotoHomeWalladListener, ta, yp
{

    private RelativeLayout A;
    private Handler B;
    private ListView C;
    private ArrayList D;
    private eo E;
    private String F;
    String a;
    CommonActionBarView1 b;
    public SinaweiboShareInfo c;
    public TencentweiboShareInfo d;
    public QQShareInfo e;
    public WechatShareInfo f;
    public WXMomentsShareInfo g;
    public FacebookShareInfo h;
    public InstagramShareInfo i;
    public TwitterShareInfo j;
    public TumblrShareInfo k;
    public ShareInfoToline l;
    SavePageBigPicAdadapter m;
    boolean n;
    private boolean o;
    private boolean p;
    private Resources q;
    private Bitmap r;
    private Uri s;
    private String t;
    private NewTShareScrollView u;
    private String v;
    private FrameLayout w;
    private TextView x;
    private RelativeLayout y;
    private RelativeLayout z;

    public NewPhotoShareActivity()
    {
        o = false;
        p = false;
        a = null;
        D = new ArrayList();
        E = new eo() {

            final NewPhotoShareActivity a;

            public void a(String s1)
            {
                if (!s1.startsWith("http://") && !s1.startsWith("https://") || s1 == null || s1.length() <= 0)
                {
                    return;
                } else
                {
                    Intent intent = new Intent(a, com/fotoable/adbuttonlib/TWebBrowActivity);
                    intent.putExtra("webUriString", s1);
                    a.startActivity(intent);
                    return;
                }
            }

            public void b(String s1)
            {
            }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
        };
        n = true;
    }

    static Bitmap a(NewPhotoShareActivity newphotoshareactivity, Bitmap bitmap)
    {
        newphotoshareactivity.r = bitmap;
        return bitmap;
    }

    static Uri a(NewPhotoShareActivity newphotoshareactivity, Uri uri)
    {
        newphotoshareactivity.s = uri;
        return uri;
    }

    static eo a(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.E;
    }

    static String a(NewPhotoShareActivity newphotoshareactivity, String s1)
    {
        newphotoshareactivity.t = s1;
        return s1;
    }

    private void a(Bitmap bitmap)
    {
        h();
        a = null;
        if (i != null && i.shareTag != null && i.shareTag.compareTo("") != 0)
        {
            a = i.shareTag;
        }
        if (bitmap != null)
        {
            oc.c(this, bitmap, "sync_instagram", null, a, new od() {

                final NewPhotoShareActivity a;

                public void a(boolean flag, boolean flag1)
                {
                    android.content.SharedPreferences.Editor editor;
                    NewPhotoShareActivity.b(a);
                    editor = a.getSharedPreferences("shareStyle", 0).edit();
                    editor.putString("shareName", "sync_instagram");
                    if (!flag || flag1) goto _L2; else goto _L1
_L1:
                    editor.putInt("ShareState", 1);
_L4:
                    editor.commit();
                    return;
_L2:
                    if (flag && flag1)
                    {
                        editor.putInt("ShareState", 2);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            });
        }
    }

    static String b(NewPhotoShareActivity newphotoshareactivity, String s1)
    {
        newphotoshareactivity.F = s1;
        return s1;
    }

    static void b(NewPhotoShareActivity newphotoshareactivity)
    {
        newphotoshareactivity.i();
    }

    static Uri c(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.s;
    }

    static String c(NewPhotoShareActivity newphotoshareactivity, String s1)
    {
        newphotoshareactivity.v = s1;
        return s1;
    }

    static TextView d(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.x;
    }

    private void d()
    {
        if (D == null)
        {
            D = new ArrayList();
        }
        rt rt1 = new rt();
        rt1.a = getResources().getString(0x7f0601ce);
        rt1.h = false;
        rt1.c = "adRes/ic_wantu.png";
        if (pb.a())
        {
            rt1.d = "adRes/fotorus_cn.jpg";
            rt1.g = "http://ad.apps.fm/DNgeHHf_tNl1iHJmdAPQNq5px440Px0vtrw1ww5B54wPg0HEs5wsRIZQnXzfFLa8efn0kAmeWlv4UXXWfqixuiawossYb4DtitWAGiatJuM";
        } else
        {
            rt1.d = "adRes/fotorus_en.jpg";
            rt1.g = "http://ad.apps.fm/QaZ8wWjMFGOXm04wdIAuw65px440Px0vtrw1ww5B54wPg0HEs5wsRIZQnXzfFLa8efn0kAmeWlv4UXXWfqixugCREdHUSdXjj7fxfL5JSg4";
        }
        rt1.b = getResources().getString(0x7f0600d1);
        rt1.f = "com.wantu.activity";
        if (!BigPicAdViewItem.isInstalled(getApplicationContext(), rt1.f))
        {
            D.add(rt1);
        }
        rt1 = new rt();
        rt1.a = getResources().getString(0x7f0601cb);
        rt1.h = false;
        rt1.c = "adRes/ic_instamag.png";
        if (pb.a())
        {
            rt1.d = "adRes/instamag_cn.jpg";
            rt1.g = "http://ad.apps.fm/m5wnf8dFCHCjl3b7KLZyaq5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ESc4doAmrRlvT9rGlu5Dfa5DazLNT_ouVYz_Ycg4KTso";
        } else
        {
            rt1.d = "adRes/instamag_en.jpg";
            rt1.g = "http://ad.apps.fm/cpKQuu9wpmphpnPqv_L6M65px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ESc4doAmrRlvT9rGlu5Dfa61Iy8T_zUeHBMJGiG_rN9w";
        }
        rt1.b = getResources().getString(0x7f0600d0);
        rt1.f = "com.instamag.activity";
        if (!BigPicAdViewItem.isInstalled(getApplicationContext(), rt1.f))
        {
            D.add(rt1);
        }
        rt1 = new rt();
        rt1.a = getResources().getString(0x7f0601c9);
        rt1.h = false;
        rt1.c = "adRes/ic_helpr.png";
        rt1.d = "adRes/helpr_cn.jpg";
        rt1.b = getResources().getString(0x7f0600ce);
        rt1.f = "com.fotoable.helpr";
        rt1.g = "http://ad.apps.fm/rssS2Y6hboXKQOgsc_ZwK65px440Px0vtrw1ww5B54wIWi0djV-KukgWU0nnfGEYefn0kAmeWlv4UXXWfqixukLUMOY-QcAeqxxaHVZb-7s";
        if (pb.a() && !BigPicAdViewItem.isInstalled(getApplicationContext(), rt1.f))
        {
            D.add(rt1);
        }
        rt1 = new rt();
        rt1.a = getResources().getString(0x7f0601ca);
        if (pb.a())
        {
            rt1.d = "adRes/instabeauty_cn.jpg";
            rt1.g = "http://ad.apps.fm/zteIGX4LM9RwooZyPZUB6q5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvZTP9kRyvncBdk8rPc8dNJBzBg2G3-2-IDvXQw2Il6Cc";
        } else
        {
            rt1.d = "adRes/instabeauty_en.jpg";
            rt1.g = "http://ad.apps.fm/Rq7v06IbKxnaeYQYE9QN3a5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvZTP9kRyvncBdk8rPc8dNJM9aHYEelYpovj_9kFURkCc";
        }
        rt1.h = false;
        rt1.c = "adRes/ic_instabeauty.png";
        rt1.b = getResources().getString(0x7f0600cf);
        rt1.f = "com.fotoable.fotobeauty";
        if (!BigPicAdViewItem.isInstalled(getApplicationContext(), rt1.f))
        {
            D.add(rt1);
        }
    }

    static RelativeLayout e(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.z;
    }

    private void e()
    {
        h();
        (new Thread(new Runnable() {

            final NewPhotoShareActivity a;

            public void run()
            {
                try
                {
                    Thread.sleep(300L);
                }
                catch (InterruptedException interruptedexception) { }
                a.runOnUiThread(new Runnable(this) {

                    final _cls18 a;

                    public void run()
                    {
                        Object obj;
                        NewPhotoShareActivity.b(a.a);
                        obj = a.a.getIntent();
                        if (a.a.getIntent() != null)
                        {
                            String s1 = a.a.getIntent().getStringExtra("share_tag");
                            if (s1 != null && s1.length() > 0)
                            {
                                NewPhotoShareActivity.a(a.a, s1);
                            }
                        }
                        if (((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
                        {
                            break MISSING_BLOCK_LABEL_345;
                        }
                        obj = ((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri");
                        Object obj1 = new File(new URI(((String) (obj)).replace(" ", "%20")));
                        uz.a().b(((File) (obj1)).getPath());
                        uz.a().a(false);
                        NewPhotoShareActivity.a(a.a, Uri.parse(((String) (obj))));
                        NewPhotoShareActivity.b(a.a, ((File) (obj1)).getPath());
                        NewPhotoShareActivity.c(a.a, uz.a().d());
                        NewPhotoShareActivity.a(a.a, android.provider.MediaStore.Images.Media.getBitmap(a.a.getContentResolver(), NewPhotoShareActivity.c(a.a)));
                        NewPhotoShareActivity.d(a.a).setText(0x7f060197);
                        obj1 = new AlphaAnimation(1.0F, 0.0F);
                        ((Animation) (obj1)).setInterpolator(new DecelerateInterpolator());
                        ((Animation) (obj1)).setDuration(2000L);
                        ((Animation) (obj1)).setFillAfter(true);
                        NewPhotoShareActivity.e(a.a).startAnimation(((Animation) (obj1)));
                        obj1 = a.a.getSharedPreferences("savephotoImageString", 0).edit();
                        ((android.content.SharedPreferences.Editor) (obj1)).putString("imageString", ((String) (obj)));
                        ((android.content.SharedPreferences.Editor) (obj1)).commit();
_L1:
                        return;
                        obj;
                        Crashlytics.logException(((Throwable) (obj)));
                        a.a.finish();
                        return;
                        obj;
                        ((FileNotFoundException) (obj)).printStackTrace();
                        Crashlytics.logException(((Throwable) (obj)));
                        return;
                        obj;
                        ((IOException) (obj)).printStackTrace();
                        Crashlytics.logException(((Throwable) (obj)));
                        return;
                        obj = ((Intent) (obj)).getStringExtra("imageUrlString");
                        NewPhotoShareActivity.a(a.a, yl.a().b(((String) (obj))));
                        NewPhotoShareActivity.c(a.a, yl.a().a(((String) (obj))));
                        if (NewPhotoShareActivity.f(a.a) != null)
                        {
                            NewPhotoShareActivity.g(a.a);
                            return;
                        }
                          goto _L1
                    }

            
            {
                a = _pcls18;
                super();
            }
                });
            }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
        })).start();
    }

    static Bitmap f(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.r;
    }

    private void f()
    {
        if (!o)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        uz.a().a(null);
        System.gc();
        finish();
        overridePendingTransition(0x10a0002, 0x10a0003);
_L1:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.e("PhotoShare", activitynotfoundexception.getMessage());
        Crashlytics.logException(activitynotfoundexception);
        return;
        if (p)
        {
            try
            {
                uz.a().a(null);
                yg.a().b();
                yl.a().c();
                System.gc();
                Intent intent = new Intent();
                intent.setClass(this, com/pipcamera/activity/PIPCameraActivity);
                intent.setFlags(0x4000000);
                startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception1)
            {
                Log.e("PhotoShare", activitynotfoundexception1.getMessage());
                Crashlytics.logException(activitynotfoundexception1);
                return;
            }
        }
          goto _L1
    }

    private void g()
    {
        boolean flag = false;
        Object obj = new ByteArrayOutputStream();
        r.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, ((java.io.OutputStream) (obj)));
        byte abyte0[] = ((ByteArrayOutputStream) (obj)).toByteArray();
        Object obj1 = uz.a();
        ((uz) (obj1)).b();
        ((uz) (obj1)).a("JPEG");
        ((uz) (obj1)).a(true);
        uz.a().a(abyte0);
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        long l1;
        if (flag)
        {
            abyte0 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            obj1 = (new StringBuilder()).append(abyte0).append("/FOTORUS").toString();
            File file = new File(((String) (obj1)));
            abyte0 = ((byte []) (obj1));
            if (!file.exists())
            {
                file.mkdirs();
                abyte0 = ((byte []) (obj1));
            }
        } else
        {
            String s1 = getDir("FOTORUS", 2).getAbsolutePath();
            File file1 = new File(s1);
            abyte0 = s1;
            if (!file1.exists())
            {
                file1.mkdirs();
                abyte0 = s1;
            }
        }
        l1 = (new Date()).getTime();
        obj1 = (new StringBuilder()).append("img").append(String.valueOf(l1)).toString();
        abyte0 = (new StringBuilder()).append(abyte0).append("/").append(((String) (obj1))).append(".jpg").toString();
        try
        {
            byte abyte1[] = uz.a().c();
            int i1 = abyte1.length;
            Object obj2 = new FileOutputStream(abyte0);
            ((FileOutputStream) (obj2)).write(abyte1, 0, i1);
            ((FileOutputStream) (obj2)).close();
            obj2 = new ContentValues();
            ((ContentValues) (obj2)).put("title", ((String) (obj1)));
            ((ContentValues) (obj2)).put("_display_name", (new StringBuilder()).append(((String) (obj1))).append(".jpg").toString());
            ((ContentValues) (obj2)).put("datetaken", Long.valueOf(l1));
            ((ContentValues) (obj2)).put("mime_type", "image/jpeg");
            ((ContentValues) (obj2)).put("_data", abyte0);
            ((ContentValues) (obj2)).put("_size", Integer.valueOf(abyte1.length));
            ((ContentValues) (obj2)).put("orientation", Integer.valueOf(0));
            s = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ((ContentValues) (obj2)));
            obj1 = getApplicationContext();
            android.media.MediaScannerConnection.OnScanCompletedListener onscancompletedlistener = new android.media.MediaScannerConnection.OnScanCompletedListener() {

                final NewPhotoShareActivity a;

                public void onScanCompleted(String s2, Uri uri)
                {
                    Log.d("PhotoShare", uri.toString());
                    NewPhotoShareActivity.a(a, uri);
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            };
            MediaScannerConnection.scanFile(((android.content.Context) (obj1)), new String[] {
                abyte0
            }, null, onscancompletedlistener);
            uz.a().b(abyte0);
            x.setText(0x7f060197);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            Toast.makeText(this, q.getString(0x7f060196), 1).show();
        }
        Log.i("test", "usersavePhoto");
        FlurryAgent.logEvent("usersavePhoto");
    }

    static void g(NewPhotoShareActivity newphotoshareactivity)
    {
        newphotoshareactivity.g();
    }

    private void h()
    {
        showDialog(1);
    }

    private void i()
    {
        removeDialog(1);
    }

    private void j()
    {
        Intent intent = new Intent(this, com/pipcamera/activity/PhotoShareToInstagramActivity);
        intent.putExtra("KSHARETOINSTAGRAM", true);
        intent.putExtra("kimageuri", getIntent().getStringExtra("PhotoShareActivity_ToShareImageUri"));
        startActivity(intent);
    }

    protected void a()
    {
        try
        {
            FotoAdFactory.createAdBanner(this, y);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    public void a(String s1, Object obj)
    {
        FlurryAgent.logEvent(s1);
        if (s1.compareTo("sync_facebook") == 0)
        {
            h();
            a = null;
            if (h != null && h.shareTag != null && h.shareTag.compareTo("") != 0)
            {
                a = h.shareTag;
            }
            oc.a(this, r, s1, obj, a, new od() {

                final NewPhotoShareActivity a;

                public void a(boolean flag, boolean flag1)
                {
                    android.content.SharedPreferences.Editor editor;
                    NewPhotoShareActivity.b(a);
                    editor = a.getSharedPreferences("shareStyle", 0).edit();
                    editor.putString("shareName", "sync_facebook");
                    if (!flag || flag1) goto _L2; else goto _L1
_L1:
                    editor.putInt("ShareState", 1);
_L4:
                    editor.commit();
                    return;
_L2:
                    if (flag && flag1)
                    {
                        editor.putInt("ShareState", 2);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            });
        } else
        {
            if (s1.compareTo("sync_twitter") == 0)
            {
                h();
                a = null;
                if (j != null && j.shareTag != null && j.shareTag.compareTo("") != 0)
                {
                    a = j.shareTag;
                }
                oc.b(this, r, s1, obj, a, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_twitter");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_instagram") == 0)
            {
                if (!kf.a(this, "com.instagram.android"))
                {
                    Toast.makeText(this, getString(0x7f0601ff), 1).show();
                    return;
                }
                la.b(this, "InstagramNew", false);
                u.setInstagramNewViewVisibility(false);
                s1 = ev.a(F, this);
                if (((Point) (s1)).x == ((Point) (s1)).y)
                {
                    a(r);
                    return;
                } else
                {
                    j();
                    return;
                }
            }
            if (s1.compareTo("sync_tumblr") == 0)
            {
                h();
                a = null;
                if (k != null && k.shareTag != null && k.shareTag.compareTo("") != 0)
                {
                    a = k.shareTag;
                }
                oc.d(this, r, s1, obj, a, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_tumblr");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_sina") == 0)
            {
                h();
                a = null;
                if (c != null && c.shareTag != null && c.shareTag.compareTo("") != 0)
                {
                    a = c.shareTag;
                }
                oc.e(this, r, s1, obj, a, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_sina");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_qqzone") == 0)
            {
                h();
                oc.b(this, r, s1, obj, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_qqzone");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_qqweibo") == 0)
            {
                h();
                a = null;
                if (d != null && d.shareTag != null && d.shareTag.compareTo("") != 0)
                {
                    a = d.shareTag;
                }
                oc.f(this, r, s1, obj, a, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_qqweibo");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_qq") == 0)
            {
                h();
                a = null;
                if (e != null && e.shareTag != null && e.shareTag.compareTo("") != 0)
                {
                    a = e.shareTag;
                }
                oc.c(this, r, s1, obj, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_qq");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_moment") == 0)
            {
                h();
                a = null;
                if (g != null && g.shareTag != null && g.shareTag.compareTo("") != 0)
                {
                    a = g.shareTag;
                }
                oc.e(this, r, s1, obj, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_moment");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_wechat") == 0)
            {
                h();
                a = null;
                if (f != null && f.shareTag != null && f.shareTag.compareTo("") != 0)
                {
                    a = f.shareTag;
                }
                oc.d(this, r, s1, obj, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_wechat");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_line") == 0)
            {
                h();
                oc.a(this, r, s1, obj, new od() {

                    final NewPhotoShareActivity a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        NewPhotoShareActivity.b(a);
                        editor = a.getSharedPreferences("shareStyle", 0).edit();
                        editor.putString("shareName", "sync_line");
                        if (!flag || flag1) goto _L2; else goto _L1
_L1:
                        editor.putInt("ShareState", 1);
_L4:
                        editor.commit();
                        return;
_L2:
                        if (flag && flag1)
                        {
                            editor.putInt("ShareState", 2);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_more") == 0)
            {
                s1 = new Intent();
                s1.setAction("android.intent.action.SEND");
                s1.putExtra("android.intent.extra.SUBJECT", 0x7f060199);
                s1.putExtra("android.intent.extra.STREAM", s);
                s1.setType("image/jpeg");
                startActivity(Intent.createChooser(s1, getResources().getText(0x7f060199)));
                FlurryAgent.logEvent("PhotoSharebyOther");
                return;
            }
        }
    }

    public void b()
    {
        nextBtnClicked(null);
    }

    public void backBtnClicked(View view)
    {
        o = true;
        f();
    }

    public void c()
    {
        backBtnClicked(null);
    }

    public void nextBtnClicked(View view)
    {
        p = true;
        f();
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (NativeAdWrapper.nativeAdHandleResult(i1, j1, intent, this))
        {
            super.onActivityResult(i1, j1, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getSharedPreferences("shareStyle", 0).edit();
        bundle.putString("shareName", "isempty");
        bundle.putInt("ShareState", 0);
        bundle.commit();
        Object obj = getSharedPreferences("saveAndShareInfo", 0);
        bundle = ((SharedPreferences) (obj)).getString("gsonString", null);
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("gsonString", null);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        if (bundle == null || bundle.compareTo("") == 0)
        {
            break MISSING_BLOCK_LABEL_1658;
        }
        Object obj1;
        bundle = new JSONObject(bundle);
        obj1 = bundle.names();
        JSONArray jsonarray = bundle.toJSONArray(((JSONArray) (obj1)));
        int i1 = 0;
_L2:
        if (i1 >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        kv.a(null, 3, (new StringBuilder()).append("Key => ").append(((JSONArray) (obj1)).getString(i1)).append(" Value => ").append(jsonarray.getString(i1)).toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!bundle.has("tencentweiboShareInfo"))
        {
            break MISSING_BLOCK_LABEL_377;
        }
        obj1 = kv.c(bundle, "tencentweiboShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_377;
        }
        TencentweiboShareInfo tencentweiboshareinfo = new TencentweiboShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            tencentweiboshareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("backUrl"))
        {
            tencentweiboshareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            tencentweiboshareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            tencentweiboshareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            tencentweiboshareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expiredTime"))
        {
            tencentweiboshareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            tencentweiboshareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        d = tencentweiboshareinfo;
        if (!bundle.has("sinaweiboShareInfo"))
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj1 = kv.c(bundle, "sinaweiboShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        SinaweiboShareInfo sinaweiboshareinfo = new SinaweiboShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            sinaweiboshareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("backUrl"))
        {
            sinaweiboshareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            sinaweiboshareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            sinaweiboshareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            sinaweiboshareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expiredTime"))
        {
            sinaweiboshareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            sinaweiboshareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        c = sinaweiboshareinfo;
        if (!bundle.has("wechatShareInfo"))
        {
            break MISSING_BLOCK_LABEL_743;
        }
        obj1 = kv.c(bundle, "wechatShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_743;
        }
        WechatShareInfo wechatshareinfo = new WechatShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            wechatshareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("backUrl"))
        {
            wechatshareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            wechatshareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            wechatshareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            wechatshareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expiredTime"))
        {
            wechatshareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            wechatshareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        f = wechatshareinfo;
        if (!bundle.has("wxMomentsShareInfo"))
        {
            break MISSING_BLOCK_LABEL_926;
        }
        obj1 = kv.c(bundle, "wxMomentsShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_926;
        }
        WXMomentsShareInfo wxmomentsshareinfo = new WXMomentsShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            wxmomentsshareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("backUrl"))
        {
            wxmomentsshareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            wxmomentsshareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            wxmomentsshareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            wxmomentsshareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expiredTime"))
        {
            wxmomentsshareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            wxmomentsshareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        g = wxmomentsshareinfo;
        if (!bundle.has("facebookShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1109;
        }
        obj1 = kv.c(bundle, "facebookShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1109;
        }
        FacebookShareInfo facebookshareinfo = new FacebookShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            facebookshareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("backUrl"))
        {
            facebookshareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            facebookshareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            facebookshareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            facebookshareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expiredTime"))
        {
            facebookshareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            facebookshareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        h = facebookshareinfo;
        if (!bundle.has("twitterShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1292;
        }
        obj1 = kv.c(bundle, "twitterShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1292;
        }
        TwitterShareInfo twittershareinfo = new TwitterShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            twittershareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("backUrl"))
        {
            twittershareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            twittershareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            twittershareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            twittershareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expriedTime"))
        {
            twittershareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            twittershareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        j = twittershareinfo;
        if (!bundle.has("qqShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1475;
        }
        obj1 = kv.c(bundle, "qqShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1475;
        }
        QQShareInfo qqshareinfo = new QQShareInfo();
        if (((JSONObject) (obj1)).has("shareTag"))
        {
            qqshareinfo.shareTag = kv.a(((JSONObject) (obj1)), "shareTag");
        }
        if (((JSONObject) (obj1)).has("bcakUrl"))
        {
            qqshareinfo.backUrl = kv.a(((JSONObject) (obj1)), "backUrl");
        }
        if (((JSONObject) (obj1)).has("alertText"))
        {
            qqshareinfo.alertText = kv.a(((JSONObject) (obj1)), "alertText");
        }
        if (((JSONObject) (obj1)).has("okText"))
        {
            qqshareinfo.okText = kv.a(((JSONObject) (obj1)), "okText");
        }
        if (((JSONObject) (obj1)).has("cancelText"))
        {
            qqshareinfo.cancelText = kv.a(((JSONObject) (obj1)), "cancelText");
        }
        if (((JSONObject) (obj1)).has("expiredTime"))
        {
            qqshareinfo.expiredTime = kv.e(((JSONObject) (obj1)), "expiredTime");
        }
        if (((JSONObject) (obj1)).has("backUrlID"))
        {
            qqshareinfo.backUrlID = kv.e(((JSONObject) (obj1)), "backUrlID");
        }
        e = qqshareinfo;
        if (!bundle.has("instagramShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1658;
        }
        bundle = kv.c(bundle, "instagramShareInfo");
        if (bundle != null)
        {
            try
            {
                InstagramShareInfo instagramshareinfo = new InstagramShareInfo();
                if (bundle.has("shareTag"))
                {
                    instagramshareinfo.shareTag = kv.a(bundle, "shareTag");
                }
                if (bundle.has("backUrl"))
                {
                    instagramshareinfo.backUrl = kv.a(bundle, "backUrl");
                }
                if (bundle.has("alertText"))
                {
                    instagramshareinfo.alertText = kv.a(bundle, "alertText");
                }
                if (bundle.has("okText"))
                {
                    instagramshareinfo.okText = kv.a(bundle, "okText");
                }
                if (bundle.has("cancelText"))
                {
                    instagramshareinfo.cancelText = kv.a(bundle, "cancelText");
                }
                if (bundle.has("expiredTime"))
                {
                    instagramshareinfo.expiredTime = kv.e(bundle, "expiredTime");
                }
                if (bundle.has("backUrlID"))
                {
                    instagramshareinfo.backUrlID = kv.e(bundle, "backUrlID");
                }
                i = instagramshareinfo;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                try
                {
                    bundle.printStackTrace();
                    Crashlytics.logException(bundle);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                    Crashlytics.logException(bundle);
                }
            }
        }
        setContentView(0x7f030060);
        q = getResources();
        B = new Handler();
        a = getIntent().getStringExtra("share_tag");
        b = (CommonActionBarView1)findViewById(0x7f0c0081);
        b.setOnAcceptListener(this);
        b.setActionBarTitle(q.getString(0x7f060199));
        b.setAcceptBarResId(0x7f0201f5);
        w = new FbNativeAdViewItem(this);
        ((FbNativeAdViewItem)w).setData();
        w.setOnTouchListener(new android.view.View.OnTouchListener() {

            final NewPhotoShareActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
        });
        x = (TextView)findViewById(0x7f0c01af);
        z = (RelativeLayout)findViewById(0x7f0c01ae);
        x.setText(0x7f060197);
        A = (RelativeLayout)findViewById(0x7f0c01ab);
        y = (RelativeLayout)findViewById(0x7f0c0055);
        if (PIPCameraApplication.b().a(this))
        {
            if (y != null)
            {
                y.setVisibility(4);
            }
            ((android.widget.RelativeLayout.LayoutParams)A.getLayoutParams()).setMargins(0, pb.a(this, 44F), 0, 0);
            A.requestLayout();
            A.setVisibility(4);
        } else
        {
            if (!yo.a(this))
            {
                a();
            }
            if (!PIPCameraApplication.d() && getResources().getDisplayMetrics().heightPixels > 480)
            {
                HomeWallFactory.createHomeWallAdView(this, w, 2, uc.a(), null, this);
            }
        }
        e();
        u = (NewTShareScrollView)findViewById(0x7f0c01ad);
        u.setCallback(this);
        u.setVerticalScrollBarEnabled(false);
        if (la.a(this, "InstagramNew", true) && kf.a(this, "com.instagram.android"))
        {
            u.setInstagramNewViewVisibility(true);
        } else
        {
            u.setInstagramNewViewVisibility(false);
        }
        C = (ListView)findViewById(0x7f0c01b0);
        if (HomeWallFactory.IsSavewallLoaded || HomeWallFactory.hasNativeAd)
        {
            C.addHeaderView(w);
        }
        d();
        m = new SavePageBigPicAdadapter(this, D);
        C.setAdapter(m);
        FlurryAgent.logEvent("PIPCameraSavePhoto");
        return;
    }

    protected Dialog onCreateDialog(int i1)
    {
        ProgressDialog progressdialog;
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this);
            break;
        }
        progressdialog.setMessage(getResources().getString(0x7f0601d0));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        return progressdialog;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onHomeWallClicked(String s1)
    {
        Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
        intent.putExtra("webUriString", s1);
        startActivity(intent);
    }

    public void onHomeWallLoadfailed()
    {
        runOnUiThread(new Runnable() {

            final NewPhotoShareActivity a;

            public void run()
            {
                Log.i("test", "home wall failed");
            }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
        });
    }

    public void onHomeWallReceived(kp kp)
    {
        y.setVisibility(4);
        ((android.widget.RelativeLayout.LayoutParams)A.getLayoutParams()).setMargins(0, pb.a(this, 44F), 0, 0);
        A.invalidate();
        A.setVisibility(4);
    }

    protected void onPause()
    {
        super.onPause();
        if (HomeWallFactory.IsHomawallLoaded)
        {
            HomeWallFactory.stopCirclePlay();
        }
        en.b(this);
    }

    public void onResume()
    {
        super.onResume();
        if (n)
        {
            n = false;
            (new Handler()).postDelayed(new Runnable() {

                final NewPhotoShareActivity a;

                public void run()
                {
                    en.a(a, "save", NewPhotoShareActivity.a(a));
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            }, 500L);
        }
        Object obj1 = getSharedPreferences("shareStyle", 0);
        Object obj = ((SharedPreferences) (obj1)).getString("shareName", "isempty");
        int i1 = ((SharedPreferences) (obj1)).getInt("ShareState", 0);
        obj1 = ((SharedPreferences) (obj1)).edit();
        ((android.content.SharedPreferences.Editor) (obj1)).putInt("ShareState", 0);
        ((android.content.SharedPreferences.Editor) (obj1)).putString("shareName", "isempty");
        ((android.content.SharedPreferences.Editor) (obj1)).commit();
        if (((String) (obj)).compareTo("sync_facebook") == 0)
        {
            l = h;
        } else
        if (((String) (obj)).compareTo("sync_twitter") == 0)
        {
            l = j;
        } else
        if (((String) (obj)).compareTo("sync_instagram") == 0)
        {
            l = i;
        } else
        if (((String) (obj)).compareTo("sync_tumblr") == 0)
        {
            l = k;
        } else
        if (((String) (obj)).compareTo("sync_sina") == 0)
        {
            l = c;
        } else
        if (((String) (obj)).compareTo("sync_moment") == 0)
        {
            l = g;
        } else
        if (((String) (obj)).compareTo("sync_qqweibo") == 0)
        {
            l = d;
        } else
        if (((String) (obj)).compareTo("sync_qq") == 0)
        {
            l = e;
        } else
        if (((String) (obj)).compareTo("sync_wechat") == 0)
        {
            l = f;
        } else
        if (((String) (obj)).compareTo("sync_qqzone") == 0)
        {
            l = null;
        } else
        if (((String) (obj)).compareTo("sync_line") == 0)
        {
            l = null;
        }
        if (i1 == 1)
        {
            obj = new android.app.AlertDialog.Builder(this);
            ((android.app.AlertDialog.Builder) (obj)).setMessage("\u7533\u8BF7\u5931\u8D25");
            ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

                final NewPhotoShareActivity a;

                public void onClick(DialogInterface dialoginterface, int j1)
                {
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            });
            ((android.app.AlertDialog.Builder) (obj)).show();
        } else
        if (i1 == 2 && l != null)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("\u5206\u4EAB\u5B8C\u6210");
            if (l.alertText != null && l.alertText.compareTo("") != 0)
            {
                builder.setMessage(l.alertText);
            }
            builder.setPositiveButton(l.okText, new android.content.DialogInterface.OnClickListener() {

                final NewPhotoShareActivity a;

                public void onClick(DialogInterface dialoginterface, int j1)
                {
                    if (a.l.backUrl != null && a.l.backUrl.compareTo("") != 0)
                    {
                        dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(a.l.backUrl));
                        a.startActivity(dialoginterface);
                    }
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            });
            builder.setNegativeButton(l.cancelText, new android.content.DialogInterface.OnClickListener() {

                final NewPhotoShareActivity a;

                public void onClick(DialogInterface dialoginterface, int j1)
                {
                }

            
            {
                a = NewPhotoShareActivity.this;
                super();
            }
            });
            builder.show();
        }
        if (HomeWallFactory.IsHomawallLoaded)
        {
            y.setVisibility(4);
            ((android.widget.RelativeLayout.LayoutParams)A.getLayoutParams()).setMargins(0, pb.a(this, 44F), 0, 0);
            A.requestLayout();
            A.setVisibility(4);
            HomeWallFactory.startCirclePlay();
        }
    }
}
