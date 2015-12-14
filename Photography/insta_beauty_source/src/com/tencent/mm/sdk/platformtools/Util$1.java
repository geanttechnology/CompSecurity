// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;

final class stener
    implements android.media.ayer.OnCompletionListener
{

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        mediaplayer.release();
    }

    stener()
    {
    }
}
