// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

public interface IPCCommand
{

    public abstract Bundle performIPCAction(Context context, Bundle bundle, Callback callback);
}
