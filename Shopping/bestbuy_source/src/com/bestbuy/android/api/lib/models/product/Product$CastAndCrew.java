// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ata
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList castAndCrewList;
    private ArrayList castMembers;
    private ArrayList directors;
    private ArrayList otherCrew;
    private ArrayList writers;

    public static ata getCastAndCrewData(JSONObject jsonobject)
    {
        boolean flag = false;
        ata ata = new <init>();
        ata.castMembers = new ArrayList();
        ata.castAndCrewList = new ArrayList();
        JSONArray jsonarray = jsonobject.getJSONArray("castMembers");
        Object obj = new ata("Cast Members", "", "", "");
        ata.castAndCrewList.add(obj);
        if (jsonarray != null)
        {
            int i = 0;
            while (i < jsonarray.length()) 
            {
                Object obj2 = jsonarray.optJSONObject(i);
                if (obj2 != null)
                {
                    String s1 = ((JSONObject) (obj2)).optString("displayName");
                    if (((JSONObject) (obj2)).optJSONArray("characterNames") == null)
                    {
                        obj = "";
                    } else
                    {
                        obj = ((JSONObject) (obj2)).optJSONArray("characterNames").optJSONObject(0).optString("displayName");
                    }
                    if (((JSONObject) (obj2)).optJSONObject("headshotImage") == null)
                    {
                        obj2 = "";
                    } else
                    {
                        obj2 = ((JSONObject) (obj2)).optJSONObject("headshotImage").optString("url");
                    }
                    obj = new ata(s1, ((String) (obj)), ((String) (obj2)), "");
                    ata.castMembers.add(obj);
                    ata.castAndCrewList.add(obj);
                }
                i++;
            }
        }
        obj = jsonobject.optJSONObject("crewMembers").optJSONArray("writers");
        ata.writers = new ArrayList();
        Object obj3 = new ata("Writers", "", "", "");
        ata.castAndCrewList.add(obj3);
        if (obj != null)
        {
            for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
            {
                obj3 = ((JSONArray) (obj)).optJSONObject(j);
                if (obj3 != null)
                {
                    obj3 = new ata(((JSONObject) (obj3)).optString("displayName"), "no char name", "no image", "");
                    ata.writers.add(obj3);
                    ata.castAndCrewList.add(obj3);
                }
            }

        }
        obj = jsonobject.optJSONObject("crewMembers").optJSONArray("directors");
        ata.directors = new ArrayList();
        obj3 = new ata("Directors", "", "", "");
        ata.castAndCrewList.add(obj3);
        if (obj != null)
        {
            for (int k = 0; k < ((JSONArray) (obj)).length(); k++)
            {
                Object obj4 = ((JSONArray) (obj)).optJSONObject(k);
                if (obj4 != null)
                {
                    obj4 = new ata(((JSONObject) (obj4)).optString("displayName"), "no char name", "no image", "");
                    ata.directors.add(obj4);
                    ata.castAndCrewList.add(obj4);
                }
            }

        }
        jsonobject = jsonobject.optJSONObject("crewMembers").optJSONArray("otherCrew");
        ata.otherCrew = new ArrayList();
        obj = new ata("Other Crew", "", "", "");
        ata.castAndCrewList.add(obj);
        if (jsonobject != null)
        {
            for (int l = ((flag) ? 1 : 0); l < jsonobject.length(); l++)
            {
                Object obj1 = jsonobject.optJSONObject(l);
                if (obj1 != null)
                {
                    String s = ((JSONObject) (obj1)).optString("role");
                    obj1 = new ata(((JSONObject) (obj1)).optString("displayName"), "", "no image", s);
                    ata.otherCrew.add(obj1);
                    ata.castAndCrewList.add(obj1);
                }
            }

        }
        return ata;
    }

    public ArrayList getCastAndCrewList()
    {
        return castAndCrewList;
    }

    public ArrayList getCastMembers()
    {
        return castMembers;
    }

    public ArrayList getDirectors()
    {
        return directors;
    }

    public ArrayList getOtherCrew()
    {
        return otherCrew;
    }

    public ArrayList getWriters()
    {
        return writers;
    }

    public ata()
    {
    }
}
