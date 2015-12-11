// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import com.comcast.cim.model.services.KeyValueDao;
import com.comcast.cim.model.services.KeyValueStore;

// Referenced classes of package com.comcast.cim.model.user:
//            User

public abstract class UserDao
    implements KeyValueDao
{

    private final KeyValueStore store;

    public UserDao(KeyValueStore keyvaluestore)
    {
        store = keyvaluestore;
    }

    public User get(String s)
    {
        return (User)store.get(s);
    }

    public void put(User user)
    {
        put(user.getUserKey(), user);
    }

    public void put(String s, User user)
    {
        store.put(s, user);
    }
}
