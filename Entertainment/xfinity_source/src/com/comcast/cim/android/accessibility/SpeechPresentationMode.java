// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


public final class SpeechPresentationMode extends Enum
{

    private static final SpeechPresentationMode $VALUES[];
    public static final SpeechPresentationMode OPEN;
    public static final SpeechPresentationMode PLAY;
    public static final SpeechPresentationMode SEARCH;

    private SpeechPresentationMode(String s, int i)
    {
        super(s, i);
    }

    public static SpeechPresentationMode valueOf(String s)
    {
        return (SpeechPresentationMode)Enum.valueOf(com/comcast/cim/android/accessibility/SpeechPresentationMode, s);
    }

    public static SpeechPresentationMode[] values()
    {
        return (SpeechPresentationMode[])$VALUES.clone();
    }

    static 
    {
        SEARCH = new SpeechPresentationMode("SEARCH", 0);
        OPEN = new SpeechPresentationMode("OPEN", 1);
        PLAY = new SpeechPresentationMode("PLAY", 2);
        $VALUES = (new SpeechPresentationMode[] {
            SEARCH, OPEN, PLAY
        });
    }
}
