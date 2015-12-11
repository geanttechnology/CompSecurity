// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import com.bitstrips.imoji.ui.ImageLoader;
import com.squareup.picasso.Picasso;
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
    private Binding picasso;

    public void attach(Linker linker)
    {
        picasso = linker.requestBinding("com.squareup.picasso.Picasso", com/bitstrips/imoji/ImojiModule, getClass().getClassLoader());
    }

    public ImageLoader get()
    {
        return module.provideImageLoader((Picasso)picasso.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(picasso);
    }

    public (ImojiModule imojimodule)
    {
        super("com.bitstrips.imoji.ui.ImageLoader", false, "com.bitstrips.imoji.ImojiModule", "provideImageLoader");
        module = imojimodule;
        setLibrary(false);
    }
}
