// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;

public class TabInfo
{

    public final Bundle bundle;
    public final Class clss;
    private WeakReference mRef;
    protected String mTag;

    public TabInfo(Class class1, Bundle bundle1, String s)
    {
        clss = class1;
        bundle = bundle1;
        mTag = s;
    }

    public Fragment fragment()
    {
        if (mRef != null)
        {
            return (Fragment)mRef.get();
        } else
        {
            return null;
        }
    }

    public String getTag()
    {
        return mTag;
    }

    public void setFragment(Fragment fragment1)
    {
        if (fragment1 != null)
        {
            mRef = new WeakReference(fragment1);
            return;
        } else
        {
            mRef = null;
            return;
        }
    }
}
