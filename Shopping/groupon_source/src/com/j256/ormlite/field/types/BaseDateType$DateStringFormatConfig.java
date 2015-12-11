// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDateType

protected static class dateFormatStr
{

    final String dateFormatStr;
    private final ThreadLocal threadLocal = new ThreadLocal() {

        final BaseDateType.DateStringFormatConfig this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            return new SimpleDateFormat(dateFormatStr);
        }

            
            {
                this$0 = BaseDateType.DateStringFormatConfig.this;
                super();
            }
    };

    public DateFormat getDateFormat()
    {
        return (DateFormat)threadLocal.get();
    }

    public String toString()
    {
        return dateFormatStr;
    }

    public _cls1.this._cls0(String s)
    {
        dateFormatStr = s;
    }
}
