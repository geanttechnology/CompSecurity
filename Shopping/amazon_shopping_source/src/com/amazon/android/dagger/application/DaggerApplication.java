// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.dagger.application;

import android.app.Application;
import android.content.Context;
import com.amazon.android.dagger.DaggerAndroid;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.android.dagger.application:
//            ContextModule

public abstract class DaggerApplication extends Application
{

    public DaggerApplication()
    {
    }

    protected abstract Set configure(Set set);

    void createGraph(Context context)
    {
        Set set = configure(new HashSet());
        set.add(new ContextModule(context));
        DaggerAndroid.createGraph(set.toArray());
    }

    public void onCreate()
    {
        createGraph(getBaseContext());
    }
}
