// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

// Referenced classes of package co.vine.android:
//            ProfileFragment

class priv extends BaseAdapter
{

    boolean blocked;
    boolean priv;
    final ProfileFragment this$0;

    public int getCount()
    {
        return 1;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (blocked)
        {
            return LayoutInflater.from(getActivity()).inflate(0x7f030074, viewgroup, false);
        } else
        {
            return LayoutInflater.from(getActivity()).inflate(0x7f030079, viewgroup, false);
        }
    }

    public (boolean flag, boolean flag1)
    {
        this$0 = ProfileFragment.this;
        super();
        blocked = flag;
        priv = flag1;
    }
}
