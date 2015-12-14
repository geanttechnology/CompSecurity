// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.content.Context;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXAppExtendObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.Util;

public class MMPluginMsg
{

    public static final String ACTION_AUTO_MSG = "ACTION_AUTO_MSG";
    public static final String RECV_MSG = "recv_msg";
    public static final String RECV_PKG = "recv_pkg";
    public static final String RECV_THUMB = "recv_thumb";
    public static final String SEND_ERR_CODE = "send_err_code";
    public static final String SEND_ERR_TYPE = "send_err_type";
    public static final String SEND_ID = "send_id";
    public static final String TYPE = "type";
    public static final int TYPE_RECV_MSG = 2;
    public static final int TYPE_SEND_RET = 1;
    public String content;
    public long msgClientId;

    public MMPluginMsg()
    {
    }

    public static MMPluginMsg WXAppExtentObjectToPluginMsg(WXAppExtendObject wxappextendobject)
    {
        if (wxappextendobject != null)
        {
            MMPluginMsg mmpluginmsg = new MMPluginMsg();
            mmpluginmsg.msgClientId = Util.getLong(wxappextendobject.extInfo, -1L);
            if (mmpluginmsg.msgClientId != -1L && !Util.isNullOrNil(wxappextendobject.fileData))
            {
                mmpluginmsg.content = new String(wxappextendobject.fileData);
                if (!Util.isNullOrNil(mmpluginmsg.content))
                {
                    return mmpluginmsg;
                }
            }
        }
        return null;
    }

    public static WXAppExtendObject pluginMsgToWXAppExtendObject(MMPluginMsg mmpluginmsg)
    {
        if (mmpluginmsg == null)
        {
            return null;
        } else
        {
            WXAppExtendObject wxappextendobject = new WXAppExtendObject();
            wxappextendobject.extInfo = (new StringBuilder()).append(mmpluginmsg.msgClientId).toString();
            wxappextendobject.fileData = mmpluginmsg.content.getBytes();
            return wxappextendobject;
        }
    }

    public static long sendMessage(Context context, String s)
    {
        if (Util.isNullOrNil(s))
        {
            return -1L;
        }
        MMPluginMsg mmpluginmsg = new MMPluginMsg();
        mmpluginmsg.msgClientId = Util.nowMilliSecond();
        mmpluginmsg.content = s;
        Object obj = pluginMsgToWXAppExtendObject(mmpluginmsg);
        s = new WXMediaMessage();
        s.mediaObject = ((com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject) (obj));
        s.description = "";
        context = WXAPIFactory.createWXAPI(context, null);
        if (context == null)
        {
            return -2L;
        }
        obj = new com.tencent.mm.sdk.openapi.SendMessageToWX.Req();
        obj.transaction = (new StringBuilder("appdata")).append(mmpluginmsg.msgClientId).toString();
        obj.message = s;
        if (!context.sendReq(((com.tencent.mm.sdk.openapi.BaseReq) (obj))))
        {
            return -3L;
        } else
        {
            return mmpluginmsg.msgClientId;
        }
    }
}
