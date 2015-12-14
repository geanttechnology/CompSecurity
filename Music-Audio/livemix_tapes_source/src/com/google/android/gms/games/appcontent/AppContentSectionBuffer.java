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

    private final ArrayList zzasw;

    public void release()
    {
        super.release();
        int j = zzasw.size();
        for (int i = 1; i < j; i++)
        {
            DataHolder dataholder = (DataHolder)zzasw.get(i);
            if (dataholder != null)
            {
                dataholder.close();
            }
        }

    }

    protected Object zzk(int i, int j)
    {
        return zzn(i, j);
    }

    protected AppContentSection zzn(int i, int j)
    {
        return new AppContentSectionRef(zzasw, i, j);
    }

    protected String zznW()
    {
        return "section_id";
    }

    protected String zznY()
    {
        return "card_id";
    }
}
