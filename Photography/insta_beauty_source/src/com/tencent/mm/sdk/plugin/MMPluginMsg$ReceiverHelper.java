// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.plugin;

import android.content.Intent;

public class intent
{

    Intent intent;
    int type;

    public String getMsgContent()
    {
        if (isRecvNew())
        {
            return intent.getStringExtra("recv_msg");
        } else
        {
            return null;
        }
    }

    public Integer getSendErrCode()
    {
        if (isSendRet())
        {
            return Integer.valueOf(intent.getIntExtra("send_err_code", 0));
        } else
        {
            return null;
        }
    }

    public Integer getSendErrType()
    {
        if (isSendRet())
        {
            return Integer.valueOf(intent.getIntExtra("send_err_type", 0));
        } else
        {
            return null;
        }
    }

    public Long getSendMsgId()
    {
        if (isSendRet())
        {
            return Long.valueOf(intent.getLongExtra("send_id", 0L));
        } else
        {
            return null;
        }
    }

    public boolean isRecvNew()
    {
        return type == 2;
    }

    public boolean isSendRet()
    {
        return type == 1;
    }

    public (Intent intent1)
    {
        type = intent1.getIntExtra("type", 0);
        intent = intent1;
    }
}
