// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.Onboarding;

public class MyFragment extends Fragment
{

    int mNum;

    public MyFragment()
    {
    }

    public static MyFragment newInstance(int i)
    {
        MyFragment myfragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("num", i);
        myfragment.setArguments(bundle);
        return myfragment;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i;
        if (getArguments() != null)
        {
            i = getArguments().getInt("num");
        } else
        {
            i = 1;
        }
        mNum = i;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mNum == 0)
        {
            layoutinflater = layoutinflater.inflate(0x7f030030, viewgroup, false);
            viewgroup = (TextView)layoutinflater.findViewById(0x7f070075);
            layoutinflater.findViewById(0x7f070074);
            viewgroup.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Roboto-Regular.ttf"));
            ((Onboarding)getActivity()).ivS1 = (ImageView)layoutinflater.findViewById(0x7f070076);
            ((Onboarding)getActivity()).ivS2 = (ImageView)layoutinflater.findViewById(0x7f070078);
            ((Onboarding)getActivity()).ivS3 = (ImageView)layoutinflater.findViewById(0x7f07007a);
            return layoutinflater;
        }
        if (mNum == 2)
        {
            layoutinflater = layoutinflater.inflate(0x7f030031, viewgroup, false);
            viewgroup = (TextView)layoutinflater.findViewById(0x7f070075);
            layoutinflater.findViewById(0x7f070074);
            viewgroup.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Roboto-Regular.ttf"));
            ((Button)layoutinflater.findViewById(0x7f070073)).setOnClickListener(new _cls1());
            return layoutinflater;
        } else
        {
            layoutinflater = layoutinflater.inflate(0x7f030032, viewgroup, false);
            viewgroup = (TextView)layoutinflater.findViewById(0x7f070075);
            layoutinflater.findViewById(0x7f070074);
            viewgroup.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Roboto-Regular.ttf"));
            return layoutinflater;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (!((Onboarding)getActivity()).hasInit)
        {
            ((Onboarding)getActivity()).initAnim();
        }
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final MyFragment this$0;

        public void onClick(View view)
        {
            ((Onboarding)getActivity()).goToMainPage();
        }

        _cls1()
        {
            this$0 = MyFragment.this;
            super();
        }
    }

}
