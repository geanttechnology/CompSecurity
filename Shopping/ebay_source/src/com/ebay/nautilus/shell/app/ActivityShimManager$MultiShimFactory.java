// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager

private static final class shimClasses extends shimClasses
{

    private final List shimClasses;

    public ActivityShimManager createShimManager(Activity activity)
    {
        return new (activity, shimClasses);
    }

    public void removeActivityShimClass(Class class1)
    {
        shimClasses _tmp = ActivityShimManager.access$202(new (shimClasses));
        ActivityShimManager.access$200().ivityShimClass(class1);
    }

    public (List list)
    {
        super(null);
        shimClasses = list;
    }
}
