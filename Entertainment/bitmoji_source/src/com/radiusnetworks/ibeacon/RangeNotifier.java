// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import java.util.Collection;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            Region

public interface RangeNotifier
{

    public abstract void didRangeBeaconsInRegion(Collection collection, Region region);
}
