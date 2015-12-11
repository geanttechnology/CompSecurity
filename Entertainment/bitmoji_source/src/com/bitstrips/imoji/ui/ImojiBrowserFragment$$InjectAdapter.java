// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserFragment, AvatarChangeRegister, ImagesGridViewsWrapper

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding avatarChangeRegister;
    private Binding imagesGridViewsWrapper;
    private Binding supertype;

    public void attach(Linker linker)
    {
        avatarChangeRegister = linker.requestBinding("com.bitstrips.imoji.ui.AvatarChangeRegister", com/bitstrips/imoji/ui/ImojiBrowserFragment, getClass().getClassLoader());
        imagesGridViewsWrapper = linker.requestBinding("com.bitstrips.imoji.ui.ImagesGridViewsWrapper", com/bitstrips/imoji/ui/ImojiBrowserFragment, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.AbstractFragment", com/bitstrips/imoji/ui/ImojiBrowserFragment, getClass().getClassLoader(), false, true);
    }

    public ImojiBrowserFragment get()
    {
        ImojiBrowserFragment imojibrowserfragment = new ImojiBrowserFragment();
        injectMembers(imojibrowserfragment);
        return imojibrowserfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(avatarChangeRegister);
        set1.add(imagesGridViewsWrapper);
        set1.add(supertype);
    }

    public void injectMembers(ImojiBrowserFragment imojibrowserfragment)
    {
        imojibrowserfragment.avatarChangeRegister = (AvatarChangeRegister)avatarChangeRegister.get();
        imojibrowserfragment.imagesGridViewsWrapper = (ImagesGridViewsWrapper)imagesGridViewsWrapper.get();
        supertype.injectMembers(imojibrowserfragment);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImojiBrowserFragment)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.ImojiBrowserFragment", "members/com.bitstrips.imoji.ui.ImojiBrowserFragment", false, com/bitstrips/imoji/ui/ImojiBrowserFragment);
    }
}
