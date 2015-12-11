// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip.ams;

import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;

public class AmsHttpErrorException extends CimHttpException
{
    public static final class PlayerAction extends Enum
    {

        private static final PlayerAction $VALUES[];
        public static final PlayerAction INCREMENT;
        public static final PlayerAction STOP;

        public static PlayerAction valueOf(String s)
        {
            return (PlayerAction)Enum.valueOf(com/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction, s);
        }

        public static PlayerAction[] values()
        {
            return (PlayerAction[])$VALUES.clone();
        }

        static 
        {
            STOP = new PlayerAction("STOP", 0);
            INCREMENT = new PlayerAction("INCREMENT", 1);
            $VALUES = (new PlayerAction[] {
                STOP, INCREMENT
            });
        }

        private PlayerAction(String s, int i)
        {
            super(s, i);
        }
    }


    private final DetailedRequestStatus amsRequestStatus;

    public AmsHttpErrorException(DetailedRequestStatus detailedrequeststatus, DetailedRequestStatus detailedrequeststatus1)
    {
        super(detailedrequeststatus);
        amsRequestStatus = detailedrequeststatus1;
    }

    public static AmsHttpErrorException fromHttpStatusAndAMSStatus(DetailedRequestStatus detailedrequeststatus, DetailedRequestStatus detailedrequeststatus1)
    {
        Integer integer = detailedrequeststatus1.getStatusCode();
        if (integer == null || integer.intValue() == 200 || integer.intValue() == 201)
        {
            return null;
        } else
        {
            return new AmsHttpErrorException(detailedrequeststatus, detailedrequeststatus1);
        }
    }

    public static PlayerAction getPlayerActionForException(AmsHttpErrorException amshttperrorexception)
    {
        switch (amshttperrorexception.getDetailedStatusCode())
        {
        default:
            return PlayerAction.INCREMENT;

        case 405: 
        case 407: 
        case 409: 
        case 412: 
        case 413: 
        case 415: 
        case 417: 
        case 420: 
        case 1000: 
        case 1002: 
        case 1006: 
        case 1007: 
        case 1008: 
        case 1101: 
        case 1102: 
        case 1103: 
        case 1105: 
        case 1901: 
        case 2000: 
        case 2002: 
        case 4005: 
        case 4009: 
        case 5061: 
        case 6003: 
        case 6004: 
        case 6005: 
        case 6006: 
            return PlayerAction.STOP;
        }
    }

    public DetailedRequestStatus getAmsRequestStatus()
    {
        return amsRequestStatus;
    }

    public int getDetailedStatusCode()
    {
        return amsRequestStatus.getStatusCode().intValue();
    }

    public int getStatusCodeForDisplay()
    {
        return amsRequestStatus.getStatusCode().intValue();
    }
}
