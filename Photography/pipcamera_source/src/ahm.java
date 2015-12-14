// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ahm extends ahl
{

    protected String a;

    public ahm(Context context, String s)
    {
        a = a(context, s);
    }

    public Object a(String s, aho aho1)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        s = new File((new StringBuilder()).append(a).append("/").append(s).toString());
        if (!s.exists()) goto _L2; else goto _L1
_L1:
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(s));
        s = bufferedinputstream;
        aho1 = ((aho) (aho1.a(bufferedinputstream)));
        s = aho1;
        if (bufferedinputstream == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        bufferedinputstream.close();
        s = aho1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        Crashlytics.logException(s);
        s = aho1;
        if (true) goto _L4; else goto _L3
_L3:
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = obj;
        if (true) goto _L4; else goto _L5
_L5:
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            this;
        }
        Crashlytics.logException(s);
        s = obj;
          goto _L4
        aho1;
        bufferedinputstream = null;
_L12:
        s = bufferedinputstream;
        aho1.printStackTrace();
        s = bufferedinputstream;
        Crashlytics.logException(aho1);
        s = obj;
        if (bufferedinputstream == null) goto _L4; else goto _L6
_L6:
        bufferedinputstream.close();
        s = obj;
          goto _L4
        s;
        Crashlytics.logException(s);
        s = obj;
          goto _L4
        aho1;
        bufferedinputstream = null;
_L11:
        s = bufferedinputstream;
        aho1.printStackTrace();
        s = bufferedinputstream;
        Crashlytics.logException(aho1);
        s = obj;
        if (bufferedinputstream == null) goto _L4; else goto _L7
_L7:
        bufferedinputstream.close();
        s = obj;
          goto _L4
        s;
        Crashlytics.logException(s);
        s = obj;
          goto _L4
        aho1;
        s = null;
_L10:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        s.close();
_L8:
        throw aho1;
        s;
        Crashlytics.logException(s);
          goto _L8
        aho1;
        if (true) goto _L10; else goto _L9
_L9:
        aho1;
          goto _L11
        aho1;
          goto _L12
    }

    protected String a(Context context, String s)
    {
        context = context.getApplicationContext().getCacheDir().getAbsolutePath();
        context = (new StringBuilder()).append(context).append("/opens/").append(s).toString();
        (new File(context)).mkdirs();
        return context;
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = new File((new StringBuilder()).append(a).append("/").append(s).toString());
        if (s.exists())
        {
            s.delete();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void a(String s, Object obj, aho aho1)
    {
        this;
        JVM INSTR monitorenter ;
        File file = new File((new StringBuilder()).append(a).append("/").append(s).toString());
        BufferedOutputStream bufferedoutputstream;
        Object obj1;
        bufferedoutputstream = null;
        obj1 = null;
        s = bufferedoutputstream;
        file.createNewFile();
        s = bufferedoutputstream;
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file));
        s = bufferedoutputstream;
        aho1.a(bufferedoutputstream, obj);
        if (bufferedoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        bufferedoutputstream.close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        Crashlytics.logException(s);
          goto _L1
        s;
        throw s;
        obj;
        bufferedoutputstream = null;
_L8:
        s = bufferedoutputstream;
        ((FileNotFoundException) (obj)).printStackTrace();
        s = bufferedoutputstream;
        Crashlytics.logException(((Throwable) (obj)));
        if (bufferedoutputstream == null) goto _L1; else goto _L2
_L2:
        bufferedoutputstream.close();
          goto _L1
        s;
        Crashlytics.logException(s);
          goto _L1
        aho1;
        obj = obj1;
_L7:
        s = ((String) (obj));
        aho1.printStackTrace();
        s = ((String) (obj));
        Crashlytics.logException(aho1);
        if (obj == null) goto _L1; else goto _L3
_L3:
        ((BufferedOutputStream) (obj)).close();
          goto _L1
        s;
        Crashlytics.logException(s);
          goto _L1
        aho1;
        obj = s;
        s = aho1;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        ((BufferedOutputStream) (obj)).close();
_L4:
        throw s;
        obj;
        Crashlytics.logException(((Throwable) (obj)));
          goto _L4
        aho1;
        obj = s;
        s = aho1;
        if (true) goto _L6; else goto _L5
_L5:
        aho1;
        obj = bufferedoutputstream;
          goto _L7
        obj;
          goto _L8
    }
}
