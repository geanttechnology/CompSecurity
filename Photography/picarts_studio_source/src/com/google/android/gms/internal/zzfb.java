// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzfh, zziz, zzid, zzbq, 
//            zzhu

public class zzfb extends zzfh
{

    private final Context mContext;
    private final Map zzvS;
    private String zzzV;
    private long zzzW;
    private long zzzX;
    private String zzzY;
    private String zzzZ;

    public zzfb(zziz zziz1, Map map)
    {
        super(zziz1, "createCalendarEvent");
        zzvS = map;
        mContext = zziz1.zzgZ();
        zzec();
    }

    static Context zza(zzfb zzfb1)
    {
        return zzfb1.mContext;
    }

    private String zzah(String s)
    {
        if (TextUtils.isEmpty((CharSequence)zzvS.get(s)))
        {
            return "";
        } else
        {
            return (String)zzvS.get(s);
        }
    }

    private long zzai(String s)
    {
        s = (String)zzvS.get(s);
        if (s == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    private void zzec()
    {
        zzzV = zzah("description");
        zzzY = zzah("summary");
        zzzW = zzai("start_ticks");
        zzzX = zzai("end_ticks");
        zzzZ = zzah("location");
    }

    Intent createIntent()
    {
        Intent intent = (new Intent("android.intent.action.EDIT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
        intent.putExtra("title", zzzV);
        intent.putExtra("eventLocation", zzzZ);
        intent.putExtra("description", zzzY);
        if (zzzW > -1L)
        {
            intent.putExtra("beginTime", zzzW);
        }
        if (zzzX > -1L)
        {
            intent.putExtra("endTime", zzzX);
        }
        intent.setFlags(0x10000000);
        return intent;
    }

    public void execute()
    {
        if (mContext == null)
        {
            zzak("Activity context is not available.");
            return;
        }
        if (!zzp.zzbv().zzL(mContext).zzdb())
        {
            zzak("This feature is not available on the device.");
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = zzp.zzbv().zzK(mContext);
            builder.setTitle(zzp.zzby().zzd(com.google.android.gms.R.string.create_calendar_title, "Create calendar event"));
            builder.setMessage(zzp.zzby().zzd(com.google.android.gms.R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(zzp.zzby().zzd(com.google.android.gms.R.string.accept, "Accept"), new android.content.DialogInterface.OnClickListener() {

                final zzfb zzAa;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = zzAa.createIntent();
                    zzp.zzbv().zzb(zzfb.zza(zzAa), dialoginterface);
                }

            
            {
                zzAa = zzfb.this;
                super();
            }
            });
            builder.setNegativeButton(zzp.zzby().zzd(com.google.android.gms.R.string.decline, "Decline"), new android.content.DialogInterface.OnClickListener() {

                final zzfb zzAa;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    zzAa.zzak("Operation denied by user.");
                }

            
            {
                zzAa = zzfb.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }
}
