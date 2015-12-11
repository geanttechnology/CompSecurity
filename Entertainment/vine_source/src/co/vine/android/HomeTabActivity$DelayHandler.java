// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import co.vine.android.client.AppController;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            HomeTabActivity

public static final class  extends Handler
{

    public static final int DETERMINE_SERVER_STATUS = 3;
    public static final int FETCH_FOLLOWERS = 2;
    public static final int FETCH_ME = 1;
    public static final int SEND_LOOP_COUNTS = 4;
    private final WeakReference mContextRef;

    public void handleMessage(Message message)
    {
        Object obj = (Context)mContextRef.get();
        if (obj == null)
        {
            return;
        }
        obj = AppController.getInstance(((Context) (obj)));
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            ((AppController) (obj)).fetchUsersMe(((AppController) (obj)).getActiveId());
            return;

        case 2: // '\002'
            ((AppController) (obj)).fetchFollowing(((AppController) (obj)).getActiveId(), 1, 0L);
            return;

        case 3: // '\003'
            ((AppController) (obj)).determineServerStatus();
            return;

        case 4: // '\004'
            ((AppController) (obj)).sendLoopCounts();
            break;
        }
    }

    public (Context context)
    {
        mContextRef = new WeakReference(context.getApplicationContext());
    }
}
