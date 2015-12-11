// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.Context;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentNameViewHolder, DepartmentNameViewModel

public class DepartmentNamesAdapter extends RecyclerContentAdapter
{

    public static final int VIEW_TYPE_DEPARTMENT_NAME = 0;
    private int currentPosition;

    public DepartmentNamesAdapter(Context context, List list, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(context);
        addViewType(0, com/ebay/mobile/home/departments/DepartmentNameViewHolder, 0x7f0300ea);
        if (list != null && !list.isEmpty())
        {
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                dataSet.add(new DepartmentNameViewModel(0, (Channel)list.get(i), i, j, onclicklistener));
            }

            setCurrentPosition(0);
        }
    }

    public int getItemCount()
    {
        return dataSet.size();
    }

    public void setArrowEnabled(int i, boolean flag)
    {
        if (i >= 0 && i < dataSet.size())
        {
            DepartmentNameViewModel departmentnameviewmodel = (DepartmentNameViewModel)dataSet.get(i);
            if (departmentnameviewmodel != null)
            {
                departmentnameviewmodel.hasDisclosureArrow = flag;
                notifyItemChanged(i);
            }
        }
    }

    public void setCurrentPosition(int i)
    {
        if (i >= 0 && i < dataSet.size())
        {
            DepartmentNameViewModel departmentnameviewmodel = (DepartmentNameViewModel)dataSet.get(i);
            if (departmentnameviewmodel != null)
            {
                departmentnameviewmodel.isSelected = true;
                notifyItemChanged(i);
            }
            if (currentPosition >= 0 && currentPosition < dataSet.size() && currentPosition != i)
            {
                DepartmentNameViewModel departmentnameviewmodel1 = (DepartmentNameViewModel)dataSet.get(currentPosition);
                if (departmentnameviewmodel1 != null)
                {
                    departmentnameviewmodel1.isSelected = false;
                    notifyItemChanged(currentPosition);
                }
            }
            currentPosition = i;
        }
    }
}
