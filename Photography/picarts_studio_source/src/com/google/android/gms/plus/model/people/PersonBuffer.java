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

    private final zzd zzaUz;

    public PersonBuffer(DataHolder dataholder)
    {
        super(dataholder);
        if (dataholder.zzor() != null && dataholder.zzor().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false))
        {
            zzaUz = new zzd(dataholder, PersonEntity.CREATOR);
            return;
        } else
        {
            zzaUz = null;
            return;
        }
    }

    public final Person get(int i)
    {
        if (zzaUz != null)
        {
            return (Person)zzaUz.zzbs(i);
        } else
        {
            return new zzk(zzabq, i);
        }
    }

    public final volatile Object get(int i)
    {
        return get(i);
    }
}
