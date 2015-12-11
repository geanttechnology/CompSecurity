// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package a.a:
//            bd, be

public final class bg
    implements bd
{

    private Float a;

    public bg()
    {
        a = null;
        be.b();
        a = Float.valueOf(be.b().getResources().getDisplayMetrics().ydpi);
    }

    public final String a()
    {
        return "ydpi";
    }

    public final volatile Object b()
    {
        return a;
    }
}
