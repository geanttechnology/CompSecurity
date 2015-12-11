// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.facebook.widget:
//            FacebookFragment, ImageRequest, ImageResponse, ImageDownloader, 
//            LoginButton

public class UserSettingsFragment extends FacebookFragment
{

    private static final String FIELDS = "fields";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String REQUEST_FIELDS = TextUtils.join(",", new String[] {
        "id", "name", "picture"
    });
    private TextView connectedStateLabel;
    private LoginButton loginButton;
    private LoginButton.LoginButtonProperties loginButtonProperties;
    private com.facebook.Session.StatusCallback sessionStatusCallback;
    private GraphUser user;
    private Session userInfoSession;
    private Drawable userProfilePic;
    private String userProfilePicID;

    public UserSettingsFragment()
    {
        loginButtonProperties = new LoginButton.LoginButtonProperties();
    }

    private void fetchUserInfo()
    {
        final Session currentSession = getSession();
        if (currentSession != null && currentSession.isOpened())
        {
            if (currentSession != userInfoSession)
            {
                Request request = Request.newMeRequest(currentSession, new com.facebook.Request.GraphUserCallback() {

                    final UserSettingsFragment this$0;
                    final Session val$currentSession;

                    public void onCompleted(GraphUser graphuser, Response response)
                    {
                        if (currentSession == getSession())
                        {
                            user = graphuser;
                            updateUI();
                        }
                        if (response.getError() != null)
                        {
                            loginButton.handleError(response.getError().getException());
                        }
                    }

            
            {
                this$0 = UserSettingsFragment.this;
                currentSession = session;
                super();
            }
                });
                Bundle bundle = new Bundle();
                bundle.putString("fields", REQUEST_FIELDS);
                request.setParameters(bundle);
                Request.executeBatchAsync(new Request[] {
                    request
                });
                userInfoSession = currentSession;
            }
            return;
        } else
        {
            user = null;
            return;
        }
    }

    private ImageRequest getImageRequest()
    {
        ImageRequest imagerequest;
        try
        {
            imagerequest = (new ImageRequest.Builder(getActivity(), ImageRequest.getProfilePictureUrl(user.getId(), getResources().getDimensionPixelSize(0x7f080017), getResources().getDimensionPixelSize(0x7f080018)))).setCallerTag(this).setCallback(new ImageRequest.Callback() {

                final UserSettingsFragment this$0;

                public void onCompleted(ImageResponse imageresponse)
                {
                    processImageResponse(user.getId(), imageresponse);
                }

            
            {
                this$0 = UserSettingsFragment.this;
                super();
            }
            }).build();
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return imagerequest;
    }

    private void processImageResponse(String s, ImageResponse imageresponse)
    {
        if (imageresponse != null)
        {
            Object obj = imageresponse.getBitmap();
            if (obj != null)
            {
                obj = new BitmapDrawable(getResources(), ((android.graphics.Bitmap) (obj)));
                ((BitmapDrawable) (obj)).setBounds(0, 0, getResources().getDimensionPixelSize(0x7f080017), getResources().getDimensionPixelSize(0x7f080018));
                userProfilePic = ((Drawable) (obj));
                userProfilePicID = s;
                connectedStateLabel.setCompoundDrawables(null, ((Drawable) (obj)), null, null);
                connectedStateLabel.setTag(imageresponse.getRequest().getImageUrl());
            }
        }
    }

    private void updateUI()
    {
        if (!isAdded())
        {
            return;
        }
        if (isSessionOpen())
        {
            connectedStateLabel.setTextColor(getResources().getColor(0x7f07002b));
            connectedStateLabel.setShadowLayer(1.0F, 0.0F, -1F, getResources().getColor(0x7f07002c));
            if (user != null)
            {
                ImageRequest imagerequest = getImageRequest();
                if (imagerequest != null)
                {
                    URL url = imagerequest.getImageUrl();
                    if (!url.equals(connectedStateLabel.getTag()))
                    {
                        if (user.getId().equals(userProfilePicID))
                        {
                            connectedStateLabel.setCompoundDrawables(null, userProfilePic, null, null);
                            connectedStateLabel.setTag(url);
                        } else
                        {
                            ImageDownloader.downloadAsync(imagerequest);
                        }
                    }
                }
                connectedStateLabel.setText(user.getName());
                return;
            } else
            {
                connectedStateLabel.setText(getResources().getString(0x7f0b0052));
                Drawable drawable = getResources().getDrawable(0x7f020095);
                drawable.setBounds(0, 0, getResources().getDimensionPixelSize(0x7f080017), getResources().getDimensionPixelSize(0x7f080018));
                connectedStateLabel.setCompoundDrawables(null, drawable, null, null);
                return;
            }
        } else
        {
            int i = getResources().getColor(0x7f07002d);
            connectedStateLabel.setTextColor(i);
            connectedStateLabel.setShadowLayer(0.0F, 0.0F, 0.0F, i);
            connectedStateLabel.setText(getResources().getString(0x7f0b0053));
            connectedStateLabel.setCompoundDrawables(null, null, null, null);
            connectedStateLabel.setTag(null);
            return;
        }
    }

    public void clearPermissions()
    {
        loginButtonProperties.clearPermissions();
    }

    public SessionDefaultAudience getDefaultAudience()
    {
        return loginButtonProperties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior()
    {
        return loginButtonProperties.getLoginBehavior();
    }

    public LoginButton.OnErrorListener getOnErrorListener()
    {
        return loginButtonProperties.getOnErrorListener();
    }

    List getPermissions()
    {
        return loginButtonProperties.getPermissions();
    }

    public com.facebook.Session.StatusCallback getSessionStatusCallback()
    {
        return sessionStatusCallback;
    }

    public volatile void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public volatile void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030039, viewgroup, false);
        loginButton = (LoginButton)layoutinflater.findViewById(0x7f0a00b9);
        loginButton.setProperties(loginButtonProperties);
        loginButton.setFragment(this);
        viewgroup = getSession();
        if (viewgroup != null && !viewgroup.equals(Session.getActiveSession()))
        {
            loginButton.setSession(viewgroup);
        }
        connectedStateLabel = (TextView)layoutinflater.findViewById(0x7f0a00b8);
        if (layoutinflater.getBackground() == null)
        {
            layoutinflater.setBackgroundColor(getResources().getColor(0x7f07002a));
            return layoutinflater;
        } else
        {
            layoutinflater.getBackground().setDither(true);
            return layoutinflater;
        }
    }

    public volatile void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        fetchUserInfo();
        updateUI();
    }

    protected void onSessionStateChange(SessionState sessionstate, Exception exception)
    {
        fetchUserInfo();
        updateUI();
        if (sessionStatusCallback != null)
        {
            sessionStatusCallback.call(getSession(), sessionstate, exception);
        }
    }

    public void setDefaultAudience(SessionDefaultAudience sessiondefaultaudience)
    {
        loginButtonProperties.setDefaultAudience(sessiondefaultaudience);
    }

    public void setLoginBehavior(SessionLoginBehavior sessionloginbehavior)
    {
        loginButtonProperties.setLoginBehavior(sessionloginbehavior);
    }

    public void setOnErrorListener(LoginButton.OnErrorListener onerrorlistener)
    {
        loginButtonProperties.setOnErrorListener(onerrorlistener);
    }

    public void setPublishPermissions(List list)
    {
        loginButtonProperties.setPublishPermissions(list, getSession());
    }

    public void setReadPermissions(List list)
    {
        loginButtonProperties.setReadPermissions(list, getSession());
    }

    public void setSession(Session session)
    {
        super.setSession(session);
        if (loginButton != null)
        {
            loginButton.setSession(session);
        }
        fetchUserInfo();
        updateUI();
    }

    public void setSessionStatusCallback(com.facebook.Session.StatusCallback statuscallback)
    {
        sessionStatusCallback = statuscallback;
    }




/*
    static GraphUser access$002(UserSettingsFragment usersettingsfragment, GraphUser graphuser)
    {
        usersettingsfragment.user = graphuser;
        return graphuser;
    }

*/



}
