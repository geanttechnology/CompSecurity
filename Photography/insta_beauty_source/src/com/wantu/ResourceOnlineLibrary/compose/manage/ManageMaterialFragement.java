// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose.manage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import bga;
import bgb;
import bgc;
import bgv;
import bho;
import bhr;
import bhs;
import bht;
import com.fotoable.comlib.util.ImageCache;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import zr;
import zu;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose.manage:
//            MagManageAdapter, ManageOnlineLibActivity

public class ManageMaterialFragement extends Fragment
    implements bgc, bho
{

    protected MagManageAdapter a;
    protected ArrayList b;
    protected ManageOnlineLibActivity c;
    private String d;
    private zu e;
    private zu f;
    private bgb g;
    private GridView h;

    public ManageMaterialFragement()
    {
        d = "ManageMaterialFragement";
        b = new ArrayList(0);
        f = null;
    }

    public static String a(ManageMaterialFragement managematerialfragement)
    {
        return managematerialfragement.d;
    }

    public static bgb b(ManageMaterialFragement managematerialfragement)
    {
        return managematerialfragement.g;
    }

    private zu b()
    {
        if (f == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.a(0.05F);
            f = new bht(this, getActivity(), a());
            f.a(getActivity().getSupportFragmentManager(), zr1);
        }
        return f;
    }

    public int a()
    {
        return 320;
    }

    public void a(InstaMagType instamagtype)
    {
        Log.v(d, String.format("%d", new Object[] {
            Integer.valueOf(b.size())
        }));
        a.setItemList(b(instamagtype));
        a.notifyDataSetChanged();
    }

    public void a(TResInfo tresinfo)
    {
_L2:
        return;
        if (c == null || b == null) goto _L2; else goto _L1
_L1:
        int i = 0;
        do
        {
            if (i < b.size())
            {
label0:
                {
                    TResInfo tresinfo1 = (TResInfo)b.get(i);
                    if (tresinfo1.resId != tresinfo.resId)
                    {
                        break label0;
                    }
                    b.remove(tresinfo1);
                    if (a != null)
                    {
                        a.setItemList(b(c.b()));
                        a.notifyDataSetChanged();
                        return;
                    }
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
    }

    public void a(Object obj)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c);
        builder.setTitle(c.getResources().getString(0x7f0602ae));
        builder.setMessage(c.getResources().getString(0x7f0600c0));
        builder.setPositiveButton(c.getResources().getString(0x7f0602fd), new bhr(this, obj));
        builder.setNegativeButton(c.getResources().getString(0x7f06018e), new bhs(this));
        builder.create().show();
    }

    public void a(ArrayList arraylist)
    {
        Log.v((new StringBuilder()).append(d).append("group size:").toString(), (new StringBuilder()).append(d).append(arraylist.size()).append("").toString());
        b.clear();
        for (int i = 0; i < arraylist.size(); i++)
        {
            bga bga1 = (bga)arraylist.get(i);
            Log.v((new StringBuilder()).append(d).append("group  infos size:").toString(), (new StringBuilder()).append(d).append(bga1.c.size()).append("").toString());
            if (bga1.c.size() <= 0)
            {
                continue;
            }
            for (int j = 0; j < bga1.c.size(); j++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)bga1.c.get(j);
                if (!tphotocomposeinfo.isShouldFirst())
                {
                    b.add(tphotocomposeinfo);
                }
            }

        }

        a.setItemList(b(c.b()));
        if (a != null)
        {
            a.notifyDataSetChanged();
        }
    }

    public ArrayList b(InstaMagType instamagtype)
    {
        ArrayList arraylist = new ArrayList(0);
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            for (int i = 0; i < b.size(); i++)
            {
                instamagtype = (TPhotoComposeInfo)b.get(i);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 480F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            for (int j = 0; j < b.size(); j++)
            {
                instamagtype = (TPhotoComposeInfo)b.get(j);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 320F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            for (int k = 0; k < b.size(); k++)
            {
                instamagtype = (TPhotoComposeInfo)b.get(k);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 214F)
                {
                    arraylist.add(instamagtype);
                }
            }

        }
        return arraylist;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = (ManageOnlineLibActivity)activity;
        Log.d(d, "onAttach");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        e = b();
        a = new MagManageAdapter(getActivity(), b, e);
        a.setManageItemViewDelegate(this);
        g = new bgb();
        g.a(this);
        bundle = new ArrayList(2);
        bundle.add(bgv.getStringByResType(EOnlineResType.MAG_MASK_INFO));
        g.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030076, viewgroup, false);
        h = (GridView)layoutinflater.findViewById(0x7f0d0266);
        h.setAdapter(a);
        if (e != null)
        {
            e.a(android.graphics.Bitmap.CompressFormat.JPEG);
        }
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if (c != null)
        {
            c.a(Boolean.valueOf(true));
        }
    }
}
