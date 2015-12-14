// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.List;

public class bbs
{

    public static int a()
    {
        return (int)(float)InstaBeautyApplication.a.getResources().getDisplayMetrics().widthPixels / 16;
    }

    public static int a(Context context)
    {
        return (int)((float)context.getResources().getDisplayMetrics().widthPixels - (float)(a() * 4)) / 3;
    }

    public static int a(InstaMagType instamagtype)
    {
        int j = a(InstaBeautyApplication.a);
        int i;
        if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            i = (int)(((float)j * 214F) / 320F);
        } else
        {
            i = j;
            if (instamagtype != InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
                {
                    return (int)(((float)j * 3F) / 2.0F);
                }
                i = j;
                if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
                {
                    return (int)(((float)j * 3F) / 2.0F);
                }
            }
        }
        return i;
    }

    public static int a(List list)
    {
        InstaMagType instamagtype = InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
        if (list == null || list.size() == 0)
        {
            return 0;
        }
        float f = 0.0F;
        for (int i = 0; i < list.size();)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)list.get(i);
            float f1 = f;
            if (tphotocomposeinfo.height > f)
            {
                f1 = tphotocomposeinfo.height;
                instamagtype = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
            }
            i++;
            f = f1;
        }

        return a(instamagtype);
    }

    public static String b(InstaMagType instamagtype)
    {
        switch (bbt.a[instamagtype.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            if (yp.b())
            {
                return "\u7AD6\u7248";
            }
            if (yp.c())
            {
                return "\u8C4E\u7248";
            } else
            {
                return "Portrait";
            }

        case 2: // '\002'
            if (yp.b())
            {
                return "\u6B63\u65B9\u5F62";
            }
            if (yp.c())
            {
                return "\u6B63\u65B9\u5F62";
            } else
            {
                return "Squart";
            }

        case 3: // '\003'
            if (yp.b())
            {
                return "\u6A2A\u7248";
            }
            if (yp.c())
            {
                return "\u6A6B\u7248";
            } else
            {
                return "Landscape";
            }

        case 4: // '\004'
            break;
        }
        if (yp.b())
        {
            return "\u62FC\u63A5";
        }
        if (yp.c())
        {
            return "\u62FC\u63A5";
        } else
        {
            return "Strips";
        }
    }
}
