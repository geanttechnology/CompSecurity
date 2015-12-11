// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx, zzw

final class zzagb
{

    private final String zzPp;
    private final ComponentName zzagb;

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzagb))
            {
                return false;
            }
            obj = (zzagb)obj;
            if (!zzw.equal(zzPp, ((zzPp) (obj)).zzPp) || !zzw.equal(zzagb, ((zzagb) (obj)).zzagb))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzPp, zzagb
        });
    }

    public final String toString()
    {
        if (zzPp == null)
        {
            return zzagb.flattenToString();
        } else
        {
            return zzPp;
        }
    }

    public final Intent zzpm()
    {
        if (zzPp != null)
        {
            return (new Intent(zzPp)).setPackage("com.google.android.gms");
        } else
        {
            return (new Intent()).setComponent(zzagb);
        }
    }

    public (ComponentName componentname)
    {
        zzPp = null;
        zzagb = (ComponentName)zzx.zzw(componentname);
    }

    public zzagb(String s)
    {
        zzPp = zzx.zzcr(s);
        zzagb = null;
    }
}
