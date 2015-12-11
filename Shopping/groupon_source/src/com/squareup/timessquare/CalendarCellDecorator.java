// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import java.util.Date;

// Referenced classes of package com.squareup.timessquare:
//            CalendarCellView

public interface CalendarCellDecorator
{

    public abstract void decorate(CalendarCellView calendarcellview, Date date);
}
