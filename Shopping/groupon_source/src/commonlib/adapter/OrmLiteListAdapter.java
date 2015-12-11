// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.adapter;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package commonlib.adapter:
//            JavaListAdapter

public abstract class OrmLiteListAdapter extends JavaListAdapter
{

    private Dao dao;

    protected OrmLiteListAdapter(Dao dao1)
    {
        dao = dao1;
    }

    protected OrmLiteListAdapter(Dao dao1, List list)
    {
        super(list);
        dao = dao1;
    }

    public long getItemId(int i)
    {
        long l;
        try
        {
            l = ((Number)dao.extractId(getItem(i))).longValue();
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return l;
    }
}
