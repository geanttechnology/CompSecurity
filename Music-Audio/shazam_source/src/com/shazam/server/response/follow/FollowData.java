// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.follow;


public class FollowData
{

    public static final FollowData EMPTY = new FollowData(null, null, null);
    public final String id;
    public final String key;
    public final String type;

    private FollowData(String s, String s1, String s2)
    {
        key = s;
        id = s1;
        type = s2;
    }

}
