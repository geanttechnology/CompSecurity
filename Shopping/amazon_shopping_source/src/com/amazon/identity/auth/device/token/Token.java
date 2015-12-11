// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.text.format.Time;
import java.util.Map;

public interface Token
{

    public static final String KEY_TOKEN = "token";

    public abstract Map getData();

    public abstract String getDirectedId();

    public abstract Time getLocalTimestamp();

    public abstract String getType();

    public abstract String toString();
}
