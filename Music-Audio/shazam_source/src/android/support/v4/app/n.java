// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class n
{
    public static final class a
    {

        public View a;

        public a()
        {
        }
    }

    public static interface b
    {

        public abstract View a();
    }


    static Rect a(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        rect.set(ai[0], ai[1], ai[0] + view.getWidth(), ai[1] + view.getHeight());
        return rect;
    }

    public static Object a(Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = ((Transition)obj).clone();
        }
        return obj1;
    }

    public static void a(Object obj, View view)
    {
        ((Transition)obj).setEpicenterCallback(new android.transition.Transition.EpicenterCallback(a(view)) {

            final Rect a;

            public final Rect onGetEpicenter(Transition transition)
            {
                return a;
            }

            
            {
                a = rect;
                super();
            }
        });
    }

    public static void a(Object obj, View view, boolean flag)
    {
        ((Transition)obj).excludeTarget(view, flag);
    }

    public static void a(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        if (obj instanceof TransitionSet)
        {
            obj = (TransitionSet)obj;
            int k = ((TransitionSet) (obj)).getTransitionCount();
            for (int i = 0; i < k; i++)
            {
                a(((TransitionSet) (obj)).getTransitionAt(i), arraylist);
            }

        } else
        if (!a(((Transition) (obj))))
        {
            List list = ((Transition) (obj)).getTargets();
            if (list != null && list.size() == arraylist.size() && list.containsAll(arraylist))
            {
                for (int j = arraylist.size() - 1; j >= 0; j--)
                {
                    ((Transition) (obj)).removeTarget((View)arraylist.get(j));
                }

            }
        }
    }

    static void a(ArrayList arraylist, View view)
    {
label0:
        {
            if (view.getVisibility() == 0)
            {
                if (!(view instanceof ViewGroup))
                {
                    break label0;
                }
                view = (ViewGroup)view;
                if (view.isTransitionGroup())
                {
                    arraylist.add(view);
                } else
                {
                    int j = view.getChildCount();
                    int i = 0;
                    while (i < j) 
                    {
                        a(arraylist, view.getChildAt(i));
                        i++;
                    }
                }
            }
            return;
        }
        arraylist.add(view);
    }

    public static void a(Map map, View view)
    {
        if (view.getVisibility() == 0)
        {
            String s = view.getTransitionName();
            if (s != null)
            {
                map.put(s, view);
            }
            if (view instanceof ViewGroup)
            {
                view = (ViewGroup)view;
                int j = view.getChildCount();
                for (int i = 0; i < j; i++)
                {
                    a(map, view.getChildAt(i));
                }

            }
        }
    }

    private static boolean a(Transition transition)
    {
        return !a(transition.getTargetIds()) || !a(transition.getTargetNames()) || !a(transition.getTargetTypes());
    }

    private static boolean a(List list)
    {
        return list == null || list.isEmpty();
    }

    public static void b(Object obj, ArrayList arraylist)
    {
        int i = 0;
        obj = (Transition)obj;
        if (obj instanceof TransitionSet)
        {
            obj = (TransitionSet)obj;
            for (int k = ((TransitionSet) (obj)).getTransitionCount(); i < k; i++)
            {
                b(((TransitionSet) (obj)).getTransitionAt(i), arraylist);
            }

        } else
        if (!a(((Transition) (obj))) && a(((Transition) (obj)).getTargets()))
        {
            int l = arraylist.size();
            for (int j = 0; j < l; j++)
            {
                ((Transition) (obj)).addTarget((View)arraylist.get(j));
            }

        }
    }

    // Unreferenced inner class android/support/v4/app/n$2

/* anonymous class */
    static final class _cls2
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final View a;
        final b b;
        final Map c;
        final Map d;
        final Transition e;
        final ArrayList f;
        final View g;

        public final boolean onPreDraw()
        {
            a.getViewTreeObserver().removeOnPreDrawListener(this);
            View view = b.a();
            if (view != null)
            {
                if (!c.isEmpty())
                {
                    n.a(d, view);
                    d.keySet().retainAll(c.values());
                    Iterator iterator = c.entrySet().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                        Object obj = (String)entry.getValue();
                        obj = (View)d.get(obj);
                        if (obj != null)
                        {
                            ((View) (obj)).setTransitionName((String)entry.getKey());
                        }
                    } while (true);
                }
                if (e != null)
                {
                    n.a(f, view);
                    f.removeAll(d.values());
                    f.add(g);
                    e.removeTarget(g);
                    n.b(e, f);
                }
            }
            return true;
        }

            
            {
                a = view;
                b = b1;
                c = map;
                d = map1;
                e = transition;
                f = arraylist;
                g = view1;
                super();
            }
    }


    // Unreferenced inner class android/support/v4/app/n$3

/* anonymous class */
    static final class _cls3 extends android.transition.Transition.EpicenterCallback
    {

        final a a;
        private Rect b;

        public final Rect onGetEpicenter(Transition transition)
        {
            if (b == null && a.a != null)
            {
                b = n.a(a.a);
            }
            return b;
        }

            
            {
                a = a1;
                super();
            }
    }


    // Unreferenced inner class android/support/v4/app/n$4

/* anonymous class */
    static final class _cls4
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final View a;
        final Transition b;
        final View c;
        final ArrayList d;
        final Transition e;
        final ArrayList f;
        final Transition g;
        final ArrayList h;
        final Map i;
        final ArrayList j;
        final Transition k;

        public final boolean onPreDraw()
        {
            a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (b != null)
            {
                b.removeTarget(c);
                n.a(b, d);
            }
            if (e != null)
            {
                n.a(e, f);
            }
            if (g != null)
            {
                n.a(g, h);
            }
            java.util.Map.Entry entry;
            for (Iterator iterator = i.entrySet().iterator(); iterator.hasNext(); ((View)entry.getValue()).setTransitionName((String)entry.getKey()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            int i1 = j.size();
            for (int l = 0; l < i1; l++)
            {
                k.excludeTarget((View)j.get(l), false);
            }

            k.excludeTarget(c, false);
            return true;
        }

            
            {
                a = view;
                b = transition;
                c = view1;
                d = arraylist;
                e = transition1;
                f = arraylist1;
                g = transition2;
                h = arraylist2;
                i = map;
                j = arraylist3;
                k = transition3;
                super();
            }
    }

}
