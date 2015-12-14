// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.File;

public class ade
    implements add
{

    private final Context a;
    private final String b;
    private final String c;

    public ade(aad aad1)
    {
        if (aad1.getContext() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            a = aad1.getContext();
            b = aad1.getPath();
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
            zw.h().d("Fabric", "Couldn't create file");
        } else
        {
            zw.h().a("Fabric", "Null File");
        }
        return null;
    }
}
