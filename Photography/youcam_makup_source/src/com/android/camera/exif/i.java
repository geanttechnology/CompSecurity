// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import android.util.Log;
import java.io.InputStream;

// Referenced classes of package com.android.camera.exif:
//            e, b, k, j, 
//            c

class i
{

    private final c a;

    i(c c)
    {
        a = c;
    }

    protected b a(InputStream inputstream)
    {
        b b1;
        int l;
        inputstream = e.a(inputstream, a);
        b1 = new b(inputstream.m());
        l = inputstream.a();
_L8:
        if (l == 5)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        l;
        JVM INSTR tableswitch 0 4: default 68
    //                   0 77
    //                   1 95
    //                   2 131
    //                   3 166
    //                   4 202;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_202;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L9:
        l = inputstream.a();
        if (true) goto _L8; else goto _L7
_L7:
        b1.a(new k(inputstream.d()));
          goto _L9
_L3:
        j j1 = inputstream.c();
        if (!j1.f())
        {
            inputstream.a(j1);
        } else
        {
            b1.b(j1.a()).a(j1);
        }
          goto _L9
_L4:
        j j2 = inputstream.c();
        if (j2.c() == 7)
        {
            inputstream.b(j2);
        }
        b1.b(j2.a()).a(j2);
          goto _L9
_L5:
        byte abyte0[] = new byte[inputstream.g()];
        if (abyte0.length == inputstream.a(abyte0))
        {
            b1.a(abyte0);
        } else
        {
            Log.w("ExifReader", "Failed to read the compressed thumbnail");
        }
          goto _L9
        byte abyte1[] = new byte[inputstream.f()];
        if (abyte1.length == inputstream.a(abyte1))
        {
            b1.a(inputstream.e(), abyte1);
        } else
        {
            Log.w("ExifReader", "Failed to read the strip bytes");
        }
          goto _L9
        return b1;
    }
}
