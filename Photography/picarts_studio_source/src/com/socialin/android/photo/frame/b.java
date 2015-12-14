// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.picsart.shop.a;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.SwyftSerials;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.photo.clipart.j;
import com.socialin.android.photo.f;
import com.socialin.android.photo.h;
import com.socialin.android.util.Utils;
import java.io.File;
import java.util.List;
import myobfuscated.cb.c;
import myobfuscated.cb.d;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.frame:
//            a

public final class b extends j
{

    private ItemType o;
    private int p[];
    private List q;
    private String r;
    private String s;
    private boolean t;

    public b()
    {
        o = ItemType.FRAME;
        t = false;
    }

    static String a(b b1)
    {
        return b1.c;
    }

    static c a(b b1, c c1)
    {
        b1.j = c1;
        return c1;
    }

    private void a(int l, String s1, boolean flag, String s2, int i1)
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        }
        AnalyticUtils.getInstance(activity).trackLocalAction("frame:done");
        Intent intent = new Intent();
        intent.putExtra("frameResId", -1);
        intent.putExtra("path", s2);
        intent.putExtra("fileName", s1);
        intent.putExtra("fromPicsinFile", flag);
        if (flag)
        {
            if ("svg".equals(((c)q.get(l)).u))
            {
                intent.putExtra("type", -255);
            }
        } else
        {
            intent.putExtra("type", i1);
        }
        activity.setResult(-1, intent);
        activity.finish();
    }

    static void a(b b1, int l, String s1, String s2)
    {
        b1.a(l, s1, true, s2, 0);
    }

    static String b(b b1)
    {
        return b1.c;
    }

    static String c(b b1)
    {
        return b1.f;
    }

    static String d(b b1)
    {
        return b1.d;
    }

    static String e(b b1)
    {
        return b1.e;
    }

    static String f(b b1)
    {
        return b1.e;
    }

    static List g(b b1)
    {
        return b1.q;
    }

    static c h(b b1)
    {
        return b1.j;
    }

    static c i(b b1)
    {
        return b1.j;
    }

    static ItemType j(b b1)
    {
        return b1.o;
    }

    static c k(b b1)
    {
        return b1.j;
    }

    protected final String a(int l, int i1)
    {
        return com.socialin.android.photo.frame.a.a(l, i1);
    }

    protected final String a(int l, int i1, Context context)
    {
        return com.socialin.android.photo.frame.a.a(l, i1, context);
    }

    public final void a(int l)
    {
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        }
        String s1;
        String s2;
        int i1;
        if (!t)
        {
            s1 = com.socialin.android.photo.frame.a.a(a, l, activity);
            i1 = com.socialin.android.photo.frame.a.c[a][l];
            s2 = com.socialin.android.photo.frame.a.b(a, l);
        } else
        {
            s1 = m.a(l, activity, r, false, o);
            i1 = com.socialin.android.photo.f.a(activity, s1, o);
            s2 = com.socialin.android.photo.f.c(activity, s1, o);
        }
        if (s1 == null)
        {
            Utils.b(activity, getString(0x7f0802d1));
            return;
        }
        if ((new File(s1)).exists())
        {
            a(l, null, false, s1, i1);
            com.socialin.android.photo.f.a(activity, o, s1, null, s2, i1, 1, com.socialin.android.photo.frame.a.d[a + 1]);
            return;
        } else
        {
            n.a = l;
            n.b = s1;
            n.a();
            f(l);
            return;
        }
    }

    public final void a(Intent intent, c c1)
    {
        int l;
        l = 0;
        c1 = getActivity();
        if (getView() != null && c1 != null) goto _L2; else goto _L1
_L1:
        this.l = intent;
_L4:
        return;
_L2:
        Object obj;
        if (r == null || s == null)
        {
            s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(CommonConstants.d[o.getValue()]).append("/icons").toString();
            r = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(CommonConstants.d[o.getValue()]).toString();
        }
        obj = intent.getExtras();
        c = ((Bundle) (obj)).getString("packageName");
        d = ((Bundle) (obj)).getString("brand");
        e = ((Bundle) (obj)).getString("content");
        f = ((Bundle) (obj)).getString("provider");
        g = ((Bundle) (obj)).getBoolean("installed", true);
        if (g)
        {
            Object obj1 = getActivity().getFragmentManager();
            intent = ((FragmentManager) (obj1)).beginTransaction();
            obj1 = (com.picsart.shop.m)((FragmentManager) (obj1)).findFragmentByTag("shopItemFragment");
            if (obj1 != null && ((com.picsart.shop.m) (obj1)).isAdded() && ((com.picsart.shop.m) (obj1)).isVisible())
            {
                intent.hide(((android.app.Fragment) (obj1)));
                intent.commitAllowingStateLoss();
            }
        } else
        {
            Object obj2 = getActivity().getFragmentManager();
            FragmentTransaction fragmenttransaction = ((FragmentManager) (obj2)).beginTransaction();
            com.picsart.shop.m m1 = (com.picsart.shop.m)((FragmentManager) (obj2)).findFragmentByTag("shopItemFragment");
            obj2 = new Bundle();
            ((Bundle) (obj2)).putParcelable("selectedShopItem", intent.getParcelableExtra("selectedShopItem"));
            ((Bundle) (obj2)).putString("fromSource", "frame");
            if (m1 != null && m1.isAdded() && !m1.isRemoving())
            {
                fragmenttransaction.show(m1);
                m1.a((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)intent.getParcelableExtra("selectedShopItem"));
            } else
            {
                intent = new com.picsart.shop.m();
                intent.setArguments(((Bundle) (obj2)));
                fragmenttransaction.add(0x7f100637, intent, "shopItemFragment");
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
        if (c == null)
        {
            a = ((Bundle) (obj)).getInt("selectedCategory");
            int i1 = ((Bundle) (obj)).getInt("categoryFavorite", -1);
            if (i1 == a)
            {
                t = true;
                p = com.socialin.android.photo.frame.a.a(r, o);
            } else
            if (i1 == -1)
            {
                t = false;
                p = com.socialin.android.photo.frame.a.c[a];
            }
        }
        if (!g) goto _L4; else goto _L3
_L3:
        if (c != null) goto _L6; else goto _L5
_L5:
        k = new d(c1, 0x7f030121);
        l = 0;
_L16:
        if (l >= p.length)
        {
            break MISSING_BLOCK_LABEL_719;
        }
        obj = new c();
        if (!t)
        {
            break MISSING_BLOCK_LABEL_703;
        }
        intent = m.a(c1, l, s, false, o);
        if (intent == null || !(new File(intent)).exists()) goto _L8; else goto _L7
_L7:
        obj.h = intent;
        intent = com.socialin.android.photo.f.d(c1, intent, o);
_L11:
        obj.g = intent;
_L12:
        k.a(((c) (obj)));
_L10:
        l++;
        continue; /* Loop/switch isn't completed */
_L8:
        intent = m.b(c1, l, r, false, o);
        if (intent == null) goto _L10; else goto _L9
_L9:
        intent = com.socialin.android.photo.f.c(c1, intent, o);
          goto _L11
        obj.c = com.socialin.android.photo.frame.a.b(a, l);
          goto _L12
        f(-1);
_L14:
        intent = (GridView)e(0x7f100636);
        intent.setAdapter(k);
        intent.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private b a;

            public final void onItemClick(AdapterView adapterview, View view, int j1, long l1)
            {
                adapterview = a.getActivity();
                if (adapterview == null)
                {
                    return;
                }
                if (com.socialin.android.photo.frame.b.a(a) == null)
                {
                    a.a(j1);
                    return;
                }
                AnalyticUtils.getInstance(adapterview).track(new com.socialin.android.apiv3.events.EventsFactory.ShopPackageUseEvent(b.b(a), "frame"));
                if ("swyftmedia".equals(com.socialin.android.photo.frame.b.c(a)))
                {
                    view = new SwyftSerials(com.socialin.android.photo.frame.b.d(a), b.e(a), (new StringBuilder()).append(com.socialin.android.photo.frame.b.f(a)).append("_").append(String.format("%03d", new Object[] {
                        Integer.valueOf(j1 + 1)
                    })).toString());
                    SwyftAnalytics.getInstance().createTrackEvent("shop_package_use").addParam("serials", view.toJSON().toString()).track();
                }
                com.socialin.android.photo.frame.b.a(a, (c)b.g(a).get(j1));
                char c2;
                if ("svg".equals(((c)b.g(a).get(j1)).u))
                {
                    c2 = '\uFF01';
                } else
                {
                    c2 = '\0';
                }
                com.socialin.android.photo.frame.b.a(a, j1, com.socialin.android.photo.frame.b.h(a).m, b.i(a).j);
                com.socialin.android.photo.f.b(adapterview, com.socialin.android.photo.frame.b.j(a), b.k(a), c2);
            }

            
            {
                a = b.this;
                super();
            }
        });
        return;
_L6:
        q = com.picsart.shop.a.a(c1).a(c1, c, 2);
        k = new d(c1, 0x7f030121);
        while (l < q.size()) 
        {
            k.a((c)q.get(l));
            l++;
        }
        if (true) goto _L14; else goto _L13
_L13:
        if (true) goto _L16; else goto _L15
_L15:
    }

    protected final int d(int l)
    {
        if (t)
        {
            return com.socialin.android.photo.frame.a.a(r, o).length;
        } else
        {
            return com.socialin.android.photo.frame.a.c[l].length;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030124, viewgroup, false);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        if (k != null)
        {
            com.socialin.android.util.c.b(k.a);
        }
    }
}
