// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.Model.OnlineResImageAdapter;
import com.wantu.ResourceOnlineLibrary.TOnlineConfigItem;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneMode;
import java.util.ArrayList;
import kf;
import tu;
import tz;
import ua;
import uj;
import yf;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            BaseOnlineFragement, MainResourceActivity

public class MaterialListFragement extends BaseOnlineFragement
{

    private uj g;
    private ESceneMode h;

    public MaterialListFragement()
    {
        h = ESceneMode.SCENE_MODE1;
    }

    public static MaterialListFragement a(uj uj1)
    {
        MaterialListFragement materiallistfragement = new MaterialListFragement();
        materiallistfragement.g = uj1;
        return materiallistfragement;
    }

    static ESceneMode a(MaterialListFragement materiallistfragement)
    {
        return materiallistfragement.h;
    }

    public void a(TResInfo tresinfo)
    {
        int i = 0;
_L3:
        if (i >= g.g.size())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (!((TResInfo)g.g.get(i)).name.equalsIgnoreCase(tresinfo.name)) goto _L2; else goto _L1
_L1:
        tresinfo = (TResInfo)g.g.get(i);
_L4:
        g.g.remove(tresinfo);
        tresinfo = g;
        tresinfo.e = ((uj) (tresinfo)).e - 1;
        return;
_L2:
        i++;
          goto _L3
        tresinfo = null;
          goto _L4
    }

    public void a(tu tu, ArrayList arraylist)
    {
        if (d != null)
        {
            d.e();
        }
        for (int i = 0; i < arraylist.size(); i++)
        {
            tu = (TResInfo)arraylist.get(i);
            c.add(tu);
        }

        b.setItemList(c);
        if (g != null)
        {
            (new TOnlineConfigItem()).setUpdateDateDictByChildType(g.d, g.a, g.f.longValue());
        }
    }

    public void b(Object obj)
    {
        super.b(obj);
        if (d != null)
        {
            d.e();
            MainResourceActivity mainresourceactivity = d;
            String s;
            if (isAdded())
            {
                s = d.getResources().getString(0x7f0600d6);
            } else
            {
                s = "download completed";
            }
            Toast.makeText(mainresourceactivity, s, 0).show();
        }
        obj = (TResInfo)obj;
        b.removeItem(((TResInfo) (obj)));
        a(((TResInfo) (obj)));
    }

    public void c(Object obj)
    {
        Log.v("donwload item", "TAG button Clicked");
        obj = (TResInfo)obj;
        tz.a().a(((TResInfo) (obj)), new ua() {

            final MaterialListFragement a;

            public void a(TResInfo tresinfo)
            {
                if (a.d != null)
                {
                    a.d.a(a.d.getResources().getString(0x7f0600da), BaseOnlineFragement.e);
                }
            }

            public void a(TResInfo tresinfo, float f)
            {
            }

            public void a(TDFSceneInfo tdfsceneinfo)
            {
                if (a.d != null)
                {
                    a.d.e();
                    Toast.makeText(a.d, a.d.getResources().getString(0x7f0600d6), 0).show();
                }
                a.b.removeItem(tdfsceneinfo);
                a.a(tdfsceneinfo);
                tdfsceneinfo.setMode(MaterialListFragement.a(a));
                kf.c().d().a(tdfsceneinfo);
            }

            public void b(TResInfo tresinfo)
            {
                if (a.d != null)
                {
                    a.d.e();
                    Toast.makeText(a.d, a.d.getResources().getString(0x7f0600d7), 0).show();
                }
            }

            
            {
                a = MaterialListFragement.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (g != null)
        {
            int i = 0;
            while (i < g.g.size()) 
            {
                bundle = (TResInfo)g.g.get(i);
                if (g.d == EOnlineResType.PIP_SCENE)
                {
                    h = ESceneMode.SCENE_MODE1;
                } else
                {
                    h = ESceneMode.SCENE_MODE2;
                }
                if (bundle != null && !kf.c().d().a(((TResInfo) (bundle)).resId, h))
                {
                    c.add(bundle);
                }
                i++;
            }
        }
    }
}
