// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzx;

// Referenced classes of package com.google.android.gms.drive:
//            DriveApi, DrivePreferencesApi, zzd, zzg

public final class Drive
{

    public static final Api API;
    public static final DriveApi DriveApi = new zzs();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzaa();
    public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    public static final com.google.android.gms.common.api.Api.zzc zzRk;
    public static final Scope zzaiF = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzaiG = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api zzaiH;
    public static final zzd zzaiI = new zzx();
    public static final zzg zzaiJ = new zzac();

    private Drive()
    {
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        API = new Api("Drive.API", new _cls1(), zzRk);
        zzaiH = new Api("Drive.INTERNAL_API", new _cls2(), zzRk);
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
