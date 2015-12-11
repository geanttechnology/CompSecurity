// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.j;

public abstract class BadgeView extends FrameLayout
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a BIG;
        public static final a SMALL;
        public static final a X_LARGE;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/BadgeView$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            SMALL = new a("SMALL", 0);
            BIG = new a("BIG", 1);
            X_LARGE = new a("X_LARGE", 2);
            $VALUES = (new a[] {
                SMALL, BIG, X_LARGE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b ACTIVE;
        public static final b INACTIVE;
        public static final b INVERSE;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/ui/view/BadgeView$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            ACTIVE = new b("ACTIVE", 0);
            INACTIVE = new b("INACTIVE", 1);
            INVERSE = new b("INVERSE", 2);
            $VALUES = (new b[] {
                ACTIVE, INACTIVE, INVERSE
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final int INVALID_RESOURCE_ID = -1;
    private a mBadgeSize;
    private b mBadgeType;
    private ImageView mImage;
    private ImageView mLargeImage;
    private TextView mTextOverlay;

    public BadgeView(Context context)
    {
        super(context);
        a(((AttributeSet) (null)));
    }

    public BadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(attributeset);
    }

    public BadgeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(attributeset);
    }

    private void a()
    {
        setBackgroundSelector(mBadgeType);
        setContentDescription(getBadgeContentDescription());
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$BadgeView$BadgeSize[];
            static final int $SwitchMap$com$target$ui$view$BadgeView$BadgeType[];

            static 
            {
                $SwitchMap$com$target$ui$view$BadgeView$BadgeSize = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$BadgeView$BadgeSize[a.X_LARGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$view$BadgeView$BadgeSize[a.BIG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$view$BadgeView$BadgeSize[a.SMALL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$target$ui$view$BadgeView$BadgeType = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$BadgeView$BadgeType[b.ACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$view$BadgeView$BadgeType[b.INVERSE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$BadgeView$BadgeType[b.INACTIVE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.view.BadgeView.BadgeType[mBadgeType.ordinal()])
        {
        default:
            c();
            return;

        case 3: // '\003'
            e();
            return;

        case 2: // '\002'
            d();
            return;
        }
    }

    private void a(int i, int k, int l)
    {
        _cls1..SwitchMap.com.target.ui.view.BadgeView.BadgeSize[mBadgeSize.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 70
    //                   2 83;
           goto _L1 _L2 _L3
_L1:
        Drawable drawable = getResources().getDrawable(l);
_L5:
        i = getForegroundDrawable();
        if (i == -1)
        {
            a(getTextOverlay());
            mImage.setImageDrawable(drawable);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        drawable = getResources().getDrawable(i);
        continue; /* Loop/switch isn't completed */
_L3:
        drawable = getResources().getDrawable(k);
        if (true) goto _L5; else goto _L4
_L4:
        a(((String) (null)));
        Drawable drawable1 = getResources().getDrawable(i);
        if (a.X_LARGE.equals(mBadgeSize))
        {
            mImage.setImageDrawable(drawable);
            mLargeImage.setImageDrawable(drawable1);
            return;
        } else
        {
            mImage.setImageDrawable(new LayerDrawable(new Drawable[] {
                drawable, drawable1
            }));
            return;
        }
    }

    private void a(AttributeSet attributeset)
    {
        inflate(getContext(), 0x7f030101, this);
        mImage = (ImageView)findViewById(0x7f1002fa);
        mLargeImage = (ImageView)findViewById(0x7f1002fb);
        mTextOverlay = (TextView)findViewById(0x7f1002fc);
        mImage.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        setDefaultAttributes(attributeset);
        a();
    }

    private void a(a a1, boolean flag)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("DepartmentBadgeView BadgeSize can not be null");
        }
        mBadgeSize = a1;
        if (flag)
        {
            a();
        }
    }

    private void a(b b1, boolean flag)
    {
        if (b1 == null)
        {
            throw new IllegalArgumentException("DepartmentBadgeView BadgeType can not be null");
        }
        mBadgeType = b1;
        if (flag)
        {
            a();
        }
    }

    private void a(String s)
    {
        if (!o.g(s))
        {
            mTextOverlay.setText(null);
            return;
        }
        int i;
        if (s.length() > 3)
        {
            i = 0x7f0a02dd;
        } else
        if (s.length() > 2)
        {
            i = 0x7f0a02db;
        } else
        {
            i = 0x7f0a02bb;
        }
        mTextOverlay.setTextSize(0, getResources().getDimension(i));
        mTextOverlay.setText(s);
    }

    private void c()
    {
        a(0x7f0201b6, 0x7f0201b4, 0x7f0201b5);
    }

    private void d()
    {
        a(0x7f0201b9, 0x7f0201b7, 0x7f0201b8);
    }

    private void e()
    {
        a(0x7f0201bc, 0x7f0201ba, 0x7f0201bb);
    }

    private void setBackgroundSelector(b b1)
    {
        switch (_cls1..SwitchMap.com.target.ui.view.BadgeView.BadgeType[b1.ordinal()])
        {
        default:
            setClickable(false);
            setBackgroundResource(0);
            return;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (j.b())
        {
            setBackgroundResource(0x7f020047);
        } else
        {
            setBackgroundResource(0x7f020048);
        }
        setClickable(true);
    }

    private void setDefaultAttributes(AttributeSet attributeset)
    {
        mBadgeSize = a.SMALL;
        mBadgeType = b.ACTIVE;
        if (attributeset != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((attributeset = getContext().obtainStyledAttributes(attributeset, com.target.ui.a.a.DepartmentBadgeView)) == null) goto _L1; else goto _L3
_L3:
        attributeset.getInteger(1, -1);
        JVM INSTR tableswitch 0 2: default 68
    //                   0 105
    //                   1 115
    //                   2 125;
           goto _L4 _L5 _L6 _L7
_L4:
        attributeset.getInteger(0, -1);
        JVM INSTR tableswitch 0 2: default 100
    //                   0 135
    //                   1 145
    //                   2 155;
           goto _L8 _L9 _L10 _L11
_L8:
        attributeset.recycle();
        return;
_L5:
        mBadgeSize = a.BIG;
          goto _L4
_L6:
        mBadgeSize = a.SMALL;
          goto _L4
_L7:
        mBadgeSize = a.X_LARGE;
          goto _L4
_L9:
        mBadgeType = b.ACTIVE;
          goto _L8
_L10:
        mBadgeType = b.INACTIVE;
          goto _L8
_L11:
        mBadgeType = b.INVERSE;
          goto _L8
    }

    public void b()
    {
        a();
    }

    public abstract String getBadgeContentDescription();

    public a getBadgeSize()
    {
        return mBadgeSize;
    }

    public b getBadgeType()
    {
        return mBadgeType;
    }

    public abstract int getForegroundDrawable();

    public abstract String getTextOverlay();

    public void setBadgeSize(a a1)
    {
        a(a1, true);
    }

    public void setBadgeType(b b1)
    {
        a(b1, true);
    }
}
