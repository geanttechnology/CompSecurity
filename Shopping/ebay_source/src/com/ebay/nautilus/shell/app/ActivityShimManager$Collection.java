// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager, ActivityShim

private static final class shims extends ActivityShimManager
{

    final List shims;

    public ActivityShim getShim(Class class1)
    {
        if (class1 != com/ebay/nautilus/shell/app/ActivityShim) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        ActivityShim activityshim;
        Iterator iterator = shims.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            activityshim = (ActivityShim)iterator.next();
        } while (!class1.isInstance(activityshim));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return (ActivityShim)class1.cast(activityshim);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onActivityResult(i, j, intent)) { }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onConfigurationChanged(configuration)) { }
    }

    public void onContentChanged()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onContentChanged()) { }
    }

    public void onCreate(Bundle bundle)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onCreate(bundle)) { }
    }

    public void onDestroy()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onDestroy()) { }
    }

    public void onPause()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onPause()) { }
    }

    public void onPostCreate(Bundle bundle)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onPostCreate(bundle)) { }
    }

    public void onPostResume()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onPostResume()) { }
    }

    public void onRestart()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onRestart()) { }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onRestoreInstanceState(bundle)) { }
    }

    public void onResume()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onResume()) { }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onSaveInstanceState(bundle)) { }
    }

    public void onStart()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onStart()) { }
    }

    public void onStop()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onStop()) { }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onWindowFocusChanged(flag)) { }
    }

    public void preOnCreate(Bundle bundle)
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnCreate(bundle)) { }
    }

    public void preOnDestroy()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnDestroy()) { }
    }

    public void preOnPause()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnPause()) { }
    }

    public void preOnRestart()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnRestart()) { }
    }

    public void preOnResume()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnResume()) { }
    }

    public void preOnStart()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnStart()) { }
    }

    public void preOnStop()
    {
        for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnStop()) { }
    }

    (Activity activity, List list)
    {
        super(activity);
        ArrayList arraylist = new ArrayList(list.size());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            activity = (Class)list.next();
            try
            {
                ActivityShim activityshim = (ActivityShim)activity.newInstance();
                activityshim.setManager(this);
                arraylist.add(activityshim);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                activity = new IllegalAccessError((new StringBuilder()).append(activity.getName()).append(" does not have a public constructor!").toString());
                activity.initCause(list);
                throw activity;
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                activity = new IllegalAccessError((new StringBuilder()).append("Can't construct ").append(activity.getName()).append('!').toString());
                activity.initCause(list);
                throw activity;
            }
        } while (true);
        shims = Collections.unmodifiableList(arraylist);
    }
}
