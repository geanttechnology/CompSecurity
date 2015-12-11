// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ProgressCallback, ParseFile, ParseExecutors

static final class >
    implements ProgressCallback
{

    final ProgressCallback val$progressCallback;

    public void done(final Integer percentDone)
    {
        j.a(new Callable() {

            final ParseFile._cls1 this$0;
            final Integer val$percentDone;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                progressCallback.done(percentDone);
                return null;
            }

            
            {
                this$0 = ParseFile._cls1.this;
                percentDone = integer;
                super();
            }
        }, ParseExecutors.main());
    }

    back(ProgressCallback progresscallback)
    {
        val$progressCallback = progresscallback;
        super();
    }
}
