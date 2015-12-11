// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import com.bitstrips.imoji.api.TemplatesService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.util.FileUtil;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.manager:
//            TemplatesManager

public final class A extends Binding
    implements MembersInjector
{

    private Binding b4MService;
    private Binding facebookService;
    private Binding fileUtil;
    private Binding preferenceUtils;
    private Binding templatesService;

    public void attach(Linker linker)
    {
        templatesService = linker.requestBinding("com.bitstrips.imoji.api.TemplatesService", com/bitstrips/imoji/manager/TemplatesManager, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/manager/TemplatesManager, getClass().getClassLoader());
        fileUtil = linker.requestBinding("com.bitstrips.imoji.util.FileUtil", com/bitstrips/imoji/manager/TemplatesManager, getClass().getClassLoader());
        b4MService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/manager/TemplatesManager, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/manager/TemplatesManager, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(templatesService);
        set1.add(preferenceUtils);
        set1.add(fileUtil);
        set1.add(b4MService);
        set1.add(facebookService);
    }

    public void injectMembers(TemplatesManager templatesmanager)
    {
        templatesmanager.templatesService = (TemplatesService)templatesService.get();
        templatesmanager.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        templatesmanager.fileUtil = (FileUtil)fileUtil.get();
        templatesmanager.b4MService = (B4MService)b4MService.get();
        templatesmanager.facebookService = (FacebookService)facebookService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((TemplatesManager)obj);
    }

    public A()
    {
        super(null, "members/com.bitstrips.imoji.manager.TemplatesManager", false, com/bitstrips/imoji/manager/TemplatesManager);
    }
}
