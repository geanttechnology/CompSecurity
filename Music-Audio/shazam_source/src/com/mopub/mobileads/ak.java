// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import com.mopub.common.d.d;
import com.mopub.common.d.m;
import com.mopub.mobileads.b.e;

public final class ak extends ImageView
{

    e a;

    public ak(Context context, int i)
    {
        super(context);
        setId((int)m.a());
        a = new e(context);
        setImageDrawable(a);
        context = new android.widget.RelativeLayout.LayoutParams(-1, d.b(4F, context));
        context.addRule(8, i);
        setLayoutParams(context);
    }

    final e getImageViewDrawable()
    {
        return a;
    }

    final void setImageViewDrawable(e e1)
    {
        a = e1;
    }
}
