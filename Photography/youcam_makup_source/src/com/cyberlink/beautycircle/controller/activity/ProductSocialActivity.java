// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ag;
import com.cyberlink.beautycircle.controller.a.an;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.ProductComment;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.view.widgetpool.common.PostContentTextView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

public class ProductSocialActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    private long f;
    private Product g;
    private ViewGroup h;
    private SwipeRefreshLayout i;
    private View j;
    private int k;
    private DynamicDrawableSpan l;

    public ProductSocialActivity()
    {
        k = 0;
        l = null;
    }

    static int a(ProductSocialActivity productsocialactivity, int i1)
    {
        i1 = productsocialactivity.k + i1;
        productsocialactivity.k = i1;
        return i1;
    }

    static Product a(ProductSocialActivity productsocialactivity, Product product)
    {
        productsocialactivity.g = product;
        return product;
    }

    private void a(long l1)
    {
        aq.c = "report_comment";
        AccountManager.a(this, new com.cyberlink.beautycircle.utility.b(l1) {

            final long a;
            final ProductSocialActivity b;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s1)
            {
                if (s1 != null)
                {
                    DialogUtils.a(b, s1, "Comment", a, com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.b, null);
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

            
            {
                b = ProductSocialActivity.this;
                a = l1;
                super();
            }
        });
    }

    static void a(ProductSocialActivity productsocialactivity)
    {
        productsocialactivity.q();
    }

    static void a(ProductSocialActivity productsocialactivity, long l1)
    {
        productsocialactivity.a(l1);
    }

    static void a(ProductSocialActivity productsocialactivity, ProductComment productcomment, View view)
    {
        productsocialactivity.b(productcomment, view);
    }

    static void a(ProductSocialActivity productsocialactivity, ArrayList arraylist)
    {
        productsocialactivity.a(arraylist);
    }

    private void a(ProductComment productcomment, View view)
    {
        view.setOnLongClickListener(new android.view.View.OnLongClickListener(productcomment) {

            final ProductComment a;
            final ProductSocialActivity b;

            public boolean onLongClick(View view1)
            {
                Menu menu;
                boolean flag;
                PopupMenu popupmenu = new PopupMenu(b, view1);
                menu = popupmenu.getMenu();
                UserInfo userinfo = AccountManager.d();
                if (a != null && a.creator != null && a.creator.b().c())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (userinfo == null || userinfo.id != a.creator.userId) goto _L2; else goto _L1
_L1:
                menu.add(m.bc_post_comment_menu_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this, view1) {

                    final View a;
                    final _cls13 b;

                    public boolean onMenuItemClick(MenuItem menuitem)
                    {
                        DialogUtils.a(b.b, "", b.b.getResources().getString(m.bc_product_review_delete_confirm_text), b.b.getResources().getString(m.bc_review_cancel), new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }, b.b.getResources().getString(m.bc_review_delete), new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a.b.b, a.b.a, a.a);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return true;
                    }

            
            {
                b = _pcls13;
                a = view;
                super();
            }
                });
_L4:
                if (e.a)
                {
                    menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls13 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            ((ClipboardManager)a.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
                            return true;
                        }

            
            {
                a = _pcls13;
                super();
            }
                    });
                }
                menu.add(m.bc_post_comment_menu_cancel);
                popupmenu.show();
                return true;
_L2:
                if (!flag)
                {
                    menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls13 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a.b, a.a.id);
                            return true;
                        }

            
            {
                a = _pcls13;
                super();
            }
                    });
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                b = ProductSocialActivity.this;
                a = productcomment;
                super();
            }
        });
        Object obj = (UICImageView)view.findViewById(j.avatar_image);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(productcomment.creator.avatar);
            ((UICImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener(productcomment) {

                final ProductComment a;
                final ProductSocialActivity b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(b, a.creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }

            
            {
                b = ProductSocialActivity.this;
                a = productcomment;
                super();
            }
            });
        }
        obj = (ImageView)view.findViewById(j.avatar_crown);
        if (productcomment.creator != null)
        {
            com.cyberlink.beautycircle.a.a(((ImageView) (obj)), productcomment.creator.userType);
        }
        EmojiconTextView emojicontextview = (EmojiconTextView)view.findViewById(j.comment_user);
        if (emojicontextview != null)
        {
            String s1 = productcomment.creator.displayName;
            obj = s1;
            if (s1 == null)
            {
                obj = String.valueOf(productcomment.creator.userId);
            }
            emojicontextview.setText(((CharSequence) (obj)));
            emojicontextview.setOnClickListener(new android.view.View.OnClickListener(productcomment) {

                final ProductComment a;
                final ProductSocialActivity b;

                public void onClick(View view1)
                {
                    com.cyberlink.beautycircle.c.a(b, a.creator.userId, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }

            
            {
                b = ProductSocialActivity.this;
                a = productcomment;
                super();
            }
            });
        }
        obj = (RatingBar)view.findViewById(j.product_rating_star);
        if (obj != null)
        {
            ((RatingBar) (obj)).setRating(productcomment.rating);
        }
        obj = (PostContentTextView)view.findViewById(j.comment_description);
        if (obj != null)
        {
            ((PostContentTextView) (obj)).setTextViewHTML(productcomment.comment);
        }
        view = (TextView)view.findViewById(j.comment_time);
        if (view != null)
        {
            if (l == null)
            {
                l = new DynamicDrawableSpan(1, (int)((double)view.getTextSize() * 0.80000000000000004D)) {

                    final int a;
                    final ProductSocialActivity b;

                    public Drawable getDrawable()
                    {
                        Drawable drawable = b.getResources().getDrawable(com.cyberlink.beautycircle.i.bc_issue_comment_time);
                        drawable.setBounds(0, 0, a, a);
                        return drawable;
                    }

            
            {
                b = ProductSocialActivity.this;
                a = j1;
                super(i1);
            }
                };
            }
            productcomment = new SpannableString((new StringBuilder()).append("  ").append(com.cyberlink.beautycircle.utility.i.a(new Date(productcomment.lastModified))).toString());
            productcomment.setSpan(l, 0, 1, 17);
            view.setText(productcomment);
        }
    }

    private void a(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            LayoutInflater layoutinflater = (LayoutInflater)getSystemService("layout_inflater");
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                ProductComment productcomment = (ProductComment)arraylist.next();
                View view = layoutinflater.inflate(k.bc_view_item_product_user, h, false);
                a(productcomment, view);
                h.addView(view);
            }
        }
    }

    static SwipeRefreshLayout b(ProductSocialActivity productsocialactivity)
    {
        return productsocialactivity.i;
    }

    private void b(ProductComment productcomment, View view)
    {
        if (productcomment == null)
        {
            return;
        } else
        {
            com.cyberlink.beautycircle.model.network.r.a(AccountManager.b(), productcomment.id).a(new com.perfectcorp.utility.m(view, productcomment) {

                final View a;
                final ProductComment b;
                final ProductSocialActivity c;

                public void a(int i1)
                {
                    Globals.b((new StringBuilder()).append("deleteComment fail: ").append(i1).toString());
                    com.perfectcorp.utility.e.b(new Object[] {
                        "deleteComment fail: ", Integer.valueOf(i1)
                    });
                }

                protected void a(Void void1)
                {
label0:
                    {
                        float f1 = 0.0F;
                        com.perfectcorp.utility.e.b(new Object[] {
                            "deleteComment success"
                        });
                        void1 = PropertyValuesHolder.ofFloat("alpha", new float[] {
                            1.0F, 0.0F
                        });
                        PropertyValuesHolder propertyvaluesholder = PropertyValuesHolder.ofFloat("translationX", new float[] {
                            0.0F, (float)(com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.g(c).getWidth() * -1)
                        });
                        void1 = ObjectAnimator.ofPropertyValuesHolder(a, new PropertyValuesHolder[] {
                            void1, propertyvaluesholder
                        }).setDuration(300L);
                        void1.addListener(new android.animation.Animator.AnimatorListener(this) {

                            final _cls5 a;

                            public void onAnimationCancel(Animator animator)
                            {
                                com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.g(a.c).removeView(a.a);
                            }

                            public void onAnimationEnd(Animator animator)
                            {
                                com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.g(a.c).removeView(a.a);
                            }

                            public void onAnimationRepeat(Animator animator)
                            {
                            }

                            public void onAnimationStart(Animator animator)
                            {
                            }

            
            {
                a = _pcls5;
                super();
            }
                        });
                        void1.start();
                        void1 = c.findViewById(j.product_comment);
                        if ((void1 instanceof TextView) && com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.d(c).isCommented)
                        {
                            ((TextView)void1).setText(m.bc_product_info_comment);
                        }
                        void1 = (TextView)c.findViewById(j.product_rating_count);
                        if (void1 != null && (void1.getTag() instanceof Integer))
                        {
                            int j1 = ((Integer)void1.getTag()).intValue();
                            RatingBar ratingbar;
                            int i1;
                            if (j1 > 1)
                            {
                                i1 = j1 - 1;
                            } else
                            {
                                i1 = 0;
                            }
                            ratingbar = (RatingBar)c.findViewById(j.product_rating_star);
                            if (ratingbar != null)
                            {
                                if (i1 != 0)
                                {
                                    f1 = (ratingbar.getRating() * (float)j1 - b.rating) / (float)i1;
                                }
                                ratingbar.setRating(f1);
                            }
                            void1.setTag(Integer.valueOf(i1));
                            void1.setText(String.format(Locale.getDefault(), "(%d)", new Object[] {
                                Integer.valueOf(i1)
                            }));
                            void1 = (TextView)c.findViewById(j.first_comment_layout);
                            if (void1 != null)
                            {
                                if (i1 <= 0)
                                {
                                    break label0;
                                }
                                void1.setText(c.getResources().getQuantityString(l.bc_countpattern_review, i1, new Object[] {
                                    Integer.valueOf(i1)
                                }));
                            }
                        }
                        return;
                    }
                    void1.setText(m.bc_product_first_comment);
                }

                protected void b(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                c = ProductSocialActivity.this;
                a = view;
                b = productcomment;
                super();
            }
            });
            return;
        }
    }

    static long c(ProductSocialActivity productsocialactivity)
    {
        return productsocialactivity.f;
    }

    static Product d(ProductSocialActivity productsocialactivity)
    {
        return productsocialactivity.g;
    }

    static void e(ProductSocialActivity productsocialactivity)
    {
        productsocialactivity.p();
    }

    static int f(ProductSocialActivity productsocialactivity)
    {
        return productsocialactivity.k;
    }

    static ViewGroup g(ProductSocialActivity productsocialactivity)
    {
        return productsocialactivity.h;
    }

    private void p()
    {
        com.cyberlink.beautycircle.model.network.r.a(f, AccountManager.c()).a(new com.perfectcorp.utility.m() {

            final ProductSocialActivity a;

            protected void a(int i1)
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "queryProdInfo: ", Integer.toHexString(i1)
                });
                com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a);
                if (com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.b(a) != null)
                {
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.b(a).setRefreshing(false);
                }
            }

            protected void a(d d1)
            {
                if (d1 == null || d1.a.intValue() <= 0 || d1.b == null)
                {
                    b(0x80000003);
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a, (Product)d1.b.get(0));
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a);
                    if (com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.b(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.b(a).setRefreshing(false);
                        return;
                    }
                }
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
        });
    }

    private void q()
    {
        Object obj = findViewById(j.empty_layout);
        if (g == null)
        {
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
            }
        } else
        {
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
            }
            obj = (UICImageView)findViewById(j.product_img);
            if (obj != null)
            {
                ((UICImageView) (obj)).setImageURI(Uri.parse(g.imgOriginal));
            }
            obj = (TextView)findViewById(j.product_displayname);
            if (obj != null)
            {
                ((TextView) (obj)).setText(g.displayTitle);
            }
            obj = (TextView)findViewById(j.product_description);
            if (obj != null)
            {
                ((TextView) (obj)).setText(g.description);
            }
            obj = (TextView)findViewById(j.product_price);
            if (obj != null)
            {
                ((TextView) (obj)).setText(g.recommendedPrice);
            }
            obj = (TextView)findViewById(j.product_brand);
            if (obj != null)
            {
                ((TextView) (obj)).setText(g.brandName);
            }
            obj = (TextView)findViewById(j.product_category);
            if (obj != null && g.typeName != null)
            {
                StringBuilder stringbuilder = new StringBuilder();
                String s1;
                for (Iterator iterator = g.typeName.iterator(); iterator.hasNext(); stringbuilder.append(s1))
                {
                    s1 = (String)iterator.next();
                    if (stringbuilder.length() != 0)
                    {
                        stringbuilder.append(" | ");
                    }
                }

                ((TextView) (obj)).setText(stringbuilder);
            }
            obj = (RatingBar)findViewById(j.product_rating_star);
            if (obj != null)
            {
                ((RatingBar) (obj)).setRating(g.rating);
            }
            obj = (TextView)findViewById(j.product_rating_count);
            if (obj != null)
            {
                ((TextView) (obj)).setTag(Integer.valueOf(g.commentCount));
                ((TextView) (obj)).setText(String.format(Locale.getDefault(), "(%d)", new Object[] {
                    Integer.valueOf(g.commentCount)
                }));
            }
            obj = (TextView)findViewById(j.first_comment_layout);
            if (obj != null)
            {
                if (g.commentCount > 0)
                {
                    ((TextView) (obj)).setText(getResources().getQuantityString(l.bc_countpattern_review, g.commentCount, new Object[] {
                        Integer.valueOf(g.commentCount)
                    }));
                } else
                {
                    ((TextView) (obj)).setText(m.bc_product_first_comment);
                }
            }
            obj = findViewById(j.product_comment);
            if (obj instanceof TextView)
            {
                if (g.isCommented)
                {
                    ((TextView)obj).setText(m.bc_product_info_comment_edit);
                }
                ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ProductSocialActivity a;

                    public void onClick(View view)
                    {
                        aq.c = "comment";
                        AccountManager.a(a, new com.cyberlink.beautycircle.utility.b(this) {

                            final _cls6 a;

                            public void a()
                            {
                                Globals.b("getAccountToken Fail");
                            }

                            public void a(String s1)
                            {
                                com.cyberlink.beautycircle.c.a(a.a, com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.c(a.a));
                            }

                            public void b()
                            {
                                Globals.b("getAccountToken Cancel");
                            }

            
            {
                a = _pcls6;
                super();
            }
                        });
                    }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
                });
            }
            obj = findViewById(j.product_buy);
            if (obj != null && g.productStoreLink != null)
            {
                ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ProductSocialActivity a;

                    public void onClick(View view)
                    {
                        if (com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.d(a).productStoreLink != null)
                        {
                            com.perfectcorp.a.b.a(new an(Long.toString(com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.d(a).productId), com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.d(a).recommendedStore));
                            com.cyberlink.beautycircle.c.a(a, Uri.parse(com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.d(a).productStoreLink));
                        }
                    }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
                });
            }
            h = (ViewGroup)findViewById(j.comment_layout);
            if (h != null)
            {
                h.removeAllViews();
            }
            k = 0;
            o();
            obj = findViewById(j.more_comment_btn);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
                ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ProductSocialActivity a;

                    public void onClick(View view)
                    {
                        a.o();
                    }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
                });
            }
            obj = (LinearLayout)findViewById(j.bc_product_outter);
            if (obj != null)
            {
                ((LinearLayout) (obj)).setVisibility(0);
                return;
            }
        }
    }

    private void r()
    {
        i = (SwipeRefreshLayout)findViewById(j.bc_pull_to_refresh_layout);
        if (i != null)
        {
            i.setColorSchemeResources(new int[] {
                g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style
            });
            i.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

                final ProductSocialActivity a;

                public void onRefresh()
                {
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.e(a);
                }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
            });
        }
        j = findViewById(j.empty_layout);
        if (j != null)
        {
            j.setOnClickListener(new android.view.View.OnClickListener() {

                final ProductSocialActivity a;

                public void onClick(View view)
                {
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.e(a);
                }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
            });
        }
    }

    private void s()
    {
        if (i != null)
        {
            i.setOnRefreshListener(null);
        }
    }

    public String d(String s1)
    {
        s1 = null;
        if (f > 0L)
        {
            s1 = String.format(Locale.getDefault(), "ybc://product/%d", new Object[] {
                Long.valueOf(f)
            });
        }
        return s1;
    }

    protected void o()
    {
        com.cyberlink.beautycircle.model.network.r.a(k, 20, f, AccountManager.c()).a(new com.perfectcorp.utility.m() {

            final ProductSocialActivity a;

            protected void a(com.cyberlink.beautycircle.model.ProductComment.ProductCommentResult productcommentresult)
            {
                if (productcommentresult != null)
                {
                    ArrayList arraylist = productcommentresult.results;
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a, arraylist.size());
                    com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.a(a, arraylist);
                    if (productcommentresult.totalSize != null)
                    {
                        int i1 = productcommentresult.totalSize.intValue();
                        productcommentresult = a.findViewById(j.more_comment_btn);
                        if (i1 > ProductSocialActivity.f(a))
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = 8;
                        }
                        productcommentresult.setVisibility(i1);
                        return;
                    }
                }
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.ProductComment.ProductCommentResult)obj);
            }

            
            {
                a = ProductSocialActivity.this;
                super();
            }
        });
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
        });
        super.onActivityResult(i1, j1, intent);
        if (i1 == 48137 && j1 == -1)
        {
            p();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_product_social);
        f = getIntent().getLongExtra("ProductId", -1L);
        b(m.bc_products_title);
        p();
        r();
    }

    public void onDestroy()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        s();
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        com.perfectcorp.a.b.a(new ag(Long.toString(f)));
    }

}
