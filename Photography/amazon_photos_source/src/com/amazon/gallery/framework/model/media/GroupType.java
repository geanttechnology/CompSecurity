// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;


public final class GroupType extends Enum
{

    private static final GroupType $VALUES[];
    public static final GroupType BURST;
    public static final GroupType EDIT;
    public static final GroupType HDR;
    public static final GroupType LENTICULAR;
    public static final GroupType NONE;
    public static final GroupType REWIND;
    public final int value;

    private GroupType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static GroupType valueOf(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalStateException("Invalid value");

        case 1: // '\001'
            return HDR;

        case 2: // '\002'
            return BURST;

        case 3: // '\003'
            return EDIT;

        case 0: // '\0'
            return NONE;

        case 4: // '\004'
            return LENTICULAR;

        case 5: // '\005'
            return REWIND;
        }
    }

    public static GroupType valueOf(String s)
    {
        return (GroupType)Enum.valueOf(com/amazon/gallery/framework/model/media/GroupType, s);
    }

    public static GroupType[] values()
    {
        return (GroupType[])$VALUES.clone();
    }

    static 
    {
        NONE = new GroupType("NONE", 0, 0);
        HDR = new GroupType("HDR", 1, 1);
        BURST = new GroupType("BURST", 2, 2);
        EDIT = new GroupType("EDIT", 3, 3);
        LENTICULAR = new GroupType("LENTICULAR", 4, 4);
        REWIND = new GroupType("REWIND", 5, 5);
        $VALUES = (new GroupType[] {
            NONE, HDR, BURST, EDIT, LENTICULAR, REWIND
        });
    }
}
