// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.ArrayList;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response

public class UsernameResponse extends Response
{

    public boolean exists;
    public ArrayList variants;

    public UsernameResponse()
    {
        variants = new ArrayList();
    }
}
