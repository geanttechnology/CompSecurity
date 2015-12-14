// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.GestureDetectorCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.a;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            q, s

public class SelectUsersActivity extends BaseActivity
{

    private List a;
    private List b;
    private List c;
    private List d;
    private ListView e;
    private View f;
    private EditText g;
    private Button h;
    private Button i;
    private Button j;
    private int k;
    private int l;
    private final int m = 1;
    private String n;
    private q o;
    private GestureDetectorCompat p;
    private LongSparseArray q;
    private boolean r;
    private android.view.View.OnClickListener s;
    private TextWatcher t;
    private android.widget.AdapterView.OnItemClickListener u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;

    public SelectUsersActivity()
    {
        k = 0;
        l = 0;
        p = null;
        q = new LongSparseArray();
        r = false;
        s = new android.view.View.OnClickListener() {

            final SelectUsersActivity a;

            public void onClick(View view)
            {
                view = new Intent();
                a.setResult(0, view);
                a.finish();
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        };
        t = new TextWatcher() {

            final SelectUsersActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                SelectUsersActivity.c(a).getFilter().filter(charsequence.toString());
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        };
        u = new android.widget.AdapterView.OnItemClickListener() {

            final SelectUsersActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                boolean flag1 = true;
                view = (s)view.getTag();
                if (!((s) (view)).c.isEnabled())
                {
                    return;
                }
                adapterview = Long.valueOf(SelectUsersActivity.c(a).a(i1).a);
                boolean flag2 = com.cyberlink.you.activity.SelectUsersActivity.a(a, adapterview.longValue());
                LongSparseArray longsparsearray = com.cyberlink.you.activity.SelectUsersActivity.d(a);
                l1 = adapterview.longValue();
                boolean flag;
                if (!flag2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                longsparsearray.put(l1, Boolean.valueOf(flag));
                view = ((s) (view)).c;
                if (!flag2)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                view.setChecked(flag);
                adapterview = com.cyberlink.you.e.g().a(String.valueOf(adapterview));
                if (!flag2) goto _L2; else goto _L1
_L1:
                if (com.cyberlink.you.activity.SelectUsersActivity.e(a) > 0)
                {
                    SelectUsersActivity.f(a);
                }
                com.cyberlink.you.activity.SelectUsersActivity.g(a);
                SelectUsersActivity.h(a).remove(adapterview);
_L4:
                SelectUsersActivity.k(a);
                SelectUsersActivity.l(a);
                return;
_L2:
                if (com.cyberlink.you.activity.SelectUsersActivity.a(a) == null || !com.cyberlink.you.activity.SelectUsersActivity.a(a).contains(adapterview))
                {
                    SelectUsersActivity.i(a);
                    SelectUsersActivity.j(a);
                    SelectUsersActivity.h(a).add(adapterview);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final SelectUsersActivity a;

            public void onClick(View view)
            {
                SelectUsersActivity.m(a).runOnUiThread(new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        com.cyberlink.you.utility.d.a(SelectUsersActivity.m(a.a), false);
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
                view = new Intent();
                Bundle bundle = new Bundle();
                ArrayList arraylist = new ArrayList(com.cyberlink.you.activity.SelectUsersActivity.d(a).size());
                int i1 = 0;
                while (i1 < com.cyberlink.you.activity.SelectUsersActivity.d(a).size()) 
                {
                    long l1 = com.cyberlink.you.activity.SelectUsersActivity.d(a).keyAt(i1);
                    if (!com.cyberlink.you.activity.SelectUsersActivity.a(a, l1))
                    {
                        continue;
                    }
                    Friend friend = com.cyberlink.you.e.g().a(String.valueOf(l1));
                    boolean flag;
                    if (com.cyberlink.you.activity.SelectUsersActivity.a(a) != null && com.cyberlink.you.activity.SelectUsersActivity.a(a).contains(friend))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (friend != null && !flag)
                    {
                        arraylist.add(friend);
                    }
                    i1++;
                }
                long l2 = com.cyberlink.you.g.a().g().longValue();
                arraylist.add(com.cyberlink.you.e.g().a(String.valueOf(l2)));
                bundle.putParcelableArrayList("INTENT_RESULT_SELECTED_USERS_LIST", arraylist);
                view.putExtras(bundle);
                a.setResult(-1, view);
                a.finish();
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final SelectUsersActivity a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(SelectUsersActivity.m(a), false);
                com.cyberlink.you.activity.SelectUsersActivity.d(a).clear();
                SelectUsersActivity.h(a).clear();
                com.cyberlink.you.activity.SelectUsersActivity.a(a, 0);
                SelectUsersActivity.b(a, 0);
                SelectUsersActivity.n(a);
                SelectUsersActivity.c(a).notifyDataSetChanged();
                SelectUsersActivity.k(a);
                SelectUsersActivity.l(a);
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final SelectUsersActivity a;

            public void onClick(View view)
            {
                com.cyberlink.you.utility.d.a(SelectUsersActivity.m(a), false);
                view = com.cyberlink.you.activity.SelectUsersActivity.o(a).iterator();
                do
                {
                    if (!view.hasNext())
                    {
                        break;
                    }
                    Friend friend = (Friend)view.next();
                    if ((com.cyberlink.you.activity.SelectUsersActivity.a(a) == null || !com.cyberlink.you.activity.SelectUsersActivity.a(a).contains(friend)) && !SelectUsersActivity.h(a).contains(friend))
                    {
                        com.cyberlink.you.activity.SelectUsersActivity.d(a).put(friend.a, Boolean.valueOf(true));
                        SelectUsersActivity.i(a);
                        SelectUsersActivity.j(a);
                        SelectUsersActivity.h(a).add(friend);
                    }
                } while (true);
                Log.d("SelectUsersActivity", (new StringBuilder()).append("------------- mTotalSelectedCount = ").append(com.cyberlink.you.activity.SelectUsersActivity.p(a)).toString());
                SelectUsersActivity.c(a).notifyDataSetChanged();
                SelectUsersActivity.k(a);
                SelectUsersActivity.l(a);
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        };
    }

    static int a(SelectUsersActivity selectusersactivity, int i1)
    {
        selectusersactivity.k = i1;
        return i1;
    }

    static List a(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.a;
    }

    private boolean a(long l1)
    {
        Boolean boolean1 = (Boolean)q.get(l1);
        return boolean1 != null && boolean1.booleanValue();
    }

    static boolean a(SelectUsersActivity selectusersactivity, long l1)
    {
        return selectusersactivity.a(l1);
    }

    static int b(SelectUsersActivity selectusersactivity, int i1)
    {
        selectusersactivity.l = i1;
        return i1;
    }

    static View b(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.f;
    }

    private void b()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            n = bundle.getString("INTENT_TITLE", getString(r.u_select_friends_title));
            c = bundle.getParcelableArrayList("INTENT_USER_LIST");
            b = bundle.getParcelableArrayList("INTENT_PREV_SELECTED_USERS_LIST");
            a = bundle.getParcelableArrayList("INTENT_CANNOT_MODIFIED_USERS_LIST");
        }
    }

    static q c(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.o;
    }

    private void c()
    {
        ((TextView)findViewById(o.textViewTitle)).setText(n);
        g = (EditText)findViewById(o.SearchEditText);
        g.addTextChangedListener(t);
        g.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SelectUsersActivity a;

            public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
            {
                boolean flag = false;
                if (i1 == 3)
                {
                    com.cyberlink.you.utility.d.a(SelectUsersActivity.m(a), false);
                    flag = true;
                }
                return flag;
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        });
        findViewById(o.deselectBarLayout).setVisibility(0);
        e = (ListView)findViewById(o.ChatAddMemberListView);
        findViewById(o.ChatAddMemberBackBtn).setOnClickListener(s);
        h = (Button)findViewById(o.buttonDone);
        h.setOnClickListener(v);
        j = (Button)findViewById(o.selectAllBtn);
        j.setOnClickListener(x);
        i = (Button)findViewById(o.deselectBtn);
        i.setOnClickListener(w);
        f = findViewById(o.ChatAddMemberSearchEmptyView);
    }

    static LongSparseArray d(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.q;
    }

    private void d()
    {
        if (k > 0)
        {
            h.setText((new StringBuilder()).append(getString(r.u_done_btn)).append(" (").append(k).append(")").toString());
            h.setEnabled(true);
        } else
        {
            h.setText(r.u_done_btn);
            h.setEnabled(false);
        }
        if (b != null && d != null)
        {
            if (!e())
            {
                h.setText(r.u_done_btn);
            }
            h.setEnabled(e());
        }
    }

    static int e(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.k;
    }

    private boolean e()
    {
        if (d.size() != b.size())
        {
            return true;
        }
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            Friend friend = (Friend)iterator.next();
            if (!d.contains(friend))
            {
                return true;
            }
        }

        return false;
    }

    static int f(SelectUsersActivity selectusersactivity)
    {
        int i1 = selectusersactivity.k;
        selectusersactivity.k = i1 - 1;
        return i1;
    }

    private void f()
    {
        if (c != null && a != null && a.size() - 1 == c.size())
        {
            j.setVisibility(0);
            i.setVisibility(8);
            j.setEnabled(false);
            i.setEnabled(false);
            return;
        }
        if (l == j())
        {
            j.setVisibility(8);
            i.setVisibility(0);
            j.setEnabled(false);
            i.setEnabled(true);
            return;
        } else
        {
            j.setVisibility(0);
            i.setVisibility(8);
            j.setEnabled(true);
            i.setEnabled(false);
            return;
        }
    }

    static int g(SelectUsersActivity selectusersactivity)
    {
        int i1 = selectusersactivity.l;
        selectusersactivity.l = i1 - 1;
        return i1;
    }

    private void g()
    {
        if (c == null)
        {
            List list = Collections.EMPTY_LIST;
            Collections.sort(list, new a());
            c = list;
        } else
        {
            long l1 = com.cyberlink.you.g.a().g().longValue();
            Friend friend = new Friend();
            friend.a = l1;
            c.remove(friend);
            b.remove(friend);
        }
        if (b != null && b.size() > 0)
        {
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Friend friend1 = (Friend)iterator.next();
                q.put(friend1.a, Boolean.valueOf(true));
                d.add(friend1);
                if (a == null || !a.contains(friend1))
                {
                    l = l + 1;
                }
            } while (true);
            r = true;
        }
        if (!r)
        {
            a();
        }
        d();
        f();
        o = new q(this, h(), c);
        e.setAdapter(o);
        e.setOnItemClickListener(u);
        e.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SelectUsersActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (SelectUsersActivity.q(a) == null)
                {
                    return false;
                } else
                {
                    return SelectUsersActivity.q(a).onTouchEvent(motionevent);
                }
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        });
    }

    private Activity h()
    {
        return this;
    }

    static List h(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.d;
    }

    static int i(SelectUsersActivity selectusersactivity)
    {
        int i1 = selectusersactivity.k;
        selectusersactivity.k = i1 + 1;
        return i1;
    }

    private void i()
    {
        if (b != null)
        {
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Friend friend = (Friend)iterator.next();
                if (a != null && a.contains(friend))
                {
                    q.put(friend.a, Boolean.valueOf(true));
                    d.add(friend);
                }
            } while (true);
        }
    }

    private int j()
    {
        if (a != null)
        {
            Iterator iterator = a.iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Friend friend = (Friend)iterator.next();
                if (c.contains(friend))
                {
                    i1++;
                }
            } while (true);
            if (i1 != 0)
            {
                return c.size() - i1;
            }
        }
        return c.size();
    }

    static int j(SelectUsersActivity selectusersactivity)
    {
        int i1 = selectusersactivity.l;
        selectusersactivity.l = i1 + 1;
        return i1;
    }

    static void k(SelectUsersActivity selectusersactivity)
    {
        selectusersactivity.d();
    }

    static void l(SelectUsersActivity selectusersactivity)
    {
        selectusersactivity.f();
    }

    static Activity m(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.h();
    }

    static void n(SelectUsersActivity selectusersactivity)
    {
        selectusersactivity.i();
    }

    static List o(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.c;
    }

    static int p(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.l;
    }

    static GestureDetectorCompat q(SelectUsersActivity selectusersactivity)
    {
        return selectusersactivity.p;
    }

    public void a()
    {
        Friend friend;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); d.add(friend))
        {
            friend = (Friend)iterator.next();
            q.put(friend.a, Boolean.valueOf(true));
            k = k + 1;
            l = l + 1;
        }

    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_chat_add_member);
        p = new GestureDetectorCompat(this, new android.view.GestureDetector.SimpleOnGestureListener() {

            final SelectUsersActivity a;

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                com.cyberlink.you.utility.d.a(SelectUsersActivity.m(a), false);
                return false;
            }

            
            {
                a = SelectUsersActivity.this;
                super();
            }
        });
        d = new ArrayList(q.size());
        b();
        c();
        g();
    }

    public void onDestroy()
    {
        g.removeTextChangedListener(t);
        g.setOnEditorActionListener(null);
        e.setOnTouchListener(null);
        super.onDestroy();
    }
}
