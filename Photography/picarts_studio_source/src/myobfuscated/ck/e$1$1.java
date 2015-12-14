// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.w;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.cj.b;
import myobfuscated.cm.n;

// Referenced classes of package myobfuscated.ck:
//            e, c, b, f

final class >
    implements Observer
{

    private inish a;

    public final void update(Observable observable, Object obj)
    {
        n n1 = (n)obj;
        obj = e.d(a.a);
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        }
        Intent intent = new Intent();
        if (e.a(a.a).g != null && e.a(a.a).g.compareTo("None") != 0)
        {
            observable = e.a(a.a).q;
            observable.k = ((EditingData) (observable)).k + 1;
        }
        java.util.ArrayList arraylist = e.a(a.a).i();
        if (e.f(a.a))
        {
            if (n1.a != null)
            {
                observable = null;
                if (!e.g(a.a))
                {
                    Log.e("ex1", "NOT saveResultToRecents");
                    observable = (new StringBuilder()).append(((Activity) (obj)).getString(0x7f0808fc)).append("_").append(System.currentTimeMillis()).toString();
                    observable = w.a((new StringBuilder()).append(e.a(a.a).l.a).append(observable).toString(), n1.a);
                }
                intent.putExtra("bufferData", observable);
            }
        } else
        {
            intent.putExtra("path", n1.c);
        }
        intent.putStringArrayListExtra("effects", arraylist);
        if (e.a(a.a).q != null)
        {
            if (a.a != null)
            {
                a.a.a();
            }
            intent.putExtra("editing_data", e.a(a.a).q);
        }
        ((Activity) (obj)).setResult(-1, intent);
        e.r();
        ((Activity) (obj)).finish();
    }

    >(> >)
    {
        a = >;
        super();
    }

    // Unreferenced inner class myobfuscated/ck/e$1

/* anonymous class */
    final class e._cls1
        implements android.view.View.OnClickListener
    {

        final myobfuscated.ck.b a;
        final e b;

        public final void onClick(View view)
        {
            if (e.a(b).c || !e.a(b).d)
            {
                return;
            }
            if (e.a(b).e)
            {
                myobfuscated.ck.e.b(b);
                return;
            }
            if (!e.c(b))
            {
                AnalyticUtils.getInstance(e.d(b)).trackLocalAction("effect:cancel_dialog_picsartEdit");
                e.e(b);
                return;
            } else
            {
                AnalyticUtils.getInstance(e.d(b)).trackLocalAction("effect:done");
                view = e.a(b).k.a(e.a(b).g);
                AnalyticUtils.getInstance(e.d(b)).track(new com.socialin.android.apiv3.events.EventsFactory.EffectDoneEvent(view));
                view = new e._cls1._cls1(this);
                e.h(b).a(e.f(b), android.graphics.Bitmap.CompressFormat.PNG, view);
                return;
            }
        }

            
            {
                b = e1;
                a = b1;
                super();
            }
    }

}
