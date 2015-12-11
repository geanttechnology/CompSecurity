// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzj

public class zzp extends zzj
{

    public zzp(String s, int i)
    {
        super(s, zzcI(s), Collections.emptyList(), i);
    }

    private static String zzA(String s, String s1)
    {
        return (new StringBuilder()).append(s).append(".").append(s1).toString();
    }

    private String zzcH(String s)
    {
        return zzA(getName(), s);
    }

    private static Collection zzcI(String s)
    {
        return Arrays.asList(new String[] {
            zzA(s, "permissionId"), zzA(s, "displayName"), zzA(s, "picture"), zzA(s, "isAuthenticatedUser"), zzA(s, "emailAddress")
        });
    }

    protected boolean zzb(DataHolder dataholder, int i, int j)
    {
        return dataholder.zzce(zzcH("permissionId")) && !dataholder.zzi(zzcH("permissionId"), i, j);
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzj(dataholder, i, j);
    }

    protected UserMetadata zzj(DataHolder dataholder, int i, int j)
    {
        String s = dataholder.zzd(zzcH("permissionId"), i, j);
        if (s != null)
        {
            String s1 = dataholder.zzd(zzcH("displayName"), i, j);
            String s2 = dataholder.zzd(zzcH("picture"), i, j);
            boolean flag = dataholder.zze(zzcH("isAuthenticatedUser"), i, j);
            dataholder = dataholder.zzd(zzcH("emailAddress"), i, j);
            return new UserMetadata(s, s1, s2, Boolean.valueOf(flag).booleanValue(), dataholder);
        } else
        {
            return null;
        }
    }
}
