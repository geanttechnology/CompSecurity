// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.location.Geocoder;
import com.google.inject.Provider;
import java.util.Locale;

// Referenced classes of package com.groupon:
//            GrouponModule

class this._cls0
    implements Provider
{

    final GrouponModule this$0;

    public Geocoder get()
    {
        return new Geocoder(GrouponModule.access$000(GrouponModule.this), Locale.ENGLISH);
    }

    public volatile Object get()
    {
        return get();
    }

    ()
    {
        this$0 = GrouponModule.this;
        super();
    }
}
