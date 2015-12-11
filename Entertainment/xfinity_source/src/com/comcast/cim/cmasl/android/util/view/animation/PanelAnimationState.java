// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.animation;


public final class PanelAnimationState extends Enum
{

    private static final PanelAnimationState $VALUES[];
    public static final PanelAnimationState CLOSED;
    public static final PanelAnimationState CLOSING;
    public static final PanelAnimationState OPEN;
    public static final PanelAnimationState OPENING;

    private PanelAnimationState(String s, int i)
    {
        super(s, i);
    }

    public static PanelAnimationState valueOf(String s)
    {
        return (PanelAnimationState)Enum.valueOf(com/comcast/cim/cmasl/android/util/view/animation/PanelAnimationState, s);
    }

    public static PanelAnimationState[] values()
    {
        return (PanelAnimationState[])$VALUES.clone();
    }

    static 
    {
        OPENING = new PanelAnimationState("OPENING", 0);
        OPEN = new PanelAnimationState("OPEN", 1);
        CLOSING = new PanelAnimationState("CLOSING", 2);
        CLOSED = new PanelAnimationState("CLOSED", 3);
        $VALUES = (new PanelAnimationState[] {
            OPENING, OPEN, CLOSING, CLOSED
        });
    }
}
