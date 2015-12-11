// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.commonscodecandroid.binary.Base64;
import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;
import com.comcast.cim.httpcomponentsandroid.auth.InvalidCredentialsException;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeader;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.auth:
//            AuthSchemeBase, SpnegoTokenGenerator

public class NegotiateScheme extends AuthSchemeBase
{
    static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State CHALLENGE_RECEIVED;
        public static final State FAILED;
        public static final State TOKEN_GENERATED;
        public static final State UNINITIATED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/comcast/cim/httpcomponentsandroid/impl/auth/NegotiateScheme$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNINITIATED = new State("UNINITIATED", 0);
            CHALLENGE_RECEIVED = new State("CHALLENGE_RECEIVED", 1);
            TOKEN_GENERATED = new State("TOKEN_GENERATED", 2);
            FAILED = new State("FAILED", 3);
            $VALUES = (new State[] {
                UNINITIATED, CHALLENGE_RECEIVED, TOKEN_GENERATED, FAILED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private GSSContext gssContext;
    private final Log log;
    private Oid negotiationOid;
    private final SpnegoTokenGenerator spengoGenerator;
    private State state;
    private final boolean stripPort;
    private byte token[];

    public NegotiateScheme()
    {
        this(null, false);
    }

    public NegotiateScheme(SpnegoTokenGenerator spnegotokengenerator, boolean flag)
    {
        log = LogFactory.getLog(getClass());
        gssContext = null;
        negotiationOid = null;
        state = State.UNINITIATED;
        spengoGenerator = spnegotokengenerator;
        stripPort = flag;
    }

    public Header authenticate(Credentials credentials, HttpRequest httprequest)
        throws AuthenticationException
    {
        return authenticate(credentials, httprequest, null);
    }

    public Header authenticate(Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException
    {
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (state != State.CHALLENGE_RECEIVED)
        {
            throw new IllegalStateException("Negotiation authentication process has not been initiated");
        }
        if (isProxy())
        {
            credentials = "http.proxy_host";
        } else
        {
            credentials = "http.target_host";
        }
        credentials = (HttpHost)httpcontext.getAttribute(credentials);
        boolean flag;
        if (credentials == null)
        {
            try
            {
                throw new AuthenticationException("Authentication host is not set in the execution context");
            }
            // Misplaced declaration of an exception variable
            catch (Credentials credentials)
            {
                state = State.FAILED;
                if (credentials.getMajor() == 9 || credentials.getMajor() == 8)
                {
                    throw new InvalidCredentialsException(credentials.getMessage(), credentials);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Credentials credentials)
            {
                state = State.FAILED;
                throw new AuthenticationException(credentials.getMessage());
            }
            break MISSING_BLOCK_LABEL_621;
        }
        if (stripPort || credentials.getPort() <= 0) goto _L2; else goto _L1
_L1:
        credentials = credentials.toHostString();
_L4:
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("init ").append(credentials).toString());
        }
        negotiationOid = new Oid("1.3.6.1.5.5.2");
        flag = false;
        httprequest = getManager();
        gssContext = httprequest.createContext(httprequest.createName((new StringBuilder()).append("HTTP@").append(credentials).toString(), GSSName.NT_HOSTBASED_SERVICE).canonicalize(negotiationOid), negotiationOid, null, 0);
        gssContext.requestMutualAuth(true);
        gssContext.requestCredDeleg(true);
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        log.debug("Using Kerberos MECH 1.2.840.113554.1.2.2");
        negotiationOid = new Oid("1.2.840.113554.1.2.2");
        httprequest = getManager();
        gssContext = httprequest.createContext(httprequest.createName((new StringBuilder()).append("HTTP@").append(credentials).toString(), GSSName.NT_HOSTBASED_SERVICE).canonicalize(negotiationOid), negotiationOid, null, 0);
        gssContext.requestMutualAuth(true);
        gssContext.requestCredDeleg(true);
        if (token == null)
        {
            token = new byte[0];
        }
        token = gssContext.initSecContext(token, 0, token.length);
        if (token == null)
        {
            state = State.FAILED;
            throw new AuthenticationException("GSS security context initialization failed");
        }
          goto _L3
_L2:
        credentials = credentials.getHostName();
          goto _L4
        httprequest;
        if (httprequest.getMajor() != 2)
        {
            break MISSING_BLOCK_LABEL_481;
        }
        log.debug("GSSException BAD_MECH, retry with Kerberos MECH");
        flag = true;
          goto _L5
        throw httprequest;
_L3:
        if (spengoGenerator != null && negotiationOid.toString().equals("1.2.840.113554.1.2.2"))
        {
            token = spengoGenerator.generateSpnegoDERObject(token);
        }
        state = State.TOKEN_GENERATED;
        credentials = new String(Base64.encodeBase64(token, false));
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Sending response '").append(credentials).append("' back to the auth server").toString());
        }
        credentials = new BasicHeader("Authorization", (new StringBuilder()).append("Negotiate ").append(credentials).toString());
        return credentials;
        if (credentials.getMajor() == 13)
        {
            throw new InvalidCredentialsException(credentials.getMessage(), credentials);
        }
        if (credentials.getMajor() == 10 || credentials.getMajor() == 19 || credentials.getMajor() == 20)
        {
            throw new AuthenticationException(credentials.getMessage(), credentials);
        }
        throw new AuthenticationException(credentials.getMessage());
          goto _L4
    }

    protected GSSManager getManager()
    {
        return GSSManager.getInstance();
    }

    public String getRealm()
    {
        return null;
    }

    public String getSchemeName()
    {
        return "Negotiate";
    }

    public boolean isComplete()
    {
        return state == State.TOKEN_GENERATED || state == State.FAILED;
    }

    public boolean isConnectionBased()
    {
        return true;
    }

    protected void parseChallenge(CharArrayBuffer chararraybuffer, int i, int j)
        throws MalformedChallengeException
    {
        chararraybuffer = chararraybuffer.substringTrimmed(i, j);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Received challenge '").append(chararraybuffer).append("' from the auth server").toString());
        }
        if (state == State.UNINITIATED)
        {
            token = (new Base64()).decode(chararraybuffer.getBytes());
            state = State.CHALLENGE_RECEIVED;
            return;
        } else
        {
            log.debug("Authentication already attempted");
            state = State.FAILED;
            return;
        }
    }
}
