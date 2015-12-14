// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.os.AsyncTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.cyberlink.you.utility:
//            d, g, e

class f extends AsyncTask
{

    final e a;
    private String b;
    private String c;
    private Map d;

    public f(e e1)
    {
        a = e1;
        super();
        b = null;
        c = null;
        d = new HashMap();
    }

    static void a(f f1, String s)
    {
        f1.a(s);
    }

    static void a(f f1, String s, g g1)
    {
        f1.a(s, g1);
    }

    private void a(String s)
    {
        c = s;
    }

    private void a(String s, g g1)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = UUID.randomUUID().toString();
        }
        d.put(s1, g1);
    }

    public transient Boolean a(String as[])
    {
        Object obj1;
        Object obj2;
        Object obj4;
        byte abyte0[];
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        String s;
        Thread.currentThread().setName("DownloadTask AsyncTask");
        if (c == null)
        {
            return Boolean.valueOf(false);
        }
        s = (new StringBuilder()).append(c).append(".temp").toString();
        File file1;
        Object obj9;
        Object obj10;
        try
        {
            File file = new File(s);
            if (file.exists())
            {
                file.delete();
            }
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return Boolean.valueOf(false);
        }
        obj9 = null;
        obj7 = null;
        obj1 = null;
        obj10 = null;
        obj6 = null;
        obj5 = null;
        file1 = null;
        obj8 = null;
        obj2 = file1;
        obj4 = obj10;
        abyte0 = obj9;
        b = as[0];
        obj2 = file1;
        obj4 = obj10;
        abyte0 = obj9;
        as = (HttpURLConnection)(new URL(b)).openConnection();
        as.connect();
        if (as.getResponseCode() == 200)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        if (false)
        {
            Object obj;
            IOException ioexception;
            Exception exception;
            Object obj3;
            String as1[];
            int i;
            int j;
            long l;
            boolean flag1;
            try
            {
                throw new NullPointerException();
            }
            catch (IOException ioexception1) { }
            break MISSING_BLOCK_LABEL_173;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        throw new NullPointerException();
        if (as != null)
        {
            as.disconnect();
        }
        try
        {
            file1 = new File(s);
            as = new File(c);
            if (file1.exists())
            {
                if (as.exists())
                {
                    com.cyberlink.you.utility.d.a(as);
                }
                file1.renameTo(as);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
        }
        return Boolean.valueOf(false);
        j = as.getContentLength();
        obj = as.getInputStream();
        obj4 = new FileOutputStream(s);
        obj1 = new byte[4096];
        l = 0L;
_L7:
        i = ((InputStream) (obj)).read(((byte []) (obj1)));
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_746;
        }
        if (!isCancelled()) goto _L2; else goto _L1
_L1:
        ((InputStream) (obj)).close();
        for (boolean flag = false; obj4 == null; flag = true)
        {
            break MISSING_BLOCK_LABEL_319;
        }

        ((OutputStream) (obj4)).close();
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
        }
        if (as != null)
        {
            as.disconnect();
        }
        as = new File(s);
        obj = new File(c);
        if (!as.exists()) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        try
        {
            if (((File) (obj)).exists())
            {
                com.cyberlink.you.utility.d.a(((File) (obj)));
            }
            as.renameTo(((File) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
        }
_L4:
        return Boolean.valueOf(flag);
_L2:
        l += i;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        publishProgress(new Integer[] {
            Integer.valueOf((int)((100L * l) / (long)j))
        });
        ((OutputStream) (obj4)).write(((byte []) (obj1)), 0, i);
          goto _L7
        obj2;
        obj1 = obj;
        obj = obj2;
        obj5 = obj4;
_L11:
        obj2 = as;
        obj4 = obj5;
        abyte0 = ((byte []) (obj1));
        ((Exception) (obj)).printStackTrace();
        flag1 = false;
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_481;
        }
        ((OutputStream) (obj5)).close();
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (as != null)
        {
            as.disconnect();
        }
        as = new File(s);
        new File(c);
        flag = flag1;
        if (!as.exists()) goto _L4; else goto _L8
_L8:
        as.delete();
        flag = flag1;
          goto _L4
        as;
        as.printStackTrace();
        flag = flag1;
          goto _L4
_L6:
        as.delete();
          goto _L4
        as;
        obj1 = abyte0;
        obj = obj2;
_L10:
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_587;
        }
        ((OutputStream) (obj4)).close();
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        try
        {
            obj1 = new File(s);
            obj = new File(c);
            if (((File) (obj1)).exists())
            {
                if (((File) (obj)).exists())
                {
                    com.cyberlink.you.utility.d.a(((File) (obj)));
                }
                ((File) (obj1)).renameTo(((File) (obj)));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        throw as;
        exception;
        obj = as;
        as = exception;
        obj4 = obj6;
        exception = obj7;
        continue; /* Loop/switch isn't completed */
        obj3;
        exception = ((Exception) (obj));
        obj = obj3;
        as1 = as;
        as = ((String []) (obj));
        obj = as1;
        obj4 = obj6;
        continue; /* Loop/switch isn't completed */
        as1;
        exception = ((Exception) (obj));
        obj = as;
        as = as1;
        if (true) goto _L10; else goto _L9
_L9:
        obj;
        as = obj8;
          goto _L11
        obj;
          goto _L11
        as1;
        exception = ((Exception) (obj));
        obj = as1;
          goto _L11
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            for (boolean1 = d.values().iterator(); boolean1.hasNext(); ((g)boolean1.next()).a(c)) { }
        } else
        {
            for (boolean1 = d.values().iterator(); boolean1.hasNext(); ((g)boolean1.next()).a()) { }
        }
        synchronized (e.a())
        {
            String s = (new StringBuilder()).append(b).append(c).toString();
            e.b().remove(s);
        }
        return;
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected transient void a(Integer ainteger[])
    {
        for (Iterator iterator = d.values().iterator(); iterator.hasNext(); ((g)iterator.next()).a(ainteger[0].intValue())) { }
    }

    public Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}
