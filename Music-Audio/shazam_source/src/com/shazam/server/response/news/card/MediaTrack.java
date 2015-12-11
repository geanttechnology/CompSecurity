// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.news.card;


public class MediaTrack
{

    public static final MediaTrack EMPTY = new MediaTrack(null, null, null);
    public final String id;
    public final String subtitle;
    public final String title;

    private MediaTrack(String s, String s1, String s2)
    {
        title = s;
        subtitle = s1;
        id = s2;
    }

}
