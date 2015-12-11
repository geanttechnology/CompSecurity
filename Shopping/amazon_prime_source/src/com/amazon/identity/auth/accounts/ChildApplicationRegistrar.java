// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.kcpsdk.common.WebRequest;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ChildApplicationRegistrarCallback

public interface ChildApplicationRegistrar
{

    public abstract void registerChild(String s, WebRequest webrequest, ChildApplicationRegistrarCallback childapplicationregistrarcallback, Tracer tracer);
}
