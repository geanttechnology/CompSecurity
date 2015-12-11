// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package a.a:
//            bd, be

public final class cf
    implements bd
{

    private Float a;

    public cf()
    {
        a = null;
        be.b();
        a = Float.valueOf(be.b().getResources().getDisplayMetrics().xdpi);
    }

    public final String a()
    {
        return "xdpi";
    }

    public final volatile Object b()
    {
        return a;
    }
}
