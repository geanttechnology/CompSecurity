// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.h;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            k

class a extends AsyncTask
{

    final a a;

    protected transient String a(Void avoid[])
    {
        Globals.a("doInBackground");
        return k.a(a.a.getActivity());
    }

    protected void a(String s)
    {
        Globals.a("onPostExecute");
        Object obj = a.a.getActivity();
        if (obj != null && s != null)
        {
            obj = new android.app.alog.Builder(((android.content.Context) (obj)));
            if (s != null)
            {
                ((android.app.alog.Builder) (obj)).setMessage(Html.fromHtml(s));
            }
            ((android.app.alog.Builder) (obj)).setPositiveButton("Ok", null);
            s = ((android.app.alog.Builder) (obj)).show();
            ((TextView)s.findViewById(0x102000b)).setTextSize(Globals.b(h.t5dp));
            Globals.a(s, a.a.getResources().getColor(g.bc_color_main_style));
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$11

/* anonymous class */
    class k._cls11
        implements android.view.View.OnClickListener
    {

        final k a;

        public void onClick(View view)
        {
            Globals.a("OnClick");
            (new k._cls11._cls1(this)).executeOnExecutor(j.q, new Void[0]);
        }

            
            {
                a = k1;
                super();
            }
    }

}
