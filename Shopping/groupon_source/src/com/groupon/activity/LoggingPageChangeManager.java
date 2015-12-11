// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import com.crittercism.app.Crittercism;
import com.groupon.tracking.mobile.events.MobileEvent;
import com.groupon.tracking.mobile.sdk.Logger;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Ln;

public class LoggingPageChangeManager
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private Bus bus;
    private final Map fragmentListMap = new HashMap();
    private FragmentManager fragmentManager;
    private Bus globalBus;
    private Logger logger;
    private ViewPager pager;
    private int selectPageIndex;
    private final Map trackingListMap = new HashMap();

    public LoggingPageChangeManager()
    {
        selectPageIndex = 0;
    }

    public void destroy()
    {
        globalBus.unregister(this);
        bus.unregister(this);
    }

    protected Fragment getFragmentAtIndex(int i)
    {
        Fragment fragment = fragmentManager.findFragmentByTag((new StringBuilder()).append("android:switcher:").append(pager.getId()).append(":").append(i).toString());
        if (fragment == null)
        {
            Ln.d("Warning, LoggingPageChangeManager.getFragmentAtIndex is returning null", new Object[0]);
            try
            {
                throw new Exception("Warning, LoggingPageChangeManager.getFragmentAtIndex is returning null");
            }
            catch (Exception exception)
            {
                Crittercism.logHandledException(exception);
            }
        }
        return fragment;
    }

    public void handleFragmentDestroyEvent(com.groupon.fragment.GrouponFragmentDelegate.GrouponFragmentDestroyEvent grouponfragmentdestroyevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (fragmentListMap.containsKey(grouponfragmentdestroyevent.getFragmentName()))
        {
            fragmentListMap.remove(grouponfragmentdestroyevent.getFragmentName());
        }
        if (trackingListMap.containsKey(grouponfragmentdestroyevent.getFragmentName()))
        {
            trackingListMap.remove(grouponfragmentdestroyevent.getFragmentName());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        grouponfragmentdestroyevent;
        throw grouponfragmentdestroyevent;
    }

    public void handleLogEvent(com.groupon.RedirectLogger.LogContextEvent logcontextevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (logcontextevent.getKeyString() == null) goto _L2; else goto _L1
_L1:
        Fragment fragment = getFragmentAtIndex(selectPageIndex);
        if (fragment == null) goto _L4; else goto _L3
_L3:
        if (!fragment.getClass().getSimpleName().equals(logcontextevent.getKeyString())) goto _L4; else goto _L5
_L5:
        logger.log(logcontextevent.getEvent());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!fragmentListMap.containsKey(logcontextevent.getKeyString()))
        {
            fragmentListMap.put(logcontextevent.getKeyString(), new ArrayList());
        }
        ((List)fragmentListMap.get(logcontextevent.getKeyString())).add(logcontextevent.getEvent());
        if (true) goto _L2; else goto _L6
_L6:
        logcontextevent;
        throw logcontextevent;
    }

    public void handleTrackingEvent(com.groupon.RedirectTracking.TrackingEvent trackingevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (trackingevent.getFragment() == null) goto _L2; else goto _L1
_L1:
        Fragment fragment = getFragmentAtIndex(selectPageIndex);
        if (fragment == null) goto _L4; else goto _L3
_L3:
        boolean flag = fragment.getClass().getSimpleName().equals(trackingevent.getFragment());
        if (!flag) goto _L4; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!trackingListMap.containsKey(trackingevent.getFragment()))
        {
            trackingListMap.put(trackingevent.getFragment(), new ArrayList());
        }
        ((List)trackingListMap.get(trackingevent.getFragment())).add(trackingevent);
        if (true) goto _L2; else goto _L5
_L5:
        trackingevent;
        throw trackingevent;
    }

    public void init(ViewPager viewpager)
    {
        pager = viewpager;
        globalBus.register(this);
        bus.register(this);
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Ln.d("LoggingPageChangeManager.onPageSelected(%s)", new Object[] {
            Integer.valueOf(i)
        });
        selectPageIndex = i;
        obj = getFragmentAtIndex(i);
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (fragmentListMap.containsKey(obj = obj.getClass().getSimpleName()))
        {
            obj = ((List)fragmentListMap.get(obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                MobileEvent mobileevent = (MobileEvent)((Iterator) (obj)).next();
                logger.log(mobileevent);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
