// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnEventResponse, zzy

public class zzad extends zzan.zza
{
    private static class zza extends Handler
    {

        private final Context mContext;

        private static void zza(zzl zzl1, QueryResultEventParcelable queryresulteventparcelable)
        {
            com.google.android.gms.common.data.DataHolder dataholder = queryresulteventparcelable.zzqA();
            if (dataholder != null)
            {
                zzl1.zza(new zzj(new MetadataBuffer(dataholder)) {

                    final MetadataBuffer zzaji;

            
            {
                zzaji = metadatabuffer;
                super();
            }
                });
            }
            if (queryresulteventparcelable.zzqB())
            {
                zzl1.zzcs(queryresulteventparcelable.zzqC());
            }
        }

        public void handleMessage(Message message)
        {
            Object obj;
            switch (message.what)
            {
            default:
                com.google.android.gms.drive.internal.zzy.zzf(mContext, "EventCallback", "Don't know how to handle this event");
                return;

            case 1: // '\001'
                obj = (Pair)message.obj;
                break;
            }
            message = (zzf)((Pair) (obj)).first;
            obj = (DriveEvent)((Pair) (obj)).second;
            switch (((DriveEvent) (obj)).getType())
            {
            default:
                zzy.zzw("EventCallback", (new StringBuilder()).append("Unexpected event: ").append(obj).toString());
                return;

            case 1: // '\001'
                ((ChangeListener)message).onChange((ChangeEvent)obj);
                return;

            case 2: // '\002'
                ((CompletionListener)message).onCompletion((CompletionEvent)obj);
                return;

            case 3: // '\003'
                zza((zzl)message, (QueryResultEventParcelable)obj);
                return;

            case 4: // '\004'
                ((zzc)message).zza((ChangesAvailableEvent)obj);
                return;

            case 5: // '\005'
            case 6: // '\006'
                ((zzi)message).zza((ProgressEvent)obj);
                break;
            }
        }

        public void zza(zzf zzf1, DriveEvent driveevent)
        {
            sendMessage(obtainMessage(1, new Pair(zzf1, driveevent)));
        }

        private zza(Looper looper, Context context)
        {
            super(looper);
            mContext = context;
        }

    }


    private final int zzafk;
    private final zzf zzajf;
    private final zza zzajg;
    private final List zzajh = new ArrayList();

    public zzad(Looper looper, Context context, int i, zzf zzf)
    {
        zzafk = i;
        zzajf = zzf;
        zzajg = new zza(looper, context);
    }

    public void zzc(OnEventResponse oneventresponse)
        throws RemoteException
    {
        oneventresponse = oneventresponse.zzqS();
        boolean flag;
        if (zzafk == oneventresponse.getType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzY(flag);
        zzx.zzY(zzajh.contains(Integer.valueOf(oneventresponse.getType())));
        zzajg.zza(zzajf, oneventresponse);
    }

    public void zzcJ(int i)
    {
        zzajh.add(Integer.valueOf(i));
    }

    public boolean zzcK(int i)
    {
        return zzajh.contains(Integer.valueOf(i));
    }
}
