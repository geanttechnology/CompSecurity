// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;


// Referenced classes of package com.shazam.android.analytics.event:
//            StringEventParameterKey

public static class 
{

    private String parameterKey;

    static String a( )
    {
        return .parameterKey;
    }

    public static parameterKey stringEventParameterKey()
    {
        return new <init>();
    }

    public StringEventParameterKey build()
    {
        return new StringEventParameterKey(this, (byte)0);
    }

    public <init> withParameterKey(String s)
    {
        parameterKey = s;
        return this;
    }

    public ()
    {
    }
}
