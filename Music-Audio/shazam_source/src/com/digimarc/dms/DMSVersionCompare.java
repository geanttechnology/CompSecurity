// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import android.util.Log;

public class DMSVersionCompare
    implements Comparable
{

    private static final String TAG = com/digimarc/dms/DMSVersionCompare.getName();
    private String version;

    public DMSVersionCompare(String s)
    {
        if (s == null)
        {
            try
            {
                throw new IllegalArgumentException("Version can not be null");
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.e(TAG, (new StringBuilder("Invalid version string: ")).append(s).toString());
            }
            version = null;
            return;
        }
        if (!s.matches("[0-9]+(\\.[0-9]+)*"))
        {
            throw new IllegalArgumentException("Invalid version format");
        }
        version = s;
        return;
    }

    public int compareTo(DMSVersionCompare dmsversioncompare)
    {
        boolean flag1 = isEmpty();
        boolean flag;
        if (dmsversioncompare == null || dmsversioncompare.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag1 || !flag)
        {
            if (version == null && !flag)
            {
                return -1;
            }
            if (!flag1 && flag)
            {
                return 1;
            }
            String as[] = get().split("\\.");
            dmsversioncompare = dmsversioncompare.get().split("\\.");
            int l = Math.max(as.length, dmsversioncompare.length);
            int i = 0;
            while (i < l) 
            {
                int j;
                int k;
                if (i < as.length)
                {
                    j = Integer.parseInt(as[i]);
                } else
                {
                    j = 0;
                }
                if (i < dmsversioncompare.length)
                {
                    k = Integer.parseInt(dmsversioncompare[i]);
                } else
                {
                    k = 0;
                }
                if (j < k)
                {
                    return -1;
                }
                if (j > k)
                {
                    return 1;
                }
                i++;
            }
        }
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((DMSVersionCompare)obj);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            if (compareTo((DMSVersionCompare)obj) != 0)
            {
                return false;
            }
        }
        return true;
    }

    public final String get()
    {
        return version;
    }

    public boolean isEmpty()
    {
        return version == null || version.isEmpty();
    }

}
