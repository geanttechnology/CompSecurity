// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.picsart.studio.editor.utils.a;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            p

final class init> extends ModernAsyncTask
{

    private nPostExecute a;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = new Bundle();
        ((Bundle) (aobj)).putSerializable("gifOptions", p.k(a.a.a));
        a.a.a.getActivity().getIntent().putExtras(((Bundle) (aobj)));
        a.a.a.a(a.a.a);
        return null;
    }

    protected final volatile void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/p$9

/* anonymous class */
    final class p._cls9
        implements android.view.View.OnClickListener
    {

        final p a;

        public final void onClick(View view)
        {
            if (p.l(a) != null)
            {
                p.b(a).removeCallbacks(p.l(a));
            }
            a.getActivity().runOnUiThread(new p._cls9._cls1(this));
        }

            
            {
                a = p1;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/fragment/p$9$1

/* anonymous class */
    final class p._cls9._cls1
        implements Runnable
    {

        final p._cls9 a;

        public final void run()
        {
            if (p.j() != null)
            {
                p.j().a();
            }
            (new p._cls9._cls1._cls1(this)).execute(new Void[0]);
        }

            
            {
                a = _pcls9;
                super();
            }
    }

}
