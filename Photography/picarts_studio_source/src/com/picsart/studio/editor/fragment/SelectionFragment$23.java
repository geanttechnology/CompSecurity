// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a extends ModernAsyncTask
{

    private File a;
    private SelectionFragment b;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = a.getPath();
        android.graphics.Bitmap bitmap = SelectionFragment.n(b);
        b.getActivity();
        return w.a(((String) (aobj)), bitmap);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (HashMap)obj;
        SelectionFragment.a(b, ((HashMap) (obj)));
    }

    (SelectionFragment selectionfragment, File file)
    {
        b = selectionfragment;
        a = file;
        super();
    }
}
