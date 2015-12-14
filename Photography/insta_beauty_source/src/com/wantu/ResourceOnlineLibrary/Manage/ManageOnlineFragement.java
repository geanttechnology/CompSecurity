// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Manage;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import bfu;
import bfv;
import bfz;
import bga;
import bgb;
import bgc;
import bgv;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Manage:
//            SectionGridViewAdapter

public class ManageOnlineFragement extends Fragment
    implements bfz, bgc
{

    protected bgv a;
    private String b;
    private bfu c;
    private ListView d;
    private SectionGridViewAdapter e;
    private int f;
    private int g;
    private int h;
    private bgb i;
    private LinkedHashMap j;

    public ManageOnlineFragement()
    {
        a = null;
        b = "ManageOnlineFramgement";
        e = null;
        j = new LinkedHashMap();
    }

    public static int a(ManageOnlineFragement manageonlinefragement, int k)
    {
        manageonlinefragement.f = k;
        return k;
    }

    public static ListView a(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.d;
    }

    private bfu a()
    {
        if (c == null)
        {
            c = new bfu(getActivity());
        }
        return c;
    }

    public static SectionGridViewAdapter a(ManageOnlineFragement manageonlinefragement, SectionGridViewAdapter sectiongridviewadapter)
    {
        manageonlinefragement.e = sectiongridviewadapter;
        return sectiongridviewadapter;
    }

    private int b()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f080057);
    }

    public static int b(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.b();
    }

    public static int b(ManageOnlineFragement manageonlinefragement, int k)
    {
        manageonlinefragement.g = k;
        return k;
    }

    public static int c(ManageOnlineFragement manageonlinefragement, int k)
    {
        manageonlinefragement.h = k;
        return k;
    }

    public static LinkedHashMap c(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.j;
    }

    public static int d(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.f;
    }

    public static bfu e(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.c;
    }

    public static SectionGridViewAdapter f(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.e;
    }

    public void a(String s, int k, View view)
    {
        view = (new StringBuilder()).append("Item clicked is:").append(s).append("____").append(k).toString();
        Log.d(b, view);
        view = (ArrayList)j.get(s);
        if (view != null && k > -1 && k < view.size())
        {
            TResInfo tresinfo = (TResInfo)view.get(k);
            view.remove(k);
            if (view.size() == 0)
            {
                j.remove(s);
            }
            e.notifyDataSetChanged();
            if (i != null)
            {
                i.a(tresinfo, bgv.getResTypeByString(s));
            }
        }
    }

    public void a(ArrayList arraylist)
    {
        Log.v((new StringBuilder()).append(b).append("group size:").toString(), (new StringBuilder()).append(arraylist.size()).append("").toString());
        for (int k = 0; k < arraylist.size(); k++)
        {
            bga bga1 = (bga)arraylist.get(k);
            Log.v((new StringBuilder()).append(b).append("group  infos size:").toString(), (new StringBuilder()).append(bga1.c.size()).append("").toString());
            if (bga1.c.size() > 0)
            {
                j.put(bga1.a, bga1.c);
            }
        }

        if (e != null)
        {
            e.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c = a();
        i = new bgb();
        i.a(this);
        bundle = new ArrayList(2);
        bundle.add(bgv.getStringByResType(EOnlineResType.PIP_SCENE));
        bundle.add(bgv.getStringByResType(EOnlineResType.LIGHT_FILTER));
        bundle.add(bgv.getStringByResType(EOnlineResType.FILTER_FRAME));
        bundle.add(bgv.getStringByResType(EOnlineResType.FREE_COLLAGE_STYLE));
        i.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03009f, viewgroup, false);
        d = (ListView)layoutinflater.findViewById(0x7f0d02a8);
        d.getViewTreeObserver().addOnGlobalLayoutListener(new bfv(this));
        return layoutinflater;
    }
}
