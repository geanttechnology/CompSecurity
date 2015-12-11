// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.specific.SpecificRecord;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            AdSpaceLayout

class AdFrame extends SpecificRecordBase
    implements SpecificRecord
{

    public static final Schema SCHEMA$ = (new com.flurry.org.apache.avro.Schema.Parser()).parse("{\"type\":\"record\",\"name\":\"AdFrame\",\"namespace\":\"com.flurry.android\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"}]}");
    public int I;
    public CharSequence J;
    public CharSequence K;
    public AdSpaceLayout L;
    public CharSequence M;
    public List callbacks;

    AdFrame()
    {
    }

    public Object get(int i)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            return Integer.valueOf(I);

        case 1: // '\001'
            return J;

        case 2: // '\002'
            return K;

        case 3: // '\003'
            return L;

        case 4: // '\004'
            return callbacks;

        case 5: // '\005'
            return M;
        }
    }

    public final CharSequence getAdGuid()
    {
        return M;
    }

    public final AdSpaceLayout getAdSpaceLayout()
    {
        return L;
    }

    public final Integer getBinding()
    {
        return Integer.valueOf(I);
    }

    public final List getCallbacks()
    {
        return callbacks;
    }

    public final CharSequence getContent()
    {
        return K;
    }

    public final CharSequence getDisplay()
    {
        return J;
    }

    public Schema getSchema()
    {
        return SCHEMA$;
    }

    public void put(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new AvroRuntimeException("Bad index");

        case 0: // '\0'
            I = ((Integer)obj).intValue();
            return;

        case 1: // '\001'
            J = (CharSequence)obj;
            return;

        case 2: // '\002'
            K = (CharSequence)obj;
            return;

        case 3: // '\003'
            L = (AdSpaceLayout)obj;
            return;

        case 4: // '\004'
            callbacks = (List)obj;
            return;

        case 5: // '\005'
            M = (CharSequence)obj;
            break;
        }
    }

}
