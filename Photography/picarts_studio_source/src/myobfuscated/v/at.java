// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import myobfuscated.s.j;

public final class at
    implements a
{

    private final j a;

    public at(j j1)
    {
        a = j1;
    }

    private boolean a(InputStream inputstream, File file)
    {
        byte abyte0[] = a.a(0x10000);
        FileOutputStream fileoutputstream = new FileOutputStream(file);
_L2:
        file = fileoutputstream;
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        file = fileoutputstream;
        fileoutputstream.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        inputstream;
        inputstream = fileoutputstream;
_L6:
        file = inputstream;
        Log.isLoggable("StreamEncoder", 3);
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
        }
        a.a(abyte0);
        return false;
_L1:
        file = fileoutputstream;
        fileoutputstream.close();
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        a.a(abyte0);
        return true;
        inputstream;
        file = null;
_L4:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        a.a(abyte0);
        throw inputstream;
        inputstream;
        if (true) goto _L4; else goto _L3
_L3:
        inputstream;
        inputstream = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final volatile boolean a(Object obj, File file, e e)
    {
        return a((InputStream)obj, file);
    }
}
