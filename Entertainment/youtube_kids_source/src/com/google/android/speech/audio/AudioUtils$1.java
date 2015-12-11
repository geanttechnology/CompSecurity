// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;


class coding
{

    static final int $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding[];

    static 
    {
        $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding = new int[coding.values().length];
        try
        {
            $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding[coding.AMR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding[coding.AMRWB.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
