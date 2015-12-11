// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import java.util.HashMap;
import java.util.Map;

public class AccountInfoV2
{

    public final Map accountData;
    public final String directedId;
    public final String displayName;

    AccountInfoV2(String s, String s1)
    {
        this(s, s1, ((Map) (new HashMap())));
    }

    AccountInfoV2(String s, String s1, Map map)
    {
        directedId = s;
        displayName = s1;
        accountData = map;
    }
}
