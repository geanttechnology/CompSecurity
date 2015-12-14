// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import java.util.Comparator;
import org.apache.http.NameValuePair;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

static final class 
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((NameValuePair)obj, (NameValuePair)obj1);
    }

    public int compare(NameValuePair namevaluepair, NameValuePair namevaluepair1)
    {
        return namevaluepair.getName().compareTo(namevaluepair1.getName());
    }

    ()
    {
    }
}
