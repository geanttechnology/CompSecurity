// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage

public class AccountTransaction
{

    private final DataStorage mDataStorage;
    private final String mDirectedId;
    private final Map mTokens;
    private final Map mUserData;

    public AccountTransaction(String s, Map map, Map map1)
    {
        this(s, map, map1, null);
    }

    public AccountTransaction(String s, Map map, Map map1, DataStorage datastorage)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("AccountData directedId cannot be null");
        }
        mDirectedId = s;
        if (map == null)
        {
            mUserData = new HashMap();
        } else
        {
            mUserData = map;
        }
        if (map1 == null)
        {
            mTokens = new HashMap();
        } else
        {
            mTokens = map1;
        }
        mDataStorage = datastorage;
    }

    public String getDirectedId()
    {
        return mDirectedId;
    }

    public String getToken(String s)
    {
        String s2 = (String)mTokens.get(s);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = s2;
            if (mDataStorage != null)
            {
                s1 = mDataStorage.getToken(mDirectedId, s);
            }
        }
        return s1;
    }

    public Map getTokens()
    {
        return mTokens;
    }

    public String getUserData(String s)
    {
        String s2 = (String)mUserData.get(s);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = s2;
            if (mDataStorage != null)
            {
                s1 = mDataStorage.getUserData(mDirectedId, s);
            }
        }
        return s1;
    }

    public Map getUserData()
    {
        return mUserData;
    }

    public void setToken(String s, String s1)
    {
        mTokens.put(s, s1);
    }

    public void setUserData(String s, String s1)
    {
        mUserData.put(s, s1);
    }
}
