// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record.android.activity;

import android.app.Activity;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.mcc.record.android.activity:
//            ActivityContext

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding activity;
    private Binding supertype;

    public void attach(Linker linker)
    {
        activity = linker.requestBinding("android.app.Activity", com/amazon/mcc/record/android/activity/ActivityContext, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.mcc.record.android.DeviceContext", com/amazon/mcc/record/android/activity/ActivityContext, getClass().getClassLoader(), false, true);
    }

    public ActivityContext get()
    {
        ActivityContext activitycontext = new ActivityContext((Activity)activity.get());
        injectMembers(activitycontext);
        return activitycontext;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(activity);
        set1.add(supertype);
    }

    public void injectMembers(ActivityContext activitycontext)
    {
        supertype.injectMembers(activitycontext);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ActivityContext)obj);
    }

    public ()
    {
        super("com.amazon.mcc.record.android.activity.ActivityContext", "members/com.amazon.mcc.record.android.activity.ActivityContext", false, com/amazon/mcc/record/android/activity/ActivityContext);
    }
}
