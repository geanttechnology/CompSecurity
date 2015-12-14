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

class a
    implements android.view.OnClickListener
{

    final k a;

    public void onClick(View view)
    {
        Globals.a("OnClick");
        (new AsyncTask() {

            final k._cls11 a;

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
                    obj = new android.app.AlertDialog.Builder(((android.content.Context) (obj)));
                    if (s != null)
                    {
                        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(s));
                    }
                    ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("Ok", null);
                    s = ((android.app.AlertDialog.Builder) (obj)).show();
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

            
            {
                a = k._cls11.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    _cls1.a(k k1)
    {
        a = k1;
        super();
    }
}
