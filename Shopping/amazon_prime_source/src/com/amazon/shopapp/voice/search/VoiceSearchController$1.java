// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;

import android.media.MediaPlayer;
import android.util.Log;
import com.amazon.shopapp.voice.search.ui.SpeechPanel;

// Referenced classes of package com.amazon.shopapp.voice.search:
//            VoiceSearchController

class this._cls0
    implements android.media.Listener
{

    final VoiceSearchController this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (VoiceSearchController.access$100(VoiceSearchController.this) != mediaplayer)
        {
            return;
        }
        try
        {
            if (!VoiceSearchController.access$200(VoiceSearchController.this) && VoiceSearchController.access$300(VoiceSearchController.this).isActive())
            {
                startSpeechRecognition();
            }
            VoiceSearchController.access$400(VoiceSearchController.this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            Log.e(VoiceSearchController.access$500(), "Error", mediaplayer);
        }
        return;
    }

    ()
    {
        this$0 = VoiceSearchController.this;
        super();
    }
}
