// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.voice;

import android.app.Activity;
import com.amazon.now.AmazonActivity;
import com.amazon.shopapp.voice.module.KeyboardModeListener;

// Referenced classes of package com.amazon.now.voice:
//            VoiceSearchInitializer

private static class <init>
    implements KeyboardModeListener
{

    public void search(Activity activity)
    {
        if (activity instanceof AmazonActivity)
        {
            ((AmazonActivity)activity).search(null, null);
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
