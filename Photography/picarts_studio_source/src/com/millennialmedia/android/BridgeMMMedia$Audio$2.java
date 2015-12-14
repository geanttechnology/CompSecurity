// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.lang.ref.WeakReference;

class LoadCompleteListener extends LoadCompleteListener
{

    private a a;

    public void onLoadComplete(SoundPool soundpool, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (soundpool == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        Object obj = (Context)LoadCompleteListener(a).get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj = (AudioManager)((Context) (obj)).getSystemService("audio");
        float f = ((float)((AudioManager) (obj)).getStreamVolume(3) + 0.0F) / (float)((AudioManager) (obj)).getStreamMaxVolume(3);
        soundpool.play(i, f, f, 1, 0, 1.0F);
        this;
        JVM INSTR monitorexit ;
        return;
        soundpool;
        throw soundpool;
    }

    LoadCompleteListener(LoadCompleteListener loadcompletelistener, SoundPool soundpool)
    {
        a = loadcompletelistener;
        super(loadcompletelistener, soundpool);
    }
}
