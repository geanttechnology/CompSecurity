// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.d.a;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import org.json.JSONArray;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            f, UICImageView, g

public class CircleList extends ListView
{

    protected static final int a[] = {
        0xff7fc789, 0xff93c2cc, 0xffc4a8a4, 0xffcfb4d5, 0xffdec092, 0xfff2a9bb, 0xfffec576, -23141
    };
    private boolean b;
    private ArrayList c;
    private TreeSet d;
    private u e = new u() {

        final CircleList a;

        public void a()
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "OnNewCircle"
            });
            if (com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(a))
            {
                a.a(true);
            } else
            {
                CircleList.b(a).clear();
                com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(CircleList.b(a)).a(new m(this) {

                    final _cls2 a;

                    protected void a(Void void1)
                    {
                        a.a.a(true);
                    }

                    protected void b(Object obj)
                    {
                        a((Void)obj);
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }
            a.scrollTo(0, 0);
        }

            
            {
                a = CircleList.this;
                super();
            }
    };
    private g f;
    private f g;

    public CircleList(Context context)
    {
        super(context);
        b = false;
        c = new ArrayList();
        d = new TreeSet(new Comparator() {

            final CircleList a;

            public int a(CircleBasic circlebasic, CircleBasic circlebasic1)
            {
                return circlebasic.id.compareTo(circlebasic1.id);
            }

            public int compare(Object obj, Object obj1)
            {
                return a((CircleBasic)obj, (CircleBasic)obj1);
            }

            
            {
                a = CircleList.this;
                super();
            }
        });
        f = null;
        g = new f(this);
        b();
    }

    public CircleList(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        c = new ArrayList();
        d = new TreeSet(new _cls1());
        f = null;
        g = new f(this);
        b();
    }

    static Bitmap a(String s)
    {
        return b(s);
    }

    public static j a()
    {
        return (new j() {

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected ArrayList a(Void void1)
            {
                return Model.b(java/lang/Long, Globals.D().getString("LastShareInCircleIds", null));
            }

        }).d(null);
    }

    public static j a(TreeSet treeset)
    {
        return (new j() {

            protected volatile Object a(Object obj)
            {
                return a((TreeSet)obj);
            }

            protected Void a(TreeSet treeset1)
            {
                ArrayList arraylist = new ArrayList();
                if (treeset1 != null)
                {
                    for (treeset1 = treeset1.iterator(); treeset1.hasNext(); arraylist.add(((CircleBasic)treeset1.next()).id)) { }
                }
                Globals.D().edit().putString("LastShareInCircleIds", Model.b(arraylist).toString()).apply();
                return null;
            }

        }).d(treeset);
    }

    static void a(CircleList circlelist, CircleBasic circlebasic)
    {
        circlelist.setCircleSelected(circlebasic);
    }

    public static void a(UICImageView uicimageview, Uri uri, String s)
    {
        if (uri == null)
        {
            uicimageview.setImageURI(null);
            uicimageview.a(b(s));
            return;
        } else
        {
            uicimageview.setImageURI(uri);
            uicimageview.setImageLoadingListener(new a(uicimageview, s) {

                final UICImageView a;
                final String b;

                public void a(String s1, View view)
                {
                }

                public void a(String s1, View view, Bitmap bitmap)
                {
                }

                public void a(String s1, View view, FailReason failreason)
                {
                    a.setImageURI(null);
                    if (e.a)
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            s1
                        });
                        a.a(com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a("!"));
                        return;
                    } else
                    {
                        a.a(com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(b));
                        return;
                    }
                }

                public void b(String s1, View view)
                {
                    a(s1, view, ((FailReason) (null)));
                }

            
            {
                a = uicimageview;
                b = s;
                super();
            }
            });
            return;
        }
    }

    public static void a(UICImageView uicimageview, CircleBasic circlebasic)
    {
        if (circlebasic.iconUrl == null)
        {
            if (circlebasic.iconBmp == null)
            {
                circlebasic.iconBmp = b(circlebasic.circleName);
            }
            uicimageview.setImageURI(null);
            uicimageview.a(circlebasic.iconBmp);
            return;
        } else
        {
            uicimageview.setImageURI(circlebasic.iconUrl);
            uicimageview.setImageLoadingListener(new a(circlebasic, uicimageview) {

                final CircleBasic a;
                final UICImageView b;

                public void a(String s, View view)
                {
                }

                public void a(String s, View view, Bitmap bitmap)
                {
                }

                public void a(String s, View view, FailReason failreason)
                {
                    a.iconUrl = null;
                    if (e.a)
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            s
                        });
                        a.iconBmp = com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a("!");
                    } else
                    {
                        a.iconBmp = com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(a.circleName);
                    }
                    b.setImageURI(null);
                    b.a(a.iconBmp);
                }

                public void b(String s, View view)
                {
                    a(s, view, ((FailReason) (null)));
                }

            
            {
                a = circlebasic;
                b = uicimageview;
                super();
            }
            });
            return;
        }
    }

    static boolean a(CircleList circlelist)
    {
        return circlelist.b;
    }

    private static Bitmap b(String s)
    {
        char c1;
        Canvas canvas;
        Paint paint;
        int i;
        if (s != null && s.length() > 0)
        {
            c1 = s.toUpperCase(Locale.US).charAt(0);
        } else
        {
            c1 = ' ';
        }
        i = a.length;
        s = Bitmap.createBitmap(80, 80, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(s);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(a[c1 % i]);
        canvas.drawCircle(40F, 40F, 40F, paint);
        paint.setColor(-1);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint.setTextSize(40F);
        canvas.drawText(Character.toString(c1), 0, 1, 40F, 53F, paint);
        return s;
    }

    static TreeSet b(CircleList circlelist)
    {
        return circlelist.d;
    }

    private void b()
    {
        setChoiceMode(1);
        t.a.a(e);
        setAdapter(g);
    }

    static ArrayList c(CircleList circlelist)
    {
        return circlelist.c;
    }

    static f d(CircleList circlelist)
    {
        return circlelist.g;
    }

    static g e(CircleList circlelist)
    {
        return circlelist.f;
    }

    private void setCircleSelected(CircleBasic circlebasic)
    {
        if (circlebasic != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        setItemChecked(0, true);
        int i = 0;
        do
        {
label0:
            {
                if (i < c.size())
                {
                    if (((CircleBasic)c.get(i)).id != circlebasic.id)
                    {
                        break label0;
                    }
                    setItemChecked(i, true);
                }
                d.clear();
                d.add(circlebasic);
                if (!b)
                {
                    a(d);
                }
                if (f != null)
                {
                    f.a(d);
                    return;
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(boolean flag)
    {
        Long long1 = AccountManager.c();
        if (long1 == null)
        {
            if (f != null)
            {
                f.a(32769);
            }
            return;
        }
        if (flag)
        {
            c.clear();
            d.clear();
            g.a();
        }
        if (Globals.d != null)
        {
            Globals.d.k();
        }
        NetworkCircle.a(long1.longValue(), long1.longValue()).a(new m(flag) {

            final boolean a;
            final CircleList b;

            protected void a()
            {
                if (Globals.d != null)
                {
                    Globals.d.l();
                }
                com.cyberlink.beautycircle.view.widgetpool.common.CircleList.e(b).a(0x80000005);
            }

            protected void a(int i)
            {
                if (Globals.d != null)
                {
                    Globals.d.l();
                }
                com.cyberlink.beautycircle.view.widgetpool.common.CircleList.e(b).a(i);
            }

            protected void a(d d1)
            {
                if (d1 != null && d1.b != null)
                {
                    if (!d1.b.isEmpty())
                    {
                        CircleList.c(b).addAll(d1.b);
                        d1 = CircleList.c(b).iterator();
                        do
                        {
                            if (!d1.hasNext())
                            {
                                break;
                            }
                            CircleBasic circlebasic = (CircleBasic)d1.next();
                            if (circlebasic != null && "HOW-TO".equals(circlebasic.defaultType))
                            {
                                d1.remove();
                            }
                        } while (true);
                        com.cyberlink.beautycircle.view.widgetpool.common.CircleList.d(b).a();
                    }
                    if (a && !com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(b))
                    {
                        com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a().a(new m(this) {

                            final _cls3 a;

                            protected void a(ArrayList arraylist)
                            {
label0:
                                {
                                    if (arraylist == null || arraylist.isEmpty())
                                    {
                                        break label0;
                                    }
                                    Iterator iterator = CircleList.c(a.b).iterator();
                                    CircleBasic circlebasic;
                                    do
                                    {
                                        if (!iterator.hasNext())
                                        {
                                            break label0;
                                        }
                                        circlebasic = (CircleBasic)iterator.next();
                                    } while (!arraylist.contains(circlebasic.id));
                                    com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(a.b, circlebasic);
                                }
                                if (CircleList.b(a.b).isEmpty())
                                {
                                    com.cyberlink.beautycircle.view.widgetpool.common.CircleList.a(a.b, (CircleBasic)CircleList.c(a.b).get(0));
                                }
                            }

                            protected void b(Object obj)
                            {
                                a((ArrayList)obj);
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                    }
                    if (Globals.d != null)
                    {
                        Globals.d.l();
                        return;
                    }
                }
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                b = CircleList.this;
                a = flag;
                super();
            }
        });
    }

    public void setEventListener(g g1)
    {
        f = g1;
    }

    public void setPickMode(boolean flag)
    {
        b = flag;
        int i;
        if (b)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        setChoiceMode(i);
    }

}
