// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import com.picsart.shop.m;
import com.picsart.studio.ItemType;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.SwyftSerials;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.b;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.clipart.j;
import com.socialin.android.photo.f;
import com.socialin.android.photo.h;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ae;
import com.socialin.android.util.e;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Mac;
import myobfuscated.cb.c;
import myobfuscated.cb.d;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.template:
//            Template, CollageFrameRes, i

public final class a extends j
{

    private ArrayList o;
    private String p;
    private String q;
    private boolean r;
    private String s;
    private ItemType t;
    private List u;
    private g v;

    public a()
    {
        o = null;
        p = null;
        r = false;
        t = ItemType.COLLAGE_FRAME;
        v = null;
    }

    private String a(String s1)
    {
        byte abyte0[];
        StringBuilder stringbuilder;
        int l;
        abyte0 = b.a.a.doFinal(s1.getBytes(e.a));
        stringbuilder = new StringBuilder();
        l = abyte0.length;
        int k = 0;
_L2:
        if (k >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        String s3 = Integer.toHexString(abyte0[k] & 0xff);
        if (s3.length() == 1)
        {
            stringbuilder.append('0');
        }
        stringbuilder.append(s3);
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        String s2 = stringbuilder.toString();
        s1 = s2;
_L4:
        return (new StringBuilder()).append(q).append(s1).toString();
        Exception exception;
        exception;
        s1 = String.valueOf(s1.hashCode());
        exception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    static List a(a a1)
    {
        return a1.u;
    }

    private void a(Template template)
    {
        Intent intent = new Intent();
        intent.putExtra("template", template);
        intent.putExtra("paths", getActivity().getIntent().getStringArrayExtra("paths"));
        intent.putExtra("degrees", getActivity().getIntent().getIntArrayExtra("degrees"));
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    static void a(a a1, Template template)
    {
        a1.a(template);
    }

    private void a(String s1, int k, boolean flag, boolean flag1)
    {
        AnalyticUtils.getInstance(getActivity()).trackLocalAction("selectCollageFrame:done");
        if (!flag) goto _L2; else goto _L1
_L1:
        if (v != null)
        {
            v.show();
        }
        s1 = getActivity();
        if (s1 != null && !s1.isFinishing()) goto _L4; else goto _L3
_L3:
        s1 = new ModernAsyncTask(k) {

            private int a;
            private a b;

            private transient Template a()
            {
                Object obj;
                Template template1;
                template1 = (Template)((c)a.a(b).get(a)).a;
                template1.p = ((c)a.a(b).get(a)).j;
                obj = null;
                java.io.ByteArrayInputStream bytearrayinputstream = com.picsart.shop.a.a(b.getActivity()).a(template1.p, template1.h);
                obj = bytearrayinputstream;
_L2:
                obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
                String s2 = (new StringBuilder()).append(b.getActivity().getApplicationContext().getExternalCacheDir().getPath()).append("/frameTemp").toString();
                w.a(b.getActivity().getApplicationContext().getExternalCacheDir().getPath(), "frameTemp", ((android.graphics.Bitmap) (obj)), b.getActivity(), android.graphics.Bitmap.CompressFormat.PNG, true);
                template1.g = s2;
                return template1;
                Exception exception;
                exception;
                exception.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Template)obj;
                super.onPostExecute(obj);
                if (com.socialin.android.photo.template.a.b(b) != null)
                {
                    com.socialin.android.photo.template.a.b(b).dismiss();
                }
                a.a(b, ((Template) (obj)));
            }

            
            {
                b = a.this;
                a = k;
                super();
            }
        };
        v.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(s1) {

            private ModernAsyncTask a;
            private a b;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.cancel(true);
                dialoginterface = b.getActivity();
                if (dialoginterface != null && !dialoginterface.isFinishing())
                {
                    dialoginterface.setRequestedOrientation(2);
                }
            }

            
            {
                b = a.this;
                a = modernasynctask;
                super();
            }
        });
        s1.execute(new Void[0]);
        return;
_L4:
        int l = s1.getWindowManager().getDefaultDisplay().getRotation();
        switch (getResources().getConfiguration().orientation)
        {
        case 1: // '\001'
            if (l == 1 || l == 2)
            {
                s1.setRequestedOrientation(9);
            } else
            {
                s1.setRequestedOrientation(1);
            }
            break;

        case 2: // '\002'
            if (l == 0 || l == 1)
            {
                s1.setRequestedOrientation(0);
            } else
            {
                s1.setRequestedOrientation(8);
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Template template = (Template)o.get(k);
        if (flag1)
        {
            template.p = ((Template)o.get(k)).p;
            template.o = true;
        } else
        {
            template.g = s1;
            template.o = false;
        }
        template.e = 1;
        a(template);
        return;
        if (true) goto _L3; else goto _L5
_L5:
    }

    static g b(a a1)
    {
        return a1.v;
    }

    protected final String a(int k, int l)
    {
label0:
        {
            String s1;
            if (PicsartContext.a != com.picsart.studio.PicsartContext.MemoryType.LOW)
            {
                s1 = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_frame_ver2/").append(Utils.b()).append("/").append(((Template)o.get(l)).h).toString();
            } else
            {
                s1 = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_frame_ver2/").append(Utils.b()).append("/").append(((Template)o.get(l)).h).toString();
            }
            if (r)
            {
                if (PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.LOW)
                {
                    break label0;
                }
                s1 = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_form_ver2/").append(Utils.b()).append("/").append(((Template)o.get(l)).h).toString();
            }
            return s1;
        }
        return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_form_ver2/").append(Utils.b()).append("/").append(((Template)o.get(l)).h).toString();
    }

    protected final String a(int k, int l, Context context)
    {
        return a(b(l));
    }

    public final void a(int k)
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            boolean flag;
            if ("collage_grid.json".equals(p) || o != null && o.size() > k && o.get(k) != null && ((Template)o.get(k)).j != null && ((Template)o.get(k)).j.contains("simple"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            r = flag;
            if (c == null)
            {
                Activity activity1 = getActivity();
                if (activity1 != null)
                {
                    if (!FileUtils.a())
                    {
                        Utils.a(activity1, 0x7f080342);
                    } else
                    if (((Template)o.get(k)).o)
                    {
                        a("", k, false, true);
                    } else
                    {
                        String s1 = a(a(-1, k));
                        if ((new File(s1)).exists())
                        {
                            a(s1, k, false, false);
                        } else
                        {
                            n.a = k;
                            n.b = s1;
                            n.a();
                            f(k);
                        }
                    }
                }
                f.a(activity, t, com.socialin.android.photo.template.CollageFrameRes.c[a], p, k);
                AnalyticUtils.getInstance(activity).trackLocalAction("collageFrame:download");
                return;
            }
            if (u != null)
            {
                j = (c)u.get(k);
                a(null, k, true, false);
                f.a(activity, t, j, k);
                AnalyticUtils.getInstance(activity).track(new com.socialin.android.apiv3.events.EventsFactory.ShopPackageUseEvent(c, "collageFrame"));
                if ("swyftmedia".equals(f))
                {
                    SwyftSerials swyftserials = new SwyftSerials(d, e, (new StringBuilder()).append(e).append("_").append(String.format("%03d", new Object[] {
                        Integer.valueOf(k + 1)
                    })).toString());
                    SwyftAnalytics.getInstance().createTrackEvent("shop_package_use").addParam("serials", swyftserials.toJSON().toString()).track();
                }
                AnalyticUtils.getInstance(activity).trackLocalAction("collageFrame:load_shop_item");
                return;
            }
        }
    }

    public final void a(Intent intent, c c1)
    {
        int k;
        k = 0;
        c1 = getActivity();
        if (getView() != null && c1 != null) goto _L2; else goto _L1
_L1:
        this.l = intent;
_L4:
        return;
_L2:
        Object obj;
        if (s == null)
        {
            s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(CommonConstants.d[t.getValue()]).append("/icons").toString();
        }
        obj = intent.getExtras();
        if (obj == null) goto _L4; else goto _L3
_L3:
        c = ((Bundle) (obj)).getString("packageName");
        d = ((Bundle) (obj)).getString("brand");
        e = ((Bundle) (obj)).getString("content");
        f = ((Bundle) (obj)).getString("provider");
        g = ((Bundle) (obj)).getBoolean("installed", true);
        if (!g || c == null)
        {
            p = ((Bundle) (obj)).getString("readFrom");
            r = "collage_grid.json".equals(p);
        }
        if (g)
        {
            Object obj1 = getActivity().getFragmentManager();
            intent = ((FragmentManager) (obj1)).beginTransaction();
            obj1 = (m)((FragmentManager) (obj1)).findFragmentByTag("shopItemFragment");
            if (obj1 != null && ((m) (obj1)).isAdded() && ((m) (obj1)).isVisible())
            {
                intent.hide(((android.app.Fragment) (obj1)));
                intent.commitAllowingStateLoss();
            }
        } else
        {
            Object obj2 = getActivity().getFragmentManager();
            FragmentTransaction fragmenttransaction = ((FragmentManager) (obj2)).beginTransaction();
            m m1 = (m)((FragmentManager) (obj2)).findFragmentByTag("shopItemFragment");
            obj2 = new Bundle();
            ((Bundle) (obj2)).putParcelable("selectedShopItem", intent.getParcelableExtra("selectedShopItem"));
            ((Bundle) (obj2)).putString("fromSource", "collageframe");
            if (m1 != null && m1.isAdded() && !m1.isRemoving())
            {
                fragmenttransaction.show(m1);
                m1.a((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)intent.getParcelableExtra("selectedShopItem"));
            } else
            {
                intent = new m();
                intent.setArguments(((Bundle) (obj2)));
                fragmenttransaction.add(0x7f100637, intent, "shopItemFragment");
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
        if (c == null)
        {
            a = ((Bundle) (obj)).getInt("selectedCategory");
            int l = ((Bundle) (obj)).getInt("categoryFavorite");
            if (l == a)
            {
                o = f.b(s, t);
            } else
            if (l == -1)
            {
                o = i.a(getActivity(), p);
            }
        }
        if (!g) goto _L4; else goto _L5
_L5:
        obj = (GridView)getView().findViewById(0x7f100636);
        q = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/collage_frame_ver2/").toString();
        if (r)
        {
            q = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/collage_form_ver2/").toString();
        }
        if (c != null) goto _L7; else goto _L6
_L6:
        this.k = new d(c1, 0x7f030121);
        k = 0;
_L18:
        if (k >= o.size()) goto _L9; else goto _L8
_L8:
        c1 = new c();
        boolean flag;
        if ("collage_grid.json".equals(p) || ((Template)o.get(k)).j.contains("simple"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        r = flag;
        if (((Template)o.get(k)).o) goto _L11; else goto _L10
_L10:
        intent = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_frame_ver2/icons/").append(((Template)o.get(k)).i).toString();
        if (r)
        {
            intent = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_form_ver2/icons/").append(((Template)o.get(k)).i).toString();
        }
        c1.c = intent;
_L14:
        if (Utils.a(c1.j) || !c1.j.contains("package_valentine_2013"))
        {
            this.k.a(c1);
        }
_L13:
        k++;
        continue; /* Loop/switch isn't completed */
_L11:
        if (!(new File(((Template)o.get(k)).p)).exists()) goto _L13; else goto _L12
_L12:
        c1.i = ((Template)o.get(k)).o;
        c1.j = ((Template)o.get(k)).p;
        c1.l = ((Template)o.get(k)).i;
        if (true) goto _L14; else goto _L9
_L9:
        f(-1);
_L16:
        ((GridView) (obj)).setAdapter(this.k);
        ((GridView) (obj)).setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private a a;

            public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                a.a(i1);
            }

            
            {
                a = a.this;
                super();
            }
        });
        return;
_L7:
        u = com.picsart.shop.a.a(getActivity()).a(getActivity(), c);
        this.k = new d(c1, 0x7f030121);
        while (k < u.size()) 
        {
            this.k.a((c)u.get(k));
            k++;
        }
        if (true) goto _L16; else goto _L15
_L15:
        if (true) goto _L18; else goto _L17
_L17:
    }

    protected final int d(int k)
    {
        return o.size();
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        if (bundle != null && !bundle.isFinishing())
        {
            v = new g(getActivity());
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
