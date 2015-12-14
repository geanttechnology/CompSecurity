// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.p;
import com.cyberlink.beautycircle.utility.q;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public class w extends com.cyberlink.beautycircle.controller.adapter.m
{

    protected Activity a;
    protected long b;
    protected long c;
    protected q d;
    private com.cyberlink.beautycircle.model.network.NetworkUser.UserListType e;
    private String f;

    public w(Activity activity, ViewGroup viewgroup, int i, long l1, long l2, 
            com.cyberlink.beautycircle.model.network.NetworkUser.UserListType userlisttype, n n, q q)
    {
        super(activity, viewgroup, i, 20, n);
        f = null;
        a = activity;
        b = l1;
        c = l2;
        d = q;
        e = userlisttype;
    }

    private d a(int i, int k)
    {
        d d1;
        try
        {
            d1 = (d)NetworkUser.a(b, AccountManager.c(), i, k).a(new j() {

                final w a;

                protected d a(d d2)
                {
                    return d2;
                }

                protected volatile Object a(Object obj)
                {
                    return a((d)obj);
                }

                protected void a(int i1)
                {
                    super.a(i1);
                    if ((a.a instanceof MainActivity) && i1 != 0)
                    {
                        ((BaseActivity)a.a).a(a.a.getString(m.bc_server_connect_fail), 3000);
                    }
                }

            
            {
                a = w.this;
                super();
            }
            }).d();
        }
        catch (CancellationException cancellationexception)
        {
            cancellationexception.printStackTrace();
            return null;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return null;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
            return null;
        }
        return d1;
    }

    private d a(int i, int k, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType userlisttype)
    {
        com.cyberlink.beautycircle.model.network.NetworkUser.UserListType userlisttype1 = null;
        ArrayList arraylist = new ArrayList();
        if (!userlisttype.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g)) goto _L2; else goto _L1
_L1:
        arraylist.add("Expert");
        userlisttype = NetworkUser.a(AccountManager.c(), i, k, arraylist);
_L3:
        userlisttype = (d)userlisttype.a(new j() {

            final w a;

            protected d a(d d1)
            {
                return d1;
            }

            protected volatile Object a(Object obj)
            {
                return a((d)obj);
            }

            protected void a(int i1)
            {
                super.a(i1);
            }

            
            {
                a = w.this;
                super();
            }
        }).d();
        break MISSING_BLOCK_LABEL_154;
_L2:
label0:
        {
            if (!userlisttype.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f))
            {
                break label0;
            }
            arraylist.add("Brand");
            userlisttype = NetworkUser.a(AccountManager.c(), i, k, arraylist);
        }
          goto _L3
        if (!userlisttype.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        arraylist.add("Publisher");
        userlisttype = NetworkUser.a(AccountManager.c(), i, k, arraylist);
          goto _L3
        userlisttype;
        userlisttype.printStackTrace();
        userlisttype = null;
        break MISSING_BLOCK_LABEL_154;
        userlisttype;
        userlisttype.printStackTrace();
        userlisttype = null;
        break MISSING_BLOCK_LABEL_154;
        userlisttype;
        userlisttype.printStackTrace();
        userlisttype = null;
        userlisttype1 = userlisttype;
        return userlisttype1;
    }

    private d a(int i, int k, String as[])
    {
        try
        {
            as = (d)NetworkEvent.a(c, AccountManager.c(), as, Integer.valueOf(i), Integer.valueOf(k)).a(new j() {

                final w a;

                protected d a(d d1)
                {
                    return d1;
                }

                protected volatile Object a(Object obj)
                {
                    return a((d)obj);
                }

                protected void a(int i1)
                {
                    super.a(i1);
                    if ((a.a instanceof MainActivity) && i1 != 0)
                    {
                        ((BaseActivity)a.a).a(a.a.getString(m.bc_server_connect_fail), 3000);
                    }
                }

            
            {
                a = w.this;
                super();
            }
            }).d();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return null;
        }
        return as;
    }

    private void b(UserInfo userinfo, View view)
    {
        ((TextView)view.findViewById(com.cyberlink.beautycircle.j.display_name)).setText(userinfo.displayName);
        ((UICImageView)view.findViewById(com.cyberlink.beautycircle.j.avatar_image)).setImageURI(userinfo.avatarUrl);
        com.cyberlink.beautycircle.a.a((ImageView)view.findViewById(com.cyberlink.beautycircle.j.avatar_crown), userinfo.userType);
        String s = a.getResources().getString(m.bc_search_suggestion_desciption_separator);
        Object obj = a.getResources().getQuantityString(l.bc_search_suggestion_desciption_user_follower_count, userinfo.followerCount.intValue(), new Object[] {
            userinfo.followerCount
        });
        String s1 = a.getResources().getQuantityString(l.bc_search_suggestion_desciption_post_count, userinfo.postCount.intValue(), new Object[] {
            userinfo.postCount
        });
        obj = new StringBuilder(((String) (obj)));
        if (((StringBuilder) (obj)).length() > 0 && !s1.isEmpty())
        {
            ((StringBuilder) (obj)).append(s);
        }
        ((StringBuilder) (obj)).append(s1);
        ((TextView)view.findViewById(com.cyberlink.beautycircle.j.display_description)).setText(((CharSequence) (obj)));
        view.setTag(userinfo);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final w a;

            public void onClick(View view1)
            {
                view1 = (UserInfo)view1.getTag();
                if (view1 == null)
                {
                    return;
                } else
                {
                    com.cyberlink.beautycircle.c.a(a.a, ((UserInfo) (view1)).id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                    return;
                }
            }

            
            {
                a = w.this;
                super();
            }
        });
    }

    private d c(int i, int k)
    {
        d d1;
        try
        {
            d1 = (d)NetworkUser.a(b, AccountManager.c(), "User", i, k).a(new j() {

                final w a;

                protected d a(com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult listfollowingresult)
                {
                    Object obj = null;
                    d d2 = obj;
                    if (listfollowingresult != null)
                    {
                        d2 = obj;
                        if (listfollowingresult.users != null)
                        {
                            d2 = new d();
                            d2.a = listfollowingresult.users.totalSize;
                            d2.b = listfollowingresult.users.results;
                        }
                    }
                    return d2;
                }

                protected volatile Object a(Object obj)
                {
                    return a((com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult)obj);
                }

                protected void a(int i1)
                {
                    super.a(i1);
                    if ((a.a instanceof MainActivity) && i1 != 0)
                    {
                        ((BaseActivity)a.a).a(a.a.getString(m.bc_server_connect_fail), 3000);
                    }
                }

            
            {
                a = w.this;
                super();
            }
            }).d();
        }
        catch (CancellationException cancellationexception)
        {
            cancellationexception.printStackTrace();
            return null;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return null;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
            return null;
        }
        return d1;
    }

    private d d(int i, int k)
    {
        d d1;
        try
        {
            d1 = (d)NetworkCircle.a(c, b, AccountManager.c(), i, k).a(new j() {

                final w a;

                protected d a(d d2)
                {
                    return d2;
                }

                protected volatile Object a(Object obj)
                {
                    return a((d)obj);
                }

                protected void a(int i1)
                {
                    super.a(i1);
                    if ((a.a instanceof MainActivity) && i1 != 0)
                    {
                        ((BaseActivity)a.a).a(a.a.getString(m.bc_server_connect_fail), 3000);
                    }
                }

            
            {
                a = w.this;
                super();
            }
            }).d();
        }
        catch (CancellationException cancellationexception)
        {
            cancellationexception.printStackTrace();
            return null;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return null;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
            return null;
        }
        return d1;
    }

    private d e(int i, int k)
    {
        d d1;
        try
        {
            d1 = (d)NetworkSearch.b(f, AccountManager.c(), Integer.valueOf(i), Integer.valueOf(k)).a(new j() {

                final w a;

                protected d a(d d2)
                {
                    return d2;
                }

                protected volatile Object a(Object obj)
                {
                    return a((d)obj);
                }

                protected void a(int i1)
                {
                    super.a(i1);
                    if ((a.a instanceof MainActivity) && i1 != 0)
                    {
                        ((BaseActivity)a.a).a(a.a.getString(m.bc_server_connect_fail), 3000);
                    }
                }

            
            {
                a = w.this;
                super();
            }
            }).d();
        }
        catch (CancellationException cancellationexception)
        {
            cancellationexception.printStackTrace();
            return null;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return null;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
            return null;
        }
        return d1;
    }

    public UserInfo a(long l1)
    {
        Object obj = f();
        if (obj == null)
        {
            return null;
        }
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            UserInfo userinfo = (UserInfo)((Iterator) (obj)).next();
            if (userinfo != null && userinfo.id == l1)
            {
                return userinfo;
            }
        }

        return null;
    }

    protected void a(UserInfo userinfo)
    {
    }

    public void a(UserInfo userinfo, View view)
    {
        if (userinfo != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        TextView textview;
        if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.d))
        {
            b(userinfo, view);
            return;
        }
        obj = (UICImageView)view.findViewById(com.cyberlink.beautycircle.j.avatar_image);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(userinfo.avatarUrl);
        }
        com.cyberlink.beautycircle.a.a((ImageView)view.findViewById(com.cyberlink.beautycircle.j.avatar_crown), userinfo.userType);
        obj = view.findViewById(com.cyberlink.beautycircle.j.follow);
        textview = (TextView)view.findViewById(com.cyberlink.beautycircle.j.follow_text);
        if (!e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g) && !e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f) && !e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h))
        {
            break; /* Loop/switch isn't completed */
        }
        p.a(((View) (obj)), textview, userinfo, new q(((View) (obj))) {

            final View a;
            final w b;

            public void a()
            {
                a.performClick();
            }

            public void a(UserInfo userinfo1, boolean flag)
            {
                b.notifyDataSetChanged();
            }

            
            {
                b = w.this;
                a = view;
                super();
            }
        });
        obj = (TextView)view.findViewById(com.cyberlink.beautycircle.j.title);
        if (obj != null)
        {
            ((TextView) (obj)).setText(userinfo.displayName);
        }
        obj = (TextView)view.findViewById(com.cyberlink.beautycircle.j.description);
        if (obj != null)
        {
            ((TextView) (obj)).setText(userinfo.description);
        }
        view = (TextView)view.findViewById(com.cyberlink.beautycircle.j.follow_count);
        if (view != null && userinfo.followerCount != null)
        {
            view.setText(userinfo.followerCount.toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        p.a(((View) (obj)), textview, userinfo, d);
        obj = (EmojiconTextView)view.findViewById(com.cyberlink.beautycircle.j.display_name);
        if (obj != null)
        {
            if (userinfo.displayName != null)
            {
                ((EmojiconTextView) (obj)).setText(userinfo.displayName);
            } else
            {
                ((EmojiconTextView) (obj)).setText("");
            }
        }
        view = view.findViewById(com.cyberlink.beautycircle.j.userItem);
        if (view != null)
        {
            if (userinfo.visible)
            {
                view.setVisibility(0);
                return;
            } else
            {
                view.setVisibility(8);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void a(Model model)
    {
        b((UserInfo)model);
    }

    public volatile void a(Model model, View view)
    {
        a((UserInfo)model, view);
    }

    public void a(String s)
    {
        f = s;
    }

    public boolean a(long l1, boolean flag)
    {
        UserInfo userinfo = a(l1);
        if (userinfo != null)
        {
            userinfo.visible = flag;
            notifyDataSetChanged();
            return true;
        } else
        {
            return false;
        }
    }

    protected d b(int i, int k)
    {
        if (e != null)
        {
            if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a))
            {
                return a(i, k);
            }
            if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b))
            {
                return c(i, k);
            }
            if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.c))
            {
                return d(i, k);
            }
            if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.d))
            {
                return e(i, k);
            }
            if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.e))
            {
                return a(i, k, new String[] {
                    "Selected", "Redeemed"
                });
            }
            if (e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g) || e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f) || e.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h))
            {
                return a(i, k, e);
            }
        }
        return null;
    }

    protected void b(UserInfo userinfo)
    {
        if (userinfo == null || h() || a == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.c.a(a, userinfo.id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
            return;
        }
    }

    protected void b(Model model)
    {
        a((UserInfo)model);
    }
}
