// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import android.media.MediaPlayer;

// Referenced classes of package com.digidust.elokence.akinator.services:
//            BackgroundSoundsService

class this._cls0
    implements android.media.stener
{

    final BackgroundSoundsService this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        mediaplayer.release();
    }

    ()
    {
        this$0 = BackgroundSoundsService.this;
        super();
    }
}
