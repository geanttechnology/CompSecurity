// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseJSONUtils, ParseDecoder, ParseUser, ParseRole, 
//            ParseEncoder, GetCallback, ParseObject, ParseException

public class ParseACL
{
    private static class UserResolutionListener
        implements GetCallback
    {

        private final WeakReference parent;

        public void done(ParseObject parseobject, ParseException parseexception)
        {
            parseexception = (ParseACL)parent.get();
            if (parseexception == null)
            {
                break MISSING_BLOCK_LABEL_23;
            }
            parseexception.resolveUser((ParseUser)parseobject);
            parseobject.unregisterSaveListener(this);
            return;
            parseexception;
            parseobject.unregisterSaveListener(this);
            throw parseexception;
        }

        public volatile void done(Object obj, Throwable throwable)
        {
            done((ParseObject)obj, (ParseException)throwable);
        }

        public UserResolutionListener(ParseACL parseacl)
        {
            parent = new WeakReference(parseacl);
        }
    }


    private static final String PUBLIC_KEY = "*";
    private static final String UNRESOLVED_KEY = "*unresolved";
    private static ParseACL defaultACL;
    private static boolean defaultACLUsesCurrentUser;
    private static ParseACL defaultACLWithCurrentUser;
    private static WeakReference lastCurrentUser;
    private JSONObject permissionsById;
    private boolean shared;
    private ParseUser unresolvedUser;

    public ParseACL()
    {
        permissionsById = new JSONObject();
    }

    public ParseACL(ParseUser parseuser)
    {
        this();
        setReadAccess(parseuser, true);
        setWriteAccess(parseuser, true);
    }

    static ParseACL createACLFromJSONObject(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        ParseACL parseacl = new ParseACL();
        for (Iterator iterator = ParseJSONUtils.keys(jsonobject).iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            if (((String) (obj)).equals("unresolvedUser"))
            {
                try
                {
                    obj = jsonobject.getJSONObject(((String) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new RuntimeException(jsonobject);
                }
                parseacl.unresolvedUser = (ParseUser)parsedecoder.decode(obj);
            } else
            {
                Object obj1;
                try
                {
                    obj1 = jsonobject.getJSONObject(((String) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new RuntimeException((new StringBuilder()).append("could not decode ACL: ").append(jsonobject.getMessage()).toString());
                }
                obj1 = ParseJSONUtils.keys(((JSONObject) (obj1))).iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    parseacl.setAccess((String)((Iterator) (obj1)).next(), ((String) (obj)), true);
                }
            }
        }

        return parseacl;
    }

    private boolean getAccess(String s, String s1)
    {
        boolean flag;
        try
        {
            s1 = permissionsById.optJSONObject(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException((new StringBuilder()).append("JSON failure with ACL: ").append(s.getMessage()).toString());
        }
        if (s1 == null)
        {
            return false;
        }
        if (!s1.has(s))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        flag = s1.getBoolean(s);
        return flag;
        return false;
    }

    static ParseACL getDefaultACL()
    {
        if (defaultACLUsesCurrentUser && defaultACL != null)
        {
            ParseUser parseuser = ParseUser.getCurrentUser();
            if (parseuser != null)
            {
                Object obj;
                if (lastCurrentUser != null)
                {
                    obj = (ParseUser)lastCurrentUser.get();
                } else
                {
                    obj = null;
                }
                if (obj != parseuser)
                {
                    obj = defaultACL.copy();
                    ((ParseACL) (obj)).setShared(true);
                    ((ParseACL) (obj)).setReadAccess(parseuser, true);
                    ((ParseACL) (obj)).setWriteAccess(parseuser, true);
                    defaultACLWithCurrentUser = ((ParseACL) (obj));
                    lastCurrentUser = new WeakReference(parseuser);
                }
                return defaultACLWithCurrentUser;
            }
        }
        return defaultACL;
    }

    private void prepareUnresolvedUser(ParseUser parseuser)
    {
        if (unresolvedUser != parseuser)
        {
            permissionsById.remove("*unresolved");
            unresolvedUser = parseuser;
            parseuser.registerSaveListener(new UserResolutionListener(this));
        }
    }

    private void resolveUser(ParseUser parseuser)
    {
        if (parseuser != unresolvedUser)
        {
            return;
        }
        try
        {
            if (permissionsById.has("*unresolved"))
            {
                permissionsById.put(parseuser.getObjectId(), permissionsById.get("*unresolved"));
                permissionsById.remove("*unresolved");
            }
            unresolvedUser = null;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParseUser parseuser)
        {
            throw new RuntimeException(parseuser);
        }
    }

    private void setAccess(String s, String s1, boolean flag)
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        try
        {
            jsonobject1 = permissionsById.optJSONObject(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException((new StringBuilder()).append("JSON failure with ACL: ").append(s.getMessage()).toString());
        }
        jsonobject = jsonobject1;
        if (jsonobject1 != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (!flag)
        {
            return;
        }
        jsonobject = new JSONObject();
        permissionsById.put(s1, jsonobject);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        jsonobject.put(s, true);
        return;
        jsonobject.remove(s);
        if (jsonobject.length() == 0)
        {
            permissionsById.remove(s1);
        }
        return;
    }

    public static void setDefaultACL(ParseACL parseacl, boolean flag)
    {
        defaultACLWithCurrentUser = null;
        lastCurrentUser = null;
        if (parseacl != null)
        {
            parseacl = parseacl.copy();
            parseacl.setShared(true);
            defaultACL = parseacl;
            defaultACLUsesCurrentUser = flag;
            return;
        } else
        {
            defaultACL = null;
            return;
        }
    }

    private void setUnresolvedReadAccess(ParseUser parseuser, boolean flag)
    {
        prepareUnresolvedUser(parseuser);
        setReadAccess("*unresolved", flag);
    }

    private void setUnresolvedWriteAccess(ParseUser parseuser, boolean flag)
    {
        prepareUnresolvedUser(parseuser);
        setWriteAccess("*unresolved", flag);
    }

    private static void validateRoleState(ParseRole parserole)
    {
        if (parserole.getObjectId() == null)
        {
            throw new IllegalArgumentException("Roles must be saved to the server before they can be used in an ACL.");
        } else
        {
            return;
        }
    }

    ParseACL copy()
    {
        ParseACL parseacl = new ParseACL();
        Object obj;
        obj = permissionsById;
        if (obj instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = ((JSONObject) (obj)).toString();
_L1:
        parseacl.permissionsById = JSONObjectInstrumentation.init(((String) (obj)));
        parseacl.unresolvedUser = unresolvedUser;
        if (unresolvedUser != null)
        {
            unresolvedUser.registerSaveListener(new UserResolutionListener(parseacl));
        }
        return parseacl;
        try
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
          goto _L1
    }

    public boolean getPublicReadAccess()
    {
        return getReadAccess("*");
    }

    public boolean getPublicWriteAccess()
    {
        return getWriteAccess("*");
    }

    public boolean getReadAccess(ParseUser parseuser)
    {
        if (parseuser == unresolvedUser)
        {
            return getReadAccess("*unresolved");
        }
        if (parseuser.isLazy())
        {
            return false;
        }
        if (parseuser.getObjectId() == null)
        {
            throw new IllegalArgumentException("cannot getReadAccess for a user with null id");
        } else
        {
            return getReadAccess(parseuser.getObjectId());
        }
    }

    public boolean getReadAccess(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("cannot getReadAccess for null userId");
        } else
        {
            return getAccess("read", s);
        }
    }

    public boolean getRoleReadAccess(ParseRole parserole)
    {
        validateRoleState(parserole);
        return getRoleReadAccess(parserole.getName());
    }

    public boolean getRoleReadAccess(String s)
    {
        return getReadAccess((new StringBuilder()).append("role:").append(s).toString());
    }

    public boolean getRoleWriteAccess(ParseRole parserole)
    {
        validateRoleState(parserole);
        return getRoleWriteAccess(parserole.getName());
    }

    public boolean getRoleWriteAccess(String s)
    {
        return getWriteAccess((new StringBuilder()).append("role:").append(s).toString());
    }

    ParseUser getUnresolvedUser()
    {
        return unresolvedUser;
    }

    public boolean getWriteAccess(ParseUser parseuser)
    {
        if (parseuser == unresolvedUser)
        {
            return getWriteAccess("*unresolved");
        }
        if (parseuser.isLazy())
        {
            return false;
        }
        if (parseuser.getObjectId() == null)
        {
            throw new IllegalArgumentException("cannot getWriteAccess for a user with null id");
        } else
        {
            return getWriteAccess(parseuser.getObjectId());
        }
    }

    public boolean getWriteAccess(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("cannot getWriteAccess for null userId");
        } else
        {
            return getAccess("write", s);
        }
    }

    boolean hasUnresolvedUser()
    {
        return unresolvedUser != null;
    }

    boolean isShared()
    {
        return shared;
    }

    public void setPublicReadAccess(boolean flag)
    {
        setReadAccess("*", flag);
    }

    public void setPublicWriteAccess(boolean flag)
    {
        setWriteAccess("*", flag);
    }

    public void setReadAccess(ParseUser parseuser, boolean flag)
    {
        if (parseuser.getObjectId() == null)
        {
            if (parseuser.isLazy())
            {
                setUnresolvedReadAccess(parseuser, flag);
                return;
            } else
            {
                throw new IllegalArgumentException("cannot setReadAccess for a user with null id");
            }
        } else
        {
            setReadAccess(parseuser.getObjectId(), flag);
            return;
        }
    }

    public void setReadAccess(String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("cannot setReadAccess for null userId");
        } else
        {
            setAccess("read", s, flag);
            return;
        }
    }

    public void setRoleReadAccess(ParseRole parserole, boolean flag)
    {
        validateRoleState(parserole);
        setRoleReadAccess(parserole.getName(), flag);
    }

    public void setRoleReadAccess(String s, boolean flag)
    {
        setReadAccess((new StringBuilder()).append("role:").append(s).toString(), flag);
    }

    public void setRoleWriteAccess(ParseRole parserole, boolean flag)
    {
        validateRoleState(parserole);
        setRoleWriteAccess(parserole.getName(), flag);
    }

    public void setRoleWriteAccess(String s, boolean flag)
    {
        setWriteAccess((new StringBuilder()).append("role:").append(s).toString(), flag);
    }

    void setShared(boolean flag)
    {
        shared = flag;
    }

    public void setWriteAccess(ParseUser parseuser, boolean flag)
    {
        if (parseuser.getObjectId() == null)
        {
            if (parseuser.isLazy())
            {
                setUnresolvedWriteAccess(parseuser, flag);
                return;
            } else
            {
                throw new IllegalArgumentException("cannot setWriteAccess for a user with null id");
            }
        } else
        {
            setWriteAccess(parseuser.getObjectId(), flag);
            return;
        }
    }

    public void setWriteAccess(String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("cannot setWriteAccess for null userId");
        } else
        {
            setAccess("write", s, flag);
            return;
        }
    }

    JSONObject toJSONObject(ParseEncoder parseencoder)
    {
        Object obj;
        obj = permissionsById;
        if (obj instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj = ((JSONObject) (obj)).toString();
_L1:
        obj = JSONObjectInstrumentation.init(((String) (obj)));
        if (unresolvedUser == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ((JSONObject) (obj)).put("unresolvedUser", parseencoder.encode(unresolvedUser));
        return ((JSONObject) (obj));
        try
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        // Misplaced declaration of an exception variable
        catch (ParseEncoder parseencoder)
        {
            throw new RuntimeException(parseencoder);
        }
          goto _L1
        return ((JSONObject) (obj));
    }

}
