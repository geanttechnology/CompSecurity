// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.pip.PipStyleActivity;
import com.pipcamera.activity.pip.PipStyleBaseActivity;
import com.pipcamera.activity.shareView.TShareScrollView;
import com.pipcamera.activity.weibo.QQAuthroizeActivity;
import com.pipcamera.application.PIPCameraApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Date;
import rx;
import ta;
import uz;
import yg;
import yl;
import yz;
import zb;
import ze;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity, PIPCameraActivity, ShareEditActivity

public class PhotoShareActivity extends FullscreenActivity
    implements ta
{

    TShareScrollView a;
    String b;
    private Button c;
    private boolean d;
    private boolean e;
    private Resources f;
    private Bitmap g;
    private Uri h;
    private boolean i;

    public PhotoShareActivity()
    {
        d = false;
        e = false;
        i = false;
        b = null;
    }

    static Bitmap a(PhotoShareActivity photoshareactivity, Bitmap bitmap)
    {
        photoshareactivity.g = bitmap;
        return bitmap;
    }

    static Uri a(PhotoShareActivity photoshareactivity)
    {
        return photoshareactivity.h;
    }

    static Uri a(PhotoShareActivity photoshareactivity, Uri uri)
    {
        photoshareactivity.h = uri;
        return uri;
    }

    private void a()
    {
        ProgressDialog progressdialog = ProgressDialog.show(this, null, f.getString(0x7f0601d0), true);
        (new Handler()).postDelayed(new Runnable(progressdialog) {

            final ProgressDialog a;
            final PhotoShareActivity b;

            public void run()
            {
                Object obj;
                Object obj1;
                a.dismiss();
                obj = (ImageView)b.findViewById(0x7f0c01e5);
                obj1 = b.getIntent();
                ((Intent) (obj1)).getStringExtra("PhotoShareActivity_ToShareImageUri");
                if (((Intent) (obj1)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
                {
                    break MISSING_BLOCK_LABEL_178;
                }
                obj1 = ((Intent) (obj1)).getStringExtra("PhotoShareActivity_ToShareImageUri");
                File file = new File(new URI(((String) (obj1)).replace(" ", "%20")));
                uz.a().b(file.getPath());
                uz.a().a(false);
                PhotoShareActivity.a(b, Uri.parse(((String) (obj1))));
                ((ImageView) (obj)).setImageURI(PhotoShareActivity.a(b));
                PhotoShareActivity.a(b, android.provider.MediaStore.Images.Media.getBitmap(b.getContentResolver(), PhotoShareActivity.a(b)));
                if (PhotoShareActivity.b(b) != null)
                {
                    ((ImageView) (obj)).setImageBitmap(PhotoShareActivity.b(b));
                }
_L1:
                return;
                obj;
                ((Exception) (obj)).printStackTrace();
                Crashlytics.logException(((Throwable) (obj)));
                b.finish();
                return;
                obj1 = ((Intent) (obj1)).getStringExtra("imageUrlString");
                PhotoShareActivity.a(b, yl.a().b(((String) (obj1))));
                ((ImageView) (obj)).setImageBitmap(PhotoShareActivity.b(b));
                if (PhotoShareActivity.b(b) != null)
                {
                    PhotoShareActivity.c(b);
                    return;
                }
                  goto _L1
            }

            
            {
                b = PhotoShareActivity.this;
                a = progressdialog;
                super();
            }
        }, 2000L);
    }

    static Bitmap b(PhotoShareActivity photoshareactivity)
    {
        return photoshareactivity.g;
    }

    private void b()
    {
        if (!d) goto _L2; else goto _L1
_L1:
        finish();
        uz.a().a(null);
        System.gc();
        yl.a().c();
        overridePendingTransition(0x10a0002, 0x10a0003);
_L4:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Log.e("PhotoShare", activitynotfoundexception.getMessage());
        Crashlytics.logException(activitynotfoundexception);
        return;
_L2:
        if (!e) goto _L4; else goto _L3
_L3:
        try
        {
            if (PipStyleActivity.i != null)
            {
                Log.v("PhotoShare", "PhotoSharemake PipStyleActivity finish");
                PipStyleActivity.i.finish();
                PipStyleActivity.i = null;
            }
            if (PIPCameraApplication.g)
            {
                finish();
                PIPCameraApplication.g = false;
                return;
            }
        }
        catch (ActivityNotFoundException activitynotfoundexception1)
        {
            Log.e("PhotoShare", activitynotfoundexception1.getMessage());
            Crashlytics.logException(activitynotfoundexception1);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, com/pipcamera/activity/PIPCameraActivity);
        intent.setFlags(0x4000000);
        startActivity(intent);
        uz.a().a(null);
        yg.a().b();
        yl.a().c();
        System.gc();
        return;
    }

    private void c()
    {
        boolean flag = false;
        Object obj = new ByteArrayOutputStream();
        g.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((OutputStream) (obj)));
        byte abyte0[] = ((ByteArrayOutputStream) (obj)).toByteArray();
        Object obj1 = uz.a();
        ((uz) (obj1)).b();
        ((uz) (obj1)).a("JPG");
        ((uz) (obj1)).a(true);
        uz.a().a(abyte0);
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        byte abyte1[];
        Object obj2;
        FileOutputStream fileoutputstream;
        int j;
        long l;
        if (flag)
        {
            abyte0 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            obj1 = (new StringBuilder()).append(abyte0).append("/PIP_CAMERA/").toString();
            File file = new File(((String) (obj1)));
            abyte0 = ((byte []) (obj1));
            if (!file.exists())
            {
                file.mkdirs();
                abyte0 = ((byte []) (obj1));
            }
        } else
        {
            String s = getDir("PIP_CAMERA", 1).getAbsolutePath();
            File file1 = new File(s);
            abyte0 = s;
            if (!file1.exists())
            {
                file1.mkdirs();
                abyte0 = s;
            }
        }
        l = (new Date()).getTime();
        obj1 = (new StringBuilder()).append("img").append(String.valueOf(l)).append(".jpg").toString();
        abyte0 = (new StringBuilder()).append(abyte0).append(((String) (obj1))).toString();
        abyte1 = uz.a().c();
        j = abyte1.length;
        fileoutputstream = new FileOutputStream(abyte0);
        fileoutputstream.write(abyte1, 0, j);
        fileoutputstream.close();
        obj2 = new ContentValues(9);
        ((ContentValues) (obj2)).put("title", "jpg_wantu");
        ((ContentValues) (obj2)).put("_display_name", ((String) (obj1)));
        ((ContentValues) (obj2)).put("mime_type", "image/jpeg");
        ((ContentValues) (obj2)).put("_data", abyte0);
        ((ContentValues) (obj2)).put("_size", Integer.valueOf(j));
        obj1 = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ((ContentValues) (obj2)));
        obj2 = getContentResolver().openOutputStream(((Uri) (obj1)));
        g.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((OutputStream) (obj2)));
        ((OutputStream) (obj2)).close();
_L1:
        Exception exception1;
        try
        {
            Log.v("url", ((Uri) (obj1)).toString());
            h = ((Uri) (obj1));
            uz.a().b(abyte0);
            Toast.makeText(this, (new StringBuilder()).append(f.getString(0x7f060197)).append(abyte0).toString(), 1).show();
        }
        catch (Exception exception)
        {
            Toast.makeText(this, f.getString(0x7f060196), 1).show();
            Crashlytics.logException(exception);
        }
        FlurryAgent.logEvent("usersavePhoto");
        return;
        exception1;
        Log.e("PhotoShare", "exception while writing image", exception1);
        Crashlytics.logException(exception1);
          goto _L1
    }

    static void c(PhotoShareActivity photoshareactivity)
    {
        photoshareactivity.c();
    }

    public void OnSinaShareBtnClicked(View view)
    {
        if (h == null)
        {
            Toast.makeText(this, f.getString(0x7f060193), 1).show();
        }
    }

    public void a(String s, Object obj)
    {
    }

    public void backBtnClicked(View view)
    {
        d = true;
        b();
    }

    public void moreShareClicked(View view)
    {
        view = new Intent();
        view.setAction("android.intent.action.SEND");
        view.putExtra("android.intent.extra.SUBJECT", 0x7f060199);
        view.putExtra("android.intent.extra.STREAM", h);
        view.setType("image/jpeg");
        startActivity(Intent.createChooser(view, getResources().getText(0x7f060199)));
        FlurryAgent.logEvent("PhotoSharebyOther");
    }

    public void nextBtnClicked(View view)
    {
        e = true;
        b();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030069);
        b = getIntent().getStringExtra("shareText");
        f = getResources();
        c = (Button)findViewById(0x7f0c0080);
        FrameLayout framelayout;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (PIPCameraApplication.g)
        {
            c.setText(getResources().getString(0x7f0600ef));
        } else
        {
            c.setText(getResources().getString(0x7f060134));
        }
        bundle = (RelativeLayout)findViewById(0x7f0c01e1);
        bundle = getResources().getDisplayMetrics();
        framelayout = (FrameLayout)findViewById(0x7f0c01e4);
        layoutparams = (android.widget.RelativeLayout.LayoutParams)framelayout.getLayoutParams();
        if (((DisplayMetrics) (bundle)).heightPixels - ((DisplayMetrics) (bundle)).widthPixels < 150)
        {
            layoutparams.width = ((DisplayMetrics) (bundle)).heightPixels - 150;
            layoutparams.height = ((DisplayMetrics) (bundle)).heightPixels - 150;
        } else
        {
            layoutparams.width = ((DisplayMetrics) (bundle)).widthPixels;
            layoutparams.height = ((DisplayMetrics) (bundle)).widthPixels;
        }
        framelayout.setLayoutParams(layoutparams);
        ((TextView)findViewById(0x7f0c002d)).setText(f.getString(0x7f060199));
        a();
        a = (TShareScrollView)findViewById(0x7f0c01ad);
        a.setCallback(this);
    }

    protected void onDestroy()
    {
        ImageView imageview = (ImageView)findViewById(0x7f0c01e5);
        if (imageview != null)
        {
            imageview.setImageBitmap(null);
        }
        if (g != null && !g.isRecycled())
        {
            g.recycle();
        }
        super.onDestroy();
    }

    public void onFacebookShareBtnClicked(View view)
    {
        if (h == null)
        {
            Toast.makeText(this, f.getString(0x7f060193), 1).show();
            return;
        }
        if (checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            ze.a(this, f.getString(0x7f060198), f.getString(0x7f060192));
        }
        if (Boolean.valueOf(getSharedPreferences("com.wantu.android.WantuSetting", 0).getBoolean("com.wantu.android.facebook.isconnected.key", false)).booleanValue())
        {
            view = new Intent(this, com/pipcamera/activity/ShareEditActivity);
            view.putExtra("com.wantu.android.weibo", "facebook");
            startActivity(view);
            FlurryAgent.logEvent("PhotoSharebyFacebook");
            return;
        } else
        {
            view = new zb("382743411764062");
            rx rx1 = new rx(this);
            view.a(this, new String[] {
                "offline_access", "publish_stream", "user_photos", "publish_checkins", "photo_upload"
            }, rx1);
            return;
        }
    }

    public void onQQBtnClicked(View view)
    {
        if (h == null)
        {
            Toast.makeText(this, f.getString(0x7f060193), 1).show();
            return;
        }
        if (checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            ze.a(this, f.getString(0x7f060198), f.getString(0x7f060192));
        }
        if (!yz.a(this))
        {
            view = new Intent(this, com/pipcamera/activity/weibo/QQAuthroizeActivity);
            view.putExtra("com.wantu.android.source", "share");
            startActivity(view);
            return;
        } else
        {
            view = new Intent(this, com/pipcamera/activity/ShareEditActivity);
            view.putExtra("com.wantu.android.weibo", "qq");
            startActivity(view);
            FlurryAgent.logEvent("PhotoSharebyTencent");
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
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
