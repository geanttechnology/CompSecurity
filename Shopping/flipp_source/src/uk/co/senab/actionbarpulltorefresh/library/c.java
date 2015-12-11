// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.k;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            f, p, v, s, 
//            u, q, r, d

public final class c extends f
{

    View a;
    private ViewGroup b;
    private TextView c;
    private SmoothProgressBar d;
    private CharSequence e;
    private CharSequence f;
    private CharSequence g;
    private int h;
    private long i;
    private int j;
    private int k;
    private final Interpolator l = new AccelerateInterpolator();

    protected c()
    {
        k = -2;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            throw new IllegalStateException("This HeaderTransformer is designed to run on SDK 14+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra.");
        } else
        {
            return;
        }
    }

    private static TypedArray a(Context context, int i1, int ai[])
    {
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(i1, typedvalue, true);
        return context.obtainStyledAttributes(typedvalue.resourceId, ai);
    }

    private static Drawable a(Context context)
    {
        context = a(context, 0x10102ce, new int[] {
            0x10100d4
        });
        Drawable drawable = context.getDrawable(0);
        context.recycle();
        return drawable;
        Exception exception;
        exception;
        context.recycle();
        throw exception;
    }

    private static int b(Context context)
    {
        context = context.getTheme().obtainStyledAttributes(new int[] {
            0x10102eb
        });
        int i1 = context.getDimensionPixelSize(0, 0);
        context.recycle();
        return i1;
        Exception exception;
        exception;
        context.recycle();
        throw exception;
    }

    private void b(Activity activity, View view)
    {
        TypedArray typedarray = a(activity, p.ptrHeaderStyle, v.PullToRefreshHeader);
        if (b != null)
        {
            int i1 = typedarray.getDimensionPixelSize(v.PullToRefreshHeader_ptrHeaderHeight, b(((Context) (activity))));
            b.getLayoutParams().height = i1;
            b.requestLayout();
        }
        int j1;
        if (typedarray.hasValue(v.PullToRefreshHeader_ptrHeaderBackground))
        {
            activity = typedarray.getDrawable(v.PullToRefreshHeader_ptrHeaderBackground);
        } else
        {
            activity = a(activity);
        }
        if (activity != null)
        {
            c.setBackgroundDrawable(activity);
            if (b != null && activity.getOpacity() == -1)
            {
                b.setBackgroundResource(0);
            }
        }
        activity = view.getContext();
        j1 = typedarray.getResourceId(v.PullToRefreshHeader_ptrHeaderTitleTextAppearance, c(activity));
        if (j1 != 0)
        {
            c.setTextAppearance(activity, j1);
        }
        if (typedarray.hasValue(v.PullToRefreshHeader_ptrProgressBarColor))
        {
            h = typedarray.getColor(v.PullToRefreshHeader_ptrProgressBarColor, h);
        }
        j = typedarray.getInt(v.PullToRefreshHeader_ptrProgressBarStyle, 1);
        if (typedarray.hasValue(v.PullToRefreshHeader_ptrProgressBarHeight))
        {
            k = typedarray.getDimensionPixelSize(v.PullToRefreshHeader_ptrProgressBarHeight, k);
        }
        if (typedarray.hasValue(v.PullToRefreshHeader_ptrPullText))
        {
            e = typedarray.getString(v.PullToRefreshHeader_ptrPullText);
        }
        if (typedarray.hasValue(v.PullToRefreshHeader_ptrRefreshingText))
        {
            f = typedarray.getString(v.PullToRefreshHeader_ptrRefreshingText);
        }
        if (typedarray.hasValue(v.PullToRefreshHeader_ptrReleaseText))
        {
            g = typedarray.getString(v.PullToRefreshHeader_ptrReleaseText);
        }
        typedarray.recycle();
    }

    private static int c(Context context)
    {
        context = a(context, 0x10102ce, new int[] {
            0x10102f8
        });
        int i1 = context.getResourceId(0, 0);
        context.recycle();
        return i1;
        Exception exception;
        exception;
        context.recycle();
        throw exception;
    }

    public final void a()
    {
        if (d != null)
        {
            d.setVisibility(0);
            d.setProgress(0);
            d.setIndeterminate(false);
        }
        if (c != null)
        {
            c.setVisibility(0);
            c.setText(e);
        }
        if (b != null)
        {
            b.setVisibility(0);
            ViewGroup viewgroup = b;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                viewgroup.setAlpha(1.0F);
            }
        }
    }

    public final void a(float f1)
    {
        if (d != null)
        {
            d.setVisibility(0);
            f1 = l.getInterpolation(f1);
            d.setProgress(Math.round(f1 * (float)d.getMax()));
        }
    }

    public final void a(Activity activity)
    {
        b(activity, a);
    }

    public final void a(Activity activity, View view)
    {
        a = view;
        d = (SmoothProgressBar)view.findViewById(s.ptr_progress);
        c = (TextView)view.findViewById(s.ptr_text);
        b = (ViewGroup)view.findViewById(s.ptr_content);
        e = activity.getString(u.pull_to_refresh_pull_label);
        f = activity.getString(u.pull_to_refresh_refreshing_label);
        g = activity.getString(u.pull_to_refresh_release_label);
        i = activity.getResources().getInteger(0x10e0000);
        h = activity.getResources().getColor(q.default_progress_bar_color);
        b(activity, view);
        activity = new android.widget.RelativeLayout.LayoutParams(-1, k);
        j;
        JVM INSTR tableswitch 0 1: default 156
    //                   0 275
    //                   1 287;
           goto _L1 _L2 _L3
_L1:
        d.setLayoutParams(activity);
        if (d != null)
        {
            int i1 = d.getResources().getDimensionPixelSize(r.ptr_progress_bar_stroke_width);
            d.setIndeterminateDrawable((new k(d.getContext())).a(h).b(i1).a());
            activity = new ShapeDrawable();
            activity.setShape(new RectShape());
            activity.getPaint().setColor(h);
            activity = new ClipDrawable(activity, 17, 1);
            d.setProgressDrawable(activity);
        }
        a();
        return;
_L2:
        activity.addRule(8, s.ptr_content);
        continue; /* Loop/switch isn't completed */
_L3:
        activity.addRule(3, s.ptr_content);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void b()
    {
        if (c != null)
        {
            c.setText(f);
        }
        if (d != null)
        {
            d.setVisibility(0);
            d.setIndeterminate(true);
        }
    }

    public final void c()
    {
        if (c != null)
        {
            c.setText(g);
        }
        if (d != null)
        {
            d.setProgress(d.getMax());
        }
    }

    public final void d()
    {
        if (b != null)
        {
            ObjectAnimator.ofFloat(b, "alpha", new float[] {
                1.0F, 0.0F
            }).start();
        }
    }

    public final boolean e()
    {
        boolean flag;
        if (a.getVisibility() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a.setVisibility(0);
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(b, "translationY", new float[] {
                    (float)(-b.getHeight()), 0.0F
                }), ObjectAnimator.ofFloat(a, "alpha", new float[] {
                    0.0F, 1.0F
                })
            });
            animatorset.setDuration(i);
            animatorset.start();
        }
        return flag;
    }

    public final boolean f()
    {
        boolean flag;
        if (a.getVisibility() != 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Object obj;
            if (b.getAlpha() >= 0.5F)
            {
                obj = new AnimatorSet();
                ObjectAnimator objectanimator = ObjectAnimator.ofFloat(b, "translationY", new float[] {
                    0.0F, (float)(-b.getHeight())
                });
                ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(a, "alpha", new float[] {
                    1.0F, 0.0F
                });
                ((AnimatorSet)obj).playTogether(new Animator[] {
                    objectanimator, objectanimator1
                });
            } else
            {
                obj = ObjectAnimator.ofFloat(a, "alpha", new float[] {
                    1.0F, 0.0F
                });
            }
            ((Animator) (obj)).setDuration(i);
            ((Animator) (obj)).addListener(new d(this));
            ((Animator) (obj)).start();
        }
        return flag;
    }
}
