// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.framework.Tracer;
import java.util.EnumSet;

public interface CustomerAttributeStoreDefinition
{

    public abstract MAPFuture getAttribute(String s, String s1, Callback callback, Bundle bundle, EnumSet enumset, Tracer tracer);

    public abstract Bundle peekAttribute(String s, String s1);

    public abstract MAPFuture setAttribute(String s, String s1, String s2, Callback callback);
}
