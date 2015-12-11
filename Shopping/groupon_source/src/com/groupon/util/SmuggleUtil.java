// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Intent;
import com.groupon.Channel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import roboguice.util.Strings;

public class SmuggleUtil
{

    public static final String DEALS_TO_BE_SMUGGLED_IN = "deals_to_be_smuggled_in";
    public static final String NEW_SMUGGLED_DEALS_EXTRA = "NEW_SMUGGLED_DEALS_EXTRA";

    public SmuggleUtil()
    {
    }

    public void addDealIdsToBeSmuggledToNameValuesList(List list, Set set)
    {
        if (!set.isEmpty())
        {
            list.addAll(Arrays.asList(new String[] {
                "deals_to_be_smuggled_in", Strings.join(",", set)
            }));
        }
    }

    public void addDealsToBeSmuggledToIntent(Intent intent, Channel channel, List list)
    {
        intent.putStringArrayListExtra(Channel.channelDealIdsExtraKey(channel.name()), new ArrayList(list));
    }

    public ArrayList getDealsToBeSmuggledFromIntent(Intent intent, Channel channel)
    {
        return intent.getStringArrayListExtra(Channel.channelDealIdsExtraKey(channel.name()));
    }
}
