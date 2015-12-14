// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Typeface;
import com.instabeauty.application.InstaBeautyApplication;

public class bew
{

    private static String a = "TFontTypeface";

    public static Typeface a(String s, int i)
    {
        Object obj;
        if (s.equalsIgnoreCase("PTSans-Narrow"))
        {
            obj = "PT_Sans-Narrow-Web-Regular";
        } else
        if (s.equalsIgnoreCase("PTSans-CaptionBold"))
        {
            obj = "PTC75F";
        } else
        if (s.equalsIgnoreCase("PTSans-Italic"))
        {
            obj = "PTS56F";
        } else
        if (s.equalsIgnoreCase("PTSans-NarrowBold"))
        {
            obj = "PT_Sans-Narrow-Web-Bold";
        } else
        {
            obj = s;
        }
        obj = beq.a().a(((String) (obj)));
        if (obj != null)
        {
            if (beq.a().b(((bev) (obj))))
            {
                Typeface typeface = beq.a().a(((bev) (obj)));
                obj = typeface;
                if (typeface == null)
                {
                    obj = Typeface.create(s, i);
                }
                return ((Typeface) (obj));
            } else
            {
                ber.a(InstaBeautyApplication.a).a(null);
                ber.a(InstaBeautyApplication.a).a(((bev) (obj)), false);
                return Typeface.create(s, i);
            }
        } else
        {
            return Typeface.create(s, i);
        }
    }

}
