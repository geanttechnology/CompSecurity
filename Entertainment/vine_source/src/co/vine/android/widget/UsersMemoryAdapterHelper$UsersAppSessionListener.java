// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.BaseFragment;
import co.vine.android.Friendships;
import co.vine.android.PendingRequest;
import co.vine.android.PendingRequestHelper;
import co.vine.android.UsersMemoryAdapter;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.service.PendingAction;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android.widget:
//            UsersMemoryAdapterHelper

class this._cls0 extends AppSessionListener
{

    final UsersMemoryAdapterHelper this$0;

    public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
    {
        if (UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).removeRequest(s) != null)
        {
            UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).onCaptchaRequired(UsersMemoryAdapterHelper.access$500(UsersMemoryAdapterHelper.this).getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
        }
    }

    public void onFollowComplete(String s, int i, String s1, long l)
    {
        if (UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).removeRequest(s) != null && i != 200)
        {
            UsersMemoryAdapterHelper.access$400(UsersMemoryAdapterHelper.this).removeFollowing(l);
            UsersMemoryAdapterHelper.access$100(UsersMemoryAdapterHelper.this).notifyDataSetChanged();
        }
    }

    public void onGetUsersComplete(Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
            int l, long l1)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 200 200: default 24
    //                   200 36;
           goto _L1 _L2
_L1:
        UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).hideProgress(3);
_L4:
        return;
_L2:
        session = UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).removeRequest(s);
        if (session != null)
        {
            UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).hideProgress(((PendingRequest) (session)).fetchType);
            if (UsersMemoryAdapterHelper.access$100(UsersMemoryAdapterHelper.this) != null)
            {
                s = UsersMemoryAdapterHelper.access$100(UsersMemoryAdapterHelper.this);
                if (((PendingRequest) (session)).fetchType != 1)
                {
                    flag = false;
                }
                s.mergeData(arraylist, flag);
            }
            UsersMemoryAdapterHelper.access$202(UsersMemoryAdapterHelper.this, k);
            UsersMemoryAdapterHelper.access$302(UsersMemoryAdapterHelper.this, l1);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        if (UsersMemoryAdapterHelper.access$100(UsersMemoryAdapterHelper.this) != null)
        {
            UsersMemoryAdapterHelper.access$100(UsersMemoryAdapterHelper.this).setUserImages(hashmap);
        }
    }

    public void onUnFollowComplete(String s, int i, String s1, long l)
    {
        if (UsersMemoryAdapterHelper.access$000(UsersMemoryAdapterHelper.this).removeRequest(s) != null && i != 200)
        {
            UsersMemoryAdapterHelper.access$400(UsersMemoryAdapterHelper.this).addFollowing(l);
            UsersMemoryAdapterHelper.access$100(UsersMemoryAdapterHelper.this).notifyDataSetChanged();
        }
    }

    ()
    {
        this$0 = UsersMemoryAdapterHelper.this;
        super();
    }
}
