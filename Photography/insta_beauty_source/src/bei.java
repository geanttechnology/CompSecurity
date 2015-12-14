// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bei
{

    private ArrayList a;
    private bgv b;
    private ben c;

    public bei()
    {
        a = new ArrayList(0);
    }

    public InstaMagType a(TPhotoComposeInfo tphotocomposeinfo)
    {
        InstaMagType instamagtype1 = InstaMagType.RECT_LIB_SIZE_TYPE;
        InstaMagType instamagtype;
        if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 480F)
        {
            instamagtype = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        {
            if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 320F)
            {
                return InstaMagType.SQ_LIB_SIZE_TYPE;
            }
            instamagtype = instamagtype1;
            if (tphotocomposeinfo.width == 320F)
            {
                instamagtype = instamagtype1;
                if (tphotocomposeinfo.height == 214F)
                {
                    return InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
                }
            }
        }
        return instamagtype;
    }

    public List a(InstaMagType instamagtype)
    {
        ArrayList arraylist = new ArrayList(0);
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            for (int i = 0; i < a.size(); i++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(i);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 480F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
        {
            for (int j = 0; j < a.size(); j++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(j);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 320F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            for (int k = 0; k < a.size(); k++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(k);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 214F)
                {
                    arraylist.add(instamagtype);
                }
            }

        } else
        if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
        {
            for (int l = 0; l < a.size(); l++)
            {
                instamagtype = (TPhotoComposeInfo)a.get(l);
                if (((TPhotoComposeInfo) (instamagtype)).width == 320F && ((TPhotoComposeInfo) (instamagtype)).height == 960F)
                {
                    arraylist.add(instamagtype);
                }
            }

        }
        Collections.sort(arraylist, new bej(this));
        return arraylist;
    }

    public List a(InstaMagType instamagtype, int i)
    {
        if (i == -1)
        {
            return a(instamagtype);
        }
        if (i == 0)
        {
            return b(instamagtype);
        }
        instamagtype = a(instamagtype);
        Iterator iterator = instamagtype.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((TPhotoComposeInfo)iterator.next()).imageCount != i)
            {
                iterator.remove();
            }
        } while (true);
        Collections.sort(instamagtype, new bek(this));
        return instamagtype;
    }

    public void a()
    {
        Object obj = EOnlineResType.MAG_MASK_INFO;
        a.clear();
        b = bgs.a(((EOnlineResType) (obj)));
        obj = b.AllInfos();
        if (obj != null)
        {
            for (int i = 0; i < ((List) (obj)).size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)((List) (obj)).get(i);
                if (tphotocomposeinfo.icon != null && tphotocomposeinfo.icon.length() > 0)
                {
                    a.add(tphotocomposeinfo);
                }
            }

        }
        if (c != null)
        {
            c.a(a);
        }
    }

    public List b()
    {
        ArrayList arraylist = new ArrayList(0);
        for (int i = 0; i < a.size(); i++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)a.get(i);
            if (tphotocomposeinfo.useCount > 0)
            {
                arraylist.add(tphotocomposeinfo);
            }
        }

        Collections.sort(arraylist, new bel(this));
        Collections.sort(arraylist, new bem(this));
        return arraylist;
    }

    public List b(InstaMagType instamagtype)
    {
        List list = b();
        if (list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (a((TPhotoComposeInfo)iterator.next()) != instamagtype)
                {
                    iterator.remove();
                }
            } while (true);
        }
        return list;
    }
}
