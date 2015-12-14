// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import ab;
import ad;
import ae;
import am;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import az;
import bb;
import c;
import cz;
import dc;
import ed;
import ee;
import ef;
import f;
import g;
import h;
import i;
import j;
import k;
import m;
import r;
import t;
import w;
import y;

// Referenced classes of package android.support.v7.app:
//            ActionBarActivity, ActionBar

public class ActionBarActivityDelegateBase extends c
    implements bb
{

    private boolean A;
    private az B;
    private Rect C;
    private Rect D;
    public ee g;
    public ActionBarContextView h;
    public PopupWindow i;
    public Runnable j;
    private cz k;
    private j l;
    private m m;
    private boolean n;
    private ViewGroup o;
    private ViewGroup p;
    private View q;
    private CharSequence r;
    private boolean s;
    private boolean t;
    private boolean u;
    private PanelFeatureState v[];
    private PanelFeatureState w;
    private boolean x;
    private int y;
    private final Runnable z = new f(this);

    public ActionBarActivityDelegateBase(ActionBarActivity actionbaractivity)
    {
        super(actionbaractivity);
    }

    public static int a(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        return actionbaractivitydelegatebase.y;
    }

    private PanelFeatureState a(int i1, boolean flag)
    {
        PanelFeatureState apanelfeaturestate[];
label0:
        {
            PanelFeatureState apanelfeaturestate1[] = v;
            if (apanelfeaturestate1 != null)
            {
                apanelfeaturestate = apanelfeaturestate1;
                if (apanelfeaturestate1.length > i1)
                {
                    break label0;
                }
            }
            apanelfeaturestate = new PanelFeatureState[i1 + 1];
            if (apanelfeaturestate1 != null)
            {
                System.arraycopy(apanelfeaturestate1, 0, apanelfeaturestate, 0, apanelfeaturestate1.length);
            }
            v = apanelfeaturestate;
        }
        PanelFeatureState panelfeaturestate = apanelfeaturestate[i1];
        if (panelfeaturestate == null)
        {
            panelfeaturestate = new PanelFeatureState(i1);
            apanelfeaturestate[i1] = panelfeaturestate;
            return panelfeaturestate;
        } else
        {
            return panelfeaturestate;
        }
    }

    public static PanelFeatureState a(ActionBarActivityDelegateBase actionbaractivitydelegatebase, Menu menu)
    {
        return actionbaractivitydelegatebase.a(menu);
    }

    private PanelFeatureState a(Menu menu)
    {
        PanelFeatureState apanelfeaturestate[] = v;
        int i1;
        int j1;
        if (apanelfeaturestate != null)
        {
            i1 = apanelfeaturestate.length;
        } else
        {
            i1 = 0;
        }
        for (j1 = 0; j1 < i1; j1++)
        {
            PanelFeatureState panelfeaturestate = apanelfeaturestate[j1];
            if (panelfeaturestate != null && panelfeaturestate.d == menu)
            {
                return panelfeaturestate;
            }
        }

        return null;
    }

    private void a(int i1, PanelFeatureState panelfeaturestate, Menu menu)
    {
        PanelFeatureState panelfeaturestate2 = panelfeaturestate;
        Object obj = menu;
        if (menu == null)
        {
            PanelFeatureState panelfeaturestate1 = panelfeaturestate;
            if (panelfeaturestate == null)
            {
                panelfeaturestate1 = panelfeaturestate;
                if (i1 >= 0)
                {
                    panelfeaturestate1 = panelfeaturestate;
                    if (i1 < v.length)
                    {
                        panelfeaturestate1 = v[i1];
                    }
                }
            }
            panelfeaturestate2 = panelfeaturestate1;
            obj = menu;
            if (panelfeaturestate1 != null)
            {
                obj = panelfeaturestate1.d;
                panelfeaturestate2 = panelfeaturestate1;
            }
        }
        if (panelfeaturestate2 != null && !panelfeaturestate2.i)
        {
            return;
        } else
        {
            m().b(i1, ((Menu) (obj)));
            return;
        }
    }

    private void a(PanelFeatureState panelfeaturestate)
    {
        panelfeaturestate.b = o;
        panelfeaturestate.a(l());
    }

    private void a(PanelFeatureState panelfeaturestate, KeyEvent keyevent)
    {
        if (!panelfeaturestate.i && !o()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (panelfeaturestate.a != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = a;
        boolean flag;
        boolean flag1;
        if ((((Context) (obj)).getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((Context) (obj)).getApplicationInfo().targetSdkVersion >= 11)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1) goto _L1; else goto _L3
_L3:
        obj = m();
        if (obj != null && !((ad) (obj)).c(panelfeaturestate.a, panelfeaturestate.d))
        {
            a(panelfeaturestate, true);
            return;
        }
        if (b(panelfeaturestate, keyevent))
        {
            if (panelfeaturestate.b == null || panelfeaturestate.k)
            {
                a(panelfeaturestate);
            }
            if (c(panelfeaturestate) && panelfeaturestate.a())
            {
                panelfeaturestate.h = false;
                panelfeaturestate.i = true;
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(PanelFeatureState panelfeaturestate, boolean flag)
    {
        if (flag && panelfeaturestate.a == 0 && k != null && k.isOverflowMenuShowing())
        {
            b(panelfeaturestate.d);
        } else
        {
            if (panelfeaturestate.i && flag)
            {
                a(panelfeaturestate.a, panelfeaturestate, ((Menu) (null)));
            }
            panelfeaturestate.g = false;
            panelfeaturestate.h = false;
            panelfeaturestate.i = false;
            panelfeaturestate.c = null;
            panelfeaturestate.k = true;
            if (w == panelfeaturestate)
            {
                w = null;
                return;
            }
        }
    }

    public static void a(ActionBarActivityDelegateBase actionbaractivitydelegatebase, int i1)
    {
        actionbaractivitydelegatebase.d(i1);
    }

    public static void a(ActionBarActivityDelegateBase actionbaractivitydelegatebase, int i1, PanelFeatureState panelfeaturestate, Menu menu)
    {
        actionbaractivitydelegatebase.a(i1, panelfeaturestate, menu);
    }

    public static void a(ActionBarActivityDelegateBase actionbaractivitydelegatebase, PanelFeatureState panelfeaturestate, boolean flag)
    {
        actionbaractivitydelegatebase.a(panelfeaturestate, flag);
    }

    public static void a(ActionBarActivityDelegateBase actionbaractivitydelegatebase, MenuBuilder menubuilder)
    {
        actionbaractivitydelegatebase.b(menubuilder);
    }

    private void a(MenuBuilder menubuilder, boolean flag)
    {
        if (k == null || !k.canShowOverflowMenu() || ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(a)) && !k.isOverflowMenuShowPending())
        {
            break MISSING_BLOCK_LABEL_211;
        }
        menubuilder = m();
        if (k.isOverflowMenuShowing() && flag) goto _L2; else goto _L1
_L1:
        if (menubuilder != null && !o())
        {
            if (x && (y & 1) != 0)
            {
                o.removeCallbacks(z);
                z.run();
            }
            PanelFeatureState panelfeaturestate = a(0, true);
            if (panelfeaturestate.d != null && !panelfeaturestate.l && menubuilder.a(0, null, panelfeaturestate.d))
            {
                menubuilder.c(8, panelfeaturestate.d);
                k.showOverflowMenu();
            }
        }
_L4:
        return;
_L2:
        k.hideOverflowMenu();
        if (o()) goto _L4; else goto _L3
_L3:
        menubuilder = a(0, true);
        a.onPanelClosed(8, ((PanelFeatureState) (menubuilder)).d);
        return;
        menubuilder = a(0, true);
        menubuilder.k = true;
        a(((PanelFeatureState) (menubuilder)), false);
        a(((PanelFeatureState) (menubuilder)), ((KeyEvent) (null)));
        return;
    }

    public static boolean a(ActionBarActivityDelegateBase actionbaractivitydelegatebase, boolean flag)
    {
        actionbaractivitydelegatebase.x = flag;
        return flag;
    }

    public static int b(ActionBarActivityDelegateBase actionbaractivitydelegatebase, int i1)
    {
        actionbaractivitydelegatebase.y = i1;
        return i1;
    }

    private void b(MenuBuilder menubuilder)
    {
        if (u)
        {
            return;
        }
        u = true;
        k.dismissPopups();
        ad ad1 = m();
        if (ad1 != null && !o())
        {
            ad1.b(8, menubuilder);
        }
        u = false;
    }

    private boolean b(PanelFeatureState panelfeaturestate)
    {
        ActionBarActivity actionbaractivity = a;
        if (panelfeaturestate.a != 0 && panelfeaturestate.a != 8 || k == null) goto _L2; else goto _L1
_L1:
        Object obj;
        TypedValue typedvalue = new TypedValue();
        android.content.res.Resources.Theme theme1 = actionbaractivity.getTheme();
        theme1.resolveAttribute(r.actionBarTheme, typedvalue, true);
        obj = null;
        android.content.res.Resources.Theme theme;
        if (typedvalue.resourceId != 0)
        {
            obj = actionbaractivity.getResources().newTheme();
            ((android.content.res.Resources.Theme) (obj)).setTo(theme1);
            ((android.content.res.Resources.Theme) (obj)).applyStyle(typedvalue.resourceId, true);
            ((android.content.res.Resources.Theme) (obj)).resolveAttribute(r.actionBarWidgetTheme, typedvalue, true);
        } else
        {
            theme1.resolveAttribute(r.actionBarWidgetTheme, typedvalue, true);
        }
        theme = ((android.content.res.Resources.Theme) (obj));
        if (typedvalue.resourceId != 0)
        {
            theme = ((android.content.res.Resources.Theme) (obj));
            if (obj == null)
            {
                theme = actionbaractivity.getResources().newTheme();
                theme.setTo(theme1);
            }
            theme.applyStyle(typedvalue.resourceId, true);
        }
        if (theme == null) goto _L2; else goto _L3
_L3:
        obj = new ContextThemeWrapper(actionbaractivity, 0);
        ((Context) (obj)).getTheme().setTo(theme);
_L5:
        obj = new MenuBuilder(((Context) (obj)));
        ((MenuBuilder) (obj)).a(this);
        panelfeaturestate.a(((MenuBuilder) (obj)));
        return true;
_L2:
        obj = actionbaractivity;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private boolean b(PanelFeatureState panelfeaturestate, KeyEvent keyevent)
    {
        if (!o()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1;
        if (panelfeaturestate.g)
        {
            return true;
        }
        if (w != null && w != panelfeaturestate)
        {
            a(w, false);
        }
        if (panelfeaturestate.a == 0 || panelfeaturestate.a == 8)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 && k != null)
        {
            k.setMenuPrepared();
        }
        if (panelfeaturestate.d != null && !panelfeaturestate.l)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        if (panelfeaturestate.d == null && (!b(panelfeaturestate) || panelfeaturestate.d == null))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i1 && k != null)
        {
            if (l == null)
            {
                l = new j(this, null);
            }
            k.setMenu(panelfeaturestate.d, l);
        }
        panelfeaturestate.d.g();
        if (m().a(panelfeaturestate.a, panelfeaturestate.d))
        {
            break; /* Loop/switch isn't completed */
        }
        panelfeaturestate.a(null);
        if (i1 && k != null)
        {
            k.setMenu(null, l);
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        panelfeaturestate.l = false;
        panelfeaturestate.d.g();
        if (panelfeaturestate.m != null)
        {
            panelfeaturestate.d.b(panelfeaturestate.m);
            panelfeaturestate.m = null;
        }
        if (!m().a(0, null, panelfeaturestate.d))
        {
            if (i1 && k != null)
            {
                k.setMenu(null, l);
            }
            panelfeaturestate.d.h();
            return false;
        }
        boolean flag;
        if (keyevent != null)
        {
            i1 = keyevent.getDeviceId();
        } else
        {
            i1 = -1;
        }
        if (KeyCharacterMap.load(i1).getKeyboardType() != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        panelfeaturestate.j = flag;
        panelfeaturestate.d.setQwertyMode(panelfeaturestate.j);
        panelfeaturestate.d.h();
        panelfeaturestate.g = true;
        panelfeaturestate.h = false;
        w = panelfeaturestate;
        return true;
    }

    public static int c(ActionBarActivityDelegateBase actionbaractivitydelegatebase, int i1)
    {
        return actionbaractivitydelegatebase.e(i1);
    }

    private void c(int i1)
    {
        y = y | 1 << i1;
        if (!x && o != null)
        {
            ViewCompat.postOnAnimation(o, z);
            x = true;
        }
    }

    private boolean c(PanelFeatureState panelfeaturestate)
    {
        if (panelfeaturestate.d == null)
        {
            return false;
        }
        if (m == null)
        {
            m = new m(this, null);
        }
        panelfeaturestate.c = (View)panelfeaturestate.a(m);
        boolean flag;
        if (panelfeaturestate.c != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private void d(int i1)
    {
        PanelFeatureState panelfeaturestate = a(i1, true);
        if (panelfeaturestate.d != null)
        {
            Bundle bundle = new Bundle();
            panelfeaturestate.d.a(bundle);
            if (bundle.size() > 0)
            {
                panelfeaturestate.m = bundle;
            }
            panelfeaturestate.d.g();
            panelfeaturestate.d.clear();
        }
        panelfeaturestate.l = true;
        panelfeaturestate.k = true;
        if ((i1 == 8 || i1 == 0) && k != null)
        {
            PanelFeatureState panelfeaturestate1 = a(0, false);
            if (panelfeaturestate1 != null)
            {
                panelfeaturestate1.g = false;
                b(panelfeaturestate1, ((KeyEvent) (null)));
            }
        }
    }

    private int e(int i1)
    {
        int k1 = 1;
        boolean flag = true;
        boolean flag1 = false;
        int j1;
        if (h != null && (h.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
        {
            Object obj = (android.view.ViewGroup.MarginLayoutParams)h.getLayoutParams();
            if (h.isShown())
            {
                if (C == null)
                {
                    C = new Rect();
                    D = new Rect();
                }
                Rect rect = C;
                Rect rect1 = D;
                rect.set(0, i1, 0, 0);
                ed.a(p, rect, rect1);
                if (rect1.top == 0)
                {
                    j1 = i1;
                } else
                {
                    j1 = 0;
                }
                if (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin != j1)
                {
                    obj.topMargin = i1;
                    if (q == null)
                    {
                        q = new View(a);
                        q.setBackgroundColor(a.getResources().getColor(t.abc_input_method_navigation_guard));
                        p.addView(q, -1, new android.view.ViewGroup.LayoutParams(-1, i1));
                        j1 = 1;
                    } else
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = q.getLayoutParams();
                        if (layoutparams.height != i1)
                        {
                            layoutparams.height = i1;
                            q.setLayoutParams(layoutparams);
                        }
                        j1 = 1;
                    }
                } else
                {
                    j1 = 0;
                }
                if (q == null)
                {
                    flag = false;
                }
                k1 = i1;
                if (!d)
                {
                    k1 = i1;
                    if (flag)
                    {
                        k1 = 0;
                    }
                }
                i1 = k1;
                k1 = j1;
                j1 = ((flag) ? 1 : 0);
            } else
            if (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin != 0)
            {
                obj.topMargin = 0;
                j1 = 0;
            } else
            {
                k1 = 0;
                j1 = 0;
            }
            if (k1 != 0)
            {
                h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }
        } else
        {
            j1 = 0;
        }
        if (q != null)
        {
            obj = q;
            if (j1 != 0)
            {
                j1 = ((flag1) ? 1 : 0);
            } else
            {
                j1 = 8;
            }
            ((View) (obj)).setVisibility(j1);
        }
        return i1;
    }

    private void r()
    {
        TypedValue typedvalue3 = null;
        DisplayMetrics displaymetrics = null;
        TypedArray typedarray = a.obtainStyledAttributes(ab.Theme);
        TypedValue typedvalue;
        if (typedarray.hasValue(ab.Theme_windowFixedWidthMajor))
        {
            TypedValue typedvalue1;
            TypedValue typedvalue2;
            int i1;
            int j1;
            if (true)
            {
                typedvalue = new TypedValue();
            } else
            {
                typedvalue = null;
            }
            typedarray.getValue(ab.Theme_windowFixedWidthMajor, typedvalue);
        } else
        {
            typedvalue = null;
        }
        if (typedarray.hasValue(ab.Theme_windowFixedWidthMinor))
        {
            if (true)
            {
                typedvalue1 = new TypedValue();
            } else
            {
                typedvalue1 = null;
            }
            typedarray.getValue(ab.Theme_windowFixedWidthMinor, typedvalue1);
        } else
        {
            typedvalue1 = null;
        }
        if (typedarray.hasValue(ab.Theme_windowFixedHeightMajor))
        {
            if (true)
            {
                typedvalue2 = new TypedValue();
            } else
            {
                typedvalue2 = null;
            }
            typedarray.getValue(ab.Theme_windowFixedHeightMajor, typedvalue2);
        } else
        {
            typedvalue2 = null;
        }
        if (typedarray.hasValue(ab.Theme_windowFixedHeightMinor))
        {
            typedvalue3 = displaymetrics;
            if (true)
            {
                typedvalue3 = new TypedValue();
            }
            typedarray.getValue(ab.Theme_windowFixedHeightMinor, typedvalue3);
        }
        displaymetrics = a.getResources().getDisplayMetrics();
        if (displaymetrics.widthPixels < displaymetrics.heightPixels)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 == 0)
        {
            typedvalue1 = typedvalue;
        }
        if (typedvalue1 == null || typedvalue1.type == 0) goto _L2; else goto _L1
_L1:
        if (typedvalue1.type != 5) goto _L4; else goto _L3
_L3:
        i1 = (int)typedvalue1.getDimension(displaymetrics);
_L11:
        if (j1 == 0)
        {
            typedvalue2 = typedvalue3;
        }
        if (typedvalue2 == null || typedvalue2.type == 0) goto _L6; else goto _L5
_L5:
        if (typedvalue2.type != 5) goto _L8; else goto _L7
_L7:
        j1 = (int)typedvalue2.getDimension(displaymetrics);
_L9:
        if (i1 != -1 || j1 != -1)
        {
            a.getWindow().setLayout(i1, j1);
        }
        typedarray.recycle();
        return;
_L4:
        if (typedvalue1.type != 6)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = (int)typedvalue1.getFraction(displaymetrics.widthPixels, displaymetrics.widthPixels);
        continue; /* Loop/switch isn't completed */
_L8:
        if (typedvalue2.type == 6)
        {
            j1 = (int)typedvalue2.getFraction(displaymetrics.heightPixels, displaymetrics.heightPixels);
            continue; /* Loop/switch isn't completed */
        }
_L6:
        j1 = -1;
        if (true) goto _L9; else goto _L2
_L2:
        i1 = -1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public ActionBar a()
    {
        p();
        ae ae1 = new ae(a, c);
        ae1.c(A);
        return ae1;
    }

    View a(String s1, Context context, AttributeSet attributeset)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 5: default 64
    //                   -1455429095: 166
    //                   -339785223: 118
    //                   776382189: 150
    //                   1601505219: 134
    //                   1666676343: 102;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        byte0;
        JVM INSTR tableswitch 0 4: default 100
    //                   0 182
    //                   1 192
    //                   2 202
    //                   3 212
    //                   4 222;
           goto _L2 _L9 _L10 _L11 _L12 _L13
_L2:
        return null;
_L8:
        if (s1.equals("EditText"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (s1.equals("Spinner"))
        {
            byte0 = 1;
        }
          goto _L3
_L7:
        if (s1.equals("CheckBox"))
        {
            byte0 = 2;
        }
          goto _L3
_L6:
        if (s1.equals("RadioButton"))
        {
            byte0 = 3;
        }
          goto _L3
_L4:
        if (s1.equals("CheckedTextView"))
        {
            byte0 = 4;
        }
          goto _L3
_L9:
        return new TintEditText(context, attributeset);
_L10:
        return new TintSpinner(context, attributeset);
_L11:
        return new TintCheckBox(context, attributeset);
_L12:
        return new TintRadioButton(context, attributeset);
_L13:
        return new TintCheckedTextView(context, attributeset);
    }

    ee a(ef ef1)
    {
        if (g != null)
        {
            g.c();
        }
        Object obj = new k(this, ef1);
        Context context = l();
        if (h == null)
        {
            if (e)
            {
                h = new ActionBarContextView(context);
                i = new PopupWindow(context, null, r.actionModePopupWindowStyle);
                i.setContentView(h);
                i.setWidth(-1);
                TypedValue typedvalue = new TypedValue();
                a.getTheme().resolveAttribute(r.actionBarSize, typedvalue, true);
                int i1 = TypedValue.complexToDimensionPixelSize(typedvalue.data, a.getResources().getDisplayMetrics());
                h.setContentHeight(i1);
                i.setHeight(-2);
                j = new i(this);
            } else
            {
                ViewStubCompat viewstubcompat = (ViewStubCompat)a.findViewById(w.action_mode_bar_stub);
                if (viewstubcompat != null)
                {
                    viewstubcompat.setLayoutInflater(LayoutInflater.from(context));
                    h = (ActionBarContextView)viewstubcompat.inflate();
                }
            }
        }
        if (h != null)
        {
            h.killMode();
            ActionBarContextView actionbarcontextview = h;
            boolean flag;
            if (i == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new am(context, actionbarcontextview, ((ef) (obj)), flag);
            if (ef1.a(((ee) (obj)), ((ee) (obj)).b()))
            {
                ((ee) (obj)).d();
                h.initForMode(((ee) (obj)));
                h.setVisibility(0);
                g = ((ee) (obj));
                if (i != null)
                {
                    a.getWindow().getDecorView().post(j);
                }
                h.sendAccessibilityEvent(32);
                if (h.getParent() != null)
                {
                    ViewCompat.requestApplyInsets((View)h.getParent());
                }
            } else
            {
                g = null;
            }
        }
        if (g != null && a != null)
        {
            a.a(g);
        }
        return g;
    }

    public void a(int i1)
    {
        p();
        ViewGroup viewgroup = (ViewGroup)a.findViewById(0x1020002);
        viewgroup.removeAllViews();
        a.getLayoutInflater().inflate(i1, viewgroup);
        a.c();
    }

    public void a(int i1, Menu menu)
    {
        PanelFeatureState panelfeaturestate = a(i1, false);
        if (panelfeaturestate != null)
        {
            a(panelfeaturestate, false);
        }
        if (i1 == 8)
        {
            menu = b();
            if (menu != null)
            {
                menu.e(false);
            }
        } else
        if (!o())
        {
            a.b(i1, menu);
            return;
        }
    }

    public void a(Configuration configuration)
    {
        if (b && n)
        {
            ActionBar actionbar = b();
            if (actionbar != null)
            {
                actionbar.a(configuration);
            }
        }
    }

    void a(Bundle bundle)
    {
label0:
        {
            super.a(bundle);
            o = (ViewGroup)a.getWindow().getDecorView();
            if (NavUtils.getParentActivityName(a) != null)
            {
                bundle = c();
                if (bundle != null)
                {
                    break label0;
                }
                A = true;
            }
            return;
        }
        bundle.c(true);
    }

    public void a(MenuBuilder menubuilder)
    {
        a(menubuilder, true);
    }

    public void a(View view)
    {
        p();
        ViewGroup viewgroup = (ViewGroup)a.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view);
        a.c();
    }

    public void a(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        p();
        ViewGroup viewgroup = (ViewGroup)a.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view, layoutparams);
        a.c();
    }

    public void a(CharSequence charsequence)
    {
        if (k != null)
        {
            k.setWindowTitle(charsequence);
            return;
        }
        if (b() != null)
        {
            b().a(charsequence);
            return;
        } else
        {
            r = charsequence;
            return;
        }
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        return b(i1, keyevent);
    }

    public boolean a(int i1, View view, Menu menu)
    {
        if (i1 != 0)
        {
            return m().a(i1, view, menu);
        } else
        {
            return false;
        }
    }

    final boolean a(PanelFeatureState panelfeaturestate, int i1, KeyEvent keyevent, int j1)
    {
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = false;
        if (!keyevent.isSystem()) goto _L2; else goto _L1
_L1:
        flag2 = flag;
_L4:
        return flag2;
_L2:
        boolean flag1;
label0:
        {
            if (!panelfeaturestate.g)
            {
                flag1 = flag2;
                if (!b(panelfeaturestate, keyevent))
                {
                    break label0;
                }
            }
            flag1 = flag2;
            if (panelfeaturestate.d != null)
            {
                flag1 = panelfeaturestate.d.performShortcut(i1, keyevent, j1);
            }
        }
        flag2 = flag1;
        if (flag1)
        {
            flag2 = flag1;
            if ((j1 & 1) == 0)
            {
                flag2 = flag1;
                if (k == null)
                {
                    a(panelfeaturestate, true);
                    return flag1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a(MenuBuilder menubuilder, MenuItem menuitem)
    {
        ad ad1 = m();
        if (ad1 != null && !o())
        {
            menubuilder = a(((Menu) (menubuilder.p())));
            if (menubuilder != null)
            {
                return ad1.a(((PanelFeatureState) (menubuilder)).a, menuitem);
            }
        }
        return false;
    }

    public View b(int i1)
    {
        if (g == null)
        {
            Object obj = m();
            View view;
            if (obj != null)
            {
                obj = ((ad) (obj)).a(i1);
            } else
            {
                obj = null;
            }
            view = ((View) (obj));
            if (obj == null)
            {
                view = ((View) (obj));
                if (B == null)
                {
                    PanelFeatureState panelfeaturestate = a(i1, true);
                    a(panelfeaturestate, ((KeyEvent) (null)));
                    view = ((View) (obj));
                    if (panelfeaturestate.i)
                    {
                        view = panelfeaturestate.c;
                    }
                }
            }
            return view;
        } else
        {
            return null;
        }
    }

    public ee b(ef ef1)
    {
        if (ef1 == null)
        {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (g != null)
        {
            g.c();
        }
        ef1 = new k(this, ef1);
        ActionBar actionbar = b();
        if (actionbar != null)
        {
            g = actionbar.a(ef1);
            if (g != null)
            {
                a.a(g);
            }
        }
        if (g == null)
        {
            g = a(ef1);
        }
        return g;
    }

    public void b(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        p();
        ((ViewGroup)a.findViewById(0x1020002)).addView(view, layoutparams);
        a.c();
    }

    boolean b(int i1, KeyEvent keyevent)
    {
        if (w == null || !a(w, keyevent.getKeyCode(), keyevent, 1)) goto _L2; else goto _L1
_L1:
        if (w != null)
        {
            w.h = true;
        }
_L4:
        return true;
_L2:
        boolean flag;
        if (w != null)
        {
            break; /* Loop/switch isn't completed */
        }
        PanelFeatureState panelfeaturestate = a(0, true);
        b(panelfeaturestate, keyevent);
        flag = a(panelfeaturestate, keyevent.getKeyCode(), keyevent, 1);
        panelfeaturestate.g = false;
        if (flag) goto _L4; else goto _L3
_L3:
        return false;
    }

    boolean b(int i1, Menu menu)
    {
        if (i1 == 8)
        {
            menu = b();
            if (menu != null)
            {
                menu.e(true);
            }
            return true;
        } else
        {
            return a.c(i1, menu);
        }
    }

    public boolean c(int i1, Menu menu)
    {
        if (i1 != 0)
        {
            return m().a(i1, menu);
        } else
        {
            return false;
        }
    }

    public void e()
    {
        ActionBar actionbar = b();
        if (actionbar != null)
        {
            actionbar.d(false);
        }
    }

    public void f()
    {
        ActionBar actionbar = b();
        if (actionbar != null)
        {
            actionbar.d(true);
        }
    }

    public void g()
    {
        ActionBar actionbar = b();
        if (actionbar != null && actionbar.c())
        {
            return;
        } else
        {
            c(0);
            return;
        }
    }

    public boolean h()
    {
        if (g != null)
        {
            g.c();
        } else
        {
            ActionBar actionbar = b();
            if (actionbar == null || !actionbar.d())
            {
                return false;
            }
        }
        return true;
    }

    int j()
    {
        return r.homeAsUpIndicator;
    }

    public void k()
    {
    }

    final void p()
    {
        if (!n)
        {
            if (b)
            {
                Object obj = new TypedValue();
                a.getTheme().resolveAttribute(r.actionBarTheme, ((TypedValue) (obj)), true);
                if (((TypedValue) (obj)).resourceId != 0)
                {
                    obj = new ContextThemeWrapper(a, ((TypedValue) (obj)).resourceId);
                } else
                {
                    obj = a;
                }
                p = (ViewGroup)LayoutInflater.from(((Context) (obj))).inflate(y.abc_screen_toolbar, null);
                k = (cz)p.findViewById(w.decor_content_parent);
                k.setWindowCallback(m());
                if (c)
                {
                    k.initFeature(9);
                }
                if (s)
                {
                    k.initFeature(2);
                }
                if (t)
                {
                    k.initFeature(5);
                }
            } else
            {
                if (d)
                {
                    p = (ViewGroup)LayoutInflater.from(a).inflate(y.abc_screen_simple_overlay_action_mode, null);
                } else
                {
                    p = (ViewGroup)LayoutInflater.from(a).inflate(y.abc_screen_simple, null);
                }
                if (android.os.Build.VERSION.SDK_INT >= 21)
                {
                    ViewCompat.setOnApplyWindowInsetsListener(p, new g(this));
                } else
                {
                    ((dc)p).setOnFitSystemWindowsListener(new h(this));
                }
            }
            ed.b(p);
            a.a(p);
            obj = a.findViewById(0x1020002);
            ((View) (obj)).setId(-1);
            a.findViewById(w.action_bar_activity_content).setId(0x1020002);
            if (obj instanceof FrameLayout)
            {
                ((FrameLayout)obj).setForeground(null);
            }
            if (r != null && k != null)
            {
                k.setWindowTitle(r);
                r = null;
            }
            r();
            q();
            n = true;
            obj = a(0, false);
            if (!o() && (obj == null || ((PanelFeatureState) (obj)).d == null))
            {
                c(8);
            }
        }
    }

    public void q()
    {
    }

    private class PanelFeatureState
    {

        public int a;
        ViewGroup b;
        View c;
        MenuBuilder d;
        az e;
        Context f;
        boolean g;
        boolean h;
        boolean i;
        public boolean j;
        boolean k;
        boolean l;
        Bundle m;

        bq a(bp bp)
        {
            if (d == null)
            {
                return null;
            }
            if (e == null)
            {
                e = new az(f, y.abc_list_menu_item_layout);
                e.a(bp);
                d.a(e);
            }
            return e.a(b);
        }

        void a(Context context)
        {
            TypedValue typedvalue = new TypedValue();
            android.content.res.Resources.Theme theme = context.getResources().newTheme();
            theme.setTo(context.getTheme());
            theme.resolveAttribute(r.actionBarPopupTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            }
            theme.resolveAttribute(r.panelMenuListTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            } else
            {
                theme.applyStyle(aa.Theme_AppCompat_CompactMenu, true);
            }
            context = new ContextThemeWrapper(context, 0);
            context.getTheme().setTo(theme);
            f = context;
        }

        void a(MenuBuilder menubuilder)
        {
            if (menubuilder != d)
            {
                if (d != null)
                {
                    d.b(e);
                }
                d = menubuilder;
                if (menubuilder != null && e != null)
                {
                    menubuilder.a(e);
                    return;
                }
            }
        }

        public boolean a()
        {
            while (c == null || e.a().getCount() <= 0) 
            {
                return false;
            }
            return true;
        }

        PanelFeatureState(int i1)
        {
            a = i1;
            k = false;
        }
    }

}
