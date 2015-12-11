// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user.service;

import android.content.SharedPreferences;
import com.comcast.cim.model.services.KeyValueStore;
import com.comcast.cim.model.user.User;
import com.comcast.cim.utils.JsonDeserializer;
import com.comcast.cim.utils.JsonSerializer;

public class PreferencesUserStore
    implements KeyValueStore
{

    private final JsonDeserializer deserializer;
    private final SharedPreferences preferences;
    private final JsonSerializer serializer;
    private final Class userClazz;

    public PreferencesUserStore(SharedPreferences sharedpreferences, JsonSerializer jsonserializer, JsonDeserializer jsondeserializer, Class class1)
    {
        preferences = sharedpreferences;
        serializer = jsonserializer;
        deserializer = jsondeserializer;
        userClazz = class1;
    }

    public User get(String s)
    {
        s = preferences.getString(s, null);
        if (s == null)
        {
            return null;
        } else
        {
            return (User)deserializer.deserialize(s, userClazz);
        }
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    public volatile void put(Object obj, Object obj1)
    {
        put((String)obj, (User)obj1);
    }

    public void put(String s, User user)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(s, serializer.serialize(user));
        editor.commit();
    }
}
