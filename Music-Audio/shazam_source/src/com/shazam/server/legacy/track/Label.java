// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;


public class Label
{

    private String id;
    private String name;

    private Label()
    {
    }

    public Label(String s, String s1)
    {
        id = s;
        name = s1;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
