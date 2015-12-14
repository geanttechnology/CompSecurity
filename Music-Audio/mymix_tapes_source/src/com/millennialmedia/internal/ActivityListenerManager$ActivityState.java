// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal:
//            ActivityListenerManager

private static class .UNKNOWN
{

    private List activityListenerRefs;
    private  lifecycleState;

     getLifecycleState()
    {
        return lifecycleState;
    }

    List getListeners()
    {
        ArrayList arraylist = new ArrayList();
        if (activityListenerRefs != null)
        {
            for (Iterator iterator = activityListenerRefs.iterator(); iterator.hasNext();)
            {
                er er = (er)((WeakReference)iterator.next()).get();
                if (er == null)
                {
                    iterator.remove();
                } else
                {
                    arraylist.add(er);
                }
            }

        }
        return arraylist;
    }

    void registerListener(er er)
    {
        if (activityListenerRefs == null)
        {
            activityListenerRefs = new ArrayList();
        }
        activityListenerRefs.add(new WeakReference(er));
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Registered activity listener: ").append(er).toString());
        }
    }

    void unregisterListener(er er)
    {
label0:
        {
            if (activityListenerRefs == null)
            {
                break label0;
            }
            Iterator iterator = activityListenerRefs.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (er != ((WeakReference)iterator.next()).get());
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(ActivityListenerManager.access$000(), (new StringBuilder()).append("Unregistered activity listener: ").append(er).toString());
            }
            iterator.remove();
        }
    }


/*
    static  access$202( ,  1)
    {
        .lifecycleState = 1;
        return 1;
    }

*/

    lifecycleState()
    {
        lifecycleState = .UNKNOWN;
    }
}
