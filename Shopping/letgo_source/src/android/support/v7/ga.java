// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Referenced classes of package android.support.v7:
//            fz, aqo

public class ga extends fz
{

    public ga()
    {
    }

    public Bitmap a(String s)
    {
        InputStream inputstream;
        IOException ioexception;
        try
        {
            inputstream = (InputStream)(new URL(s)).getContent();
            s = BitmapFactory.decodeStream(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "retrieveImage failed", new Object[0]);
            return null;
        }
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        inputstream.close();
_L1:
        return s;
        ioexception;
        aqo.b(ioexception, "retrieveImage : error closing stream", new Object[0]);
          goto _L1
    }
}
