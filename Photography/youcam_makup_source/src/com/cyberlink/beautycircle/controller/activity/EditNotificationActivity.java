// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.NotificationSetting;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class EditNotificationActivity extends BaseActivity
{

    protected View e;
    protected View f;
    protected View g;
    protected View h;
    protected View i;
    protected View j;
    protected View k;
    protected View l;
    private android.view.View.OnClickListener m;

    public EditNotificationActivity()
    {
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = new android.view.View.OnClickListener() {

            final EditNotificationActivity a;

            public void onClick(View view)
            {
                if (view != null)
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
                }
            }

            
            {
                a = EditNotificationActivity.this;
                super();
            }
        };
    }

    private View a(int i1, int j1, android.view.View.OnClickListener onclicklistener)
    {
        View view = findViewById(i1);
        if (onclicklistener != null)
        {
            view.setOnClickListener(onclicklistener);
        }
        ((TextView)view.findViewById(j.bc_selector_left_text)).setText(j1);
        view.setSelected(true);
        return view;
    }

    static boolean a(EditNotificationActivity editnotificationactivity)
    {
        return editnotificationactivity.BaseActivity.e();
    }

    private void o()
    {
        k();
        (new com.perfectcorp.utility.j() {

            final EditNotificationActivity a;

            protected NotificationSetting a(Void void1)
            {
                void1 = AccountManager.c();
                if (void1 == null)
                {
                    break MISSING_BLOCK_LABEL_29;
                }
                void1 = (NotificationSetting)com.cyberlink.beautycircle.model.network.o.a(void1.longValue()).d();
                return void1;
                void1;
                void1.printStackTrace();
_L2:
                return null;
                void1;
                void1.printStackTrace();
                continue; /* Loop/switch isn't completed */
                void1;
                void1.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = EditNotificationActivity.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final EditNotificationActivity a;

            protected void a(NotificationSetting notificationsetting)
            {
                if (notificationsetting != null && notificationsetting.nonNotifyType != null && notificationsetting.nonNotifyType.size() > 0)
                {
                    notificationsetting = notificationsetting.nonNotifyType.iterator();
                    do
                    {
                        if (!notificationsetting.hasNext())
                        {
                            break;
                        }
                        String s = (String)notificationsetting.next();
                        if (s != null)
                        {
                            if ("CommentPost".equals(s))
                            {
                                a.e.setSelected(false);
                            } else
                            if ("FollowUser".equals(s))
                            {
                                a.f.setSelected(false);
                            } else
                            if ("FollowCircle".equals(s))
                            {
                                a.g.setSelected(false);
                            } else
                            if ("JoinBCFromFB".equals(s) || "JoinBCFromWeibo".equals(s))
                            {
                                a.h.setSelected(false);
                            } else
                            if ("AddPost".equals(s))
                            {
                                a.i.setSelected(false);
                            } else
                            if ("CreateCircle".equals(s))
                            {
                                a.j.setSelected(false);
                            } else
                            if ("LikePost".equals(s))
                            {
                                a.k.setSelected(false);
                            } else
                            if ("CircleInPost".equals(s))
                            {
                                a.l.setSelected(false);
                            }
                        }
                    } while (true);
                }
                a.l();
            }

            protected void b(Object obj)
            {
                a((NotificationSetting)obj);
            }

            
            {
                a = EditNotificationActivity.this;
                super();
            }
        });
    }

    private void p()
    {
        ArrayList arraylist = new ArrayList();
        if (!e.isSelected())
        {
            arraylist.add("CommentPost");
        }
        if (!f.isSelected())
        {
            arraylist.add("FollowUser");
        }
        if (!g.isSelected())
        {
            arraylist.add("FollowCircle");
        }
        if (!h.isSelected())
        {
            arraylist.add("JoinBCFromFB");
            arraylist.add("JoinBCFromWeibo");
        }
        if (!i.isSelected())
        {
            arraylist.add("AddPost");
        }
        if (!j.isSelected())
        {
            arraylist.add("CreateCircle");
        }
        if (!k.isSelected())
        {
            arraylist.add("LikePost");
        }
        if (!l.isSelected())
        {
            arraylist.add("CircleInPost");
        }
        k();
        (new com.perfectcorp.utility.j(arraylist) {

            final ArrayList a;
            final EditNotificationActivity b;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected String a(Void void1)
            {
                void1 = AccountManager.b();
                if (void1 == null || void1.isEmpty())
                {
                    break MISSING_BLOCK_LABEL_37;
                }
                void1 = (String)com.cyberlink.beautycircle.model.network.o.a(void1, a).d();
                return void1;
                void1;
                void1.printStackTrace();
_L2:
                return null;
                void1;
                void1.printStackTrace();
                continue; /* Loop/switch isn't completed */
                void1;
                void1.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                b = EditNotificationActivity.this;
                a = arraylist;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final EditNotificationActivity a;

            protected void a(String s)
            {
                a.l();
                Globals.a(a.getResources().getString(m.bc_notification_apply_success));
                EditNotificationActivity.a(a);
            }

            protected void b(Object obj)
            {
                a((String)obj);
            }

            
            {
                a = EditNotificationActivity.this;
                super();
            }
        });
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_edit_notification);
        e = a(j.item_notify_comments_on_your_post, m.bc_item_notify_comments_on_your_post, m);
        f = a(j.item_notify_follows_you, m.bc_item_notify_follows_you, m);
        g = a(j.item_notify_follows_you_or_your_board, m.bc_item_notify_follows_you_or_your_board, m);
        h = a(j.item_notify_follows_joins_beauty_circle, m.bc_item_notify_follows_joins_beauty_circle, m);
        i = a(j.item_notify_people_add_a_post, m.bc_item_notify_people_add_a_post, m);
        j = a(j.item_notify_people_creates_a_circle, m.bc_item_notify_people_creates_a_circle, m);
        k = a(j.item_notify_like_your_post, m.bc_item_notify_like_your_post, m);
        l = a(j.item_notify_circle_in_your_post, m.bc_item_notify_circle_in_your_post, m);
        b(m.bc_edit_notify_title);
        b().a(0xe4000000, x.a, x.d, 0);
        o();
    }

    public void onRightBtnClick(View view)
    {
        p();
    }
}
