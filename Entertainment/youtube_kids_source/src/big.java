// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ConditionVariable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

public abstract class big
    implements bid
{

    final String a;
    final ConcurrentHashMap b;
    final FilenameFilter c;
    final ConditionVariable d;
    public volatile boolean e;
    private final String f;

    public big(String s)
    {
        this(s, "");
    }

    private big(String s, String s1)
    {
        b.a(s);
        b.a((new File(s)).isDirectory());
        a = s;
        d = new ConditionVariable(false);
        b = new ConcurrentHashMap();
        f = (String)b.a(s1);
        c = new bik(this, s1);
    }

    private void a()
    {
        b.b(e, "init() must be called before calling to this method");
        d.block();
    }

    protected static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return;
        }
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
    }

    protected static void a(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            return;
        }
        try
        {
            outputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            return;
        }
    }

    private String b(Object obj)
    {
        obj = String.valueOf(String.valueOf(obj.hashCode()));
        String s = f;
        String s1 = String.valueOf(".cache");
        return (new StringBuilder(String.valueOf(obj).length() + 0 + String.valueOf(s).length() + String.valueOf(s1).length())).append(((String) (obj))).append(s).append(s1).toString();
    }

    protected abstract Object a(BufferedInputStream bufferedinputstream);

    public final Object a(Object obj)
    {
        Object obj1;
        Object obj3;
        String s;
        File file;
        obj1 = null;
        obj3 = null;
        b.a(obj);
        a();
        s = b(obj);
        if (!b.containsKey(s))
        {
            return null;
        }
        file = new File(a, s);
        Object obj2 = new BufferedInputStream(new FileInputStream(file), 8192);
        obj = obj2;
        obj3 = a(((BufferedInputStream) (obj2)));
        obj = obj2;
        obj1 = obj3;
        file.setLastModified(System.currentTimeMillis());
        a(((InputStream) (obj2)));
        return obj3;
        obj;
        obj1 = null;
_L4:
        obj = obj1;
        b.remove(s);
        obj = obj1;
        bmo.c((new StringBuilder(String.valueOf(s).length() + 53)).append("Error opening cache file (maybe removed). [filename=").append(s).append("]").toString());
        a(((InputStream) (obj1)));
        return obj3;
        obj;
        obj2 = null;
        obj1 = obj;
_L2:
        a(((InputStream) (obj2)));
        throw obj1;
        obj1;
        obj2 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        obj3 = obj1;
        obj1 = obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(bjo bjo)
    {
        b.a(bjo);
        bmo.e("Clearing persistent cache as a result of a filtered remove");
        a();
        b.clear();
        bjo = (new File(a)).listFiles(c);
        if (bjo != null)
        {
            int j = bjo.length;
            for (int i = 0; i < j; i++)
            {
                bjo[i].delete();
            }

        }
    }

    protected abstract void a(Object obj, BufferedOutputStream bufferedoutputstream);

    public final void a(Object obj, Object obj1)
    {
        String s;
        b.a(obj);
        b.a(obj);
        a();
        s = b(obj);
        obj = new File(a, s);
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(((File) (obj))), 8192);
        obj = bufferedoutputstream;
        a(obj1, bufferedoutputstream);
        obj = bufferedoutputstream;
        b.put(s, "");
        a(((OutputStream) (bufferedoutputstream)));
        return;
        obj1;
        bufferedoutputstream = null;
_L6:
        obj = bufferedoutputstream;
        bmo.b("Error creating cache file.", ((Throwable) (obj1)));
        a(((OutputStream) (bufferedoutputstream)));
        return;
        obj1;
        bufferedoutputstream = null;
_L4:
        obj = bufferedoutputstream;
        bmo.b("Error creating cache file.", ((Throwable) (obj1)));
        a(((OutputStream) (bufferedoutputstream)));
        return;
        obj1;
        obj = null;
_L2:
        a(((OutputStream) (obj)));
        throw obj1;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
