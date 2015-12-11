// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewUtil
{
    public static final class ResizeAnimationType extends Enum
    {

        private static final ResizeAnimationType $VALUES[];
        public static final ResizeAnimationType COLLAPSE_HEIGHT;
        public static final ResizeAnimationType COLLAPSE_WIDTH;
        public static final ResizeAnimationType EXPAND_HEIGHT;
        public static final ResizeAnimationType EXPAND_WIDTH;

        public static ResizeAnimationType valueOf(String s)
        {
            return (ResizeAnimationType)Enum.valueOf(co/vine/android/util/ViewUtil$ResizeAnimationType, s);
        }

        public static ResizeAnimationType[] values()
        {
            return (ResizeAnimationType[])$VALUES.clone();
        }

        static 
        {
            EXPAND_WIDTH = new ResizeAnimationType("EXPAND_WIDTH", 0);
            EXPAND_HEIGHT = new ResizeAnimationType("EXPAND_HEIGHT", 1);
            COLLAPSE_WIDTH = new ResizeAnimationType("COLLAPSE_WIDTH", 2);
            COLLAPSE_HEIGHT = new ResizeAnimationType("COLLAPSE_HEIGHT", 3);
            $VALUES = (new ResizeAnimationType[] {
                EXPAND_WIDTH, EXPAND_HEIGHT, COLLAPSE_WIDTH, COLLAPSE_HEIGHT
            });
        }

        private ResizeAnimationType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.view.View.OnClickListener EMPTY_VIEW_CLICK_LISTENER = new android.view.View.OnClickListener() {

        public void onClick(View view)
        {
        }

    };
    private static int sActionBarHeight = -1;

    public ViewUtil()
    {
    }

    public static void fillColor(Resources resources, int i, int j, View view)
    {
        if (view instanceof ImageView)
        {
            ((ImageView)view).setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
            return;
        } else
        {
            resources = resources.getDrawable(j);
            resources.setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
            setBackground(view, resources);
            return;
        }
    }

    public static int getActionBarHeight(Context context)
    {
        if (sActionBarHeight < 0)
        {
            context = context.getTheme().obtainStyledAttributes(new int[] {
                0x10102eb
            });
            sActionBarHeight = (int)context.getDimension(0, -1F);
            context.recycle();
        }
        return sActionBarHeight;
    }

    public static float getFontScale(Context context)
    {
        return context.getResources().getConfiguration().fontScale;
    }

    public static int getPecentageColor(float f, int i)
    {
        return (int)(255F * f) << 24 | i;
    }

    public static Animation makeResizeAnimation(ResizeAnimationType resizeanimationtype, View view, int i)
    {
        return makeResizeAnimation(resizeanimationtype, view, i, -1, null);
    }

    public static Animation makeResizeAnimation(ResizeAnimationType resizeanimationtype, View view, int i, int j)
    {
        return makeResizeAnimation(resizeanimationtype, view, i, j, null);
    }

    public static Animation makeResizeAnimation(ResizeAnimationType resizeanimationtype, View view, int i, int j, android.view.animation.Animation.AnimationListener animationlistener)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        boolean flag;
        boolean flag1;
        if (resizeanimationtype == ResizeAnimationType.EXPAND_WIDTH || resizeanimationtype == ResizeAnimationType.COLLAPSE_WIDTH)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (resizeanimationtype == ResizeAnimationType.EXPAND_WIDTH || resizeanimationtype == ResizeAnimationType.EXPAND_HEIGHT)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (flag1)
            {
                layoutparams.width = 0;
            } else
            {
                layoutparams.height = 0;
            }
            view.setVisibility(0);
            resizeanimationtype = new Animation(flag1, layoutparams, i, view) {

                final android.view.ViewGroup.LayoutParams val$params;
                final int val$targetSize;
                final boolean val$typeWidth;
                final View val$v;

                protected void applyTransformation(float f, Transformation transformation)
                {
                    if (typeWidth)
                    {
                        transformation = params;
                        int k;
                        if (f == 1.0F)
                        {
                            k = targetSize;
                        } else
                        {
                            k = (int)((float)targetSize * f);
                        }
                        transformation.width = k;
                    } else
                    {
                        transformation = params;
                        int l;
                        if (f == 1.0F)
                        {
                            l = targetSize;
                        } else
                        {
                            l = (int)((float)targetSize * f);
                        }
                        transformation.height = l;
                    }
                    v.requestLayout();
                }

                public boolean willChangeBounds()
                {
                    return true;
                }

            
            {
                typeWidth = flag;
                params = layoutparams;
                targetSize = i;
                v = view;
                super();
            }
            };
        } else
        {
            if (flag1)
            {
                i = view.getMeasuredWidth();
            } else
            {
                i = view.getMeasuredHeight();
            }
            resizeanimationtype = new Animation(view, flag1, layoutparams, i) {

                final int val$initialSize;
                final android.view.ViewGroup.LayoutParams val$params;
                final boolean val$typeWidth;
                final View val$v;

                protected void applyTransformation(float f, Transformation transformation)
                {
                    if (f == 1.0F)
                    {
                        v.setVisibility(8);
                        return;
                    }
                    if (typeWidth)
                    {
                        params.width = initialSize - (int)((float)initialSize * f);
                    } else
                    {
                        params.height = initialSize - (int)((float)initialSize * f);
                    }
                    v.requestLayout();
                }

                public boolean willChangeBounds()
                {
                    return true;
                }

            
            {
                v = view;
                typeWidth = flag;
                params = layoutparams;
                initialSize = i;
                super();
            }
            };
        }
        if (j > 0)
        {
            resizeanimationtype.setDuration(j);
        }
        resizeanimationtype.setAnimationListener(animationlistener);
        return resizeanimationtype;
    }

    public static transient void reduceTextSizeViaFontScaleIfNeeded(Context context, float f, float f1, TextView atextview[])
    {
        float f2 = getFontScale(context);
        if (f2 > f)
        {
            int j = atextview.length;
            for (int i = 0; i < j; i++)
            {
                stepDownViaFontScale(atextview[i], f2, f1);
            }

        }
    }

    public static void setActionBarHeight(ActionBarActivity actionbaractivity, View view)
    {
        int i = getActionBarHeight(actionbaractivity);
        if (i > 0)
        {
            view.getLayoutParams().height = i;
            return;
        } else
        {
            setActionBarHeightWhenReady(actionbaractivity, view);
            return;
        }
    }

    public static void setActionBarHeightWhenReady(ActionBarActivity actionbaractivity, View view)
    {
        ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
        if (viewtreeobserver != null)
        {
            viewtreeobserver.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(actionbaractivity, view, viewtreeobserver) {

                final ActionBarActivity val$actionBarActivity;
                final ViewTreeObserver val$observer;
                final View val$viewToSet;

                public void onGlobalLayout()
                {
label0:
                    {
                        ActionBar actionbar = actionBarActivity.getSupportActionBar();
                        if (actionbar != null)
                        {
                            int i = actionbar.getHeight();
                            if (i > 0)
                            {
                                viewToSet.getLayoutParams().height = i;
                                if (android.os.Build.VERSION.SDK_INT >= 16)
                                {
                                    break label0;
                                }
                                observer.removeGlobalOnLayoutListener(this);
                            }
                        }
                        return;
                    }
                    observer.removeOnGlobalLayoutListener(this);
                }

            
            {
                actionBarActivity = actionbaractivity;
                viewToSet = view;
                observer = viewtreeobserver;
                super();
            }
            });
        }
    }

    public static void setBackground(Resources resources, View view, Bitmap bitmap)
    {
        setBackground(view, ((Drawable) (new BitmapDrawable(resources, bitmap))));
    }

    public static void setBackground(View view, Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setBackground(drawable);
            return;
        } else
        {
            view.setBackgroundDrawable(drawable);
            return;
        }
    }

    public static void stepDownViaFontScale(TextView textview, float f, float f1)
    {
        textview.setTextSize(0, (float)((double)textview.getTextSize() - (double)f1 * (1.0D - (1.5D - (double)f))));
    }

}
