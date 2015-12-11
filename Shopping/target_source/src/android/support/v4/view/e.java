// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Rect;

public class e
{

    static final a a;

    public static int a(int i, int j)
    {
    /* block-local class not found */
    class a {}

        return a.a(i, j);
    }

    public static void a(int i, int j, int k, Rect rect, Rect rect1, int l)
    {
        a.a(i, j, k, rect, rect1, l);
    }

    static 
    {
    /* block-local class not found */
    class b {}

    /* block-local class not found */
    class c {}

        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
