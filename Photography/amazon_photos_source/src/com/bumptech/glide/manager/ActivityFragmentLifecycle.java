// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.bumptech.glide.manager:
//            Lifecycle, LifecycleListener

class ActivityFragmentLifecycle
    implements Lifecycle
{

    private boolean isDestroyed;
    private boolean isStarted;
    private final Set lifecycleListeners = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    ActivityFragmentLifecycle()
    {
    }

    public void addListener(LifecycleListener lifecyclelistener)
    {
        lifecycleListeners.add(lifecyclelistener);
        if (isDestroyed)
        {
            lifecyclelistener.onDestroy();
            return;
        }
        if (isStarted)
        {
            lifecyclelistener.onStart();
            return;
        } else
        {
            lifecyclelistener.onStop();
            return;
        }
    }

    void onDestroy()
    {
        isDestroyed = true;
        for (Iterator iterator = lifecycleListeners.iterator(); iterator.hasNext(); ((LifecycleListener)iterator.next()).onDestroy()) { }
    }

    void onStart()
    {
        isStarted = true;
        for (Iterator iterator = lifecycleListeners.iterator(); iterator.hasNext(); ((LifecycleListener)iterator.next()).onStart()) { }
    }

    void onStop()
    {
        isStarted = false;
        for (Iterator iterator = lifecycleListeners.iterator(); iterator.hasNext(); ((LifecycleListener)iterator.next()).onStop()) { }
    }
}
