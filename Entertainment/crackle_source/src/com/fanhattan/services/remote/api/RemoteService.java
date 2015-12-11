// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.fanhattan.services.api.BaseServiceBinder;

// Referenced classes of package com.fanhattan.services.remote.api:
//            IRemoteService, RemoteCallback

public final class RemoteService extends BaseServiceBinder
{
    public static final class Events
    {

        public static final int RAW_CANCEL = 4;
        public static final int RAW_MOTION = 2;
        public static final int RAW_PRESS = 1;
        public static final int RAW_RELEASE = 3;

        private Events()
        {
            throw new IllegalAccessError();
        }
    }

    final class RemoteServiceListener extends IRemoteServiceListener.Stub
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
                flag = super.onTransact(i, parcel, parcel1, j);
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

        public RemoteServiceListener(RemoteCallback remotecallback)
        {
            this$0 = RemoteService.this;
            super();
            mCallback = remotecallback;
        }
    }


    public static final int BLUETOOTH_REMOTE = 0;
    private static final String TAG = "RemoteService";
    public static final int WIFI_REMOTE = 1;
    private final RemoteServiceListener mRemoteServiceListener;

    public RemoteService(Context context, RemoteCallback remotecallback)
    {
        super(context, true, "RemoteService");
        if (remotecallback == null)
        {
            throw new NullPointerException();
        } else
        {
            mRemoteServiceListener = new RemoteServiceListener(remotecallback);
            return;
        }
    }

    protected void beforeServiceDisconnected(IRemoteService iremoteservice)
    {
        try
        {
            iremoteservice.unregisterListener(mRemoteServiceListener);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IRemoteService iremoteservice)
        {
            Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services, cannot register a remote callback").append(iremoteservice.getMessage()).toString());
        }
    }

    protected volatile void beforeServiceDisconnected(Object obj)
    {
        beforeServiceDisconnected((IRemoteService)obj);
    }

    protected IRemoteService castService(IBinder ibinder)
    {
        return IRemoteService.Stub.asInterface(ibinder);
    }

    protected volatile Object castService(IBinder ibinder)
    {
        return castService(ibinder);
    }

    public int getBatteryLevel(int i)
    {
        IRemoteService iremoteservice = (IRemoteService)getService();
        if (iremoteservice != null)
        {
            try
            {
                i = iremoteservice.getBatteryLevel(i);
            }
            catch (Exception exception)
            {
                Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return 0;
            }
            return i;
        } else
        {
            Log.e("RemoteService", "Not bound to remoteService ");
            return 0;
        }
    }

    public String getHardwareVersion(int i)
    {
        Object obj = (IRemoteService)getService();
        if (obj != null)
        {
            try
            {
                obj = ((IRemoteService) (obj)).getHardwareVersion(i);
            }
            catch (Exception exception)
            {
                Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return null;
            }
            return ((String) (obj));
        } else
        {
            Log.e("RemoteService", "Not bound to remoteService ");
            return null;
        }
    }

    protected Intent getIntent()
    {
        Intent intent = new Intent("remote");
        intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
        return intent;
    }

    public String getSoftwareBuild(int i)
    {
        Object obj = (IRemoteService)getService();
        if (obj != null)
        {
            try
            {
                obj = ((IRemoteService) (obj)).getSoftwareBuild(i);
            }
            catch (Exception exception)
            {
                Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return null;
            }
            return ((String) (obj));
        } else
        {
            Log.e("RemoteService", "Not bound to remoteService ");
            return null;
        }
    }

    public String getSoftwareVersion(int i)
    {
        Object obj = (IRemoteService)getService();
        if (obj != null)
        {
            try
            {
                obj = ((IRemoteService) (obj)).getSoftwareVersion(i);
            }
            catch (Exception exception)
            {
                Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return null;
            }
            return ((String) (obj));
        } else
        {
            Log.e("RemoteService", "Not bound to remoteService ");
            return null;
        }
    }

    public boolean isConnected(int i)
    {
        IRemoteService iremoteservice = (IRemoteService)getService();
        if (iremoteservice != null)
        {
            boolean flag;
            try
            {
                flag = iremoteservice.isConnected(i);
            }
            catch (Exception exception)
            {
                Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services ").append(exception.getMessage()).toString());
                return false;
            }
            return flag;
        } else
        {
            Log.e("RemoteService", "Not bound to remoteService ");
            return false;
        }
    }

    public void onPause()
    {
        unbind();
    }

    public void onResume()
    {
        bind();
    }

    protected void onServiceConnected(IRemoteService iremoteservice)
    {
        try
        {
            iremoteservice.registerListener(mRemoteServiceListener);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IRemoteService iremoteservice)
        {
            Log.e("RemoteService", (new StringBuilder()).append("Error in Fanhattan Services, cannot register a remote callback").append(iremoteservice.getMessage()).toString());
        }
    }

    protected volatile void onServiceConnected(Object obj)
    {
        onServiceConnected((IRemoteService)obj);
    }
}
