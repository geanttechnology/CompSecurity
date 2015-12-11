// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.framework.Tracer;

public interface TokenManagementDefinition
{

    public abstract MAPFuture getCookies(String s, String s1, Bundle bundle, Callback callback, Tracer tracer);

    public abstract MAPFuture getToken(String s, String s1, Bundle bundle, Callback callback, Tracer tracer);
}
