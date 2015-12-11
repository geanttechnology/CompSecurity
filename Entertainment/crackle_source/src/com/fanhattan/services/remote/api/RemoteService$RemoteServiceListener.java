// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package com.fanhattan.services.remote.api:
//            RemoteService, RemoteCallback

final class mCallback extends mCallback
{

    private final RemoteCallback mCallback;
    final RemoteService this$0;

    public void onBatteryLevelChanged(int i, int j)
        throws RemoteException
    {
        mCallback.onRemoteBatteryLevelChanged(i, j);
    }

    public void onConnected(int i)
        throws RemoteException
    {
        mCallback.onRemoteConnected(i);
    }

    public void onDisconnected(int i)
        throws RemoteException
    {
        mCallback.onRemoteDisconnected(i);
    }

    public void onEnvironmentReport(int i, int j, int k, int l)
        throws RemoteException
    {
        mCallback.onEnvironmentReport(i, j, k, l);
    }

    public boolean onTouchEvent(int i, int j, float f, float f1, float f2, float f3, int k, 
            long l)
        throws RemoteException
    {
        return mCallback.onRemoteTouchEvent(i, j, f, f1, f2, f3, k, l);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        boolean flag;
        try
        {
            flag = super.ct(i, parcel, parcel1, j);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            Log.e("RemoteService", "onTransact error ", parcel);
            throw parcel;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            Log.e("RemoteService", "onTransact error ", parcel);
            return false;
        }
        return flag;
    }

    public (RemoteCallback remotecallback)
    {
        this$0 = RemoteService.this;
        super();
        mCallback = remotecallback;
    }
}
