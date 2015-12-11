// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.b.ad;
import com.a.b.aq;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.widget:
//            CustomEditText, dc, dd, de, 
//            df, dk, dj, dg, 
//            dh, di

public final class db extends FrameLayout
{

    public boolean a;
    private final RelativeLayout b;
    private final CustomEditText c;
    private final CheckBox d;
    private final TextView e;
    private final TextView f;
    private final View g;
    private final TextView h;
    private final ImageView i;
    private final ImageView j;
    private final ProgressBar k;
    private final ImageView l;
    private final LinearLayout m;
    private final ArrayList n;
    private ArrayList o;
    private final GestureDetector p;
    private int q;
    private dj r;
    private AnimatorSet s;
    private long t;
    private int u;

    public db(Context context)
    {
        this(context, (byte)0);
    }

    private db(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private db(Context context, char c1)
    {
        super(context, null, 0);
        n = new ArrayList();
        t = -1L;
        View.inflate(context, 0x7f03004d, this);
        b = (RelativeLayout)findViewById(0x7f0b011e);
        c = (CustomEditText)findViewById(0x7f0b0121);
        d = (CheckBox)findViewById(0x7f0b0120);
        e = (TextView)findViewById(0x7f0b012c);
        f = (TextView)findViewById(0x7f0b012d);
        g = findViewById(0x7f0b012b);
        h = (TextView)findViewById(0x7f0b0124);
        i = (ImageView)findViewById(0x7f0b0123);
        j = (ImageView)findViewById(0x7f0b0125);
        k = (ProgressBar)findViewById(0x7f0b0126);
        l = (ImageView)findViewById(0x7f0b012e);
        m = (LinearLayout)findViewById(0x7f0b0122);
        n.add((ImageView)findViewById(0x7f0b0127));
        n.add((ImageView)findViewById(0x7f0b0128));
        n.add((ImageView)findViewById(0x7f0b0129));
        n.add((ImageView)findViewById(0x7f0b012a));
        d.setOnClickListener(new dc(this));
        l.setOnClickListener(new dd(this));
        p = new GestureDetector(context, new de(this));
        b.setOnTouchListener(new df(this));
        u = 0;
        setState$282bce2c(dk.b);
    }

    static dj a(db db1)
    {
        return db1.r;
    }

    static int b(db db1)
    {
        return db1.q;
    }

    static GestureDetector c(db db1)
    {
        return db1.p;
    }

    static LinearLayout d(db db1)
    {
        return db1.m;
    }

    static boolean e(db db1)
    {
        boolean flag = false;
        Iterator iterator = db1.n.iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((ImageView)iterator.next()).getDrawable() != null)
            {
                i1++;
            }
        } while (true);
        if (i1 == db1.o.size())
        {
            flag = true;
        }
        return flag;
    }

    static AnimatorSet f(db db1)
    {
        return db1.s;
    }

    private void setThumbnailsVisible(boolean flag)
    {
        Iterator iterator = n.iterator();
        while (iterator.hasNext()) 
        {
            View view = (View)iterator.next();
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            view.setVisibility(i1);
        }
    }

    public final void a()
    {
        ImageView imageview;
        for (Iterator iterator = n.iterator(); iterator.hasNext(); imageview.setImageDrawable(null))
        {
            imageview = (ImageView)iterator.next();
            ad.a(getContext()).a(imageview);
        }

        if (s != null && s.isRunning())
        {
            s.cancel();
        }
        measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        for (Iterator iterator1 = n.iterator(); iterator1.hasNext(); ((ImageView)iterator1.next()).setTranslationY(getMeasuredHeight())) { }
        g.setTranslationX(g.getMeasuredWidth());
        m.setTranslationX(0.0F);
    }

    public final void b()
    {
        if (s != null)
        {
            s.cancel();
        }
        if (o == null)
        {
            if (r != null)
            {
                r.d(this);
            }
        } else
        {
            setState$282bce2c(dk.b);
            a();
            AnimatorSet animatorset = new AnimatorSet();
            measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            float f1 = getMeasuredHeight();
            int i1 = n.size() - o.size();
            Object obj = null;
            for (long l1 = 0L; i1 < n.size(); l1 = 1L + l1)
            {
                obj = (ImageView)n.get(i1);
                ObjectAnimator objectanimator = ObjectAnimator.ofFloat(obj, "translationY", new float[] {
                    0.0F
                });
                objectanimator.setInterpolator(new DecelerateInterpolator(1.4F));
                obj = ObjectAnimator.ofFloat(obj, "translationY", new float[] {
                    f1
                });
                ((ObjectAnimator) (obj)).setInterpolator(new AccelerateInterpolator(1.4F));
                objectanimator.setDuration(450L);
                ((ObjectAnimator) (obj)).setDuration(450L);
                objectanimator.setStartDelay(180L * l1);
                animatorset.play(((android.animation.Animator) (obj))).after(objectanimator);
                i1++;
            }

            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(g, "translationX", new float[] {
                (float)g.getMeasuredWidth(), 0.0F
            });
            objectanimator1.setDuration(400L);
            PropertyValuesHolder propertyvaluesholder;
            if (obj != null)
            {
                animatorset.play(objectanimator1).after(((android.animation.Animator) (obj)));
            } else
            {
                animatorset.play(objectanimator1);
            }
            obj = ObjectAnimator.ofFloat(g, "translationX", new float[] {
                (float)g.getMeasuredWidth()
            });
            ((ObjectAnimator) (obj)).setStartDelay(500L);
            ((ObjectAnimator) (obj)).setDuration(400L);
            animatorset.play(((android.animation.Animator) (obj))).after(objectanimator1);
            obj = PropertyValuesHolder.ofFloat("translationX", new float[] {
                (float)(-e.getMeasuredWidth()), 0.0F
            });
            propertyvaluesholder = PropertyValuesHolder.ofFloat("alpha", new float[] {
                0.0F, 1.0F
            });
            obj = ObjectAnimator.ofPropertyValuesHolder(m, new PropertyValuesHolder[] {
                obj, propertyvaluesholder
            });
            ((ObjectAnimator) (obj)).setDuration(400L);
            ((ObjectAnimator) (obj)).setStartDelay(500L);
            animatorset.play(((android.animation.Animator) (obj))).after(objectanimator1);
            animatorset.addListener(new dg(this));
            s = animatorset;
            if (o == null || o.isEmpty())
            {
                setState$282bce2c(dk.c);
                s.start();
                return;
            }
            i1 = 0;
            while (i1 < o.size()) 
            {
                ad.a(getContext()).a((String)o.get(i1)).a((ImageView)n.get(n.size() - 1 - i1), new dh(this));
                i1++;
            }
        }
    }

    public final boolean getChecked()
    {
        return d.isChecked();
    }

    public final int getClipCount()
    {
        return Integer.parseInt(h.getText().toString());
    }

    public final dj getListener()
    {
        return r;
    }

    public final long getLongTag()
    {
        return t;
    }

    public final String getName()
    {
        return c.getText().toString();
    }

    public final int getResultCount()
    {
        return Integer.parseInt(e.getText().toString());
    }

    public final int getState$1599ee8e()
    {
        return q;
    }

    public final ArrayList getThumbnailUrls()
    {
        return o;
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        if (c.getRight() > m.getLeft())
        {
            c.setRight(m.getLeft());
        }
    }

    public final void setChecked(boolean flag)
    {
        boolean flag2 = true;
        d.setChecked(flag);
        CustomEditText customedittext = c;
        int i1;
        boolean flag1;
        if (flag)
        {
            i1 = c.getPaintFlags() | 0x10;
        } else
        {
            i1 = c.getPaintFlags() & 0xffffffef;
        }
        customedittext.setPaintFlags(i1);
        customedittext = c;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        customedittext.setFocusableInTouchMode(flag1);
        customedittext = c;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        customedittext.setFocusable(flag);
    }

    public final void setClipCount(int i1)
    {
        u = i1;
        h.setText(Integer.toString(i1));
    }

    public final void setListener(dj dj1)
    {
        r = dj1;
    }

    public final void setLongTag(long l1)
    {
        t = l1;
    }

    public final void setName(String s1)
    {
        c.setText(s1);
    }

    public final void setResultCount(int i1)
    {
        if (i1 == 0)
        {
            f.setText(0x7f0e0133);
        } else
        if (i1 == 1)
        {
            f.setText(0x7f0e0131);
        } else
        {
            f.setText(0x7f0e0132);
        }
        e.setText(Integer.toString(i1));
    }

    public final void setState$282bce2c(int i1)
    {
        q = i1;
        switch (di.a[q - 1])
        {
        default:
            throw new InvalidParameterException("Invalid shopping cell state");

        case 1: // '\001'
            b.setClickable(true);
            p.setIsLongpressEnabled(true);
            d.setEnabled(true);
            k.setVisibility(4);
            c.setEnabled(true);
            j.setVisibility(0);
            m.setVisibility(0);
            m.setAlpha(1.0F);
            Object obj = h;
            if (u > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ((TextView) (obj)).setVisibility(i1);
            obj = i;
            if (u > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ((ImageView) (obj)).setVisibility(i1);
            l.setVisibility(4);
            g.setVisibility(4);
            setThumbnailsVisible(false);
            return;

        case 2: // '\002'
            b.setClickable(true);
            p.setIsLongpressEnabled(true);
            d.setEnabled(true);
            k.setVisibility(0);
            c.setEnabled(false);
            j.setVisibility(4);
            m.setVisibility(4);
            m.setAlpha(1.0F);
            h.setVisibility(4);
            i.setVisibility(4);
            l.setVisibility(4);
            g.setVisibility(4);
            setThumbnailsVisible(false);
            return;

        case 3: // '\003'
            b.setClickable(true);
            p.setIsLongpressEnabled(true);
            d.setEnabled(true);
            k.setVisibility(4);
            c.setEnabled(false);
            j.setVisibility(4);
            m.setVisibility(0);
            m.setAlpha(0.0F);
            Object obj1 = h;
            if (u > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ((TextView) (obj1)).setVisibility(i1);
            obj1 = i;
            if (u > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            ((ImageView) (obj1)).setVisibility(i1);
            l.setVisibility(4);
            g.setVisibility(0);
            setThumbnailsVisible(true);
            return;

        case 4: // '\004'
            b.setClickable(false);
            p.setIsLongpressEnabled(false);
            d.setEnabled(false);
            k.setVisibility(4);
            c.setEnabled(false);
            j.setVisibility(4);
            m.setVisibility(4);
            m.setAlpha(1.0F);
            h.setVisibility(4);
            i.setVisibility(4);
            l.setVisibility(0);
            g.setVisibility(4);
            setThumbnailsVisible(false);
            return;
        }
    }

    public final void setSubmitted(boolean flag)
    {
        a = flag;
    }

    public final void setThumbnailUrls(ArrayList arraylist)
    {
        o = arraylist;
    }
}
