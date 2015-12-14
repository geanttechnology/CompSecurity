// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.network.k;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import com.perfectcorp.utility.i;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            k

class a extends m
{

    final BaseActivity a;
    final a b;

    protected void a()
    {
        a(0x80000005);
    }

    protected void a(int i)
    {
        a.l();
        DialogUtils.a(a, (new StringBuilder()).append("Unzip error: ").append(i).toString());
    }

    protected void a(String s)
    {
        a.l();
        c.d(a, s);
    }

    protected void b(Object obj)
    {
        a((String)obj);
    }

    nit>(nit> nit>, BaseActivity baseactivity)
    {
        b = nit>;
        a = baseactivity;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$10

/* anonymous class */
    class k._cls10
        implements android.view.View.OnClickListener
    {

        final com.cyberlink.beautycircle.controller.fragment.k a;
        private final String b[] = {
            "Feline", "Mime", "Masquerade", "Empress Wu", "Mustache"
        };
        private final String c[] = {
            "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_1.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_2.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_3.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_4.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_5.zip"
        };
        private android.widget.AdapterView.OnItemClickListener d;

        static String[] a(k._cls10 _pcls10)
        {
            return _pcls10.c;
        }

        public void onClick(View view)
        {
            Object obj = a.getActivity();
            if (obj == null)
            {
                return;
            } else
            {
                view = new ArrayAdapter(((android.content.Context) (obj)), 0x1090011);
                view.addAll(b);
                obj = new Dialog(((android.content.Context) (obj)));
                ((Dialog) (obj)).setTitle("Select a look pageage:");
                ((Dialog) (obj)).setContentView(0x1090014);
                ListView listview = (ListView)((Dialog) (obj)).findViewById(0x102000a);
                listview.setAdapter(view);
                listview.setOnItemClickListener(d);
                ((Dialog) (obj)).show();
                return;
            }
        }

            
            {
                a = k1;
                super();
                d = new k._cls10._cls1(this);
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$10$1

/* anonymous class */
    class k._cls10._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final k._cls10 a;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (BaseActivity)a.a.getActivity();
            break MISSING_BLOCK_LABEL_14;
            if (adapterview != null && k._cls10.a(a).length > i)
            {
                view = e.a();
                if (view != null && !view.isEmpty())
                {
                    adapterview.k();
                    String s = k._cls10.a(a)[i];
                    (new k()).d(new u(s)).a(new k._cls10._cls1._cls2(view, s)).a(h.b(Globals.n())).a(new k._cls10._cls1._cls1(this, adapterview));
                    return;
                }
            }
            return;
        }

            
            {
                a = _pcls10;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$10$1$2

/* anonymous class */
        class k._cls10._cls1._cls2 extends j
        {

            final String a;
            final String b;
            final k._cls10._cls1 c;

            protected i a(byte abyte0[])
            {
                String s = h.a(new String[] {
                    a, "Looks", b.substring(b.lastIndexOf('/'))
                });
                h.a(abyte0, s);
                return new i(s, s.substring(0, s.lastIndexOf('.')));
            }

            protected volatile Object a(Object obj)
            {
                return a((byte[])obj);
            }

                    
                    {
                        c = k._cls10._cls1.this;
                        a = s;
                        b = s1;
                        super();
                    }
        }

    }

}
