// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.james.mime4j.field.contenttype.parser.ContentTypeParser;
import org.apache.james.mime4j.field.contenttype.parser.ParseException;
import org.apache.james.mime4j.field.contenttype.parser.TokenMgrError;
import org.apache.james.mime4j.util.ByteSequence;

// Referenced classes of package org.apache.james.mime4j.field:
//            AbstractField, FieldParser, ParsedField

public class ContentTypeField extends AbstractField
{

    static final FieldParser PARSER = new FieldParser() {

        public ParsedField parse(String s, String s1, ByteSequence bytesequence)
        {
            return new ContentTypeField(s, s1, bytesequence);
        }

    };
    private static Log log = LogFactory.getLog(org/apache/james/mime4j/field/ContentTypeField);
    private String mimeType;
    private Map parameters;
    private ParseException parseException;
    private boolean parsed;

    ContentTypeField(String s, String s1, ByteSequence bytesequence)
    {
        super(s, s1, bytesequence);
        parsed = false;
        mimeType = "";
        parameters = new HashMap();
    }

    private void parse()
    {
        Object obj1 = getBody();
        Object obj = new ContentTypeParser(new StringReader(((String) (obj1))));
        String s;
        try
        {
            ((ContentTypeParser) (obj)).parseAll();
        }
        catch (ParseException parseexception)
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Parsing value '").append(((String) (obj1))).append("': ").append(parseexception.getMessage()).toString());
            }
            parseException = parseexception;
        }
        catch (TokenMgrError tokenmgrerror)
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Parsing value '").append(((String) (obj1))).append("': ").append(tokenmgrerror.getMessage()).toString());
            }
            parseException = new ParseException(tokenmgrerror.getMessage());
        }
        obj1 = ((ContentTypeParser) (obj)).getType();
        s = ((ContentTypeParser) (obj)).getSubType();
        if (obj1 != null && s != null)
        {
            mimeType = (new StringBuilder()).append(((String) (obj1))).append("/").append(s).toString().toLowerCase();
            obj1 = ((ContentTypeParser) (obj)).getParamNames();
            obj = ((ContentTypeParser) (obj)).getParamValues();
            if (obj1 != null && obj != null)
            {
                int j = Math.min(((List) (obj1)).size(), ((List) (obj)).size());
                for (int i = 0; i < j; i++)
                {
                    String s1 = ((String)((List) (obj1)).get(i)).toLowerCase();
                    String s2 = (String)((List) (obj)).get(i);
                    parameters.put(s1, s2);
                }

            }
        }
        parsed = true;
    }

    public String getBoundary()
    {
        return getParameter("boundary");
    }

    public String getCharset()
    {
        return getParameter("charset");
    }

    public String getParameter(String s)
    {
        if (!parsed)
        {
            parse();
        }
        return (String)parameters.get(s.toLowerCase());
    }

}
