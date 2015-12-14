// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import dagger.Lazy;

// Referenced classes of package dagger.internal:
//            Binding, Linker

final class LazyBinding extends Binding
{

    private static final Object NOT_PRESENT = new Object();
    private Binding _flddelegate;
    private final String lazyKey;

    public LazyBinding(String s, Object obj, String s1)
    {
        super(s, null, false, obj);
        lazyKey = s1;
    }

    public void attach(Linker linker)
    {
        _flddelegate = linker.requestBinding(lazyKey, requiredBy);
    }

    public Lazy get()
    {
        return new Lazy() {

            private Object cacheValue;
            final LazyBinding this$0;

            
            {
                this$0 = LazyBinding.this;
                super();
                cacheValue = LazyBinding.NOT_PRESENT;
            }
        };
    }

    public volatile Object get()
    {
        return get();
    }

    public void injectMembers(Lazy lazy)
    {
        throw new UnsupportedOperationException();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((Lazy)obj);
    }


}
