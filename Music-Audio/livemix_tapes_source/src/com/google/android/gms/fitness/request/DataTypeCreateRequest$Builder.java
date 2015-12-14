// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataTypeCreateRequest

public static class zzanX
{

    private String mName;
    private List zzanX;

    static String zza(zzanX zzanx)
    {
        return zzanx.mName;
    }

    static List zzb(mName mname)
    {
        return mname.zzanX;
    }

    public zzanX addField(Field field)
    {
        if (!zzanX.contains(field))
        {
            zzanX.add(field);
        }
        return this;
    }

    public zzanX addField(String s, int i)
    {
        boolean flag;
        if (s != null && !s.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid name specified");
        return addField(Field.zzo(s, i));
    }

    public DataTypeCreateRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (mName != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set the name");
        if (!zzanX.isEmpty())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must specify the data fields");
        return new DataTypeCreateRequest(this, null);
    }

    public zzanX setName(String s)
    {
        mName = s;
        return this;
    }

    public ()
    {
        zzanX = new ArrayList();
    }
}
