// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzu, zzt

final class zzaaO
{

    private final ComponentName zzaaO;
    private final String zzuO;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzaaO))
            {
                return false;
            }
            obj = (zzaaO)obj;
            if (!zzt.equal(zzuO, ((zzuO) (obj)).zzuO) || !zzt.equal(zzaaO, ((zzaaO) (obj)).zzaaO))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            zzuO, zzaaO
        });
    }

    public String toString()
    {
        if (zzuO == null)
        {
            return zzaaO.flattenToString();
        } else
        {
            return zzuO;
        }
    }

    public Intent zznV()
    {
        if (zzuO != null)
        {
            return (new Intent(zzuO)).setPackage("com.google.android.gms");
        } else
        {
            return (new Intent()).setComponent(zzaaO);
        }
    }

    public (ComponentName componentname)
    {
        zzuO = null;
        zzaaO = (ComponentName)zzu.zzu(componentname);
    }

    public zzaaO(String s)
    {
        zzuO = zzu.zzcj(s);
        zzaaO = null;
    }
}
