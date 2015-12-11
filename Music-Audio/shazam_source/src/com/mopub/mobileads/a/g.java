// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.a;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public final class g
{

    private static g a = new g();

    public g()
    {
    }

    public static DefaultHttpClient a()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        return new DefaultHttpClient(basichttpparams);
    }

}
