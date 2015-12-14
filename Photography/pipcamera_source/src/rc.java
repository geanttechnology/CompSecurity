// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;

public class rc
{

    private static String a = "TFontTypeface";

    public static Typeface a(String s, int i)
    {
        Object obj = null;
        if (!s.equalsIgnoreCase("PTSans-Narrow")) goto _L2; else goto _L1
_L1:
        s = Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), "PT_Sans-Narrow-Web-Regular.ttf");
_L4:
        return s;
_L2:
        if (!s.equalsIgnoreCase("PTSans-CaptionBold"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = obj;
        if (i == 1)
        {
            return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), "PTC75F.ttf");
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s.equalsIgnoreCase("PTSans-Italic"))
        {
            s = obj;
            if (i == 2)
            {
                return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), "PTS56F.ttf");
            }
        } else
        {
            if (s.equalsIgnoreCase("PTSans-NarrowBold"))
            {
                return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), "PT_Sans-Narrow-Web-Bold.ttf");
            }
            if (!s.endsWith("ttf") && !s.endsWith("otf") && !s.endsWith("TTF") && !s.endsWith("OTF"))
            {
                String s1 = String.format("%s.%s", new Object[] {
                    s, "ttf"
                });
                String s2 = String.format("%s.%s", new Object[] {
                    s, "TTF"
                });
                String s3 = String.format("%s.%s", new Object[] {
                    s, "otf"
                });
                String s4 = String.format("%s.%s", new Object[] {
                    s, "OTF"
                });
                Log.v(a, (new StringBuilder()).append(a).append("fontFamily:").append(s).toString());
                if (a(s1))
                {
                    Log.v(a, (new StringBuilder()).append(a).append("fontName1 fontFamily:").append(s1).append(" is Exist!!").toString());
                    return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), s1);
                }
                if (a(s2))
                {
                    Log.v(a, (new StringBuilder()).append(a).append("fontName2 fontFamily:").append(s2).append(" is Exist!!").toString());
                    return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), s2);
                }
                if (a(s3))
                {
                    Log.v(a, (new StringBuilder()).append(a).append("fontName3 fontFamily:").append(s3).append(" is Exist!!").toString());
                    return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), s3);
                }
                if (a(s4))
                {
                    Log.v(a, (new StringBuilder()).append(a).append("fontName4 fontFamily:").append(s4).append(" is Exist!!").toString());
                    return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), s4);
                } else
                {
                    return Typeface.create(s, i);
                }
            }
            if (a(s))
            {
                return Typeface.createFromAsset(PIPCameraApplication.a.getAssets(), s);
            } else
            {
                return Typeface.create(s, i);
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static boolean a(String s)
    {
        AssetManager assetmanager = PIPCameraApplication.a.getResources().getAssets();
        try
        {
            assetmanager.open(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return false;
        }
        return true;
    }

}
