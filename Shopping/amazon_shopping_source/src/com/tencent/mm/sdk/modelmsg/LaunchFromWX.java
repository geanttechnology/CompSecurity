// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.platformtools.Log;

public class LaunchFromWX
{
    public static class Req extends BaseReq
    {

        public String country;
        public String lang;
        public String messageAction;
        public String messageExt;

        public boolean checkArgs()
        {
            if (messageAction != null && messageAction.length() > 2048)
            {
                Log.e("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageAction is too long");
                return false;
            }
            if (messageExt != null && messageExt.length() > 2048)
            {
                Log.e("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageExt is too long");
                return false;
            } else
            {
                return true;
            }
        }

        public void fromBundle(Bundle bundle)
        {
            super.fromBundle(bundle);
            messageAction = bundle.getString("_wxobject_message_action");
            messageExt = bundle.getString("_wxobject_message_ext");
            lang = bundle.getString("_wxapi_launch_req_lang");
            country = bundle.getString("_wxapi_launch_req_country");
        }

        public int getType()
        {
            return 6;
        }

        public void toBundle(Bundle bundle)
        {
            super.toBundle(bundle);
            bundle.putString("_wxobject_message_action", messageAction);
            bundle.putString("_wxobject_message_ext", messageExt);
            bundle.putString("_wxapi_launch_req_lang", lang);
            bundle.putString("_wxapi_launch_req_country", country);
        }

        public Req()
        {
        }

        public Req(Bundle bundle)
        {
            fromBundle(bundle);
        }
    }


    private LaunchFromWX()
    {
    }
}
