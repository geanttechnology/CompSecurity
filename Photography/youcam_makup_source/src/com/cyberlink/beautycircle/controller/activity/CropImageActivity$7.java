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

    protected void a()
    {
        a.l();
        Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_update_user_info));
    }

    protected void a(int i)
    {
        a.l();
        if (i == 401 || i == 420)
        {
            CropImageActivity.a(a, 48258, null);
            return;
        } else
        {
            Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_update_user_info));
            return;
        }
    }

    protected void a(com.cyberlink.beautycircle.model.esponse esponse)
    {
        try
        {
            CropImageActivity.a(a, esponse.userId);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.beautycircle.model.esponse esponse)
        {
            esponse.printStackTrace();
        }
        a.l();
        Globals.a(a.getResources().getString(com.cyberlink.beautycircle.m.bc_change_photo_update_user_info));
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.esponse)obj);
    }

    (CropImageActivity cropimageactivity)
    {
        a = cropimageactivity;
        super();
    }
}
