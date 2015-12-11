// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import com.bestbuy.android.api.lib.models.registry.Entity;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import java.util.List;

public class fr
{

    public static void a()
    {
        fo fo1 = fo.a();
        if (fo1 != null)
        {
            fo1.a("user_profile");
        }
    }

    public static void a(LoggedInUserProfile loggedinuserprofile)
    {
        fo fo1 = fo.a();
        ContentValues contentvalues;
        fo1.c();
        a();
        contentvalues = new ContentValues();
        contentvalues.put("uuid", ((Entity)loggedinuserprofile.getEntities().get(0)).getUuid());
        contentvalues.put("type", ((Entity)loggedinuserprofile.getEntities().get(0)).getType());
        contentvalues.put("created", ((Entity)loggedinuserprofile.getEntities().get(0)).getCreated());
        contentvalues.put("modified", ((Entity)loggedinuserprofile.getEntities().get(0)).getModified());
        contentvalues.put("username", ((Entity)loggedinuserprofile.getEntities().get(0)).getUsername());
        contentvalues.put("activated", ((Entity)loggedinuserprofile.getEntities().get(0)).getActivated());
        contentvalues.put("invalidLogins", ((Entity)loggedinuserprofile.getEntities().get(0)).getLocked());
        contentvalues.put("transient", ((Entity)loggedinuserprofile.getEntities().get(0)).getTransientValue());
        contentvalues.put("firstName", ((Entity)loggedinuserprofile.getEntities().get(0)).getFirstName());
        contentvalues.put("lastName", ((Entity)loggedinuserprofile.getEntities().get(0)).getLastName());
        contentvalues.put("lockedAt", ((Entity)loggedinuserprofile.getEntities().get(0)).getLockedAt());
        contentvalues.put("postalCode", ((Entity)loggedinuserprofile.getEntities().get(0)).getPostalCode());
        contentvalues.put("rzLinkStatus", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzLinkStatus());
        contentvalues.put("rzMemberId", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzMemberId());
        contentvalues.put("rzStatus", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzStatus());
        contentvalues.put("rzTierStatus", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzStatus());
        contentvalues.put("access_token", loggedinuserprofile.getAccess_token());
        contentvalues.put("expires_in", ((Entity)loggedinuserprofile.getEntities().get(0)).getExpires_in());
        contentvalues.put("cg_token", loggedinuserprofile.getAccess_token());
        contentvalues.put("cg_expires_in", loggedinuserprofile.getExpires_in());
        contentvalues.put("has_registry", String.valueOf(loggedinuserprofile.isHasWeddingRegistry()));
        contentvalues.put("points_balance", ((Entity)loggedinuserprofile.getEntities().get(0)).getPointsBalance());
        contentvalues.put("certs_value", ((Entity)loggedinuserprofile.getEntities().get(0)).getCertTotalAvailableValue());
        contentvalues.put("rz_member_id", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzMemberId());
        contentvalues.put("rz_tier_status", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzTierStatus());
        contentvalues.put("rz_status", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzStatus());
        contentvalues.put("is_attached_user", String.valueOf(loggedinuserprofile.isAttachedUser()));
        if (loggedinuserprofile.getRegistry() != null)
        {
            contentvalues.put("registry_name", loggedinuserprofile.getRegistry().getShortDescription());
        }
        if (fo1 == null)
        {
            break MISSING_BLOCK_LABEL_591;
        }
        fo1.a("user_profile", contentvalues);
        fo1.d();
        fo1.e();
        return;
        loggedinuserprofile;
        loggedinuserprofile.printStackTrace();
        fo1.e();
        return;
        loggedinuserprofile;
        fo1.e();
        throw loggedinuserprofile;
    }

    public static boolean a(String s)
    {
        String s1 = e();
        fo fo1 = fo.a();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("has_registry", s);
        return fo1.a("user_profile", contentvalues, "firstName=?", new String[] {
            s1
        }) > 0;
    }

    public static String b()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "access_token"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("access_token");
            }
        }
        return s;
    }

    public static boolean b(String s)
    {
        String s1 = c();
        fo fo1 = fo.a();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("registry_name", s);
        return fo1.a("user_profile", contentvalues, "username=?", new String[] {
            s1
        }) > 0;
    }

    public static String c()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "username"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("username");
            }
        }
        return s;
    }

    public static String d()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "uuid"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("uuid");
            }
        }
        return s;
    }

    public static String e()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "firstName"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("firstName");
            }
        }
        return s;
    }

    public static String f()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "lastName"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("lastName");
            }
        }
        return s;
    }

    public static String g()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "has_registry"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("has_registry");
            }
        }
        return s;
    }

    public static String h()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "points_balance"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("points_balance");
            }
        }
        return s;
    }

    public static String i()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "certs_value"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("certs_value");
            }
        }
        return s;
    }

    public static String j()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "rz_tier_status"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("rz_tier_status");
            }
        }
        return s;
    }

    public static String k()
    {
        Object obj = null;
        Object obj1 = fo.a();
        String s = obj;
        if (obj1 != null)
        {
            obj1 = ((fo) (obj1)).a("user_profile", new String[] {
                "registry_name"
            }, null, null);
            s = obj;
            if (((List) (obj1)).size() > 0)
            {
                s = ((ContentValues)((List) (obj1)).get(0)).getAsString("registry_name");
            }
        }
        return s;
    }

    public static boolean l()
    {
        boolean flag1 = false;
        Object obj = fo.a();
        boolean flag = flag1;
        if (obj != null)
        {
            obj = ((fo) (obj)).a("user_profile", new String[] {
                "is_attached_user"
            }, null, null);
            flag = flag1;
            if (((List) (obj)).size() > 0)
            {
                flag = Boolean.valueOf(((ContentValues)((List) (obj)).get(0)).getAsString("is_attached_user")).booleanValue();
            }
        }
        return flag;
    }
}
