// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            DraftViewPager

static final class emInfo
    implements Comparator
{

    public int compare(emInfo eminfo, emInfo eminfo1)
    {
        return eminfo.position - eminfo1.position;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((emInfo)obj, (emInfo)obj1);
    }

    emInfo()
    {
    }
}
