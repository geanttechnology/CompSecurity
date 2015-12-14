// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.fragment;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import apq;
import bbs;
import bck;
import bcl;
import bcm;
import bda;
import bdb;
import bdz;
import com.fotoable.comlib.util.ImageCache;
import com.instamag.activity.library.view.MaglibItemView;
import com.instamag.activity.library.view.waterfall.WaterFall;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.photoselector.InstaPhotoSelectorActivity;
import java.util.ArrayList;
import zr;

public class NewMagListFragment extends Fragment
{

    private WaterFall a;
    private bdb b;
    private bcm c;
    private ArrayList d;
    private bda e;
    private bdz f;
    private BroadcastReceiver g;
    private boolean h;

    public NewMagListFragment()
    {
        d = new ArrayList();
        e = null;
    }

    public static void a(NewMagListFragment newmaglistfragment)
    {
        newmaglistfragment.e();
    }

    public static void a(NewMagListFragment newmaglistfragment, TPhotoComposeInfo tphotocomposeinfo)
    {
        newmaglistfragment.a(tphotocomposeinfo);
    }

    private void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo == null || getActivity() == null)
        {
            return;
        } else
        {
            Intent intent = new Intent(getActivity(), com/wantu/activity/photoselector/InstaPhotoSelectorActivity);
            intent.putExtra("SelectedComposeInfoResId", tphotocomposeinfo.resId);
            intent.putExtra("SelectedComposeInfoImageCount", tphotocomposeinfo.imageCount);
            getActivity().startActivity(intent);
            return;
        }
    }

    public static boolean a(NewMagListFragment newmaglistfragment, boolean flag)
    {
        newmaglistfragment.h = flag;
        return flag;
    }

    private bdz c()
    {
        if (f == null)
        {
            f = new bcl(this);
        }
        return f;
    }

    private bda d()
    {
        if (e == null)
        {
            zr zr1 = new zr(getActivity(), ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.a(0.05F);
            e = new bda(getActivity(), 320);
            e.a(getActivity().getSupportFragmentManager(), zr1);
        }
        return e;
    }

    private void e()
    {
        if (a != null)
        {
            ArrayList arraylist = a.getVisiableViews();
            if (arraylist != null && arraylist.size() > 0)
            {
                Log.v("NewMagListFragment", (new StringBuilder()).append("NewMagListFragment visible Count\uFF1A").append(arraylist.size()).toString());
                for (int i = 0; i < arraylist.size(); i++)
                {
                    Object obj = (View)arraylist.get(i);
                    if (obj != null && (obj instanceof MaglibItemView))
                    {
                        obj = (MaglibItemView)obj;
                        ((MaglibItemView) (obj)).refreshUIByData(((MaglibItemView) (obj)).getDataItem());
                    }
                }

            }
        }
    }

    protected void a()
    {
        if (g == null)
        {
            g = new bck(this);
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
            getActivity().registerReceiver(g, intentfilter);
        }
    }

    public void b()
    {
        if (g != null)
        {
            getActivity().unregisterReceiver(g);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i = getArguments().getInt("FRAGMENT_INDEX");
        if (c != null)
        {
            d = c.a(i);
        }
        a();
        f = c();
        b = new bdb(getActivity(), d, d(), f);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = (WaterFall)layoutinflater.inflate(0x7f030063, viewgroup, false).findViewById(0x7f0d00af);
        a.setColumn(3);
        a.setMarginWidth(bbs.a());
        a.setAdapter(b);
        return a;
    }

    public void onDestroy()
    {
        b();
        super.onDestroy();
    }

    public void onPause()
    {
        Log.v("NewMagListFragment", "NewMagListFragment onPause");
        super.onPause();
        if (e != null)
        {
            e.a(true);
        }
    }

    public void onResume()
    {
        Log.v("NewMagListFragment", "NewMagListFragment onresume");
        super.onResume();
        if (e != null)
        {
            e.a(false);
        }
    }

    public void onStop()
    {
        if (h)
        {
            h = false;
            apq.c().d().asynArchive();
        }
        super.onStop();
    }
}
