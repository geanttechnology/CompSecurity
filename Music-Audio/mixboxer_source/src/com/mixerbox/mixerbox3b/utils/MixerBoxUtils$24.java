// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import com.loopj.android.http.AsyncHttpResponseHandler;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class  extends AsyncHttpResponseHandler
{

    public final void onFailure(Throwable throwable, String s)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("Cohort: ").append(throwable.toString()).append(" / ").append(s).toString());
    }

    public final void onSuccess(String s)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("Cohort +  / ").append(s).toString());
    }

    ()
    {
    }
}
