// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.voice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.shopapp.voice.module.VoiceSearchActionListener;

// Referenced classes of package com.amazon.now.voice:
//            VoiceSearchInitializer

private static class <init>
    implements VoiceSearchActionListener
{

    public void search(Context context, String s, String s1, String s2, int i, String s3, String s4)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        s = (new SearchIntentBuilder(context)).query(s).build();
        s.putExtra("com.amazon.now.search.method", SearchMethod.VOICE.getName());
        s.putExtra("com.amazon.now.search.voice.asrRequestId", s1);
        s.putExtra("com.amazon.now.search.voice.utteranceId", s2);
        if (i >= 0)
        {
            i++;
        } else
        {
            i = 0;
        }
        s.putExtra("com.amazon.now.search.voice.interpretationNumber", i);
        context.startActivity(s);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
