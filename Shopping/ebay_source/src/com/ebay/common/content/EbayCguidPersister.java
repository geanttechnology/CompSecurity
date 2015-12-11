// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;


// Referenced classes of package com.ebay.common.content:
//            EbayCguid

public interface EbayCguidPersister
{

    public abstract EbayCguid getCguid(boolean flag);

    public abstract void setCguid(boolean flag, EbayCguid ebaycguid);
}
