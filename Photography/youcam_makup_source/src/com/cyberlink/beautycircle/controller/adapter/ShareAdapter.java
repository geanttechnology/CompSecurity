// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.d;
import com.cyberlink.beautycircle.h;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            s

public class ShareAdapter extends ArrayAdapter
{

    private static final String a[] = {
        "com.cyberlink.youperfect", "com.cyberlink.youcammakeup"
    };
    private static final List b = Arrays.asList(a);
    private static final String c[];
    private static final List d;
    private static final String e[];
    private static final List f;
    private static final String g[];
    private static final List h;
    private static final String i[];
    private static final String j[];
    private static List k;

    public ShareAdapter(Context context, List list, ShareListMode sharelistmode)
    {
        super(context, k.bc_view_item_share_out, a(list, sharelistmode));
    }

    public static Pair a(ResolveInfo resolveinfo)
    {
        Resources resources = Globals.n().getResources();
        Object obj = resolveinfo.activityInfo.packageName;
        if (s.f.equals(obj))
        {
            obj = resources.getString(m.bc_share_to_wechat_moments);
            resolveinfo = resources.getDrawable(i.bc_ico_sns_wechat_moment);
        } else
        if (s.b.equals(obj))
        {
            obj = resources.getString(m.bc_share_to_fb);
            resolveinfo = resources.getDrawable(i.bc_ico_sns_fb);
        } else
        if (s.c.equals(obj))
        {
            obj = resources.getString(m.bc_share_to_weibo);
            resolveinfo = resources.getDrawable(i.bc_ico_sns_weibo);
        } else
        if (com.cyberlink.beautycircle.controller.adapter.s.d.equals(obj))
        {
            obj = resources.getString(m.bc_share_to_wechat);
            resolveinfo = resources.getDrawable(i.bc_ico_sns_wechat);
        } else
        if (com.cyberlink.beautycircle.controller.adapter.s.e.equals(obj))
        {
            obj = resources.getString(m.bc_share_to_wechat_moments);
            resolveinfo = resources.getDrawable(i.bc_ico_sns_wechat_moment);
        } else
        if (s.g.equals(obj))
        {
            obj = resources.getString(m.bc_share_to_bc_messages);
            resolveinfo = resources.getDrawable(i.u_ico_text);
        } else
        {
            PackageManager packagemanager = Globals.n().getPackageManager();
            obj = resolveinfo.activityInfo.applicationInfo.loadLabel(packagemanager);
            resolveinfo = resolveinfo.activityInfo.applicationInfo.loadIcon(packagemanager);
        }
        return new Pair(obj, resolveinfo);
    }

    public static ShareAdapter a(Context context, String s1, ShareListMode sharelistmode)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(s1);
        return new ShareAdapter(context, context.getPackageManager().queryIntentActivities(intent, 0), sharelistmode);
    }

    public static Comparator a(ShareListMode sharelistmode)
    {
        return new Comparator(sharelistmode) {

            final ShareListMode a;

            public int a(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
            {
                List list = ShareAdapter.a();
                if (a == com.cyberlink.beautycircle.controller.adapter.ShareListMode.e)
                {
                    list = ShareAdapter.b();
                }
                int i1 = list.indexOf(resolveinfo.activityInfo.packageName);
                int j1 = list.indexOf(resolveinfo1.activityInfo.packageName);
                int l = i1;
                if (i1 == -1)
                {
                    l = 0x7fffffff;
                }
                i1 = j1;
                if (j1 == -1)
                {
                    i1 = 0x7fffffff;
                }
                return l - i1;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((ResolveInfo)obj, (ResolveInfo)obj1);
            }

            
            {
                a = sharelistmode;
                super();
            }

            private class ShareListMode extends Enum
            {

                public static final ShareListMode a;
                public static final ShareListMode b;
                public static final ShareListMode c;
                public static final ShareListMode d;
                public static final ShareListMode e;
                private static final ShareListMode f[];

                public static ShareListMode valueOf(String s1)
                {
                    return (ShareListMode)Enum.valueOf(com/cyberlink/beautycircle/controller/adapter/ShareAdapter$ShareListMode, s1);
                }

                public static ShareListMode[] values()
                {
                    return (ShareListMode[])f.clone();
                }

                static 
                {
                    a = new ShareListMode("LiteMode", 0);
                    b = new ShareListMode("FullMode", 1);
                    c = new ShareListMode("WhiteList", 2);
                    d = new ShareListMode("EventWhiteList", 3);
                    e = new ShareListMode("ContestWhiteList", 4);
                    f = (new ShareListMode[] {
                        a, b, c, d, e
                    });
                }

                private ShareListMode(String s1, int l)
                {
                    super(s1, l);
                }
            }

        };
    }

    static List a()
    {
        return f;
    }

    public static List a(List list, ShareListMode sharelistmode)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        if (AccountManager.a().equals(Locale.CHINA.toString()))
        {
            k = Arrays.asList(j);
        } else
        {
            k = Arrays.asList(i);
        }
        if (sharelistmode == ShareListMode.c)
        {
            obj = new HashSet(d);
            Iterator iterator = list.iterator();
            boolean flag = false;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = ((ResolveInfo)iterator.next()).activityInfo.packageName;
                if (!((HashSet) (obj)).contains(s1))
                {
                    iterator.remove();
                } else
                if (d.j.equals(s1))
                {
                    flag = true;
                }
            } while (true);
            if (flag)
            {
                obj = new ResolveInfo();
                obj.activityInfo = new ActivityInfo();
                ((ResolveInfo) (obj)).activityInfo.name = s.f;
                ((ResolveInfo) (obj)).activityInfo.packageName = com.cyberlink.beautycircle.controller.adapter.s.e;
                list.add(obj);
            }
            if (Globals.m())
            {
                obj = new ResolveInfo();
                obj.activityInfo = new ActivityInfo();
                ((ResolveInfo) (obj)).activityInfo.name = s.g;
                ((ResolveInfo) (obj)).activityInfo.packageName = s.g;
                list.add(0, obj);
            }
        } else
        {
            if (sharelistmode != com.cyberlink.beautycircle.controller.adapter.ShareListMode.e)
            {
                continue;
            }
            obj = new HashSet(k);
            obj1 = list.iterator();
            boolean flag1 = false;
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                s2 = ((ResolveInfo)((Iterator) (obj1)).next()).activityInfo.packageName;
                if (!((HashSet) (obj)).contains(s2))
                {
                    ((Iterator) (obj1)).remove();
                } else
                if (d.j.equals(s2))
                {
                    flag1 = true;
                }
            } while (true);
            if (flag1)
            {
                obj = new ResolveInfo();
                obj.activityInfo = new ActivityInfo();
                ((ResolveInfo) (obj)).activityInfo.name = s.f;
                ((ResolveInfo) (obj)).activityInfo.packageName = s.f;
                list.add(obj);
            }
        }
        do
        {
label0:
            {
                do
                {
                    obj = new HashSet(b);
                    for (Object obj1 = list.iterator(); ((Iterator) (obj1)).hasNext();)
                    {
                        String s2 = ((ResolveInfo)((Iterator) (obj1)).next()).activityInfo.packageName;
                        if (!((HashSet) (obj)).add(s2))
                        {
                            ((Iterator) (obj1)).remove();
                        } else
                        {
                            com.perfectcorp.utility.e.a(new Object[] {
                                s2
                            });
                        }
                    }

                    break label0;
                } while (sharelistmode != com.cyberlink.beautycircle.controller.adapter.ShareListMode.d);
                obj = new HashSet(h);
                for (obj1 = list.iterator(); ((Iterator) (obj1)).hasNext();)
                {
                    s2 = ((ResolveInfo)((Iterator) (obj1)).next()).activityInfo.packageName;
                    if (((HashSet) (obj)).contains(s2))
                    {
                        ((HashSet) (obj)).remove(s2);
                    } else
                    {
                        ((Iterator) (obj1)).remove();
                    }
                }

                obj = ((HashSet) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    obj1 = (String)((Iterator) (obj)).next();
                    if (d.d.equals(obj1))
                    {
                        obj1 = new ResolveInfo();
                        obj1.activityInfo = new ActivityInfo();
                        ((ResolveInfo) (obj1)).activityInfo.name = d.d;
                        ((ResolveInfo) (obj1)).activityInfo.packageName = s.b;
                        list.add(obj1);
                    } else
                    if (d.i.equals(obj1))
                    {
                        obj1 = new ResolveInfo();
                        obj1.activityInfo = new ActivityInfo();
                        ((ResolveInfo) (obj1)).activityInfo.name = d.i;
                        ((ResolveInfo) (obj1)).activityInfo.packageName = s.c;
                        list.add(obj1);
                    } else
                    if (d.j.equals(obj1))
                    {
                        obj1 = new ResolveInfo();
                        obj1.activityInfo = new ActivityInfo();
                        ((ResolveInfo) (obj1)).activityInfo.name = d.j;
                        ((ResolveInfo) (obj1)).activityInfo.packageName = com.cyberlink.beautycircle.controller.adapter.s.d;
                        list.add(obj1);
                    } else
                    if (s.f.equals(obj1))
                    {
                        obj1 = new ResolveInfo();
                        obj1.activityInfo = new ActivityInfo();
                        ((ResolveInfo) (obj1)).activityInfo.name = s.f;
                        ((ResolveInfo) (obj1)).activityInfo.packageName = com.cyberlink.beautycircle.controller.adapter.s.e;
                        list.add(obj1);
                    }
                }
            }
        } while (true);
        Collections.sort(list, a(sharelistmode));
        obj = list;
        if (sharelistmode == ShareListMode.a)
        {
            obj = list;
            if (list.size() > 5)
            {
                list.subList(5, list.size()).clear();
                return list;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static List b()
    {
        return k;
    }

    public View a(int l, ViewGroup viewgroup)
    {
        Pair pair = a((ResolveInfo)getItem(l));
        viewgroup = (ImageView)LayoutInflater.from(getContext()).inflate(k.bc_view_item_share_icon, viewgroup, false);
        viewgroup.setImageDrawable((Drawable)pair.second);
        return viewgroup;
    }

    public View getView(int l, View view, ViewGroup viewgroup)
    {
        view = super.getView(l, view, viewgroup);
        viewgroup = (TextView)view;
        Object obj = a((ResolveInfo)getItem(l));
        CharSequence charsequence = (CharSequence)((Pair) (obj)).first;
        obj = (Drawable)((Pair) (obj)).second;
        if (obj != null)
        {
            ((Drawable) (obj)).setBounds(0, 0, Globals.b(h.t40dp), Globals.b(h.t40dp));
        }
        viewgroup.setCompoundDrawables(((Drawable) (obj)), null, null, null);
        viewgroup.setText(charsequence);
        return view;
    }

    static 
    {
        c = (new String[] {
            d.d, d.e, d.f, d.g, d.i, d.j
        });
        d = Arrays.asList(c);
        e = (new String[] {
            s.g, d.d, s.b, d.e, d.f, d.g, d.i, s.c, d.j, com.cyberlink.beautycircle.controller.adapter.s.d, 
            s.f, com.cyberlink.beautycircle.controller.adapter.s.e
        });
        f = Arrays.asList(e);
        g = (new String[] {
            d.d, d.i, d.j, s.f
        });
        h = Arrays.asList(g);
        i = (new String[] {
            d.q, d.d, d.e, d.g, d.o, d.j, s.f, d.i
        });
        j = (new String[] {
            d.j, s.f, d.i, d.q, d.d, d.e, d.g, d.o
        });
    }
}
