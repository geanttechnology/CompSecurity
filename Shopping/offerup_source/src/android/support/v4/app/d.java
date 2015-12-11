// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.RemoteInput;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v4.app:
//            cb, e, ab, ao, 
//            ap, aq, cw, cy, 
//            aa, at, as

public class d
{

    private cy a;

    public d()
    {
    }

    public d(cy cy1)
    {
        this();
        a = cy1;
    }

    private static android.app.Notification.Action a(cb cb1)
    {
        android.app.Notification.Action.Builder builder = (new android.app.Notification.Action.Builder(cb1.a(), cb1.b(), cb1.c())).addExtras(cb1.d());
        cb1 = cb1.e();
        if (cb1 != null)
        {
            cb1 = a(((cw []) (cb1)));
            int j = cb1.length;
            for (int i = 0; i < j; i++)
            {
                builder.addRemoteInput(cb1[i]);
            }

        }
        return builder.build();
    }

    private static SharedElementCallback a(d d1)
    {
        e e1 = null;
        if (d1 != null)
        {
            e1 = new e(d1);
        }
        return e1;
    }

    static Rect a(View view)
    {
        return b(view);
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

    public static Object a(Object obj, View view, ArrayList arraylist, Map map, View view1)
    {
label0:
        {
            Object obj1 = obj;
            if (obj != null)
            {
                b(arraylist, view);
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
        arraylist.add(view1);
        b((Transition)obj, arraylist);
        return obj;
    }

    public static ArrayList a(cb acb[])
    {
        if (acb != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = null;
_L4:
        return arraylist;
_L2:
        ArrayList arraylist1 = new ArrayList(acb.length);
        int j = acb.length;
        int i = 0;
        do
        {
            arraylist = arraylist1;
            if (i >= j)
            {
                continue;
            }
            arraylist1.add(a(acb[i]));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(Activity activity, d d1)
    {
        activity.setEnterSharedElementCallback(a(d1));
    }

    public static void a(android.app.Notification.Builder builder, cb cb1)
    {
        android.app.Notification.Action.Builder builder1 = new android.app.Notification.Action.Builder(cb1.a(), cb1.b(), cb1.c());
        if (cb1.e() != null)
        {
            RemoteInput aremoteinput[] = a(cb1.e());
            int j = aremoteinput.length;
            for (int i = 0; i < j; i++)
            {
                builder1.addRemoteInput(aremoteinput[i]);
            }

        }
        if (cb1.d() != null)
        {
            builder1.addExtras(cb1.d());
        }
        builder.addAction(builder1.build());
    }

    public static void a(aa aa)
    {
        if (aa instanceof ab)
        {
            if (((ab) (aa = (ab)aa)).d != null)
            {
                Collections.sort(((ab) (aa)).d, Collections.reverseOrder());
                return;
            }
        }
    }

    public static void a(Object obj, View view)
    {
        ((Transition)obj).setEpicenterCallback(new ao(b(view)));
    }

    public static void a(Object obj, View view, Map map, ArrayList arraylist)
    {
        obj = (TransitionSet)obj;
        arraylist.clear();
        arraylist.addAll(map.values());
        map = ((TransitionSet) (obj)).getTargets();
        map.clear();
        int i1 = arraylist.size();
        for (int i = 0; i < i1; i++)
        {
            View view1 = (View)arraylist.get(i);
            int l = map.size();
            if (a(((List) (map)), view1, l))
            {
                continue;
            }
            map.add(view1);
            for (int j = l; j < map.size(); j++)
            {
                Object obj1 = (View)map.get(j);
                if (!(obj1 instanceof ViewGroup))
                {
                    continue;
                }
                obj1 = (ViewGroup)obj1;
                int j1 = ((ViewGroup) (obj1)).getChildCount();
                for (int k = 0; k < j1; k++)
                {
                    View view2 = ((ViewGroup) (obj1)).getChildAt(k);
                    if (!a(((List) (map)), view2, l))
                    {
                        map.add(view2);
                    }
                }

            }

        }

        arraylist.add(view);
        b(obj, arraylist);
    }

    public static void a(Object obj, View view, boolean flag)
    {
        ((Transition)obj).excludeTarget(view, flag);
    }

    public static void a(Object obj, Object obj1, View view, at at, View view1, as as, Map map, ArrayList arraylist, 
            Map map1, Map map2, ArrayList arraylist1)
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
                a(obj1, view1, map1, arraylist1);
            }
            view.getViewTreeObserver().addOnPreDrawListener(new ap(view, ((Transition) (obj)), view1, at, map, map2, arraylist));
            if (obj != null)
            {
                ((Transition) (obj)).setEpicenterCallback(new aq(as));
            }
        }
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
        b(arraylist, view);
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

    private static boolean a(List list, View view, int i)
    {
        boolean flag1 = false;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < i)
                {
                    if (list.get(j) != view)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    static RemoteInput[] a(cw acw[])
    {
        if (acw == null)
        {
            return null;
        }
        RemoteInput aremoteinput[] = new RemoteInput[acw.length];
        for (int i = 0; i < acw.length; i++)
        {
            cw cw1 = acw[i];
            aremoteinput[i] = (new android.app.RemoteInput.Builder(cw1.a())).setLabel(cw1.b()).setChoices(cw1.c()).setAllowFreeFormInput(cw1.d()).addExtras(cw1.e()).build();
        }

        return aremoteinput;
    }

    private static Rect b(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        rect.set(ai[0], ai[1], ai[0] + view.getWidth(), ai[1] + view.getHeight());
        return rect;
    }

    public static void b(Activity activity, d d1)
    {
        activity.setExitSharedElementCallback(a(d1));
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

    private static void b(ArrayList arraylist, View view)
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
                        b(arraylist, view.getChildAt(i));
                        i++;
                    }
                }
            }
            return;
        }
        arraylist.add(view);
    }

    static Bundle[] b(cw acw[])
    {
        if (acw == null)
        {
            return null;
        }
        Bundle abundle[] = new Bundle[acw.length];
        for (int i = 0; i < acw.length; i++)
        {
            cw cw1 = acw[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", cw1.a());
            bundle.putCharSequence("label", cw1.b());
            bundle.putCharSequenceArray("choices", cw1.c());
            bundle.putBoolean("allowFreeFormInput", cw1.d());
            bundle.putBundle("extras", cw1.e());
            abundle[i] = bundle;
        }

        return abundle;
    }

    public Parcelable a(View view, Matrix matrix, RectF rectf)
    {
        return a.a(view, matrix, rectf);
    }

    public View a(Context context, Parcelable parcelable)
    {
        return cy.a(context, parcelable);
    }
}
