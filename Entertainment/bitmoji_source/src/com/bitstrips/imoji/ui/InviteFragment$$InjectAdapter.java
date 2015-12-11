// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            InviteFragment

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding picasso;
    private Binding supertype;

    public void attach(Linker linker)
    {
        picasso = linker.requestBinding("com.squareup.picasso.Picasso", com/bitstrips/imoji/ui/InviteFragment, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.AbstractFragment", com/bitstrips/imoji/ui/InviteFragment, getClass().getClassLoader(), false, true);
    }

    public InviteFragment get()
    {
        InviteFragment invitefragment = new InviteFragment();
        injectMembers(invitefragment);
        return invitefragment;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(picasso);
        set1.add(supertype);
    }

    public void injectMembers(InviteFragment invitefragment)
    {
        invitefragment.picasso = (Picasso)picasso.get();
        supertype.injectMembers(invitefragment);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((InviteFragment)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.InviteFragment", "members/com.bitstrips.imoji.ui.InviteFragment", false, com/bitstrips/imoji/ui/InviteFragment);
    }
}
