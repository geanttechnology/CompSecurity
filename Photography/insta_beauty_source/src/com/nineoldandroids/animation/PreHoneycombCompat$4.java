// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class  extends FloatProperty
{

    public Float get(View view)
    {
        return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
    }

    public volatile Object get(Object obj)
    {
        return get((View)obj);
    }

    public void setValue(View view, float f)
    {
        AnimatorProxy.wrap(view).setTranslationX(f);
    }

    public volatile void setValue(Object obj, float f)
    {
        setValue((View)obj, f);
    }

    (String s)
    {
        super(s);
    }
}
