// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.util.FileUtil;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ShareImageDialogFragment

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding fileUtil;
    private Binding supertype;

    public void attach(Linker linker)
    {
        fileUtil = linker.requestBinding("com.bitstrips.imoji.util.FileUtil", com/bitstrips/imoji/ui/ShareImageDialogFragment, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.BaseShareDialogFragment", com/bitstrips/imoji/ui/ShareImageDialogFragment, getClass().getClassLoader(), false, true);
    }

    public ShareImageDialogFragment get()
    {
        ShareImageDialogFragment shareimagedialogfragment = new ShareImageDialogFragment();
        injectMembers(shareimagedialogfragment);
        return shareimagedialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(fileUtil);
        set1.add(supertype);
    }

    public void injectMembers(ShareImageDialogFragment shareimagedialogfragment)
    {
        shareimagedialogfragment.fileUtil = (FileUtil)fileUtil.get();
        supertype.injectMembers(shareimagedialogfragment);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ShareImageDialogFragment)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.ShareImageDialogFragment", "members/com.bitstrips.imoji.ui.ShareImageDialogFragment", false, com/bitstrips/imoji/ui/ShareImageDialogFragment);
    }
}
