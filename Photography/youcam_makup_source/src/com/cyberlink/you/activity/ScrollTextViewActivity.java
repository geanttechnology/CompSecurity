// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.chat.d;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.chat.r;
import com.cyberlink.you.chat.x;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.ULogUtility;
import org.jivesoftware.smack.packet.IQ;

// Referenced classes of package com.cyberlink.you.activity:
//            LogBrowserActivity

public class ScrollTextViewActivity extends BaseActivity
{

    private l a;
    private TextView b;
    private String c;
    private String d;
    private android.view.View.OnClickListener e;
    private android.view.View.OnClickListener f;
    private android.view.View.OnClickListener g;
    private x h;

    public ScrollTextViewActivity()
    {
        c = "==== XMPP Server ====";
        d = "==== U Server ====";
        e = new android.view.View.OnClickListener() {

            final ScrollTextViewActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = ScrollTextViewActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final ScrollTextViewActivity a;

            public void onClick(View view)
            {
                (new AsyncTask(this) {

                    final _cls2 a;

                    protected transient Void a(Void avoid[])
                    {
                        Thread.currentThread().setName("ScrollTextViewActivity.pingUServer AsyncTask");
                        ScrollTextViewActivity.a(a.a);
                        return null;
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

            
            {
                a = _pcls2;
                super();
            }
                }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                ScrollTextViewActivity.b(a);
            }

            
            {
                a = ScrollTextViewActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final ScrollTextViewActivity a;

            public void onClick(View view)
            {
                view = new Intent(a.a(), com/cyberlink/you/activity/LogBrowserActivity);
                view.putExtra("type", com.cyberlink.you.utility.ULogUtility.LogType.b.toString());
                a.a().startActivity(view);
            }

            
            {
                a = ScrollTextViewActivity.this;
                super();
            }
        };
        h = new x() {

            final ScrollTextViewActivity a;

            public void a(String s)
            {
                ScrollTextViewActivity.a(a, ScrollTextViewActivity.c(a), s);
            }

            
            {
                a = ScrollTextViewActivity.this;
                super();
            }
        };
    }

    static void a(ScrollTextViewActivity scrolltextviewactivity)
    {
        scrolltextviewactivity.b();
    }

    static void a(ScrollTextViewActivity scrolltextviewactivity, String s, String s1)
    {
        scrolltextviewactivity.a(s, s1);
    }

    private void a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a().runOnUiThread(new Runnable(s, s1) {

            final String a;
            final String b;
            final ScrollTextViewActivity c;

            public void run()
            {
                com.cyberlink.you.activity.ScrollTextViewActivity.d(c).setText((new StringBuilder()).append(com.cyberlink.you.activity.ScrollTextViewActivity.d(c).getText().toString()).append("\n").append(a).append("\n").append(b).append("\n").toString());
                ScrollTextViewActivity.e(c);
            }

            
            {
                c = ScrollTextViewActivity.this;
                a = s;
                b = s1;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void b()
    {
        String s = l.a;
        Object obj = (new StringBuilder()).append("Ping ").append(s).toString();
        ULogUtility.a(((String) (obj)), "Send", com.cyberlink.you.utility.ULogUtility.PingType.a);
        a(d, ((String) (obj)));
        obj = new StringBuffer();
        String s1 = a.a(a());
        if (s1 != null && s1.equals("200"))
        {
            ((StringBuffer) (obj)).append((new StringBuilder()).append("Response from ").append(s).toString());
            ULogUtility.a(((StringBuffer) (obj)).toString(), "Receive", com.cyberlink.you.utility.ULogUtility.PingType.a);
            a(d, ((StringBuffer) (obj)).toString());
            return;
        } else
        {
            ((StringBuffer) (obj)).append((new StringBuilder()).append("No Response or status code is not 200 from ").append(s).toString());
            ULogUtility.a(((StringBuffer) (obj)).toString(), "Receive", com.cyberlink.you.utility.ULogUtility.PingType.a);
            a(d, ((StringBuffer) (obj)).toString());
            return;
        }
    }

    static void b(ScrollTextViewActivity scrolltextviewactivity)
    {
        scrolltextviewactivity.c();
    }

    static String c(ScrollTextViewActivity scrolltextviewactivity)
    {
        return scrolltextviewactivity.c;
    }

    private void c()
    {
        IQ iq = new IQ() {

            final ScrollTextViewActivity a;

            public String a()
            {
                return "<ping xmlns='urn:xmpp:ping'/>";
            }

            public CharSequence b()
            {
                return a();
            }

            
            {
                a = ScrollTextViewActivity.this;
                super();
            }
        };
        String s = l.a("chat", "xmpp.domain");
        iq.m(n.a().b());
        iq.l(s);
        com.cyberlink.you.chat.d.a(iq, new r(iq) {

            final IQ a;
            final ScrollTextViewActivity b;

            public void a()
            {
                StringBuffer stringbuffer = new StringBuffer();
                stringbuffer.append((new StringBuilder()).append("Ping ").append(l.a("chat", "xmpp.server")).append("\n").toString());
                stringbuffer.append((new StringBuilder()).append("messageId: ").append(a.q()).toString());
                ULogUtility.a(stringbuffer.toString(), "Send", com.cyberlink.you.utility.ULogUtility.PingType.b);
                ScrollTextViewActivity.a(b, ScrollTextViewActivity.c(b), stringbuffer.toString());
            }

            public void b()
            {
                ULogUtility.a("Ping fail by sendPack eception:\nSend packet error.", "Send", com.cyberlink.you.utility.ULogUtility.PingType.b);
                ScrollTextViewActivity.a(b, ScrollTextViewActivity.c(b), "Ping fail by sendPack eception:\nSend packet error.");
            }

            
            {
                b = ScrollTextViewActivity.this;
                a = iq;
                super();
            }
        });
    }

    static TextView d(ScrollTextViewActivity scrolltextviewactivity)
    {
        return scrolltextviewactivity.b;
    }

    private void d()
    {
        ScrollView scrollview = (ScrollView)findViewById(o.ScrollTextViewScrollView);
        scrollview.post(new Runnable(scrollview) {

            final ScrollView a;
            final ScrollTextViewActivity b;

            public void run()
            {
                a.fullScroll(130);
            }

            
            {
                b = ScrollTextViewActivity.this;
                a = scrollview;
                super();
            }
        });
    }

    static void e(ScrollTextViewActivity scrolltextviewactivity)
    {
        scrolltextviewactivity.d();
    }

    public Activity a()
    {
        return this;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_scroll_text_view);
        findViewById(o.ScrollTextViewBackBtn).setOnClickListener(e);
        findViewById(o.ScrollTextViewPingBtn).setOnClickListener(f);
        findViewById(o.ScrollTextViewOpenBtn).setOnClickListener(g);
        b = (TextView)findViewById(o.ScrollTextViewText);
        a = new l();
        n.a().a(h);
    }

    protected void onDestroy()
    {
        n.a().a(null);
        super.onDestroy();
    }
}
