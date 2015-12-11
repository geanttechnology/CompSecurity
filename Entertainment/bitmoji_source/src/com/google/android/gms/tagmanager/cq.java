// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.ke;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.tagmanager:
//            ba, bh, cr, bg, 
//            ce

class cq
    implements o.f
{

    private final String TM;
    private bg Wi;
    private final ExecutorService Wp = Executors.newSingleThreadExecutor();
    private final Context mContext;

    cq(Context context, String s)
    {
        mContext = context;
        TM = s;
    }

    private cr.c a(ByteArrayOutputStream bytearrayoutputstream)
    {
        try
        {
            bytearrayoutputstream = ba.br(bytearrayoutputstream.toString("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayOutputStream bytearrayoutputstream)
        {
            bh.s("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayOutputStream bytearrayoutputstream)
        {
            bh.w("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
        return bytearrayoutputstream;
    }

    private cr.c k(byte abyte0[])
    {
        try
        {
            abyte0 = cr.b(com.google.android.gms.internal.c.f.a(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bh.w("Resource doesn't contain a binary container");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bh.w("Resource doesn't contain a binary container");
            return null;
        }
        return abyte0;
    }

    public void a(bg bg1)
    {
        Wi = bg1;
    }

    public void b(com.google.android.gms.internal.jd.a a1)
    {
        Wp.execute(new Runnable(a1) {

            final cq Wq;
            final com.google.android.gms.internal.jd.a Wr;

            public void run()
            {
                Wq.c(Wr);
            }

            
            {
                Wq = cq.this;
                Wr = a1;
                super();
            }
        });
    }

    public cr.c bP(int i)
    {
        bh.v((new StringBuilder()).append("Atttempting to load container from resource ID ").append(i).toString());
        Object obj;
        Object obj1;
        try
        {
            obj1 = mContext.getResources().openRawResource(i);
            obj = new ByteArrayOutputStream();
            cr.b(((java.io.InputStream) (obj1)), ((java.io.OutputStream) (obj)));
            obj1 = a(((ByteArrayOutputStream) (obj)));
        }
        catch (IOException ioexception)
        {
            bh.w((new StringBuilder()).append("Error reading default container resource with ID ").append(i).toString());
            return null;
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            bh.w("No default container resource found.");
            return null;
        }
        if (obj1 != null)
        {
            return ((cr.c) (obj1));
        }
        obj = k(((ByteArrayOutputStream) (obj)).toByteArray());
        return ((cr.c) (obj));
    }

    boolean c(com.google.android.gms.internal.jd.a a1)
    {
        FileOutputStream fileoutputstream;
        File file;
        file = jD();
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.jd.a a1)
        {
            bh.t("Error opening resource file for writing");
            return false;
        }
        fileoutputstream.write(ke.d(a1));
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.jd.a a1)
        {
            bh.w("error closing stream for writing resource to disk");
            return true;
        }
        return true;
        a1;
        bh.w("Error writing resource to disk. Removing resource from disk.");
        file.delete();
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.jd.a a1)
        {
            bh.w("error closing stream for writing resource to disk");
            return false;
        }
        return false;
        a1;
        try
        {
            fileoutputstream.close();
        }
        catch (IOException ioexception)
        {
            bh.w("error closing stream for writing resource to disk");
        }
        throw a1;
    }

    public void iN()
    {
        Wp.execute(new Runnable() {

            final cq Wq;

            public void run()
            {
                Wq.jC();
            }

            
            {
                Wq = cq.this;
                super();
            }
        });
    }

    void jC()
    {
        Object obj;
        if (Wi == null)
        {
            throw new IllegalStateException("callback must be set before execute");
        }
        Wi.iM();
        bh.v("Start loading resource from disk ...");
        if ((ce.ju().jv() == ce.a.VX || ce.ju().jv() == ce.a.VY) && TM.equals(ce.ju().getContainerId()))
        {
            Wi.a(bg.a.VA);
            return;
        }
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            obj = new FileInputStream(jD());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bh.s("resource not on disk");
            Wi.a(bg.a.VA);
            return;
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        cr.b(((java.io.InputStream) (obj)), bytearrayoutputstream);
        Wi.i(com.google.android.gms.internal.jd.a.l(bytearrayoutputstream.toByteArray()));
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bh.w("error closing stream for reading resource from disk");
        }
_L2:
        bh.v("Load resource from disk finished.");
        return;
        Object obj1;
        obj1;
        bh.w("error reading resource from disk");
        Wi.a(bg.a.VB);
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bh.w("error closing stream for reading resource from disk");
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        try
        {
            ((FileInputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            bh.w("error closing stream for reading resource from disk");
        }
        throw obj1;
    }

    File jD()
    {
        String s = (new StringBuilder()).append("resource_").append(TM).toString();
        return new File(mContext.getDir("google_tagmanager", 0), s);
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        Wp.shutdown();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
