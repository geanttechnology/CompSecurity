// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.graphics.Bitmap;
import android.widget.Toast;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.util.HashMap;
import java.util.UUID;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class e extends ModernAsyncTask
{

    private String a;
    private String b;
    private HashMap c;
    private EditingData d;
    private Runnable e;
    private EditorActivity f;

    protected final Object doInBackground(Object aobj[])
    {
        if (a != null)
        {
            return w.g(a);
        } else
        {
            return EditorActivity.a(f, b, c);
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        if (obj != null)
        {
            com.picsart.studio.editor.e.a().a(((Bitmap) (obj)), d, UUID.randomUUID().toString());
            e.run();
        } else
        {
            Toast.makeText(f, "Something went wrong", 0).show();
            f.c();
        }
        f.e();
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        f.d();
    }

    _cls9(EditorActivity editoractivity, String s, String s1, HashMap hashmap, EditingData editingdata, Runnable runnable)
    {
        f = editoractivity;
        a = s;
        b = s1;
        c = hashmap;
        d = editingdata;
        e = runnable;
        super();
    }
}
