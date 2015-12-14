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
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import td;
import th;
import ti;
import tj;
import tk;
import tu;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Manage:
//            SectionGridViewAdapter

public class ManageOnlineFragement extends Fragment
    implements th, tk
{

    protected tu a;
    private String b;
    private td c;
    private ListView d;
    private SectionGridViewAdapter e;
    private int f;
    private int g;
    private int h;
    private tj i;
    private LinkedHashMap j;

    public ManageOnlineFragement()
    {
        a = null;
        b = "ManageOnlineFramgement";
        e = null;
        j = new LinkedHashMap();
    }

    static int a(ManageOnlineFragement manageonlinefragement, int k)
    {
        manageonlinefragement.f = k;
        return k;
    }

    static ListView a(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.d;
    }

    static SectionGridViewAdapter a(ManageOnlineFragement manageonlinefragement, SectionGridViewAdapter sectiongridviewadapter)
    {
        manageonlinefragement.e = sectiongridviewadapter;
        return sectiongridviewadapter;
    }

    private td a()
    {
        if (c == null)
        {
            c = new td(getActivity());
        }
        return c;
    }

    private int b()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f080048);
    }

    static int b(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.b();
    }

    static int b(ManageOnlineFragement manageonlinefragement, int k)
    {
        manageonlinefragement.g = k;
        return k;
    }

    static int c(ManageOnlineFragement manageonlinefragement, int k)
    {
        manageonlinefragement.h = k;
        return k;
    }

    static LinkedHashMap c(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.j;
    }

    static int d(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.f;
    }

    static td e(ManageOnlineFragement manageonlinefragement)
    {
        return manageonlinefragement.c;
    }

    static SectionGridViewAdapter f(ManageOnlineFragement manageonlinefragement)
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
                i.a(tresinfo, tu.getResTypeByString(s));
            }
        }
    }

    public void a(ArrayList arraylist)
    {
        Log.v((new StringBuilder()).append(b).append("group size:").toString(), (new StringBuilder()).append(arraylist.size()).append("").toString());
        for (int k = 0; k < arraylist.size(); k++)
        {
            ti ti1 = (ti)arraylist.get(k);
            Log.v((new StringBuilder()).append(b).append("group  infos size:").toString(), (new StringBuilder()).append(ti1.c.size()).append("").toString());
            if (ti1.c.size() > 0)
            {
                j.put(ti1.a, ti1.c);
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
        i = new tj();
        i.a(this);
        bundle = new ArrayList(2);
        bundle.add(tu.getStringByResType(EOnlineResType.PIP_SCENE));
        bundle.add(tu.getStringByResType(EOnlineResType.PIP_SCENE2));
        i.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030056, viewgroup, false);
        d = (ListView)layoutinflater.findViewById(0x7f0c0156);
        d.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ManageOnlineFragement a;

            public void onGlobalLayout()
            {
                ManageOnlineFragement.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ManageOnlineFragement.a(a).getWidth();
                ManageOnlineFragement.a(a, ManageOnlineFragement.b(a));
                ManageOnlineFragement.b(a, a.getResources().getDimensionPixelSize(0x7f08004a));
                ManageOnlineFragement.c(a, a.getResources().getDimensionPixelSize(0x7f080047));
                ManageOnlineFragement.a(a, new SectionGridViewAdapter(a.getActivity(), ManageOnlineFragement.c(a), ManageOnlineFragement.a(a).getWidth(), ManageOnlineFragement.a(a).getHeight(), ManageOnlineFragement.d(a), ManageOnlineFragement.e(a)));
                ManageOnlineFragement.f(a).setItemListener(a);
                ManageOnlineFragement.a(a).setAdapter(ManageOnlineFragement.f(a));
                ManageOnlineFragement.a(a).setDividerHeight(ManageOnlineFragement.f(a).gapBetweenChildrenInRow());
            }

            
            {
                a = ManageOnlineFragement.this;
                super();
            }
        });
        return layoutinflater;
    }
}
