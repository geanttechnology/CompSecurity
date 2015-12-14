// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import com.instamag.activity.commonview.MagFilterActionBar;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.TResInfo;
import es;
import fo;
import fq;
import ix;
import ja;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc;
import kf;
import pb;
import qn;
import qy;
import tu;
import up;

// Referenced classes of package com.instamag.activity.lib:
//            MagLocalListViewdapter, MagLibActivity

public class LocalLibFragement extends Fragment
    implements android.widget.AbsListView.OnScrollListener
{

    protected MagLocalListViewdapter a;
    protected ArrayList b;
    protected MagLibActivity c;
    int d;
    qn e;
    private String f;
    private fq g;
    private fq h;
    private qy i;
    private ListView j;
    private BroadcastReceiver k;
    private Boolean l;
    private int m;
    private MagFilterActionBar n;
    private android.widget.FrameLayout.LayoutParams o;
    private android.widget.FrameLayout.LayoutParams p;
    private Button q;
    private FrameLayout r;
    private boolean s;

    public LocalLibFragement()
    {
        f = "LocalLibFragement";
        b = new ArrayList(0);
        h = null;
        k = null;
        l = Boolean.valueOf(false);
        m = 0;
        d = 0;
        s = false;
        e = null;
    }

    static Boolean a(LocalLibFragement locallibfragement, Boolean boolean1)
    {
        locallibfragement.l = boolean1;
        return boolean1;
    }

    static String a(LocalLibFragement locallibfragement)
    {
        return locallibfragement.f;
    }

    private void a(FotoNativeIcon fotonativeicon)
    {
        if (a != null && j != null)
        {
            b(fotonativeicon);
            a.setItemList(b);
            a.setItemNativeAd(fotonativeicon);
            a.notifyDataSetChanged();
        }
    }

    static void a(LocalLibFragement locallibfragement, FotoNativeIcon fotonativeicon)
    {
        locallibfragement.a(fotonativeicon);
    }

    private void b(FotoNativeIcon fotonativeicon)
    {
        if (s)
        {
            TPhotoComposeInfo tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.imageCount = 1;
            tphotocomposeinfo.resId = TPhotoMagComposeManager.KFBNATIVEID;
            tphotocomposeinfo.rid = TPhotoMagComposeManager.KFBNATIVEID;
            tphotocomposeinfo.backgroundColor = 0;
            tphotocomposeinfo.icon = fotonativeicon.nativeItem.b();
            tphotocomposeinfo.name = "fb native ad";
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 480F;
            if (b != null && b.size() >= 0)
            {
                fotonativeicon = b.iterator();
                do
                {
                    if (!fotonativeicon.hasNext())
                    {
                        break;
                    }
                    TResInfo tresinfo = (TResInfo)fotonativeicon.next();
                    if (tresinfo.resId != TPhotoMagComposeManager.KFBNATIVEID)
                    {
                        continue;
                    }
                    b.remove(tresinfo);
                    break;
                } while (true);
                b.add(0, tphotocomposeinfo);
            }
        }
    }

    static void b(LocalLibFragement locallibfragement)
    {
        locallibfragement.g();
    }

    static qy c(LocalLibFragement locallibfragement)
    {
        return locallibfragement.i;
    }

    static MagFilterActionBar d(LocalLibFragement locallibfragement)
    {
        return locallibfragement.n;
    }

    private fq d()
    {
        if (h == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            fo1.a(0.05F);
            h = new up(getActivity(), b());
            h.a(getActivity().getSupportFragmentManager(), fo1);
        }
        return h;
    }

    private void e()
    {
        try
        {
            s = true;
            ix.b(getActivity()).loadNativeAd(FotoAdMediationDB.getFBResIconAdID(getActivity()), new ja() {

                final LocalLibFragement a;

                public void adIconFailed()
                {
                    FlurryAgent.logEvent("FBNatice_PIPMagResIcon_Failed");
                }

                public void adIconLoaded(FotoNativeIcon fotonativeicon)
                {
                    Log.e(LocalLibFragement.a(a), (new StringBuilder()).append(LocalLibFragement.a(a)).append(" fbnative ad loaded").toString());
                    LocalLibFragement.a(a, fotonativeicon);
                    FlurryAgent.logEvent("FBNatice_PIPMagResIcon_Loaded");
                }

            
            {
                a = LocalLibFragement.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    private void f()
    {
        if (!NativeAdWrapper.needFBNative(getActivity()))
        {
            return;
        }
        try
        {
            if (kf.a(getActivity(), "com.facebook.katana"))
            {
                e();
                return;
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
    }

    private void g()
    {
        l = Boolean.valueOf(true);
        if (i != null)
        {
            i.b();
            m = 0;
        }
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MATERIAL_ADDED");
        intentfilter.addAction("ACTION_MATERIAL_REMOVE");
        intentfilter.addAction("ACTION_MATERIAL_CHANGE");
        c.registerReceiver(k, intentfilter);
    }

    public void a(int i1)
    {
        j.setSelection(i1);
    }

    public void a(InstaMagType instamagtype, int i1)
    {
        if (i != null)
        {
            b.clear();
            instamagtype = i.a(CollageType.COLLAGE_MAGZINE, instamagtype, i1);
            i1 = 0;
            while (i1 < instamagtype.size()) 
            {
                TResInfo tresinfo = (TResInfo)instamagtype.get(i1);
                if (!pb.a(PIPCameraApplication.a, es.b) || tresinfo.resId >= TPhotoMagComposeManager.KMAXADRESID)
                {
                    b.add(tresinfo);
                }
                i1++;
            }
        }
        Log.v(f, String.format("%d", new Object[] {
            Integer.valueOf(b.size())
        }));
        a.setItemList(b);
        j.setSelection(0);
        if (n != null)
        {
            n.refreshIndex();
        }
    }

    public void a(qn qn)
    {
        e = qn;
        if (a != null)
        {
            a.setMagLibCellClickedLisener(qn);
        }
    }

    public int b()
    {
        return 320;
    }

    public void c()
    {
        if (getActivity() != null)
        {
            getActivity().finish();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = (MagLibActivity)activity;
        Log.d(f, "onAttach");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.v(f, (new StringBuilder()).append(f).append(" onCreate").toString());
        g = d();
        a = new MagLocalListViewdapter(getActivity(), b, g);
        if (e != null)
        {
            a.setMagLibCellClickedLisener(e);
        }
        i = new qy();
        i.a();
        k = new BroadcastReceiver() {

            final LocalLibFragement a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                Log.v(LocalLibFragement.a(a), (new StringBuilder()).append(LocalLibFragement.a(a)).append("BroadcastReceiver on receiver").toString());
                if (context == null || !context.equalsIgnoreCase("ACTION_MATERIAL_ADDED")) goto _L2; else goto _L1
_L1:
                if (intent.getStringExtra("TYPE_MATERIAL") != null && intent.getStringExtra("TYPE_MATERIAL").equalsIgnoreCase(tu.getStringByResType(EOnlineResType.MAG_MASK_INFO)))
                {
                    LocalLibFragement.b(a);
                }
_L4:
                return;
_L2:
                if (context == null || !context.equalsIgnoreCase("ACTION_MATERIAL_CHANGE"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                LocalLibFragement.a(a, Boolean.valueOf(true));
                if (LocalLibFragement.c(a) == null) goto _L4; else goto _L3
_L3:
                LocalLibFragement.c(a).b();
                return;
                if (context == null || !context.equalsIgnoreCase("ACTION_MATERIAL_REMOVE") || LocalLibFragement.c(a) == null) goto _L4; else goto _L5
_L5:
                LocalLibFragement.b(a);
                return;
            }

            
            {
                a = LocalLibFragement.this;
                super();
            }
        };
        a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.v(f, (new StringBuilder()).append(f).append(" onCreateView").toString());
        layoutinflater = layoutinflater.inflate(0x7f03004a, viewgroup, false);
        n = (MagFilterActionBar)layoutinflater.findViewById(0x7f0c0158);
        n.setListView(j);
        r = (FrameLayout)layoutinflater.findViewById(0x7f0c012c);
        r.setOnClickListener(new android.view.View.OnClickListener() {

            final LocalLibFragement a;

            public void onClick(View view)
            {
                a.c();
            }

            
            {
                a = LocalLibFragement.this;
                super();
            }
        });
        q = (Button)layoutinflater.findViewById(0x7f0c0153);
        o = (android.widget.FrameLayout.LayoutParams)q.getLayoutParams();
        p = new android.widget.FrameLayout.LayoutParams(50, 50);
        p.height = (o.height * 64) / 88;
        p.width = (o.width * 64 * 5) / 8 / 88;
        p.gravity = 21;
        q.setOnClickListener(new android.view.View.OnClickListener() {

            final LocalLibFragement a;

            public void onClick(View view)
            {
                if (LocalLibFragement.d(a).getVisibility() == 4)
                {
                    LocalLibFragement.d(a).setVisibility(0);
                    view = new AlphaAnimation(0.0F, 1.0F);
                    view.setDuration(200L);
                    LocalLibFragement.d(a).startAnimation(view);
                    return;
                } else
                {
                    view = new AlphaAnimation(1.0F, 0.0F);
                    view.setDuration(200L);
                    LocalLibFragement.d(a).startAnimation(view);
                    LocalLibFragement.d(a).setVisibility(4);
                    return;
                }
            }

            
            {
                a = LocalLibFragement.this;
                super();
            }
        });
        f();
        j = (ListView)layoutinflater.findViewById(0x7f0c0156);
        j.setAdapter(a);
        j.setOnScrollListener(this);
        if (g != null)
        {
            g.a(android.graphics.Bitmap.CompressFormat.JPEG);
        }
        if (i != null && a != null)
        {
            a(((InstaMagType) (null)), -1);
        }
        n.setListView(j);
        viewgroup = (RelativeLayout)layoutinflater.findViewById(0x7f0c0154);
        if (viewgroup != null)
        {
            viewgroup.setVisibility(8);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        c.unregisterReceiver(k);
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        Log.d(f, "onPause");
        if (g != null)
        {
            g.a(true);
        }
    }

    public void onResume()
    {
        Log.v(f, (new StringBuilder()).append(f).append(" onresume").toString());
        super.onResume();
        if (g != null)
        {
            g.a(false);
        }
        if (l.booleanValue())
        {
            a(((InstaMagType) (null)), -1);
            l = Boolean.valueOf(false);
            a(m);
        }
        FotoAdFactory.createAdBanner(getActivity(), getView());
    }

    public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
    {
        if (n.getVisibility() == 0)
        {
            n.setVisibility(4);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i1)
    {
    }
}
