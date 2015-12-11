// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import java.util.concurrent.Callable;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

private abstract class <init>
    implements Callable
{

    private String errorMessage;
    private Runnable errorRunnable = new Runnable() {

        final OAuth2Session.ErrorReportingStringCallable this$1;

        public void run()
        {
            OAuth2Session.access$800(this$0).onError(errorMessage);
        }

            
            {
                this$1 = OAuth2Session.ErrorReportingStringCallable.this;
                super();
            }
    };
    final OAuth2Session this$0;

    public void dispatchError(String s)
    {
        errorMessage = s;
        dispatchAsyncResult(errorRunnable);
    }


    private _cls1.this._cls1()
    {
        this$0 = OAuth2Session.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
