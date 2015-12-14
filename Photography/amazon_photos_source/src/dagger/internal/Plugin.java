// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;


// Referenced classes of package dagger.internal:
//            Binding, ModuleAdapter

public interface Plugin
{

    public abstract Binding getAtInjectBinding(String s, String s1, boolean flag);

    public abstract ModuleAdapter getModuleAdapter(Class class1, Object obj);
}
