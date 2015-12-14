// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphObject;

// Referenced classes of package com.parse:
//            FacebookAuthenticationProvider, ParseException

class this._cls0
    implements com.facebook.s._cls0
{

    final FacebookAuthenticationProvider this$0;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        if (sessionstate != SessionState.OPENING)
        {
            if (sessionstate.isOpened())
            {
                if (FacebookAuthenticationProvider.access$300(FacebookAuthenticationProvider.this) != null)
                {
                    session = Request.newGraphPathRequest(session, "me", new com.facebook.Request.Callback() {

                        final FacebookAuthenticationProvider._cls2 this$1;

                        public void onCompleted(Response response)
                        {
                            if (response.getError() != null)
                            {
                                if (response.getError().getException() != null)
                                {
                                    FacebookAuthenticationProvider.access$200(this$0, response.getError().getException());
                                    return;
                                } else
                                {
                                    FacebookAuthenticationProvider.access$200(this$0, new ParseException(-1, "An error occurred while fetching the Facebook user's identity."));
                                    return;
                                }
                            } else
                            {
                                FacebookAuthenticationProvider.access$100(this$0, (String)response.getGraphObject().getProperty("id"));
                                return;
                            }
                        }

            
            {
                this$1 = FacebookAuthenticationProvider._cls2.this;
                super();
            }
                    });
                    session.getParameters().putString("fields", "id");
                    session.executeAsync();
                    return;
                }
            } else
            if (exception != null)
            {
                FacebookAuthenticationProvider.access$200(FacebookAuthenticationProvider.this, exception);
                return;
            } else
            {
                FacebookAuthenticationProvider.access$400(FacebookAuthenticationProvider.this);
                return;
            }
        }
    }

    _cls1.this._cls1()
    {
        this$0 = FacebookAuthenticationProvider.this;
        super();
    }
}
