// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            SendMessageToWX, WXMediaMessage, WXFileObject

public static class er extends BaseReq
{

    public WXMediaMessage message;
    public int scene;

    public boolean checkArgs()
    {
        if (message == null)
        {
            Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
            return false;
        }
        if (message.mediaObject.type() == 6 && scene == 2)
        {
            ((WXFileObject)(WXFileObject)message.mediaObject).setContentLengthLimit(0x1900000);
        }
        return message.checkArgs();
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        message = er.fromBundle(bundle);
        scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
    }

    public int getType()
    {
        return 2;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putAll(er.toBundle(message));
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", scene);
    }

    public er()
    {
    }
}
