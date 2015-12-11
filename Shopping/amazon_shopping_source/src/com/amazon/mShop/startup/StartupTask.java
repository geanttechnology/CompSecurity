// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.util.Log;
import com.amazon.mShop.util.mediator.Mediator;
import com.amazon.mShop.util.mediator.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartupTask
    implements Task
{

    private final String mId;
    private final List mInputDependency = new ArrayList();
    private Mediator mMediator;
    private final List mOutputDependency = new ArrayList();

    public StartupTask(Mediator mediator, String s)
    {
        mMediator = mediator;
        mId = s;
        mediator.register(this);
    }

    public void addInputDependency(String s)
    {
        if (!mInputDependency.contains(s))
        {
            mInputDependency.add(s);
            mMediator.addDependency(this, s);
        }
    }

    public void addOutputDependency(String s)
    {
        if (!mOutputDependency.contains(s))
        {
            mOutputDependency.add(s);
        }
    }

    public void end(String s)
    {
        if ("taskResultSucceed".equals(s))
        {
            onSucceed();
            return;
        } else
        {
            onFailed();
            return;
        }
    }

    public String getId()
    {
        return mId;
    }

    public List getInputDependency()
    {
        return mInputDependency;
    }

    public void onFailed()
    {
        Log.i(toString(), (new StringBuilder()).append("failed ").append(getId()).toString());
        String s;
        for (Iterator iterator = mOutputDependency.iterator(); iterator.hasNext(); mMediator.onFailed(s))
        {
            s = (String)iterator.next();
        }

    }

    public void onSucceed()
    {
        Log.i(toString(), (new StringBuilder()).append("succeed ").append(getId()).toString());
        String s;
        for (Iterator iterator = mOutputDependency.iterator(); iterator.hasNext(); mMediator.onReady(s))
        {
            s = (String)iterator.next();
        }

    }

    public void removeInputDependency(String s)
    {
        mInputDependency.remove(s);
    }

    public void start()
    {
    }
}
