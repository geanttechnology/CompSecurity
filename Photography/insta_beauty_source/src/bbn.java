// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.compose.NetMaterialFragement;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;

public class bbn
    implements android.view.View.OnClickListener
{

    final NetMaterialFragement a;

    public bbn(NetMaterialFragement netmaterialfragement)
    {
        a = netmaterialfragement;
        super();
    }

    public void onClick(View view)
    {
        a.a(InstaMagType.RECT_LIB_SIZE_TYPE);
        a.b(InstaMagType.RECT_LIB_SIZE_TYPE);
    }
}
