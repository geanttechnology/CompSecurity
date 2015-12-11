// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.mas.client.authentication.InferredCorPfm;
import com.amazon.mas.client.device.DeviceInspector;
import com.amazon.mas.client.device.hardware.HardwareEvaluator;
import com.amazon.mas.client.device.software.opengl.OpenGlActivityInterrogator;
import com.amazon.mcc.resources.ResourceCache;
import com.amazon.venezia.web.PageUrlFactory;
import com.amazon.venezia.web.WebViewBuilder;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.client.ftue:
//            InferCorPfmFragment

public final class yInterrogator extends Binding
    implements MembersInjector, Provider
{

    private Binding accountManager;
    private Binding authCookieHelper;
    private Binding deviceInspector;
    private Binding hardware;
    private Binding inferredCorPfm;
    private Binding openglInterrogator;
    private Binding pageUrlFactory;
    private Binding resourceCache;
    private Binding webViewFactory;

    public void attach(Linker linker)
    {
        openglInterrogator = linker.requestBinding("com.amazon.mas.client.device.software.opengl.OpenGlActivityInterrogator", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        accountManager = linker.requestBinding("com.amazon.identity.auth.device.api.MAPAccountManager", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        resourceCache = linker.requestBinding("com.amazon.mcc.resources.ResourceCache", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        authCookieHelper = linker.requestBinding("dagger.Lazy<com.amazon.venezia.web.AuthCookieHelper>", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        inferredCorPfm = linker.requestBinding("com.amazon.mas.client.authentication.InferredCorPfm", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        webViewFactory = linker.requestBinding("com.amazon.venezia.web.WebViewBuilder", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        pageUrlFactory = linker.requestBinding("com.amazon.venezia.web.PageUrlFactory", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        hardware = linker.requestBinding("com.amazon.mas.client.device.hardware.HardwareEvaluator", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
        deviceInspector = linker.requestBinding("com.amazon.mas.client.device.DeviceInspector", com/amazon/client/ftue/InferCorPfmFragment, getClass().getClassLoader());
    }

    public InferCorPfmFragment get()
    {
        InferCorPfmFragment infercorpfmfragment = new InferCorPfmFragment();
        injectMembers(infercorpfmfragment);
        return infercorpfmfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(openglInterrogator);
        set1.add(accountManager);
        set1.add(resourceCache);
        set1.add(authCookieHelper);
        set1.add(inferredCorPfm);
        set1.add(webViewFactory);
        set1.add(pageUrlFactory);
        set1.add(hardware);
        set1.add(deviceInspector);
    }

    public void injectMembers(InferCorPfmFragment infercorpfmfragment)
    {
        infercorpfmfragment.openglInterrogator = (OpenGlActivityInterrogator)openglInterrogator.get();
        infercorpfmfragment.accountManager = (MAPAccountManager)accountManager.get();
        infercorpfmfragment.resourceCache = (ResourceCache)resourceCache.get();
        infercorpfmfragment.authCookieHelper = (Lazy)authCookieHelper.get();
        infercorpfmfragment.inferredCorPfm = (InferredCorPfm)inferredCorPfm.get();
        infercorpfmfragment.webViewFactory = (WebViewBuilder)webViewFactory.get();
        infercorpfmfragment.pageUrlFactory = (PageUrlFactory)pageUrlFactory.get();
        infercorpfmfragment.hardware = (HardwareEvaluator)hardware.get();
        infercorpfmfragment.deviceInspector = (DeviceInspector)deviceInspector.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((InferCorPfmFragment)obj);
    }

    public yInterrogator()
    {
        super("com.amazon.client.ftue.InferCorPfmFragment", "members/com.amazon.client.ftue.InferCorPfmFragment", false, com/amazon/client/ftue/InferCorPfmFragment);
    }
}
