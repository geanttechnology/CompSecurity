// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Rect;

// Referenced classes of package android.support.v4.view:
//            v, u, t

public final class s
{

    private static t a;

    public static int a(int i, int j)
    {
        return a.a(i, j);
    }

    public static void a(int i, int j, int k, Rect rect, Rect rect1, int l)
    {
        a.a(i, j, k, rect, rect1, l);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new v();
        } else
        {
            a = new u();
        }
    }
}
