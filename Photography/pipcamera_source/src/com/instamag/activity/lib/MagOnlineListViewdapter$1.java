// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.Comparator;

// Referenced classes of package com.instamag.activity.lib:
//            MagOnlineListViewdapter

class a
    implements Comparator
{

    final MagOnlineListViewdapter a;

    public int compare(Object obj, Object obj1)
    {
        boolean flag;
        boolean flag1;
        if (!(obj instanceof TPhotoComposeInfo) || !(obj1 instanceof TPhotoComposeInfo))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = (TPhotoComposeInfo)obj;
        obj1 = (TPhotoComposeInfo)obj1;
        flag = MagOnlineListViewdapter.access$000(a).isExistedByResId(((TPhotoComposeInfo) (obj)).resId);
        flag1 = MagOnlineListViewdapter.access$000(a).isExistedByResId(((TPhotoComposeInfo) (obj1)).resId);
        if ((!flag || !flag1) && (flag || flag1)) goto _L2; else goto _L1
_L1:
        if (((TPhotoComposeInfo) (obj)).height <= ((TPhotoComposeInfo) (obj1)).height) goto _L4; else goto _L3
_L3:
        return -1;
_L4:
        return ((TPhotoComposeInfo) (obj)).height >= ((TPhotoComposeInfo) (obj1)).height ? 0 : 1;
_L2:
        if (!flag) goto _L3; else goto _L5
_L5:
        return 1;
        return 0;
    }

    poseManager(MagOnlineListViewdapter magonlinelistviewdapter)
    {
        a = magonlinelistviewdapter;
        super();
    }
}
