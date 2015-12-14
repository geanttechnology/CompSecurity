// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;
import com.inmobi.rendering.RenderView;

// Referenced classes of package com.inmobi.ads:
//            AdUnit

final class r extends Handler
{

    private AdUnit a;

    public r(AdUnit adunit)
    {
        a = adunit;
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            a.n().stopLoading();
            break;
        }
        a.v();
    }
}
