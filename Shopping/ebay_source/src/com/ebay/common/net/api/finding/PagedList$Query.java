// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.finding:
//            PagedList

public static interface Exception
{

    public abstract void fill(ArrayList arraylist, int i, int j)
        throws com.ebay.nautilus.kernel.net.equestDataException, com.ebay.nautilus.kernel.net.esponseDataException, com.ebay.nautilus.kernel.net.rorException, IOException, InterruptedException;

    public abstract int query()
        throws com.ebay.nautilus.kernel.net.equestDataException, com.ebay.nautilus.kernel.net.esponseDataException, com.ebay.nautilus.kernel.net.rorException, IOException, InterruptedException;
}
