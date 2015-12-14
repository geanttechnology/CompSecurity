// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.picsart.collages.CollageCategoryItem;
import com.socialin.gson.Gson;
import com.socialin.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Referenced classes of package com.socialin.android.photo.template:
//            CustomTemplate, c, d

public class b extends Fragment
{

    private static int d = 0;
    private static String e = "collages/";
    public d a;
    private c b;
    private ListView c;

    public b()
    {
        b = null;
    }

    static int a()
    {
        return d;
    }

    static ListView a(b b1)
    {
        return b1.c;
    }

    private void a(int i)
    {
        AppCompatActivity appcompatactivity = (AppCompatActivity)getActivity();
        if (b == null || a == null || appcompatactivity == null)
        {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("type", 0);
        intent.putExtra("readFrom", CustomTemplate.b[i]);
        intent.putExtra("selectedCollagePackage", (Parcelable)b.getItem(i));
        a.a(intent);
        d = i;
        b.notifyDataSetChanged();
        if (appcompatactivity.getSupportActionBar() != null)
        {
            appcompatactivity.getSupportActionBar().setTitle(CustomTemplate.a[i]);
        }
        c.post(new Runnable() {

            private b a;

            public final void run()
            {
                b.a(a).setItemChecked(b.a(), true);
            }

            
            {
                a = b.this;
                super();
            }
        });
    }

    static void a(b b1, int i)
    {
        b1.a(i);
    }

    public final void a(d d1)
    {
        a = d1;
        a(d);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        Object obj;
        c = (ListView)getView().findViewById(0x7f10028b);
        b = new c(this, getActivity().getApplicationContext());
        c.setAdapter(b);
        c.setSelected(true);
        c.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(bundle) {

            private Activity a;
            private b b;

            public final void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                adapterview = a.findViewById(0x7f100169);
                if (adapterview != null && (adapterview instanceof ViewPager))
                {
                    ((ViewPager)adapterview).setCurrentItem(1, true);
                }
                if (b.a() != j)
                {
                    b.a(b, j);
                }
            }

            
            {
                b = b.this;
                a = activity;
                super();
            }
        });
        obj = null;
        bundle = null;
        Object obj1 = getResources().getAssets().open((new StringBuilder()).append(e).append("collage_meta.json").toString());
        bundle = ((Bundle) (obj1));
        obj = obj1;
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(((InputStream) (obj1))));
        bundle = ((Bundle) (obj1));
        obj = obj1;
        StringBuilder stringbuilder = new StringBuilder();
_L4:
        bundle = ((Bundle) (obj1));
        obj = obj1;
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        stringbuilder.append(s);
        if (true) goto _L4; else goto _L3
_L5:
        ((IOException) (obj1)).printStackTrace();
        CollageCategoryItem acollagecategoryitem[];
        int i;
        if (bundle != null)
        {
            try
            {
                bundle.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        a(d);
_L2:
        return;
_L3:
        bundle = ((Bundle) (obj1));
        obj = obj1;
        acollagecategoryitem = (CollageCategoryItem[])(new GsonBuilder()).create().fromJson(stringbuilder.toString(), [Lcom/picsart/collages/CollageCategoryItem;);
        i = 0;
_L6:
        bundle = ((Bundle) (obj1));
        obj = obj1;
        if (i >= acollagecategoryitem.length)
        {
            break MISSING_BLOCK_LABEL_468;
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        if (!"Square(1:1)".equalsIgnoreCase(acollagecategoryitem[i].a))
        {
            break MISSING_BLOCK_LABEL_293;
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        try
        {
            acollagecategoryitem[i].a = getString(0x7f0800d3);
            break MISSING_BLOCK_LABEL_516;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = bundle;
        }
        finally
        {
            if (obj != null)
            {
                try
                {
                    ((InputStream) (obj)).close();
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
            }
            throw bundle;
        }
          goto _L5
        bundle = ((Bundle) (obj1));
        obj = obj1;
        if (!"Landscape(4:3)".equalsIgnoreCase(acollagecategoryitem[i].a))
        {
            break MISSING_BLOCK_LABEL_345;
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        acollagecategoryitem[i].a = getString(0x7f0800d0);
        break MISSING_BLOCK_LABEL_516;
        bundle = ((Bundle) (obj1));
        obj = obj1;
        if (!"Portrait(3:4)".equalsIgnoreCase(acollagecategoryitem[i].a))
        {
            break MISSING_BLOCK_LABEL_386;
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        acollagecategoryitem[i].a = getString(0x7f0800d2);
        break MISSING_BLOCK_LABEL_516;
        bundle = ((Bundle) (obj1));
        obj = obj1;
        if (!"Fb Cover(851 x 315)".equalsIgnoreCase(acollagecategoryitem[i].a))
        {
            break MISSING_BLOCK_LABEL_427;
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        acollagecategoryitem[i].a = getString(0x7f0800ce);
        break MISSING_BLOCK_LABEL_516;
        bundle = ((Bundle) (obj1));
        obj = obj1;
        if (!"Lines".equalsIgnoreCase(acollagecategoryitem[i].a))
        {
            break MISSING_BLOCK_LABEL_516;
        }
        bundle = ((Bundle) (obj1));
        obj = obj1;
        acollagecategoryitem[i].a = getString(0x7f0800d1);
        break MISSING_BLOCK_LABEL_516;
        bundle = ((Bundle) (obj1));
        obj = obj1;
        b.addAll(acollagecategoryitem);
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_200;
        i++;
          goto _L6
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030068, viewgroup, false);
    }

    static 
    {
        com/socialin/android/photo/template/b.getSimpleName();
    }
}
