// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableWrappedIterable

public interface GenericRawResults
    extends CloseableWrappedIterable
{

    public abstract void close()
        throws SQLException;

    public abstract String[] getColumnNames();

    public abstract Object getFirstResult()
        throws SQLException;

    public abstract int getNumberColumns();

    public abstract List getResults()
        throws SQLException;
}
