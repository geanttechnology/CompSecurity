// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            PersistentHitStore, Hit, Log, Clock

class this._cls0
    implements this._cls0
{

    final PersistentHitStore this$0;

    public void onHitDispatched(Hit hit)
    {
        PersistentHitStore.access$000(PersistentHitStore.this, hit.getHitId());
    }

    public void onHitPermanentDispatchFailure(Hit hit)
    {
        PersistentHitStore.access$000(PersistentHitStore.this, hit.getHitId());
        Log.v((new StringBuilder()).append("Permanent failure dispatching hitId: ").append(hit.getHitId()).toString());
    }

    public void onHitTransientDispatchFailure(Hit hit)
    {
        long l = hit.getHitFirstDispatchTime();
        if (l == 0L)
        {
            PersistentHitStore.access$200(PersistentHitStore.this, hit.getHitId(), PersistentHitStore.access$100(PersistentHitStore.this).currentTimeMillis());
        } else
        if (0xdbba00L + l < PersistentHitStore.access$100(PersistentHitStore.this).currentTimeMillis())
        {
            PersistentHitStore.access$000(PersistentHitStore.this, hit.getHitId());
            Log.v((new StringBuilder()).append("Giving up on failed hitId: ").append(hit.getHitId()).toString());
            return;
        }
    }

    ()
    {
        this$0 = PersistentHitStore.this;
        super();
    }
}
