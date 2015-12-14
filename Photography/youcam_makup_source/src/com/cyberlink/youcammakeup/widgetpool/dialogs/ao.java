// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;

public class ao extends Fragment
{

    private View a;
    private View b;
    private long c;
    private boolean d;
    private int e;
    private int f;

    public ao()
    {
        c = 1000L;
        d = false;
        f = 0x7f0703b9;
    }

    static View a(ao ao1)
    {
        return ao1.b;
    }

    public void a(long l)
    {
        c = l;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[MakeupMode.values().length];
                try
                {
                    a[MakeupMode.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[MakeupMode.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[MakeupMode.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[MakeupMode.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[MakeupMode.b.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[MakeupMode.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[MakeupMode.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[StatusManager.j().r().ordinal()];
        JVM INSTR tableswitch 1 6: default 52
    //                   1 77
    //                   2 77
    //                   3 77
    //                   4 77
    //                   5 92
    //                   6 92;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L3
_L1:
        e = 0x7f03020d;
_L5:
        a = layoutinflater.inflate(e, viewgroup, false);
        return a;
_L2:
        f = 0x7f0706fd;
        e = 0x7f03020f;
        continue; /* Loop/switch isn't completed */
_L3:
        f = 0x7f0706fc;
        e = 0x7f03020f;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onStart()
    {
        super.onStart();
        b = a.findViewById(0x7f0c08eb);
        View view = a.findViewById(0x7f0c08ec);
        if (view != null)
        {
            ((TextView)(TextView)view).setText(f);
        }
        b.setVisibility(4);
        if (d)
        {
            a.setBackgroundResource(0x7f02019a);
        }
        a.postDelayed(new Runnable() {

            final ao a;

            public void run()
            {
                ao.a(a).setVisibility(0);
            }

            
            {
                a = ao.this;
                super();
            }
        }, c);
    }
}
