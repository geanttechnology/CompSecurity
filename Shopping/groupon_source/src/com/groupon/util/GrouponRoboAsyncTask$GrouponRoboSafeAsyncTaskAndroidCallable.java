// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.io.InterruptedIOException;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            GrouponRoboAsyncTask

protected class this._cls0 extends roboguice.util.e
{

    final GrouponRoboAsyncTask this$0;

    public void onException(Exception exception)
    {
        if ((exception instanceof InterruptedException) || (exception instanceof InterruptedIOException))
        {
            GrouponRoboAsyncTask.access$000(GrouponRoboAsyncTask.this, exception);
            return;
        }
        try
        {
            super._mth0(exception);
            Ln.w(exception, "May or may not indicate a problem", new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            Ln.w(exception, "May or may not indicate a problem", new Object[0]);
        }
        return;
    }

    public void onFinally()
    {
        try
        {
            super.e();
            return;
        }
        catch (Exception exception)
        {
            Ln.w(exception, "May or may not indicate a problem", new Object[0]);
        }
    }

    public void onSuccess(Object obj)
    {
        try
        {
            super.e(obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Ln.w(((Throwable) (obj)), "May or may not indicate a problem", new Object[0]);
        }
    }

    protected ()
    {
        this$0 = GrouponRoboAsyncTask.this;
        super(GrouponRoboAsyncTask.this);
    }
}
