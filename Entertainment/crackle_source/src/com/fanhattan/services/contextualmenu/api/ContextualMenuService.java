// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.fanhattan.services.api.BaseServiceBinder;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            IContextualMenuService, ContextualMenu

public class ContextualMenuService extends BaseServiceBinder
{
    public static interface ContextualMenuCallback
    {

        public abstract ContextualMenu createContextualMenu();

        public abstract void onCloseContextualMenu();

        public abstract boolean onContextualMenuSelected(String s);
    }

    private static final class MyCallback extends IContextualMenuCallback.Stub
    {

        private final ContextualMenuCallback mCallback;

        public void onCloseContextualMenu()
            throws RemoteException
        {
            if (mCallback != null)
            {
                mCallback.onCloseContextualMenu();
            }
        }

        public boolean onContextualMenuSelected(String s)
            throws RemoteException
        {
            boolean flag = false;
            if (mCallback != null)
            {
                flag = mCallback.onContextualMenuSelected(s);
            }
            return flag;
        }

        public ContextualMenu onCreateContextualMenu()
            throws RemoteException
        {
            ContextualMenu contextualmenu = null;
            if (mCallback != null)
            {
                contextualmenu = mCallback.createContextualMenu();
            }
            return contextualmenu;
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
                Log.e("ContextualMenuService - client side", "onTransact error ", parcel);
                return false;
            }
            return flag;
        }

        public MyCallback(ContextualMenuCallback contextualmenucallback)
        {
            mCallback = contextualmenucallback;
        }
    }


    public static final String TAG = "ContextualMenuService - client side";
    private final MyCallback mCallback;

    public ContextualMenuService(Context context)
    {
        this(context, null);
    }

    public ContextualMenuService(Context context, ContextualMenuCallback contextualmenucallback)
    {
        super(context, true, "ContextualMenuService - client side");
        mCallback = new MyCallback(contextualmenucallback);
    }

    protected void beforeServiceDisconnected(IContextualMenuService icontextualmenuservice)
    {
        try
        {
            icontextualmenuservice.unregisterContextualMenu(mContext.getPackageName());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IContextualMenuService icontextualmenuservice)
        {
            Log.e("ContextualMenuService - client side", (new StringBuilder()).append("Error on unregisterContextualMenu").append(icontextualmenuservice).toString());
        }
    }

    protected volatile void beforeServiceDisconnected(Object obj)
    {
        beforeServiceDisconnected((IContextualMenuService)obj);
    }

    protected IContextualMenuService castService(IBinder ibinder)
    {
        return IContextualMenuService.Stub.asInterface(ibinder);
    }

    protected volatile Object castService(IBinder ibinder)
    {
        return castService(ibinder);
    }

    protected Intent getIntent()
    {
        Intent intent = new Intent("contextualMenu");
        intent.setClassName("com.fanhattan.services", "com.fanhattan.services.FanhattanService");
        return intent;
    }

    public void hideContextualMenu()
    {
        IContextualMenuService icontextualmenuservice;
        icontextualmenuservice = (IContextualMenuService)getService();
        if (icontextualmenuservice == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        icontextualmenuservice.hideContextualMenu(mContext.getPackageName());
        return;
        Exception exception;
        exception;
        Log.e("ContextualMenuService - client side", (new StringBuilder()).append("Error on hideContextualMenu").append(exception).toString());
        return;
    }

    public void invalidateContextualMenu(ContextualMenu contextualmenu)
    {
        IContextualMenuService icontextualmenuservice;
        icontextualmenuservice = (IContextualMenuService)getService();
        if (icontextualmenuservice == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        icontextualmenuservice.invalidateContextualMenu(contextualmenu);
        return;
        contextualmenu;
        Log.e("ContextualMenuService - client side", (new StringBuilder()).append("Error on invalidateContextualMenu").append(contextualmenu).toString());
        return;
    }

    public void onPause()
    {
        unbind();
    }

    public void onResume()
    {
        bind();
    }

    protected void onServiceConnected(IContextualMenuService icontextualmenuservice)
    {
        try
        {
            icontextualmenuservice.registerContextualMenu(mCallback, mContext.getPackageName());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IContextualMenuService icontextualmenuservice)
        {
            Log.e("ContextualMenuService - client side", (new StringBuilder()).append("Error on registerContextualMenu").append(icontextualmenuservice).toString());
        }
    }

    protected volatile void onServiceConnected(Object obj)
    {
        onServiceConnected((IContextualMenuService)obj);
    }

    protected void onServiceUnexpectedlyDisconnected()
    {
    }
}
