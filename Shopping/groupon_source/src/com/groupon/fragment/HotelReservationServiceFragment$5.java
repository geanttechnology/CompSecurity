// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            HotelReservationServiceFragment

class this._cls0
    implements Function1
{

    final HotelReservationServiceFragment this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        HotelReservationServiceFragment.access$100(HotelReservationServiceFragment.this).onUpdateReservationFinished(HotelReservationServiceFragment.access$000(HotelReservationServiceFragment.this), null);
    }

    llback()
    {
        this$0 = HotelReservationServiceFragment.this;
        super();
    }
}
