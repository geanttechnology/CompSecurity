// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package myobfuscated.q:
//            b, c

public abstract class o
    implements b
{

    private final Uri a;
    private final Context b;
    private Object c;

    public o(Context context, Uri uri)
    {
        b = context.getApplicationContext();
        a = uri;
    }

    protected abstract Object a(Uri uri, ContentResolver contentresolver);

    public final void a()
    {
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        a(c);
        return;
        IOException ioexception;
        ioexception;
    }

    public final void a(Priority priority, c c1)
    {
        priority = b.getContentResolver();
        try
        {
            c = a(a, ((ContentResolver) (priority)));
        }
        // Misplaced declaration of an exception variable
        catch (Priority priority)
        {
            Log.isLoggable("LocalUriFetcher", 3);
            c1.a(priority);
            return;
        }
        c1.a(c);
    }

    protected abstract void a(Object obj);

    public final void b()
    {
    }

    public final DataSource c()
    {
        return DataSource.LOCAL;
    }
}
