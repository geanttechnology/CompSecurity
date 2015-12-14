// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public abstract class BaseResp
{

    public int errCode;
    public String errStr;
    public String transaction;

    public BaseResp()
    {
    }

    abstract boolean checkArgs();

    public void fromBundle(Bundle bundle)
    {
        errCode = bundle.getInt("_wxapi_baseresp_errcode");
        errStr = bundle.getString("_wxapi_baseresp_errstr");
        transaction = bundle.getString("_wxapi_baseresp_transaction");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle)
    {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putInt("_wxapi_baseresp_errcode", errCode);
        bundle.putString("_wxapi_baseresp_errstr", errStr);
        bundle.putString("_wxapi_baseresp_transaction", transaction);
    }
}
