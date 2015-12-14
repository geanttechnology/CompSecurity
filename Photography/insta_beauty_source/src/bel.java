// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.Comparator;

class bel
    implements Comparator
{

    final bei a;

    bel(bei bei)
    {
        a = bei;
        super();
    }

    public int compare(Object obj, Object obj1)
    {
        boolean flag = false;
        byte byte0 = flag;
        if (obj instanceof TPhotoComposeInfo)
        {
            byte0 = flag;
            if (obj1 instanceof TPhotoComposeInfo)
            {
                obj = (TPhotoComposeInfo)obj;
                obj1 = (TPhotoComposeInfo)obj1;
                if (((TPhotoComposeInfo) (obj)).useCount > ((TPhotoComposeInfo) (obj1)).useCount)
                {
                    byte0 = -1;
                } else
                {
                    byte0 = flag;
                    if (((TPhotoComposeInfo) (obj)).useCount != ((TPhotoComposeInfo) (obj1)).useCount)
                    {
                        return 1;
                    }
                }
            }
        }
        return byte0;
    }
}
