// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class DataFormatReaders
{
    protected class AccessorForReader extends com.fasterxml.jackson.core.format.InputAccessor.Std
    {

        final DataFormatReaders this$0;

        public Match createMatcher(ObjectReader objectreader, MatchStrength matchstrength)
        {
            return new Match(_in, _buffer, _bufferedStart, _bufferedEnd - _bufferedStart, objectreader, matchstrength);
        }

        public AccessorForReader(InputStream inputstream, byte abyte0[])
        {
            this$0 = DataFormatReaders.this;
            super(inputstream, abyte0);
        }

        public AccessorForReader(byte abyte0[])
        {
            this$0 = DataFormatReaders.this;
            super(abyte0);
        }

        public AccessorForReader(byte abyte0[], int i, int j)
        {
            this$0 = DataFormatReaders.this;
            super(abyte0, i, j);
        }
    }

    public static class Match
    {

        protected final byte _bufferedData[];
        protected final int _bufferedLength;
        protected final int _bufferedStart;
        protected final ObjectReader _match;
        protected final MatchStrength _matchStrength;
        protected final InputStream _originalStream;

        public JsonParser createParserWithMatch()
            throws IOException
        {
            if (_match == null)
            {
                return null;
            }
            JsonFactory jsonfactory = _match.getFactory();
            if (_originalStream == null)
            {
                return jsonfactory.createParser(_bufferedData, _bufferedStart, _bufferedLength);
            } else
            {
                return jsonfactory.createParser(getDataStream());
            }
        }

        public InputStream getDataStream()
        {
            if (_originalStream == null)
            {
                return new ByteArrayInputStream(_bufferedData, _bufferedStart, _bufferedLength);
            } else
            {
                return new MergedStream(null, _originalStream, _bufferedData, _bufferedStart, _bufferedLength);
            }
        }

        public MatchStrength getMatchStrength()
        {
            if (_matchStrength == null)
            {
                return MatchStrength.INCONCLUSIVE;
            } else
            {
                return _matchStrength;
            }
        }

        public String getMatchedFormatName()
        {
            return _match.getFactory().getFormatName();
        }

        public ObjectReader getReader()
        {
            return _match;
        }

        public boolean hasMatch()
        {
            return _match != null;
        }

        protected Match(InputStream inputstream, byte abyte0[], int i, int j, ObjectReader objectreader, MatchStrength matchstrength)
        {
            _originalStream = inputstream;
            _bufferedData = abyte0;
            _bufferedStart = i;
            _bufferedLength = j;
            _match = objectreader;
            _matchStrength = matchstrength;
        }
    }


    public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
    protected final int _maxInputLookahead;
    protected final MatchStrength _minimalMatch;
    protected final MatchStrength _optimalMatch;
    protected final ObjectReader _readers[];

    public DataFormatReaders(Collection collection)
    {
        this((ObjectReader[])collection.toArray(new ObjectReader[collection.size()]));
    }

    public transient DataFormatReaders(ObjectReader aobjectreader[])
    {
        this(aobjectreader, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
    }

    private DataFormatReaders(ObjectReader aobjectreader[], MatchStrength matchstrength, MatchStrength matchstrength1, int i)
    {
        _readers = aobjectreader;
        _optimalMatch = matchstrength;
        _minimalMatch = matchstrength1;
        _maxInputLookahead = i;
    }

    private Match _findFormat(AccessorForReader accessorforreader)
        throws IOException
    {
        ObjectReader objectreader;
        MatchStrength matchstrength;
        ObjectReader aobjectreader[];
        int i;
        int j;
        aobjectreader = _readers;
        j = aobjectreader.length;
        i = 0;
        objectreader = null;
        matchstrength = null;
_L3:
        ObjectReader objectreader1;
        MatchStrength matchstrength1;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        objectreader1 = aobjectreader[i];
        accessorforreader.reset();
        matchstrength1 = objectreader1.getFactory().hasFormat(accessorforreader);
          goto _L1
_L4:
        i++;
        if (true) goto _L3; else goto _L2
_L1:
        if (matchstrength1 != null && (matchstrength1.ordinal() >= _minimalMatch.ordinal() && (objectreader == null || matchstrength.ordinal() < matchstrength1.ordinal()))) goto _L5; else goto _L4
_L5:
        if (matchstrength1.ordinal() < _optimalMatch.ordinal()) goto _L7; else goto _L6
_L6:
        return accessorforreader.createMatcher(objectreader1, matchstrength1);
_L2:
        matchstrength1 = matchstrength;
        objectreader1 = objectreader;
        if (true) goto _L6; else goto _L7
_L7:
        matchstrength = matchstrength1;
        objectreader = objectreader1;
          goto _L4
    }

    public Match findFormat(InputStream inputstream)
        throws IOException
    {
        return _findFormat(new AccessorForReader(inputstream, new byte[_maxInputLookahead]));
    }

    public Match findFormat(byte abyte0[])
        throws IOException
    {
        return _findFormat(new AccessorForReader(abyte0));
    }

    public Match findFormat(byte abyte0[], int i, int j)
        throws IOException
    {
        return _findFormat(new AccessorForReader(abyte0, i, j));
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append('[');
        int j = _readers.length;
        if (j > 0)
        {
            stringbuilder.append(_readers[0].getFactory().getFormatName());
            for (int i = 1; i < j; i++)
            {
                stringbuilder.append(", ");
                stringbuilder.append(_readers[i].getFactory().getFormatName());
            }

        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public DataFormatReaders with(DeserializationConfig deserializationconfig)
    {
        int j = _readers.length;
        ObjectReader aobjectreader[] = new ObjectReader[j];
        for (int i = 0; i < j; i++)
        {
            aobjectreader[i] = _readers[i].with(deserializationconfig);
        }

        return new DataFormatReaders(aobjectreader, _optimalMatch, _minimalMatch, _maxInputLookahead);
    }

    public DataFormatReaders with(ObjectReader aobjectreader[])
    {
        return new DataFormatReaders(aobjectreader, _optimalMatch, _minimalMatch, _maxInputLookahead);
    }

    public DataFormatReaders withMaxInputLookahead(int i)
    {
        if (i == _maxInputLookahead)
        {
            return this;
        } else
        {
            return new DataFormatReaders(_readers, _optimalMatch, _minimalMatch, i);
        }
    }

    public DataFormatReaders withMinimalMatch(MatchStrength matchstrength)
    {
        if (matchstrength == _minimalMatch)
        {
            return this;
        } else
        {
            return new DataFormatReaders(_readers, _optimalMatch, matchstrength, _maxInputLookahead);
        }
    }

    public DataFormatReaders withOptimalMatch(MatchStrength matchstrength)
    {
        if (matchstrength == _optimalMatch)
        {
            return this;
        } else
        {
            return new DataFormatReaders(_readers, matchstrength, _minimalMatch, _maxInputLookahead);
        }
    }

    public DataFormatReaders withType(JavaType javatype)
    {
        int j = _readers.length;
        ObjectReader aobjectreader[] = new ObjectReader[j];
        for (int i = 0; i < j; i++)
        {
            aobjectreader[i] = _readers[i].withType(javatype);
        }

        return new DataFormatReaders(aobjectreader, _optimalMatch, _minimalMatch, _maxInputLookahead);
    }
}
