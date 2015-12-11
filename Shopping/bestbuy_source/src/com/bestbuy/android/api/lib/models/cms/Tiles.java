// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.cms;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.cms:
//            Tile

public class Tiles
{

    private static ArrayList tileArray;
    private int index;
    private String title;

    public Tiles()
    {
    }

    public static ArrayList loadData(JSONObject jsonobject)
    {
        ArrayList arraylist = new ArrayList();
        jsonobject = jsonobject.optJSONArray("sections");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                Object obj = jsonobject.optJSONObject(i);
                Tiles tiles = new Tiles();
                tiles.index = ((JSONObject) (obj)).optInt("index");
                tiles.title = ((JSONObject) (obj)).optString("title");
                tileArray = new ArrayList();
                obj = ((JSONObject) (obj)).optJSONArray("items");
                if (obj != null)
                {
                    for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
                    {
                        tileArray.add(Tile.loadData(((JSONArray) (obj)).optJSONObject(j)));
                    }

                }
                arraylist.add(tiles);
            }

        }
        return arraylist;
    }

    public int getIndex()
    {
        return index;
    }

    public ArrayList getTileArray()
    {
        return tileArray;
    }

    public String getTitle()
    {
        return title;
    }
}
