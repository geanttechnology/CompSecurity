// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import atq;
import bei;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.instamag.activity.compose.MagComposeActivity;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import os;
import ot;
import ou;
import ov;
import ow;
import ox;
import oy;
import oz;
import pa;
import pb;
import pc;
import qv;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            ContinuousPhotoViewPager, PhotoViewerPagerAdapter, CustomShareUtil

public class ActivityContinousPhotoViewer extends FullscreenActivity
    implements android.view.View.OnClickListener, qv
{

    public static int a = 1120;
    public static int b = 1;
    LinearLayout A;
    LinearLayout B;
    public boolean C;
    private final String D = "ActivityContinousPhotoViewer";
    private final String E = "ContinueViewerRecentShare";
    private ContinuousPhotoViewPager F;
    private PhotoViewerPagerAdapter G;
    private ArrayList H;
    private ArrayList I;
    private int J;
    private float K;
    private CustomShareUtil.EnumRecentShare L;
    private bei M;
    public FrameLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public FrameLayout f;
    ImageView g;
    ImageView h;
    ImageView i;
    ImageView j;
    ImageView k;
    ImageView l;
    TextView m;
    ImageView n;
    ImageView o;
    ImageView p;
    ImageView q;
    ImageView r;
    ImageView s;
    ImageView t;
    ImageView u;
    LinearLayout v;
    LinearLayout w;
    LinearLayout x;
    LinearLayout y;
    LinearLayout z;

    public ActivityContinousPhotoViewer()
    {
        J = 0;
        K = 1.0F;
        C = false;
        M = null;
    }

    public static ContinuousPhotoViewPager a(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        return activitycontinousphotoviewer.F;
    }

    private void a(int i1)
    {
        m.setText((new StringBuilder()).append("(").append(i1).append("/").append(String.valueOf(H.size())).append(")").toString());
    }

    public static void a(ActivityContinousPhotoViewer activitycontinousphotoviewer, int i1)
    {
        activitycontinousphotoviewer.a(i1);
    }

    private void a(CustomShareUtil.EnumRecentShare enumrecentshare)
    {
        ou.a[enumrecentshare.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 60
    //                   2 77
    //                   3 94
    //                   4 111
    //                   5 128
    //                   6 145
    //                   7 162;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        d.invalidate();
        return;
_L2:
        h.setBackgroundResource(0x7f020141);
        L = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L3:
        h.setBackgroundResource(0x7f020142);
        L = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L4:
        h.setBackgroundResource(0x7f0200ae);
        L = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L5:
        h.setBackgroundResource(0x7f0200b4);
        L = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L6:
        h.setBackgroundResource(0x7f0200b5);
        L = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L7:
        h.setBackgroundResource(0x7f020146);
        L = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L8:
        h.setBackgroundResource(0x7f0200ac);
        L = enumrecentshare;
        if (true) goto _L1; else goto _L9
_L9:
    }

    private TPhotoComposeInfo b(int i1)
    {
        Object obj = InstaMagType.RECT_LIB_SIZE_TYPE;
        int j1 = getSharedPreferences("config", 0).getInt("lastTypeInt", 0);
        if (j1 == 0)
        {
            obj = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        if (j1 == 1)
        {
            obj = InstaMagType.SQ_LIB_SIZE_TYPE;
        } else
        if (j1 == 2)
        {
            obj = InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
        } else
        {
            obj = InstaMagType.RECT_LIB_SIZE_TYPE;
        }
        obj = t().a(((InstaMagType) (obj)), i1);
        if (obj != null && ((List) (obj)).size() > 0)
        {
            return (TPhotoComposeInfo)((List) (obj)).get((int)(Math.random() * (double)((List) (obj)).size()));
        } else
        {
            return null;
        }
    }

    private void b()
    {
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        s.setOnClickListener(this);
        r.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        t.setOnClickListener(this);
        n.setOnClickListener(this);
        u.setOnClickListener(this);
        F.setOnPageChangeListener(new os(this));
    }

    public static void b(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        activitycontinousphotoviewer.d();
    }

    public static float c(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        return activitycontinousphotoviewer.K;
    }

    private void c()
    {
        c = (FrameLayout)findViewById(0x7f0d008c);
        d = (FrameLayout)findViewById(0x7f0d0091);
        e = (FrameLayout)findViewById(0x7f0d0089);
        f = (FrameLayout)findViewById(0x7f0d0087);
        g = (ImageView)findViewById(0x7f0d008d);
        h = (ImageView)findViewById(0x7f0d008e);
        j = (ImageView)findViewById(0x7f0d0090);
        k = (ImageView)findViewById(0x7f0d00a0);
        i = (ImageView)findViewById(0x7f0d008f);
        l = (ImageView)findViewById(0x7f0d008a);
        m = (TextView)findViewById(0x7f0d008b);
        s = (ImageView)findViewById(0x7f0d009b);
        r = (ImageView)findViewById(0x7f0d009d);
        o = (ImageView)findViewById(0x7f0d0099);
        p = (ImageView)findViewById(0x7f0d0097);
        q = (ImageView)findViewById(0x7f0d0095);
        t = (ImageView)findViewById(0x7f0d009f);
        n = (ImageView)findViewById(0x7f0d0093);
        u = (ImageView)findViewById(0x7f0d00a1);
        z = (LinearLayout)findViewById(0x7f0d009a);
        A = (LinearLayout)findViewById(0x7f0d009c);
        x = (LinearLayout)findViewById(0x7f0d0098);
        y = (LinearLayout)findViewById(0x7f0d0096);
        w = (LinearLayout)findViewById(0x7f0d0094);
        B = (LinearLayout)findViewById(0x7f0d009e);
        v = (LinearLayout)findViewById(0x7f0d0092);
        F = (ContinuousPhotoViewPager)findViewById(0x7f0d0088);
        d.setVisibility(4);
        d.getViewTreeObserver().addOnGlobalLayoutListener(new ov(this));
    }

    private void c(int i1)
    {
        AnimationSet animationset = new AnimationSet(true);
        d.setVisibility(0);
        Log.e("ActivityContinousPhotoViewer", (new StringBuilder()).append("mShareBar.getHeight()=").append(d.getHeight()).toString());
        TranslateAnimation translateanimation;
        if (C)
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, d.getHeight(), 0.0F);
            d.setClickable(true);
            d.setFocusable(true);
        } else
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, d.getHeight());
            d.setClickable(false);
            d.setFocusable(false);
        }
        translateanimation.setFillAfter(true);
        translateanimation.setDuration(i1);
        translateanimation.setAnimationListener(new ot(this));
        animationset.addAnimation(translateanimation);
        d.startAnimation(animationset);
    }

    private void d()
    {
        e();
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            x.setVisibility(0);
            y.setVisibility(0);
            w.setVisibility(0);
            return;
        } else
        {
            z.setVisibility(0);
            A.setVisibility(0);
            B.setVisibility(0);
            return;
        }
    }

    public static void d(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        activitycontinousphotoviewer.v();
    }

    private void e()
    {
        z.setVisibility(8);
        A.setVisibility(8);
        x.setVisibility(8);
        y.setVisibility(8);
        w.setVisibility(8);
        B.setVisibility(8);
    }

    private void f()
    {
        if (C)
        {
            C = false;
            c(500);
        }
    }

    private void g()
    {
        finish();
    }

    private void h()
    {
        if (!C)
        {
            C = true;
            c(500);
        }
    }

    private void i()
    {
        Uri uri = Uri.parse((String)H.get(F.getCurrentItem()));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.SUBJECT", "Share");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setFlags(0x10000000);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    private void j()
    {
        Object obj = (String)H.get(F.getCurrentItem());
        H.remove(F.getCurrentItem());
        G.notifyDataSetChanged();
        a(F.getCurrentItem() + 1);
        I.add(obj);
        Log.e("ActivityContinousPhotoViewer", (new StringBuilder()).append("strPhotoName=").append(((String) (obj))).append(", mDelList.size()=").append(I.size()).toString());
        obj = new Intent();
        ((Intent) (obj)).putExtra("DelPhotoList", I);
        setResult(b, ((Intent) (obj)));
        if (H != null && H.size() == 0)
        {
            finish();
        }
    }

    private void k()
    {
        switch (ou.a[L.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            r();
            return;

        case 2: // '\002'
            q();
            return;

        case 3: // '\003'
            p();
            return;

        case 6: // '\006'
            o();
            return;

        case 7: // '\007'
            n();
            return;

        case 4: // '\004'
            m();
            return;

        case 5: // '\005'
            l();
            return;
        }
    }

    private boolean l()
    {
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile((String)H.get(F.getCurrentItem()));
        u();
        FlurryAgent.logEvent("PhotoSharebytwitter");
        return atq.b(this, bitmap, "sync_twitter", null, new ow(this));
    }

    private boolean m()
    {
        u();
        FlurryAgent.logEvent("PhotoSharebySinaweibo");
        return atq.b(this, Uri.parse((String)H.get(F.getCurrentItem())), "sync_sina", null, getResources().getString(0x7f060077), new ox(this));
    }

    private boolean n()
    {
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile((String)H.get(F.getCurrentItem()));
        u();
        FlurryAgent.logEvent("PhotoSharebyMonent");
        return atq.f(this, bitmap, "sync_moment", null, new oy(this));
    }

    private boolean o()
    {
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile((String)H.get(F.getCurrentItem()));
        u();
        FlurryAgent.logEvent("PhotoSharebyWechat");
        return atq.e(this, bitmap, "sync_wechat", null, new oz(this));
    }

    private boolean p()
    {
        u();
        FlurryAgent.logEvent("PhotoSharebyQQZone");
        return atq.e(this, Uri.parse((String)H.get(F.getCurrentItem())), "sync_qqzone", null, new pa(this));
    }

    private boolean q()
    {
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile((String)H.get(F.getCurrentItem()));
        u();
        FlurryAgent.logEvent("PhotoSharebyInstagram");
        return atq.c(this, bitmap, "sync_instagram", null, new pb(this));
    }

    private boolean r()
    {
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile((String)H.get(F.getCurrentItem()));
        u();
        FlurryAgent.logEvent("PhotoSharebyFacebook");
        return atq.a(this, bitmap, "sync_facebook", null, new pc(this));
    }

    private void s()
    {
        Object obj = (String)H.get(F.getCurrentItem());
        Log.e("ActivityContinousPhotoViewer", (new StringBuilder()).append("current photo str=").append(((String) (obj))).toString());
        ArrayList arraylist = new ArrayList();
        arraylist.add(obj);
        obj = b(arraylist.size());
        if (obj != null)
        {
            Intent intent = new Intent(this, com/instamag/activity/compose/MagComposeActivity);
            intent.putExtra("SelectedComposeInfoResId", ((TPhotoComposeInfo) (obj)).resId);
            intent.putStringArrayListExtra("SelectedImageUriStrings", arraylist);
            intent.putExtra("use_for_flurry_mag", 13);
            startActivity(intent);
        }
        FlurryAgent.logEvent("continutake_photoedit_instamag_clicked");
    }

    private bei t()
    {
        if (M == null)
        {
            M = new bei();
            M.a();
        }
        return M;
    }

    private void u()
    {
        showDialog(1);
    }

    private void v()
    {
        removeDialog(1);
    }

    public void a()
    {
        if (C)
        {
            C = false;
            c(500);
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558538 2131558561: default 116
    //                   2131558538 142
    //                   2131558539 116
    //                   2131558540 116
    //                   2131558541 117
    //                   2131558542 122
    //                   2131558543 137
    //                   2131558544 127
    //                   2131558545 116
    //                   2131558546 116
    //                   2131558547 314
    //                   2131558548 116
    //                   2131558549 179
    //                   2131558550 116
    //                   2131558551 206
    //                   2131558552 116
    //                   2131558553 260
    //                   2131558554 116
    //                   2131558555 152
    //                   2131558556 116
    //                   2131558557 233
    //                   2131558558 116
    //                   2131558559 287
    //                   2131558560 132
    //                   2131558561 147;
           goto _L1 _L2 _L1 _L1 _L3 _L4 _L5 _L6 _L1 _L1 _L7 _L1 _L8 _L1 _L9 _L1 _L10 _L1 _L11 _L1 _L12 _L1 _L13 _L14 _L15
_L1:
        return;
_L3:
        s();
        return;
_L4:
        k();
        return;
_L6:
        j();
        return;
_L14:
        i();
        return;
_L5:
        h();
        return;
_L2:
        g();
        return;
_L15:
        f();
        return;
_L11:
        if (r())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_WECHAT;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (m())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_SINA;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (p())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_QQZONE;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (q())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_INSTAGRAM;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (n())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_MOMENT;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if (l())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_TWITTER;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (o())
        {
            L = CustomShareUtil.EnumRecentShare.SHARE_WECHAT;
            CustomShareUtil.a().a(L, "ContinueViewerRecentShare");
            return;
        }
        if (true) goto _L1; else goto _L16
_L16:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030021);
        CustomShareUtil.a().a(getApplicationContext());
        L = CustomShareUtil.a().a("ContinueViewerRecentShare");
        I = new ArrayList();
        H = (ArrayList)getIntent().getSerializableExtra("UriList");
        J = getIntent().getIntExtra("pos", 0);
        K = getIntent().getFloatExtra("h2w", 1.0F);
        c();
        b();
        a(J + 1);
        G = new PhotoViewerPagerAdapter();
        F.setAdapter(G);
        F.setCurrentItem(J);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onResume()
    {
        a(L);
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

}
