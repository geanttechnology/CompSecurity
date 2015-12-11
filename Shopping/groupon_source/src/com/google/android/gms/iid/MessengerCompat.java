// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.iid:
//            zzb

public class MessengerCompat
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Object createFromParcel(Parcel parcel)
        {
            return zzeb(parcel);
        }

        public Object[] newArray(int i)
        {
            return zzgo(i);
        }

        public MessengerCompat zzeb(Parcel parcel)
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

        public MessengerCompat[] zzgo(int i)
        {
            return new MessengerCompat[i];
        }

    };
    Messenger zzaxa;
    zzb zzaxb;

    public MessengerCompat(IBinder ibinder)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            zzaxa = new Messenger(ibinder);
            return;
        } else
        {
            zzaxb = zzb.zza.zzbR(ibinder);
            return;
        }
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
        if (zzaxa != null)
        {
            return zzaxa.getBinder();
        } else
        {
            return zzaxb.asBinder();
        }
    }

    public int hashCode()
    {
        return getBinder().hashCode();
    }

    public void send(Message message)
        throws RemoteException
    {
        if (zzaxa != null)
        {
            zzaxa.send(message);
            return;
        } else
        {
            zzaxb.send(message);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaxa != null)
        {
            parcel.writeStrongBinder(zzaxa.getBinder());
            return;
        } else
        {
            parcel.writeStrongBinder(zzaxb.asBinder());
            return;
        }
    }

}
