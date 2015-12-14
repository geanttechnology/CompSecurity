// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.g;
import java.io.File;
import java.io.IOException;
import myobfuscated.aj.a;

// Referenced classes of package myobfuscated.ab:
//            d

public final class f
    implements g
{

    public f()
    {
    }

    private static boolean a(ad ad1, File file)
    {
        ad1 = (d)ad1.b();
        try
        {
            myobfuscated.aj.a.a(ad1.a(), file);
        }
        // Misplaced declaration of an exception variable
        catch (ad ad1)
        {
            if (Log.isLoggable("GifEncoder", 5))
            {
                Log.w("GifEncoder", "Failed to encode gif drawable data", ad1);
            }
            return false;
        }
        return true;
    }

    public final EncodeStrategy a(e e)
    {
        return EncodeStrategy.SOURCE;
    }

    public final volatile boolean a(Object obj, File file, e e)
    {
        return a((ad)obj, file);
    }
}
