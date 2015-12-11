// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.registry.Entity;
import com.bestbuy.android.api.lib.models.registry.ListTypes;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.Recommendations;
import com.bestbuy.android.api.lib.models.registry.RecommendationsList;
import com.bestbuy.android.api.lib.models.registry.RefreshToken;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.RegistryWishListCompleteData;
import com.bestbuy.android.api.lib.models.registry.ShareURL;
import com.bestbuy.android.api.lib.models.registry.TokenResponse;
import com.bestbuy.android.api.lib.models.registry.TokenSIResponse;
import com.bestbuy.android.api.lib.models.registry.TokenServiceResponse;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONObject;

public class gj
{

    private static String a = "";

    public static Recommendations a(String s, int i)
    {
        Recommendations recommendations = new Recommendations();
        Object obj = c();
        s = (new StringBuilder()).append(((gr) (obj)).f).append(s).append("%26page=").append(i).append("&searchType=promo").toString();
        obj = d();
        try
        {
            s = Recommendations.parseRecommendationsData((new JSONObject(gw.a(s, null, ((List) (obj)), null, true))).optJSONObject("si").optJSONObject("response").optJSONObject("searchApi"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return recommendations;
        }
        return s;
    }

    public static RegistryWishList a(String s, String s1, String s2, WeddingRegistryData weddingregistrydata)
    {
        Object obj = c();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/users/").append(s).append("/").append(s1).toString();
        obj = d();
        ((List) (obj)).add(new BasicNameValuePair("access_token", s2));
        s2 = new JSONObject();
        s2.put("lists", a(weddingregistrydata, s1));
        s2.put("recipients", a(weddingregistrydata));
        if (s1.equalsIgnoreCase("weddingregistrylists"))
        {
            s2.put("affiliations", b(weddingregistrydata));
        }
        return e(gw.b(s, null, ((List) (obj)), s2.toString(), "application/json"));
    }

    public static RegistryWishList a(String s, String s1, String s2, String s3)
    {
        boolean flag = false;
        gr gr1 = c();
        s = (new StringBuilder()).append(gr1.f).append("/si/users/").append(s).append("/").append(s2).append("/").append(s1).toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s3));
        s1 = (new JSONObject(gw.a(s, new ArrayList(), s1, null, true))).optJSONObject("si").optJSONObject("response");
        s = s1.optJSONObject("lists");
        s2 = s.optJSONArray("entities");
        if (s != null)
        {
            s = null;
            for (int i = 0; i < s2.length(); i++)
            {
                s = RegistryWishList.parseRegistryWishListData(s2.optJSONObject(i));
            }

        } else
        {
            s = null;
        }
        if (s != null)
        {
            s2 = Recipient.parseRecipientResponse(s1.optJSONObject("recipients"));
            if (s2 != null)
            {
                for (int j = ((flag) ? 1 : 0); j < s2.size(); j++)
                {
                    s.setRecipient((Recipient)s2.get(j));
                }

            }
        }
        if (s != null)
        {
            s1 = s1.optJSONObject("affiliations");
            if (s1 != null)
            {
                s.setTheKnot(s1.optBoolean("theknot"));
                s.setMyRegistry(s1.optBoolean("myregistry"));
            }
        }
        return s;
    }

    public static RegistryWishListCompleteData a(String s, String s1, boolean flag, int i, String s2)
    {
        gr gr1 = c();
        ArrayList arraylist = new ArrayList();
        if (s2 != null && !s2.equals(""))
        {
            s = (new StringBuilder()).append(gr1.f).append("/si").append(s2).toString();
        } else
        {
            s2 = (new StringBuilder()).append(gr1.f).append("/si/giftRegistries").toString();
            arraylist.add(new BasicNameValuePair("type", s1));
            arraylist.add(new BasicNameValuePair("searchTerm", s));
            arraylist.add(new BasicNameValuePair("limit", Integer.toString(i)));
            s = s2;
        }
        s1 = d();
        try
        {
            s = f(gw.a(s, arraylist, s1, null, true));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static ArrayList a()
    {
        gr gr1 = c();
        return c(gw.a((new StringBuilder()).append(gr1.f).append("/si/eventTypes").toString(), null, d(), null, true));
    }

    public static ArrayList a(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        s1 = (new JSONObject(f(s, s1))).optJSONObject("si").optJSONObject("response");
        s = s1.optJSONObject("lists").optJSONArray("entities");
        if (s1 != null)
        {
            for (int i = 0; i < s.length(); i++)
            {
                s1 = RegistryWishList.parseRegistryWishListData(s.optJSONObject(i));
                if (!s1.getType().equals("weddingregistrylists") && !s1.isTransientFlag() && !s1.getType().equals("device"))
                {
                    arraylist.add(s1);
                }
            }

        }
        return arraylist;
    }

    public static ArrayList a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {
        gr gr1 = c();
        s = (new StringBuilder()).append(gr1.f).append("/si/users/").append(s).append("/").append(s3).append("/").append(s1).append("/gifts/").toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s7));
        s3 = new JSONObject();
        int i;
        if (s4 != null)
        {
            i = Integer.valueOf(s4).intValue();
        } else
        {
            i = 1;
        }
        s3.put("required-quantity", i);
        s3.put("sku", s2);
        s3.put("tags", s2);
        s3.put("created-by", s5);
        s3.put("last-updated-by", s6);
        s3.put("favorite", false);
        return b(gw.b(s, null, s1, s3.toString(), "application/json"));
    }

    private static JSONObject a(WeddingRegistryData weddingregistrydata)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("first-name", weddingregistrydata.getFirstName());
        jsonobject.put("last-name", weddingregistrydata.getLastName());
        jsonobject.put("address-line1", weddingregistrydata.getAddressLine1());
        jsonobject.put("address-line2", weddingregistrydata.getAddressLine2());
        jsonobject.put("address-city", weddingregistrydata.getCity());
        jsonobject.put("address-state", weddingregistrydata.getState());
        jsonobject.put("address-zip", weddingregistrydata.getZipCode());
        jsonobject.put("phone-number", weddingregistrydata.getPhone());
        jsonobject.put("country", "USA");
        jsonobject.put("phone-number-type", "Cell");
        jsonobject.put("email-address", weddingregistrydata.getUuid());
        jsonobject.put("is-mobile-phone-number", "Y");
        return jsonobject;
    }

    private static JSONObject a(WeddingRegistryData weddingregistrydata, String s)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("base-type", "list");
        jsonobject.put("short-description", weddingregistrydata.getRegistryName());
        jsonobject.put("occasion-date", weddingregistrydata.getEventDate());
        jsonobject.put("privacy-setting", weddingregistrydata.getPrivacySetting());
        jsonobject.put("created-on-channel", "app");
        if (weddingregistrydata.getPrivacySetting().equals("public"))
        {
            jsonobject.put("tags", (new StringBuilder()).append(weddingregistrydata.getRegistryName()).append(";").append(weddingregistrydata.getFirstName()).append(";").append(weddingregistrydata.getLastName()).append(";").append(weddingregistrydata.getFirstName()).append(" ").append(weddingregistrydata.getLastName()).append(";").append(weddingregistrydata.getFirstName()).append("$").append(weddingregistrydata.getLastName()).append(";").append(weddingregistrydata.getCoregistrantFirstName()).append(";").append(weddingregistrydata.getCoregistrantLastName()).append(";").append(weddingregistrydata.getCoregistrantFirstName()).append("$").append(weddingregistrydata.getCoregistrantLastName()).append(";").append(weddingregistrydata.getFirstName()).append("$").append(weddingregistrydata.getEventDate()).append(";").append(weddingregistrydata.getLastName()).append("$").append(weddingregistrydata.getEventDate()).append(";").append(weddingregistrydata.getFirstName()).append("$").append(weddingregistrydata.getLastName()).append("$").append(weddingregistrydata.getEventDate()).append(";").append(weddingregistrydata.getCoregistrantFirstName()).append("$").append(weddingregistrydata.getEventDate()).append(";").append(weddingregistrydata.getCoregistrantLastName()).append("$").append(weddingregistrydata.getEventDate()).append(";").append(weddingregistrydata.getCoregistrantFirstName()).append("$").append(weddingregistrydata.getCoregistrantLastName()).append("$").append(weddingregistrydata.getEventDate()).toString());
        }
        jsonobject.put("personalized-message", weddingregistrydata.getAddDescription());
        jsonobject.put("created-by", weddingregistrydata.getCreatedBy());
        jsonobject.put("last-updated-by", weddingregistrydata.getLastModifiedBy());
        JSONObject jsonobject1 = new JSONObject();
        if (weddingregistrydata.getEventLocation().isEmpty() && weddingregistrydata.getEventCity().isEmpty() && weddingregistrydata.getEventState().isEmpty())
        {
            jsonobject1.put("location", "");
        } else
        {
            jsonobject1.put("location", (new StringBuilder()).append(weddingregistrydata.getEventLocation()).append(", ").append(weddingregistrydata.getEventCity()).append(", ").append(weddingregistrydata.getEventState()).toString());
        }
        jsonobject1.put("city", weddingregistrydata.getEventCity());
        jsonobject1.put("state", weddingregistrydata.getEventState());
        jsonobject.put("occasion-notes", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("first-name", weddingregistrydata.getFirstName());
        jsonobject1.put("last-name", weddingregistrydata.getLastName());
        jsonobject.put("list-notes", jsonobject1);
        if (s.equals("weddingregistrylists"))
        {
            jsonobject.put("co-registrant-first-name", weddingregistrydata.getCoregistrantFirstName());
            jsonobject.put("co-registrant-last-name", weddingregistrydata.getCoregistrantLastName());
        }
        return jsonobject;
    }

    public static void a(String s)
    {
        a = s;
    }

    public static boolean a(String s, String s1, String s2, WishListReqData wishlistreqdata)
    {
        boolean flag = false;
        Object obj = c();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/users/").append(s).append("/").append(s1).append("/").append(wishlistreqdata.getUuid()).append("/recipients/").toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s2));
        s2 = new JSONObject();
        obj = new JSONArray();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("first-name", wishlistreqdata.getAddressFirstName());
        jsonobject.put("last-name", wishlistreqdata.getAddressLastName());
        jsonobject.put("address-line1", wishlistreqdata.getAddressLine1());
        jsonobject.put("address-line2", wishlistreqdata.getAddressLine2());
        jsonobject.put("address-city", wishlistreqdata.getCity());
        jsonobject.put("address-state", wishlistreqdata.getState());
        jsonobject.put("address-zip", wishlistreqdata.getZipCode());
        jsonobject.put("phone-number", wishlistreqdata.getPhone());
        jsonobject.put("country", "USA");
        jsonobject.put("phone-number-type", "Mobile");
        jsonobject.put("email-address", wishlistreqdata.getUuid());
        jsonobject.put("is-mobile-phone-number", "Y");
        ((JSONArray) (obj)).put(jsonobject);
        s2.put("recipients", obj);
        int i;
        boolean flag1;
        try
        {
            s2 = (new JSONObject(gw.b(s, null, s1, s2.toString(), "application/json"))).optJSONObject("si").optJSONObject("response").optJSONArray("recipients");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        s = "";
        s1 = s;
        if (s2 == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L3:
        s1 = s;
        if (i >= s2.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = s2.optJSONObject(i).optString("status", "");
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        flag1 = s1.equals("200");
        if (flag1)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(String s, String s1, String s2, String s3, int i, String s4)
    {
        boolean flag = false;
        gr gr1 = c();
        s = (new StringBuilder()).append(gr1.f).append("/si/users/").append(s).append("/").append(s3).append("s").append("/").append(s1).append("/gifts/").append(s2).toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s4));
        s2 = new JSONObject();
        s2.put("required-quantity", i);
        if ((new JSONObject(gw.b(s, null, s1, s2.toString(), false))).optJSONObject("si").optJSONObject("response").optJSONObject("gifts").optString("status", "").equals("200"))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(String s, String s1, String s2, String s3, String s4)
    {
        boolean flag = false;
        gr gr1 = c();
        s = (new StringBuilder()).append(gr1.f).append("/si/users/").append(s).append("/").append(s1).append("/").append(s2).append("/gifts/").append(s3).toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s4));
        if ((new JSONObject(gw.c(s, null, s1, null, false))).optJSONObject("si").optJSONObject("response").optJSONObject("gifts").optString("status", "").equals("200"))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(String s, String s1, String s2, String s3, String s4, boolean flag)
    {
        boolean flag1 = false;
        gr gr1 = c();
        s = (new StringBuilder()).append(gr1.f).append("/si/users/").append(s).append("/").append(s3).append("/").append(s1).append("/gifts/").append(s2).toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s4));
        s2 = new JSONObject();
        s2.put("favorite", flag);
        flag = flag1;
        if ((new JSONObject(gw.b(s, null, s1, s2.toString(), false))).optJSONObject("si").optJSONObject("response").optJSONObject("gifts").optString("status", "").equals("200"))
        {
            flag = true;
        }
        return flag;
    }

    public static ArrayList b()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = c();
        obj = (new StringBuilder()).append(((gr) (obj)).f).append("/si/lifeEventsCuratedLists").toString();
        List list = d();
        ArrayList arraylist1 = new ArrayList();
        arraylist1.add(new BasicNameValuePair("deviceClass", "n"));
        try
        {
            obj = RecommendationsList.getRecommendationListData((new JSONObject(gw.a(((String) (obj)), arraylist1, list, null, true))).optJSONObject("si").optJSONObject("response").optJSONArray("lists"));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return arraylist;
        }
        return ((ArrayList) (obj));
    }

    public static ArrayList b(String s)
    {
        new ArrayList();
        return Entities.getAddedProductsList((new JSONObject(s)).optJSONObject("si").optJSONObject("response").optJSONObject("gifts").optJSONArray("entities"));
    }

    public static ArrayList b(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        s1 = (new JSONObject(f(s, s1))).optJSONObject("si").optJSONObject("response");
        s = s1.optJSONObject("lists").optJSONArray("entities");
        if (s1 != null)
        {
            for (int i = 0; i < s.length(); i++)
            {
                s1 = RegistryWishList.parseRegistryWishListData(s.optJSONObject(i));
                if (!s1.isTransientFlag())
                {
                    arraylist.add(s1);
                }
            }

        }
        return arraylist;
    }

    public static ArrayList b(String s, String s1, String s2, String s3)
    {
        s3 = c();
        new ArrayList();
        s = (new StringBuilder()).append(((gr) (s3)).f).append("/si/users/").append(s).append("/").append(s2).append("/").append(s1).append("/gifts").toString();
        s1 = d();
        s2 = new ArrayList();
        s2.add(new BasicNameValuePair("limit", "200"));
        return b(gw.a(s, s2, s1, null, true));
    }

    private static JSONObject b(WeddingRegistryData weddingregistrydata)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("theknot", weddingregistrydata.isTheKnot());
        jsonobject.put("myregistry", weddingregistrydata.isMyregistry());
        return jsonobject;
    }

    public static boolean b(String s, String s1, String s2, WeddingRegistryData weddingregistrydata)
    {
        boolean flag = false;
        Object obj = c();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/users/").append(s).append("/").append(s1).append("/").append(weddingregistrydata.getUuid()).toString();
        obj = d();
        ((List) (obj)).add(new BasicNameValuePair("access_token", s2));
        s2 = new JSONObject();
        s2.put("lists", a(weddingregistrydata, s1));
        s2.put("affiliations", b(weddingregistrydata));
        boolean flag1;
        try
        {
            flag1 = (new JSONObject(gw.b(s, null, ((List) (obj)), s2.toString(), false))).optJSONObject("si").optJSONObject("response").optJSONObject("lists").optString("status", "").equals("200");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        if (flag1)
        {
            flag = true;
        }
        return flag;
    }

    public static RegistryWishList c(String s, String s1)
    {
        s1 = (new JSONObject(f(s, s1))).optJSONObject("si").optJSONObject("response");
        s = s1.optJSONObject("lists").optJSONArray("entities");
        if (s1 != null)
        {
            for (int i = 0; i < s.length(); i++)
            {
                s1 = RegistryWishList.parseRegistryWishListData(s.optJSONObject(i));
                if (s1.getType().equals("weddingregistrylists"))
                {
                    return s1;
                }
            }

        }
        return null;
    }

    private static gr c()
    {
        return gq.a();
    }

    public static ArrayList c(String s)
    {
        ListTypes listtypes = new ListTypes();
        try
        {
            s = listtypes.getListTypesData((new JSONObject(s)).optJSONObject("si").optJSONObject("response").optJSONArray("eventTypes"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }

    public static boolean c(String s, String s1, String s2, String s3)
    {
        boolean flag = false;
        gr gr1 = c();
        s = (new StringBuilder()).append(gr1.f).append("/si/users/").append(s).append("/").append(s2).append("/").append(s1).toString();
        s1 = d();
        s1.add(new BasicNameValuePair("access_token", s3));
        if ((new JSONObject(gw.c(s, null, s1, null, false))).optJSONObject("si").optJSONObject("response").optJSONObject("lists").optString("status", "").equals("200"))
        {
            flag = true;
        }
        return flag;
    }

    public static RegistryWishList d(String s, String s1)
    {
        return c(s, s1);
    }

    public static ShareURL d(String s)
    {
        Object obj = null;
        Object obj1;
        try
        {
            obj1 = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj1)), 5000);
            HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj1)), 10000);
            obj1 = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj1)));
            HttpPost httppost = new HttpPost("https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyAuYoKQeVmfozdGBSMaFIVju7cbtf2Wlm4");
            httppost.setHeader("Content-type", "application/json");
            httppost.setHeader("Accept", "application/json");
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("longUrl", s);
            httppost.setEntity(new StringEntity(jsonobject.toString(), "UTF-8"));
            obj1 = p.a(((org.apache.http.client.HttpClient) (obj1)), httppost);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        s = obj;
        if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() == 200)
        {
            s = new ByteArrayOutputStream();
            ((HttpResponse) (obj1)).getEntity().writeTo(s);
            s.close();
            s = h(s.toString());
        }
        return s;
    }

    private static List d()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        arraylist.add(new BasicNameValuePair("X-SI-API-VERSION", "1.0"));
        return arraylist;
    }

    public static LoggedInUserProfile e(String s, String s1)
    {
        Object obj;
        LoggedInUserProfile loggedinuserprofile;
        obj = null;
        loggedinuserprofile = new LoggedInUserProfile();
        Object obj1 = c();
        s = (new StringBuilder()).append(((gr) (obj1)).f).append("/si/users/").append(s).append("/token").toString();
        obj1 = d();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("grant_type", "refresh_token");
        jsonobject.put("access_token", s1);
        s1 = gw.b(s, null, ((List) (obj1)), jsonobject.toString(), "application/json");
        if (s1 == null || s1.contains("refreshToken") || !s1.equals("409") && !s1.equals("403") && !s1.equals("401") && !s1.equals("412")) goto _L2; else goto _L1
_L1:
        loggedinuserprofile.setHasError(true);
        if (!s1.equals("409")) goto _L4; else goto _L3
_L3:
        s = "409";
_L8:
        loggedinuserprofile.setErrorCode(s);
_L6:
        return loggedinuserprofile;
_L4:
        if (s1.equals("403"))
        {
            s = "403";
        } else
        if (s1.equals("401"))
        {
            s = "401";
        } else
        {
            s = obj;
            if (s1.equals("412"))
            {
                s = "412";
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s = g(s1);
        if (s == null || s.getSi() == null || s.getSi().getResponse() == null || s.getSi().getResponse().getRefreshToken() == null) goto _L6; else goto _L5
_L5:
        s1 = s.getSi().getResponse().getRefreshToken().getAccess_token();
        loggedinuserprofile.setAccess_token(s1);
        loggedinuserprofile.setExpires_in((new StringBuilder()).append("").append(s.getSi().getResponse().getRefreshToken().getExpires_in()).toString());
        loggedinuserprofile.setEntities(s.getSi().getResponse().getRefreshToken().getEntities());
        if (loggedinuserprofile.getEntities().size() > 0 && (((Entity)loggedinuserprofile.getEntities().get(0)).getRzLinkStatus() == null || ((Entity)loggedinuserprofile.getEntities().get(0)).getRzLinkStatus().isEmpty()))
        {
            loggedinuserprofile.setAttachedUser(true);
        } else
        {
            loggedinuserprofile.setAttachedUser(false);
        }
        if (((Entity)loggedinuserprofile.getEntities().get(0)).getPointsBalance() == null)
        {
            ((Entity)loggedinuserprofile.getEntities().get(0)).setPointsBalance(((Entity)loggedinuserprofile.getEntities().get(0)).getRzTotalPoints());
        }
        if (((Entity)loggedinuserprofile.getEntities().get(0)).getCertTotalAvailableValue() == null)
        {
            ((Entity)loggedinuserprofile.getEntities().get(0)).setCertTotalAvailableValue(((Entity)loggedinuserprofile.getEntities().get(0)).getRzTotalCerts());
        }
        a(s1);
        return loggedinuserprofile;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static RegistryWishList e(String s)
    {
        RegistryWishList registrywishlist = new RegistryWishList();
        JSONArray jsonarray = (new JSONObject(s)).optJSONObject("si").optJSONObject("response").optJSONObject("lists").optJSONArray("entities");
        s = registrywishlist;
        if (jsonarray != null)
        {
            int i = 0;
            s = registrywishlist;
            for (; i < jsonarray.length(); i++)
            {
                s = RegistryWishList.parseRegistryWishListData(jsonarray.optJSONObject(i));
            }

        }
        return s;
    }

    private static RegistryWishListCompleteData f(String s)
    {
        new RegistryWishListCompleteData();
        return RegistryWishListCompleteData.getRegistryWishListData((new JSONObject(s)).optJSONObject("si").optJSONObject("response").optJSONObject("lists"));
    }

    private static String f(String s, String s1)
    {
        Object obj = c();
        s = (new StringBuilder()).append(((gr) (obj)).f).append("/si/users/").append(s).append("/giftRegistries/").toString();
        obj = d();
        ((List) (obj)).add(new BasicNameValuePair("access_token", s1));
        s1 = new ArrayList();
        s1.add(new BasicNameValuePair("limit", "200"));
        return gw.a(s, s1, ((List) (obj)), null, true);
    }

    private static TokenServiceResponse g(String s)
    {
        return (TokenServiceResponse)(new gy()).a(s, new TokenServiceResponse());
    }

    private static ShareURL h(String s)
    {
        ShareURL shareurl = new ShareURL();
        s = new JSONObject(s);
        s.getString("id");
        if (s.has("id"))
        {
            shareurl.setUrl(s.getString("id"));
        }
        return shareurl;
    }

}
