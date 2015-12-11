// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

final class abi extends bmr
{

    private aaa a;

    abi(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        mh mh1 = (mh)a.t.b_();
        android.content.SharedPreferences sharedpreferences = a.c.i();
        coe coe = a.e();
        aaa aaa1 = a;
        return new cpi(mh1, sharedpreferences, coe, acl.a.c(), a.a(a.a.getContentResolver(), a.c.f()), "YouTubeKidsApp");
    }
}
