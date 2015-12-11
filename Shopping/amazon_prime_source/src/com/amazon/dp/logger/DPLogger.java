// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dp.logger;

import android.os.Build;
import android.util.Log;

// Referenced classes of package com.amazon.dp.logger:
//            DPFormattedMessage

public class DPLogger
{

    private static final String BUILD_TYPE;
    protected static final int MAX_TAG_SIZE = 23;
    protected final String mName;

    public DPLogger()
    {
        mName = ensureSafeName(removePackageName((new Throwable()).getStackTrace()[1].getClassName()));
    }

    public DPLogger(Class class1)
    {
        mName = ensureSafeName(class1.getSimpleName());
    }

    public DPLogger(String s)
    {
        mName = ensureSafeName(s);
    }

    private String ensureSafeName(String s)
    {
        if (s == null)
        {
            Log.w("DPLogger", "Got a null DPLogger name; using an empty string instead");
            return "";
        }
        if (s.length() > 23)
        {
            String s1 = s.substring(0, 23);
            Log.i("DPLogger", DPFormattedMessage.toDPFormat("DPLogger", "Name was too long. Truncating", new Object[] {
                "original name", s, "truncated name", s1
            }));
            return s1;
        } else
        {
            return s;
        }
    }

    private static transient Throwable extractThrowable(Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            return null;
        }
        aobj = ((Object []) (aobj[aobj.length - 1]));
        if (aobj instanceof Throwable)
        {
            return (Throwable)aobj;
        } else
        {
            return null;
        }
    }

    private static String removePackageName(String s)
    {
        int i = s.lastIndexOf('.');
        String s1 = s;
        if (i != -1)
        {
            s1 = s;
            if (i <= s.length() - 1)
            {
                s1 = s.substring(i + 1);
            }
        }
        return s1;
    }

    public void debug(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isDebugEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.d(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.d(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void debug(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isDebugEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.d(mName, s);
            }
            return;
        }
        Log.d(mName, s, s1);
    }

    public void error(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isErrorEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.e(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.e(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void error(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isErrorEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.e(mName, s);
            }
            return;
        }
        Log.e(mName, s, s1);
    }

    public void fatal(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isFatalEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.wtf(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.wtf(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void fatal(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isFatalEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.wtf(mName, s);
            }
            return;
        }
        Log.wtf(mName, s, s1);
    }

    public void info(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isInfoEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.i(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.i(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void info(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isInfoEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.i(mName, s);
            }
            return;
        }
        Log.i(mName, s, s1);
    }

    public boolean isDebugEnabled()
    {
        return Log.isLoggable(mName, 3) || "eng".equals(BUILD_TYPE);
    }

    public boolean isErrorEnabled()
    {
        return Log.isLoggable(mName, 6) || "eng".equals(BUILD_TYPE);
    }

    public boolean isFatalEnabled()
    {
        return Log.isLoggable(mName, 7) || "eng".equals(BUILD_TYPE);
    }

    public boolean isInfoEnabled()
    {
        return Log.isLoggable(mName, 4) || "eng".equals(BUILD_TYPE);
    }

    public boolean isTraceEnabled()
    {
        return Log.isLoggable(mName, 2) || "eng".equals(BUILD_TYPE);
    }

    public boolean isVerboseEnabled()
    {
        return Log.isLoggable(mName, 2) || "eng".equals(BUILD_TYPE);
    }

    public boolean isWarnEnabled()
    {
        return Log.isLoggable(mName, 5) || "eng".equals(BUILD_TYPE);
    }

    public void trace(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isTraceEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.v(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.v(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void trace(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isTraceEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.v(mName, s);
            }
            return;
        }
        Log.v(mName, s, s1);
    }

    public void verbose(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isVerboseEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.v(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.v(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void verbose(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isVerboseEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.v(mName, s);
            }
            return;
        }
        Log.v(mName, s, s1);
    }

    public void warn(DPFormattedMessage dpformattedmessage)
    {
label0:
        {
            if (isWarnEnabled())
            {
                if (dpformattedmessage.getThrowable() != null)
                {
                    break label0;
                }
                Log.w(mName, dpformattedmessage.toString());
            }
            return;
        }
        Log.w(mName, dpformattedmessage.toString(), dpformattedmessage.getThrowable());
    }

    public transient void warn(String s, String s1, Object aobj[])
    {
label0:
        {
            if (isWarnEnabled())
            {
                s = DPFormattedMessage.toDPFormat(s, s1, aobj);
                s1 = extractThrowable(aobj);
                if (s1 != null)
                {
                    break label0;
                }
                Log.w(mName, s);
            }
            return;
        }
        Log.w(mName, s, s1);
    }

    static 
    {
        BUILD_TYPE = Build.TYPE;
    }
}
