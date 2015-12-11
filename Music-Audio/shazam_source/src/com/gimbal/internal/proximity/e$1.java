// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.gimbal.internal.proximity:
//            e

final class 
    implements ThreadFactory
{

    public final Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, "PropertyChangeNotify");
    }

    ()
    {
    }
}
