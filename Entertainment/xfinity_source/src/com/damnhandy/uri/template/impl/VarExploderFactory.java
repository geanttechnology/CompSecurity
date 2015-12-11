// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template.impl;

import com.damnhandy.uri.template.DefaultVarExploder;
import com.damnhandy.uri.template.VarExploder;

// Referenced classes of package com.damnhandy.uri.template.impl:
//            VarSpec

public final class VarExploderFactory
{

    public static VarExploder getExploder(Object obj, VarSpec varspec)
    {
        if (obj instanceof VarExploder)
        {
            return (VarExploder)obj;
        } else
        {
            return new DefaultVarExploder(obj);
        }
    }
}
