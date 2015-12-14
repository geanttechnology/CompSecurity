// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import com.socialin.android.NoProGuard;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            g

public class FBFriendObject
    implements NoProGuard, g
{

    private boolean checked;
    private String id;
    private String imageUrl;
    private String name;

    public FBFriendObject(JSONObject jsonobject)
    {
        checked = false;
        init(jsonobject);
    }

    public int getCount()
    {
        return 0;
    }

    public String getCover()
    {
        return imageUrl;
    }

    public String getId()
    {
        return id;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return name;
    }

    public void init(JSONObject jsonobject)
    {
        id = jsonobject.optString("id");
        name = jsonobject.optString("name");
        imageUrl = (new StringBuilder("https://graph.facebook.com/v2.4/")).append(id).append("/picture?type=large").toString();
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean flag)
    {
        checked = flag;
    }
}
