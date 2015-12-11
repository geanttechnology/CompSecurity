// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import com.digimarc.dms.imagereader.Payload;

// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverService, ResolveResult

public static interface 
{

    public abstract void onError(Payload payload);

    public abstract void onResolvedUnknown(ResolveResult resolveresult);

    public abstract void onResolvedWithPayoff(ResolveResult resolveresult);
}
