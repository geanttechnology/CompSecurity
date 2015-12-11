// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.tapjoy:
//            TapjoyCachedAssetData, TapjoyUtil

public class TapjoyCacheMap extends ConcurrentHashMap
{

    private Context a;
    private int b;

    public TapjoyCacheMap(Context context, int i)
    {
        b = -1;
        a = context;
        b = i;
    }

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public TapjoyCachedAssetData put(String s, TapjoyCachedAssetData tapjoycachedassetdata)
    {
        while (tapjoycachedassetdata == null || tapjoycachedassetdata.getTimeOfDeathInSeconds() <= System.currentTimeMillis() / 1000L) 
        {
            return null;
        }
        if (size() == b)
        {
            long l = -1L;
            String s1 = "";
            Iterator iterator = entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                long l1 = ((TapjoyCachedAssetData)entry.getValue()).getTimestampInSeconds();
                if (l == 0L || l1 < l)
                {
                    s1 = (String)entry.getKey();
                    l = l1;
                }
            } while (true);
            remove(s1);
        }
        android.content.SharedPreferences.Editor editor = a.getSharedPreferences("tapjoyCacheData", 0).edit();
        editor.putString(tapjoycachedassetdata.getLocalFilePath(), tapjoycachedassetdata.toRawJSONString());
        editor.commit();
        return (TapjoyCachedAssetData)super.put(s, tapjoycachedassetdata);
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, (TapjoyCachedAssetData)obj1);
    }

    public TapjoyCachedAssetData remove(Object obj)
    {
        if (containsKey(obj))
        {
            Object obj1 = a.getSharedPreferences("tapjoyCacheData", 0).edit();
            ((android.content.SharedPreferences.Editor) (obj1)).remove(((TapjoyCachedAssetData)get(obj)).getLocalFilePath());
            ((android.content.SharedPreferences.Editor) (obj1)).commit();
            obj1 = ((TapjoyCachedAssetData)get(obj)).getLocalFilePath();
            if (obj1 != null && ((String) (obj1)).length() > 0)
            {
                TapjoyUtil.deleteFileOrDirectory(new File(((String) (obj1))));
            }
            return (TapjoyCachedAssetData)super.remove(obj);
        } else
        {
            return null;
        }
    }

    public volatile Object remove(Object obj)
    {
        return remove(obj);
    }

    public TapjoyCachedAssetData replace(String s, TapjoyCachedAssetData tapjoycachedassetdata)
    {
        throw new UnsupportedOperationException();
    }

    public volatile Object replace(Object obj, Object obj1)
    {
        return replace((String)obj, (TapjoyCachedAssetData)obj1);
    }

    public volatile boolean replace(Object obj, Object obj1, Object obj2)
    {
        return replace((String)obj, (TapjoyCachedAssetData)obj1, (TapjoyCachedAssetData)obj2);
    }

    public boolean replace(String s, TapjoyCachedAssetData tapjoycachedassetdata, TapjoyCachedAssetData tapjoycachedassetdata1)
    {
        throw new UnsupportedOperationException();
    }
}
