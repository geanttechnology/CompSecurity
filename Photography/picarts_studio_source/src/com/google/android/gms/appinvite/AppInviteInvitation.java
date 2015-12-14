// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appinvite;

import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class AppInviteInvitation
{

    private AppInviteInvitation()
    {
    }

    public static String[] getInvitationIds(int i, Intent intent)
    {
        if (i == -1)
        {
            return intent.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS");
        } else
        {
            return null;
        }
    }

    private static Bundle zzC(Map map)
    {
        Bundle bundle = new Bundle();
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); bundle.putString(s, (String)map.get(s)))
        {
            s = (String)iterator.next();
        }

        return bundle;
    }

    static Bundle zzD(Map map)
    {
        return zzC(map);
    }
}
