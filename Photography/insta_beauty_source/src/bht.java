// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.wantu.ResourceOnlineLibrary.compose.manage.ManageMaterialFragement;
import com.wantu.model.res.TResInfo;

public class bht extends zs
{

    final ManageMaterialFragement f;

    public bht(ManageMaterialFragement managematerialfragement, Context context, int i)
    {
        f = managematerialfragement;
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        Object obj1;
        if (!(obj instanceof TResInfo))
        {
            break MISSING_BLOCK_LABEL_24;
        }
        obj1 = (TResInfo)obj;
        obj1 = ((TResInfo) (obj1)).getIconBitmap();
        return ((Bitmap) (obj1));
        Exception exception;
        exception;
        exception.printStackTrace();
        return super.a(String.valueOf(obj));
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
