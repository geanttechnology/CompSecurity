// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.a.a.a;
import b.a.a.a.b;
import b.a.a.a.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            b

public final class BottomUIFragment_ extends com.smule.pianoandroid.magicpiano.b
    implements a, b
{

    private final c g = new c();
    private View h;

    public BottomUIFragment_()
    {
    }

    private void a(Bundle bundle)
    {
        c.a(this);
        f = getActivity().getResources().getBoolean(0x7f070008);
    }

    public void a(a a1)
    {
        c = (ProgressBar)a1.findViewById(0x7f0a007a);
        b = (TextView)a1.findViewById(0x7f0a0079);
        e = (ProgressBar)a1.findViewById(0x7f0a0072);
        a = a1.findViewById(0x7f0a0075);
        d = a1.findViewById(0x7f0a0071);
        a();
    }

    public View findViewById(int i)
    {
        if (h == null)
        {
            return null;
        } else
        {
            return h.findViewById(i);
        }
    }

    public void onCreate(Bundle bundle)
    {
        c c1 = c.a(g);
        a(bundle);
        super.onCreate(bundle);
        c.a(c1);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        h = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (h == null)
        {
            h = layoutinflater.inflate(0x7f03001e, viewgroup, false);
        }
        return h;
    }

    public void onDestroyView()
    {
        h = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        g.a(this);
    }
}
