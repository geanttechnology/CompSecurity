// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.dp.logger.DPLogger;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.communication:
//            IInputStream

public class LargeArrayOptimizedIInputStream
    implements IInputStream
{

    private static final DPLogger log;
    private static boolean sIsOptimizedReadMethodAvailable = false;
    private static Method sOptimizedReadMethod = null;
    private final IBinder mRemote;
    private final IInputStream mStandardImplementation;

    private LargeArrayOptimizedIInputStream(IBinder ibinder, IInputStream iinputstream)
    {
        mRemote = ibinder;
        mStandardImplementation = iinputstream;
    }

    protected static boolean isOptimizedReadMethodAvailable()
    {
        return sIsOptimizedReadMethodAvailable;
    }

    public static IInputStream makeIInputStream(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.IInputStream");
        if (iinterface != null && (iinterface instanceof IInputStream))
        {
            return (IInputStream)iinterface;
        } else
        {
            return new LargeArrayOptimizedIInputStream(ibinder, IInputStream.Stub.asInterface(ibinder));
        }
    }

    public IBinder asBinder()
    {
        return mStandardImplementation.asBinder();
    }

    public int available()
        throws RemoteException
    {
        return mStandardImplementation.available();
    }

    public boolean close()
        throws RemoteException
    {
        return mStandardImplementation.close();
    }

    public int readByte()
        throws RemoteException
    {
        return mStandardImplementation.readByte();
    }

    public int readBytes(byte abyte0[])
        throws RemoteException
    {
        return mStandardImplementation.readBytes(abyte0);
    }

    public int readBytesIntoOffset(byte abyte0[], int i, int j)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        if (!isOptimizedReadMethodAvailable())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        int k;
        parcel.writeInterfaceToken("com.amazon.communication.IInputStream");
        parcel.writeByteArray(abyte0, i, j);
        parcel.writeInt(0);
        parcel.writeInt(j);
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        sOptimizedReadMethod.invoke(parcel1, new Object[] {
            abyte0, Integer.valueOf(i), Integer.valueOf(j)
        });
        parcel1.recycle();
        parcel.recycle();
        return k;
        abyte0;
        log.error("readBytesIntoOffset", "error invoking bulk read method via reflection", new Object[] {
            "offset", Integer.valueOf(i), "length", Integer.valueOf(j), abyte0
        });
        throw new RemoteException("Error invoking optimized read method");
        abyte0;
        parcel1.recycle();
        parcel.recycle();
        throw abyte0;
        return mStandardImplementation.readBytesIntoOffset(abyte0, i, j);
    }

    static 
    {
        log = new DPLogger("TComm.LargeArrayOptimizedIInputStream");
        try
        {
            sOptimizedReadMethod = android/os/Parcel.getDeclaredMethod("readByteArray", new Class[] {
                [B, Integer.TYPE, Integer.TYPE
            });
            sIsOptimizedReadMethodAvailable = true;
        }
        catch (Exception exception)
        {
            log.warn("static", "Could not find optimized Parcel.readByteArray(byte[], int, int) method", new Object[0]);
        }
    }
}
