// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            n

public class j
{

    static final a a;

    public static void a(LayoutInflater layoutinflater, n n)
    {
    /* block-local class not found */
    class a {}

        a.a(layoutinflater, n);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
    /* block-local class not found */
    class b {}

    /* block-local class not found */
    class c {}

    /* block-local class not found */
    class d {}

        if (i >= 21)
        {
            a = new d();
        } else
        if (i >= 11)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
