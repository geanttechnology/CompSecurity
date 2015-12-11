// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.spi;

import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.LogLog;

public class LocationInfo
    implements Serializable
{

    public static final LocationInfo NA_LOCATION_INFO;
    static Class class$java$lang$Throwable;
    private static Method getClassNameMethod;
    private static Method getFileNameMethod;
    private static Method getLineNumberMethod;
    private static Method getMethodNameMethod;
    private static Method getStackTraceMethod;
    static boolean inVisualAge;
    private static PrintWriter pw;
    private static StringWriter sw;
    transient String className;
    transient String fileName;
    public String fullInfo;
    transient String lineNumber;
    transient String methodName;

    public LocationInfo(String s, String s1, String s2, String s3)
    {
        fileName = s;
        className = s1;
        methodName = s2;
        lineNumber = s3;
        StringBuffer stringbuffer = new StringBuffer();
        appendFragment(stringbuffer, s1);
        stringbuffer.append(".");
        appendFragment(stringbuffer, s2);
        stringbuffer.append("(");
        appendFragment(stringbuffer, s);
        stringbuffer.append(":");
        appendFragment(stringbuffer, s3);
        stringbuffer.append(")");
        fullInfo = stringbuffer.toString();
    }

    public LocationInfo(Throwable throwable, String s)
    {
        if (throwable != null && s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (getLineNumberMethod == null) goto _L4; else goto _L3
_L3:
        Object aobj[] = (Object[])(Object[])getStackTraceMethod.invoke(throwable, null);
        obj = "?";
        int i = aobj.length - 1;
_L16:
        if (i < 0) goto _L1; else goto _L5
_L5:
        String s1 = (String)getClassNameMethod.invoke(aobj[i], null);
        if (!s.equals(s1)) goto _L7; else goto _L6
_L6:
        i++;
        if (i >= aobj.length) goto _L1; else goto _L8
_L8:
        className = ((String) (obj));
        methodName = (String)getMethodNameMethod.invoke(aobj[i], null);
        fileName = (String)getFileNameMethod.invoke(aobj[i], null);
        if (fileName == null)
        {
            fileName = "?";
        }
        i = ((Integer)getLineNumberMethod.invoke(aobj[i], null)).intValue();
        if (i >= 0) goto _L10; else goto _L9
_L9:
        lineNumber = "?";
_L15:
        obj = new StringBuffer();
        ((StringBuffer) (obj)).append(className);
        ((StringBuffer) (obj)).append(".");
        ((StringBuffer) (obj)).append(methodName);
        ((StringBuffer) (obj)).append("(");
        ((StringBuffer) (obj)).append(fileName);
        ((StringBuffer) (obj)).append(":");
        ((StringBuffer) (obj)).append(lineNumber);
        ((StringBuffer) (obj)).append(")");
        fullInfo = ((StringBuffer) (obj)).toString();
        return;
        obj;
        LogLog.debug("LocationInfo failed using JDK 1.4 methods", ((Throwable) (obj)));
_L4:
        int j;
        synchronized (sw)
        {
            throwable.printStackTrace(pw);
            throwable = sw.toString();
            sw.getBuffer().setLength(0);
        }
        j = throwable.lastIndexOf(s);
        if (j == -1) goto _L1; else goto _L11
_L11:
        i = j;
        if (s.length() + j < throwable.length())
        {
            i = j;
            if (throwable.charAt(s.length() + j) != '.')
            {
                int k = throwable.lastIndexOf(s + ".");
                i = j;
                if (k != -1)
                {
                    i = k;
                }
            }
        }
        i = throwable.indexOf(Layout.LINE_SEP, i);
        if (i == -1) goto _L1; else goto _L12
_L12:
        i += Layout.LINE_SEP_LEN;
        j = throwable.indexOf(Layout.LINE_SEP, i);
        if (j == -1) goto _L1; else goto _L13
_L13:
        if (inVisualAge)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        i = throwable.lastIndexOf("at ", j);
        if (i == -1) goto _L1; else goto _L14
_L14:
        i += 3;
        fullInfo = throwable.substring(i, j);
        return;
_L10:
        lineNumber = String.valueOf(i);
          goto _L15
        obj;
        if ((((InvocationTargetException) (obj)).getTargetException() instanceof InterruptedException) || (((InvocationTargetException) (obj)).getTargetException() instanceof InterruptedIOException))
        {
            Thread.currentThread().interrupt();
        }
        LogLog.debug("LocationInfo failed using JDK 1.4 methods", ((Throwable) (obj)));
          goto _L4
_L7:
        obj = s1;
        i--;
          goto _L16
        obj;
        LogLog.debug("LocationInfo failed using JDK 1.4 methods", ((Throwable) (obj)));
          goto _L4
        throwable;
        obj;
        JVM INSTR monitorexit ;
        throw throwable;
          goto _L16
    }

    private static final void appendFragment(StringBuffer stringbuffer, String s)
    {
        if (s == null)
        {
            stringbuffer.append("?");
            return;
        } else
        {
            stringbuffer.append(s);
            return;
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public String getClassName()
    {
        if (fullInfo == null)
        {
            return "?";
        }
        if (className == null)
        {
            int i = fullInfo.lastIndexOf('(');
            if (i == -1)
            {
                className = "?";
            } else
            {
                int j = fullInfo.lastIndexOf('.', i);
                i = 0;
                if (inVisualAge)
                {
                    i = fullInfo.lastIndexOf(' ', j) + 1;
                }
                if (j == -1)
                {
                    className = "?";
                } else
                {
                    className = fullInfo.substring(i, j);
                }
            }
        }
        return className;
    }

    public String getFileName()
    {
        if (fullInfo == null)
        {
            return "?";
        }
        if (fileName == null)
        {
            int i = fullInfo.lastIndexOf(':');
            if (i == -1)
            {
                fileName = "?";
            } else
            {
                int j = fullInfo.lastIndexOf('(', i - 1);
                fileName = fullInfo.substring(j + 1, i);
            }
        }
        return fileName;
    }

    public String getLineNumber()
    {
        if (fullInfo == null)
        {
            return "?";
        }
        if (lineNumber == null)
        {
            int i = fullInfo.lastIndexOf(')');
            int j = fullInfo.lastIndexOf(':', i - 1);
            if (j == -1)
            {
                lineNumber = "?";
            } else
            {
                lineNumber = fullInfo.substring(j + 1, i);
            }
        }
        return lineNumber;
    }

    public String getMethodName()
    {
        if (fullInfo == null)
        {
            return "?";
        }
        if (methodName == null)
        {
            int i = fullInfo.lastIndexOf('(');
            int j = fullInfo.lastIndexOf('.', i);
            if (j == -1)
            {
                methodName = "?";
            } else
            {
                methodName = fullInfo.substring(j + 1, i);
            }
        }
        return methodName;
    }

    static 
    {
        boolean flag;
        flag = false;
        sw = new StringWriter();
        pw = new PrintWriter(sw);
        NA_LOCATION_INFO = new LocationInfo("?", "?", "?", "?");
        inVisualAge = false;
        if (Class.forName("com.ibm.uvm.tools.DebugSupport") != null)
        {
            flag = true;
        }
        Class class1;
        Object obj;
        try
        {
            inVisualAge = flag;
            LogLog.debug("Detected IBM VisualAge environment.");
        }
        catch (Throwable throwable) { }
        if (class$java$lang$Throwable != null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        class1 = _mthclass$("java.lang.Throwable");
        class$java$lang$Throwable = class1;
_L1:
        getStackTraceMethod = class1.getMethod("getStackTrace", null);
        class1 = Class.forName("java.lang.StackTraceElement");
        getClassNameMethod = class1.getMethod("getClassName", null);
        getMethodNameMethod = class1.getMethod("getMethodName", null);
        getFileNameMethod = class1.getMethod("getFileName", null);
        getLineNumberMethod = class1.getMethod("getLineNumber", null);
        return;
        try
        {
            class1 = class$java$lang$Throwable;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogLog.debug("LocationInfo will use pre-JDK 1.4 methods to determine location.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogLog.debug("LocationInfo will use pre-JDK 1.4 methods to determine location.");
            return;
        }
          goto _L1
    }
}
