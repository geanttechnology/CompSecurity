// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzn;

// Referenced classes of package com.google.android.gms.location.places:
//            PlacesStatusCodes, PlaceLikelihood

public class PlaceLikelihoodBuffer extends AbstractDataBuffer
    implements Result
{

    private final Context mContext;
    private final Status zzSC;
    private final String zzaGk;
    private final int zzaGp;

    public PlaceLikelihoodBuffer(DataHolder dataholder, int i, Context context)
    {
        super(dataholder);
        mContext = context;
        zzSC = PlacesStatusCodes.zzhp(dataholder.getStatusCode());
        zzaGp = zza.zzhk(i);
        if (dataholder != null && dataholder.zzor() != null)
        {
            zzaGk = dataholder.zzor().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
            return;
        } else
        {
            zzaGk = null;
            return;
        }
    }

    public PlaceLikelihood get(int i)
    {
        return new zzn(zzabq, i, mContext);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public CharSequence getAttributions()
    {
        return zzaGk;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", getStatus()).zzg("attributions", zzaGk).toString();
    }

    private class zza
    {

        static int zzhk(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder("invalid source: ")).append(i).toString());

            case 100: // 'd'
            case 101: // 'e'
            case 102: // 'f'
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
                return i;
            }
        }
    }

}
