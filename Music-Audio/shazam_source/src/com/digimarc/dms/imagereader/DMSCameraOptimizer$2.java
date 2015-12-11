// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;

import java.util.Comparator;

// Referenced classes of package com.digimarc.dms.imagereader:
//            DMSCameraOptimizer, ResolutionPoints

static final class 
    implements Comparator
{

    public final int compare(ResolutionPoints resolutionpoints, ResolutionPoints resolutionpoints1)
    {
        return resolutionpoints1.compareTo(resolutionpoints);
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        return compare((ResolutionPoints)obj, (ResolutionPoints)obj1);
    }

    ()
    {
    }
}
