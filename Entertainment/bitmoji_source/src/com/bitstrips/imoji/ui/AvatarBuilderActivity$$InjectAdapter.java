// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity, IntentCreatorService

public final class A extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding bitstripsService;
    private Binding intentCreatorService;
    private Binding preferenceUtils;
    private Binding supertype;

    public void attach(Linker linker)
    {
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/AvatarBuilderActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/AvatarBuilderActivity, getClass().getClassLoader());
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/ui/AvatarBuilderActivity, getClass().getClassLoader());
        intentCreatorService = linker.requestBinding("com.bitstrips.imoji.ui.IntentCreatorService", com/bitstrips/imoji/ui/AvatarBuilderActivity, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.ImojiWebViewActivity", com/bitstrips/imoji/ui/AvatarBuilderActivity, getClass().getClassLoader(), false, true);
    }

    public AvatarBuilderActivity get()
    {
        AvatarBuilderActivity avatarbuilderactivity = new AvatarBuilderActivity();
        injectMembers(avatarbuilderactivity);
        return avatarbuilderactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(analytics);
        set1.add(preferenceUtils);
        set1.add(bitstripsService);
        set1.add(intentCreatorService);
        set1.add(supertype);
    }

    public void injectMembers(AvatarBuilderActivity avatarbuilderactivity)
    {
        avatarbuilderactivity.analytics = (AnalyticsService)analytics.get();
        avatarbuilderactivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        avatarbuilderactivity.bitstripsService = (BitstripsService)bitstripsService.get();
        avatarbuilderactivity.intentCreatorService = (IntentCreatorService)intentCreatorService.get();
        supertype.injectMembers(avatarbuilderactivity);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((AvatarBuilderActivity)obj);
    }

    public A()
    {
        super("com.bitstrips.imoji.ui.AvatarBuilderActivity", "members/com.bitstrips.imoji.ui.AvatarBuilderActivity", false, com/bitstrips/imoji/ui/AvatarBuilderActivity);
    }
}
