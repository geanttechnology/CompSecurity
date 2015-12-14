// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.n;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public class c extends com.cyberlink.beautycircle.controller.adapter.m
{

    protected Activity a;
    protected long b;
    protected final int c;
    private String d;

    public c(Activity activity, ViewGroup viewgroup, long l, int i, com.cyberlink.beautycircle.controller.adapter.n n1)
    {
        super(activity, viewgroup, k.bc_view_item_circle, 20, n1);
        d = null;
        a = activity;
        b = l;
        c = i;
    }

    private d a(int i, int l)
    {
        Object obj = AccountManager.c();
        try
        {
            obj = (d)NetworkCircle.a(b, ((Long) (obj)), Integer.valueOf(i), Integer.valueOf(l)).a(new j() {

                final c a;

                protected d a(d d1)
                {
                    return d1;
                }

                protected volatile Object a(Object obj1)
                {
                    return a((d)obj1);
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
                a = c.this;
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
        return ((d) (obj));
    }

    public static void a(Activity activity, CircleDetail circledetail, View view)
    {
        view.setTag(circledetail);
        Object obj = view.findViewById(com.cyberlink.beautycircle.j.circle_panel);
        View view1 = view.findViewById(com.cyberlink.beautycircle.j.circle_add_panel);
        if (circledetail.id.longValue() == -1L)
        {
            ((View) (obj)).setVisibility(8);
            view1.setVisibility(0);
            view.setOnClickListener(new android.view.View.OnClickListener(activity) {

                final Activity a;

                public void onClick(View view2)
                {
                    com.cyberlink.beautycircle.c.a(a, null, Boolean.valueOf(false));
                }

            
            {
                a = activity;
                super();
            }
            });
        } else
        {
            ((View) (obj)).setVisibility(0);
            view1.setVisibility(8);
            view.setOnClickListener(new android.view.View.OnClickListener(activity) {

                final Activity a;

                public void onClick(View view2)
                {
                    if (view2.getTag() == null || !(view2.getTag() instanceof CircleDetail))
                    {
                        return;
                    } else
                    {
                        com.cyberlink.beautycircle.c.a(a, (CircleDetail)view2.getTag());
                        return;
                    }
                }

            
            {
                a = activity;
                super();
            }
            });
            obj = (TextView)view.findViewById(com.cyberlink.beautycircle.j.circle_name);
            if (obj != null)
            {
                ((TextView) (obj)).setText(circledetail.circleName);
            }
            obj = (TextView)view.findViewById(com.cyberlink.beautycircle.j.circle_count);
            if (obj != null && circledetail.postCount != null)
            {
                ((TextView) (obj)).setText(circledetail.postCount.toString());
            }
            obj = view.findViewById(com.cyberlink.beautycircle.j.circle_lock);
            if (obj != null && circledetail.isSecret != null)
            {
                int i;
                if (circledetail.isSecret.booleanValue())
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((View) (obj)).setVisibility(i);
            }
            obj = (TextView)view.findViewById(com.cyberlink.beautycircle.j.circle_edit);
            if (obj != null)
            {
                if (circledetail.isEditable != null && circledetail.isEditable.booleanValue())
                {
                    ((TextView) (obj)).setText(m.bc_edit_circle_edit_button);
                    ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener(activity, circledetail) {

                        final Activity a;
                        final CircleDetail b;

                        public void onClick(View view2)
                        {
                            com.cyberlink.beautycircle.c.a(a, b, Boolean.valueOf(true));
                        }

            
            {
                a = activity;
                b = circledetail;
                super();
            }
                    });
                } else
                {
                    n.a(((View) (obj)), ((TextView) (obj)), circledetail);
                }
            }
            if (circledetail.postThumbnails != null)
            {
                activity = (UICImageView)view.findViewById(com.cyberlink.beautycircle.j.circle_image_one);
                obj = view.findViewById(com.cyberlink.beautycircle.j.circle_image_one_plus);
                if (activity != null && obj != null && circledetail.postThumbnails.size() > 0)
                {
                    activity.setImageURI((Uri)circledetail.postThumbnails.get(0));
                    ((View) (obj)).setVisibility(8);
                } else
                {
                    activity.setImageURI(null);
                    ((View) (obj)).setVisibility(0);
                }
                activity = (UICImageView)view.findViewById(com.cyberlink.beautycircle.j.circle_image_two);
                if (activity != null && circledetail.postThumbnails.size() > 1)
                {
                    activity.setImageURI((Uri)circledetail.postThumbnails.get(1));
                } else
                {
                    activity.setImageURI(null);
                }
                activity = (UICImageView)view.findViewById(com.cyberlink.beautycircle.j.circle_image_three);
                if (activity != null && circledetail.postThumbnails.size() > 2)
                {
                    activity.setImageURI((Uri)circledetail.postThumbnails.get(2));
                    return;
                } else
                {
                    activity.setImageURI(null);
                    return;
                }
            }
        }
    }

    private d c(int i, int l)
    {
        Object obj = AccountManager.c();
        try
        {
            obj = (d)NetworkUser.a(b, ((Long) (obj)), "All", i, l).a(new j() {

                final c a;

                protected d a(com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult listfollowingresult)
                {
                    listfollowingresult = listfollowingresult.circles;
                    d d1 = new d();
                    d1.b = ((com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult.Circles) (listfollowingresult)).results;
                    d1.a = ((com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult.Circles) (listfollowingresult)).totalSize;
                    return d1;
                }

                protected volatile Object a(Object obj1)
                {
                    return a((com.cyberlink.beautycircle.model.network.NetworkUser.ListFollowingResult)obj1);
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
                a = c.this;
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
        return ((d) (obj));
    }

    private d d(int i, int l)
    {
        d d1;
        try
        {
            d1 = (d)NetworkSearch.a(d, AccountManager.c(), Integer.valueOf(i), Integer.valueOf(l)).d();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return d1;
    }

    protected void a(CircleDetail circledetail)
    {
    }

    public void a(CircleDetail circledetail, View view)
    {
        a(a, circledetail, view);
    }

    protected void a(Model model)
    {
        b((CircleDetail)model);
    }

    public volatile void a(Model model, View view)
    {
        a((CircleDetail)model, view);
    }

    public void a(String s)
    {
        d = s;
    }

    protected void a(boolean flag)
    {
        int i = 1;
        Long long1 = AccountManager.c();
        if (long1 == null || long1.longValue() != b || c != 1)
        {
            return;
        }
        if (!this.i.containsKey(Long.valueOf(-1L)))
        {
            i = 0;
        }
        if (flag && getCount() > i)
        {
            CircleDetail circledetail = new CircleDetail();
            circledetail.id = Long.valueOf(-1L);
            c(circledetail);
            return;
        } else
        {
            b(Long.valueOf(-1L));
            return;
        }
    }

    protected d b(int i, int l)
    {
        switch (c)
        {
        default:
            return null;

        case 1: // '\001'
            return a(i, l);

        case 2: // '\002'
            return c(i, l);

        case 3: // '\003'
            return d(i, l);
        }
    }

    protected void b(CircleDetail circledetail)
    {
        if (circledetail == null || h())
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.c.a(a, circledetail);
            return;
        }
    }

    protected void b(Model model)
    {
        a((CircleDetail)model);
    }
}
