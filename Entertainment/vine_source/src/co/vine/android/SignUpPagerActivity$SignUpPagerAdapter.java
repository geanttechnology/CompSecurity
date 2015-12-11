// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            SignUpPagerActivity, SignUpNameAvatarFragment, SignUpDetailsFragment

private class  extends FragmentStatePagerAdapter
{

    final SignUpPagerActivity this$0;

    public int getCount()
    {
        return 2;
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("no pager found for ").append(i).toString());

        case 0: // '\0'
            SignUpNameAvatarFragment signupnameavatarfragment = new SignUpNameAvatarFragment();
            if (SignUpPagerActivity.access$000(SignUpPagerActivity.this) != null)
            {
                signupnameavatarfragment.setArguments(getIntent().getExtras());
            }
            SignUpPagerActivity.access$102(SignUpPagerActivity.this, new WeakReference(signupnameavatarfragment));
            return signupnameavatarfragment;

        case 1: // '\001'
            SignUpDetailsFragment signupdetailsfragment = new SignUpDetailsFragment();
            SignUpPagerActivity.access$202(SignUpPagerActivity.this, new WeakReference(signupdetailsfragment));
            return signupdetailsfragment;
        }
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = SignUpPagerActivity.this;
        super(fragmentmanager);
    }
}
