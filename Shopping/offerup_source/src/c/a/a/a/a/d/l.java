// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package c.a.a.a.a.d:
//            h

public final class l extends h
{

    public l(Context context, File file, String s, String s1)
    {
        super(context, file, s, s1);
    }

    public final OutputStream a(File file)
    {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
