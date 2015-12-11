// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.network;

import java.io.InputStream;

public interface PinningInfoProvider
{

    public abstract String getKeyStorePassword();

    public abstract InputStream getKeyStoreStream();

    public abstract long getPinCreationTimeInMillis();

    public abstract String[] getPins();
}
