// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;

class AdUnit extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"AdUnit\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"long\",\"default\":0},{\"name\":\"adomain\",\"type\":\"string\",\"default\":\"null\"}]}");
    public CharSequence bE;
    public long bF;
    public List bG;
    public int bH;
    public CharSequence bI;
    public CharSequence bJ;
    public long bK;
    public int bL;
    public int bM;
    public int bN;
    public long bO;
    public long bP;
    public CharSequence bQ;

    AdUnit()
    {
    }

    public Object get(int i)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            return bE;

        case 1: // '\001'
            return Long.valueOf(bF);

        case 2: // '\002'
            return bG;

        case 3: // '\003'
            return Integer.valueOf(bH);

        case 4: // '\004'
            return bI;

        case 5: // '\005'
            return bJ;

        case 6: // '\006'
            return Long.valueOf(bK);

        case 7: // '\007'
            return Integer.valueOf(bL);

        case 8: // '\b'
            return Integer.valueOf(bM);

        case 9: // '\t'
            return Integer.valueOf(bN);

        case 10: // '\n'
            return Long.valueOf(bO);

        case 11: // '\013'
            return Long.valueOf(bP);

        case 12: // '\f'
            return bQ;
        }
    }

    public final List getAdFrames()
    {
        return bG;
    }

    public final CharSequence getAdSpace()
    {
        return bE;
    }

    public final Integer getCombinable()
    {
        return Integer.valueOf(bH);
    }

    public final Long getExpiration()
    {
        return Long.valueOf(bF);
    }

    public final Long getExpirationTime()
    {
        return Long.valueOf(bO);
    }

    public final CharSequence getGroupId()
    {
        return bI;
    }

    public final CharSequence getIdHash()
    {
        return bJ;
    }

    public final Integer getNewCap()
    {
        return Integer.valueOf(bL);
    }

    public final Integer getPreviousCap()
    {
        return Integer.valueOf(bM);
    }

    public final Integer getPreviousCapType()
    {
        return Integer.valueOf(bN);
    }

    public Schema getSchema()
    {
        return SCHEMA$;
    }

    public final Long getServeTime()
    {
        return Long.valueOf(bK);
    }

    public void put(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            bE = (CharSequence)obj;
            return;

        case 1: // '\001'
            bF = ((Long)obj).longValue();
            return;

        case 2: // '\002'
            bG = (List)obj;
            return;

        case 3: // '\003'
            bH = ((Integer)obj).intValue();
            return;

        case 4: // '\004'
            bI = (CharSequence)obj;
            return;

        case 5: // '\005'
            bJ = (CharSequence)obj;
            return;

        case 6: // '\006'
            bK = ((Long)obj).longValue();
            return;

        case 7: // '\007'
            bL = ((Integer)obj).intValue();
            return;

        case 8: // '\b'
            bM = ((Integer)obj).intValue();
            return;

        case 9: // '\t'
            bN = ((Integer)obj).intValue();
            return;

        case 10: // '\n'
            bO = ((Long)obj).longValue();
            return;

        case 11: // '\013'
            bP = ((Long)obj).longValue();
            return;

        case 12: // '\f'
            bQ = (CharSequence)obj;
            break;
        }
    }

}
