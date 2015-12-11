// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva;


// Referenced classes of package com.conviva:
//            StreamInfo

public class StreamerError
{

    private String _errorCode;
    private int _index;
    private int _scope;
    private int _severity;
    private StreamInfo _stream;

    public StreamerError(String s, StreamInfo streaminfo, int i, int j, int k)
    {
        _errorCode = s;
        _stream = streaminfo;
        _index = i;
        _severity = j;
        _scope = k;
    }

    public static StreamerError makeUnscopedError(String s, int i)
    {
        return new StreamerError(s, null, -1, i, 0);
    }

    public String getErrorCode()
    {
        return _errorCode;
    }

    public int getSeverity()
    {
        return _severity;
    }
}
