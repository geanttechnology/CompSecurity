// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.common.base:
//            Preconditions

public final class Throwables
{

    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
    private static final Method getStackTraceDepthMethod;
    private static final Method getStackTraceElementMethod;
    private static final Object jla;

    private Throwables()
    {
    }

    public static List getCausalChain(Throwable throwable)
    {
        Preconditions.checkNotNull(throwable);
        ArrayList arraylist = new ArrayList(4);
        for (; throwable != null; throwable = throwable.getCause())
        {
            arraylist.add(throwable);
        }

        return Collections.unmodifiableList(arraylist);
    }

    private static Method getGetMethod()
    {
        return getJlaMethod("getStackTraceElement", new Class[] {
            java/lang/Throwable, Integer.TYPE
        });
    }

    private static Object getJLA()
    {
        Object obj;
        try
        {
            obj = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            return null;
        }
        return obj;
    }

    private static transient Method getJlaMethod(String s, Class aclass[])
        throws ThreadDeath
    {
        try
        {
            s = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Throwable getRootCause(Throwable throwable)
    {
        do
        {
            Throwable throwable1 = throwable.getCause();
            if (throwable1 != null)
            {
                throwable = throwable1;
            } else
            {
                return throwable;
            }
        } while (true);
    }

    private static Method getSizeMethod()
    {
        return getJlaMethod("getStackTraceDepth", new Class[] {
            java/lang/Throwable
        });
    }

    public static String getStackTraceAsString(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString();
    }

    private static transient Object invokeAccessibleNonThrowingMethod(Method method, Object obj, Object aobj[])
    {
        try
        {
            method = ((Method) (method.invoke(obj, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new RuntimeException(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw propagate(method.getCause());
        }
        return method;
    }

    private static List jlaStackTrace(Throwable throwable)
    {
        Preconditions.checkNotNull(throwable);
        return new AbstractList(throwable) {

            final Throwable val$t;

            public volatile Object get(int i)
            {
                return get(i);
            }

            public StackTraceElement get(int i)
            {
                return (StackTraceElement)Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceElementMethod, Throwables.jla, new Object[] {
                    t, Integer.valueOf(i)
                });
            }

            public int size()
            {
                return ((Integer)Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceDepthMethod, Throwables.jla, new Object[] {
                    t
                })).intValue();
            }

            
            {
                t = throwable;
                super();
            }
        };
    }

    public static List lazyStackTrace(Throwable throwable)
    {
        if (lazyStackTraceIsLazy())
        {
            return jlaStackTrace(throwable);
        } else
        {
            return Collections.unmodifiableList(Arrays.asList(throwable.getStackTrace()));
        }
    }

    public static boolean lazyStackTraceIsLazy()
    {
        boolean flag1 = true;
        boolean flag;
        if (getStackTraceElementMethod != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (getStackTraceDepthMethod == null)
        {
            flag1 = false;
        }
        return flag & flag1;
    }

    public static RuntimeException propagate(Throwable throwable)
    {
        propagateIfPossible((Throwable)Preconditions.checkNotNull(throwable));
        throw new RuntimeException(throwable);
    }

    public static void propagateIfInstanceOf(Throwable throwable, Class class1)
        throws Throwable
    {
        if (throwable != null && class1.isInstance(throwable))
        {
            throw (Throwable)class1.cast(throwable);
        } else
        {
            return;
        }
    }

    public static void propagateIfPossible(Throwable throwable)
    {
        propagateIfInstanceOf(throwable, java/lang/Error);
        propagateIfInstanceOf(throwable, java/lang/RuntimeException);
    }

    public static void propagateIfPossible(Throwable throwable, Class class1)
        throws Throwable
    {
        propagateIfInstanceOf(throwable, class1);
        propagateIfPossible(throwable);
    }

    public static void propagateIfPossible(Throwable throwable, Class class1, Class class2)
        throws Throwable, Throwable
    {
        Preconditions.checkNotNull(class2);
        propagateIfInstanceOf(throwable, class1);
        propagateIfPossible(throwable, class2);
    }

    static 
    {
        Object obj = null;
        jla = getJLA();
        Method method;
        if (jla == null)
        {
            method = null;
        } else
        {
            method = getGetMethod();
        }
        getStackTraceElementMethod = method;
        if (jla == null)
        {
            method = obj;
        } else
        {
            method = getSizeMethod();
        }
        getStackTraceDepthMethod = method;
    }




}
