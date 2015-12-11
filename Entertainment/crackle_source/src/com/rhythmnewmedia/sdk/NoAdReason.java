// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import java.io.PrintStream;

public final class NoAdReason extends Enum
{

    private static final NoAdReason a[];
    public static final NoAdReason error;
    public static final NoAdReason noAd;

    private NoAdReason(String s, int i)
    {
        super(s, i);
    }

    public static void main(String args[])
    {
        System.out.println(String.format("RhythmSDK %s (%s %s)", new Object[] {
            "5.0.1", "50831", "09/28/2011 04:45 PM"
        }));
    }

    public static NoAdReason valueOf(String s)
    {
        return (NoAdReason)Enum.valueOf(com/rhythmnewmedia/sdk/NoAdReason, s);
    }

    public static NoAdReason[] values()
    {
        return (NoAdReason[])a.clone();
    }

    static 
    {
        noAd = new NoAdReason("noAd", 0);
        error = new NoAdReason("error", 1);
        a = (new NoAdReason[] {
            noAd, error
        });
    }
}
