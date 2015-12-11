// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.follow;


public class Avatar
{

    public static final Avatar EMPTY = new Avatar(null);
    public final String defaultUrl;

    public Avatar(String s)
    {
        defaultUrl = s;
    }

}
