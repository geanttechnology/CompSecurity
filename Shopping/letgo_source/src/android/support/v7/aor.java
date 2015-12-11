// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.File;

// Referenced classes of package android.support.v7:
//            aoq, alz, alt, amc

public class aor
    implements aoq
{

    private final Context a;
    private final String b;
    private final String c;

    public aor(alz alz1)
    {
        if (alz1.getContext() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            a = alz1.getContext();
            b = alz1.getPath();
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
            alt.h().d("Fabric", "Couldn't create file");
        } else
        {
            alt.h().a("Fabric", "Null File");
        }
        return null;
    }
}
