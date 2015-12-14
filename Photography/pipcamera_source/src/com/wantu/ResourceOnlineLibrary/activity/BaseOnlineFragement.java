// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.Toast;
import com.fotoable.comlib.util.ImageCache;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.Model.OnlineResImageAdapter;
import com.wantu.model.res.TResInfo;
import fo;
import fq;
import java.util.ArrayList;
import tl;
import tt;
import tu;
import um;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            MainResourceActivity

public class BaseOnlineFragement extends Fragment
    implements tt, um
{

    static int e = 1558;
    static int f = 1559;
    protected tu a;
    protected OnlineResImageAdapter b;
    protected ArrayList c;
    protected MainResourceActivity d;
    private String g;
    private int h;
    private int i;
    private int j;
    private fq k;
    private fq l;

    public BaseOnlineFragement()
    {
        a = null;
        g = "BaseOnlineFramgement";
        c = new ArrayList(0);
        l = null;
    }

    static int a(BaseOnlineFragement baseonlinefragement)
    {
        return baseonlinefragement.h;
    }

    private fq a()
    {
        if (l == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.PNG;
            fo1.a(0.05F);
            l = new tl(getActivity(), b());
            l.a(getActivity().getSupportFragmentManager(), fo1);
        }
        return l;
    }

    private int b()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f080048);
    }

    static int b(BaseOnlineFragement baseonlinefragement)
    {
        return baseonlinefragement.i;
    }

    static int c(BaseOnlineFragement baseonlinefragement)
    {
        return baseonlinefragement.j;
    }

    static String d(BaseOnlineFragement baseonlinefragement)
    {
        return baseonlinefragement.g;
    }

    public void a(float f1, Object obj)
    {
    }

    public void a(int i1, Object obj)
    {
        if (d != null)
        {
            d.e();
            Toast.makeText(d, d.getResources().getString(0x7f0600d7), 0).show();
        }
        Log.v(g, "download iamge failed");
    }

    public void a(Object obj)
    {
        Log.v(g, "start download online materail");
        if (d != null)
        {
            d.a(d.getResources().getString(0x7f0600da), e);
        }
    }

    public void a(tu tu1)
    {
        if (d != null)
        {
            d.a(d.getResources().getString(0x7f060109), f);
        }
    }

    public void a(tu tu1, int i1)
    {
        if (d != null)
        {
            d.e();
            Toast.makeText(PIPCameraApplication.a, PIPCameraApplication.a.getResources().getString(0x7f060105), 1).show();
        }
    }

    public void a(tu tu1, ArrayList arraylist)
    {
        if (d != null)
        {
            d.e();
        }
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            tu1 = (TResInfo)arraylist.get(i1);
            c.add(tu1);
            Log.v((new StringBuilder()).append(g).append("\tinfo.name:").toString(), ((TResInfo) (tu1)).name);
            Log.v((new StringBuilder()).append(g).append("\tinfo.icon:").toString(), ((TResInfo) (tu1)).icon);
        }

        Log.v(g, String.format("%d", new Object[] {
            Integer.valueOf(c.size())
        }));
        b.setItemList(c);
    }

    public void b(Object obj)
    {
        if (d != null)
        {
            d.e();
            Toast.makeText(d, d.getResources().getString(0x7f0600d6), 0).show();
        }
        obj = (TResInfo)obj;
        b.removeItem(((TResInfo) (obj)));
        Log.v(g, "download iamge success");
        if (d != null)
        {
            d.g();
        }
    }

    public void b(tu tu1, int i1)
    {
    }

    public void c(Object obj)
    {
        Log.v(g, "download button Clicked");
        if (d != null)
        {
            d.a(d.getResources().getString(0x7f0600da), e);
        }
        if (a != null)
        {
            obj = (TResInfo)obj;
            a.downloadRes(((TResInfo) (obj)));
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (MainResourceActivity)activity;
        Log.d(g, "onAttach");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        h = b();
        k = a();
        i = getResources().getDimensionPixelSize(0x7f08004a);
        j = getResources().getDimensionPixelSize(0x7f080047);
        b = new OnlineResImageAdapter(getActivity(), c, k);
        b.setmDelegate(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007b, viewgroup, false);
        viewgroup = (GridView)layoutinflater.findViewById(0x7f0c0229);
        viewgroup.setAdapter(b);
        if (k != null)
        {
            k.a(android.graphics.Bitmap.CompressFormat.PNG);
        }
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewgroup) {

            final GridView a;
            final BaseOnlineFragement b;

            public void onGlobalLayout()
            {
                if (b.b.getNumColumns() == 0)
                {
                    int i1 = (int)Math.floor(a.getWidth() / (BaseOnlineFragement.a(b) + BaseOnlineFragement.b(b)));
                    if (i1 > 0)
                    {
                        int j1 = a.getWidth() / i1;
                        int k1 = BaseOnlineFragement.b(b);
                        b.b.setNumColumns(i1);
                        b.b.setItemHeight((j1 - k1) + BaseOnlineFragement.c(b));
                        Log.d(BaseOnlineFragement.d(b), (new StringBuilder()).append("onCreateView - numColumns set to ").append(i1).toString());
                    }
                }
            }

            
            {
                b = BaseOnlineFragement.this;
                a = gridview;
                super();
            }
        });
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        Log.d(g, "onPause");
        if (k != null)
        {
            k.a(true);
        }
    }

    public void onResume()
    {
        Log.v(g, (new StringBuilder()).append(g).append(" onresume").toString());
        super.onResume();
        if (k != null)
        {
            k.a(false);
        }
    }

}
