// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;

public class ts
{

    public static tu a(EOnlineResType eonlinerestype)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[EOnlineResType.values().length];
                try
                {
                    a[EOnlineResType.MAG_MASK_INFO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return kf.c().e();
        }
    }
}
