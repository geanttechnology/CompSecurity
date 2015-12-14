// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.socialin.android.share:
//            a

final class AsyncTask extends ModernAsyncTask
{

    private Runnable a;
    private a b;

    protected final Object doInBackground(Object aobj[])
    {
        return Integer.valueOf(com.socialin.android.share.a.c(b));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Integer)obj;
        super.onPostExecute(obj);
        if (!isCancelled() && b.getActivity() != null && !b.getActivity().isFinishing() && ((Integer) (obj)).intValue() != -1)
        {
            a.run();
        }
    }

    AsyncTask(a a1, Runnable runnable)
    {
        b = a1;
        a = runnable;
        super();
    }
}
