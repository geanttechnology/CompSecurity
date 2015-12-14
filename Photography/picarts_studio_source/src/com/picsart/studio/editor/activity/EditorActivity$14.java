// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.e;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.io.File;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class a extends ModernAsyncTask
{

    private File a;
    private String b;
    private Bitmap c;
    private android.graphics.mat d;
    private String e;
    private EditorActivity f;

    protected final Object doInBackground(Object aobj[])
    {
        a = w.a(b.substring(0, b.lastIndexOf("/")), b.substring(b.lastIndexOf("/") + 1), c, f, d, true);
        EditorActivity.d(f).b();
        aobj = com.picsart.studio.editor.e.a().e;
        aobj.i = (int)((long)((EditingData) (aobj)).i + EditorActivity.d(f).d());
        EditorActivity.d(f).a();
        String s = b;
        if (SocialinV3.getInstance().isRegistered())
        {
            aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
        } else
        {
            aobj = null;
        }
        m.a(s, ((String) (aobj)), com.picsart.studio.editor.e.a().e.c().toString());
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        if (a != null)
        {
            Utils.a(f, b);
            EditorActivity.a(f, "savetogallery");
            EditorActivity.a(f, b, e);
            EditorActivity.a(f, true);
        } else
        {
            Utils.a(f, 0x7f0804a0);
        }
        c.recycle();
        f.e();
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        f.d();
    }

    (EditorActivity editoractivity, String s, Bitmap bitmap, android.graphics.mat mat, String s1)
    {
        f = editoractivity;
        b = s;
        c = bitmap;
        d = mat;
        e = s1;
        super();
        a = null;
    }
}
