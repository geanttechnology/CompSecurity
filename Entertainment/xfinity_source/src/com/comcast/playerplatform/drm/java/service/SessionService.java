// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service;

import android.content.Context;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.drm.java.request.ClientSessionRequest;
import com.comcast.playerplatform.util.android.MoneyTrace;
import java.util.Iterator;
import java.util.Vector;

public class SessionService
{

    private ClientSessionRequest clientSessionRequest;
    private ClientStateInterface clientState;
    protected AbstractDrmEventListener drmEventListener;
    private Vector listeners;

    public SessionService(ClientStateInterface clientstateinterface, Context context, HttpClient httpclient)
    {
        listeners = new Vector();
        drmEventListener = new AbstractDrmEventListener() {

            final SessionService this$0;

            public void internalDRMError(SecurityTokenType securitytokentype, String s, String s1)
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractDrmEventListener)iterator.next()).internalDRMError(securitytokentype, s, s1)) { }
                break MISSING_BLOCK_LABEL_59;
                securitytokentype;
                vector;
                JVM INSTR monitorexit ;
                throw securitytokentype;
                vector;
                JVM INSTR monitorexit ;
            }

            public void serverSecurityError(SecurityTokenType securitytokentype, String s, String s1, String s2)
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractDrmEventListener)iterator.next()).serverSecurityError(securitytokentype, s, s1, s2)) { }
                break MISSING_BLOCK_LABEL_61;
                securitytokentype;
                vector;
                JVM INSTR monitorexit ;
                throw securitytokentype;
                vector;
                JVM INSTR monitorexit ;
            }

            public void sessionCreated()
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractDrmEventListener)iterator.next()).sessionCreated()) { }
                break MISSING_BLOCK_LABEL_50;
                Exception exception;
                exception;
                vector;
                JVM INSTR monitorexit ;
                throw exception;
                vector;
                JVM INSTR monitorexit ;
            }

            public void unprovisionedError()
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractDrmEventListener)iterator.next()).unprovisionedError()) { }
                break MISSING_BLOCK_LABEL_50;
                Exception exception;
                exception;
                vector;
                JVM INSTR monitorexit ;
                throw exception;
                vector;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = SessionService.this;
                super();
            }
        };
        clientState = clientstateinterface;
        clientSessionRequest = new ClientSessionRequest(clientstateinterface, httpclient, drmEventListener, context);
    }

    public void addEventListeners(AbstractDrmEventListener abstractdrmeventlistener)
    {
        listeners.add(abstractdrmeventlistener);
    }

    public void create()
    {
        create(null);
    }

    public void create(MoneyTrace moneytrace)
    {
        clientSessionRequest.create(moneytrace);
    }

}
