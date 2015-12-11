// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.api.Status;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package android.support.v7:
//            vq, abo, xd, xi

public class xj
{

    public static final Integer a = Integer.valueOf(0);
    public static final Integer b = Integer.valueOf(1);
    private final Context c;
    private final ExecutorService d;

    public xj(Context context)
    {
        this(context, Executors.newSingleThreadExecutor());
    }

    xj(Context context, ExecutorService executorservice)
    {
        c = context;
        d = executorservice;
    }

    private byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        vq.a(inputstream, bytearrayoutputstream);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            abo.b("Error closing stream for reading resource from disk");
            return null;
        }
_L2:
        return bytearrayoutputstream.toByteArray();
        IOException ioexception;
        ioexception;
        abo.b("Failed to read the resource from disk");
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            abo.b("Error closing stream for reading resource from disk");
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
            abo.b("Error closing stream for reading resource from disk");
            return null;
        }
        throw exception;
    }

    private String c(String s)
    {
        return (new StringBuilder()).append("resource_").append(s).toString();
    }

    public long a(String s)
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

    public void a(String s, Integer integer, xd xd1, xi xi1)
    {
        d.execute(new Runnable(s, integer, xd1, xi1) {

            final String a;
            final Integer b;
            final xd c;
            final xi d;
            final xj e;

            public void run()
            {
                e.b(a, b, c, d);
            }

            
            {
                e = xj.this;
                a = s;
                b = integer;
                c = xd1;
                d = xi1;
                super();
            }
        });
    }

    public void a(String s, byte abyte0[])
    {
        d.execute(new Runnable(s, abyte0) {

            final String a;
            final byte b[];
            final xj c;

            public void run()
            {
                c.b(a, b);
            }

            
            {
                c = xj.this;
                a = s;
                b = abyte0;
                super();
            }
        });
    }

    File b(String s)
    {
        return new File(c.getDir("google_tagmanager", 0), c(s));
    }

    void b(String s, Integer integer, xd xd1, xi xi1)
    {
        abo.d("DiskLoader: Starting to load resource from Disk.");
        Object obj = xd1.a(a(new FileInputStream(b(s))));
        if (obj != null)
        {
            try
            {
                abo.d((new StringBuilder()).append("Saved resource loaded: ").append(c(s)).toString());
                xi1.a(Status.a, obj, b, a(s));
                return;
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                abo.a((new StringBuilder()).append("Saved resource not found: ").append(c(s)).toString());
            }
            catch (xh.g g)
            {
                abo.a((new StringBuilder()).append("Saved resource is corrupted: ").append(c(s)).toString());
            }
        }
        if (integer == null)
        {
            xi1.a(Status.c, null, null, 0L);
            return;
        }
        s = c.getResources().openRawResource(integer.intValue());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        s = ((String) (xd1.a(a(s))));
        if (s != null)
        {
            try
            {
                abo.d((new StringBuilder()).append("Default resource loaded: ").append(c.getResources().getResourceEntryName(integer.intValue())).toString());
                xi1.a(Status.a, s, a, 0L);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                abo.a((new StringBuilder()).append("Default resource not found. ID: ").append(integer).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                abo.a((new StringBuilder()).append("Default resource resource is corrupted: ").append(integer).toString());
            }
        }
        xi1.a(Status.c, null, null, 0L);
        return;
    }

    void b(String s, byte abyte0[])
    {
        FileOutputStream fileoutputstream;
        File file;
        file = b(s);
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.a("Error opening resource file for writing");
            return;
        }
        fileoutputstream.write(abyte0);
        try
        {
            fileoutputstream.close();
            abo.d((new StringBuilder()).append("Resource ").append(s).append(" saved on Disk.").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.a("Error closing stream for writing resource to disk");
        }
        return;
        abyte0;
        abo.a("Error writing resource to disk. Removing resource from disk");
        file.delete();
        try
        {
            fileoutputstream.close();
            abo.d((new StringBuilder()).append("Resource ").append(s).append(" saved on Disk.").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.a("Error closing stream for writing resource to disk");
        }
        return;
        abyte0;
        try
        {
            fileoutputstream.close();
            abo.d((new StringBuilder()).append("Resource ").append(s).append(" saved on Disk.").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.a("Error closing stream for writing resource to disk");
        }
        throw abyte0;
    }

}
