// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.ClipboardManager;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMPasteboard, MMJSResponse

class val.context
    implements Callable
{

    final BridgeMMPasteboard this$0;
    final Context val$context;

    public MMJSResponse call()
    {
        CharSequence charsequence = ((ClipboardManager)val$context.getSystemService("clipboard")).getText();
        Object obj;
        obj = null;
        if (charsequence == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        obj = charsequence.toString();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj = MMJSResponse.responseWithSuccess(((String) (obj)));
        return ((MMJSResponse) (obj));
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = final_bridgemmpasteboard;
        val$context = Context.this;
        super();
    }
}
