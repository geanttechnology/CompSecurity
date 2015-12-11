// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.g.c.ad;
import com.g.c.u;
import com.shazam.android.aq.l;
import com.shazam.android.aq.q;
import com.shazam.android.k.f.j;
import com.shazam.android.k.f.t;

// Referenced classes of package com.shazam.android.l.g:
//            e

public final class f
    implements ad
{

    public final Resources a;
    public final Context b;
    public final t c;
    public final u d;
    public final l e = new q();
    public e f;
    public android.support.v4.app.u.b g;
    private final j h;

    public f(Context context, t t, u u, Resources resources, j j)
    {
        b = context;
        c = t;
        d = u;
        a = resources;
        h = j;
    }

    public final void a()
    {
    }

    public final void a(Bitmap bitmap)
    {
        g.a = bitmap;
        e e1 = f;
        android.support.v4.app.u.b b1 = g;
        bitmap = null;
        if (((android.support.v4.app.u.p) (b1)).d != null)
        {
            bitmap = ((android.support.v4.app.u.p) (b1)).d.b();
        }
        e1.a(bitmap);
    }
}
