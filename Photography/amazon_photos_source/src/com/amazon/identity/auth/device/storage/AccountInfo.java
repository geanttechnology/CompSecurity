// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.GenericUtils;
import com.amazon.identity.auth.device.utils.PublicCloneable;
import java.util.HashMap;
import java.util.Map;

public class AccountInfo
    implements PublicCloneable
{

    public final String directedId;
    public final String displayName;
    public final Map tokens;
    public final Map userdata;

    public AccountInfo(String s, String s1)
    {
        this(s, s1, ((Map) (new HashMap())));
    }

    public AccountInfo(String s, String s1, Map map)
    {
        this(s, s1, map, ((Map) (new HashMap())));
    }

    public AccountInfo(String s, String s1, Map map, Map map1)
    {
        directedId = s;
        displayName = s1;
        userdata = map;
        tokens = map1;
    }

    public AccountInfo cloneObject()
    {
        return new AccountInfo(directedId, displayName, GenericUtils.cloneMap(userdata), GenericUtils.cloneMap(tokens));
    }

    public volatile PublicCloneable cloneObject()
    {
        return cloneObject();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (AccountInfo)obj;
            if (!TextUtils.equals(directedId, ((AccountInfo) (obj)).directedId) || !TextUtils.equals(displayName, ((AccountInfo) (obj)).displayName) || !GenericUtils.equals(userdata, ((AccountInfo) (obj)).userdata) || !GenericUtils.equals(tokens, ((AccountInfo) (obj)).tokens))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (directedId == null)
        {
            i = 0;
        } else
        {
            i = directedId.hashCode();
        }
        if (displayName == null)
        {
            j = 0;
        } else
        {
            j = displayName.hashCode();
        }
        if (tokens == null)
        {
            k = 0;
        } else
        {
            k = tokens.hashCode();
        }
        if (userdata != null)
        {
            l = userdata.hashCode();
        }
        return (((i + 31) * 31 + j) * 31 + k) * 31 + l;
    }

    public String toString()
    {
        return String.format("DirectedId: %s, Display Name: %s, userdata: %s, tokens: %s", new Object[] {
            directedId, displayName, userdata.toString(), tokens.toString()
        });
    }
}
