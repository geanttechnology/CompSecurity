// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            LineFormatter

public class BasicLineFormatter
    implements LineFormatter
{

    public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
    public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();

    public BasicLineFormatter()
    {
    }

    public static String formatHeader(Header header, LineFormatter lineformatter)
    {
        if (lineformatter == null)
        {
            lineformatter = INSTANCE;
        }
        return lineformatter.formatHeader(null, header).toString();
    }

    public static String formatProtocolVersion(ProtocolVersion protocolversion, LineFormatter lineformatter)
    {
        if (lineformatter == null)
        {
            lineformatter = INSTANCE;
        }
        return lineformatter.appendProtocolVersion(null, protocolversion).toString();
    }

    public static String formatRequestLine(RequestLine requestline, LineFormatter lineformatter)
    {
        if (lineformatter == null)
        {
            lineformatter = INSTANCE;
        }
        return lineformatter.formatRequestLine(null, requestline).toString();
    }

    public static String formatStatusLine(StatusLine statusline, LineFormatter lineformatter)
    {
        if (lineformatter == null)
        {
            lineformatter = INSTANCE;
        }
        return lineformatter.formatStatusLine(null, statusline).toString();
    }

    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer chararraybuffer, ProtocolVersion protocolversion)
    {
        Args.notNull(protocolversion, "Protocol version");
        int i = estimateProtocolVersionLen(protocolversion);
        if (chararraybuffer == null)
        {
            chararraybuffer = new CharArrayBuffer(i);
        } else
        {
            chararraybuffer.ensureCapacity(i);
        }
        chararraybuffer.append(protocolversion.getProtocol());
        chararraybuffer.append('/');
        chararraybuffer.append(Integer.toString(protocolversion.getMajor()));
        chararraybuffer.append('.');
        chararraybuffer.append(Integer.toString(protocolversion.getMinor()));
        return chararraybuffer;
    }

    protected void doFormatHeader(CharArrayBuffer chararraybuffer, Header header)
    {
        String s = header.getName();
        header = header.getValue();
        int j = s.length() + 2;
        int i = j;
        if (header != null)
        {
            i = j + header.length();
        }
        chararraybuffer.ensureCapacity(i);
        chararraybuffer.append(s);
        chararraybuffer.append(": ");
        if (header != null)
        {
            chararraybuffer.append(header);
        }
    }

    protected void doFormatRequestLine(CharArrayBuffer chararraybuffer, RequestLine requestline)
    {
        String s = requestline.getMethod();
        String s1 = requestline.getUri();
        chararraybuffer.ensureCapacity(s.length() + 1 + s1.length() + 1 + estimateProtocolVersionLen(requestline.getProtocolVersion()));
        chararraybuffer.append(s);
        chararraybuffer.append(' ');
        chararraybuffer.append(s1);
        chararraybuffer.append(' ');
        appendProtocolVersion(chararraybuffer, requestline.getProtocolVersion());
    }

    protected void doFormatStatusLine(CharArrayBuffer chararraybuffer, StatusLine statusline)
    {
        int j = estimateProtocolVersionLen(statusline.getProtocolVersion()) + 1 + 3 + 1;
        String s = statusline.getReasonPhrase();
        int i = j;
        if (s != null)
        {
            i = j + s.length();
        }
        chararraybuffer.ensureCapacity(i);
        appendProtocolVersion(chararraybuffer, statusline.getProtocolVersion());
        chararraybuffer.append(' ');
        chararraybuffer.append(Integer.toString(statusline.getStatusCode()));
        chararraybuffer.append(' ');
        if (s != null)
        {
            chararraybuffer.append(s);
        }
    }

    protected int estimateProtocolVersionLen(ProtocolVersion protocolversion)
    {
        return protocolversion.getProtocol().length() + 4;
    }

    public CharArrayBuffer formatHeader(CharArrayBuffer chararraybuffer, Header header)
    {
        Args.notNull(header, "Header");
        if (header instanceof FormattedHeader)
        {
            return ((FormattedHeader)header).getBuffer();
        } else
        {
            chararraybuffer = initBuffer(chararraybuffer);
            doFormatHeader(chararraybuffer, header);
            return chararraybuffer;
        }
    }

    public CharArrayBuffer formatRequestLine(CharArrayBuffer chararraybuffer, RequestLine requestline)
    {
        Args.notNull(requestline, "Request line");
        chararraybuffer = initBuffer(chararraybuffer);
        doFormatRequestLine(chararraybuffer, requestline);
        return chararraybuffer;
    }

    public CharArrayBuffer formatStatusLine(CharArrayBuffer chararraybuffer, StatusLine statusline)
    {
        Args.notNull(statusline, "Status line");
        chararraybuffer = initBuffer(chararraybuffer);
        doFormatStatusLine(chararraybuffer, statusline);
        return chararraybuffer;
    }

    protected CharArrayBuffer initBuffer(CharArrayBuffer chararraybuffer)
    {
        if (chararraybuffer != null)
        {
            chararraybuffer.clear();
            return chararraybuffer;
        } else
        {
            return new CharArrayBuffer(64);
        }
    }

}
