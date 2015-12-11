// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji:
//            ImojiModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ImojiModule module;
    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ImojiModule, getClass().getClassLoader());
    }

    public volatile Object get()
    {
        return get();
    }

    public String get()
    {
        return module.provideAvatarId((PreferenceUtils)preferenceUtils.get());
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(preferenceUtils);
    }

    public (ImojiModule imojimodule)
    {
        super("@javax.inject.Named(value=avatarId)/java.lang.String", false, "com.bitstrips.imoji.ImojiModule", "provideAvatarId");
        module = imojimodule;
        setLibrary(false);
    }
}
