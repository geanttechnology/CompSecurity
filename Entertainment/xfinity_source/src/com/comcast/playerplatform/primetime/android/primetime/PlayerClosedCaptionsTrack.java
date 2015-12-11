// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.info.ClosedCaptionsTrack;

public class PlayerClosedCaptionsTrack
{

    private ClosedCaptionsTrack closedCaptionsTrack;
    protected boolean isSelected;

    public PlayerClosedCaptionsTrack(ClosedCaptionsTrack closedcaptionstrack, boolean flag)
    {
        closedCaptionsTrack = closedcaptionstrack;
        isSelected = flag;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlayerClosedCaptionsTrack))
            {
                return false;
            }
            obj = (PlayerClosedCaptionsTrack)obj;
            if (isSelected != ((PlayerClosedCaptionsTrack) (obj)).isSelected)
            {
                return false;
            }
            if (isActive() != ((PlayerClosedCaptionsTrack) (obj)).isActive())
            {
                return false;
            }
            String s = getName();
            if (s == null ? ((PlayerClosedCaptionsTrack) (obj)).getName() != null : !s.equals(((PlayerClosedCaptionsTrack) (obj)).getName()))
            {
                return false;
            }
        }
        return true;
    }

    public String getName()
    {
        return closedCaptionsTrack.getName();
    }

    protected ClosedCaptionsTrack getTrack()
    {
        return closedCaptionsTrack;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (closedCaptionsTrack != null)
        {
            i = closedCaptionsTrack.hashCode();
        } else
        {
            i = 0;
        }
        if (isSelected)
        {
            j = 1;
        }
        return i * 31 + j;
    }

    public boolean isActive()
    {
        return closedCaptionsTrack.isActive();
    }

    public boolean isDefault()
    {
        return closedCaptionsTrack.isDefault();
    }

    public boolean isSelected()
    {
        return isSelected;
    }
}
