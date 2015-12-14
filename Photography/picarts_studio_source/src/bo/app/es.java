// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import com.appboy.AppboyUser;
import com.appboy.Constants;
import com.appboy.IAppboy;
import com.appboy.enums.Gender;
import com.appboy.enums.Month;
import com.appboy.enums.SocialNetwork;
import com.google.android.gms.wearable.DataMap;
import java.math.BigDecimal;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package bo.app:
//            an, dc, et

public class es
{

    private static final String a;

    public es()
    {
    }

    public static dc a(DataMap datamap)
    {
        dc dc1 = null;
        if (b(datamap) == an.y)
        {
            try
            {
                dc1 = bo.app.dc.a(new JSONObject(datamap.getString("v0")));
            }
            // Misplaced declaration of an exception variable
            catch (DataMap datamap)
            {
                myobfuscated.i.a.c(a, "Wear device couldn't be recreated.", datamap);
                return null;
            }
        }
        return dc1;
    }

    private static myobfuscated.h.a a(String s)
    {
        myobfuscated.h.a a1;
        try
        {
            a1 = new myobfuscated.h.a(new JSONObject(s));
        }
        catch (JSONException jsonexception)
        {
            myobfuscated.i.a.c(a, (new StringBuilder("Failed to create properties object from string: ")).append(s).toString(), jsonexception);
            return null;
        }
        return a1;
    }

    public static boolean a(DataMap datamap, IAppboy iappboy)
    {
        an an1 = b(datamap);
        boolean flag = datamap.getBoolean("h");
        Object obj;
        if (flag)
        {
            obj = a(datamap.getString("p"));
        } else
        {
            obj = null;
        }
        switch (bo.app.et.a[an1.ordinal()])
        {
        default:
            myobfuscated.i.a.a(a, (new StringBuilder("No current implementation for action in DataMap: ")).append(datamap.toString()).toString());
            return false;

        case 1: // '\001'
            datamap = datamap.getString("v0");
            if (flag && obj != null)
            {
                return iappboy.logCustomEvent(datamap, ((myobfuscated.h.a) (obj)));
            } else
            {
                return iappboy.logCustomEvent(datamap);
            }

        case 2: // '\002'
            String s = datamap.getString("v0");
            String s1 = datamap.getString("v1");
            datamap = new BigDecimal(datamap.getString("v2"));
            if (flag && obj != null)
            {
                return iappboy.logPurchase(s, s1, datamap, ((myobfuscated.h.a) (obj)));
            } else
            {
                return iappboy.logPurchase(s, s1, datamap);
            }

        case 3: // '\003'
            return iappboy.logShare(SocialNetwork.valueOf(datamap.getString("v0")));

        case 4: // '\004'
            return iappboy.logPushNotificationOpened(datamap.getString("v0"));

        case 5: // '\005'
            return iappboy.submitFeedback(datamap.getString("v0"), datamap.getString("v1"), datamap.getBoolean("v2"));

        case 6: // '\006'
            obj = datamap.getString("k");
            datamap = datamap.getString("v0");
            return iappboy.getCurrentUser().addToCustomAttributeArray(((String) (obj)), datamap);

        case 7: // '\007'
            obj = datamap.getString("k");
            int i = datamap.getInt("v0");
            return iappboy.getCurrentUser().incrementCustomUserAttribute(((String) (obj)), i);

        case 8: // '\b'
            obj = datamap.getString("k");
            datamap = datamap.getStringArray("v0");
            return iappboy.getCurrentUser().setCustomAttributeArray(((String) (obj)), datamap);

        case 9: // '\t'
            obj = datamap.getString("k");
            int j = datamap.getInt("v1");
            if (j == 1)
            {
                return iappboy.getCurrentUser().setCustomUserAttribute(((String) (obj)), datamap.getBoolean("v0"));
            }
            if (j == 3)
            {
                return iappboy.getCurrentUser().setCustomUserAttribute(((String) (obj)), datamap.getFloat("v0"));
            }
            if (j == 4)
            {
                return iappboy.getCurrentUser().setCustomUserAttribute(((String) (obj)), datamap.getInt("v0"));
            }
            if (j == 5)
            {
                return iappboy.getCurrentUser().setCustomUserAttribute(((String) (obj)), datamap.getLong("v0"));
            }
            double d;
            double d1;
            int k;
            long l;
            if (j == 2)
            {
                return iappboy.getCurrentUser().setCustomUserAttribute(((String) (obj)), datamap.getString("v0"));
            } else
            {
                return false;
            }

        case 10: // '\n'
            datamap = datamap.getString("k");
            return iappboy.getCurrentUser().setCustomUserAttributeToNow(datamap);

        case 11: // '\013'
            datamap = datamap.getString("k");
            return iappboy.getCurrentUser().unsetCustomUserAttribute(datamap);

        case 12: // '\f'
            obj = datamap.getString("k");
            l = datamap.getLong("v0");
            return iappboy.getCurrentUser().setCustomUserAttributeToSecondsFromEpoch(((String) (obj)), l);

        case 13: // '\r'
            d = datamap.getDouble("v0");
            d1 = datamap.getDouble("v1");
            if (datamap.containsKey("v2"))
            {
                obj = Double.valueOf(datamap.getDouble("v2"));
            } else
            {
                obj = null;
            }
            if (datamap.containsKey("v3"))
            {
                datamap = Double.valueOf(datamap.getDouble("v3"));
            } else
            {
                datamap = null;
            }
            iappboy.getCurrentUser().setLastKnownLocation(d, d1, datamap, ((Double) (obj)));
            return true;

        case 14: // '\016'
            return iappboy.getCurrentUser().setAvatarImageUrl(datamap.getString("v0"));

        case 15: // '\017'
            return iappboy.getCurrentUser().setBio(datamap.getString("v0"));

        case 16: // '\020'
            return iappboy.getCurrentUser().setCountry(datamap.getString("v0"));

        case 17: // '\021'
            return iappboy.getCurrentUser().setEmail(datamap.getString("v0"));

        case 18: // '\022'
            return iappboy.getCurrentUser().setFirstName(datamap.getString("v0"));

        case 19: // '\023'
            return iappboy.getCurrentUser().setHomeCity(datamap.getString("v0"));

        case 20: // '\024'
            return iappboy.getCurrentUser().setLastName(datamap.getString("v0"));

        case 21: // '\025'
            return iappboy.getCurrentUser().setPhoneNumber(datamap.getString("v0"));

        case 22: // '\026'
            datamap = Gender.valueOf(datamap.getString("v0"));
            return iappboy.getCurrentUser().setGender(datamap);

        case 23: // '\027'
            j = datamap.getInt("v0");
            obj = Month.valueOf(datamap.getString("v1"));
            k = datamap.getInt("v2");
            return iappboy.getCurrentUser().setDateOfBirth(j, ((Month) (obj)), k);

        case 24: // '\030'
            myobfuscated.i.a.a(a, (new StringBuilder("Got an unsupported wearable sdk action. DataMap: ")).append(datamap.toString()).toString());
            return false;
        }
    }

    public static an b(DataMap datamap)
    {
        return bo.app.an.a(datamap.getString("t"));
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/es.getName()
        });
    }
}
