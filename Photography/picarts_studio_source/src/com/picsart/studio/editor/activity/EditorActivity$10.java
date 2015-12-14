// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import com.picsart.studio.editor.e;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class a extends ModernAsyncTask
{

    private String a;
    private EditorActivity b;

    protected final Object doInBackground(Object aobj[])
    {
        e.a().a(a);
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        b.e();
        EditorActivity.b(b);
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        b.d();
    }

    (EditorActivity editoractivity, String s)
    {
        b = editoractivity;
        a = s;
        super();
    }
}
