// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import com.amazon.retailsearch.metrics.RetailSearchDCMLogger;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            ModelViewEntry

public final class  extends Binding
    implements MembersInjector
{

    private Binding dcmLog;
    private Binding supertype;

    public void attach(Linker linker)
    {
        dcmLog = linker.requestBinding("com.amazon.retailsearch.metrics.RetailSearchDCMLogger", com/amazon/retailsearch/android/ui/listadapter/ModelViewEntry, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry", com/amazon/retailsearch/android/ui/listadapter/ModelViewEntry, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(dcmLog);
        set1.add(supertype);
    }

    public void injectMembers(ModelViewEntry modelviewentry)
    {
        modelviewentry.dcmLog = (RetailSearchDCMLogger)dcmLog.get();
        supertype.injectMembers(modelviewentry);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ModelViewEntry)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry", false, com/amazon/retailsearch/android/ui/listadapter/ModelViewEntry);
    }
}
