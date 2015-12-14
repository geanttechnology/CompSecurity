// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.ListView;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.widgetpool.tokenautocomplete.PeopleCompleteView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

// Referenced classes of package com.cyberlink.you.c:
//            i, j, f, k, 
//            h

public class e extends Fragment
{

    private static final String a = com/cyberlink/you/c/e.getSimpleName();
    private l b;
    private List c;
    private ListView d;
    private f e;
    private PeopleCompleteView f;
    private View g;
    private View h;
    private Timer i;
    private j j;
    private android.widget.AdapterView.OnItemClickListener k;
    private android.view.View.OnFocusChangeListener l;

    public e()
    {
        k = new android.widget.AdapterView.OnItemClickListener() {

            final e a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (h)view.getTag();
                view = e.a(a).a(i1);
                Long long1 = Long.valueOf(((Friend) (view)).a);
                boolean flag;
                if (!e.a(a).a(long1.longValue()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                e.a(a).a(long1.longValue(), flag);
                ((h) (adapterview)).c.setChecked(flag);
                if (!flag)
                {
                    e.g(a).d(view);
                } else
                {
                    e.g(a).c(view);
                }
                a.a();
            }

            
            {
                a = e.this;
                super();
            }
        };
        l = new android.view.View.OnFocusChangeListener() {

            final e a;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    a.c();
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
    }

    static f a(e e1)
    {
        return e1.e;
    }

    static f a(e e1, f f1)
    {
        e1.e = f1;
        return f1;
    }

    private void a(View view)
    {
        f = (PeopleCompleteView)view.findViewById(o.token_complete);
        f.setOnFocusChangeListener(l);
        f.setTokenListener(new com.cyberlink.you.widgetpool.tokenautocomplete.e() {

            final e a;

            public void a(Friend friend)
            {
            }

            public void a(Object obj)
            {
                b((Friend)obj);
            }

            public void a(String s)
            {
                if (s.length() > 2)
                {
                    e.b(a).schedule(new k(a, s), 800L);
                } else
                if (e.a(a) != null)
                {
                    e.a(a).getFilter().filter(s.toString());
                    return;
                }
            }

            public void b(Friend friend)
            {
                e.a(a).a(friend.a, false);
                e.a(a).notifyDataSetChanged();
                a.a();
            }

            public void b(Object obj)
            {
                a((Friend)obj);
            }

            
            {
                a = e.this;
                super();
            }
        });
        f.setPrefix((new StringBuilder()).append(getString(r.u_to)).append(": ").toString());
        d = (ListView)view.findViewById(o.ChatAddMemberListView);
        g = view.findViewById(o.ChatAddMemberSearchEmptyView);
        h = view.findViewById(o.recentContractText);
    }

    static Timer b(e e1)
    {
        return e1.i;
    }

    static l c(e e1)
    {
        return e1.b;
    }

    static List d(e e1)
    {
        return e1.c;
    }

    static ListView e(e e1)
    {
        return e1.d;
    }

    private void e()
    {
        c = new ArrayList();
        (new i(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static android.widget.AdapterView.OnItemClickListener f(e e1)
    {
        return e1.k;
    }

    static PeopleCompleteView g(e e1)
    {
        return e1.f;
    }

    static View h(e e1)
    {
        return e1.g;
    }

    public void a()
    {
        if (j != null)
        {
            j.a();
        }
    }

    public void a(j j1)
    {
        j = j1;
    }

    public void b()
    {
        h.setVisibility(8);
        d.setVisibility(8);
    }

    public void c()
    {
        h.setVisibility(0);
        d.setVisibility(0);
    }

    public List d()
    {
        if (e != null)
        {
            return e.a();
        } else
        {
            return Collections.EMPTY_LIST;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = new l(activity);
        i = new Timer();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(p.u_fragment_select_followers, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onDetach()
    {
        super.onDetach();
        b.b();
        b = null;
        i = null;
        f.setTokenListener(null);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        a(view);
        e();
    }

}
