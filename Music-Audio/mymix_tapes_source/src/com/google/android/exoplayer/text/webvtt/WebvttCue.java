// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.webvtt;

import com.google.android.exoplayer.text.Cue;

final class WebvttCue extends Cue
{

    public final long endTime;
    public final long startTime;

    public WebvttCue(long l, long l1, CharSequence charsequence)
    {
        this(l, l1, charsequence, -1, -1, null, -1);
    }

    public WebvttCue(long l, long l1, CharSequence charsequence, int i, int j, 
            android.text.Layout.Alignment alignment, int k)
    {
        super(charsequence, i, j, alignment, k);
        startTime = l;
        endTime = l1;
    }

    public WebvttCue(CharSequence charsequence)
    {
        this(-1L, -1L, charsequence);
    }

    public boolean isNormalCue()
    {
        return line == -1 && position == -1;
    }
}
