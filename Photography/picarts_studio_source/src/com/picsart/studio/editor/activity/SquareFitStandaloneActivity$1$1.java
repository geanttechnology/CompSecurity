// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.fragment.i;
import com.picsart.studio.editor.history.EditorAction;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.activity:
//            SquareFitStandaloneActivity

final class a extends ModernAsyncTask
{

    private a a;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = (Bitmap[])aobj;
        EditingData editingdata = EditingData.a(SquareFitStandaloneActivity.a(a.a));
        SquareFitStandaloneActivity.a(a.a, w.a(SquareFitStandaloneActivity.a(a.a).substring(0, SquareFitStandaloneActivity.a(a.a).lastIndexOf("/") + 1), SquareFitStandaloneActivity.a(a.a).substring(SquareFitStandaloneActivity.a(a.a).lastIndexOf("/") + 1), ((Bitmap) (aobj[0])), a.a, android.graphics.aloneActivity._cls1.a, false).getPath());
        String s = SquareFitStandaloneActivity.a(a.a);
        if (SocialinV3.getInstance().isRegistered())
        {
            aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
        } else
        {
            aobj = null;
        }
        m.a(s, ((String) (aobj)), editingdata.c().toString());
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        a.a.a(-1);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/activity/SquareFitStandaloneActivity$1

/* anonymous class */
    final class SquareFitStandaloneActivity._cls1
        implements c
    {

        final SquareFitStandaloneActivity a;

        public final void a(i i)
        {
            a.a(0);
        }

        public final void a(i i, Bitmap bitmap, EditorAction editoraction)
        {
            (new SquareFitStandaloneActivity._cls1._cls1(this)).execute(new Bitmap[] {
                bitmap
            });
        }

            
            {
                a = squarefitstandaloneactivity;
                super();
            }
    }

}
