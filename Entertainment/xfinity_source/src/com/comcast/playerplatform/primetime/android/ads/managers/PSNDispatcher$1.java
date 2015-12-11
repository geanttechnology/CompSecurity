// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import android.util.Log;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            PSNDispatcher

class t> extends AbstractResponseEventListener
{

    final PSNDispatcher this$0;

    public void configurationNotReady()
    {
        super.configurationNotReady();
    }

    public void redirectUrlFound(String s)
    {
        super.redirectUrlFound(s);
    }

    public void requestFailed(String s)
    {
        super.requestFailed(s);
        Log.d("PaukTest", (new StringBuilder()).append("PSN failed:").append(s).toString());
    }

    public void responseReceived(String s)
    {
        Log.d("PaukTest", (new StringBuilder()).append("PSN success:").append(s).toString());
    }

    ()
    {
        this$0 = PSNDispatcher.this;
        super();
    }
}
