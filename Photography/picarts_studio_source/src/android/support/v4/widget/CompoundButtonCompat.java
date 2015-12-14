// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

public final class CompoundButtonCompat
{

    private static final CompoundButtonCompatImpl IMPL;

    private CompoundButtonCompat()
    {
    }

    public static Drawable getButtonDrawable(CompoundButton compoundbutton)
    {
        return IMPL.getButtonDrawable(compoundbutton);
    }

    public static ColorStateList getButtonTintList(CompoundButton compoundbutton)
    {
        return IMPL.getButtonTintList(compoundbutton);
    }

    public static android.graphics.PorterDuff.Mode getButtonTintMode(CompoundButton compoundbutton)
    {
        return IMPL.getButtonTintMode(compoundbutton);
    }

    public static void setButtonTintList(CompoundButton compoundbutton, ColorStateList colorstatelist)
    {
        IMPL.setButtonTintList(compoundbutton, colorstatelist);
    }

    public static void setButtonTintMode(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode)
    {
        IMPL.setButtonTintMode(compoundbutton, mode);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 23)
        {
            IMPL = new Api23CompoundButtonImpl();
        } else
        if (i >= 21)
        {
            IMPL = new LollipopCompoundButtonImpl();
        } else
        {
            IMPL = new BaseCompoundButtonCompat();
        }
    }

    private class CompoundButtonCompatImpl
    {

        public abstract Drawable getButtonDrawable(CompoundButton compoundbutton);

        public abstract ColorStateList getButtonTintList(CompoundButton compoundbutton);

        public abstract android.graphics.PorterDuff.Mode getButtonTintMode(CompoundButton compoundbutton);

        public abstract void setButtonTintList(CompoundButton compoundbutton, ColorStateList colorstatelist);

        public abstract void setButtonTintMode(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode);
    }


    private class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl
    {
        private class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat
        {
            private class BaseCompoundButtonCompat
                implements CompoundButtonCompatImpl
            {

                public Drawable getButtonDrawable(CompoundButton compoundbutton)
                {
                    return CompoundButtonCompatDonut.getButtonDrawable(compoundbutton);
                }

                public ColorStateList getButtonTintList(CompoundButton compoundbutton)
                {
                    return CompoundButtonCompatDonut.getButtonTintList(compoundbutton);
                }

                public android.graphics.PorterDuff.Mode getButtonTintMode(CompoundButton compoundbutton)
                {
                    return CompoundButtonCompatDonut.getButtonTintMode(compoundbutton);
                }

                public void setButtonTintList(CompoundButton compoundbutton, ColorStateList colorstatelist)
                {
                    CompoundButtonCompatDonut.setButtonTintList(compoundbutton, colorstatelist);
                }

                public void setButtonTintMode(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode)
                {
                    CompoundButtonCompatDonut.setButtonTintMode(compoundbutton, mode);
                }

                BaseCompoundButtonCompat()
                {
                }
            }


            public ColorStateList getButtonTintList(CompoundButton compoundbutton)
            {
                return CompoundButtonCompatLollipop.getButtonTintList(compoundbutton);
            }

            public android.graphics.PorterDuff.Mode getButtonTintMode(CompoundButton compoundbutton)
            {
                return CompoundButtonCompatLollipop.getButtonTintMode(compoundbutton);
            }

            public void setButtonTintList(CompoundButton compoundbutton, ColorStateList colorstatelist)
            {
                CompoundButtonCompatLollipop.setButtonTintList(compoundbutton, colorstatelist);
            }

            public void setButtonTintMode(CompoundButton compoundbutton, android.graphics.PorterDuff.Mode mode)
            {
                CompoundButtonCompatLollipop.setButtonTintMode(compoundbutton, mode);
            }

            LollipopCompoundButtonImpl()
            {
            }
        }


        public Drawable getButtonDrawable(CompoundButton compoundbutton)
        {
            return CompoundButtonCompatApi23.getButtonDrawable(compoundbutton);
        }

        Api23CompoundButtonImpl()
        {
        }
    }

}
