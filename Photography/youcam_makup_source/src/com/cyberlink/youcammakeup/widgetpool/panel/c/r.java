// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.common.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            v, t, u, w

public class r extends BaseAdapter
{

    public boolean a;
    protected ag b;
    private int c;
    private Context d;
    private android.view.View.OnClickListener e;
    private final LinkedList f = new LinkedList();
    private boolean g;

    public r(Context context, android.view.View.OnClickListener onclicklistener)
    {
        c = 0;
        a = true;
        d = context;
        b(false);
        b = new ag(context);
        k k1 = new k(context, null);
        k1.g = false;
        k1.a(0.15F);
        b.a(((Activity)context).getFragmentManager(), k1);
        b.a(0x7f020873);
        e = onclicklistener;
    }

    private void a(e e1)
    {
        e1.setTag(Integer.valueOf(0));
        e1.setMoreBtnView(true);
        if (!z.a("HAS_SET_SEEN_LIVE_LOOK_RED_ICON", Globals.d()))
        {
            e1.b(true);
            return;
        } else
        {
            e1.b(af.a(MoreMakeupActivity.a, 0x15ab1bL));
            return;
        }
    }

    private void b(boolean flag)
    {
        f.clear();
        f.add(new v());
        f.add(new v());
        Object obj = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, new com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.b
        });
        Object obj1 = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, new com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.b
        });
        if (LiveDemoConfigHelper.h().d())
        {
            f.clear();
            obj = Arrays.asList(LiveDemoConfigHelper.h().p().split(","));
        } else
        {
            Collections.reverse(((List) (obj)));
            ((List) (obj)).addAll(((java.util.Collection) (obj1)));
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj1 = (String)((Iterator) (obj)).next();
            obj1 = PanelDataCenter.a().o(((String) (obj1)));
            if (obj1 != null)
            {
                f.add(new t(((as) (obj1))));
            }
        } while (true);
        if (flag)
        {
            notifyDataSetChanged();
        }
    }

    public int a()
    {
        return c;
    }

    public int a(String s)
    {
        for (int i = 0; i < f.size(); i++)
        {
            if (((u)f.get(i)).g().a().equals(s))
            {
                return i;
            }
        }

        return -1;
    }

    public void a(int i)
    {
        if (i >= getCount())
        {
            c = 0;
            return;
        } else
        {
            c = i;
            return;
        }
    }

    public void a(int i, e e1)
    {
        boolean flag1 = false;
        u u1 = b(Integer.valueOf(i).intValue());
        e1.setTag(Integer.valueOf(i));
        e1.setMoreBtnView(false);
        boolean flag = flag1;
        if (g)
        {
            flag = flag1;
            if (u1.a())
            {
                flag = true;
            }
        }
        e1.c(flag);
        e1.a(b, u1);
        e1.setName(u1.c());
        e1.a(u1.f());
        e1.a(u1.h(), u1.e());
    }

    public void a(int i, String s)
    {
        Log.d("LookEffectAdapter", (new StringBuilder()).append("[insertItem] add").append(s).append(" at:").append(i).toString());
        if (!bo.h(s))
        {
            return;
        }
        int j = a(s);
        if (j == -1)
        {
            f.add(i, new t(PanelDataCenter.a().o(s)));
        } else
        {
            s = b(j).g();
            f.remove(j);
            f.add(i, new t(s));
        }
        notifyDataSetChanged();
    }

    public void a(int i, List list)
    {
        list = list.iterator();
        while (list.hasNext()) 
        {
            MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
            if (makeupitemmetadata.x())
            {
                Log.d("LookEffectAdapter", (new StringBuilder()).append("[insertPromotionItems] add").append(makeupitemmetadata.b()).append(" at:").append(i).toString());
                int j = a(makeupitemmetadata.b());
                if (j == -1)
                {
                    f.add(i, new w(makeupitemmetadata));
                } else
                {
                    f.remove(j);
                    f.add(i, new w(makeupitemmetadata));
                }
            }
            i++;
        }
        notifyDataSetChanged();
    }

    public void a(int i, boolean flag)
    {
        b(i).a(flag);
    }

    public void a(List list)
    {
        a(2, list);
    }

    public void a(boolean flag)
    {
        g = flag;
        notifyDataSetChanged();
    }

    public u b(int i)
    {
        if (f.size() == 0)
        {
            return null;
        }
        if (i == 0)
        {
            return (u)f.get(0);
        }
        if (i == 1)
        {
            return (u)f.get(1);
        }
        if (i < 0 || i >= f.size())
        {
            return (u)f.get(1);
        } else
        {
            return (u)f.get(i);
        }
    }

    public boolean b()
    {
        List list = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, new com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.b
        });
        list.addAll(PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, new com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.b
        }));
        return list.size() != f.size() - 2;
    }

    public String c(int i)
    {
        return b(i).d();
    }

    public void c()
    {
        b(true);
    }

    public void d(int i)
    {
        u u1 = b(i);
        if (u1 == null)
        {
            return;
        }
        PanelDataCenter.a().c(u1.g().a(), false);
        f.remove(i);
        if (u1.i())
        {
            f.add(i, new w(u1.b()));
        }
        notifyDataSetChanged();
    }

    public boolean d()
    {
        return g;
    }

    public int getCount()
    {
        return f.size();
    }

    public Object getItem(int i)
    {
        return b(i);
    }

    public long getItemId(int i)
    {
        return -1L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (e)view;
        } else
        {
            view = new e(d, e);
        }
        if (i == 0)
        {
            a(view);
            return view;
        } else
        {
            a(i, view);
            return view;
        }
    }

    public boolean isEnabled(int i)
    {
        return a;
    }
}
