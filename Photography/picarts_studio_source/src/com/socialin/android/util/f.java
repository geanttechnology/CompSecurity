// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;

public final class f
{

    public Context a;
    private k b;

    public f(Context context)
    {
        b = com.bumptech.glide.b.b(context);
        a = context;
    }

    public final void a(String s, ImageView imageview, e e, d d)
    {
        s = b.g().a(s);
        if (d != null)
        {
            s.a = d;
        }
        s.a(e).a(new _cls1(imageview, imageview));
    }

    /* member class not found */
    class _cls1 {}

}
