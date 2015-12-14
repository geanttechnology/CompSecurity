// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.SwyftSerials;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RemoveItemController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.d;
import com.socialin.android.net.a;
import com.socialin.android.photo.b;
import com.socialin.android.photo.f;
import com.socialin.android.photo.h;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.clipart:
//            j, d, e

public class c extends j
{

    private static final String o = com/socialin/android/photo/clipart/c.getSimpleName();
    private List A;
    private List B;
    private List C;
    private List D;
    private final ItemType E;
    private boolean F;
    private int G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N[];
    private String O[];
    private String P;
    private String Q;
    private String R;
    private String S;
    private int T;
    private int U;
    private ItemType V;
    private Activity p;
    private List q;
    private boolean r;
    private BaseSocialinApiRequestController s;
    private RemoveItemController t;
    private ParamWithPageLimit u;
    private ParamWithItemId v;
    private int w;
    private com.socialin.android.photo.clipart.d x;
    private List y;
    private List z;

    public c()
    {
        r = false;
        s = RequestControllerFactory.createGetStickerStreamController();
        u = new ParamWithPageLimit();
        w = 4;
        x = new com.socialin.android.photo.clipart.d(this, (byte)0);
        y = new ArrayList();
        C = new ArrayList();
        D = new ArrayList();
        E = ItemType.CLIPART;
        G = -1;
        U = 0;
        V = ItemType.CLIPART;
    }

    static int a(c c1)
    {
        return c1.G;
    }

    static int a(c c1, int i1)
    {
        c1.U = i1;
        return i1;
    }

    static RemoveItemController a(c c1, RemoveItemController removeitemcontroller)
    {
        c1.t = removeitemcontroller;
        return removeitemcontroller;
    }

    static ParamWithItemId a(c c1, ParamWithItemId paramwithitemid)
    {
        c1.v = paramwithitemid;
        return paramwithitemid;
    }

    static String a()
    {
        return o;
    }

    static List a(c c1, List list)
    {
        c1.y = list;
        return list;
    }

    private void a(int i1, int j1, boolean flag, String s1, String s2, String s3, String s4)
    {
        if (p == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("clipartResId", -1);
        intent.putExtra("clipartType", i1);
        intent.putExtra("clipartFillColorType", j1);
        intent.putExtra("clipartPath", s2);
        intent.putExtra("clipartIconUrl", s4);
        intent.putExtra("fromPicsinFile", flag);
        intent.putExtra("fileName", s1);
        intent.putExtra("isReplace", h);
        intent.putExtra("defaultBlendingMode", s3);
        p.setResult(-1, intent);
        p.finish();
        if (d.b)
        {
            (new StringBuilder("fileName: ")).append(s1).append(" itemPath: ").append(s2);
        }
        AnalyticUtils.getInstance(p).trackLocalAction("clipart:done");
    }

    static Activity b(c c1)
    {
        return c1.p;
    }

    private void b()
    {
        GridView gridview = (GridView)e(0x7f1007e8);
        Activity activity = p;
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        gridview.setChoiceMode(3);
        gridview.setMultiChoiceModeListener(new android.widget.AbsListView.MultiChoiceModeListener(arraylist, activity, arraylist1, arraylist2) {

            final List a;
            final Activity b;
            final List c;
            final List d;
            final c e;

            public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
            {
                if (menuitem.getItemId() == 1)
                {
                    actionmode = new com.socialin.android.dialog.b();
                    actionmode.b = b.getString(0x7f0805ea);
                    actionmode.a(e.getString(0x7f080311)).a(new android.view.View.OnClickListener(this) {

                        final _cls3 a;

                        public final void onClick(View view)
                        {
                            boolean flag = false;
                            com.socialin.android.photo.clipart.c.a(a.e, a.a.size());
                            a.e.e(0x7f1007e7).setVisibility(0);
                            int i1 = 0;
                            int j1;
                            do
                            {
                                j1 = ((flag) ? 1 : 0);
                                if (i1 >= a.a.size())
                                {
                                    break;
                                }
                                view = (ImageItem)a.a.get(i1);
                                com.socialin.android.photo.clipart.c.a(a.e, new ParamWithItemId());
                                com.socialin.android.photo.clipart.c.m(a.e).itemId = ((ImageItem) (view)).id;
                                com.socialin.android.photo.clipart.c.a(a.e, new RemoveItemController());
                                c.r(a.e).setRequestCompleteListener(new com.socialin.asyncnet.d(this) {

                                    private _cls1 a;

                                    public final volatile void onCancelRequest(Object obj, Request request)
                                    {
                                    }

                                    public final void onFailure(Exception exception, Request request)
                                    {
                                        Utils.b(a.a.b, a.a.e.getString(0x7f0805cb));
                                    }

                                    public final transient void onProgressUpdate(Integer ainteger[])
                                    {
                                    }

                                    public final void onSuccess(Object obj, Request request)
                                    {
                                        if (a.a.e.isVisible() && a.a.e.a == com.socialin.android.photo.clipart.c.a(a.a.e))
                                        {
                                            c.n(a.a.e);
                                            c.o(a.a.e);
                                            if (c.p(a.a.e) == 0)
                                            {
                                                c.q(a.a.e);
                                            }
                                        }
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                                c.r(a.e).doRequest(com.socialin.android.photo.clipart.c.a(), com.socialin.android.photo.clipart.c.m(a.e));
                                Object obj = (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(String.valueOf(((ImageItem) (view)).id)).toString();
                                view = new File(com.socialin.android.photo.clipart.e.a(c.i(a.e), ((String) (obj))));
                                obj = new File(com.socialin.android.photo.clipart.e.b(c.g(a.e), ((String) (obj))));
                                if (view.exists() && !view.delete())
                                {
                                    Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete synced clipart");
                                }
                                if (((File) (obj)).exists() && !((File) (obj)).delete())
                                {
                                    Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete synced clipart icon");
                                }
                                i1++;
                            } while (true);
                            for (; j1 < a.c.size(); j1++)
                            {
                                if (a.c.get(j1) != null)
                                {
                                    view = new File((String)a.c.get(j1));
                                    if (view.exists() && !view.delete())
                                    {
                                        Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete local clipart");
                                    }
                                }
                                if (a.d.get(j1) == null)
                                {
                                    continue;
                                }
                                view = new File((String)a.d.get(j1));
                                if (view.exists() && !view.delete())
                                {
                                    Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete local clipart icon");
                                }
                            }

                            a.c.clear();
                            a.d.clear();
                            if (a.a.size() == 0)
                            {
                                c.q(a.e);
                            }
                            a.a.clear();
                        }

            
            {
                a = _pcls3;
                super();
            }
                    }).b(e.getString(0x7f080295)).a().show(b.getFragmentManager(), null);
                }
                return true;
            }

            public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
            {
                actionmode.setTitle(e.getString(0x7f080583));
                menu.add(0, 1, 0, "Delete").setTitle(e.getString(0x7f080583)).setIcon(0x7f02033d);
                return true;
            }

            public final void onDestroyActionMode(ActionMode actionmode)
            {
                a.clear();
            }

            public final void onItemCheckedStateChanged(ActionMode actionmode, int i1, long l1, boolean flag)
            {
                int j1;
                boolean flag1;
                flag1 = false;
                j1 = 0;
                if (!flag) goto _L2; else goto _L1
_L1:
                if (i1 >= c.c(e).size()) goto _L4; else goto _L3
_L3:
                a.add(c.c(e).get(i1));
_L6:
                return;
_L4:
                actionmode = ((myobfuscated.cb.c)c.l(e).get(i1)).d;
                String s1 = actionmode.substring(actionmode.lastIndexOf("/"));
                String s2 = actionmode.substring(actionmode.lastIndexOf("/") + 1, actionmode.length());
                c.add(actionmode);
                d.add(com.socialin.android.photo.clipart.e.b(s1, s2));
                return;
_L2:
                if (i1 >= c.c(e).size())
                {
                    break; /* Loop/switch isn't completed */
                }
                while (j1 < a.size()) 
                {
                    if (((ImageItem)a.get(j1)).id == ((ImageItem)c.c(e).get(i1)).id)
                    {
                        a.remove(j1);
                        return;
                    }
                    j1++;
                }
                if (true) goto _L6; else goto _L5
_L5:
                actionmode = ((myobfuscated.cb.c)c.l(e).get(i1)).d;
                i1 = ((flag1) ? 1 : 0);
                while (i1 < c.size()) 
                {
                    if (((String)c.get(i1)).equals(actionmode))
                    {
                        c.remove(i1);
                        d.remove(i1);
                        return;
                    }
                    i1++;
                }
                if (true) goto _L6; else goto _L7
_L7:
            }

            public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
            {
                return true;
            }

            
            {
                e = c.this;
                a = list;
                b = activity;
                c = list1;
                d = list2;
                super();
            }
        });
        gridview.setVisibility(8);
        e(0x7f1007e7).setVisibility(0);
        D.clear();
        if (!F)
        {
            c();
        }
        gridview = (GridView)e(0x7f1007e8);
        if (com.socialin.android.util.s.a(p) && SocialinV3.getInstance().isRegistered())
        {
            u.userId = SocialinV3.getInstance().getUser().id;
            s.setCacheConfig(w);
            s.setRequestCompleteListener(new com.socialin.asyncnet.d(gridview) {

                private GridView a;
                private c b;

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    if (com.socialin.android.photo.clipart.c.b(b) != null && !com.socialin.android.photo.clipart.c.b(b).isFinishing() && c.l(b).size() == 0)
                    {
                        a.setVisibility(8);
                        b.e(0x7f1007e7).setVisibility(8);
                        b.e(0x7f1007e5).setVisibility(0);
                    }
                    if (!"Specified stream doesn't exist".equals(exception.getMessage()) && b.isAdded())
                    {
                        Utils.b(com.socialin.android.photo.clipart.c.b(b), b.getString(0x7f0805cb));
                    }
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj, Request request)
                {
label0:
                    {
                        obj = (Stream)obj;
                        if (b.isVisible() && b.a == com.socialin.android.photo.clipart.c.a(b))
                        {
                            com.socialin.android.photo.clipart.c.a(b, ((Stream) (obj)).items);
                            if (com.socialin.android.photo.clipart.c.b(b) != null && !com.socialin.android.photo.clipart.c.b(b).isFinishing())
                            {
                                String s1;
                                for (obj = c.c(b).iterator(); ((Iterator) (obj)).hasNext(); b.m.a(request.getLargeUrl(), com.socialin.android.photo.clipart.e.a(c.i(b), s1), null, null, false))
                                {
                                    request = (ImageItem)((Iterator) (obj)).next();
                                    s1 = (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(String.valueOf(((ImageItem) (request)).id)).toString();
                                    if (com.socialin.android.photo.clipart.c.d(b) == null)
                                    {
                                        c.e(b);
                                    }
                                    Iterator iterator = com.socialin.android.photo.clipart.c.d(b).iterator();
                                    do
                                    {
                                        if (!iterator.hasNext())
                                        {
                                            break;
                                        }
                                        myobfuscated.cb.c c1 = (myobfuscated.cb.c)iterator.next();
                                        if (c1.d.substring(c1.d.lastIndexOf("/") + 1).equals(((ImageItem) (request)).title))
                                        {
                                            File file = new File(com.socialin.android.photo.clipart.e.b(com.socialin.android.photo.clipart.c.f(b), ((ImageItem) (request)).title));
                                            if (!file.renameTo(new File(com.socialin.android.photo.clipart.e.b(c.g(b), s1))) && !file.delete())
                                            {
                                                com.socialin.android.photo.clipart.c.a();
                                                (new StringBuilder("clipart icon is not deleted: ")).append(file.getAbsolutePath());
                                            }
                                            file = new File(com.socialin.android.photo.clipart.e.a(com.socialin.android.photo.clipart.c.h(b), ((ImageItem) (request)).title));
                                            if (!file.renameTo(new File(com.socialin.android.photo.clipart.e.a(c.i(b), s1))) && !file.delete())
                                            {
                                                com.socialin.android.photo.clipart.c.a();
                                                (new StringBuilder("clipart is not deleted: ")).append(file.getAbsolutePath());
                                            }
                                            iterator.remove();
                                        }
                                    } while (true);
                                    if (c.j(b) != null)
                                    {
                                        Iterator iterator1 = c.j(b).iterator();
                                        do
                                        {
                                            if (!iterator1.hasNext())
                                            {
                                                break;
                                            }
                                            myobfuscated.cb.c c2 = (myobfuscated.cb.c)iterator1.next();
                                            if (c2.d.substring(c2.d.lastIndexOf("/") + 1).equals(s1))
                                            {
                                                iterator1.remove();
                                            }
                                        } while (true);
                                    }
                                    b.m.a(request.getSmallUrl(), com.socialin.android.photo.clipart.e.b(c.g(b), s1), null, null, false);
                                }

                                c.k(b);
                                if (c.l(b).size() <= 0)
                                {
                                    break label0;
                                }
                                b.e(0x7f1007e7).setVisibility(8);
                                a.setVisibility(0);
                                a.setChoiceMode(3);
                                if (a.getAdapter() == null)
                                {
                                    a.setAdapter(b.k);
                                }
                                com.socialin.android.photo.clipart.c.b(b).invalidateOptionsMenu();
                            }
                        }
                        return;
                    }
                    a.setVisibility(8);
                    b.e(0x7f1007e7).setVisibility(8);
                    b.e(0x7f1007e5).setVisibility(0);
                }

            
            {
                b = c.this;
                a = gridview;
                super();
            }
            });
            s.doRequest(o, u);
        } else
        if (D.size() == 0)
        {
            gridview.setVisibility(8);
            e(0x7f1007e7).setVisibility(8);
            if (SocialinV3.getInstance().isRegistered() && !com.socialin.android.util.s.a(p))
            {
                e(0x7f1007e6).setVisibility(0);
                return;
            } else
            {
                e(0x7f1007e5).setVisibility(0);
                return;
            }
        }
    }

    static List c(c c1)
    {
        return c1.y;
    }

    private void c()
    {
        y.clear();
        if (SocialinV3.getInstance().isRegistered())
        {
            List list3 = myobfuscated.f.m.a(p, M, F, V);
            List list = myobfuscated.f.m.a(p, L, F, V);
            if (list3.size() != list.size())
            {
                myobfuscated.f.m.a(M, L);
                myobfuscated.f.m.a(M, L, V.getValue());
                list3 = myobfuscated.f.m.a(p, M, F, V);
                list = myobfuscated.f.m.a(p, L, F, V);
            }
            z = new ArrayList(list3.size());
            for (int i1 = 0; i1 < list3.size(); i1++)
            {
                myobfuscated.cb.c c1 = new myobfuscated.cb.c();
                c1.h = ((File)list3.get(i1)).getPath();
                c1.d = ((File)list.get(i1)).getPath();
                z.add(i1, c1);
            }

        }
        List list4 = myobfuscated.f.m.a(p, H, F, V);
        List list1 = myobfuscated.f.m.a(p, I, F, V);
        if (list4.size() != list1.size())
        {
            myobfuscated.f.m.a(H, I);
            myobfuscated.f.m.a(H, I, V.getValue());
            list4 = myobfuscated.f.m.a(p, H, F, V);
            list1 = myobfuscated.f.m.a(p, I, F, V);
        }
        A = new ArrayList(list4.size());
        for (int j1 = 0; j1 < list4.size(); j1++)
        {
            myobfuscated.cb.c c2 = new myobfuscated.cb.c();
            c2.h = ((File)list4.get(j1)).getPath();
            c2.d = ((File)list1.get(j1)).getPath();
            A.add(j1, c2);
        }

        d();
        C.clear();
        for (int k1 = 0; k1 < O.length; k1++)
        {
            List list2 = myobfuscated.f.m.a(p, O[k1], F, V);
            List list5 = myobfuscated.f.m.a(p, N[k1], F, V);
            if (list2.size() != list5.size())
            {
                myobfuscated.f.m.a(O[k1], N[k1]);
                myobfuscated.f.m.a(O[k1], N[k1], V.getValue());
                list2 = myobfuscated.f.m.a(p, O[k1], F, V);
                list5 = myobfuscated.f.m.a(p, N[k1], F, V);
            }
            for (int l1 = 0; l1 < list2.size(); l1++)
            {
                myobfuscated.cb.c c3 = new myobfuscated.cb.c();
                c3.h = ((File)list2.get(l1)).getPath();
                c3.d = ((File)list5.get(l1)).getPath();
                C.add(l1, c3);
            }

        }

        e();
        if (D.size() > 0)
        {
            GridView gridview = (GridView)e(0x7f1007e8);
            e(0x7f1007e7).setVisibility(8);
            gridview.setVisibility(0);
            gridview.setChoiceMode(3);
            gridview.setAdapter(k);
        }
    }

    static List d(c c1)
    {
        return c1.B;
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (B != null) goto _L2; else goto _L1
_L1:
        List list;
        List list1;
        list1 = myobfuscated.f.m.a(p, K, F, V);
        list = myobfuscated.f.m.a(p, J, F, V);
        if (list1.size() != list.size())
        {
            myobfuscated.f.m.a(K, J);
            myobfuscated.f.m.a(K, J, V.getValue());
            list1 = myobfuscated.f.m.a(p, H, F, V);
            list = myobfuscated.f.m.a(p, I, F, V);
        }
        B = new ArrayList(list1.size());
        int i1 = 0;
_L3:
        if (i1 >= list1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        myobfuscated.cb.c c1 = new myobfuscated.cb.c();
        c1.h = ((File)list1.get(i1)).getPath();
        c1.d = ((File)list.get(i1)).getPath();
        B.add(i1, c1);
        i1++;
        if (true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void e()
    {
        D.clear();
        myobfuscated.cb.c c1;
        for (Iterator iterator = y.iterator(); iterator.hasNext(); D.add(c1))
        {
            ImageItem imageitem = (ImageItem)iterator.next();
            c1 = new myobfuscated.cb.c();
            c1.g = imageitem.getSmallUrl();
            c1.d = com.socialin.android.photo.clipart.e.a(L, (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(String.valueOf(imageitem.id)).toString());
        }

        if (!F)
        {
            if (z != null)
            {
                D.addAll(z);
            }
            if (A != null)
            {
                D.addAll(A);
            }
            if (B != null)
            {
                D.addAll(B);
            }
            if (C != null)
            {
                D.addAll(C);
            }
        }
        if (k == null)
        {
            k = new myobfuscated.cb.d(p, 0x7f030064);
        }
        if (D.size() > 0)
        {
            myobfuscated.cb.d d1 = k;
            List list = D;
            d1.b.clear();
            d1.b.addAll(list);
            d1.notifyDataSetChanged();
        }
    }

    static void e(c c1)
    {
        c1.d();
    }

    static String f(c c1)
    {
        return c1.K;
    }

    static String g(c c1)
    {
        return c1.M;
    }

    static String h(c c1)
    {
        return c1.J;
    }

    static String i(c c1)
    {
        return c1.L;
    }

    static List j(c c1)
    {
        return c1.z;
    }

    static void k(c c1)
    {
        c1.e();
    }

    static List l(c c1)
    {
        return c1.D;
    }

    static ParamWithItemId m(c c1)
    {
        return c1.v;
    }

    static int n(c c1)
    {
        c1.w = 3;
        return 3;
    }

    static int o(c c1)
    {
        int i1 = c1.U;
        c1.U = i1 - 1;
        return i1;
    }

    static int p(c c1)
    {
        return c1.U;
    }

    static void q(c c1)
    {
        c1.b();
    }

    static RemoveItemController r(c c1)
    {
        return c1.t;
    }

    protected final String a(int i1, int j1)
    {
        return com.socialin.android.photo.clipart.e.a(i1, j1);
    }

    protected final String a(int i1, int j1, Context context)
    {
        return com.socialin.android.photo.clipart.e.a(i1, j1, context);
    }

    public final void a(int i1)
    {
        if (p != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        AnalyticUtils.getInstance(p).track(new com.socialin.android.apiv3.events.EventsFactory.EditClipArtChooseEvent(c));
        if (c != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (a != G) goto _L4; else goto _L3
_L3:
        String s4 = ((myobfuscated.cb.c)D.get(i1)).d;
        String s6 = ((myobfuscated.cb.c)D.get(i1)).h;
        String s1 = "";
        if (i1 < y.size())
        {
            if (s4 != null && !(new File(s4)).exists())
            {
                Utils.a(p, 0x7f08048a);
                m.a(((ImageItem)y.get(i1)).getLargeUrl(), s4, null, null, true);
                return;
            }
            s1 = ((ImageItem)y.get(i1)).getUrl();
        }
        if (s4 != null)
        {
            if (p != null)
            {
                if (!FileUtils.a())
                {
                    Utils.a(p, 0x7f080342);
                } else
                if (s4 == null || !(new File(s4)).exists())
                {
                    Utils.b(p, getString(0x7f0802a2));
                } else
                {
                    a(0, 1, false, null, s4, "normal", s1);
                }
            }
            com.socialin.android.photo.f.a(p, E, s4, s6, s1, 0, 1, com.socialin.android.photo.clipart.e.d[1]);
            AnalyticUtils.getInstance(p).trackLocalAction("clipart:startDownload");
        } else
        {
            myobfuscated.f.m.a(0x7f0805cb, p);
        }
_L6:
        AnalyticUtils.getInstance(p).trackLocalAction("clipart:startDownload");
        return;
_L4:
        int j1;
        if (p == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!FileUtils.a())
        {
            Utils.a(p, 0x7f080342);
            continue; /* Loop/switch isn't completed */
        }
        j1 = 1;
        int l1 = b[i1][2];
        j1 = l1;
_L8:
        String s2;
        String s5;
        int i2;
        if (!r)
        {
            s5 = com.socialin.android.photo.clipart.e.a(a, i1, p);
            s2 = com.socialin.android.photo.clipart.e.c(a, i1);
            i2 = b[i1][1];
        } else
        {
            String s7 = myobfuscated.f.m.a(i1, p, R, F, V);
            int k2 = com.socialin.android.photo.f.a(p, s7, V);
            int l2 = com.socialin.android.photo.f.b(p, s7, V);
            String s8 = com.socialin.android.photo.f.c(p, s7, V);
            i2 = k2;
            j1 = l2;
            s5 = s7;
            s2 = s8;
            if (s7 == null)
            {
                Utils.b(p, getString(0x7f0802a2));
                i2 = k2;
                j1 = l2;
                s5 = s7;
                s2 = s8;
            }
        }
        if (s5 != null)
        {
            if ((new File(s5)).exists())
            {
                a(i2, j1, false, null, s5, "normal", s2);
                com.socialin.android.photo.f.a(p, V, s5, null, s2, i2, j1, com.socialin.android.photo.clipart.e.d[a + 1]);
            } else
            {
                n.a = i1;
                n.b = s5;
                n.a();
                f(i1);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (q == null) goto _L1; else goto _L7
_L7:
        j = (myobfuscated.cb.c)q.get(i1);
        String s3;
        int k1;
        int j2;
        if ("img".equals(j.u))
        {
            k1 = 0;
        } else
        if ("svg".equals(j.u))
        {
            k1 = 1;
        } else
        {
            k1 = -1;
        }
        if ("mask".equals(j.v))
        {
            j2 = 1;
        } else
        if ("absolute".equals(j.v))
        {
            j2 = 0;
        } else
        {
            j2 = -1;
        }
        s3 = (new StringBuilder()).append(SocialinV3.SHOP_PACKAGE_ICON_URL).append("_240/").append(c).append("/").append(j.l).toString();
        AnalyticUtils.getInstance(p).track(new com.socialin.android.apiv3.events.EventsFactory.ShopPackageUseEvent(c, "clipart"));
        if ("swyftmedia".equals(f))
        {
            SwyftSerials swyftserials = new SwyftSerials(d, e, (new StringBuilder()).append(e).append("_").append(String.format("%03d", new Object[] {
                Integer.valueOf(i1 + 1)
            })).toString());
            SwyftAnalytics.getInstance().createTrackEvent("shop_package_use").addParam("serials", swyftserials.toJSON().toString()).track();
        }
        a(k1, j2, true, j.m, j.j, j.x, s3);
        com.socialin.android.photo.f.b(p, V, j, k1);
        return;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
          goto _L8
    }

    public final void a(Intent intent, myobfuscated.cb.c c1)
    {
        p = getActivity();
        if (getView() != null && p != null) goto _L2; else goto _L1
_L1:
        l = intent;
_L4:
        return;
_L2:
        Bundle bundle;
        if (H == null || I == null)
        {
            I = com.socialin.android.photo.clipart.e.b(p);
            H = com.socialin.android.photo.clipart.e.c(p);
        }
        if (J == null || K == null)
        {
            J = com.socialin.android.photo.clipart.e.d(p);
            K = com.socialin.android.photo.clipart.e.a(J);
        }
        if (L == null || M == null)
        {
            L = com.socialin.android.photo.clipart.e.e(p);
            M = com.socialin.android.photo.clipart.e.f(p);
        }
        if (N == null || O == null)
        {
            N = com.socialin.android.photo.clipart.e.g(p);
            O = com.socialin.android.photo.clipart.e.a(N);
        }
        if (Q == null || P == null)
        {
            Q = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(CommonConstants.d[V.getValue()]).toString();
            P = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(CommonConstants.d[V.getValue()]).append("/icons").toString();
        }
        bundle = intent.getExtras();
        if (bundle == null) goto _L4; else goto _L3
_L3:
        int i1;
        if (p.getIntent() != null && p.getIntent().getExtras() != null)
        {
            h = p.getIntent().getExtras().getBoolean("isReplace", false);
        }
        c = bundle.getString("packageName");
        d = bundle.getString("brand");
        e = bundle.getString("content");
        f = bundle.getString("provider");
        g = bundle.getBoolean("installed", true);
        Object obj = p.getFragmentManager();
        FragmentTransaction fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
        obj = (com.picsart.shop.m)((FragmentManager) (obj)).findFragmentByTag("shopItemFragment");
        e(0x7f1007e9).setVisibility(8);
        e(0x7f1007e7).setVisibility(8);
        e(0x7f1007e5).setVisibility(8);
        if (g)
        {
            if (obj != null && ((com.picsart.shop.m) (obj)).isAdded() && ((com.picsart.shop.m) (obj)).isVisible())
            {
                fragmenttransaction.hide(((android.app.Fragment) (obj)));
                fragmenttransaction.commitAllowingStateLoss();
            }
        } else
        {
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("selectedShopItem", intent.getParcelableExtra("selectedShopItem"));
            bundle1.putString("fromSource", "clipart");
            e(0x7f1007e9).setVisibility(0);
            if (obj != null && ((com.picsart.shop.m) (obj)).isAdded() && !((com.picsart.shop.m) (obj)).isRemoving())
            {
                fragmenttransaction.show(((android.app.Fragment) (obj)));
                ((com.picsart.shop.m) (obj)).a((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)intent.getParcelableExtra("selectedShopItem"));
            } else
            {
                obj = new com.picsart.shop.m();
                ((com.picsart.shop.m) (obj)).setArguments(bundle1);
                fragmenttransaction.add(0x7f1007e9, ((android.app.Fragment) (obj)), "shopItemFragment");
            }
            fragmenttransaction.commitAllowingStateLoss();
            obj.b = c1;
        }
        r = false;
        a = bundle.getInt("selectedCategory");
        i1 = bundle.getInt("categoryFavorite", -1);
        G = bundle.getInt("categoryMyClipart", -1);
        F = bundle.getBoolean("fromComment");
        if (c != null) goto _L6; else goto _L5
_L5:
        if (G != a) goto _L8; else goto _L7
_L7:
        r = true;
        R = I;
        S = H;
        obj = H;
        c1 = E;
        obj = new File(((String) (obj)));
        if (((File) (obj)).exists())
        {
            i1 = ((File) (obj)).listFiles(new b(c1)).length;
        } else
        {
            i1 = 0;
        }
        T = i1;
        b = null;
_L6:
        c1 = (GridView)e(0x7f1007e8);
        c1.setVisibility(0);
        if (!g)
        {
            c1.setVisibility(8);
            return;
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (i1 == a)
        {
            r = true;
            R = Q;
            S = P;
            int j1 = com.socialin.android.photo.f.b(Q, V, F);
            b = (int[][])Array.newInstance(Integer.TYPE, new int[] {
                j1, 2
            });
            j1 = 0;
            while (j1 < b.length) 
            {
                b[j1][0] = -256;
                b[j1][1] = 0;
                j1++;
            }
        } else
        if (G == -1)
        {
            b = e.c[a];
        }
        if (true) goto _L6; else goto _L9
_L9:
        if (intent.getStringExtra("bgColor") != null)
        {
            c1.setBackgroundColor(Color.parseColor(intent.getStringExtra("bgColor")));
        } else
        {
            c1.setBackgroundColor(Color.parseColor("#333333"));
        }
        if (c != null) goto _L11; else goto _L10
_L10:
        if (b == null) goto _L13; else goto _L12
_L12:
        int k1;
        if (a == G)
        {
            k = new myobfuscated.cb.d(p, 0x7f030064);
        } else
        {
            k = new myobfuscated.cb.d(p, 0x7f030063);
        }
        c1.setChoiceMode(0);
        k1 = 0;
        while (k1 < b.length) 
        {
            myobfuscated.cb.c c2 = new myobfuscated.cb.c();
            int l1 = b[k1][0];
            if (l1 != -256)
            {
                c2.b = l1;
            } else
            if (r)
            {
                intent = myobfuscated.f.m.a(p, k1, S, F, V);
                if (intent != null && (new File(intent)).exists())
                {
                    c2.h = intent;
                    intent = com.socialin.android.photo.f.d(p, intent, V);
                } else
                {
                    intent = myobfuscated.f.m.b(p, k1, R, F, V);
                    intent = com.socialin.android.photo.f.c(p, intent, V);
                }
                c2.g = intent;
            } else
            {
                c2.c = com.socialin.android.photo.clipart.e.b(a, k1);
            }
            k.a(c2);
            k1++;
        }
        f(-1);
_L15:
        c1.setVisibility(0);
        c1.setAdapter(k);
        if (G == a)
        {
            b();
        }
        p.invalidateOptionsMenu();
        c1.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private c a;

            public final void onItemClick(AdapterView adapterview, View view, int i2, long l2)
            {
                a.a(i2);
            }

            
            {
                a = c.this;
                super();
            }
        });
        return;
_L13:
        if (k != null)
        {
            k.b.clear();
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L11:
        c1.setChoiceMode(0);
        q = com.picsart.shop.a.a(p.getApplicationContext()).a(p, c, 1);
        k = new myobfuscated.cb.d(p, 0x7f030063);
        intent = q.iterator();
        while (intent.hasNext()) 
        {
            myobfuscated.cb.c c3 = (myobfuscated.cb.c)intent.next();
            k.a(c3);
        }
        if (true) goto _L15; else goto _L14
_L14:
    }

    protected final int d(int i1)
    {
        if (r)
        {
            return T;
        } else
        {
            return e.c[i1].length;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        p = getActivity();
        p.registerReceiver(x, new IntentFilter("picsart.clipart.uploaded.action"));
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0301a9, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (k != null)
        {
            com.socialin.android.util.c.b(k.a);
        }
        getActivity().unregisterReceiver(x);
    }

}
