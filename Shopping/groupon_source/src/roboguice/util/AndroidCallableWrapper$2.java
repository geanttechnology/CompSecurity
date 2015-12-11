// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;


// Referenced classes of package roboguice.util:
//            AndroidCallableWrapper

class val.result
    implements Runnable
{

    final AndroidCallableWrapper this$0;
    final Exception val$e;
    final Object val$result;

    public void run()
    {
        if (val$e == null) goto _L2; else goto _L1
_L1:
        if (launchLocation != null)
        {
            StackTraceElement astacktraceelement[] = val$e.getStackTrace();
            StackTraceElement astacktraceelement1[] = new StackTraceElement[astacktraceelement.length + launchLocation.length];
            System.arraycopy(astacktraceelement, 0, astacktraceelement1, 0, astacktraceelement.length);
            System.arraycopy(launchLocation, 0, astacktraceelement1, astacktraceelement.length, launchLocation.length);
            val$e.setStackTrace(astacktraceelement1);
        }
        doOnException(val$e);
_L4:
        doOnFinally();
        return;
_L2:
        doOnSuccess(val$result);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        doOnFinally();
        throw exception;
    }

    ()
    {
        this$0 = final_androidcallablewrapper;
        val$e = exception;
        val$result = Object.this;
        super();
    }
}
