// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.instamag.activity.compose.NetMaterialFragement;
import com.wantu.model.res.TResInfo;

public class bbq extends zs
{

    final NetMaterialFragement f;

    public bbq(NetMaterialFragement netmaterialfragement, Context context, int i)
    {
        f = netmaterialfragement;
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        if (obj instanceof TResInfo)
        {
            return super.a(String.valueOf(((TResInfo)obj).icon));
        } else
        {
            return super.a(String.valueOf(obj));
        }
    }

    protected String b(Object obj)
    {
        if (obj instanceof TResInfo)
        {
            obj = (TResInfo)obj;
            if (((TResInfo) (obj)).icon != null)
            {
                return ((TResInfo) (obj)).getIcon();
            } else
            {
                return "";
            }
        } else
        {
            return String.valueOf(obj);
        }
    }
}
