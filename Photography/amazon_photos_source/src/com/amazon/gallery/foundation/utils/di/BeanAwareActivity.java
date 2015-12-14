// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.di;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.amazon.gallery.foundation.utils.DebugAssert;

// Referenced classes of package com.amazon.gallery.foundation.utils.di:
//            BeanFactory, BeanAwareApplication, BeanKey

public class BeanAwareActivity extends AppCompatActivity
{

    protected final BeanFactory beanFactory;

    public BeanAwareActivity(BeanFactory beanfactory)
    {
        beanFactory = beanfactory;
    }

    public Object getApplicationBean(BeanKey beankey)
    {
        return getApplicationBeanFactory().getBean(beankey);
    }

    public BeanFactory getApplicationBeanFactory()
    {
        return ((BeanAwareApplication)getApplication()).getBeanFactory();
    }

    public Object getBean(BeanKey beankey)
    {
        return getBeanFactory().getBean(beankey);
    }

    public BeanFactory getBeanFactory()
    {
        return beanFactory;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        DebugAssert.enableStrictMode();
        beanFactory.init(this);
    }

    protected void onDestroy()
    {
        beanFactory.release();
        super.onDestroy();
    }
}
