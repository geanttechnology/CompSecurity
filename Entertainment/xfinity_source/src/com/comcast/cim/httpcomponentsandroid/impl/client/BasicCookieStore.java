// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.client.CookieStore;
import com.comcast.cim.httpcomponentsandroid.cookie.Cookie;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieIdentityComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class BasicCookieStore
    implements CookieStore, Serializable
{

    private final TreeSet cookies = new TreeSet(new CookieIdentityComparator());

    public BasicCookieStore()
    {
    }

    public void addCookie(Cookie cookie)
    {
        this;
        JVM INSTR monitorenter ;
        if (cookie == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        cookies.remove(cookie);
        if (!cookie.isExpired(new Date()))
        {
            cookies.add(cookie);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        cookie;
        throw cookie;
    }

    public List getCookies()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(cookies);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s = cookies.toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
