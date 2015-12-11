// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user.service;

import android.content.SharedPreferences;
import com.comcast.cim.model.services.KeyValueStore;
import com.comcast.cim.utils.JsonDeserializer;
import com.comcast.cim.utils.JsonSerializer;

// Referenced classes of package com.comcast.cim.model.user.service:
//            UserSettings

public class PreferencesUserSettingsStore
    implements KeyValueStore
{

    private final JsonDeserializer deserializer;
    private final SharedPreferences preferences;
    private final JsonSerializer serializer;
    private final Class userSettingsClazz;

    public PreferencesUserSettingsStore(SharedPreferences sharedpreferences, JsonSerializer jsonserializer, JsonDeserializer jsondeserializer, Class class1)
    {
        preferences = sharedpreferences;
        serializer = jsonserializer;
        deserializer = jsondeserializer;
        userSettingsClazz = class1;
    }

    public UserSettings get(String s)
    {
        s = preferences.getString(s, null);
        if (s == null)
        {
            return null;
        } else
        {
            return (UserSettings)deserializer.deserialize(s, userSettingsClazz);
        }
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    public volatile void put(Object obj, Object obj1)
    {
        put((String)obj, (UserSettings)obj1);
    }

    public void put(String s, UserSettings usersettings)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(s, serializer.serialize(usersettings));
        editor.commit();
    }
}
