// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;


// Referenced classes of package dagger.internal:
//            Binding, Linker

private static class <init> extends Binding
{

    private final Binding binding;
    private Object onlyInstance;

    public void attach(Linker linker)
    {
        binding.attach(linker);
    }

    public Object get()
    {
        if (onlyInstance == Linker.access$200())
        {
            onlyInstance = binding.get();
        }
        return onlyInstance;
    }

    public void injectMembers(Object obj)
    {
        binding.injectMembers(obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append("@Singleton/").append(binding.toString()).toString();
    }

    private (Binding binding1)
    {
        super(binding1.provideKey, binding1.membersKey, true, binding1.requiredBy);
        onlyInstance = Linker.access$200();
        binding = binding1;
    }

    binding(Binding binding1, binding binding2)
    {
        this(binding1);
    }
}
