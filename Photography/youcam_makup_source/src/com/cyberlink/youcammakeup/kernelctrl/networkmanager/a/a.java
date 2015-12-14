// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.utility.bb;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            k, e, b, l

public class a extends k
{

    final e a;

    public a(NetworkManager networkmanager, e e1, b b1)
    {
        this(networkmanager, e1, b1, null);
    }

    public a(NetworkManager networkmanager, e e1, b b1, f f)
    {
        super(networkmanager, e1.o(), c(e1), new l(e1, networkmanager, b1, f) {

            final e a;
            final NetworkManager b;
            final b c;
            final f d;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
            {
                b.a(a.l(), a1);
                if (d != null)
                {
                    d.d(a1);
                }
            }

            public void a(bn bn1)
            {
                b.a(a.l(), bn1);
                if (d != null)
                {
                    d.b(bn1);
                }
            }

            public void a(File file)
            {
                File file1 = a.a(a, file);
                if (!NetworkManager.a())
                {
                    file.delete();
                }
                if (file1 == null)
                {
                    file = new bn(null, new Exception("unzip failed"));
                    b.a(a.l(), file);
                } else
                {
                    c.a(file1, a);
                    c.a(b, a);
                    c.b(file1, a);
                    long l1 = a.l();
                    b.b(l1);
                    if (d != null)
                    {
                        d.a(null);
                        return;
                    }
                }
            }

            public volatile void a(Object obj)
            {
                a((File)obj);
            }

            public void a(Void void1)
            {
                b.c(a.l());
                if (d != null)
                {
                    d.c(void1);
                }
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            public void d(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
            }

            
            {
                a = e1;
                b = networkmanager;
                c = b1;
                d = f1;
                super();
            }
        });
        a = e1;
    }

    protected static File a(e e1, File file)
    {
        BufferedInputStream bufferedinputstream;
        ZipInputStream zipinputstream;
        byte abyte0[];
        Object obj;
        e1 = new File(a(e1));
        e1.mkdirs();
        bb.a(e1);
        ZipEntry zipentry;
        try
        {
            file = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            return null;
        }
        bufferedinputstream = new BufferedInputStream(file);
        zipinputstream = new ZipInputStream(bufferedinputstream);
        abyte0 = new byte[0x100000];
_L2:
        try
        {
            zipentry = zipinputstream.getNextEntry();
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            FileOutputStream fileoutputstream;
            int i;
            try
            {
                zipinputstream.close();
                bufferedinputstream.close();
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (e e1) { }
            return null;
        }
        finally { }
        if (zipentry == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
label0:
        {
            obj = new File(e1, zipentry.getName());
            if (!zipentry.isDirectory())
            {
                break label0;
            }
            ((File) (obj)).mkdirs();
        }
        break MISSING_BLOCK_LABEL_54;
        if (!((File) (obj)).getParentFile().exists())
        {
            ((File) (obj)).getParentFile().mkdirs();
        }
        fileoutputstream = new FileOutputStream(((File) (obj)));
        obj = new BufferedOutputStream(fileoutputstream);
_L1:
        i = zipinputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        ((BufferedOutputStream) (obj)).write(abyte0, 0, i);
          goto _L1
        try
        {
            zipinputstream.close();
            bufferedinputstream.close();
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        throw e1;
        ((BufferedOutputStream) (obj)).flush();
        ((BufferedOutputStream) (obj)).close();
        fileoutputstream.close();
        zipinputstream.closeEntry();
          goto _L2
        try
        {
            zipinputstream.close();
            bufferedinputstream.close();
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return e1;
        }
        return e1;
    }

    public static final String a(e e1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.b());
        stringbuilder.append(Globals.c);
        stringbuilder.append("download");
        stringbuilder.append(Globals.c);
        stringbuilder.append(e1.n());
        stringbuilder.append(Globals.c);
        stringbuilder.append(e1.l());
        stringbuilder.append("_");
        stringbuilder.append(e1.m());
        return stringbuilder.toString();
    }

    public static final String b()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.b());
        stringbuilder.append(Globals.c);
        stringbuilder.append("download");
        return stringbuilder.toString();
    }

    private static final StringBuilder b(e e1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.c());
        stringbuilder.append(Globals.c);
        stringbuilder.append("download");
        stringbuilder.append(Globals.c);
        stringbuilder.append(e1.n());
        stringbuilder.append(Globals.c);
        stringbuilder.append(e1.l());
        stringbuilder.append("_");
        stringbuilder.append(e1.m());
        return stringbuilder;
    }

    private static File c(e e1)
    {
        File file = new File(e1.o().getPath());
        e1 = b(e1);
        e1.append(Globals.c);
        e1.append(file.getName());
        e1 = new File(e1.toString());
        e1.getParentFile().mkdirs();
        try
        {
            e1.createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            throw e1;
        }
        return e1;
    }

    public e c()
    {
        return a;
    }
}
