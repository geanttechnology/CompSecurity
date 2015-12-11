// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import com.rdio.android.core.RdioApiResponse;

public interface RdioResponseListener
    extends com.rdio.android.core.RdioService_Api.ResponseListener
{

    public abstract void onResponse(RdioApiResponse rdioapiresponse);
}
