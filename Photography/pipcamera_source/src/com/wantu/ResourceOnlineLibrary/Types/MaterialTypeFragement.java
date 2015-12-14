// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Types;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.fotoable.comlib.util.ImageCache;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.activity.MainResourceActivity;
import ew;
import fo;
import fq;
import java.util.ArrayList;
import jw;
import kb;
import org.json.JSONException;
import org.json.JSONObject;
import tu;
import ty;
import uc;
import ue;
import ug;
import uh;
import ui;
import uj;
import uk;
import ul;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.Types:
//            SectionListAdapter, MaterialParentView, MaterialChildView

public class MaterialTypeFragement extends Fragment
    implements ui
{

    private String a;
    private String b;
    private String c;
    private MainResourceActivity d;
    private ul e;
    private Boolean f;
    private ArrayList g;
    private ArrayList h;
    private SectionListAdapter i;
    private ug j;
    private LayoutInflater k;
    private boolean l;
    private jw m;

    public MaterialTypeFragement()
    {
        a = "ACACHE_PIP_ONLINELIB_JSON_TAG";
        b = "BaseOnlineFramgement";
        c = uc.k;
        d = null;
        f = Boolean.valueOf(false);
        g = new ArrayList(0);
        h = new ArrayList();
        l = false;
    }

    static MainResourceActivity a(MaterialTypeFragement materialtypefragement)
    {
        return materialtypefragement.d;
    }

    static Boolean a(MaterialTypeFragement materialtypefragement, Boolean boolean1)
    {
        materialtypefragement.f = boolean1;
        return boolean1;
    }

    static ArrayList a(MaterialTypeFragement materialtypefragement, ArrayList arraylist)
    {
        materialtypefragement.g = arraylist;
        return arraylist;
    }

    static ArrayList b(MaterialTypeFragement materialtypefragement)
    {
        return materialtypefragement.h;
    }

    private void b()
    {
        String s = kb.a();
        JSONObject jsonobject = m.b(a);
        if (jsonobject != null)
        {
            Log.v(b, (new StringBuilder()).append(b).append("get data from Cache").toString());
            g = ty.a(jsonobject, h);
            if (g != null && g.size() > 0)
            {
                i.notifyDataSetChanged();
                return;
            }
        }
        Log.v("RequestURl %@", (new StringBuilder()).append("RequestURl:").append(s).toString());
        if (e != null && !e.isCancelled())
        {
            e.cancel(true);
            e = null;
        }
        if (d != null)
        {
            d.a("", -1);
        }
        e = new ul(PIPCameraApplication.a, s);
        e.a(new ue() {

            final MaterialTypeFragement a;

            public void a(String s1)
            {
                if (MaterialTypeFragement.a(a) != null)
                {
                    MaterialTypeFragement.a(a).e();
                }
                if (s1 == null || s1.length() <= 0)
                {
                    break MISSING_BLOCK_LABEL_159;
                }
                MaterialTypeFragement.a(a, Boolean.valueOf(true));
                if (s1 != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                try
                {
                    s1 = new JSONObject(s1);
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    s1.printStackTrace();
                    s1 = null;
                }
                MaterialTypeFragement.a(a, ty.a(s1, MaterialTypeFragement.b(a)));
                if (MaterialTypeFragement.c(a) == null || MaterialTypeFragement.c(a).size() <= 0) goto _L1; else goto _L3
_L3:
                MaterialTypeFragement.e(a).c(MaterialTypeFragement.d(a));
                MaterialTypeFragement.e(a).a(MaterialTypeFragement.d(a), s1, 300);
                MaterialTypeFragement.f(a).notifyDataSetChanged();
                return;
                s1 = "\u6570\u636E\u8BF7\u6C42\u5931\u8D25\uFF01";
                if (!ew.a())
                {
                    s1 = "Request failed!";
                }
                Toast.makeText(PIPCameraApplication.a, s1, 0).show();
                return;
            }

            
            {
                a = MaterialTypeFragement.this;
                super();
            }
        });
        e.execute(new String[0]);
    }

    private fq c()
    {
        if (j == null)
        {
            fo fo1 = new fo(getActivity().getApplicationContext(), ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.PNG;
            fo1.a(0.05F);
            j = new ug(getActivity(), d());
            j.a(getActivity().getSupportFragmentManager(), fo1);
        }
        return j;
    }

    static ArrayList c(MaterialTypeFragement materialtypefragement)
    {
        return materialtypefragement.g;
    }

    private int d()
    {
        return getActivity().getResources().getDimensionPixelSize(0x7f080048);
    }

    static String d(MaterialTypeFragement materialtypefragement)
    {
        return materialtypefragement.a;
    }

    static jw e(MaterialTypeFragement materialtypefragement)
    {
        return materialtypefragement.m;
    }

    static SectionListAdapter f(MaterialTypeFragement materialtypefragement)
    {
        return materialtypefragement.i;
    }

    public int a()
    {
        if (g != null)
        {
            return g.size();
        } else
        {
            return 0;
        }
    }

    public int a(int i1)
    {
        if (g != null)
        {
            uk uk1 = (uk)g.get(i1);
            if (uk1 != null)
            {
                return uk1.c.size();
            } else
            {
                return 0;
            }
        } else
        {
            return 0;
        }
    }

    public View a(int i1, View view, ViewGroup viewgroup)
    {
        viewgroup = ((ViewGroup) (g.get(i1)));
        if (viewgroup instanceof uk)
        {
            viewgroup = (uk)viewgroup;
            if (view != null && (view instanceof MaterialParentView))
            {
                view = (MaterialParentView)view;
            } else
            {
                view = new MaterialParentView(d);
            }
            view.SetDataItem(viewgroup);
            return view;
        } else
        {
            return null;
        }
    }

    public View a(uh uh1, View view, ViewGroup viewgroup)
    {
        viewgroup = ((ViewGroup) (g.get(uh1.a)));
        if (viewgroup instanceof uk)
        {
            viewgroup = (uj)((uk)viewgroup).c.get(uh1.b);
            if (view != null && (view instanceof MaterialChildView))
            {
                uh1 = (MaterialChildView)view;
            } else
            {
                uh1 = new MaterialChildView(d, j);
            }
            uh1.SetDataItem(viewgroup);
            return uh1;
        } else
        {
            return null;
        }
    }

    public void a(uh uh1, View view)
    {
        Object obj = g.get(uh1.a);
        if ((obj instanceof uk) && d != null)
        {
            uh1 = (uj)((uk)obj).c.get(uh1.b);
            if (uh1 != null)
            {
                if (view instanceof MaterialChildView)
                {
                    ((MaterialChildView)view).refresh();
                }
                d.a(uh1);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d = (MainResourceActivity)getActivity();
        m = jw.a(d);
        for (int i1 = 0; i1 < d.b().size(); i1++)
        {
            bundle = (String)d.b().get(i1);
            h.add(tu.getResTypeByString(bundle));
        }

        i = new SectionListAdapter();
        i._flddelegate = this;
        k = LayoutInflater.from(d);
        c();
        l = uc.a(d);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005b, viewgroup, false);
        viewgroup = (ListView)layoutinflater.findViewById(0x7f0c0193);
        viewgroup.setAdapter(i);
        viewgroup.setOnItemClickListener(i.itemClickListener);
        if (l)
        {
            b();
        } else
        {
            i.notifyDataSetChanged();
        }
        d.a(Boolean.valueOf(true));
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (e != null && !e.isCancelled())
        {
            e.cancel(true);
            e.a(null);
            e = null;
        }
    }

    public void onPause()
    {
        super.onPause();
        Log.d(b, "onPause");
        if (j != null)
        {
            j.a(true);
        }
    }

    public void onResume()
    {
        Log.v(b, (new StringBuilder()).append(b).append(" onresume").toString());
        super.onResume();
        if (j != null)
        {
            j.a(false);
        }
    }
}
