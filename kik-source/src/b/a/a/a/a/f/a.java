// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a.a.f;

import android.content.Context;
import b.a.a.a.d;
import b.a.a.a.l;
import b.a.a.a.o;
import java.io.File;

public final class a
{

    private final Context a;
    private final String b;
    private final String c;

    public a(l l1)
    {
        if (l1.v() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            a = l1.v();
            b = l1.x();
            c = (new StringBuilder("Android/")).append(a.getPackageName()).toString();
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
            d.c().a("Fabric", "Couldn't create file");
        } else
        {
            d.c();
        }
        return null;
    }
}
