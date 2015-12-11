// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, SearchActivity

public class FindFriendsSearchFragment extends BaseControllerFragment
    implements android.view.View.OnClickListener
{

    public static final String ARG_LAYOUT = "layout";
    private StyleSpan mBold[];
    private int mLayoutRes;
    private Intent mSmsIntent;
    private View mView;

    public FindFriendsSearchFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mSmsIntent = new Intent("android.intent.action.VIEW");
        mSmsIntent.setType("vnd.android-dir/mms-sms");
        mSmsIntent.putExtra("sms_body", Util.getSmsMessage(getActivity()));
        if (mSmsIntent.resolveActivity(getActivity().getPackageManager()) == null)
        {
            mView.findViewById(0x7f0a00f3).setVisibility(8);
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362035: 
            FlurryUtils.trackInvite("sms", "FindFriends");
            startActivity(Intent.createChooser(mSmsIntent, getString(0x7f0e01be)));
            return;

        case 2131362036: 
            FlurryUtils.trackInvite("email", "FindFriends");
            view = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
            view.putExtra("android.intent.extra.SUBJECT", getString(0x7f0e00e6));
            view.putExtra("android.intent.extra.TEXT", Util.getEmailMessage(getActivity()));
            startActivity(Intent.createChooser(view, getString(0x7f0e00e4)));
            return;

        case 2131362034: 
            FlurryUtils.trackVisitSearch("FindFriends");
            startActivity(new Intent(getActivity(), co/vine/android/SearchActivity));
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mBold = (new StyleSpan[] {
            new StyleSpan(1)
        });
        mLayoutRes = getArguments().getInt("layout", 0);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(mLayoutRes, viewgroup, false);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00f2);
        viewgroup.setText(Util.getSpannedText(mBold, getString(0x7f0e00ea), '"'));
        viewgroup.setOnClickListener(this);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00f3);
        viewgroup.setText(Util.getSpannedText(mBold, getString(0x7f0e00eb), '"'));
        viewgroup.setOnClickListener(this);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00f4);
        viewgroup.setText(Util.getSpannedText(mBold, getString(0x7f0e00e9), '"'));
        viewgroup.setOnClickListener(this);
        mView = layoutinflater;
        return layoutinflater;
    }
}
