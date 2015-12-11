// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.math;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MathRuntimeException extends RuntimeException
{

    private final Object arguments[];
    private final String pattern;

    private static transient String buildMessage(Locale locale, String s, Object aobj[])
    {
        if (s == null)
        {
            return "";
        } else
        {
            return (new MessageFormat(translate(s, locale), locale)).format(((Object) (aobj)));
        }
    }

    public static transient IllegalArgumentException createIllegalArgumentException(String s, Object aobj[])
    {
        return new IllegalArgumentException(buildMessage(Locale.US, s, aobj), s, aobj) {

            final Object val$arguments[];
            final String val$pattern;

            public String getLocalizedMessage()
            {
                return MathRuntimeException.buildMessage(Locale.getDefault(), pattern, arguments);
            }

            
            {
                pattern = s1;
                arguments = aobj;
                super(s);
            }
        };
    }

    private static String translate(String s, Locale locale)
    {
        String s1;
        ResourceBundle resourcebundle;
        try
        {
            resourcebundle = ResourceBundle.getBundle("org.apache.commons.math.MessagesResources", locale);
        }
        // Misplaced declaration of an exception variable
        catch (Locale locale)
        {
            return s;
        }
        s1 = s;
        if (resourcebundle.getLocale().getLanguage().equals(locale.getLanguage()))
        {
            s1 = resourcebundle.getString(s);
        }
        return s1;
    }

    public String getLocalizedMessage()
    {
        return getMessage(Locale.getDefault());
    }

    public String getMessage(Locale locale)
    {
        return buildMessage(locale, pattern, arguments);
    }

    public void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printstream)
    {
        printstream;
        JVM INSTR monitorenter ;
        PrintWriter printwriter = new PrintWriter(printstream, false);
        printStackTrace(printwriter);
        printwriter.flush();
        printstream;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        printstream;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
