// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import android.content.Context;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji:
//            ImojiModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ImojiModule module;

    public Context get()
    {
        return module.provideContext();
    }

    public volatile Object get()
    {
        return get();
    }

    public (ImojiModule imojimodule)
    {
        super("android.content.Context", false, "com.bitstrips.imoji.ImojiModule", "provideContext");
        module = imojimodule;
        setLibrary(false);
    }
}
