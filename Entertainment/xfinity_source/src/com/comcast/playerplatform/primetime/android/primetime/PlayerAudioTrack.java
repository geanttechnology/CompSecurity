// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.info.AudioTrack;

public class PlayerAudioTrack
{

    private AudioTrack audioTrack;
    private boolean isSelected;

    protected PlayerAudioTrack(AudioTrack audiotrack, boolean flag)
    {
        audioTrack = audiotrack;
        isSelected = flag;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlayerAudioTrack))
            {
                return false;
            }
            obj = (PlayerAudioTrack)obj;
            if (isSelected != ((PlayerAudioTrack) (obj)).isSelected)
            {
                return false;
            }
            String s = getLanguage();
            if (s == null ? ((PlayerAudioTrack) (obj)).getLanguage() != null : !s.equals(((PlayerAudioTrack) (obj)).getLanguage()))
            {
                return false;
            }
        }
        return true;
    }

    public String getLanguage()
    {
        return audioTrack.getLanguage();
    }

    protected AudioTrack getTrack()
    {
        return audioTrack;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (audioTrack != null)
        {
            i = audioTrack.hashCode();
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

    public boolean isDefault()
    {
        return audioTrack.isDefault();
    }

    public boolean isSelected()
    {
        return isSelected;
    }
}
