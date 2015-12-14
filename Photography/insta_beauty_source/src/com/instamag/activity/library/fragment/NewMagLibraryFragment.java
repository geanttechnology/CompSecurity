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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import apq;
import bci;
import bcj;
import bda;
import bdz;
import com.fotoable.comlib.util.ImageCache;
import com.instamag.activity.library.view.LibraryExpandableListView;
import com.instamag.common.CollageType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.photoselector.InstaPhotoSelectorActivity;
import java.util.ArrayList;
import java.util.List;
import zr;

public class NewMagLibraryFragment extends Fragment
{

    public LibraryExpandableListView a;
    CollageType b;
    bda c;
    int d;
    List e;
    private BroadcastReceiver f;
    private boolean g;
    private bdz h;

    public NewMagLibraryFragment()
    {
        g = false;
        e = new ArrayList();
        h = new bci(this);
    }

    public static void a(NewMagLibraryFragment newmaglibraryfragment, TPhotoComposeInfo tphotocomposeinfo)
    {
        newmaglibraryfragment.a(tphotocomposeinfo);
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

    public static boolean a(NewMagLibraryFragment newmaglibraryfragment, boolean flag)
    {
        newmaglibraryfragment.g = flag;
        return flag;
    }

    private bda c()
    {
        if (c == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.a(0.05F);
            c = new bda(getActivity(), 320);
            c.a(getActivity().getSupportFragmentManager(), zr1);
        }
        return c;
    }

    protected void a()
    {
        if (f == null)
        {
            f = new bcj(this);
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
            getActivity().registerReceiver(f, intentfilter);
        }
    }

    public void b()
    {
        if (f != null)
        {
            getActivity().unregisterReceiver(f);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle.getInt("FRAGMENT_INDEX") == 0)
        {
            b = CollageType.COLLAGE_MAGZINE;
        } else
        {
            b = CollageType.COLLAGE_COMIC;
        }
        d = bundle.getInt("FRAGMENT_TRESTYPE_INDEX");
        a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = null;
        a.setDivider(null);
        a.setItemClickLisener(h);
        a.initWithCollageType(d, c());
        if (e != null && e.size() > 0)
        {
            a.addOnlineList(e);
        }
        return null;
    }

    public void onDestroy()
    {
        b();
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        if (c != null)
        {
            c.a(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (c != null)
        {
            c.a(false);
        }
    }

    public void onStop()
    {
        if (g)
        {
            g = false;
            apq.c().d().asynArchive();
        }
        super.onStop();
    }
}
