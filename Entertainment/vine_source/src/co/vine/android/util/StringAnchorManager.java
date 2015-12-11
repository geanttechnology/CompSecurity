// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package co.vine.android.util:
//            Util

public class StringAnchorManager
{
    public static class Editor
    {

        private final android.content.SharedPreferences.Editor mEditor;
        private final String mType;

        public void commit()
        {
            mEditor.commit();
        }

        public void setAnchor(String s)
        {
            mEditor.putString((new StringBuilder()).append("anchor_").append(mType).toString(), s);
        }

        public void setIndex(long l)
        {
            mEditor.putLong((new StringBuilder()).append("index_").append(mType).toString(), l);
        }

        public void setLastId(long l)
        {
            mEditor.putLong((new StringBuilder()).append("lastId_").append(mType).toString(), l);
        }

        public void setRefreshTime(long l)
        {
            mEditor.putLong((new StringBuilder()).append("refresh_time_").append(mType).toString(), l);
        }

        public Editor(android.content.SharedPreferences.Editor editor, String s)
        {
            mEditor = editor;
            mType = s;
        }
    }


    public static final int NONE_ID = 0;
    private static final String sPrefixAnchor = "anchor_";
    private static final String sPrefixIndex = "index_";
    private static final String sPrefixLastId = "lastId_";
    private static final String sPrefixRefreshTime = "refresh_time_";
    private final SharedPreferences mPrefs;
    private final String mType;

    public StringAnchorManager(Context context, String s)
    {
        mPrefs = Util.getSharedPrefs(context, "StringAnchorManager");
        mType = s;
    }

    public Editor edit()
    {
        return new Editor(mPrefs.edit(), mType);
    }

    public long getIndex()
    {
        return mPrefs.getLong((new StringBuilder()).append("index_").append(mType).toString(), -1L);
    }

    public long getLastId()
    {
        return mPrefs.getLong((new StringBuilder()).append("lastId_").append(mType).toString(), -1L);
    }

    public long getRefreshTime()
    {
        return mPrefs.getLong((new StringBuilder()).append("refresh_time_").append(mType).toString(), -1L);
    }

    public String getStringAnchor()
    {
        return mPrefs.getString((new StringBuilder()).append("anchor_").append(mType).toString(), null);
    }

    public boolean haveMore()
    {
        return getLastId() != 0L;
    }
}
