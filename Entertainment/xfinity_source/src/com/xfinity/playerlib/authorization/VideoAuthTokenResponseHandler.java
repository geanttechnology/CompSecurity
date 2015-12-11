// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthToken

public class VideoAuthTokenResponseHandler extends DelegatingResponseHandler
{

    private VideoAuthToken videoAuthToken;

    public VideoAuthTokenResponseHandler()
    {
        videoAuthToken = new VideoAuthToken();
        addDefaultHeaderHandlers();
    }

    public VideoAuthToken getVideoAuthToken()
    {
        return videoAuthToken;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        Object obj = new StringWriter();
        VideoAuthToken videoauthtoken;
        int i;
        try
        {
            IOUtils.copy(inputstream, ((java.io.Writer) (obj)), "UTF-8");
            inputstream = StringUtils.remove(((StringWriter) (obj)).toString(), "\n");
            videoAuthToken.setRawData(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimException(inputstream);
        }
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        VideoAuthToken videoauthtoken1;
        try
        {
            inputstream = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(inputstream)));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimException(inputstream);
        }
        if (inputstream == null) goto _L2; else goto _L3
_L3:
        if (inputstream.getFirstChild() == null) goto _L2; else goto _L4
_L4:
        obj = inputstream.getFirstChild().getChildNodes();
        if (obj == null) goto _L2; else goto _L5
_L5:
        i = 0;
_L11:
        if (i >= ((NodeList) (obj)).getLength()) goto _L2; else goto _L6
_L6:
        inputstream = ((NodeList) (obj)).item(i);
        if (!inputstream.getNodeName().equals("resourceID")) goto _L8; else goto _L7
_L7:
        videoauthtoken = videoAuthToken;
        if (inputstream.getFirstChild() == null) goto _L10; else goto _L9
_L9:
        inputstream = inputstream.getFirstChild().getNodeValue();
_L12:
        videoauthtoken.setResourceID(inputstream);
_L13:
        i++;
          goto _L11
_L10:
        inputstream = null;
          goto _L12
_L8:
        if (!inputstream.getNodeName().equals("titleID"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        inputstream = inputstream.getFirstChild().getNodeValue();
_L14:
        videoauthtoken1.setTitleID(inputstream);
          goto _L13
        inputstream = null;
          goto _L14
        if (!inputstream.getNodeName().equals("requestorID")) goto _L16; else goto _L15
_L15:
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null) goto _L18; else goto _L17
_L17:
        inputstream = inputstream.getFirstChild().getNodeValue();
_L35:
        videoauthtoken1.setRequestorID(inputstream);
          goto _L13
_L16:
        if (!inputstream.getNodeName().equals("issueTime")) goto _L20; else goto _L19
_L19:
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null) goto _L22; else goto _L21
_L21:
        inputstream = inputstream.getFirstChild().getNodeValue();
_L36:
        videoauthtoken1.setIssueTime(inputstream);
          goto _L13
_L20:
        if (!inputstream.getNodeName().equals("ttl")) goto _L24; else goto _L23
_L23:
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null) goto _L26; else goto _L25
_L25:
        inputstream = inputstream.getFirstChild().getNodeValue();
_L37:
        videoauthtoken1.setTtl(inputstream);
          goto _L13
_L24:
        if (!inputstream.getNodeName().equals("opaqueUserID")) goto _L28; else goto _L27
_L27:
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null) goto _L30; else goto _L29
_L29:
        inputstream = inputstream.getFirstChild().getNodeValue();
_L38:
        videoauthtoken1.setOpaqueUserID(inputstream);
          goto _L13
_L28:
        if (!inputstream.getNodeName().equals("keyName")) goto _L32; else goto _L31
_L31:
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        inputstream = inputstream.getFirstChild().getNodeValue();
_L39:
        videoauthtoken1.setKeyName(inputstream);
          goto _L13
_L32:
        if (!inputstream.getNodeName().equals("value")) goto _L13; else goto _L33
_L33:
        videoauthtoken1 = videoAuthToken;
        if (inputstream.getFirstChild() == null)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        inputstream = inputstream.getFirstChild().getNodeValue();
_L34:
        videoauthtoken1.setValue(inputstream);
          goto _L13
        inputstream = null;
          goto _L34
_L2:
        return;
          goto _L13
_L18:
        inputstream = null;
          goto _L35
_L22:
        inputstream = null;
          goto _L36
_L26:
        inputstream = null;
          goto _L37
_L30:
        inputstream = null;
          goto _L38
        inputstream = null;
          goto _L39
    }
}
