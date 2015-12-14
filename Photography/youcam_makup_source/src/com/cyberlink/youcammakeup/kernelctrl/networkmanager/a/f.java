// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.sku.g;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.be;
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
//            k, e, b, h, 
//            l

public class f extends k
{

    final e a;

    public f(NetworkManager networkmanager, g g1, b b1, h h, com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType downloadtype)
    {
        super(networkmanager, g1.o(), c(g1), new l(downloadtype, g1, h, b1, networkmanager) {

            final com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType a;
            final g b;
            final h c;
            final b d;
            final NetworkManager e;

            public void a(a a1)
            {
                c.a(a1);
            }

            public void a(bn bn1)
            {
                c.a(bn1);
            }

            public void a(File file)
            {
                Object obj;
                String s;
                s = be.a(file.getPath().toString());
                obj = "";
                if (a != com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType.a) goto _L2; else goto _L1
_L1:
                obj = b.a().n();
_L4:
                if (!s.equals(obj))
                {
                    obj = new bn(null, new Exception("MD5 error"));
                    c.a(((bn) (obj)));
                    file.delete();
                }
                obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.f.a(b, file);
                if (!NetworkManager.a())
                {
                    file.delete();
                }
                if (obj == null)
                {
                    file = new bn(null, new Exception("unzip failed"));
                    c.a(file);
                    return;
                }
                break; /* Loop/switch isn't completed */
_L2:
                if (a == com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType.b)
                {
                    obj = b.a().o();
                } else
                if (a == com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType.c)
                {
                    obj = b.a().p();
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (d != null)
                {
                    d.a(((File) (obj)), b);
                    d.a(e, b);
                }
                c.a(((File) (obj)).getAbsolutePath());
                return;
            }

            public volatile void a(Object obj)
            {
                a((File)obj);
            }

            public void a(Void void1)
            {
                c.a();
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
                a((a)obj);
            }

            
            {
                a = downloadtype;
                b = g1;
                c = h1;
                d = b1;
                e = networkmanager;
                super();
            }
        });
        a = g1;
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
}
