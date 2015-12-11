// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import com.poshmark.http.api.PMApiError;

public interface GoogleConnectCallback
{

    public abstract void error(PMApiError pmapierror);

    public abstract void success(String s);
}
