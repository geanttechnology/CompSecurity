// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost;

import java.io.Serializable;
import oauth.signpost.http.HttpParameters;

// Referenced classes of package oauth.signpost:
//            OAuthConsumer

public interface OAuthProvider
    extends Serializable
{

    public transient abstract String a(OAuthConsumer oauthconsumer, String s, String as[]);

    public abstract HttpParameters a();

    public transient abstract void b(OAuthConsumer oauthconsumer, String s, String as[]);
}
