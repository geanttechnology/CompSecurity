// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager

private static abstract class <init>
{

    public void addActivityShimClass(Class class1)
    {
        throw new UnsupportedOperationException("You must add all the shims before any activity is created! Look at ActivityShimManager.addActivityShimClass().");
    }

    public abstract ActivityShimManager createShimManager(Activity activity);

    public abstract void removeActivityShimClass(Class class1);

    private ()
    {
    }

    ( )
    {
        this();
    }
}
