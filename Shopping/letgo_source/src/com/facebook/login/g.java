// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

public class g
{

    private final AccessToken a;
    private final Set b;
    private final Set c;

    public g(AccessToken accesstoken, Set set, Set set1)
    {
        a = accesstoken;
        b = set;
        c = set1;
    }

    public AccessToken a()
    {
        return a;
    }

    public Set b()
    {
        return b;
    }
}
