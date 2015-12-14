// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseException, ParseAuthenticationProvider, Parse, 
//            ParseCommand, PointerEncodingStrategy, ParseAnonymousUtils, OfflineStore, 
//            ParseQuery, TaskQueue, ParseFileUtils, ParseOperationSet, 
//            LogInCallback, RequestPasswordResetCallback, ParseObjectEncodingStrategy, ParseDecoder, 
//            SignUpCallback

public class ParseUser extends ParseObject
{

    private static final String CURRENT_USER_FILENAME = "currentUser";
    private static final Object MUTEX_CURRENT_USER = new Object();
    private static final String PIN_CURRENT_USER = "_currentUser";
    private static Map authenticationProviders = new HashMap();
    private static boolean autoUserEnabled;
    private static ParseUser currentUser;
    private static boolean currentUserMatchesDisk = false;
    private final JSONObject authData = new JSONObject();
    private boolean dirty;
    private boolean isCurrentUser;
    private boolean isLazy;
    private boolean isNew;
    private final Set linkedServiceNames = new HashSet();
    private String password;
    private final Set readOnlyLinkedServiceNames;
    private String sessionToken;

    public ParseUser()
    {
        isLazy = false;
        isCurrentUser = false;
        readOnlyLinkedServiceNames = Collections.unmodifiableSet(linkedServiceNames);
    }

    private static Task authenticateAsync(ParseAuthenticationProvider parseauthenticationprovider)
    {
        bolts.Task.TaskCompletionSource taskcompletionsource = Task.create();
        parseauthenticationprovider.authenticate(new ParseAuthenticationProvider.ParseAuthenticationCallback(taskcompletionsource) {

            final bolts.Task.TaskCompletionSource val$tcs;

            public void onCancel()
            {
                tcs.setCancelled();
            }

            public void onError(Throwable throwable)
            {
                tcs.setError(new ParseException(throwable));
            }

            public void onSuccess(JSONObject jsonobject)
            {
                tcs.setResult(jsonobject);
            }

            
            {
                tcs = taskcompletionsource;
                super();
            }
        });
        return taskcompletionsource.getTask();
    }

    public static ParseUser become(String s)
        throws ParseException
    {
        return (ParseUser)Parse.waitForTask(becomeInBackground(s));
    }

    public static Task becomeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Must specify a sessionToken for the user to log in with");
        } else
        {
            return constructBecomeCommand(s).executeAsync().onSuccessTask(new Continuation() {

                public Task then(Task task)
                    throws Exception
                {
                    if (task.getResult() == JSONObject.NULL)
                    {
                        throw new ParseException(101, "invalid login credentials");
                    } else
                    {
                        return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON((JSONObject)task.getResult(), "_User", true));
                    }
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            });
        }
    }

    public static void becomeInBackground(String s, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(becomeInBackground(s), logincallback);
    }

    private static void checkApplicationContext()
    {
        if (Parse.applicationContext == null)
        {
            throw new RuntimeException("You must call Parse.initialize(context, oauthKey, oauthSecret) before using the Parse library.");
        } else
        {
            return;
        }
    }

    private void cleanUpAuthData()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = authData.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (authData.isNull(s))
            {
                iterator.remove();
                linkedServiceNames.remove(s);
                if (authenticationProviders.containsKey(s))
                {
                    ((ParseAuthenticationProvider)authenticationProviders.get(s)).restoreAuthentication(null);
                }
            }
        } while (true);
        break MISSING_BLOCK_LABEL_101;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
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

    private static ParseCommand constructBecomeCommand(String s)
    {
        return new ParseCommand("client_me", s);
    }

    private static ParseCommand constructLogInCommand(String s, String s1)
    {
        ParseCommand parsecommand = new ParseCommand("user_login", null);
        parsecommand.put("username", s);
        parsecommand.put("user_password", s1);
        return parsecommand;
    }

    private static ParseCommand constructPasswordResetCommand(String s, String s1)
    {
        s1 = new ParseCommand("user_request_password_reset", s1);
        s1.put("email", s);
        return s1;
    }

    private ParseCommand constructSignUpCommand(ParseOperationSet parseoperationset, String s)
        throws ParseException
    {
        parseoperationset = constructSaveCommand(parseoperationset, PointerEncodingStrategy.get(), s);
        parseoperationset.setOp("user_signup");
        return parseoperationset;
    }

    private ParseCommand constructSignUpOrLoginCommand(ParseOperationSet parseoperationset)
        throws ParseException
    {
        String s;
        Iterator iterator;
        synchronized (mutex)
        {
            parseoperationset = toJSONObjectForSaving(parseoperationset, PointerEncodingStrategy.get());
            s = password;
        }
        obj = new ParseCommand("user_signup_or_login", null);
        iterator = parseoperationset.keys();
_L2:
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (String)iterator.next();
        Object obj2;
        obj2 = parseoperationset.get(((String) (obj1)));
        if (obj2 instanceof JSONObject)
        {
            ((ParseCommand) (obj)).put(((String) (obj1)), (JSONObject)obj2);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_103;
        parseoperationset;
        obj;
        JVM INSTR monitorexit ;
        throw parseoperationset;
        if (obj2 instanceof JSONArray)
        {
            ((ParseCommand) (obj)).put(((String) (obj1)), (JSONArray)obj2);
            continue; /* Loop/switch isn't completed */
        }
        if (obj2 instanceof String)
        {
            ((ParseCommand) (obj)).put(((String) (obj1)), (String)obj2);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            ((ParseCommand) (obj)).put(((String) (obj1)), parseoperationset.getInt(((String) (obj1))));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        if (true) goto _L2; else goto _L1
_L1:
        if (s != null)
        {
            ((ParseCommand) (obj)).put("user_password", s);
        }
        return ((ParseCommand) (obj));
    }

    static void disableAutomaticUser()
    {
        autoUserEnabled = false;
    }

    public static void enableAutomaticUser()
    {
        autoUserEnabled = true;
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

    public static ParseUser getCurrentUser()
    {
        boolean flag;
        checkApplicationContext();
        synchronized (MUTEX_CURRENT_USER)
        {
            obj = currentUser;
            flag = currentUserMatchesDisk;
        }
        if (obj != null)
        {
            return ((ParseUser) (obj));
        }
        break MISSING_BLOCK_LABEL_30;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        if (flag)
        {
            if (isAutomaticUserEnabled())
            {
                return ParseAnonymousUtils.lazyLogIn();
            } else
            {
                return null;
            }
        }
        if (!OfflineStore.isEnabled()) goto _L2; else goto _L1
_L1:
        ParseUser parseuser = (ParseUser)Parse.waitForTask(ParseQuery.getQuery(com/parse/ParseUser).fromPin("_currentUser", true).findInBackground((ParseUser)null).onSuccessTask(new Continuation() {

            public Task then(Task task)
                throws Exception
            {
                task = (List)task.getResult();
                if (task != null)
                {
                    if (task.size() == 1)
                    {
                        return Task.forResult(task.get(0));
                    } else
                    {
                        return ParseObject.unpinAllInBackground("_currentUser").cast();
                    }
                } else
                {
                    return Task.forResult(null);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        }));
        flag = true;
        obj = parseuser;
        break MISSING_BLOCK_LABEL_91;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        obj = (ParseUser)getFromDisk(Parse.applicationContext, "currentUser");
        flag = true;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        synchronized (MUTEX_CURRENT_USER)
        {
            currentUser = ((ParseUser) (obj));
            currentUserMatchesDisk = flag;
        }
        if (obj != null)
        {
            synchronized (((ParseUser) (obj)).mutex)
            {
                obj.isCurrentUser = true;
            }
            return ((ParseUser) (obj));
        }
        if (isAutomaticUserEnabled())
        {
            return ParseAnonymousUtils.lazyLogIn();
        } else
        {
            return null;
        }
        ParseException parseexception;
        parseexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseUser);
    }

    static boolean isAutomaticUserEnabled()
    {
        return autoUserEnabled;
    }

    private Task linkWithAsync(final ParseAuthenticationProvider authenticator)
    {
        return authenticateAsync(authenticator).onSuccessTask(new Continuation() {

            final ParseUser this$0;
            final ParseAuthenticationProvider val$authenticator;

            public Task then(Task task)
                throws Exception
            {
                return linkWithAsync(authenticator.getAuthType(), (JSONObject)task.getResult());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseUser.this;
                authenticator = parseauthenticationprovider;
                super();
            }
        });
    }

    private Task linkWithAsync(final String authType, final JSONObject authData, final Task toAwait)
    {
        final JSONObject oldAnonymousData = authData.optJSONObject("anonymous");
        synchronized (mutex)
        {
            authType = Task.call(new Callable() {

                final ParseUser this$0;
                final JSONObject val$authData;
                final String val$authType;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    synchronized (mutex)
                    {
                        ParseUser.this.authData.put(authType, authData);
                        linkedServiceNames.add(authType);
                        stripAnonymity();
                        dirty = true;
                    }
                    return null;
                    exception;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = ParseUser.this;
                authType = s;
                authData = jsonobject;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final ParseUser this$0;
                final Task val$toAwait;

                public Task then(Task task)
                    throws Exception
                {
                    return saveAsync(toAwait);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseUser.this;
                toAwait = task;
                super();
            }
            }).continueWithTask(new Continuation() {

                final ParseUser this$0;
                final String val$authType;
                final JSONObject val$oldAnonymousData;

                public Task then(Task task)
                    throws Exception
                {
label0:
                    {
                        synchronized (mutex)
                        {
                            if (!task.isFaulted() && !task.isCancelled())
                            {
                                break label0;
                            }
                            restoreAnonymity(oldAnonymousData);
                        }
                        return task;
                    }
                    synchronizeAuthData(authType);
                    obj1;
                    JVM INSTR monitorexit ;
                    return task;
                    task;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseUser.this;
                oldAnonymousData = jsonobject;
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
        return (ParseUser)Parse.waitForTask(logInInBackground(s, s1));
    }

    public static Task logInInBackground(String s, String s1)
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
            return constructLogInCommand(s, s1).executeAsync().onSuccessTask(new Continuation() {

                public Task then(Task task)
                    throws Exception
                {
                    if (task.getResult() == JSONObject.NULL)
                    {
                        throw new ParseException(101, "invalid login credentials");
                    } else
                    {
                        return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON((JSONObject)task.getResult(), "_User", true));
                    }
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            });
        }
    }

    public static void logInInBackground(String s, String s1, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(s, s1), logincallback);
    }

    static ParseUser logInLazyUser(String s, JSONObject jsonobject)
    {
        ParseUser parseuser = (ParseUser)ParseObject.create(com/parse/ParseUser);
        Object obj = parseuser.mutex;
        obj;
        JVM INSTR monitorenter ;
        parseuser.isCurrentUser = true;
        parseuser.isLazy = true;
        parseuser.authData.put(s, jsonobject);
        parseuser.linkedServiceNames.add(s);
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!OfflineStore.isEnabled())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        Parse.waitForTask(saveCurrentUserAsync(parseuser));
        flag = true;
_L2:
        synchronized (MUTEX_CURRENT_USER)
        {
            currentUserMatchesDisk = flag;
            currentUser = parseuser;
        }
        return parseuser;
        s;
        throw new RuntimeException(s);
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        jsonobject;
        s;
        JVM INSTR monitorexit ;
        throw jsonobject;
        s;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Task logInWithAsync(ParseAuthenticationProvider parseauthenticationprovider)
    {
        return authenticateAsync(parseauthenticationprovider).onSuccessTask(new Continuation(parseauthenticationprovider) {

            final ParseAuthenticationProvider val$authenticator;

            public Task then(Task task)
                throws Exception
            {
                return ParseUser.logInWithAsync(authenticator.getAuthType(), (JSONObject)task.getResult());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                authenticator = parseauthenticationprovider;
                super();
            }
        });
    }

    static Task logInWithAsync(String s)
    {
        if (!authenticationProviders.containsKey(s))
        {
            throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
        } else
        {
            return logInWithAsync((ParseAuthenticationProvider)authenticationProviders.get(s));
        }
    }

    static Task logInWithAsync(String s, JSONObject jsonobject)
    {
        ParseUser parseuser;
        Object obj1;
        obj1 = new Continuation(s, jsonobject) {

            final JSONObject val$authData;
            final String val$authType;

            public Task then(Task task)
                throws Exception
            {
                task = (ParseUser)ParseObject.create(com/parse/ParseUser);
                try
                {
                    ((ParseUser) (task)).authData.put(authType, authData);
                    ((ParseUser) (task)).linkedServiceNames.add(authType);
                }
                // Misplaced declaration of an exception variable
                catch (Task task)
                {
                    throw new ParseException(task);
                }
                return task.constructSignUpOrLoginCommand(task.startSave()).executeAsync().onSuccessTask(new Continuation() {

                    final _cls14 this$0;

                    public Task then(Task task)
                        throws Exception
                    {
                        return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON((JSONObject)task.getResult(), "_User", true));
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$0 = _cls14.this;
                super();
            }
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                authType = s;
                authData = jsonobject;
                super();
            }
        };
        parseuser = getCurrentUser();
        if (parseuser != null)
        {
label0:
            {
                synchronized (parseuser.mutex)
                {
                    if (!ParseAnonymousUtils.isLinked(parseuser))
                    {
                        break MISSING_BLOCK_LABEL_105;
                    }
                    if (!parseuser.isLazy())
                    {
                        break label0;
                    }
                    obj1 = parseuser.authData.optJSONObject("anonymous");
                    s = parseuser.taskQueue.enqueue(new Continuation(parseuser, s, jsonobject, ((JSONObject) (obj1))) {

                        final JSONObject val$authData;
                        final String val$authType;
                        final JSONObject val$oldAnonymousData;
                        final ParseUser val$user;

                        public Task then(Task task)
                            throws Exception
                        {
                            return Task.forResult(null).continueWithTask(new Continuation() {

                                final _cls15 this$0;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    synchronized (user.mutex)
                                    {
                                        user.stripAnonymity();
                                        user.authData.put(authType, authData);
                                        user.linkedServiceNames.add(authType);
                                        task = user.resolveLazinessAsync(task).makeVoid();
                                    }
                                    return task;
                                    task;
                                    obj;
                                    JVM INSTR monitorexit ;
                                    throw task;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$0 = _cls15.this;
                super();
            }
                            }).continueWithTask(new Continuation() {

                                final _cls15 this$0;

                                public Task then(Task task)
                                    throws Exception
                                {
label0:
                                    {
                                        synchronized (user.mutex)
                                        {
                                            if (!task.isFaulted())
                                            {
                                                break label0;
                                            }
                                            user.authData.remove(authType);
                                            user.linkedServiceNames.remove(authType);
                                            user.restoreAnonymity(oldAnonymousData);
                                            task = Task.forError(task.getError());
                                        }
                                        return task;
                                    }
                                    if (!task.isCancelled())
                                    {
                                        break MISSING_BLOCK_LABEL_113;
                                    }
                                    task = Task.cancelled();
                                    obj;
                                    JVM INSTR monitorexit ;
                                    return task;
                                    task;
                                    obj;
                                    JVM INSTR monitorexit ;
                                    throw task;
                                    task = Task.forResult(user);
                                    obj;
                                    JVM INSTR monitorexit ;
                                    return task;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$0 = _cls15.this;
                super();
            }
                            });
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                user = parseuser;
                authType = s;
                authData = jsonobject;
                oldAnonymousData = jsonobject1;
                super();
            }
                    });
                }
                return s;
            }
        }
          goto _L1
        s = parseuser.linkWithAsync(s, jsonobject).continueWithTask(new Continuation(((Continuation) (obj1)), parseuser) {

            final Continuation val$logInWithTask;
            final ParseUser val$user;

            public Task then(Task task)
                throws Exception
            {
                if (task.isFaulted())
                {
                    Exception exception = task.getError();
                    if ((exception instanceof ParseException) && ((ParseException)exception).getCode() == 208)
                    {
                        return Task.forResult(null).continueWithTask(logInWithTask);
                    }
                }
                if (task.isCancelled())
                {
                    return Task.cancelled();
                } else
                {
                    return Task.forResult(user);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                logInWithTask = continuation;
                user = parseuser;
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
        obj;
        JVM INSTR monitorexit ;
_L1:
        return Task.forResult(null).continueWithTask(((Continuation) (obj1)));
    }

    public static void logOut()
    {
        checkApplicationContext();
        synchronized (MUTEX_CURRENT_USER)
        {
            obj = currentUser;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj2 = ((ParseUser) (obj)).mutex;
        obj2;
        JVM INSTR monitorenter ;
        for (Iterator iterator = ((ParseUser) (obj)).getLinkedServiceNames().iterator(); iterator.hasNext(); ((ParseUser) (obj)).logOutWith((String)iterator.next())) { }
        break MISSING_BLOCK_LABEL_71;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        obj.isCurrentUser = false;
        obj.isNew = false;
        obj.sessionToken = null;
        obj2;
        JVM INSTR monitorexit ;
_L2:
        boolean flag;
        flag = ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "currentUser"));
        if (!OfflineStore.isEnabled())
        {
            break MISSING_BLOCK_LABEL_121;
        }
        Parse.waitForTask(ParseObject.unpinAllInBackground("_currentUser"));
        flag = true;
_L4:
        synchronized (MUTEX_CURRENT_USER)
        {
            currentUserMatchesDisk = flag;
            currentUser = null;
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        ParseException parseexception;
        parseexception;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void logOutWith(ParseAuthenticationProvider parseauthenticationprovider)
    {
        parseauthenticationprovider.deauthenticate();
    }

    static void registerAuthenticationProvider(ParseAuthenticationProvider parseauthenticationprovider)
    {
        authenticationProviders.put(parseauthenticationprovider.getAuthType(), parseauthenticationprovider);
        ParseUser parseuser = getCurrentUser();
        if (parseuser != null)
        {
            parseuser.synchronizeAuthData(parseauthenticationprovider.getAuthType());
        }
    }

    public static void requestPasswordReset(String s)
        throws ParseException
    {
        Parse.waitForTask(requestPasswordResetInBackground(s));
    }

    public static Task requestPasswordResetInBackground(String s)
    {
        return constructPasswordResetCommand(s, getCurrentSessionToken()).executeAsync().makeVoid();
    }

    public static void requestPasswordResetInBackground(String s, RequestPasswordResetCallback requestpasswordresetcallback)
    {
        Parse.callbackOnMainThreadAsync(requestPasswordResetInBackground(s), requestpasswordresetcallback);
    }

    private Task resolveLazinessAsync(Task task)
    {
label0:
        {
            synchronized (mutex)
            {
                if (isLazy())
                {
                    break label0;
                }
                task = Task.forResult(null);
            }
            return task;
        }
        if (linkedServiceNames.size() != 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        task = signUpAsync(task).onSuccess(new Continuation() {

            final ParseUser this$0;

            public ParseUser then(Task task1)
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
                task1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return task;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
        final Capture operations = new Capture();
        task = Task.call(new Callable() {

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
        }).onSuccessTask(TaskQueue.waitFor(task)).onSuccessTask(new Continuation() {

            final ParseUser this$0;
            final Capture val$operations;

            public Task then(Task task1)
                throws Exception
            {
                operations.set(task1.getResult());
                return constructSignUpOrLoginCommand((ParseOperationSet)operations.get()).executeAsync();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                operations = capture;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseUser this$0;
            final Capture val$operations;

            public Task then(Task task1)
                throws Exception
            {
                task1 = (JSONObject)task1.getResult();
                if (OfflineStore.isEnabled() && !task1.optBoolean("is_new"))
                {
                    return Task.forResult(task1);
                } else
                {
                    return handleSaveResultAsync(task1, (ParseOperationSet)operations.get()).onSuccess(task1. new Continuation() {

                        final _cls19 this$1;
                        final JSONObject val$commandResult;

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

                        public JSONObject then(Task task)
                            throws Exception
                        {
                            return commandResult;
                        }

            
            {
                this$1 = final__pcls19;
                commandResult = JSONObject.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                operations = capture;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseUser this$0;

            public Task then(Task task1)
                throws Exception
            {
                Object obj1 = (JSONObject)task1.getResult();
                task1 = ((Task) (mutex));
                task1;
                JVM INSTR monitorenter ;
                dirty = false;
                if (!((JSONObject) (obj1)).optBoolean("is_new"))
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                isLazy = false;
                obj1 = Task.forResult(ParseUser.this);
                return ((Task) (obj1));
                task1;
                JVM INSTR monitorexit ;
                return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.fromJSON(((JSONObject) (obj1)), "_User", true));
                Exception exception;
                exception;
                task1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return task;
    }

    private void restoreAnonymity(JSONObject jsonobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        linkedServiceNames.add("anonymous");
        authData.put("anonymous", jsonobject);
        obj;
        JVM INSTR monitorexit ;
        return;
        jsonobject;
        throw new RuntimeException(jsonobject);
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    private static Task saveCurrentUserAsync(ParseUser parseuser)
    {
        checkApplicationContext();
        ParseUser parseuser1;
        synchronized (MUTEX_CURRENT_USER)
        {
            parseuser1 = currentUser;
        }
        if (parseuser1 != parseuser)
        {
            logOut();
        }
        synchronized (parseuser.mutex)
        {
            parseuser.isCurrentUser = true;
            parseuser.synchronizeAllAuthData();
        }
        if (OfflineStore.isEnabled())
        {
            obj = ParseObject.unpinAllInBackground("_currentUser").continueWithTask(new Continuation(parseuser) {

                final ParseUser val$user;

                public Task then(Task task)
                    throws Exception
                {
                    return user.pinInBackground("_currentUser");
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                user = parseuser;
                super();
            }
            });
        } else
        {
            obj = Task.forResult(null).continueWith(new Continuation(parseuser) {

                final ParseUser val$user;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
                    throws Exception
                {
                    user.saveToDisk(Parse.applicationContext, "currentUser");
                    return null;
                }

            
            {
                user = parseuser;
                super();
            }
            });
        }
        return ((Task) (obj)).continueWith(new Continuation(parseuser) {

            final ParseUser val$user;

            public ParseUser then(Task task)
                throws Exception
            {
                Object obj1 = ParseUser.MUTEX_CURRENT_USER;
                obj1;
                JVM INSTR monitorenter ;
                boolean flag;
                if (!task.isFaulted())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ParseUser.currentUserMatchesDisk = flag;
                ParseUser.currentUser = user;
                obj1;
                JVM INSTR monitorexit ;
                return user;
                task;
                obj1;
                JVM INSTR monitorexit ;
                throw task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                user = parseuser;
                super();
            }
        });
        parseuser;
        obj;
        JVM INSTR monitorexit ;
        throw parseuser;
        parseuser;
        obj;
        JVM INSTR monitorexit ;
        throw parseuser;
    }

    private Task signUpAsync(Task task)
    {
        final ParseUser user = getCurrentUser();
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        final String sessionToken;
        sessionToken = getCurrentSessionToken();
        if (getUsername() == null || getUsername().length() == 0)
        {
            throw new IllegalArgumentException("Username cannot be missing or blank");
        }
        break MISSING_BLOCK_LABEL_49;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
        String s;
        if (password == null)
        {
            throw new IllegalArgumentException("Password cannot be missing or blank");
        }
        s = getObjectId();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (!authData.has("anonymous") || authData.get("anonymous") != JSONObject.NULL)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        task = saveAsync(task);
        obj;
        JVM INSTR monitorexit ;
        return task;
        task;
        throw new RuntimeException(task);
        throw new IllegalArgumentException("Cannot sign up a user that has already signed up.");
        if (operationSetQueue.size() > 1)
        {
            throw new IllegalArgumentException("Cannot sign up a user that is already signing up.");
        }
        if (user == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (!ParseAnonymousUtils.isLinked(user))
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (this != user)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        throw new IllegalArgumentException("Attempt to merge currentUser with itself.");
        checkForChangesToMutableContainers();
        user.checkForChangesToMutableContainers();
        user.copyChangesFrom(this);
        user.dirty = true;
        user.setPassword(password);
        user.setUsername(getUsername());
        revert();
        task = user.saveAsync(task).onSuccessTask(new Continuation() {

            final ParseUser this$0;
            final ParseUser val$user;

            public Task then(Task task1)
                throws Exception
            {
                mergeFromObject(user);
                return ParseUser.saveCurrentUserAsync(ParseUser.this).makeVoid();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                user = parseuser1;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return task;
        task = Task.call(new Callable() {

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
        }).continueWithTask(TaskQueue.waitFor(task)).onSuccessTask(new Continuation() {

            final ParseUser this$0;
            final String val$sessionToken;

            public Task then(Task task1)
                throws Exception
            {
                task1 = (ParseOperationSet)task1.getResult();
                ParseCommand parsecommand = constructSignUpCommand(task1, sessionToken);
                if (parsecommand == null)
                {
                    return Task.forResult(null);
                } else
                {
                    return parsecommand.executeAsync().continueWithTask(task1. new Continuation() {

                        final _cls5 this$1;
                        final ParseOperationSet val$operations;

                        public Task then(Task task)
                            throws Exception
                        {
                            return handleSaveResultAsync((JSONObject)task.getResult(), operations).continueWithTask(task. new Continuation() {

                                final _cls1 this$2;
                                final Task val$signUpTask;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    if (!signUpTask.isCancelled() && !signUpTask.isFaulted())
                                    {
                                        synchronized (mutex)
                                        {
                                            isNew = true;
                                            dirty = false;
                                        }
                                        return ParseUser.saveCurrentUserAsync(_fld0).makeVoid();
                                    } else
                                    {
                                        return signUpTask.makeVoid();
                                    }
                                    exception;
                                    task;
                                    JVM INSTR monitorexit ;
                                    throw exception;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$2 = final__pcls1;
                signUpTask = Task.this;
                super();
            }
                            });
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls5;
                operations = ParseOperationSet.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                sessionToken = s;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return task;
    }

    private void stripAnonymity()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (!ParseAnonymousUtils.isLinked(this))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        linkedServiceNames.remove("anonymous");
        authData.put("anonymous", JSONObject.NULL);
        dirty = true;
        return;
        Object obj1;
        obj1;
        throw new RuntimeException(((Throwable) (obj1)));
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private void synchronizeAllAuthData()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = authData.keys(); iterator.hasNext(); synchronizeAuthData((String)iterator.next())) { }
        break MISSING_BLOCK_LABEL_45;
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
        if (authenticationProviders.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_37;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        ParseAuthenticationProvider parseauthenticationprovider = (ParseAuthenticationProvider)authenticationProviders.get(s);
        if (!parseauthenticationprovider.restoreAuthentication(authData.optJSONObject(parseauthenticationprovider.getAuthType())))
        {
            unlinkFromAsync(s);
        }
        obj;
        JVM INSTR monitorexit ;
    }

    ParseCommand constructSaveCommand(ParseOperationSet parseoperationset, ParseObjectEncodingStrategy parseobjectencodingstrategy, String s)
        throws ParseException
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        parseoperationset = super.constructSaveCommand(parseoperationset, parseobjectencodingstrategy, s);
        if (parseoperationset != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
        if (password != null)
        {
            parseoperationset.put("user_password", password);
        }
        if (authData.length() > 0)
        {
            parseoperationset.put("auth_data", authData);
        }
        obj;
        JVM INSTR monitorexit ;
        return parseoperationset;
        parseoperationset;
        obj;
        JVM INSTR monitorexit ;
        throw parseoperationset;
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

    Task fetchAsync(Task task)
    {
label0:
        {
            synchronized (mutex)
            {
                if (!isLazy())
                {
                    break label0;
                }
                task = Task.forResult(this);
            }
            return task;
        }
        task = super.fetchAsync(task).onSuccessTask(new Continuation() {

            final ParseUser this$0;

            public Task then(Task task1)
                throws Exception
            {
                Task task2 = task1;
                if (isCurrentUser())
                {
                    cleanUpAuthData();
                    task2 = ParseUser.saveCurrentUserAsync(ParseUser.this).continueWithTask(task1. new Continuation() {

                        final _cls2 this$1;
                        final Task val$fetchAsyncTask;

                        public Task then(Task task)
                            throws Exception
                        {
                            return fetchAsyncTask;
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls2;
                fetchAsyncTask = Task.this;
                super();
            }
                    });
                }
                return task2;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return task;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
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

    Set getLinkedServiceNames()
    {
        Set set;
        synchronized (mutex)
        {
            set = readOnlyLinkedServiceNames;
        }
        return set;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getSessionToken()
    {
        String s;
        synchronized (mutex)
        {
            s = sessionToken;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getUsername()
    {
        return getString("username");
    }

    public boolean isAuthenticated()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ParseUser parseuser = getCurrentUser();
        if (isLazy()) goto _L2; else goto _L1
_L1:
        if (sessionToken == null || parseuser == null) goto _L4; else goto _L3
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

    boolean isDirty(boolean flag)
    {
        return dirty || super.isDirty(flag);
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

    Task linkWithAsync(String s)
    {
        if (!authenticationProviders.containsKey(s))
        {
            throw new IllegalArgumentException("No authentication provider could be found for the provided authType");
        } else
        {
            return linkWithAsync((ParseAuthenticationProvider)authenticationProviders.get(s));
        }
    }

    Task linkWithAsync(final String authType, final JSONObject authData)
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseUser this$0;
            final JSONObject val$authData;
            final String val$authType;

            public Task then(Task task)
                throws Exception
            {
                return linkWithAsync(authType, authData, task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseUser.this;
                authType = s;
                authData = jsonobject;
                super();
            }
        });
    }

    void logOutWith(String s)
    {
        synchronized (mutex)
        {
            if (authenticationProviders.containsKey(s) && linkedServiceNames.contains(s))
            {
                logOutWith((ParseAuthenticationProvider)authenticationProviders.get(s));
            }
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void mergeFromObject(ParseObject parseobject)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        super.mergeFromObject(parseobject);
        if (this != parseobject)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        if (!(parseobject instanceof ParseUser))
        {
            break MISSING_BLOCK_LABEL_185;
        }
        sessionToken = ((ParseUser)parseobject).sessionToken;
        isNew = ((ParseUser)parseobject).isNew();
        for (Iterator iterator = authData.keys(); iterator.hasNext(); iterator.remove())
        {
            iterator.next();
        }

        break MISSING_BLOCK_LABEL_87;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
        Iterator iterator1 = ((ParseUser)parseobject).authData.keys();
_L1:
        String s;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_159;
        }
        s = (String)iterator1.next();
        Object obj1 = ((ParseUser)parseobject).authData.get(s);
        authData.put(s, obj1);
          goto _L1
        parseobject;
        throw new RuntimeException("A JSONException occurred where one was not possible.");
        linkedServiceNames.clear();
        linkedServiceNames.addAll(((ParseUser)parseobject).linkedServiceNames);
        obj;
        JVM INSTR monitorexit ;
    }

    void mergeFromServer(JSONObject jsonobject, ParseDecoder parsedecoder, boolean flag)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        super.mergeFromServer(jsonobject, parsedecoder, flag);
        flag = jsonobject.has("session_token");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        sessionToken = jsonobject.getString("session_token");
        flag = jsonobject.has("auth_data");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        try
        {
            parsedecoder = jsonobject.getJSONObject("auth_data");
            String s;
            for (Iterator iterator = parsedecoder.keys(); iterator.hasNext(); synchronizeAuthData(s))
            {
                s = (String)iterator.next();
                authData.put(s, parsedecoder.get(s));
                if (!parsedecoder.isNull(s))
                {
                    linkedServiceNames.add(s);
                }
            }

            break MISSING_BLOCK_LABEL_162;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        finally { }
        throw new RuntimeException(jsonobject);
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
        jsonobject;
        throw new RuntimeException(jsonobject.getMessage());
        flag = jsonobject.has("is_new");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        isNew = jsonobject.getBoolean("is_new");
        obj;
        JVM INSTR monitorexit ;
        return;
        jsonobject;
        throw new RuntimeException(jsonobject);
    }

    void mergeREST(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        super.mergeREST(jsonobject, parsedecoder);
        flag = jsonobject.has("sessionToken");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        sessionToken = jsonobject.getString("sessionToken");
        flag = jsonobject.has("authData");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        try
        {
            parsedecoder = jsonobject.getJSONObject("authData");
            String s;
            for (Iterator iterator = parsedecoder.keys(); iterator.hasNext(); synchronizeAuthData(s))
            {
                s = (String)iterator.next();
                authData.put(s, parsedecoder.get(s));
                if (!parsedecoder.isNull(s))
                {
                    linkedServiceNames.add(s);
                }
            }

            break MISSING_BLOCK_LABEL_162;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        finally { }
        throw new RuntimeException(jsonobject);
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
        jsonobject;
        throw new RuntimeException(jsonobject.getMessage());
        flag = jsonobject.has("isNew");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        isNew = jsonobject.getBoolean("isNew");
        obj;
        JVM INSTR monitorexit ;
        return;
        jsonobject;
        throw new RuntimeException(jsonobject);
    }

    boolean needsDefaultACL()
    {
        return false;
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

    Task saveAsync(Task task)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (!isLazy())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        task = resolveLazinessAsync(task).makeVoid();
_L1:
        task = task.onSuccessTask(new Continuation() {

            final ParseUser this$0;

            public Task then(Task task1)
                throws Exception
            {
                if (isCurrentUser())
                {
                    cleanUpAuthData();
                    return ParseUser.saveCurrentUserAsync(ParseUser.this).makeVoid();
                } else
                {
                    return Task.forResult(null);
                }
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
        return task;
        task = super.saveAsync(task);
          goto _L1
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
    }

    public void setEmail(String s)
    {
        put("email", s);
    }

    public void setPassword(String s)
    {
        synchronized (mutex)
        {
            password = s;
            dirty = true;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setUsername(String s)
    {
        put("username", s);
    }

    public void signUp()
        throws ParseException
    {
        Parse.waitForTask(signUpInBackground());
    }

    public Task signUpInBackground()
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseUser this$0;

            public Task then(Task task)
                throws Exception
            {
                return signUpAsync(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseUser.this;
                super();
            }
        });
    }

    public void signUpInBackground(SignUpCallback signupcallback)
    {
        Parse.callbackOnMainThreadAsync(signUpInBackground(), signupcallback);
    }

    JSONObject toJSONObjectForDataFile(boolean flag, ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        parseobjectencodingstrategy = super.toJSONObjectForDataFile(flag, parseobjectencodingstrategy);
        s = sessionToken;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        parseobjectencodingstrategy.put("session_token", sessionToken);
        int i = authData.length();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        parseobjectencodingstrategy.put("auth_data", authData);
        obj;
        JVM INSTR monitorexit ;
        return parseobjectencodingstrategy;
        parseobjectencodingstrategy;
        throw new RuntimeException("could not encode value for key: session_token");
        parseobjectencodingstrategy;
        obj;
        JVM INSTR monitorexit ;
        throw parseobjectencodingstrategy;
        parseobjectencodingstrategy;
        throw new RuntimeException("could not attach key: auth_data");
    }

    JSONObject toJSONObjectForSaving(ParseOperationSet parseoperationset, ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        parseoperationset = super.toJSONObjectForSaving(parseoperationset, parseobjectencodingstrategy);
        parseobjectencodingstrategy = sessionToken;
        if (parseobjectencodingstrategy == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        parseoperationset.put("session_token", sessionToken);
        int i = authData.length();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        parseoperationset.put("auth_data", authData);
        obj;
        JVM INSTR monitorexit ;
        return parseoperationset;
        parseoperationset;
        throw new RuntimeException("could not encode value for key: session_token");
        parseoperationset;
        obj;
        JVM INSTR monitorexit ;
        throw parseoperationset;
        parseoperationset;
        throw new RuntimeException("could not attach key: auth_data");
    }

    JSONObject toRest(ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        parseobjectencodingstrategy = super.toRest(parseobjectencodingstrategy);
        s = sessionToken;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        parseobjectencodingstrategy.put("sessionToken", sessionToken);
        int i = authData.length();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        parseobjectencodingstrategy.put("authData", authData);
        obj;
        JVM INSTR monitorexit ;
        return parseobjectencodingstrategy;
        parseobjectencodingstrategy;
        throw new RuntimeException("could not encode value for key: sessionToken");
        parseobjectencodingstrategy;
        obj;
        JVM INSTR monitorexit ;
        throw parseobjectencodingstrategy;
        parseobjectencodingstrategy;
        throw new RuntimeException("could not attach key: authData");
    }

    Task unlinkFromAsync(final String authType)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (authType != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        authType = Task.forResult(null);
        obj;
        JVM INSTR monitorexit ;
        return authType;
        authType = Task.forResult(null).continueWithTask(new Continuation() {

            final ParseUser this$0;
            final String val$authType;

            public Task then(Task task)
                throws Exception
            {
label0:
                {
                    Task task1;
                    synchronized (mutex)
                    {
                        if (!authData.has(authType))
                        {
                            break label0;
                        }
                        authData.put(authType, JSONObject.NULL);
                        dirty = true;
                        task1 = saveInBackground();
                    }
                    return task1;
                }
                Task task2 = Task.forResult(null);
                task;
                JVM INSTR monitorexit ;
                return task2;
                exception;
                task;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
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
        Object obj1 = getCurrentUser();
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (getObjectId() == null)
        {
            throw new IllegalArgumentException("Cannot save a ParseUser until it has been signed up. Call signUp first.");
        }
        break MISSING_BLOCK_LABEL_34;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        if (!isAuthenticated() && isDirty() && !getObjectId().equals(((ParseUser) (obj1)).getObjectId()))
        {
            throw new IllegalArgumentException("Cannot save a ParseUser that is not authenticated.");
        }
        obj;
        JVM INSTR monitorexit ;
    }










/*
    static boolean access$1502(ParseUser parseuser, boolean flag)
    {
        parseuser.isLazy = flag;
        return flag;
    }

*/






/*
    static boolean access$402(ParseUser parseuser, boolean flag)
    {
        parseuser.isNew = flag;
        return flag;
    }

*/


/*
    static boolean access$502(ParseUser parseuser, boolean flag)
    {
        parseuser.dirty = flag;
        return flag;
    }

*/



/*
    static boolean access$702(boolean flag)
    {
        currentUserMatchesDisk = flag;
        return flag;
    }

*/


/*
    static ParseUser access$802(ParseUser parseuser)
    {
        currentUser = parseuser;
        return parseuser;
    }

*/

}
