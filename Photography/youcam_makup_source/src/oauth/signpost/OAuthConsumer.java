// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost;

import java.io.Serializable;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.a;

public interface OAuthConsumer
    extends Serializable
{

    public abstract String a();

    public abstract a a(Object obj);

    public abstract a a(a a1);

    public abstract void a(String s, String s1);

    public abstract void a(HttpParameters httpparameters);

    public abstract String b();

    public abstract String c();

    public abstract String d();
}
