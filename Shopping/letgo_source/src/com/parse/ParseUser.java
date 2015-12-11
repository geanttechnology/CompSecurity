// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, TaskQueue, ParseException, ParseTaskUtils, 
//            ParseRESTUserCommand, ParseRESTCommand, ParseAuthenticationProvider, PointerEncoder, 
//            ParseQuery, AnonymousAuthenticationProvider, ParseTextUtils, ParseAnonymousUtils, 
//            ParseOperationSet, ParseDecoder, ParseEncoder, Parse, 
//            LogInCallback, LogOutCallback, RequestPasswordResetCallback, SignUpCallback, 
//            ParseFileUtils, ParseSession

public class ParseUser extends ParseObject
{
    static class State extends ParseObject.State
    {

        public Map authData()
        {
            Map map = (Map)get("authData");
            Object obj = map;
            if (map == null)
            {
                obj = new HashMap();
            }
            return ((Map) (obj));
        }

        public volatile ParseObject.State.Init newBuilder()
        {
            return newBuilder();
        }

        public Builder newBuilder()
        {
            return new Builder(this);
        }

        public String sessionToken()
        {
            return (String)get("sessionToken");
        }

        private State(Builder builder)
        {
            super(builder);
        }

    }

    static class State.Builder extends ParseObject.State.Init
    {

        public State.Builder authData(Map map)
        {
            return (State.Builder)put("authData", map);
        }

        public volatile ParseObject.State build()
        {
            return build();
        }

        public State build()
        {
            return new State(this);
        }

        public State.Builder putAuthData(String s, Map map)
        {
            Map map1 = (Map)serverData.get("authData");
            Object obj = map1;
            if (map1 == null)
            {
                obj = new HashMap();
            }
            ((Map) (obj)).put(s, map);
            serverData.put("authData", obj);
            return this;
        }

        volatile ParseObject.State.Init self()
        {
            return self();
        }

        State.Builder self()
        {
            return this;
        }

        public State.Builder sessionToken(String s)
        {
            return (State.Builder)put("sessionToken", s);
        }

        State.Builder(State state)
        {
            super(state);
        }

        public State.Builder(String s)
        {
            super(s);
        }
    }


    static final String FILENAME_CURRENT_USER = "currentUser";
    private static final String KEY_AUTH_DATA = "authData";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SESSION_TOKEN = "sessionToken";
    private static final String KEY_USERNAME = "username";
    private static final Object MUTEX_CURRENT_USER = new Object();
    static final String PIN_CURRENT_USER = "_currentUser";
    private static final TaskQueue QUEUE_CURRENT_USER = new TaskQueue();
    private static final List READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[] {
        "sessionToken", "authData"
    }));
    private static Map authenticationProviders = new HashMap();
    private static boolean autoUserEnabled;
    static ParseUser currentUser;
    private static boolean currentUserMatchesDisk = false;
    private static final Object isAutoUserEnabledMutex = new Object();
    private static boolean isRevocableSessionEnabled;
    private static final Object isRevocableSessionEnabledMutex = new Object();
    private boolean isCurrentUser;
    private boolean isLazy;
    private boolean isNew;

    public ParseUser()
    {
        isLazy = false;
        isCurrentUser = false;
    }

    public static ParseUser become(String s)
        throws ParseException
    {
        return (ParseUser)ParseTaskUtils.wait(becomeInBackground(s));
    }

    public static cu becomeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Must specify a sessionToken for the user to log in with");
        } else
        {
            return ParseRESTUserCommand.getCurrentUserCommand(s).executeAsync().d(new ct() {

                public cu then(cu cu1)
                    throws Exception
                {
                    cu1 = (JSONObject)cu1.e();
                    if (cu1 == JSONObject.NULL)
                    {
                        return cu.a(new ParseException(101, "invalid login credentials"));
                    } else
                    {
                        return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON(cu1, "_User", true));
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            });
        }
    }

    public static void becomeInBackground(String s, LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(becomeInBackground(s), logincallback);
    }

    private void cleanUpAuthData()
    {
label0:
        {
            synchronized (mutex)
            {
                obj1 = getState().authData();
                if (((Map) (obj1)).size() != 0)
                {
                    break label0;
                }
            }
            return;
        }
        Iterator iterator = ((Map) (obj1)).entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() == null)
            {
                iterator.remove();
                if (authenticationProviders.containsKey(entry.getKey()))
                {
                    ((ParseAuthenticationProvider)authenticationProviders.get(entry.getKey())).restoreAuthentication(null);
                }
            }
        } while (true);
        break MISSING_BLOCK_LABEL_124;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        setState(getState().newBuilder().authData(((Map) (obj1))).build());
        obj;
        JVM INSTR monitorexit ;
    }

    static void clearCurrentUserFromMemory()
    {
        synchronized (MUTEX_CURRENT_USER)
        {
            currentUser = null;
            currentUserMatchesDisk = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ParseRESTUserCommand currentServiceLogInCommand(State state, ParseOperationSet parseoperationset)
        throws ParseException
    {
        synchronized (mutex)
        {
            parseoperationset = toJSONObjectForSaving(getState(), parseoperationset, PointerEncoder.get());
        }
        return ParseRESTUserCommand.serviceLogInUserCommand(parseoperationset, state.sessionToken(), isRevocableSessionEnabled());
        state;
        obj;
        JVM INSTR monitorexit ;
        throw state;
    }

    static void disableAutomaticUser()
    {
        synchronized (isAutoUserEnabledMutex)
        {
            autoUserEnabled = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void disableRevocableSession()
    {
        synchronized (isRevocableSessionEnabledMutex)
        {
            isRevocableSessionEnabled = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void enableAutomaticUser()
    {
        synchronized (isAutoUserEnabledMutex)
        {
            autoUserEnabled = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static cu enableRevocableSessionInBackground()
    {
        synchronized (isRevocableSessionEnabledMutex)
        {
            isRevocableSessionEnabled = true;
        }
        return getCurrentUserAsync(false).d(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (ParseUser)cu1.e();
                if (cu1 == null)
                {
                    return cu.a(null);
                } else
                {
                    return cu1.upgradeToRevocableSessionAsync();
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        });
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Map getAuthData()
    {
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        Map map = getMap("authData");
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = new HashMap();
        obj1;
        JVM INSTR monitorexit ;
        return ((Map) (obj));
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Map getAuthData(String s)
    {
        return (Map)getAuthData().get(s);
    }

    static String getCurrentSessionToken()
    {
        ParseUser parseuser = getCurrentUser();
        if (parseuser != null)
        {
            return parseuser.getSessionToken();
        } else
        {
            return null;
        }
    }

    static cu getCurrentSessionTokenAsync()
    {
        return getCurrentUserAsync(false).c(new ct() {

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public String then(cu cu1)
                throws Exception
            {
                cu1 = (ParseUser)cu1.e();
                if (cu1 != null)
                {
                    return cu1.getSessionToken();
                } else
                {
                    return null;
                }
            }

        });
    }

    public static ParseUser getCurrentUser()
    {
        return getCurrentUser(isAutomaticUserEnabled());
    }

    private static ParseUser getCurrentUser(boolean flag)
    {
        ParseUser parseuser;
        try
        {
            parseuser = (ParseUser)ParseTaskUtils.wait(getCurrentUserAsync(flag));
        }
        catch (ParseException parseexception)
        {
            return null;
        }
        return parseuser;
    }

    static cu getCurrentUserAsync()
    {
        return getCurrentUserAsync(isAutomaticUserEnabled());
    }

    private static cu getCurrentUserAsync(boolean flag)
    {
        Object obj = MUTEX_CURRENT_USER;
        obj;
        JVM INSTR monitorenter ;
        cu cu1;
        if (currentUser == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        cu1 = cu.a(currentUser);
        return cu1;
        obj;
        JVM INSTR monitorexit ;
        return QUEUE_CURRENT_USER.enqueue(new ct(flag) {

            final boolean val$shouldAutoCreateUser;

            public cu then(cu cu2)
                throws Exception
            {
                return ParseUser.getCurrentUserAsync(shouldAutoCreateUser, cu2);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                shouldAutoCreateUser = flag;
                super();
            }
        });
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static cu getCurrentUserAsync(boolean flag, cu cu1)
    {
        return cu1.b(new ct(flag) {

            final boolean val$shouldAutoCreateUser;

            public cu then(cu cu2)
                throws Exception
            {
                boolean flag1;
                ParseUser parseuser;
                synchronized (ParseUser.MUTEX_CURRENT_USER)
                {
                    parseuser = ParseUser.currentUser;
                    flag1 = ParseUser.currentUserMatchesDisk;
                }
                if (parseuser != null)
                {
                    return cu.a(parseuser);
                }
                break MISSING_BLOCK_LABEL_30;
                exception;
                cu2;
                JVM INSTR monitorexit ;
                throw exception;
                if (flag1)
                {
                    if (shouldAutoCreateUser)
                    {
                        return cu.a(ParseAnonymousUtils.lazyLogIn());
                    } else
                    {
                        return null;
                    }
                }
                if (Parse.isLocalDatastoreEnabled())
                {
                    cu2 = ParseQuery.getQuery(com/parse/ParseUser).fromPin("_currentUser").ignoreACLs().findInBackground().d(new ct() {

                        final _cls10 this$0;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            cu1 = (List)cu1.e();
                            if (cu1 != null)
                            {
                                if (cu1.size() == 1)
                                {
                                    return cu.a(cu1.get(0));
                                } else
                                {
                                    return ParseObject.unpinAllInBackground("_currentUser").i();
                                }
                            } else
                            {
                                return cu.a(null);
                            }
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = _cls10.this;
                super();
            }
                    }).d(new ct() {

                        final _cls10 this$0;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            if ((ParseUser)cu1.e() != null)
                            {
                                return cu1;
                            } else
                            {
                                return ParseObject.migrateFromDiskToLDS("currentUser", "_currentUser").i();
                            }
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = _cls10.this;
                super();
            }
                    });
                } else
                {
                    cu2 = cu.a((ParseUser)ParseObject.getFromDisk("currentUser"));
                }
                return cu2.a(new ct() {

                    final _cls10 this$0;

                    public ParseUser then(cu cu1)
                        throws Exception
                    {
                        boolean flag = true;
                        ParseUser parseuser = (ParseUser)cu1.e();
                        if (cu1.d())
                        {
                            flag = false;
                        }
                        synchronized (ParseUser.MUTEX_CURRENT_USER)
                        {
                            ParseUser.currentUser = parseuser;
                            ParseUser.currentUserMatchesDisk = flag;
                        }
                        if (parseuser != null)
                        {
                            synchronized (parseuser.mutex)
                            {
                                parseuser.isCurrentUser = true;
                                parseuser.isLazy = ParseAnonymousUtils.isLinked(parseuser);
                            }
                            return parseuser;
                        }
                        break MISSING_BLOCK_LABEL_79;
                        exception;
                        cu1;
                        JVM INSTR monitorexit ;
                        throw exception;
                        exception1;
                        cu1;
                        JVM INSTR monitorexit ;
                        throw exception1;
                        if (shouldAutoCreateUser)
                        {
                            return ParseAnonymousUtils.lazyLogIn();
                        } else
                        {
                            return null;
                        }
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = _cls10.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                shouldAutoCreateUser = flag;
                super();
            }
        });
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseUser);
    }

    static boolean isAutomaticUserEnabled()
    {
        boolean flag;
        synchronized (isAutoUserEnabledMutex)
        {
            flag = autoUserEnabled;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean isRevocableSessionEnabled()
    {
        boolean flag;
        synchronized (isRevocableSessionEnabledMutex)
        {
            flag = isRevocableSessionEnabled;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean isRevocableSessionToken(String s)
    {
        return s.contains("r:");
    }

    private cu linkWithAsync(final String authType, Map map, final cu toAwait, final String sessionToken)
    {
        final Map oldAnonymousData = getAuthData("anonymous");
        synchronized (mutex)
        {
            stripAnonymity();
            putAuthData(authType, map);
            authType = getCurrentSessionTokenAsync().d(new ct() {

                final ParseUser this$0;
                final String val$sessionToken;
                final cu val$toAwait;

                public cu then(cu cu1)
                    throws Exception
                {
                    return saveAsync(sessionToken, toAwait);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseUser.this;
                sessionToken = s;
                toAwait = cu1;
                super();
            }
            }).b(new ct() {

                final ParseUser this$0;
                final String val$authType;
                final Map val$oldAnonymousData;

                public cu then(cu cu1)
                    throws Exception
                {
label0:
                    {
                        synchronized (mutex)
                        {
                            if (!cu1.d() && !cu1.c())
                            {
                                break label0;
                            }
                            restoreAnonymity(oldAnonymousData);
                        }
                        return cu1;
                    }
                    synchronizeAuthData(authType);
                    obj1;
                    JVM INSTR monitorexit ;
                    return cu1;
                    cu1;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseUser.this;
                oldAnonymousData = map;
                authType = s;
                super();
            }
            });
        }
        return authType;
        authType;
        obj;
        JVM INSTR monitorexit ;
        throw authType;
    }

    public static ParseUser logIn(String s, String s1)
        throws ParseException
    {
        return (ParseUser)ParseTaskUtils.wait(logInInBackground(s, s1));
    }

    public static cu logInInBackground(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Must specify a username for the user to log in with");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Must specify a password for the user to log in with");
        } else
        {
            return ParseRESTUserCommand.logInUserCommand(s, s1, isRevocableSessionEnabled()).executeAsync().d(new ct() {

                public cu then(cu cu1)
                    throws Exception
                {
                    cu1 = (JSONObject)cu1.e();
                    if (cu1 == JSONObject.NULL)
                    {
                        throw new ParseException(101, "invalid login credentials");
                    } else
                    {
                        return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON(cu1, "_User", true));
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            });
        }
    }

    public static void logInInBackground(String s, String s1, LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(s, s1), logincallback);
    }

    static ParseUser logInLazyUser(String s, Map map)
    {
        ParseUser parseuser = (ParseUser)ParseObject.create(com/parse/ParseUser);
        synchronized (parseuser.mutex)
        {
            parseuser.isCurrentUser = true;
            parseuser.isLazy = true;
            parseuser.putAuthData(s, map);
        }
        synchronized (MUTEX_CURRENT_USER)
        {
            currentUserMatchesDisk = false;
            currentUser = parseuser;
        }
        return parseuser;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        map;
        s;
        JVM INSTR monitorexit ;
        throw map;
    }

    static cu logInWithAsync(String s, Map map)
    {
        ct ct = new ct(s, map) {

            final Map val$authData;
            final String val$authType;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = ParseRESTUserCommand.serviceLogInUserCommand(authType, authData, ParseUser.isRevocableSessionEnabled());
                return cu1.executeAsync().d(cu1. new ct() {

                    final _cls18 this$0;
                    final ParseRESTUserCommand val$command;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        ParseUser parseuser;
                        boolean flag;
                        flag = true;
                        parseuser = (ParseUser)ParseObject.fromJSON((JSONObject)cu1.e(), "_User", true);
                        cu1 = ((cu) (parseuser.mutex));
                        cu1;
                        JVM INSTR monitorenter ;
                        State.Builder builder = parseuser.getState().newBuilder().putAuthData(authType, authData);
                        if (command.getStatusCode() != 201)
                        {
                            flag = false;
                        }
                        parseuser.isNew = flag;
                        parseuser.setState(builder.build());
                        return ParseUser.saveCurrentUserAsync(parseuser);
                        Exception exception;
                        exception;
                        cu1;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = final__pcls18;
                command = ParseRESTUserCommand.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                authType = s;
                authData = map;
                super();
            }
        };
        return getCurrentUserAsync().d(new ct(s, map, ct) {

            final Map val$authData;
            final String val$authType;
            final ct val$logInWithTask;

            public cu then(cu cu1)
                throws Exception
            {
                final Object user;
                user = (ParseUser)cu1.e();
                if (user != null)
                {
label0:
                    {
                        synchronized (((ParseUser) (user)).mutex)
                        {
                            if (!ParseAnonymousUtils.isLinked(((ParseUser) (user))))
                            {
                                break MISSING_BLOCK_LABEL_100;
                            }
                            if (!((ParseUser) (user)).isLazy())
                            {
                                break label0;
                            }
                            Map map1 = ((ParseUser) (user)).getAuthData("anonymous");
                            user = ((ParseUser) (user)).taskQueue.enqueue(map1. new ct() {

                                final _cls19 this$0;
                                final Map val$oldAnonymousData;
                                final ParseUser val$user;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    return cu1.b(new ct() {

                                        final _cls1 this$1;

                                        public cu then(cu cu1)
                                            throws Exception
                                        {
                                            synchronized (user.mutex)
                                            {
                                                user.stripAnonymity();
                                                user.putAuthData(authType, authData);
                                                cu1 = user.resolveLazinessAsync(cu1).j();
                                            }
                                            return cu1;
                                            cu1;
                                            obj;
                                            JVM INSTR monitorexit ;
                                            throw cu1;
                                        }

                                        public volatile Object then(cu cu1)
                                            throws Exception
                                        {
                                            return then(cu1);
                                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                                    }).b(new ct() {

                                        final _cls1 this$1;

                                        public cu then(cu cu1)
                                            throws Exception
                                        {
label0:
                                            {
                                                synchronized (user.mutex)
                                                {
                                                    if (!cu1.d())
                                                    {
                                                        break label0;
                                                    }
                                                    user.removeAuthData(authType);
                                                    user.restoreAnonymity(oldAnonymousData);
                                                    cu1 = cu.a(cu1.f());
                                                }
                                                return cu1;
                                            }
                                            if (!cu1.c())
                                            {
                                                break MISSING_BLOCK_LABEL_89;
                                            }
                                            cu1 = cu.h();
                                            obj;
                                            JVM INSTR monitorexit ;
                                            return cu1;
                                            cu1;
                                            obj;
                                            JVM INSTR monitorexit ;
                                            throw cu1;
                                            cu1 = cu.a(user);
                                            obj;
                                            JVM INSTR monitorexit ;
                                            return cu1;
                                        }

                                        public volatile Object then(cu cu1)
                                            throws Exception
                                        {
                                            return then(cu1);
                                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                                    });
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$0 = final__pcls19;
                user = parseuser;
                oldAnonymousData = Map.this;
                super();
            }
                            });
                        }
                        return ((cu) (user));
                    }
                }
                  goto _L1
                user = ((ParseUser) (user)).linkWithAsync(authType, authData, ((ParseUser) (user)).getSessionToken()).b(((_cls2) (user)). new ct() {

                    final _cls19 this$0;
                    final ParseUser val$user;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        if (cu1.d())
                        {
                            Exception exception = cu1.f();
                            if ((exception instanceof ParseException) && ((ParseException)exception).getCode() == 208)
                            {
                                return cu.a(null).b(logInWithTask);
                            }
                        }
                        if (cu1.c())
                        {
                            return cu.h();
                        } else
                        {
                            return cu.a(user);
                        }
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = final__pcls19;
                user = ParseUser.this;
                super();
            }
                });
                cu1;
                JVM INSTR monitorexit ;
                return ((cu) (user));
                exception;
                cu1;
                JVM INSTR monitorexit ;
                throw exception;
                cu1;
                JVM INSTR monitorexit ;
_L1:
                return cu.a(null).b(logInWithTask);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                authType = s;
                authData = map;
                logInWithTask = ct1;
                super();
            }
        });
    }

    public static void logOut()
    {
        try
        {
            ParseTaskUtils.wait(logOutInBackground());
            return;
        }
        catch (ParseException parseexception)
        {
            return;
        }
    }

    private cu logOutAsync()
    {
        return revokeSessionTokenAsync(logOutInternal());
    }

    public static cu logOutInBackground()
    {
        return QUEUE_CURRENT_USER.enqueue(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                return ParseUser.logOutInBackground(cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        });
    }

    private static cu logOutInBackground(cu cu1)
    {
        return cu1.b(new ct(getCurrentUserAsync(false)) {

            final cu val$userTask;

            public cu then(cu cu2)
                throws Exception
            {
                return cu.a(Arrays.asList(new cu[] {
                    userTask.d(new ct() {

                        final _cls16 this$0;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            ParseUser parseuser = (ParseUser)cu1.e();
                            if (parseuser == null)
                            {
                                return cu1.i();
                            } else
                            {
                                return parseuser.logOutAsync();
                            }
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = _cls16.this;
                super();
            }
                    }), userTask.a(new ct() {

                        final _cls16 this$0;

                        public Boolean then(cu cu1)
                            throws Exception
                        {
                            return Boolean.valueOf(ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "currentUser")));
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = _cls16.this;
                super();
            }
                    }, cu.a).b(new ct() {

                        final _cls16 this$0;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            if (Parse.isLocalDatastoreEnabled())
                            {
                                cu1 = ParseObject.unpinAllInBackground("_currentUser").a(new ct() {

                                    final _cls3 this$1;

                                    public Boolean then(cu cu1)
                                        throws Exception
                                    {
                                        boolean flag;
                                        if (!cu1.d())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        return Boolean.valueOf(flag);
                                    }

                                    public volatile Object then(cu cu1)
                                        throws Exception
                                    {
                                        return then(cu1);
                                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                                });
                            }
                            return cu1;
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = _cls16.this;
                super();
            }
                    }).c(new ct() {

                        final _cls16 this$0;

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

                        public Void then(cu cu1)
                            throws Exception
                        {
                            boolean flag = ((Boolean)cu1.e()).booleanValue();
                            synchronized (ParseUser.MUTEX_CURRENT_USER)
                            {
                                ParseUser.currentUserMatchesDisk = flag;
                                ParseUser.currentUser = null;
                            }
                            return null;
                            exception;
                            cu1;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

            
            {
                this$0 = _cls16.this;
                super();
            }
                    })
                }));
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                userTask = cu1;
                super();
            }
        });
    }

    public static void logOutInBackground(LogOutCallback logoutcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logOutInBackground(), logoutcallback);
    }

    private String logOutInternal()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = getState().sessionToken();
        for (Iterator iterator = getAuthData().entrySet().iterator(); iterator.hasNext(); logOutWith((String)((java.util.Map.Entry)iterator.next()).getKey())) { }
        break MISSING_BLOCK_LABEL_68;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        State.Builder builder = getState().newBuilder().sessionToken(null);
        isCurrentUser = false;
        isNew = false;
        setState(builder.build());
        obj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
    }

    private void logOutWith(String s)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ParseAuthenticationProvider parseauthenticationprovider = (ParseAuthenticationProvider)authenticationProviders.get(s);
        if (parseauthenticationprovider == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (isLinked(s))
        {
            parseauthenticationprovider.deauthenticate();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static cu pinCurrentUserIfNeededAsync(ParseUser parseuser)
    {
        Object obj = MUTEX_CURRENT_USER;
        obj;
        JVM INSTR monitorenter ;
        if (parseuser.isCurrentUser() && !currentUserMatchesDisk)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        parseuser = cu.a(null);
        return parseuser;
        obj;
        JVM INSTR monitorexit ;
        return saveCurrentUserAsync(parseuser).j();
        parseuser;
        obj;
        JVM INSTR monitorexit ;
        throw parseuser;
    }

    private void putAuthData(String s, Map map)
    {
        synchronized (mutex)
        {
            Map map1 = getAuthData();
            map1.put(s, map);
            performPut("authData", map1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static void registerAuthenticationProvider(ParseAuthenticationProvider parseauthenticationprovider)
    {
        authenticationProviders.put(parseauthenticationprovider.getAuthType(), parseauthenticationprovider);
        ParseUser parseuser;
        if (!(parseauthenticationprovider instanceof AnonymousAuthenticationProvider))
        {
            if ((parseuser = getCurrentUser()) != null)
            {
                parseuser.synchronizeAuthData(parseauthenticationprovider);
                return;
            }
        }
    }

    private void removeAuthData(String s)
    {
        synchronized (mutex)
        {
            Map map = getAuthData();
            map.remove(s);
            performPut("authData", map);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void requestPasswordReset(String s)
        throws ParseException
    {
        ParseTaskUtils.wait(requestPasswordResetInBackground(s));
    }

    public static cu requestPasswordResetInBackground(String s)
    {
        return ParseRESTUserCommand.resetUserPasswordCommand(s).executeAsync().j();
    }

    public static void requestPasswordResetInBackground(String s, RequestPasswordResetCallback requestpasswordresetcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(requestPasswordResetInBackground(s), requestpasswordresetcallback);
    }

    private cu resolveLazinessAsync(cu cu1)
    {
label0:
        {
            synchronized (mutex)
            {
                if (isLazy())
                {
                    break label0;
                }
                cu1 = cu.a(null);
            }
            return cu1;
        }
        if (getAuthData().size() != 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        cu1 = signUpAsync(cu1).c(new ct() {

            final ParseUser this$0;

            public ParseUser then(cu cu2)
                throws Exception
            {
                ParseUser parseuser;
                synchronized (mutex)
                {
                    isLazy = false;
                    parseuser = ParseUser.this;
                }
                return parseuser;
                exception;
                cu2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        cu1;
        obj;
        JVM INSTR monitorexit ;
        throw cu1;
        final cs operations = new cs();
        cu1 = cu.a(new Callable() {

            final ParseUser this$0;

            public ParseOperationSet call()
                throws Exception
            {
                return startSave();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        }).d(TaskQueue.waitFor(cu1)).d(new ct() {

            final ParseUser this$0;
            final cs val$operations;

            public cu then(cu cu2)
                throws Exception
            {
                operations.a(cu2.e());
                cu2 = currentServiceLogInCommand(getState(), (ParseOperationSet)operations.a());
                return cu2.executeAsync().d(cu2. new ct() {

                    final _cls24 this$1;
                    final ParseRESTUserCommand val$command;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        cu1 = (JSONObject)cu1.e();
                        boolean flag;
                        if (command.getStatusCode() == 201)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (Parse.isLocalDatastoreEnabled() && !flag)
                        {
                            cu1 = cu.a(cu1);
                        } else
                        {
                            cu1 = handleSaveResultAsync(cu1, (ParseOperationSet)operations.a()).c(cu1. new ct() {

                                final _cls1 this$2;
                                final JSONObject val$commandResult;

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

                                public JSONObject then(cu cu1)
                                    throws Exception
                                {
                                    return commandResult;
                                }

            
            {
                this$2 = final__pcls1;
                commandResult = JSONObject.this;
                super();
            }
                            });
                        }
                        return cu1.d(flag. new ct() {

                            final _cls1 this$2;
                            final boolean val$isNew;

                            public cu then(cu cu1)
                                throws Exception
                            {
                                Object obj = (JSONObject)cu1.e();
                                cu1 = ((cu) (mutex));
                                cu1;
                                JVM INSTR monitorenter ;
                                if (!isNew)
                                {
                                    break MISSING_BLOCK_LABEL_64;
                                }
                                isLazy = false;
                                obj = cu.a(_fld0);
                                return ((cu) (obj));
                                cu1;
                                JVM INSTR monitorexit ;
                                return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON(((JSONObject) (obj)), "_User", true));
                                Exception exception;
                                exception;
                                cu1;
                                JVM INSTR monitorexit ;
                                throw exception;
                            }

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

            
            {
                this$2 = final__pcls1;
                isNew = Z.this;
                super();
            }
                        });
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls24;
                command = ParseRESTUserCommand.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser.this;
                operations = cs1;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return cu1;
    }

    private void restoreAnonymity(Map map)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        putAuthData("anonymous", map);
        obj;
        JVM INSTR monitorexit ;
        return;
        map;
        obj;
        JVM INSTR monitorexit ;
        throw map;
    }

    private cu revokeSessionTokenAsync(String s)
    {
        if (s == null || !isRevocableSessionToken(s))
        {
            return cu.a(null);
        } else
        {
            return ParseRESTUserCommand.logOutUserCommand(s).executeAsync().j();
        }
    }

    private static cu saveCurrentUserAsync(ParseUser parseuser)
    {
        return QUEUE_CURRENT_USER.enqueue(new ct(parseuser) {

            final ParseUser val$user;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseUser.saveCurrentUserAsync(user, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                user = parseuser;
                super();
            }
        });
    }

    private static cu saveCurrentUserAsync(ParseUser parseuser, cu cu1)
    {
        return cu1.b(new ct(parseuser) {

            final ParseUser val$user;

            public cu then(cu cu2)
                throws Exception
            {
                ParseUser parseuser1;
                synchronized (ParseUser.MUTEX_CURRENT_USER)
                {
                    parseuser1 = ParseUser.currentUser;
                }
                if (parseuser1 != null && parseuser1 != user)
                {
                    parseuser1.logOutInternal();
                }
                synchronized (user.mutex)
                {
                    user.isCurrentUser = true;
                    user.synchronizeAllAuthData();
                }
                if (Parse.isLocalDatastoreEnabled())
                {
                    return ParseObject.unpinAllInBackground("_currentUser").b(new ct() {

                        final _cls14 this$0;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            return user.pinInBackground("_currentUser", false);
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$0 = _cls14.this;
                super();
            }
                    });
                } else
                {
                    return cu.a(new Callable() {

                        final _cls14 this$0;

                        public volatile Object call()
                            throws Exception
                        {
                            return call();
                        }

                        public Void call()
                            throws Exception
                        {
                            user.saveToDisk("currentUser");
                            return null;
                        }

            
            {
                this$0 = _cls14.this;
                super();
            }
                    }, cu.a);
                }
                exception;
                cu2;
                JVM INSTR monitorexit ;
                throw exception;
                exception1;
                cu2;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                user = parseuser;
                super();
            }
        }).a(new ct(parseuser) {

            final ParseUser val$user;

            public ParseUser then(cu cu2)
                throws Exception
            {
                Object obj = ParseUser.MUTEX_CURRENT_USER;
                obj;
                JVM INSTR monitorenter ;
                boolean flag;
                if (!cu2.d())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ParseUser.currentUserMatchesDisk = flag;
                ParseUser.currentUser = user;
                obj;
                JVM INSTR monitorexit ;
                return user;
                cu2;
                obj;
                JVM INSTR monitorexit ;
                throw cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                user = parseuser;
                super();
            }
        });
    }

    private cu setSessionTokenInBackground(String s)
    {
        synchronized (mutex)
        {
            setState(getState().newBuilder().sessionToken(s).build());
            s = saveCurrentUserAsync(this).j();
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private cu signUpAsync(cu cu1)
    {
        final Object user = getCurrentUser();
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        final String sessionToken = ((ParseUser) (user)).getSessionToken();
_L3:
        if (!ParseTextUtils.isEmpty(getUsername())) goto _L2; else goto _L1
_L1:
        cu1 = cu.a(new IllegalArgumentException("Username cannot be missing or blank"));
        obj;
        JVM INSTR monitorexit ;
        return cu1;
_L2:
        if (!ParseTextUtils.isEmpty(getPassword()))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        cu1 = cu.a(new IllegalArgumentException("Password cannot be missing or blank"));
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        cu1;
        obj;
        JVM INSTR monitorexit ;
        throw cu1;
        if (getObjectId() == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        user = getAuthData();
        if (!((Map) (user)).containsKey("anonymous") || ((Map) (user)).get("anonymous") != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        cu1 = saveAsync(sessionToken, cu1);
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        cu1 = cu.a(new IllegalArgumentException("Cannot sign up a user that has already signed up."));
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        if (operationSetQueue.size() <= 1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        cu1 = cu.a(new IllegalArgumentException("Cannot sign up a user that is already signing up."));
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        if (!ParseAnonymousUtils.isLinked(((ParseUser) (user))))
        {
            break MISSING_BLOCK_LABEL_310;
        }
        if (this != user)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        cu1 = cu.a(new IllegalArgumentException("Attempt to merge currentUser with itself."));
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        checkForChangesToMutableContainers();
        ((ParseUser) (user)).checkForChangesToMutableContainers();
        final String oldUsername = ((ParseUser) (user)).getUsername();
        final String oldPassword = ((ParseUser) (user)).getPassword();
        final Map anonymousData = ((ParseUser) (user)).getAuthData("anonymous");
        ((ParseUser) (user)).copyChangesFrom(this);
        ((ParseUser) (user)).setUsername(getUsername());
        ((ParseUser) (user)).setPassword(getPassword());
        revert();
        cu1 = ((ParseUser) (user)).saveAsync(sessionToken, cu1).b(new ct() {

            final ParseUser this$0;
            final Map val$anonymousData;
            final String val$oldPassword;
            final String val$oldUsername;
            final ParseUser val$user;

            public cu then(cu cu2)
                throws Exception
            {
                if (cu2.c() || cu2.d())
                {
                    synchronized (user.mutex)
                    {
                        if (oldUsername != null)
                        {
                            user.setUsername(oldUsername);
                        }
                        if (oldPassword != null)
                        {
                            user.setPassword(oldPassword);
                        }
                        user.restoreAnonymity(anonymousData);
                    }
                    return cu2;
                } else
                {
                    revert("password");
                    mergeFromObject(user);
                    return ParseUser.saveCurrentUserAsync(ParseUser.this).j();
                }
                cu2;
                obj1;
                JVM INSTR monitorexit ;
                throw cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser.this;
                user = parseuser1;
                oldUsername = s;
                oldPassword = s1;
                anonymousData = map;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        cu1 = cu.a(new Callable() {

            final ParseUser this$0;

            public ParseOperationSet call()
                throws Exception
            {
                ParseOperationSet parseoperationset;
                synchronized (mutex)
                {
                    parseoperationset = startSave();
                }
                return parseoperationset;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        }).b(TaskQueue.waitFor(cu1)).d(new ct() {

            final ParseUser this$0;
            final String val$sessionToken;

            public cu then(cu cu2)
                throws Exception
            {
                cu2 = (ParseOperationSet)cu2.e();
                return ParseRESTUserCommand.signUpUserCommand(toJSONObjectForSaving(getState(), cu2, PointerEncoder.get()), sessionToken, ParseUser.isRevocableSessionEnabled()).executeAsync().b(cu2. new ct() {

                    final _cls5 this$1;
                    final ParseOperationSet val$operations;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return handleSaveResultAsync((JSONObject)cu1.e(), operations).b(cu1. new ct() {

                            final _cls1 this$2;
                            final cu val$signUpTask;

                            public cu then(cu cu1)
                                throws Exception
                            {
                                if (!signUpTask.c() && !signUpTask.d())
                                {
                                    synchronized (mutex)
                                    {
                                        isNew = true;
                                        isLazy = false;
                                    }
                                    return ParseUser.saveCurrentUserAsync(_fld0).j();
                                } else
                                {
                                    return signUpTask.j();
                                }
                                exception;
                                cu1;
                                JVM INSTR monitorexit ;
                                throw exception;
                            }

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

            
            {
                this$2 = final__pcls1;
                signUpTask = cu.this;
                super();
            }
                        });
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls5;
                operations = ParseOperationSet.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser.this;
                sessionToken = s;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return cu1;
        sessionToken = null;
          goto _L3
    }

    private void stripAnonymity()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (ParseAnonymousUtils.isLinked(this))
        {
            if (getObjectId() == null)
            {
                break MISSING_BLOCK_LABEL_32;
            }
            putAuthData("anonymous", null);
        }
_L2:
        return;
        removeAuthData("anonymous");
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void synchronizeAllAuthData()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = getAuthData().entrySet().iterator(); iterator.hasNext(); synchronizeAuthData((String)((java.util.Map.Entry)iterator.next()).getKey())) { }
        break MISSING_BLOCK_LABEL_60;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void synchronizeAuthData(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                if (isCurrentUser())
                {
                    break label0;
                }
            }
            return;
        }
        s = (ParseAuthenticationProvider)authenticationProviders.get(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        synchronizeAuthData(((ParseAuthenticationProvider) (s)));
        obj;
        JVM INSTR monitorexit ;
    }

    private cu upgradeToRevocableSessionAsync(cu cu1)
    {
        final String sessionToken = getSessionToken();
        if (sessionToken == null || isRevocableSessionToken(sessionToken))
        {
            return cu1;
        } else
        {
            return cu1.b(new ct() {

                final ParseUser this$0;
                final String val$sessionToken;

                public cu then(cu cu2)
                    throws Exception
                {
                    return ParseRESTUserCommand.upgradeRevocableSessionCommand(sessionToken).executeAsync().i();
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser.this;
                sessionToken = s;
                super();
            }
            }).d(new ct() {

                final ParseUser this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    cu2 = (ParseSession)ParseObject.fromJSON((JSONObject)cu2.e(), "_Session", true);
                    return setSessionTokenInBackground(cu2.getSessionToken());
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser.this;
                super();
            }
            });
        }
    }

    public volatile ParseObject fetch()
        throws ParseException
    {
        return fetch();
    }

    public ParseUser fetch()
        throws ParseException
    {
        return (ParseUser)super.fetch();
    }

    cu fetchAsync(String s, cu cu1)
    {
label0:
        {
            synchronized (mutex)
            {
                if (!isLazy())
                {
                    break label0;
                }
                s = cu.a(this);
            }
            return s;
        }
        s = super.fetchAsync(s, cu1).d(new ct() {

            final ParseUser this$0;

            public cu then(cu cu2)
                throws Exception
            {
                cu cu3 = cu2;
                if (isCurrentUser())
                {
                    cleanUpAuthData();
                    cu3 = ParseUser.saveCurrentUserAsync(ParseUser.this).b(cu2. new ct() {

                        final _cls2 this$1;
                        final cu val$fetchAsyncTask;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            return fetchAsyncTask;
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$1 = final__pcls2;
                fetchAsyncTask = cu.this;
                super();
            }
                    });
                }
                return cu3;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    cu fetchFromLocalDatastoreAsync()
    {
        if (isLazy())
        {
            return cu.a(this);
        } else
        {
            return super.fetchFromLocalDatastoreAsync();
        }
    }

    public volatile ParseObject fetchIfNeeded()
        throws ParseException
    {
        return fetchIfNeeded();
    }

    public ParseUser fetchIfNeeded()
        throws ParseException
    {
        return (ParseUser)super.fetchIfNeeded();
    }

    public String getEmail()
    {
        return getString("email");
    }

    String getPassword()
    {
        return getString("password");
    }

    public String getSessionToken()
    {
        return getState().sessionToken();
    }

    volatile ParseObject.State getState()
    {
        return getState();
    }

    State getState()
    {
        return (State)super.getState();
    }

    public String getUsername()
    {
        return getString("username");
    }

    cu handleSaveResultAsync(ParseObject.State state, ParseOperationSet parseoperationset)
    {
        boolean flag;
        if (state != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            parseoperationset.remove("password");
        }
        return super.handleSaveResultAsync(state, parseoperationset);
    }

    public boolean isAuthenticated()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ParseUser parseuser = getCurrentUser();
        if (isLazy()) goto _L2; else goto _L1
_L1:
        if (getState().sessionToken() == null || parseuser == null) goto _L4; else goto _L3
_L3:
        if (!getObjectId().equals(parseuser.getObjectId())) goto _L4; else goto _L2
_L6:
        obj;
        JVM INSTR monitorexit ;
        boolean flag;
        return flag;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    boolean isContainerObject(String s, Object obj)
    {
        if ("authData".equals(s))
        {
            return false;
        } else
        {
            return super.isContainerObject(s, obj);
        }
    }

    boolean isCurrentUser()
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = isCurrentUser;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean isKeyMutable(String s)
    {
        return !READ_ONLY_KEYS.contains(s);
    }

    boolean isLazy()
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = isLazy;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean isLinked(String s)
    {
        Map map = getAuthData();
        return map.containsKey(s) && map.get(s) != null;
    }

    public boolean isNew()
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = isNew;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    cu linkWithAsync(final String authType, final Map authData, final String sessionToken)
    {
        return taskQueue.enqueue(new ct() {

            final ParseUser this$0;
            final Map val$authData;
            final String val$authType;
            final String val$sessionToken;

            public cu then(cu cu1)
                throws Exception
            {
                return linkWithAsync(authType, authData, cu1, sessionToken);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseUser.this;
                authType = s;
                authData = map;
                sessionToken = s1;
                super();
            }
        });
    }

    ParseObject.State mergeFromDiskJSON(ParseObject.State state, JSONObject jsonobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        state = (State.Builder)state.newBuilder();
        obj1 = jsonobject.optString("session_token", null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        state.sessionToken(((String) (obj1)));
        jsonobject.remove("session_token");
        obj1 = jsonobject.optJSONObject("auth_data");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        try
        {
            String s;
            for (Iterator iterator = ((JSONObject) (obj1)).keys(); iterator.hasNext(); synchronizeAuthData(s))
            {
                s = (String)iterator.next();
                if (!((JSONObject) (obj1)).isNull(s))
                {
                    state.putAuthData(s, (Map)ParseDecoder.get().decode(((JSONObject) (obj1)).getJSONObject(s)));
                }
            }

            break MISSING_BLOCK_LABEL_145;
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State state) { }
        finally { }
        throw new RuntimeException(state);
        obj;
        JVM INSTR monitorexit ;
        throw state;
        jsonobject.remove("auth_data");
        state = super.mergeFromDiskJSON(state.build(), jsonobject);
        obj;
        JVM INSTR monitorexit ;
        return state;
    }

    void mergeFromObject(ParseObject parseobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (this != parseobject)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if (parseobject instanceof ParseUser)
        {
            isNew = ((ParseUser)parseobject).isNew();
        }
        super.mergeFromObject(parseobject);
        obj;
        JVM INSTR monitorexit ;
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    boolean needsDefaultACL()
    {
        return false;
    }

    volatile ParseObject.State.Init newStateBuilder(String s)
    {
        return newStateBuilder(s);
    }

    State.Builder newStateBuilder(String s)
    {
        return new State.Builder(s);
    }

    public void put(String s, Object obj)
    {
        synchronized (mutex)
        {
            if ("username".equals(s))
            {
                stripAnonymity();
            }
            super.put(s, obj);
        }
        return;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void remove(String s)
    {
        if ("username".equals(s))
        {
            throw new IllegalArgumentException("Can't remove the username key.");
        } else
        {
            super.remove(s);
            return;
        }
    }

    cu saveAsync(String s, cu cu1)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (!isLazy())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        s = resolveLazinessAsync(cu1).j();
_L1:
        s = s.d(new ct() {

            final ParseUser this$0;

            public cu then(cu cu2)
                throws Exception
            {
                if (isCurrentUser())
                {
                    cleanUpAuthData();
                    return ParseUser.saveCurrentUserAsync(ParseUser.this).j();
                } else
                {
                    return cu.a(null);
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        return s;
        s = super.saveAsync(s, cu1);
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setEmail(String s)
    {
        put("email", s);
    }

    public void setPassword(String s)
    {
        put("password", s);
    }

    public void setUsername(String s)
    {
        put("username", s);
    }

    public void signUp()
        throws ParseException
    {
        ParseTaskUtils.wait(signUpInBackground());
    }

    public cu signUpInBackground()
    {
        return taskQueue.enqueue(new ct() {

            final ParseUser this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return signUpAsync(cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
    }

    public void signUpInBackground(SignUpCallback signupcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(signUpInBackground(), signupcallback);
    }

    void synchronizeAuthData(ParseAuthenticationProvider parseauthenticationprovider)
    {
        synchronized (mutex)
        {
            String s = parseauthenticationprovider.getAuthType();
            if (!parseauthenticationprovider.restoreAuthentication(getAuthData(s)))
            {
                unlinkFromAsync(s);
            }
        }
        return;
        parseauthenticationprovider;
        obj;
        JVM INSTR monitorexit ;
        throw parseauthenticationprovider;
    }

    JSONObject toJSONObjectForDataFile(ParseObject.State state, ParseEncoder parseencoder)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        String s;
        jsonobject = super.toJSONObjectForDataFile(state, parseencoder);
        s = ((State)state).sessionToken();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        jsonobject.put("session_token", s);
        int i;
        state = ((State)state).authData();
        i = state.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        jsonobject.put("auth_data", parseencoder.encode(state));
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
        state;
        throw new RuntimeException("could not encode value for key: session_token");
        state;
        obj;
        JVM INSTR monitorexit ;
        throw state;
        state;
        throw new RuntimeException("could not attach key: auth_data");
    }

    JSONObject toRest(ParseObject.State state, List list, ParseEncoder parseencoder)
    {
        int i = 0;
        Object obj;
        Object obj1;
        for (obj = list; i < list.size(); obj = obj1)
        {
            ParseOperationSet parseoperationset = (ParseOperationSet)list.get(i);
            obj1 = obj;
            if (parseoperationset.containsKey("password"))
            {
                obj1 = obj;
                if (obj == list)
                {
                    obj1 = new LinkedList(list);
                }
                obj = new ParseOperationSet(parseoperationset);
                ((ParseOperationSet) (obj)).remove("password");
                ((List) (obj1)).set(i, obj);
            }
            i++;
        }

        return super.toRest(state, ((List) (obj)), parseencoder);
    }

    cu unlinkFromAsync(final String authType)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (authType != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        authType = cu.a(null);
        obj;
        JVM INSTR monitorexit ;
        return authType;
        authType = cu.a(null).b(new ct() {

            final ParseUser this$0;
            final String val$authType;

            public cu then(cu cu1)
                throws Exception
            {
label0:
                {
                    cu cu2;
                    synchronized (mutex)
                    {
                        if (!getAuthData().containsKey(authType))
                        {
                            break label0;
                        }
                        putAuthData(authType, null);
                        cu2 = saveInBackground();
                    }
                    return cu2;
                }
                cu cu3 = cu.a(null);
                cu1;
                JVM INSTR monitorexit ;
                return cu3;
                exception;
                cu1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseUser.this;
                authType = s;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return authType;
        authType;
        obj;
        JVM INSTR monitorexit ;
        throw authType;
    }

    cu upgradeToRevocableSessionAsync()
    {
        return taskQueue.enqueue(new ct() {

            final ParseUser this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return upgradeToRevocableSessionAsync(cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
    }

    void validateDelete()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        super.validateDelete();
        if (!isAuthenticated() && isDirty())
        {
            throw new IllegalArgumentException("Cannot delete a ParseUser that is not authenticated.");
        }
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    void validateSave()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (getObjectId() == null)
        {
            throw new IllegalArgumentException("Cannot save a ParseUser until it has been signed up. Call signUp first.");
        }
        break MISSING_BLOCK_LABEL_30;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!isAuthenticated() && isDirty() && !isCurrentUser())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        obj;
        JVM INSTR monitorexit ;
label0:
        {
            if (!Parse.isLocalDatastoreEnabled())
            {
                ParseUser parseuser = getCurrentUser();
                if (parseuser != null && getObjectId().equals(parseuser.getObjectId()))
                {
                    break label0;
                }
            }
            throw new IllegalArgumentException("Cannot save a ParseUser that is not authenticated.");
        }
        return;
    }





/*
    static boolean access$1002(boolean flag)
    {
        currentUserMatchesDisk = flag;
        return flag;
    }

*/


/*
    static boolean access$1102(ParseUser parseuser, boolean flag)
    {
        parseuser.isCurrentUser = flag;
        return flag;
    }

*/






















/*
    static boolean access$602(ParseUser parseuser, boolean flag)
    {
        parseuser.isNew = flag;
        return flag;
    }

*/


/*
    static boolean access$702(ParseUser parseuser, boolean flag)
    {
        parseuser.isLazy = flag;
        return flag;
    }

*/


}
