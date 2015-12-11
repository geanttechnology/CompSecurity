// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class lang.Object
    implements rt
{

    final FrameLayout a;
    final LayoutInflater b;
    final ViewGroup c;
    final Bundle d;
    final rs e;

    public int a()
    {
        return 2;
    }

    public void a(rr rr1)
    {
        a.removeAllViews();
        a.addView(rs.b(e).a(b, c, d));
    }

    >(rs rs1, FrameLayout framelayout, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = rs1;
        a = framelayout;
        b = layoutinflater;
        c = viewgroup;
        d = bundle;
        super();
    }
}
