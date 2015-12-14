// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import com.socialin.android.brushlib.layer.a;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.brushlib.util.k;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

// Referenced classes of package myobfuscated.br:
//            e, a

public class d
{

    static final String a = myobfuscated/br/d.getSimpleName();
    private static final List b = new CopyOnWriteArrayList();

    public d(myobfuscated.br.a a1)
    {
    }

    public static Snapshot a(File file)
    {
        return (Snapshot)k.a(file);
    }

    public static ByteBuffer a(long l)
    {
        if (b.size() > 0)
        {
            ByteBuffer bytebuffer = (ByteBuffer)b.get(0);
            bytebuffer.rewind();
            if ((long)bytebuffer.remaining() == l)
            {
                b.remove(0);
                return bytebuffer;
            }
        }
        return ImageOpCommon.allocNativeBuffer(l);
    }

    public static e a(Project project)
    {
        Object obj1 = FileUtils.e(project.getIndexFile());
        if (((List) (obj1)).size() != 2)
        {
            throw new InvalidIndexFileException("Index file must contain 2 lines");
        }
        Object obj = (String)((List) (obj1)).get(0);
        String s = (String)((List) (obj1)).get(1);
        obj1 = (Snapshot)k.a(new File(project.getRootFolder(), ((String) (obj))));
        ArrayList arraylist;
        if (s.equals(obj))
        {
            obj = obj1;
        } else
        {
            obj = (Snapshot)k.a(new File(project.getRootFolder(), s));
        }
        arraylist = new ArrayList();
        arraylist.add(obj);
        do
        {
            if (obj == null || ((Snapshot) (obj)).previousSnapshotKey == null)
            {
                break;
            }
            if (((Snapshot) (obj)).previousSnapshotKey.equals(((Snapshot) (obj1)).key))
            {
                arraylist.add(obj1);
                obj = obj1;
            } else
            {
                obj = ((Snapshot) (obj)).previousSnapshotKey;
                Snapshot snapshot = (Snapshot)k.a(new File(project.getRootFolder(), ((String) (obj))));
                obj = snapshot;
                if (snapshot != null)
                {
                    arraylist.add(snapshot);
                    obj = snapshot;
                }
            }
        } while (true);
        Collections.reverse(arraylist);
        return new e(arraylist, obj1);
    }

    public static void a()
    {
        try
        {
            for (Iterator iterator = b.iterator(); iterator.hasNext(); ImageOpCommon.freeNativeBuffer((ByteBuffer)iterator.next())) { }
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
            return;
        }
        b.clear();
        return;
    }

    public static void a(a a1, File file)
    {
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        ByteBuffer bytebuffer = a(a1.a());
        RandomAccessFile randomaccessfile = new RandomAccessFile(file, "rw");
        file = randomaccessfile;
        b(bytebuffer, randomaccessfile);
        file = randomaccessfile;
        bytebuffer.rewind();
        file = randomaccessfile;
        a1.b(bytebuffer);
        file = randomaccessfile;
        a(bytebuffer);
        randomaccessfile.close();
_L4:
        return;
        a1;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        a1 = null;
_L7:
        file = a1;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(filenotfoundexception.getMessage()).toString()
        });
        if (a1 == null) goto _L4; else goto _L3
_L3:
        try
        {
            a1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
            });
        }
        return;
        a1;
        file = null;
_L6:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
                });
            }
        }
        throw a1;
_L2:
        a1.c();
        return;
        a1;
        if (true) goto _L6; else goto _L5
_L5:
        filenotfoundexception;
        a1 = randomaccessfile;
          goto _L7
    }

    public static void a(ByteBuffer bytebuffer)
    {
        if (b.size() < 3)
        {
            b.add(bytebuffer);
            return;
        } else
        {
            ImageOpCommon.freeNativeBuffer(bytebuffer);
            return;
        }
    }

    public static void a(ByteBuffer bytebuffer, RandomAccessFile randomaccessfile)
    {
        com.socialin.android.brushlib.util.b.a(bytebuffer, randomaccessfile);
        a(bytebuffer);
        try
        {
            randomaccessfile.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
            });
        }
        return;
        bytebuffer;
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(randomaccessfile.getMessage()).toString()
            });
        }
        throw bytebuffer;
    }

    static String b()
    {
        return a;
    }

    public static void b(ByteBuffer bytebuffer, RandomAccessFile randomaccessfile)
    {
        com.socialin.android.brushlib.util.b.b(bytebuffer, randomaccessfile);
        try
        {
            randomaccessfile.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
            });
        }
        return;
        bytebuffer;
        try
        {
            randomaccessfile.close();
        }
        // Misplaced declaration of an exception variable
        catch (RandomAccessFile randomaccessfile)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(randomaccessfile.getMessage()).toString()
            });
        }
        throw bytebuffer;
    }

    public final void a(a a1, File file, Runnable runnable)
    {
        ByteBuffer bytebuffer;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        bytebuffer = a(a1.a());
        file = new RandomAccessFile(file, "r");
        a1 = new Runnable(bytebuffer, a1, runnable) {

            private ByteBuffer a;
            private a b;
            private Runnable c;

            public final void run()
            {
                a.rewind();
                b.b(a);
                myobfuscated.br.d.a(a);
                if (c != null)
                {
                    c.run();
                }
            }

            
            {
                a = bytebuffer;
                b = a1;
                c = runnable;
                super();
            }
        };
        myobfuscated.br.a.a().execute(new Runnable(bytebuffer, file, a1) {

            private ByteBuffer a;
            private RandomAccessFile b;
            private Runnable c;

            public final void run()
            {
                com.socialin.android.brushlib.util.b.b(a, b);
                try
                {
                    b.close();
                }
                catch (IOException ioexception)
                {
                    com.socialin.android.d.b(myobfuscated.br.d.b(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                    });
                }
                if (c != null)
                {
                    c.run();
                }
                return;
                Exception exception;
                exception;
                try
                {
                    b.close();
                }
                catch (IOException ioexception1)
                {
                    com.socialin.android.d.b(myobfuscated.br.d.b(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
                    });
                }
                if (c != null)
                {
                    c.run();
                }
                throw exception;
            }

            
            {
                a = bytebuffer;
                b = randomaccessfile;
                c = runnable;
                super();
            }
        });
_L1:
        return;
        a1;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(a1.getMessage()).toString()
        });
        return;
        a1.c();
        if (runnable != null)
        {
            runnable.run();
            return;
        }
          goto _L1
    }


    // Unreferenced inner class myobfuscated/br/d$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        private Runnable a;

        public final void run()
        {
            if (a != null)
            {
                a.run();
            }
        }

            
            {
                a = runnable;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/br/d$2

/* anonymous class */
    final class _cls2
        implements Runnable
    {

        private ByteBuffer a;
        private RandomAccessFile b;
        private Runnable c;

        public final void run()
        {
            myobfuscated.br.d.a(a, b);
            if (c != null)
            {
                c.run();
            }
        }

            
            {
                a = bytebuffer;
                b = randomaccessfile;
                c = runnable;
                super();
            }
    }

}
