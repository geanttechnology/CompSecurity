// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


// Referenced classes of package com.shazam.model:
//            Action, ActionType

public static class 
{

    public String artist;
    public String coverArt;
    public String href;
    public String id;
    public String key;
    public boolean panel;
    public String trackTitle;
    public ActionType type;
    public String uri;

    public static  a()
    {
        return new <init>();
    }

    static ActionType a(<init> <init>1)
    {
        return <init>1.type;
    }

    static String b(type type1)
    {
        return type1.id;
    }

    static String c(id id1)
    {
        return id1.uri;
    }

    static boolean d(uri uri1)
    {
        return uri1.panel;
    }

    static String e(panel panel1)
    {
        return panel1.href;
    }

    static String f(href href1)
    {
        return href1.key;
    }

    static String g(key key1)
    {
        return key1.artist;
    }

    static String h(artist artist1)
    {
        return artist1.trackTitle;
    }

    static String i(trackTitle tracktitle)
    {
        return tracktitle.coverArt;
    }

    public final Action b()
    {
        return new Action(this, null);
    }

    public ()
    {
    }
}
