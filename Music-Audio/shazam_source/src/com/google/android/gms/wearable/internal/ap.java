// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.e;
import java.util.List;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            ChannelEventParcelable, AmsEntityUpdateParcelable, AncsNotificationParcelable, CapabilityInfoParcelable, 
//            MessageEventParcelable, NodeParcelable

final class ap extends w.a
{

    final IntentFilter a[];
    final String b = null;
    final String c = null;
    private com.google.android.gms.wearable.q.a d;
    private com.google.android.gms.wearable.r.a e;
    private com.google.android.gms.wearable.c.b f;
    private com.google.android.gms.wearable.j.a g;
    private com.google.android.gms.wearable.m.b h;
    private com.google.android.gms.wearable.m.c i;
    private com.google.android.gms.wearable.b.a j;
    private com.google.android.gms.wearable.a.a k;

    private ap(com.google.android.gms.wearable.c.b b1, IntentFilter aintentfilter[])
    {
        d = null;
        e = null;
        f = b1;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        a = aintentfilter;
    }

    public static ap a(com.google.android.gms.wearable.c.b b1, IntentFilter aintentfilter[])
    {
        return new ap((com.google.android.gms.wearable.c.b)w.a(b1), aintentfilter);
    }

    public final void a()
    {
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
    }

    public final void a(DataHolder dataholder)
    {
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        f.a(new e(dataholder));
        dataholder.b();
        return;
        Exception exception;
        exception;
        dataholder.b();
        throw exception;
        dataholder.b();
        return;
    }

    public final void a(AmsEntityUpdateParcelable amsentityupdateparcelable)
    {
    }

    public final void a(AncsNotificationParcelable ancsnotificationparcelable)
    {
    }

    public final void a(CapabilityInfoParcelable capabilityinfoparcelable)
    {
    }

    public final void a(ChannelEventParcelable channeleventparcelable)
    {
        if (j != null)
        {
            channeleventparcelable.a();
        }
    }

    public final void a(MessageEventParcelable messageeventparcelable)
    {
        if (g != null)
        {
            g.a(messageeventparcelable);
        }
    }

    public final void a(NodeParcelable nodeparcelable)
    {
    }

    public final void a(List list)
    {
    }

    public final void b(NodeParcelable nodeparcelable)
    {
    }
}
