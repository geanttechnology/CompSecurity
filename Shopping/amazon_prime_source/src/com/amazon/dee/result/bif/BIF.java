// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.dee.result.bif:
//            BIFException, Interpretation, Intent, Token

public class BIF
{

    private static final JsonFactory JSON_FACTORY = new JsonFactory();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private List mInterpretations;
    private String mRequestId;
    private String mSessionId;
    private String mUtteranceId;
    private String mVersion;
    private Boolean mWakeWordFalsePositive;

    public BIF()
    {
        this(null, null, null, null, null);
    }

    public BIF(String s, String s1, String s2, List list)
    {
        this(s, s1, s2, list, null);
    }

    public BIF(String s, String s1, String s2, List list, Boolean boolean1)
    {
        mVersion = "2.0";
        mSessionId = s;
        mRequestId = s1;
        mUtteranceId = s2;
        if (list == null)
        {
            list = new ArrayList();
        }
        mInterpretations = list;
        mWakeWordFalsePositive = boolean1;
    }

    public static BIF fromJson(File file)
        throws BIFException
    {
        try
        {
            file = (BIF)OBJECT_MAPPER.readValue(file, com/amazon/dee/result/bif/BIF);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new BIFException((new StringBuilder()).append("Exception in contructing BIF from JSON file: ").append(file.getMessage()).toString(), file);
        }
        return file;
    }

    public static BIF fromJson(String s)
        throws BIFException
    {
        try
        {
            s = (BIF)OBJECT_MAPPER.readValue(s, com/amazon/dee/result/bif/BIF);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BIFException("Exception in constructing BIF from JSON string", s);
        }
        return s;
    }

    public static String toJson(BIF bif, boolean flag)
        throws BIFException
    {
        StringWriter stringwriter = new StringWriter();
        JsonGenerator jsongenerator;
        try
        {
            jsongenerator = JSON_FACTORY.createJsonGenerator(stringwriter);
        }
        // Misplaced declaration of an exception variable
        catch (BIF bif)
        {
            throw new BIFException(bif.getMessage(), bif);
        }
        if (flag)
        {
            jsongenerator.useDefaultPrettyPrinter();
        }
        try
        {
            OBJECT_MAPPER.writeValue(jsongenerator, bif);
        }
        // Misplaced declaration of an exception variable
        catch (BIF bif)
        {
            throw new BIFException(bif.getMessage(), bif);
        }
        return stringwriter.toString();
    }

    public final void addInterpretation(Interpretation interpretation)
    {
        mInterpretations.add(interpretation);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof BIF)
        {
            obj = (BIF)obj;
            flag = flag1;
            if (Objects.equal(mSessionId, ((BIF) (obj)).mSessionId))
            {
                flag = flag1;
                if (Objects.equal(mRequestId, ((BIF) (obj)).mRequestId))
                {
                    flag = flag1;
                    if (Objects.equal(mUtteranceId, ((BIF) (obj)).mUtteranceId))
                    {
                        flag = flag1;
                        if (Objects.equal(mVersion, ((BIF) (obj)).mVersion))
                        {
                            flag = flag1;
                            if (Objects.equal(mInterpretations, ((BIF) (obj)).mInterpretations))
                            {
                                flag = flag1;
                                if (Objects.equal(mWakeWordFalsePositive, ((BIF) (obj)).mWakeWordFalsePositive))
                                {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final String getBestTokenString()
    {
        return getTokenString(0);
    }

    public final List getInterpretations()
    {
        if (mInterpretations == null)
        {
            return null;
        } else
        {
            return Collections.unmodifiableList(mInterpretations);
        }
    }

    public final String getRequestId()
    {
        return mRequestId;
    }

    public final String getSessionId()
    {
        return mSessionId;
    }

    public final String getTokenString(int i)
    {
        String s;
        try
        {
            s = (String)getTokensAsStringList().get(i);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return "";
        }
        return s;
    }

    public final List getTokensAsStringList()
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = mInterpretations.iterator();
_L2:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Interpretation)iterator.next();
        Object obj1 = ((Interpretation) (obj)).getIntent().getTokens();
        obj = new StringBuilder();
        Token token;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append((new StringBuilder()).append(token.getValue()).append(" ").toString()))
        {
            token = (Token)((Iterator) (obj1)).next();
        }

        try
        {
            arraylist.add(((StringBuilder) (obj)).toString().trim());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            arraylist.add(null);
        }
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    public final String getUtteranceId()
    {
        return mUtteranceId;
    }

    public final String getVersion()
    {
        return mVersion;
    }

    public final Boolean getWakeWordFalsePositive()
    {
        return mWakeWordFalsePositive;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mSessionId, mRequestId, mUtteranceId, mVersion, mInterpretations, mWakeWordFalsePositive
        });
    }

    public final void setInterpretations(List list)
    {
        mInterpretations = list;
    }

    public final void setRequestId(String s)
    {
        mRequestId = s;
    }

    public final void setSessionId(String s)
    {
        mSessionId = s;
    }

    public final void setUtteranceId(String s)
    {
        mUtteranceId = s;
    }

    public void setVersion(String s)
    {
        mVersion = s;
    }

    public final void setWakeWordFalsePositive(Boolean boolean1)
    {
        mWakeWordFalsePositive = boolean1;
    }

    public String toString()
    {
        String s;
        try
        {
            s = toJson(this, false);
        }
        catch (BIFException bifexception)
        {
            return bifexception.toString();
        }
        return s;
    }

}
