// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;


// Referenced classes of package com.amazon.gallery.framework.data.store:
//            NoOpRewindHelper

public class RewindHelper extends NoOpRewindHelper
{

    private static RewindHelper instance;

    private RewindHelper()
    {
    }

    public static RewindHelper getInstance()
    {
        if (instance == null)
        {
            instance = new RewindHelper();
        }
        return instance;
    }
}
