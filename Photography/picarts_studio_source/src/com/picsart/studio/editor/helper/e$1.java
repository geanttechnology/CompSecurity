// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.helper:
//            e

final class Task extends ModernAsyncTask
{

    private e a;

    private transient Void a()
    {
        try
        {
            w.a(a.a, a.b);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
            System.gc();
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final volatile void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        a.a = null;
    }

    Task(e e1)
    {
        a = e1;
        super();
    }
}
