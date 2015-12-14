// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;


// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            ChangeList

public static final class A extends Enum
{

    private static final REMOVED $VALUES[];
    public static final REMOVED ADDED;
    public static final REMOVED MODIFIED;
    public static final REMOVED REMOVED;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/amazon/gallery/framework/data/dao/ChangeList$ChangeType, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        ADDED = new <init>("ADDED", 0);
        MODIFIED = new <init>("MODIFIED", 1);
        REMOVED = new <init>("REMOVED", 2);
        $VALUES = (new .VALUES[] {
            ADDED, MODIFIED, REMOVED
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
