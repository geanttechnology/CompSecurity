// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.File;

public class bwr
    implements bwq
{

    private final Context a;
    private final String b;
    private final String c;

    public bwr(bsy bsy1)
    {
        if (bsy1.getContext() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            a = bsy1.getContext();
            b = bsy1.getPath();
            c = (new StringBuilder()).append("Android/").append(a.getPackageName()).toString();
            return;
        }
    }

    public File a()
    {
        return a(a.getFilesDir());
    }

    File a(File file)
    {
        if (file != null)
        {
            if (file.exists() || file.mkdirs())
            {
                return file;
            }
            bso.h().d("Fabric", "Couldn't create file");
        } else
        {
            bso.h().a("Fabric", "Null File");
        }
        return null;
    }
}
