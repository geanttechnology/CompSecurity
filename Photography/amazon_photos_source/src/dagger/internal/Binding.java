// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import dagger.MembersInjector;
import javax.inject.Provider;

// Referenced classes of package dagger.internal:
//            Linker

public abstract class Binding
    implements MembersInjector, Provider
{

    public static final Binding UNRESOLVED = new Binding(null, null, false, null) {

    };
    private int bits;
    public final String membersKey;
    public final String provideKey;
    public final Object requiredBy;

    protected Binding(String s, String s1, boolean flag, Object obj)
    {
        if (flag && s == null)
        {
            throw new IllegalArgumentException();
        }
        provideKey = s;
        membersKey = s1;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        bits = i;
        requiredBy = obj;
    }

    public void attach(Linker linker)
    {
    }

    public Object get()
    {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void injectMembers(Object obj)
    {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public boolean isLinked()
    {
        return (bits & 2) != 0;
    }

    boolean isSingleton()
    {
        return (bits & 1) != 0;
    }

    void setLinked()
    {
        bits = bits | 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[provideKey=\"").append(provideKey).append("\", memberskey=\"").append(membersKey).append("\"]").toString();
    }

}
