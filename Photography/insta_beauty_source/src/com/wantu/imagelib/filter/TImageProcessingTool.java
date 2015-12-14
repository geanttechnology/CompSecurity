// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.wantu.imagelib.filter:
//            ProcessType, TImageFilterManager, TLightingFilterManager, TImageFilter, 
//            TImageFilterInfo, TImageProcessingDelegate

public class TImageProcessingTool
{

    static final boolean $assertionsDisabled;
    private static final String TAG = "TImageProcessingTool";
    private TImageFilterManager filterManager;
    private ProcessType type;

    public TImageProcessingTool()
    {
    }

    public TImageProcessingTool(ProcessType processtype, TImageProcessingDelegate timageprocessingdelegate)
    {
        type = processtype;
        _cls1..SwitchMap.com.wantu.imagelib.filter.ProcessType[processtype.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 58
    //                   2 78
    //                   3 78;
           goto _L1 _L2 _L3 _L3
_L1:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L2:
        filterManager = new TImageFilterManager();
_L5:
        filterManager.setmDelegate(timageprocessingdelegate);
        return;
_L3:
        filterManager = new TLightingFilterManager();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void configFilterRect(Rect rect)
    {
    }

    public TImageFilterManager getFilterManager()
    {
        return filterManager;
    }

    public ProcessType getType()
    {
        return type;
    }

    public List groupFilterNames(String s)
    {
        return null;
    }

    public void installFilter(TImageFilterInfo timagefilterinfo)
    {
        filterManager.installFilter(timagefilterinfo);
    }

    public void setFilterManager(TImageFilterManager timagefiltermanager)
    {
        filterManager = timagefiltermanager;
    }

    public void setType(ProcessType processtype)
    {
        type = processtype;
    }

    public Boolean startProcessing(Bitmap bitmap, String s)
    {
        s = filterManager.filterWithName(s);
        if (s == null)
        {
            Log.v("TImageProcessingTool", "no filter found");
            return Boolean.valueOf(false);
        } else
        {
            s.setSourceBmp(bitmap);
            s.setmDelegate(filterManager.getmDelegate());
            s.execute(new String[] {
                s.getmInfo().filterName
            });
            return Boolean.valueOf(true);
        }
    }

    public List supportedFilter()
    {
        ArrayList arraylist = new ArrayList();
        if (type == ProcessType.TSingleType || type == ProcessType.TLightStream)
        {
            for (int i = 0; i < filterManager.getmKeyOderArray().size(); i++)
            {
                String s = (String)filterManager.getmKeyOderArray().get(i);
                if (s != null)
                {
                    arraylist.add(filterManager.getmFilterDict().get(s));
                }
            }

            return arraylist;
        } else
        {
            return null;
        }
    }

    public Bitmap syncProcessing(Bitmap bitmap, String s)
    {
        s = filterManager.filterWithName(s);
        if (s == null)
        {
            Log.v("TImageProcessingTool", "no filter found");
            return null;
        } else
        {
            s.setSourceBmp(bitmap);
            s.setmDelegate(filterManager.getmDelegate());
            return s.process();
        }
    }

    static 
    {
        boolean flag;
        if (!com/wantu/imagelib/filter/TImageProcessingTool.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private class _cls1
    {

        static final int $SwitchMap$com$wantu$imagelib$filter$ProcessType[];

        static 
        {
            $SwitchMap$com$wantu$imagelib$filter$ProcessType = new int[ProcessType.values().length];
            try
            {
                $SwitchMap$com$wantu$imagelib$filter$ProcessType[ProcessType.TSingleType.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$wantu$imagelib$filter$ProcessType[ProcessType.TGifType.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$wantu$imagelib$filter$ProcessType[ProcessType.TLightStream.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
