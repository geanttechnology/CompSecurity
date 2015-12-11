// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

// Referenced classes of package com.shazam.android.a:
//            b

public abstract class d extends b
{

    protected int c;
    protected LayoutInflater d;

    public d(Context context, int i, List list)
    {
        super(context, list);
        c = i;
        d = (LayoutInflater)a.getSystemService("layout_inflater");
    }

    public final View a(Context context, ViewGroup viewgroup)
    {
        return d.inflate(c, viewgroup, false);
    }
}
