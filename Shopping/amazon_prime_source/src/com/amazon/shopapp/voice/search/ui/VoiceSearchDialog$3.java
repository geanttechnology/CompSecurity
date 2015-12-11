// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.app.Activity;
import android.util.Log;

// Referenced classes of package com.amazon.shopapp.voice.search.ui:
//            VoiceSearchDialog

static final class val.count
    implements Runnable
{

    final Activity val$activity;
    final int val$count;

    public void run()
    {
        try
        {
            VoiceSearchDialog.access$200(val$activity, val$count - 1);
            return;
        }
        catch (Exception exception)
        {
            Log.e(VoiceSearchDialog.access$100(), "Error", exception);
        }
    }

    (Activity activity1, int i)
    {
        val$activity = activity1;
        val$count = i;
        super();
    }
}
