// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bs;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

// Referenced classes of package myobfuscated.bs:
//            a, c

public abstract class d
{

    private static ByteBuffer a = ByteBuffer.allocate(9216);

    public d()
    {
    }

    public static c a(AssetManager assetmanager, String s)
    {
        Object obj = null;
        myobfuscated/bs/d;
        JVM INSTR monitorenter ;
        s = assetmanager.open(s);
        assetmanager = s;
        ReadableByteChannel readablebytechannel = Channels.newChannel(s);
        assetmanager = s;
        a.clear();
        assetmanager = s;
        readablebytechannel.read(a);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        s.close();
_L1:
        a.rewind();
        assetmanager = myobfuscated.bs.a.a(a);
_L3:
        myobfuscated/bs/d;
        JVM INSTR monitorexit ;
        return assetmanager;
        assetmanager;
        (new StringBuilder("Got unexpected exception: ")).append(assetmanager.getMessage());
          goto _L1
        assetmanager;
        throw assetmanager;
        IOException ioexception;
        ioexception;
        s = null;
_L7:
        assetmanager = s;
        (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage());
        assetmanager = obj;
        if (s == null) goto _L3; else goto _L2
_L2:
        s.close();
        assetmanager = obj;
          goto _L3
        assetmanager;
        (new StringBuilder("Got unexpected exception: ")).append(assetmanager.getMessage());
        assetmanager = obj;
          goto _L3
        s;
        assetmanager = null;
_L6:
        if (assetmanager == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        assetmanager.close();
_L4:
        throw s;
        assetmanager;
        (new StringBuilder("Got unexpected exception: ")).append(assetmanager.getMessage());
          goto _L4
        s;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
          goto _L7
    }

    static 
    {
        myobfuscated/bs/d.getSimpleName();
    }
}
