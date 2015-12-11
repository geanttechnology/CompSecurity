// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.services.B4MService;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            B4MBitmojiBrowserActivity

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding b4MService;
    private Binding facebookService;
    private Binding supertype;

    public void attach(Linker linker)
    {
        b4MService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/ui/B4MBitmojiBrowserActivity, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/B4MBitmojiBrowserActivity, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.ImojiBrowserActivity", com/bitstrips/imoji/ui/B4MBitmojiBrowserActivity, getClass().getClassLoader(), false, true);
    }

    public B4MBitmojiBrowserActivity get()
    {
        B4MBitmojiBrowserActivity b4mbitmojibrowseractivity = new B4MBitmojiBrowserActivity();
        injectMembers(b4mbitmojibrowseractivity);
        return b4mbitmojibrowseractivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(b4MService);
        set1.add(facebookService);
        set1.add(supertype);
    }

    public void injectMembers(B4MBitmojiBrowserActivity b4mbitmojibrowseractivity)
    {
        b4mbitmojibrowseractivity.b4MService = (B4MService)b4MService.get();
        b4mbitmojibrowseractivity.facebookService = (FacebookService)facebookService.get();
        supertype.injectMembers(b4mbitmojibrowseractivity);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((B4MBitmojiBrowserActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.B4MBitmojiBrowserActivity", "members/com.bitstrips.imoji.ui.B4MBitmojiBrowserActivity", false, com/bitstrips/imoji/ui/B4MBitmojiBrowserActivity);
    }
}
