// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.content.Context;
import com.amazon.gallery.thor.app.authentication.AospPreferences;

// Referenced classes of package com.amazon.gallery.framework.kindle.auth.mapr5:
//            MAPR5AuthenticationManager

public class AospMAPR5AuthenticationManager extends MAPR5AuthenticationManager
{

    private final AospPreferences aospPrefs;

    public AospMAPR5AuthenticationManager(Context context)
    {
        super(context);
        aospPrefs = new AospPreferences(context);
    }

    public String getAccountId()
    {
        if (hasActiveAccount())
        {
            return super.getAccountId();
        } else
        {
            return null;
        }
    }

    public String getPFM()
    {
        if (hasActiveAccount())
        {
            return super.getPFM();
        } else
        {
            return null;
        }
    }

    public boolean hasActiveAccount()
    {
        return aospPrefs.signedIn();
    }
}
