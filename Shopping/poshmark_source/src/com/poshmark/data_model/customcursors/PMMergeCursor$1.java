// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.customcursors;

import android.database.DataSetObserver;

// Referenced classes of package com.poshmark.data_model.customcursors:
//            PMMergeCursor

class this._cls0 extends DataSetObserver
{

    final PMMergeCursor this$0;

    public void onChanged()
    {
        PMMergeCursor.access$002(PMMergeCursor.this, -1);
    }

    public void onInvalidated()
    {
        PMMergeCursor.access$102(PMMergeCursor.this, -1);
    }

    ()
    {
        this$0 = PMMergeCursor.this;
        super();
    }
}
