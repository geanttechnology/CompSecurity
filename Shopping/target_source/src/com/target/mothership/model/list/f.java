// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.e;
import com.target.mothership.cache.h;
import com.target.mothership.cache.list.CacheListDetail;
import com.target.mothership.cache.list.CacheListItem;
import com.target.mothership.cache.list.CacheListSummary;
import com.target.mothership.cache.list.b;
import com.target.mothership.cache.list.c;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.a;
import com.target.mothership.model.product.interfaces.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            e, l

public class f
    implements com.target.mothership.model.list.e
{

    public static final int MAX_LIST_ITEM_COUNT = 100;
    private GuestBase mGuest;
    private a mList;

    public f(a a1, GuestBase guestbase)
    {
        mList = a1;
        mGuest = guestbase;
    }

    static long a(f f1)
        throws SQLException
    {
        return f1.i();
    }

    static List a(f f1, boolean flag)
        throws SQLException
    {
        return f1.a(flag);
    }

    private List a(boolean flag)
        throws SQLException
    {
        Where where = (new c()).getDao().queryBuilder().orderBy("mItemPosition", true).where().eq("mListKey", Integer.valueOf(a().getKey()));
        if (!flag)
        {
            where.and().eq("mIsDeleting", Boolean.valueOf(false));
        }
        return where.query();
    }

    static void a(f f1, ListItem listitem, int j, Dao dao)
        throws SQLException
    {
        f1.a(listitem, j, dao);
    }

    private void a(final ListItem saveItem, int j, final int position, final d handler)
    {
        if (j < 1)
        {
            handler.b(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_BELOW_MINIMUM_QUANTITY));
            return;
        }
        if (j > 99)
        {
            handler.b(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_ABOVE_MAXIMUM_QUANTITY));
            return;
        }
        if (position < -1)
        {
            handler.b(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_BELOW_MIN_POSITION));
            return;
        }
        if (position > 100)
        {
            handler.b(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_ABOVE_MAX_POSITION));
            return;
        } else
        {
            saveItem = new CacheListItem(saveItem);
            saveItem.setDesiredQuantity(j);
            saveItem.setListKey(a().getKey());
            saveItem.setListId(a().getId());
            saveItem.setDirty(false);
            saveItem.setDeleting(false);
            handler = new com.target.mothership.cache.list.a(handler);
            com.target.mothership.cache.e.getInstance().add(new Callable() {

                final f this$0;
                final com.target.mothership.cache.list.a val$handler;
                final int val$position;
                final CacheListItem val$saveItem;

                public Void a()
                    throws Exception
                {
                    if (com.target.mothership.model.list.f.a(f.this) != 100L)
                    {
                        break MISSING_BLOCK_LABEL_35;
                    }
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED);
                    handler.onError(a1);
                    return null;
                    Dao dao;
                    long l1;
                    dao = (new c()).getDao();
                    if (position != -1)
                    {
                        break MISSING_BLOCK_LABEL_130;
                    }
                    l1 = com.target.mothership.model.list.f.b(f.this);
_L2:
                    Object obj;
                    int k;
                    if (position == -1)
                    {
                        break MISSING_BLOCK_LABEL_140;
                    }
                    obj = com.target.mothership.model.list.f.c(f.this);
                    k = position;
_L1:
                    if (k >= ((List) (obj)).size())
                    {
                        break MISSING_BLOCK_LABEL_140;
                    }
                    CacheListItem cachelistitem = (CacheListItem)((List) (obj)).get(k);
                    com.target.mothership.model.list.f.a(f.this, cachelistitem, k + 1, dao);
                    k++;
                      goto _L1
                    List list;
                    try
                    {
                        l1 = position;
                    }
                    catch (SQLException sqlexception)
                    {
                        com.target.mothership.model.list.interfaces.a.a a2 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                        handler.onError(a2);
                        return null;
                    }
                      goto _L2
                    saveItem.setItemPosition(l1);
                    dao.create(saveItem);
                    obj = new ArrayList();
                    ((List) (obj)).add(saveItem);
                    com.target.mothership.model.list.f.d(f.this);
                    if (position == -1)
                    {
                        break MISSING_BLOCK_LABEL_259;
                    }
                    list = com.target.mothership.model.list.f.c(f.this);
                    for (int i1 = position; i1 < list.size(); i1++)
                    {
                        CacheListItem cachelistitem1 = (CacheListItem)list.get(i1);
                        if (cachelistitem1.getItemPosition() != (long)i1)
                        {
                            com.target.mothership.model.list.f.a(f.this, cachelistitem1, i1, dao);
                        }
                        break MISSING_BLOCK_LABEL_289;
                    }

                    handler.onResponse(obj);
                    return null;
                }

                public Object call()
                    throws Exception
                {
                    return a();
                }

            
            {
                this$0 = f.this;
                handler = a1;
                position = j;
                saveItem = cachelistitem;
                super();
            }
            });
            return;
        }
    }

    private void a(ListItem listitem, int j, Dao dao)
        throws SQLException
    {
        listitem = (CacheListItem)listitem;
        listitem.setItemPosition(j);
        com.target.mothership.cache.h.update(dao, listitem, Integer.valueOf(listitem.getKey()));
    }

    static long b(f f1)
        throws SQLException
    {
        return f1.c();
    }

    private long c()
        throws SQLException
    {
        return (new c()).getDao().queryBuilder().where().eq("mListKey", Integer.valueOf(a().getKey())).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
    }

    static List c(f f1)
        throws SQLException
    {
        return f1.h();
    }

    private void d()
        throws SQLException
    {
        int j = (int)(new c()).getDao().queryBuilder().where().eq("mListKey", Integer.valueOf(a().getKey())).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
        Dao dao = (new com.target.mothership.cache.list.f()).getDao();
        CacheListSummary cachelistsummary = (CacheListSummary)dao.queryForId(Integer.valueOf(a().getKey()));
        cachelistsummary.setLastModifiedUserId(b().getGuestId());
        cachelistsummary.setItemCount(j);
        cachelistsummary.setLastModifiedDate(null);
        com.target.mothership.cache.h.update(dao, cachelistsummary, Integer.valueOf(cachelistsummary.getKey()));
    }

    static void d(f f1)
        throws SQLException
    {
        f1.d();
    }

    private void e()
        throws SQLException
    {
        Dao dao = (new com.target.mothership.cache.list.f()).getDao();
        List list = com.target.mothership.model.list.l.a(b().getGuestId());
        for (int j = 0; j < list.size(); j++)
        {
            CacheListSummary cachelistsummary = (CacheListSummary)list.get(j);
            if (cachelistsummary.getListPosition() != (long)j)
            {
                com.target.mothership.model.list.l.a(cachelistsummary, j, dao);
            }
        }

    }

    static void e(f f1)
        throws SQLException
    {
        f1.e();
    }

    private int f()
    {
        long l1 = 0L;
        long l2 = (new c()).getDao().queryBuilder().where().eq("mListKey", Integer.valueOf(a().getKey())).and().eq("mIsDeleting", Boolean.valueOf(false)).and().eq("mIsCompleted", Boolean.valueOf(false)).countOf();
        l1 = l2;
_L2:
        return (int)l1;
        SQLException sqlexception;
        sqlexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void f(f f1)
        throws SQLException
    {
        f1.g();
    }

    static int g(f f1)
    {
        return f1.f();
    }

    private void g()
        throws SQLException
    {
        Dao dao = (new c()).getDao();
        List list = h();
        for (int j = 0; j < list.size(); j++)
        {
            CacheListItem cachelistitem = (CacheListItem)list.get(j);
            if (cachelistitem.getItemPosition() != (long)j)
            {
                a(cachelistitem, j, dao);
            }
        }

    }

    private List h()
        throws SQLException
    {
        return a(false);
    }

    private long i()
        throws SQLException
    {
        return (new c()).getDao().queryBuilder().where().eq("mListKey", Integer.valueOf(a().getKey())).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
    }

    public a a()
    {
        return mList;
    }

    public void a(d d1)
    {
        a(false, d1);
    }

    public void a(final ListItem listItem, final int count, final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final int val$count;
            final com.target.mothership.cache.list.a val$handler;
            final ListItem val$listItem;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    CacheListItem cachelistitem = (CacheListItem)dao.queryForId(Integer.valueOf(listItem.getKey()));
                    cachelistitem.setDesiredQuantity(count);
                    com.target.mothership.cache.h.update(dao, cachelistitem, Integer.valueOf(cachelistitem.getKey()));
                    handler.onResponse(cachelistitem);
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                listItem = listitem;
                count = j;
                handler = a1;
                super();
            }
        });
    }

    public void a(ListItem listitem, final d callback)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(listitem);
        a(((List) (arraylist)), ((d) (new d() {

            final f this$0;
            final d val$callback;

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                callback.b(a1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (!list.isEmpty())
                {
                    callback.a(list.get(0));
                    return;
                } else
                {
                    callback.a(null);
                    return;
                }
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = f.this;
                callback = d1;
                super();
            }
        })));
    }

    public void a(final ListItem listItem, final String title, final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;
            final ListItem val$listItem;
            final String val$title;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    CacheListItem cachelistitem = (CacheListItem)dao.queryForId(Integer.valueOf(listItem.getKey()));
                    cachelistitem.setTitle(title);
                    cachelistitem.setDirty(true);
                    com.target.mothership.cache.h.update(dao, cachelistitem, Integer.valueOf(cachelistitem.getKey()));
                    handler.onResponse(cachelistitem);
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                listItem = listitem;
                title = s;
                handler = a1;
                super();
            }
        });
    }

    public void a(Product product, int j, int k, d d1)
    {
        CacheListItem cachelistitem = new CacheListItem();
        cachelistitem.setTitle(product.g());
        cachelistitem.setTcin(product.k_());
        a(((ListItem) (cachelistitem)), j, k, d1);
    }

    public void a(Product product, int j, d d1)
    {
        CacheListItem cachelistitem = new CacheListItem();
        cachelistitem.setTitle(product.g());
        cachelistitem.setTcin(product.k_());
        c(cachelistitem, j, d1);
    }

    public void a(String s, int j, int k, d d1)
    {
        CacheListItem cachelistitem = new CacheListItem();
        cachelistitem.setTitle(s);
        a(((ListItem) (cachelistitem)), j, k, d1);
    }

    public void a(String s, int j, d d1)
    {
        CacheListItem cachelistitem = new CacheListItem();
        cachelistitem.setTitle(s);
        c(cachelistitem, j, d1);
    }

    public void a(final String newDescription, final String newLocation, final String newTitle, final String newOrganization, final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;
            final String val$newDescription;
            final String val$newLocation;
            final String val$newOrganization;
            final String val$newTitle;

            public Void a()
                throws Exception
            {
                try
                {
                    Object obj = (new com.target.mothership.cache.list.f()).getDao();
                    CacheListSummary cachelistsummary = (CacheListSummary)((Dao) (obj)).queryForId(Integer.valueOf(f.this.a().getKey()));
                    cachelistsummary.setDescription(newDescription);
                    cachelistsummary.setLocation(newLocation);
                    cachelistsummary.setTitle(newTitle);
                    cachelistsummary.setOrganization(newOrganization);
                    cachelistsummary.setChannel(com.target.mothership.common.c.b.MOBILE);
                    cachelistsummary.setLastModifiedUserId(f.this.b().getGuestId());
                    cachelistsummary.setItemCount(cachelistsummary.getItemCount());
                    cachelistsummary.setLastModifiedDate(null);
                    com.target.mothership.cache.h.update(((Dao) (obj)), cachelistsummary, Integer.valueOf(cachelistsummary.getKey()));
                    obj = new CacheListDetail(cachelistsummary);
                    ((CacheListDetail) (obj)).setListItems(new ArrayList(com.target.mothership.model.list.f.c(f.this)));
                    handler.onResponse(obj);
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                    return null;
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                newDescription = s;
                newLocation = s1;
                newTitle = s2;
                newOrganization = s3;
                handler = a1;
                super();
            }
        });
    }

    public void a(final List items, final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;
            final List val$items;

            public Void a()
                throws Exception
            {
                Object obj;
                Dao dao;
                Iterator iterator;
                obj = new ArrayList();
                dao = (new c()).getDao();
                iterator = items.iterator();
_L4:
                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                CacheListItem cachelistitem = (CacheListItem)dao.queryForId(Integer.valueOf(((ListItem)iterator.next()).getKey()));
                if (cachelistitem == null) goto _L4; else goto _L3
_L3:
                cachelistitem.setDeleting(true);
                dao.update(cachelistitem);
                ((List) (obj)).add(cachelistitem);
                  goto _L4
_L6:
                return null;
_L2:
                try
                {
                    f.f(f.this);
                    com.target.mothership.model.list.f.d(f.this);
                    handler.onResponse(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    obj = new com.target.mothership.model.list.interfaces.a.a(((SQLException) (obj)));
                    handler.onError(obj);
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                items = list;
                handler = a1;
                super();
            }
        });
    }

    protected void a(final boolean allItemsForSync, final d handler)
    {
        handler = new b(com.target.mothership.model.list.l.a(handler));
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final boolean val$allItemsForSync;
            final b val$handler;

            public Void a()
                throws Exception
            {
                Object obj;
                try
                {
                    obj = new com.target.mothership.cache.list.f();
                    int j = f.this.a().getKey();
                    obj = (CacheListSummary)((com.target.mothership.cache.list.f) (obj)).getDao().queryForId(Integer.valueOf(j));
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                    return null;
                }
                if (obj != null)
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                handler.onError(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST));
                return null;
                obj = new CacheListDetail(((CacheListSummary) (obj)));
                ((CacheListDetail) (obj)).setListItems(new ArrayList(com.target.mothership.model.list.f.a(f.this, allItemsForSync)));
                handler.onResponse(obj);
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                handler = b1;
                allItemsForSync = flag;
                super();
            }
        });
    }

    public GuestBase b()
    {
        return mGuest;
    }

    public void b(final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    dao.delete(dao.queryBuilder().where().eq("mListKey", Integer.valueOf(f.this.a().getKey())).query());
                    dao = (new com.target.mothership.cache.list.f()).getDao();
                    CacheListSummary cachelistsummary = (CacheListSummary)dao.queryForId(Integer.valueOf(f.this.a().getKey()));
                    cachelistsummary.setDeleting(true);
                    dao.update(cachelistsummary);
                    com.target.mothership.model.list.f.e(f.this);
                    handler.onResponse("1000");
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                handler = a1;
                super();
            }
        });
    }

    public void b(final ListItem listItem, final int newPosition, final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;
            final ListItem val$listItem;
            final int val$newPosition;

            public Void a()
                throws Exception
            {
                Dao dao;
                List list;
                Iterator iterator;
                dao = (new c()).getDao();
                list = com.target.mothership.model.list.f.c(f.this);
                iterator = list.iterator();
_L4:
                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                Object obj = (CacheListItem)iterator.next();
                if (((CacheListItem) (obj)).getKey() != listItem.getKey()) goto _L4; else goto _L3
_L3:
                if (obj == null)
                {
                    int j;
                    try
                    {
                        handler.onError(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_INVALID_ITEM_ID));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        obj = new com.target.mothership.model.list.interfaces.a.a(((SQLException) (obj)));
                        handler.onError(obj);
                        return null;
                    }
                    return null;
                }
                j = (int)((CacheListItem) (obj)).getItemPosition();
                list.remove(j);
                list.add(newPosition, obj);
                for (int k = Math.min(j, newPosition); k < list.size(); k++)
                {
                    obj = (CacheListItem)list.get(k);
                    if (((CacheListItem) (obj)).getItemPosition() != (long)k)
                    {
                        com.target.mothership.model.list.f.a(f.this, ((ListItem) (obj)), k, dao);
                    }
                    break MISSING_BLOCK_LABEL_215;
                }

                handler.onResponse(new ArrayList(list));
                return null;
_L2:
                obj = null;
                if (true) goto _L3; else goto _L5
_L5:
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                listItem = listitem;
                handler = a1;
                newPosition = j;
                super();
            }
        });
    }

    public void b(final ListItem listItem, final d callback)
    {
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final d val$callback;
            final ListItem val$listItem;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    CacheListItem cachelistitem = (CacheListItem)dao.queryForId(Integer.valueOf(listItem.getKey()));
                    cachelistitem.setCompleted(true);
                    cachelistitem.setDirty(true);
                    com.target.mothership.cache.h.update(dao, cachelistitem, Integer.valueOf(cachelistitem.getKey()));
                    int j = f.g(f.this);
                    b(cachelistitem, j, callback);
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    callback.b(a1);
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                listItem = listitem;
                callback = d1;
                super();
            }
        });
    }

    public void c(final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    CacheListItem cachelistitem;
                    for (Iterator iterator = dao.queryBuilder().where().eq("mListKey", Integer.valueOf(f.this.a().getKey())).query().iterator(); iterator.hasNext(); dao.update(cachelistitem))
                    {
                        cachelistitem = (CacheListItem)iterator.next();
                        cachelistitem.setDeleting(true);
                    }

                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                    return null;
                }
                com.target.mothership.model.list.f.d(f.this);
                handler.onResponse(null);
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                handler = a1;
                super();
            }
        });
    }

    protected void c(ListItem listitem, int j, d d1)
    {
        a(listitem, j, -1, d1);
    }

    public void c(final ListItem listItem, final d callback)
    {
        final int position = f();
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final d val$callback;
            final ListItem val$listItem;
            final int val$position;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    CacheListItem cachelistitem = (CacheListItem)dao.queryForId(Integer.valueOf(listItem.getKey()));
                    cachelistitem.setCompleted(false);
                    cachelistitem.setDirty(true);
                    com.target.mothership.cache.h.update(dao, cachelistitem, Integer.valueOf(cachelistitem.getKey()));
                    b(cachelistitem, position, callback);
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    callback.b(a1);
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                listItem = listitem;
                position = j;
                callback = d1;
                super();
            }
        });
    }

    public void d(final d handler)
    {
        handler = new com.target.mothership.cache.list.a(handler);
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final f this$0;
            final com.target.mothership.cache.list.a val$handler;

            public Void a()
                throws Exception
            {
                try
                {
                    Dao dao = (new c()).getDao();
                    CacheListItem cachelistitem;
                    for (Iterator iterator = dao.queryBuilder().where().eq("mListKey", Integer.valueOf(f.this.a().getKey())).and().eq("mIsCompleted", Boolean.valueOf(true)).query().iterator(); iterator.hasNext(); dao.update(cachelistitem))
                    {
                        cachelistitem = (CacheListItem)iterator.next();
                        cachelistitem.setDeleting(true);
                    }

                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                    return null;
                }
                com.target.mothership.model.list.f.d(f.this);
                handler.onResponse(null);
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = f.this;
                handler = a1;
                super();
            }
        });
    }
}
