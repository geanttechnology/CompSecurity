// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import com.socialin.android.NoProGuard;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            g

public class FacebookPageObject
    implements NoProGuard, g
{

    private String id;
    private String name;
    private String token;

    public FacebookPageObject(JSONObject jsonobject)
    {
        init(jsonobject);
    }

    public String getAccessToken()
    {
        return token;
    }

    public int getCount()
    {
        return 0;
    }

    public String getCover()
    {
        return null;
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return name;
    }

    public void init(JSONObject jsonobject)
    {
        id = jsonobject.optString("id");
        name = jsonobject.optString("name");
        token = jsonobject.optString("access_token");
    }
}
