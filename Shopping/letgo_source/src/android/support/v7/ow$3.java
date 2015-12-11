// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            ox, ow, nn, nj, 
//            ul

static final class 
    implements ox
{

    public void zza(ul ul1, Map map)
    {
        if (!((Boolean)nn.ai.c()).booleanValue())
        {
            return;
        }
        boolean flag;
        if (!Boolean.parseBoolean((String)map.get("disabled")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ul1.c(flag);
    }

    ()
    {
    }
}
