// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            InboxFragment, ConversationActivity, PendingRequest

public class this._cls0 extends AppSessionListener
{

    final InboxFragment this$0;

    public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
    {
        if (l == mWaitingToStartId)
        {
            mWaitingToStartId = -1L;
            mAppController.clearUnreadMessageCount(l1);
            startActivity(ConversationActivity.getIntent(getActivity(), l1, s, l, flag, false));
        }
    }

    public void onGetMessageInboxComplete(String s, int i, String s1, int j)
    {
        s = removeRequest(s);
        if (s != null)
        {
            InboxFragment.access$1402(InboxFragment.this, false);
            hideProgress(((PendingRequest) (s)).fetchType);
            InboxFragment.this.onGetMessageInboxComplete(j);
            switch (i)
            {
            default:
                hideProgress(3);
                if (((PendingRequest) (s)).fetchType != 3)
                {
                    Util.showCenteredToast(getActivity(), 0x7f0e00cb);
                }
                SLog.e((new StringBuilder()).append("Error ").append(i).append(" - ").append(s1).toString());
                break;

            case 200: 
                break;
            }
        }
    }

    public void onGetUsersComplete(Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
            int l, long l1)
    {
        session = removeRequest(s);
        if (session != null)
        {
            hideProgress(((PendingRequest) (session)).fetchType);
            switch (i)
            {
            default:
                hideProgress(3);
                SLog.e((new StringBuilder()).append("Error:  ").append(s1).toString());
                break;

            case 200: 
                break;
            }
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        InboxFragment.this.onPhotoImageLoaded(hashmap);
    }

    public ()
    {
        this$0 = InboxFragment.this;
        super();
    }
}
