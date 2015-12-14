// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzmt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzl

public final class LargeParcelTeleporter
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    final int mVersionCode;
    ParcelFileDescriptor zzFc;
    private Parcelable zzFd;
    private boolean zzFe;

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelfiledescriptor)
    {
        mVersionCode = i;
        zzFc = parcelfiledescriptor;
        zzFd = null;
        zzFe = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeparcelable)
    {
        mVersionCode = 1;
        zzFc = null;
        zzFd = safeparcelable;
        zzFe = false;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        Parcel parcel1;
        if (zzFc != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        parcel1 = Parcel.obtain();
        byte abyte0[];
        zzFd.writeToParcel(parcel1, 0);
        abyte0 = parcel1.marshall();
        parcel1.recycle();
        zzFc = zzf(abyte0);
        zzl.zza(this, parcel, i);
        return;
        parcel;
        parcel1.recycle();
        throw parcel;
    }

    public final SafeParcelable zza(android.os.Parcelable.Creator creator)
    {
        Object obj;
        if (!zzFe)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (zzFc == null)
        {
            zzb.e("File descriptor is empty, returning null.");
            return null;
        }
        obj = new DataInputStream(new android.os.ParcelFileDescriptor.AutoCloseInputStream(zzFc));
        byte abyte0[];
        abyte0 = new byte[((DataInputStream) (obj)).readInt()];
        ((DataInputStream) (obj)).readFully(abyte0, 0, abyte0.length);
        zzmt.zzb(((java.io.Closeable) (obj)));
        obj = Parcel.obtain();
        ((Parcel) (obj)).unmarshall(abyte0, 0, abyte0.length);
        ((Parcel) (obj)).setDataPosition(0);
        zzFd = (SafeParcelable)creator.createFromParcel(((Parcel) (obj)));
        ((Parcel) (obj)).recycle();
        zzFe = false;
        return (SafeParcelable)zzFd;
        creator;
        throw new IllegalStateException("Could not read from parcel file descriptor", creator);
        creator;
        zzmt.zzb(((java.io.Closeable) (obj)));
        throw creator;
        creator;
        ((Parcel) (obj)).recycle();
        throw creator;
    }

    protected final ParcelFileDescriptor zzf(byte abyte0[])
    {
        android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream;
        ParcelFileDescriptor aparcelfiledescriptor[];
        aparcelfiledescriptor = ParcelFileDescriptor.createPipe();
        autocloseoutputstream = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(aparcelfiledescriptor[1]);
        (new Thread(new Runnable(autocloseoutputstream, abyte0) {

            final OutputStream zzFf;
            final byte zzFg[];
            final LargeParcelTeleporter zzFh;

            public void run()
            {
                DataOutputStream dataoutputstream1 = new DataOutputStream(zzFf);
                DataOutputStream dataoutputstream = dataoutputstream1;
                dataoutputstream1.writeInt(zzFg.length);
                dataoutputstream = dataoutputstream1;
                dataoutputstream1.write(zzFg);
                zzmt.zzb(dataoutputstream1);
                return;
                IOException ioexception;
                ioexception;
                dataoutputstream1 = null;
_L4:
                dataoutputstream = dataoutputstream1;
                zzb.zzb("Error transporting the ad response", ioexception);
                dataoutputstream = dataoutputstream1;
                zzp.zzby().zzc(ioexception, true);
                if (dataoutputstream1 == null)
                {
                    zzmt.zzb(zzFf);
                    return;
                } else
                {
                    zzmt.zzb(dataoutputstream1);
                    return;
                }
                Exception exception;
                exception;
                dataoutputstream = null;
_L2:
                if (dataoutputstream == null)
                {
                    zzmt.zzb(zzFf);
                } else
                {
                    zzmt.zzb(dataoutputstream);
                }
                throw exception;
                exception;
                if (true) goto _L2; else goto _L1
_L1:
                ioexception;
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                zzFh = LargeParcelTeleporter.this;
                zzFf = outputstream;
                zzFg = abyte0;
                super();
            }
        })).start();
        abyte0 = aparcelfiledescriptor[0];
        return abyte0;
        abyte0;
        autocloseoutputstream = null;
_L2:
        zzb.zzb("Error transporting the ad response", abyte0);
        zzp.zzby().zzc(abyte0, true);
        zzmt.zzb(autocloseoutputstream);
        return null;
        abyte0;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
