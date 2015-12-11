// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import com.amazon.avod.perf.Profiler;
import java.util.Set;

// Referenced classes of package dagger.internal:
//            Binding, Linker

public class BindingWrapper extends Binding
{

    private final Binding mBinding;

    public BindingWrapper(Binding binding)
    {
        super(binding.provideKey, binding.membersKey, binding.isSingleton(), binding.requiredBy);
        mBinding = binding;
    }

    public void attach(Linker linker)
    {
        mBinding.attach(linker);
    }

    public boolean dependedOn()
    {
        return mBinding.dependedOn();
    }

    public Object get()
    {
        String s;
        s = (new StringBuilder()).append("DI:DaggerBinding:get:").append(mBinding.getClass().getName()).toString();
        Profiler.beginTrace(s, 3);
        Object obj = mBinding.get();
        Profiler.endTrace(s, 3);
        return obj;
        Exception exception;
        exception;
        Profiler.endTrace(s, 3);
        throw exception;
    }

    public void getDependencies(Set set, Set set1)
    {
        mBinding.getDependencies(set, set1);
    }

    public void injectMembers(Object obj)
    {
        String s = (new StringBuilder()).append("DI:DaggerBinding:injectMembers:").append(mBinding.getClass().getName()).toString();
        Profiler.beginTrace(s, 3);
        mBinding.injectMembers(obj);
        Profiler.endTrace(s, 3);
    }

    public boolean isCycleFree()
    {
        return mBinding.isCycleFree();
    }

    public boolean isLinked()
    {
        return mBinding.isLinked();
    }

    boolean isSingleton()
    {
        return mBinding.isSingleton();
    }

    public boolean isVisiting()
    {
        return mBinding.isVisiting();
    }

    public boolean library()
    {
        return mBinding.library();
    }

    public void setCycleFree(boolean flag)
    {
        mBinding.setCycleFree(flag);
    }

    public void setDependedOn(boolean flag)
    {
        mBinding.setDependedOn(flag);
    }

    public void setLibrary(boolean flag)
    {
        mBinding.setLibrary(flag);
    }

    void setLinked()
    {
        mBinding.setLinked();
    }

    public void setVisiting(boolean flag)
    {
        mBinding.setVisiting(flag);
    }

    public String toString()
    {
        return mBinding.toString();
    }
}
