// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseException, ParseTaskUtils, ParseUserController, 
//            ParseCorePlugins, NetworkUserController, ParsePlugins, ParseCurrentUserController, 
//            ParseQuery, TaskQueue, Parse, ParseAuthenticationManager, 
//            ParseAnonymousUtils, ParseOperationSet, ParseSession, ParseTextUtils, 
//            LogInCallback, LogOutCallback, AuthenticationCallback, RequestPasswordResetCallback, 
//            SignUpCallback, ParseEncoder

public class ParseUser extends ParseObject
{
    static class State extends ParseObject.State
    {

        private final boolean isNew;

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

        public boolean isNew()
        {
            return isNew;
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
            isNew = builder.isNew;
        }

    }

    static class State.Builder extends ParseObject.State.Init
    {

        private boolean isNew;

        public volatile ParseObject.State.Init apply(ParseObject.State state)
        {
            return apply(state);
        }

        public State.Builder apply(ParseObject.State state)
        {
            isNew(((State)state).isNew());
            return (State.Builder)super.apply(state);
        }

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

        public State.Builder isNew(boolean flag)
        {
            isNew = flag;
            return this;
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


        public State.Builder()
        {
            super("_User");
        }

        State.Builder(State state)
        {
            super(state);
            isNew = state.isNew();
        }
    }


    private static final String KEY_AUTH_DATA = "authData";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SESSION_TOKEN = "sessionToken";
    private static final String KEY_USERNAME = "username";
    private static final List READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[] {
        "sessionToken", "authData"
    }));
    private static boolean autoUserEnabled;
    private static final Object isAutoUserEnabledMutex = new Object();
    private boolean isCurrentUser;

    public ParseUser()
    {
        isCurrentUser = false;
    }

    public static ParseUser become(String s)
        throws ParseException
    {
        return (ParseUser)ParseTaskUtils.wait(becomeInBackground(s));
    }

    public static j becomeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Must specify a sessionToken for the user to log in with");
        } else
        {
            return getUserController().getUserAsync(s).d(new i() {

                public j then(j j1)
                    throws Exception
                {
                    j1 = (ParseUser)ParseObject.from((State)j1.e());
                    return ParseUser.saveCurrentUserAsync(j1).c(j1. new i() {

                        final _cls10 this$0;
                        final ParseUser val$user;

                        public ParseUser then(j j1)
                            throws Exception
                        {
                            return user;
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$0 = final__pcls10;
                user = ParseUser.this;
                super();
            }
                    });
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            });
        }
    }

    public static void becomeInBackground(String s, LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(becomeInBackground(s), logincallback);
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

    public static j enableRevocableSessionInBackground()
    {
        ParseCorePlugins.getInstance().registerUserController(new NetworkUserController(ParsePlugins.get().restClient(), true));
        return getCurrentUserController().getAsync(false).d(new i() {

            public j then(j j1)
                throws Exception
            {
                j1 = (ParseUser)j1.e();
                if (j1 == null)
                {
                    return j.a(null);
                } else
                {
                    return j1.upgradeToRevocableSessionAsync();
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

        });
    }

    private Map getAuthData(String s)
    {
        return (Map)getAuthData().get(s);
    }

    static ParseAuthenticationManager getAuthenticationManager()
    {
        return ParseCorePlugins.getInstance().getAuthenticationManager();
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

    static j getCurrentSessionTokenAsync()
    {
        return getCurrentUserController().getCurrentSessionTokenAsync();
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
            parseuser = (ParseUser)ParseTaskUtils.wait(getCurrentUserController().getAsync(flag));
        }
        catch (ParseException parseexception)
        {
            return null;
        }
        return parseuser;
    }

    static j getCurrentUserAsync()
    {
        return getCurrentUserController().getAsync();
    }

    static ParseCurrentUserController getCurrentUserController()
    {
        return ParseCorePlugins.getInstance().getCurrentUserController();
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseUser);
    }

    static ParseUserController getUserController()
    {
        return ParseCorePlugins.getInstance().getUserController();
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

    private j linkWithAsync(final String authType, Map map, j j1, String s)
    {
        synchronized (mutex)
        {
            boolean flag = isLazy();
            final Map oldAnonymousData = getAuthData("anonymous");
            stripAnonymity();
            putAuthData(authType, map);
            authType = saveAsync(s, flag, j1).b(new i() {

                final ParseUser this$0;
                final String val$authType;
                final Map val$oldAnonymousData;

                public j then(j j2)
                    throws Exception
                {
label0:
                    {
                        synchronized (mutex)
                        {
                            if (!j2.d() && !j2.c())
                            {
                                break label0;
                            }
                            restoreAnonymity(oldAnonymousData);
                        }
                        return j2;
                    }
                    j2 = synchronizeAuthDataAsync(authType);
                    obj1;
                    JVM INSTR monitorexit ;
                    return j2;
                    j2;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
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

    private j linkWithAsync(final String authType, final Map authData, final String sessionToken)
    {
        return taskQueue.enqueue(new i() {

            final ParseUser this$0;
            final Map val$authData;
            final String val$authType;
            final String val$sessionToken;

            public j then(j j1)
                throws Exception
            {
                return linkWithAsync(authType, authData, j1, sessionToken);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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

    public static ParseUser logIn(String s, String s1)
        throws ParseException
    {
        return (ParseUser)ParseTaskUtils.wait(logInInBackground(s, s1));
    }

    public static j logInInBackground(String s, String s1)
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
            return getUserController().logInAsync(s, s1).d(new i() {

                public j then(j j1)
                    throws Exception
                {
                    j1 = (ParseUser)ParseObject.from((State)j1.e());
                    return ParseUser.saveCurrentUserAsync(j1).c(j1. new i() {

                        final _cls9 this$0;
                        final ParseUser val$newCurrent;

                        public ParseUser then(j j1)
                            throws Exception
                        {
                            return newCurrent;
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$0 = final__pcls9;
                newCurrent = ParseUser.this;
                super();
            }
                    });
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            });
        }
    }

    public static void logInInBackground(String s, String s1, LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(s, s1), logincallback);
    }

    public static j logInWithInBackground(String s, Map map)
    {
        if (s == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid authType: ").append(null).toString());
        } else
        {
            i i = new i(s, map) {

                final Map val$authData;
                final String val$authType;

                public j then(j j1)
                    throws Exception
                {
                    return ParseUser.getUserController().logInAsync(authType, authData).d(new i() {

                        final _cls11 this$0;

                        public j then(j j1)
                            throws Exception
                        {
                            j1 = (ParseUser)ParseObject.from((State)j1.e());
                            return ParseUser.saveCurrentUserAsync(j1).c(j1. new i() {

                                final _cls1 this$1;
                                final ParseUser val$user;

                                public ParseUser then(j j1)
                                    throws Exception
                                {
                                    return user;
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$1 = final__pcls1;
                user = ParseUser.this;
                super();
            }
                            });
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$0 = _cls11.this;
                super();
            }
                    });
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                authType = s;
                authData = map;
                super();
            }
            };
            return getCurrentUserAsync().d(new i(s, map, i) {

                final Map val$authData;
                final String val$authType;
                final i val$logInWithTask;

                public j then(j j1)
                    throws Exception
                {
                    final Object user;
                    user = (ParseUser)j1.e();
                    if (user != null)
                    {
label0:
                        {
                            synchronized (((ParseUser) (user)).mutex)
                            {
                                if (!ParseAnonymousUtils.isLinked(((ParseUser) (user))))
                                {
                                    break MISSING_BLOCK_LABEL_96;
                                }
                                if (!((ParseUser) (user)).isLazy())
                                {
                                    break label0;
                                }
                                Map map1 = ((ParseUser) (user)).getAuthData("anonymous");
                                user = ((ParseUser) (user)).taskQueue.enqueue(map1. new i() {

                                    final _cls12 this$0;
                                    final Map val$oldAnonymousData;
                                    final ParseUser val$user;

                                    public j then(j j1)
                                        throws Exception
                                    {
                                        return j1.b(new i() {

                                            final _cls1 this$1;

                                            public j then(j j1)
                                                throws Exception
                                            {
                                                synchronized (user.mutex)
                                                {
                                                    user.stripAnonymity();
                                                    user.putAuthData(authType, authData);
                                                    j1 = user.resolveLazinessAsync(j1);
                                                }
                                                return j1;
                                                j1;
                                                obj;
                                                JVM INSTR monitorexit ;
                                                throw j1;
                                            }

                                            public volatile Object then(j j1)
                                                throws Exception
                                            {
                                                return then(j1);
                                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                                        }).b(new i() {

                                            final _cls1 this$1;

                                            public j then(j j1)
                                                throws Exception
                                            {
label0:
                                                {
                                                    synchronized (user.mutex)
                                                    {
                                                        if (!j1.d())
                                                        {
                                                            break label0;
                                                        }
                                                        user.removeAuthData(authType);
                                                        user.restoreAnonymity(oldAnonymousData);
                                                        j1 = j.a(j1.f());
                                                    }
                                                    return j1;
                                                }
                                                if (!j1.c())
                                                {
                                                    break MISSING_BLOCK_LABEL_89;
                                                }
                                                j1 = j.h();
                                                obj;
                                                JVM INSTR monitorexit ;
                                                return j1;
                                                j1;
                                                obj;
                                                JVM INSTR monitorexit ;
                                                throw j1;
                                                j1 = j.a(user);
                                                obj;
                                                JVM INSTR monitorexit ;
                                                return j1;
                                            }

                                            public volatile Object then(j j1)
                                                throws Exception
                                            {
                                                return then(j1);
                                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                                        });
                                    }

                                    public volatile Object then(j j1)
                                        throws Exception
                                    {
                                        return then(j1);
                                    }

            
            {
                this$0 = final__pcls12;
                user = parseuser;
                oldAnonymousData = Map.this;
                super();
            }
                                });
                            }
                            return ((j) (user));
                        }
                    }
                      goto _L1
                    user = ((ParseUser) (user)).linkWithInBackground(authType, authData).b(((_cls2) (user)). new i() {

                        final _cls12 this$0;
                        final ParseUser val$user;

                        public j then(j j1)
                            throws Exception
                        {
                            if (j1.d())
                            {
                                Exception exception = j1.f();
                                if ((exception instanceof ParseException) && ((ParseException)exception).getCode() == 208)
                                {
                                    return j.a(null).b(logInWithTask);
                                }
                            }
                            if (j1.c())
                            {
                                return j.h();
                            } else
                            {
                                return j.a(user);
                            }
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$0 = final__pcls12;
                user = ParseUser.this;
                super();
            }
                    });
                    j1;
                    JVM INSTR monitorexit ;
                    return ((j) (user));
                    exception;
                    j1;
                    JVM INSTR monitorexit ;
                    throw exception;
                    j1;
                    JVM INSTR monitorexit ;
_L1:
                    return j.a(null).b(logInWithTask);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                authType = s;
                authData = map;
                logInWithTask = k;
                super();
            }
            });
        }
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

    public static j logOutInBackground()
    {
        return getCurrentUserController().logOutAsync();
    }

    public static void logOutInBackground(LogOutCallback logoutcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logOutInBackground(), logoutcallback);
    }

    static j pinCurrentUserIfNeededAsync(ParseUser parseuser)
    {
        if (!Parse.isLocalDatastoreEnabled())
        {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        } else
        {
            return getCurrentUserController().setIfNeededAsync(parseuser);
        }
    }

    public static void registerAuthenticationCallback(String s, AuthenticationCallback authenticationcallback)
    {
        getAuthenticationManager().register(s, authenticationcallback);
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

    public static j requestPasswordResetInBackground(String s)
    {
        return getUserController().requestPasswordResetAsync(s);
    }

    public static void requestPasswordResetInBackground(String s, RequestPasswordResetCallback requestpasswordresetcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(requestPasswordResetInBackground(s), requestpasswordresetcallback);
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

    private static j saveCurrentUserAsync(ParseUser parseuser)
    {
        return getCurrentUserController().setAsync(parseuser);
    }

    private j setSessionTokenInBackground(String s)
    {
        State state;
label0:
        {
            synchronized (mutex)
            {
                state = getState();
                if (!s.equals(state.sessionToken()))
                {
                    break label0;
                }
                s = j.a(null);
            }
            return s;
        }
        setState(state.newBuilder().sessionToken(s).build());
        s = saveCurrentUserAsync(this);
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
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

    private j synchronizeAuthDataAsync(ParseAuthenticationManager parseauthenticationmanager, final String authType, Map map)
    {
        return parseauthenticationmanager.restoreAuthenticationAsync(authType, map).b(new i() {

            final ParseUser this$0;
            final String val$authType;

            public j then(j j1)
                throws Exception
            {
                boolean flag;
                if (!j1.d() && ((Boolean)j1.e()).booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    return unlinkFromInBackground(authType);
                } else
                {
                    return j1.j();
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseUser.this;
                authType = s;
                super();
            }
        });
    }

    private j upgradeToRevocableSessionAsync(j j1)
    {
        return j1.b(new i() {

            final ParseUser this$0;
            final String val$sessionToken;

            public j then(j j2)
                throws Exception
            {
                return ParseSession.upgradeToRevocableSessionAsync(sessionToken);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseUser.this;
                sessionToken = s;
                super();
            }
        }).d(new i() {

            final ParseUser this$0;

            public j then(j j2)
                throws Exception
            {
                j2 = (String)j2.e();
                return setSessionTokenInBackground(j2);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
    }

    j cleanUpAuthDataAsync()
    {
        Object obj;
        Map map;
label0:
        {
            obj = getAuthenticationManager();
            synchronized (mutex)
            {
                map = getState().authData();
                if (map.size() != 0)
                {
                    break label0;
                }
                obj = j.a(null);
            }
            return ((j) (obj));
        }
        obj1;
        JVM INSTR monitorexit ;
        obj1 = new ArrayList();
        Iterator iterator = map.entrySet().iterator();
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
                ((List) (obj1)).add(((ParseAuthenticationManager) (obj)).restoreAuthenticationAsync((String)entry.getKey(), null).j());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_132;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        setState(getState().newBuilder().authData(map).build());
        return j.a(((java.util.Collection) (obj1)));
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

    j fetchAsync(String s, j j1)
    {
        if (isLazy())
        {
            s = j.a(this);
        } else
        {
            j1 = super.fetchAsync(s, j1);
            s = j1;
            if (isCurrentUser())
            {
                return j1.d(new i() {

                    final ParseUser this$0;

                    public j then(j j2)
                        throws Exception
                    {
                        return cleanUpAuthDataAsync();
                    }

                    public volatile Object then(j j2)
                        throws Exception
                    {
                        return then(j2);
                    }

            
            {
                this$0 = ParseUser.this;
                super();
            }
                }).d(new i() {

                    final ParseUser this$0;

                    public j then(j j2)
                        throws Exception
                    {
                        return ParseUser.saveCurrentUserAsync(ParseUser.this);
                    }

                    public volatile Object then(j j2)
                        throws Exception
                    {
                        return then(j2);
                    }

            
            {
                this$0 = ParseUser.this;
                super();
            }
                }).c(new i() {

                    final ParseUser this$0;

                    public ParseObject then(j j2)
                        throws Exception
                    {
                        return ParseUser.this;
                    }

                    public volatile Object then(j j2)
                        throws Exception
                    {
                        return then(j2);
                    }

            
            {
                this$0 = ParseUser.this;
                super();
            }
                });
            }
        }
        return s;
    }

    j fetchFromLocalDatastoreAsync()
    {
        if (isLazy())
        {
            return j.a(this);
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

    Map getAuthData()
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

    j handleSaveResultAsync(ParseObject.State state, ParseOperationSet parseoperationset)
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
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (getObjectId() == null && ParseAnonymousUtils.isLinked(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isLinked(String s)
    {
        Map map = getAuthData();
        return map.containsKey(s) && map.get(s) != null;
    }

    public boolean isNew()
    {
        return getState().isNew();
    }

    public j linkWithInBackground(String s, Map map)
    {
        if (s == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid authType: ").append(null).toString());
        } else
        {
            return linkWithAsync(s, map, getSessionToken());
        }
    }

    j logOutAsync()
    {
        return logOutAsync(true);
    }

    j logOutAsync(boolean flag)
    {
        Object obj1;
        ParseAuthenticationManager parseauthenticationmanager;
        parseauthenticationmanager = getAuthenticationManager();
        obj1 = new ArrayList();
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        s = getState().sessionToken();
        for (Iterator iterator = getAuthData().entrySet().iterator(); iterator.hasNext(); ((List) (obj1)).add(parseauthenticationmanager.deauthenticateAsync((String)((java.util.Map.Entry)iterator.next()).getKey()))) { }
        break MISSING_BLOCK_LABEL_93;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        State state = getState().newBuilder().sessionToken(null).isNew(false).build();
        isCurrentUser = false;
        setState(state);
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            ((List) (obj1)).add(ParseSession.revokeAsync(s));
        }
        return j.a(((java.util.Collection) (obj1)));
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
        return new State.Builder();
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

    void putAuthData(String s, Map map)
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

    j resolveLazinessAsync(j j1)
    {
label0:
        {
            synchronized (mutex)
            {
                if (getAuthData().size() != 0)
                {
                    break label0;
                }
                j1 = signUpAsync(j1);
            }
            return j1;
        }
        j1 = j1.d(new i() {

            final ParseUser this$0;
            final ParseOperationSet val$operations;

            public j then(j j2)
                throws Exception
            {
                return ParseUser.getUserController().logInAsync(getState(), operations).d(new i() {

                    final _cls16 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        j1 = (State)j1.e();
                        if (Parse.isLocalDatastoreEnabled() && !j1.isNew())
                        {
                            j1 = j.a(j1);
                        } else
                        {
                            j1 = handleSaveResultAsync(j1, operations).c(j1. new i() {

                                final _cls1 this$2;
                                final State val$result;

                                public State then(j j1)
                                    throws Exception
                                {
                                    return result;
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$2 = final__pcls1;
                result = State.this;
                super();
            }
                            });
                        }
                        return j1.d(new i() {

                            final _cls1 this$2;

                            public j then(j j1)
                                throws Exception
                            {
                                State state = (State)j1.e();
                                if (!state.isNew())
                                {
                                    return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.from(state));
                                } else
                                {
                                    return j1.j();
                                }
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls16.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseUser.this;
                operations = parseoperationset;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return j1;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
    }

    j saveAsync(String s, j j1)
    {
        return saveAsync(s, isLazy(), j1);
    }

    j saveAsync(String s, boolean flag, j j1)
    {
        if (flag)
        {
            s = resolveLazinessAsync(j1);
        } else
        {
            s = super.saveAsync(s, j1);
        }
        j1 = s;
        if (isCurrentUser())
        {
            j1 = s.d(new i() {

                final ParseUser this$0;

                public j then(j j2)
                    throws Exception
                {
                    return cleanUpAuthDataAsync();
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseUser.this;
                super();
            }
            }).d(new i() {

                final ParseUser this$0;

                public j then(j j2)
                    throws Exception
                {
                    return ParseUser.saveCurrentUserAsync(ParseUser.this);
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseUser.this;
                super();
            }
            });
        }
        return j1;
    }

    public void setEmail(String s)
    {
        put("email", s);
    }

    void setIsCurrentUser(boolean flag)
    {
        synchronized (mutex)
        {
            isCurrentUser = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setPassword(String s)
    {
        put("password", s);
    }

    void setState(ParseObject.State state)
    {
        ParseObject.State state1 = state;
        if (isCurrentUser())
        {
            state1 = state;
            if (getSessionToken() != null)
            {
                state1 = state;
                if (state.get("sessionToken") == null)
                {
                    state1 = state.newBuilder().put("sessionToken", getSessionToken()).build();
                }
            }
        }
        super.setState(state1);
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

    j signUpAsync(j j1)
    {
        final Object user = getCurrentUser();
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        String s = ((ParseUser) (user)).getSessionToken();
_L3:
        if (!ParseTextUtils.isEmpty(getUsername())) goto _L2; else goto _L1
_L1:
        j1 = j.a(new IllegalArgumentException("Username cannot be missing or blank"));
        obj;
        JVM INSTR monitorexit ;
        return j1;
_L2:
        if (!ParseTextUtils.isEmpty(getPassword()))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        j1 = j.a(new IllegalArgumentException("Password cannot be missing or blank"));
        obj;
        JVM INSTR monitorexit ;
        return j1;
        j1;
        obj;
        JVM INSTR monitorexit ;
        throw j1;
        if (getObjectId() == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        user = getAuthData();
        if (!((Map) (user)).containsKey("anonymous") || ((Map) (user)).get("anonymous") != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        j1 = saveAsync(s, j1);
        obj;
        JVM INSTR monitorexit ;
        return j1;
        j1 = j.a(new IllegalArgumentException("Cannot sign up a user that has already signed up."));
        obj;
        JVM INSTR monitorexit ;
        return j1;
        if (operationSetQueue.size() <= 1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        j1 = j.a(new IllegalArgumentException("Cannot sign up a user that is already signing up."));
        obj;
        JVM INSTR monitorexit ;
        return j1;
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        if (!ParseAnonymousUtils.isLinked(((ParseUser) (user))))
        {
            break MISSING_BLOCK_LABEL_319;
        }
        if (this != user)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        j1 = j.a(new IllegalArgumentException("Attempt to merge currentUser with itself."));
        obj;
        JVM INSTR monitorexit ;
        return j1;
        checkForChangesToMutableContainers();
        ((ParseUser) (user)).checkForChangesToMutableContainers();
        boolean flag = ((ParseUser) (user)).isLazy();
        final String oldUsername = ((ParseUser) (user)).getUsername();
        final String oldPassword = ((ParseUser) (user)).getPassword();
        final Map anonymousData = ((ParseUser) (user)).getAuthData("anonymous");
        ((ParseUser) (user)).copyChangesFrom(this);
        ((ParseUser) (user)).setUsername(getUsername());
        ((ParseUser) (user)).setPassword(getPassword());
        revert();
        j1 = ((ParseUser) (user)).saveAsync(s, flag, j1).b(new i() {

            final ParseUser this$0;
            final Map val$anonymousData;
            final String val$oldPassword;
            final String val$oldUsername;
            final ParseUser val$user;

            public j then(j j2)
                throws Exception
            {
                if (!j2.c() && !j2.d())
                {
                    break MISSING_BLOCK_LABEL_104;
                }
                Object obj1 = user.mutex;
                obj1;
                JVM INSTR monitorenter ;
                if (oldUsername == null) goto _L2; else goto _L1
_L1:
                user.setUsername(oldUsername);
_L5:
                if (oldPassword == null) goto _L4; else goto _L3
_L3:
                user.setPassword(oldPassword);
_L6:
                user.restoreAnonymity(anonymousData);
                return j2;
_L2:
                user.revert("username");
                  goto _L5
                j2;
                obj1;
                JVM INSTR monitorexit ;
                throw j2;
_L4:
                user.revert("password");
                  goto _L6
                user.revert("password");
                revert("password");
                mergeFromObject(user);
                return ParseUser.saveCurrentUserAsync(ParseUser.this);
                  goto _L5
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
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
        return j1;
        j1 = j1.d(new i() {

            final ParseUser this$0;
            final ParseOperationSet val$operations;
            final String val$sessionToken;

            public j then(j j2)
                throws Exception
            {
                return ParseUser.getUserController().signUpAsync(getState(), operations, sessionToken).b(new i() {

                    final _cls8 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        State state = (State)j1.e();
                        return handleSaveResultAsync(state, operations).b(j1. new i() {

                            final _cls1 this$2;
                            final j val$signUpTask;

                            public j then(j j1)
                                throws Exception
                            {
                                if (!signUpTask.c() && !signUpTask.d())
                                {
                                    return ParseUser.saveCurrentUserAsync(_fld0);
                                } else
                                {
                                    return signUpTask.j();
                                }
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = final__pcls1;
                signUpTask = j.this;
                super();
            }
                        });
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseUser.this;
                operations = parseoperationset;
                sessionToken = s;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return j1;
        s = null;
          goto _L3
    }

    public j signUpInBackground()
    {
        return taskQueue.enqueue(new i() {

            final ParseUser this$0;

            public j then(j j1)
                throws Exception
            {
                return signUpAsync(j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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

    j synchronizeAllAuthDataAsync()
    {
label0:
        {
            j j1;
            synchronized (mutex)
            {
                if (isCurrentUser())
                {
                    break label0;
                }
                j1 = j.a(null);
            }
            return j1;
        }
        Object obj1 = getAuthData();
        obj;
        JVM INSTR monitorexit ;
        obj = new ArrayList(((Map) (obj1)).size());
        for (obj1 = ((Map) (obj1)).keySet().iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(synchronizeAuthDataAsync((String)((Iterator) (obj1)).next()))) { }
        break MISSING_BLOCK_LABEL_93;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        return j.a(((java.util.Collection) (obj)));
    }

    j synchronizeAuthDataAsync(String s)
    {
label0:
        {
            synchronized (mutex)
            {
                if (isCurrentUser())
                {
                    break label0;
                }
                s = j.a(null);
            }
            return s;
        }
        Map map = getAuthData(s);
        obj;
        JVM INSTR monitorexit ;
        return synchronizeAuthDataAsync(getAuthenticationManager(), s, map);
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
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

    public j unlinkFromInBackground(String s)
    {
        if (s == null)
        {
            return j.a(null);
        }
        synchronized (mutex)
        {
            if (getAuthData().containsKey(s))
            {
                break MISSING_BLOCK_LABEL_43;
            }
            s = j.a(null);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        putAuthData(s, null);
        obj;
        JVM INSTR monitorexit ;
        return saveInBackground();
    }

    j upgradeToRevocableSessionAsync()
    {
        return taskQueue.enqueue(new i() {

            final ParseUser this$0;

            public j then(j j1)
                throws Exception
            {
                return upgradeToRevocableSessionAsync(j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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

    void validateSaveEventually()
        throws ParseException
    {
        if (isDirty("password"))
        {
            throw new ParseException(-1, "Unable to saveEventually on a ParseUser with dirty password");
        } else
        {
            return;
        }
    }









}
