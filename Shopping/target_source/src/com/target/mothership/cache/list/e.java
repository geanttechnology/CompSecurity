// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.a.a.b;
import com.target.mothership.cache.h;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.cache.list:
//            f, c, CacheListSummary, CacheListItem

public class e
    implements com.target.mothership.model.guest.b.a
{

    private static final String TAG = com/target/mothership/cache/list/e.getSimpleName();

    public e()
    {
    }

    private void createIfNeededDefaultList(final GuestBase guest, final f listCollectionAccessor, final Dao listCollectionDao)
    {
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final e this$0;
            final GuestBase val$guest;
            final f val$listCollectionAccessor;
            final Dao val$listCollectionDao;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                if (listCollectionDao.queryBuilder().where().eq("mIsDefaultList", Boolean.valueOf(true)).and().eq("mGuestId", guest.getGuestId()).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf() == 0L)
                {
                    listCollectionAccessor.createDefaultList(guest);
                }
                return null;
            }

            
            {
                this$0 = e.this;
                listCollectionDao = dao;
                guest = guestbase;
                listCollectionAccessor = f1;
                super();
            }
        });
    }

    private void transferDefaultListItems(final Guest newGuest, final Dao listCollectionDao, final Dao listItemDao)
    {
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final e this$0;
            final Dao val$listCollectionDao;
            final Dao val$listItemDao;
            final Guest val$newGuest;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                CacheListSummary cachelistsummary = (CacheListSummary)listCollectionDao.queryBuilder().where().eq("mIsDefaultList", Boolean.valueOf(true)).and().eq("mGuestId", com.target.mothership.model.guest.b.a().getGuestId()).queryForFirst();
                CacheListSummary cachelistsummary1 = (CacheListSummary)listCollectionDao.queryBuilder().where().eq("mIsDefaultList", Boolean.valueOf(true)).and().eq("mGuestId", newGuest.getGuestId()).queryForFirst();
                int i = cachelistsummary1.getKey();
                CacheListItem cachelistitem;
                int j;
                for (Iterator iterator = listItemDao.queryBuilder().where().eq("mListKey", Integer.valueOf(cachelistsummary.getKey())).query().iterator(); iterator.hasNext(); h.update(listItemDao, cachelistitem, Integer.valueOf(j)))
                {
                    cachelistitem = (CacheListItem)iterator.next();
                    cachelistitem.setListKey(i);
                    j = cachelistitem.getKey();
                }

                cachelistsummary1.setItemCount(listItemDao.queryBuilder().where().eq("mListKey", Integer.valueOf(cachelistsummary1.getKey())).query().size());
                h.update(listCollectionDao, cachelistsummary1, Integer.valueOf(i));
                i = cachelistsummary.getKey();
                cachelistsummary.setLastModifiedDate(null);
                cachelistsummary.setItemCount(0);
                cachelistsummary.setListPosition(0L);
                h.update(listCollectionDao, cachelistsummary, Integer.valueOf(i));
                return null;
            }

            
            {
                this$0 = e.this;
                listCollectionDao = dao;
                newGuest = guest;
                listItemDao = dao1;
                super();
            }
        });
    }

    private void transferLists(final Guest newGuest, final Dao dao)
    {
        com.target.mothership.cache.e.getInstance().add(new Callable() {

            final e this$0;
            final Dao val$dao;
            final Guest val$newGuest;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                long l = dao.queryBuilder().where().eq("mGuestId", newGuest.getGuestId()).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
                Iterator iterator = dao.queryBuilder().orderBy("mListPosition", true).where().eq("mIsDefaultList", Boolean.valueOf(false)).and().eq("mGuestId", com.target.mothership.model.guest.b.a().getGuestId()).and().eq("mIsDeleting", Boolean.valueOf(false)).query().iterator();
                for (int i = 0; iterator.hasNext(); i++)
                {
                    CacheListSummary cachelistsummary = (CacheListSummary)iterator.next();
                    cachelistsummary.setGuestId(newGuest.getGuestId());
                    int j = cachelistsummary.getKey();
                    cachelistsummary.setListPosition((long)i + l);
                    h.update(dao, cachelistsummary, Integer.valueOf(j));
                }

                return null;
            }

            
            {
                this$0 = e.this;
                dao = dao1;
                newGuest = guest;
                super();
            }
        });
    }

    public void onGuestChanged(com.google.a.a.e e1)
    {
label0:
        {
            if (e1.b())
            {
                e1 = (Guest)e1.c();
                if (!e1.isAnonymous())
                {
                    break label0;
                }
            }
            return;
        }
        try
        {
            f f1 = new f();
            Dao dao = f1.getDao();
            Dao dao1 = (new c()).getDao();
            createIfNeededDefaultList(e1, f1, dao);
            transferLists(e1, dao);
            transferDefaultListItems(e1, dao, dao1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.a.a.e e1)
        {
            b.b(TAG, "database exception while migrating list entities on guest authentication");
        }
    }

}
