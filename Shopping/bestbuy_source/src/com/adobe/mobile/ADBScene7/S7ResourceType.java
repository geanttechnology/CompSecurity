// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile.ADBScene7;


public final class S7ResourceType extends Enum
{

    private static final S7ResourceType $VALUES[];
    public static final S7ResourceType S7ResourceTypeContent;
    public static final S7ResourceType S7ResourceTypeImage;
    private String resourceType;

    private S7ResourceType(String s, int i, String s1)
    {
        super(s, i);
        resourceType = s1;
    }

    public static S7ResourceType valueOf(String s)
    {
        return (S7ResourceType)Enum.valueOf(com/adobe/mobile/ADBScene7/S7ResourceType, s);
    }

    public static S7ResourceType[] values()
    {
        return (S7ResourceType[])$VALUES.clone();
    }

    public String getTypeName()
    {
        return resourceType;
    }

    static 
    {
        S7ResourceTypeImage = new S7ResourceType("S7ResourceTypeImage", 0, "image");
        S7ResourceTypeContent = new S7ResourceType("S7ResourceTypeContent", 1, "content");
        $VALUES = (new S7ResourceType[] {
            S7ResourceTypeImage, S7ResourceTypeContent
        });
    }
}
