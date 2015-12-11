// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import co.vine.android.api.VineNotificationSetting;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            NotificationSettingsFragment

public class mContext extends BaseAdapter
    implements SpinnerAdapter, android.widget.
{

    private Context mContext;
    private VineNotificationSetting mSetting;
    final NotificationSettingsFragment this$0;

    public int getCount()
    {
        return mSetting.choices.size();
    }

    public Object getItem(int i)
    {
        return mSetting.choices.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (Pair)mSetting.choices.get(i);
        TextView textview;
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f030092, null);
        }
        textview = (TextView)view.findViewById(0x7f0a004a);
        textview.setText((CharSequence)((Pair) (viewgroup)).first);
        textview.setSingleLine(false);
        view.invalidate();
        return view;
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        mSetting.value = (String)((Pair)mSetting.choices.get(i)).second;
        adapterview.setSelection(i);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public (Context context, VineNotificationSetting vinenotificationsetting)
    {
        this$0 = NotificationSettingsFragment.this;
        super();
        mSetting = vinenotificationsetting;
        mContext = context;
    }
}
