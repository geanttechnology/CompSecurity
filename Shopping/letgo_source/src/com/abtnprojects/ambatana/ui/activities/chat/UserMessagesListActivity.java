// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.aqo;
import android.support.v7.dh;
import android.support.v7.hq;
import android.support.v7.iv;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.chat.Conversation;
import com.abtnprojects.ambatana.models.chat.ConversationsEntity;
import com.abtnprojects.ambatana.ui.activities.b;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            MessagesActivity

public class UserMessagesListActivity extends b
{
    private class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final UserMessagesListActivity a;
        private final String b;
        private final CountryCurrencyInfo c;
        private final WeakReference d;
        private final String e;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient List a(Void avoid[])
        {
            if (d == null)
            {
                avoid = null;
            } else
            {
                avoid = (Context)d.get();
            }
            if (avoid != null)
            {
                List list = (new dh(b)).a(1, 100);
                return (new ConversationsEntity(iv.a(avoid, 0x7f080001), c, avoid)).transform(list, e);
            } else
            {
                return null;
            }
        }

        protected void a(List list)
        {
            iv.a(a.n);
            int i;
            if (list == null)
            {
                i = 0;
            } else
            {
                i = list.size();
            }
            aqo.a("conversation size : %d", new Object[] {
                Integer.valueOf(i)
            });
            if (UserMessagesListActivity.a(a) != null)
            {
                UserMessagesListActivity.a(a).clear();
            }
            if (list != null)
            {
                UserMessagesListActivity.a(a).addAll(new ArrayList(list));
            }
            UserMessagesListActivity.a(a).notifyDataSetChanged();
        }

        protected void b(List list)
        {
            super.onCancelled(list);
            iv.a(a.n);
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "UserMessagesListActivity$a#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "UserMessagesListActivity$a#doInBackground", null);
              goto _L1
        }

        protected void onCancelled(Object obj)
        {
            b((List)obj);
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "UserMessagesListActivity$a#onPostExecute", null);
_L1:
            a((List)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "UserMessagesListActivity$a#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            Context context;
            if (d == null)
            {
                context = null;
            } else
            {
                context = (Context)d.get();
            }
            if (context != null)
            {
                a.n = new ProgressDialog(context);
                a.n.setTitle(context.getString(0x7f09008c));
                a.n.setMessage(context.getString(0x7f09008b));
                a.n.setIndeterminate(false);
                a.n.show();
            }
        }

        private a(String s, CountryCurrencyInfo countrycurrencyinfo, Context context, String s1)
        {
            a = UserMessagesListActivity.this;
            super();
            b = s;
            c = countrycurrencyinfo;
            e = s1;
            d = new WeakReference(context);
        }

    }


    private a A;
    private boolean B;
    private CountryCurrencyInfo C;
    private hq D;
    protected ProgressDialog n;

    public UserMessagesListActivity()
    {
    }

    static hq a(UserMessagesListActivity usermessageslistactivity)
    {
        return usermessageslistactivity.D;
    }

    private void l()
    {
        Object obj = ParseUser.getCurrentUser();
        A = new a(((ParseUser) (obj)).getSessionToken(), C, this, ((ParseUser) (obj)).getObjectId());
        obj = A;
        Void avoid[] = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((a) (obj)).execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
            return;
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            a(0x7f0200d1);
            B = true;
            b(0x7f040019);
            n();
            D = new hq(this, new ArrayList());
            bundle = (ListView)findViewById(0x7f1000e8);
            bundle.setEmptyView(findViewById(0x7f1000e9));
            bundle.setAdapter(D);
            bundle.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final UserMessagesListActivity a;

                public void onItemClick(AdapterView adapterview, View view, int i, long l1)
                {
                    adapterview = (Conversation)UserMessagesListActivity.a(a).getItem(i);
                    view = adapterview.getProduct();
                    if (view != null)
                    {
                        Intent intent = new Intent(a.getApplicationContext(), com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
                        intent.putExtra("conversation_message", adapterview.getId());
                        intent.putExtra("product", view);
                        intent.putExtra("conversation", adapterview);
                        intent.putExtra("origin_activity", 0);
                        a.startActivity(intent);
                        return;
                    } else
                    {
                        Toast.makeText(a, a.getString(0x7f090148), 0).show();
                        aqo.d("Product not found for conversation : %d", new Object[] {
                            adapterview.getId()
                        });
                        return;
                    }
                }

            
            {
                a = UserMessagesListActivity.this;
                super();
            }
            });
            C = iv.a(this);
            l();
        }
    }

    protected void k()
    {
        setContentView(0x7f04002b);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onDestroy()
    {
        iv.a(n);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (0x102002c == menuitem.getItemId())
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!B)
        {
            l();
        }
        B = false;
    }
}
