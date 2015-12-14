// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.network.upload.UploadPreferences;

public abstract class GalleryApplication extends BeanAwareApplication
{

    private static final String TAG = com/amazon/gallery/framework/kindle/GalleryApplication.getName();

    public GalleryApplication(BeanFactory beanfactory)
    {
        super(beanfactory);
    }

    public void onCreate()
    {
        super.onCreate();
        DebugAssert.enableStrictMode();
        UploadPreferences.initializeDefaultPreferences(this);
    }

}
