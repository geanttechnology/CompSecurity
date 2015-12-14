// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.e;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;
import java.util.UUID;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

public final class a extends ModernAsyncTask
{

    private EditorActivity a;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = null;
        Object obj = null;
        if (e.a().b())
        {
            String s = (new StringBuilder()).append(e.a().d.getTmpDirectory()).append(File.separator).append(UUID.randomUUID()).append(".jpg").toString();
            b.b(e.a().c(), s);
            EditorActivity.d(a).b();
            aobj = e.a().e;
            aobj.i = (int)((long)((EditingData) (aobj)).i + EditorActivity.d(a).d());
            EditorActivity.d(a).a();
            aobj = obj;
            if (SocialinV3.getInstance().isRegistered())
            {
                aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
            }
            m.a(s, ((String) (aobj)), e.a().e.c().toString());
            aobj = s;
        }
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        super.onPostExecute(obj);
        if (obj != null && e.a().b() && !a.isFinishing() && com.picsart.studio.editor.activity.EditorActivity.e(a))
        {
            c.a(a, uestCode.SHARE_PHOTO.toInt(), true, ((String) (obj)), e.a().b.getWidth(), e.a().b.getHeight(), "editor", "share_to_pa");
            a.overridePendingTransition(0x7f040026, 0x7f040027);
        }
        EditorActivity.a(a, true);
        a.e();
        EditorActivity.a(a, "export");
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        a.d();
    }

    public uestCode(EditorActivity editoractivity)
    {
        a = editoractivity;
        super();
    }
}
