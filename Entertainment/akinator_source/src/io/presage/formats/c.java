// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;


public final class c extends Exception
{

    private int a;

    public c(int i)
    {
        a = i;
    }

    public final String getMessage()
    {
        switch (a)
        {
        default:
            return "unknown error on the viewer";

        case 0: // '\0'
            return "unable to parse viewer";

        case 1: // '\001'
            return "alert viewer not usable";

        case 2: // '\002'
            return "exoPlayer not available before 16";
        }
    }
}
