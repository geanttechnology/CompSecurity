// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary;

import android.util.Log;
import bgr;
import bgv;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.wantu.ResourceOnlineLibrary:
//            FileManager, EOnlineResType

public class TOnlineConfigItem
{

    private Map typesUpdateDict;

    public TOnlineConfigItem()
    {
        typesUpdateDict = new HashMap();
        unarchiveUpdateTimes();
    }

    private void archiveUpdateTimes()
    {
        String s = (new Gson()).toJson(typesUpdateDict);
        Log.v("exit:update new String ", s);
        FileManager.getInstance().saveOnlineConfigUpdateTimes(s);
    }

    public static String getChildNameByKey(String s)
    {
        String s2 = "";
        String s1 = s2;
        if (s != null)
        {
            int i = s.indexOf("_");
            s1 = s2;
            if (i > -1)
            {
                s1 = s2;
                if (i < s.length() - 1)
                {
                    s1 = s.substring(0, i);
                }
            }
        }
        return s1;
    }

    public static String getChildTypeUpdateKey(EOnlineResType eonlinerestype, String s)
    {
        return String.format("%s_%s_UPDATEDATE", new Object[] {
            s, bgv.getStringByResType(eonlinerestype)
        });
    }

    private void unarchiveUpdateTimes()
    {
        Object obj = new Gson();
        Object obj1 = FileManager.getInstance().getOnlineConfigUpdateTimes();
        if (obj1 != null)
        {
            obj = (Map)((Gson) (obj)).fromJson((String)obj1, (new bgr(this)).getType());
            if (obj != null)
            {
                typesUpdateDict = ((Map) (obj));
            }
        }
    }

    public long getUpdateDateByChildType(EOnlineResType eonlinerestype, String s)
    {
        long l = 0L;
        Map map = getUpdateDateDictByType(eonlinerestype);
        if (map != null)
        {
            l = ((Long)map.get(getChildTypeUpdateKey(eonlinerestype, s))).longValue();
        }
        return l;
    }

    public Map getUpdateDateDictByType(EOnlineResType eonlinerestype)
    {
        eonlinerestype = String.format("%s_UPDATEDATE", new Object[] {
            bgv.getStringByResType(eonlinerestype)
        });
        return (Map)typesUpdateDict.get(eonlinerestype);
    }

    public void setUpdateDateDictByChildType(EOnlineResType eonlinerestype, String s, long l)
    {
        Object obj = getUpdateDateDictByType(eonlinerestype);
        if (obj == null)
        {
            obj = new HashMap(5);
        }
        ((Map) (obj)).put(getChildTypeUpdateKey(eonlinerestype, s), Long.valueOf(l));
        setUpdateDateDictByType(eonlinerestype, ((Map) (obj)));
        archiveUpdateTimes();
    }

    public void setUpdateDateDictByType(EOnlineResType eonlinerestype, Map map)
    {
        eonlinerestype = String.format("%s_UPDATEDATE", new Object[] {
            bgv.getStringByResType(eonlinerestype)
        });
        if (map != null)
        {
            typesUpdateDict.put(eonlinerestype, map);
        }
    }
}
