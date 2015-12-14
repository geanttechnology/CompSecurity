// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            d

public class  extends Model
{

    public Date currentTime;
    public ArrayList results;
    public Integer totalSize;

    public d b()
    {
        d d1 = new d();
        d1.b = results;
        d1.a = totalSize;
        return d1;
    }

    public ()
    {
    }
}
