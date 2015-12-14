// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.a;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.request.e;
import java.util.concurrent.Executors;

public final class d
{

    public Context a;
    public k b;

    public d(Context context)
    {
        a = context;
        b = com.bumptech.glide.b.b(context);
        Executors.newSingleThreadExecutor();
    }

    public final void a(String s, ImageView imageview, com.bumptech.glide.request.d d1, e e)
    {
        s = b.g().a(s);
        s.a = d1;
        s.a(e).a(new _cls1(imageview));
    }

    public final void a(String s, ImageView imageview, e e)
    {
        b.i().a(s).a(0.6F).a(e).a(com.bumptech.glide.a.a()).a(imageview);
    }

    public final void a(String s, ImageView imageview, e e, com.bumptech.glide.request.d d1)
    {
        if (d1 != null)
        {
            s = b.i().a(s).a(com.bumptech.glide.a.a()).a(0.6F);
            s.a = d1;
            s.a(e).a(imageview);
            return;
        } else
        {
            b.i().a(s).a(com.bumptech.glide.a.a()).a(0.6F).a(e).a(imageview);
            return;
        }
    }

    public final void b(String s, ImageView imageview, e e)
    {
        b.i().a(s).a(e).a(imageview);
    }

    public final void c(String s, ImageView imageview, e e)
    {
        b.g().a(s).a(0.6F).a(e).a(com.bumptech.glide.a.a()).a(new _cls2(imageview, imageview));
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
