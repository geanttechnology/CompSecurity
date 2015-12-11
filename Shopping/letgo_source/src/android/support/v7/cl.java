// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class cl extends Exception
{

    private List a;

    public cl(String s, List list)
    {
        Throwable throwable;
        if (list != null && list.size() > 0)
        {
            throwable = (Throwable)list.get(0);
        } else
        {
            throwable = null;
        }
        super(s, throwable);
        a = Collections.unmodifiableList(list);
    }

    public void printStackTrace(PrintStream printstream)
    {
        super.printStackTrace(printstream);
        Iterator iterator = a.iterator();
        int i = -1;
        for (; iterator.hasNext(); printstream.append("\n"))
        {
            Throwable throwable = (Throwable)iterator.next();
            printstream.append("\n");
            printstream.append("  Inner throwable #");
            i++;
            printstream.append(Integer.toString(i));
            printstream.append(": ");
            throwable.printStackTrace(printstream);
        }

    }

    public void printStackTrace(PrintWriter printwriter)
    {
        super.printStackTrace(printwriter);
        Iterator iterator = a.iterator();
        int i = -1;
        for (; iterator.hasNext(); printwriter.append("\n"))
        {
            Throwable throwable = (Throwable)iterator.next();
            printwriter.append("\n");
            printwriter.append("  Inner throwable #");
            i++;
            printwriter.append(Integer.toString(i));
            printwriter.append(": ");
            throwable.printStackTrace(printwriter);
        }

    }
}
