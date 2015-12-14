// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.android.bitmapfun.util.ImageDetailActivity;
import com.example.android.bitmapfun.util.ImageDetailFragment;
import java.util.ArrayList;

public class gq extends FragmentStatePagerAdapter
{

    final ImageDetailActivity a;

    public gq(ImageDetailActivity imagedetailactivity, FragmentManager fragmentmanager)
    {
        a = imagedetailactivity;
        super(fragmentmanager);
    }

    public int getCount()
    {
        return ImageDetailActivity.a(a).size();
    }

    public Fragment getItem(int i)
    {
        return ImageDetailFragment.a((String)ImageDetailActivity.a(a).get(i));
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }
}
