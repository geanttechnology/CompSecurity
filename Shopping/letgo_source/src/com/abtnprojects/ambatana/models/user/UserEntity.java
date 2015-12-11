// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.user;

import android.support.v7.iu;
import com.parse.ParseFile;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.models.user:
//            User

public class UserEntity
{

    public UserEntity()
    {
    }

    public User transform(ParseUser parseuser)
    {
        String s = null;
        if (parseuser == null)
        {
            return null;
        }
        ParseFile parsefile = parseuser.getParseFile("avatar");
        if (parsefile != null)
        {
            s = parsefile.getUrl();
        }
        return new User(parseuser.getObjectId(), parseuser.getString("username_public"), s, iu.a(parseuser), parseuser.getString("zipcode"), parseuser.getString("city"), parseuser.getString("country_code"));
    }
}
