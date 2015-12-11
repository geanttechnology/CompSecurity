// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.parse.ParseUser;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi, aho, ahp, aqo

public class hn
    implements gi
{

    public hn()
    {
    }

    public void a()
    {
        aho.a().e();
    }

    public void a(Activity activity)
    {
        String s = activity.getString(0x7f0901d8);
        aho.a().a(activity.getApplicationContext(), s, Integer.valueOf(0x48dc2));
        aho.a().a(new ahp[0]);
    }

    public void a(Application application)
    {
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 56
    //                   -1514399234: 108
    //                   -1339456808: 93
    //                   486764790: 123
    //                   1992203943: 153
    //                   2022711712: 138;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_153;
_L7:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            c();
            return;

        case 1: // '\001'
            d();
            return;

        case 2: // '\002'
            f();
            return;

        case 3: // '\003'
        case 4: // '\004'
            b(parseuser);
            break;
        }
        break MISSING_BLOCK_LABEL_189;
_L3:
        if (s.equals("product-detail-ask-question"))
        {
            byte0 = 0;
        }
          goto _L7
_L2:
        if (s.equals("product-detail-offer"))
        {
            byte0 = 1;
        }
          goto _L7
_L4:
        if (s.equals("product-sell-complete"))
        {
            byte0 = 2;
        }
          goto _L7
_L6:
        if (s.equals("login-fb"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("signup-email"))
        {
            byte0 = 4;
        }
          goto _L7
    }

    public void a(ParseUser parseuser)
    {
        aqo.a("identify user with nanigans", new Object[0]);
        aho.a().a(parseuser.getObjectId());
    }

    public void b()
    {
    }

    public void b(Activity activity)
    {
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch -1499863611 -1499863611: default 24
    //                   -1499863611 45;
           goto _L1 _L2
_L2:
        if (s.equals("product-sell-start"))
        {
            byte0 = 0;
        }
_L1:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            e();
            break;
        }
        return;
    }

    protected void b(ParseUser parseuser)
    {
        aho.a().a(aho.a.b, "reg", new ahp[] {
            g(), c(parseuser), d(parseuser)
        });
    }

    protected ahp c(ParseUser parseuser)
    {
        if (parseuser == null)
        {
            return new ahp("user-id", new Object[] {
                ""
            });
        } else
        {
            return new ahp("user-id", new Object[] {
                parseuser.getObjectId()
            });
        }
    }

    protected void c()
    {
        aho.a().a(aho.a.a, "product-detail-ask-question", new ahp[0]);
    }

    public void c(Activity activity)
    {
    }

    protected ahp d(ParseUser parseuser)
    {
        if (parseuser == null || parseuser.getEmail() == null)
        {
            return new ahp("ut1", new Object[] {
                ""
            });
        } else
        {
            return new ahp("ut1", new Object[] {
                e(parseuser)
            });
        }
    }

    protected void d()
    {
        aho.a().a(aho.a.a, "product-detail-offer", new ahp[0]);
    }

    public void d(Activity activity)
    {
    }

    protected String e(ParseUser parseuser)
    {
        if (parseuser == null || parseuser.getEmail() == null)
        {
            return null;
        }
        parseuser = parseuser.getEmail().trim().toLowerCase();
        Object obj;
        String s;
        int i;
        try
        {
            obj = MessageDigest.getInstance("SHA-256");
            ((MessageDigest) (obj)).update(parseuser.getBytes("UTF-8"));
            parseuser = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (ParseUser parseuser)
        {
            aqo.b(parseuser, "Sha-256 not available", new Object[0]);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ParseUser parseuser)
        {
            aqo.b(parseuser, "UTF-8 encoding not supported", new Object[0]);
            return null;
        }
        i = 0;
        if (i >= parseuser.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s = Integer.toHexString(parseuser[i] & 0xff);
        if (s.length() == 1)
        {
            ((StringBuffer) (obj)).append('0');
        }
        ((StringBuffer) (obj)).append(s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_56;
_L1:
        parseuser = ((StringBuffer) (obj)).toString();
        return parseuser;
    }

    protected void e()
    {
        aho.a().a(aho.a.a, "product-sell-start", new ahp[0]);
    }

    public void e(Activity activity)
    {
    }

    protected void f()
    {
        aho.a().a(aho.a.a, "product-sell-complete", new ahp[0]);
    }

    public void f(Activity activity)
    {
    }

    protected ahp g()
    {
        return new ahp("nan_pid", new Object[] {
            Integer.valueOf(0x48dc2)
        });
    }
}
