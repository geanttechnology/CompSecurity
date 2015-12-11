// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.content.Context;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphPlace;

// Referenced classes of package com.facebook.widget:
//            PlacePickerFragment

class ragmentAdapter extends ragmentAdapter
{

    final PlacePickerFragment this$0;

    protected int getDefaultPicture()
    {
        return 0x7f020094;
    }

    protected volatile int getGraphObjectRowLayoutId(GraphObject graphobject)
    {
        return getGraphObjectRowLayoutId((GraphPlace)graphobject);
    }

    protected int getGraphObjectRowLayoutId(GraphPlace graphplace)
    {
        return 0x7f030038;
    }

    protected volatile CharSequence getSubTitleOfGraphObject(GraphObject graphobject)
    {
        return getSubTitleOfGraphObject((GraphPlace)graphobject);
    }

    protected CharSequence getSubTitleOfGraphObject(GraphPlace graphplace)
    {
        String s = graphplace.getCategory();
        Integer integer = (Integer)graphplace.getProperty("were_here_count");
        Object obj = null;
        if (s != null && integer != null)
        {
            graphplace = getString(0x7f0b0054, new Object[] {
                s, integer
            });
        } else
        {
            if (s == null && integer != null)
            {
                return getString(0x7f0b0056, new Object[] {
                    integer
                });
            }
            graphplace = obj;
            if (s != null)
            {
                graphplace = obj;
                if (integer == null)
                {
                    return getString(0x7f0b0055, new Object[] {
                        s
                    });
                }
            }
        }
        return graphplace;
    }

    ragmentAdapter(Context context)
    {
        this$0 = PlacePickerFragment.this;
        super(PlacePickerFragment.this, context);
    }
}
