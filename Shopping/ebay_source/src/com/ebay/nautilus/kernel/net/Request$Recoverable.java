// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.IOException;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Request, Response

public static interface 
{

    public abstract void clearResponse();

    public abstract int getRetryCount();

    public abstract boolean hasRecoverableError(Response response, IOException ioexception);
}
