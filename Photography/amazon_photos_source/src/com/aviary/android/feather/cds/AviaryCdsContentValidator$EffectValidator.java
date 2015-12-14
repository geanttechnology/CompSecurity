// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import java.util.List;
import java.util.zip.ZipFile;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsContentValidator

static class  extends 
{

    boolean validateItem(String s, List list)
        throws AssertionError
    {
        return list.contains((new StringBuilder()).append(s).append(".json").toString());
    }

    boolean validateItem(String s, ZipFile zipfile)
        throws AssertionError
    {
        Assert.assertNotNull("identifier is null", s);
        Assert.assertNotNull("zip is null", zipfile);
        zipfile = zipfile.getEntry((new StringBuilder()).append(s).append(".json").toString());
        Assert.assertNotNull((new StringBuilder()).append(s).append(".json").toString(), zipfile);
        return true;
    }

    ()
    {
    }
}
