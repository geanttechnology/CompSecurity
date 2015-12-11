// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.receivers;

import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.receivers:
//            BootCompletedReceiver

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding floaterServiceManager;
    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        floaterServiceManager = linker.requestBinding("com.bitstrips.imoji.manager.FloaterServiceManager", com/bitstrips/imoji/receivers/BootCompletedReceiver, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/receivers/BootCompletedReceiver, getClass().getClassLoader());
    }

    public BootCompletedReceiver get()
    {
        BootCompletedReceiver bootcompletedreceiver = new BootCompletedReceiver();
        injectMembers(bootcompletedreceiver);
        return bootcompletedreceiver;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(floaterServiceManager);
        set1.add(preferenceUtils);
    }

    public void injectMembers(BootCompletedReceiver bootcompletedreceiver)
    {
        bootcompletedreceiver.floaterServiceManager = (FloaterServiceManager)floaterServiceManager.get();
        bootcompletedreceiver.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BootCompletedReceiver)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.receivers.BootCompletedReceiver", "members/com.bitstrips.imoji.receivers.BootCompletedReceiver", false, com/bitstrips/imoji/receivers/BootCompletedReceiver);
    }
}
