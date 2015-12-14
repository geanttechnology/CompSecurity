// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect;

import android.content.Context;
import com.tencent.connect.b.m;
import com.tencent.connect.common.c;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.b;

public class a extends com.tencent.connect.common.a
{

    public a(Context context, m m)
    {
        super(m);
    }

    public void a(b b)
    {
        android.os.Bundle bundle = c();
        b = new c(this, b);
        HttpUtils.a(this.b, com.tencent.open.utils.c.a(), "user/get_simple_userinfo", bundle, "GET", b);
    }
}
