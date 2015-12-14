// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.geocoderlib.enums.GeocodingLanguage;
import java.util.Locale;

public class js
{

    public static GeocodingLanguage a()
    {
        String s3;
        String s4;
        int i;
        i = 0;
        Locale locale = Locale.getDefault();
        s3 = locale.getLanguage();
        s4 = locale.getCountry();
_L5:
        if (i >= GeocodingLanguage.values().length) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1;
        String s2;
        GeocodingLanguage geocodinglanguage;
        geocodinglanguage = GeocodingLanguage.values()[i];
        s2 = geocodinglanguage.toString();
        obj = "";
        s1 = "";
        if (s2.length() <= 4) goto _L4; else goto _L3
_L3:
        String s = ((String) (obj));
        Log.v("GeocodingLanguageFactory", (new StringBuilder()).append("GeocodingLanguageFactory").append(" sLanguage: ").append(s2).toString());
        s = ((String) (obj));
        obj = s2.substring(0, 2);
        s = ((String) (obj));
        s2 = s2.substring(3, 5);
        s1 = s2;
        s = ((String) (obj));
        obj = s1;
        break MISSING_BLOCK_LABEL_112;
_L4:
        s = s2;
        obj = s1;
_L6:
        if (((String) (obj)).length() > 0)
        {
            if (s.equalsIgnoreCase(s3) && ((String) (obj)).equalsIgnoreCase(s4))
            {
                return geocodinglanguage;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (s.equalsIgnoreCase(s3))
        {
            return geocodinglanguage;
        }
        i++;
          goto _L5
_L2:
        return GeocodingLanguage.EN;
        Exception exception;
        exception;
        exception = s1;
          goto _L6
    }
}
