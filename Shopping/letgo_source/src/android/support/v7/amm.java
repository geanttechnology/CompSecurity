// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            amn, alt, amc, amj

class amm
    implements amn
{
    private static final class a
        implements ServiceConnection
    {

        private boolean a;
        private final LinkedBlockingQueue b;

        public IBinder a()
        {
            if (a)
            {
                alt.h().e("Fabric", "getBinder already called");
            }
            a = true;
            IBinder ibinder;
            try
            {
                ibinder = (IBinder)b.poll(200L, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException interruptedexception)
            {
                return null;
            }
            return ibinder;
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            try
            {
                b.put(ibinder);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname)
            {
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            b.clear();
        }

        private a()
        {
            a = false;
            b = new LinkedBlockingQueue(1);
        }

    }

    private static final class b
        implements IInterface
    {

        private final IBinder a;

        public String a()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Object obj;
            obj;
            alt.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            parcel1.recycle();
            parcel.recycle();
            return null;
            obj;
            parcel1.recycle();
            parcel.recycle();
            throw obj;
        }

        public IBinder asBinder()
        {
            return a;
        }

        public boolean b()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcel.writeInt(1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i == 0)
            {
                flag = false;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Object obj;
            obj;
            alt.h().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
            parcel1.recycle();
            parcel.recycle();
            return false;
            obj;
            parcel1.recycle();
            parcel.recycle();
            throw obj;
        }

        public b(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    private final Context a;

    public amm(Context context)
    {
        a = context.getApplicationContext();
    }

    public amj a()
    {
        Object obj;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            alt.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        Object obj1;
        boolean flag;
        try
        {
            a.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            alt.h().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            alt.h().a("Fabric", "Unable to determine if Google Play Services is available", ((Throwable) (obj)));
            return null;
        }
        obj = new a();
        obj1 = new Intent("com.google.android.gms.ads.identifier.service.START");
        ((Intent) (obj1)).setPackage("com.google.android.gms");
        Exception exception;
        try
        {
            flag = a.bindService(((Intent) (obj1)), ((ServiceConnection) (obj)), 1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            alt.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", ((Throwable) (obj)));
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj1 = new b(((a) (obj)).a());
        obj1 = new amj(((b) (obj1)).a(), ((b) (obj1)).b());
        a.unbindService(((ServiceConnection) (obj)));
        return ((amj) (obj1));
        exception;
        alt.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", exception);
        a.unbindService(((ServiceConnection) (obj)));
        return null;
        Exception exception1;
        exception1;
        a.unbindService(((ServiceConnection) (obj)));
        throw exception1;
        alt.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        return null;
    }
}
