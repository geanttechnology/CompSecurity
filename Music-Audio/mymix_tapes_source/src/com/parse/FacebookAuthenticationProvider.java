// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionState;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.facebook.TokenCachingStrategy;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.model.GraphObject;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider, ParseException

class FacebookAuthenticationProvider
    implements ParseAuthenticationProvider
{

    private static final String AUTH_TYPE_NAME = "facebook";
    public static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
    private int activityCode;
    private Context applicationContext;
    protected String applicationId;
    private WeakReference baseActivity;
    private ParseAuthenticationProvider.ParseAuthenticationCallback currentOperationCallback;
    private SessionDefaultAudience defaultAudience;
    private Facebook facebook;
    private Collection permissions;
    private final DateFormat preciseDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
    private Session session;
    private String userId;

    public FacebookAuthenticationProvider(Context context, String s)
    {
        preciseDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        activityCode = 32665;
        applicationId = s;
        if (context != null)
        {
            applicationContext = context.getApplicationContext();
        }
        if (s != null)
        {
            facebook = new Facebook(s);
        }
    }

    private void handleCancel()
    {
        if (currentOperationCallback == null)
        {
            return;
        }
        currentOperationCallback.onCancel();
        currentOperationCallback = null;
        return;
        Exception exception;
        exception;
        currentOperationCallback = null;
        throw exception;
    }

    private void handleError(Throwable throwable)
    {
        if (currentOperationCallback == null)
        {
            return;
        }
        currentOperationCallback.onError(throwable);
        currentOperationCallback = null;
        return;
        throwable;
        currentOperationCallback = null;
        throw throwable;
    }

    private void handleSuccess(String s)
    {
        if (currentOperationCallback == null)
        {
            return;
        }
        userId = s;
        try
        {
            s = getAuthData(s, session.getAccessToken(), session.getExpirationDate());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            handleError(s);
            return;
        }
        currentOperationCallback.onSuccess(s);
        currentOperationCallback = null;
        return;
        s;
        currentOperationCallback = null;
        throw s;
    }

    public void authenticate(ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentOperationCallback != null)
        {
            cancel();
        }
        currentOperationCallback = parseauthenticationcallback;
        if (baseActivity != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        parseauthenticationcallback = null;
_L1:
        if (parseauthenticationcallback != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        throw new IllegalStateException("Activity must be non-null for Facebook authentication to proceed.");
        parseauthenticationcallback;
        this;
        JVM INSTR monitorexit ;
        throw parseauthenticationcallback;
        parseauthenticationcallback = (Activity)baseActivity.get();
          goto _L1
        int i = activityCode;
        session = (new com.facebook.Session.Builder(parseauthenticationcallback)).setApplicationId(applicationId).setTokenCachingStrategy(new SharedPreferencesTokenCachingStrategy(parseauthenticationcallback)).build();
        parseauthenticationcallback = new com.facebook.Session.OpenRequest(parseauthenticationcallback);
        parseauthenticationcallback.setRequestCode(i);
        if (defaultAudience != null)
        {
            parseauthenticationcallback.setDefaultAudience(defaultAudience);
        }
        if (permissions != null)
        {
            parseauthenticationcallback.setPermissions(new ArrayList(permissions));
        }
        parseauthenticationcallback.setCallback(new com.facebook.Session.StatusCallback() {

            final FacebookAuthenticationProvider this$0;

            public void call(Session session1, SessionState sessionstate, Exception exception)
            {
                if (sessionstate != SessionState.OPENING)
                {
                    if (sessionstate.isOpened())
                    {
                        if (currentOperationCallback != null)
                        {
                            session1 = Request.newGraphPathRequest(session1, "me", new com.facebook.Request.Callback() {

                                final _cls2 this$1;

                                public void onCompleted(Response response)
                                {
                                    if (response.getError() != null)
                                    {
                                        if (response.getError().getException() != null)
                                        {
                                            handleError(response.getError().getException());
                                            return;
                                        } else
                                        {
                                            handleError(new ParseException(-1, "An error occurred while fetching the Facebook user's identity."));
                                            return;
                                        }
                                    } else
                                    {
                                        handleSuccess((String)response.getGraphObject().getProperty("id"));
                                        return;
                                    }
                                }

            
            {
                this$1 = _cls2.this;
                super();
            }
                            });
                            session1.getParameters().putString("fields", "id");
                            session1.executeAsync();
                            return;
                        }
                    } else
                    if (exception != null)
                    {
                        handleError(exception);
                        return;
                    } else
                    {
                        handleCancel();
                        return;
                    }
                }
            }

            
            {
                this$0 = FacebookAuthenticationProvider.this;
                super();
            }
        });
        session.openForRead(parseauthenticationcallback);
        this;
        JVM INSTR monitorexit ;
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        handleCancel();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void deauthenticate()
    {
        restoreAuthentication(null);
    }

    public void extendAccessToken(Context context, ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentOperationCallback != null)
        {
            cancel();
        }
        currentOperationCallback = parseauthenticationcallback;
        if (!facebook.extendAccessToken(context, new com.facebook.android.Facebook.ServiceListener() {

        final FacebookAuthenticationProvider this$0;

        public void onComplete(Bundle bundle)
        {
            handleSuccess(userId);
        }

        public void onError(Error error)
        {
            handleError(error);
        }

        public void onFacebookError(FacebookError facebookerror)
        {
            handleError(facebookerror);
        }

            
            {
                this$0 = FacebookAuthenticationProvider.this;
                super();
            }
    }))
        {
            handleCancel();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public int getActivityCode()
    {
        return activityCode;
    }

    public JSONObject getAuthData(String s, String s1, Date date)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", s);
        jsonobject.put("access_token", s1);
        jsonobject.put("expiration_date", preciseDateFormat.format(date));
        return jsonobject;
    }

    public String getAuthType()
    {
        return "facebook";
    }

    public Facebook getFacebook()
    {
        return facebook;
    }

    public Session getSession()
    {
        return session;
    }

    public String getUserId()
    {
        return userId;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Activity activity = (Activity)baseActivity.get();
        if (activity != null)
        {
            session.onActivityResult(activity, i, j, intent);
        }
    }

    public boolean restoreAuthentication(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            if (facebook != null)
            {
                facebook.setAccessExpires(0L);
                facebook.setAccessToken(null);
            }
            session = null;
            return true;
        }
        Object obj = jsonobject.getString("access_token");
        Date date = preciseDateFormat.parse(jsonobject.getString("expiration_date"));
        if (facebook != null)
        {
            facebook.setAccessToken(((String) (obj)));
            facebook.setAccessExpires(date.getTime());
        }
        obj = new SharedPreferencesTokenCachingStrategy(applicationContext);
        Bundle bundle = ((TokenCachingStrategy) (obj)).load();
        TokenCachingStrategy.putToken(bundle, jsonobject.getString("access_token"));
        TokenCachingStrategy.putExpirationDate(bundle, date);
        ((TokenCachingStrategy) (obj)).save(bundle);
        jsonobject = (new com.facebook.Session.Builder(applicationContext)).setApplicationId(applicationId).setTokenCachingStrategy(((TokenCachingStrategy) (obj))).build();
        if (jsonobject.getState() != SessionState.CREATED_TOKEN_LOADED)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        jsonobject.openForRead(null);
        session = jsonobject;
        Session.setActiveSession(session);
        return true;
        try
        {
            session = null;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return false;
        }
        return true;
    }

    public void setActivity(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        baseActivity = new WeakReference(activity);
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    public void setActivityCode(int i)
    {
        this;
        JVM INSTR monitorenter ;
        activityCode = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setPermissions(Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        permissions = collection;
        this;
        JVM INSTR monitorexit ;
        return;
        collection;
        throw collection;
    }





}
