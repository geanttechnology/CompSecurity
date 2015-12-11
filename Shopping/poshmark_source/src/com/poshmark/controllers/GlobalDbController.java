// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.Catalog;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.SuggestedSearchItem;
import com.poshmark.db.AllBrandsModel;
import com.poshmark.db.AllBrandsUpdater;
import com.poshmark.db.CategoriesUpdater;
import com.poshmark.db.FollowingBrandsUpdater;
import com.poshmark.db.PMDbContentProvider;
import com.poshmark.db.RecentBrandsUpdater;
import com.poshmark.db.SavedSearchesUpdater;
import com.poshmark.db.SqlStore;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlobalDbController
    implements PMNotificationListener
{
    private static class SingletonHolder
    {

        public static final GlobalDbController INSTANCE = new GlobalDbController();


        private SingletonHolder()
        {
        }
    }


    Object mutex;

    GlobalDbController()
    {
        mutex = new Object();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NEW_BRANDS_ON_SERVER", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NEW_CATALOG_ON_SERVER", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        Object obj = new AllBrandsUpdater(null, false);
        Void avoid[] = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((AllBrandsUpdater) (obj)).execute(avoid);
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
        }
        obj = new CategoriesUpdater(null, false);
        avoid = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((CategoriesUpdater) (obj)).execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
            return;
        }
    }

    private void cleanupCursor(Cursor cursor)
    {
        if (cursor != null)
        {
            cursor.close();
        }
    }

    public static GlobalDbController getGlobalDbController()
    {
        return SingletonHolder.INSTANCE;
    }

    private void reloadAllBrands()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("canonical_name");
        PMApi.getAllBrands(arraylist, new PMApiResponseHandler() {

            final GlobalDbController this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                Void avoid[];
label0:
                {
                    if (!pmapiresponse.hasError())
                    {
                        pmapiresponse = new AllBrandsUpdater((AllBrandsModel)pmapiresponse.data, true);
                        avoid = new Void[0];
                        if (pmapiresponse instanceof AsyncTask)
                        {
                            break label0;
                        }
                        pmapiresponse.execute(avoid);
                    }
                    return;
                }
                AsyncTaskInstrumentation.execute((AsyncTask)pmapiresponse, avoid);
            }

            
            {
                this$0 = GlobalDbController.this;
                super();
            }
        });
    }

    private void reloadAllFollowingBrands()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("canonical_name");
        PMApi.getAllFollowingBrands(arraylist, new PMApiResponseHandler() {

            final GlobalDbController this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                Void avoid[];
label0:
                {
                    if (!pmapiresponse.hasError())
                    {
                        pmapiresponse = new FollowingBrandsUpdater((AllBrandsModel)pmapiresponse.data, true);
                        avoid = new Void[0];
                        if (pmapiresponse instanceof AsyncTask)
                        {
                            break label0;
                        }
                        pmapiresponse.execute(avoid);
                    }
                    return;
                }
                AsyncTaskInstrumentation.execute((AsyncTask)pmapiresponse, avoid);
            }

            
            {
                this$0 = GlobalDbController.this;
                super();
            }
        });
    }

    private void reloadCatalog()
    {
        PMApi.getCatalog(new PMApiResponseHandler() {

            final GlobalDbController this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                Void avoid[];
label0:
                {
                    if (!pmapiresponse.hasError())
                    {
                        pmapiresponse = new CategoriesUpdater((Catalog)pmapiresponse.data, true);
                        avoid = new Void[0];
                        if (pmapiresponse instanceof AsyncTask)
                        {
                            break label0;
                        }
                        pmapiresponse.execute(avoid);
                    }
                    return;
                }
                AsyncTaskInstrumentation.execute((AsyncTask)pmapiresponse, avoid);
            }

            
            {
                this$0 = GlobalDbController.this;
                super();
            }
        });
    }

    private void updateAllBrands(String s, String s1)
    {
        s1 = String.format("SELECT * FROM timestamps WHERE tag='%s'", new Object[] {
            s1
        });
        s1 = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_TIMESTAMPS, null, s1, null, null);
        if (s1 != null && s1.getCount() > 0)
        {
            s1.moveToFirst();
            if (DateUtils.getDateFromString(s1.getString(s1.getColumnIndex("last_update_dtm"))).before(DateUtils.getDateFromString(s)))
            {
                reloadAllBrands();
            }
        }
        cleanupCursor(s1);
    }

    private void updateCatalog(String s, String s1)
    {
        s1 = String.format("SELECT * FROM timestamps WHERE tag='%s'", new Object[] {
            s1
        });
        s1 = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_TIMESTAMPS, null, s1, null, null);
        if (s1 != null && s1.getCount() > 0)
        {
            s1.moveToFirst();
            if (DateUtils.getDateFromString(s1.getString(s1.getColumnIndex("last_update_dtm"))).before(DateUtils.getDateFromString(s)))
            {
                reloadCatalog();
            }
        }
        cleanupCursor(s1);
    }

    private void updateFollowingBrands(String s, String s1)
    {
        s1 = String.format("SELECT * FROM timestamps WHERE tag='%s'", new Object[] {
            s1
        });
        s1 = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_TIMESTAMPS, null, s1, null, null);
        if (s1 != null && s1.getCount() > 0)
        {
            s1.moveToFirst();
            if (DateUtils.getDateFromString(s1.getString(s1.getColumnIndex("last_update_dtm"))).before(DateUtils.getDateFromString(s)))
            {
                reloadAllFollowingBrands();
            }
        } else
        {
            reloadAllFollowingBrands();
        }
        cleanupCursor(s1);
    }

    public void addBrandToRecents(MetaItem metaitem)
    {
        String s = DateUtils.getTimeStampStringFromUTCDate(new Date());
        ContentValues contentvalues = new ContentValues();
        String s1 = PMApplicationSession.GetPMSession().getUserId();
        Object obj = String.format("select * from recent_brands WHERE user='%s' AND canonical_name ='%s'", new Object[] {
            s1, SqlStore.sqlEscape(metaitem.getId())
        });
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, null, ((String) (obj)), null, null);
        if (obj != null && ((Cursor) (obj)).getCount() == 1)
        {
            contentvalues.put("insert_dtm", s);
            metaitem = metaitem.getId();
            PMApplication.getContext().getContentResolver().update(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, contentvalues, "canonical_name=?", new String[] {
                metaitem
            });
        } else
        {
            contentvalues.put("insert_dtm", s);
            contentvalues.put("user", s1);
            contentvalues.put("canonical_name", metaitem.getId());
            PMApplication.getContext().getContentResolver().insert(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, contentvalues);
        }
        cleanupCursor(((Cursor) (obj)));
    }

    public void addNewSearchToSavedSearches(String s)
    {
        String s1 = DateUtils.getTimeStampStringFromUTCDate(new Date());
        ContentValues contentvalues = new ContentValues();
        String s2 = PMApplicationSession.GetPMSession().getUserId();
        Object obj = String.format("SELECT keyword FROM saved_searches WHERE keyword ='%s'  AND user = '%s'", new Object[] {
            SqlStore.sqlEscape(s), s2
        });
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_SAVED_SEARCHES, null, ((String) (obj)), null, null);
        if (obj != null && ((Cursor) (obj)).getCount() == 1)
        {
            contentvalues.put("insert_dtm", s1);
            s = SqlStore.sqlEscape(s);
            PMApplication.getContext().getContentResolver().update(PMDbContentProvider.CONTENT_URI_SAVED_SEARCHES, contentvalues, "keyword=?", new String[] {
                s
            });
        } else
        {
            contentvalues.put("insert_dtm", s1);
            contentvalues.put("user", s2);
            contentvalues.put("keyword", s);
            PMApplication.getContext().getContentResolver().insert(PMDbContentProvider.CONTENT_URI_SAVED_SEARCHES, contentvalues);
        }
        cleanupCursor(((Cursor) (obj)));
    }

    public void followBrand(String s)
    {
        if (!isFollowingBrand(s))
        {
            String s1 = PMApplicationSession.GetPMSession().getUserId();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("canonical_name", s);
            contentvalues.put("user", s1);
            PMApplication.getContext().getContentResolver().insert(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, contentvalues);
        }
    }

    public List getAllBrands()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_BRANDS, null, " SELECT * from brands", null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            int i = cursor.getColumnIndex("canonical_name");
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                String s = cursor.getString(i);
                arraylist.add(new MetaItem(s, s));
            }

        }
        cleanupCursor(cursor);
        return arraylist;
    }

    public List getAllCategories()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY, null, " SELECT * from category", null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            int i = cursor.getColumnIndex("canonical_name");
            int j = cursor.getColumnIndex("_id");
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                String s = cursor.getString(i);
                arraylist.add(new MetaItem(cursor.getString(j), s));
            }

        }
        cleanupCursor(cursor);
        return arraylist;
    }

    public List getAllColors()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_COLORS, null, " SELECT * from colors", null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            int i = cursor.getColumnIndex("_id");
            int j = cursor.getColumnIndex("rgb");
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                arraylist.add(new PMColor(cursor.getString(i), cursor.getString(j)));
            }

        }
        cleanupCursor(cursor);
        return arraylist;
    }

    public List getAllFollowingBrands()
    {
        Object obj1 = null;
        Object obj = String.format("SELECT canonical_name FROM following WHERE user='%s'", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        });
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, null, ((String) (obj)), null, null);
        obj = obj1;
        if (cursor != null)
        {
            obj = obj1;
            if (cursor.getCount() > 0)
            {
                ArrayList arraylist = new ArrayList();
                cursor.moveToFirst();
                int i = cursor.getColumnIndex("canonical_name");
                do
                {
                    obj = arraylist;
                    if (cursor.isAfterLast())
                    {
                        break;
                    }
                    arraylist.add(cursor.getString(i));
                    cursor.moveToNext();
                } while (true);
            }
        }
        cleanupCursor(cursor);
        return ((List) (obj));
    }

    public List getAllSizesForCategory(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = String.format(" SELECT * from sizes WHERE _id ='%s'", new Object[] {
            s
        });
        s = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY_SIZES, null, s, null, null);
        if (s != null && s.getCount() > 0)
        {
            s.moveToFirst();
            int i = s.getColumnIndex("short_name");
            int j = s.getColumnIndex("long_name");
            for (; !s.isAfterLast(); s.moveToNext())
            {
                arraylist.add(new MetaItem(s.getString(i), s.getString(j)));
            }

        }
        cleanupCursor(s);
        return arraylist;
    }

    public List getAllSubCategoriesForCategory(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = String.format(" SELECT * from subcategory WHERE category_id ='%s'", new Object[] {
            s
        });
        s = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY_STYLE_TAGS, null, s, null, null);
        if (s != null && s.getCount() > 0)
        {
            s.moveToFirst();
            int i = s.getColumnIndex("_id");
            int j = s.getColumnIndex("name");
            for (; !s.isAfterLast(); s.moveToNext())
            {
                arraylist.add(new MetaItem(s.getString(i), s.getString(j)));
            }

        }
        cleanupCursor(s);
        return arraylist;
    }

    public String getBrandCanonicalName(String s)
    {
        s = String.format(" SELECT canonical_name from brands WHERE canonical_name ='%s'", new Object[] {
            SqlStore.sqlEscape(s)
        });
        Object obj = null;
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_BRANDS, null, s, null, null);
        s = obj;
        if (cursor != null)
        {
            s = obj;
            if (cursor.getCount() == 1)
            {
                cursor.moveToFirst();
                s = cursor.getString(cursor.getColumnIndex("canonical_name"));
            }
        }
        cleanupCursor(cursor);
        return s;
    }

    public MetaItem getCategoryFromId(String s)
    {
        Object obj1 = null;
        Object obj = String.format(" SELECT canonical_name from category WHERE _id ='%s'", new Object[] {
            SqlStore.sqlEscape(s)
        });
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY, null, ((String) (obj)), null, null);
        obj = obj1;
        if (cursor != null)
        {
            obj = obj1;
            if (cursor.getCount() == 1)
            {
                cursor.moveToFirst();
                obj = new MetaItem(s, cursor.getString(cursor.getColumnIndex("canonical_name")));
            }
        }
        cleanupCursor(cursor);
        return ((MetaItem) (obj));
    }

    public MetaItem getCategoryFromLabel(String s)
    {
        Object obj = null;
        s = String.format(" SELECT * from category WHERE canonical_name ='%s'", new Object[] {
            SqlStore.sqlEscape(s)
        });
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY, null, s, null, null);
        s = obj;
        if (cursor != null)
        {
            s = obj;
            if (cursor.getCount() == 1)
            {
                cursor.moveToFirst();
                int i = cursor.getColumnIndex("canonical_name");
                int j = cursor.getColumnIndex("_id");
                s = cursor.getString(i);
                s = new MetaItem(cursor.getString(j), s);
            }
        }
        cleanupCursor(cursor);
        return s;
    }

    public PMColor getColorFromName(String s)
    {
        Object obj = null;
        s = String.format(" SELECT * from colors WHERE _id ='%s'", new Object[] {
            s
        });
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_COLORS, null, s, null, null);
        s = obj;
        if (cursor != null)
        {
            s = obj;
            if (cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                int i = cursor.getColumnIndex("_id");
                int j = cursor.getColumnIndex("rgb");
                s = new PMColor(cursor.getString(i), cursor.getString(j));
            }
        }
        cleanupCursor(cursor);
        return s;
    }

    public int getFollowingBrandsCount()
    {
        Object obj = String.format("SELECT canonical_name FROM following WHERE user='%s'", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        });
        boolean flag = false;
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, null, ((String) (obj)), null, null);
        int i = ((flag) ? 1 : 0);
        if (obj != null)
        {
            i = ((flag) ? 1 : 0);
            if (((Cursor) (obj)).getCount() > 0)
            {
                i = ((Cursor) (obj)).getCount();
            }
        }
        cleanupCursor(((Cursor) (obj)));
        return i;
    }

    public Object getMutex()
    {
        return mutex;
    }

    public List getRecentBrands()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = String.format("select * from recent_brands WHERE user='%s' ORDER BY insert_dtm COLLATE NOCASE DESC", new Object[] {
            PMApplicationSession.GetPMSession().getUserId()
        });
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, null, ((String) (obj)), null, null);
        if (obj != null && ((Cursor) (obj)).getCount() > 0)
        {
            ((Cursor) (obj)).getColumnIndex("canonical_name");
            ((Cursor) (obj)).moveToFirst();
            for (; !((Cursor) (obj)).isAfterLast(); ((Cursor) (obj)).moveToNext())
            {
                String s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("canonical_name"));
                arraylist.add(new MetaItem(s, s));
            }

        }
        cleanupCursor(((Cursor) (obj)));
        return arraylist;
    }

    public List getRecentBrandsAndFollowingBrands()
    {
        ArrayList arraylist = new ArrayList();
        String s = PMApplicationSession.GetPMSession().getUserId();
        Object obj = String.format("select canonical_name,insert_dtm from recent_brands WHERE user='%s'", new Object[] {
            s
        });
        s = String.format("select canonical_name,Null  from following WHERE user='%s'", new Object[] {
            s
        });
        obj = (new StringBuilder()).append(((String) (obj))).append(" UNION ").append(s).append(" ORDER BY ").append("insert_dtm").append(" DESC").toString();
        obj = (new StringBuilder()).append("SELECT DISTINCT canonical_name FROM (").append(((String) (obj))).append(" )").toString();
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_RECENTS_BRANDS, null, ((String) (obj)), null, null);
        if (obj != null && ((Cursor) (obj)).getCount() > 0)
        {
            ((Cursor) (obj)).moveToFirst();
            for (; !((Cursor) (obj)).isAfterLast(); ((Cursor) (obj)).moveToNext())
            {
                String s1 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("canonical_name"));
                arraylist.add(new MetaItem(s1, s1));
            }

        }
        cleanupCursor(((Cursor) (obj)));
        return arraylist;
    }

    public MetaItem getSizeForCategoryFromLabel(String s, String s1)
    {
        Object obj = null;
        s = String.format("SELECT *  FROM sizes WHERE short_name = '%s'  AND _id = '%s'", new Object[] {
            SqlStore.sqlEscape(s1), s
        });
        s1 = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY_SIZES, null, s, null, null);
        s = obj;
        if (s1 != null)
        {
            s = obj;
            if (s1.getCount() > 0)
            {
                s1.moveToFirst();
                int i = s1.getColumnIndex("short_name");
                int j = s1.getColumnIndex("long_name");
                s1.getColumnIndex("_id");
                s = new MetaItem(s1.getString(i), s1.getString(j));
            }
        }
        cleanupCursor(s1);
        return s;
    }

    public MetaItem getSubCategoryFromId(String s)
    {
        Object obj = null;
        s = String.format(" SELECT _id,name from subcategory WHERE _id ='%s'", new Object[] {
            s
        });
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY_STYLE_TAGS, null, s, null, null);
        s = obj;
        if (cursor != null)
        {
            s = obj;
            if (cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                int i = cursor.getColumnIndex("_id");
                int j = cursor.getColumnIndex("name");
                s = new MetaItem(cursor.getString(i), cursor.getString(j));
            }
        }
        cleanupCursor(cursor);
        return s;
    }

    public MetaItem getSubCategoryFromLabel(String s)
    {
        Object obj = null;
        s = String.format(" SELECT _id,name from subcategory WHERE name ='%s'", new Object[] {
            s
        });
        Cursor cursor = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_CATEGORY_STYLE_TAGS, null, s, null, null);
        s = obj;
        if (cursor != null)
        {
            s = obj;
            if (cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                int i = cursor.getColumnIndex("_id");
                int j = cursor.getColumnIndex("name");
                s = new MetaItem(cursor.getString(i), cursor.getString(j));
            }
        }
        cleanupCursor(cursor);
        return s;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.NEW_BRANDS_ON_SERVER"))
        {
            Object obj = intent.getBundleExtra("RESULT");
            intent = ((Bundle) (obj)).getString("ALL_BRANDS_UPDATE_DTM");
            obj = ((Bundle) (obj)).getString("FOLLOWING_BRANDS_UPDATE_DTM");
            updateAllBrands(intent, "brands");
            updateFollowingBrands(((String) (obj)), PMApplicationSession.GetPMSession().getUserId());
        } else
        {
            if (intent.getAction().equals("com.poshmark.intents.NEW_CATALOG_ON_SERVER"))
            {
                updateCatalog(intent.getBundleExtra("RESULT").getString("CATALOG_UPDATE_DTM"), "category");
                return;
            }
            if (intent.getAction().equals("com.poshmark.intents.LOGIN_COMPLETE"))
            {
                intent = new RecentBrandsUpdater();
                Void avoid[] = new Void[0];
                if (!(intent instanceof AsyncTask))
                {
                    intent.execute(avoid);
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)intent, avoid);
                }
                intent = new SavedSearchesUpdater();
                avoid = new Void[0];
                if (!(intent instanceof AsyncTask))
                {
                    intent.execute(avoid);
                    return;
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)intent, avoid);
                    return;
                }
            }
        }
    }

    public boolean isBrand(String s)
    {
        boolean flag1 = false;
        s = String.format(" SELECT canonical_name from brands WHERE canonical_name ='%s'", new Object[] {
            SqlStore.sqlEscape(s)
        });
        s = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_BRANDS, null, s, null, null);
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.getCount() == 1)
            {
                flag = true;
            }
        }
        cleanupCursor(s);
        return flag;
    }

    public boolean isFollowingBrand(String s)
    {
        boolean flag1 = false;
        s = String.format("SELECT canonical_name FROM following WHERE canonical_name='%s' AND user ='%s'  COLLATE NOCASE", new Object[] {
            SqlStore.sqlEscape(s), PMApplicationSession.GetPMSession().getUserId()
        });
        s = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, null, s, null, null);
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.getCount() == 1)
            {
                flag = true;
            }
        }
        cleanupCursor(s);
        return flag;
    }

    public boolean isKeywordInSavedSearches(String s)
    {
        boolean flag1 = false;
        String s1 = PMApplicationSession.GetPMSession().getUserId();
        s = String.format("SELECT keyword FROM saved_searches WHERE keyword ='%s'  AND user = '%s'", new Object[] {
            SqlStore.sqlEscape(s), s1
        });
        s = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_SAVED_SEARCHES, null, s, null, null);
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.getCount() == 1)
            {
                flag = true;
            }
        }
        cleanupCursor(s);
        return flag;
    }

    public void populateCursorWithRecentSavedSearches(CustomMatrixCursor custommatrixcursor, int i)
    {
        Object obj = String.format("select * from saved_searches WHERE user='%s' ORDER BY insert_dtm desc  LIMIT %s", new Object[] {
            PMApplicationSession.GetPMSession().getUserId(), Integer.valueOf(i)
        });
        obj = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_SAVED_SEARCHES, null, ((String) (obj)), null, null);
        if (obj != null && ((Cursor) (obj)).getCount() >= 1)
        {
            ((Cursor) (obj)).moveToFirst();
            for (; !((Cursor) (obj)).isAfterLast(); ((Cursor) (obj)).moveToNext())
            {
                String s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("keyword"));
                SuggestedSearchItem suggestedsearchitem = new SuggestedSearchItem();
                suggestedsearchitem.kw = s;
                custommatrixcursor.addRow(new Object[] {
                    Integer.valueOf(0), suggestedsearchitem
                });
            }

        }
        cleanupCursor(((Cursor) (obj)));
    }

    public void populateCursorWithRelevantSavedSearches(CustomMatrixCursor custommatrixcursor, String s)
    {
        String s1 = PMApplicationSession.GetPMSession().getUserId();
        s = String.format("SELECT keyword FROM saved_searches WHERE keyword LIKE '%s%%'  AND user = '%s'", new Object[] {
            SqlStore.sqlEscape(s), s1
        });
        s = PMApplication.getContext().getContentResolver().query(PMDbContentProvider.CONTENT_URI_SAVED_SEARCHES, null, s, null, null);
        if (s != null && s.getCount() >= 1)
        {
            s.moveToFirst();
            for (; !s.isAfterLast(); s.moveToNext())
            {
                String s2 = s.getString(s.getColumnIndex("keyword"));
                SuggestedSearchItem suggestedsearchitem = new SuggestedSearchItem();
                suggestedsearchitem.kw = s2;
                custommatrixcursor.addRow(new Object[] {
                    Integer.valueOf(0), suggestedsearchitem
                });
            }

        }
        cleanupCursor(s);
    }

    public void unFollowBrand(String s)
    {
        if (isFollowingBrand(s))
        {
            String s1 = PMApplicationSession.GetPMSession().getUserId();
            PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_FOLLOWING_BRANDS, "canonical_name=? AND user=?", new String[] {
                s, s1
            });
        }
    }
}
