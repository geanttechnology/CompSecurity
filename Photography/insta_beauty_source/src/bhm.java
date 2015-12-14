// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.List;

public class bhm
    implements bgu
{

    private String a;
    private int b;
    private ArrayList c;
    private bgv d;
    private bhn e;

    public bhm(int i)
    {
        a = "TPhotoOnlineMagListModel";
        b = -1;
        c = new ArrayList(0);
        b = i;
    }

    public bgv a()
    {
        if (d == null)
        {
            d = bgs.a(EOnlineResType.MAG_MASK_INFO);
            d.setoperationDelegate(this);
        }
        return d;
    }

    public List a(InstaMagType instamagtype)
    {
        ArrayList arraylist = new ArrayList(0);
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            for (int i = 0; i < c.size(); i++)
            {
                instamagtype = (TPhotoComposeInfo)c.get(i);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 480F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            for (int j = 0; j < c.size(); j++)
            {
                instamagtype = (TPhotoComposeInfo)c.get(j);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 320F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            for (int k = 0; k < c.size(); k++)
            {
                instamagtype = (TPhotoComposeInfo)c.get(k);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 214F)
                {
                    arraylist.add(instamagtype);
                }
            }

        }
        return arraylist;
    }

    public void a(float f, Object obj)
    {
    }

    public void a(int i)
    {
        if (e != null)
        {
            e.b();
        }
    }

    public void a(int i, Object obj)
    {
        if (e != null)
        {
            e.c();
        }
    }

    public void a(bgv bgv1)
    {
        Log.v(a, (new StringBuilder()).append(a).append(" :").append("updateStarting").toString());
        if (e != null)
        {
            e.e();
        }
    }

    public void a(bgv bgv1, int i)
    {
        Log.v(a, (new StringBuilder()).append(a).append(" :").append("updateFailed").toString());
        if (e != null)
        {
            e.d();
        }
    }

    public void a(bgv bgv1, ArrayList arraylist)
    {
    }

    public void a(bhn bhn1)
    {
        e = bhn1;
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo)
    {
        int i = 0;
_L3:
        if (i >= c.size())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((TPhotoComposeInfo)c.get(i)).resId != tphotocomposeinfo.resId) goto _L2; else goto _L1
_L1:
        tphotocomposeinfo = (TPhotoComposeInfo)c.get(i);
_L4:
        if (tphotocomposeinfo != null)
        {
            c.remove(tphotocomposeinfo);
        }
        return;
_L2:
        i++;
          goto _L3
        tphotocomposeinfo = null;
          goto _L4
    }

    public void a(Object obj)
    {
        if (e != null)
        {
            e.a(obj);
        }
    }

    public void b()
    {
        d = bgs.a(EOnlineResType.MAG_MASK_INFO);
        if (d != null)
        {
            d.setoperationDelegate(this);
            d.update();
        }
    }

    public void b(bgv bgv1, int i)
    {
    }
}
