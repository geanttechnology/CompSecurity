// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.w;

import com.bumptech.glide.load.e;
import java.net.URL;
import myobfuscated.v.ae;
import myobfuscated.v.af;
import myobfuscated.v.t;

public final class j
    implements ae
{

    private final ae a;

    public j(ae ae1)
    {
        a = ae1;
    }

    public final af buildLoadData(Object obj, int i, int k, e e)
    {
        obj = (URL)obj;
        return a.buildLoadData(new t(((URL) (obj))), i, k, e);
    }

    public final volatile boolean handles(Object obj)
    {
        return true;
    }
}
