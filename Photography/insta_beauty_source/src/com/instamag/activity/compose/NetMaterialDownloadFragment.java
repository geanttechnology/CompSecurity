// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.compose;

import aaj;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import bbj;
import bbk;
import bgv;
import bgy;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.ImageCache;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import zr;
import zu;

// Referenced classes of package com.instamag.activity.compose:
//            MainOnlineLibActivity

public class NetMaterialDownloadFragment extends Fragment
{

    public static String a = "SaveInstaceString_rid";
    public static String b = "SaveInstaceString_version";
    public static String c = "SaveInstaceString_imageCount";
    public static String d = "SaveInstaceString_previewUrl";
    public static String e = "SaveInstaceString_otherAppId";
    private static String m = "NetMaterialDownloadFragment";
    private ImageView f;
    private Button g;
    private Button h;
    private bgy i;
    private TPhotoComposeInfo j;
    private MainOnlineLibActivity k;
    private ProgressBar l;

    public NetMaterialDownloadFragment()
    {
    }

    public static NetMaterialDownloadFragment a(bgv bgv, TPhotoComposeInfo tphotocomposeinfo)
    {
        bgv = new NetMaterialDownloadFragment();
        bgv.j = tphotocomposeinfo;
        return bgv;
    }

    public static TPhotoComposeInfo a(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        return netmaterialdownloadfragment.j;
    }

    public static String a()
    {
        return m;
    }

    private void a(int i1, int j1)
    {
        if (k != null)
        {
            k.a(i1, j1);
        }
    }

    public static void a(NetMaterialDownloadFragment netmaterialdownloadfragment, int i1, int j1)
    {
        netmaterialdownloadfragment.a(i1, j1);
    }

    public static boolean a(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                Crashlytics.logException(context);
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    private bgy b()
    {
        if (i == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.a(0.05F);
            zr1.g = true;
            int i1 = 320;
            if (j != null)
            {
                i1 = (int)j.height;
                int j1 = (int)j.width;
                if (i1 <= j1)
                {
                    i1 = j1;
                }
            }
            i = new bgy(getActivity(), i1);
            i.a(getActivity().getSupportFragmentManager(), zr1);
        }
        return i;
    }

    public static MainOnlineLibActivity b(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        return netmaterialdownloadfragment.k;
    }

    public static Button c(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        return netmaterialdownloadfragment.g;
    }

    public static Button d(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        return netmaterialdownloadfragment.h;
    }

    public static ImageView e(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        return netmaterialdownloadfragment.f;
    }

    public static ProgressBar f(NetMaterialDownloadFragment netmaterialdownloadfragment)
    {
        return netmaterialdownloadfragment.l;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        i = b();
        i.a(j, f);
        if (android/view/View$OnClickListener.isInstance(getActivity()) && aaj.c())
        {
            f.setOnClickListener((android.view.View.OnClickListener)getActivity());
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        k = (MainOnlineLibActivity)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            if (j == null)
            {
                j = new TPhotoComposeInfo();
            }
            j.resId = bundle.getInt(a);
            j.previewUrl = bundle.getString(d);
            j.imageCount = bundle.getInt(c);
            j.otherAppStoreId = bundle.getString(e);
            j.version = bundle.getString(b);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030074, viewgroup, false);
        l = (ProgressBar)layoutinflater.findViewById(0x7f0d0261);
        float f1 = getResources().getDisplayMetrics().widthPixels;
        viewgroup = (android.widget.RelativeLayout.LayoutParams)((FrameLayout)layoutinflater.findViewById(0x7f0d0260)).getLayoutParams();
        f = (ImageView)layoutinflater.findViewById(0x7f0d024b);
        f.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        h = (Button)layoutinflater.findViewById(0x7f0d0262);
        h.setOnClickListener(new bbj(this));
        g = (Button)layoutinflater.findViewById(0x7f0d0263);
        g.setOnClickListener(new bbk(this));
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (f != null)
        {
            zu.a(f);
            f.setImageDrawable(null);
        }
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (j == null)
        {
            return;
        } else
        {
            bundle.putInt(a, j.resId);
            bundle.putString(b, j.version);
            bundle.putInt(c, j.imageCount);
            bundle.putString(d, j.previewUrl);
            bundle.putInt(c, j.imageCount);
            bundle.putString(e, j.otherAppStoreId);
            return;
        }
    }

}
