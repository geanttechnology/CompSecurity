// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.log4j.spi.ThrowableRenderer;

public final class DefaultThrowableRenderer
    implements ThrowableRenderer
{

    public static String[] render(Throwable throwable)
    {
        Object obj = new StringWriter();
        Object obj1 = new PrintWriter(((java.io.Writer) (obj)));
        try
        {
            throwable.printStackTrace(((PrintWriter) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable) { }
        ((PrintWriter) (obj1)).flush();
        obj1 = new LineNumberReader(new StringReader(((StringWriter) (obj)).toString()));
        obj = new ArrayList();
        throwable = ((LineNumberReader) (obj1)).readLine();
_L2:
        if (throwable == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ArrayList) (obj)).add(throwable);
        throwable = ((LineNumberReader) (obj1)).readLine();
        if (true) goto _L2; else goto _L1
        throwable;
        if (throwable instanceof InterruptedIOException)
        {
            Thread.currentThread().interrupt();
        }
        ((ArrayList) (obj)).add(throwable.toString());
_L1:
        throwable = new String[((ArrayList) (obj)).size()];
        ((ArrayList) (obj)).toArray(throwable);
        return throwable;
    }

    public String[] doRender(Throwable throwable)
    {
        return render(throwable);
    }
}
