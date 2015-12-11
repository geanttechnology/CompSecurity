// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import com.amazon.identity.auth.device.storage.StorageKeyUtils;

public final class KeyInfo
{

    private final String mKey;
    private final String mPackageName;
    private final String mRawKey;

    public KeyInfo(String s, String s1)
    {
        mRawKey = StorageKeyUtils.getKeyWithPackageNamespace(s, s1);
        mPackageName = s;
        mKey = s1;
    }

    private KeyInfo(String s, String s1, String s2)
    {
        mRawKey = s;
        mPackageName = s1;
        mKey = s2;
    }

    public static KeyInfo parseKey(String s)
    {
        int i = s.indexOf('/');
        String s1;
        String s2;
        if (i == -1)
        {
            s2 = null;
            s1 = s;
        } else
        {
            s2 = s.substring(0, i);
            s1 = s.substring(i + 1);
        }
        return new KeyInfo(s, s2, s1);
    }

    public String getKey()
    {
        return mKey;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public KeyInfo getPackagelessKeyInfo()
    {
        return new KeyInfo(null, getKey());
    }

    public String getRawKey()
    {
        return mRawKey;
    }
}
