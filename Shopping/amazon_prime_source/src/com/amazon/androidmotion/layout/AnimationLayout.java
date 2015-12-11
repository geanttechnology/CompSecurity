// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.amazon.androidmotion.util.ViewUtil;

public class AnimationLayout
{
    public static final class DuplicateZIndexes extends Enum
    {

        private static final DuplicateZIndexes $VALUES[];
        public static final DuplicateZIndexes STACK_ABOVE;
        public static final DuplicateZIndexes STACK_BELOW;

        public static DuplicateZIndexes valueOf(String s)
        {
            return (DuplicateZIndexes)Enum.valueOf(com/amazon/androidmotion/layout/AnimationLayout$DuplicateZIndexes, s);
        }

        public static DuplicateZIndexes[] values()
        {
            return (DuplicateZIndexes[])$VALUES.clone();
        }

        static 
        {
            STACK_ABOVE = new DuplicateZIndexes("STACK_ABOVE", 0);
            STACK_BELOW = new DuplicateZIndexes("STACK_BELOW", 1);
            $VALUES = (new DuplicateZIndexes[] {
                STACK_ABOVE, STACK_BELOW
            });
        }

        private DuplicateZIndexes(String s, int i)
        {
            super(s, i);
        }
    }

    private class LayoutHolder
    {

        private RelativeLayout mLayout;
        final AnimationLayout this$0;

        public RelativeLayout getLayout()
        {
            if (mLayout == null)
            {
                throw new IllegalStateException("no layout has been set on this AnimationLayout");
            } else
            {
                return mLayout;
            }
        }

        public void setLayout(RelativeLayout relativelayout)
        {
            mLayout = relativelayout;
        }

        private LayoutHolder()
        {
            this$0 = AnimationLayout.this;
            super();
        }

    }


    private final Context mContext;
    private final LayoutHolder mLayoutHolder = new LayoutHolder();
    private final int mZIndexResId;

    public AnimationLayout(Context context, int i)
    {
        mContext = context;
        mZIndexResId = i;
    }

    private void checkViewIsInLayout(View view)
    {
        if (!hasView(view))
        {
            throw new IllegalArgumentException("specified view is not in this AnimationLayout");
        } else
        {
            return;
        }
    }

    private int findInsertionIndex(int i, DuplicateZIndexes duplicatezindexes)
    {
        RelativeLayout relativelayout = mLayoutHolder.getLayout();
        int j = 0;
        do
        {
label0:
            {
                if (j < relativelayout.getChildCount())
                {
                    Integer integer = (Integer)relativelayout.getChildAt(j).getTag(mZIndexResId);
                    if (integer == null || (duplicatezindexes != DuplicateZIndexes.STACK_ABOVE || integer.intValue() <= i) && (duplicatezindexes != DuplicateZIndexes.STACK_BELOW || integer.intValue() < i))
                    {
                        break label0;
                    }
                }
                return j;
            }
            j++;
        } while (true);
    }

    public void addView(View view, int i)
    {
        addView(view, i, DuplicateZIndexes.STACK_ABOVE);
    }

    public void addView(View view, int i, DuplicateZIndexes duplicatezindexes)
    {
        view.setTag(mZIndexResId, Integer.valueOf(i));
        mLayoutHolder.getLayout().addView(view, findInsertionIndex(i, duplicatezindexes));
    }

    public void bringToFront(View view)
    {
        checkViewIsInLayout(view);
        setZIndex(view, getLargestZIndex(), DuplicateZIndexes.STACK_ABOVE);
    }

    public ImageView createImageView(int i, int j, int k, int l, int i1)
    {
        return createImageView(i, j, k, l, i1, DuplicateZIndexes.STACK_ABOVE);
    }

    public ImageView createImageView(int i, int j, int k, int l, int i1, DuplicateZIndexes duplicatezindexes)
    {
        ImageView imageview = new ImageView(mContext);
        place(imageview, i, j, i1, duplicatezindexes);
        duplicatezindexes = imageview.getLayoutParams();
        duplicatezindexes.width = k;
        duplicatezindexes.height = l;
        imageview.setLayoutParams(duplicatezindexes);
        imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        return imageview;
    }

    public int getLargestZIndex()
    {
        RelativeLayout relativelayout = mLayoutHolder.getLayout();
        int j = 0x80000000;
        boolean flag = false;
        for (int i = 0; i < relativelayout.getChildCount();)
        {
            Integer integer = (Integer)relativelayout.getChildAt(i).getTag(mZIndexResId);
            boolean flag1 = flag;
            int k = j;
            if (integer != null)
            {
                flag1 = flag;
                k = j;
                if (integer.intValue() > j)
                {
                    flag1 = true;
                    k = integer.intValue();
                }
            }
            i++;
            flag = flag1;
            j = k;
        }

        if (flag)
        {
            return j;
        } else
        {
            return 0;
        }
    }

    public int getSmallestZIndex()
    {
        RelativeLayout relativelayout = mLayoutHolder.getLayout();
        int j = 0x7fffffff;
        boolean flag = false;
        for (int i = 0; i < relativelayout.getChildCount();)
        {
            Integer integer = (Integer)relativelayout.getChildAt(i).getTag(mZIndexResId);
            boolean flag1 = flag;
            int k = j;
            if (integer != null)
            {
                flag1 = flag;
                k = j;
                if (integer.intValue() < j)
                {
                    flag1 = true;
                    k = integer.intValue();
                }
            }
            i++;
            flag = flag1;
            j = k;
        }

        if (flag)
        {
            return j;
        } else
        {
            return 0;
        }
    }

    public int getZIndex(View view)
    {
        checkViewIsInLayout(view);
        return ((Integer)view.getTag(mZIndexResId)).intValue();
    }

    public boolean hasView(View view)
    {
        return view.getParent() != null && view.getParent() == mLayoutHolder.getLayout() && view.getTag(mZIndexResId) != null;
    }

    public ImageView place(Bitmap bitmap, int i, int j, int k, int l, int i1)
    {
        return place(bitmap, i, j, k, l, i1, DuplicateZIndexes.STACK_ABOVE);
    }

    public ImageView place(Bitmap bitmap, int i, int j, int k, int l, int i1, DuplicateZIndexes duplicatezindexes)
    {
        duplicatezindexes = createImageView(i, j, k, l, i1, duplicatezindexes);
        duplicatezindexes.setImageBitmap(bitmap);
        return duplicatezindexes;
    }

    public ImageView place(Drawable drawable, int i, int j, int k, int l, int i1)
    {
        return place(drawable, i, j, k, l, i1, DuplicateZIndexes.STACK_ABOVE);
    }

    public ImageView place(Drawable drawable, int i, int j, int k, int l, int i1, DuplicateZIndexes duplicatezindexes)
    {
        duplicatezindexes = createImageView(i, j, k, l, i1, duplicatezindexes);
        duplicatezindexes.setImageDrawable(drawable);
        return duplicatezindexes;
    }

    public void place(View view, int i, int j, int k)
    {
        place(view, i, j, k, DuplicateZIndexes.STACK_ABOVE);
    }

    public void place(View view, int i, int j, int k, DuplicateZIndexes duplicatezindexes)
    {
        addView(view, k, duplicatezindexes);
        duplicatezindexes = new int[2];
        transformToLocalCoords(i, j, duplicatezindexes);
        view.setTranslationX(duplicatezindexes[0]);
        view.setTranslationY(duplicatezindexes[1]);
    }

    public void removeView(View view)
    {
        if (hasView(view))
        {
            mLayoutHolder.getLayout().removeView(view);
            view.setTag(mZIndexResId, null);
        }
    }

    public void removeViewOnEnd(final View view, Animator animator)
    {
        animator.addListener(new AnimatorListenerAdapter() {

            final AnimationLayout this$0;
            final View val$view;

            public void onAnimationEnd(Animator animator1)
            {
                if (hasView(view))
                {
                    removeView(view);
                }
            }

            
            {
                this$0 = AnimationLayout.this;
                view = view1;
                super();
            }
        });
    }

    public void sendToBack(View view)
    {
        checkViewIsInLayout(view);
        setZIndex(view, getSmallestZIndex(), DuplicateZIndexes.STACK_BELOW);
    }

    public void setLayout(RelativeLayout relativelayout)
    {
        mLayoutHolder.setLayout(relativelayout);
    }

    public void setZIndex(View view, int i)
    {
        setZIndex(view, i, DuplicateZIndexes.STACK_ABOVE);
    }

    public void setZIndex(View view, int i, DuplicateZIndexes duplicatezindexes)
    {
        checkViewIsInLayout(view);
        removeView(view);
        addView(view, i, duplicatezindexes);
    }

    public void transformToLocalCoords(int i, int j, int ai[])
    {
        ViewUtil.transformToLocalCoords(mLayoutHolder.getLayout(), i, j, ai);
    }

    public void transformToScreenCoords(int i, int j, int ai[])
    {
        ViewUtil.transformToScreenCoords(mLayoutHolder.getLayout(), i, j, ai);
    }
}
