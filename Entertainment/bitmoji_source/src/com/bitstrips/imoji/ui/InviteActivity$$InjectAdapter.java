// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            InviteActivity, ImageLoader, IntentCreatorService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analyticsService;
    private Binding bitstripsService;
    private Binding imageLoader;
    private Binding intentCreatorService;
    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/InviteActivity, getClass().getClassLoader());
        imageLoader = linker.requestBinding("com.bitstrips.imoji.ui.ImageLoader", com/bitstrips/imoji/ui/InviteActivity, getClass().getClassLoader());
        analyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/InviteActivity, getClass().getClassLoader());
        intentCreatorService = linker.requestBinding("com.bitstrips.imoji.ui.IntentCreatorService", com/bitstrips/imoji/ui/InviteActivity, getClass().getClassLoader());
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/ui/InviteActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/InviteActivity, getClass().getClassLoader());
    }

    public InviteActivity get()
    {
        InviteActivity inviteactivity = new InviteActivity();
        injectMembers(inviteactivity);
        return inviteactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(templatesManager);
        set1.add(imageLoader);
        set1.add(analyticsService);
        set1.add(intentCreatorService);
        set1.add(bitstripsService);
        set1.add(preferenceUtils);
    }

    public void injectMembers(InviteActivity inviteactivity)
    {
        inviteactivity.templatesManager = (TemplatesManager)templatesManager.get();
        inviteactivity.imageLoader = (ImageLoader)imageLoader.get();
        inviteactivity.analyticsService = (AnalyticsService)analyticsService.get();
        inviteactivity.intentCreatorService = (IntentCreatorService)intentCreatorService.get();
        inviteactivity.bitstripsService = (BitstripsService)bitstripsService.get();
        inviteactivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((InviteActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.InviteActivity", "members/com.bitstrips.imoji.ui.InviteActivity", false, com/bitstrips/imoji/ui/InviteActivity);
    }
}
