// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import com.wishabi.flipp.util.h;
import org.json.JSONObject;

public final class b
{

    public final int a;
    public final String b;

    public b(JSONObject jsonobject)
    {
        a = jsonobject.getInt("id");
        b = h.a(jsonobject, "disclaimer_text");
    }

    public final String toString()
    {
        return (new StringBuilder("Extra{mCouponId=")).append(a).append(", mDisclaimer='").append(b).append('\'').append('}').toString();
    }
}
