// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.manager:
//            RecentImojiesManager, TemplatesManager

public final class  extends Binding
    implements MembersInjector
{

    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/manager/RecentImojiesManager, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/manager/RecentImojiesManager, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceUtils);
        set1.add(templatesManager);
    }

    public void injectMembers(RecentImojiesManager recentimojiesmanager)
    {
        recentimojiesmanager.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        recentimojiesmanager.templatesManager = (TemplatesManager)templatesManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RecentImojiesManager)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.manager.RecentImojiesManager", false, com/bitstrips/imoji/manager/RecentImojiesManager);
    }
}
