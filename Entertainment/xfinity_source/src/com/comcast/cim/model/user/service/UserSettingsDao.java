// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user.service;

import com.comcast.cim.cmasl.utils.initializer.Initializer;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.model.services.KeyValueDao;
import com.comcast.cim.model.user.User;

// Referenced classes of package com.comcast.cim.model.user.service:
//            PreferencesUserSettingsStore, UserSettings

public class UserSettingsDao
    implements KeyValueDao
{

    private final Initializer initializer;
    private final PreferencesUserSettingsStore store;
    private final Provider userSettingsFactory;

    public UserSettingsDao(PreferencesUserSettingsStore preferencesusersettingsstore, Provider provider, Initializer initializer1)
    {
        store = preferencesusersettingsstore;
        userSettingsFactory = provider;
        initializer = initializer1;
    }

    private String getKey(User user)
    {
        return (new StringBuilder()).append("usersettings_").append(user.getUserKey()).toString();
    }

    public UserSettings get(User user)
    {
        user = getKey(user);
        UserSettings usersettings = store.get(user);
        if (usersettings == null)
        {
            usersettings = (UserSettings)userSettingsFactory.get();
            initializer.initialize(usersettings);
            store.put(user, usersettings);
            return usersettings;
        } else
        {
            initializer.initialize(usersettings);
            return usersettings;
        }
    }

    public void put(User user, UserSettings usersettings)
    {
        store.put(getKey(user), usersettings);
    }
}
