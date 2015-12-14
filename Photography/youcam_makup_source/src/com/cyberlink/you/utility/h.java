// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.n;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.utility:
//            d

public class h
{

    public static Friend a(JSONObject jsonobject)
    {
        Friend friend;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        friend = new Friend();
        JSONObject jsonobject1;
        friend.a = jsonobject.getLong("userId");
        friend.a(jsonobject.getString("displayName"));
        friend.b = jsonobject.getString("avatar");
        friend.c = jsonobject.getString("jid");
        if (jsonobject.has("isBlocked"))
        {
            friend.d = jsonobject.getBoolean("isBlocked");
        }
        if (!jsonobject.has("attrs"))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        jsonobject1 = jsonobject.getJSONObject("attrs");
        if (jsonobject1 == null);
        return friend;
        JSONException jsonexception;
        jsonexception;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[paresUserInfoFromServerResponse] 'userId', 'displaName', 'avatar' missing. JSONstr=").append(jsonobject.toString()).toString());
        return null;
    }

    public static List a(JSONArray jsonarray)
    {
        if (jsonarray != null)
        {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    arraylist.add(c(jsonarray.getJSONObject(i)));
                }
                catch (JSONException jsonexception) { }
                i++;
            }
            return arraylist;
        } else
        {
            return null;
        }
    }

    public static List a(JSONArray jsonarray, boolean flag, boolean flag1)
    {
        ArrayList arraylist;
        int i;
        if (jsonarray == null)
        {
            return null;
        }
        arraylist = new ArrayList();
        i = 0;
_L2:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = jsonarray.getJSONObject(i);
        Object obj1;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        long l2;
        long l3;
        l2 = jsonobject1.getLong("packId");
        s1 = jsonobject1.getString("packType");
        s2 = jsonobject1.getString("purchaseType");
        s3 = jsonobject1.getString("packName");
        s4 = jsonobject1.getString("description");
        s5 = jsonobject1.getString("expiration");
        l3 = jsonobject1.getLong("lastModified");
        obj1 = com.cyberlink.you.database.StickerPackObj.Status.a;
        String s = "";
        n n1;
        if (jsonobject1.has("publishedDate"))
        {
            s = jsonobject1.getString("iapItem");
        }
        n1 = new n();
        JSONObject jsonobject = jsonobject1.getJSONObject("url");
        n1.a = jsonobject.getString("zip");
        n1.b = jsonobject.getString("cover");
        n1.d = jsonobject.getString("thumbnail");
        n1.f = jsonobject.getString("preview");
        Object obj;
        if (!flag)
        {
            obj = obj1;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_315;
            }
        }
        obj = com.cyberlink.you.utility.d.a(l2);
        n1.c = (new StringBuilder()).append(((String) (obj))).append(File.separator).append("cover").toString();
        n1.e = (new StringBuilder()).append(((String) (obj))).append(File.separator).append("thumbnail").toString();
        n1.g = (new StringBuilder()).append(((String) (obj))).append(File.separator).append("preview").toString();
        obj = obj1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj = com.cyberlink.you.database.StickerPackObj.Status.b;
        String s6;
        Object obj2;
        long l1;
        obj2 = jsonobject1.getJSONObject("publisher");
        l1 = ((JSONObject) (obj2)).getLong("lastModified");
        obj1 = ((JSONObject) (obj2)).getString("name");
        s6 = ((JSONObject) (obj2)).getString("titleOfUrl");
        obj2 = ((JSONObject) (obj2)).getString("url");
        long l = l1;
        if (!jsonobject1.has("publishedDate"))
        {
            break MISSING_BLOCK_LABEL_397;
        }
        l = l1;
        if (!jsonobject1.isNull("publishedDate"))
        {
            l = jsonobject1.getLong("publishedDate");
        }
        arraylist.add(new StickerPackObj(-1L, l2, s1, s2, s3, s4, s5, n1, ((com.cyberlink.you.database.StickerPackObj.Status) (obj)), l3, l, ((String) (obj1)), s6, ((String) (obj2)), flag1, s));
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[sticker.pack.info] groupinfo parse error. JSONstr=").append(jsonarray.toString()).toString());
          goto _L3
        jsonexception;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[sticker.pack.info] Parse item error. JSONstr=").append(jsonobject1.toString()).toString());
          goto _L3
_L1:
        return arraylist;
    }

    public static JSONObject a(String s)
    {
        JSONObject jsonobject1 = null;
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(s);
        }
        catch (JSONException jsonexception)
        {
            Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseJObj] Parse error. JSONstr=").append(s).toString());
            jsonexception = null;
        }
        if (jsonobject != null)
        {
            try
            {
                jsonobject1 = jsonobject.getJSONObject("result");
            }
            catch (JSONException jsonexception1)
            {
                Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseResults] 'result' missing. JSONstr=").append(s).toString());
                return null;
            }
        }
        return jsonobject1;
    }

    public static UserInfo b(JSONObject jsonobject)
    {
        boolean flag1 = true;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        UserInfo userinfo = new UserInfo();
        userinfo.a = jsonobject.getLong("userId");
        if (!jsonobject.isNull("displayName")) goto _L4; else goto _L3
_L3:
        Object obj = "";
_L12:
        userinfo.b = ((String) (obj));
        if (!jsonobject.isNull("avatar")) goto _L6; else goto _L5
_L5:
        obj = "";
_L10:
        JSONObject jsonobject1;
        userinfo.c = ((String) (obj));
        userinfo.f = jsonobject.getString("jid");
        jsonobject1 = jsonobject.getJSONObject("attrs");
        obj = userinfo;
        if (jsonobject1 == null) goto _L8; else goto _L7
_L7:
        if (jsonobject1.has("attr_publicKey"))
        {
            userinfo.m = jsonobject1.getString("attr_publicKey");
        }
        if (jsonobject1.has("notification.disabled"))
        {
            userinfo.n = jsonobject1.getString("notification.disabled").equals("0");
        }
        if (!jsonobject1.has("profile.publicId.enabled"))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        boolean flag;
        if (!jsonobject1.getString("profile.publicId.enabled").equals("0"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        userinfo.o = flag;
        if (!jsonobject1.has("friend.autoInvite.enabled"))
        {
            break MISSING_BLOCK_LABEL_189;
        }
        if (!jsonobject1.getString("friend.autoInvite.enabled").equals("0"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        userinfo.p = flag;
        if (!jsonobject1.has("friend.autoAccept.enabled"))
        {
            break MISSING_BLOCK_LABEL_221;
        }
        if (!jsonobject1.getString("friend.autoAccept.enabled").equals("0"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        userinfo.q = flag;
        obj = userinfo;
        if (!jsonobject1.has("notification.hide.message")) goto _L8; else goto _L9
_L9:
        if (!jsonobject1.getString("notification.hide.message").equals("0"))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        userinfo.r = flag;
        return userinfo;
_L4:
        try
        {
            obj = jsonobject.getString("displayName");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("FriendsClientUtils", (new StringBuilder()).append("[paresUserInfoFromServerResponse] 'userId', 'displaName', 'avatar' missing. JSONstr=").append(jsonobject.toString()).toString());
        }
          goto _L2
_L6:
        obj = jsonobject.getString("avatar");
          goto _L10
_L2:
        obj = null;
_L8:
        return ((UserInfo) (obj));
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static List b(JSONArray jsonarray)
    {
        if (jsonarray != null)
        {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    arraylist.add(a(jsonarray.getJSONObject(i)));
                }
                catch (JSONException jsonexception) { }
                i++;
            }
            return arraylist;
        } else
        {
            return null;
        }
    }

    public static JSONArray b(String s)
    {
        JSONArray jsonarray = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj = new JSONObject(s);
_L4:
        if (obj != null)
        {
            try
            {
                jsonarray = ((JSONObject) (obj)).getJSONArray("results");
            }
            catch (JSONException jsonexception)
            {
                Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseResults] 'results' missing. JSONstr=").append(s).toString());
                return null;
            }
        }
        return jsonarray;
        obj;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseJObj] Parse error. JSONstr=").append(s).toString());
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Group c(JSONObject jsonobject)
    {
        Group group;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        group = new Group();
        group.e = jsonobject.getString("groupType");
        if (!jsonobject.isNull("displayName"))
        {
            break MISSING_BLOCK_LABEL_141;
        }
        Object obj = "";
_L1:
        group.f = ((String) (obj));
        group.h = Long.valueOf(jsonobject.getLong("lastModified"));
        group.b = jsonobject.getLong("groupId");
        group.g = jsonobject.getLong("numberOfMember");
        group.c = jsonobject.getString("jid");
        group.d = jsonobject.getString("avatar");
        if (jsonobject.has("isDisabled"))
        {
            group.i = jsonobject.getBoolean("isDisabled");
        }
        obj = group;
        if (!jsonobject.has("isNotificationDisabled"))
        {
            break MISSING_BLOCK_LABEL_183;
        }
        group.j = jsonobject.getBoolean("isNotificationDisabled");
        return group;
        obj = jsonobject.getString("displayName");
          goto _L1
        obj;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseGroupInfoFromJSONObj] JSONstr=").append(jsonobject.toString()).toString());
        obj = null;
        return ((Group) (obj));
    }

    public static List c(JSONArray jsonarray)
    {
        if (jsonarray != null)
        {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    arraylist.add(e(jsonarray.getJSONObject(i)));
                }
                catch (JSONException jsonexception) { }
                i++;
            }
            return arraylist;
        } else
        {
            return Collections.EMPTY_LIST;
        }
    }

    public static JSONObject c(String s)
    {
        Object obj1 = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj = new JSONObject(s);
_L4:
        JSONObject jsonobject = obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        JSONException jsonexception;
        try
        {
            obj = ((JSONObject) (obj)).getJSONArray("results");
        }
        catch (JSONException jsonexception1)
        {
            Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseResults] 'results' missing. JSONstr=").append(s).toString());
            return null;
        }
        jsonobject = obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        jsonobject = obj1;
        if (((JSONArray) (obj)).length() > 0)
        {
            jsonobject = ((JSONArray) (obj)).getJSONObject(0);
        }
        return jsonobject;
        jsonexception;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[parseJObj] Parse error. JSONstr=").append(s).toString());
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String d(JSONObject jsonobject)
    {
        String s;
        try
        {
            s = jsonobject.getString("status");
        }
        catch (JSONException jsonexception)
        {
            Log.d("FriendsClientUtils", (new StringBuilder()).append("[parseUserStatus] JObj=").append(jsonobject.toString()).toString());
            return null;
        }
        return s;
    }

    public static Friend e(JSONObject jsonobject)
    {
        Friend friend;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        friend = new Friend();
        friend.a = jsonobject.getLong("id");
        friend.a(jsonobject.getString("displayName"));
        friend.b = jsonobject.getString("avatarUrl");
        return friend;
        JSONException jsonexception;
        jsonexception;
        Log.e("FriendsClientUtils", (new StringBuilder()).append("[paresUserInfoFromServerResponse] 'userId', 'displaName', 'avatar' missing. JSONstr=").append(jsonobject.toString()).toString());
        return null;
    }
}
