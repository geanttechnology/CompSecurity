// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager

private static class shimClasses extends shimClasses
{

    protected ArrayList shimClasses;

    public void addActivityShimClass(Class class1)
    {
        if (class1 == null)
        {
            throw new NullPointerException("c");
        }
        if (shimClasses == null)
        {
            shimClasses = new ArrayList();
        }
        shimClasses.add(class1);
    }

    public ActivityShimManager createShimManager(Activity activity)
    {
        if (shimClasses == null)
        {
            shimClasses _tmp = ActivityShimManager.access$202(new (null));
        } else
        {
             _tmp1 = ActivityShimManager.access$202(new init>(Collections.unmodifiableList(shimClasses)));
        }
        return ActivityShimManager.access$200().Manager(activity);
    }

    public void removeActivityShimClass(Class class1)
    {
        if (class1 == null)
        {
            throw new NullPointerException("c");
        }
        if (shimClasses == null) goto _L2; else goto _L1
_L1:
        int i = shimClasses.size();
_L5:
        int j = i - 1;
        if (i <= 0) goto _L4; else goto _L3
_L3:
        if (class1.isAssignableFrom((Class)shimClasses.get(j)))
        {
            shimClasses.remove(j);
            i = j;
        } else
        {
            i = j;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (shimClasses.isEmpty())
        {
            shimClasses = null;
        }
_L2:
    }

    public ()
    {
        this(null);
    }

    public <init>(List list)
    {
        Object obj = null;
        super(null);
        if (list == null)
        {
            list = obj;
        } else
        {
            list = new ArrayList(list);
        }
        shimClasses = list;
    }
}
