// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;


// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegate

public static final class A extends Enum
{

    private static final IN_PROGRESS $VALUES[];
    public static final IN_PROGRESS CLOSED;
    public static final IN_PROGRESS IN_PROGRESS;
    public static final IN_PROGRESS OPEN;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/comcast/cim/android/sideribbon/SideRibbonDelegate$State, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        CLOSED = new <init>("CLOSED", 0);
        OPEN = new <init>("OPEN", 1);
        IN_PROGRESS = new <init>("IN_PROGRESS", 2);
        $VALUES = (new .VALUES[] {
            CLOSED, OPEN, IN_PROGRESS
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
