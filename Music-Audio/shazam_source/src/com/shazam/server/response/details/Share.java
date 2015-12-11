// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.details;


public class Share
{

    public static final Share EMPTY = new Share(null, null, null);
    public final String href;
    public final String subject;
    public final String text;

    private Share(String s, String s1, String s2)
    {
        subject = s;
        text = s1;
        href = s2;
    }

}
