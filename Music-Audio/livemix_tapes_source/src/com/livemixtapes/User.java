// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            JsonToMap, App, AsyncHttp, console

public class User
{
    public static abstract class SignupCallback
    {

        protected abstract void always();

        protected abstract void failure(int i, Exception exception);

        protected abstract void signup_failure(String s);

        protected abstract void success();

        public SignupCallback()
        {
        }
    }

    public static abstract class UserCallback
    {

        protected abstract void always();

        protected abstract void failure(int i, Exception exception);

        protected abstract void success(UserData userdata);

        public UserCallback()
        {
        }
    }

    public static final class UserData
    {

        public final Set favoriteMixtapeIds = new HashSet();
        public final List favoriteMixtapes;
        public final String firstName;
        public final String lastName;
        public List playlists;
        public final int radioFavoritesListId;
        public final int userId;
        public final String userName;

        public UserData(String s, int i, String s1, String s2, int j, List list, List list1)
        {
            userName = s;
            userId = i;
            firstName = s1;
            lastName = s2;
            radioFavoritesListId = j;
            playlists = list;
            favoriteMixtapes = list1;
            Log.d("Nithin", list1.toString());
            i = 0;
            do
            {
                if (i >= list1.size())
                {
                    return;
                }
                s = (String)((Map)list1.get(i)).get("id");
                favoriteMixtapeIds.add(Integer.valueOf(s));
                i++;
            } while (true);
        }
    }


    private static final String AUTH_KEY = "auth";
    public static final int EXCEPTION = 4;
    public static final int INVALID_AUTH = 0;
    public static final int INVALID_CREDENTIALS = 1;
    public static final int INVALID_JSON = 2;
    private static final String LOGIN_URL = "https://api.livemixtapes.com/api/user/login";
    public static final int OFFLINE = 3;
    private static final String SIGNUP_URL = "https://api.livemixtapes.com/api/user/signup";
    private static final String USER_FILE = "user";
    private static final String USER_URL = "https://api.livemixtapes.com/api/user/login";
    private static UserData userData = null;

    public User()
    {
    }

    public static void addFavoriteMixtape(Map map)
    {
        if (userData == null)
        {
            return;
        } else
        {
            String s = (String)map.get("id");
            userData.favoriteMixtapeIds.add(Integer.valueOf(s));
            userData.favoriteMixtapes.add(map);
            return;
        }
    }

    public static String getAuth()
    {
        return getPreferences().getString("auth", "");
    }

    public static UserData getData()
    {
        return userData;
    }

    private static int getInt(Object obj)
    {
        int i;
        try
        {
            i = Integer.valueOf((String)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 0;
        }
        return i;
    }

    private static Map getJsonMap(String s)
    {
        try
        {
            s = JsonToMap.convert(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static SharedPreferences getPreferences()
    {
        return App.context.getSharedPreferences("user", 0);
    }

    public static Boolean hasAuth()
    {
        if (getAuth() != "")
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public static Boolean isGuest()
    {
        boolean flag;
        if (isLogged().booleanValue())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        return Boolean.valueOf(flag);
    }

    public static Boolean isLogged()
    {
        if (userData != null)
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public static void login(String s, String s1, final UserCallback callback)
    {
        logout();
        HashMap hashmap = new HashMap();
        hashmap.put("username", s);
        hashmap.put("password", md5(s1));
        (new AsyncHttp()).post("https://api.livemixtapes.com/api/user/login", hashmap, new AsyncHttp.AsyncHttpCallback() {

            private final UserCallback val$callback;

            protected void always()
            {
                callback.always();
            }

            protected void exception(Exception exception1)
            {
                console.log(new Object[] {
                    "EXCEPTION"
                });
                exception1.printStackTrace();
                callback.failure(4, exception1);
            }

            protected void success(String s2, String s3, int i)
            {
                s2 = User.getJsonMap(s2);
                if (s2 == null)
                {
                    console.log(new Object[] {
                        "INVALID JSON"
                    });
                    callback.failure(2, null);
                    return;
                }
                if (s2.get("auth_token") != null)
                {
                    try
                    {
                        User.setAuth((String)s2.get("auth_token"));
                        User.setUserData(s2);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s2)
                    {
                        console.log(new Object[] {
                            "NO AUTH TOKEN"
                        });
                        User.logout();
                        callback.failure(4, s2);
                        return;
                    }
                    callback.success(User.userData);
                    return;
                } else
                {
                    callback.failure(1, null);
                    return;
                }
            }

            
            {
                callback = usercallback;
                super();
            }
        });
    }

    public static void logout()
    {
        userData = null;
        setAuth("");
    }

    public static String md5(String s)
    {
        Object obj;
        int i;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            return ((StringBuffer) (obj)).toString();
        }
        if ((s[i] & 0xff) >= 16)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        ((StringBuffer) (obj)).append('0');
        ((StringBuffer) (obj)).append(Integer.toHexString(s[i] & 0xff));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_29;
        }
    }

    public static void refresh(final UserCallback callback)
    {
        if (hasAuth().booleanValue())
        {
            HashMap hashmap = new HashMap();
            hashmap.put("auth", getAuth());
            (new AsyncHttp()).get("https://api.livemixtapes.com/api/user/login", hashmap, new AsyncHttp.AsyncHttpCallback() {

                private final UserCallback val$callback;

                protected void always()
                {
                    callback.always();
                }

                protected void exception(Exception exception1)
                {
                    callback.failure(4, exception1);
                }

                protected void success(String s, String s1, int i)
                {
                    s = User.getJsonMap(s);
                    if (s == null)
                    {
                        callback.failure(2, null);
                        return;
                    }
                    if (s.get("user") != null)
                    {
                        try
                        {
                            User.setUserData((Map)s.get("user"));
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            User.logout();
                            callback.failure(4, s);
                            return;
                        }
                        callback.success(User.userData);
                        return;
                    } else
                    {
                        User.logout();
                        callback.failure(0, null);
                        return;
                    }
                }

            
            {
                callback = usercallback;
                super();
            }
            });
        }
    }

    public static void removeFavoriteMixtape(int i)
    {
        if (userData != null)
        {
            userData.favoriteMixtapeIds.remove(Integer.valueOf(i));
            int j = 0;
            while (j < userData.favoriteMixtapes.size()) 
            {
                if (Integer.valueOf((String)((Map)userData.favoriteMixtapes.get(j)).get("id")).intValue() == i)
                {
                    userData.favoriteMixtapes.remove(j);
                    return;
                }
                j++;
            }
        }
    }

    private static void setAuth(String s)
    {
        android.content.SharedPreferences.Editor editor = getPreferences().edit();
        if (s == null)
        {
            editor.remove("auth");
        } else
        {
            editor.putString("auth", s);
        }
        editor.commit();
    }

    private static void setUserData(Map map)
    {
        userData = new UserData((String)map.get("username"), getInt(map.get("userid")), (String)map.get("firstname"), (String)map.get("lastname"), getInt(map.get("favorites_playlist")), (List)map.get("playlists_complete"), (List)map.get("favorite_mixtapes"));
    }

    public static void signup(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, String s10, final SignupCallback callback)
    {
        logout();
        HashMap hashmap = new HashMap();
        hashmap.put("country", s5);
        hashmap.put("dob_day", s9);
        hashmap.put("dob_month", s8);
        hashmap.put("dob_year", s10);
        hashmap.put("email", s1);
        hashmap.put("firstname", s3);
        hashmap.put("gender", s7);
        hashmap.put("lastname", s4);
        hashmap.put("password", s2);
        hashmap.put("username", s);
        hashmap.put("tos", "1");
        hashmap.put("zip", s6);
        (new AsyncHttp()).post("https://api.livemixtapes.com/api/user/signup", hashmap, new AsyncHttp.AsyncHttpCallback() {

            private final SignupCallback val$callback;

            protected void always()
            {
                callback.always();
            }

            protected void exception(Exception exception1)
            {
                callback.failure(4, exception1);
            }

            protected void success(String s11, String s12, int i)
            {
                s12 = User.getJsonMap(s11);
                if (s12 == null)
                {
                    callback.failure(2, null);
                    return;
                }
                if (s12.get("status") != null)
                {
                    callback.success();
                    return;
                } else
                {
                    callback.signup_failure(s11);
                    return;
                }
            }

            
            {
                callback = signupcallback;
                super();
            }
        });
    }

    public static void updatePlayList()
    {
    }





}
