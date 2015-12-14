// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;


public final class Q extends Enum
{

    private static final Invisible $VALUES[];
    public static final Invisible Invisible;
    public static final Invisible Visible;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/instamag/activity/library/view/NumberProgressBar$ProgressTextVisibility, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        Visible = new <init>("Visible", 0);
        Invisible = new <init>("Invisible", 1);
        $VALUES = (new .VALUES[] {
            Visible, Invisible
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
