// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback.commands;


public class SetSequenceEvent
{

    private final String parentKey;
    private final Class sequencerUnitType;
    private final int startPosition;

    public SetSequenceEvent(String s, int i, Class class1)
    {
        parentKey = s;
        startPosition = i;
        sequencerUnitType = class1;
    }

    public String getParentKey()
    {
        return parentKey;
    }

    public Class getSequencerUnitType()
    {
        return sequencerUnitType;
    }

    public int getStartPosition()
    {
        return startPosition;
    }
}
