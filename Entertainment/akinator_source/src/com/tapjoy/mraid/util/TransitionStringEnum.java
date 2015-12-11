// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.util;


public final class TransitionStringEnum extends Enum
{

    private static final TransitionStringEnum $VALUES[];
    public static final TransitionStringEnum DEFAULT;
    public static final TransitionStringEnum DISSOLVE;
    public static final TransitionStringEnum FADE;
    public static final TransitionStringEnum NONE;
    public static final TransitionStringEnum ROLL;
    public static final TransitionStringEnum SLIDE;
    public static final TransitionStringEnum ZOOM;
    private String text;

    private TransitionStringEnum(String s, int i, String s1)
    {
        super(s, i);
        text = s1;
    }

    public static TransitionStringEnum fromString(String s)
    {
        if (s != null)
        {
            TransitionStringEnum atransitionstringenum[] = values();
            int j = atransitionstringenum.length;
            for (int i = 0; i < j; i++)
            {
                TransitionStringEnum transitionstringenum = atransitionstringenum[i];
                if (s.equalsIgnoreCase(transitionstringenum.text))
                {
                    return transitionstringenum;
                }
            }

        }
        return null;
    }

    public static TransitionStringEnum valueOf(String s)
    {
        return (TransitionStringEnum)Enum.valueOf(com/tapjoy/mraid/util/TransitionStringEnum, s);
    }

    public static TransitionStringEnum[] values()
    {
        return (TransitionStringEnum[])$VALUES.clone();
    }

    public final String getText()
    {
        return text;
    }

    static 
    {
        DEFAULT = new TransitionStringEnum("DEFAULT", 0, "default");
        DISSOLVE = new TransitionStringEnum("DISSOLVE", 1, "dissolve");
        FADE = new TransitionStringEnum("FADE", 2, "fade");
        ROLL = new TransitionStringEnum("ROLL", 3, "roll");
        SLIDE = new TransitionStringEnum("SLIDE", 4, "slide");
        ZOOM = new TransitionStringEnum("ZOOM", 5, "zoom");
        NONE = new TransitionStringEnum("NONE", 6, "none");
        $VALUES = (new TransitionStringEnum[] {
            DEFAULT, DISSOLVE, FADE, ROLL, SLIDE, ZOOM, NONE
        });
    }
}
