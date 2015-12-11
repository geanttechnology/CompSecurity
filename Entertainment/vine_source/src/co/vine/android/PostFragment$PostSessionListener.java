// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.text.TextUtils;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.provider.VineSuggestionsProvider;
import co.vine.android.util.Util;
import co.vine.android.views.SwitchInterface;
import co.vine.android.widget.PopupEditText;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            PostFragment, UsersAutoCompleteAdapter

class this._cls0 extends AppSessionListener
{

    final PostFragment this$0;

    public void onConnectFacebookComplete(String s, int i, String s1)
    {
        if (PostFragment.access$000(PostFragment.this) != null)
        {
            PostFragment.access$000(PostFragment.this).dismiss();
        }
        if (i != 200)
        {
            Util.showCenteredToast(getActivity(), 0x7f0e00ca);
            PostFragment.access$100(PostFragment.this).setChecked(false);
        }
    }

    public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
    {
        if (i == 200)
        {
            if (l > 0L && !TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
            {
                VineAccountHelper.saveTwitterInfo(getActivity(), mAppController.getActiveSession().getLoginEmail(), s2, s3, s4, l);
                PostFragment.access$200(PostFragment.this).setChecked(true);
            }
            return;
        } else
        {
            Util.showCenteredToast(getActivity(), s1);
            PostFragment.access$200(PostFragment.this).setChecked(false);
            return;
        }
    }

    public void onGetTagTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
        if (i == 200 && !arraylist.isEmpty())
        {
            VineSuggestionsProvider.addRealtimeTagSuggestions(s2, arraylist);
            PostFragment.access$300(PostFragment.this).performFilter(false);
        }
    }

    public void onGetUserTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
    {
        if (i == 200 && !arraylist.isEmpty())
        {
            VineSuggestionsProvider.addRealtimeUserSuggestions(s2, arraylist);
            PostFragment.access$300(PostFragment.this).performFilter(false);
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        super.onPhotoImageLoaded(hashmap);
        PostFragment.access$400(PostFragment.this).setUserImages(hashmap);
    }

    ()
    {
        this$0 = PostFragment.this;
        super();
    }
}
