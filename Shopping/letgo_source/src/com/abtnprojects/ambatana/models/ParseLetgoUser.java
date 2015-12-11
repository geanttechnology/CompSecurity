// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            AbstractLetgoUser

public class ParseLetgoUser extends AbstractLetgoUser
{

    public ParseLetgoUser()
    {
    }

    public ParseUser getAppCurrentUser()
    {
        return ParseUser.getCurrentUser();
    }
}
