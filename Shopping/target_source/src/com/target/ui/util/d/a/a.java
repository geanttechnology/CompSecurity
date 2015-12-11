// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d.a;

import com.target.mothership.common.tender.b;

public final class a
{

    public final b expirationMonth;
    public final Integer expirationYear;
    public final String input;
    public final String noFormatting;
    public final boolean wasFormattingNeeded;
    public final String withFormatting;

    public a(boolean flag, String s, String s1, String s2, b b, Integer integer)
    {
        wasFormattingNeeded = flag;
        input = s;
        noFormatting = s1;
        withFormatting = s2;
        expirationMonth = b;
        expirationYear = integer;
    }
}
