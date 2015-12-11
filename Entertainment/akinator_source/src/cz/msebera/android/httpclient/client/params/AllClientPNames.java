// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.auth.params.AuthPNames;
import cz.msebera.android.httpclient.conn.params.ConnConnectionPNames;
import cz.msebera.android.httpclient.conn.params.ConnManagerPNames;
import cz.msebera.android.httpclient.conn.params.ConnRoutePNames;
import cz.msebera.android.httpclient.cookie.params.CookieSpecPNames;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.CoreProtocolPNames;

// Referenced classes of package cz.msebera.android.httpclient.client.params:
//            ClientPNames

public interface AllClientPNames
    extends CoreConnectionPNames, CoreProtocolPNames, ClientPNames, AuthPNames, CookieSpecPNames, ConnConnectionPNames, ConnManagerPNames, ConnRoutePNames
{
}
