// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.manager.TemplatesManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImagesGridViewsWrapper, ImageLoader

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding imageLoader;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        imageLoader = linker.requestBinding("com.bitstrips.imoji.ui.ImageLoader", com/bitstrips/imoji/ui/ImagesGridViewsWrapper, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/ImagesGridViewsWrapper, getClass().getClassLoader());
    }

    public ImagesGridViewsWrapper get()
    {
        ImagesGridViewsWrapper imagesgridviewswrapper = new ImagesGridViewsWrapper();
        injectMembers(imagesgridviewswrapper);
        return imagesgridviewswrapper;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(imageLoader);
        set1.add(templatesManager);
    }

    public void injectMembers(ImagesGridViewsWrapper imagesgridviewswrapper)
    {
        imagesgridviewswrapper.imageLoader = (ImageLoader)imageLoader.get();
        imagesgridviewswrapper.templatesManager = (TemplatesManager)templatesManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImagesGridViewsWrapper)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.ImagesGridViewsWrapper", "members/com.bitstrips.imoji.ui.ImagesGridViewsWrapper", false, com/bitstrips/imoji/ui/ImagesGridViewsWrapper);
    }
}
