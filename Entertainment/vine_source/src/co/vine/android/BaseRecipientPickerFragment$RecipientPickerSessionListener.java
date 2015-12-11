// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.TextUtils;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseRecipientPickerFragment, PendingRequest, FriendsPickerAdapter

private class <init> extends AppSessionListener
{

    final BaseRecipientPickerFragment this$0;

    public void onGetFriendsTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
        BaseRecipientPickerFragment.this.onGetFriendsTypeAheadComplete(s2, arraylist);
    }

    public void onGetUsersComplete(Session session, String s, int i, String s1, int j, ArrayList arraylist, int k, 
            int l, long l1)
    {
        session = removeRequest(s);
        if (session != null)
        {
            onGetFriendsComplete(i);
            hideProgress(((PendingRequest) (session)).fetchType);
            switch (i)
            {
            default:
                hideProgress(3);
                if (!TextUtils.isEmpty(s1))
                {
                    Util.showCenteredToast(getActivity(), s1);
                }
                break;

            case 200: 
                break;
            }
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        if (mCursorAdapter instanceof FriendsPickerAdapter)
        {
            ((FriendsPickerAdapter)mCursorAdapter).setUserImages(hashmap);
        }
    }

    private ()
    {
        this$0 = BaseRecipientPickerFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
