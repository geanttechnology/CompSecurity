// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.a;

import android.content.Context;
import com.mopub.common.b;
import com.mopub.mobileads.p;
import com.mopub.mobileads.q;

public final class f
{

    protected static f a = new f();

    public f()
    {
    }

    public static p a(Context context, b b, com.mopub.mobileads.m.a a1, boolean flag, String s, String s1)
    {
        context = new p(context, b);
        context.setOnTouchListener(new com.mopub.mobileads._cls1(context, flag));
        context.setWebViewClient(new q(new com.mopub.mobileads.p.a(a1), context, s1, s));
        return context;
    }

}
