// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.Toast;
import co.vine.android.client.AppSessionListener;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            NotificationSettingsFragment

public class this._cls0 extends AppSessionListener
{

    final NotificationSettingsFragment this$0;

    public void onGetNotificationSettingsComplete(String s, ArrayList arraylist)
    {
label0:
        {
            NotificationSettingsFragment.access$002(NotificationSettingsFragment.this, true);
            if (removeRequest(s) != null)
            {
                if (arraylist == null)
                {
                    break label0;
                }
                mAdapter = new init>(NotificationSettingsFragment.this, getActivity(), arraylist);
                mListView.setAdapter(mAdapter);
                NotificationSettingsFragment.access$102(NotificationSettingsFragment.this, true);
                getActivity().invalidateOptionsMenu();
            }
            return;
        }
        showSadface(true);
        NotificationSettingsFragment.access$102(NotificationSettingsFragment.this, false);
    }

    public void onSaveNotificationSettingsComplete(String s, int i, String s1)
    {
        if (i != 200)
        {
            if (TextUtils.isEmpty(s1))
            {
                Toast.makeText(getActivity(), 0x7f0e00cb, 1).show();
                return;
            } else
            {
                Toast.makeText(getActivity(), s1, 1).show();
                return;
            }
        } else
        {
            getActivity().finish();
            return;
        }
    }

    public ()
    {
        this$0 = NotificationSettingsFragment.this;
        super();
    }
}
