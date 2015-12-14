// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

final class VersionColumns
{
    public static abstract class BaseCursorWrapper
        implements Cloneable
    {

        protected final long id;

        public static final boolean isValid(Cursor cursor)
        {
            return cursor != null && !cursor.isAfterLast() && !cursor.isBeforeFirst();
        }

        public abstract Object clone();

        public final long getId()
        {
            return id;
        }

        public BaseCursorWrapper(long l)
        {
            id = l;
        }
    }

    public static class VersionCursorWrapper extends BaseCursorWrapper
    {

        private String assetsBaseURL;
        private String versionKey;

        public static VersionCursorWrapper create(Cursor cursor)
        {
            if (isValid(cursor))
            {
                VersionCursorWrapper versioncursorwrapper = new VersionCursorWrapper(cursor.getLong(cursor.getColumnIndex("version_id")));
                int i = cursor.getColumnIndex("version_versionKey");
                if (i > -1)
                {
                    versioncursorwrapper.versionKey = cursor.getString(i);
                }
                i = cursor.getColumnIndex("version_assetsBaseURL");
                if (i > -1)
                {
                    versioncursorwrapper.assetsBaseURL = cursor.getString(i);
                }
                return versioncursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            VersionCursorWrapper versioncursorwrapper = new VersionCursorWrapper(id);
            versioncursorwrapper.assetsBaseURL = assetsBaseURL;
            versioncursorwrapper.versionKey = versionKey;
            return versioncursorwrapper;
        }

        public String getAssetsBaseURL()
        {
            return assetsBaseURL;
        }

        public String getVersionKey()
        {
            return versionKey;
        }

        public String toString()
        {
            return (new StringBuilder()).append("VersionColumns.Version{ id: ").append(id).append(", versionKey: ").append(versionKey).append(", assetsBaseURL: ").append(assetsBaseURL).append(" }").toString();
        }

        public VersionCursorWrapper(long l)
        {
            super(l);
        }
    }


    public static final String ASSETS_BASE_URL = "version_assetsBaseURL";
    public static final String TABLE_NAME = "version_table";
    public static final String VERSION_KEY = "version_versionKey";
    public static final String _ID = "version_id";

    private VersionColumns()
    {
    }
}
