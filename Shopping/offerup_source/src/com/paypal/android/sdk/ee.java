// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            ci, co, cp, ck, 
//            ac

public abstract class ee extends ci
{

    public ee(cp cp, ck ck, ac ac, String s)
    {
        super(new co(cp), ck, ac, (new StringBuilder("Bearer ")).append(s).toString());
        a("Content-Type", "application/json");
        a("Accept", "application/json");
    }
}
