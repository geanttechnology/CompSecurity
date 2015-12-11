// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public final class  extends Binding
    implements MembersInjector
{

    private Binding mAvatarIdProvider;

    public void attach(Linker linker)
    {
        mAvatarIdProvider = linker.requestBinding("@javax.inject.Named(value=avatarId)/javax.inject.Provider<java.lang.String>", com/bitstrips/imoji/ui/adapters/PolyAdapter, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(mAvatarIdProvider);
    }

    public void injectMembers(PolyAdapter polyadapter)
    {
        polyadapter.mAvatarIdProvider = (Provider)mAvatarIdProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((PolyAdapter)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.ui.adapters.PolyAdapter", false, com/bitstrips/imoji/ui/adapters/PolyAdapter);
    }
}
