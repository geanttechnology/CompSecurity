// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CropImageActivity

class a extends m
{

    final CropImageActivity a;

    protected void a(int i)
    {
        a.l();
        if (i == 401 || i == 420)
        {
            CropImageActivity.a(a, 48258, null);
            return;
        } else
        {
            Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_upload_avatar_fail));
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.network.leResult leresult)
    {
        if (leresult == null || leresult.fileId == null)
        {
            b(0x80000001);
        } else
        {
            if (CropImageActivity.d(a) == 48135)
            {
                CropImageActivity.a(a, leresult.fileId, null);
                return;
            }
            if (CropImageActivity.d(a) == 48132)
            {
                CropImageActivity.a(a, null, leresult.fileId);
                return;
            }
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.leResult)obj);
    }

    lt(CropImageActivity cropimageactivity)
    {
        a = cropimageactivity;
        super();
    }
}
