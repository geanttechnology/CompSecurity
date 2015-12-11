// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.history.HistoryContentProvider;
import com.amazon.mShop.history.HistoryEntity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ResultWrapper, ViewItDBResultWrapper, ViewItSearchResultWrapper

public class ViewItDBHelper
{

    private AmazonActivity mActivity;
    private List mAllDBObjects;

    public ViewItDBHelper(Context context)
    {
        mAllDBObjects = new ArrayList();
        mActivity = (AmazonActivity)context;
    }

    public void delete(ResultWrapper resultwrapper)
    {
        if (resultwrapper == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("original_scanned_history in (\"").append(resultwrapper.getOriginalScannedOutput()).append("\")");
        mActivity.getContentResolver().delete(HistoryContentProvider.VISUAL_SEARCH_URI, stringbuilder.toString(), null);
        return;
        resultwrapper;
        Log.e("ViewItDBHelper", (new StringBuilder()).append("Error delete ResultWrapper object from DB:").append(resultwrapper.getMessage()).toString());
        return;
    }

    public void deleteAllObjectsFromDB()
    {
        String s;
        ContentResolver contentresolver;
        android.net.Uri uri;
        contentresolver = mActivity.getContentResolver();
        uri = HistoryContentProvider.VISUAL_SEARCH_URI;
        if (!User.isLoggedIn())
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s = User.getUser().getFullName();
_L1:
        contentresolver.delete(uri, "email=?", new String[] {
            s
        });
        return;
        s = "";
          goto _L1
        DBException dbexception;
        dbexception;
        Log.e("ViewItDBHelper", (new StringBuilder()).append("Error delete all objects from DB:").append(dbexception.getMessage()).toString());
        return;
    }

    public List getAllHistoryItems()
    {
        Cursor cursor;
        Cursor cursor1;
        mAllDBObjects.clear();
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = mActivity.getContentResolver().query(HistoryContentProvider.VISUAL_SEARCH_URI, HistoryEntity.HISTORY_VISION_PROJECTION, null, null, "visit_date DESC");
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        cursor2.moveToFirst();
_L4:
        cursor = cursor2;
        cursor1 = cursor2;
        String s = cursor2.getString(cursor2.getColumnIndex("original_scanned_history"));
        cursor = cursor2;
        cursor1 = cursor2;
        String s1 = cursor2.getString(cursor2.getColumnIndex("asin"));
        cursor = cursor2;
        cursor1 = cursor2;
        long l = cursor2.getLong(cursor2.getColumnIndex("visit_date"));
        cursor = cursor2;
        cursor1 = cursor2;
        Date date = Calendar.getInstance().getTime();
        cursor = cursor2;
        cursor1 = cursor2;
        date.setTime(l);
        cursor = cursor2;
        cursor1 = cursor2;
        mAllDBObjects.add(new ViewItDBResultWrapper(s, s1, date));
        cursor = cursor2;
        cursor1 = cursor2;
        boolean flag = cursor2.move(1);
        if (flag) goto _L4; else goto _L2
_L2:
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L6:
        return mAllDBObjects;
        DBException dbexception;
        dbexception;
        cursor1 = cursor;
        Log.e("ViewItDBHelper", (new StringBuilder()).append("Error get all ViewItDBResultWrapper objects from DB:").append(dbexception.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    public void insert(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        if (viewitsearchresultwrapper == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("original_scanned_history", viewitsearchresultwrapper.getOriginalScannedOutput());
        contentvalues.put("asin", viewitsearchresultwrapper.getSeriesAsinString());
        contentvalues.put("visit_date", Long.valueOf(viewitsearchresultwrapper.getScannedDate().getTime()));
        mActivity.getContentResolver().insert(HistoryContentProvider.VISUAL_SEARCH_URI, contentvalues);
        return;
        viewitsearchresultwrapper;
        Log.e("ViewItDBHelper", (new StringBuilder()).append("Error insert ViewItSearchResultWrapper object to DB:").append(viewitsearchresultwrapper.getMessage()).toString());
        return;
    }

    public void update(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        if (viewitsearchresultwrapper == null) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        s = viewitsearchresultwrapper.getSeriesAsinString();
        s1 = viewitsearchresultwrapper.getLatestScannedOutput(s);
        if (Util.isEmpty(s1)) goto _L4; else goto _L3
_L3:
        ContentValues contentvalues;
        ContentResolver contentresolver;
        android.net.Uri uri;
        String s2;
        contentvalues = new ContentValues();
        contentvalues.put("original_scanned_history", s1);
        contentvalues.put("asin", s);
        contentvalues.put("visit_date", Long.valueOf(viewitsearchresultwrapper.getScannedDate().getTime()));
        contentresolver = mActivity.getContentResolver();
        uri = HistoryContentProvider.VISUAL_SEARCH_URI;
        s2 = viewitsearchresultwrapper.getOriginalScannedOutput();
        if (!User.isLoggedIn())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        s = User.getUser().getFullName();
_L5:
        contentresolver.update(uri, contentvalues, "original_scanned_history=? AND email=?", new String[] {
            s2, s
        });
        viewitsearchresultwrapper.updateOriginalScannedOutput(s1);
        return;
_L4:
        try
        {
            delete(viewitsearchresultwrapper);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewItSearchResultWrapper viewitsearchresultwrapper)
        {
            Log.e("ViewItDBHelper", (new StringBuilder()).append("Error update ViewItSearchResultWrapper object to DB:").append(viewitsearchresultwrapper.getMessage()).toString());
        }
_L2:
        return;
        s = "";
          goto _L5
    }
}
