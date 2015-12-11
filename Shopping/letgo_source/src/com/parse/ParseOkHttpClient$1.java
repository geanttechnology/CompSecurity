// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.squareup.okhttp.Call;

// Referenced classes of package com.parse:
//            ParseOkHttpClient

static final class val.okHttpCall
    implements Runnable
{

    final Call val$okHttpCall;

    public void run()
    {
        val$okHttpCall.cancel();
    }

    (Call call)
    {
        val$okHttpCall = call;
        super();
    }
}
