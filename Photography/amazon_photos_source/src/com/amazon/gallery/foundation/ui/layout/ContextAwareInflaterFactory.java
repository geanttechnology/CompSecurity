// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.di.BeanKey;

public class ContextAwareInflaterFactory
{
    private static class Factory
        implements android.view.LayoutInflater.Factory
    {

        private BeanFactory beanFactory;

        public View onCreateView(String s, Context context, AttributeSet attributeset)
        {
            if ("ContextBean".contains(s))
            {
                attributeset = attributeset.getAttributeValue("http://schemas.amazon.com/android/gallery", "key");
                try
                {
                    context = (View)beanFactory.getBean(new BeanKey(attributeset, android/view/View));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new RuntimeException((new StringBuilder()).append("The bean '").append(attributeset).append("' which you are trying to insert into layout xml must be View").toString(), s);
                }
                s = context;
                if (context == null)
                {
                    throw new RuntimeException((new StringBuilder()).append("The bean '").append(attributeset).append("' which you are trying to insert into layout xml hasn't been put in the context").toString());
                }
            } else
            {
                s = null;
            }
            return s;
        }

        public Factory(BeanFactory beanfactory)
        {
            beanFactory = beanfactory;
        }
    }


    public static LayoutInflater create(BeanAwareActivity beanawareactivity, BeanFactory beanfactory)
    {
        beanawareactivity = ((LayoutInflater)beanawareactivity.getSystemService("layout_inflater")).cloneInContext(beanawareactivity);
        beanawareactivity.setFactory(new Factory(beanfactory));
        return beanawareactivity;
    }
}
