// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import myobfuscated.q.b;
import myobfuscated.q.c;

// Referenced classes of package myobfuscated.v:
//            r

final class q
    implements b
{

    private final File a;
    private final r b;
    private Object c;

    public q(File file, r r1)
    {
        a = file;
        b = r1;
    }

    public final void a()
    {
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        b.a(c);
        return;
        IOException ioexception;
        ioexception;
    }

    public final void a(Priority priority, c c1)
    {
        try
        {
            c = b.a(a);
        }
        // Misplaced declaration of an exception variable
        catch (Priority priority)
        {
            Log.isLoggable("FileLoader", 3);
            c1.a(priority);
            return;
        }
        c1.a(c);
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
        return b.a();
    }
}
