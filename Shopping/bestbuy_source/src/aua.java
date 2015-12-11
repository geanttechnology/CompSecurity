// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import com.google.android.gms.wearable.Asset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class aua
{

    private final Uri a;
    private final atz b;

    private aua(atx atx1)
    {
        a = atx1.b();
        b = b((atx)atx1.a());
    }

    public static aua a(atx atx1)
    {
        if (atx1 == null)
        {
            throw new IllegalStateException("provided dataItem is null");
        } else
        {
            return new aua(atx1);
        }
    }

    private atz b(atx atx1)
    {
        ArrayList arraylist;
        aty aty1;
        int i;
        if (atx1.c() == null && atx1.d().size() > 0)
        {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        }
        if (atx1.c() == null)
        {
            return new atz();
        }
        int j;
        try
        {
            arraylist = new ArrayList();
            j = atx1.d().size();
        }
        // Misplaced declaration of an exception variable
        catch (atx atx1)
        {
            throw new IllegalStateException("Unable to parse. Not a DataItem.");
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aty1 = (aty)atx1.d().get(Integer.toString(i));
        if (aty1 != null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        throw new IllegalStateException((new StringBuilder()).append("Cannot find DataItemAsset referenced in data at ").append(i).append(" for ").append(atx1).toString());
        arraylist.add(Asset.a(aty1.b()));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        atx1 = agk.a(new agl(agm.a(atx1.c()), arraylist));
        return atx1;
    }

    public atz a()
    {
        return b;
    }
}
