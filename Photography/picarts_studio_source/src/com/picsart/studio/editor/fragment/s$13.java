// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.os.AsyncTask;
import com.picsart.studio.editor.activity.EditorActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a extends AsyncTask
{

    private s a;

    private transient Void a()
    {
_L4:
        if (s.l(a))
        {
            break MISSING_BLOCK_LABEL_68;
        }
        (new StringBuilder("initFlag: ")).append(s.l(a));
        Object obj = s.m(a);
        obj;
        JVM INSTR monitorenter ;
        s.m(a).wait();
_L2:
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        s.n(a);
        if (a.isAdded())
        {
            ((EditorActivity)a.getActivity()).e();
        }
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        ((EditorActivity)a.getActivity()).d();
    }

    rActivity(s s1)
    {
        a = s1;
        super();
    }
}
