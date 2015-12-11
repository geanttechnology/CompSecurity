// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.ResultStatus;
import java.text.DateFormat;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            Content

public class DatedContent extends Content
{

    private final long _timeLastUpdatedMillis;

    public DatedContent(ResultStatus resultstatus)
    {
        this(resultstatus, System.currentTimeMillis());
    }

    public DatedContent(ResultStatus resultstatus, long l)
    {
        super(resultstatus);
        _timeLastUpdatedMillis = l;
    }

    public DatedContent(Object obj)
    {
        this(obj, System.currentTimeMillis());
    }

    public DatedContent(Object obj, long l)
    {
        super(obj);
        _timeLastUpdatedMillis = l;
    }

    public DatedContent(Object obj, ResultStatus resultstatus)
    {
        this(obj, resultstatus, System.currentTimeMillis());
    }

    public DatedContent(Object obj, ResultStatus resultstatus, long l)
    {
        super(obj, resultstatus);
        _timeLastUpdatedMillis = l;
    }

    public final long getLastUpdatedMillis()
    {
        return _timeLastUpdatedMillis;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(", last updated:").append(DateFormat.getDateTimeInstance().format(new Date(_timeLastUpdatedMillis))).toString();
    }
}
