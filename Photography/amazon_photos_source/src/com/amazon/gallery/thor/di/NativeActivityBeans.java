// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.di;

import android.content.Context;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.print.PrintContextWrapper;

public class NativeActivityBeans extends BeanFactory
{

    public NativeActivityBeans()
    {
    }

    public void init(Context context)
    {
        super.init(context);
        putBean(Keys.PRINT_CONTEXT, new PrintContextWrapper());
    }
}
