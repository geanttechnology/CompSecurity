// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.video;


public class VideoKey
{

    public final String url;

    public VideoKey(String s)
    {
        url = s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            if (url != null)
            {
                return url.equals(((VideoKey)obj).url);
            }
            if (((VideoKey)obj).url != null)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (url != null)
        {
            return url.hashCode() * 31;
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        return url;
    }
}
