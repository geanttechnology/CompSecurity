// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            ParseError, WebResponseHeaders

public abstract class WebResponseParser
{
    private static final class WebResponseParserState extends Enum
    {

        private static final WebResponseParserState $VALUES[];
        public static final WebResponseParserState Before_Parse;
        public static final WebResponseParserState Begin_Parse;
        public static final WebResponseParserState Completed;
        public static final WebResponseParserState Parsing;

        public static WebResponseParserState valueOf(String s)
        {
            return (WebResponseParserState)Enum.valueOf(com/amazon/identity/kcpsdk/common/WebResponseParser$WebResponseParserState, s);
        }

        public static WebResponseParserState[] values()
        {
            return (WebResponseParserState[])$VALUES.clone();
        }

        static 
        {
            Before_Parse = new WebResponseParserState("Before_Parse", 0);
            Begin_Parse = new WebResponseParserState("Begin_Parse", 1);
            Parsing = new WebResponseParserState("Parsing", 2);
            Completed = new WebResponseParserState("Completed", 3);
            $VALUES = (new WebResponseParserState[] {
                Before_Parse, Begin_Parse, Parsing, Completed
            });
        }

        private WebResponseParserState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/identity/kcpsdk/common/WebResponseParser.getName();
    private WebResponseParserState mCurrentState;
    private boolean mParseBodyChunkWasMaybeNeeded;
    private ParseError mParseError;
    private final String mParserName;
    private WebResponseHeaders mWebResponseHeaders;

    public WebResponseParser(String s)
    {
        mParserName = s;
        mParseError = ParseError.ParseErrorNoError;
        mCurrentState = WebResponseParserState.Before_Parse;
    }

    private void checkAndChangeState(WebResponseParserState webresponseparserstate)
    {
        if (mCurrentState != WebResponseParserState.Before_Parse && webresponseparserstate == WebResponseParserState.Begin_Parse)
        {
            MAPLog.e(TAG, "%s: beginParse has been called more than once.", new Object[] {
                getParserName()
            });
            return;
        }
        if (mCurrentState == WebResponseParserState.Before_Parse)
        {
            if (webresponseparserstate == WebResponseParserState.Parsing)
            {
                MAPLog.e(TAG, "%s: parseBodyChunk called before beginParse", new Object[] {
                    getParserName()
                });
                return;
            }
            if (webresponseparserstate == WebResponseParserState.Completed)
            {
                MAPLog.e(TAG, "%s: endParse called before beginParse", new Object[] {
                    getParserName()
                });
                return;
            }
        } else
        if (mCurrentState == WebResponseParserState.Begin_Parse)
        {
            if (webresponseparserstate == WebResponseParserState.Completed && shouldParseBody())
            {
                mParseBodyChunkWasMaybeNeeded = true;
                return;
            }
            if (webresponseparserstate == WebResponseParserState.Parsing && !shouldParseBody())
            {
                MAPLog.e(TAG, "%s: shouldParseBody is false. parseBodyChunk should not be called", new Object[] {
                    getParserName()
                });
                return;
            }
        } else
        if (mCurrentState == WebResponseParserState.Completed && webresponseparserstate == WebResponseParserState.Parsing)
        {
            MAPLog.e(TAG, "%s: parseBodyChunk called after endParse", new Object[] {
                getParserName()
            });
            return;
        }
        mCurrentState = webresponseparserstate;
    }

    public void beginParse(WebResponseHeaders webresponseheaders)
    {
        checkAndChangeState(WebResponseParserState.Begin_Parse);
        mWebResponseHeaders = webresponseheaders;
        boolean flag = internalBeginParse(webresponseheaders);
        long l = mWebResponseHeaders.getStatusCode();
        if (l < 200L || l >= 300L)
        {
            MAPLog.i(TAG, "%s: HTTP Error: %d", new Object[] {
                getParserName(), Long.valueOf(l)
            });
            if (!flag)
            {
                setParseError(ParseError.ParseErrorHttpError);
            }
        }
    }

    public ParseError endParse()
    {
        checkAndChangeState(WebResponseParserState.Completed);
        if (getParseError() != ParseError.ParseErrorNoError)
        {
            MAPLog.e(TAG, "%s: endParse: called after another method returned a parse error.", new Object[] {
                getParserName()
            });
            return getParseError();
        }
        internalEndParse();
        if (getParseError() == ParseError.ParseErrorMalformedBody)
        {
            if (mParseBodyChunkWasMaybeNeeded)
            {
                MAPLog.w(TAG, "%s: endParse called before parseBodyChunk. Confirm that this is by design.", new Object[] {
                    getParserName()
                });
            }
            MAPLog.e(TAG, "%s: endParse: Malformed response. Confirm all received data is being properly passed to the parser, device capabilities are set properly, and no server-side behavior changes have occurred.", new Object[] {
                getParserName()
            });
        }
        return getParseError();
    }

    public ParseError getParseError()
    {
        return mParseError;
    }

    public abstract Object getParsedResponse();

    protected String getParserName()
    {
        return mParserName;
    }

    protected WebResponseHeaders getWebResponseHeaders()
    {
        return mWebResponseHeaders;
    }

    protected boolean internalBeginParse(WebResponseHeaders webresponseheaders)
    {
        return false;
    }

    protected abstract void internalEndParse();

    protected abstract void internalParseBodyChunk(byte abyte0[], long l);

    public ParseError parseBodyChunk(byte abyte0[], long l)
    {
        checkAndChangeState(WebResponseParserState.Parsing);
        if (getParseError() != ParseError.ParseErrorNoError)
        {
            MAPLog.e(TAG, "%s: parseBodyChunk: called after another method returned a parse error.", new Object[] {
                getParserName()
            });
            return getParseError();
        }
        internalParseBodyChunk(abyte0, l);
        if (getParseError() == ParseError.ParseErrorMalformedBody)
        {
            MAPLog.i(TAG, "%s: parseBodyChunk: Malformed response. confirm all received data is being properly passed to the parser, device capabilities are set properly, and no server-side behavior changes have occurred.", new Object[] {
                getParserName()
            });
        }
        return getParseError();
    }

    protected boolean setParseError(ParseError parseerror)
    {
        if (mParseError != ParseError.ParseErrorNoError)
        {
            MAPLog.i(TAG, "%s: setParseError has been called more than once.  Was %s, Now %s.", new Object[] {
                getParserName(), mParseError.name(), parseerror.name()
            });
        }
        mParseError = parseerror;
        return true;
    }

    public boolean shouldParseBody()
    {
        return getParseError() != ParseError.ParseErrorHttpError;
    }

}
