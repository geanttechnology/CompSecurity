// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.e.aj;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.d:
//            il, kb, kg

public final class kh
{

    public static final Integer a = Integer.valueOf(0);
    public static final Integer b = Integer.valueOf(1);
    final Context c;
    final ExecutorService d;

    public kh(Context context)
    {
        this(context, Executors.newSingleThreadExecutor());
    }

    private kh(Context context, ExecutorService executorservice)
    {
        c = context;
        d = executorservice;
    }

    static byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        il.a(inputstream, bytearrayoutputstream, false);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            aj.a();
            return null;
        }
_L2:
        return bytearrayoutputstream.toByteArray();
        IOException ioexception;
        ioexception;
        aj.a();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            aj.a();
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            aj.a();
            return null;
        }
        throw exception;
    }

    static String c(String s)
    {
        return (new StringBuilder("resource_")).append(s).toString();
    }

    public final long a(String s)
    {
        s = b(s);
        if (s.exists())
        {
            return s.lastModified();
        } else
        {
            return 0L;
        }
    }

    final File b(String s)
    {
        return new File(c.getDir("google_tagmanager", 0), c(s));
    }


    // Unreferenced inner class com/google/android/gms/d/kh$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final String a;
        final Integer b;
        final kb c;
        final kg d;
        final kh e;

        public final void run()
        {
            Integer integer;
            kg kg1;
            kh kh1;
            Object obj;
            Object obj1;
            kh1 = e;
            obj1 = a;
            integer = b;
            obj = c;
            kg1 = d;
            aj.d();
            Object obj2 = ((kb) (obj)).a(kh.a(new FileInputStream(kh1.b(((String) (obj1))))));
            if (obj2 != null)
            {
                try
                {
                    (new StringBuilder("Saved resource loaded: ")).append(kh.c(((String) (obj1))));
                    aj.d();
                    kg1.a(Status.a, obj2, kh.b, kh1.a(((String) (obj1))));
                    return;
                }
                catch (FileNotFoundException filenotfoundexception)
                {
                    aj.a((new StringBuilder("Saved resource not found: ")).append(kh.c(((String) (obj1)))).toString());
                }
                catch (kf.g g1)
                {
                    aj.a((new StringBuilder("Saved resource is corrupted: ")).append(kh.c(((String) (obj1)))).toString());
                }
            }
            if (integer == null)
            {
                kg1.a(Status.c, null, null, 0L);
                return;
            }
            obj1 = kh1.c.getResources().openRawResource(integer.intValue());
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_278;
            }
            obj = ((kb) (obj)).a(kh.a(((InputStream) (obj1))));
            if (obj != null)
            {
                try
                {
                    (new StringBuilder("Default resource loaded: ")).append(kh1.c.getResources().getResourceEntryName(integer.intValue()));
                    aj.d();
                    kg1.a(Status.a, obj, kh.a, 0L);
                    return;
                }
                catch (android.content.res.Resources.NotFoundException notfoundexception)
                {
                    aj.a((new StringBuilder("Default resource not found. ID: ")).append(integer).toString());
                }
                catch (kf.g g)
                {
                    aj.a((new StringBuilder("Default resource resource is corrupted: ")).append(integer).toString());
                }
            }
            kg1.a(Status.c, null, null, 0L);
            return;
        }

            
            {
                e = kh.this;
                a = s;
                b = integer;
                c = kb1;
                d = kg1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/d/kh$2

/* anonymous class */
    final class _cls2
        implements Runnable
    {

        final String a;
        final byte b[];
        final kh c;

        public final void run()
        {
            Object obj;
            Object obj1;
            File file;
            obj1 = c;
            obj = a;
            byte abyte0[] = b;
            file = ((kh) (obj1)).b(((String) (obj)));
            try
            {
                obj1 = new FileOutputStream(file);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aj.a("Error opening resource file for writing");
                return;
            }
            ((FileOutputStream) (obj1)).write(abyte0);
            try
            {
                ((FileOutputStream) (obj1)).close();
                (new StringBuilder("Resource ")).append(((String) (obj))).append(" saved on Disk.");
                aj.d();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aj.a("Error closing stream for writing resource to disk");
            }
            return;
            Object obj2;
            obj2;
            aj.a("Error writing resource to disk. Removing resource from disk");
            file.delete();
            try
            {
                ((FileOutputStream) (obj1)).close();
                (new StringBuilder("Resource ")).append(((String) (obj))).append(" saved on Disk.");
                aj.d();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aj.a("Error closing stream for writing resource to disk");
            }
            return;
            obj2;
            try
            {
                ((FileOutputStream) (obj1)).close();
                (new StringBuilder("Resource ")).append(((String) (obj))).append(" saved on Disk.");
                aj.d();
            }
            catch (IOException ioexception)
            {
                aj.a("Error closing stream for writing resource to disk");
            }
            throw obj2;
        }

            
            {
                c = kh.this;
                a = s;
                b = abyte0;
                super();
            }
    }

}
