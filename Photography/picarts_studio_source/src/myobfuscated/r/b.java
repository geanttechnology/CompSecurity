// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.r;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import myobfuscated.q.c;
import myobfuscated.q.h;

// Referenced classes of package myobfuscated.r:
//            f, e

public final class b
    implements myobfuscated.q.b
{

    private final Context a;
    private final Uri b;
    private final f c;
    private InputStream d;

    private b(Context context, Uri uri, f f1)
    {
        a = context;
        b = uri;
        c = f1;
    }

    public static b a(Context context, Uri uri, e e)
    {
        return new b(context, uri, new f(e, com.bumptech.glide.b.a(context).c));
    }

    public final void a()
    {
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        d.close();
        return;
        IOException ioexception;
        ioexception;
    }

    public final void a(Priority priority, c c1)
    {
        int i;
        try
        {
            priority = c.b(a, b);
        }
        // Misplaced declaration of an exception variable
        catch (Priority priority)
        {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            c1.a(priority);
            return;
        }
        if (priority == null) goto _L2; else goto _L1
_L1:
        i = c.a(a, b);
_L4:
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        priority = new h(priority, i);
        d = priority;
        c1.a(d);
        return;
_L2:
        i = -1;
        if (true) goto _L4; else goto _L3
_L3:
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
        return java/io/InputStream;
    }
}
