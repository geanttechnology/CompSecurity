// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            WXMediaMessage

public class ShowMessageFromWX
{
    public static class Req extends BaseReq
    {

        public String country;
        public String lang;
        public WXMediaMessage message;

        public boolean checkArgs()
        {
            if (message == null)
            {
                return false;
            } else
            {
                return message.checkArgs();
            }
        }

        public void fromBundle(Bundle bundle)
        {
            super.fromBundle(bundle);
            lang = bundle.getString("_wxapi_showmessage_req_lang");
            country = bundle.getString("_wxapi_showmessage_req_country");
            message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        public int getType()
        {
            return 4;
        }

        public void toBundle(Bundle bundle)
        {
            Bundle bundle1 = WXMediaMessage.Builder.toBundle(message);
            super.toBundle(bundle1);
            bundle.putString("_wxapi_showmessage_req_lang", lang);
            bundle.putString("_wxapi_showmessage_req_country", country);
            bundle.putAll(bundle1);
        }

        public Req()
        {
        }

        public Req(Bundle bundle)
        {
            fromBundle(bundle);
        }
    }


    private ShowMessageFromWX()
    {
    }
}
