// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.adapter;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package commonlib.adapter:
//            JavaAdapter

public abstract class JavaListAdapter extends BaseAdapter
    implements JavaAdapter
{

    protected List list;

    public JavaListAdapter()
    {
        list = Collections.EMPTY_LIST;
    }

    public JavaListAdapter(List list1)
    {
        list = list1;
    }

    public int getCount()
    {
        return list.size();
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public List getListCopy()
    {
        return new ArrayList(list);
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
