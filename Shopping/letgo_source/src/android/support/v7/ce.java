// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.view.d;
import android.support.v4.view.r;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.support.v7:
//            af

public class ce extends MenuInflater
{
    private static class a
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        private static final Class a[] = {
            android/view/MenuItem
        };
        private Object b;
        private Method c;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            try
            {
                if (c.getReturnType() == Boolean.TYPE)
                {
                    return ((Boolean)c.invoke(b, new Object[] {
                        menuitem
                    })).booleanValue();
                }
                c.invoke(b, new Object[] {
                    menuitem
                });
            }
            // Misplaced declaration of an exception variable
            catch (MenuItem menuitem)
            {
                throw new RuntimeException(menuitem);
            }
            return true;
        }


        public a(Object obj, String s)
        {
            b = obj;
            Class class1 = obj.getClass();
            try
            {
                c = class1.getMethod(s, a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                s = new InflateException((new StringBuilder()).append("Couldn't resolve menu item onClick handler ").append(s).append(" in class ").append(class1.getName()).toString());
            }
            s.initCause(((Throwable) (obj)));
            throw s;
        }
    }

    private class b
    {

        final ce a;
        private Menu b;
        private int c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;
        private CharSequence l;
        private CharSequence m;
        private int n;
        private char o;
        private char p;
        private int q;
        private boolean r;
        private boolean s;
        private boolean t;
        private int u;
        private int v;
        private String w;
        private String x;
        private String y;
        private d z;

        private char a(String s1)
        {
            if (s1 == null)
            {
                return '\0';
            } else
            {
                return s1.charAt(0);
            }
        }

        static d a(b b1)
        {
            return b1.z;
        }

        private Object a(String s1, Class aclass[], Object aobj[])
        {
            try
            {
                aclass = ((Class []) (ce.a(a).getClassLoader().loadClass(s1).getConstructor(aclass).newInstance(aobj)));
            }
            // Misplaced declaration of an exception variable
            catch (Class aclass[])
            {
                Log.w("SupportMenuInflater", (new StringBuilder()).append("Cannot instantiate class: ").append(s1).toString(), aclass);
                return null;
            }
            return aclass;
        }

        private void a(MenuItem menuitem)
        {
            boolean flag = true;
            Object obj = menuitem.setChecked(r).setVisible(s).setEnabled(t);
            boolean flag1;
            if (q >= 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((MenuItem) (obj)).setCheckable(flag1).setTitleCondensed(m).setIcon(n).setAlphabeticShortcut(o).setNumericShortcut(p);
            if (u >= 0)
            {
                android.support.v4.view.r.a(menuitem, u);
            }
            if (y != null)
            {
                if (ce.a(a).isRestricted())
                {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuitem.setOnMenuItemClickListener(new a(ce.c(a), y));
            }
            if (menuitem instanceof h)
            {
                obj = (h)menuitem;
            }
            if (q >= 2)
            {
                if (menuitem instanceof h)
                {
                    ((h)menuitem).a(true);
                } else
                if (menuitem instanceof i)
                {
                    ((i)menuitem).a(true);
                }
            }
            if (w != null)
            {
                android.support.v4.view.r.a(menuitem, (View)a(w, ce.b(), android.support.v7.ce.d(a)));
            } else
            {
                flag = false;
            }
            if (v > 0)
            {
                if (!flag)
                {
                    android.support.v4.view.r.b(menuitem, v);
                } else
                {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (z != null)
            {
                android.support.v4.view.r.a(menuitem, z);
            }
        }

        public void a()
        {
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = true;
            h = true;
        }

        public void a(AttributeSet attributeset)
        {
            attributeset = ce.a(a).obtainStyledAttributes(attributeset, br.k.MenuGroup);
            c = attributeset.getResourceId(br.k.MenuGroup_android_id, 0);
            d = attributeset.getInt(br.k.MenuGroup_android_menuCategory, 0);
            e = attributeset.getInt(br.k.MenuGroup_android_orderInCategory, 0);
            f = attributeset.getInt(br.k.MenuGroup_android_checkableBehavior, 0);
            g = attributeset.getBoolean(br.k.MenuGroup_android_visible, true);
            h = attributeset.getBoolean(br.k.MenuGroup_android_enabled, true);
            attributeset.recycle();
        }

        public void b()
        {
            i = true;
            a(b.add(c, j, k, l));
        }

        public void b(AttributeSet attributeset)
        {
            boolean flag = true;
            attributeset = ce.a(a).obtainStyledAttributes(attributeset, android.support.v7.br.k.MenuItem);
            j = attributeset.getResourceId(br.k.MenuItem_android_id, 0);
            k = attributeset.getInt(br.k.MenuItem_android_menuCategory, d) & 0xffff0000 | attributeset.getInt(br.k.MenuItem_android_orderInCategory, e) & 0xffff;
            l = attributeset.getText(br.k.MenuItem_android_title);
            m = attributeset.getText(br.k.MenuItem_android_titleCondensed);
            n = attributeset.getResourceId(br.k.MenuItem_android_icon, 0);
            o = a(attributeset.getString(br.k.MenuItem_android_alphabeticShortcut));
            p = a(attributeset.getString(br.k.MenuItem_android_numericShortcut));
            int i1;
            if (attributeset.hasValue(br.k.MenuItem_android_checkable))
            {
                if (attributeset.getBoolean(br.k.MenuItem_android_checkable, false))
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                q = i1;
            } else
            {
                q = f;
            }
            r = attributeset.getBoolean(br.k.MenuItem_android_checked, false);
            s = attributeset.getBoolean(br.k.MenuItem_android_visible, g);
            t = attributeset.getBoolean(br.k.MenuItem_android_enabled, h);
            u = attributeset.getInt(br.k.MenuItem_showAsAction, -1);
            y = attributeset.getString(br.k.MenuItem_android_onClick);
            v = attributeset.getResourceId(br.k.MenuItem_actionLayout, 0);
            w = attributeset.getString(br.k.MenuItem_actionViewClass);
            x = attributeset.getString(br.k.MenuItem_actionProviderClass);
            if (x != null)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            if (i1 != 0 && v == 0 && w == null)
            {
                z = (d)a(x, ce.a(), ce.b(a));
            } else
            {
                if (i1 != 0)
                {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                z = null;
            }
            attributeset.recycle();
            i = false;
        }

        public SubMenu c()
        {
            i = true;
            SubMenu submenu = b.addSubMenu(c, j, k, l);
            a(submenu.getItem());
            return submenu;
        }

        public boolean d()
        {
            return i;
        }

        public b(Menu menu)
        {
            a = ce.this;
            super();
            b = menu;
            a();
        }
    }


    private static final Class a[] = {
        android/content/Context
    };
    private static final Class b[] = a;
    private final Object c[];
    private final Object d[];
    private Context e;
    private Object f;

    public ce(Context context)
    {
        super(context);
        e = context;
        c = (new Object[] {
            context
        });
        d = c;
    }

    static Context a(ce ce1)
    {
        return ce1.e;
    }

    private Object a(Object obj)
    {
        while ((obj instanceof Activity) || !(obj instanceof ContextWrapper)) 
        {
            return obj;
        }
        return a(((ContextWrapper)obj).getBaseContext());
    }

    private void a(XmlPullParser xmlpullparser, AttributeSet attributeset, Menu menu)
        throws XmlPullParserException, IOException
    {
        b b1;
        int i;
        b1 = new b(menu);
        i = xmlpullparser.getEventType();
_L12:
        if (i != 2) goto _L2; else goto _L1
_L1:
        menu = xmlpullparser.getName();
        if (!menu.equals("menu")) goto _L4; else goto _L3
_L3:
        i = xmlpullparser.next();
_L13:
        int j;
        int k;
        menu = null;
        boolean flag = false;
        k = i;
        j = 0;
        i = ((flag) ? 1 : 0);
_L10:
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        k;
        JVM INSTR tableswitch 1 3: default 100
    //                   1 368
    //                   2 163
    //                   3 250;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
_L14:
        k = xmlpullparser.next();
        if (true) goto _L10; else goto _L9
_L4:
        throw new RuntimeException((new StringBuilder()).append("Expecting menu, got ").append(menu).toString());
_L2:
        j = xmlpullparser.next();
        i = j;
        if (j != 1) goto _L12; else goto _L11
_L11:
        i = j;
          goto _L13
_L9:
        if (i == 0)
        {
            String s = xmlpullparser.getName();
            if (s.equals("group"))
            {
                b1.a(attributeset);
            } else
            if (s.equals("item"))
            {
                b1.b(attributeset);
            } else
            if (s.equals("menu"))
            {
                a(xmlpullparser, attributeset, ((Menu) (b1.c())));
            } else
            {
                menu = s;
                i = 1;
            }
        }
          goto _L14
_L8:
        String s1 = xmlpullparser.getName();
        if (i != 0 && s1.equals(menu))
        {
            menu = null;
            i = 0;
        } else
        if (s1.equals("group"))
        {
            b1.a();
        } else
        if (s1.equals("item"))
        {
            if (!b1.d())
            {
                if (b.a(b1) != null && b.a(b1).hasSubMenu())
                {
                    b1.c();
                } else
                {
                    b1.b();
                }
            }
        } else
        if (s1.equals("menu"))
        {
            j = 1;
        }
          goto _L14
_L6:
        throw new RuntimeException("Unexpected end of document");
          goto _L13
    }

    static Class[] a()
    {
        return b;
    }

    static Class[] b()
    {
        return a;
    }

    static Object[] b(ce ce1)
    {
        return ce1.d;
    }

    private Object c()
    {
        if (f == null)
        {
            f = a(e);
        }
        return f;
    }

    static Object c(ce ce1)
    {
        return ce1.c();
    }

    static Object[] d(ce ce1)
    {
        return ce1.c;
    }

    public void inflate(int i, Menu menu)
    {
        if (menu instanceof af) goto _L2; else goto _L1
_L1:
        super.inflate(i, menu);
_L4:
        return;
_L2:
        XmlResourceParser xmlresourceparser;
        XmlResourceParser xmlresourceparser1;
        XmlResourceParser xmlresourceparser2;
        xmlresourceparser = null;
        xmlresourceparser2 = null;
        xmlresourceparser1 = null;
        XmlResourceParser xmlresourceparser3 = e.getResources().getLayout(i);
        xmlresourceparser1 = xmlresourceparser3;
        xmlresourceparser = xmlresourceparser3;
        xmlresourceparser2 = xmlresourceparser3;
        a(xmlresourceparser3, Xml.asAttributeSet(xmlresourceparser3), menu);
        if (xmlresourceparser3 != null)
        {
            xmlresourceparser3.close();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        menu;
        xmlresourceparser = xmlresourceparser1;
        throw new InflateException("Error inflating menu XML", menu);
        menu;
        if (xmlresourceparser != null)
        {
            xmlresourceparser.close();
        }
        throw menu;
        menu;
        xmlresourceparser = xmlresourceparser2;
        throw new InflateException("Error inflating menu XML", menu);
    }

}
