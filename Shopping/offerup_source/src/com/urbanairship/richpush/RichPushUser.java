// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushManager

public class RichPushUser
{

    private static final String KEY_PREFIX = "com.urbanairship.user";
    private static final String USER_ID_KEY = "com.urbanairship.user.ID";
    private static final String USER_PASSWORD_KEY = "com.urbanairship.user.PASSWORD";
    private static final String USER_TOKEN_KEY = "com.urbanairship.user.USER_TOKEN";
    private final PreferenceDataStore preferences;

    RichPushUser(PreferenceDataStore preferencedatastore)
    {
        preferences = preferencedatastore;
        preferencedatastore = preferences.getString("com.urbanairship.user.PASSWORD", null);
        if (!UAStringUtil.isEmpty(preferencedatastore))
        {
            preferencedatastore = encode(preferencedatastore, preferences.getString("com.urbanairship.user.ID", null));
            if (preferences.putSync("com.urbanairship.user.USER_TOKEN", preferencedatastore))
            {
                preferences.remove("com.urbanairship.user.PASSWORD");
            }
        }
    }

    private static String decode(String s, String s1)
    {
        if (!UAStringUtil.isEmpty(s) && !UAStringUtil.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        int j;
        return null;
_L2:
        if ((j = s.length()) % 2 != 0) goto _L1; else goto _L3
_L3:
        byte abyte0[];
        int i;
        try
        {
            abyte0 = new byte[j / 2];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error((new StringBuilder("RichPushUser - Unable to decode string. ")).append(s.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error((new StringBuilder("RichPushUser - String contains invalid hex numbers. ")).append(s.getMessage()).toString());
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        abyte0[i / 2] = Byte.parseByte(s.substring(i, i + 2), 16);
        i += 2;
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_38;
_L4:
        s = new String(xor(abyte0, s1.getBytes()), "UTF-8");
        return s;
    }

    private static String encode(String s, String s1)
    {
        if (UAStringUtil.isEmpty(s) || UAStringUtil.isEmpty(s1))
        {
            return null;
        }
        s = xor(s.getBytes(), s1.getBytes());
        s1 = new StringBuilder();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            s1.append(String.format("%02x", new Object[] {
                Byte.valueOf(s[i])
            }));
        }

        return s1.toString();
    }

    public static boolean isCreated()
    {
        Object obj = UAirship.shared();
        String s = ((UAirship) (obj)).getRichPushManager().getRichPushUser().getId();
        obj = ((UAirship) (obj)).getRichPushManager().getRichPushUser().getPassword();
        return !UAStringUtil.isEmpty(s) && !UAStringUtil.isEmpty(((String) (obj)));
    }

    private static byte[] xor(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte2[i] = (byte)(abyte0[i] ^ abyte1[i % abyte1.length]);
        }

        return abyte2;
    }

    public String getId()
    {
        String s = null;
        if (preferences.getString("com.urbanairship.user.USER_TOKEN", null) != null)
        {
            s = preferences.getString("com.urbanairship.user.ID", null);
        }
        return s;
    }

    public String getPassword()
    {
        String s = null;
        if (preferences.getString("com.urbanairship.user.ID", null) != null)
        {
            s = decode(preferences.getString("com.urbanairship.user.USER_TOKEN", null), getId());
        }
        return s;
    }

    void setUser(String s, String s1)
    {
        Logger.debug((new StringBuilder("RichPushUser - Setting Rich Push user: ")).append(s).toString());
        preferences.put("com.urbanairship.user.ID", s);
        preferences.put("com.urbanairship.user.USER_TOKEN", encode(s1, s));
    }
}
