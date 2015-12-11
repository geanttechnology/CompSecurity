// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.abtnprojects.ambatana.models.user.User;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;
import java.util.Locale;

public class iu
{

    public iu()
    {
    }

    public static boolean a(ParseUser parseuser)
    {
        if (parseuser != null)
        {
            if (!TextUtils.isEmpty(parseuser = parseuser.getUsername()))
            {
                return parseuser.toLowerCase(Locale.US).startsWith("usercontent");
            }
        }
        return false;
    }

    public static boolean c(ParseUser parseuser)
    {
        while (parseuser == null || ParseAnonymousUtils.isLinked(parseuser)) 
        {
            return false;
        }
        return true;
    }

    public String a(User user)
    {
        if (user != null && user.isRichy())
        {
            return "dummy";
        } else
        {
            return "real";
        }
    }

    public boolean b(ParseUser parseuser)
    {
        if (parseuser != null)
        {
            if (!TextUtils.isEmpty(parseuser = parseuser.getUsername()))
            {
                return parseuser.toLowerCase(Locale.US).startsWith("usercontent");
            }
        }
        return false;
    }
}
