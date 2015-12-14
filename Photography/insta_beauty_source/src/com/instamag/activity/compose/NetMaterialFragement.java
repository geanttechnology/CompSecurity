// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.compose;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import bbn;
import bbo;
import bbp;
import bbq;
import bhm;
import bhn;
import com.fotoable.comlib.util.ImageCache;
import com.instamag.activity.commonview.MagOnlineBottomActionBar;
import com.instamag.activity.commonview.TabItemView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagItemView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.MagComposeImageAdapter;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.List;
import zr;
import zt;

// Referenced classes of package com.instamag.activity.compose:
//            MainOnlineLibActivity, NetMaterialDownloadFragment

public class NetMaterialFragement extends Fragment
    implements android.widget.AdapterView.OnItemClickListener, bhn
{

    protected MagComposeImageAdapter a;
    protected ArrayList b;
    protected MainOnlineLibActivity c;
    private String d;
    private zt e;
    private zt f;
    private GridView g;
    private TabItemView h;
    private TabItemView i;
    private TabItemView j;
    private MagOnlineBottomActionBar k;

    public NetMaterialFragement()
    {
        d = "NetMaterialFragement";
        b = new ArrayList(0);
        f = null;
    }

    private zt f()
    {
        if (f == null)
        {
            zr zr1 = new zr(getActivity().getApplicationContext(), ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.JPEG;
            zr1.a(0.05F);
            f = new bbq(this, getActivity(), a());
            f.a(getActivity().getSupportFragmentManager(), zr1);
        }
        return f;
    }

    public int a()
    {
        return 320;
    }

    public void a(InstaMagType instamagtype)
    {
        if (c != null)
        {
            if (c.a() != null)
            {
                b.clear();
                instamagtype = c.a().a(instamagtype);
                for (int l = 0; l < instamagtype.size(); l++)
                {
                    TResInfo tresinfo = (TResInfo)instamagtype.get(l);
                    b.add(tresinfo);
                    Log.v((new StringBuilder()).append(d).append("\tinfo.name:").toString(), tresinfo.name);
                    Log.v((new StringBuilder()).append(d).append("\tinfo.icon:").toString(), tresinfo.icon);
                }

            }
            Log.v(d, String.format("%d", new Object[] {
                Integer.valueOf(b.size())
            }));
            a.setItemList(b);
            if (b.size() == 0 && getActivity() != null)
            {
                Toast.makeText(c, c.getResources().getString(0x7f060075), 0).show();
                return;
            }
        }
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (getActivity().getSupportFragmentManager().findFragmentById(0x7f0d00f6) instanceof NetMaterialFragement)
        {
            Log.v(d, (new StringBuilder()).append(d).append("goDownloadFragmentByTResInfo").toString());
            FragmentTransaction fragmenttransaction = getActivity().getSupportFragmentManager().beginTransaction();
            tphotocomposeinfo = NetMaterialDownloadFragment.a(c.a().a(), tphotocomposeinfo);
            fragmenttransaction.setCustomAnimations(0x7f040021, 0x7f040022, 0x7f040023, 0x7f040024);
            fragmenttransaction.replace(0x7f0d00f6, tphotocomposeinfo);
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public void a(Object obj)
    {
        if (c == null)
        {
            return;
        }
        if (c != null && !c.isFinishing())
        {
            c.g();
            c.f();
            Toast.makeText(c, c.getResources().getString(0x7f0600e6), 0).show();
        }
        obj = (TPhotoComposeInfo)obj;
        a.removeItem(((TResInfo) (obj)));
        if (c.a() != null)
        {
            c.a().a(((TPhotoComposeInfo) (obj)));
        }
        Log.v(d, "download iamge success");
    }

    public void b()
    {
    }

    public void b(InstaMagType instamagtype)
    {
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            h.setSelected(true);
            i.setSelected(false);
            j.setSelected(false);
        } else
        {
            if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                h.setSelected(false);
                i.setSelected(true);
                j.setSelected(false);
                return;
            }
            if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                h.setSelected(false);
                i.setSelected(false);
                j.setSelected(true);
                return;
            }
        }
    }

    public void c()
    {
        if (c != null && !c.isFinishing())
        {
            c.g();
            c.f();
            Toast.makeText(c, c.getResources().getString(0x7f0600e7), 0).show();
        }
        Log.v(d, "download iamge failed");
    }

    public void d()
    {
    }

    public void e()
    {
        if (c != null)
        {
            c.e();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = (MainOnlineLibActivity)activity;
        Log.v(d, (new StringBuilder()).append(d).append(" :on Attach").toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        e = f();
        a = new MagComposeImageAdapter(getActivity(), b, e);
        c.a().a(this);
        c.a().b();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300a8, viewgroup, false);
        k = (MagOnlineBottomActionBar)layoutinflater.findViewById(0x7f0d0272);
        h = (TabItemView)k.findViewById(0x7f0d0290);
        h.setSelected(true);
        i = (TabItemView)k.findViewById(0x7f0d0293);
        j = (TabItemView)k.findViewById(0x7f0d0296);
        h.setOnClickListener(new bbn(this));
        i.setOnClickListener(new bbo(this));
        j.setOnClickListener(new bbp(this));
        g = (GridView)layoutinflater.findViewById(0x7f0d0266);
        g.setAdapter(a);
        g.setOnItemClickListener(this);
        if (e != null)
        {
            e.a(android.graphics.Bitmap.CompressFormat.JPEG);
        }
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int l, long l1)
    {
        if (view != null && (view instanceof InstaMagItemView))
        {
            adapterview = ((InstaMagItemView)view).getItemData();
            if (adapterview instanceof TPhotoComposeInfo)
            {
                a((TPhotoComposeInfo)adapterview);
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        Log.d(d, "onPause");
        if (e != null)
        {
            e.a(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (e != null)
        {
            e.a(false);
        }
    }
}
