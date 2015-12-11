// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.service;

import com.comcast.cim.cmasl.utils.exceptions.CimException;

// Referenced classes of package com.comcast.cim.cmasl.http.service:
//            RetryingHttpService

public static interface 
{

    public abstract boolean shouldRetry(CimException cimexception, int i);
}
