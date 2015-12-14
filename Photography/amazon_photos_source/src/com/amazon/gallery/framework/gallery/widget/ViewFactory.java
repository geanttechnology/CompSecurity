// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.view.View;

public interface ViewFactory
{
    public static interface VisibleEqualityCheck
    {

        public abstract boolean visiblyEqual(Object obj, Object obj1);
    }


    public abstract View createView(Object obj);

    public abstract View getView(int i, Object obj, View view);

    public abstract void onViewDestroy(View view);

    public abstract void reset();

    public abstract void setBoundingSize(int i, int j);

    public abstract void setContext(Context context);
}
