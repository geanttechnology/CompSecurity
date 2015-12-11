// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentSectionRef, AppContentSection

public final class AppContentSectionBuffer extends zzf
{

    private final ArrayList zzauU;

    public void release()
    {
        super.release();
        int j = zzauU.size();
        for (int i = 1; i < j; i++)
        {
            DataHolder dataholder = (DataHolder)zzauU.get(i);
            if (dataholder != null)
            {
                dataholder.close();
            }
        }

    }

    protected Object zzj(int i, int j)
    {
        return zzm(i, j);
    }

    protected AppContentSection zzm(int i, int j)
    {
        return new AppContentSectionRef(zzauU, i, j);
    }

    protected String zzoA()
    {
        return "card_id";
    }

    protected String zzoy()
    {
        return "section_id";
    }
}
