// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.pinterest.android.pdk:
//            Utils, PDKCallback, PDKRequest, PDKException, 
//            PDKResponse

public class PDKClient
{

    private static final String BOARDS = "boards/";
    private static final String FOLLOWERS = "followers/";
    private static final String FOLLOWING = "following/";
    private static final String INTERESTS = "interests/";
    private static final String LIKES = "likes/";
    private static final String ME = "me/";
    private static final String PDKCLIENT_EXTRA_APPID = "PDKCLIENT_EXTRA_APPID";
    private static final String PDKCLIENT_EXTRA_APPNAME = "PDKCLIENT_EXTRA_APPNAME";
    private static final String PDKCLIENT_EXTRA_PERMISSIONS = "PDKCLIENT_EXTRA_PERMISSIONS";
    private static final String PDKCLIENT_EXTRA_RESULT = "PDKCLIENT_EXTRA_RESULT";
    public static final String PDKCLIENT_PERMISSION_READ_PRIVATE = "read_private";
    public static final String PDKCLIENT_PERMISSION_READ_PUBLIC = "read_public";
    public static final String PDKCLIENT_PERMISSION_READ_RELATIONSHIPS = "read_relationships";
    public static final String PDKCLIENT_PERMISSION_WRITE_PRIVATE = "write_private";
    public static final String PDKCLIENT_PERMISSION_WRITE_PUBLIC = "write_public";
    public static final String PDKCLIENT_PERMISSION_WRITE_RELATIONSHIPS = "write_relationships";
    private static final int PDKCLIENT_REQUEST_CODE = 8772;
    public static final String PDKCLIENT_VERSION_CODE = "1.0";
    public static final String PDK_QUERY_PARAM_CURSOR = "cursor";
    public static final String PDK_QUERY_PARAM_FIELDS = "fields";
    private static final String PDK_SHARED_PREF_FILE_KEY = "com.pinterest.android.pdk.PREF_FILE_KEY";
    private static final String PDK_SHARED_PREF_SCOPES_KEY = "PDK_SHARED_PREF_SCOPES_KEY";
    private static final String PDK_SHARED_PREF_TOKEN_KEY = "PDK_SHARED_PREF_TOKEN_KEY";
    private static final String PINS = "pins/";
    private static final String PINTEREST_OAUTH_ACTIVITY = "com.pinterest.sdk.PinterestOauthActivity";
    private static final String PINTEREST_PACKAGE = "com.pinterest";
    private static final String PROD_BASE_API_URL = "https://api.pinterest.com/v1/";
    private static final String PROD_WEB_OAUTH_URL = "https://api.pinterest.com/oauth/";
    private static final String USER = "users/";
    private static final String VOLLEY_TAG = "volley_tag";
    private static String _accessToken;
    private static String _clientId;
    private static Context _context;
    private static boolean _debugMode;
    private static boolean _isAuthenticated = false;
    private static boolean _isConfigured;
    private static PDKClient _mInstance = null;
    private static RequestQueue _requestQueue;
    private static Set _requestedScopes;
    private static Set _scopes;
    private PDKCallback _authCallback;

    private PDKClient()
    {
    }

    private static void addToRequestQueue(Request request)
    {
        request.setTag("volley_tag");
        getRequestQueue().add(request);
    }

    private static void cancelPendingRequests()
    {
        _requestQueue.cancelAll("volley_tag");
    }

    public static PDKClient configureInstance(Context context, String s)
    {
        boolean flag = true;
        _clientId = s;
        _context = context.getApplicationContext();
        _isConfigured = true;
        _accessToken = restoreAccessToken();
        _scopes = restoreScopes();
        if (_accessToken == null)
        {
            flag = false;
        }
        _isAuthenticated = flag;
        return getInstance();
    }

    private Intent createAuthIntent(Context context, String s, List list)
    {
        return (new Intent()).setClassName("com.pinterest", "com.pinterest.sdk.PinterestOauthActivity").putExtra("PDKCLIENT_EXTRA_APPID", s).putExtra("PDKCLIENT_EXTRA_APPNAME", "appName").putExtra("PDKCLIENT_EXTRA_PERMISSIONS", TextUtils.join(",", list));
    }

    private static Request deleteRequest(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        Utils.log(String.format("PDK DELETE: %s", new Object[] {
            s
        }), new Object[0]);
        hashmap = new LinkedList();
        hashmap.add(new BasicNameValuePair("access_token", _accessToken));
        hashmap = Utils.getUrlWithQueryParams(s, hashmap);
        s = pdkcallback;
        if (pdkcallback == null)
        {
            s = new PDKCallback();
        }
        s = new PDKRequest(3, hashmap, null, s, getHeaders());
        s.setShouldCache(false);
        addToRequestQueue(s);
        return s;
    }

    private static Map getHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("User-Agent", String.format("PDK %s", new Object[] {
            "1.0"
        }));
        return hashmap;
    }

    public static PDKClient getInstance()
    {
        if (_mInstance == null)
        {
            _mInstance = new PDKClient();
            _requestQueue = getRequestQueue();
        }
        return _mInstance;
    }

    private HashMap getMapWithFields(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("fields", s);
        return hashmap;
    }

    private static Request getRequest(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        Utils.log("PDK GET: %s", new Object[] {
            s
        });
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new BasicNameValuePair("access_token", _accessToken));
        if (!Utils.isEmpty(hashmap))
        {
            java.util.Map.Entry entry;
            for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
            {
                entry = (java.util.Map.Entry)hashmap.next();
            }

        }
        hashmap = Utils.getUrlWithQueryParams(s, linkedlist);
        s = pdkcallback;
        if (pdkcallback == null)
        {
            s = new PDKCallback();
        }
        s = new PDKRequest(0, hashmap, null, s, getHeaders());
        addToRequestQueue(s);
        return s;
    }

    private static RequestQueue getRequestQueue()
    {
        if (_requestQueue == null)
        {
            _requestQueue = Volley.newRequestQueue(_context);
        }
        return _requestQueue;
    }

    private void initiateLogin(Context context, List list)
    {
        if (pinterestInstalled(_context))
        {
            Intent intent = createAuthIntent(_context, _clientId, list);
            if (intent != null)
            {
                openPinterestAppForLogin(context, intent);
                return;
            } else
            {
                initiateWebLogin(context, list);
                return;
            }
        } else
        {
            initiateWebLogin(context, list);
            return;
        }
    }

    private void initiateWebLogin(Context context, List list)
    {
        try
        {
            LinkedList linkedlist = new LinkedList();
            linkedlist.add(new BasicNameValuePair("client_id", _clientId));
            linkedlist.add(new BasicNameValuePair("scope", TextUtils.join(",", list)));
            linkedlist.add(new BasicNameValuePair("redirect_uri", (new StringBuilder()).append("pdk").append(_clientId).append("://").toString()));
            linkedlist.add(new BasicNameValuePair("response_type", "token"));
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Utils.getUrlWithQueryParams("https://api.pinterest.com/oauth/", linkedlist))));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Utils.loge("PDK: Error initiating web oauth", new Object[0]);
        }
    }

    public static boolean isDebugMode()
    {
        return _debugMode;
    }

    private static boolean meetsRequirements()
    {
        return android.os.Build.VERSION.SDK_INT >= 8;
    }

    private void onOauthResponse(String s)
    {
        if (Utils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Uri uri = Uri.parse(s);
        if (uri.getQueryParameter("access_token") == null) goto _L4; else goto _L3
_L3:
        s = uri.getQueryParameter("access_token");
        String s1 = URLDecoder.decode(s, "UTF-8");
        s = s1;
_L6:
        _accessToken = s;
        _isAuthenticated = true;
        getInstance().getMe(_authCallback);
        saveAccessToken(_accessToken);
_L4:
        if (uri.getQueryParameter("error") != null)
        {
            Utils.loge("PDK: authentication error: %s", new Object[] {
                uri.getQueryParameter("error")
            });
        }
_L2:
        if (_accessToken == null)
        {
            _authCallback.onFailure(new PDKException("PDK: authentication failed"));
        }
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Utils.loge(unsupportedencodingexception.getLocalizedMessage(), new Object[0]);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void openPinterestAppForLogin(Context context, Intent intent)
    {
        try
        {
            ((Activity)context).startActivityForResult(intent, 8772);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Utils.loge("PDK: failed to open Pinterest App for login", new Object[0]);
        }
    }

    private static boolean pinterestInstalled(Context context)
    {
        boolean flag;
        if (!meetsRequirements())
        {
            return false;
        }
        flag = false;
        context = context.getPackageManager().getPackageInfo("com.pinterest", 0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        boolean flag1;
        if (((PackageInfo) (context)).versionCode >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        Utils.log("PDK: Pinterest App not installed or version too low!", new Object[0]);
        flag1 = flag;
_L2:
        return flag1;
        context;
        Utils.loge(context.getLocalizedMessage(), new Object[0]);
        flag1 = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Request postRequest(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        Utils.log(String.format("PDK POST: %s", new Object[] {
            s
        }), new Object[0]);
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        hashmap = new LinkedList();
        hashmap.add(new BasicNameValuePair("access_token", _accessToken));
        hashmap = Utils.getUrlWithQueryParams(s, hashmap);
        s = pdkcallback;
        if (pdkcallback == null)
        {
            s = new PDKCallback();
        }
        s = new PDKRequest(1, hashmap, new JSONObject(hashmap1), s, getHeaders());
        addToRequestQueue(s);
        return s;
    }

    private static Request putRequest(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        Utils.log(String.format("PDK PUT: %s", new Object[] {
            s
        }), new Object[0]);
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        hashmap = new LinkedList();
        hashmap.add(new BasicNameValuePair("access_token", _accessToken));
        hashmap = Utils.getUrlWithQueryParams(s, hashmap);
        s = pdkcallback;
        if (pdkcallback == null)
        {
            s = new PDKCallback();
        }
        s = new PDKRequest(2, hashmap, new JSONObject(hashmap1), s, getHeaders());
        addToRequestQueue(s);
        return s;
    }

    private static String restoreAccessToken()
    {
        return _context.getSharedPreferences("com.pinterest.android.pdk.PREF_FILE_KEY", 0).getString("PDK_SHARED_PREF_TOKEN_KEY", null);
    }

    private static Set restoreScopes()
    {
        return _context.getSharedPreferences("com.pinterest.android.pdk.PREF_FILE_KEY", 0).getStringSet("PDK_SHARED_PREF_SCOPES_KEY", new HashSet());
    }

    private void saveAccessToken(String s)
    {
        android.content.SharedPreferences.Editor editor = _context.getSharedPreferences("com.pinterest.android.pdk.PREF_FILE_KEY", 0).edit();
        editor.putString("PDK_SHARED_PREF_TOKEN_KEY", s);
        editor.commit();
    }

    private void saveScopes(Set set)
    {
        android.content.SharedPreferences.Editor editor = _context.getSharedPreferences("com.pinterest.android.pdk.PREF_FILE_KEY", 0).edit();
        editor.putStringSet("PDK_SHARED_PREF_SCOPES_KEY", set);
        editor.commit();
    }

    public static void setDebugMode(boolean flag)
    {
        _debugMode = flag;
    }

    private static boolean validateScopes(Set set)
    {
        return _scopes.equals(set);
    }

    private boolean verifyAccessToken(Object obj)
    {
        Object obj1;
        Object obj2;
        HashSet hashset;
        boolean flag1;
        flag1 = false;
        obj2 = "";
        hashset = new HashSet();
        obj1 = obj2;
        Object obj3 = (JSONObject)obj;
        obj = obj2;
        obj1 = obj2;
        if (!((JSONObject) (obj3)).has("app"))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj1 = obj2;
        JSONObject jsonobject = ((JSONObject) (obj3)).getJSONObject("app");
        obj = obj2;
        obj1 = obj2;
        if (!jsonobject.has("id"))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj1 = obj2;
        obj = jsonobject.getString("id");
        obj1 = obj;
        obj2 = obj;
        if (!((JSONObject) (obj3)).has("scopes")) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj3 = ((JSONObject) (obj3)).getJSONArray("scopes");
        obj1 = obj;
        int j = ((JSONArray) (obj3)).length();
        int i = 0;
_L3:
        obj2 = obj;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        hashset.add(((JSONArray) (obj3)).get(i).toString());
        i++;
        if (true) goto _L3; else goto _L2
        obj;
        Utils.loge("PDK: ", new Object[] {
            ((JSONException) (obj)).getLocalizedMessage()
        });
        obj2 = obj1;
_L2:
        if (!Utils.isEmpty(hashset))
        {
            saveScopes(hashset);
        }
        boolean flag = flag1;
        if (!Utils.isEmpty(((String) (obj2))))
        {
            flag = flag1;
            if (!Utils.isEmpty(hashset))
            {
                flag = flag1;
                if (((String) (obj2)).equalsIgnoreCase(_clientId))
                {
                    flag = flag1;
                    if (hashset.equals(_requestedScopes))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public void createBoard(String s, String s1, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Board name cannot be empty"));
            }
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("name", s);
        if (Utils.isEmpty(s1))
        {
            hashmap.put("description", s1);
        }
        postPath("boards/", hashmap, pdkcallback);
    }

    public void createPin(String s, String s1, String s2, String s3, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s) || Utils.isEmpty(s1) || Utils.isEmpty(s2))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Board Id, note, Image cannot be empty"));
            }
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("board", s1);
        hashmap.put("note", s);
        if (!Utils.isEmpty(s3))
        {
            hashmap.put("link", s3);
        }
        if (!Utils.isEmpty(s2))
        {
            hashmap.put("image_url", s2);
        }
        postPath("pins/", hashmap, pdkcallback);
    }

    public void deleteBoard(String s, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s) && pdkcallback != null)
        {
            pdkcallback.onFailure(new PDKException("Board Id cannot be empty"));
        }
        deletePath((new StringBuilder()).append("boards/").append(s).append("/").toString(), pdkcallback);
    }

    public void deletePath(String s, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid path"));
            }
            return;
        }
        if (pdkcallback != null)
        {
            pdkcallback.setPath(s);
        }
        deleteRequest((new StringBuilder()).append("https://api.pinterest.com/v1/").append(s).toString(), null, pdkcallback);
    }

    public void deletePin(String s, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s) && pdkcallback != null)
        {
            pdkcallback.onFailure(new PDKException("Pin Id cannot be empty"));
        }
        deletePath((new StringBuilder()).append("pins/").append(s).append("/").toString(), pdkcallback);
    }

    public String getAccessToken()
    {
        return _accessToken;
    }

    public void getBoard(String s, String s1, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid board Id"));
            }
            return;
        } else
        {
            getPath((new StringBuilder()).append("boards/").append(s).toString(), getMapWithFields(s1), pdkcallback);
            return;
        }
    }

    public void getBoardPins(String s, String s1, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid board Id"));
            }
            return;
        } else
        {
            getPath((new StringBuilder()).append("boards/").append(s).append("/").append("pins/").toString(), getMapWithFields(s1), pdkcallback);
            return;
        }
    }

    public void getMe(PDKCallback pdkcallback)
    {
        getPath("me/", pdkcallback);
    }

    public void getMe(String s, PDKCallback pdkcallback)
    {
        getPath("me/", getMapWithFields(s), pdkcallback);
    }

    public void getMyBoards(String s, PDKCallback pdkcallback)
    {
        getPath("me/boards/", getMapWithFields(s), pdkcallback);
    }

    public void getMyFollowedBoards(String s, PDKCallback pdkcallback)
    {
        getPath("me/following/boards/", getMapWithFields(s), pdkcallback);
    }

    public void getMyFollowedInterests(String s, PDKCallback pdkcallback)
    {
        getPath("me/following/interests/", getMapWithFields(s), pdkcallback);
    }

    public void getMyFollowedUsers(String s, PDKCallback pdkcallback)
    {
        getPath("me/following/users/", getMapWithFields(s), pdkcallback);
    }

    public void getMyFollowers(String s, PDKCallback pdkcallback)
    {
        getPath("me/followers/", getMapWithFields(s), pdkcallback);
    }

    public void getMyLikes(String s, PDKCallback pdkcallback)
    {
        getPath("me/likes/", getMapWithFields(s), pdkcallback);
    }

    public void getMyPins(String s, PDKCallback pdkcallback)
    {
        getPath("me/pins/", getMapWithFields(s), pdkcallback);
    }

    public void getPath(String s, PDKCallback pdkcallback)
    {
        getPath(s, null, pdkcallback);
    }

    public void getPath(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid path"));
            }
            return;
        }
        String s1 = (new StringBuilder()).append("https://api.pinterest.com/v1/").append(s).toString();
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        if (pdkcallback != null)
        {
            pdkcallback.setPath(s);
        }
        if (pdkcallback != null)
        {
            pdkcallback.setParams(hashmap1);
        }
        getRequest(s1, hashmap1, pdkcallback);
    }

    public void getPin(String s, String s1, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid pin Id"));
            }
            return;
        } else
        {
            getPath((new StringBuilder()).append("pins/").append(s).toString(), getMapWithFields(s1), pdkcallback);
            return;
        }
    }

    public void getUser(String s, String s1, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid user name/Id"));
            }
            return;
        } else
        {
            getPath((new StringBuilder()).append("users/").append(s).toString(), getMapWithFields(s1), pdkcallback);
            return;
        }
    }

    public void login(final Context context, final List permissions, PDKCallback pdkcallback)
    {
        _authCallback = pdkcallback;
        if (Utils.isEmpty(permissions))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Scopes cannot be empty"));
            }
        } else
        if (!(context instanceof Activity))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Please pass Activity context with login request"));
                return;
            }
        } else
        {
            _requestedScopes = new HashSet();
            _requestedScopes.addAll(permissions);
            if (!Utils.isEmpty(_accessToken) && !Utils.isEmpty(_scopes))
            {
                getPath("oauth/inspect", null, new PDKCallback() {

                    final PDKClient this$0;
                    final Context val$context;
                    final List val$permissions;

                    public void onFailure(PDKException pdkexception)
                    {
                        initiateLogin(context, permissions);
                    }

                    public void onSuccess(PDKResponse pdkresponse)
                    {
                        if (verifyAccessToken(pdkresponse.getData()))
                        {
                            PDKClient._isAuthenticated = true;
                            PDKClient.getInstance().getMe(_authCallback);
                            return;
                        } else
                        {
                            initiateLogin(context, permissions);
                            return;
                        }
                    }

            
            {
                this$0 = PDKClient.this;
                context = context1;
                permissions = list;
                super();
            }
                });
                return;
            } else
            {
                initiateLogin(context, permissions);
                return;
            }
        }
    }

    public void logout()
    {
        _accessToken = null;
        _scopes = null;
        cancelPendingRequests();
        saveAccessToken(null);
        saveScopes(null);
    }

    public void onConnect(Context context)
    {
        if (!(context instanceof Activity))
        {
            if (_authCallback != null)
            {
                _authCallback.onFailure(new PDKException("Please pass Activity context with onConnect request"));
            }
        } else
        {
            context = (Activity)context;
            if ("android.intent.action.VIEW".equals(context.getIntent().getAction()))
            {
                context = context.getIntent().getData();
                if (context != null && context.toString().contains((new StringBuilder()).append("pdk").append(_clientId).append("://").toString()))
                {
                    onOauthResponse(context.toString());
                    return;
                }
            }
        }
    }

    public void onOauthResponse(int i, int j, Intent intent)
    {
label0:
        {
            if (i == 8772)
            {
                if (j != -1)
                {
                    break label0;
                }
                Utils.log("PDK: result - %s", new Object[] {
                    intent.getStringExtra("PDKCLIENT_EXTRA_RESULT")
                });
                onOauthResponse(intent.getStringExtra("PDKCLIENT_EXTRA_RESULT"));
            }
            return;
        }
        Utils.log("PDK: Authentication failed", new Object[0]);
        _authCallback.onFailure(new PDKException("Authentication failed"));
    }

    public void postPath(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid path"));
            }
            return;
        }
        if (pdkcallback != null)
        {
            pdkcallback.setPath(s);
        }
        postRequest((new StringBuilder()).append("https://api.pinterest.com/v1/").append(s).toString(), hashmap, pdkcallback);
    }

    public void putPath(String s, HashMap hashmap, PDKCallback pdkcallback)
    {
        if (Utils.isEmpty(s))
        {
            if (pdkcallback != null)
            {
                pdkcallback.onFailure(new PDKException("Invalid path"));
            }
            return;
        }
        if (pdkcallback != null)
        {
            pdkcallback.setPath(s);
        }
        putRequest((new StringBuilder()).append("https://api.pinterest.com/v1/").append(s).toString(), hashmap, pdkcallback);
    }

    public void setAccessToken(String s)
    {
        _accessToken = s;
        saveAccessToken(_accessToken);
    }




/*
    static boolean access$102(boolean flag)
    {
        _isAuthenticated = flag;
        return flag;
    }

*/


}
