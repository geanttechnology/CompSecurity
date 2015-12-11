// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

// Referenced classes of package org.springframework.http.converter:
//            HttpMessageConverter, ByteArrayHttpMessageConverter, StringHttpMessageConverter, ResourceHttpMessageConverter, 
//            HttpMessageNotWritableException, HttpMessageNotReadableException

public class FormHttpMessageConverter
    implements HttpMessageConverter
{
    private class MultipartHttpOutputMessage
        implements HttpOutputMessage
    {

        private final HttpHeaders headers = new HttpHeaders();
        private boolean headersWritten;
        private final OutputStream os;
        final FormHttpMessageConverter this$0;

        private void writeHeaders()
            throws IOException
        {
            if (!headersWritten)
            {
                for (Iterator iterator = headers.entrySet().iterator(); iterator.hasNext();)
                {
                    Object obj = (java.util.Map.Entry)iterator.next();
                    byte abyte0[] = getAsciiBytes((String)((java.util.Map.Entry) (obj)).getKey());
                    obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        byte abyte1[] = getAsciiBytes((String)((Iterator) (obj)).next());
                        os.write(abyte0);
                        os.write(58);
                        os.write(32);
                        os.write(abyte1);
                        writeNewLine(os);
                    }
                }

                writeNewLine(os);
                headersWritten = true;
            }
        }

        protected byte[] getAsciiBytes(String s)
        {
            try
            {
                s = s.getBytes("US-ASCII");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalStateException(s);
            }
            return s;
        }

        public OutputStream getBody()
            throws IOException
        {
            writeHeaders();
            return os;
        }

        public HttpHeaders getHeaders()
        {
            if (headersWritten)
            {
                return HttpHeaders.readOnlyHttpHeaders(headers);
            } else
            {
                return headers;
            }
        }

        public MultipartHttpOutputMessage(OutputStream outputstream)
        {
            this$0 = FormHttpMessageConverter.this;
            super();
            headersWritten = false;
            os = outputstream;
        }
    }


    private static final byte BOUNDARY_CHARS[] = {
        45, 95, 49, 50, 51, 52, 53, 54, 55, 56, 
        57, 48, 97, 98, 99, 100, 101, 102, 103, 104, 
        105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 
        115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 
        67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 
        77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 
        87, 88, 89, 90
    };
    private Charset charset;
    private List partConverters;
    private final Random rnd = new Random();
    private List supportedMediaTypes;

    public FormHttpMessageConverter()
    {
        charset = Charset.forName("UTF-8");
        supportedMediaTypes = new ArrayList();
        partConverters = new ArrayList();
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.MULTIPART_FORM_DATA);
        partConverters.add(new ByteArrayHttpMessageConverter());
        StringHttpMessageConverter stringhttpmessageconverter = new StringHttpMessageConverter();
        stringhttpmessageconverter.setWriteAcceptCharset(false);
        partConverters.add(stringhttpmessageconverter);
        partConverters.add(new ResourceHttpMessageConverter());
    }

    private HttpEntity getEntity(Object obj)
    {
        if (obj instanceof HttpEntity)
        {
            return (HttpEntity)obj;
        } else
        {
            return new HttpEntity(obj);
        }
    }

    private boolean isMultipart(MultiValueMap multivaluemap, MediaType mediatype)
    {
        if (mediatype != null)
        {
            return MediaType.MULTIPART_FORM_DATA.equals(mediatype);
        }
        mediatype = multivaluemap.keySet().iterator();
label0:
        do
        {
            if (mediatype.hasNext())
            {
                Iterator iterator = ((List)multivaluemap.get((String)mediatype.next())).iterator();
                Object obj;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    obj = iterator.next();
                } while (obj == null || (obj instanceof String));
                break;
            } else
            {
                return false;
            }
        } while (true);
        return true;
    }

    private void writeBoundary(byte abyte0[], OutputStream outputstream)
        throws IOException
    {
        outputstream.write(45);
        outputstream.write(45);
        outputstream.write(abyte0);
        writeNewLine(outputstream);
    }

    private void writeEnd(byte abyte0[], OutputStream outputstream)
        throws IOException
    {
        outputstream.write(45);
        outputstream.write(45);
        outputstream.write(abyte0);
        outputstream.write(45);
        outputstream.write(45);
        writeNewLine(outputstream);
    }

    private void writeForm(MultiValueMap multivaluemap, MediaType mediatype, HttpOutputMessage httpoutputmessage)
        throws IOException
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        if (mediatype != null)
        {
            httpoutputmessage.getHeaders().setContentType(mediatype);
            String s;
            Iterator iterator1;
            String s1;
            if (mediatype.getCharSet() != null)
            {
                mediatype = mediatype.getCharSet();
            } else
            {
                mediatype = charset;
            }
        } else
        {
            httpoutputmessage.getHeaders().setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            mediatype = charset;
        }
        stringbuilder = new StringBuilder();
        iterator = multivaluemap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            s = (String)iterator.next();
            iterator1 = ((List)multivaluemap.get(s)).iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                s1 = (String)iterator1.next();
                stringbuilder.append(URLEncoder.encode(s, mediatype.name()));
                if (s1 != null)
                {
                    stringbuilder.append('=');
                    stringbuilder.append(URLEncoder.encode(s1, mediatype.name()));
                    if (iterator1.hasNext())
                    {
                        stringbuilder.append('&');
                    }
                }
            } while (true);
            if (iterator.hasNext())
            {
                stringbuilder.append('&');
            }
        } while (true);
        multivaluemap = stringbuilder.toString().getBytes(mediatype.name());
        httpoutputmessage.getHeaders().setContentLength(multivaluemap.length);
        FileCopyUtils.copy(multivaluemap, httpoutputmessage.getBody());
    }

    private void writeMultipart(MultiValueMap multivaluemap, HttpOutputMessage httpoutputmessage)
        throws IOException
    {
        byte abyte0[] = generateMultipartBoundary();
        Object obj = Collections.singletonMap("boundary", new String(abyte0, "US-ASCII"));
        obj = new MediaType(MediaType.MULTIPART_FORM_DATA, ((java.util.Map) (obj)));
        httpoutputmessage.getHeaders().setContentType(((MediaType) (obj)));
        writeParts(httpoutputmessage.getBody(), multivaluemap, abyte0);
        writeEnd(abyte0, httpoutputmessage.getBody());
    }

    private void writeNewLine(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(13);
        outputstream.write(10);
    }

    private void writePart(String s, HttpEntity httpentity, OutputStream outputstream)
        throws IOException
    {
        Object obj = httpentity.getBody();
        Class class1 = obj.getClass();
        httpentity = httpentity.getHeaders();
        MediaType mediatype = httpentity.getContentType();
        for (Iterator iterator = partConverters.iterator(); iterator.hasNext();)
        {
            HttpMessageConverter httpmessageconverter = (HttpMessageConverter)iterator.next();
            if (httpmessageconverter.canWrite(class1, mediatype))
            {
                outputstream = new MultipartHttpOutputMessage(outputstream);
                outputstream.getHeaders().setContentDispositionFormData(s, getFilename(obj));
                if (!httpentity.isEmpty())
                {
                    outputstream.getHeaders().putAll(httpentity);
                }
                httpmessageconverter.write(obj, mediatype, outputstream);
                return;
            }
        }

        throw new HttpMessageNotWritableException((new StringBuilder()).append("Could not write request: no suitable HttpMessageConverter found for request type [").append(class1.getName()).append("]").toString());
    }

    private void writeParts(OutputStream outputstream, MultiValueMap multivaluemap, byte abyte0[])
        throws IOException
    {
        for (multivaluemap = multivaluemap.entrySet().iterator(); multivaluemap.hasNext();)
        {
            Object obj = (java.util.Map.Entry)multivaluemap.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Object obj1 = ((Iterator) (obj)).next();
                writeBoundary(abyte0, outputstream);
                writePart(s, getEntity(obj1), outputstream);
                writeNewLine(outputstream);
            }
        }

    }

    public final void addPartConverter(HttpMessageConverter httpmessageconverter)
    {
        Assert.notNull(httpmessageconverter, "'partConverter' must not be NULL");
        partConverters.add(httpmessageconverter);
    }

    public boolean canRead(Class class1, MediaType mediatype)
    {
        if (org/springframework/util/MultiValueMap.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (mediatype == null)
        {
            return true;
        }
        class1 = getSupportedMediaTypes().iterator();
        MediaType mediatype1;
        do
        {
            if (!class1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            mediatype1 = (MediaType)class1.next();
        } while (mediatype1.equals(MediaType.MULTIPART_FORM_DATA) || !mediatype1.includes(mediatype));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public boolean canWrite(Class class1, MediaType mediatype)
    {
        if (org/springframework/util/MultiValueMap.isAssignableFrom(class1))
        {
            if (mediatype == null || MediaType.ALL.equals(mediatype))
            {
                return true;
            }
            class1 = getSupportedMediaTypes().iterator();
            while (class1.hasNext()) 
            {
                if (((MediaType)class1.next()).isCompatibleWith(mediatype))
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected byte[] generateMultipartBoundary()
    {
        byte abyte0[] = new byte[rnd.nextInt(11) + 30];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = BOUNDARY_CHARS[rnd.nextInt(BOUNDARY_CHARS.length)];
        }

        return abyte0;
    }

    protected String getFilename(Object obj)
    {
        if (obj instanceof Resource)
        {
            return ((Resource)obj).getFilename();
        } else
        {
            return null;
        }
    }

    public List getSupportedMediaTypes()
    {
        return Collections.unmodifiableList(supportedMediaTypes);
    }

    public volatile Object read(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        return read(class1, httpinputmessage);
    }

    public MultiValueMap read(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        class1 = httpinputmessage.getHeaders().getContentType();
        LinkedMultiValueMap linkedmultivaluemap;
        int i;
        int j;
        if (class1.getCharSet() != null)
        {
            class1 = class1.getCharSet();
        } else
        {
            class1 = charset;
        }
        httpinputmessage = StringUtils.tokenizeToStringArray(FileCopyUtils.copyToString(new InputStreamReader(httpinputmessage.getBody(), class1)), "&");
        linkedmultivaluemap = new LinkedMultiValueMap(httpinputmessage.length);
        j = httpinputmessage.length;
        i = 0;
        while (i < j) 
        {
            String s = httpinputmessage[i];
            int k = s.indexOf('=');
            if (k == -1)
            {
                linkedmultivaluemap.add(URLDecoder.decode(s, class1.name()), null);
            } else
            {
                linkedmultivaluemap.add(URLDecoder.decode(s.substring(0, k), class1.name()), URLDecoder.decode(s.substring(k + 1), class1.name()));
            }
            i++;
        }
        return linkedmultivaluemap;
    }

    public volatile void write(Object obj, MediaType mediatype, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        write((MultiValueMap)obj, mediatype, httpoutputmessage);
    }

    public void write(MultiValueMap multivaluemap, MediaType mediatype, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        if (!isMultipart(multivaluemap, mediatype))
        {
            writeForm(multivaluemap, mediatype, httpoutputmessage);
            return;
        } else
        {
            writeMultipart(multivaluemap, httpoutputmessage);
            return;
        }
    }


}
