// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.beautycircle.wxapi;

import android.app.Activity;
import android.os.Bundle;
import com.cyberlink.beautycircle.utility.ae;
import com.tencent.mm.sdk.openapi.e;
import com.tencent.mm.sdk.openapi.o;

public class WXEntryActivity extends Activity
{

    private e a;

    public WXEntryActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (ae.d != null)
        {
            a = o.a(this, ae.a, false);
            a.a(getIntent(), ae.d);
        }
        finish();
    }
}
