// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.os.Binder;
import android.os.Parcel;

// Referenced classes of package org.chromium.net:
//            IRemoteAndroidKeyStore

public abstract class attachInterface extends Binder
    implements IRemoteAndroidKeyStore
{

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("org.chromium.net.IRemoteAndroidKeyStore");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = a();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = a(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeByteArray(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            i = b(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            a(cks.Stub.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = a(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeByteArray(parcel);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = b(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeByteArray(parcel);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = c(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeByteArray(parcel);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = d(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeByteArray(parcel);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            parcel = a(parcel.readInt(), parcel.createByteArray());
            parcel1.writeNoException();
            parcel1.writeByteArray(parcel);
            return true;

        case 10: // '\n'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            i = e(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 11: // '\013'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStore");
            f(parcel.readInt());
            parcel1.writeNoException();
            return true;
        }
    }

    public cks.Stub()
    {
        attachInterface(this, "org.chromium.net.IRemoteAndroidKeyStore");
    }
}
