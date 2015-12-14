// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            m

final class sk extends ModernAsyncTask
{

    private File a;
    private m b;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = a.getPath();
        android.graphics.Bitmap bitmap = m.a(b);
        b.getActivity();
        return w.a(((String) (aobj)), bitmap);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (HashMap)obj;
        m.a(b, ((HashMap) (obj)));
    }

    sk(m m1, File file)
    {
        b = m1;
        a = file;
        super();
    }
}
