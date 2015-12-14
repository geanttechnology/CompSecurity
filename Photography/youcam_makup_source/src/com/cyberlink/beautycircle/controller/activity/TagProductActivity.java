// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public class TagProductActivity extends BaseActivity
{

    public static final UUID e = UUID.randomUUID();
    private static boolean f = true;
    private Uri g;
    private ArrayList h;
    private com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint i;
    private LayoutInflater j;
    private ViewGroup k;
    private LinearLayout l;
    private View m;
    private ArrayList n;
    private ArrayList o;
    private ObservableScrollView p;
    private boolean q;
    private android.view.View.OnTouchListener r;

    public TagProductActivity()
    {
        g = null;
        h = new ArrayList();
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = new ArrayList();
        o = new ArrayList();
        p = null;
        q = false;
        r = new android.view.View.OnTouchListener() {

            final TagProductActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (TagProductActivity.o()) goto _L2; else goto _L1
_L1:
                return false;
_L2:
                int i1 = motionevent.getAction();
                if (i1 != 0) goto _L4; else goto _L3
_L3:
                view = new Rect();
                i1 = 0;
_L11:
                if (i1 >= TagProductActivity.f(a).size()) goto _L6; else goto _L5
_L5:
                View view1;
                View view2;
                view1 = (View)TagProductActivity.f(a).get(i1);
                view2 = (View)com.cyberlink.beautycircle.controller.activity.TagProductActivity.c(a).get(i1);
                if (TagProductActivity.i(a)) goto _L8; else goto _L7
_L7:
                view1.getHitRect(view);
                if (!view.contains((int)motionevent.getX(), (int)motionevent.getY())) goto _L8; else goto _L9
_L9:
                TagProductActivity.a(a, view1);
                TagProductActivity.a(a, true);
                view1.setScaleX(1.5F);
                view1.setScaleY(1.5F);
                view1.setAlpha(0.9F);
                view2.findViewById(j.product_tag_border).setSelected(true);
                ((HorizontalScrollView)a.findViewById(j.product_tags_scroller)).smoothScrollTo((int)view2.getX(), (int)view2.getY());
                com.cyberlink.beautycircle.controller.activity.TagProductActivity.j(a).setScrollable(false);
_L10:
                i1++;
                continue; /* Loop/switch isn't completed */
_L8:
                view1.setScaleX(1.0F);
                view1.setScaleY(1.0F);
                view1.setAlpha(0.7F);
                view2.findViewById(j.product_tag_border).setSelected(false);
                if (true) goto _L10; else goto _L6
_L6:
                if (TagProductActivity.i(a))
                {
                    return true;
                }
                TagProductActivity.a(a, false);
                if (TagProductActivity.a(a).size() >= 9)
                {
                    DialogUtils.a(a, m.bc_tag_product_warning_reach_limit);
                    return false;
                } else
                {
                    TagProductActivity.a(a, com.cyberlink.beautycircle.controller.activity.TagProductActivity.e(a).inflate(k.bc_view_item_tag_product_number, com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a), false));
                    ((TextView)TagProductActivity.h(a).findViewById(j.tag_number)).setText(String.valueOf(TagProductActivity.a(a).size() + 1));
                    com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).addView(TagProductActivity.h(a));
                    return true;
                }
                if (true) goto _L11; else goto _L4
_L4:
                if (i1 == 2)
                {
                    if (TagProductActivity.i(a))
                    {
                        float f1 = Math.max(TagProductActivity.h(a).getWidth() / 2, Math.min(com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).getWidth() - TagProductActivity.h(a).getWidth() / 2, motionevent.getX()));
                        float f3 = Math.max(TagProductActivity.h(a).getHeight() / 2, Math.min(com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).getHeight() - TagProductActivity.h(a).getHeight() / 2, motionevent.getY()));
                        TagProductActivity.h(a).setVisibility(0);
                        TagProductActivity.h(a).setTranslationX(f1 - (float)TagProductActivity.h(a).getWidth() / 2.0F);
                        TagProductActivity.h(a).setTranslationY(f3 - (float)TagProductActivity.h(a).getHeight() / 2.0F);
                        return false;
                    }
                } else
                if (TagProductActivity.h(a) != null && i1 == 1)
                {
                    float f2 = Math.max(TagProductActivity.h(a).getWidth() / 2, Math.min(com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).getWidth() - TagProductActivity.h(a).getWidth() / 2, motionevent.getX()));
                    float f4 = Math.max(TagProductActivity.h(a).getHeight() / 2, Math.min(com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).getHeight() - TagProductActivity.h(a).getHeight() / 2, motionevent.getY()));
                    TagProductActivity.h(a).setVisibility(0);
                    TagProductActivity.h(a).setTranslationX(f2 - (float)TagProductActivity.h(a).getWidth() / 2.0F);
                    TagProductActivity.h(a).setTranslationY(f4 - (float)TagProductActivity.h(a).getHeight() / 2.0F);
                    TagProductActivity.a(a, new com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint());
                    TagProductActivity.g(a).xRatio = f2 / (float)com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).getWidth();
                    TagProductActivity.g(a).yRatio = f4 / (float)com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).getHeight();
                    if (TagProductActivity.i(a))
                    {
                        ((com.cyberlink.beautycircle.model.Tags.ProductTag)TagProductActivity.a(a).get(TagProductActivity.f(a).indexOf(TagProductActivity.h(a)))).a(TagProductActivity.g(a));
                        TagProductActivity.a(a, null);
                        TagProductActivity.a(a, null);
                        TagProductActivity.a(a, false);
                    } else
                    {
                        TagProductActivity.a(false);
                        com.cyberlink.beautycircle.c.a(a);
                    }
                    com.cyberlink.beautycircle.controller.activity.TagProductActivity.j(a).setScrollable(true);
                    return true;
                } else
                {
                    TagProductActivity.a(a, false);
                    return false;
                }
                if (true) goto _L1; else goto _L12
_L12:
            }

            
            {
                a = TagProductActivity.this;
                super();
            }
        };
    }

    static View a(TagProductActivity tagproductactivity, View view)
    {
        tagproductactivity.m = view;
        return view;
    }

    static View a(TagProductActivity tagproductactivity, com.cyberlink.beautycircle.model.Tags.ProductTag producttag, int i1)
    {
        return tagproductactivity.a(producttag, i1);
    }

    private View a(com.cyberlink.beautycircle.model.Tags.ProductTag producttag, int i1)
    {
        View view = j.inflate(k.bc_view_item_tag_product_item, l, false);
        Object obj = (UICImageView)view.findViewById(j.product_thumbnail);
        if (obj != null)
        {
            ((UICImageView) (obj)).setImageURI(producttag.productThumbnail);
        }
        obj = (TextView)view.findViewById(j.product_name);
        if (obj != null)
        {
            ((TextView) (obj)).setText(producttag.brandName);
        }
        producttag = (TextView)view.findViewById(j.tag_number);
        if (producttag != null)
        {
            producttag.setText(String.valueOf(i1 + 1));
        }
        producttag = view.findViewById(j.cancel_button);
        if (producttag != null)
        {
            producttag.setTag(Integer.valueOf(i1));
            producttag.setOnClickListener(new android.view.View.OnClickListener() {

                final TagProductActivity a;

                public void onClick(View view1)
                {
                    int j1 = ((Integer)view1.getTag()).intValue();
                    com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).removeView((View)TagProductActivity.f(a).get(j1));
                    TagProductActivity.b(a).removeView((View)com.cyberlink.beautycircle.controller.activity.TagProductActivity.c(a).get(j1));
                    TagProductActivity.a(a).remove(j1);
                    TagProductActivity.f(a).remove(j1);
                    com.cyberlink.beautycircle.controller.activity.TagProductActivity.c(a).remove(j1);
                    for (; j1 < TagProductActivity.a(a).size(); j1++)
                    {
                        view1 = (TextView)((View)TagProductActivity.f(a).get(j1)).findViewById(j.tag_number);
                        if (view1 != null)
                        {
                            view1.setText(String.valueOf(j1 + 1));
                        }
                        view1 = (View)com.cyberlink.beautycircle.controller.activity.TagProductActivity.c(a).get(j1);
                        TextView textview = (TextView)view1.findViewById(j.tag_number);
                        if (textview != null)
                        {
                            textview.setText(String.valueOf(j1 + 1));
                        }
                        view1 = view1.findViewById(j.cancel_button);
                        if (view1 != null)
                        {
                            view1.setTag(Integer.valueOf(j1));
                        }
                    }

                }

            
            {
                a = TagProductActivity.this;
                super();
            }
            });
        }
        return view;
    }

    static com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint a(TagProductActivity tagproductactivity, com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint tagpoint)
    {
        tagproductactivity.i = tagpoint;
        return tagpoint;
    }

    static ArrayList a(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.h;
    }

    static boolean a(TagProductActivity tagproductactivity, boolean flag)
    {
        tagproductactivity.q = flag;
        return flag;
    }

    static boolean a(boolean flag)
    {
        f = flag;
        return flag;
    }

    static LinearLayout b(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.l;
    }

    static ArrayList c(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.o;
    }

    static ViewGroup d(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.k;
    }

    static LayoutInflater e(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.j;
    }

    static ArrayList f(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.n;
    }

    static com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint g(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.i;
    }

    static View h(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.m;
    }

    static boolean i(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.q;
    }

    static ObservableScrollView j(TagProductActivity tagproductactivity)
    {
        return tagproductactivity.p;
    }

    static boolean o()
    {
        return f;
    }

    public boolean e()
    {
        setResult(0, null);
        super.e();
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
label0:
        {
label1:
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
                });
                super.onActivityResult(i1, j1, intent);
                if (i1 == 48142)
                {
                    if (j1 != -1)
                    {
                        break label0;
                    }
                    if (intent == null)
                    {
                        break label1;
                    }
                    long l1 = intent.getLongExtra("ProductId", -1L);
                    if (l1 > 0L)
                    {
                        com.cyberlink.beautycircle.model.network.r.a(l1, AccountManager.c()).a(new com.perfectcorp.utility.m() {

                            final TagProductActivity a;

                            protected void a()
                            {
                                com.perfectcorp.utility.e.a(new Object[] {
                                    "queryProductById cancel"
                                });
                                if (e.a)
                                {
                                    DialogUtils.a(a, "Oops", "queryProdInfo cancel", null);
                                }
                                TagProductActivity.a(a, null);
                                com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).removeView(TagProductActivity.h(a));
                                TagProductActivity.a(a, null);
                                TagProductActivity.a(true);
                            }

                            protected void a(int k1)
                            {
                                com.perfectcorp.utility.e.e(new Object[] {
                                    "queryProdInfo error: ", Integer.toHexString(k1)
                                });
                                if (e.a)
                                {
                                    DialogUtils.a(a, "Oops", (new StringBuilder()).append("queryProdInfo error: ").append(Integer.toHexString(k1)).toString(), null);
                                }
                                TagProductActivity.a(a, null);
                                com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).removeView(TagProductActivity.h(a));
                                TagProductActivity.a(a, null);
                                TagProductActivity.a(true);
                            }

                            protected void a(d d1)
                            {
                                if (d1 == null || d1.a.intValue() <= 0 || d1.b == null || d1.b.isEmpty())
                                {
                                    b(0x80000003);
                                } else
                                if (TagProductActivity.g(a) != null)
                                {
                                    d1 = (Product)d1.b.get(0);
                                    com.cyberlink.beautycircle.model.Tags.ProductTag producttag = new com.cyberlink.beautycircle.model.Tags.ProductTag();
                                    producttag.a(TagProductActivity.g(a));
                                    producttag.productId = ((Product) (d1)).productId;
                                    producttag.productName = ((Product) (d1)).productName;
                                    producttag.brandName = ((Product) (d1)).brandName;
                                    if (((Product) (d1)).imgThumbnail != null)
                                    {
                                        producttag.productThumbnail = Uri.parse(((Product) (d1)).imgThumbnail);
                                    }
                                    TagProductActivity.a(a).add(producttag);
                                    TagProductActivity.f(a).add(TagProductActivity.h(a));
                                    d1 = TagProductActivity.a(a, producttag, TagProductActivity.a(a).size() - 1);
                                    TagProductActivity.b(a).addView(d1);
                                    com.cyberlink.beautycircle.controller.activity.TagProductActivity.c(a).add(d1);
                                    TagProductActivity.a(true);
                                    return;
                                }
                            }

                            protected void b(Object obj)
                            {
                                a((d)obj);
                            }

            
            {
                a = TagProductActivity.this;
                super();
            }
                        });
                    }
                }
                return;
            }
            com.perfectcorp.utility.e.e(new Object[] {
                "Results OK but data is null"
            });
            if (e.a)
            {
                DialogUtils.a(this, "Oops", "Results OK but data is null", null);
            }
            i = null;
            k.removeView(m);
            m = null;
            f = true;
            return;
        }
        com.perfectcorp.utility.e.a(new Object[] {
            "User canceled picking a product"
        });
        i = null;
        k.removeView(m);
        m = null;
        f = true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_tag_product);
        b(m.bc_write_post_tag_photo_title);
        b().a(0xe4000000, x.a, x.d, 0);
        bundle = getIntent();
        if (bundle != null)
        {
            g = (Uri)bundle.getParcelableExtra("PhotoUri");
            try
            {
                h = Model.a(com/cyberlink/beautycircle/model/Tags$ProductTag, new JSONArray(bundle.getStringExtra("ProductTags")));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    bundle
                });
            }
        }
        p = (ObservableScrollView)findViewById(j.tag_product_scroller);
        k = (ViewGroup)findViewById(j.tag_layout);
        l = (LinearLayout)findViewById(j.product_layout);
        bundle = (ImageView)findViewById(j.tag_photo);
        if (bundle != null)
        {
            bundle.setImageURI(g);
            bundle.setOnTouchListener(r);
        }
        j = (LayoutInflater)getSystemService("layout_inflater");
        if (h != null)
        {
            k.post(new Runnable() {

                final TagProductActivity a;

                public void run()
                {
                    Iterator iterator = TagProductActivity.a(a).iterator();
                    int i1 = 0;
                    Object obj;
                    for (; iterator.hasNext(); TagProductActivity.f(a).add(obj))
                    {
                        obj = (com.cyberlink.beautycircle.model.Tags.ProductTag)iterator.next();
                        obj = TagProductActivity.a(a, ((com.cyberlink.beautycircle.model.Tags.ProductTag) (obj)), i1);
                        TagProductActivity.b(a).addView(((View) (obj)));
                        com.cyberlink.beautycircle.controller.activity.TagProductActivity.c(a).add(obj);
                        obj = com.cyberlink.beautycircle.controller.activity.TagProductActivity.e(a).inflate(k.bc_view_item_tag_product_number, com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a), false);
                        ((View) (obj)).setVisibility(0);
                        TextView textview = (TextView)((View) (obj)).findViewById(j.tag_number);
                        i1++;
                        textview.setText(String.valueOf(i1));
                        com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).addView(((View) (obj)));
                    }

                    com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).post(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            for (int i1 = 0; i1 < TagProductActivity.f(a.a).size(); i1++)
                            {
                                View view = (View)TagProductActivity.f(a.a).get(i1);
                                com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint tagpoint = ((com.cyberlink.beautycircle.model.Tags.ProductTag)TagProductActivity.a(a.a).get(i1)).b();
                                view.setTranslationX((float)(tagpoint.xRatio * (double)com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a.a).getWidth()) - (float)view.getWidth() / 2.0F);
                                view.setTranslationY((float)(tagpoint.yRatio * (double)com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a.a).getHeight()) - (float)view.getHeight() / 2.0F);
                            }

                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                a = TagProductActivity.this;
                super();
            }
            });
        }
    }

    public void onRightBtnClick(View view)
    {
        view = new Intent();
        view.putExtra("PhotoUri", g);
        view.putExtra("ProductTags", Model.b(h).toString());
        setResult(-1, view);
        super.e();
    }

}
