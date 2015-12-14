// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.content.res.AssetManager;
import java.io.InputStream;

// Referenced classes of package myobfuscated.q:
//            a

public final class p extends a
{

    public p(AssetManager assetmanager, String s)
    {
        super(assetmanager, s);
    }

    protected final Object a(AssetManager assetmanager, String s)
    {
        return assetmanager.open(s);
    }

    protected final void a(Object obj)
    {
        ((InputStream)obj).close();
    }

    public final Class d()
    {
        return java/io/InputStream;
    }
}
