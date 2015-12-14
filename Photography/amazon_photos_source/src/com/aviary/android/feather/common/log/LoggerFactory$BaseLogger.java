// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.log;


// Referenced classes of package com.aviary.android.feather.common.log:
//            LoggerFactory

static abstract class tag
    implements tag
{

    String tag;

    protected transient StringBuilder formatArguments(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            stringbuilder.append((new StringBuilder()).append(obj).append(", ").toString());
        }

        return stringbuilder;
    }

    public (String s)
    {
        tag = s;
    }
}
