// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.common.utils.helpers;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.openx.core.sdk.OXMManagersResolver;
import com.openx.sdk.event.OXMEvent;
import com.openx.sdk.event.OXMEventsListener;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package com.openx.common.utils.helpers:
//            CSVFileReader

public final class Utils
{

    public static float DENSITY;
    private static Hashtable mLogMessages;
    private static Hashtable mMraidErrMessages;
    private static final String mRecognizedPrefixes[] = {
        "tel:", "voicemail:", "sms:", "mailto:", "geo:", "google.streetview:", "market:"
    };
    private static Hashtable mStrings;
    private static int mSysVersion = -1;
    private static final String mVideoContent[] = {
        "3gp", "mp4", "ts", "webm", "mkv"
    };

    public Utils()
    {
    }

    public static boolean atLeastFroyo()
    {
        return osAtLeast(8);
    }

    public static boolean atLeastGingerbread()
    {
        return osAtLeast(9);
    }

    public static boolean atLeastHoneycomb()
    {
        return osAtLeast(11);
    }

    public static boolean atLeastICS()
    {
        return osAtLeast(14);
    }

    public static boolean atLeastJellyBean()
    {
        return osAtLeast(16);
    }

    public static boolean atLeastKitKat()
    {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    public static boolean atMostJB()
    {
        return android.os.Build.VERSION.SDK_INT <= 18;
    }

    public static boolean avoidJSC_MOB273()
    {
        return "generic".equals(Build.BRAND) && (android.os.Build.VERSION.SDK_INT == 10 || android.os.Build.VERSION.SDK_INT == 9);
    }

    public static String byteArrayToHexString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            if (j < 16)
            {
                stringbuffer.append('0');
            }
            stringbuffer.append(Integer.toHexString(j));
        }

        return stringbuffer.toString().toLowerCase();
    }

    public static String generateSHA1(String s)
    {
        try
        {
            s = byteArrayToHexString(generateSHA1(s.getBytes()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getStackTrace();
            return null;
        }
        return s;
    }

    public static byte[] generateSHA1(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.reset();
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.getStackTrace();
            return null;
        }
        return abyte0;
    }

    public static BitmapDrawable getDrawable(Resources resources, String s)
    {
        s = String.format("%1$s/%2$s", new Object[] {
            resourcesPathForDensity(stringFromDensity(DENSITY)), s
        });
        s = com/openx/common/utils/helpers/Utils.getClassLoader().getResourceAsStream(s);
        if (s != null)
        {
            return new BitmapDrawable(resources, BitmapFactory.decodeStream(s));
        } else
        {
            return null;
        }
    }

    public static String getLogMessage(String s)
    {
        Hashtable hashtable = getLogMessagesMap();
        if (hashtable != null && hashtable.containsKey(s))
        {
            return (String)hashtable.get(s);
        } else
        {
            return "";
        }
    }

    private static Hashtable getLogMessagesMap()
    {
        if (mLogMessages == null)
        {
            mLogMessages = (new CSVFileReader(com/openx/common/utils/helpers/Utils.getClassLoader().getResourceAsStream(String.format("%1$s/%2$s", new Object[] {
                "com/openx/ad/mobile/sdk/resources/raw", "log_messages.csv"
            })), ";")).read();
        }
        return mLogMessages;
    }

    public static String getMRAIDErrMessage(String s)
    {
        Hashtable hashtable = getMraidErrMessagesMap();
        if (hashtable != null && hashtable.containsKey(s))
        {
            return (String)hashtable.get(s);
        } else
        {
            return "";
        }
    }

    private static Hashtable getMraidErrMessagesMap()
    {
        if (mMraidErrMessages == null)
        {
            mMraidErrMessages = (new CSVFileReader(com/openx/common/utils/helpers/Utils.getClassLoader().getResourceAsStream(String.format("%1$s/%2$s", new Object[] {
                "com/openx/ad/mobile/sdk/resources/raw", "mraid_error_messages.csv"
            })), ";")).read();
        }
        return mMraidErrMessages;
    }

    public static String getSdkVersion()
        throws Exception
    {
label0:
        {
            Object obj;
label1:
            {
                obj = com/openx/common/utils/helpers/Utils.getClassLoader().getResourceAsStream(String.format("%1$s/%2$s.xml", new Object[] {
                    "com/openx/ad/mobile/sdk/resources/raw", "assembly"
                }));
                obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(((InputStream) (obj))).getDocumentElement();
                if (obj == null)
                {
                    break label0;
                }
                String s = ((Element) (obj)).getAttributes().getNamedItem("android:versionName").getNodeValue();
                if (s != null)
                {
                    obj = s;
                    if (!s.equals(""))
                    {
                        break label1;
                    }
                }
                obj = null;
            }
            return ((String) (obj));
        }
        return null;
    }

    public static String getString(String s)
    {
        Hashtable hashtable = getStringsMap();
        if (hashtable != null && hashtable.containsKey(s))
        {
            return (String)hashtable.get(s);
        } else
        {
            return "";
        }
    }

    private static Hashtable getStringsMap()
    {
        if (mStrings == null)
        {
            mStrings = (new CSVFileReader(com/openx/common/utils/helpers/Utils.getClassLoader().getResourceAsStream(String.format("%1$s/%2$s", new Object[] {
                "com/openx/ad/mobile/sdk/resources/raw", "strings.csv"
            })), ";")).read();
        }
        return mStrings;
    }

    public static boolean isExternalStorageAvailable()
    {
        String s = Environment.getExternalStorageState();
        boolean flag;
        boolean flag1;
        if ("mounted".equals(s))
        {
            flag1 = true;
            flag = true;
        } else
        if ("mounted_ro".equals(s))
        {
            flag = true;
            flag1 = false;
        } else
        {
            flag1 = false;
            flag = false;
        }
        return flag && flag1;
    }

    public static boolean isRecognizedUrl(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            for (int i = 0; i < mRecognizedPrefixes.length; i++)
            {
                if (s.startsWith(mRecognizedPrefixes[i]))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isVideoContent(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            s = MimeTypeMap.getSingleton().getExtensionFromMimeType(s);
            if (!TextUtils.isEmpty(s))
            {
                for (int i = 0; i < mVideoContent.length; i++)
                {
                    if (s.equalsIgnoreCase(mVideoContent[i]))
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static String loadStringFromFile(Resources resources, int i)
    {
        String s;
        try
        {
            resources = resources.openRawResource(i);
            byte abyte0[] = new byte[resources.available()];
            resources.read(abyte0);
            s = new String(abyte0);
            resources.close();
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            return "EMPTY";
        }
        return s;
    }

    public static void log(Object obj, Object obj1)
    {
        OXMEventsListener oxmeventslistener = OXMManagersResolver.getInstance().getEventsManager();
        if (oxmeventslistener != null)
        {
            oxmeventslistener.fireEvent(new OXMEvent(com.openx.sdk.event.OXMEvent.OXMEventType.LOG, obj, obj1));
        }
    }

    public static String md5(String s)
    {
        Object obj;
        int i;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuffer) (obj)).append(String.format("%02x", new Object[] {
            Byte.valueOf(s[i])
        }));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_30;
_L1:
        s = ((StringBuffer) (obj)).toString();
        return s;
    }

    private static boolean osAtLeast(int i)
    {
        boolean flag = false;
        if (mSysVersion == -1)
        {
            try
            {
                mSysVersion = android/os/Build$VERSION.getDeclaredField("SDK_INT").getInt(null);
            }
            catch (Exception exception)
            {
                mSysVersion = 0;
            }
        }
        if (mSysVersion >= i)
        {
            flag = true;
        }
        return flag;
    }

    private static String resourcesPathForDensity(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "mdpi";
        }
        return String.format("%1$s/%2$s", new Object[] {
            "com/openx/ad/mobile/sdk/resources/drawable", s1
        });
    }

    private static String stringFromDensity(float f)
    {
        if ((double)f == 1.5D)
        {
            return "hdpi";
        }
        if ((double)f >= 2D)
        {
            return "xhdpi";
        } else
        {
            return "mdpi";
        }
    }

}
