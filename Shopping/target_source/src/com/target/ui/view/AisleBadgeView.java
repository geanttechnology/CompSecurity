// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.google.a.a.e;
import com.pointinside.maps.Location;
import com.target.mothership.util.o;
import com.target.ui.util.f.a;

// Referenced classes of package com.target.ui.view:
//            DepartmentBadgeView

public class AisleBadgeView extends DepartmentBadgeView
{

    private String mAisle;
    private String mUnknownDepartmentString;

    public AisleBadgeView(Context context)
    {
        super(context);
        c();
    }

    public AisleBadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public AisleBadgeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    private void c()
    {
        mUnknownDepartmentString = getResources().getString(0x7f0902ec);
    }

    private String getUnknownDepartmentString()
    {
        return mUnknownDepartmentString;
    }

    public boolean a()
    {
        return getUnknownDepartmentString().equals(mAisle);
    }

    public String getBadgeContentDescription()
    {
        if (mAisle == null || getDepartment() == DepartmentBadgeView.a.UNKNOWN)
        {
            return super.getBadgeContentDescription();
        } else
        {
            return getResources().getString(0x7f090146, new Object[] {
                mAisle
            });
        }
    }

    public String getTextOverlay()
    {
        return mAisle;
    }

    public void setAisle(String s)
    {
        mAisle = s;
        if (o.g(s))
        {
            setBadgeInformation(null);
            return;
        } else
        {
            b();
            return;
        }
    }

    public void setBadgeInformation(DepartmentBadgeView.a a1)
    {
        if (a1 != null)
        {
            if (a1 == DepartmentBadgeView.a.UNKNOWN)
            {
                mAisle = getUnknownDepartmentString();
            } else
            {
                mAisle = null;
            }
        }
        super.setBadgeInformation(a1);
    }

    public void setLocation(Location location)
    {
        e e1 = com.target.ui.util.f.a.b(location);
        if (e1.b())
        {
            setAisle((String)e1.c());
            return;
        } else
        {
            setDepartment(com.target.ui.util.f.a.c(location));
            return;
        }
    }
}
