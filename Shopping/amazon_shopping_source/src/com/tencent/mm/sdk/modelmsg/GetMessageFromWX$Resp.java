// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            GetMessageFromWX, WXMediaMessage

public static class  extends BaseResp
{

    public WXMediaMessage message;

    public boolean checkArgs()
    {
        if (message == null)
        {
            Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
            return false;
        } else
        {
            return message.checkArgs();
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        message = .fromBundle(bundle);
    }

    public int getType()
    {
        return 3;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putAll(.toBundle(message));
    }

    public ()
    {
    }
}
