// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import java.io.InputStream;

interface OmniataHttpResponseHandler
{

    public abstract void onComplete(int i, InputStream inputstream);

    public abstract void onError(Exception exception);
}
