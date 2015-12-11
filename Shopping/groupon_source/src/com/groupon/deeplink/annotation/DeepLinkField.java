// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink.annotation;


public final class DeepLinkField extends Enum
{

    private static final DeepLinkField $VALUES[];
    public static final DeepLinkField SPECIFIER;

    private DeepLinkField(String s, int i)
    {
        super(s, i);
    }

    public static DeepLinkField valueOf(String s)
    {
        return (DeepLinkField)Enum.valueOf(com/groupon/deeplink/annotation/DeepLinkField, s);
    }

    public static DeepLinkField[] values()
    {
        return (DeepLinkField[])$VALUES.clone();
    }

    static 
    {
        SPECIFIER = new DeepLinkField("SPECIFIER", 0);
        $VALUES = (new DeepLinkField[] {
            SPECIFIER
        });
    }
}
