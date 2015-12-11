// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.ResultStatus;
import java.text.DateFormat;
import java.util.Date;

public class ListCountContent
{

    private final ResultStatus _resultStatus;
    private final long _timeLastUpdatedMillis;
    private final int _totalItemCount;

    public ListCountContent(int i, ResultStatus resultstatus, long l)
    {
        if (resultstatus == null)
        {
            throw new IllegalArgumentException("Status must not be null!");
        } else
        {
            _totalItemCount = i;
            _resultStatus = resultstatus;
            _timeLastUpdatedMillis = l;
            return;
        }
    }

    public ListCountContent(ListCountContent listcountcontent)
    {
        _timeLastUpdatedMillis = listcountcontent._timeLastUpdatedMillis;
        _totalItemCount = listcountcontent._totalItemCount;
        _resultStatus = listcountcontent._resultStatus;
    }

    public final long getLastUpdatedMillis()
    {
        return _timeLastUpdatedMillis;
    }

    public final ResultStatus getStatus()
    {
        return _resultStatus;
    }

    public final int getTotalItemCount()
    {
        return _totalItemCount;
    }

    public String toString()
    {
        return (new StringBuilder()).append("total item count:").append(_totalItemCount).append(", result status:").append(_resultStatus).append(", last updated:").append(DateFormat.getDateTimeInstance().format(new Date(_timeLastUpdatedMillis))).toString();
    }
}
