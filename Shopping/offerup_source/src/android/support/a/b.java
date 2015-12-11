// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.a;

import dalvik.system.DexFile;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

// Referenced classes of package android.support.a:
//            a

class b
{

    long a;
    long b;

    b()
    {
    }

    static long a(File file)
    {
        file = new RandomAccessFile(file, "r");
        long l = a(((RandomAccessFile) (file)), a(((RandomAccessFile) (file))));
        file.close();
        return l;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    static long a(RandomAccessFile randomaccessfile, b b1)
    {
        CRC32 crc32 = new CRC32();
        long l = b1.b;
        randomaccessfile.seek(b1.a);
        int i = (int)Math.min(16384L, l);
        b1 = new byte[16384];
        i = randomaccessfile.read(b1, 0, i);
        do
        {
            if (i == -1)
            {
                break;
            }
            crc32.update(b1, 0, i);
            l -= i;
            if (l == 0L)
            {
                break;
            }
            i = randomaccessfile.read(b1, 0, (int)Math.min(16384L, l));
        } while (true);
        return crc32.getValue();
    }

    static b a(RandomAccessFile randomaccessfile)
    {
        long l = 0L;
        long l1 = randomaccessfile.length() - 22L;
        if (l1 < 0L)
        {
            throw new ZipException((new StringBuilder("File too short to be a zip file: ")).append(randomaccessfile.length()).toString());
        }
        long l2 = l1 - 0x10000L;
        int i;
        if (l2 >= 0L)
        {
            l = l2;
        }
        i = Integer.reverseBytes(0x6054b50);
        do
        {
            randomaccessfile.seek(l1);
            if (randomaccessfile.readInt() != i)
            {
                l2 = l1 - 1L;
                l1 = l2;
                if (l2 < l)
                {
                    throw new ZipException("End Of Central Directory signature not found");
                }
            } else
            {
                randomaccessfile.skipBytes(2);
                randomaccessfile.skipBytes(2);
                randomaccessfile.skipBytes(2);
                randomaccessfile.skipBytes(2);
                b b1 = new b();
                b1.b = (long)Integer.reverseBytes(randomaccessfile.readInt()) & 0xffffffffL;
                b1.a = (long)Integer.reverseBytes(randomaccessfile.readInt()) & 0xffffffffL;
                return b1;
            }
        } while (true);
    }

    static void a(ClassLoader classloader, List list)
    {
        int i = list.size();
        Field field = android.support.a.a.a(classloader, "path");
        StringBuilder stringbuilder = new StringBuilder((String)field.get(classloader));
        String as[] = new String[i];
        File afile[] = new File[i];
        ZipFile azipfile[] = new ZipFile[i];
        DexFile adexfile[] = new DexFile[i];
        for (list = list.listIterator(); list.hasNext();)
        {
            File file = (File)list.next();
            String s = file.getAbsolutePath();
            stringbuilder.append(':').append(s);
            int j = list.previousIndex();
            as[j] = s;
            afile[j] = file;
            azipfile[j] = new ZipFile(file);
            adexfile[j] = DexFile.loadDex(s, (new StringBuilder()).append(s).append(".dex").toString(), 0);
        }

        field.set(classloader, stringbuilder.toString());
        android.support.a.a.a(classloader, "mPaths", as);
        android.support.a.a.a(classloader, "mFiles", afile);
        android.support.a.a.a(classloader, "mZips", azipfile);
        android.support.a.a.a(classloader, "mDexs", adexfile);
    }

    static void a(ClassLoader classloader, List list, File file)
    {
        classloader = ((ClassLoader) (android.support.a.a.a(classloader, "pathList").get(classloader)));
        list = new ArrayList(list);
        android.support.a.a.a(classloader, "dexElements", (Object[])android.support.a.a.a(classloader, "makeDexElements", new Class[] {
            java/util/ArrayList, java/io/File
        }).invoke(classloader, new Object[] {
            list, file
        }));
    }
}
