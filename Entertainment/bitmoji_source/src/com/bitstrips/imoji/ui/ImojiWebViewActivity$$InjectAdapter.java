// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.auth.FacebookService;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiWebViewActivity

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding facebookService;

    public void attach(Linker linker)
    {
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/ImojiWebViewActivity, getClass().getClassLoader());
    }

    public ImojiWebViewActivity get()
    {
        ImojiWebViewActivity imojiwebviewactivity = new ImojiWebViewActivity();
        injectMembers(imojiwebviewactivity);
        return imojiwebviewactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(facebookService);
    }

    public void injectMembers(ImojiWebViewActivity imojiwebviewactivity)
    {
        imojiwebviewactivity.facebookService = (FacebookService)facebookService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImojiWebViewActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.ImojiWebViewActivity", "members/com.bitstrips.imoji.ui.ImojiWebViewActivity", false, com/bitstrips/imoji/ui/ImojiWebViewActivity);
    }
}
