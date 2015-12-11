// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import android.content.ContentResolver;
import android.net.Uri;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.photomanager.net:
//            UploadSiteHostedPicturesResponse

final class UploadSiteHostedImageRequest extends EbayTradingRequest
{

    private final String customPictureSet;
    private final String extensionInDays;
    private final Uri image;
    private final String multiPartBoundary = "EbayMobileFormBoundary";
    private final ContentResolver resolver;

    public UploadSiteHostedImageRequest(EbayTradingApi ebaytradingapi, ContentResolver contentresolver, Uri uri, String s, String s1)
    {
        super(ebaytradingapi, "UploadSiteHostedPictures");
        resolver = contentresolver;
        image = uri;
        customPictureSet = s;
        extensionInDays = s1;
        contentType = (new StringBuilder()).append("multipart/form-data; boundary=").append(multiPartBoundary).toString();
        timeout = timeout * 4;
    }

    private final byte[] buildRequest(String s, String s1, String s2)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(s.getBytes("UTF8"));
        s = XmlSerializerHelper.createSerializer();
        s.setOutput(bytearrayoutputstream, "UTF8");
        s.startDocument("utf-8", null);
        buildXmlRequest(s);
        s.endDocument();
        bytearrayoutputstream.write(s1.getBytes("UTF8"));
        s = resolver.openInputStream(image);
        s1 = new byte[4096];
_L1:
        int i = s.read(s1);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        bytearrayoutputstream.write(s1, 0, i);
          goto _L1
        s;
        bytearrayoutputstream.close();
        throw s;
        s.close();
        bytearrayoutputstream.write(s2.getBytes("UTF8"));
        bytearrayoutputstream.flush();
        s = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        return s;
    }

    private void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "UploadSiteHostedPicturesRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "PictureUploadPolicy", "ClearAndAdd");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "PictureSet", "Supersize");
        if (customPictureSet != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CustomPictureSet", customPictureSet);
        }
        if (extensionInDays != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ExtensionInDays", extensionInDays);
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "UploadSiteHostedPicturesRequest");
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append("--").append(multiPartBoundary).append("\r\n").append("Content-Disposition: form-data; name=document").append("\r\n").append("Content-Type").append(": ").append("text/xml; charset=UTF-8").append("\r\n").append("\r\n");
        String s = ((StringBuilder) (obj)).toString();
        ((StringBuilder) (obj)).delete(0, ((StringBuilder) (obj)).length()).append("\r\n").append("--").append(multiPartBoundary).append("\r\n").append("Content-Disposition: form-data; name=image; filename=image").append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("Content-Type").append(": ").append("image/jpeg").append("\r\n").append("\r\n");
        String s1 = ((StringBuilder) (obj)).toString();
        ((StringBuilder) (obj)).delete(0, ((StringBuilder) (obj)).length()).append("\r\n").append("--").append(multiPartBoundary).append("--").append("\r\n");
        obj = ((StringBuilder) (obj)).toString();
        byte abyte0[];
        try
        {
            abyte0 = buildRequest(s, s1, ((String) (obj)));
        }
        catch (IOException ioexception)
        {
            throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(ioexception);
        }
        return abyte0;
    }

    public URL getRequestUrl()
    {
        if (EbaySite.DE.equals(site))
        {
            return ApiSettings.getUrl(EbaySettings.deTradingApiImageUpload);
        } else
        {
            return super.getRequestUrl();
        }
    }

    public UploadSiteHostedPicturesResponse getResponse()
    {
        return new UploadSiteHostedPicturesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
