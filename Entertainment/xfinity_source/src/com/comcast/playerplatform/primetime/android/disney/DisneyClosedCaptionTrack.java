// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.disney;

import com.adobe.mediacore.info.ClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;

public class DisneyClosedCaptionTrack extends PlayerClosedCaptionsTrack
{

    public DisneyClosedCaptionTrack(boolean flag)
    {
        super(null, flag);
    }

    public String getName()
    {
        return "CC1";
    }

    protected ClosedCaptionsTrack getTrack()
    {
        return null;
    }

    public boolean isActive()
    {
        return true;
    }

    public boolean isDefault()
    {
        return true;
    }

    public boolean isSelected()
    {
        return super.isSelected();
    }

    public void setIsSelected(boolean flag)
    {
        isSelected = flag;
    }
}
