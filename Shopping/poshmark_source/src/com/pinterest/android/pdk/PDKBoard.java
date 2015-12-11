// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKModel, PDKUser, Utils

public class PDKBoard extends PDKModel
{

    private Integer collaboratorsCount;
    private Date createdAt;
    private PDKUser creator;
    private String description;
    private Integer followersCount;
    private String imageUrl;
    private String name;
    private Integer pinsCount;
    private String uid;

    public PDKBoard()
    {
    }

    public static PDKBoard makeBoard(Object obj)
    {
        PDKBoard pdkboard = new PDKBoard();
        try
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
                if (((JSONObject) (obj)).has("id"))
                {
                    pdkboard.setUid(((JSONObject) (obj)).getString("id"));
                }
                if (((JSONObject) (obj)).has("name"))
                {
                    pdkboard.setName(((JSONObject) (obj)).getString("name"));
                }
                if (((JSONObject) (obj)).has("description"))
                {
                    pdkboard.setDescription(((JSONObject) (obj)).getString("description"));
                }
                if (((JSONObject) (obj)).has("creator"))
                {
                    PDKUser.makeUser(((JSONObject) (obj)).getJSONObject("creator"));
                }
                if (((JSONObject) (obj)).has("created_at"))
                {
                    pdkboard.createdAt = Utils.getDateFormatter().parse(((JSONObject) (obj)).getString("created_at"));
                }
                if (((JSONObject) (obj)).has("counts"))
                {
                    JSONObject jsonobject = ((JSONObject) (obj)).getJSONObject("counts");
                    if (jsonobject.has("pins"))
                    {
                        pdkboard.setPinsCount(Integer.valueOf(jsonobject.getInt("pins")));
                    }
                    if (jsonobject.has("collaborators"))
                    {
                        pdkboard.setCollaboratorsCount(Integer.valueOf(jsonobject.getInt("collaborators")));
                    }
                    if (jsonobject.has("followers"))
                    {
                        pdkboard.setFollowersCount(Integer.valueOf(jsonobject.getInt("followers")));
                    }
                }
                if (((JSONObject) (obj)).has("image"))
                {
                    obj = ((JSONObject) (obj)).getJSONObject("image");
                    Iterator iterator = ((JSONObject) (obj)).keys();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        Object obj1 = (String)iterator.next();
                        if (((JSONObject) (obj)).get(((String) (obj1))) instanceof JSONObject)
                        {
                            obj1 = ((JSONObject) (obj)).getJSONObject(((String) (obj1)));
                            if (((JSONObject) (obj1)).has("url"))
                            {
                                pdkboard.setImageUrl(((JSONObject) (obj1)).getString("url"));
                            }
                        }
                    } while (true);
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKBoard parse JSON error %s", new Object[] {
                ((JSONException) (obj)).getLocalizedMessage()
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKBoard parse error %s", new Object[] {
                ((ParseException) (obj)).getLocalizedMessage()
            });
            return pdkboard;
        }
        return pdkboard;
    }

    public static List makeBoardList(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        if (!(obj instanceof JSONArray)) goto _L2; else goto _L1
_L1:
        int j;
        obj = (JSONArray)obj;
        j = ((JSONArray) (obj)).length();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(makeBoard(((JSONArray) (obj)).getJSONObject(i)));
        i++;
        if (true) goto _L3; else goto _L2
        obj;
        Utils.loge("PDK: PDKBoard parse JSON error %s", new Object[] {
            ((JSONException) (obj)).getLocalizedMessage()
        });
_L2:
        return arraylist;
    }

    public Integer getCollaboratorsCount()
    {
        return collaboratorsCount;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public PDKUser getCreator()
    {
        return creator;
    }

    public String getDescription()
    {
        return description;
    }

    public Integer getFollowersCount()
    {
        return followersCount;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getName()
    {
        return name;
    }

    public Integer getPinsCount()
    {
        return pinsCount;
    }

    public String getUid()
    {
        return uid;
    }

    public void setCollaboratorsCount(Integer integer)
    {
        collaboratorsCount = integer;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setCreator(PDKUser pdkuser)
    {
        creator = pdkuser;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setFollowersCount(Integer integer)
    {
        followersCount = integer;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPinsCount(Integer integer)
    {
        pinsCount = integer;
    }

    public void setUid(String s)
    {
        uid = s;
    }
}
