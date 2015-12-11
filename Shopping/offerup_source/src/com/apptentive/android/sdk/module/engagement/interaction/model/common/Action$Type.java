// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model.common;

import com.apptentive.android.sdk.Log;

public final class  extends Enum
{

    private static final unknown $VALUES[];
    public static final unknown dismiss;
    public static final unknown interaction;
    public static final unknown unknown;

    public static  parse(String s)
    {
         ;
        try
        {
             = valueOf(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.v((new StringBuilder("Error parsing unknown Action.Type: ")).append(s).toString(), new Object[0]);
            return unknown;
        }
        return ;
    }

    public static unknown valueOf(String s)
    {
        return (unknown)Enum.valueOf(com/apptentive/android/sdk/module/engagement/interaction/model/common/Action$Type, s);
    }

    public static unknown[] values()
    {
        return (unknown[])$VALUES.clone();
    }

    static 
    {
        dismiss = new <init>("dismiss", 0);
        interaction = new <init>("interaction", 1);
        unknown = new <init>("unknown", 2);
        $VALUES = (new .VALUES[] {
            dismiss, interaction, unknown
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
