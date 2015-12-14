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

final class a
    implements android.view..OnClickListener
{

    final p a;

    public final void onClick(View view)
    {
        if (p.l(a) != null)
        {
            p.b(a).removeCallbacks(p.l(a));
        }
        a.getActivity().runOnUiThread(new Runnable() {

            final p._cls9 a;

            public final void run()
            {
                if (p.j() != null)
                {
                    p.j().a();
                }
                (new ModernAsyncTask(this) {

                    private _cls1 a;

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

            
            {
                a = _pcls1;
                super();
            }
                }).execute(new Void[0]);
            }

            
            {
                a = p._cls9.this;
                super();
            }
        });
    }

    _cls1.a(p p1)
    {
        a = p1;
        super();
    }
}
