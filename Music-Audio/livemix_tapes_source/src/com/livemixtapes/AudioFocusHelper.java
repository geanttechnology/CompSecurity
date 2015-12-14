// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.media.AudioManager;

// Referenced classes of package com.livemixtapes:
//            MusicFocusable

public class AudioFocusHelper
    implements android.media.AudioManager.OnAudioFocusChangeListener
{

    AudioManager mAM;
    MusicFocusable mFocusable;

    public AudioFocusHelper(Context context, MusicFocusable musicfocusable)
    {
        mAM = (AudioManager)context.getSystemService("audio");
        mFocusable = musicfocusable;
    }

    public boolean abandonFocus()
    {
        return 1 == mAM.abandonAudioFocus(this);
    }

    public void onAudioFocusChange(int i)
    {
        if (mFocusable == null)
        {
            return;
        }
        switch (i)
        {
        case 0: // '\0'
        default:
            return;

        case -3: 
            mFocusable.onLostAudioFocus(true);
            return;

        case 1: // '\001'
            mFocusable.onGainedAudioFocus();
            return;

        case -2: 
        case -1: 
            mFocusable.onLostAudioFocus(false);
            return;
        }
    }

    public boolean requestFocus()
    {
        return 1 == mAM.requestAudioFocus(this, 3, 1);
    }
}
