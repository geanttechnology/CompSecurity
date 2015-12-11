// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package co.vine.android:
//            ProfileHeaderAdapter

private class <init> extends PagerAdapter
{

    public static final int PAGER_COUNT = 2;
    public static final int PAGER_INDEX_DETAILS = 1;
    public static final int PAGER_INDEX_MAIN = 0;
    final ProfileHeaderAdapter this$0;

    public int getCount()
    {
        return 2;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        Object obj = (LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater");
        i;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 40
    //                   1 98;
           goto _L1 _L2 _L3
_L1:
        viewgroup = null;
_L5:
        return viewgroup;
_L2:
        obj = ((LayoutInflater) (obj)).inflate(0x7f030078, viewgroup, false);
        ProfileHeaderAdapter.access$102(ProfileHeaderAdapter.this, new t>(((View) (obj))));
        viewgroup.addView(((View) (obj)));
        viewgroup = ((ViewGroup) (obj));
        if (ProfileHeaderAdapter.access$200(ProfileHeaderAdapter.this) == null) goto _L5; else goto _L4
_L4:
        bindUser(ProfileHeaderAdapter.access$200(ProfileHeaderAdapter.this));
        return obj;
_L3:
        obj = ((LayoutInflater) (obj)).inflate(0x7f030077, viewgroup, false);
        ProfileHeaderAdapter.access$302(ProfileHeaderAdapter.this, new init>(((View) (obj))));
        viewgroup.addView(((View) (obj)));
        if (ProfileHeaderAdapter.access$200(ProfileHeaderAdapter.this) != null)
        {
            bindUser(ProfileHeaderAdapter.access$200(ProfileHeaderAdapter.this));
        }
        ProfileHeaderAdapter.access$400(ProfileHeaderAdapter.this);
        return obj;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    private ()
    {
        this$0 = ProfileHeaderAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
