// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.os.IBinder;
import com.amazon.identity.auth.device.callback.IGenericIPC;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceManager, GenericIPCSender

static final class  extends BoundServiceManager
{

    protected IGenericIPC asInterface(IBinder ibinder)
    {
        return com.amazon.identity.auth.device.callback.Interface(ibinder);
    }

    protected volatile Object asInterface(IBinder ibinder)
    {
        return asInterface(ibinder);
    }

    (Context context, String s, Executor executor)
    {
        super(context, s, executor);
    }
}
