// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.manage.ManageMaterialFragement;
import com.wantu.model.res.TResInfo;

public class bhr
    implements android.content.DialogInterface.OnClickListener
{

    final Object a;
    final ManageMaterialFragement b;

    public bhr(ManageMaterialFragement managematerialfragement, Object obj)
    {
        b = managematerialfragement;
        a = obj;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (TResInfo)a;
        Log.v(ManageMaterialFragement.a(b), (new StringBuilder()).append(ManageMaterialFragement.a(b)).append("confirm delete :").append(((TResInfo) (dialoginterface)).resId).toString());
        b.a(dialoginterface);
        ManageMaterialFragement.b(b).a(dialoginterface, EOnlineResType.MAG_MASK_INFO);
    }
}
