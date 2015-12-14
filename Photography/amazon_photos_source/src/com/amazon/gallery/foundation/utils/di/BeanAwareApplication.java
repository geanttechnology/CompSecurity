// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.di;

import android.app.Activity;
import android.app.Application;
import com.amazon.gallery.foundation.utils.TimeTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.foundation.utils.di:
//            BeanFactory, BeanKey

public class BeanAwareApplication extends Application
{

    protected final BeanFactory beanFactory;
    private Map galleryActivityMap;

    public BeanAwareApplication(BeanFactory beanfactory)
    {
        galleryActivityMap = new HashMap();
        TimeTracker.log("Application.ctor");
        beanFactory = beanfactory;
    }

    public void clearAllActivities()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = galleryActivityMap.values().iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((List)iterator.next()).iterator();
            while (iterator1.hasNext()) 
            {
                Activity activity = (Activity)iterator1.next();
                if (!activity.isFinishing())
                {
                    activity.finish();
                }
            }
        }

        break MISSING_BLOCK_LABEL_79;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public Object getApplicationBean(BeanKey beankey)
    {
        return getBeanFactory().getBean(beankey);
    }

    public BeanFactory getBeanFactory()
    {
        return beanFactory;
    }

    public void init()
    {
        beanFactory.init(this);
    }

    public void onCreate()
    {
        super.onCreate();
        init();
    }

    public void registerNewActivity(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        List list = (List)galleryActivityMap.get(activity.getClass());
        if (list == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = list.iterator();
_L4:
        Object obj = list;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Activity)iterator.next();
        if (!((Activity) (obj)).isFinishing())
        {
            ((Activity) (obj)).finish();
        }
        if (true) goto _L4; else goto _L3
        activity;
        throw activity;
_L2:
        obj = new ArrayList();
        galleryActivityMap.put(activity.getClass(), obj);
_L3:
        ((List) (obj)).add(activity);
        this;
        JVM INSTR monitorexit ;
    }

    public void unregisterActivity(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        List list = (List)galleryActivityMap.get(activity.getClass());
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        list.remove(activity);
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    static 
    {
        TimeTracker.log("init");
    }
}
