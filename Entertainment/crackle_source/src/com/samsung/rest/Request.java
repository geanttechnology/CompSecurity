// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

// Referenced classes of package com.samsung.rest:
//            DeviceInfo, HTTPMethod

public class Request
{

    public static final String CONTENT_TYPE_BINARY = "binary/octet-stream";
    public static final String CONTENT_TYPE_JPEG = "image/jpeg";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_PNG = "image/png";
    private String _body;
    private byte _bodyBinary[];
    private String _contentType;
    private String _filePath;
    private HashMap _headers;
    private HTTPMethod _method;
    private URL _url;
    private boolean _waitForResponse;

    public Request(String s, String s1)
    {
        _body = "";
        _contentType = "application/json";
        _bodyBinary = null;
        _waitForResponse = true;
        _waitForResponse = true;
        setUrl(s);
        addRequiredHeaders();
        setMethod(s1);
    }

    public Request(String s, String s1, String s2)
    {
        _body = "";
        _contentType = "application/json";
        _bodyBinary = null;
        _waitForResponse = true;
        setContentType(s2);
        setUrl(s);
        addRequiredHeaders();
        setMethod(s1);
    }

    public Request(String s, String s1, boolean flag)
    {
        _body = "";
        _contentType = "application/json";
        _bodyBinary = null;
        _waitForResponse = true;
        setUrl(s);
        addRequiredHeaders();
        setMethod(s1);
        _waitForResponse = flag;
    }

    private void addDeviceNameHeader()
    {
        _headers.put("DeviceName", DeviceInfo.getDeviceName());
    }

    private void addProductIdHeader()
    {
        _headers.put("ProductID", "SMARTDev");
    }

    private void addRequiredHeaders()
    {
        _headers = new HashMap();
        addSLDeviceIdHeader();
        addDeviceNameHeader();
        addProductIdHeader();
        addVendorIdHeader();
        addUserAgentHeader();
    }

    private void addSLDeviceIdHeader()
    {
        _headers.put("SLDeviceID", DeviceInfo.getDeviceId());
    }

    private void addUserAgentHeader()
    {
        _headers.put("User-Agent", DeviceInfo.getDeviceUserAgent());
    }

    private void addVendorIdHeader()
    {
        _headers.put("VendorID", "samsunge");
    }

    private void setUrl(String s)
    {
        try
        {
            _url = new URL(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MalformedURLException", (new StringBuilder("MalformedURLException: ")).append(s.getMessage()).toString());
        }
    }

    private void waitForResponse()
    {
        _headers.put("BLUEBIRD_CONNECTION_MODE", "PIGGYBACK_MODE");
    }

    public void addBody(String s)
    {
        if (s != null)
        {
            _body = s;
        }
    }

    public void addHeader(String s, String s1)
    {
        if (s != null || s1 != null)
        {
            _headers.put(s, s1);
        }
    }

    public void addHeaders(HashMap hashmap)
    {
        if (hashmap != null)
        {
            hashmap.putAll(hashmap);
        }
    }

    public String getBody()
    {
        return _body;
    }

    public byte[] getBodyBinary()
    {
        return _bodyBinary;
    }

    public String getContentType()
    {
        return _contentType;
    }

    public String getFilePath()
    {
        return _filePath;
    }

    public HashMap getHeaders()
    {
        return _headers;
    }

    public HTTPMethod getMethod()
    {
        return _method;
    }

    public URL getUrl()
    {
        return _url;
    }

    public boolean isWaitForResponse()
    {
        return _waitForResponse;
    }

    public void makeFileRequest(String s)
    {
        _waitForResponse = true;
        _filePath = s;
    }

    public void setBodyBinary(byte abyte0[])
    {
        _bodyBinary = abyte0;
    }

    public void setContentType(String s)
    {
        _contentType = s;
    }

    public void setMethod(String s)
    {
        _method = HTTPMethod.get(s);
    }
}
