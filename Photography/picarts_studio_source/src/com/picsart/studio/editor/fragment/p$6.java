// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            p

final class sk extends ModernAsyncTask
{

    private p a;

    protected final Object doInBackground(Object aobj[])
    {
        if (!(new File(p.i())).exists())
        {
            p.c(a);
            (new File(p.i())).mkdirs();
        }
        p.d(a);
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        p.f(a).setVisibility(8);
        p.e(a).setEnabled(true);
        p.a(a, true);
        a.a(p.g(a));
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        p.a(a, false);
        p.e(a).setEnabled(false);
        p.f(a).setVisibility(0);
    }

    sk(p p1)
    {
        a = p1;
        super();
    }
}
