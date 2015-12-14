// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.m;
import com.cyberlink.you.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.widgetpool.common.CircleImageView;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.chat:
//            f, UnreadCountManager, h

public class e extends ArrayAdapter
{

    private static String a = "GroupAdapter";
    private List b;
    private Map c;
    private Context d;
    private boolean e;
    private final int f = 999;
    private int g;
    private h h;

    public e(Context context, int i, List list)
    {
        super(context, i, list);
        c = new HashMap();
        g = -1;
        h = new h() {

            final e a;

            public void a(boolean flag)
            {
                if (flag)
                {
                    a.notifyDataSetChanged();
                    UnreadCountManager.b().b(e.a(a));
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        b = list;
        d = context;
        e = false;
    }

    private int a(f f1)
    {
        if (f1 != null)
        {
            if (g < 0)
            {
                DisplayMetrics displaymetrics = new DisplayMetrics();
                ((Activity)d).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int k = (int)d.getResources().getDimension(m.chatlist_avatar_image_width);
                int l = (int)d.getResources().getDimension(m.chatlist_margin_width);
                int i = (int)d.getResources().getDimension(m.chatlist_itemtime_marginright_width);
                int j = (int)d.getResources().getDimension(m.chatlist_unreadcount_marginright_width);
                Object obj = Calendar.getInstance();
                f1.d.setText(com.cyberlink.you.utility.d.d(((Calendar) (obj)).getTime()));
                obj = f1.d.getPaint();
                i += (int)((Paint) (obj)).measureText(f1.d.getText().toString());
                float f2 = displaymetrics.density;
                int i1 = (int)(((Paint) (obj)).measureText("99+") + 20F * f2);
                f1.e.setText("99+");
                f2 = f1.e.getPaint().measureText(f1.e.getText().toString());
                j = (int)((float)j + f2);
                if (i <= j)
                {
                    i = j;
                }
                f1.g.setText("9999+");
                j = (int)f1.g.getPaint().measureText(f1.g.getText().toString());
                i1 = (int)d.getResources().getDimension(m.chatlist_count_margin_to_name);
                g = displaymetrics.widthPixels - k - (j + i1) - (i + l);
            }
            f1.b.setMaxWidth(g);
        } else
        {
            g = -1;
        }
        return g;
    }

    static h a(e e1)
    {
        return e1.h;
    }

    public int a(Group group)
    {
        for (int i = 0; i < b.size(); i++)
        {
            if (String.valueOf(((Group)b.get(i)).b).equals(String.valueOf(group.b)))
            {
                return i;
            }
        }

        return -1;
    }

    public int getPosition(Object obj)
    {
        return a((Group)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        String s;
        if (view == null)
        {
            view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.u_view_item_chat_group, viewgroup, false);
            viewgroup = new f(this);
            viewgroup.a = (CircleImageView)view.findViewById(o.chatGroupAvatarView);
            viewgroup.b = (TextView)view.findViewById(o.chatGroupNameView);
            viewgroup.c = (TextView)view.findViewById(o.chatGroupLastMessageUpperView);
            viewgroup.d = (TextView)view.findViewById(o.chatGroupTimeView);
            viewgroup.e = (TextView)view.findViewById(o.chatGroupUnreadCountView);
            viewgroup.h = (LinearLayout)view.findViewById(o.chatGroupRightLayout);
            viewgroup.i = (CheckBox)view.findViewById(o.chatGroupItemCheckBox);
            viewgroup.g = (TextView)view.findViewById(o.chatGroupCountViewText);
            viewgroup.f = view.findViewById(o.chatGroupCountView);
            viewgroup.j = view.findViewById(o.bulletin_notification_disable_unread);
            viewgroup.k = view.findViewById(o.UnreadLayout);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (f)view.getTag();
        }
        a(viewgroup);
        obj = (Group)b.get(i);
        s = ((Group) (obj)).d;
        if (s == null || s.isEmpty() || s.equals("null"))
        {
            if (((Group) (obj)).e.equals("Dual"))
            {
                ((f) (viewgroup)).a.setImageResource(n.u_pic_default);
            } else
            {
                ((f) (viewgroup)).a.setImageResource(n.u_pic_default_group);
            }
        } else
        {
            LoadImageUtils.a(d, ((Group) (obj)), ((f) (viewgroup)).a);
        }
        if (((Group) (obj)).g == 1L && (((Group) (obj)).f == null || ((Group) (obj)).f.isEmpty()))
        {
            obj.f = d.getString(r.u_group_empty_room);
        }
        ((f) (viewgroup)).b.setText(((Group) (obj)).f);
        if (!((Group) (obj)).e.equals("Dual"))
        {
            ((f) (viewgroup)).f.setVisibility(0);
            Object obj1;
            long l;
            boolean flag;
            if (((Group) (obj)).g < 999L)
            {
                ((f) (viewgroup)).g.setText(String.valueOf(((Group) (obj)).g));
            } else
            {
                ((f) (viewgroup)).g.setText((new StringBuilder()).append(String.valueOf(999)).append("+").toString());
            }
        } else
        {
            ((f) (viewgroup)).f.setVisibility(8);
        }
        obj1 = new Object();
        ((f) (viewgroup)).b.setTag(obj1);
        if (e)
        {
            ((f) (viewgroup)).h.setVisibility(4);
            ((f) (viewgroup)).i.setVisibility(0);
            flag = c.containsKey(getItem(i));
            ((f) (viewgroup)).i.setChecked(flag);
        } else
        {
            ((f) (viewgroup)).h.setVisibility(0);
            ((f) (viewgroup)).i.setVisibility(4);
            Runnable runnable = new Runnable(((Group) (obj)), viewgroup) {

                final Group a;
                final f b;
                final e c;

                public void run()
                {
                    int j = UnreadCountManager.b().b(a.c);
                    if (j > 0)
                    {
                        if (j > 99)
                        {
                            b.e.setText("N");
                        } else
                        {
                            b.e.setText(String.valueOf(j));
                        }
                        b.e.setVisibility(0);
                        b.j.setVisibility(8);
                        b.k.setVisibility(0);
                        b.e.setBackgroundResource(n.u_chat_unread);
                        return;
                    } else
                    {
                        b.k.setVisibility(4);
                        return;
                    }
                }

            
            {
                c = e.this;
                a = group;
                b = f1;
                super();
            }
            };
            UnreadCountManager.b().a(h);
            if (UnreadCountManager.b().a())
            {
                runnable.run();
            }
        }
        obj1 = ((Group) (obj)).p;
        if (((Group) (obj)).p == null || ((Group) (obj)).p.isEmpty())
        {
            break MISSING_BLOCK_LABEL_724;
        }
        obj = new JSONObject(((String) (obj1)));
        obj1 = ((JSONObject) (obj)).getString("content");
        l = ((JSONObject) (obj)).getLong("time");
        if (!((String) (obj1)).isEmpty() && l != 0L)
        {
            try
            {
                ((f) (viewgroup)).c.setText(((CharSequence) (obj1)));
                ((f) (viewgroup)).d.setText(com.cyberlink.you.utility.d.d(new Date(l)));
            }
            catch (Exception exception)
            {
                ((f) (viewgroup)).c.setText("");
                ((f) (viewgroup)).d.setText("");
                return view;
            }
            return view;
        }
        ((f) (viewgroup)).c.setText("");
        ((f) (viewgroup)).d.setText("");
        return view;
        ((f) (viewgroup)).c.setText("");
        ((f) (viewgroup)).d.setText("");
        return view;
    }

}
