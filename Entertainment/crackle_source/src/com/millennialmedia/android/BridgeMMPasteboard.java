// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.ClipboardManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse

class BridgeMMPasteboard extends MMJSObject
{

    BridgeMMPasteboard()
    {
    }

    public MMJSResponse getPasteboardContents(final HashMap context)
    {
        context = (Context)contextRef.get();
        if (context != null)
        {
            return runOnUiThreadFuture(new Callable() {

                final BridgeMMPasteboard this$0;
                final Context val$context;

                public MMJSResponse call()
                {
                    CharSequence charsequence = ((ClipboardManager)context.getSystemService("clipboard")).getText();
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

            
            {
                this$0 = BridgeMMPasteboard.this;
                context = context1;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse writeToPasteboard(final HashMap arguments)
    {
        final Context context = (Context)contextRef.get();
        if (context != null)
        {
            return runOnUiThreadFuture(new Callable() {

                final BridgeMMPasteboard this$0;
                final HashMap val$arguments;
                final Context val$context;

                public MMJSResponse call()
                {
                    MMJSResponse mmjsresponse;
                    try
                    {
                        ((ClipboardManager)context.getSystemService("clipboard")).setText((String)arguments.get("data"));
                        mmjsresponse = MMJSResponse.responseWithSuccess();
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        return null;
                    }
                    return mmjsresponse;
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = BridgeMMPasteboard.this;
                context = context1;
                arguments = hashmap;
                super();
            }
            });
        } else
        {
            return null;
        }
    }
}
