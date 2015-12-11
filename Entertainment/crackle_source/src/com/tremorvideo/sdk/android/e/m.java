// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;


abstract class m
{

    m()
    {
    }

    private String a(String s)
    {
        if (s != null)
        {
            return s.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
        } else
        {
            return "";
        }
    }

    public abstract String a();

    public String toString()
    {
        return a(a());
    }
}
