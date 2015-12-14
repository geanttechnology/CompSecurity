// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.List;

public class bgv
    implements bge
{

    public static final String ACTION_MATERIAL_ADDED = "ACTION_MATERIAL_ADDED";
    public static final String ACTION_MATERIAL_CHANGE = "ACTION_MATERIAL_CHANGE";
    public static final String ACTION_MATERIAL_REMOVE = "ACTION_MATERIAL_REMOVE";
    public static final String INSTAMAG_IMAGE_COUNT = "INSTAMAG_IMAGE_COUNT";
    public static final String INSTAMAG_RESID = "INSTAMAG_RESID";
    public static final String INSTAMAG_TYPE = "INSTAMAG_TYPE";
    public static final String NAME_MATERIAL = "NAME_MATERIAL";
    public static final String TYPE_MATERIAL = "TYPE_MATERIAL";
    public bgz materialtype;
    bgu operationDelegate;
    EOnlineResType type;

    public bgv()
    {
    }

    public static EOnlineResType getResTypeByString(String s)
    {
        EOnlineResType eonlinerestype = EOnlineResType.PIP_SCENE;
        if (s.equalsIgnoreCase("PIP_SCENE"))
        {
            eonlinerestype = EOnlineResType.PIP_SCENE;
        } else
        {
            if (s.equalsIgnoreCase("PIP_SCENE2"))
            {
                return EOnlineResType.PIP_SCENE2;
            }
            if (s.equalsIgnoreCase("LIGHT_FILTER"))
            {
                return EOnlineResType.LIGHT_FILTER;
            }
            if (s.equalsIgnoreCase("FILTER_FRAME"))
            {
                return EOnlineResType.FILTER_FRAME;
            }
            if (s.equalsIgnoreCase("FREE_COLLAGE_STYLE"))
            {
                return EOnlineResType.FREE_COLLAGE_STYLE;
            }
            if (s.equalsIgnoreCase("GIF_EFFECT"))
            {
                return EOnlineResType.GIF_EFFECT;
            }
            if (s.equalsIgnoreCase("MAG_MASK_INFO"))
            {
                return EOnlineResType.MAG_MASK_INFO;
            }
        }
        return eonlinerestype;
    }

    public static String getStringByResType(EOnlineResType eonlinerestype)
    {
        switch (bgw.a[eonlinerestype.ordinal()])
        {
        default:
            return "PIP_SCENE";

        case 1: // '\001'
            return "PIP_SCENE";

        case 2: // '\002'
            return "PIP_SCENE2";

        case 3: // '\003'
            return "LIGHT_FILTER";

        case 4: // '\004'
            return "FILTER_FRAME";

        case 5: // '\005'
            return "FREE_COLLAGE_STYLE";

        case 6: // '\006'
            return "GIF_EFFECT";

        case 7: // '\007'
            return "MAG_MASK_INFO";
        }
    }

    public List AllInfos()
    {
        return null;
    }

    public void archive()
    {
    }

    public void deleteInfo(TResInfo tresinfo)
    {
    }

    public void downloadRes(TResInfo tresinfo)
    {
    }

    public void filterDownloadFailed(int i, Object obj)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(i, obj);
        }
    }

    public void filterDownloadFinished(Object obj)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(obj);
        }
        archive();
    }

    public void filterDownloadStarting(int i)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(i);
        }
    }

    public void filterDownloadUploadData(float f, Object obj)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(f, obj);
        }
    }

    public void filterUpdateFailed(int i)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(this, i);
        }
    }

    public void filterUpdateFinished(ArrayList arraylist)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(this, arraylist);
        }
    }

    public void filterUpdateStarting()
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(this);
        }
    }

    public bgz getMaterialType()
    {
        return materialtype;
    }

    public EOnlineResType getType()
    {
        return type;
    }

    public bgu getoperationDelegate()
    {
        return operationDelegate;
    }

    public List netMaterials()
    {
        return null;
    }

    public void newFilterCount(int i)
    {
        if (operationDelegate != null)
        {
            operationDelegate.b(this, i);
        }
    }

    public void setMaterialType(bgz bgz)
    {
        materialtype = bgz;
    }

    public void setType(EOnlineResType eonlinerestype)
    {
        type = eonlinerestype;
    }

    public void setoperationDelegate(bgu bgu1)
    {
        operationDelegate = bgu1;
    }

    public void unarchive()
    {
    }

    public void update()
    {
    }
}
