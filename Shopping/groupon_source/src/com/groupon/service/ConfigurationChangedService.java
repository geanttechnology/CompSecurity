// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;

// Referenced classes of package com.groupon.service:
//            ConfigurationChangedProvider

public class ConfigurationChangedService
{

    private List configurationChangeProviderKeys;
    private ArrayList configurationChangedProviders;
    private HashSet configurationState;
    private Context context;

    public ConfigurationChangedService()
    {
        configurationChangedProviders = new ArrayList();
    }

    private void init()
    {
        roboguice.inject.ContextScopedRoboInjector contextscopedroboinjector = RoboGuice.getInjector(context);
        Class class1;
        for (Iterator iterator = configurationChangeProviderKeys.iterator(); iterator.hasNext(); configurationChangedProviders.add(contextscopedroboinjector.getInstance(class1)))
        {
            class1 = (Class)iterator.next();
        }

        configurationState = getInstanceState();
    }

    public HashSet getInstanceState()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = configurationChangedProviders.iterator(); iterator.hasNext(); hashset.add(((ConfigurationChangedProvider)iterator.next()).getConfigurationState())) { }
        return hashset;
    }

    public boolean hasConfigurationChanged(HashSet hashset)
    {
        HashSet hashset1 = getInstanceState();
        if (hashset == null)
        {
            hashset = configurationState;
        }
        return !hashset1.equals(hashset);
    }
}
