// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.comlib.ui.HorizontalListView;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.global.SimpleDialogFragment;
import com.instamag.activity.commonview.TStyleCollectionView;
import com.instamag.activity.commonview.TabItemView;
import com.instamag.activity.link.model.TPhotoLinkComposeInfo;
import com.instamag.activity.model.StyleListAdapter;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import es;
import ew;
import fo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import ju;
import ke;
import kf;
import pb;
import qx;
import qy;
import tu;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement

public class MagComposeActivity extends FullscreenActivity
    implements android.widget.AdapterView.OnItemClickListener
{

    public static LocationManager f;
    private FrameLayout A;
    private Button B;
    private Button C;
    private FrameLayout D;
    private FrameLayout E;
    private FrameLayout F;
    private BroadcastReceiver G;
    private View H;
    private FrameLayout I;
    private int J;
    TStyleCollectionView a;
    HorizontalListView b;
    StyleListAdapter c;
    qx d;
    ImageView e;
    int g;
    protected Handler h;
    Runnable i;
    public final LocationListener j = new LocationListener() {

        final MagComposeActivity a;

        public void onLocationChanged(Location location)
        {
            Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" : ").append("onLocationChanged").toString());
            if (location != null)
            {
                PIPCameraApplication.d.a(location.getLatitude());
                PIPCameraApplication.d.b(location.getLongitude());
                PIPCameraApplication.f = true;
            }
            MagComposeActivity.f.removeUpdates(a.j);
        }

        public void onProviderDisabled(String s1)
        {
            Log.v("PIPCameraApplication", (new StringBuilder()).append("PIPCameraApplication").append(" : ").append("onProviderDisabled").toString());
        }

        public void onProviderEnabled(String s1)
        {
            Log.v("PIPCameraApplication", (new StringBuilder()).append("PIPCameraApplication").append(" : ").append("onProviderEnabled").toString());
        }

        public void onStatusChanged(String s1, int i1, Bundle bundle)
        {
        }

            
            {
                a = MagComposeActivity.this;
                super();
            }
    };
    SimpleDialogFragment k;
    ke l;
    private ProgressDialog m;
    private String n;
    private ArrayList o;
    private int p;
    private int q;
    private TPhotoMagComposeManager r;
    private qy s;
    private TPhotoComposeInfo t;
    private ArrayList u;
    private TabItemView v;
    private TabItemView w;
    private TabItemView x;
    private TabItemView y;
    private FrameLayout z;

    public MagComposeActivity()
    {
        n = "MagComposeActivity";
        o = null;
        p = 0;
        q = 0;
        s = null;
        u = null;
        G = null;
        g = -1;
        h = new Handler();
        J = 0;
        i = new Runnable() {

            final MagComposeActivity a;

            public void run()
            {
                a.a.setVisibility(8);
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        };
        l = new ke() {

            final MagComposeActivity a;

            public void a()
            {
                if (a.k != null)
                {
                    a.k.dismiss();
                    a.k = null;
                }
                FlurryAgent.logEvent("MagADBtnToWantuDownload");
                a.q();
            }

            public void b()
            {
                if (a.k != null)
                {
                    a.k.dismiss();
                    a.k = null;
                }
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        };
    }

    private int a(List list, int i1)
    {
        if (list != null)
        {
            for (int j1 = 0; j1 < list.size(); j1++)
            {
                if (((TPhotoComposeInfo)list.get(j1)).resId == i1)
                {
                    return j1;
                }
            }

        }
        return -1;
    }

    static FrameLayout a(MagComposeActivity magcomposeactivity)
    {
        return magcomposeactivity.D;
    }

    private void a(int i1, float f1, float f2)
    {
        int j1 = b.getLastVisiblePosition();
        int k1 = b.getFirstVisiblePosition();
        boolean flag = false;
        if (j1 - i1 > i1 - k1)
        {
            flag = true;
        }
        int l1 = b.getAdapter().getCount();
        if (flag)
        {
            if (i1 - 1 >= 0 && i1 - 1 <= k1)
            {
                i1 = (int)((float)(i1 - 1) * f2);
                b.scrollTo(i1);
            }
        } else
        if (i1 + 1 < l1 && i1 + 1 >= j1)
        {
            i1 = (int)(((float)(i1 + 1) * f2 - f1) + f2);
            b.scrollTo(i1);
            return;
        }
    }

    private void a(View view)
    {
        n();
    }

    private void a(View view, int i1, int j1, long l1, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, i1, j1);
            translateanimation.setDuration(l1);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

                final boolean a;
                final View b;
                final MagComposeActivity c;

                public void onAnimationEnd(Animation animation)
                {
                    if (a && b != null)
                    {
                        b.setVisibility(0);
                        return;
                    } else
                    {
                        b.setVisibility(4);
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                c = MagComposeActivity.this;
                a = flag;
                b = view;
                super();
            }
            });
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    static void a(MagComposeActivity magcomposeactivity, int i1)
    {
        magcomposeactivity.b(i1);
    }

    static void a(MagComposeActivity magcomposeactivity, int i1, float f1, float f2)
    {
        magcomposeactivity.a(i1, f1, f2);
    }

    static void a(MagComposeActivity magcomposeactivity, View view)
    {
        magcomposeactivity.b(view);
    }

    private void a(InstaMagType instamagtype)
    {
        ArrayList arraylist;
        if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
        {
            instamagtype = f().b(t.getInfoCollageType(), -1);
            if (PIPCameraApplication.a())
            {
                b(instamagtype, 105);
                b(instamagtype, 107);
            }
        } else
        {
            instamagtype = f().b(t.getInfoCollageType(), t.imageCount);
        }
        arraylist = new ArrayList(instamagtype.size());
        if (instamagtype != null && instamagtype.size() > 0)
        {
            for (int i1 = 0; i1 < instamagtype.size(); i1++)
            {
                arraylist.add((TPhotoComposeInfo)instamagtype.get(i1));
            }

        }
        c = new StyleListAdapter(this, u(), arraylist);
        b.setAdapter(c);
        if (t != null)
        {
            int j1 = a(((List) (arraylist)), t.resId);
            c.setSelectPosition(j1);
        }
    }

    private boolean a(String s1, String s2)
    {
        if (s1 == null)
        {
            return s2 == null;
        } else
        {
            return s1.equals(s2);
        }
    }

    private Location b(String s1)
    {
        Location location;
        Object obj;
        Object obj1;
        obj1 = null;
        location = null;
        obj = null;
        if (!f.isProviderEnabled(s1))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        Log.v("PIPCameraApplication", (new StringBuilder()).append("PIPCameraApplication").append(" : ").append("requestLocationUpdates").toString());
        location = f.getLastKnownLocation(s1);
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (!s1.equalsIgnoreCase("gps"))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        boolean flag;
        if ((new Date(System.currentTimeMillis())).getTime() - location.getTime() > 0xf731400L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        f.requestLocationUpdates(s1, 10000L, 10F, j);
        break MISSING_BLOCK_LABEL_192;
        f.requestLocationUpdates(s1, 10000L, 10F, j);
        return location;
        f.requestLocationUpdates(s1, 10000L, 10F, j);
        return location;
        s1;
        location = obj;
_L4:
        s1.printStackTrace();
        return location;
        s1;
        location = obj1;
_L2:
        s1.printStackTrace();
        return location;
        s1;
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        if (true) goto _L4; else goto _L3
_L3:
        return location;
    }

    static String b(MagComposeActivity magcomposeactivity)
    {
        return magcomposeactivity.n;
    }

    private void b(int i1)
    {
        if (b != null && b.getAdapter() != null)
        {
            StyleListAdapter stylelistadapter = (StyleListAdapter)b.getAdapter();
            if (i1 < stylelistadapter.getCount())
            {
                stylelistadapter.setSelectPosition(i1);
            }
        }
    }

    private void b(View view)
    {
        view = getSupportFragmentManager().findFragmentById(0x7f0c007b);
        if (view instanceof MagComposeFragement)
        {
            ((MagComposeFragement)view).i();
        }
    }

    static void b(MagComposeActivity magcomposeactivity, View view)
    {
        magcomposeactivity.a(view);
    }

    private void b(InstaMagType instamagtype)
    {
        w.setSelected(false);
        x.setSelected(false);
        y.setSelected(false);
        v.setSelected(false);
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            v.setSelected(true);
        } else
        {
            if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                w.setSelected(true);
                return;
            }
            if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                x.setSelected(true);
                return;
            }
            if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
            {
                y.setSelected(true);
                return;
            }
        }
    }

    private void b(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag = false;
        if (tphotocomposeinfo.getInfoCollageType() == CollageType.COLLAGE_COMIC)
        {
            if (y != null)
            {
                y.setVisibility(4);
            }
        } else
        if (y != null)
        {
            y.setVisibility(0);
        }
        if (tphotocomposeinfo.getInfoCollageType() == CollageType.COLLAGE_COMIC)
        {
            int i1;
            if (w != null)
            {
                i1 = f().a(CollageType.COLLAGE_COMIC, tphotocomposeinfo.imageCount);
                TabItemView tabitemview = w;
                if (i1 > 0)
                {
                    i1 = 0;
                } else
                {
                    i1 = 4;
                }
                tabitemview.setVisibility(i1);
            }
            if (x != null)
            {
                i1 = f().a(CollageType.COLLAGE_COMIC, tphotocomposeinfo.imageCount);
                tphotocomposeinfo = x;
                if (i1 > 0)
                {
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    i1 = 4;
                }
                tphotocomposeinfo.setVisibility(i1);
            }
        }
    }

    private void b(List list, int i1)
    {
        if (list != null && list != null && list.size() > 0)
        {
            int j1 = 0;
            while (j1 < list.size()) 
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(j1);
                if (tphotocomposeinfo.resId == i1)
                {
                    list.remove(tphotocomposeinfo);
                    return;
                }
                j1++;
            }
        }
    }

    private void c(View view)
    {
        if (view instanceof Button)
        {
            ((Button)view).setEnabled(false);
        }
        view = getSupportFragmentManager().findFragmentById(0x7f0c007b);
        if (view instanceof MagComposeFragement)
        {
            ((MagComposeFragement)view).g();
        }
    }

    static void c(MagComposeActivity magcomposeactivity)
    {
        magcomposeactivity.t();
    }

    static void c(MagComposeActivity magcomposeactivity, View view)
    {
        magcomposeactivity.c(view);
    }

    private void c(TPhotoComposeInfo tphotocomposeinfo)
    {
        byte byte0 = 4;
        if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
        {
            C.setVisibility(4);
        } else
        if (tphotocomposeinfo instanceof TPhotoComposeInfo)
        {
            Button button = C;
            if (tphotocomposeinfo.isHFlip || tphotocomposeinfo.isVFlip)
            {
                byte0 = 0;
            }
            button.setVisibility(byte0);
            return;
        }
    }

    private void d(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null)
        {
            c(tphotocomposeinfo);
            Log.d(n, (new StringBuilder()).append(n).append(" ").append(String.format("%d", new Object[] {
                Integer.valueOf(tphotocomposeinfo.resId)
            })).toString());
            Log.d(n, (new StringBuilder()).append(n).append(" ").append(tphotocomposeinfo.name).toString());
            if ((tphotocomposeinfo instanceof TPhotoComposeInfo) && (t == null || t.resId != tphotocomposeinfo.resId))
            {
                t = tphotocomposeinfo;
                tphotocomposeinfo = getSupportFragmentManager().findFragmentById(0x7f0c007b);
                if (tphotocomposeinfo instanceof MagComposeFragement)
                {
                    ((MagComposeFragement)tphotocomposeinfo).c();
                    return;
                } else
                {
                    tphotocomposeinfo = new MagComposeFragement();
                    getSupportFragmentManager().beginTransaction().replace(0x7f0c007b, tphotocomposeinfo).commit();
                    return;
                }
            }
        }
    }

    private void r()
    {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0c007b);
        if (fragment instanceof MagComposeFragement)
        {
            ((MagComposeFragement)fragment).f();
        }
    }

    private void s()
    {
        if (a.getVisibility() == 4 || a.getVisibility() == 8)
        {
            a.setVisibility(0);
            E.setVisibility(0);
            B.setBackgroundResource(0x7f02006a);
            ((android.widget.FrameLayout.LayoutParams)D.getLayoutParams()).bottomMargin = ew.a(this, 50F);
            D.requestLayout();
            ((android.widget.FrameLayout.LayoutParams)I.getLayoutParams()).bottomMargin = ew.a(this, 50F) + D.getHeight();
            I.requestLayout();
            a(I, D.getHeight(), 0, 250L, true);
            a(D, D.getHeight(), 0, 250L, true);
        }
    }

    private void t()
    {
        Log.e(n, "hideStyleView");
        if (a.getVisibility() == 0)
        {
            B.setBackgroundResource(0x7f02006b);
            ((android.widget.FrameLayout.LayoutParams)D.getLayoutParams()).bottomMargin = ew.a(this, 50F) - D.getHeight();
            D.requestLayout();
            ((android.widget.FrameLayout.LayoutParams)I.getLayoutParams()).bottomMargin = ew.a(this, 55F);
            I.requestLayout();
            a(I, -D.getHeight(), 0, 250L, true);
            a(D, -D.getHeight(), 0, 250L, true);
            (new Handler()).postDelayed(i, 250L);
        }
    }

    private qx u()
    {
        if (d == null)
        {
            fo fo1 = new fo(getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.PNG;
            fo1.a(0.05F);
            d = new qx(this, 200);
            d.a(getSupportFragmentManager(), fo1);
        }
        return d;
    }

    private void v()
    {
        Log.v("PIPCameraApplication", (new StringBuilder()).append("PIPCameraApplication").append(" : ").append("requestLocation").toString());
        if (f == null)
        {
            f = (LocationManager)getSystemService("location");
        }
        if (j == null);
        Location location = b("gps");
        Location location1 = b("network");
        if (location != null && location1 != null)
        {
            location = a(location, location1);
            PIPCameraApplication.d.a(location.getLatitude());
            PIPCameraApplication.d.b(location.getLongitude());
        } else
        {
            if (location != null)
            {
                PIPCameraApplication.d.a(location.getLatitude());
                PIPCameraApplication.d.b(location.getLongitude());
                return;
            }
            if (location1 != null)
            {
                PIPCameraApplication.d.a(location1.getLatitude());
                PIPCameraApplication.d.b(location1.getLongitude());
                return;
            }
        }
    }

    public void OnTypeEditClicked(View view)
    {
        r();
        J = J + 1;
        Log.e(n, (new StringBuilder()).append("OnTypeEditClicked ").append(a.getVisibility()).append(",,,").append(J).toString());
        if (a.getVisibility() == 4 || a.getVisibility() == 8)
        {
            s();
        }
    }

    protected Location a(Location location, Location location1)
    {
        boolean flag3 = true;
        if (location1 != null)
        {
            long l1 = location.getTime() - location1.getTime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l1 > 0x1d4c0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (l1 < 0xfffffffffffe2b40L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (l1 > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1)
            {
                if (flag2)
                {
                    return location1;
                }
                int i1 = (int)(location.getAccuracy() - location1.getAccuracy());
                boolean flag4;
                if (i1 > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (i1 < 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (i1 <= 200)
                {
                    flag3 = false;
                }
                flag4 = a(location.getProvider(), location1.getProvider());
                if (!flag2 && (!flag || flag1) && (!flag || flag3 || !flag4))
                {
                    return location1;
                }
            }
        }
        return location;
    }

    public void a()
    {
        p();
    }

    protected void a(int i1)
    {
        if (s != null)
        {
            s.b();
            TPhotoComposeInfo tphotocomposeinfo = e().getComposeInfoByResId(i1);
            Log.d(n, (new StringBuilder()).append(n).append(" loadNewDownloadInfo  newInfoId:").append(tphotocomposeinfo.resId).toString());
            d(tphotocomposeinfo);
            InstaMagType instamagtype = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
            b(instamagtype);
            a(instamagtype);
            b(tphotocomposeinfo);
        }
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo)
    {
    }

    protected void a(String s1)
    {
        while (m != null && m.isShowing() || isFinishing()) 
        {
            return;
        }
        try
        {
            m = ProgressDialog.show(this, "", s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Crashlytics.logException(s1);
        }
    }

    public void a(ArrayList arraylist)
    {
        if (u != null)
        {
            u.clear();
        }
        u = arraylist;
    }

    public void a(boolean flag)
    {
label0:
        {
            if (B != null)
            {
                if (!flag)
                {
                    break label0;
                }
                B.setVisibility(0);
                c(t);
            }
            return;
        }
        B.setVisibility(0);
        C.setVisibility(4);
    }

    protected void b()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MATERIAL_ADDED");
        registerReceiver(G, intentfilter);
    }

    public void c()
    {
        FotoAdFactory.createAdBanner(this, H);
    }

    protected void d()
    {
        if (m == null || !m.isShowing() || isFinishing())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        m.dismiss();
        m = null;
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    public TPhotoMagComposeManager e()
    {
        if (r == null)
        {
            r = kf.c().e();
        }
        return r;
    }

    public qy f()
    {
        if (s == null)
        {
            s = new qy();
            s.a();
        }
        return s;
    }

    public TPhotoComposeInfo g()
    {
        if (t == null)
        {
            t = e().getComposeInfoByResId(p);
        }
        return t;
    }

    public List h()
    {
        return o;
    }

    public ArrayList i()
    {
        return u;
    }

    public void j()
    {
        D.setVisibility(0);
        E.setVisibility(0);
    }

    public void k()
    {
        a(InstaMagType.RECT_LIB_SIZE_TYPE);
    }

    public void l()
    {
        a(InstaMagType.SQ_LIB_SIZE_TYPE);
    }

    public void m()
    {
        a(InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
    }

    public void n()
    {
        if (a.getVisibility() == 0)
        {
            t();
            return;
        } else
        {
            finish();
            overridePendingTransition(0x10a0002, 0x10a0003);
            return;
        }
    }

    public void o()
    {
        if (f != null && j != null)
        {
            Log.v("PIPCameraApplication", (new StringBuilder()).append("PIPCameraApplication").append(" : ").append("removeGPSLisenter").toString());
            f.removeUpdates(j);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030047);
        Log.v(n, (new StringBuilder()).append(n).append("onCreatepppppp").toString());
        if (bundle != null)
        {
            o = bundle.getStringArrayList("SelectedImageUriStrings");
            p = bundle.getInt("SelectedComposeInfoResId");
        } else
        {
            bundle = getIntent();
            if (bundle != null)
            {
                p = bundle.getIntExtra("SelectedComposeInfoResId", 0);
                o = bundle.getStringArrayListExtra("SelectedImageUriStrings");
            }
        }
        r = e();
        t = r.getComposeInfoByResId(p);
        if (t != null)
        {
            Log.v(n, (new StringBuilder()).append(n).append(" ").append("resId:").append(t.resId).toString());
        }
        E = (FrameLayout)findViewById(0x7f0c0144);
        E.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MagComposeActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (MagComposeActivity.a(a).getVisibility() == 0)
                {
                    Log.e(MagComposeActivity.b(a), "maskLayout ONtoUCH");
                    MagComposeActivity.c(a);
                }
                return false;
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        });
        H = findViewById(0x7f0c0055);
        D = (FrameLayout)findViewById(0x7f0c0145);
        bundle = new MagComposeFragement();
        getSupportFragmentManager().beginTransaction().replace(0x7f0c007b, bundle).commit();
        F = (FrameLayout)findViewById(0x7f0c012b);
        B = (Button)findViewById(0x7f0c0141);
        C = (Button)findViewById(0x7f0c0143);
        z = (FrameLayout)findViewById(0x7f0c012c);
        A = (FrameLayout)findViewById(0x7f0c013e);
        I = (FrameLayout)findViewById(0x7f0c0140);
        C.setOnClickListener(new android.view.View.OnClickListener() {

            final MagComposeActivity a;

            public void onClick(View view)
            {
                MagComposeActivity.a(a, view);
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        });
        z.setOnClickListener(new android.view.View.OnClickListener() {

            final MagComposeActivity a;

            public void onClick(View view)
            {
                MagComposeActivity.b(a, view);
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        });
        A.setOnClickListener(new android.view.View.OnClickListener() {

            final MagComposeActivity a;

            public void onClick(View view)
            {
                MagComposeActivity.c(a, view);
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        });
        a = (TStyleCollectionView)findViewById(0x7f0c0146);
        e = (ImageView)a.findViewById(0x7f0c0175);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final MagComposeActivity a;

            public void onClick(View view)
            {
                a.a();
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        });
        b = (HorizontalListView)a.findViewById(0x7f0c0162);
        b.setOnItemClickListener(this);
        bundle = TPhotoComposeInfo.getInstaMagType(t);
        if (bundle == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            k();
        } else
        if (bundle == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            l();
        } else
        if (bundle == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            m();
        }
        c(t);
        G = new BroadcastReceiver() {

            final MagComposeActivity a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append("BroadcastReceiver on receiver").toString());
                if (context != null && context.equalsIgnoreCase("ACTION_MATERIAL_ADDED") && intent.getStringExtra("TYPE_MATERIAL") != null && intent.getStringExtra("TYPE_MATERIAL").equalsIgnoreCase(tu.getStringByResType(EOnlineResType.MAG_MASK_INFO)))
                {
                    int i1 = intent.getIntExtra("INSTAMAG_RESID", -1);
                    int j1 = intent.getIntExtra("INSTAMAG_IMAGE_COUNT", -1);
                    Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver resid:").append(i1).toString());
                    Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver imagecount:").append(j1).toString());
                    if (j1 == a.h().size())
                    {
                        a.g = i1;
                        Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver _needResetrid:").append(a.g).toString());
                    }
                }
            }

            
            {
                a = MagComposeActivity.this;
                super();
            }
        };
        b();
        b(t);
    }

    protected void onDestroy()
    {
        d();
        if (u != null)
        {
            for (Iterator iterator = u.iterator(); iterator.hasNext(); iterator.remove())
            {
                Bitmap bitmap = (Bitmap)iterator.next();
                if (bitmap != null && !bitmap.isRecycled())
                {
                    Log.v(n, (new StringBuilder()).append(n).append(" onDestroy recycle bitmap").toString());
                    bitmap.recycle();
                }
            }

        }
        o();
        unregisterReceiver(G);
        super.onDestroy();
        Log.v(n, (new StringBuilder()).append(n).append("onDestroy").toString());
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        float f2 = 0.0F;
        if (c != null && c.getItem(i1) != null && (c.getItem(i1) instanceof TPhotoComposeInfo))
        {
            float f1;
            if (adapterview != null && view != null)
            {
                f1 = adapterview.getWidth();
                f2 = view.getWidth();
            } else
            {
                f1 = 0.0F;
            }
            h.post(new Runnable(i1, i1, f1, f2) {

                final int a;
                final int b;
                final float c;
                final float d;
                final MagComposeActivity e;

                public void run()
                {
                    MagComposeActivity.a(e, a);
                    MagComposeActivity.a(e, b, c, d);
                }

            
            {
                e = MagComposeActivity.this;
                a = i1;
                b = j1;
                c = f1;
                d = f2;
                super();
            }
            });
            adapterview = (TPhotoComposeInfo)c.getItem(i1);
            if (adapterview != null)
            {
                Log.d(n, (new StringBuilder()).append(n).append("selected info resid:").append(((TPhotoComposeInfo) (adapterview)).resId).toString());
                if (adapterview instanceof TPhotoComposeInfo)
                {
                    if (!e().isExistedByResId(((TPhotoComposeInfo) (adapterview)).resId) && !(adapterview instanceof TPhotoLinkComposeInfo))
                    {
                        a(adapterview);
                        return;
                    }
                    d(adapterview);
                    adapterview = TPhotoComposeInfo.getInstaMagType(adapterview);
                    if (adapterview == InstaMagType.RECT_LIB_SIZE_TYPE)
                    {
                        i1 = 0;
                    } else
                    if (adapterview == InstaMagType.SQ_LIB_SIZE_TYPE)
                    {
                        i1 = 1;
                    } else
                    if (adapterview == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
                    {
                        i1 = 2;
                    } else
                    {
                        i1 = 0;
                    }
                    adapterview = getSharedPreferences("config", 0).edit();
                    adapterview.putInt("lastTypeInt", i1);
                    adapterview.commit();
                    return;
                }
            }
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            n();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onResume()
    {
        Log.v(n, (new StringBuilder()).append(n).append(" onResume").toString());
        super.onResume();
        if (A != null)
        {
            A.setEnabled(true);
        }
        if (pb.a(this, es.b))
        {
            if (e != null)
            {
                e.setVisibility(8);
            } else
            {
                e.setVisibility(0);
            }
        }
        if (g > 0)
        {
            int i1 = g;
            g = -1;
            a(i1);
        }
        c();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SelectedComposeInfoResId", p);
        bundle.putStringArrayList("SelectedImageUriStrings", o);
    }

    public void onStart()
    {
        super.onStart();
        Log.v(n, (new StringBuilder()).append(n).append(" onStart").toString());
        if (!PIPCameraApplication.f)
        {
            v();
        }
    }

    public void onStop()
    {
        super.onStop();
        Log.v(n, (new StringBuilder()).append(n).append(" onStop").toString());
        o();
    }

    public void p()
    {
        FlurryAgent.logEvent("MagADBtnToWantuShow");
        if (k != null) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        k = new SimpleDialogFragment();
        s2 = "Download FotoRus to get more styles.";
        s1 = "Get";
        if (!pb.b()) goto _L4; else goto _L3
_L3:
        s2 = "\u4E0B\u8F7D\u201C\u73A9\u56FE-\u5168\u80FD\u7F8E\u5316\u201D\uFF0C\u4F53\u9A8C\u66F4\u591A\u7D20\u6750\u3002";
        s1 = "\u4E0B\u8F7D";
_L6:
        k.a(true);
        k.c(s1);
        k.a(getResources().getString(0x7f060277));
        k.b(s2);
        k.a(l);
        k.show(getSupportFragmentManager(), n);
_L2:
        return;
_L4:
        if (pb.c())
        {
            s2 = "\u4E0B\u8F09\u201C\u73A9\u5716-\u5168\u80FD\u7F8E\u5316\u201D\uFF0C\u9AD4\u9A57\u66F4\u591A\u7D20\u6750\u3002";
            s1 = "\u4E0B\u8F09";
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void q()
    {
        Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
        if (pb.a())
        {
            intent.putExtra("webUriString", kf.d);
        } else
        {
            intent.putExtra("webUriString", kf.e);
        }
        startActivity(intent);
    }
}
