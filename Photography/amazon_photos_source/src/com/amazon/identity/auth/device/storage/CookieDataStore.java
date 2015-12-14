// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import java.util.List;
import java.util.Map;

public abstract class CookieDataStore
{

    public CookieDataStore()
    {
    }

    public abstract boolean clearCookies(Context context, String s);

    public List getAllCookies(String s, String s1)
    {
        return getCookies(s, s1);
    }

    public abstract Map getCookieTokenMapOrWriteToDataStoreFromRegistrationData(String s, List list, String s1);

    protected abstract List getCookies(String s, String s1);

    public List getNonAuthCookies(String s)
    {
        return getCookies(null, s);
    }

    public void setAllCookies(String s, String s1, List list)
    {
        setCookies(s, s1, list);
    }

    protected abstract void setCookies(String s, String s1, List list);

    public void setNonAuthCookies(String s, List list)
    {
        setCookies(null, s, list);
    }
}
