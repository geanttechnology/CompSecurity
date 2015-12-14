// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.picsart.studio.view.viewpagerindicator.CirclePageIndicator;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.IntrospectiveArrayList;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Tag;
import com.socialin.android.apiv3.model.ViewerUser;
import com.socialin.android.apiv3.model.card.Card;
import com.socialin.android.apiv3.model.parsers.BannerItemsFilter;
import com.socialin.android.picsart.profile.view.BannerViewPager;
import com.socialin.android.picsart.profile.view.PagerRecyclerView;
import com.socialin.android.util.Utils;
import com.socialin.android.util.f;
import java.util.List;
import java.util.Random;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.adapter:
//            a, d, b, w, 
//            x, h, e

public final class v
{

    private static final String d = (new StringBuilder()).append(com/socialin/android/picsart/profile/adapter/a.getSimpleName()).append(" - ").toString();
    Context a;
    android.support.v7.widget.RecyclerView.OnScrollListener b;
    com.socialin.android.picsart.profile.adapter.d c;
    private e e;
    private final int f;
    private a g;
    private f h;
    private d i;

    public v(Context context, a a1)
    {
        c = new com.socialin.android.picsart.profile.adapter.d(null);
        a = context;
        g = a1;
        f = (int)Utils.a(1.0F, context);
        h = new f(context.getApplicationContext());
        i = new d(context.getApplicationContext());
        e = (e)((e)((e)((e)com.bumptech.glide.request.e.b(l.a).b()).a(android.graphics.Bitmap.CompressFormat.PNG)).a(0x7f0201f8)).b(0x7f0201f8);
    }

    static int a(int j, int k)
    {
        int i1;
        if (j % 5 != 0)
        {
            if ((j != (i1 = (k / 5) * 5) + 1 || j != k - 1) && (j != (i1 + 5) - 2 || j != k - 1))
            {
                return 1;
            }
        }
        return 2;
    }

    static a a(v v1)
    {
        return v1.g;
    }

    static String a()
    {
        return d;
    }

    static boolean a(ViewGroup viewgroup)
    {
        return viewgroup.findViewById(0x7f100274) != null;
    }

    static boolean a(v v1, String s)
    {
        return v1.a(s);
    }

    private boolean a(String s)
    {
        if (!s.contains("http"))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        s = Uri.parse(s);
        a.startActivity(new Intent("android.intent.action.VIEW", s));
        return true;
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            a.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(s.getMessage(), s);
            return false;
        }
        return true;
    }

    static Context b(v v1)
    {
        return v1.a;
    }

    static boolean b(ViewGroup viewgroup)
    {
        return viewgroup.findViewById(0x7f10026e) != null;
    }

    static com.socialin.android.picsart.profile.adapter.d c(v v1)
    {
        return v1.c;
    }

    private View f(ViewGroup viewgroup)
    {
        return LayoutInflater.from(a).inflate(0x7f0300ac, viewgroup, false);
    }

    final void a(View view, Tag tag, Card card)
    {
        view.findViewById(0x7f10026d).setOnClickListener(new _cls5(tag, card));
        ((TextView)view.findViewById(0x7f10026e)).setText((new StringBuilder("#")).append(tag.name).toString());
        ImageView imageview = (ImageView)view.findViewById(0x7f10026f);
        Object obj = LayoutInflater.from(a).inflate(0x7f03005c, null);
        PopupWindow popupwindow = new PopupWindow(((View) (obj)), -2, -2);
        popupwindow.setOutsideTouchable(true);
        popupwindow.setFocusable(true);
        popupwindow.setBackgroundDrawable(a.getResources().getDrawable(0x7f02002d));
        popupwindow.setTouchInterceptor(new _cls6(popupwindow));
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f100271);
        if (tag.isTagFollow)
        {
            obj = a.getString(0x7f0805c5);
        } else
        {
            obj = a.getString(0x7f0805b6);
        }
        textview.setText(((CharSequence) (obj)));
        textview.setOnClickListener(new _cls7(tag, card, textview, popupwindow));
        imageview.setOnClickListener(new _cls8(popupwindow, imageview));
        view = (ViewGroup)view.findViewById(0x7f100270);
        tag.items.setLabel("tag", tag.name);
        a(((List) (tag.items)), ((ViewGroup) (view)), card);
    }

    final void a(View view, ViewerUser vieweruser, Card card, int j)
    {
        Object obj = new _cls3(vieweruser, card);
        view.findViewById(0x7f100261).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        ((TextView)view.findViewById(0x7f100274)).setText((new StringBuilder("@")).append(vieweruser.username).toString());
        if (vieweruser.name != null)
        {
            ((TextView)view.findViewById(0x7f100276)).setText(vieweruser.name);
        }
        obj = (ImageView)view.findViewById(0x7f100273);
        ((ImageView) (obj)).setVisibility(0);
        if (!TextUtils.isEmpty(vieweruser.getPhoto()))
        {
            h.a(vieweruser.getPhoto(), ((ImageView) (obj)), (e)((e)((e)com.bumptech.glide.request.e.b(l.a).a(0x7f020669)).b(0x7f020669)).a(h.a), null);
        }
        obj = (ImageView)view.findViewById(0x7f100275);
        if (vieweruser.isValidated)
        {
            ((ImageView) (obj)).setVisibility(0);
        } else
        {
            ((ImageView) (obj)).setVisibility(8);
        }
        obj = (CheckBox)view.findViewById(0x7f100277);
        ((CheckBox) (obj)).setOnClickListener(new _cls4(((CheckBox) (obj)), j, vieweruser, card));
        if (vieweruser.isOwnerFollowing)
        {
            ((CheckBox) (obj)).setChecked(true);
        } else
        {
            ((CheckBox) (obj)).setChecked(false);
        }
        view = (ViewGroup)view.findViewById(0x7f100270);
        a(((List) (vieweruser.photos)), ((ViewGroup) (view)), card);
    }

    protected final void a(Card card, ViewGroup viewgroup)
    {
        viewgroup.removeAllViews();
        List list = card.banners;
        if (list != null && !list.isEmpty())
        {
            if ("slide_feature".equals(card.renderType))
            {
                List list2 = card.banners;
                Object obj1 = new BannerItemsFilter();
                ((BannerItemsFilter) (obj1)).evaluateContentWrapping(list2);
                View view = LayoutInflater.from(a).inflate(0x7f030036, viewgroup, false);
                BannerViewPager bannerviewpager = (BannerViewPager)view.findViewById(0x7f1001a3);
                Object obj4 = card.action;
                int i1 = card.rows;
                int j;
                if (card.messageTitleRows == 0)
                {
                    j = 1;
                } else
                {
                    j = card.messageTitleRows;
                }
                obj4 = new b(false, ((String) (obj4)), i1, j);
                obj1 = new com.socialin.android.picsart.profile.adapter.a(a, list2, ((b) (obj4)), g, ((BannerItemsFilter) (obj1)), card);
                obj1.a = card.proportion;
                bannerviewpager.setAdapter(((android.support.v4.view.PagerAdapter) (obj1)));
                ((com.socialin.android.picsart.profile.adapter.a) (obj1)).notifyDataSetChanged();
                ((BaseActivity)a).addOnDestroyListener(((com.firegnom.rat.ActivityDestroyListener) (obj1)));
                if (list2.size() > 1)
                {
                    CirclePageIndicator circlepageindicator = (CirclePageIndicator)view.findViewById(0x7f1001a4);
                    if (circlepageindicator != null)
                    {
                        circlepageindicator.setViewPager(bannerviewpager);
                        circlepageindicator.setOnPageChangeListener(new _cls10(card));
                    }
                }
                viewgroup.addView(view);
                return;
            }
            if ("slide_banner".equals(card.renderType))
            {
                int k;
                if (Utils.h(a) || Utils.j(a))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                if (k != 0 && card.full_screen)
                {
                    Object obj = m.a(card);
                    List list1 = card.banners;
                    PagerRecyclerView pagerrecyclerview = (PagerRecyclerView)LayoutInflater.from(a).inflate(0x7f03005f, viewgroup, false);
                    int j1 = (new Random()).nextInt(list1.size());
                    Object obj2 = pagerrecyclerview.getLayoutParams();
                    int k1 = a.getResources().getDisplayMetrics().widthPixels;
                    int l1;
                    if (!Utils.h(a))
                    {
                        k = Math.min(k1, a.getResources().getDisplayMetrics().heightPixels) * 2;
                    } else
                    {
                        k = Math.max(k1, a.getResources().getDisplayMetrics().heightPixels);
                    }
                    k /= 2;
                    l1 = (k1 - k) / 2;
                    obj2.height = (int)((double)k * card.proportion);
                    pagerrecyclerview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
                    pagerrecyclerview.addItemDecoration(new w());
                    pagerrecyclerview.setProportion(l1);
                    pagerrecyclerview.setScreenWidth(k1);
                    obj2 = new x(a);
                    ((x) (obj2)).scrollToPositionWithOffset(j1 + 0x3fffffff, l1);
                    obj = new h(a, k, list1.size(), pagerrecyclerview, g, ((org.json.JSONObject) (obj)));
                    ((BaseActivity)a).addOnDestroyListener(((com.firegnom.rat.ActivityDestroyListener) (obj)));
                    obj.a = card.action;
                    pagerrecyclerview.setLayoutManager(((android.support.v7.widget.RecyclerView.LayoutManager) (obj2)));
                    ((h) (obj)).setHasStableIds(true);
                    ((h) (obj)).addAll(list1);
                    pagerrecyclerview.setAdapter(((android.support.v7.widget.RecyclerView.Adapter) (obj)));
                    viewgroup.addView(pagerrecyclerview);
                    return;
                }
                List list3 = card.banners;
                View view1 = LayoutInflater.from(a).inflate(0x7f030240, viewgroup, false);
                BannerViewPager bannerviewpager1 = (BannerViewPager)view1.findViewById(0x7f100a58);
                Object obj3 = new b(true, card.action, card.rows, card.messageTitleRows);
                obj3 = new com.socialin.android.picsart.profile.adapter.a(a, list3, ((b) (obj3)), g, null, card);
                obj3.a = card.proportion;
                bannerviewpager1.setAdapter(((android.support.v4.view.PagerAdapter) (obj3)));
                ((com.socialin.android.picsart.profile.adapter.a) (obj3)).notifyDataSetChanged();
                ((BaseActivity)a).addOnDestroyListener(((com.firegnom.rat.ActivityDestroyListener) (obj3)));
                if (list3.size() > 1)
                {
                    card = (CirclePageIndicator)view1.findViewById(0x7f100a59);
                    if (card != null)
                    {
                        card.setViewPager(bannerviewpager1);
                        obj3.b = bannerviewpager1;
                        obj3.c = card;
                    }
                }
                viewgroup.addView(view1);
                return;
            }
        }
    }

    protected final void a(List list, ViewGroup viewgroup, int j)
    {
        if (viewgroup != null)
        {
            if (list == null || list.isEmpty())
            {
                viewgroup.setVisibility(8);
                return;
            }
            viewgroup.setVisibility(0);
            int j2 = list.subList(0, Math.min(list.size(), 15)).size();
            int k1 = viewgroup.getChildCount();
            if (k1 < j2)
            {
                for (int k = 0; k < j2 - k1; k++)
                {
                    viewgroup.addView(LayoutInflater.from(a).inflate(0x7f03023d, viewgroup, false));
                }

            } else
            {
                for (int i1 = 0; i1 < k1; i1++)
                {
                    viewgroup.getChildAt(i1).setVisibility(8);
                }

            }
            int j1 = 0;
            while (j1 < j2) 
            {
                Object obj = viewgroup.getChildAt(j1);
                ((View) (obj)).setVisibility(0);
                ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f1000ef);
                imageview.setVisibility(0);
                int i2 = viewgroup.getLayoutParams().height;
                int l1 = i2;
                if (i2 < 0)
                {
                    l1 = 240;
                }
                imageview.getLayoutParams().width = l1;
                imageview.getLayoutParams().height = l1;
                if (((View) (obj)).getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)
                {
                    ((android.view.ViewGroup.MarginLayoutParams)((View) (obj)).getLayoutParams()).rightMargin = f;
                }
                ImageItem imageitem = (ImageItem)list.get(j1);
                ((View) (obj)).findViewById(0x7f100174).setOnClickListener(new _cls1(j, imageitem));
                if ((j + j1) % 2 == 0)
                {
                    imageview.setBackgroundColor(0xdedede);
                } else
                {
                    imageview.setBackgroundColor(0xefefef);
                }
                obj = imageitem.getSmallUrl();
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    i.b(((String) (obj)), imageview, e);
                }
                j1++;
            }
        }
    }

    final void a(List list, ViewGroup viewgroup, Card card)
    {
        if (list != null && viewgroup != null && card.renderType != null) goto _L2; else goto _L1
_L1:
        if (viewgroup != null)
        {
            viewgroup.removeAllViews();
        }
_L4:
        return;
_L2:
        float f1;
        Object obj;
        android.support.v7.widget.RecyclerView.Adapter adapter;
        int j;
        if (!"default".equals(card.renderType) && !"line".equals(card.renderType) && !"grid".equals(card.renderType) && !"collage".equals(card.renderType))
        {
            viewgroup.removeAllViews();
            viewgroup.addView(f(viewgroup));
            j = 0;
        } else
        if ("default".equals(card.renderType))
        {
            viewgroup.removeAllViews();
            viewgroup.addView(f(viewgroup));
            j = 0;
        } else
        {
            j = 1;
        }
        if (j == 0) goto _L4; else goto _L3
_L3:
        obj = null;
        if (viewgroup.getChildCount() > 0)
        {
            obj = (RecyclerView)viewgroup.findViewById(0x7f100260);
        }
        if (obj != null) goto _L6; else goto _L5
_L5:
        viewgroup.removeAllViews();
        obj = (RecyclerView)LayoutInflater.from(a).inflate(0x7f030058, viewgroup, false);
        viewgroup.addView(((View) (obj)));
        viewgroup = ((ViewGroup) (obj));
_L37:
        viewgroup.setTag(card);
        if (b != null)
        {
            viewgroup.setOnScrollListener(b);
        }
        obj = card.renderType;
        f1 = 1.0F;
        if (Utils.h(a))
        {
            f1 = 1.2F;
        }
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 3: default 240
    //                   3181382: 650
    //                   3321844: 633
    //                   949441171: 667;
           goto _L7 _L8 _L9 _L10
_L7:
        j = -1;
_L27:
        j;
        JVM INSTR tableswitch 0 2: default 272
    //                   0 684
    //                   1 711
    //                   2 738;
           goto _L11 _L12 _L13 _L14
_L11:
        viewgroup.getLayoutParams().height = 0;
_L30:
        adapter = viewgroup.getAdapter();
        if (adapter == null) goto _L16; else goto _L15
_L15:
        obj = adapter;
        if (adapter instanceof com.socialin.android.picsart.profile.adapter.e) goto _L17; else goto _L16
_L16:
        obj = new com.socialin.android.picsart.profile.adapter.e(a, g, card);
        viewgroup.setAdapter(((android.support.v7.widget.RecyclerView.Adapter) (obj)));
_L17:
        Object obj1 = (com.socialin.android.picsart.profile.adapter.e)obj;
        ((com.socialin.android.picsart.profile.adapter.e) (obj1)).a.clear();
        ((com.socialin.android.picsart.profile.adapter.e) (obj1)).notifyDataSetChanged();
        obj = (com.socialin.android.picsart.profile.adapter.e)obj;
        int k;
        if (((com.socialin.android.picsart.profile.adapter.e) (obj)).a.isEmpty())
        {
            j = 0;
        } else
        {
            j = ((com.socialin.android.picsart.profile.adapter.e) (obj)).a.size() - 1;
        }
        ((com.socialin.android.picsart.profile.adapter.e) (obj)).a.addAll(list);
        if (list instanceof IntrospectiveArrayList)
        {
            ((com.socialin.android.picsart.profile.adapter.e) (obj)).a.setLabel("tag", ((IntrospectiveArrayList)list).getLableValue("tag"));
        }
        ((com.socialin.android.picsart.profile.adapter.e) (obj)).notifyItemRangeChanged(j, list.size());
        card = card.renderType;
        k = list.size();
        card.hashCode();
        JVM INSTR lookupswitch 3: default 472
    //                   3181382: 793
    //                   3321844: 777
    //                   949441171: 809;
           goto _L18 _L19 _L20 _L21
_L18:
        j = -1;
_L32:
        j;
        JVM INSTR tableswitch 0 2: default 504
    //                   0 825
    //                   1 831
    //                   2 837;
           goto _L22 _L23 _L24 _L25
_L22:
        j = 1;
_L35:
        list = new GridLayoutManager(a, j, 0, false);
        if ("collage".equals(card))
        {
            list.setSpanSizeLookup(new _cls2(k));
        }
        viewgroup.setLayoutManager(list);
        return;
_L6:
        for (j = 0; j < viewgroup.getChildCount(); j++)
        {
            obj1 = viewgroup.getChildAt(j);
            if (obj1 != obj)
            {
                viewgroup.removeView(((View) (obj1)));
            }
        }

        viewgroup = ((ViewGroup) (obj));
        continue; /* Loop/switch isn't completed */
_L9:
        if (!((String) (obj)).equals("line")) goto _L7; else goto _L26
_L26:
        j = 0;
          goto _L27
_L8:
        if (!((String) (obj)).equals("grid")) goto _L7; else goto _L28
_L28:
        j = 1;
          goto _L27
_L10:
        if (!((String) (obj)).equals("collage")) goto _L7; else goto _L29
_L29:
        j = 2;
          goto _L27
_L12:
        viewgroup.getLayoutParams().height = (int)(f1 * a.getResources().getDimension(0x7f0b004e));
          goto _L30
_L13:
        viewgroup.getLayoutParams().height = (int)(f1 * a.getResources().getDimension(0x7f0b004d));
          goto _L30
_L14:
        viewgroup.getLayoutParams().height = (int)a.getResources().getDimension(0x7f0b004d);
          goto _L30
_L20:
        if (!card.equals("line")) goto _L18; else goto _L31
_L31:
        j = 0;
          goto _L32
_L19:
        if (!card.equals("grid")) goto _L18; else goto _L33
_L33:
        j = 1;
          goto _L32
_L21:
        if (!card.equals("collage")) goto _L18; else goto _L34
_L34:
        j = 2;
          goto _L32
_L23:
        j = 1;
          goto _L35
_L24:
        j = 2;
          goto _L35
_L25:
        j = 2;
          goto _L35
        if (true) goto _L37; else goto _L36
_L36:
    }

    final View c(ViewGroup viewgroup)
    {
        return LayoutInflater.from(a).inflate(0x7f03005e, viewgroup, false);
    }

    final View d(ViewGroup viewgroup)
    {
        return LayoutInflater.from(a).inflate(0x7f03005b, viewgroup, false);
    }

    final ViewGroup e(ViewGroup viewgroup)
    {
        return (ViewGroup)LayoutInflater.from(a).inflate(0x7f030057, viewgroup, false);
    }


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
