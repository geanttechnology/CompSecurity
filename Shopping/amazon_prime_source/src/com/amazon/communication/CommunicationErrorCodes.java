// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


public final class CommunicationErrorCodes
{

    public static final int ERR_CONNSTATE_INVALID_STATE = 1000;
    public static final int ERR_CONN_MISSING_CREDENTIALS = 3003;
    public static final int ERR_CONN_READ_INPUTSTREAM_ACROSS_IPC = 3002;
    public static final int ERR_CONN_SEND_MESSAGE_SOCKET_ERROR = 3000;
    public static final int ERR_CONN_SEND_REQUEST_SOCKET_ERROR = 3001;
    public static final int ERR_HANDLER_DUPLICATE_REGISTRATION = 2000;
    public static final int ERR_HANDLER_INTERNAL_ERROR_UPON_REGISTRATION = 2002;
    public static final int ERR_HANDLER_NOTHING_TO_DEREGISTER = 2001;
    public static final int SUCCESS = 0;

    private CommunicationErrorCodes()
    {
    }
}
