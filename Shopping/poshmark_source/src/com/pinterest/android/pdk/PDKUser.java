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
//            PDKModel, Utils

public class PDKUser extends PDKModel
{

    private String bio;
    private Integer boardsCount;
    private Date createdAt;
    private String firstName;
    private Integer followersCount;
    private Integer followingCount;
    private Integer imageHeight;
    private String imageUrl;
    private Integer imageWidth;
    private String lastName;
    private Integer likesCount;
    private Integer pinCount;
    private String uid;
    private String username;

    public PDKUser()
    {
    }

    public static PDKUser makeUser(Object obj)
    {
        PDKUser pdkuser = new PDKUser();
        try
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
                if (((JSONObject) (obj)).has("id"))
                {
                    pdkuser.setUid(((JSONObject) (obj)).getString("id"));
                }
                if (((JSONObject) (obj)).has("first_name"))
                {
                    pdkuser.setFirstName(((JSONObject) (obj)).getString("first_name"));
                }
                if (((JSONObject) (obj)).has("last_name"))
                {
                    pdkuser.setLastName(((JSONObject) (obj)).getString("last_name"));
                }
                if (((JSONObject) (obj)).has("username"))
                {
                    pdkuser.setUsername(((JSONObject) (obj)).getString("username"));
                }
                if (((JSONObject) (obj)).has("bio"))
                {
                    pdkuser.setBio(((JSONObject) (obj)).getString("bio"));
                }
                if (((JSONObject) (obj)).has("created_at"))
                {
                    pdkuser.setCreatedAt(Utils.getDateFormatter().parse(((JSONObject) (obj)).getString("created_at")));
                }
                if (((JSONObject) (obj)).has("counts"))
                {
                    JSONObject jsonobject = ((JSONObject) (obj)).getJSONObject("counts");
                    if (jsonobject.has("pins"))
                    {
                        pdkuser.setLikesCount(Integer.valueOf(jsonobject.getInt("pins")));
                    }
                    if (jsonobject.has("following"))
                    {
                        pdkuser.setFollowingCount(Integer.valueOf(jsonobject.getInt("following")));
                    }
                    if (jsonobject.has("followers"))
                    {
                        pdkuser.setFollowersCount(Integer.valueOf(jsonobject.getInt("followers")));
                    }
                    if (jsonobject.has("boards"))
                    {
                        pdkuser.setBoardsCount(Integer.valueOf(jsonobject.getInt("boards")));
                    }
                    if (jsonobject.has("likes"))
                    {
                        pdkuser.setLikesCount(Integer.valueOf(jsonobject.getInt("likes")));
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
                                pdkuser.setImageUrl(((JSONObject) (obj1)).getString("url"));
                            }
                        }
                    } while (true);
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKUser parse JSON error %s", new Object[] {
                ((JSONException) (obj)).getLocalizedMessage()
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKUser parse error %s", new Object[] {
                ((ParseException) (obj)).getLocalizedMessage()
            });
            return pdkuser;
        }
        return pdkuser;
    }

    public static List makeUserList(Object obj)
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
        arraylist.add(makeUser(((JSONArray) (obj)).getJSONObject(i)));
        i++;
        if (true) goto _L3; else goto _L2
        obj;
        Utils.loge("PDK: PDKUserList parse JSON error %s", new Object[] {
            ((JSONException) (obj)).getLocalizedMessage()
        });
_L2:
        return arraylist;
    }

    public String getBio()
    {
        return bio;
    }

    public Integer getBoardsCount()
    {
        return boardsCount;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public Integer getFollowersCount()
    {
        return followersCount;
    }

    public Integer getFollowingCount()
    {
        return followingCount;
    }

    public Integer getImageHeight()
    {
        return imageHeight;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public Integer getImageWidth()
    {
        return imageWidth;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Integer getLikesCount()
    {
        return likesCount;
    }

    public Integer getPinCount()
    {
        return pinCount;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setBio(String s)
    {
        bio = s;
    }

    public void setBoardsCount(Integer integer)
    {
        boardsCount = integer;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setFollowersCount(Integer integer)
    {
        followersCount = integer;
    }

    public void setFollowingCount(Integer integer)
    {
        followingCount = integer;
    }

    public void setImageHeight(Integer integer)
    {
        imageHeight = integer;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setImageWidth(Integer integer)
    {
        imageWidth = integer;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setLikesCount(Integer integer)
    {
        likesCount = integer;
    }

    public void setPinCount(Integer integer)
    {
        pinCount = integer;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }
}
