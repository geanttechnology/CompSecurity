// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import com.mopub.common.d.d;
import com.mopub.common.d.m;
import com.mopub.mobileads.b.f;

public final class al extends ImageView
{

    f a;
    int b;

    public al(Context context)
    {
        super(context);
        setId((int)m.a());
        int i = d.b(45F, context);
        int j = d.b(16F, context);
        int k = d.b(16F, context);
        int l = d.b(5F, context);
        a = new f(context);
        setImageDrawable(a);
        setPadding(l, l, l, l);
        context = new android.widget.RelativeLayout.LayoutParams(i, i);
        context.setMargins(0, j, k, 0);
        context.addRule(11);
        setLayoutParams(context);
    }

    final f getImageViewDrawable()
    {
        return a;
    }

    final void setImageViewDrawable(f f1)
    {
        a = f1;
    }
}
