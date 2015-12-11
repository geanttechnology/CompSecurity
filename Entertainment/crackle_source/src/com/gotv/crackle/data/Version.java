// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;


public class Version
    implements Comparable
{

    private String version;

    public Version(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Version can not be null");
        }
        if (!s.matches("[0-9]+(\\.[0-9]+)*"))
        {
            throw new IllegalArgumentException("Invalid version format");
        } else
        {
            version = s;
            return;
        }
    }

    public int compareTo(Version version1)
    {
        boolean flag = false;
        if (version1 != null) goto _L2; else goto _L1
_L1:
        int j = 1;
_L4:
        return j;
_L2:
        String as[] = get().split("\\.");
        version1 = version1.get().split("\\.");
        int l = Math.max(as.length, version1.length);
        int i = 0;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= l)
            {
                continue;
            }
            int k;
            if (i < as.length)
            {
                j = Integer.parseInt(as[i]);
            } else
            {
                j = 0;
            }
            if (i < version1.length)
            {
                k = Integer.parseInt(version1[i]);
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
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Version)obj);
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
            if (compareTo((Version)obj) != 0)
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
}
