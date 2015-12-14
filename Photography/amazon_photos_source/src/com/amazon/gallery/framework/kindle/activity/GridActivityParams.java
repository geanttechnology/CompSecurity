// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.kindle.LaunchCamera;

public class GridActivityParams
{

    public final BeanFactory beanFactory;
    public int collection_list_status_bar;
    public LaunchCamera launchCamera;
    public Class settingsActivityClass;

    public GridActivityParams(int i, Class class1, LaunchCamera launchcamera, BeanFactory beanfactory)
    {
        collection_list_status_bar = i;
        settingsActivityClass = class1;
        launchCamera = launchcamera;
        beanFactory = beanfactory;
    }
}
