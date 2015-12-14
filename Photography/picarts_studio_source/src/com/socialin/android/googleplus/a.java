// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googleplus;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.Comment;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.d;
import com.socialin.android.util.aj;
import com.socialin.android.util.b;
import com.socialin.android.util.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googleplus:
//            GooglePlusSignInActivity

public class a
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private static final String c = com/socialin/android/googleplus/a.getSimpleName();
    public Context a;
    public aj b;
    private GoogleApiClient d;
    private boolean e;
    private int f;
    private ImageItem g;
    private Comment h;
    private String i;
    private boolean j;
    private SharedPreferences k;
    private ResultCallback l;

    public a(Context context)
    {
        a = null;
        e = false;
        f = 0;
        j = false;
        l = new ResultCallback() {

            public final void onResult(Result result)
            {
                result = (Status)result;
                com.socialin.android.d.a("GPlus", (new StringBuilder("write moment")).append(result).toString());
            }

        };
        a = context;
        k = context.getSharedPreferences((new StringBuilder("sinPref_")).append(context.getString(m.e(context, "app_name_short"))).toString(), 0);
        b();
    }

    private void b()
    {
        com.google.android.gms.common.api.GoogleApiClient.Builder builder = (new com.google.android.gms.common.api.GoogleApiClient.Builder(a)).addConnectionCallbacks(this).addOnConnectionFailedListener(this);
        Object obj = k.getString("googleplus_account_name", null);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            builder.setAccountName(((String) (obj)));
        }
        builder.addScope(Plus.SCOPE_PLUS_LOGIN).addScope(Plus.SCOPE_PLUS_PROFILE).addScope(new Scope("https://www.googleapis.com/auth/plus.profile.emails.read"));
        obj = com.google.android.gms.plus.Plus.PlusOptions.builder().addActivityTypes(GooglePlusSignInActivity.c).build();
        builder.addApi(Plus.API, ((com.google.android.gms.common.api.Api.ApiOptions.HasOptions) (obj)));
        d = builder.build();
    }

    private void c()
    {
        Object obj;
        com.google.android.gms.plus.model.moments.ItemScope itemscope;
        ArrayList arraylist;
        obj = (new com.google.android.gms.plus.model.moments.ItemScope.Builder()).setType("http://schema.org/Person").setName(SocialinV3.getInstance().getUser().username).build();
        arraylist = new ArrayList();
        arraylist.add(obj);
        itemscope = (new com.google.android.gms.plus.model.moments.ItemScope.Builder()).setUrl((new StringBuilder("http://picsart.com/i/")).append(g.id).toString()).build();
        Object obj1;
        if (TextUtils.isEmpty(g.title))
        {
            obj = i;
        } else
        {
            obj = g.title;
        }
        if (((String) (obj)).contains("#PicsArt"))
        {
            obj1 = obj;
        } else
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append(" #PicsArt").toString();
        }
        obj1 = URLEncoder.encode(((String) (obj1)), e.a.name()).replace("+", "%20");
        obj = obj1;
_L2:
        switch (f)
        {
        default:
            return;

        case 0: // '\0'
            String s = d();
            String s4 = (new StringBuilder()).append("http://picsart.com/i/google?itemType=").append("http://schema.org/ImageObject&name=").append(((String) (obj))).append("&image=").append(g.getMidleUrl()).append("&creator=").append(SocialinV3.getInstance().getUser().username).append("&description=").append(s).toString();
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("addPhoto url= ")).append(s4).toString()
            });
            obj = (new com.google.android.gms.plus.model.moments.ItemScope.Builder()).setUrl(s4).setType("http://schema.org/ImageObject").setName(((String) (obj))).setImage(g.getImageUrl()).setDescription(s).setThumbnailUrl(g.getThumbUrl()).setAuthor(arraylist);
            if (g.address != null)
            {
                if (TextUtils.isEmpty(g.address.country))
                {
                    ((com.google.android.gms.plus.model.moments.ItemScope.Builder) (obj)).setAddressCountry(g.address.country);
                }
                if (TextUtils.isEmpty(g.address.state))
                {
                    ((com.google.android.gms.plus.model.moments.ItemScope.Builder) (obj)).setAddressRegion(g.address.state);
                }
                if (TextUtils.isEmpty(g.address.place))
                {
                    ((com.google.android.gms.plus.model.moments.ItemScope.Builder) (obj)).setAddressLocality(g.address.place);
                }
                if (TextUtils.isEmpty(g.address.place))
                {
                    ((com.google.android.gms.plus.model.moments.ItemScope.Builder) (obj)).setStreetAddress(g.address.street);
                }
            }
            obj = (new com.google.android.gms.plus.model.moments.Moment.Builder()).setType("http://schemas.google.com/CreateActivity").setTarget(itemscope).setResult(((com.google.android.gms.plus.model.moments.ItemScope.Builder) (obj)).build()).build();
            Plus.MomentsApi.write(d, ((com.google.android.gms.plus.model.moments.Moment) (obj))).setResultCallback(l);
            return;

        case 1: // '\001'
            String s1 = (new StringBuilder()).append("http://picsart.com/i/google?itemType=").append("http://schema.org/Comment&name=").append(((String) (obj))).append("&image=").append(g.getMidleUrl()).append("&creator=").append(SocialinV3.getInstance().getUser().username).append("&comment=").append(h.text).toString();
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("commentPhoto url= ")).append(s1).toString()
            });
            obj = (new com.google.android.gms.plus.model.moments.ItemScope.Builder()).setName(((String) (obj))).setType("http://schema.org/Comment").setUrl(s1).setImage(g.getImageUrl()).setThumbnailUrl(g.getThumbUrl()).setAuthor(arraylist).setText(h.text).build();
            obj = (new com.google.android.gms.plus.model.moments.Moment.Builder()).setType("http://schemas.google.com/CommentActivity").setTarget(itemscope).setResult(((com.google.android.gms.plus.model.moments.ItemScope) (obj))).build();
            Plus.MomentsApi.write(d, ((com.google.android.gms.plus.model.moments.Moment) (obj))).setResultCallback(l);
            return;

        case 3: // '\003'
            String s2 = (new StringBuilder()).append("http://picsart.com/i/google?itemType=").append("http://schema.org/UserPlusOnes&name=").append(((String) (obj))).append("&image=").append(g.getMidleUrl()).append("&creator=").append(SocialinV3.getInstance().getUser().username).toString();
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("plusOnePhoto url= ")).append(s2).toString()
            });
            obj = (new com.google.android.gms.plus.model.moments.ItemScope.Builder()).setName(((String) (obj))).setType("http://schema.org/UserPlusOnes").setUrl(s2).setImage(g.getImageUrl()).setThumbnailUrl(g.getThumbUrl()).setAuthor(arraylist).build();
            obj = (new com.google.android.gms.plus.model.moments.Moment.Builder()).setType("http://schemas.google.com/AddActivity").setTarget(itemscope).setResult(((com.google.android.gms.plus.model.moments.ItemScope) (obj))).build();
            Plus.MomentsApi.write(d, ((com.google.android.gms.plus.model.moments.Moment) (obj))).setResultCallback(l);
            return;

        case 2: // '\002'
            String s3 = (new StringBuilder()).append("http://picsart.com/i/google?itemType=").append("http://schema.org/UserLikes&name=").append(((String) (obj))).append("&image=").append(g.getMidleUrl()).append("&creator=").append(SocialinV3.getInstance().getUser().username).toString();
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("likePhoto url= ")).append(s3).toString()
            });
            obj = (new com.google.android.gms.plus.model.moments.ItemScope.Builder()).setName(((String) (obj))).setType("http://schema.org/UserLikes").setUrl(s3).setImage(g.getUrl()).setThumbnailUrl(g.getThumbUrl()).setAuthor(arraylist).build();
            obj = (new com.google.android.gms.plus.model.moments.Moment.Builder()).setType("http://schemas.google.com/AddActivity").setTarget(itemscope).setResult(((com.google.android.gms.plus.model.moments.ItemScope) (obj))).build();
            Plus.MomentsApi.write(d, ((com.google.android.gms.plus.model.moments.Moment) (obj))).setResultCallback(l);
            return;
        }
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String d()
    {
        String s;
        String s1;
        if (g != null && g.desc != null && !"null".equals(g.desc))
        {
            s = g.desc;
        } else
        {
            s = "";
        }
        s1 = s;
        if (g.getTagsString() != null)
        {
            s1 = (new StringBuilder()).append(s).append(g.getTagsString().replace("#", "")).toString();
        }
        try
        {
            s = URLEncoder.encode(s1, e.a.name()).replace("+", "%20");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            com.socialin.android.d.b(c, "encode data", unsupportedencodingexception);
            return s1;
        }
        return s;
    }

    public final void a()
    {
        com.socialin.android.d.b(c, new Object[] {
            "google plus is connected, so... disconnecting."
        });
        if (d.isConnected())
        {
            d.clearDefaultAccountAndReconnect();
            d.disconnect();
            k.edit().putString("googleplus_account_name", null).commit();
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                com.socialin.android.util.b.a(SocialinV3.getInstance().getContext()).a("Connected Google +", false);
            }
        }
    }

    public final void a(int i1, ImageItem imageitem, Comment comment)
    {
        f = i1;
        g = imageitem;
        h = comment;
        i = a.getString(0x7f0808ad);
        if (d == null)
        {
            b();
        }
        if (!d.isConnected())
        {
            j = true;
            d.connect();
            return;
        } else
        {
            c();
            return;
        }
    }

    public final void a(boolean flag)
    {
        e = flag;
        d.connect();
    }

    public void onConnected(Bundle bundle)
    {
        com.socialin.android.d.a(c, "onConnected");
        if (j)
        {
            if (!TextUtils.isEmpty(k.getString("googleplus_account_name", null)))
            {
                c();
            } else
            if (Plus.PeopleApi.getCurrentPerson(d) != null)
            {
                bundle = Plus.AccountApi.getAccountName(d);
                k.edit().putString("googleplus_account_name", bundle).commit();
                b();
                c();
            }
            j = false;
        } else
        if (b != null)
        {
            b.a();
        }
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            com.socialin.android.util.b.a(SocialinV3.getInstance().getContext()).a("Connected Google +", true);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        String s1 = c;
        StringBuilder stringbuilder = new StringBuilder("onConnectionFailed ");
        String s;
        if (connectionresult != null)
        {
            s = (new StringBuilder("errorCode= ")).append(connectionresult.getErrorCode()).toString();
        } else
        {
            s = "";
        }
        com.socialin.android.d.a(s1, stringbuilder.append(s).toString());
        if (connectionresult == null || connectionresult.getErrorCode() != 4 || !e)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (a instanceof Activity)
        {
            connectionresult.startResolutionForResult((Activity)a, 11);
        }
_L1:
        return;
        connectionresult;
        com.socialin.android.d.b(c, "onConnectionFailed", connectionresult);
        return;
        if (b != null)
        {
            b.b();
            return;
        }
          goto _L1
    }

    public void onConnectionSuspended(int i1)
    {
    }

}
