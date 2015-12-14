// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;

// Referenced classes of package myobfuscated.q:
//            a

public final class i extends a
{

    public i(AssetManager assetmanager, String s)
    {
        super(assetmanager, s);
    }

    protected final Object a(AssetManager assetmanager, String s)
    {
        return assetmanager.openFd(s).getParcelFileDescriptor();
    }

    protected final void a(Object obj)
    {
        ((ParcelFileDescriptor)obj).close();
    }

    public final Class d()
    {
        return android/os/ParcelFileDescriptor;
    }
}
