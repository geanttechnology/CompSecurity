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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FragmentTransitionCompat21
{

    FragmentTransitionCompat21()
    {
    }

    public static void addTargets(Object obj, ArrayList arraylist)
    {
        int i = 0;
        obj = (Transition)obj;
        if (obj instanceof TransitionSet)
        {
            obj = (TransitionSet)obj;
            for (int k = ((TransitionSet) (obj)).getTransitionCount(); i < k; i++)
            {
                addTargets(((TransitionSet) (obj)).getTransitionAt(i), arraylist);
            }

        } else
        if (!hasSimpleTarget(((Transition) (obj))) && isNullOrEmpty(((Transition) (obj)).getTargets()))
        {
            int l = arraylist.size();
            for (int j = 0; j < l; j++)
            {
                ((Transition) (obj)).addTarget((View)arraylist.get(j));
            }

        }
    }

    public static void addTransitionTargets(final Object enterTransition, Object obj, final View container, final ViewRetriever inFragment, final View nonExistentView, EpicenterView epicenterview, final Map nameOverrides, final ArrayList enteringViews, 
            Map map, final Map renamedViews, ArrayList arraylist)
    {
        if (enterTransition != null || obj != null)
        {
            enterTransition = (Transition)enterTransition;
            if (enterTransition != null)
            {
                ((Transition) (enterTransition)).addTarget(nonExistentView);
            }
            if (obj != null)
            {
                setSharedElementTargets(obj, nonExistentView, map, arraylist);
            }
            if (inFragment != null)
            {
                container.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                    final View val$container;
                    final Transition val$enterTransition;
                    final ArrayList val$enteringViews;
                    final ViewRetriever val$inFragment;
                    final Map val$nameOverrides;
                    final View val$nonExistentView;
                    final Map val$renamedViews;

                    public boolean onPreDraw()
                    {
                        container.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (enterTransition != null)
                        {
                            enterTransition.removeTarget(nonExistentView);
                        }
                        View view = inFragment.getView();
                        if (view != null)
                        {
                            if (!nameOverrides.isEmpty())
                            {
                                FragmentTransitionCompat21.findNamedViews(renamedViews, view);
                                renamedViews.keySet().retainAll(nameOverrides.values());
                                Iterator iterator = nameOverrides.entrySet().iterator();
                                do
                                {
                                    if (!iterator.hasNext())
                                    {
                                        break;
                                    }
                                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                                    Object obj1 = (String)entry.getValue();
                                    obj1 = (View)renamedViews.get(obj1);
                                    if (obj1 != null)
                                    {
                                        ((View) (obj1)).setTransitionName((String)entry.getKey());
                                    }
                                } while (true);
                            }
                            if (enterTransition != null)
                            {
                                FragmentTransitionCompat21.captureTransitioningViews(enteringViews, view);
                                enteringViews.removeAll(renamedViews.values());
                                enteringViews.add(nonExistentView);
                                FragmentTransitionCompat21.addTargets(enterTransition, enteringViews);
                            }
                        }
                        return true;
                    }

            
            {
                container = view;
                enterTransition = transition;
                nonExistentView = view1;
                inFragment = viewretriever;
                nameOverrides = map;
                renamedViews = map1;
                enteringViews = arraylist;
                super();
            }

                    private class ViewRetriever
                    {

                        public abstract View getView();
                    }

                });
            }
            setSharedElementEpicenter(((Transition) (enterTransition)), epicenterview);
        }
    }

    public static void beginDelayedTransition(ViewGroup viewgroup, Object obj)
    {
        TransitionManager.beginDelayedTransition(viewgroup, (Transition)obj);
    }

    private static void bfsAddViewChildren(List list, View view)
    {
        int k = list.size();
        if (!containedBeforeIndex(list, view, k))
        {
            list.add(view);
            int i = k;
            while (i < list.size()) 
            {
                view = (View)list.get(i);
                if (view instanceof ViewGroup)
                {
                    view = (ViewGroup)view;
                    int l = view.getChildCount();
                    for (int j = 0; j < l; j++)
                    {
                        View view1 = view.getChildAt(j);
                        if (!containedBeforeIndex(list, view1, k))
                        {
                            list.add(view1);
                        }
                    }

                }
                i++;
            }
        }
    }

    public static Object captureExitingViews(Object obj, View view, ArrayList arraylist, Map map, View view1)
    {
label0:
        {
            Object obj1 = obj;
            if (obj != null)
            {
                captureTransitioningViews(arraylist, view);
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
        addTargets((Transition)obj, arraylist);
        return obj;
    }

    private static void captureTransitioningViews(ArrayList arraylist, View view)
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
                        captureTransitioningViews(arraylist, view.getChildAt(i));
                        i++;
                    }
                }
            }
            return;
        }
        arraylist.add(view);
    }

    public static void cleanupTransitions(final View sceneRoot, final View nonExistentView, final Object enterTransition, final ArrayList enteringViews, final Object exitTransition, final ArrayList exitingViews, final Object sharedElementTransition, final ArrayList sharedElementTargets, 
            final Object overallTransition, final ArrayList hiddenViews, final Map renamedViews)
    {
        enterTransition = (Transition)enterTransition;
        exitTransition = (Transition)exitTransition;
        sharedElementTransition = (Transition)sharedElementTransition;
        overallTransition = (Transition)overallTransition;
        if (overallTransition != null)
        {
            sceneRoot.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                final Transition val$enterTransition;
                final ArrayList val$enteringViews;
                final Transition val$exitTransition;
                final ArrayList val$exitingViews;
                final ArrayList val$hiddenViews;
                final View val$nonExistentView;
                final Transition val$overallTransition;
                final Map val$renamedViews;
                final View val$sceneRoot;
                final ArrayList val$sharedElementTargets;
                final Transition val$sharedElementTransition;

                public boolean onPreDraw()
                {
                    sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (enterTransition != null)
                    {
                        FragmentTransitionCompat21.removeTargets(enterTransition, enteringViews);
                    }
                    if (exitTransition != null)
                    {
                        FragmentTransitionCompat21.removeTargets(exitTransition, exitingViews);
                    }
                    if (sharedElementTransition != null)
                    {
                        FragmentTransitionCompat21.removeTargets(sharedElementTransition, sharedElementTargets);
                    }
                    java.util.Map.Entry entry;
                    for (Iterator iterator = renamedViews.entrySet().iterator(); iterator.hasNext(); ((View)entry.getValue()).setTransitionName((String)entry.getKey()))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                    }

                    int j = hiddenViews.size();
                    for (int i = 0; i < j; i++)
                    {
                        overallTransition.excludeTarget((View)hiddenViews.get(i), false);
                    }

                    overallTransition.excludeTarget(nonExistentView, false);
                    return true;
                }

            
            {
                sceneRoot = view;
                enterTransition = transition;
                enteringViews = arraylist;
                exitTransition = transition1;
                exitingViews = arraylist1;
                sharedElementTransition = transition2;
                sharedElementTargets = arraylist2;
                renamedViews = map;
                hiddenViews = arraylist3;
                overallTransition = transition3;
                nonExistentView = view1;
                super();
            }
            });
        }
    }

    public static Object cloneTransition(Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = ((Transition)obj).clone();
        }
        return obj1;
    }

    private static boolean containedBeforeIndex(List list, View view, int i)
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

    public static void excludeTarget(Object obj, View view, boolean flag)
    {
        ((Transition)obj).excludeTarget(view, flag);
    }

    public static void findNamedViews(Map map, View view)
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
                    findNamedViews(map, view.getChildAt(i));
                }

            }
        }
    }

    private static Rect getBoundsOnScreen(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        rect.set(ai[0], ai[1], ai[0] + view.getWidth(), ai[1] + view.getHeight());
        return rect;
    }

    public static String getTransitionName(View view)
    {
        return view.getTransitionName();
    }

    private static boolean hasSimpleTarget(Transition transition)
    {
        return !isNullOrEmpty(transition.getTargetIds()) || !isNullOrEmpty(transition.getTargetNames()) || !isNullOrEmpty(transition.getTargetTypes());
    }

    private static boolean isNullOrEmpty(List list)
    {
        return list == null || list.isEmpty();
    }

    public static Object mergeTransitions(Object obj, Object obj1, Object obj2, boolean flag)
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

    public static void removeTargets(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        if (obj instanceof TransitionSet)
        {
            obj = (TransitionSet)obj;
            int k = ((TransitionSet) (obj)).getTransitionCount();
            for (int i = 0; i < k; i++)
            {
                removeTargets(((TransitionSet) (obj)).getTransitionAt(i), arraylist);
            }

        } else
        if (!hasSimpleTarget(((Transition) (obj))))
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

    public static void setEpicenter(Object obj, View view)
    {
        ((Transition)obj).setEpicenterCallback(new android.transition.Transition.EpicenterCallback() {

            final Rect val$epicenter;

            public Rect onGetEpicenter(Transition transition)
            {
                return epicenter;
            }

            
            {
                epicenter = rect;
                super();
            }
        });
    }

    private static void setSharedElementEpicenter(Transition transition, final EpicenterView epicenterView)
    {
        if (transition != null)
        {
            transition.setEpicenterCallback(new android.transition.Transition.EpicenterCallback() {

                private Rect mEpicenter;
                final EpicenterView val$epicenterView;

                public Rect onGetEpicenter(Transition transition1)
                {
                    if (mEpicenter == null && epicenterView.epicenter != null)
                    {
                        mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(epicenterView.epicenter);
                    }
                    return mEpicenter;
                }

            
            {
                epicenterView = epicenterview;
                super();
            }

                private class EpicenterView
                {

                    public View epicenter;

                    public EpicenterView()
                    {
                    }
                }

            });
        }
    }

    public static void setSharedElementTargets(Object obj, View view, Map map, ArrayList arraylist)
    {
        obj = (TransitionSet)obj;
        arraylist.clear();
        arraylist.addAll(map.values());
        map = ((TransitionSet) (obj)).getTargets();
        map.clear();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            bfsAddViewChildren(map, (View)arraylist.get(i));
        }

        arraylist.add(view);
        addTargets(obj, arraylist);
    }

    public static Object wrapSharedElementTransition(Object obj)
    {
        if (obj != null)
        {
            if ((obj = (Transition)obj) != null)
            {
                TransitionSet transitionset = new TransitionSet();
                transitionset.addTransition(((Transition) (obj)));
                return transitionset;
            }
        }
        return null;
    }


}
