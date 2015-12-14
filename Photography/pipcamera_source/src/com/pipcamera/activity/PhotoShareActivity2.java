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
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.HomeWallFactory;
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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import kp;
import kv;
import oc;
import od;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb;
import ta;
import uc;
import uz;
import yg;
import yl;
import yo;
import yp;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity, PIPCameraActivity

public class PhotoShareActivity2 extends FullscreenActivity
    implements com.fotoable.ad.HomeWallFactory.HomeWallClickListener, com.fotoable.ad.HomeWallFactory.fotoHomeWalladListener, ta, yp
{

    NewTShareScrollView a;
    String b;
    CommonActionBarView1 c;
    public SinaweiboShareInfo d;
    public TencentweiboShareInfo e;
    public QQShareInfo f;
    public WechatShareInfo g;
    public WXMomentsShareInfo h;
    public FacebookShareInfo i;
    public InstagramShareInfo j;
    public TwitterShareInfo k;
    public TumblrShareInfo l;
    public ShareInfoToline m;
    private boolean n;
    private boolean o;
    private Resources p;
    private Bitmap q;
    private Uri r;
    private String s;
    private String t;
    private FrameLayout u;
    private TextView v;
    private RelativeLayout w;
    private RelativeLayout x;
    private RelativeLayout y;
    private Handler z;

    public PhotoShareActivity2()
    {
        n = false;
        o = false;
        b = null;
    }

    static Bitmap a(PhotoShareActivity2 photoshareactivity2, Bitmap bitmap)
    {
        photoshareactivity2.q = bitmap;
        return bitmap;
    }

    static Uri a(PhotoShareActivity2 photoshareactivity2, Uri uri)
    {
        photoshareactivity2.r = uri;
        return uri;
    }

    static RelativeLayout a(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.y;
    }

    static String a(PhotoShareActivity2 photoshareactivity2, String s1)
    {
        photoshareactivity2.s = s1;
        return s1;
    }

    static FrameLayout b(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.u;
    }

    static String b(PhotoShareActivity2 photoshareactivity2, String s1)
    {
        photoshareactivity2.t = s1;
        return s1;
    }

    static RelativeLayout c(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.x;
    }

    static RelativeLayout d(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.w;
    }

    private void d()
    {
        g();
        (new Handler()).postDelayed(new Runnable() {

            final PhotoShareActivity2 a;

            public void run()
            {
                Object obj;
                PhotoShareActivity2.f(a);
                obj = a.getIntent();
                if (a.getIntent() != null)
                {
                    String s1 = a.getIntent().getStringExtra("share_tag");
                    if (s1 != null && s1.length() > 0)
                    {
                        PhotoShareActivity2.a(a, s1);
                    }
                }
                if (((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
                {
                    break MISSING_BLOCK_LABEL_244;
                }
                obj = ((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri");
                Object obj1 = new File(new URI(((String) (obj)).replace(" ", "%20")));
                uz.a().b(((File) (obj1)).getPath());
                uz.a().a(false);
                PhotoShareActivity2.a(a, Uri.parse(((String) (obj))));
                PhotoShareActivity2.b(a, uz.a().d());
                PhotoShareActivity2.a(a, android.provider.MediaStore.Images.Media.getBitmap(a.getContentResolver(), PhotoShareActivity2.g(a)));
                PhotoShareActivity2.h(a).setText(0x7f060197);
                obj1 = a.getSharedPreferences("savephotoImageString", 0).edit();
                ((android.content.SharedPreferences.Editor) (obj1)).putString("imageString", ((String) (obj)));
                ((android.content.SharedPreferences.Editor) (obj1)).commit();
_L1:
                return;
                obj;
                Crashlytics.logException(((Throwable) (obj)));
                a.finish();
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
                PhotoShareActivity2.a(a, yl.a().b(((String) (obj))));
                PhotoShareActivity2.b(a, yl.a().a(((String) (obj))));
                if (PhotoShareActivity2.i(a) != null)
                {
                    PhotoShareActivity2.j(a);
                    return;
                }
                  goto _L1
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        }, 300L);
    }

    static Handler e(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.z;
    }

    private void e()
    {
        if (!n)
        {
            break MISSING_BLOCK_LABEL_46;
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
        if (o)
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

    private void f()
    {
        boolean flag = false;
        Object obj = new ByteArrayOutputStream();
        q.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, ((java.io.OutputStream) (obj)));
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
            r = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ((ContentValues) (obj2)));
            obj1 = getApplicationContext();
            android.media.MediaScannerConnection.OnScanCompletedListener onscancompletedlistener = new android.media.MediaScannerConnection.OnScanCompletedListener() {

                final PhotoShareActivity2 a;

                public void onScanCompleted(String s2, Uri uri)
                {
                    Log.d("PhotoShare", uri.toString());
                    PhotoShareActivity2.a(a, uri);
                }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
            };
            MediaScannerConnection.scanFile(((android.content.Context) (obj1)), new String[] {
                abyte0
            }, null, onscancompletedlistener);
            uz.a().b(abyte0);
            v.setText(0x7f060197);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            Toast.makeText(this, p.getString(0x7f060196), 1).show();
        }
        Log.i("test", "usersavePhoto");
        FlurryAgent.logEvent("usersavePhoto");
    }

    static void f(PhotoShareActivity2 photoshareactivity2)
    {
        photoshareactivity2.h();
    }

    static Uri g(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.r;
    }

    private void g()
    {
        showDialog(1);
    }

    static TextView h(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.v;
    }

    private void h()
    {
        removeDialog(1);
    }

    static Bitmap i(PhotoShareActivity2 photoshareactivity2)
    {
        return photoshareactivity2.q;
    }

    static void j(PhotoShareActivity2 photoshareactivity2)
    {
        photoshareactivity2.f();
    }

    protected void a()
    {
        try
        {
            FotoAdFactory.createAdBanner(this, w);
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
        if (s1.compareTo("sync_facebook") == 0)
        {
            g();
            b = null;
            if (i != null && i.shareTag != null && i.shareTag.compareTo("") != 0)
            {
                b = i.shareTag;
            }
            oc.a(this, q, s1, obj, b, new od() {

                final PhotoShareActivity2 a;

                public void a(boolean flag, boolean flag1)
                {
                    android.content.SharedPreferences.Editor editor;
                    PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
            });
        } else
        {
            if (s1.compareTo("sync_twitter") == 0)
            {
                g();
                b = null;
                if (k != null && k.shareTag != null && k.shareTag.compareTo("") != 0)
                {
                    b = k.shareTag;
                }
                oc.b(this, q, s1, obj, b, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_instagram") == 0)
            {
                g();
                b = null;
                if (j != null && j.shareTag != null && j.shareTag.compareTo("") != 0)
                {
                    b = j.shareTag;
                }
                oc.c(this, q, s1, obj, b, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_tumblr") == 0)
            {
                g();
                b = null;
                if (l != null && l.shareTag != null && l.shareTag.compareTo("") != 0)
                {
                    b = l.shareTag;
                }
                oc.d(this, q, s1, obj, b, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_sina") == 0)
            {
                g();
                b = null;
                if (d != null && d.shareTag != null && d.shareTag.compareTo("") != 0)
                {
                    b = d.shareTag;
                }
                oc.e(this, q, s1, obj, b, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_qqzone") == 0)
            {
                g();
                oc.b(this, q, s1, obj, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_qqweibo") == 0)
            {
                g();
                b = null;
                if (e != null && e.shareTag != null && e.shareTag.compareTo("") != 0)
                {
                    b = e.shareTag;
                }
                oc.f(this, q, s1, obj, b, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_qq") == 0)
            {
                g();
                b = null;
                if (f != null && f.shareTag != null && f.shareTag.compareTo("") != 0)
                {
                    b = f.shareTag;
                }
                oc.c(this, q, s1, obj, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_moment") == 0)
            {
                g();
                b = null;
                if (h != null && h.shareTag != null && h.shareTag.compareTo("") != 0)
                {
                    b = h.shareTag;
                }
                oc.e(this, q, s1, obj, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_wechat") == 0)
            {
                g();
                b = null;
                if (g != null && g.shareTag != null && g.shareTag.compareTo("") != 0)
                {
                    b = g.shareTag;
                }
                oc.d(this, q, s1, obj, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
                super();
            }
                });
                return;
            }
            if (s1.compareTo("sync_line") == 0)
            {
                g();
                oc.a(this, q, s1, obj, new od() {

                    final PhotoShareActivity2 a;

                    public void a(boolean flag, boolean flag1)
                    {
                        android.content.SharedPreferences.Editor editor;
                        PhotoShareActivity2.f(a);
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
                a = PhotoShareActivity2.this;
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
                s1.putExtra("android.intent.extra.STREAM", r);
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
        n = true;
        e();
    }

    public void c()
    {
        backBtnClicked(null);
    }

    public void moreShareClicked(View view)
    {
        view = new Intent();
        view.setAction("android.intent.action.SEND");
        view.putExtra("android.intent.extra.SUBJECT", 0x7f060199);
        view.putExtra("android.intent.extra.STREAM", r);
        view.setType("image/jpeg");
        startActivity(Intent.createChooser(view, getResources().getText(0x7f060199)));
        FlurryAgent.logEvent("PhotoSharebyOther");
    }

    public void nextBtnClicked(View view)
    {
        o = true;
        e();
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
            break MISSING_BLOCK_LABEL_1659;
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
            break MISSING_BLOCK_LABEL_378;
        }
        obj1 = kv.c(bundle, "tencentweiboShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_378;
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
        e = tencentweiboshareinfo;
        if (!bundle.has("sinaweiboShareInfo"))
        {
            break MISSING_BLOCK_LABEL_561;
        }
        obj1 = kv.c(bundle, "sinaweiboShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_561;
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
        d = sinaweiboshareinfo;
        if (!bundle.has("wechatShareInfo"))
        {
            break MISSING_BLOCK_LABEL_744;
        }
        obj1 = kv.c(bundle, "wechatShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_744;
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
        g = wechatshareinfo;
        if (!bundle.has("wxMomentsShareInfo"))
        {
            break MISSING_BLOCK_LABEL_927;
        }
        obj1 = kv.c(bundle, "wxMomentsShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_927;
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
        h = wxmomentsshareinfo;
        if (!bundle.has("facebookShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1110;
        }
        obj1 = kv.c(bundle, "facebookShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1110;
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
        i = facebookshareinfo;
        if (!bundle.has("twitterShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1293;
        }
        obj1 = kv.c(bundle, "twitterShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1293;
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
        k = twittershareinfo;
        if (!bundle.has("qqShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1476;
        }
        obj1 = kv.c(bundle, "qqShareInfo");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1476;
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
        f = qqshareinfo;
        if (!bundle.has("instagramShareInfo"))
        {
            break MISSING_BLOCK_LABEL_1659;
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
                j = instagramshareinfo;
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
        setContentView(0x7f03006a);
        p = getResources();
        z = new Handler();
        b = getIntent().getStringExtra("share_tag");
        c = (CommonActionBarView1)findViewById(0x7f0c0081);
        c.setOnAcceptListener(this);
        c.setActionBarTitle(p.getString(0x7f060199));
        c.setAcceptBarResId(0x7f0201f5);
        u = (FrameLayout)findViewById(0x7f0c005a);
        u.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PhotoShareActivity2 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        });
        v = (TextView)findViewById(0x7f0c01af);
        x = (RelativeLayout)findViewById(0x7f0c01ae);
        y = (RelativeLayout)findViewById(0x7f0c01e7);
        y.setOnClickListener(new android.view.View.OnClickListener() {

            final PhotoShareActivity2 a;

            public void onClick(View view)
            {
                view = (android.widget.RelativeLayout.LayoutParams)PhotoShareActivity2.a(a).getLayoutParams();
                view.setMargins(0, 0, 0, 0);
                view.height = 0;
                PhotoShareActivity2.a(a).invalidate();
                PhotoShareActivity2.a(a).setVisibility(4);
                view = AnimationUtils.loadAnimation(a, 0x7f04001b);
                PhotoShareActivity2.b(a).startAnimation(view);
                PhotoShareActivity2.b(a).setVisibility(4);
                PhotoShareActivity2.e(a).postDelayed(new Runnable(this) {

                    final _cls12 a;

                    public void run()
                    {
                        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)PhotoShareActivity2.c(a.a).getLayoutParams();
                        if (PIPCameraApplication.b().a(a.a))
                        {
                            layoutparams.setMargins(0, pb.a(a.a, 50F), 0, 0);
                        } else
                        {
                            layoutparams.setMargins(0, pb.a(a.a, 100F), 0, 0);
                        }
                        PhotoShareActivity2.c(a.a).requestLayout();
                        PhotoShareActivity2.d(a.a).setVisibility(0);
                    }

            
            {
                a = _pcls12;
                super();
            }
                }, 250L);
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        });
        w = (RelativeLayout)findViewById(0x7f0c0055);
        if (!PIPCameraApplication.b().a(this)) goto _L4; else goto _L3
_L3:
        if (w != null)
        {
            w.setVisibility(4);
        }
        ((android.widget.RelativeLayout.LayoutParams)x.getLayoutParams()).setMargins(0, pb.a(this, 50F), 0, 0);
        x.requestLayout();
_L6:
        d();
        a = (NewTShareScrollView)findViewById(0x7f0c01ad);
        a.setCallback(this);
        a.setVerticalScrollBarEnabled(false);
        Log.i("test", "wantuSavePhoto");
        FlurryAgent.logEvent("WantuSavePhoto");
        return;
_L4:
        if (!yo.a(this))
        {
            a();
        }
        PIPCameraApplication.b();
        if (!PIPCameraApplication.d() && getResources().getDisplayMetrics().heightPixels > 480)
        {
            HomeWallFactory.createHomeWallAdView(this, u, 2, uc.a(), this, this);
        }
        if (true) goto _L6; else goto _L5
_L5:
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

            final PhotoShareActivity2 a;

            public void run()
            {
                Log.i("test", "home wall failed");
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        });
    }

    public void onHomeWallReceived(kp kp)
    {
        w.setVisibility(4);
        ((android.widget.RelativeLayout.LayoutParams)x.getLayoutParams()).setMargins(0, pb.a(this, 50F), 0, 0);
        x.invalidate();
    }

    public void onResume()
    {
        Object obj;
        int i1;
        super.onResume();
        Object obj1 = getSharedPreferences("shareStyle", 0);
        obj = ((SharedPreferences) (obj1)).getString("shareName", "isempty");
        i1 = ((SharedPreferences) (obj1)).getInt("ShareState", 0);
        obj1 = ((SharedPreferences) (obj1)).edit();
        ((android.content.SharedPreferences.Editor) (obj1)).putInt("ShareState", 0);
        ((android.content.SharedPreferences.Editor) (obj1)).putString("shareName", "isempty");
        ((android.content.SharedPreferences.Editor) (obj1)).commit();
        if (((String) (obj)).compareTo("sync_facebook") != 0) goto _L2; else goto _L1
_L1:
        m = i;
_L8:
        if (i1 != 1) goto _L4; else goto _L3
_L3:
        obj = new android.app.AlertDialog.Builder(this);
        ((android.app.AlertDialog.Builder) (obj)).setMessage("\u7533\u8BF7\u5931\u8D25");
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(0x7f06002f), new android.content.DialogInterface.OnClickListener() {

            final PhotoShareActivity2 a;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj)).show();
_L6:
        return;
_L2:
        if (((String) (obj)).compareTo("sync_twitter") == 0)
        {
            m = k;
        } else
        if (((String) (obj)).compareTo("sync_instagram") == 0)
        {
            m = j;
        } else
        if (((String) (obj)).compareTo("sync_tumblr") == 0)
        {
            m = l;
        } else
        if (((String) (obj)).compareTo("sync_sina") == 0)
        {
            m = d;
        } else
        if (((String) (obj)).compareTo("sync_moment") == 0)
        {
            m = h;
        } else
        if (((String) (obj)).compareTo("sync_qqweibo") == 0)
        {
            m = e;
        } else
        if (((String) (obj)).compareTo("sync_qq") == 0)
        {
            m = f;
        } else
        if (((String) (obj)).compareTo("sync_wechat") == 0)
        {
            m = g;
        } else
        if (((String) (obj)).compareTo("sync_qqzone") == 0)
        {
            m = null;
        } else
        if (((String) (obj)).compareTo("sync_line") == 0)
        {
            m = null;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i1 != 2 || m == null) goto _L6; else goto _L5
_L5:
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("\u5206\u4EAB\u5B8C\u6210");
        if (m.alertText != null && m.alertText.compareTo("") != 0)
        {
            builder.setMessage(m.alertText);
        }
        builder.setPositiveButton(m.okText, new android.content.DialogInterface.OnClickListener() {

            final PhotoShareActivity2 a;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
                if (a.m.backUrl != null && a.m.backUrl.compareTo("") != 0)
                {
                    dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(a.m.backUrl));
                    a.startActivity(dialoginterface);
                }
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        });
        builder.setNegativeButton(m.cancelText, new android.content.DialogInterface.OnClickListener() {

            final PhotoShareActivity2 a;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
            }

            
            {
                a = PhotoShareActivity2.this;
                super();
            }
        });
        builder.show();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
