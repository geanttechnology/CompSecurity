// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import android.app.Activity;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.shopapp.voice.module.KeyboardModeListener;

// Referenced classes of package com.amazon.mShop.voice:
//            VoiceSearchInitializer

public class this._cls0
    implements KeyboardModeListener
{

    final VoiceSearchInitializer this$0;

    public void search(Activity activity)
    {
        if (!(activity instanceof AmazonActivity))
        {
            return;
        }
        try
        {
            ((AmazonActivity)activity).onSearchRequested();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(VoiceSearchInitializer.access$000(), "Failed to open search", activity);
        }
        return;
    }

    public ()
    {
        this$0 = VoiceSearchInitializer.this;
        super();
    }
}
