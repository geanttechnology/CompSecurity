// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import co.vine.android.service.RealTimeChatService;
import co.vine.android.service.VineServiceConnection;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.client:
//            VineAccountHelper, Session, AppSessionListener

public class RealTimeChatController
    implements co.vine.android.service.VineServiceConnection.ServiceResponseHandler
{

    private static final String TAG = "RTCController";
    private static RealTimeChatController sInstance;
    private final Context mContext;
    private ArrayList mListeners;
    private final VineServiceConnection mServiceConnection;

    private RealTimeChatController(Context context)
    {
        mServiceConnection = new VineServiceConnection(context, this);
        context.bindService(new Intent(context, co/vine/android/service/RealTimeChatService), mServiceConnection, 1);
        mListeners = new ArrayList();
        mContext = context;
    }

    private Bundle createServiceBundle()
    {
        Bundle bundle = new Bundle();
        Bundle bundle1;
        try
        {
            bundle1 = injectServiceBundle(bundle, getActiveSession(true));
        }
        catch (Exception exception)
        {
            CrashUtil.log("Failed to get active session.");
            return bundle;
        }
        return bundle1;
    }

    private String executeServiceAction(int i, Bundle bundle)
    {
        bundle.putInt("pid", Process.myPid());
        return mServiceConnection.queueAndExecute(i, bundle);
    }

    private Session getActiveSession(boolean flag)
    {
        return VineAccountHelper.getActiveSession(mContext, flag);
    }

    public static RealTimeChatController getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new RealTimeChatController(context.getApplicationContext());
        }
        return sInstance;
    }

    private Bundle injectServiceBundle(Bundle bundle, Session session)
    {
        bundle.putString("s_key", session.getSessionKey());
        bundle.putLong("s_owner_id", session.getUserId());
        bundle.putString("a_name", session.getName());
        bundle.putString("email", session.getLoginEmail());
        return bundle;
    }

    public void addListener(AppSessionListener appsessionlistener)
    {
        if (mListeners.contains(appsessionlistener))
        {
            return;
        } else
        {
            mListeners.add(appsessionlistener);
            return;
        }
    }

    public String connectChatService()
    {
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("respond", false);
        return executeServiceAction(1, bundle);
    }

    public void disconnect()
    {
        SLog.dWithTag("RTCController", "RTCController disconnect() hit");
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("respond", false);
        executeServiceAction(5, bundle);
    }

    public void handleServiceResponse(int i, int j, String s, Bundle bundle)
    {
        s = bundle.getString("rid");
        mServiceConnection.remove(s);
        notifyListeners(i, bundle);
    }

    public void notifyListeners(int i, Bundle bundle)
    {
        i;
        JVM INSTR tableswitch 1 9: default 52
    //                   1 53
    //                   2 52
    //                   3 85
    //                   4 52
    //                   5 159
    //                   6 191
    //                   7 117
    //                   8 52
    //                   9 223;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L5 _L6 _L1 _L7
_L1:
        return;
_L2:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onWebSocketConnectComplete();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onSubscribeConversationComplete();
        }
        if (true) goto _L1; else goto _L6
_L6:
        boolean flag = bundle.getBoolean("is_typing");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUpdateTypingStateComplete(flag);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onWebSocketDisconnected();
        }
        if (true) goto _L1; else goto _L5
_L5:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onWebSocketError();
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L7:
        bundle = bundle.getParcelableArrayList("data");
        Iterator iterator = mListeners.iterator();
        while (iterator.hasNext()) 
        {
            AppSessionListener appsessionlistener = (AppSessionListener)iterator.next();
            if (bundle != null)
            {
                appsessionlistener.onReceiveRTCMessage(bundle);
            }
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public String notifyNewPrivateMessage(long l, long l1)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("conversation_id", l);
        bundle.putLong("last_message_id", l1);
        return executeServiceAction(8, bundle);
    }

    public String reconnectChatService()
    {
        return executeServiceAction(2, createServiceBundle());
    }

    public void removeListener(AppSessionListener appsessionlistener)
    {
        mListeners.remove(appsessionlistener);
    }

    public String subscribeConversation(long l)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("conversation_id", l);
        return executeServiceAction(3, bundle);
    }

    public String updateTypingState(long l, boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("conversation_id", l);
        bundle.putBoolean("is_typing", flag);
        return executeServiceAction(7, bundle);
    }
}
