// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import android.app.AlarmManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.manager:
//            FloaterServiceManager

public final class  extends Binding
    implements MembersInjector
{

    private Binding alarmManager;
    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        alarmManager = linker.requestBinding("android.app.AlarmManager", com/bitstrips/imoji/manager/FloaterServiceManager, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/manager/FloaterServiceManager, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(alarmManager);
        set1.add(preferenceUtils);
    }

    public void injectMembers(FloaterServiceManager floaterservicemanager)
    {
        floaterservicemanager.alarmManager = (AlarmManager)alarmManager.get();
        floaterservicemanager.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FloaterServiceManager)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.manager.FloaterServiceManager", false, com/bitstrips/imoji/manager/FloaterServiceManager);
    }
}
