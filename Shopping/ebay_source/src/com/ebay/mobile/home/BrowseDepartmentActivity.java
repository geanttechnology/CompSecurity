// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            BrowseDepartmentFragment

public abstract class BrowseDepartmentActivity extends BaseActivity
{

    protected String browseType;
    protected String departmentId;
    private String departmentTitle;
    protected String topLevelChannel;

    public BrowseDepartmentActivity()
    {
    }

    public BrowseDepartmentFragment createBrowseDepartmentFragment()
    {
        return new BrowseDepartmentFragment();
    }

    public abstract RecyclerContentAdapter getChannelContentAdapter(Boolean boolean1);

    public abstract ContentSourceEnum getContentSourceEnum(String s);

    public List getContextValues()
    {
        return null;
    }

    public String getSubDepartmentTitle(String s, String s1)
    {
        return s1;
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        setContentView(0x7f0300b2);
        obj = getIntent();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        topLevelChannel = bundle.getString("top_level_channel");
        browseType = bundle.getString("browse_type", ChannelEnum.DEPARTMENT.name());
        departmentId = bundle.getString("department_id");
        departmentTitle = bundle.getString("department_title");
_L4:
        if ((BrowseDepartmentFragment)getFragmentManager().findFragmentById(0x7f1001c9) == null)
        {
            bundle = createBrowseDepartmentFragment();
            obj = new Bundle();
            if (!TextUtils.isEmpty(topLevelChannel))
            {
                ((Bundle) (obj)).putString("top_level_channel", topLevelChannel);
            }
            if (!TextUtils.isEmpty(browseType))
            {
                ((Bundle) (obj)).putString("browse_type", browseType);
            }
            if (!TextUtils.isEmpty(departmentId))
            {
                ((Bundle) (obj)).putString("department_id", departmentId);
            }
            if (!TextUtils.isEmpty(departmentId))
            {
                ((Bundle) (obj)).putString("department_title", departmentTitle);
            }
            bundle.setArguments(((Bundle) (obj)));
            getFragmentManager().beginTransaction().add(0x7f1001c9, bundle).commit();
        }
        return;
_L2:
        if (obj != null)
        {
            topLevelChannel = ((Intent) (obj)).getStringExtra("top_level_channel");
            browseType = ((Intent) (obj)).getStringExtra("browse_type");
            departmentId = ((Intent) (obj)).getStringExtra("department_id");
            departmentTitle = ((Intent) (obj)).getStringExtra("department_title");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public abstract void sendTracking(String s, Contents contents);
}
