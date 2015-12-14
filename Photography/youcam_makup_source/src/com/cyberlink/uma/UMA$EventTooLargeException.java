// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;


public class a extends IllegalArgumentException
{

    static String a(String s, int i)
    {
        return (new StringBuilder()).append("The estimated size is ").append(i).append(" that is greater than ").append(5000).append(". key:").append(s.substring(0, Math.min(s.length(), 40))).toString();
    }

    (String s, int i)
    {
        super(a(s, i));
    }
}
