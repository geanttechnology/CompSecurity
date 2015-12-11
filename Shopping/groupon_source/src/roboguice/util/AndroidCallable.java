// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;


// Referenced classes of package roboguice.util:
//            AndroidCallableI, Ln, AndroidCallableWrapper

public abstract class AndroidCallable
    implements Runnable, AndroidCallableI
{

    protected StackTraceElement creationLocation[];

    public AndroidCallable()
    {
        StackTraceElement astacktraceelement[];
        if (Ln.isDebugEnabled())
        {
            astacktraceelement = Thread.currentThread().getStackTrace();
        } else
        {
            astacktraceelement = null;
        }
        creationLocation = astacktraceelement;
    }

    public void onFinally()
    {
    }

    public void onPreCall()
        throws Exception
    {
    }

    public void run()
    {
        (new AndroidCallableWrapper(null, this, creationLocation)).run();
    }
}
