// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cyberlink.you.activity.StickerShopAcitvity;
import com.cyberlink.you.activity.StickerShopDetailActivity;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.database.n;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.s;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.h;
import com.cyberlink.you.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.you.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.you.widgetpool.common.GifImageView;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.sticker:
//            j, StickerObj, a, i, 
//            f, d, c, g

public class StickerFragment extends Fragment
{

    private android.view.View.OnClickListener A;
    private android.view.View.OnClickListener B;
    private android.view.View.OnClickListener C;
    private android.view.View.OnClickListener D;
    private com.cyberlink.you.widgetpool.clhorizontalgridview.p E;
    private com.cyberlink.you.widgetpool.clhorizontalgridview.p F;
    private android.support.v4.view.ViewPager.OnPageChangeListener G;
    c a;
    private StickerObj b;
    private Emojicon c;
    private com.cyberlink.you.sticker.g d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Mode h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private j m;
    private a n;
    private i o;
    private HorizontalGridView p;
    private View q;
    private ViewPager r;
    private View s;
    private ImageButton t;
    private l u;
    private Dialog v;
    private Map w;
    private Map x;
    private long y;
    private boolean z;

    public StickerFragment()
    {
        e = false;
        f = false;
        g = false;
        i = false;
        j = false;
        k = false;
        l = false;
        y = -1L;
        z = false;
        A = new android.view.View.OnClickListener() {

            final StickerFragment a;

            public void onClick(View view)
            {
                StickerPackObj stickerpackobj = (StickerPackObj)view.getTag();
                if (a.getActivity() == null)
                {
                    return;
                } else
                {
                    Intent intent = new Intent(a.getActivity(), com/cyberlink/you/activity/StickerShopDetailActivity);
                    intent.putExtra("stickerPckObj", (StickerPackObj)view.getTag());
                    intent.putExtra("isPurchased", false);
                    a.getActivity().startActivityForResult(intent, 20);
                    return;
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        };
        B = new android.view.View.OnClickListener() {

            final StickerFragment a;

            public void onClick(View view)
            {
                StickerFragment.a(a, (StickerObj)view.getTag());
                StickerFragment.a(a, null);
                if (StickerFragment.a(a) != null)
                {
                    if (StickerFragment.b(a).equals(Mode.a))
                    {
                        int ai[] = new int[2];
                        view.getLocationInWindow(ai);
                        StickerFragment.a(a, ai, Pair.create(Integer.valueOf(view.getWidth()), Integer.valueOf(view.getHeight())), StickerFragment.a(a));
                        return;
                    }
                    if (StickerFragment.c(a) != null)
                    {
                        StickerFragment.c(a).a(com.cyberlink.you.sticker.StickerFragment.d(a));
                    }
                    view = (f)com.cyberlink.you.sticker.StickerFragment.e(a).getAdapter();
                    if (view != null)
                    {
                        view.a(com.cyberlink.you.sticker.StickerFragment.e(a).getCurrentItem(), StickerFragment.a(a));
                    }
                    if (StickerFragment.c(a) != null)
                    {
                        StickerFragment.c(a).a(StickerFragment.a(a));
                        return;
                    }
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }

            private class Mode extends Enum
            {

                public static final Mode a;
                public static final Mode b;
                private static final Mode c[];

                public static Mode valueOf(String s1)
                {
                    return (Mode)Enum.valueOf(com/cyberlink/you/sticker/StickerFragment$Mode, s1);
                }

                public static Mode[] values()
                {
                    return (Mode[])c.clone();
                }

                static 
                {
                    a = new Mode("Preview", 0);
                    b = new Mode("Select", 1);
                    c = (new Mode[] {
                        a, b
                    });
                }

                private Mode(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        };
        C = new android.view.View.OnClickListener() {

            final StickerFragment a;

            public void onClick(View view)
            {
                StickerFragment.a(a, (Emojicon)view.getTag());
                StickerFragment.a(a, null);
                while (com.cyberlink.you.sticker.StickerFragment.d(a) == null || StickerFragment.c(a) == null) 
                {
                    return;
                }
                StickerFragment.c(a).a(com.cyberlink.you.sticker.StickerFragment.d(a));
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        };
        D = new android.view.View.OnClickListener() {

            final StickerFragment a;

            public void onClick(View view)
            {
                if (a.getActivity() == null)
                {
                    return;
                } else
                {
                    view = new Intent(a.getActivity(), com/cyberlink/you/activity/StickerShopAcitvity);
                    a.getActivity().startActivityForResult(view, 20);
                    return;
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        };
        E = new com.cyberlink.you.widgetpool.clhorizontalgridview.p() {

            final StickerFragment a;

            public void a(AdapterView adapterview, View view, int i1, long l1)
            {
                if (a.getActivity() != null)
                {
                    StickerFragment.a(a, i1);
                    view = ((StickerPackObj)adapterview.getAdapter().getItem(i1)).r();
                    if (view == com.cyberlink.you.database.StickerPackObj.FunctionType.a)
                    {
                        adapterview = (StickerPackObj)adapterview.getAdapter().getItem(i1);
                        StickerFragment.a(a, adapterview.b());
                        return;
                    }
                    if (view == com.cyberlink.you.database.StickerPackObj.FunctionType.b)
                    {
                        StickerFragment.a(a, -2L);
                        return;
                    }
                    if (view == com.cyberlink.you.database.StickerPackObj.FunctionType.c)
                    {
                        return;
                    }
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        };
        F = new com.cyberlink.you.widgetpool.clhorizontalgridview.p() {

            final StickerFragment a;

            public void a(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (EmojiHelper.EmojiCategory)adapterview.getAdapter().getItem(i1);
                if (adapterview != null)
                {
                    adapterview = (PagerAdapter)StickerFragment.f(a).get(adapterview.toString());
                    if (adapterview != null)
                    {
                        com.cyberlink.you.sticker.StickerFragment.e(a).setAdapter(adapterview);
                        com.cyberlink.you.sticker.StickerFragment.g(a).a(a.getActivity());
                    }
                }
                com.cyberlink.you.sticker.StickerFragment.h(a).a(i1);
                adapterview = a.getActivity();
                if (adapterview != null)
                {
                    adapterview.runOnUiThread(new Runnable(this) {

                        final _cls12 a;

                        public void run()
                        {
                            com.cyberlink.you.sticker.StickerFragment.h(a.a).notifyDataSetChanged();
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        };
        a = null;
        G = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final StickerFragment a;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                com.cyberlink.you.sticker.StickerFragment.g(a).a(i1);
                f f1 = (f)com.cyberlink.you.sticker.StickerFragment.e(a).getAdapter();
                if (f1 != null && !f1.a())
                {
                    f1.a(i1);
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        };
    }

    static StickerObj a(StickerFragment stickerfragment)
    {
        return stickerfragment.b;
    }

    static StickerObj a(StickerFragment stickerfragment, StickerObj stickerobj)
    {
        stickerfragment.b = stickerobj;
        return stickerobj;
    }

    static Emojicon a(StickerFragment stickerfragment, Emojicon emojicon)
    {
        stickerfragment.c = emojicon;
        return emojicon;
    }

    static List a(StickerFragment stickerfragment, String s1)
    {
        return stickerfragment.a(s1);
    }

    private List a(String s1)
    {
        Object obj;
        ArrayList arraylist;
        int i1;
        try
        {
            obj = new JSONObject(s1);
        }
        catch (JSONException jsonexception)
        {
            Log.e("StickerFragment", (new StringBuilder()).append("[sticker.user.pack.list] Parse error. JSONstr=").append(s1).toString());
            return null;
        }
        try
        {
            obj = ((JSONObject) (obj)).getJSONArray("results");
        }
        catch (JSONException jsonexception1)
        {
            Log.e("StickerFragment", (new StringBuilder()).append("[sticker.user.pack.list] 'results' missing. JSONstr=").append(s1).toString());
            return null;
        }
        arraylist = new ArrayList();
        i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= ((JSONArray) (obj)).length())
                {
                    break label0;
                }
                Object obj1;
                try
                {
                    obj1 = ((JSONArray) (obj)).getJSONObject(i1);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    Log.e("StickerFragment", (new StringBuilder()).append("[sticker.user.pack.list] groupinfo parse error. JSONstr=").append(s1).toString());
                    break label1;
                }
                try
                {
                    arraylist.add(Long.valueOf(((JSONObject) (obj1)).getLong("packId")));
                }
                catch (JSONException jsonexception2)
                {
                    Log.e("StickerFragment", (new StringBuilder()).append("[sticker.user.pack.list] Parse item error. JSONstr=").append(((JSONObject) (obj1)).toString()).toString());
                }
            }
            i1++;
        } while (true);
        return arraylist;
    }

    private void a(int i1)
    {
        com.cyberlink.you.database.StickerPackObj.FunctionType functiontype;
        if (getActivity() != null)
        {
            if (com.cyberlink.you.database.StickerPackObj.FunctionType.a == (functiontype = ((StickerPackObj)m.getItem(i1)).r()) || com.cyberlink.you.database.StickerPackObj.FunctionType.b == functiontype)
            {
                m.a(i1);
                FragmentActivity fragmentactivity = getActivity();
                if (fragmentactivity != null)
                {
                    fragmentactivity.runOnUiThread(new Runnable() {

                        final StickerFragment a;

                        public void run()
                        {
                            StickerFragment.k(a).notifyDataSetChanged();
                        }

            
            {
                a = StickerFragment.this;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    static void a(StickerFragment stickerfragment, int i1)
    {
        stickerfragment.a(i1);
    }

    static void a(StickerFragment stickerfragment, long l1)
    {
        stickerfragment.b(l1);
    }

    static void a(StickerFragment stickerfragment, List list)
    {
        stickerfragment.a(list);
    }

    static void a(StickerFragment stickerfragment, int ai[], Pair pair, StickerObj stickerobj)
    {
        stickerfragment.a(ai, pair, stickerobj);
    }

    private void a(List list)
    {
        String s1 = com.cyberlink.you.g.a().e();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", s1));
        for (list = list.iterator(); list.hasNext(); arraylist.add(new BasicNameValuePair("packId", Long.toString(((Long)list.next()).longValue())))) { }
        u.a("sticker", "pack.info", arraylist, new com.cyberlink.you.friends.p() {

            final StickerFragment a;

            public void a(String s2, String s3, String s4, String s5)
            {
                if (s4 == null)
                {
                    Log.d("StickerFragment", "Response is null");
                } else
                {
                    if (!s4.equals("200"))
                    {
                        Log.d("StickerFragment", (new StringBuilder()).append("statusCode=").append(s4).toString());
                        return;
                    }
                    s2 = com.cyberlink.you.utility.h.a(com.cyberlink.you.utility.h.b(s5), false, true);
                    if (s2 != null)
                    {
                        com.cyberlink.you.e.i().a(s2);
                    }
                    s2 = a.getActivity();
                    if (s2 != null)
                    {
                        s2.runOnUiThread(new Runnable(this) {

                            final _cls14 a;

                            public void run()
                            {
                                StickerFragment.r(a.a);
                            }

            
            {
                a = _pcls14;
                super();
            }
                        });
                        return;
                    }
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        });
    }

    private void a(int ai[], Pair pair, StickerObj stickerobj)
    {
        ImageView imageview;
        imageview = null;
        if (getActivity() == null)
        {
            return;
        }
        if (v != null)
        {
            v.dismiss();
            v = null;
        }
        v = new Dialog(getActivity(), s.UFriendSelectorDialog);
        v.setOnShowListener(new android.content.DialogInterface.OnShowListener() {

            final StickerFragment a;

            public void onShow(DialogInterface dialoginterface)
            {
                StickerFragment.x(a).setVisibility(0);
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        });
        v.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final StickerFragment a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                StickerFragment.x(a).setVisibility(8);
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        });
        v.requestWindowFeature(1);
        v.getWindow().clearFlags(2);
        android.view.WindowManager.LayoutParams layoutparams = v.getWindow().getAttributes();
        layoutparams.gravity = 51;
        layoutparams.x = ai[0];
        layoutparams.y = ai[1] - com.cyberlink.you.utility.d.a(getActivity());
        ai = com.cyberlink.you.e.i().a(stickerobj.c()).d();
        if (!ai.equals("Static")) goto _L2; else goto _L1
_L1:
        v.setContentView(p.u_dialog_static_sticker_preview);
        imageview = (ImageView)v.findViewById(o.staticSticker);
        imageview.getLayoutParams().width = Math.round((float)((Integer)pair.first).intValue() * 1.5F);
        imageview.getLayoutParams().height = Math.round((float)((Integer)pair.second).intValue() * 1.5F);
        imageview.setOnClickListener(new android.view.View.OnClickListener() {

            final StickerFragment a;

            public void onClick(View view)
            {
                if (StickerFragment.c(a) != null)
                {
                    StickerFragment.c(a).a(StickerFragment.a(a));
                }
                StickerFragment.y(a).dismiss();
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        });
        ai = new File(stickerobj.g());
        if (!ai.getPath().equals("_") && ai.exists())
        {
            try
            {
                ai = BitmapFactory.decodeFile(ai.getPath());
            }
            // Misplaced declaration of an exception variable
            catch (int ai[])
            {
                ai.printStackTrace();
                ai = null;
            }
            imageview.setImageBitmap(ai);
        } else
        {
            LoadImageUtils.a(com.cyberlink.you.g.I(), stickerobj, imageview);
        }
_L4:
        v.show();
        return;
_L2:
        if (ai.equals("Animation"))
        {
            v.setContentView(p.u_dialog_anim_sticker_preview);
            GifImageView gifimageview = (GifImageView)v.findViewById(o.animSticker);
            gifimageview.getLayoutParams().width = Math.round((float)((Integer)pair.first).intValue() * 1.5F);
            gifimageview.getLayoutParams().height = Math.round((float)((Integer)pair.second).intValue() * 1.5F);
            gifimageview.setOnClickListener(new android.view.View.OnClickListener() {

                final StickerFragment a;

                public void onClick(View view)
                {
                    if (StickerFragment.c(a) != null)
                    {
                        StickerFragment.c(a).a(StickerFragment.a(a));
                    }
                    StickerFragment.y(a).dismiss();
                }

            
            {
                a = StickerFragment.this;
                super();
            }
            });
            ai = new File(stickerobj.g());
            if (!ai.getPath().equals("_") && ai.exists())
            {
                gifimageview.setGifImage(ai);
            } else
            {
                ai = new File(com.cyberlink.you.utility.d.a(stickerobj.c()));
                if (!ai.exists() && !ai.mkdir())
                {
                    ai = imageview;
                }
                if (ai != null)
                {
                    ai = (new StringBuilder()).append(ai).append(File.separator).append(Long.toString(stickerobj.b())).toString();
                    LoadImageUtils.a(stickerobj.f(), gifimageview, ai);
                } else
                {
                    Log.e("StickerFragment", "Cannot create dstFolder");
                }
            }
        } else
        if (ai.equals("AnimationPNG"))
        {
            v.setContentView(p.u_dialog_animpng_sticker_preview);
            ai = (ImageView)v.findViewById(o.animpngSticker);
            ai.getLayoutParams().width = Math.round((float)((Integer)pair.first).intValue() * 1.5F);
            ai.getLayoutParams().height = Math.round((float)((Integer)pair.second).intValue() * 1.5F);
            ai.setOnClickListener(new android.view.View.OnClickListener() {

                final StickerFragment a;

                public void onClick(View view)
                {
                    if (StickerFragment.c(a) != null)
                    {
                        StickerFragment.c(a).a(StickerFragment.a(a));
                    }
                    StickerFragment.y(a).dismiss();
                }

            
            {
                a = StickerFragment.this;
                super();
            }
            });
            LoadImageUtils.a(getActivity(), b, ai, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(StickerFragment stickerfragment, boolean flag)
    {
        stickerfragment.l = flag;
        return flag;
    }

    static Mode b(StickerFragment stickerfragment)
    {
        return stickerfragment.h;
    }

    private void b()
    {
        w.clear();
        java.util.Map.Entry entry;
        for (Iterator iterator = x.entrySet().iterator(); iterator.hasNext(); w.put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        e();
        p.g(17);
    }

    private void b(long l1)
    {
        if (getActivity() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (l1 != -2L)
        {
            break; /* Loop/switch isn't completed */
        }
        q.setVisibility(0);
        Object obj = (EmojiHelper.EmojiCategory)n.getItem(0);
        obj = (PagerAdapter)w.get(((EmojiHelper.EmojiCategory) (obj)).toString());
        if (obj != null)
        {
            r.setAdapter(((PagerAdapter) (obj)));
            o.a(getActivity());
            j = true;
            g();
        }
        n.a(0);
_L4:
        if (y != l1)
        {
            y = l1;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (l1 != -1L)
        {
            q.setVisibility(8);
            PagerAdapter pageradapter = (PagerAdapter)w.get(String.valueOf(l1));
            if (pageradapter != null)
            {
                r.setAdapter(pageradapter);
                o.a(getActivity());
                j = true;
                g();
            }
        } else
        {
            q.setVisibility(8);
            f f1 = (f)r.getAdapter();
            if (f1 != null)
            {
                f1.b();
            }
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    static boolean b(StickerFragment stickerfragment, boolean flag)
    {
        stickerfragment.k = flag;
        return flag;
    }

    static com.cyberlink.you.sticker.g c(StickerFragment stickerfragment)
    {
        return stickerfragment.d;
    }

    private boolean c()
    {
        List list = com.cyberlink.you.e.i().b();
        if (list != null)
        {
            int k1 = list.size();
            if (m.b() != k1)
            {
                return true;
            }
            int j1 = m.a();
            if (j1 != -1)
            {
                for (int i1 = j1; i1 < j1 + k1; i1++)
                {
                    StickerPackObj stickerpackobj = (StickerPackObj)m.getItem(i1);
                    StickerPackObj stickerpackobj1 = com.cyberlink.you.e.i().a(stickerpackobj.b());
                    if (!stickerpackobj.j().equals(stickerpackobj1.j()) || stickerpackobj.q() != stickerpackobj1.q())
                    {
                        return true;
                    }
                }

            } else
            if (k1 > 0)
            {
                return true;
            }
            return false;
        } else
        {
            return true;
        }
    }

    static boolean c(StickerFragment stickerfragment, boolean flag)
    {
        stickerfragment.i = flag;
        return flag;
    }

    static Emojicon d(StickerFragment stickerfragment)
    {
        return stickerfragment.c;
    }

    private void d()
    {
        ArrayList arraylist = new ArrayList();
        EmojiHelper.EmojiCategory aemojicategory[] = EmojiHelper.EmojiCategory.values();
        int j1 = aemojicategory.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            arraylist.add(aemojicategory[i1]);
        }

        n.addAll(arraylist);
        (new com.cyberlink.you.sticker.d(this, arraylist)).execute(new String[0]);
    }

    static ViewPager e(StickerFragment stickerfragment)
    {
        return stickerfragment.r;
    }

    private void e()
    {
        m.clear();
        if (e)
        {
            StickerPackObj stickerpackobj = new StickerPackObj(-1L, -1L, null, null, null, null, null, (n)null, com.cyberlink.you.database.StickerPackObj.Status.a, -1L, -1L, null, null, null, true, null);
            stickerpackobj.a(com.cyberlink.you.database.StickerPackObj.FunctionType.b);
            m.add(stickerpackobj);
        }
        a = new c(this);
        a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static Map f(StickerFragment stickerfragment)
    {
        return stickerfragment.w;
    }

    private void f()
    {
        String s1 = com.cyberlink.you.g.a().e();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", s1));
        u.a("sticker", "user.pack.list", arraylist, new com.cyberlink.you.friends.p() {

            final StickerFragment a;

            public void a(String s2, String s3, String s4, String s5)
            {
                if (s4 == null)
                {
                    Log.d("StickerFragment", "Response is null");
                } else
                {
                    if (!s4.equals("200"))
                    {
                        Log.d("StickerFragment", (new StringBuilder()).append("statusCode=").append(s4).toString());
                        return;
                    }
                    s2 = StickerFragment.a(a, s5);
                    if (s2 != null)
                    {
                        StickerFragment.a(a, s2);
                        return;
                    }
                }
            }

            
            {
                a = StickerFragment.this;
                super();
            }
        });
    }

    static i g(StickerFragment stickerfragment)
    {
        return stickerfragment.o;
    }

    private void g()
    {
        while (!k || !i && !j) 
        {
            return;
        }
        k = false;
        a(0);
        b(-2L);
    }

    static a h(StickerFragment stickerfragment)
    {
        return stickerfragment.n;
    }

    static boolean i(StickerFragment stickerfragment)
    {
        return stickerfragment.z;
    }

    static boolean j(StickerFragment stickerfragment)
    {
        return stickerfragment.l;
    }

    static j k(StickerFragment stickerfragment)
    {
        return stickerfragment.m;
    }

    static boolean l(StickerFragment stickerfragment)
    {
        return stickerfragment.g;
    }

    static void m(StickerFragment stickerfragment)
    {
        stickerfragment.f();
    }

    static long n(StickerFragment stickerfragment)
    {
        return stickerfragment.y;
    }

    static boolean o(StickerFragment stickerfragment)
    {
        return stickerfragment.e;
    }

    static boolean p(StickerFragment stickerfragment)
    {
        return stickerfragment.i;
    }

    static boolean q(StickerFragment stickerfragment)
    {
        return stickerfragment.j;
    }

    static void r(StickerFragment stickerfragment)
    {
        stickerfragment.e();
    }

    static Map s(StickerFragment stickerfragment)
    {
        return stickerfragment.x;
    }

    static void t(StickerFragment stickerfragment)
    {
        stickerfragment.g();
    }

    static android.view.View.OnClickListener u(StickerFragment stickerfragment)
    {
        return stickerfragment.C;
    }

    static android.view.View.OnClickListener v(StickerFragment stickerfragment)
    {
        return stickerfragment.A;
    }

    static android.view.View.OnClickListener w(StickerFragment stickerfragment)
    {
        return stickerfragment.B;
    }

    static View x(StickerFragment stickerfragment)
    {
        return stickerfragment.s;
    }

    static Dialog y(StickerFragment stickerfragment)
    {
        return stickerfragment.v;
    }

    public void a()
    {
        if (c())
        {
            b();
        }
    }

    public void a(long l1)
    {
        int i1 = m.b(l1);
        if ((long)i1 != -1L)
        {
            a(i1);
            b(l1);
        }
    }

    public void a(com.cyberlink.you.sticker.g g1)
    {
        d = g1;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 20 21: default 32
    //                   20 33
    //                   21 63;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (intent != null)
        {
            if (-1 == j1 && intent.getBooleanExtra("isChanged", false))
            {
                b();
                return;
            }
        } else
        {
            a();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (intent != null && -1 == j1 && intent.getBooleanExtra("isChanged", false))
        {
            b();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onAttach(Activity activity)
    {
        Log.d("StickerFragment", "onAttach");
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        Log.d("StickerFragment", "onCreate");
        super.onCreate(bundle);
        e = getArguments().getBoolean("Emoji", false);
        f = getArguments().getBoolean("Shop", false);
        g = getArguments().getBoolean("Setting", false);
        if (getArguments().getInt("Mode", 0) == 0)
        {
            bundle = Mode.a;
        } else
        {
            bundle = Mode.b;
        }
        h = bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Log.d("StickerFragment", "onCreateView");
        return layoutinflater.inflate(p.u_fragment_sticker, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        z = true;
        if (m != null)
        {
            m.clear();
        }
        if (w != null)
        {
            w.clear();
        }
        if (x != null)
        {
            x.clear();
        }
        if (r != null)
        {
            f f1 = (f)r.getAdapter();
            if (f1 != null)
            {
                f1.b();
            }
        }
        if (v != null)
        {
            v.dismiss();
            v = null;
        }
        Log.d("StickerFragment", "onDestory");
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        Log.d("StickerFragment", "onDestroyView");
    }

    public void onDetach()
    {
        super.onDetach();
        Log.d("StickerFragment", "onDetach");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        p = (HorizontalGridView)view.findViewById(o.stickerListGridView);
        t = (ImageButton)view.findViewById(o.stickerShopImageButton);
        r = (ViewPager)view.findViewById(o.viewpager);
        r.setOnPageChangeListener(G);
        q = view.findViewById(o.emojiListLayout);
        s = view.findViewById(o.stickerInnerMask);
        o = new i(this, (LinearLayout)view.findViewById(o.pageIndexContainer), r);
        com.cyberlink.you.utility.d.c();
        u = new l();
        w = new HashMap();
        x = new HashMap();
        i = false;
        j = false;
        if (e)
        {
            bundle = (HorizontalGridView)view.findViewById(o.emojiListGridView);
            if (getActivity() != null)
            {
                n = new a(this, getActivity(), 0x1090003, new ArrayList());
            }
            bundle.setAdapter(n);
            bundle.setOnItemClickListener(F);
            d();
        }
        if (f)
        {
            view.findViewById(o.stickerShopLayout).setVisibility(0);
            view = view.findViewById(o.seperator);
            view.setVisibility(0);
            view = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
            if (view != null)
            {
                view.addRule(0, o.stickerShopLayout);
            }
            view = (android.widget.RelativeLayout.LayoutParams)p.getLayoutParams();
            if (view != null)
            {
                view.addRule(0, o.seperator);
            }
            t.setOnClickListener(D);
        }
        if (getActivity() != null)
        {
            m = new j(this, getActivity(), 0x1090003, new ArrayList());
        }
        p.setAdapter(m);
        p.setOnItemClickListener(E);
        e();
    }
}
