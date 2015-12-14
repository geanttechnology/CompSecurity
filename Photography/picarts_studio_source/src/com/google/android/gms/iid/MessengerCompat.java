// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.android.gms.iid:
//            zzb

public class MessengerCompat
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return zzey(parcel);
        }

        public final Object[] newArray(int i)
        {
            return zzgJ(i);
        }

        public final MessengerCompat zzey(Parcel parcel)
        {
            parcel = parcel.readStrongBinder();
            if (parcel != null)
            {
                return new MessengerCompat(parcel);
            } else
            {
                return null;
            }
        }

        public final MessengerCompat[] zzgJ(int i)
        {
            return new MessengerCompat[i];
        }

    };
    Messenger zzaDK;
    zzb zzaDL;

    public MessengerCompat(Handler handler)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            zzaDK = new Messenger(handler);
            return;
        } else
        {
            zzaDL = new zza(handler);
            return;
        }
    }

    public MessengerCompat(IBinder ibinder)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            zzaDK = new Messenger(ibinder);
            return;
        } else
        {
            zzaDL = zzb.zza.zzbV(ibinder);
            return;
        }
    }

    public static int zzc(Message message)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return zzd(message);
        } else
        {
            return message.arg2;
        }
    }

    private static int zzd(Message message)
    {
        return message.sendingUid;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = getBinder().equals(((MessengerCompat)obj).getBinder());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return flag;
    }

    public IBinder getBinder()
    {
        if (zzaDK != null)
        {
            return zzaDK.getBinder();
        } else
        {
            return zzaDL.asBinder();
        }
    }

    public int hashCode()
    {
        return getBinder().hashCode();
    }

    public void send(Message message)
    {
        if (zzaDK != null)
        {
            zzaDK.send(message);
            return;
        } else
        {
            zzaDL.send(message);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaDK != null)
        {
            parcel.writeStrongBinder(zzaDK.getBinder());
            return;
        } else
        {
            parcel.writeStrongBinder(zzaDL.asBinder());
            return;
        }
    }


    private class zza extends zzb.zza
    {

        Handler handler;
        final MessengerCompat zzaDM;

        public final void send(Message message)
        {
            message.arg2 = Binder.getCallingUid();
            handler.dispatchMessage(message);
        }

        zza(Handler handler1)
        {
            zzaDM = MessengerCompat.this;
            super();
            handler = handler1;
        }
    }

}
