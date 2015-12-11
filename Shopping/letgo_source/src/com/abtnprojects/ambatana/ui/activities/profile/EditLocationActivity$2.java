// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.location.LocationSettingsResult;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditLocationActivity

class a
    implements h
{

    final EditLocationActivity a;

    public volatile void a(g g)
    {
        a((LocationSettingsResult)g);
    }

    public void a(LocationSettingsResult locationsettingsresult)
    {
        locationsettingsresult = locationsettingsresult.a();
        switch (locationsettingsresult.g())
        {
        default:
            return;

        case 0: // '\0'
            EditLocationActivity.a(a);
            return;

        case 6: // '\006'
            try
            {
                locationsettingsresult.a(a, 433);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LocationSettingsResult locationsettingsresult)
            {
                return;
            }

        case 8502: 
            EditLocationActivity.a(a);
            return;
        }
    }

    (EditLocationActivity editlocationactivity)
    {
        a = editlocationactivity;
        super();
    }
}
