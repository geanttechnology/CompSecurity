// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            BitshopPackTemplatesAdapter

public final class  extends Binding
    implements MembersInjector
{

    private Binding picasso;
    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/adapters/BitshopPackTemplatesAdapter, getClass().getClassLoader());
        picasso = linker.requestBinding("com.squareup.picasso.Picasso", com/bitstrips/imoji/ui/adapters/BitshopPackTemplatesAdapter, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/adapters/BitshopPackTemplatesAdapter, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(templatesManager);
        set1.add(picasso);
        set1.add(preferenceUtils);
    }

    public void injectMembers(BitshopPackTemplatesAdapter bitshoppacktemplatesadapter)
    {
        bitshoppacktemplatesadapter.templatesManager = (TemplatesManager)templatesManager.get();
        bitshoppacktemplatesadapter.picasso = (Picasso)picasso.get();
        bitshoppacktemplatesadapter.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BitshopPackTemplatesAdapter)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.ui.adapters.BitshopPackTemplatesAdapter", false, com/bitstrips/imoji/ui/adapters/BitshopPackTemplatesAdapter);
    }
}
