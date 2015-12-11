// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import com.bitstrips.imoji.services.B4MService;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji:
//            ImojiModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ImojiModule module;

    public B4MService get()
    {
        return module.providerB4MService();
    }

    public volatile Object get()
    {
        return get();
    }

    public (ImojiModule imojimodule)
    {
        super("com.bitstrips.imoji.services.B4MService", true, "com.bitstrips.imoji.ImojiModule", "providerB4MService");
        module = imojimodule;
        setLibrary(false);
    }
}
