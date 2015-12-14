// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import java.util.Iterator;
import java.util.List;

public class SelectXmppServerActivity extends Activity
{

    ListView a;
    ArrayAdapter b;
    com.cyberlink.you.chat.p c;

    public SelectXmppServerActivity()
    {
        c = new com.cyberlink.you.chat.p() {

            final SelectXmppServerActivity a;

            public void a(String s)
            {
                a.a.post(new Runnable(this, s) {

                    final String a;
                    final _cls1 b;

                    public void run()
                    {
                        Toast.makeText(b.a.getBaseContext(), a, 0).show();
                    }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                });
            }

            
            {
                a = SelectXmppServerActivity.this;
                super();
            }
        };
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_select_xmpp_server);
        b = new ArrayAdapter(this, p.u_view_item_text);
        a = (ListView)findViewById(o.listViewXmppServer);
        a.setAdapter(b);
        String s;
        for (bundle = n.a().j().iterator(); bundle.hasNext(); b.add(s))
        {
            s = (String)bundle.next();
        }

        a.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SelectXmppServerActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                n.a().a(i);
                n.a().e();
            }

            
            {
                a = SelectXmppServerActivity.this;
                super();
            }
        });
        findViewById(o.buttonDisconnect).setOnClickListener(new android.view.View.OnClickListener() {

            final SelectXmppServerActivity a;

            public void onClick(View view)
            {
                n.a().a(-1);
                n.a().e();
            }

            
            {
                a = SelectXmppServerActivity.this;
                super();
            }
        });
    }

    protected void onStart()
    {
        n.a().a(c);
        super.onStart();
    }

    protected void onStop()
    {
        n.a().i();
        super.onStop();
    }
}
