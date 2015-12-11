// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.f2prateek.dart;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dart
{
    public static abstract class Finder extends Enum
    {

        private static final Finder $VALUES[];
        public static final Finder ACTIVITY;
        public static final Finder BUNDLE;
        public static final Finder FRAGMENT;

        public static Finder valueOf(String s)
        {
            return (Finder)Enum.valueOf(com/f2prateek/dart/Dart$Finder, s);
        }

        public static Finder[] values()
        {
            return (Finder[])$VALUES.clone();
        }

        public abstract Object getExtra(Object obj, String s);

        static 
        {
            ACTIVITY = new Finder("ACTIVITY", 0) {

                public Object getExtra(Object obj, String s)
                {
                    obj = ((Activity)obj).getIntent();
                    if (obj == null)
                    {
                        return null;
                    } else
                    {
                        return Finder.BUNDLE.getExtra(((Intent) (obj)).getExtras(), s);
                    }
                }

            };
            FRAGMENT = new Finder("FRAGMENT", 1) {

                public Object getExtra(Object obj, String s)
                {
                    obj = ((Fragment)obj).getArguments();
                    return Finder.BUNDLE.getExtra(obj, s);
                }

            };
            BUNDLE = new Finder("BUNDLE", 2) {

                public Object getExtra(Object obj, String s)
                {
                    if (obj == null)
                    {
                        return null;
                    } else
                    {
                        return ((Bundle)obj).get(s);
                    }
                }

            };
            $VALUES = (new Finder[] {
                ACTIVITY, FRAGMENT, BUNDLE
            });
        }

        private Finder(String s, int i)
        {
            super(s, i);
        }

    }

    public static class UnableToInjectException extends RuntimeException
    {

        UnableToInjectException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    static final Map INJECTORS = new LinkedHashMap();
    static final Method NO_OP = null;
    private static boolean debug = false;

    private static Method findInjectorForClass(Class class1)
        throws NoSuchMethodException
    {
        Object obj;
        obj = (Method)INJECTORS.get(class1);
        if (obj != null)
        {
            if (debug)
            {
                Log.d("Dart", "HIT: Cached in injector map.");
            }
            return ((Method) (obj));
        }
        obj = class1.getName();
        if (((String) (obj)).startsWith("android.") || ((String) (obj)).startsWith("java."))
        {
            if (debug)
            {
                Log.d("Dart", "MISS: Reached framework class. Abandoning search.");
            }
            return NO_OP;
        }
        Method method = Class.forName((new StringBuilder()).append(((String) (obj))).append("$$ExtraInjector").toString()).getMethod("inject", new Class[] {
            com/f2prateek/dart/Dart$Finder, class1, java/lang/Object
        });
        obj = method;
        if (!debug)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        Log.d("Dart", "HIT: Class loaded injection class.");
        obj = method;
_L2:
        INJECTORS.put(class1, obj);
        return ((Method) (obj));
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if (debug)
        {
            Log.d("Dart", (new StringBuilder()).append("Not found. Trying superclass ").append(class1.getSuperclass().getName()).toString());
        }
        classnotfoundexception = findInjectorForClass(class1.getSuperclass());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void inject(Activity activity)
    {
        inject(activity, activity, Finder.ACTIVITY);
    }

    public static void inject(Fragment fragment)
    {
        inject(fragment, fragment, Finder.FRAGMENT);
    }

    public static void inject(Object obj, Bundle bundle)
    {
        inject(obj, bundle, Finder.BUNDLE);
    }

    static void inject(Object obj, Object obj1, Finder finder)
    {
        Object obj2 = obj.getClass();
        try
        {
            if (debug)
            {
                Log.d("Dart", (new StringBuilder()).append("Looking up extra injector for ").append(((Class) (obj2)).getName()).toString());
            }
            obj2 = findInjectorForClass(((Class) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new UnableToInjectException((new StringBuilder()).append("Unable to inject extras for ").append(obj).toString(), ((Throwable) (obj1)));
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        ((Method) (obj2)).invoke(null, new Object[] {
            finder, obj, obj1
        });
    }

}
