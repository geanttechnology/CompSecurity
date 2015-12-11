// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smule.pianoandroid.synths.SoundPoolSynth;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

public class v extends BroadcastReceiver
{

    final MagicActivity a;

    public v(MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        SoundPoolSynth.setVolumeScaleForHeadphones(intent.getIntExtra("state", 0));
    }
}
