// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.compose.MagComposeActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.Comparator;

public class azt
    implements Comparator
{

    final MagComposeActivity a;

    public azt(MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }

    public int a(TPhotoComposeInfo tphotocomposeinfo, TPhotoComposeInfo tphotocomposeinfo1)
    {
        if (tphotocomposeinfo.height > tphotocomposeinfo1.height)
        {
            return -1;
        }
        return tphotocomposeinfo.height >= tphotocomposeinfo1.height ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((TPhotoComposeInfo)obj, (TPhotoComposeInfo)obj1);
    }
}
