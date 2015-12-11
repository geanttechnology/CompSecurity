// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzv, zzp, AppMetadata, zzu, 
//            UserAttributeParcel, EventParcel

public class zzw extends zzm.zza
{

    private final zzv zzaKG;
    private final boolean zzaOf;

    public zzw(zzv zzv1)
    {
        zzx.zzw(zzv1);
        zzaKG = zzv1;
        zzaOf = false;
    }

    public zzw(zzv zzv1, boolean flag)
    {
        zzx.zzw(zzv1);
        zzaKG = zzv1;
        zzaOf = flag;
    }

    static zzv zza(zzw zzw1)
    {
        return zzw1.zzaKG;
    }

    private void zzed(String s)
        throws SecurityException
    {
        if (TextUtils.isEmpty(s))
        {
            zzaKG.zzyd().zzzK().zzec("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try
        {
            zzee(s);
            return;
        }
        catch (SecurityException securityexception)
        {
            zzaKG.zzyd().zzzK().zzj("Measurement Service called with invalid calling package", s);
            throw securityexception;
        }
    }

    private void zzee(String s)
        throws SecurityException
    {
        int i;
        if (zzaOf)
        {
            i = Process.myUid();
        } else
        {
            i = Binder.getCallingUid();
        }
        while (GooglePlayServicesUtil.zzb(zzaKG.getContext(), i, s) || GooglePlayServicesUtil.zze(zzaKG.getContext(), i) && !zzaKG.zzAi()) 
        {
            return;
        }
        throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] {
            s
        }));
    }

    public void zza(AppMetadata appmetadata)
    {
        zzx.zzw(appmetadata);
        zzed(appmetadata.packageName);
        zzaKG.zzzr().zzh(new Runnable(appmetadata) {

            final AppMetadata zzaOh;
            final zzw zzaOi;

            public void run()
            {
                zzw.zza(zzaOi).zzb(zzaOh);
            }

            
            {
                zzaOi = zzw.this;
                zzaOh = appmetadata;
                super();
            }
        });
    }

    public void zza(EventParcel eventparcel, AppMetadata appmetadata)
    {
        zzx.zzw(eventparcel);
        zzx.zzw(appmetadata);
        zzed(appmetadata.packageName);
        zzaKG.zzzr().zzh(new Runnable(eventparcel, appmetadata) {

            final EventParcel zzaOg;
            final AppMetadata zzaOh;
            final zzw zzaOi;

            public void run()
            {
                zzw.zza(zzaOi).zzb(zzaOg, zzaOh);
            }

            
            {
                zzaOi = zzw.this;
                zzaOg = eventparcel;
                zzaOh = appmetadata;
                super();
            }
        });
    }

    public void zza(UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
    {
        zzx.zzw(userattributeparcel);
        zzx.zzw(appmetadata);
        zzed(appmetadata.packageName);
        if (userattributeparcel.getValue() == null)
        {
            zzaKG.zzzr().zzh(new Runnable(userattributeparcel, appmetadata) {

                final AppMetadata zzaOh;
                final zzw zzaOi;
                final UserAttributeParcel zzaOj;

                public void run()
                {
                    zzw.zza(zzaOi).zzc(zzaOj, zzaOh);
                }

            
            {
                zzaOi = zzw.this;
                zzaOj = userattributeparcel;
                zzaOh = appmetadata;
                super();
            }
            });
            return;
        } else
        {
            zzaKG.zzzr().zzh(new Runnable(userattributeparcel, appmetadata) {

                final AppMetadata zzaOh;
                final zzw zzaOi;
                final UserAttributeParcel zzaOj;

                public void run()
                {
                    zzw.zza(zzaOi).zzb(zzaOj, zzaOh);
                }

            
            {
                zzaOi = zzw.this;
                zzaOj = userattributeparcel;
                zzaOh = appmetadata;
                super();
            }
            });
            return;
        }
    }
}
