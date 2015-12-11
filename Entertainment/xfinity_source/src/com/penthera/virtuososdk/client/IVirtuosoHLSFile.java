// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;

import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.client:
//            IVirtuosoAsset

public interface IVirtuosoHLSFile
    extends IVirtuosoAsset
{

    public abstract int addFragments(List list);

    public abstract double expectedSize();

    public abstract List fragments();

    public abstract boolean isPending();

    public abstract String localBaseDir();

    public abstract int totalFragments();

    public abstract int totalFragmentsComplete();
}
