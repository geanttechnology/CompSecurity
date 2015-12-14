// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

// Referenced classes of package myobfuscated.q:
//            b, c

public abstract class a
    implements b
{

    private final String a;
    private final AssetManager b;
    private Object c;

    public a(AssetManager assetmanager, String s)
    {
        b = assetmanager;
        a = s;
    }

    protected abstract Object a(AssetManager assetmanager, String s);

    public final void a()
    {
        if (c == null)
        {
            return;
        }
        try
        {
            a(c);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public final void a(Priority priority, c c1)
    {
        try
        {
            c = a(b, a);
        }
        // Misplaced declaration of an exception variable
        catch (Priority priority)
        {
            Log.isLoggable("AssetPathFetcher", 3);
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
