// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.media.MediaPlayer;
import android.widget.ImageButton;

// Referenced classes of package com.mopub.mraid:
//            MraidVideoViewController

class this._cls0
    implements android.media.tener
{

    final MraidVideoViewController this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        MraidVideoViewController.access$000(MraidVideoViewController.this).setVisibility(0);
        MraidVideoViewController.access$100(MraidVideoViewController.this, true);
    }

    ner()
    {
        this$0 = MraidVideoViewController.this;
        super();
    }
}
