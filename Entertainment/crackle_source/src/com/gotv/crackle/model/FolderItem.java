// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.StringUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.model:
//            PlayListItem

public class FolderItem
{

    private static final String DATE_ADDED = "DateAdded";
    private static final String DATE_LAST_MODIFIED = "DateLastModified";
    private static final String DISPLAY_ORDER = "DisplayOrder";
    public static final String FOLDER_LIST = "FolderList";
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String PLAY_LIST_LIST = "PlaylistList";
    private Date mDateAdded;
    private Date mDateLastModified;
    private String mDisplayOrder;
    private String mID;
    private String mName;
    private List mPlayLists;

    public FolderItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("ID");
        mName = StringUtil.removeHtmlFromString(jsonobject.getString("Name"));
        mDisplayOrder = jsonobject.getString("DisplayOrder");
        String s = jsonobject.getString("DateAdded");
        try
        {
            mDateAdded = DateTimeFormatter.parseJSONDateString(s, "M/d/yyyy h:mm:ss a");
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
        }
        s = jsonobject.getString("DateLastModified");
        try
        {
            mDateLastModified = DateTimeFormatter.parseJSONDateString(s, "M/d/yyyy h:mm:ss a");
        }
        catch (ParseException parseexception1) { }
        mPlayLists = new ArrayList();
        jsonobject = jsonobject.getJSONArray("PlaylistList");
        for (int i = 0; i < jsonobject.length(); i++)
        {
            PlayListItem playlistitem = new PlayListItem(jsonobject.getJSONObject(i));
            if (playlistitem != null)
            {
                mPlayLists.add(playlistitem);
            }
        }

    }

    public Date getDateAdded()
    {
        return mDateAdded;
    }

    public Date getDateLastModified()
    {
        return mDateLastModified;
    }

    public String getDisplayOrder()
    {
        return mDisplayOrder;
    }

    public String getID()
    {
        return mID;
    }

    public String getName()
    {
        return mName;
    }

    public List getPlayLists()
    {
        return mPlayLists;
    }
}
