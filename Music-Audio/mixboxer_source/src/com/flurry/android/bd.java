// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, bv, AppCloudResponse

final class bd
    implements AppCloudResponseHandler
{

    private String dg;
    private long dh;
    private bv di;

    bd(bv bv1, String s, long l)
    {
        di = bv1;
        dg = s;
        dh = l;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        bv.a(di, appcloudresponse, dg);
        di.a(dg, Long.valueOf(dh));
    }
}
