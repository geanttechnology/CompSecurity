// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            WXMediaMessage

public final class GetMessageFromWX
{
    public static class Req extends BaseReq
    {

        public String country;
        public String lang;

        public boolean checkArgs()
        {
            return true;
        }

        public void fromBundle(Bundle bundle)
        {
            super.fromBundle(bundle);
            lang = bundle.getString("_wxapi_getmessage_req_lang");
            country = bundle.getString("_wxapi_getmessage_req_country");
        }

        public int getType()
        {
            return 3;
        }

        public void toBundle(Bundle bundle)
        {
            super.toBundle(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", lang);
            bundle.putString("_wxapi_getmessage_req_country", country);
        }

        public Req()
        {
        }

        public Req(Bundle bundle)
        {
            fromBundle(bundle);
        }
    }

    public static class Resp extends BaseResp
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
            message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        public int getType()
        {
            return 3;
        }

        public void toBundle(Bundle bundle)
        {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(message));
        }

        public Resp()
        {
        }
    }


    private GetMessageFromWX()
    {
    }
}
