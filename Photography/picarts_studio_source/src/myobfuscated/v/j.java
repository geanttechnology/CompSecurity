// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.e;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class j
    implements a
{

    public j()
    {
    }

    private static boolean a(ByteBuffer bytebuffer, File file)
    {
        try
        {
            myobfuscated.aj.a.a(bytebuffer, file);
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
        return true;
    }

    public final volatile boolean a(Object obj, File file, e e)
    {
        return a((ByteBuffer)obj, file);
    }
}
