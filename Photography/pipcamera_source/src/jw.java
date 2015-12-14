// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Process;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class jw
{

    private static Map a = new HashMap();
    private jx b;

    private jw(File file, int i, int j)
    {
        if (!file.exists())
        {
            file.mkdirs();
        }
        b = new jx(this, file, i, j);
    }

    private static String a()
    {
        return (new StringBuilder()).append("_").append(Process.myPid()).toString();
    }

    public static jw a(Context context)
    {
        return a(new File(context.getCacheDir(), "ACache"), 0x1312d00, 0x186a0);
    }

    public static jw a(File file, int i, int j)
    {
        jw jw2 = (jw)a.get((new StringBuilder()).append(file.getAbsoluteFile()).append(a()).toString());
        jw jw1 = jw2;
        if (jw2 == null)
        {
            jw1 = new jw(file, i, j);
            a.put((new StringBuilder()).append(file.getAbsolutePath()).append(a()).toString(), jw1);
        }
        return jw1;
    }

    public String a(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = jx.b(b, s);
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        obj = obj1;
_L6:
        return ((String) (obj));
_L2:
        BufferedReader bufferedreader = new BufferedReader(new FileReader(((File) (obj))));
        String s1 = "";
_L4:
        obj = bufferedreader;
        String s2 = bufferedreader.readLine();
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = bufferedreader;
        s1 = (new StringBuilder()).append(s1).append(s2).toString();
        if (true) goto _L4; else goto _L3
_L3:
        obj = bufferedreader;
        if (jy.a(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = bufferedreader;
        s = jy.b(s1);
        obj = s;
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                return s;
            }
            return s;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        c(s);
        return null;
        IOException ioexception1;
        ioexception1;
        s = null;
_L10:
        obj = s;
        ioexception1.printStackTrace();
        obj = obj1;
        if (s == null) goto _L6; else goto _L7
_L7:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return null;
        s;
        obj = null;
_L9:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw s;
        s;
        if (true) goto _L9; else goto _L8
_L8:
        ioexception1;
        s = bufferedreader;
          goto _L10
    }

    public void a(String s, String s1)
    {
        File file;
        file = jx.a(b, s);
        s = null;
        Object obj = new BufferedWriter(new FileWriter(file), 1024);
        s = ((String) (obj));
        ((BufferedWriter) (obj)).write(s1);
        if (obj != null)
        {
            try
            {
                ((BufferedWriter) (obj)).flush();
                ((BufferedWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        jx.a(b, file);
        return;
        IOException ioexception;
        ioexception;
        s1 = null;
_L4:
        s = s1;
        ioexception.printStackTrace();
        if (s1 != null)
        {
            try
            {
                s1.flush();
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        jx.a(b, file);
        return;
        obj;
        s1 = s;
        s = ((String) (obj));
_L2:
        if (s1 != null)
        {
            try
            {
                s1.flush();
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1.printStackTrace();
            }
        }
        jx.a(b, file);
        throw s;
        obj;
        s1 = s;
        s = ((String) (obj));
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
        s1 = ((String) (obj));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(String s, String s1, int i)
    {
        a(s, jy.a(i, s1));
    }

    public void a(String s, JSONObject jsonobject, int i)
    {
        a(s, jsonobject.toString(), i);
    }

    public JSONObject b(String s)
    {
        s = a(s);
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public boolean c(String s)
    {
        return jx.c(b, s);
    }

}
