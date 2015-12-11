// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            am, p, an, bf, 
//            av

public class ac extends am
    implements p
{

    public ac()
    {
        a(System.currentTimeMillis());
        a(an.a);
    }

    public ac(String s)
    {
        this();
        a(s);
    }

    public ac(Throwable throwable)
    {
        this();
        a(a(throwable));
    }

    private String a(Throwable throwable)
    {
        Throwable throwable1;
        Object obj;
        PrintWriter printwriter;
        obj = null;
        if (throwable == null)
        {
            return null;
        }
        throwable1 = obj;
        StringWriter stringwriter;
        try
        {
            stringwriter = new StringWriter();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return throwable1;
        }
        throwable1 = obj;
        printwriter = new PrintWriter(stringwriter);
        throwable1 = obj;
        throwable.printStackTrace(printwriter);
        throwable1 = obj;
        throwable = throwable.getCause();
_L1:
        if (throwable != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        throwable1 = obj;
        throwable = stringwriter.toString();
        throwable1 = throwable;
        printwriter.close();
        throwable1 = throwable;
        stringwriter.close();
        return throwable;
        throwable1 = obj;
        throwable.printStackTrace(printwriter);
        throwable1 = obj;
        throwable = throwable.getCause();
          goto _L1
    }

    public ac a(boolean flag)
    {
        an an1;
        if (flag)
        {
            an1 = an.a;
        } else
        {
            an1 = an.b;
        }
        a(an1);
        return this;
    }

    public void a(bf bf1, String s)
    {
        if (bf1.s() <= 0) goto _L2; else goto _L1
_L1:
        Object obj = bf1.u().iterator();
_L5:
        if (((Iterator) (obj)).hasNext()) goto _L3; else goto _L2
_L2:
        av av1 = null;
_L4:
        obj = av1;
        if (av1 == null)
        {
            obj = new av();
            ((av) (obj)).a(s);
            bf1.a(((av) (obj)));
        }
        ((av) (obj)).a(this);
        return;
_L3:
        av1 = (av)((Iterator) (obj)).next();
        if (!s.equals(av1.c())) goto _L5; else goto _L4
    }
}
