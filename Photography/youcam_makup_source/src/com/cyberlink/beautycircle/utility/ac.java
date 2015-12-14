// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import java.util.ArrayList;

public class ac
    implements Comparable
{

    public android.view.View.OnClickListener a;
    AnimatorSet b;
    private LayoutInflater c;
    private View d;
    private LinearLayout e;
    private HorizontalScrollView f;
    private FrameLayout g;
    private UICImageView h;
    private ImageView i;
    private View j;
    private ArrayList k;
    private ArrayList l;
    private boolean m;
    private boolean n;
    private boolean o;
    private android.view.View.OnLayoutChangeListener p;
    private android.view.View.OnClickListener q;

    public ac(View view, boolean flag, boolean flag1, boolean flag2)
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = new ArrayList();
        m = false;
        n = false;
        o = false;
        p = new android.view.View.OnLayoutChangeListener() {

            final ac a;

            public void onLayoutChange(View view1, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (ac.b(a) != null)
                {
                    i1 = 0;
                    while (i1 < ac.b(a).size()) 
                    {
                        view1 = ((com.cyberlink.beautycircle.model.Tags.ProductTag)ac.b(a).get(i1)).b();
                        if (view1 != null)
                        {
                            View view2 = (View)com.cyberlink.beautycircle.utility.ac.c(a).get(i1);
                            view2.setVisibility(0);
                            view2.setTranslationX((float)(((com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint) (view1)).xRatio * (double)ac.d(a).getWidth()) - (float)view2.getWidth() / 2.0F);
                            view2.setTranslationY((float)(((com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint) (view1)).yRatio * (double)ac.d(a).getHeight()) - (float)view2.getHeight() / 2.0F);
                        }
                        i1++;
                    }
                }
            }

            
            {
                a = ac.this;
                super();
            }
        };
        a = new android.view.View.OnClickListener() {

            final ac a;

            public void onClick(View view1)
            {
                boolean flag3 = true;
                ac.a(a, true);
                view1 = a;
                if (ac.e(a).isSelected())
                {
                    flag3 = false;
                }
                view1.a(flag3);
                for (int i1 = 0; i1 < com.cyberlink.beautycircle.utility.ac.c(a).size(); i1++)
                {
                    ac.f(a).getChildAt(i1).findViewById(j.product_tag_border).setSelected(false);
                }

            }

            
            {
                a = ac.this;
                super();
            }
        };
        q = new android.view.View.OnClickListener() {

            final ac a;

            public void onClick(View view1)
            {
                int i1 = 0;
                while (i1 < com.cyberlink.beautycircle.utility.ac.c(a).size()) 
                {
                    View view2 = (View)com.cyberlink.beautycircle.utility.ac.c(a).get(i1);
                    View view3 = ac.f(a).getChildAt(i1);
                    float f1;
                    boolean flag3;
                    if (view2 == view1)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (flag3)
                    {
                        f1 = 1.5F;
                    } else
                    {
                        f1 = 1.0F;
                    }
                    view2.setScaleX(f1);
                    if (flag3)
                    {
                        f1 = 1.5F;
                    } else
                    {
                        f1 = 1.0F;
                    }
                    view2.setScaleY(f1);
                    if (flag3)
                    {
                        f1 = 0.9F;
                    } else
                    {
                        f1 = 0.7F;
                    }
                    view2.setAlpha(f1);
                    view3.findViewById(j.product_tag_border).setSelected(flag3);
                    if (flag3)
                    {
                        ac.g(a).smoothScrollTo((int)view3.getX(), (int)view3.getY());
                    }
                    i1++;
                }
            }

            
            {
                a = ac.this;
                super();
            }
        };
        b = null;
        m = flag2;
        c = LayoutInflater.from(view.getContext());
        d = view;
        e = (LinearLayout)view.findViewById(j.product_tags_layout);
        f = (HorizontalScrollView)view.findViewById(j.product_tags_scroller);
        g = (FrameLayout)view.findViewById(j.tag_points_layout);
        g.addOnLayoutChangeListener(p);
        h = (UICImageView)view.findViewById(j.tag_points_photo);
        i = (ImageView)view.findViewById(j.tag_points_toggle_btn);
        j = view.findViewById(j.tag_photo_panel);
        o = flag;
        if (i != null && j != null)
        {
            if (o)
            {
                i.setVisibility(0);
                i.setOnClickListener(a);
                j.setOnClickListener(a);
            } else
            {
                i.setVisibility(8);
            }
        }
        a(flag1);
    }

    private View a(int i1)
    {
        if (k == null || k.size() <= i1)
        {
            return null;
        }
        Object obj = (com.cyberlink.beautycircle.model.Tags.ProductTag)k.get(i1);
        View view = c.inflate(k.bc_view_item_tag_product_item, e, false);
        if (m)
        {
            view.setOnClickListener(new android.view.View.OnClickListener(((com.cyberlink.beautycircle.model.Tags.ProductTag) (obj))) {

                final com.cyberlink.beautycircle.model.Tags.ProductTag a;
                final ac b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(ac.h(b).getContext(), a.productId);
                }

            
            {
                b = ac.this;
                a = producttag;
                super();
            }
            });
        }
        Object obj1 = (UICImageView)view.findViewById(j.product_thumbnail);
        if (obj1 != null)
        {
            ((UICImageView) (obj1)).setImageURI(((com.cyberlink.beautycircle.model.Tags.ProductTag) (obj)).productThumbnail);
        }
        obj1 = (TextView)view.findViewById(j.product_name);
        if (obj1 != null)
        {
            ((TextView) (obj1)).setText(((com.cyberlink.beautycircle.model.Tags.ProductTag) (obj)).brandName);
        }
        obj = (TextView)view.findViewById(j.tag_number);
        if (obj != null)
        {
            ((TextView) (obj)).setText(String.valueOf(i1 + 1));
        }
        obj = view.findViewById(j.cancel_button);
        if (obj != null)
        {
            ((View) (obj)).setVisibility(8);
        }
        e.addView(view);
        return view;
    }

    static boolean a(ac ac1, boolean flag)
    {
        ac1.n = flag;
        return flag;
    }

    static ArrayList b(ac ac1)
    {
        return ac1.k;
    }

    static ArrayList c(ac ac1)
    {
        return ac1.l;
    }

    static FrameLayout d(ac ac1)
    {
        return ac1.g;
    }

    static ImageView e(ac ac1)
    {
        return ac1.i;
    }

    static LinearLayout f(ac ac1)
    {
        return ac1.e;
    }

    static HorizontalScrollView g(ac ac1)
    {
        return ac1.f;
    }

    static View h(ac ac1)
    {
        return ac1.d;
    }

    public int a(ac ac1)
    {
        return hashCode() - ac1.hashCode();
    }

    public void a()
    {
        if (o && j != null)
        {
            j.setOnClickListener(a);
        }
    }

    public void a(Uri uri)
    {
        h.setImageURI(uri);
    }

    public void a(android.view.View.OnLongClickListener onlongclicklistener)
    {
        if (o && j != null)
        {
            j.setOnLongClickListener(onlongclicklistener);
        }
    }

    public void a(ArrayList arraylist)
    {
        g.removeAllViews();
        e.removeAllViews();
        l.clear();
        k = arraylist;
        if (k != null)
        {
            int i1 = 0;
            while (i1 < k.size()) 
            {
                a(i1);
                arraylist = c.inflate(k.bc_view_item_tag_product_number, g, false);
                arraylist.setOnClickListener(q);
                ((TextView)arraylist.findViewById(j.tag_number)).setText(String.valueOf(i1 + 1));
                g.addView(arraylist);
                l.add(arraylist);
                i1++;
            }
        }
    }

    public void a(boolean flag)
    {
        if (b != null)
        {
            b.cancel();
            b = null;
        }
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        g.setAlpha(1.0F);
        g.setVisibility(i1);
        i.setSelected(flag);
    }

    public boolean a(Rect rect)
    {
        Rect rect1 = new Rect();
        b(rect1);
        return Rect.intersects(rect, rect1);
    }

    public ArrayList b()
    {
        return k;
    }

    public void b(Rect rect)
    {
        d.getHitRect(rect);
    }

    public void c()
    {
        if (n)
        {
            return;
        }
        if (b != null)
        {
            b.cancel();
            b = null;
        }
        g.setVisibility(0);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(g, "alpha", new float[] {
            1.0F
        }).setDuration(300L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(g, "alpha", new float[] {
            0.0F
        }).setDuration(300L);
        objectanimator1.setStartDelay(1000L);
        b = new AnimatorSet();
        b.playSequentially(new Animator[] {
            objectanimator, objectanimator1
        });
        b.start();
    }

    public int compareTo(Object obj)
    {
        return a((ac)obj);
    }
}
