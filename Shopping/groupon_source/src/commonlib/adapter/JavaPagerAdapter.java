// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package commonlib.adapter:
//            JavaAdapter

public class JavaPagerAdapter extends PagerAdapter
    implements JavaAdapter
{

    protected List list;

    public JavaPagerAdapter()
    {
        list = Collections.EMPTY_LIST;
    }

    public JavaPagerAdapter(List list1)
    {
        list = list1;
    }

    public int getCount()
    {
        return list.size();
    }

    public List getListCopy()
    {
        return new ArrayList(list);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void setList(List list1)
    {
        setList(list1, true);
    }

    public void setList(List list1, boolean flag)
    {
        list = list1;
        if (flag)
        {
            notifyDataSetChanged();
        }
    }
}
