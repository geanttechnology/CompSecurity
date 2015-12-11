// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.ParseUserAddressData;
import com.abtnprojects.ambatana.models.ParseUserAddressDataMapper;
import com.abtnprojects.ambatana.models.ParseUserLocationHelper;
import com.parse.ParseFile;
import com.parse.ParseUser;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import org.json.JSONException;

// Referenced classes of package android.support.v7:
//            es, aqo, eu, iv

public class er
{

    private final ParseUser a;
    private final LetgoAddress b;
    private final es c;
    private final ParseUserLocationHelper d = new ParseUserLocationHelper();

    public er(ParseUser parseuser, LetgoAddress letgoaddress, es es1)
    {
        a = parseuser;
        b = letgoaddress;
        c = es1;
    }

    ParseUserAddressData a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        Object obj = c.a();
        if (obj == null)
        {
            return null;
        }
        obj = (new ParseUserAddressDataMapper()).fromLetgoAddress(((LetgoAddress) (obj)));
        return ((ParseUserAddressData) (obj));
        Object obj1;
        obj1;
_L4:
        aqo.b(((Throwable) (obj1)), "getParseUserData", new Object[0]);
        return null;
_L2:
        return (new ParseUserAddressDataMapper()).fromLetgoAddress(b);
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(String s)
    {
        if (TextUtils.isEmpty(a.getString("username_public")))
        {
            a.put("username_public", s);
        }
    }

    boolean a(eu eu1)
    {
        if (eu1 != null && a != null)
        {
            String s = eu1.getUserEmail();
            if (!TextUtils.isEmpty(s))
            {
                b(s);
            }
            s = eu1.getUserNamePublic();
            if (!TextUtils.isEmpty(s))
            {
                a(s);
            }
            a.put("loginType", Integer.valueOf(1));
            a.put("processed", Boolean.valueOf(false));
            if (c.a(a))
            {
                if (a.getParseFile("avatar") == null)
                {
                    String s1 = eu1.a();
                    if (!TextUtils.isEmpty(s1))
                    {
                        c(s1);
                    }
                }
                Object obj = a();
                if (obj != null)
                {
                    obj = d.createLocatedParseUser(((ParseUserAddressData) (obj)), a);
                    c.a(((ParseUser) (obj)));
                }
                if (eu1.b() != null)
                {
                    c.a(eu1.b());
                }
                return true;
            }
        }
        return false;
    }

    void b(String s)
    {
        if (TextUtils.isEmpty(a.getString("email")))
        {
            a.put("email", s);
        }
        if (TextUtils.isEmpty(a.getString("username")))
        {
            a.put("username", s);
        }
    }

    void c(String s)
    {
        Bitmap bitmap = iv.c(s);
        aqo.a("saveUserAvatar bm url is %s", new Object[] {
            s
        });
        if (bitmap == null)
        {
            aqo.a("saveUserAvatar bm is null", new Object[0]);
        } else
        {
            s = (new StringBuilder()).append(a.getObjectId()).append(".jpg").toString();
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, bytearrayoutputstream);
            s = new ParseFile(s, bytearrayoutputstream.toByteArray());
            if (c.a(s))
            {
                a.put("avatar", s);
                a.put("processed", Boolean.valueOf(false));
                c.a(a);
                return;
            }
        }
    }
}
