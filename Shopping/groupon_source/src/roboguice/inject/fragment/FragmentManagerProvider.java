// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import com.google.inject.Provider;

public class FragmentManagerProvider
    implements Provider
{

    protected Activity activity;

    public FragmentManagerProvider()
    {
    }

    public FragmentManager get()
    {
        return activity.getFragmentManager();
    }

    public volatile Object get()
    {
        return get();
    }
}
