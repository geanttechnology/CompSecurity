// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseJSONUtils, ParseDecoder, ParseUser, ParseDefaultACLController, 
//            ParseCorePlugins, ParseRole, ParseEncoder, GetCallback, 
//            ParseObject, ParseException

public class ParseACL
{
    private static class Permissions
    {

        private static final String READ_PERMISSION = "read";
        private static final String WRITE_PERMISSION = "write";
        private final boolean readPermission;
        private final boolean writePermission;

        static Permissions createPermissionsFromJSONObject(JSONObject jsonobject)
        {
            return new Permissions(jsonobject.optBoolean("read", false), jsonobject.optBoolean("write", false));
        }

        boolean getReadPermission()
        {
            return readPermission;
        }

        boolean getWritePermission()
        {
            return writePermission;
        }

        JSONObject toJSONObject()
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                if (readPermission)
                {
                    jsonobject.put("read", true);
                }
                if (writePermission)
                {
                    jsonobject.put("write", true);
                }
            }
            catch (JSONException jsonexception)
            {
                throw new RuntimeException(jsonexception);
            }
            return jsonobject;
        }

        Permissions(Permissions permissions)
        {
            readPermission = permissions.readPermission;
            writePermission = permissions.writePermission;
        }

        Permissions(boolean flag, boolean flag1)
        {
            readPermission = flag;
            writePermission = flag1;
        }
    }

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


    private static final String KEY_ROLE_PREFIX = "role:";
    private static final String PUBLIC_KEY = "*";
    private static final String UNRESOLVED_KEY = "*unresolved";
    private static final String UNRESOLVED_USER_JSON_KEY = "unresolvedUser";
    private Map permissionsById;
    private boolean shared;
    private ParseUser unresolvedUser;

    public ParseACL()
    {
        permissionsById = new HashMap();
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
                try
                {
                    Permissions permissions = Permissions.createPermissionsFromJSONObject(jsonobject.getJSONObject(((String) (obj))));
                    parseacl.permissionsById.put(obj, permissions);
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    throw new RuntimeException((new StringBuilder()).append("could not decode ACL: ").append(jsonobject.getMessage()).toString());
                }
            }
        }

        return parseacl;
    }

    static ParseACL getDefaultACL()
    {
        return getDefaultACLController().get();
    }

    private static ParseDefaultACLController getDefaultACLController()
    {
        return ParseCorePlugins.getInstance().getDefaultACLController();
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

    public static void setDefaultACL(ParseACL parseacl, boolean flag)
    {
        getDefaultACLController().set(parseacl, flag);
    }

    private void setPermissionsIfNonEmpty(String s, boolean flag, boolean flag1)
    {
        if (!flag && !flag1)
        {
            permissionsById.remove(s);
            return;
        } else
        {
            permissionsById.put(s, new Permissions(flag, flag1));
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
        if (parserole == null || parserole.getObjectId() == null)
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
        String s;
        for (Iterator iterator = permissionsById.keySet().iterator(); iterator.hasNext(); parseacl.permissionsById.put(s, new Permissions((Permissions)permissionsById.get(s))))
        {
            s = (String)iterator.next();
        }

        parseacl.unresolvedUser = unresolvedUser;
        if (unresolvedUser != null)
        {
            unresolvedUser.registerSaveListener(new UserResolutionListener(parseacl));
        }
        return parseacl;
    }

    Map getPermissionsById()
    {
        return permissionsById;
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
        }
        s = (Permissions)permissionsById.get(s);
        return s != null && s.getReadPermission();
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
        }
        s = (Permissions)permissionsById.get(s);
        return s != null && s.getWritePermission();
    }

    boolean hasUnresolvedUser()
    {
        return unresolvedUser != null;
    }

    boolean isShared()
    {
        return shared;
    }

    void resolveUser(ParseUser parseuser)
    {
        if (parseuser != unresolvedUser)
        {
            return;
        }
        if (permissionsById.containsKey("*unresolved"))
        {
            permissionsById.put(parseuser.getObjectId(), permissionsById.get("*unresolved"));
            permissionsById.remove("*unresolved");
        }
        unresolvedUser = null;
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
            setPermissionsIfNonEmpty(s, flag, getWriteAccess(s));
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
            setPermissionsIfNonEmpty(s, getReadAccess(s), flag);
            return;
        }
    }

    JSONObject toJSONObject(ParseEncoder parseencoder)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = permissionsById.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, ((Permissions)permissionsById.get(s)).toJSONObject()))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (ParseEncoder parseencoder)
        {
            throw new RuntimeException(parseencoder);
        }
        if (unresolvedUser != null)
        {
            jsonobject.put("unresolvedUser", parseencoder.encode(unresolvedUser));
        }
        return jsonobject;
    }
}
