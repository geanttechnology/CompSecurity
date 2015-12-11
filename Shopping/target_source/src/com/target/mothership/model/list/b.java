// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.e;
import com.target.mothership.cache.list.CacheListDetail;
import com.target.mothership.cache.list.CacheListSummary;
import com.target.mothership.cache.list.a;
import com.target.mothership.cache.list.c;
import com.target.mothership.cache.list.f;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.ListSummary;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            a, l

class b
    implements com.target.mothership.model.list.a
{

    private GuestBase mGuest;

    public b(GuestBase guestbase)
    {
        mGuest = guestbase;
    }

    static long a(b b1)
        throws SQLException
    {
        return b1.b();
    }

    private long b()
        throws SQLException
    {
        return (new f()).getDao().queryBuilder().where().eq("mGuestId", a().getGuestId()).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
    }

    static GuestBase b(b b1)
    {
        return b1.mGuest;
    }

    GuestBase a()
    {
        return mGuest;
    }

    public void a(d d)
    {
        a(false, d);
    }

    protected void a(final d handler, final boolean ignoreDeletingFlag)
    {
        handler = new a(handler);
        e.getInstance().add(new Callable() {

            final b this$0;
            final a val$handler;
            final boolean val$ignoreDeletingFlag;

            public Void a()
                throws Exception
            {
                SQLException sqlexception;
                Object obj;
                obj = (new f()).getDao();
                Dao dao = (new c()).getDao();
                obj = ((Dao) (obj)).queryBuilder().orderBy("mListPosition", true).where().eq("mGuestId", b.b(b.this).getGuestId());
                if (!ignoreDeletingFlag)
                {
                    ((Where) (obj)).and().eq("mIsDeleting", Boolean.valueOf(false));
                }
                Object obj1 = ((Where) (obj)).query();
                obj = new ArrayList();
                CacheListDetail cachelistdetail;
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(cachelistdetail))
                {
                    Object obj2 = (CacheListSummary)((Iterator) (obj1)).next();
                    cachelistdetail = new CacheListDetail(((CacheListSummary) (obj2)));
                    obj2 = dao.queryBuilder().orderBy("mItemPosition", true).where().eq("mListKey", Integer.valueOf(((CacheListSummary) (obj2)).getKey()));
                    if (!ignoreDeletingFlag)
                    {
                        ((Where) (obj2)).and().eq("mIsDeleting", Boolean.valueOf(false));
                    }
                    cachelistdetail.getListItems().addAll(((Where) (obj2)).query());
                }

                  goto _L1
_L3:
                return null;
_L1:
                try
                {
                    handler.onResponse(obj);
                }
                // Misplaced declaration of an exception variable
                catch (SQLException sqlexception)
                {
                    handler.onError(new com.target.mothership.model.list.interfaces.a.a(sqlexception));
                }
                if (true) goto _L3; else goto _L2
_L2:
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = b.this;
                ignoreDeletingFlag = flag;
                handler = a1;
                super();
            }
        });
    }

    public void a(final ListSummary list, final int newPosition, final d handler)
    {
        handler = new a(handler);
        e.getInstance().add(new Callable() {

            final b this$0;
            final a val$handler;
            final ListSummary val$list;
            final int val$newPosition;

            public Void a()
                throws Exception
            {
                Dao dao;
                List list1;
                Iterator iterator;
                dao = (new f()).getDao();
                list1 = com.target.mothership.model.list.l.a(b.this.a().getGuestId());
                iterator = list1.iterator();
_L4:
                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                Object obj = (CacheListSummary)iterator.next();
                if (((CacheListSummary) (obj)).getKey() != list.getKey()) goto _L4; else goto _L3
_L3:
                if (obj == null)
                {
                    int i;
                    try
                    {
                        handler.onError(new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST));
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
                i = (int)((CacheListSummary) (obj)).getListPosition();
                list1.remove(i);
                list1.add(newPosition, obj);
                for (int j = Math.min(i, newPosition); j < list1.size(); j++)
                {
                    obj = (CacheListSummary)list1.get(j);
                    if (((CacheListSummary) (obj)).getListPosition() != (long)j)
                    {
                        com.target.mothership.model.list.l.a(((ListSummary) (obj)), j, dao);
                    }
                    break MISSING_BLOCK_LABEL_221;
                }

                obj = new ArrayList(list1);
                handler.onResponse(obj);
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
                this$0 = b.this;
                list = listsummary;
                handler = a1;
                newPosition = i;
                super();
            }
        });
    }

    public void a(final String listTitle, final String organization, final String location, final String description, final d handler)
    {
        handler = new a(handler);
        e.getInstance().add(new Callable() {

            final b this$0;
            final String val$description;
            final a val$handler;
            final String val$listTitle;
            final String val$location;
            final String val$organization;

            public Void a()
                throws Exception
            {
                Object obj;
                obj = b.this.a().getGuestId();
                if (l.b(((String) (obj))) != 20L)
                {
                    break MISSING_BLOCK_LABEL_45;
                }
                obj = new com.target.mothership.model.list.interfaces.a.a(com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_MAX_LIST_COUNT_EXCEEDED);
                handler.onError(obj);
                return null;
                try
                {
                    f f1 = new f();
                    CacheListSummary cachelistsummary = new CacheListSummary();
                    cachelistsummary.setTitle(listTitle);
                    cachelistsummary.setOrganization(organization);
                    cachelistsummary.setLocation(location);
                    cachelistsummary.setDescription(description);
                    cachelistsummary.setChannel(com.target.mothership.common.c.b.MOBILE);
                    cachelistsummary.setGuestId(((String) (obj)));
                    cachelistsummary.setLastModifiedUserId(((String) (obj)));
                    cachelistsummary.setListPosition(com.target.mothership.model.list.b.a(b.this));
                    f1.getDao().createIfNotExists(cachelistsummary);
                    handler.onResponse(new CacheListDetail(cachelistsummary));
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
                this$0 = b.this;
                handler = a1;
                listTitle = s;
                organization = s1;
                location = s2;
                description = s3;
                super();
            }
        });
    }

    protected void a(final boolean allListsForSync, final d handler)
    {
        handler = new a(handler);
        e.getInstance().add(new Callable() {

            final b this$0;
            final boolean val$allListsForSync;
            final a val$handler;

            public Void a()
                throws Exception
            {
                try
                {
                    Object obj = b.this.a().getGuestId();
                    obj = (new f()).getDao().queryBuilder().orderBy("mListPosition", true).where().eq("mGuestId", obj);
                    if (!allListsForSync)
                    {
                        ((Where) (obj)).and().eq("mIsDeleting", Boolean.valueOf(false));
                    }
                    obj = new ArrayList(((Where) (obj)).query());
                    handler.onResponse(obj);
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
                this$0 = b.this;
                allListsForSync = flag;
                handler = a1;
                super();
            }
        });
    }

    public void b(d d)
    {
        a(d, false);
    }

    public void c(final d handler)
    {
        handler = new a(handler);
        e.getInstance().add(new Callable() {

            final b this$0;
            final a val$handler;

            public Void a()
                throws Exception
            {
                try
                {
                    Object obj = b.this.a().getGuestId();
                    obj = (CacheListSummary)(new f()).getDao().queryBuilder().where().eq("mIsDefaultList", Boolean.valueOf(true)).and().eq("mGuestId", obj).queryForFirst();
                    CacheListDetail cachelistdetail = new CacheListDetail(((CacheListSummary) (obj)));
                    cachelistdetail.setListItems(new ArrayList((new c()).getDao().queryBuilder().where().eq("mListKey", Integer.valueOf(((CacheListSummary) (obj)).getKey())).query()));
                    handler.onResponse(cachelistdetail);
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
                this$0 = b.this;
                handler = a1;
                super();
            }
        });
    }
}
