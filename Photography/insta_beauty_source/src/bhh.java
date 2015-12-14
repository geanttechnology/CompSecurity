// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.Comparator;

public class bhh
    implements Comparator
{

    final TPhotoMagComposeManager a;

    public bhh(TPhotoMagComposeManager tphotomagcomposemanager)
    {
        a = tphotomagcomposemanager;
        super();
    }

    public int a(Integer integer, Integer integer1)
    {
        int i = integer.intValue();
        int j = integer1.intValue();
        if (j > i)
        {
            return -1;
        }
        return j >= i ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((Integer)obj, (Integer)obj1);
    }
}
