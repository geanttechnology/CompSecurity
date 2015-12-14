// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import myobfuscated.aj.a;
import myobfuscated.q.b;
import myobfuscated.q.c;

final class l
    implements b
{

    private final File a;

    public l(File file)
    {
        a = file;
    }

    public final void a()
    {
    }

    public final void a(Priority priority, c c1)
    {
        try
        {
            priority = myobfuscated.aj.a.a(a);
        }
        // Misplaced declaration of an exception variable
        catch (Priority priority)
        {
            Log.isLoggable("ByteBufferFileLoader", 3);
            c1.a(priority);
            return;
        }
        c1.a(priority);
    }

    public final void b()
    {
    }

    public final DataSource c()
    {
        return DataSource.LOCAL;
    }

    public final Class d()
    {
        return java/nio/ByteBuffer;
    }
}
