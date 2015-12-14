// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public abstract class a
{

    public String a;

    public a()
    {
    }

    public abstract int a();

    public void a(Bundle bundle)
    {
        bundle.putInt("_wxapi_command_type", a());
        bundle.putString("_wxapi_basereq_transaction", a);
    }

    public void b(Bundle bundle)
    {
        a = bundle.getString("_wxapi_basereq_transaction");
    }

    abstract boolean b();
}
