// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import c.a.a.a.a.b.l;
import c.a.a.a.e;
import c.a.a.a.q;

public final class k
{

    public final String a;
    public final int b;
    public final int c;
    public final int d;

    private k(String s, int i, int j, int i1)
    {
        a = s;
        b = i;
        c = j;
        d = i1;
    }

    public static k a(Context context, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        int i = l.j(context);
        e.d().a("Fabric", (new StringBuilder("App icon resource ID is ")).append(i).toString());
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        context = new k(s, i, options.outWidth, options.outHeight);
        return context;
        context;
        e.d().c("Fabric", "Failed to load icon", context);
        return null;
    }
}
