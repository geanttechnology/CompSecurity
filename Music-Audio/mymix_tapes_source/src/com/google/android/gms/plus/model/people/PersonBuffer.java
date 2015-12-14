// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

// Referenced classes of package com.google.android.gms.plus.model.people:
//            Person

public final class PersonBuffer extends AbstractDataBuffer
{

    private final zzd zzaNz;

    public PersonBuffer(DataHolder dataholder)
    {
        super(dataholder);
        if (dataholder.zznP() != null && dataholder.zznP().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false))
        {
            zzaNz = new zzd(dataholder, PersonEntity.CREATOR);
            return;
        } else
        {
            zzaNz = null;
            return;
        }
    }

    public Person get(int i)
    {
        if (zzaNz != null)
        {
            return (Person)zzaNz.zzbn(i);
        } else
        {
            return new zzk(zzYX, i);
        }
    }

    public volatile Object get(int i)
    {
        return get(i);
    }
}
