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
//            PDKModel, PDKUser, PDKBoard, Utils

public class PDKPin extends PDKModel
{

    private PDKBoard board;
    private Integer commentCount;
    private Date createdAt;
    private String imageUrl;
    private Integer likeCount;
    private String link;
    private String metadata;
    private String note;
    private Integer repinCount;
    private String uid;
    private PDKUser user;

    public PDKPin()
    {
    }

    public static PDKPin makePin(Object obj)
    {
        PDKPin pdkpin = new PDKPin();
        try
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
                if (((JSONObject) (obj)).has("id"))
                {
                    pdkpin.setUid(((JSONObject) (obj)).getString("id"));
                }
                if (((JSONObject) (obj)).has("link"))
                {
                    pdkpin.setLink(((JSONObject) (obj)).getString("link"));
                }
                if (((JSONObject) (obj)).has("note"))
                {
                    pdkpin.setNote(((JSONObject) (obj)).getString("note"));
                }
                if (((JSONObject) (obj)).has("metadata"))
                {
                    pdkpin.setMetadata(((JSONObject) (obj)).get("metadata").toString());
                }
                if (((JSONObject) (obj)).has("counts"))
                {
                    JSONObject jsonobject = ((JSONObject) (obj)).getJSONObject("counts");
                    if (jsonobject.has("likes"))
                    {
                        pdkpin.setLikeCount(Integer.valueOf(jsonobject.getInt("likes")));
                    }
                    if (jsonobject.has("comments"))
                    {
                        pdkpin.setCommentCount(Integer.valueOf(jsonobject.getInt("comments")));
                    }
                    if (jsonobject.has("repins"))
                    {
                        pdkpin.setRepinCount(Integer.valueOf(jsonobject.getInt("repins")));
                    }
                }
                if (((JSONObject) (obj)).has("metadata"))
                {
                    pdkpin.setMetadata(((JSONObject) (obj)).getString("metadata"));
                }
                if (((JSONObject) (obj)).has("creator"))
                {
                    PDKUser.makeUser(((JSONObject) (obj)).getJSONObject("creator"));
                }
                if (((JSONObject) (obj)).has("board"))
                {
                    PDKBoard.makeBoard(((JSONObject) (obj)).getJSONObject("board"));
                }
                if (((JSONObject) (obj)).has("created_at"))
                {
                    pdkpin.setCreatedAt(Utils.getDateFormatter().parse(((JSONObject) (obj)).getString("created_at")));
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
                                pdkpin.setImageUrl(((JSONObject) (obj1)).getString("url"));
                            }
                        }
                    } while (true);
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKPin JSON parse error %s", new Object[] {
                ((JSONException) (obj)).getLocalizedMessage()
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKPin Text parse error %s", new Object[] {
                ((ParseException) (obj)).getLocalizedMessage()
            });
            return pdkpin;
        }
        return pdkpin;
    }

    public static List makePinList(Object obj)
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
        arraylist.add(makePin(((JSONArray) (obj)).getJSONObject(i)));
        i++;
        if (true) goto _L3; else goto _L2
        obj;
        Utils.loge("PDK: PDKPinList parse JSON error %s", new Object[] {
            ((JSONException) (obj)).getLocalizedMessage()
        });
_L2:
        return arraylist;
    }

    public PDKBoard getBoard()
    {
        return board;
    }

    public Integer getCommentCount()
    {
        return commentCount;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public Integer getLikeCount()
    {
        return likeCount;
    }

    public String getLink()
    {
        return link;
    }

    public String getMetadata()
    {
        return metadata;
    }

    public String getNote()
    {
        return note;
    }

    public Integer getRepinCount()
    {
        return repinCount;
    }

    public String getUid()
    {
        return uid;
    }

    public PDKUser getUser()
    {
        return user;
    }

    public void setBoard(PDKBoard pdkboard)
    {
        board = pdkboard;
    }

    public void setCommentCount(Integer integer)
    {
        commentCount = integer;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setLikeCount(Integer integer)
    {
        likeCount = integer;
    }

    public void setLink(String s)
    {
        link = s;
    }

    public void setMetadata(String s)
    {
        metadata = s;
    }

    public void setNote(String s)
    {
        note = s;
    }

    public void setRepinCount(Integer integer)
    {
        repinCount = integer;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUser(PDKUser pdkuser)
    {
        user = pdkuser;
    }
}
