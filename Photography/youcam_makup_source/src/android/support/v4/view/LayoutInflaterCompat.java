// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            LayoutInflaterFactory

public class LayoutInflaterCompat
{

    static final LayoutInflaterCompatImpl IMPL;

    private LayoutInflaterCompat()
    {
    }

    public static void setFactory(LayoutInflater layoutinflater, LayoutInflaterFactory layoutinflaterfactory)
    {
        IMPL.setFactory(layoutinflater, layoutinflaterfactory);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            IMPL = new LayoutInflaterCompatImplV21();
        } else
        if (i >= 11)
        {
            IMPL = new LayoutInflaterCompatImplV11();
        } else
        {
            IMPL = new LayoutInflaterCompatImplBase();
        }
    }

    /* member class not found */
    class LayoutInflaterCompatImpl {}


    /* member class not found */
    class LayoutInflaterCompatImplV21 {}


    /* member class not found */
    class LayoutInflaterCompatImplV11 {}


    /* member class not found */
    class LayoutInflaterCompatImplBase {}

}
