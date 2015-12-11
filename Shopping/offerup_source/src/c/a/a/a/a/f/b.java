// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.f;

import android.content.Context;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.io.File;

// Referenced classes of package c.a.a.a.a.f:
//            a

public final class b
    implements a
{

    private final Context a;

    public b(n n1)
    {
        if (n1.getContext() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            a = n1.getContext();
            n1.getPath();
            (new StringBuilder("Android/")).append(a.getPackageName());
            return;
        }
    }

    public final File a()
    {
        File file = a.getFilesDir();
        if (file != null)
        {
            if (file.exists() || file.mkdirs())
            {
                return file;
            }
            e.d().d("Fabric", "Couldn't create file");
        } else
        {
            e.d().a("Fabric", "Null File");
        }
        return null;
    }
}
