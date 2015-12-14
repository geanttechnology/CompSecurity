// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.Environment;
import com.pf.common.utility.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class c
{

    public static String a = "BaseConfigHelper";
    public static final String b = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ymk/").toString();
    private boolean c;
    private Map d;
    private Map e;

    public c()
    {
        c = false;
        d = new HashMap();
        e = new HashMap();
    }

    private void h()
    {
        Properties properties = new Properties();
        FileInputStream fileinputstream = new FileInputStream(c());
        Object obj = fileinputstream;
        properties.load(fileinputstream);
        int l;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                m.b(a, "close config input stream failed", ((Throwable) (obj)));
            }
        }
        obj = (Enum[])b().getEnumConstants();
        l = obj.length;
        for (int k = 0; k < l; k++)
        {
            fileinputstream = obj[k];
            String s = a(fileinputstream);
            m.b("WRITE_CONFIG", (new StringBuilder()).append("default value: ").append(s).toString());
            s = properties.getProperty(fileinputstream.toString(), s);
            d.put(fileinputstream, s);
            e.put(fileinputstream, s);
        }

          goto _L1
        Exception exception1;
        exception1;
        fileinputstream = null;
_L6:
        obj = fileinputstream;
        m.b(a, "load config failed", exception1);
        if (fileinputstream == null) goto _L1; else goto _L2
_L2:
        fileinputstream.close();
_L1:
        return;
        obj;
        m.b(a, "close config input stream failed", ((Throwable) (obj)));
        return;
        Exception exception;
        exception;
        obj = null;
_L4:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                m.b(a, "close config input stream failed", ioexception);
            }
        }
        throw exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        exception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void i()
    {
        Properties properties;
        m.b("WRITE_CONFIG", "write config");
        properties = new Properties();
        java.util.Map.Entry entry;
        for (Iterator iterator = e.entrySet().iterator(); iterator.hasNext(); properties.setProperty(((Enum)entry.getKey()).toString(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            m.b("WRITE_CONFIG", (new StringBuilder()).append("config key: ").append(entry.getKey()).append(", value: ").append((String)entry.getValue()).toString());
        }

        FileOutputStream fileoutputstream = new FileOutputStream(c());
        Object obj = fileoutputstream;
        properties.store(fileoutputstream, null);
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        fileoutputstream.close();
_L2:
        return;
        obj;
        m.b("WRITE_CONFIG", "close config output stream failed", ((Throwable) (obj)));
        return;
        Exception exception1;
        exception1;
        fileoutputstream = null;
_L5:
        obj = fileoutputstream;
        m.b("WRITE_CONFIG", "store config failed", exception1);
        if (fileoutputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            fileoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            m.b("WRITE_CONFIG", "close config output stream failed", ((Throwable) (obj)));
        }
        return;
        Exception exception;
        exception;
        obj = null;
_L4:
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                m.b("WRITE_CONFIG", "close config output stream failed", ioexception);
            }
        }
        throw exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        exception1;
          goto _L5
    }

    private void j()
    {
        if (d())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        File file = new File(c());
        boolean flag;
        if (file.getParentFile().exists())
        {
            flag = true;
        } else
        {
            flag = file.getParentFile().mkdirs();
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (file.createNewFile())
        {
            m.b("WRITE_CONFIG", "succeed in creating setting file");
        }
        return;
        IOException ioexception;
        ioexception;
        m.b(a, "create file failed", ioexception);
        return;
        m.e(a, "create directory failed");
        return;
    }

    public final int a(Enum enum, int k)
    {
        if (d())
        {
            if ((enum = (String)d.get(enum)) != null)
            {
                int l;
                try
                {
                    l = Integer.parseInt(enum);
                }
                // Misplaced declaration of an exception variable
                catch (Enum enum)
                {
                    m.b(a, "parsing error", enum);
                    return k;
                }
                return l;
            }
        }
        return k;
    }

    public abstract String a();

    public abstract String a(Enum enum);

    public final String a(Enum enum, String s)
    {
        if (d())
        {
            if ((enum = (String)d.get(enum)) != null)
            {
                return enum;
            }
        }
        return s;
    }

    public final boolean a(Enum enum, boolean flag)
    {
        if (d())
        {
            if ((enum = (String)d.get(enum)) != null)
            {
                boolean flag1;
                try
                {
                    flag1 = Boolean.parseBoolean(enum);
                }
                // Misplaced declaration of an exception variable
                catch (Enum enum)
                {
                    m.b(a, "parsing error", enum);
                    return flag;
                }
                return flag1;
            }
        }
        return flag;
    }

    public abstract Class b();

    public final void b(Enum enum, String s)
    {
        m.b("WRITE_CONFIG", (new StringBuilder()).append("key: ").append(enum).append(", value: ").append(s).toString());
        e.put(enum, s);
    }

    public final void b(Enum enum, boolean flag)
    {
        m.b("WRITE_CONFIG", (new StringBuilder()).append("key: ").append(enum).append(", value: ").append(flag).toString());
        e.put(enum, Boolean.toString(flag));
    }

    public final String c()
    {
        return (new StringBuilder()).append(b).append(a()).toString();
    }

    public final boolean d()
    {
        if (c)
        {
            return c;
        }
        c = (new File(c())).exists();
        if (c)
        {
            m.b(a, "test config exists");
            h();
        } else
        {
            m.b(a, "no test config");
        }
        return c;
    }

    public final void e()
    {
        j();
        i();
    }

    public final void f()
    {
label0:
        {
            if (d())
            {
                if (!(new File(c())).delete())
                {
                    break label0;
                }
                m.b("WRITE_CONFIG", "succeed deleting existing file");
            }
            return;
        }
        m.b("WRITE_CONFIG", "failed deleting existing file");
    }

    public final void g()
    {
        c = false;
    }

}
