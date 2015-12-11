// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.content.DialogInterface;

// Referenced classes of package com.mopub.mraid:
//            MraidNativeCommandHandler

class aidCommandFailureListener
    implements android.content.ner
{

    final MraidNativeCommandHandler this$0;
    final Context val$context;
    final aidCommandFailureListener val$failureListener;
    final String val$imageUrl;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        downloadImage(val$context, val$imageUrl, val$failureListener);
    }

    aidCommandFailureListener()
    {
        this$0 = final_mraidnativecommandhandler;
        val$context = context1;
        val$imageUrl = s;
        val$failureListener = aidCommandFailureListener.this;
        super();
    }
}
