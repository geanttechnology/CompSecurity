// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Fragment;
import android.os.Handler;
import com.crittercism.app.Crittercism;
import com.groupon.util.Dates;
import com.squareup.otto.Bus;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.WeakHashMap;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            GrouponFragmentInterface

public class GrouponFragmentDelegate
{
    public static class GrouponFragmentDestroyEvent
    {

        private String fragmentName;

        public String getFragmentName()
        {
            return fragmentName;
        }

        public GrouponFragmentDestroyEvent(GrouponFragmentInterface grouponfragmentinterface)
        {
            fragmentName = grouponfragmentinterface.getClass().getSimpleName();
        }
    }

    protected static class RefreshRunnable
        implements Runnable
    {

        private WeakReference ref;

        public void run()
        {
            GrouponFragmentDelegate grouponfragmentdelegate = (GrouponFragmentDelegate)ref.get();
            if (grouponfragmentdelegate != null)
            {
                grouponfragmentdelegate.fragment.forceReload();
            }
        }

        public RefreshRunnable(GrouponFragmentDelegate grouponfragmentdelegate)
        {
            ref = new WeakReference(grouponfragmentdelegate);
        }
    }


    private static WeakHashMap residentFragments = new WeakHashMap();
    Bus bus;
    private GrouponFragmentInterface fragment;
    private Handler handler;
    private RefreshRunnable refreshAtMidnight;

    public GrouponFragmentDelegate()
    {
        refreshAtMidnight = new RefreshRunnable(this);
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        if (!Ln.isDebugEnabled())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        com/groupon/fragment/GrouponFragmentDelegate;
        JVM INSTR monitorenter ;
        Ln.d("Fragments: %s", new Object[] {
            Strings.join(", ", residentFragments.keySet())
        });
        com/groupon/fragment/GrouponFragmentDelegate;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/groupon/fragment/GrouponFragmentDelegate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onCreate(GrouponFragmentInterface grouponfragmentinterface)
    {
        if (!Ln.isDebugEnabled()) goto _L2; else goto _L1
_L1:
        com/groupon/fragment/GrouponFragmentDelegate;
        JVM INSTR monitorenter ;
        residentFragments.put((Fragment)grouponfragmentinterface, null);
        Ln.d("Fragments: %s", new Object[] {
            Strings.join(", ", residentFragments.keySet())
        });
        com/groupon/fragment/GrouponFragmentDelegate;
        JVM INSTR monitorexit ;
_L2:
        fragment = grouponfragmentinterface;
        handler.postAtTime(refreshAtMidnight, Dates.midnightTonight().getTimeInMillis());
        return;
        grouponfragmentinterface;
        com/groupon/fragment/GrouponFragmentDelegate;
        JVM INSTR monitorexit ;
        throw grouponfragmentinterface;
    }

    public void onDestroy()
    {
        handler.removeCallbacks(refreshAtMidnight);
    }

    public void onDestroyView(GrouponFragmentInterface grouponfragmentinterface)
    {
        bus.post(new GrouponFragmentDestroyEvent(grouponfragmentinterface));
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void onSelectionChange(boolean flag)
    {
        if (flag)
        {
            Crittercism.leaveBreadcrumb(fragment.getClass().getSimpleName());
        }
    }


}
