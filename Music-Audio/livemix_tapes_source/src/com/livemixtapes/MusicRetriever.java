// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicRetriever
{
    public static class Item
    {

        String album;
        String artist;
        long duration;
        long id;
        String title;

        public String getAlbum()
        {
            return album;
        }

        public String getArtist()
        {
            return artist;
        }

        public long getDuration()
        {
            return duration;
        }

        public long getId()
        {
            return id;
        }

        public String getTitle()
        {
            return title;
        }

        public Uri getURI()
        {
            return ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);
        }

        public Item(long l, String s, String s1, String s2, long l1)
        {
            id = l;
            artist = s;
            title = s1;
            album = s2;
            duration = l1;
        }
    }


    final String TAG = "MusicRetriever";
    ContentResolver mContentResolver;
    List mItems;
    Random mRandom;

    public MusicRetriever(ContentResolver contentresolver)
    {
        mItems = new ArrayList();
        mRandom = new Random();
        mContentResolver = contentresolver;
    }

    public ContentResolver getContentResolver()
    {
        return mContentResolver;
    }

    public Item getRandomItem()
    {
        if (mItems.size() <= 0)
        {
            return null;
        } else
        {
            return (Item)mItems.get(mRandom.nextInt(mItems.size()));
        }
    }

    public void prepare()
    {
        Object obj = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Log.i("MusicRetriever", "Querying media...");
        Log.i("MusicRetriever", (new StringBuilder("URI: ")).append(((Uri) (obj)).toString()).toString());
        Cursor cursor = mContentResolver.query(((Uri) (obj)), null, "is_music = 1", null, null);
        StringBuilder stringbuilder = new StringBuilder("Query finished. ");
        if (cursor == null)
        {
            obj = "Returned NULL.";
        } else
        {
            obj = "Returned a cursor.";
        }
        Log.i("MusicRetriever", stringbuilder.append(((String) (obj))).toString());
        if (cursor == null)
        {
            Log.e("MusicRetriever", "Failed to retrieve music: cursor is null :-(");
            return;
        }
        if (!cursor.moveToFirst())
        {
            Log.e("MusicRetriever", "Failed to move cursor to first row (no query results).");
            return;
        }
        Log.i("MusicRetriever", "Listing...");
        int i = cursor.getColumnIndex("artist");
        int j = cursor.getColumnIndex("title");
        int k = cursor.getColumnIndex("album");
        int l = cursor.getColumnIndex("duration");
        int i1 = cursor.getColumnIndex("_id");
        Log.i("MusicRetriever", (new StringBuilder("Title column index: ")).append(String.valueOf(j)).toString());
        Log.i("MusicRetriever", (new StringBuilder("ID column index: ")).append(String.valueOf(j)).toString());
        do
        {
            Log.i("MusicRetriever", (new StringBuilder("ID: ")).append(cursor.getString(i1)).append(" Title: ").append(cursor.getString(j)).toString());
            mItems.add(new Item(cursor.getLong(i1), cursor.getString(i), cursor.getString(j), cursor.getString(k), cursor.getLong(l)));
        } while (cursor.moveToNext());
        Log.i("MusicRetriever", "Done querying media. MusicRetriever is ready.");
    }
}
