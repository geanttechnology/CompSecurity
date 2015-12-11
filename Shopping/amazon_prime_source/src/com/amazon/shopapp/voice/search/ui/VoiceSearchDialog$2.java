// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.util.Log;
import android.view.View;
import com.amazon.shopapp.voice.search.VoiceResult;

// Referenced classes of package com.amazon.shopapp.voice.search.ui:
//            VoiceSearchDialog

class val.idx
    implements android.view.
{

    final VoiceSearchDialog this$0;
    final int val$idx;
    final String val$text;
    final VoiceResult val$voiceResult;

    public void onClick(View view)
    {
        try
        {
            closeDialogAndSearch(val$text, val$voiceResult, val$idx);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e(VoiceSearchDialog.access$100(), "Error", view);
        }
    }

    ()
    {
        this$0 = final_voicesearchdialog;
        val$text = s;
        val$voiceResult = voiceresult;
        val$idx = I.this;
        super();
    }
}
