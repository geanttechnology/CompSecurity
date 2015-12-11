// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.profiling;

import com.amazon.logging.Logger;
import com.amazon.profiling.ProfilerImplementation;
import com.amazon.profiling.ProfilerScope;
import java.util.Stack;

// Referenced classes of package com.amazon.android.profiling:
//            AndroidProfilerScope

public class AndroidProfiler
    implements ProfilerImplementation
{
    private static class ThreadLocalStack extends ThreadLocal
    {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Stack initialValue()
        {
            return new Stack();
        }

        private ThreadLocalStack()
        {
        }

    }


    private static final Logger LOG = Logger.getLogger(com/amazon/android/profiling/AndroidProfiler);
    private final ThreadLocalStack methodScopeStack = new ThreadLocalStack();
    private final long start = System.nanoTime();

    public AndroidProfiler()
    {
        LOG.i("Creating AndroidProfiler");
    }

    public void closeScope(ProfilerScope profilerscope)
    {
        if (profilerscope instanceof AndroidProfilerScope)
        {
            AndroidProfilerScope androidprofilerscope = (AndroidProfilerScope)profilerscope;
            long l2 = System.nanoTime();
            long l = androidprofilerscope.start - start;
            long l1 = l / 0xf4240L;
            l2 -= androidprofilerscope.start;
            long l3 = l2 / 0xf4240L;
            LOG.v(String.format("%s: %d> %s, [%d.%d ms] %d.%d ms", new Object[] {
                Thread.currentThread(), Integer.valueOf(((Stack)methodScopeStack.get()).size()), androidprofilerscope.name, Long.valueOf(l1), Long.valueOf(l - 0xf4240L * l1), Long.valueOf(l3), Long.valueOf(l2 - 0xf4240L * l3)
            }));
            if (androidprofilerscope.method)
            {
                Stack stack = (Stack)methodScopeStack.get();
                for (profilerscope = null; !stack.isEmpty() && profilerscope != androidprofilerscope; profilerscope = (AndroidProfilerScope)stack.pop()) { }
            }
        }
    }

    public ProfilerScope createMethodProfilerScope(Class class1, String s)
    {
        class1 = new AndroidProfilerScope(true, (new StringBuilder()).append(class1.getSimpleName()).append(".").append(s).toString(), System.nanoTime());
        ((Stack)methodScopeStack.get()).push(class1);
        return class1;
    }

    public ProfilerScope createProfilerScope(String s)
    {
        Object obj = (Stack)methodScopeStack.get();
        if (!((Stack) (obj)).isEmpty())
        {
            obj = (AndroidProfilerScope)((Stack) (obj)).peek();
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            obj = "";
        } else
        {
            obj = (new StringBuilder()).append(((AndroidProfilerScope) (obj)).name).append("/").toString();
        }
        return new AndroidProfilerScope(false, (new StringBuilder()).append(((String) (obj))).append(s).toString(), System.nanoTime());
    }

}
