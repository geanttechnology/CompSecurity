// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.content.Context;

public interface MASHApplication
{

    public abstract String getAppCustomUserAgent();

    public abstract Context getApplicationContext();

    public abstract boolean isDebugEnabled();

    public abstract boolean shouldInterceptUrls();
}
