// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import com.nineoldandroids.util.Property;

final class PreHoneycombCompat
{

    static Property ALPHA = new _cls1("alpha");
    static Property PIVOT_X = new _cls2("pivotX");
    static Property PIVOT_Y = new _cls3("pivotY");
    static Property ROTATION = new _cls6("rotation");
    static Property ROTATION_X = new _cls7("rotationX");
    static Property ROTATION_Y = new _cls8("rotationY");
    static Property SCALE_X = new _cls9("scaleX");
    static Property SCALE_Y = new _cls10("scaleY");
    static Property SCROLL_X = new _cls11("scrollX");
    static Property SCROLL_Y = new _cls12("scrollY");
    static Property TRANSLATION_X = new _cls4("translationX");
    static Property TRANSLATION_Y = new _cls5("translationY");
    static Property X = new _cls13("x");
    static Property Y = new _cls14("y");

    private PreHoneycombCompat()
    {
    }


    private class _cls1 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setAlpha(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls1(String s)
        {
            super(s);
        }
    }


    private class _cls2 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setPivotX(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls2(String s)
        {
            super(s);
        }
    }


    private class _cls3 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setPivotY(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls3(String s)
        {
            super(s);
        }
    }


    private class _cls4 extends FloatProperty
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

        _cls4(String s)
        {
            super(s);
        }
    }


    private class _cls5 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setTranslationY(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls5(String s)
        {
            super(s);
        }
    }


    private class _cls6 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setRotation(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls6(String s)
        {
            super(s);
        }
    }


    private class _cls7 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setRotationX(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls7(String s)
        {
            super(s);
        }
    }


    private class _cls8 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setRotationY(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls8(String s)
        {
            super(s);
        }
    }


    private class _cls9 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setScaleX(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls9(String s)
        {
            super(s);
        }
    }


    private class _cls10 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setScaleY(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls10(String s)
        {
            super(s);
        }
    }


    private class _cls11 extends IntProperty
    {

        public Integer get(View view)
        {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, int i)
        {
            AnimatorProxy.wrap(view).setScrollX(i);
        }

        public volatile void setValue(Object obj, int i)
        {
            setValue((View)obj, i);
        }

        _cls11(String s)
        {
            super(s);
        }
    }


    private class _cls12 extends IntProperty
    {

        public Integer get(View view)
        {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, int i)
        {
            AnimatorProxy.wrap(view).setScrollY(i);
        }

        public volatile void setValue(Object obj, int i)
        {
            setValue((View)obj, i);
        }

        _cls12(String s)
        {
            super(s);
        }
    }


    private class _cls13 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setX(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls13(String s)
        {
            super(s);
        }
    }


    private class _cls14 extends FloatProperty
    {

        public Float get(View view)
        {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }

        public volatile Object get(Object obj)
        {
            return get((View)obj);
        }

        public void setValue(View view, float f)
        {
            AnimatorProxy.wrap(view).setY(f);
        }

        public volatile void setValue(Object obj, float f)
        {
            setValue((View)obj, f);
        }

        _cls14(String s)
        {
            super(s);
        }
    }

}
