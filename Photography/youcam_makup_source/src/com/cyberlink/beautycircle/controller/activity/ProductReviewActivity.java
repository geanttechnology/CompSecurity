// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.ProductComment;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;

public class ProductReviewActivity extends BaseActivity
{

    private long e;
    private EditText f;
    private RatingBar g;
    private boolean h;

    public ProductReviewActivity()
    {
        h = false;
    }

    static EditText a(ProductReviewActivity productreviewactivity)
    {
        return productreviewactivity.f;
    }

    static boolean a(ProductReviewActivity productreviewactivity, boolean flag)
    {
        productreviewactivity.h = flag;
        return flag;
    }

    static RatingBar b(ProductReviewActivity productreviewactivity)
    {
        return productreviewactivity.g;
    }

    static boolean c(ProductReviewActivity productreviewactivity)
    {
        return productreviewactivity.BaseActivity.e();
    }

    static boolean d(ProductReviewActivity productreviewactivity)
    {
        return productreviewactivity.h;
    }

    protected void o()
    {
        UserInfo userinfo = AccountManager.d();
        if (userinfo == null)
        {
            return;
        } else
        {
            k();
            r.a(0, 1, e, Long.valueOf(userinfo.id)).a(new com.perfectcorp.utility.m() {

                final ProductReviewActivity a;

                protected void a(int i)
                {
                    a.l();
                    com.perfectcorp.utility.e.e(new Object[] {
                        "NetworkProduct.listComment: ", Integer.valueOf(i)
                    });
                }

                protected void a(com.cyberlink.beautycircle.model.ProductComment.ProductCommentResult productcommentresult)
                {
                    a.l();
                    if (productcommentresult == null || productcommentresult.userComment == null)
                    {
                        return;
                    } else
                    {
                        ProductReviewActivity.a(a, true);
                        ProductReviewActivity.a(a).setText(productcommentresult.userComment.comment);
                        com.cyberlink.beautycircle.controller.activity.ProductReviewActivity.b(a).setRating(productcommentresult.userComment.rating);
                        return;
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.ProductComment.ProductCommentResult)obj);
                }

            
            {
                a = ProductReviewActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_write_review);
        b(m.bc_product_info_review_title);
        b().a(0xe4000000, x.a, x.d, 0);
        e = getIntent().getLongExtra("ProductId", -1L);
        f = (EditText)findViewById(com.cyberlink.beautycircle.j.write_review_text);
        g = (RatingBar)findViewById(com.cyberlink.beautycircle.j.write_review_rating_star);
        o();
    }

    public void onRightBtnClick(View view)
    {
        long l = e;
        view = f.getText().toString();
        float f1 = g.getRating();
        if (f1 < 1.0F)
        {
            DialogUtils.a(this, m.bc_product_review_rating_warning);
            return;
        } else
        {
            i();
            AccountManager.a(this, new b(l, view, f1) {

                final long a;
                final String b;
                final float c;
                final ProductReviewActivity d;

                public void a()
                {
                    Globals.b("getAccountToken Fail");
                }

                public void a(String s)
                {
                    d.k();
                    com.perfectcorp.utility.m m1 = new com.perfectcorp.utility.m(this) {

                        final _cls2 a;

                        protected void a(int i)
                        {
                            a.d.l();
                            Globals.a(a.d.getResources().getString(m.bc_server_connect_fail));
                            com.perfectcorp.utility.e.e(new Object[] {
                                "createComment error: ", Integer.valueOf(i)
                            });
                        }

                        protected void a(Void void1)
                        {
                            a.d.l();
                            void1 = new Intent();
                            a.d.setResult(-1, void1);
                            ProductReviewActivity.c(a.d);
                        }

                        protected void b(Object obj)
                        {
                            a((Void)obj);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    };
                    if (ProductReviewActivity.d(d))
                    {
                        r.b(s, a, b, c).a(m1);
                        return;
                    } else
                    {
                        r.a(s, a, b, c).a(m1);
                        return;
                    }
                }

                public void b()
                {
                    Globals.b("getAccountToken Cancel");
                }

            
            {
                d = ProductReviewActivity.this;
                a = l;
                b = s;
                c = f1;
                super();
            }
            });
            return;
        }
    }
}
