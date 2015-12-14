// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.b;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.bumptech.glide.load.engine:
//            aa

public final class GlideException extends Exception
{

    private static final StackTraceElement EMPTY_ELEMENTS[] = new StackTraceElement[0];
    private final List causes;
    private Class dataClass;
    private DataSource dataSource;
    private b key;

    public GlideException(String s)
    {
        this(s, Collections.emptyList());
    }

    public GlideException(String s, Exception exception)
    {
        this(s, Collections.singletonList(exception));
    }

    public GlideException(String s, List list)
    {
        super(s);
        setStackTrace(EMPTY_ELEMENTS);
        causes = list;
    }

    private void addRootCauses(Exception exception, List list)
    {
        if (exception instanceof GlideException)
        {
            for (exception = ((GlideException)exception).getCauses().iterator(); exception.hasNext(); addRootCauses((Exception)exception.next(), list)) { }
        } else
        {
            list.add(exception);
        }
    }

    private static void appendCauses(List list, Appendable appendable)
    {
        try
        {
            appendCausesWrapped(list, appendable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
    }

    private static void appendCausesWrapped(List list, Appendable appendable)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            appendable.append("Cause (").append(String.valueOf(i + 1)).append(" of ").append(String.valueOf(j)).append("): ");
            Exception exception = (Exception)list.get(i);
            if (exception instanceof GlideException)
            {
                ((GlideException)exception).printStackTrace(appendable);
            } else
            {
                appendExceptionMessage(exception, appendable);
            }
            i++;
        }
    }

    private static void appendExceptionMessage(Exception exception, Appendable appendable)
    {
        try
        {
            appendable.append(exception.getClass().toString()).append(": ").append(exception.getMessage()).append('\n');
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Appendable appendable)
        {
            throw new RuntimeException(exception);
        }
    }

    private void printStackTrace(Appendable appendable)
    {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new aa(appendable));
    }

    public final Throwable fillInStackTrace()
    {
        return this;
    }

    public final List getCauses()
    {
        return causes;
    }

    public final String getMessage()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(super.getMessage());
        String s;
        if (dataClass != null)
        {
            s = (new StringBuilder(", ")).append(dataClass).toString();
        } else
        {
            s = "";
        }
        stringbuilder = stringbuilder.append(s);
        if (dataSource != null)
        {
            s = (new StringBuilder(", ")).append(dataSource).toString();
        } else
        {
            s = "";
        }
        stringbuilder = stringbuilder.append(s);
        if (key != null)
        {
            s = (new StringBuilder(", ")).append(key).toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

    public final List getRootCauses()
    {
        ArrayList arraylist = new ArrayList();
        addRootCauses(this, arraylist);
        return arraylist;
    }

    public final void logRootCauses(String s)
    {
        Log.e(s, (new StringBuilder()).append(getClass()).append(": ").append(getMessage()).toString());
        List list = getRootCauses();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Log.i(s, (new StringBuilder("Root cause (")).append(i + 1).append(" of ").append(j).append(")").toString(), (Throwable)list.get(i));
        }

    }

    public final void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printstream)
    {
        printStackTrace(((Appendable) (printstream)));
    }

    public final void printStackTrace(PrintWriter printwriter)
    {
        printStackTrace(((Appendable) (printwriter)));
    }

    final void setLoggingDetails(b b, DataSource datasource)
    {
        setLoggingDetails(b, datasource, null);
    }

    final void setLoggingDetails(b b, DataSource datasource, Class class1)
    {
        key = b;
        dataSource = datasource;
        dataClass = class1;
    }

}
