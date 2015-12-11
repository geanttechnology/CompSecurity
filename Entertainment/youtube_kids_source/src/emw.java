// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class emw extends eml
{

    private final File a;

    public emw(File file)
    {
        a = (File)f.b(file);
    }

    private FileInputStream c()
    {
        return new FileInputStream(a);
    }

    public final InputStream a()
    {
        return c();
    }

    public final byte[] b()
    {
        byte abyte0[];
        emq emq1;
        int i;
        long l;
        i = 0;
        l = a.length();
        if (l == 0L)
        {
            return super.b();
        }
        if (l > 0x7fffffffL)
        {
            throw new OutOfMemoryError((new StringBuilder("file is too large to fit in a byte array: ")).append(l).append(" bytes").toString());
        }
        abyte0 = new byte[(int)l];
        emq1 = emq.a();
        Object obj1 = (InputStream)emq1.a(c());
        int j = 0;
_L2:
        int k;
        k = i;
        if ((long)j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((InputStream) (obj1)).read(abyte0, j, (int)l - j);
        k = i;
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        j += i;
        if (true) goto _L2; else goto _L1
_L1:
        if ((long)j >= l) goto _L4; else goto _L3
_L3:
        obj1 = new byte[j];
        System.arraycopy(abyte0, 0, obj1, 0, j);
        abyte0 = ((byte []) (obj1));
_L6:
        emq1.close();
        return abyte0;
_L4:
        if (k == -1) goto _L6; else goto _L5
_L5:
        byte abyte1[];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        emm.a(((InputStream) (obj1)), bytearrayoutputstream);
        byte abyte2[] = bytearrayoutputstream.toByteArray();
        abyte1 = new byte[abyte0.length + abyte2.length];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        System.arraycopy(abyte2, 0, abyte1, abyte0.length, abyte2.length);
        abyte0 = abyte1;
          goto _L6
        Object obj;
        obj;
        throw emq1.a(((Throwable) (obj)));
        obj;
        emq1.close();
        throw obj;
    }

    public final String toString()
    {
        return (new StringBuilder("Files.asByteSource(")).append(a).append(")").toString();
    }
}
