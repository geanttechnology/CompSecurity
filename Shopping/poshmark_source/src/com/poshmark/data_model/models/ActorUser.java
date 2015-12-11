// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.models.inner_models.UserReference;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            Actor

public class ActorUser extends Actor
{

    List data;

    public ActorUser()
    {
    }

    public String getAvataar()
    {
        return ((UserReference)data.get(0)).getAvataar();
    }

    public int getDefaultAvataarImageId()
    {
        return 0x7f020116;
    }

    public String getId()
    {
        return ((UserReference)data.get(0)).getUserId();
    }

    public String getName()
    {
        return ((UserReference)data.get(0)).getUserName();
    }
}
