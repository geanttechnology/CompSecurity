// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.components;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavigationFragment extends Fragment
    implements android.view.View.OnClickListener
{
    public static interface OnNavigationListener
    {

        public abstract void onNavigationSelected(int i);
    }


    private View mButtonSelected;
    private OnNavigationListener mCallback;
    private ViewHolder mHolder;

    public NavigationFragment()
    {
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder();
        mHolder.profile = view.findViewById(0x7f0d019c);
        mHolder.justAdded = view.findViewById(0x7f0d019e);
        mHolder.features = view.findViewById(0x7f0d019f);
        mHolder.singles = view.findViewById(0x7f0d01a0);
        mHolder.library = view.findViewById(0x7f0d01a1);
        mHolder.profile.setTag(Integer.valueOf(0));
        mHolder.justAdded.setTag(Integer.valueOf(1));
        mHolder.features.setTag(Integer.valueOf(2));
        mHolder.singles.setTag(Integer.valueOf(3));
        mHolder.library.setTag(Integer.valueOf(4));
        mHolder.profile.setOnClickListener(this);
        mHolder.justAdded.setOnClickListener(this);
        mHolder.features.setOnClickListener(this);
        mHolder.singles.setOnClickListener(this);
        mHolder.library.setOnClickListener(this);
        mButtonSelected = mHolder.features;
    }

    private void setNavigationButtonSelected(boolean flag)
    {
        View view = mButtonSelected;
        int i;
        if (flag)
        {
            i = getResources().getColor(0x7f0c0020);
        } else
        {
            i = 0;
        }
        view.setBackgroundColor(i);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mCallback = (OnNavigationListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnNavigationSelectedListener").toString());
        }
    }

    public void onClick(View view)
    {
        if (view != mButtonSelected)
        {
            mCallback.onNavigationSelected(((Integer)view.getTag()).intValue());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030043, viewgroup, false);
        initView(layoutinflater);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mCallback = null;
    }

    public void setNavigationSelected(int i)
    {
        setNavigationButtonSelected(false);
        i;
        JVM INSTR tableswitch 0 4: default 40
    //                   0 46
    //                   1 60
    //                   2 74
    //                   3 88
    //                   4 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        setNavigationButtonSelected(true);
        return;
_L2:
        mButtonSelected = mHolder.profile;
        continue; /* Loop/switch isn't completed */
_L3:
        mButtonSelected = mHolder.justAdded;
        continue; /* Loop/switch isn't completed */
_L4:
        mButtonSelected = mHolder.features;
        continue; /* Loop/switch isn't completed */
_L5:
        mButtonSelected = mHolder.singles;
        continue; /* Loop/switch isn't completed */
_L6:
        mButtonSelected = mHolder.library;
        if (true) goto _L1; else goto _L7
_L7:
    }
}
