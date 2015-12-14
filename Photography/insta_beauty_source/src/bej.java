// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.Comparator;

class bej
    implements Comparator
{

    final bei a;

    bej(bei bei)
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
                if (((TPhotoComposeInfo) (obj)).isShouldFirst() && !((TPhotoComposeInfo) (obj1)).isShouldFirst())
                {
                    byte0 = -1;
                } else
                {
                    byte0 = flag;
                    if (!((TPhotoComposeInfo) (obj)).isShouldFirst())
                    {
                        byte0 = flag;
                        if (((TPhotoComposeInfo) (obj1)).isShouldFirst())
                        {
                            return 1;
                        }
                    }
                }
            }
        }
        return byte0;
    }
}
