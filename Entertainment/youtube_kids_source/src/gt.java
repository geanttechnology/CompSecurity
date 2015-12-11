// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class gt
    implements ci
{

    private static final int h[] = {
        1, 4, 5, 3, 2, 0
    };
    final Context a;
    ArrayList b;
    boolean c;
    public ArrayList d;
    boolean e;
    CopyOnWriteArrayList f;
    gv g;
    private final Resources i;
    private boolean j;
    private boolean k;
    private ArrayList l;
    private ArrayList m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private ArrayList s;

    public gt(Context context)
    {
        boolean flag = true;
        super();
        n = 0;
        o = false;
        p = false;
        q = false;
        r = false;
        s = new ArrayList();
        f = new CopyOnWriteArrayList();
        a = context;
        i = context.getResources();
        b = new ArrayList();
        l = new ArrayList();
        c = true;
        d = new ArrayList();
        m = new ArrayList();
        e = true;
        if (i.getConfiguration().keyboard == 1 || !i.getBoolean(0x7f120003))
        {
            flag = false;
        }
        k = flag;
    }

    private static int a(ArrayList arraylist, int i1)
    {
        for (int j1 = arraylist.size() - 1; j1 >= 0; j1--)
        {
            if (((gv)arraylist.get(j1)).a <= i1)
            {
                return j1 + 1;
            }
        }

        return 0;
    }

    private MenuItem a(int i1, int j1, int k1, CharSequence charsequence)
    {
        int l1;
label0:
        {
            l1 = k1 >> 16;
            if (l1 >= 0)
            {
                int ai[] = h;
                if (l1 < 6)
                {
                    break label0;
                }
            }
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        l1 = h[l1] << 16 | 0xffff & k1;
        charsequence = new gv(this, i1, j1, k1, l1, charsequence, 0);
        b.add(a(b, l1), charsequence);
        b(true);
        return charsequence;
    }

    private gv a(int i1, KeyEvent keyevent)
    {
        ArrayList arraylist;
        arraylist = s;
        arraylist.clear();
        a(((List) (arraylist)), i1, keyevent);
        if (!arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        keyevent = null;
_L6:
        return keyevent;
_L2:
        android.view.KeyCharacterMap.KeyData keydata;
        int j1;
        int k1;
        int l1;
        boolean flag;
        k1 = keyevent.getMetaState();
        keydata = new android.view.KeyCharacterMap.KeyData();
        keyevent.getKeyData(keydata);
        l1 = arraylist.size();
        if (l1 == 1)
        {
            return (gv)arraylist.get(0);
        }
        flag = a();
        j1 = 0;
_L9:
        if (j1 >= l1) goto _L4; else goto _L3
_L3:
        gv gv1 = (gv)arraylist.get(j1);
        char c1;
        if (flag)
        {
            c1 = gv1.getAlphabeticShortcut();
        } else
        {
            c1 = gv1.getNumericShortcut();
        }
        if (c1 != keydata.meta[0])
        {
            break; /* Loop/switch isn't completed */
        }
        keyevent = gv1;
        if ((k1 & 2) == 0) goto _L6; else goto _L5
_L5:
        if (c1 != keydata.meta[2])
        {
            break; /* Loop/switch isn't completed */
        }
        keyevent = gv1;
        if ((k1 & 2) != 0) goto _L6; else goto _L7
_L7:
        if (!flag || c1 != '\b')
        {
            continue; /* Loop/switch isn't completed */
        }
        keyevent = gv1;
        if (i1 == 67) goto _L6; else goto _L8
_L8:
        j1++;
          goto _L9
_L4:
        return null;
    }

    private void a(int i1, boolean flag)
    {
        if (i1 >= 0 && i1 < b.size())
        {
            b.remove(i1);
            if (flag)
            {
                b(true);
                return;
            }
        }
    }

    private void a(List list, int i1, KeyEvent keyevent)
    {
        boolean flag = a();
        int k1 = keyevent.getMetaState();
        android.view.KeyCharacterMap.KeyData keydata = new android.view.KeyCharacterMap.KeyData();
        if (keyevent.getKeyData(keydata) || i1 == 67)
        {
            int l1 = b.size();
            int j1 = 0;
            while (j1 < l1) 
            {
                gv gv1 = (gv)b.get(j1);
                if (gv1.hasSubMenu())
                {
                    ((gt)gv1.getSubMenu()).a(list, i1, keyevent);
                }
                char c1;
                if (flag)
                {
                    c1 = gv1.getAlphabeticShortcut();
                } else
                {
                    c1 = gv1.getNumericShortcut();
                }
                if ((k1 & 5) == 0 && c1 != 0 && (c1 == keydata.meta[0] || c1 == keydata.meta[2] || flag && c1 == '\b' && i1 == 67) && gv1.isEnabled())
                {
                    list.add(gv1);
                }
                j1++;
            }
        }
    }

    private void h()
    {
        if (!o)
        {
            o = true;
            p = false;
        }
    }

    private void i()
    {
        o = false;
        if (p)
        {
            p = false;
            b(true);
        }
    }

    protected final gt a(Drawable drawable)
    {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected final gt a(CharSequence charsequence)
    {
        a(0, charsequence, 0, null, null);
        return this;
    }

    void a(int i1, CharSequence charsequence, int j1, Drawable drawable, View view)
    {
        charsequence = i;
        b(false);
    }

    public final void a(boolean flag)
    {
        if (r)
        {
            return;
        }
        r = true;
        for (Iterator iterator = f.iterator(); iterator.hasNext();)
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            gy gy1 = (gy)weakreference.get();
            if (gy1 == null)
            {
                f.remove(weakreference);
            } else
            {
                gy1.a(this, flag);
            }
        }

        r = false;
    }

    boolean a()
    {
        return j;
    }

    public final boolean a(MenuItem menuitem, int i1)
    {
        boolean flag;
        flag = false;
        menuitem = (gv)menuitem;
        if (menuitem != null && menuitem.isEnabled()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        boolean flag1;
        flag1 = menuitem.a();
        if (false)
        {
            throw new NullPointerException();
        }
        if (!menuitem.h())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = menuitem.expandActionView() | flag1;
        flag = flag1;
        if (flag1)
        {
            a(true);
            return flag1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (menuitem.hasSubMenu() || false)
        {
            a(false);
            if (!menuitem.hasSubMenu())
            {
                menuitem.a(new hb(a, this, menuitem));
            }
            menuitem = (hb)menuitem.getSubMenu();
            if (false)
            {
                throw new NullPointerException();
            }
            if (!f.isEmpty())
            {
                if (false)
                {
                    throw new NullPointerException();
                }
                Iterator iterator = f.iterator();
                flag = false;
                while (iterator.hasNext()) 
                {
                    WeakReference weakreference = (WeakReference)iterator.next();
                    gy gy1 = (gy)weakreference.get();
                    if (gy1 == null)
                    {
                        f.remove(weakreference);
                    } else
                    if (!flag)
                    {
                        flag = gy1.a(menuitem);
                    }
                }
            }
            flag1 |= flag;
            flag = flag1;
            if (!flag1)
            {
                a(true);
                return flag1;
            }
        } else
        {
            if ((i1 & 1) == 0)
            {
                a(true);
            }
            return flag1;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    boolean a(gt gt1, MenuItem menuitem)
    {
        return false;
    }

    public boolean a(gv gv1)
    {
        boolean flag1 = false;
        if (!f.isEmpty())
        {
            h();
            Iterator iterator = f.iterator();
            boolean flag = false;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                WeakReference weakreference = (WeakReference)iterator.next();
                gy gy1 = (gy)weakreference.get();
                if (gy1 == null)
                {
                    f.remove(weakreference);
                    continue;
                }
                flag1 = gy1.a(gv1);
                flag = flag1;
                if (flag1)
                {
                    break;
                }
                flag = flag1;
            } while (true);
            i();
            flag1 = flag;
            if (flag)
            {
                g = gv1;
                return flag;
            }
        }
        return flag1;
    }

    public MenuItem add(int i1)
    {
        return a(0, 0, 0, i.getString(i1));
    }

    public MenuItem add(int i1, int j1, int k1, int l1)
    {
        return a(i1, j1, k1, i.getString(l1));
    }

    public MenuItem add(int i1, int j1, int k1, CharSequence charsequence)
    {
        return a(i1, j1, k1, charsequence);
    }

    public MenuItem add(CharSequence charsequence)
    {
        return a(0, 0, 0, charsequence);
    }

    public int addIntentOptions(int i1, int j1, int k1, ComponentName componentname, Intent aintent[], Intent intent, int l1, 
            MenuItem amenuitem[])
    {
        PackageManager packagemanager = a.getPackageManager();
        List list = packagemanager.queryIntentActivityOptions(componentname, aintent, intent, 0);
        int i2;
        if (list != null)
        {
            i2 = list.size();
        } else
        {
            i2 = 0;
        }
        if ((l1 & 1) == 0)
        {
            removeGroup(i1);
        }
        l1 = 0;
        while (l1 < i2) 
        {
            ResolveInfo resolveinfo = (ResolveInfo)list.get(l1);
            if (resolveinfo.specificIndex < 0)
            {
                componentname = intent;
            } else
            {
                componentname = aintent[resolveinfo.specificIndex];
            }
            componentname = new Intent(componentname);
            componentname.setComponent(new ComponentName(resolveinfo.activityInfo.applicationInfo.packageName, resolveinfo.activityInfo.name));
            componentname = add(i1, j1, k1, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setIntent(componentname);
            if (amenuitem != null && resolveinfo.specificIndex >= 0)
            {
                amenuitem[resolveinfo.specificIndex] = componentname;
            }
            l1++;
        }
        return i2;
    }

    public SubMenu addSubMenu(int i1)
    {
        return addSubMenu(0, 0, 0, ((CharSequence) (i.getString(i1))));
    }

    public SubMenu addSubMenu(int i1, int j1, int k1, int l1)
    {
        return addSubMenu(i1, j1, k1, ((CharSequence) (i.getString(l1))));
    }

    public SubMenu addSubMenu(int i1, int j1, int k1, CharSequence charsequence)
    {
        charsequence = (gv)a(i1, j1, k1, charsequence);
        hb hb1 = new hb(a, this, charsequence);
        charsequence.a(hb1);
        return hb1;
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return addSubMenu(0, 0, 0, charsequence);
    }

    public final void b(boolean flag)
    {
        if (!o)
        {
            if (flag)
            {
                c = true;
                e = true;
            }
            if (!f.isEmpty())
            {
                h();
                for (Iterator iterator = f.iterator(); iterator.hasNext();)
                {
                    WeakReference weakreference = (WeakReference)iterator.next();
                    gy gy1 = (gy)weakreference.get();
                    if (gy1 == null)
                    {
                        f.remove(weakreference);
                    } else
                    {
                        gy1.a(flag);
                    }
                }

                i();
            }
            return;
        } else
        {
            p = true;
            return;
        }
    }

    public boolean b()
    {
        return k;
    }

    public boolean b(gv gv1)
    {
        boolean flag = false;
        boolean flag2 = flag;
        if (!f.isEmpty())
        {
            if (g != gv1)
            {
                flag2 = flag;
            } else
            {
                h();
                Iterator iterator = f.iterator();
                boolean flag1 = false;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    WeakReference weakreference = (WeakReference)iterator.next();
                    gy gy1 = (gy)weakreference.get();
                    if (gy1 == null)
                    {
                        f.remove(weakreference);
                        continue;
                    }
                    flag2 = gy1.b(gv1);
                    flag1 = flag2;
                    if (flag2)
                    {
                        break;
                    }
                    flag1 = flag2;
                } while (true);
                i();
                flag2 = flag1;
                if (flag1)
                {
                    g = null;
                    return flag1;
                }
            }
        }
        return flag2;
    }

    final void c()
    {
        e = true;
        b(true);
    }

    public void clear()
    {
        if (g != null)
        {
            b(g);
        }
        b.clear();
        b(true);
    }

    public void clearHeader()
    {
        b(false);
    }

    public void close()
    {
        a(true);
    }

    public final ArrayList d()
    {
        if (!c)
        {
            return l;
        }
        l.clear();
        int j1 = b.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            gv gv1 = (gv)b.get(i1);
            if (gv1.isVisible())
            {
                l.add(gv1);
            }
        }

        c = false;
        e = true;
        return l;
    }

    public final void e()
    {
        ArrayList arraylist = d();
        if (!e)
        {
            return;
        }
        Iterator iterator = f.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            gy gy1 = (gy)weakreference.get();
            if (gy1 == null)
            {
                f.remove(weakreference);
            } else
            {
                flag = gy1.a() | flag;
            }
        }
        if (flag)
        {
            d.clear();
            m.clear();
            int j1 = arraylist.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                gv gv1 = (gv)arraylist.get(i1);
                if (gv1.e())
                {
                    d.add(gv1);
                } else
                {
                    m.add(gv1);
                }
                i1++;
            }
        } else
        {
            d.clear();
            m.clear();
            m.addAll(d());
        }
        e = false;
    }

    public final ArrayList f()
    {
        e();
        return m;
    }

    public MenuItem findItem(int i1)
    {
        int j1;
        int k1;
        k1 = size();
        j1 = 0;
_L6:
        if (j1 >= k1) goto _L2; else goto _L1
_L1:
        Object obj = (gv)b.get(j1);
        if (((gv) (obj)).getItemId() != i1) goto _L4; else goto _L3
_L3:
        return ((MenuItem) (obj));
_L4:
        MenuItem menuitem;
        if (!((gv) (obj)).hasSubMenu())
        {
            continue; /* Loop/switch isn't completed */
        }
        menuitem = ((gv) (obj)).getSubMenu().findItem(i1);
        obj = menuitem;
        if (menuitem != null) goto _L3; else goto _L5
_L5:
        j1++;
          goto _L6
_L2:
        return null;
    }

    public gt g()
    {
        return this;
    }

    public MenuItem getItem(int i1)
    {
        return (MenuItem)b.get(i1);
    }

    public boolean hasVisibleItems()
    {
        int j1 = size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((gv)b.get(i1)).isVisible())
            {
                return true;
            }
        }

        return false;
    }

    public boolean isShortcutKey(int i1, KeyEvent keyevent)
    {
        return a(i1, keyevent) != null;
    }

    public boolean performIdentifierAction(int i1, int j1)
    {
        return a(findItem(i1), j1);
    }

    public boolean performShortcut(int i1, KeyEvent keyevent, int j1)
    {
        keyevent = a(i1, keyevent);
        boolean flag = false;
        if (keyevent != null)
        {
            flag = a(keyevent, j1);
        }
        if ((j1 & 2) != 0)
        {
            a(true);
        }
        return flag;
    }

    public void removeGroup(int i1)
    {
        int j1;
        int k1;
        k1 = size();
        j1 = 0;
_L7:
        if (j1 >= k1) goto _L2; else goto _L1
_L1:
        if (((gv)b.get(j1)).getGroupId() != i1) goto _L4; else goto _L3
_L3:
        if (j1 < 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        int i2 = b.size();
        for (int l1 = 0; l1 < i2 - j1 && ((gv)b.get(j1)).getGroupId() == i1; l1++)
        {
            a(j1, false);
        }

        break; /* Loop/switch isn't completed */
_L4:
        j1++;
        continue; /* Loop/switch isn't completed */
_L2:
        j1 = -1;
        if (true) goto _L3; else goto _L5
_L5:
        b(true);
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void removeItem(int i1)
    {
        int j1;
        int k1;
        k1 = size();
        j1 = 0;
_L3:
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (((gv)b.get(j1)).getItemId() != i1) goto _L2; else goto _L1
_L1:
        a(j1, true);
        return;
_L2:
        j1++;
          goto _L3
        j1 = -1;
          goto _L1
    }

    public void setGroupCheckable(int i1, boolean flag, boolean flag1)
    {
        int k1 = b.size();
        int j1 = 0;
        while (j1 < k1) 
        {
            gv gv1 = (gv)b.get(j1);
            if (gv1.getGroupId() == i1)
            {
                int l1 = gv1.c;
                byte byte0;
                if (flag1)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                gv1.c = byte0 | l1 & -5;
                gv1.setCheckable(flag);
            }
            j1++;
        }
    }

    public void setGroupEnabled(int i1, boolean flag)
    {
        int k1 = b.size();
        for (int j1 = 0; j1 < k1; j1++)
        {
            gv gv1 = (gv)b.get(j1);
            if (gv1.getGroupId() == i1)
            {
                gv1.setEnabled(flag);
            }
        }

    }

    public void setGroupVisible(int i1, boolean flag)
    {
        int k1 = b.size();
        int j1 = 0;
        boolean flag1 = false;
        for (; j1 < k1; j1++)
        {
            gv gv1 = (gv)b.get(j1);
            if (gv1.getGroupId() == i1 && gv1.b(flag))
            {
                flag1 = true;
            }
        }

        if (flag1)
        {
            b(true);
        }
    }

    public void setQwertyMode(boolean flag)
    {
        j = flag;
        b(false);
    }

    public int size()
    {
        return b.size();
    }

}
