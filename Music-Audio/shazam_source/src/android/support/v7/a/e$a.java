// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.view.ContextThemeWrapper;

// Referenced classes of package android.support.v7.a:
//            e

public static final class b
{

    public final b a;
    public int b;

    public Wrapper(Context context)
    {
        this(context, e.a(context, 0));
    }

    private <init>(Context context, int i)
    {
        a = new <init>(new ContextThemeWrapper(context, e.a(context, i)));
        b = i;
    }
}
