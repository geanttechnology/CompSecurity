// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;

import java.io.PrintStream;

public final class Debug
{

    public static Debug debug = new Debug();
    public static boolean enabled = false;
    private PrintStream out;

    public Debug()
    {
        out = System.out;
    }

    public static Debug getDebug()
    {
        return debug;
    }

    public static boolean isOn()
    {
        return enabled;
    }

    public static final void message(String s)
    {
        if (enabled)
        {
            debug.getOut().println((new StringBuilder("CyberGarage message : ")).append(s).toString());
        }
    }

    public static final void message(String s, String s1)
    {
        if (enabled)
        {
            debug.getOut().println("CyberGarage message : ");
        }
        debug.getOut().println(s);
        debug.getOut().println(s1);
    }

    public static final void off()
    {
        enabled = false;
    }

    public static final void on()
    {
        enabled = true;
    }

    public static final void warning(Exception exception)
    {
        warning(exception.getMessage());
        exception.printStackTrace(debug.getOut());
    }

    public static final void warning(String s)
    {
        debug.getOut().println((new StringBuilder("CyberGarage warning : ")).append(s).toString());
    }

    public static final void warning(String s, Exception exception)
    {
        if (exception.getMessage() == null)
        {
            debug.getOut().println((new StringBuilder("CyberGarage warning : ")).append(s).append(" START").toString());
            exception.printStackTrace(debug.getOut());
            debug.getOut().println((new StringBuilder("CyberGarage warning : ")).append(s).append(" END").toString());
            return;
        } else
        {
            debug.getOut().println((new StringBuilder("CyberGarage warning : ")).append(s).append(" (").append(exception.getMessage()).append(")").toString());
            exception.printStackTrace(debug.getOut());
            return;
        }
    }

    public PrintStream getOut()
    {
        this;
        JVM INSTR monitorenter ;
        PrintStream printstream = out;
        this;
        JVM INSTR monitorexit ;
        return printstream;
        Exception exception;
        exception;
        throw exception;
    }

    public void setOut(PrintStream printstream)
    {
        this;
        JVM INSTR monitorenter ;
        out = printstream;
        this;
        JVM INSTR monitorexit ;
        return;
        printstream;
        throw printstream;
    }

}
