// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Locale;

// Referenced classes of package roboguice.util:
//            LnInterface, Ln, Strings

public class LnImpl
    implements LnInterface
{

    protected int minimumLogLevel;
    protected String packageName;
    protected String tag;

    public LnImpl()
    {
        minimumLogLevel = 2;
        packageName = "";
        tag = "";
    }

    public LnImpl(Application application)
    {
        int j;
        j = 2;
        super();
        minimumLogLevel = 2;
        packageName = "";
        tag = "";
        packageName = application.getPackageName();
        if ((application.getPackageManager().getApplicationInfo(packageName, 0).flags & 2) == 0)
        {
            j = 4;
        }
        minimumLogLevel = j;
        tag = packageName.toUpperCase(Locale.US);
        Ln.d("Configuring Logging, minimum log level is %s", new Object[] {
            Ln.logLevelToString(minimumLogLevel)
        });
        return;
        application;
        try
        {
            Log.e(packageName, "Error configuring logger", application);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            return;
        }
    }

    public transient int d(Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 3)
        {
            return 0;
        } else
        {
            return println(3, formatArgs(Strings.toString(obj), aobj));
        }
    }

    public int d(Throwable throwable)
    {
        if (getLoggingLevel() <= 3)
        {
            return println(3, Log.getStackTraceString(throwable));
        } else
        {
            return 0;
        }
    }

    public transient int d(Throwable throwable, Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 3)
        {
            return 0;
        } else
        {
            obj = Strings.toString(obj);
            return println(3, (new StringBuilder()).append(formatArgs(((String) (obj)), aobj)).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }

    public transient int e(Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 6)
        {
            return 0;
        } else
        {
            return println(6, formatArgs(Strings.toString(obj), aobj));
        }
    }

    public int e(Throwable throwable)
    {
        if (getLoggingLevel() <= 6)
        {
            return println(6, Log.getStackTraceString(throwable));
        } else
        {
            return 0;
        }
    }

    public transient int e(Throwable throwable, Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 6)
        {
            return 0;
        } else
        {
            obj = Strings.toString(obj);
            return println(6, (new StringBuilder()).append(formatArgs(((String) (obj)), aobj)).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }

    protected transient String formatArgs(String s, Object aobj[])
    {
        if (aobj != null && aobj.length == 0)
        {
            return s;
        } else
        {
            return String.format(s, aobj);
        }
    }

    public int getLoggingLevel()
    {
        return minimumLogLevel;
    }

    protected String getTag()
    {
        if (getLoggingLevel() <= 3)
        {
            StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[6];
            return (new StringBuilder()).append(tag).append("/").append(stacktraceelement.getFileName()).append(":").append(stacktraceelement.getLineNumber()).toString();
        } else
        {
            return tag;
        }
    }

    public transient int i(Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 4)
        {
            return 0;
        } else
        {
            return println(4, formatArgs(Strings.toString(obj), aobj));
        }
    }

    public int i(Throwable throwable)
    {
        if (getLoggingLevel() <= 4)
        {
            return println(4, Log.getStackTraceString(throwable));
        } else
        {
            return 0;
        }
    }

    public transient int i(Throwable throwable, Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 4)
        {
            return 0;
        } else
        {
            obj = Strings.toString(obj);
            return println(4, (new StringBuilder()).append(formatArgs(((String) (obj)), aobj)).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }

    public boolean isDebugEnabled()
    {
        return getLoggingLevel() <= 3;
    }

    public boolean isVerboseEnabled()
    {
        return getLoggingLevel() <= 2;
    }

    public String logLevelToString(int j)
    {
        switch (j)
        {
        default:
            return "UNKNOWN";

        case 2: // '\002'
            return "VERBOSE";

        case 3: // '\003'
            return "DEBUG";

        case 4: // '\004'
            return "INFO";

        case 5: // '\005'
            return "WARN";

        case 6: // '\006'
            return "ERROR";

        case 7: // '\007'
            return "ASSERT";
        }
    }

    public int println(int j, String s)
    {
        return Log.println(j, getTag(), processMessage(s));
    }

    protected String processMessage(String s)
    {
        String s1 = s;
        if (getLoggingLevel() <= 3)
        {
            s1 = String.format("%s %s", new Object[] {
                Thread.currentThread().getName(), s
            });
        }
        return s1;
    }

    public void setLoggingLevel(int j)
    {
        minimumLogLevel = j;
    }

    public transient int v(Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 2)
        {
            return 0;
        } else
        {
            return println(2, formatArgs(Strings.toString(obj), aobj));
        }
    }

    public int v(Throwable throwable)
    {
        if (getLoggingLevel() <= 2)
        {
            return println(2, Log.getStackTraceString(throwable));
        } else
        {
            return 0;
        }
    }

    public int v(Throwable throwable, Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 2)
        {
            return 0;
        } else
        {
            obj = Strings.toString(obj);
            return println(2, (new StringBuilder()).append(formatArgs(((String) (obj)), aobj)).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }

    public transient int w(Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 5)
        {
            return 0;
        } else
        {
            return println(5, formatArgs(Strings.toString(obj), aobj));
        }
    }

    public int w(Throwable throwable)
    {
        if (getLoggingLevel() <= 5)
        {
            return println(5, Log.getStackTraceString(throwable));
        } else
        {
            return 0;
        }
    }

    public transient int w(Throwable throwable, Object obj, Object aobj[])
    {
        if (getLoggingLevel() > 5)
        {
            return 0;
        } else
        {
            obj = Strings.toString(obj);
            return println(5, (new StringBuilder()).append(formatArgs(((String) (obj)), aobj)).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }
}
