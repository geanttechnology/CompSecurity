// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            VASTParser

public static class url
{

     event;
    public String url;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof url))
            {
                return false;
            }
            obj = (url)obj;
            if (event != ((event) (obj)).event)
            {
                return false;
            }
            if (!url.equals(((url) (obj)).url))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return url.hashCode() * 31 + event.hashCode();
    }

    ( , String s)
    {
        event = ;
        url = s;
    }
}
