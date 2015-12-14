// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.Comparator;

public class bhj
    implements Comparator
{

    final TPhotoMagComposeManager a;

    public bhj(TPhotoMagComposeManager tphotomagcomposemanager)
    {
        a = tphotomagcomposemanager;
        super();
    }

    public int compare(Object obj, Object obj1)
    {
        boolean flag = false;
        byte byte0 = flag;
        if (obj instanceof bde)
        {
            byte0 = flag;
            if (obj1 instanceof bde)
            {
                obj = (bde)obj;
                obj1 = (bde)obj1;
                if (((bde) (obj)).b > ((bde) (obj1)).b)
                {
                    byte0 = -1;
                } else
                {
                    byte0 = flag;
                    if (((bde) (obj)).b < ((bde) (obj1)).b)
                    {
                        return 1;
                    }
                }
            }
        }
        return byte0;
    }
}
