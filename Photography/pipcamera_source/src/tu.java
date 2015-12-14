// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.List;

public class tu
    implements tn
{

    public static final String ACTION_MATERIAL_ADDED = "ACTION_MATERIAL_ADDED";
    public static final String ACTION_MATERIAL_CHANGE = "ACTION_MATERIAL_CHANGE";
    public static final String ACTION_MATERIAL_REMOVE = "ACTION_MATERIAL_REMOVE";
    public static final String INSTAMAG_IMAGE_COUNT = "INSTAMAG_IMAGE_COUNT";
    public static final String INSTAMAG_RESID = "INSTAMAG_RESID";
    public static final String INSTAMAG_TYPE = "INSTAMAG_TYPE";
    public static final String RESID_MATERIAL = "RESID_MATERIAL";
    public static final String TYPE_MATERIAL = "TYPE_MATERIAL";
    protected uj materialtype;
    tt operationDelegate;
    EOnlineResType type;

    public tu()
    {
    }

    public static EOnlineResType getResTypeByString(String s)
    {
        EOnlineResType eonlinerestype = EOnlineResType.PIP_SCENE;
        if (!s.equalsIgnoreCase("PIP_SCENE")) goto _L2; else goto _L1
_L1:
        eonlinerestype = EOnlineResType.PIP_SCENE;
_L4:
        if (s.equalsIgnoreCase("GIF_EFFECT"))
        {
            eonlinerestype = EOnlineResType.GIF_EFFECT;
        }
        return eonlinerestype;
_L2:
        if (s.equalsIgnoreCase("PIP_SCENE2"))
        {
            eonlinerestype = EOnlineResType.PIP_SCENE2;
        } else
        if (s.equalsIgnoreCase("LIGHT_FILTER"))
        {
            eonlinerestype = EOnlineResType.LIGHT_FILTER;
        } else
        if (s.equalsIgnoreCase("FILTER_FRAME"))
        {
            eonlinerestype = EOnlineResType.FILTER_FRAME;
        } else
        if (s.equalsIgnoreCase("FREE_COLLAGE_STYLE"))
        {
            eonlinerestype = EOnlineResType.FREE_COLLAGE_STYLE;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getStringByResType(EOnlineResType eonlinerestype)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[EOnlineResType.values().length];
                try
                {
                    a[EOnlineResType.PIP_SCENE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[EOnlineResType.PIP_SCENE2.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[EOnlineResType.LIGHT_FILTER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[EOnlineResType.FILTER_FRAME.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[EOnlineResType.FREE_COLLAGE_STYLE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[eonlinerestype.ordinal()])
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
            operationDelegate.b(obj);
        }
        archive();
    }

    public void filterDownloadStarting(int i)
    {
        if (operationDelegate != null)
        {
            operationDelegate.a(Integer.valueOf(i));
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

    public uj getMaterialType()
    {
        return materialtype;
    }

    public EOnlineResType getType()
    {
        return type;
    }

    public tt getoperationDelegate()
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

    public void setMaterialType(uj uj)
    {
        materialtype = uj;
    }

    public void setType(EOnlineResType eonlinerestype)
    {
        type = eonlinerestype;
    }

    public void setoperationDelegate(tt tt1)
    {
        operationDelegate = tt1;
    }

    public void unarchive()
    {
    }

    public void update()
    {
    }
}
