// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentUtils, AppContentTupleRef, AppContentTuple

static final class zzava
    implements pContentRunner
{

    final DataHolder zzauZ;
    final Bundle zzava;

    public void zzb(ArrayList arraylist, int i)
    {
        arraylist = new AppContentTupleRef(zzauZ, i);
        zzava.putString(arraylist.getName(), arraylist.getValue());
    }

    (DataHolder dataholder, Bundle bundle)
    {
        zzauZ = dataholder;
        zzava = bundle;
        super();
    }
}
