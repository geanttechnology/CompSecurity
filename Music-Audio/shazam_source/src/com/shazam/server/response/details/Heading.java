// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.details;


public class Heading
{

    public static final Heading EMPTY = new Heading(null, null);
    public final String subtitle;
    public final String title;

    private Heading(String s, String s1)
    {
        title = s;
        subtitle = s1;
    }

}
