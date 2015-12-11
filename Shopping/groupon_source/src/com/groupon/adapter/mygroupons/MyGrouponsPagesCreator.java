// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.mygroupons;

import android.app.Fragment;
import android.content.Context;
import com.groupon.MyGrouponsTabs;
import com.groupon.fragment.mygroupons.AllMyGrouponsFragment;
import com.groupon.fragment.mygroupons.MyAvailableGrouponsFragment;
import com.groupon.fragment.mygroupons.MyExpiringGrouponsFragment;
import com.groupon.fragment.mygroupons.MyNearbyGrouponsFragment;
import com.groupon.models.MyGrouponsPage;
import java.util.ArrayList;
import java.util.List;

public class MyGrouponsPagesCreator
{

    private Context context;
    private List myGrouponsPages;

    public MyGrouponsPagesCreator(Context context1)
    {
        context = context1;
    }

    private MyGrouponsPage createPage(MyGrouponsTabs mygrouponstabs)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$MyGrouponsTabs[];

            static 
            {
                $SwitchMap$com$groupon$MyGrouponsTabs = new int[MyGrouponsTabs.values().length];
                try
                {
                    $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.AVAILABLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.EXPIRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.NEARBY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$MyGrouponsTabs[MyGrouponsTabs.ALL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.groupon.MyGrouponsTabs[mygrouponstabs.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("MyGrouponsPagesCreator: ").append(mygrouponstabs).append(" groupon category not found").toString());

        case 1: // '\001'
            return new MyGrouponsPage(mygrouponstabs, Fragment.instantiate(context, com/groupon/fragment/mygroupons/MyAvailableGrouponsFragment.getName()), context.getString(0x7f08006b));

        case 2: // '\002'
            return new MyGrouponsPage(mygrouponstabs, Fragment.instantiate(context, com/groupon/fragment/mygroupons/MyExpiringGrouponsFragment.getName()), context.getString(0x7f0801af));

        case 3: // '\003'
            return new MyGrouponsPage(mygrouponstabs, Fragment.instantiate(context, com/groupon/fragment/mygroupons/MyNearbyGrouponsFragment.getName()), context.getString(0x7f080288));

        case 4: // '\004'
            return new MyGrouponsPage(mygrouponstabs, Fragment.instantiate(context, com/groupon/fragment/mygroupons/AllMyGrouponsFragment.getName()), context.getString(0x7f080202));
        }
    }

    public void createPages()
    {
        myGrouponsPages = new ArrayList(MyGrouponsTabs.values().length);
        MyGrouponsTabs amygrouponstabs[] = MyGrouponsTabs.values();
        int j = amygrouponstabs.length;
        for (int i = 0; i < j; i++)
        {
            MyGrouponsTabs mygrouponstabs = amygrouponstabs[i];
            myGrouponsPages.add(createPage(mygrouponstabs));
        }

    }

    public List getMyGrouponsPages()
    {
        return myGrouponsPages;
    }
}
