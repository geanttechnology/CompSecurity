// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.b;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package e.b:
//            c, b, d, e

public final class a extends RuntimeException
{

    private final List a;
    private final String b;
    private Throwable c;

    public a(Collection collection)
    {
        c = null;
        LinkedHashSet linkedhashset = new LinkedHashSet();
        ArrayList arraylist = new ArrayList();
        if (collection != null)
        {
            for (collection = collection.iterator(); collection.hasNext();)
            {
                Throwable throwable = (Throwable)collection.next();
                if (throwable instanceof a)
                {
                    linkedhashset.addAll(((a)throwable).a);
                } else
                if (throwable != null)
                {
                    linkedhashset.add(throwable);
                } else
                {
                    linkedhashset.add(new NullPointerException());
                }
            }

        } else
        {
            linkedhashset.add(new NullPointerException());
        }
        arraylist.addAll(linkedhashset);
        a = Collections.unmodifiableList(arraylist);
        b = (new StringBuilder()).append(a.size()).append(" exceptions occurred. ").toString();
    }

    public a(Collection collection, byte byte0)
    {
        this(collection);
    }

    private static List a(Throwable throwable)
    {
        ArrayList arraylist = new ArrayList();
        Throwable throwable1 = throwable.getCause();
        throwable = throwable1;
        if (throwable1 == null)
        {
            return arraylist;
        }
        do
        {
            arraylist.add(throwable);
            if (throwable.getCause() != null)
            {
                throwable = throwable.getCause();
            } else
            {
                return arraylist;
            }
        } while (true);
    }

    private void a(c c1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(this).append("\n");
        StackTraceElement astacktraceelement[] = getStackTrace();
        int k = astacktraceelement.length;
        for (int i = 0; i < k; i++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[i];
            stringbuilder.append("\tat ").append(stacktraceelement).append("\n");
        }

        Iterator iterator = a.iterator();
        for (int j = 1; iterator.hasNext(); j++)
        {
            Throwable throwable = (Throwable)iterator.next();
            stringbuilder.append("  ComposedException ").append(j).append(" :\n");
            a(stringbuilder, throwable, "\t");
        }

        synchronized (c1.a())
        {
            c1.a(stringbuilder.toString());
        }
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    private void a(StringBuilder stringbuilder, Throwable throwable, String s)
    {
        do
        {
            stringbuilder.append(s).append(throwable).append("\n");
            s = throwable.getStackTrace();
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = s[i];
                stringbuilder.append("\t\tat ").append(obj).append("\n");
            }

            if (throwable.getCause() != null)
            {
                stringbuilder.append("\tCaused by: ");
                throwable = throwable.getCause();
                s = "";
            } else
            {
                return;
            }
        } while (true);
    }

    public final Throwable getCause()
    {
        this;
        JVM INSTR monitorenter ;
        b b1;
        HashSet hashset;
        Iterator iterator;
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        b1 = new b();
        hashset = new HashSet();
        iterator = a.iterator();
        Object obj = b1;
_L3:
        Object obj1;
        Iterator iterator1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_170;
            }
            obj1 = (Throwable)iterator.next();
        } while (hashset.contains(obj1));
        hashset.add(obj1);
        iterator1 = a(((Throwable) (obj1))).iterator();
_L2:
        Throwable throwable1;
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_156;
            }
            throwable1 = (Throwable)iterator1.next();
            if (!hashset.contains(throwable1))
            {
                break MISSING_BLOCK_LABEL_138;
            }
            obj1 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
        } while (true);
        hashset.add(throwable1);
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
        try
        {
            ((Throwable) (obj)).initCause(((Throwable) (obj1)));
        }
        catch (Throwable throwable) { }
        obj = ((Throwable) (obj)).getCause();
          goto _L3
        c = b1;
        obj = c;
        this;
        JVM INSTR monitorexit ;
        return ((Throwable) (obj));
    }

    public final String getMessage()
    {
        return b;
    }

    public final void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printstream)
    {
        a(new d(printstream));
    }

    public final void printStackTrace(PrintWriter printwriter)
    {
        a(new e(printwriter));
    }
}
