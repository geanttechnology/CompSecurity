// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import abe;
import abf;
import abg;
import abh;
import abi;
import abj;
import abk;
import abl;
import abm;
import abn;
import abo;
import abp;
import abq;
import abr;
import abs;
import abt;
import abu;
import abv;
import abw;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import apq;
import aqe;
import aqn;
import aqx;
import atg;
import atq;
import aym;
import bgx;
import bka;
import bos;
import boy;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.HomeWallFactory;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.savepagescrollview.FotoFbNativeAdViewItem;
import com.fotoable.savepagescrollview.ShareScrolladView;
import com.fotoable.view.actionbar.CommonActionBarView1;
import com.instabeauty.application.InstaBeautyApplication;
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
import hu;
import hz;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yo;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity, WantuActivity, PhotoShareToInstagramActivity

public class NewPhotoShareActivity extends FullscreenActivity
    implements atg, aym, com.fotoable.ad.HomeWallFactory.HomeWallClickListener, com.fotoable.ad.HomeWallFactory.fotoHomeWalladListener
{

    private TextView A;
    private RelativeLayout B;
    private Handler C;
    private Uri D;
    private boolean E;
    private hz F;
    String a;
    ShareScrolladView b;
    String c;
    CommonActionBarView1 d;
    ArrayList e;
    public SinaweiboShareInfo f;
    public TencentweiboShareInfo g;
    public QQShareInfo h;
    public WechatShareInfo i;
    public WXMomentsShareInfo j;
    public FacebookShareInfo k;
    public InstagramShareInfo l;
    public TwitterShareInfo m;
    public TumblrShareInfo n;
    public ShareInfoToline o;
    boolean p;
    private boolean q;
    private boolean r;
    private Resources s;
    private Bitmap t;
    private Uri u;
    private String v;
    private boolean w;
    private boolean x;
    private FrameLayout y;
    private FrameLayout z;

    public NewPhotoShareActivity()
    {
        a = "";
        q = false;
        r = false;
        c = null;
        w = false;
        x = false;
        E = false;
        F = new abe(this);
        p = true;
    }

    public static Bitmap a(NewPhotoShareActivity newphotoshareactivity, Bitmap bitmap)
    {
        newphotoshareactivity.t = bitmap;
        return bitmap;
    }

    public static Uri a(NewPhotoShareActivity newphotoshareactivity, Uri uri)
    {
        newphotoshareactivity.u = uri;
        return uri;
    }

    public static hz a(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.F;
    }

    public static String a(NewPhotoShareActivity newphotoshareactivity, String s1)
    {
        newphotoshareactivity.v = s1;
        return s1;
    }

    private void a(Bitmap bitmap)
    {
        e();
        c = null;
        if (l != null && l.shareTag != null && l.shareTag.compareTo("") != 0)
        {
            c = l.shareTag;
        }
        if (bitmap != null)
        {
            atq.c(this, bitmap, "sync_instagram", null, new abn(this));
            return;
        } else
        {
            atq.a(this, D, "sync_instagram", null, c, new abo(this));
            return;
        }
    }

    private void a(String s1)
    {
        A.setText(0x7f0601b9);
        (new Handler()).postDelayed(new abu(this), 1000L);
    }

    public static boolean a(NewPhotoShareActivity newphotoshareactivity, boolean flag)
    {
        newphotoshareactivity.E = flag;
        return flag;
    }

    public static Uri b(NewPhotoShareActivity newphotoshareactivity, Uri uri)
    {
        newphotoshareactivity.D = uri;
        return uri;
    }

    public static void b(NewPhotoShareActivity newphotoshareactivity)
    {
        newphotoshareactivity.f();
    }

    public static void b(NewPhotoShareActivity newphotoshareactivity, String s1)
    {
        newphotoshareactivity.a(s1);
    }

    public static Uri c(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.u;
    }

    private void c()
    {
        e();
        (new Handler()).postDelayed(new abt(this), 300L);
    }

    public static Uri d(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.D;
    }

    private void d()
    {
        if (!q) goto _L2; else goto _L1
_L1:
        bka.a().a(null);
        System.gc();
        if (!w);
        FlurryAgent.logEvent("PhotoShare_back_clicked");
        finish();
        overridePendingTransition(0x10a0002, 0x10a0003);
_L4:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Crashlytics.logException(activitynotfoundexception);
        Log.e("NewPhotoShareActivity", activitynotfoundexception.getMessage());
        return;
_L2:
        if (!r) goto _L4; else goto _L3
_L3:
        Object obj;
        FlurryAgent.logEvent("PhotoShare_home_clicked");
        bka.a().a(null);
        bos.a().b();
        boy.b().d();
        System.gc();
        obj = new Intent();
        if (!E)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        ((Intent) (obj)).setClass(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNew);
        ((Intent) (obj)).putExtra(ActivityCameraNew.c, true);
_L5:
        ((Intent) (obj)).setFlags(0x4000000);
        startActivity(((Intent) (obj)));
        return;
        try
        {
            ((Intent) (obj)).setClass(this, com/fotoable/fotobeauty/WantuActivity);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Crashlytics.logException(((Throwable) (obj)));
            Log.e("NewPhotoShareActivity", ((ActivityNotFoundException) (obj)).getMessage());
            return;
        }
          goto _L5
    }

    public static Bitmap e(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.t;
    }

    private void e()
    {
        showDialog(1);
    }

    public static RelativeLayout f(NewPhotoShareActivity newphotoshareactivity)
    {
        return newphotoshareactivity.B;
    }

    private void f()
    {
        removeDialog(1);
    }

    private void g()
    {
        Intent intent = new Intent(this, com/fotoable/fotobeauty/PhotoShareToInstagramActivity);
        intent.putExtra("KSHARETOINSTAGRAM", true);
        intent.putExtra("kimageuri", D.toString());
        startActivity(intent);
    }

    public void a()
    {
        nextBtnClicked(null);
    }

    public void a(String s1, Object obj)
    {
        if (s1.compareTo("sync_facebook") == 0)
        {
            e();
            FlurryAgent.logEvent("PhotoSharebyFacebook");
            atq.a(this, t, s1, obj, new abv(this));
        } else
        {
            if (s1.compareTo("sync_twitter") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebytwitter");
                atq.b(this, t, s1, obj, new abw(this));
                return;
            }
            if (s1.compareTo("sync_instagram") == 0)
            {
                FlurryAgent.logEvent("PhotoSharebyInstagram");
                if (!apq.a(this, "com.instagram.android"))
                {
                    Toast.makeText(this, getString(0x7f060225), 1).show();
                    return;
                }
                aqx.b(this, "InstagramNew", false);
                b.setInstagramNewViewVisibility(false);
                s1 = yo.a(D.getPath(), this);
                if (((Point) (s1)).x == ((Point) (s1)).y)
                {
                    a(((Bitmap) (null)));
                    return;
                } else
                {
                    g();
                    return;
                }
            }
            if (s1.compareTo("sync_tumblr") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebytumblr");
                atq.d(this, t, s1, obj, new abf(this));
                return;
            }
            if (s1.compareTo("sync_sina") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebySinaweibo");
                atq.b(this, D, s1, obj, c, new abg(this));
                return;
            }
            if (s1.compareTo("sync_qqzone") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebyQQZone");
                atq.e(this, D, s1, obj, new abh(this));
                return;
            }
            if (s1.compareTo("sync_qqweibo") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebyQQWeibo");
                atq.g(this, D, s1, obj, new abi(this));
                return;
            }
            if (s1.compareTo("sync_qq") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebyQQ");
                atq.f(this, D, s1, obj, new abj(this));
                return;
            }
            if (s1.compareTo("sync_moment") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebyMonent");
                atq.f(this, t, s1, obj, new abk(this));
                return;
            }
            if (s1.compareTo("sync_wechat") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebyWechat");
                atq.e(this, t, s1, obj, new abl(this));
                return;
            }
            if (s1.compareTo("sync_line") == 0)
            {
                e();
                FlurryAgent.logEvent("PhotoSharebyLine");
                atq.d(this, D, s1, obj, new abm(this));
                return;
            }
            if (s1.compareTo("sync_more") == 0)
            {
                s1 = new Intent();
                s1.setAction("android.intent.action.SEND");
                s1.putExtra("android.intent.extra.SUBJECT", 0x7f0601bb);
                s1.putExtra("android.intent.extra.STREAM", u);
                s1.setType("image/jpeg");
                startActivity(Intent.createChooser(s1, getResources().getText(0x7f0601bb)));
                FlurryAgent.logEvent("PhotoSharebyOther");
                return;
            }
        }
    }

    public void b()
    {
        backBtnClicked(null);
    }

    public void backBtnClicked(View view)
    {
        q = true;
        d();
    }

    public void moreShareClicked(View view)
    {
        view = new Intent();
        view.setAction("android.intent.action.SEND");
        view.putExtra("android.intent.extra.SUBJECT", 0x7f0601bb);
        view.putExtra("android.intent.extra.STREAM", u);
        view.setType("image/jpeg");
        startActivity(Intent.createChooser(view, getResources().getText(0x7f0601bb)));
        FlurryAgent.logEvent("PhotoSharebyOther");
    }

    public void nextBtnClicked(View view)
    {
        r = true;
        d();
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
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        if (bundle == null || bundle.compareTo("") == 0)
        {
            break MISSING_BLOCK_LABEL_1625;
        }
        JSONArray jsonarray;
        bundle = new JSONObject(bundle);
        jsonarray = bundle.names();
        JSONArray jsonarray1 = bundle.toJSONArray(jsonarray);
        int i1 = 0;
_L2:
        if (i1 >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        aqn.a(null, 3, (new StringBuilder()).append("Key => ").append(jsonarray.getString(i1)).append(" Value => ").append(jsonarray1.getString(i1)).toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            if (bundle.has("tencentweiboShareInfo"))
            {
                JSONObject jsonobject = aqn.c(bundle, "tencentweiboShareInfo");
                TencentweiboShareInfo tencentweiboshareinfo = new TencentweiboShareInfo();
                if (jsonobject.has("shareTag"))
                {
                    tencentweiboshareinfo.shareTag = aqn.a(jsonobject, "shareTag");
                }
                if (jsonobject.has("backUrl"))
                {
                    tencentweiboshareinfo.backUrl = aqn.a(jsonobject, "backUrl");
                }
                if (jsonobject.has("alertText"))
                {
                    tencentweiboshareinfo.alertText = aqn.a(jsonobject, "alertText");
                }
                if (jsonobject.has("okText"))
                {
                    tencentweiboshareinfo.okText = aqn.a(jsonobject, "okText");
                }
                if (jsonobject.has("cancelText"))
                {
                    tencentweiboshareinfo.cancelText = aqn.a(jsonobject, "cancelText");
                }
                if (jsonobject.has("expiredTime"))
                {
                    tencentweiboshareinfo.expiredTime = aqn.e(jsonobject, "expiredTime");
                }
                if (jsonobject.has("backUrlID"))
                {
                    tencentweiboshareinfo.backUrlID = aqn.e(jsonobject, "backUrlID");
                }
                g = tencentweiboshareinfo;
            }
            if (bundle.has("sinaweiboShareInfo"))
            {
                JSONObject jsonobject1 = aqn.c(bundle, "sinaweiboShareInfo");
                SinaweiboShareInfo sinaweiboshareinfo = new SinaweiboShareInfo();
                if (jsonobject1.has("shareTag"))
                {
                    sinaweiboshareinfo.shareTag = aqn.a(jsonobject1, "shareTag");
                }
                if (jsonobject1.has("backUrl"))
                {
                    sinaweiboshareinfo.backUrl = aqn.a(jsonobject1, "backUrl");
                }
                if (jsonobject1.has("alertText"))
                {
                    sinaweiboshareinfo.alertText = aqn.a(jsonobject1, "alertText");
                }
                if (jsonobject1.has("okText"))
                {
                    sinaweiboshareinfo.okText = aqn.a(jsonobject1, "okText");
                }
                if (jsonobject1.has("cancelText"))
                {
                    sinaweiboshareinfo.cancelText = aqn.a(jsonobject1, "cancelText");
                }
                if (jsonobject1.has("expiredTime"))
                {
                    sinaweiboshareinfo.expiredTime = aqn.e(jsonobject1, "expiredTime");
                }
                if (jsonobject1.has("backUrlID"))
                {
                    sinaweiboshareinfo.backUrlID = aqn.e(jsonobject1, "backUrlID");
                }
                f = sinaweiboshareinfo;
            }
            if (bundle.has("wechatShareInfo"))
            {
                JSONObject jsonobject2 = aqn.c(bundle, "wechatShareInfo");
                WechatShareInfo wechatshareinfo = new WechatShareInfo();
                if (jsonobject2.has("shareTag"))
                {
                    wechatshareinfo.shareTag = aqn.a(jsonobject2, "shareTag");
                }
                if (jsonobject2.has("backUrl"))
                {
                    wechatshareinfo.backUrl = aqn.a(jsonobject2, "backUrl");
                }
                if (jsonobject2.has("alertText"))
                {
                    wechatshareinfo.alertText = aqn.a(jsonobject2, "alertText");
                }
                if (jsonobject2.has("okText"))
                {
                    wechatshareinfo.okText = aqn.a(jsonobject2, "okText");
                }
                if (jsonobject2.has("cancelText"))
                {
                    wechatshareinfo.cancelText = aqn.a(jsonobject2, "cancelText");
                }
                if (jsonobject2.has("expiredTime"))
                {
                    wechatshareinfo.expiredTime = aqn.e(jsonobject2, "expiredTime");
                }
                if (jsonobject2.has("backUrlID"))
                {
                    wechatshareinfo.backUrlID = aqn.e(jsonobject2, "backUrlID");
                }
                i = wechatshareinfo;
            }
            if (bundle.has("wxMomentsShareInfo"))
            {
                JSONObject jsonobject3 = aqn.c(bundle, "wxMomentsShareInfo");
                WXMomentsShareInfo wxmomentsshareinfo = new WXMomentsShareInfo();
                if (jsonobject3.has("shareTag"))
                {
                    wxmomentsshareinfo.shareTag = aqn.a(jsonobject3, "shareTag");
                }
                if (jsonobject3.has("backUrl"))
                {
                    wxmomentsshareinfo.backUrl = aqn.a(jsonobject3, "backUrl");
                }
                if (jsonobject3.has("alertText"))
                {
                    wxmomentsshareinfo.alertText = aqn.a(jsonobject3, "alertText");
                }
                if (jsonobject3.has("okText"))
                {
                    wxmomentsshareinfo.okText = aqn.a(jsonobject3, "okText");
                }
                if (jsonobject3.has("cancelText"))
                {
                    wxmomentsshareinfo.cancelText = aqn.a(jsonobject3, "cancelText");
                }
                if (jsonobject3.has("expiredTime"))
                {
                    wxmomentsshareinfo.expiredTime = aqn.e(jsonobject3, "expiredTime");
                }
                if (jsonobject3.has("backUrlID"))
                {
                    wxmomentsshareinfo.backUrlID = aqn.e(jsonobject3, "backUrlID");
                }
                j = wxmomentsshareinfo;
            }
            if (bundle.has("facebookShareInfo"))
            {
                JSONObject jsonobject4 = aqn.c(bundle, "facebookShareInfo");
                FacebookShareInfo facebookshareinfo = new FacebookShareInfo();
                if (jsonobject4.has("shareTag"))
                {
                    facebookshareinfo.shareTag = aqn.a(jsonobject4, "shareTag");
                }
                if (jsonobject4.has("backUrl"))
                {
                    facebookshareinfo.backUrl = aqn.a(jsonobject4, "backUrl");
                }
                if (jsonobject4.has("alertText"))
                {
                    facebookshareinfo.alertText = aqn.a(jsonobject4, "alertText");
                }
                if (jsonobject4.has("okText"))
                {
                    facebookshareinfo.okText = aqn.a(jsonobject4, "okText");
                }
                if (jsonobject4.has("cancelText"))
                {
                    facebookshareinfo.cancelText = aqn.a(jsonobject4, "cancelText");
                }
                if (jsonobject4.has("expiredTime"))
                {
                    facebookshareinfo.expiredTime = aqn.e(jsonobject4, "expiredTime");
                }
                if (jsonobject4.has("backUrlID"))
                {
                    facebookshareinfo.backUrlID = aqn.e(jsonobject4, "backUrlID");
                }
                k = facebookshareinfo;
            }
            if (bundle.has("twitterShareInfo"))
            {
                JSONObject jsonobject5 = aqn.c(bundle, "twitterShareInfo");
                TwitterShareInfo twittershareinfo = new TwitterShareInfo();
                if (jsonobject5.has("shareTag"))
                {
                    twittershareinfo.shareTag = aqn.a(jsonobject5, "shareTag");
                }
                if (jsonobject5.has("backUrl"))
                {
                    twittershareinfo.backUrl = aqn.a(jsonobject5, "backUrl");
                }
                if (jsonobject5.has("alertText"))
                {
                    twittershareinfo.alertText = aqn.a(jsonobject5, "alertText");
                }
                if (jsonobject5.has("okText"))
                {
                    twittershareinfo.okText = aqn.a(jsonobject5, "okText");
                }
                if (jsonobject5.has("cancelText"))
                {
                    twittershareinfo.cancelText = aqn.a(jsonobject5, "cancelText");
                }
                if (jsonobject5.has("expriedTime"))
                {
                    twittershareinfo.expiredTime = aqn.e(jsonobject5, "expiredTime");
                }
                if (jsonobject5.has("backUrlID"))
                {
                    twittershareinfo.backUrlID = aqn.e(jsonobject5, "backUrlID");
                }
                m = twittershareinfo;
            }
            if (bundle.has("qqShareInfo"))
            {
                JSONObject jsonobject6 = aqn.c(bundle, "qqShareInfo");
                QQShareInfo qqshareinfo = new QQShareInfo();
                if (jsonobject6.has("shareTag"))
                {
                    qqshareinfo.shareTag = aqn.a(jsonobject6, "shareTag");
                }
                if (jsonobject6.has("bcakUrl"))
                {
                    qqshareinfo.backUrl = aqn.a(jsonobject6, "backUrl");
                }
                if (jsonobject6.has("alertText"))
                {
                    qqshareinfo.alertText = aqn.a(jsonobject6, "alertText");
                }
                if (jsonobject6.has("okText"))
                {
                    qqshareinfo.okText = aqn.a(jsonobject6, "okText");
                }
                if (jsonobject6.has("cancelText"))
                {
                    qqshareinfo.cancelText = aqn.a(jsonobject6, "cancelText");
                }
                if (jsonobject6.has("expiredTime"))
                {
                    qqshareinfo.expiredTime = aqn.e(jsonobject6, "expiredTime");
                }
                if (jsonobject6.has("backUrlID"))
                {
                    qqshareinfo.backUrlID = aqn.e(jsonobject6, "backUrlID");
                }
                h = qqshareinfo;
            }
            if (bundle.has("instagramShareInfo"))
            {
                bundle = aqn.c(bundle, "instagramShareInfo");
                InstagramShareInfo instagramshareinfo = new InstagramShareInfo();
                if (bundle.has("shareTag"))
                {
                    instagramshareinfo.shareTag = aqn.a(bundle, "shareTag");
                }
                if (bundle.has("backUrl"))
                {
                    instagramshareinfo.backUrl = aqn.a(bundle, "backUrl");
                }
                if (bundle.has("alertText"))
                {
                    instagramshareinfo.alertText = aqn.a(bundle, "alertText");
                }
                if (bundle.has("okText"))
                {
                    instagramshareinfo.okText = aqn.a(bundle, "okText");
                }
                if (bundle.has("cancelText"))
                {
                    instagramshareinfo.cancelText = aqn.a(bundle, "cancelText");
                }
                if (bundle.has("expiredTime"))
                {
                    instagramshareinfo.expiredTime = aqn.e(bundle, "expiredTime");
                }
                if (bundle.has("backUrlID"))
                {
                    instagramshareinfo.backUrlID = aqn.e(bundle, "backUrlID");
                }
                l = instagramshareinfo;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            try
            {
                Crashlytics.logException(bundle);
                bundle.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        setContentView(0x7f0300aa);
        s = getResources();
        C = new Handler();
        bundle = getIntent();
        c = bundle.getStringExtra("share_tag");
        w = bundle.getBooleanExtra("colloageReIn", false);
        e = bundle.getStringArrayListExtra("CollageIds");
        d = (CommonActionBarView1)findViewById(0x7f0d00b3);
        d.setOnAcceptListener(this);
        d.setActionBarTitle(s.getString(0x7f0601bb));
        d.setAcceptBarResId(0x7f020338);
        A = (TextView)findViewById(0x7f0d02c6);
        B = (RelativeLayout)findViewById(0x7f0d02c5);
        if (!InstaBeautyApplication.a().a(this));
        c();
        z = new FotoFbNativeAdViewItem(this);
        ((FotoFbNativeAdViewItem)z).setData();
        InstaBeautyApplication.a();
        if (!InstaBeautyApplication.d() && getResources().getDisplayMetrics().heightPixels > 480)
        {
            HomeWallFactory.createHomeWallAdView(this, z, 2, bgx.a(), null, this);
        }
        b = (ShareScrolladView)findViewById(0x7f0d02c4);
        b.setCallback(this);
        b.setVerticalScrollBarEnabled(false);
        y = (FrameLayout)findViewById(0x7f0d02c7);
        if (HomeWallFactory.IsSavewallLoaded || HomeWallFactory.hasNativeAd)
        {
            y.addView(z);
        }
        FlurryAgent.logEvent("WantuSavePhoto");
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
        progressdialog.setMessage(getResources().getString(0x7f0601f3));
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
    }

    public void onHomeWallReceived(aqe aqe)
    {
    }

    protected void onPause()
    {
        super.onPause();
        try
        {
            if (HomeWallFactory.IsSavewallLoaded || HomeWallFactory.hasNativeAd)
            {
                HomeWallFactory.stopCirclePlay();
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        hu.b(this);
    }

    public void onResume()
    {
        Object obj;
        int i1;
        super.onResume();
        Object obj1;
        try
        {
            if (HomeWallFactory.IsSavewallLoaded || HomeWallFactory.hasNativeAd)
            {
                HomeWallFactory.startCirclePlay();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Crashlytics.logException(((Throwable) (obj)));
        }
        if (p)
        {
            p = false;
            (new Handler()).postDelayed(new abp(this), 500L);
        }
        obj1 = getSharedPreferences("shareStyle", 0);
        obj = ((SharedPreferences) (obj1)).getString("shareName", "isempty");
        i1 = ((SharedPreferences) (obj1)).getInt("ShareState", 0);
        obj1 = ((SharedPreferences) (obj1)).edit();
        ((android.content.SharedPreferences.Editor) (obj1)).putInt("ShareState", 0);
        ((android.content.SharedPreferences.Editor) (obj1)).putString("shareName", "isempty");
        ((android.content.SharedPreferences.Editor) (obj1)).commit();
        if (((String) (obj)).compareTo("sync_facebook") != 0) goto _L2; else goto _L1
_L1:
        o = k;
_L8:
        if (i1 != 1) goto _L4; else goto _L3
_L3:
        obj = new android.app.AlertDialog.Builder(this);
        ((android.app.AlertDialog.Builder) (obj)).setMessage("\u7533\u8BF7\u5931\u8D25");
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(0x7f060055), new abq(this));
        ((android.app.AlertDialog.Builder) (obj)).show();
_L6:
        return;
_L2:
        if (((String) (obj)).compareTo("sync_twitter") == 0)
        {
            o = m;
        } else
        if (((String) (obj)).compareTo("sync_instagram") == 0)
        {
            o = l;
        } else
        if (((String) (obj)).compareTo("sync_tumblr") == 0)
        {
            o = n;
        } else
        if (((String) (obj)).compareTo("sync_sina") == 0)
        {
            o = f;
        } else
        if (((String) (obj)).compareTo("sync_moment") == 0)
        {
            o = j;
        } else
        if (((String) (obj)).compareTo("sync_qqweibo") == 0)
        {
            o = g;
        } else
        if (((String) (obj)).compareTo("sync_qq") == 0)
        {
            o = h;
        } else
        if (((String) (obj)).compareTo("sync_wechat") == 0)
        {
            o = i;
        } else
        if (((String) (obj)).compareTo("sync_qqzone") == 0)
        {
            o = null;
        } else
        if (((String) (obj)).compareTo("sync_line") == 0)
        {
            o = null;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i1 != 2) goto _L6; else goto _L5
_L5:
        if (o == null)
        {
            Toast.makeText(this, "\u5206\u4EAB\u5B8C\u6210", 1).show();
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("\u5206\u4EAB\u5B8C\u6210");
        if (o.alertText != null && o.alertText.compareTo("") != 0)
        {
            builder.setMessage(o.alertText);
        }
        builder.setPositiveButton(o.okText, new abr(this));
        builder.setNegativeButton(o.cancelText, new abs(this));
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
