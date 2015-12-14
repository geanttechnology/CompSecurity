// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.ax;
import com.cyberlink.beautycircle.controller.adapter.a;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class a extends m
{

    final a a;

    protected void a(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.controller.activity.PostActivity.b(a.a).addAll(arraylist);
            PostActivity.c(a.a).notifyDataSetChanged();
            return;
        }
    }

    protected void b(Object obj)
    {
        a((ArrayList)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostActivity$9

/* anonymous class */
    class PostActivity._cls9 extends PagerAdapter
    {

        final PostActivity a;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            if (obj == null || !(obj instanceof g)) goto _L2; else goto _L1
_L1:
            obj = (g)obj;
            viewgroup.removeView(g.h(((g) (obj))));
            viewgroup = com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).entrySet().iterator();
_L6:
            if (!viewgroup.hasNext()) goto _L4; else goto _L3
_L3:
            java.util.Map.Entry entry = (java.util.Map.Entry)viewgroup.next();
            if (entry.getValue() != obj) goto _L6; else goto _L5
_L5:
            viewgroup = (Integer)entry.getKey();
_L8:
            if (viewgroup != null)
            {
                com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).remove(viewgroup);
            }
_L2:
            return;
_L4:
            viewgroup = null;
            if (true) goto _L8; else goto _L7
_L7:
        }

        public int getCount()
        {
            return com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).size();
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            e.b(new Object[] {
                Integer.valueOf(i)
            });
            if (i < com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).size())
            {
                g g1 = (g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(i));
                Object obj = g1;
                if (g1 == null)
                {
                    obj = (Post)com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).get(i);
                    obj = new g(a, viewgroup, ((Post) (obj)));
                    com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).put(Integer.valueOf(i), obj);
                }
                viewgroup = ((ViewGroup) (obj));
                if (i == com.cyberlink.beautycircle.controller.activity.PostActivity.d(a))
                {
                    e.b(new Object[] {
                        "PostId = ", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(((g) (obj))))
                    });
                    viewgroup = AccountManager.f();
                    if (viewgroup == null)
                    {
                        viewgroup = "none";
                    } else
                    {
                        viewgroup = viewgroup.toString();
                    }
                    com.perfectcorp.a.b.a(new ax(viewgroup, PostActivity.g(a), "visit", Long.toString(com.cyberlink.beautycircle.controller.activity.g.b(((g) (obj))))));
                    viewgroup = ((ViewGroup) (obj));
                    if (!com.cyberlink.beautycircle.controller.activity.g.d(((g) (obj))))
                    {
                        g.c(((g) (obj)));
                        com.cyberlink.beautycircle.controller.activity.g.e(((g) (obj)));
                        viewgroup = ((ViewGroup) (obj));
                    }
                }
            } else
            {
                viewgroup = null;
            }
            if (Globals.e != null && i == com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).size() - 1)
            {
                (new PostActivity._cls9._cls2(i)).d(null).a(new PostActivity._cls9._cls1(this));
            }
            return viewgroup;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view.getTag().equals(Integer.valueOf(obj.hashCode()));
        }

            
            {
                a = postactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostActivity$9$2

/* anonymous class */
        class PostActivity._cls9._cls2 extends j
        {

            final int a;
            final PostActivity._cls9 b;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected ArrayList a(Void void1)
            {
                if (Globals.e != null)
                {
                    if ((void1 = Globals.e.b(a + 1, 20)) != null)
                    {
                        return ((d) (void1)).b;
                    }
                }
                return null;
            }

                    
                    {
                        b = PostActivity._cls9.this;
                        a = i;
                        super();
                    }
        }

    }

}
