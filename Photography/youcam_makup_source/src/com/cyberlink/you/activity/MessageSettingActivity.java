// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.c;
import com.cyberlink.you.friends.k;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            m, n, k, l, 
//            p

public class MessageSettingActivity extends BaseActivity
{

    private l a;
    private n b;
    private Group c;
    private ListView d;
    private View e;
    private View f;
    private View g;
    private View h;
    private EditText i;
    private LinearLayout j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;

    public MessageSettingActivity()
    {
        k = new android.view.View.OnClickListener() {

            final MessageSettingActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final MessageSettingActivity a;

            private void a(View view)
            {
                if (!view.isFocused())
                {
                    view.setFocusableInTouchMode(true);
                    view.requestFocusFromTouch();
                    com.cyberlink.you.utility.d.a(a, true);
                }
            }

            public void onClick(View view)
            {
                if (!MessageSettingActivity.a(a).e.equals("Dual"))
                {
                    a(view);
                    MessageSettingActivity.b(a);
                }
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final MessageSettingActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.you.activity.MessageSettingActivity.c(a))
                {
                    com.cyberlink.you.activity.MessageSettingActivity.d(a);
                }
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final MessageSettingActivity a;

            public void onClick(View view)
            {
                boolean flag;
                if (!view.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                MessageSettingActivity.b(a);
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final MessageSettingActivity a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(a, r.u_leave_group_chat, r.u_you_will_no_longer_receive_message_from_this_group_again, r.u_leave, 0x1040000, new android.content.DialogInterface.OnClickListener(this) {

                    final _cls7 a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        com.cyberlink.you.activity.MessageSettingActivity.e(a.a);
                    }

            
            {
                a = _pcls7;
                super();
            }
                }, null);
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        };
    }

    static Group a(MessageSettingActivity messagesettingactivity)
    {
        return messagesettingactivity.c;
    }

    private void a()
    {
        Intent intent = new Intent();
        intent.putExtra("isLeaveGroup", true);
        setResult(-1, intent);
        finish();
    }

    static void a(MessageSettingActivity messagesettingactivity, Group group)
    {
        messagesettingactivity.a(group);
    }

    static void a(MessageSettingActivity messagesettingactivity, Group group, int i1)
    {
        messagesettingactivity.a(group, i1);
    }

    static void a(MessageSettingActivity messagesettingactivity, Friend friend)
    {
        messagesettingactivity.b(friend);
    }

    static void a(MessageSettingActivity messagesettingactivity, List list)
    {
        messagesettingactivity.a(list);
    }

    private void a(Group group)
    {
        Intent intent = new Intent();
        intent.putExtra("Group", group);
        setResult(-1, intent);
        finish();
    }

    private void a(Group group, int i1)
    {
        m m1 = new m(this, group);
        com.cyberlink.you.friends.k.a(a, group.b, i1, m1, m1).a();
    }

    private void a(Friend friend)
    {
        (new AsyncTask(friend) {

            final Friend a;
            final MessageSettingActivity b;

            protected transient Void a(Void avoid[])
            {
                a.d = true;
                com.cyberlink.you.e.g().a(String.valueOf(a.a), a, "IsBlocked");
                return null;
            }

            public void a(Void void1)
            {
                if (MessageSettingActivity.h(b) != null)
                {
                    MessageSettingActivity.h(b).notifyDataSetChanged();
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                b = MessageSettingActivity.this;
                a = friend;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void a(List list)
    {
        if (list != null)
        {
            b(list);
            b.addAll(list);
        }
    }

    private void b()
    {
        if (c())
        {
            f.setVisibility(0);
            return;
        } else
        {
            f.setVisibility(4);
            return;
        }
    }

    static void b(MessageSettingActivity messagesettingactivity)
    {
        messagesettingactivity.b();
    }

    static void b(MessageSettingActivity messagesettingactivity, Friend friend)
    {
        messagesettingactivity.a(friend);
    }

    private void b(Group group)
    {
        if (group.e.equals("Dual"))
        {
            j.setVisibility(8);
        } else
        if (group.f != null)
        {
            i.setText(group.f);
            return;
        }
    }

    private void b(Friend friend)
    {
        com.cyberlink.you.activity.k k1 = new com.cyberlink.you.activity.k(this, ProgressDialog.show(this, "", getString(r.u_loading), true), friend);
        com.cyberlink.you.friends.k.a(a, friend.a, k1, k1).a();
    }

    private void b(List list)
    {
        Friend friend = null;
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            Friend friend1 = (Friend)list.get(i1);
            if (friend1.a == com.cyberlink.you.g.a().g().longValue())
            {
                friend = friend1;
            }
        }

        if (friend != null)
        {
            list.remove(friend);
            list.add(friend);
        }
    }

    static void c(MessageSettingActivity messagesettingactivity, Friend friend)
    {
        messagesettingactivity.c(friend);
    }

    private void c(Group group)
    {
        if (group.e != null && group.e.equals("Dual"))
        {
            h.setVisibility(8);
            return;
        } else
        {
            h.setVisibility(0);
            return;
        }
    }

    private void c(Friend friend)
    {
        com.cyberlink.you.utility.d.a(this, r.u_message_setting_block_alert_title, r.u_message_setting_block_alert_description, r.u_message_setting_block_alert_postive_click, r.u_message_setting_block_alert_nagtive_click, new android.content.DialogInterface.OnClickListener(friend) {

            final Friend a;
            final MessageSettingActivity b;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
                MessageSettingActivity.a(b, a);
            }

            
            {
                b = MessageSettingActivity.this;
                a = friend;
                super();
            }
        }, new android.content.DialogInterface.OnClickListener() {

            final MessageSettingActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        });
    }

    private boolean c()
    {
        boolean flag1 = true;
        boolean flag2 = false;
        if (c != null)
        {
            String s;
            boolean flag;
            if (c.f.length() > 30)
            {
                s = c.f.substring(0, 30);
            } else
            {
                s = c.f;
            }
            if (!s.equals(i.getText().toString()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (c.j == g.isSelected())
            {
                flag1 = false;
            }
            flag2 = flag | false | flag1;
        }
        return flag2;
    }

    static boolean c(MessageSettingActivity messagesettingactivity)
    {
        return messagesettingactivity.c();
    }

    private void d()
    {
        (new AsyncTask() {

            final MessageSettingActivity a;

            protected transient Void a(Void avoid[])
            {
                com.cyberlink.you.e.f().f(String.valueOf(MessageSettingActivity.a(a).b));
                com.cyberlink.you.e.d().f(String.valueOf(MessageSettingActivity.a(a).b));
                return null;
            }

            public void a(Void void1)
            {
                com.cyberlink.you.activity.MessageSettingActivity.f(a);
                ChatListHandler.b(MessageSettingActivity.a(a).b);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static void d(MessageSettingActivity messagesettingactivity)
    {
        messagesettingactivity.f();
    }

    private void d(Group group)
    {
        (new AsyncTask(group) {

            final Group a;
            final MessageSettingActivity b;

            private boolean b(List list)
            {
                for (list = list.iterator(); list.hasNext();)
                {
                    if (!((Friend)list.next()).a())
                    {
                        return false;
                    }
                }

                return true;
            }

            protected transient List a(Void avoid[])
            {
                avoid = com.cyberlink.you.e.g().a(a.b);
                if (b(avoid))
                {
                    return avoid;
                } else
                {
                    return null;
                }
            }

            public void a(List list)
            {
                if (list != null)
                {
                    MessageSettingActivity.a(b, list);
                    return;
                } else
                {
                    MessageSettingActivity.a(b, a, 1);
                    return;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            public void onPostExecute(Object obj)
            {
                a((List)obj);
            }

            
            {
                b = MessageSettingActivity.this;
                a = group;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void e()
    {
        Object obj = ProgressDialog.show(this, "", getString(r.u_loading), true);
        long l1 = c.b;
        obj = new com.cyberlink.you.activity.l(this, ((ProgressDialog) (obj)));
        com.cyberlink.you.friends.k.b(a, l1, ((com.cyberlink.you.friends.e) (obj)), ((com.cyberlink.you.friends.i) (obj))).a();
    }

    static void e(MessageSettingActivity messagesettingactivity)
    {
        messagesettingactivity.e();
    }

    private void f()
    {
        Object obj = ProgressDialog.show(this, "", getString(r.u_loading), true);
        long l1 = c.b;
        String s = i.getText().toString();
        boolean flag = g.isSelected();
        obj = new com.cyberlink.you.activity.p(this, ((ProgressDialog) (obj)));
        com.cyberlink.you.friends.k.a(a, l1, s, flag, ((com.cyberlink.you.friends.e) (obj)), ((com.cyberlink.you.friends.i) (obj))).a();
    }

    static void f(MessageSettingActivity messagesettingactivity)
    {
        messagesettingactivity.a();
    }

    static void g(MessageSettingActivity messagesettingactivity)
    {
        messagesettingactivity.d();
    }

    static n h(MessageSettingActivity messagesettingactivity)
    {
        return messagesettingactivity.b;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_message_setting);
        b = new n(this, this, 0, new ArrayList());
        d = (ListView)findViewById(o.memberListView);
        d.setAdapter(b);
        e = findViewById(o.back);
        e.setOnClickListener(k);
        f = findViewById(o.done);
        f.setOnClickListener(m);
        g = findViewById(o.checkbox);
        g.setOnClickListener(n);
        i = (EditText)findViewById(o.groupName);
        i.setOnClickListener(l);
        i.addTextChangedListener(new TextWatcher() {

            final MessageSettingActivity a;

            public void afterTextChanged(Editable editable)
            {
                MessageSettingActivity.b(a);
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = MessageSettingActivity.this;
                super();
            }
        });
        h = findViewById(o.leaveGroup);
        h.setOnClickListener(o);
        j = (LinearLayout)findViewById(o.LinearLayoutGroupName);
        a = new l(this);
        c = (Group)getIntent().getParcelableExtra("Group");
        if (c != null)
        {
            d(c);
            b(c);
            c(c);
            g.setSelected(c.j);
            b();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        e.setOnClickListener(null);
        i.setOnClickListener(null);
        f.setOnClickListener(null);
        g.setOnClickListener(null);
        h.setOnClickListener(null);
        a.b();
        a = null;
    }
}
