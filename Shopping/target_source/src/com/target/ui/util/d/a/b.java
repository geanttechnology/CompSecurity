// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d.a;


public final class b
{

    public final String formattingAppliedString;
    public final String inputString;
    public final String noFormattingString;
    public final boolean wasFormattingNeeded;

    public b(boolean flag, String s, String s1, String s2)
    {
        wasFormattingNeeded = flag;
        inputString = s;
        noFormattingString = s1;
        formattingAppliedString = s2;
    }
}
