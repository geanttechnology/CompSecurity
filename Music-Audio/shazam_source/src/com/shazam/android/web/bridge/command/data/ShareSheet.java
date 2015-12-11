// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;


public class ShareSheet
{

    private String subject;
    private String text;

    private ShareSheet()
    {
    }

    public ShareSheet(String s, String s1)
    {
        subject = s;
        text = s1;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getText()
    {
        return text;
    }
}
