// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.e;

import com.shazam.android.activities.streaming.e;
import com.shazam.android.persistence.n.b;
import com.shazam.model.availability.AppAvailability;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.streaming.PlaybackProviderUpsellAction;
import com.shazam.model.streaming.PlaybackProviderUpsellStrategy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
    implements PlaybackProviderUpsellStrategy
{

    private final Map a;
    private final e b;
    private final b c;

    public a(Map map, e e1, b b1)
    {
        a = map;
        b = e1;
        c = b1;
    }

    public final PlaybackProviderUpsellAction a()
    {
        HashSet hashset = new HashSet();
        boolean flag;
        if (b.a() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (!c.b("pk_provider_upsell_shown"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Iterator iterator = a.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    PlaybackProvider playbackprovider = (PlaybackProvider)entry.getKey();
                    if (((AppAvailability)entry.getValue()).b())
                    {
                        hashset.add(playbackprovider);
                    }
                } while (true);
            }
        }
        com.shazam.model.streaming.PlaybackProviderUpsellAction.Builder builder = com.shazam.model.streaming.PlaybackProviderUpsellAction.Builder.a();
        builder.playbackProviders.clear();
        builder.playbackProviders.addAll(hashset);
        boolean flag1;
        if (!hashset.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        builder.shouldUpsell = flag1;
        return new PlaybackProviderUpsellAction(builder, null);
    }
}
