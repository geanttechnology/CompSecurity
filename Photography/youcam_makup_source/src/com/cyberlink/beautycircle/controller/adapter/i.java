// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.p;
import com.cyberlink.beautycircle.utility.q;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.huewu.pla.lib.internal.PLA_ListView;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            n, c

public class i extends BaseAdapter
{

    public boolean a;
    protected q b;
    private Activity c;
    private LayoutInflater d;
    private long e;
    private boolean f;
    private n g;
    private com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult h;

    public i(Activity activity, ViewGroup viewgroup, long l, n n, q q)
    {
        a = false;
        c = activity;
        d = (LayoutInflater)c.getSystemService("layout_inflater");
        e = l;
        g = n;
        b = q;
        a(viewgroup);
    }

    static Activity a(i l)
    {
        return l.c;
    }

    static com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult a(i l, com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult listfollowingresult)
    {
        l.h = listfollowingresult;
        return listfollowingresult;
    }

    static void a(i l, ArrayList arraylist, ViewGroup viewgroup)
    {
        l.a(arraylist, viewgroup);
    }

    private void a(UserInfo userinfo, View view)
    {
        view.setOnClickListener(new android.view.View.OnClickListener(userinfo) {

            final UserInfo a;
            final i b;

            public void onClick(View view1)
            {
                com.cyberlink.beautycircle.c.a(com.cyberlink.beautycircle.controller.adapter.i.a(b), a.id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
            }

            
            {
                b = i.this;
                a = userinfo;
                super();
            }
        });
        Object obj = (UICImageView)view.findViewById(j.avatar_image);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(userinfo.avatarUrl);
        }
        com.cyberlink.beautycircle.a.a((ImageView)view.findViewById(j.avatar_crown), userinfo.userType);
        obj = (EmojiconTextView)view.findViewById(j.display_name);
        if (obj != null)
        {
            if (e.a)
            {
                ((EmojiconTextView) (obj)).setText(String.format(Locale.getDefault(), "[%d]%s", new Object[] {
                    Long.valueOf(userinfo.id), userinfo.displayName
                }));
            } else
            {
                ((EmojiconTextView) (obj)).setText(userinfo.displayName);
            }
        }
        p.a(view.findViewById(j.follow), (TextView)view.findViewById(j.follow_text), userinfo, b);
    }

    private void a(ArrayList arraylist, ViewGroup viewgroup)
    {
        View view;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); viewgroup.addView(view, 0))
        {
            UserInfo userinfo = (UserInfo)arraylist.next();
            view = d.inflate(k.bc_view_item_user_list, viewgroup, false);
            a(userinfo, view);
        }

    }

    static long b(i l)
    {
        return l.e;
    }

    static com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult c(i l)
    {
        return l.h;
    }

    static n d(i l)
    {
        return l.g;
    }

    public void a(ViewGroup viewgroup)
    {
        if (viewgroup != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!(viewgroup instanceof ListView))
        {
            continue; /* Loop/switch isn't completed */
        }
        android.widget.ListAdapter listadapter2 = ((ListView)viewgroup).getAdapter();
        android.widget.ListAdapter listadapter = listadapter2;
        if (listadapter2 instanceof WrapperListAdapter)
        {
            listadapter = ((WrapperListAdapter)listadapter2).getWrappedAdapter();
        }
        if (listadapter != this)
        {
            ((ListView)viewgroup).setAdapter(this);
            ((ListView)viewgroup).setOnItemClickListener(null);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!(viewgroup instanceof PLA_ListView)) goto _L1; else goto _L3
_L3:
        android.widget.ListAdapter listadapter3 = ((PLA_ListView)viewgroup).getAdapter();
        android.widget.ListAdapter listadapter1 = listadapter3;
        if (listadapter3 instanceof WrapperListAdapter)
        {
            listadapter1 = ((WrapperListAdapter)listadapter3).getWrappedAdapter();
        }
        if (listadapter1 != this)
        {
            ((PLA_ListView)viewgroup).setAdapter(this);
            ((PLA_ListView)viewgroup).setOnItemClickListener(null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean a()
    {
        return f;
    }

    public void b()
    {
        h = null;
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return 1;
    }

    public Object getItem(int l)
    {
        return null;
    }

    public long getItemId(int l)
    {
        return 0L;
    }

    public View getView(int l, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = d.inflate(k.bc_view_me_following, viewgroup, false);
            view1.setClickable(true);
        }
        view = AccountManager.c();
        viewgroup = (ViewGroup)view1.findViewById(j.following_people);
        ViewGroup viewgroup1 = (ViewGroup)viewgroup.findViewById(j.following_people_list);
        View view2 = viewgroup.findViewById(j.following_people_all);
        if (view2 != null)
        {
            view2.setOnClickListener(new android.view.View.OnClickListener() {

                final i a;

                public void onClick(View view3)
                {
                    com.cyberlink.beautycircle.c.a(com.cyberlink.beautycircle.controller.adapter.i.a(a), com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b, Long.valueOf(i.b(a)), null);
                }

            
            {
                a = i.this;
                super();
            }
            });
        }
        view2 = view1.findViewById(j.following_circles);
        (new AsyncTask(view, viewgroup, viewgroup1, view2, (ViewGroup)view2.findViewById(j.following_circle1), (ViewGroup)view2.findViewById(j.following_circle2)) {

            final Long a;
            final ViewGroup b;
            final ViewGroup c;
            final View d;
            final View e;
            final View f;
            final i g;

            protected transient com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult a(Void avoid[])
            {
                if (com.cyberlink.beautycircle.controller.adapter.i.c(g) != null)
                {
                    return com.cyberlink.beautycircle.controller.adapter.i.c(g);
                }
                try
                {
                    com.cyberlink.beautycircle.controller.adapter.i.a(g, (com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult)NetworkUser.a(i.b(g), a, "All", 0, 5).d());
                    avoid = com.cyberlink.beautycircle.controller.adapter.i.c(g);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    return null;
                }
                return avoid;
            }

            protected void a(com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult listfollowingresult)
            {
                if (i.d(g) != null)
                {
                    boolean flag;
                    boolean flag1;
                    boolean flag2;
                    if (listfollowingresult != null)
                    {
                        i.d(g).a();
                        i.d(g).b(false);
                        n n1;
                        if (listfollowingresult.circles == null || listfollowingresult.circles.results == null || listfollowingresult.circles.results.isEmpty())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (listfollowingresult.users == null || listfollowingresult.users.results == null || listfollowingresult.users.results.isEmpty())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                    } else
                    {
                        flag1 = true;
                        flag = true;
                    }
                    n1 = i.d(g);
                    if (flag && flag1)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    n1.a(flag2);
                    if (flag1 || listfollowingresult.users.totalSize == null)
                    {
                        i.d(g).a(0);
                    } else
                    {
                        i.d(g).a(listfollowingresult.users.totalSize.intValue());
                    }
                }
                if (listfollowingresult != null && listfollowingresult.users != null && listfollowingresult.users.results != null && !listfollowingresult.users.results.isEmpty()) goto _L2; else goto _L1
_L1:
                b.setVisibility(8);
_L4:
                if (listfollowingresult == null || listfollowingresult.circles == null || listfollowingresult.circles.results == null || listfollowingresult.circles.results.isEmpty())
                {
                    d.setVisibility(8);
                    return;
                }
                break; /* Loop/switch isn't completed */
_L2:
                c.removeAllViewsInLayout();
                com.cyberlink.beautycircle.controller.adapter.i.a(g, listfollowingresult.users.results, c);
                b.setVisibility(0);
                if (listfollowingresult.users.totalSize != null && i.d(g) != null)
                {
                    i.d(g).a(listfollowingresult.users.totalSize.intValue());
                }
                if (true) goto _L4; else goto _L3
_L3:
                d.setVisibility(0);
                e.setVisibility(0);
                com.cyberlink.beautycircle.controller.adapter.c.a(com.cyberlink.beautycircle.controller.adapter.i.a(g), (CircleDetail)listfollowingresult.circles.results.get(0), e);
                if (listfollowingresult.circles.results.size() > 1)
                {
                    f.setVisibility(0);
                    com.cyberlink.beautycircle.controller.adapter.c.a(com.cyberlink.beautycircle.controller.adapter.i.a(g), (CircleDetail)listfollowingresult.circles.results.get(1), f);
                    return;
                } else
                {
                    f.setVisibility(4);
                    return;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult)obj);
            }

            
            {
                g = i.this;
                a = long1;
                b = viewgroup;
                c = viewgroup1;
                d = view;
                e = view1;
                f = view2;
                super();
            }
        }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
        view1.findViewById(j.following_circles_title).setOnClickListener(new android.view.View.OnClickListener() {

            final i a;

            public void onClick(View view3)
            {
                view3 = new com.cyberlink.beautycircle.controller.activity.GeneralWaterFallActivity.ParamsFollowingCircles();
                view3.userId = Long.valueOf(i.b(a));
                com.cyberlink.beautycircle.c.a(com.cyberlink.beautycircle.controller.adapter.i.a(a), com.cyberlink.beautycircle.controller.adapter.i.a(a).getResources().getString(m.bc_me_followed_circles), 1, view3.toString());
            }

            
            {
                a = i.this;
                super();
            }
        });
        return view1;
    }
}
