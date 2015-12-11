// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import com.b.a.a.j;
import com.offerup.android.a.o;
import com.offerup.android.dto.Discussion;
import com.offerup.android.dto.Person;
import com.offerup.android.dto.response.DiscussionsResponse;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.offerup.android.activities:
//            k, bx, bw

public class DiscussionsListActivity extends k
{

    ArrayList a;
    long b;
    private ListView c;
    private o d;

    public DiscussionsListActivity()
    {
        a = null;
    }

    private ArrayList a(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        long l = e.n();
        if (l <= 0L)
        {
            return arraylist1;
        }
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            Discussion discussion = (Discussion)arraylist.next();
            if (discussion.getBuyer().getId() == l || discussion.getSeller().getId() == l)
            {
                arraylist1.add(discussion);
            }
        } while (true);
        return arraylist1;
    }

    static void a(DiscussionsListActivity discussionslistactivity, boolean flag)
    {
        discussionslistactivity.a(true, ((android.os.AsyncTask) (new bx(discussionslistactivity))), new Object[0]);
    }

    public final void a(DiscussionsResponse discussionsresponse)
    {
        i();
        if (discussionsresponse != null && discussionsresponse.isSuccess())
        {
            a = a(new ArrayList(discussionsresponse.getDiscussions()));
            c.setOnItemClickListener(new bw(this));
        }
        d = new o(this, a);
        c.setAdapter(d);
    }

    final String b()
    {
        return "buyer_list";
    }

    protected final void h()
    {
        ViewGroup viewgroup = (ViewGroup)getLayoutInflater().inflate(0x7f04007a, c, false);
        c.addHeaderView(viewgroup, null, false);
        super.h();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04001e);
        c = (ListView)findViewById(0x7f1000c9);
        h();
        b = getIntent().getLongExtra("itemId", -1L);
        a(new bx(this), new Object[0]);
    }
}
