// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.text.TextUtils;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            ContentControlsFragment

class this._cls0 extends AppSessionListener
{

    final ContentControlsFragment this$0;

    public void onUpdateExplicitComplete(String s, int i, String s1, boolean flag)
    {
        if (ContentControlsFragment.access$000(ContentControlsFragment.this) != null)
        {
            ContentControlsFragment.access$000(ContentControlsFragment.this).dismiss();
        }
        s = getActivity();
        if (i == 200)
        {
            s = Util.getDefaultSharedPrefs(getActivity()).edit();
            s._mth0("settings_explicit", flag);
            s._mth0();
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, s1);
            return;
        } else
        {
            Util.showCenteredToast(s, 0x7f0e00a1);
            return;
        }
    }

    public void onUpdatePrivateComplete(String s, int i, String s1, boolean flag)
    {
        if (ContentControlsFragment.access$000(ContentControlsFragment.this) != null)
        {
            ContentControlsFragment.access$000(ContentControlsFragment.this).dismiss();
        }
        s = getActivity();
        if (i == 200)
        {
            s = Util.getDefaultSharedPrefs(s).edit();
            s._mth0("settings_private", flag);
            s._mth0();
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, s1);
            return;
        } else
        {
            Util.showCenteredToast(s, 0x7f0e00a1);
            return;
        }
    }

    ()
    {
        this$0 = ContentControlsFragment.this;
        super();
    }
}
