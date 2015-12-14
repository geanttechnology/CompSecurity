// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.activity.ChatDialogActivity;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, u, n

public class t extends m
{

    private boolean a;
    private View b;
    private View c;
    private View d;
    private u e;
    private android.view.View.OnClickListener f;
    private com.cyberlink.you.ChatListHandler.OnChatListChangedListener k;

    public t(Context context, View view, int i1, n n)
    {
        super(context, view, i1, 20, n);
        a = false;
        f = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view1)
            {
                a.b();
                a.b(false);
            }

            
            {
                a = t.this;
                super();
            }
        };
        k = new com.cyberlink.you.ChatListHandler.OnChatListChangedListener() {

            final t a;

            public void a(com.cyberlink.you.ChatListHandler.OnChatListChangedListener.ChangedType changedtype, long l1)
            {
                a.c();
            }

            
            {
                a = t.this;
                super();
            }
        };
        ChatListHandler.a(k);
        e = new u(this);
    }

    static u a(t t1)
    {
        return t1.e;
    }

    private void a(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
label0:
        {
            byte byte0 = 8;
            UICImageView uicimageview = (UICImageView)view.findViewById(j.bc_notification_avatar);
            UICImageView uicimageview1 = (UICImageView)view.findViewById(j.bc_notification_group_avatar_1);
            view = (UICImageView)view.findViewById(j.bc_notification_group_avatar_2);
            boolean flag = ugroup.groupType.equals("Dual");
            int i1;
            if (uicimageview != null)
            {
                if (flag)
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                uicimageview.setVisibility(i1);
                if (flag)
                {
                    if (ugroup.avatar1 != null && ugroup.avatar1.getScheme() != null)
                    {
                        uicimageview.setImageURI(ugroup.avatar1);
                    } else
                    {
                        uicimageview.setImageResource(i.bc_avatar_mugshot);
                    }
                }
            }
            if (uicimageview1 != null)
            {
                if (flag)
                {
                    i1 = 8;
                } else
                {
                    i1 = 0;
                }
                uicimageview1.setVisibility(i1);
                if (!flag)
                {
                    if (ugroup.avatar1 != null && ugroup.avatar1.getScheme() != null)
                    {
                        uicimageview1.setImageURI(ugroup.avatar1);
                    } else
                    {
                        uicimageview1.setImageResource(i.bc_avatar_mugshot);
                    }
                }
            }
            if (view != null)
            {
                if (flag)
                {
                    i1 = byte0;
                } else
                {
                    i1 = 0;
                }
                view.setVisibility(i1);
                if (!flag)
                {
                    if (ugroup.avatar2 == null || ugroup.avatar2.getScheme() == null)
                    {
                        break label0;
                    }
                    view.setImageURI(ugroup.avatar2);
                }
            }
            return;
        }
        view.setImageResource(i.bc_avatar_mugshot);
    }

    private void a(TextView textview)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        textview.setMaxWidth((displaymetrics.widthPixels / 11) * 6);
    }

    private void b(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
        view = (TextView)view.findViewById(j.bc_notification_main_desc);
        if (view != null)
        {
            a(view);
            view.setText(ugroup.displayName);
        }
    }

    private void c(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
label0:
        {
            view = (TextView)view.findViewById(j.bc_notification_last_message_desc);
            if (view != null)
            {
                if (ugroup.lastMsg == null || ugroup.lastMsg.content == null)
                {
                    break label0;
                }
                view.setText(ugroup.lastMsg.content);
            }
            return;
        }
        view.setText("");
    }

    private void d(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
label0:
        {
            view = (TextView)view.findViewById(j.bc_notification_main_time);
            if (view != null)
            {
                if (ugroup.lastMsg == null || ugroup.lastMsg.time == null)
                {
                    break label0;
                }
                view.setText(com.cyberlink.beautycircle.utility.i.a(ugroup.lastMsg.time));
            }
            return;
        }
        view.setText("");
    }

    private boolean d()
    {
        boolean flag1 = false;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < getCount())
                {
                    if (((com.cyberlink.beautycircle.model.UModel.UGroup)getItem(i1)).unread.intValue() == 0)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private void e(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
        view = view.findViewById(j.bc_unread_dot);
        if (view != null)
        {
            int i1;
            if (ugroup.unread.intValue() != 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
    }

    private void f(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
label0:
        {
            view = (UICImageView)view.findViewById(j.bc_notification_right_image);
            if (ugroup.lastMsg != null)
            {
                if (ugroup.lastMsg.postThumbnail == null || m())
                {
                    break label0;
                }
                view.setImageURI(ugroup.lastMsg.postThumbnail);
            }
            return;
        }
        view.setVisibility(8);
    }

    private void g(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
        view = view.findViewById(j.bc_check_box);
        view.setTag(ugroup);
        view.setOnClickListener(e);
        if (a)
        {
            view.setVisibility(0);
            view.setSelected(e.a(ugroup));
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    private void h(View view, com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
label0:
        {
            view = (TextView)view.findViewById(j.bc_notification_member_number);
            if (view != null)
            {
                if (!ugroup.groupType.equals("Circle"))
                {
                    break label0;
                }
                view.setText((new StringBuilder()).append("(").append(ugroup.numberOfMember).append(")").toString());
            }
            return;
        }
        view.setText("");
    }

    private void k()
    {
        if (c != null)
        {
            c.setVisibility(0);
        }
    }

    private void l()
    {
        if (c != null)
        {
            c.setVisibility(8);
        }
    }

    private boolean m()
    {
        return a;
    }

    protected void a()
    {
        if (d())
        {
            k();
            return;
        } else
        {
            l();
            return;
        }
    }

    public void a(View view)
    {
        d = view;
    }

    protected void a(com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
        boolean flag;
        if (!m())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b(flag);
    }

    protected void a(com.cyberlink.beautycircle.model.UModel.UGroup ugroup, View view)
    {
        com.perfectcorp.utility.e.e(new Object[] {
            ugroup
        });
        if (ugroup != null)
        {
            view.setTag(ugroup);
            a(view, ugroup);
            b(view, ugroup);
            c(view, ugroup);
            d(view, ugroup);
            e(view, ugroup);
            f(view, ugroup);
            e(view, ugroup);
            g(view, ugroup);
            h(view, ugroup);
        }
    }

    protected void a(Model model)
    {
        b((com.cyberlink.beautycircle.model.UModel.UGroup)model);
    }

    protected volatile void a(Model model, View view)
    {
        a((com.cyberlink.beautycircle.model.UModel.UGroup)model, view);
    }

    protected d b(int i1, int j1)
    {
        return new d(com/cyberlink/beautycircle/model/UModel$UGroup, ChatListHandler.a(AccountManager.b(), i1, j1));
    }

    public void b()
    {
        if (a)
        {
            (new AsyncTask() {

                final t a;

                protected transient Boolean a(Void avoid[])
                {
                    avoid = t.a(a).b();
                    if (!avoid.isEmpty())
                    {
                        for (avoid = avoid.iterator(); avoid.hasNext(); ChatListHandler.a(((com.cyberlink.beautycircle.model.UModel.UGroup)avoid.next()).groupId.longValue())) { }
                        return Boolean.valueOf(true);
                    } else
                    {
                        return Boolean.valueOf(false);
                    }
                }

                protected void a(Boolean boolean1)
                {
                    if (boolean1.booleanValue())
                    {
                        a.c();
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Boolean)obj);
                }

            
            {
                a = t.this;
                super();
            }
            }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
        }
    }

    public void b(View view)
    {
        if (view == null) goto _L2; else goto _L1
_L1:
        view.setOnClickListener(f);
_L4:
        b = view;
        return;
_L2:
        if (b != null)
        {
            b.setOnClickListener(null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
        while (ugroup == null || a || ugroup.groupId == null) 
        {
            return;
        }
        Intent intent = new Intent(getContext(), com/cyberlink/you/activity/ChatDialogActivity);
        intent.putExtra("groupId", ugroup.groupId);
        getContext().startActivity(intent);
    }

    protected void b(Model model)
    {
        a((com.cyberlink.beautycircle.model.UModel.UGroup)model);
    }

    public void b(boolean flag)
    {
        byte byte0 = 8;
        a = flag;
        if (flag)
        {
            e.a();
        }
        notifyDataSetChanged();
        View view = b;
        int i1;
        if (a)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = d;
        if (a)
        {
            i1 = byte0;
        } else
        {
            i1 = 0;
        }
        view.setVisibility(i1);
    }

    public void d(View view)
    {
        c = view;
    }
}
