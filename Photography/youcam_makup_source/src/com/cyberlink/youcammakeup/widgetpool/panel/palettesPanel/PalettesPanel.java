// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.o;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.q;
import com.cyberlink.youcammakeup.widgetpool.common.s;
import com.cyberlink.youcammakeup.widgetpool.common.u;
import com.cyberlink.youcammakeup.widgetpool.d.c;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            e, a, d, b, 
//            c

public class PalettesPanel extends Fragment
    implements g, a
{

    private static final String P = Globals.d().getString(0x7f0703cf);
    public static int a = 100;
    private List A;
    private List B;
    private List C;
    private List D;
    private List E;
    private List F;
    private aw G;
    private boolean H;
    private boolean I;
    private String J;
    private Map K;
    private Map L;
    private Map M;
    private com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.a N;
    private List O;
    private ConcurrentHashMap Q;
    private com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p R;
    private final android.view.View.OnClickListener S = new android.view.View.OnClickListener() {

        final PalettesPanel a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.k(a);
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final android.view.View.OnTouchListener T = new android.view.View.OnTouchListener() {

        final PalettesPanel a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            view.performClick();
            return PalettesPanel.l(a).onTouchEvent(motionevent);
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final android.view.GestureDetector.SimpleOnGestureListener U = new android.view.GestureDetector.SimpleOnGestureListener() {

        final PalettesPanel a;

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.k(a);
            return false;
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final android.widget.AdapterView.OnItemClickListener V = new android.widget.AdapterView.OnItemClickListener() {

        final PalettesPanel a;

        public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            view = a.getActivity();
            if (view instanceof EditViewActivity)
            {
                d d1 = PalettesPanel.j(a).a(i1);
                String s1 = d1.d();
                adapterview = (String)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.i(a).get(s1);
                com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.g(a).put(d1.e(), s1);
                if (adapterview == null)
                {
                    adapterview = (String)PanelDataCenter.a().l(s1).get(0);
                }
                ((EditViewActivity)view).a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.DismissType.b, adapterview);
            }
        }

            
            {
                a = PalettesPanel.this;
                super();
            }

        private class DismissType extends Enum
        {

            public static final DismissType a;
            public static final DismissType b;
            private static final DismissType c[];

            public static DismissType valueOf(String s1)
            {
                return (DismissType)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/palettesPanel/PalettesPanel$DismissType, s1);
            }

            public static DismissType[] values()
            {
                return (DismissType[])c.clone();
            }

            static 
            {
                a = new DismissType("USER_CANCELLED", 0);
                b = new DismissType("SELECT_PALETTE", 1);
                c = (new DismissType[] {
                    a, b
                });
            }

            private DismissType(String s1, int i1)
            {
                super(s1, i1);
            }
        }

    };
    private final q W = new q() {

        final PalettesPanel a;

        public void a(View view, int i1, int j1)
        {
            if (PalettesPanel.m(a))
            {
                com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.k(a);
            } else
            {
                if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(PaletteGroup.e) && j1 == 0)
                {
                    view = new Intent(view.getContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.d));
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f07033c));
                    view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.d);
                    view.putExtra("KEY_EXTRA_DOWNLOAD_BACK_TO_MAIN", false);
                    a.startActivity(view);
                    return;
                }
                PalettesPanel.e(a).a = i1;
                PalettesPanel.e(a).b = j1;
                view = a.getActivity();
                if (view instanceof EditViewActivity)
                {
                    String s1 = ((aw)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, i1).get(j1)).a();
                    ((EditViewActivity)view).a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.DismissType.b, s1);
                    return;
                }
            }
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final s X = new s() {

        final PalettesPanel a;

        public void a(View view, int i1, int j1)
        {
            if (PalettesPanel.m(a) || ((aw)PalettesPanel.f(a).b(i1, j1)).g() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a)
            {
                return;
            } else
            {
                com.cyberlink.youcammakeup.utility.o.a(a.getActivity().getFragmentManager(), PalettesPanel.n(a), com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.o(a));
                com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, true);
                PalettesPanel.f(a).a(true);
                return;
            }
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final com.cyberlink.youcammakeup.widgetpool.common.r Y = new com.cyberlink.youcammakeup.widgetpool.common.r() {

        final PalettesPanel a;

        private void a(int i1, int j1)
        {
            aw aw1 = (aw)PalettesPanel.f(a).b(i1, j1);
            List list = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, i1);
            list.remove(j1);
            PanelDataCenter.a().b(aw1.a(), true);
            ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.q(a).get(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a))).a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.p(a));
            Object obj1 = a;
            Object obj;
            if (PalettesPanel.e(a).a == i1 && PalettesPanel.e(a).b > j1)
            {
                obj = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, PalettesPanel.e(a).a, PalettesPanel.e(a).b - 1);
            } else
            {
                obj = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, PalettesPanel.e(a).a, PalettesPanel.e(a).b);
            }
            com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(((PalettesPanel) (obj1)), ((p) (obj)));
            ((u)PalettesPanel.f(a).getGroup(i1)).a(list);
            PalettesPanel.f(a).a(PalettesPanel.e(a));
            obj1 = Globals.d().t();
            list = null;
            obj = list;
            if (PalettesPanel.e(a).a >= 0)
            {
                obj = list;
                if (PalettesPanel.e(a).b >= 0)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, (aw)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, PalettesPanel.e(a).a).get(PalettesPanel.e(a).b));
                    obj = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.r(a).a();
                }
            }
            if (obj1 != null && obj != null && !((String) (obj)).equals(aw1.a()))
            {
                ((EditViewActivity) (obj1)).a(((String) (obj)));
            }
            if (!com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.s(a))
            {
                com.cyberlink.youcammakeup.utility.o.c();
            }
        }

        static void a(_cls13 _pcls13, int i1, int j1)
        {
            _pcls13.a(i1, j1);
        }

        public void a(View view, int i1, int j1)
        {
            view = (aw)PalettesPanel.f(a).b(i1, j1);
            if (PanelDataCenter.a().h(view.a()))
            {
                view = Globals.d().i();
                view.c(a.getActivity());
                view.a(null, a.getResources().getString(0x7f070335));
                view.a(new y(true, true, true, true, a.getResources().getString(0x7f070366), a.getResources().getString(0x7f070365)));
                view.a(new w(this, view, i1, j1) {

                    final com.cyberlink.youcammakeup.utility.o a;
                    final int b;
                    final int c;
                    final _cls13 d;

                    public void a(boolean flag)
                    {
                        a.i(d.a.getActivity());
                        com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel._cls13.a(d, b, c);
                    }

                    public void b(boolean flag)
                    {
                        a.i(d.a.getActivity());
                    }

            
            {
                d = _pcls13;
                a = o1;
                b = i1;
                c = j1;
                super();
            }
                });
                return;
            } else
            {
                a(i1, j1);
                return;
            }
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final android.widget.ExpandableListView.OnGroupClickListener Z = new android.widget.ExpandableListView.OnGroupClickListener() {

        final PalettesPanel a;

        public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
        {
            return true;
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final android.view.View.OnClickListener aa = new android.view.View.OnClickListener() {

        final PalettesPanel a;

        public void onClick(View view)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.k(a);
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private final android.content.DialogInterface.OnDismissListener ab = new android.content.DialogInterface.OnDismissListener() {

        final PalettesPanel a;

        public void onDismiss(DialogInterface dialoginterface)
        {
            if (!Globals.d().i().a())
            {
                com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, false);
                PalettesPanel.f(a).a(false);
            }
        }

            
            {
                a = PalettesPanel.this;
                super();
            }
    };
    private ag b;
    private GestureDetector c;
    private MakeupMenuBottomToolbar d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private ImageView k;
    private ExpandableListView l;
    private o m;
    private GridView n;
    private View o;
    private HorizontalGridView p;
    private e q;
    private String r;
    private p s;
    private List t;
    private List u;
    private List v;
    private List w;
    private List x;
    private List y;
    private List z;

    public PalettesPanel()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        J = null;
        K = null;
        L = null;
        M = null;
        N = null;
        O = null;
        Q = new ConcurrentHashMap();
        R = new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p() {

            final PalettesPanel a;

            public void a(com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView adapterview, View view, int i1, long l1)
            {
                EditViewActivity editviewactivity;
                if (com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.b(a) != null && com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.b(a).getCount() >= i1 + 1)
                {
                    if ((adapterview = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.b(a).a(i1)) != null && adapterview.a() != null && !adapterview.a().equalsIgnoreCase(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.c(a)) && ((editviewactivity = (EditViewActivity)a.getActivity()) != null && !editviewactivity.isFinishing() && !editviewactivity.b()))
                    {
                        if (com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.d(a).containsKey(adapterview))
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.d(a).put(adapterview, Integer.valueOf(((Integer)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.d(a).get(adapterview)).intValue() + 1));
                        } else
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.d(a).put(adapterview, Integer.valueOf(1));
                        }
                        view = adapterview.a();
                        com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.b(a, view);
                        com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.c(a, view);
                        if (view.equalsIgnoreCase(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.h()))
                        {
                            if (PalettesPanel.e(a).a == -1 || PalettesPanel.e(a).b == -1)
                            {
                                PalettesPanel.e(a).a = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(PaletteGroup.e);
                                PalettesPanel.e(a).b = 1;
                            }
                            adapterview = (aw)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(a, PalettesPanel.e(a).a).get(PalettesPanel.e(a).b);
                            PalettesPanel.f(a).a(PalettesPanel.e(a));
                            editviewactivity.a(null, adapterview.a());
                            return;
                        }
                        adapterview = (String)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.g(a).get(view);
                        if (adapterview == null && com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.h(a).containsKey(view))
                        {
                            adapterview = (String)((List)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.h(a).get(view)).get(0);
                        }
                        String s1 = (String)com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.i(a).get(adapterview);
                        view = s1;
                        if (s1 == null)
                        {
                            view = (String)PanelDataCenter.a().l(adapterview).get(0);
                        }
                        PalettesPanel.j(a).b(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.d(a, adapterview));
                        editviewactivity.a(null, view);
                        return;
                    }
                }
            }

            
            {
                a = PalettesPanel.this;
                super();
            }

            private class PaletteGroup extends Enum
            {

                public static final PaletteGroup a;
                public static final PaletteGroup b;
                public static final PaletteGroup c;
                public static final PaletteGroup d;
                public static final PaletteGroup e;
                public static final PaletteGroup f;
                public static final PaletteGroup g;
                public static final PaletteGroup h;
                private static final PaletteGroup i[];

                public static int a(PaletteGroup palettegroup)
                {
                    if (palettegroup == a)
                    {
                        return 0;
                    }
                    if (palettegroup == b)
                    {
                        return 1;
                    }
                    if (palettegroup == c)
                    {
                        return 2;
                    }
                    if (palettegroup == g)
                    {
                        return 3;
                    }
                    if (palettegroup == d)
                    {
                        return 4;
                    }
                    if (palettegroup == e)
                    {
                        return 5;
                    }
                    if (palettegroup == f)
                    {
                        return 6;
                    }
                    return palettegroup != h ? -1 : 7;
                }

                public static PaletteGroup a(int i1)
                {
                    switch (i1)
                    {
                    default:
                        return h;

                    case 0: // '\0'
                        return a;

                    case 1: // '\001'
                        return b;

                    case 2: // '\002'
                        return c;

                    case 3: // '\003'
                        return g;

                    case 4: // '\004'
                        return d;

                    case 5: // '\005'
                        return e;

                    case 6: // '\006'
                        return f;

                    case 7: // '\007'
                        return h;
                    }
                }

                public static boolean a(int i1, int j1)
                {
                    return i1 == 5;
                }

                public static boolean b(PaletteGroup palettegroup)
                {
                    return palettegroup == d || palettegroup == e || palettegroup == f || palettegroup == h;
                }

                public static PaletteGroup valueOf(String s1)
                {
                    return (PaletteGroup)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/palettesPanel/PalettesPanel$PaletteGroup, s1);
                }

                public static PaletteGroup[] values()
                {
                    return (PaletteGroup[])i.clone();
                }

                static 
                {
                    a = new PaletteGroup("CUSTOM_FOUR", 0);
                    b = new PaletteGroup("CUSTOM_THREE", 1);
                    c = new PaletteGroup("CUSTOM_TWO", 2);
                    d = new PaletteGroup("DEFAULT_FOUR", 3);
                    e = new PaletteGroup("DEFAULT_THREE", 4);
                    f = new PaletteGroup("DEFAULT_TWO", 5);
                    g = new PaletteGroup("CUSTOM_ONE", 6);
                    h = new PaletteGroup("DEFAULT_ONE", 7);
                    i = (new PaletteGroup[] {
                        a, b, c, d, e, f, g, h
                    });
                }

                private PaletteGroup(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
    }

    static aw a(PalettesPanel palettespanel, aw aw1)
    {
        palettespanel.G = aw1;
        return aw1;
    }

    private p a(int i1, int j1)
    {
        if (b(i1).size() > 0)
        {
            if (b(i1).size() == j1)
            {
                return new p(i1, j1 - 1);
            } else
            {
                return new p(i1, j1);
            }
        }
        for (i1 = 0; i1 < m.getGroupCount(); i1++)
        {
            if (b(i1).size() > 0)
            {
                if (com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(i1, 0))
                {
                    return new p(i1, 1);
                } else
                {
                    return new p(i1, 0);
                }
            }
        }

        return new p(-1, -1);
    }

    static p a(PalettesPanel palettespanel, int i1, int j1)
    {
        return palettespanel.a(i1, j1);
    }

    static p a(PalettesPanel palettespanel, p p1)
    {
        palettespanel.s = p1;
        return p1;
    }

    static String a(PalettesPanel palettespanel)
    {
        return palettespanel.J;
    }

    static List a(PalettesPanel palettespanel, int i1)
    {
        return palettespanel.b(i1);
    }

    private void a(aw aw1)
    {
        if (l == null || n == null || aw1 == null || p == null || q == null)
        {
            return;
        }
        if (L == null)
        {
            L = new HashMap();
        }
        if (M == null)
        {
            M = new HashMap();
        }
        h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
        Object obj1 = h1.b("eye_shadow");
        Object obj;
        if (aw1.g() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d)
        {
            obj = null;
        } else
        {
            obj = aw1.k();
        }
        J = ((String) (obj));
        L.put(J, aw1.a());
        aw1 = h1.d("eye_shadow");
        O = new ArrayList();
        if (aw1 != null)
        {
            for (aw1 = aw1.iterator(); aw1.hasNext(); O.add(new c((String)((Pair) (obj)).first, new String(), (String)((Pair) (obj)).second)))
            {
                obj = (Pair)aw1.next();
            }

        }
        q.a(O);
        if (((List) (obj1)).size() > 0)
        {
            K = new HashMap();
            String s1;
            for (aw1 = ((List) (obj1)).iterator(); aw1.hasNext(); ((List)K.get(obj1)).add(s1))
            {
                obj1 = h1.a("eye_shadow", (Long)aw1.next());
                s1 = ((d) (obj1)).d();
                obj1 = ((d) (obj1)).e();
                if (K.containsKey(obj1))
                {
                    continue;
                }
                K.put(obj1, new ArrayList());
                if (s1.equals(J))
                {
                    M.put(obj1, s1);
                }
            }

            o.setVisibility(0);
            Globals.d(new Runnable(h1) {

                final h a;
                final PalettesPanel b;

                public void run()
                {
                    PalettesPanel palettespanel = b;
                    String s2;
                    if (com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(b) != null)
                    {
                        s2 = a.b("eye_shadow", com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(b)).e();
                    } else
                    {
                        s2 = null;
                    }
                    com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.a(palettespanel, s2);
                }

            
            {
                b = PalettesPanel.this;
                a = h1;
                super();
            }
            });
            return;
        } else
        {
            o.setVisibility(8);
            return;
        }
    }

    static void a(PalettesPanel palettespanel, String s1)
    {
        palettespanel.a(s1);
    }

    private void a(String s1)
    {
        int i1 = 0;
        do
        {
label0:
            {
                c c1;
label1:
                {
                    if (i1 < q.getCount())
                    {
                        c1 = q.a(i1);
                        if (c1 == null || c1.a() == null || !c1.a().equalsIgnoreCase(s1))
                        {
                            break label0;
                        }
                        p.a(i1, true);
                        r = s1;
                        if (!Q.containsKey(c1))
                        {
                            break label1;
                        }
                        Q.put(c1, Integer.valueOf(((Integer)Q.get(c1)).intValue() + 1));
                    }
                    return;
                }
                Q.put(c1, Integer.valueOf(1));
                return;
            }
            i1++;
        } while (true);
    }

    static boolean a(PalettesPanel palettespanel, boolean flag)
    {
        palettespanel.H = flag;
        return flag;
    }

    static e b(PalettesPanel palettespanel)
    {
        return palettespanel.q;
    }

    static String b(PalettesPanel palettespanel, String s1)
    {
        palettespanel.r = s1;
        return s1;
    }

    private List b(int i1)
    {
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a))
        {
            return B;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.b))
        {
            return A;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.c))
        {
            return z;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.g))
        {
            return y;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.d))
        {
            return F;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(PaletteGroup.e))
        {
            return E;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(PaletteGroup.f))
        {
            return D;
        }
        if (i1 == com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.h))
        {
            return C;
        } else
        {
            return new ArrayList();
        }
    }

    private void b(String s1)
    {
        if (s1 == null)
        {
            return;
        }
        if (!s1.equalsIgnoreCase(P))
        {
            N = new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.a(getActivity(), s1);
            n.setAdapter(N);
            l.setVisibility(8);
            n.setVisibility(0);
            i.setVisibility(8);
            j.setVisibility(0);
            if (N.getCount() > 0)
            {
                s1 = N.a(0).d();
            } else
            {
                s1 = null;
            }
            s1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().n("eye_shadow", s1);
            b.a(s1, k);
            return;
        } else
        {
            l.setVisibility(0);
            n.setVisibility(8);
            i.setVisibility(0);
            j.setVisibility(8);
            return;
        }
    }

    private p c(String s1)
    {
        p p1 = new p(-1, -1);
        for (int i1 = 0; i1 < m.getGroupCount(); i1++)
        {
            List list = b(i1);
            for (int j1 = 0; j1 < list.size(); j1++)
            {
                if (((aw)list.get(j1)).a().equals(s1))
                {
                    p1.a = i1;
                    p1.b = j1;
                }
            }

        }

        return p1;
    }

    static String c(PalettesPanel palettespanel)
    {
        return palettespanel.r;
    }

    static void c(PalettesPanel palettespanel, String s1)
    {
        palettespanel.b(s1);
    }

    static int d(PalettesPanel palettespanel, String s1)
    {
        return palettespanel.d(s1);
    }

    private int d(String s1)
    {
        for (int i1 = 0; i1 < N.getCount(); i1++)
        {
            if (N.a(i1).d().equals(s1))
            {
                return i1;
            }
        }

        return -1;
    }

    static ConcurrentHashMap d(PalettesPanel palettespanel)
    {
        return palettespanel.Q;
    }

    static p e(PalettesPanel palettespanel)
    {
        return palettespanel.s;
    }

    static o f(PalettesPanel palettespanel)
    {
        return palettespanel.m;
    }

    static Map g(PalettesPanel palettespanel)
    {
        return palettespanel.M;
    }

    static String h()
    {
        return P;
    }

    static Map h(PalettesPanel palettespanel)
    {
        return palettespanel.K;
    }

    static Map i(PalettesPanel palettespanel)
    {
        return palettespanel.L;
    }

    private void i()
    {
        k();
        c = new GestureDetector(getActivity(), U);
        t = new ArrayList();
        B = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 4);
        A = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 3);
        z = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 2);
        y = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 1);
        x = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 4);
        w = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 3);
        v = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 2);
        u = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 1);
        r();
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(2, B, p(), 4, 0x7f0301f8));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(2, A, null, 3, 0x7f0301fd));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(3, z, null, 2, 0x7f0301fe));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(3, y, null, 1, 0x7f0301fb));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(2, F, getString(0x7f070354), 4, 0x7f0301f8));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(2, E, null, 3, 0x7f0301fd));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(3, D, null, 2, 0x7f0301fe));
        t.add(new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d(3, C, null, 1, 0x7f0301fb));
        h = g.findViewById(0x7f0c06af);
        e = g.findViewById(0x7f0c06a5);
        f = g.findViewById(0x7f0c06a6);
        i = g.findViewById(0x7f0c06a8);
        j = g.findViewById(0x7f0c06a9);
        k = (ImageView)g.findViewById(0x7f0c06aa);
        m = new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.b(getActivity(), new com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.c(t, W, X, Y));
        l = (ExpandableListView)g.findViewById(0x7f0c06ac);
        l.setAdapter(m);
        l.setOnTouchListener(T);
        n = (GridView)g.findViewById(0x7f0c06ab);
        n.setOnItemClickListener(V);
        o = g.findViewById(0x7f0c06ad);
        p = (HorizontalGridView)g.findViewById(0x7f0c06ae);
        q = new e();
        p.setAdapter(q);
        p.setOnItemClickListener(R);
        e.setOnClickListener(S);
        f.setOnClickListener(S);
        s = new p(-1, -1);
        H = false;
        I = true;
        for (int i1 = 0; i1 < t.size(); i1++)
        {
            l.expandGroup(i1);
        }

    }

    static com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.a j(PalettesPanel palettespanel)
    {
        return palettespanel.N;
    }

    private void j()
    {
        c = null;
        l = null;
    }

    private void k()
    {
        k k1 = new k(getActivity(), null);
        k1.g = false;
        k1.a(0.15F);
        b = new ag(getActivity());
        b.a(getActivity().getFragmentManager(), k1);
    }

    static void k(PalettesPanel palettespanel)
    {
        palettespanel.s();
    }

    static GestureDetector l(PalettesPanel palettespanel)
    {
        return palettespanel.c;
    }

    private void l()
    {
        h.setOnClickListener(aa);
        l.setOnGroupClickListener(Z);
    }

    private void m()
    {
        p.setAdapter(null);
        p.setOnItemClickListener(null);
        h.setOnClickListener(null);
        l.setOnGroupClickListener(null);
    }

    static boolean m(PalettesPanel palettespanel)
    {
        return palettespanel.H;
    }

    static View n(PalettesPanel palettespanel)
    {
        return palettespanel.g;
    }

    private boolean n()
    {
        return y.size() > 0 || z.size() > 0 || A.size() > 0 || A.size() > 0 || F.size() - x.size() > 0 || E.size() - w.size() > 0 || D.size() - v.size() > 0 || C.size() - u.size() > 0;
    }

    private int o()
    {
        return B.size() + A.size() + z.size() + y.size();
    }

    static android.content.DialogInterface.OnDismissListener o(PalettesPanel palettespanel)
    {
        return palettespanel.ab;
    }

    private String p()
    {
        if (o() > 0)
        {
            return (new StringBuilder()).append(getString(0x7f070347)).append(" (").append(getString(0x7f0703cc)).append(": ").append(a).append(")").toString();
        } else
        {
            return null;
        }
    }

    static String p(PalettesPanel palettespanel)
    {
        return palettespanel.p();
    }

    static List q(PalettesPanel palettespanel)
    {
        return palettespanel.t;
    }

    private void q()
    {
        int j1 = 0;
        ArrayList arraylist = new ArrayList(m.getGroupCount());
        for (int i1 = 0; i1 < m.getGroupCount(); i1++)
        {
            arraylist.add(Integer.valueOf(b(i1).size()));
        }

        r();
        boolean flag = false;
        while (j1 < m.getGroupCount()) 
        {
            if (com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.b(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(j1)))
            {
                int k1 = ((Integer)arraylist.get(j1)).intValue();
                int l1 = b(j1).size();
                if (k1 != l1)
                {
                    flag = true;
                    if (j1 == s.a)
                    {
                        p p1 = s;
                        p1.b = (l1 - k1) + p1.b;
                    }
                    ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)t.get(j1)).a(b(j1));
                }
            }
            j1++;
        }
        if (flag)
        {
            m.a(s);
            Globals.d().t().a(null);
        }
    }

    static aw r(PalettesPanel palettespanel)
    {
        return palettespanel.G;
    }

    private void r()
    {
        F = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 4);
        E = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 3);
        D = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 2);
        C = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 1);
        Collections.reverse(F);
        Collections.reverse(E);
        Collections.reverse(D);
        Collections.reverse(C);
        F.addAll(x);
        E.addAll(w);
        D.addAll(v);
        C.addAll(u);
        E.add(0, new aw("", "", 0, null, null, null, null, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 0.0F, Boolean.valueOf(false), null));
    }

    private void s()
    {
        if (H)
        {
            com.cyberlink.youcammakeup.utility.o.c();
            H = false;
            m.a(false);
        } else
        {
            Activity activity = getActivity();
            if (activity instanceof EditViewActivity)
            {
                ((EditViewActivity)activity).G();
                return;
            }
        }
    }

    static boolean s(PalettesPanel palettespanel)
    {
        return palettespanel.n();
    }

    static void t(PalettesPanel palettespanel)
    {
        palettespanel.q();
    }

    public int a()
    {
        return g.getVisibility();
    }

    public void a(int i1)
    {
        g.setVisibility(i1);
        if (i1 == 0)
        {
            if (q != null)
            {
                q.b();
            }
            r r1 = MotionControlHelper.e().C();
            String s1 = r1.c();
            G = PanelDataCenter.a().i(s1);
            a(G);
            if (G != null)
            {
                if (G.k() != null)
                {
                    break MISSING_BLOCK_LABEL_147;
                }
                if (MotionControlHelper.e().a(r1))
                {
                    s = new p(-1, -1);
                } else
                {
                    s = c(s1);
                }
                b(P);
                m.a(s);
            }
            return;
        } else
        {
            if (q != null)
            {
                q.a();
            }
            g();
            return;
        }
        s = new p(-1, -1);
        b(com.cyberlink.youcammakeup.kernelctrl.sku.h.b().b("eye_shadow", G.k()).e());
        N.b(d(G.k()));
        return;
    }

    public void a(Fragment fragment)
    {
        d = (MakeupMenuBottomToolbar)fragment;
    }

    public void a(Long long1, boolean flag)
    {
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void c(long l1)
    {
        getActivity().runOnUiThread(new Runnable() {

            final PalettesPanel a;

            public void run()
            {
                PalettesPanel.t(a);
            }

            
            {
                a = PalettesPanel.this;
                super();
            }
        });
    }

    public Long d()
    {
        return null;
    }

    public void e()
    {
        int k1 = 0;
        if (o() >= a)
        {
            String s1 = getString(0x7f070348);
            Globals.d().i().a(getActivity(), x.a, s1, false);
            return;
        }
        Object obj = MotionControlHelper.e().C();
        Object obj1 = PanelDataCenter.a().i(((r) (obj)).c());
        obj1 = PanelDataCenter.a().a(((aw) (obj1)), ((r) (obj)));
        if (obj1 == null)
        {
            obj = getString(0x7f07003a);
            Globals.d().i().a(getActivity(), x.a, ((String) (obj)), false);
            return;
        }
        i i1 = StatusManager.j().d();
        StatusManager.j().c(((String) (obj1)));
        if (i1 != null && i1.b() != null)
        {
            i1.b().a(((String) (obj1)));
        }
        B = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 4);
        A = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 3);
        z = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 2);
        y = PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 1);
        ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)t.get(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a))).a(p());
        ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)t.get(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a))).a(B);
        ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)t.get(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.b))).a(A);
        ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)t.get(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.c))).a(z);
        ((com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.d)t.get(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PaletteGroup.g))).a(y);
        int j1;
        if (((r) (obj)).f().size() > 3)
        {
            j1 = 0;
        } else
        if (((r) (obj)).f().size() > 2)
        {
            j1 = m.getChildrenCount(0) + 1;
            k1 = 1;
        } else
        if (((r) (obj)).f().size() > 1)
        {
            j1 = m.getChildrenCount(0) + 2 + m.getChildrenCount(1);
            k1 = 2;
        } else
        {
            j1 = 0;
        }
        m.a(c(((String) (obj1))));
        l.smoothScrollToPosition(j1 + m.getChildrenCount(k1));
    }

    public void f()
    {
        if (d != null)
        {
            d.a(Boolean.valueOf(false));
        }
    }

    public void g()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        for (Iterator iterator = Q.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            c c1 = (c)((java.util.Map.Entry) (obj)).getKey();
            obj = (Integer)((java.util.Map.Entry) (obj)).getValue();
            if (c1.b() != null && !c1.b().isEmpty())
            {
                hashmap.put(c1.b(), obj);
            } else
            {
                hashmap1.put(c1.a(), obj);
            }
        }

        if (!hashmap.isEmpty() || !hashmap1.isEmpty())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new com.cyberlink.youcammakeup.clflurry.r(hashmap, hashmap1, YMKFeatures.a(BeautyMode.n)));
        }
        Q.clear();
    }

    public void onActivityCreated(Bundle bundle)
    {
        i();
        l();
        super.onActivityCreated(bundle);
        f();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f030185, viewgroup, false);
        return g;
    }

    public void onDestroyView()
    {
        m();
        j();
        super.onDestroyView();
    }

    public void onPause()
    {
        if (q != null)
        {
            q.a();
        }
        g();
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
        }
    }

    public void onStart()
    {
        super.onStart();
        if (!I)
        {
            q();
        }
        I = false;
    }

}
