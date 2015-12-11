// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarChangeRegister

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/AvatarChangeRegister, getClass().getClassLoader());
    }

    public AvatarChangeRegister get()
    {
        AvatarChangeRegister avatarchangeregister = new AvatarChangeRegister();
        injectMembers(avatarchangeregister);
        return avatarchangeregister;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceUtils);
    }

    public void injectMembers(AvatarChangeRegister avatarchangeregister)
    {
        avatarchangeregister.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((AvatarChangeRegister)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.AvatarChangeRegister", "members/com.bitstrips.imoji.ui.AvatarChangeRegister", false, com/bitstrips/imoji/ui/AvatarChangeRegister);
    }
}
