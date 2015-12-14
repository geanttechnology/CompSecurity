// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.ProductComment;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductSocialActivity

class b extends m
{

    final View a;
    final ProductComment b;
    final ProductSocialActivity c;

    public void a(int i)
    {
        Globals.b((new StringBuilder()).append("deleteComment fail: ").append(i).toString());
        e.b(new Object[] {
            "deleteComment fail: ", Integer.valueOf(i)
        });
    }

    protected void a(Void void1)
    {
label0:
        {
            float f = 0.0F;
            e.b(new Object[] {
                "deleteComment success"
            });
            void1 = PropertyValuesHolder.ofFloat("alpha", new float[] {
                1.0F, 0.0F
            });
            PropertyValuesHolder propertyvaluesholder = PropertyValuesHolder.ofFloat("translationX", new float[] {
                0.0F, (float)(ProductSocialActivity.g(c).getWidth() * -1)
            });
            void1 = ObjectAnimator.ofPropertyValuesHolder(a, new PropertyValuesHolder[] {
                void1, propertyvaluesholder
            }).setDuration(300L);
            void1.addListener(new android.animation.Animator.AnimatorListener() {

                final ProductSocialActivity._cls5 a;

                public void onAnimationCancel(Animator animator)
                {
                    ProductSocialActivity.g(a.c).removeView(a.a);
                }

                public void onAnimationEnd(Animator animator)
                {
                    ProductSocialActivity.g(a.c).removeView(a.a);
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                a = ProductSocialActivity._cls5.this;
                super();
            }
            });
            void1.start();
            void1 = c.findViewById(j.product_comment);
            if ((void1 instanceof TextView) && ProductSocialActivity.d(c).isCommented)
            {
                ((TextView)void1).setText(com.cyberlink.beautycircle.m.bc_product_info_comment);
            }
            void1 = (TextView)c.findViewById(j.product_rating_count);
            if (void1 != null && (void1.getTag() instanceof Integer))
            {
                int k = ((Integer)void1.getTag()).intValue();
                RatingBar ratingbar;
                int i;
                if (k > 1)
                {
                    i = k - 1;
                } else
                {
                    i = 0;
                }
                ratingbar = (RatingBar)c.findViewById(j.product_rating_star);
                if (ratingbar != null)
                {
                    if (i != 0)
                    {
                        f = (ratingbar.getRating() * (float)k - b.rating) / (float)i;
                    }
                    ratingbar.setRating(f);
                }
                void1.setTag(Integer.valueOf(i));
                void1.setText(String.format(Locale.getDefault(), "(%d)", new Object[] {
                    Integer.valueOf(i)
                }));
                void1 = (TextView)c.findViewById(j.first_comment_layout);
                if (void1 != null)
                {
                    if (i <= 0)
                    {
                        break label0;
                    }
                    void1.setText(c.getResources().getQuantityString(l.bc_countpattern_review, i, new Object[] {
                        Integer.valueOf(i)
                    }));
                }
            }
            return;
        }
        void1.setText(com.cyberlink.beautycircle.m.bc_product_first_comment);
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    _cls1.a(ProductSocialActivity productsocialactivity, View view, ProductComment productcomment)
    {
        c = productsocialactivity;
        a = view;
        b = productcomment;
        super();
    }
}
