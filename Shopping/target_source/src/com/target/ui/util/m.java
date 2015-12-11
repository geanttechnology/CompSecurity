// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.model.common.TGTDvmRemoteData;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.target.ui.util:
//            q

public class m
{

    public static final String TAG = com/target/ui/util/m.getSimpleName();

    public m()
    {
    }

    public static DvmRemoteData a(String s)
    {
        TGTDvmRemoteData tgtdvmremotedata = new TGTDvmRemoteData();
        try
        {
            tgtdvmremotedata.a(new URL(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            q.a(TAG, "Dvm url string passed is malformed");
            return null;
        }
        return tgtdvmremotedata;
    }

}
