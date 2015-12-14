// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.picsart.collages.CollageCategoryItem;
import com.picsart.collages.CollageCellItem;
import com.picsart.collages.CollagesActivity;
import com.picsart.collages.SPArrow;
import com.picsart.collages.a;
import com.picsart.collages.i;
import com.picsart.collages.j;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.c;
import com.socialin.android.util.Utils;
import com.socialin.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.template:
//            e

public final class d extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    public String a;
    private i b;
    private GridView c;
    private Intent d;
    private String e;
    private CollageCategoryItem f;
    private String g[];
    private int h[];
    private boolean i;
    private e j;
    private Activity k;

    public d()
    {
        b = null;
        c = null;
        d = null;
        e = "collages/";
        f = null;
        g = null;
        h = null;
        i = false;
        j = null;
    }

    static CollageCategoryItem a(d d1)
    {
        return d1.f;
    }

    static j a(d d1, String s)
    {
        return d1.a(s);
    }

    private j a(String s)
    {
        CollageCellItem collagecellitem;
        ArrayList arraylist;
        int l;
        int k1;
        try
        {
            s = getResources().getAssets().open((new StringBuilder()).append(e).append(s).append(".json").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s = new InputStreamReader(s);
        collagecellitem = (CollageCellItem)com.socialin.android.c.a().fromJson(s, com/picsart/collages/CollageCellItem);
        k1 = collagecellitem.paths.length;
        arraylist = new ArrayList();
        l = 0;
        while (l < k1) 
        {
            String as[] = collagecellitem.paths[l].split(" ");
            s = new ArrayList();
            int l1 = as.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                String as1[] = as[i1].split(",");
                float f1 = Float.parseFloat(as1[0]);
                float f3 = Float.parseFloat(as1[1]);
                s.add(SPArrow.getInstance().setXY(f1, f3));
            }

            float f2 = collagecellitem.width;
            float f4 = collagecellitem.height;
            int j1 = (int)Utils.a(100F, getActivity());
            if (k == null || k.isFinishing())
            {
                s = new a();
            } else
            {
                android.graphics.Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 0x7f0202f7);
                s = new a(s, j1, bitmap);
                s.c(3F);
                s.b(j1);
                ((a) (s)).g.setColor(-1);
                s.r = false;
                s.a(f2 / f4);
            }
            arraylist.add(s);
            l++;
        }
        s = new j();
        s.a = arraylist;
        s.c = collagecellitem.height;
        s.b = collagecellitem.width;
        return s;
    }

    private void a(int l, boolean flag)
    {
        if (g == null || h == null)
        {
            g = new String[0];
            h = new int[0];
        }
        Intent intent;
        if (i)
        {
            intent = new Intent();
        } else
        {
            intent = new Intent(k.getApplicationContext(), com/picsart/collages/CollagesActivity);
        }
        if (j != null)
        {
            j.cancel(true);
        }
        intent.putExtra("cType", 1);
        intent.putExtra("selectedCollageId", 0x7f07004e);
        intent.putExtra("selectedCollagePosition", 0);
        intent.putExtra("paths", g);
        intent.putExtra("degrees", h);
        intent.putExtra("session_id", a);
        if (flag)
        {
            intent.putExtra("selectedItems", k.getIntent().getStringArrayExtra("selectedItems"));
            intent.putExtra("itemsCount", k.getIntent().getIntExtra("itemsCount", 0));
            intent.putExtra("selectedItemsDegrees", k.getIntent().getIntArrayExtra("selectedItemsDegrees"));
            intent.putExtra("isAutomatically", flag);
        }
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.CollageGridSelectedClickEvent(a, (new StringBuilder()).append(f.b).append("_").append(((com.picsart.collages.CollageCategoryItem.CollagePreviewItem)f.c.get(l)).b).toString()));
        intent.putExtra("collagePath", (new StringBuilder()).append(e).append(f.b).append("/").append(((com.picsart.collages.CollageCategoryItem.CollagePreviewItem)f.c.get(l)).b).append(".json").toString());
        if (!flag)
        {
            if (i)
            {
                k.setResult(-1, intent);
                k.finish();
                return;
            } else
            {
                k.setResult(-1, intent);
                k.finish();
                return;
            }
        } else
        {
            k.startActivity(intent);
            k.finish();
            return;
        }
    }

    static i b(d d1)
    {
        return d1.b;
    }

    public final void a(Intent intent)
    {
        if (getActivity() != null) goto _L2; else goto _L1
_L1:
        d = intent;
_L4:
        return;
_L2:
        f = (CollageCategoryItem)intent.getParcelableExtra("selectedCollagePackage");
        if (b != null)
        {
            b.a();
        }
        b = new i(k.getApplicationContext(), (int)Utils.a(100F, k), (int)Utils.a(100F, k), f.a);
        if (j != null)
        {
            j.cancel(true);
        }
        j = new e(this, f.b, f.c, (byte)0);
        c.setAdapter(b);
        c.setOnItemClickListener(this);
        j.execute(new Void[0]);
        if (k.getIntent().getIntExtra("itemsCount", 0) <= 0) goto _L4; else goto _L3
_L3:
        int i1;
        intent = k.getIntent();
        i1 = intent.getIntExtra("itemsCount", 0);
        if (i1 <= 0) goto _L4; else goto _L5
_L5:
        int l;
        int j1;
        j1 = f.c.size();
        l = 0;
_L9:
        if (l >= j1)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        if (((com.picsart.collages.CollageCategoryItem.CollagePreviewItem)f.c.get(l)).a != i1) goto _L7; else goto _L6
_L6:
        a(l, true);
        l = 1;
_L10:
        if (l != 0) goto _L4; else goto _L8
_L7:
        l++;
          goto _L9
_L8:
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = f.c.iterator(); iterator.hasNext(); arraylist.add(Integer.valueOf(((com.picsart.collages.CollageCategoryItem.CollagePreviewItem)iterator.next()).a))) { }
        Collections.sort(arraylist);
        intent.putExtra("itemsCount", (Serializable)arraylist.get(arraylist.size() - 1));
          goto _L3
        l = 0;
          goto _L10
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        AnalyticUtils.getInstance(k).trackLocalAction("collageFrame:onCreate");
        bundle = k.getIntent();
        g = bundle.getStringArrayExtra("paths");
        h = bundle.getIntArrayExtra("degrees");
        c = (GridView)k.findViewById(0x7f100636);
        if (d != null)
        {
            a(d);
            d = null;
        }
        if (bundle.hasExtra("from"))
        {
            i = "collage".equals(bundle.getStringExtra("from"));
            return;
        } else
        {
            i = false;
            return;
        }
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        k = activity;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030124, viewgroup, false);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        if (j != null)
        {
            j.cancel(true);
        }
        if (b != null)
        {
            b.a();
        }
    }

    public final void onItemClick(AdapterView adapterview, View view, int l, long l1)
    {
        AnalyticUtils.getInstance(k).trackLocalAction("collageCustomFrame:select");
        a(l, false);
    }
}
