// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.org.codehaus.jackson.format;

import com.amazon.org.codehaus.jackson.JsonFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

// Referenced classes of package com.amazon.org.codehaus.jackson.format:
//            MatchStrength, DataFormatMatcher

public class DataFormatDetector
{

    public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
    protected final JsonFactory _detectors[];
    protected final int _maxInputLookahead;
    protected final MatchStrength _minimalMatch;
    protected final MatchStrength _optimalMatch;

    public DataFormatDetector(Collection collection)
    {
        this((JsonFactory[])collection.toArray(new JsonFactory[collection.size()]));
    }

    public transient DataFormatDetector(JsonFactory ajsonfactory[])
    {
        this(ajsonfactory, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
    }

    private DataFormatDetector(JsonFactory ajsonfactory[], MatchStrength matchstrength, MatchStrength matchstrength1, int i)
    {
        _detectors = ajsonfactory;
        _optimalMatch = matchstrength;
        _minimalMatch = matchstrength1;
        _maxInputLookahead = i;
    }

    private DataFormatMatcher _findFormat(InputAccessor.Std std)
        throws IOException
    {
        Object obj;
        Object obj1;
        JsonFactory ajsonfactory[];
        int i;
        int j;
        obj1 = null;
        obj = null;
        ajsonfactory = _detectors;
        j = ajsonfactory.length;
        i = 0;
_L2:
        Object obj2;
        Object obj3;
        MatchStrength matchstrength;
        JsonFactory jsonfactory;
        obj3 = obj1;
        obj2 = obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        jsonfactory = ajsonfactory[i];
        std.reset();
        matchstrength = jsonfactory.hasFormat(std);
        obj2 = obj1;
        obj3 = obj;
        if (matchstrength != null)
        {
            if (matchstrength.ordinal() >= _minimalMatch.ordinal())
            {
                break; /* Loop/switch isn't completed */
            }
            obj3 = obj;
            obj2 = obj1;
        }
_L4:
        i++;
        obj1 = obj2;
        obj = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj1;
        obj3 = obj;
        if (((MatchStrength) (obj)).ordinal() >= matchstrength.ordinal()) goto _L4; else goto _L3
_L3:
        obj = jsonfactory;
        obj1 = matchstrength;
        obj2 = obj;
        obj3 = obj1;
        if (matchstrength.ordinal() < _optimalMatch.ordinal()) goto _L4; else goto _L5
_L5:
        obj2 = obj1;
        obj3 = obj;
        return std.createMatcher(((JsonFactory) (obj3)), ((MatchStrength) (obj2)));
    }

    public DataFormatMatcher findFormat(InputStream inputstream)
        throws IOException
    {
        return _findFormat(new InputAccessor.Std(inputstream, new byte[_maxInputLookahead]));
    }

    public DataFormatMatcher findFormat(byte abyte0[])
        throws IOException
    {
        return _findFormat(new InputAccessor.Std(abyte0));
    }

    public DataFormatDetector withMaxInputLookahead(int i)
    {
        if (i == _maxInputLookahead)
        {
            return this;
        } else
        {
            return new DataFormatDetector(_detectors, _optimalMatch, _minimalMatch, i);
        }
    }

    public DataFormatDetector withMinimalMatch(MatchStrength matchstrength)
    {
        if (matchstrength == _minimalMatch)
        {
            return this;
        } else
        {
            return new DataFormatDetector(_detectors, _optimalMatch, matchstrength, _maxInputLookahead);
        }
    }

    public DataFormatDetector withOptimalMatch(MatchStrength matchstrength)
    {
        if (matchstrength == _optimalMatch)
        {
            return this;
        } else
        {
            return new DataFormatDetector(_detectors, matchstrength, _minimalMatch, _maxInputLookahead);
        }
    }
}
