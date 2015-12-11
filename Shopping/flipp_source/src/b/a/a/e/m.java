// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.i;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package b.a.a.e:
//            k, c

public final class m
    implements k
{

    private final File a;
    private final String b;
    private final ClassLoader c;
    private final Map d;

    public m(String s)
    {
        this(s, (byte)0);
    }

    private m(String s, byte byte0)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("No resource path provided");
        }
        String s1 = s;
        if (!s.endsWith("/"))
        {
            s1 = (new StringBuilder()).append(s).append('/').toString();
        }
        a = null;
        b = s1;
        c = getClass().getClassLoader();
        d = a(b("ZoneInfoMap"));
    }

    private static Map a(InputStream inputstream)
    {
        ConcurrentHashMap concurrenthashmap;
        concurrenthashmap = new ConcurrentHashMap();
        inputstream = new DataInputStream(inputstream);
        a(((DataInputStream) (inputstream)), ((Map) (concurrenthashmap)));
        Exception exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        concurrenthashmap.put("UTC", new SoftReference(i.a));
        return concurrenthashmap;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        throw exception;
    }

    private static void a(DataInputStream datainputstream, Map map)
    {
        boolean flag = false;
        int i1 = datainputstream.readUnsignedShort();
        String as[] = new String[i1];
        for (int j = 0; j < i1; j++)
        {
            as[j] = datainputstream.readUTF().intern();
        }

        i1 = datainputstream.readUnsignedShort();
        int l = ((flag) ? 1 : 0);
        while (l < i1) 
        {
            try
            {
                map.put(as[datainputstream.readUnsignedShort()], as[datainputstream.readUnsignedShort()]);
            }
            // Misplaced declaration of an exception variable
            catch (DataInputStream datainputstream)
            {
                throw new IOException("Corrupt zone info map");
            }
            l++;
        }
    }

    private InputStream b(String s)
    {
        Object obj;
        if (a != null)
        {
            obj = new FileInputStream(new File(a, s));
        } else
        {
            String s1 = b.concat(s);
            if (c != null)
            {
                s = c.getResourceAsStream(s1);
            } else
            {
                s = ClassLoader.getSystemResourceAsStream(s1);
            }
            obj = s;
            if (s == null)
            {
                StringBuilder stringbuilder = (new StringBuilder(40)).append("Resource not found: \"").append(s1).append("\" ClassLoader: ");
                if (c != null)
                {
                    s = c.toString();
                } else
                {
                    s = "system";
                }
                throw new IOException(stringbuilder.append(s).toString());
            }
        }
        return ((InputStream) (obj));
    }

    private i c(String s)
    {
        InputStream inputstream1 = b(s);
        InputStream inputstream = inputstream1;
        if (!(inputstream1 instanceof DataInput)) goto _L2; else goto _L1
_L1:
        inputstream = inputstream1;
        Object obj = b.a.a.e.c.a((DataInput)inputstream1, s);
_L4:
        inputstream = inputstream1;
        d.put(s, new SoftReference(obj));
        Thread thread;
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return ((i) (obj));
            }
        }
        return ((i) (obj));
_L2:
        inputstream = inputstream1;
        obj = b.a.a.e.c.a(new DataInputStream(inputstream1), s);
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        inputstream1 = null;
_L8:
        inputstream = inputstream1;
        thread = Thread.currentThread();
        inputstream = inputstream1;
        thread.getThreadGroup().uncaughtException(thread, ((Throwable) (obj)));
        inputstream = inputstream1;
        d.remove(s);
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return null;
        s;
        inputstream = null;
_L6:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final i a(String s)
    {
_L6:
        if (s != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((i) (obj));
_L2:
        obj = d.get(s);
        if (obj == null)
        {
            return null;
        }
        if (s.equals(obj))
        {
            return c(s);
        }
        if (!(obj instanceof SoftReference))
        {
            break; /* Loop/switch isn't completed */
        }
        i j = (i)((SoftReference)obj).get();
        obj = j;
        if (j == null)
        {
            return c(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = (String)obj;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final Set a()
    {
        return new TreeSet(d.keySet());
    }
}
