// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package android.support.v4.app:
//            aw, at, au, av, 
//            ay, ax

final class as
{

    public static Object a(Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = ((Transition)obj).clone();
        }
        return obj1;
    }

    public static Object a(Object obj, View view, ArrayList arraylist, Map map)
    {
label0:
        {
            Object obj1 = obj;
            if (obj != null)
            {
                a(arraylist, view);
                if (map != null)
                {
                    arraylist.removeAll(map.values());
                }
                if (!arraylist.isEmpty())
                {
                    break label0;
                }
                obj1 = null;
            }
            return obj1;
        }
        b((Transition)obj, arraylist);
        return obj;
    }

    public static Object a(Object obj, Object obj1, Object obj2, boolean flag)
    {
        Transition transition = (Transition)obj;
        obj = (Transition)obj1;
        obj2 = (Transition)obj2;
        if (transition == null || obj == null)
        {
            flag = true;
        }
        if (flag)
        {
            obj1 = new TransitionSet();
            if (transition != null)
            {
                ((TransitionSet) (obj1)).addTransition(transition);
            }
            if (obj != null)
            {
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj)));
            }
            if (obj2 != null)
            {
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj2)));
            }
            return obj1;
        }
        obj1 = null;
        if (obj != null && transition != null)
        {
            obj = (new TransitionSet()).addTransition(((Transition) (obj))).addTransition(transition).setOrdering(1);
        } else
        if (obj == null)
        {
            obj = obj1;
            if (transition != null)
            {
                obj = transition;
            }
        }
        if (obj2 != null)
        {
            obj1 = new TransitionSet();
            if (obj != null)
            {
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj)));
            }
            ((TransitionSet) (obj1)).addTransition(((Transition) (obj2)));
            return obj1;
        } else
        {
            return obj;
        }
    }

    public static String a(View view)
    {
        return view.getTransitionName();
    }

    public static void a(View view, View view1, Object obj, ArrayList arraylist, Object obj1, ArrayList arraylist1, Object obj2, ArrayList arraylist2, 
            Object obj3, ArrayList arraylist3, Map map)
    {
        obj = (Transition)obj;
        obj1 = (Transition)obj1;
        obj2 = (Transition)obj2;
        obj3 = (Transition)obj3;
        if (obj3 != null)
        {
            view.getViewTreeObserver().addOnPreDrawListener(new aw(view, ((Transition) (obj)), view1, arraylist, ((Transition) (obj1)), arraylist1, ((Transition) (obj2)), arraylist2, map, arraylist3, ((Transition) (obj3))));
        }
    }

    public static void a(ViewGroup viewgroup, Object obj)
    {
        TransitionManager.beginDelayedTransition(viewgroup, (Transition)obj);
    }

    public static void a(Object obj, View view)
    {
        ((Transition)obj).setEpicenterCallback(new at(b(view)));
    }

    public static void a(Object obj, View view, boolean flag)
    {
        ((Transition)obj).excludeTarget(view, flag);
    }

    public static void a(Object obj, Object obj1, View view, ay ay, View view1, ax ax, Map map, ArrayList arraylist, 
            Map map1, ArrayList arraylist1)
    {
        if (obj != null || obj1 != null)
        {
            obj = (Transition)obj;
            if (obj != null)
            {
                ((Transition) (obj)).addTarget(view1);
            }
            if (obj1 != null)
            {
                b((Transition)obj1, arraylist1);
            }
            view.getViewTreeObserver().addOnPreDrawListener(new au(view, ay, map, map1, ((Transition) (obj)), arraylist));
            if (obj != null)
            {
                ((Transition) (obj)).setEpicenterCallback(new av(ax));
            }
        }
    }

    public static void a(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((Transition) (obj)).removeTarget((View)arraylist.get(i));
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

    static Rect b(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        rect.set(ai[0], ai[1], ai[0] + view.getWidth(), ai[1] + view.getHeight());
        return rect;
    }

    public static void b(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            ((Transition) (obj)).addTarget((View)arraylist.get(i));
        }

    }
}
