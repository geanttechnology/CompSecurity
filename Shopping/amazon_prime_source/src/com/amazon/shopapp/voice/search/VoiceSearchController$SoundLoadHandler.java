// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;

import android.media.SoundPool;
import android.util.Log;
import android.util.SparseIntArray;
import com.amazon.shopapp.voice.module.VoiceContext;

// Referenced classes of package com.amazon.shopapp.voice.search:
//            VoiceSearchController

private class <init>
    implements android.media..SoundLoadHandler
{

    final VoiceSearchController this$0;

    public void onLoadComplete(SoundPool soundpool, int i, int j)
    {
_L3:
        j = VoiceSearchController.access$600(VoiceSearchController.this).get(i);
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        Log.e(VoiceSearchController.access$500(), (new StringBuilder()).append("Unknown sample: ").append(i).toString());
_L1:
        VoiceSearchController.access$800(VoiceSearchController.this, soundpool, i);
        return;
        VoiceSearchController.access$700(VoiceSearchController.this).put(j, i);
          goto _L1
        try
        {
            if (VoiceContext.isDebug())
            {
                Log.d(VoiceSearchController.access$500(), (new StringBuilder()).append("Sound loaded: ").append(i).append(", status: ").append(j).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (SoundPool soundpool)
        {
            Log.e(VoiceSearchController.access$500(), (new StringBuilder()).append("Failed to play sample ").append(i).toString(), soundpool);
            return;
        }
        if (j != 0)
        {
            return;
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    private ()
    {
        this$0 = VoiceSearchController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
