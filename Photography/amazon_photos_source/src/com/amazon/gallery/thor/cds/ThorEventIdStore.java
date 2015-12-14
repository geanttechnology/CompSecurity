// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.mixtape.metadata.processing.EventIdStore;

public class ThorEventIdStore
    implements EventIdStore
{

    private final Context mContext;

    public ThorEventIdStore(Context context)
    {
        mContext = context;
    }

    private SharedPreferences getEventIdStoreForAccount(String s)
    {
        return mContext.getSharedPreferences((new StringBuilder()).append("event_id_shared_pref.").append(s).toString(), 0);
    }

    public com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange getEventIdRange(String s)
    {
        s = getEventIdStoreForAccount(s);
        return new com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange(s.getLong("lower_event_id", 0L), s.getLong("upper_event_id", 0L), s.getLong("max_event_id", 0L));
    }

    public void updateEventIdRange(String s, com.amazon.mixtape.metadata.processing.EventIdStore.EventIdRange eventidrange)
    {
        getEventIdStoreForAccount(s).edit().putLong("lower_event_id", eventidrange.lowerEventId).putLong("upper_event_id", eventidrange.upperEventId).putLong("max_event_id", eventidrange.maximumEventId).apply();
    }
}
