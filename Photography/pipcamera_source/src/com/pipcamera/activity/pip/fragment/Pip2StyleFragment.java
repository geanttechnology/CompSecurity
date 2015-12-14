// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.fotoable.ad.FotoAdFactory;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.activity.MainResourceActivity;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneCatalog;
import com.wantu.piprender.ESceneMode;
import com.wantu.view.TPipStyleListScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pb;
import so;
import sp;
import tu;
import tv;
import tw;
import wantu.sephiroth.android.library.imagezoom.ImageViewTouch;
import wantu.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import yf;
import yy;

public class Pip2StyleFragment extends Fragment
    implements sp, tw, yy
{

    private TPipStyleListScrollView a;
    private ImageViewTouch b;
    private ImageView c;
    private int d;
    private Button e;
    private Button f;
    private Pip2FragmentActivity g;
    private TDFSceneInfo h;
    private Button i;
    private BroadcastReceiver j;
    private tv k;
    private RelativeLayout l;

    public Pip2StyleFragment()
    {
        j = null;
    }

    static Button a(Pip2StyleFragment pip2stylefragment)
    {
        return pip2stylefragment.i;
    }

    public static Pip2StyleFragment a(String s)
    {
        Pip2StyleFragment pip2stylefragment = new Pip2StyleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SelectedImageUri", s);
        pip2stylefragment.setArguments(bundle);
        return pip2stylefragment;
    }

    private void a(View view)
    {
        e = (Button)view.findViewById(0x7f0c0080);
        f = (Button)view.findViewById(0x7f0c007f);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final Pip2StyleFragment a;

            public void onClick(View view1)
            {
                Pip2StyleFragment.a(a, view1);
            }

            
            {
                a = Pip2StyleFragment.this;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final Pip2StyleFragment a;

            public void onClick(View view1)
            {
                Pip2StyleFragment.b(a, view1);
            }

            
            {
                a = Pip2StyleFragment.this;
                super();
            }
        });
        Object obj = getResources().getDisplayMetrics();
        FrameLayout framelayout = (FrameLayout)view.findViewById(0x7f0c01e4);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)framelayout.getLayoutParams();
        layoutparams.width = ((DisplayMetrics) (obj)).widthPixels;
        layoutparams.height = ((DisplayMetrics) (obj)).widthPixels;
        framelayout.setLayoutParams(layoutparams);
        b = (ImageViewTouch)view.findViewById(0x7f0c013b);
        b.setFitToScreen(true);
        a = (TPipStyleListScrollView)view.findViewById(0x7f0c01ec);
        a.setVisibility(0);
        obj = g.j().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        ((List) (obj)).iterator();
        TDFSceneInfo tdfsceneinfo1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.addPipItem(tdfsceneinfo1))
        {
            tdfsceneinfo1 = (TDFSceneInfo)((Iterator) (obj)).next();
        }

        a.setCallback(this);
        h = g.k();
        if (h == null) goto _L2; else goto _L1
_L1:
        if (h.getName() != null)
        {
            a.setItemSelected(h.resId, Boolean.valueOf(true));
        }
_L4:
        c = (ImageView)view.findViewById(0x7f0c01f2);
        if (g.i() == null)
        {
            g.d(g.a(h));
        }
        c.setImageBitmap(g.i());
        if (g.h() != null)
        {
            b.setImageBitmap(g.h());
        }
        i = (Button)view.findViewById(0x7f0c01f4);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final Pip2StyleFragment a;

            public void onClick(View view1)
            {
                Pip2StyleFragment.c(a, view1);
            }

            
            {
                a = Pip2StyleFragment.this;
                super();
            }
        });
        return;
_L2:
        TDFSceneInfo tdfsceneinfo = g.j().a(0, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        if (tdfsceneinfo != null && tdfsceneinfo.getName() != null)
        {
            a.setItemSelected(tdfsceneinfo.resId, Boolean.valueOf(true));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(Pip2StyleFragment pip2stylefragment, int i1)
    {
        pip2stylefragment.b(i1);
    }

    static void a(Pip2StyleFragment pip2stylefragment, View view)
    {
        pip2stylefragment.nextBtnClicked(view);
    }

    private Bitmap b()
    {
        return b.getDispalyImage(612, 612);
    }

    static TPipStyleListScrollView b(Pip2StyleFragment pip2stylefragment)
    {
        return pip2stylefragment.a;
    }

    private void b(int i1)
    {
label0:
        {
            if (a != null)
            {
                a.removeAllItems();
                g.a(null);
                Object obj = g.j().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
                ((List) (obj)).iterator();
                TDFSceneInfo tdfsceneinfo1;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.addPipItem(tdfsceneinfo1))
                {
                    tdfsceneinfo1 = (TDFSceneInfo)((Iterator) (obj)).next();
                }

                a.setCallback(this);
                if (i1 >= 0)
                {
                    break label0;
                }
                obj = g.j().a(0, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
                if (obj != null && ((TDFSceneInfo) (obj)).getName() != null)
                {
                    a.setItemSelected(((TDFSceneInfo) (obj)).resId, Boolean.valueOf(true));
                }
                a(((TDFSceneInfo) (obj)));
            }
            return;
        }
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.resId = i1;
        i1 = g.j().b(tdfsceneinfo, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        tdfsceneinfo = g.j().a(i1, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        a.setItemSelected(tdfsceneinfo.resId, Boolean.valueOf(true));
        g.a(i1);
        a(tdfsceneinfo);
    }

    private void b(View view)
    {
        view = new Intent(g, com/wantu/ResourceOnlineLibrary/activity/MainResourceActivity);
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(tu.getStringByResType(EOnlineResType.PIP_SCENE2));
        view.putStringArrayListExtra("MainResourceActivity_MaterialTypes", arraylist);
        startActivity(view);
        i.setBackgroundResource(0x7f0200b3);
    }

    static void b(Pip2StyleFragment pip2stylefragment, View view)
    {
        pip2stylefragment.backBtnClicked(view);
    }

    private void backBtnClicked(View view)
    {
        if (g != null)
        {
            g.d();
        }
    }

    static Pip2FragmentActivity c(Pip2StyleFragment pip2stylefragment)
    {
        return pip2stylefragment.g;
    }

    static void c(Pip2StyleFragment pip2stylefragment, View view)
    {
        pip2stylefragment.b(view);
    }

    private void nextBtnClicked(View view)
    {
        if (g != null)
        {
            view = b();
            if (view == null)
            {
                Log.e("Pip2styleFragment makeresult image is null", "Pip2styleFragment makeresult image is null");
            }
            g.b(view);
            g.e();
        }
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MATERIAL_ADDED");
        intentfilter.addAction("ACTION_MATERIAL_REMOVE");
        g.registerReceiver(j, intentfilter);
    }

    public void a(int i1)
    {
        g.a();
    }

    public void a(TDFSceneInfo tdfsceneinfo)
    {
        h = tdfsceneinfo;
        c.setImageBitmap(null);
        g.d(null);
        Bitmap bitmap = g.a(tdfsceneinfo);
        g.d(bitmap);
        c.setImageBitmap(bitmap);
        d = g.j().b(tdfsceneinfo, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        g.a(d);
        Log.v("mindex", String.format("%d", new Object[] {
            Integer.valueOf(d)
        }));
    }

    public void a(ArrayList arraylist, int i1)
    {
        g.b();
        if (arraylist.size() > 0)
        {
            arraylist = (Bitmap)arraylist.get(0);
            g.c(arraylist);
            if (b != null)
            {
                b.setImageBitmap(arraylist);
            }
        }
    }

    public void a(HashMap hashmap)
    {
_L2:
        return;
        if (!isAdded() || i == null) goto _L2; else goto _L1
_L1:
        if (hashmap != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v("OnlineChecker ", "OnlineCheck dict is null");
        if (getActivity() != null)
        {
            i.setBackgroundResource(0x7f0200b3);
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        Boolean boolean1 = Boolean.valueOf(false);
        if (tv.a(EOnlineResType.PIP_SCENE2, hashmap).booleanValue())
        {
            boolean1 = Boolean.valueOf(true);
        }
        if (!boolean1.booleanValue())
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v("OnlineChecker ", "has new online materials");
        if (getActivity() != null)
        {
            i.setBackgroundResource(0x7f0200b4);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        Log.v("OnlineChecker ", "has no online materials");
        if (getActivity() != null)
        {
            i.setBackgroundResource(0x7f0200b3);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = (Pip2FragmentActivity)getActivity();
        if (getArguments() == null)
        {
            Log.e("Pip2StyleFragment", "getArguments() is null");
        }
        bundle = Uri.parse(getArguments().getString("SelectedImageUri"));
        so so1 = new so();
        ArrayList arraylist = new ArrayList();
        arraylist.add(bundle);
        so1.a(arraylist);
        so1.a(this);
        so1.a(1000);
        so1.c(new ArrayList[0]);
        j = new BroadcastReceiver() {

            final Pip2StyleFragment a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                Log.v("Pip2StyleFragment", "Pip2StyleFragmentBroadcastReceiver on receiver");
                if (context != null && intent.getStringExtra("TYPE_MATERIAL") != null)
                {
                    context = intent.getStringExtra("TYPE_MATERIAL");
                    int i1 = intent.getIntExtra("RESID_MATERIAL", 0);
                    if (context.equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE2)))
                    {
                        Pip2StyleFragment.a(a, i1);
                    }
                }
            }

            
            {
                a = Pip2StyleFragment.this;
                super();
            }
        };
        a();
        k = new tv();
        k.a(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006f, viewgroup, false);
        l = (RelativeLayout)layoutinflater.findViewById(0x7f0c01f5);
        a(layoutinflater);
        i.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final Pip2StyleFragment a;

            public void onGlobalLayout()
            {
                Pip2StyleFragment.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (Pip2StyleFragment.a(a) != null)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = Pip2StyleFragment.a(a).getLayoutParams();
                    if (layoutparams != null)
                    {
                        Log.v("height:", (new StringBuilder()).append("Pip2StyleFragment:").append(Pip2StyleFragment.b(a).getLayoutParams().height).append("").toString());
                        layoutparams.height = Pip2StyleFragment.b(a).getHeight() - pb.a(Pip2StyleFragment.c(a), 14F);
                        layoutparams.width = Pip2StyleFragment.b(a).getHeight() - pb.a(Pip2StyleFragment.c(a), 14F);
                        Pip2StyleFragment.a(a).setLayoutParams(layoutparams);
                    }
                }
            }

            
            {
                a = Pip2StyleFragment.this;
                super();
            }
        });
        viewgroup = new ArrayList(1);
        viewgroup.add(tu.getStringByResType(EOnlineResType.PIP_SCENE2));
        k.a(viewgroup);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        g.unregisterReceiver(j);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        if (b != null)
        {
            b.setFitToScreen(true);
        }
        if (l != null)
        {
            l.setTag("bannerRelative");
            FotoAdFactory.createAdBanner(getActivity(), l);
        }
        super.onResume();
    }
}
