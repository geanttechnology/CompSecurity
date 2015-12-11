// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.target.a.a.b;
import com.target.mothership.cache.e;
import com.target.mothership.cache.k;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.cache.guest:
//            CacheAccountDetails, b, CacheGuest, a

class c
{
    private final class a
        implements Callable
    {

        private final CacheAccountDetails mCacheAccountDetails;
        final c this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            try
            {
                Dao dao = (new com.target.mothership.cache.guest.a()).getAccountDetailsDao();
                TableUtils.clearTable(dao.getConnectionSource(), com/target/mothership/cache/guest/CacheAccountDetails);
                dao.create(mCacheAccountDetails);
            }
            catch (SQLException sqlexception)
            {
                b.a(c.TAG, (new StringBuilder()).append("Error writing account details to database: ").append(sqlexception.getMessage()).toString());
            }
            return null;
        }

        a(CacheAccountDetails cacheaccountdetails)
        {
            this$0 = c.this;
            super();
            mCacheAccountDetails = cacheaccountdetails;
        }
    }


    private static final String TAG = com/target/mothership/cache/guest/c.getSimpleName();

    c()
    {
    }

    private void writeAccountDetailsInternal(AccountDetails accountdetails)
    {
        if (accountdetails instanceof CacheAccountDetails)
        {
            accountdetails = (CacheAccountDetails)accountdetails;
        } else
        {
            accountdetails = new CacheAccountDetails(accountdetails);
        }
        e.getInstance().add(new a(accountdetails));
    }

    private void writeGuestInternal(final CacheGuest cacheGuest, final h handler)
    {
        handler = new com.target.mothership.cache.guest.b(handler);
        e.getInstance().add(new Callable() {

            final c this$0;
            final CacheGuest val$cacheGuest;
            final com.target.mothership.cache.guest.b val$handler;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                try
                {
                    Dao dao = (new com.target.mothership.cache.guest.a()).getDao();
                    TableUtils.clearTable(dao.getConnectionSource(), com/target/mothership/cache/guest/CacheGuest);
                    dao.create(cacheGuest);
                    handler.onResponse(cacheGuest);
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.services.x x = k.toNetworkError(sqlexception);
                    b.a(c.TAG, (new StringBuilder()).append("Error writing the database: ").append(sqlexception.getMessage()).toString());
                    handler.onError(x);
                }
                return null;
            }

            
            {
                this$0 = c.this;
                cacheGuest = cacheguest;
                handler = b1;
                super();
            }
        });
    }

    public void clearGuest(final Guest guest, final h handler)
    {
        handler = new com.target.mothership.cache.guest.b(handler);
        e.getInstance().add(new Callable() {

            final c this$0;
            final Guest val$guest;
            final com.target.mothership.cache.guest.b val$handler;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                try
                {
                    Dao dao = (new com.target.mothership.cache.guest.a()).getDao();
                    dao.delete(dao.queryForEq("mGuestId", guest.getGuestId()));
                    handler.onResponse(null);
                }
                catch (SQLException sqlexception)
                {
                    b.a(c.TAG, (new StringBuilder()).append("Error while trying to delete from database: ").append(sqlexception.getMessage()).toString());
                    handler.onResponse(null);
                    return null;
                }
                return null;
            }

            
            {
                this$0 = c.this;
                guest = guest1;
                handler = b1;
                super();
            }
        });
    }

    public void readGuest(final h handler)
    {
        handler = new com.target.mothership.cache.guest.b(handler);
        e.getInstance().add(new Callable() {

            final c this$0;
            final com.target.mothership.cache.guest.b val$handler;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                Object obj;
                Object obj1;
                try
                {
                    obj1 = new com.target.mothership.cache.guest.a();
                    obj = ((com.target.mothership.cache.guest.a) (obj1)).getDao();
                    obj1 = ((com.target.mothership.cache.guest.a) (obj1)).getAccountDetailsDao();
                    obj = (CacheGuest)((Dao) (obj)).queryBuilder().queryForFirst();
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.services.x x = k.toNetworkError(sqlexception);
                    b.a(c.TAG, (new StringBuilder()).append("Error reading the database: ").append(sqlexception.getMessage()).toString());
                    handler.onError(x);
                    return null;
                }
                if (obj != null)
                {
                    break MISSING_BLOCK_LABEL_45;
                }
                handler.onResponse(null);
                return null;
                ((Dao) (obj1)).refresh(((CacheGuest) (obj)).getCacheAccountDetails());
                handler.onResponse(obj);
                return null;
            }

            
            {
                this$0 = c.this;
                handler = b1;
                super();
            }
        });
    }

    public void writeGuest(Guest guest, h h)
    {
        CacheGuest cacheguest;
        if (guest instanceof CacheGuest)
        {
            cacheguest = (CacheGuest)guest;
        } else
        {
            cacheguest = new CacheGuest(guest);
        }
        if (guest.getAccountDetails().b())
        {
            guest = new CacheAccountDetails((AccountDetails)guest.getAccountDetails().c());
            writeAccountDetailsInternal(guest);
            cacheguest.setAccountDetails(guest);
        }
        writeGuestInternal(cacheguest, h);
    }


}
