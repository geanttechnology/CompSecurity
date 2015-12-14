// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public abstract class b
{

    public int a;
    public String b;
    public String c;

    public b()
    {
    }

    public void a(Bundle bundle)
    {
        a = bundle.getInt("_wxapi_baseresp_errcode");
        b = bundle.getString("_wxapi_baseresp_errstr");
        c = bundle.getString("_wxapi_baseresp_transaction");
    }
}
