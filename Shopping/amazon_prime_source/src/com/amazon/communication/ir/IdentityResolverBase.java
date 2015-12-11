// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;

import amazon.communication.connection.Purpose;
import amazon.communication.identity.IRServiceEndpoint;
import amazon.communication.identity.IdentityResolver;
import amazon.communication.identity.ServiceIdentity;
import com.amazon.dp.logger.DPLogger;
import com.amazon.org.codehaus.jackson.JsonFactory;
import com.amazon.org.codehaus.jackson.JsonParseException;
import com.amazon.org.codehaus.jackson.JsonParser;
import com.amazon.org.codehaus.jackson.JsonToken;
import com.dp.utils.FailFast;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.communication.ir:
//            IRConfigurationException, InvalidIRFileFormatException, IRServiceEndpointImpl

public class IdentityResolverBase
    implements IdentityResolver
{

    protected static final String IR_FILE_SUFFIX = ".txt";
    public static final String IR_MASTER_FILE_NAME = "ir-master.txt";
    protected static final Set LOCALHOST_ALIASES = new HashSet() {

            
            {
                add("localhost");
                add("127.0.0.1");
            }
    };
    public static final String OVERRIDE_FILE_NAME = "override.txt";
    protected static final String WILDCARD = "*";
    private static final DPLogger log = new DPLogger("TComm.IdentityResolver");
    private List mAllowedDomains;
    private String mDomain;
    protected JsonFactory mJFactory;
    private String mPath;
    private String mRealm;
    protected Map mServiceEndpointCache;

    public IdentityResolverBase(String s)
    {
        mJFactory = new JsonFactory();
        mServiceEndpointCache = Collections.synchronizedMap(new HashMap());
        mPath = s;
    }

    private static String buildServiceEndpointKey(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append(".");
        stringbuilder.append(s1);
        stringbuilder.append(".");
        stringbuilder.append(s2);
        return stringbuilder.toString();
    }

    private IRServiceEndpoint getEndpointForServiceNameDomainAndRealm(String s, String s1, String s2)
    {
        String s3;
        String s4;
        if (s1 == null)
        {
            s3 = getDomain();
        } else
        {
            s3 = s1;
        }
        if (s2 == null)
        {
            s4 = getRealm();
        } else
        {
            s4 = s2;
        }
        s2 = (IRServiceEndpoint)mServiceEndpointCache.get(buildServiceEndpointKey(s, s3, s4));
        s1 = s2;
        if (s2 == null)
        {
            s1 = s2;
            if (s3.equals("master"))
            {
                s1 = (IRServiceEndpoint)mServiceEndpointCache.get(buildServiceEndpointKey(s, "prod", s4));
            }
        }
        s2 = s1;
        if (s1 == null)
        {
            s2 = (IRServiceEndpoint)mServiceEndpointCache.get(buildServiceEndpointKey(s, s3, "*"));
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = s2;
            if (s3.equals("master"))
            {
                s1 = (IRServiceEndpoint)mServiceEndpointCache.get(buildServiceEndpointKey(s, "prod", "*"));
            }
        }
        s2 = s1;
        if (s1 == null)
        {
            s2 = (IRServiceEndpoint)mServiceEndpointCache.get(buildServiceEndpointKey(s, "*", s4));
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = (IRServiceEndpoint)mServiceEndpointCache.get(buildServiceEndpointKey(s, "*", "*"));
        }
        return s1;
    }

    private void verifyValidDomain(String s)
        throws IRConfigurationException
    {
        if (LOCALHOST_ALIASES.contains(s))
        {
            return;
        }
        for (Iterator iterator = mAllowedDomains.iterator(); iterator.hasNext();)
        {
            if (s.endsWith((String)iterator.next()))
            {
                return;
            }
        }

        throw new IRConfigurationException((new StringBuilder()).append("hostname domain is not allowed: ").append(s).toString());
    }

    public String getDomain()
    {
        return mDomain;
    }

    public IRServiceEndpoint getEndpointForServiceName(String s)
    {
        return getEndpointForServiceNameDomainAndRealm(s, null, null);
    }

    public String getRealm()
    {
        return mRealm;
    }

    public void initialize()
    {
        Object obj2;
        File afile[];
        int i;
        log.verbose("initialize", "initializing IdentityResolver map", new Object[] {
            "path", mPath, "domain", getDomain(), "realm", getRealm()
        });
        afile = (new File(mPath)).listFiles();
        if (afile == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expecting directory to exist at ").append(mPath).append(" as part of identity resolver setup").toString());
        }
        log.verbose("initialize", "found IdentityResolver files", new Object[] {
            "fileList.length", Integer.valueOf(afile.length)
        });
        Arrays.sort(afile);
        obj2 = null;
        i = 0;
_L5:
        if (i >= afile.length) goto _L2; else goto _L1
_L1:
        if (!afile[i].getName().equals("override.txt")) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = afile[i];
        log.verbose("initialize", "override file found", new Object[0]);
_L7:
        i++;
        obj2 = obj;
          goto _L5
_L4:
        obj = obj2;
        if (!afile[i].getName().endsWith(".txt")) goto _L7; else goto _L6
_L6:
        obj = obj2;
        if (afile[i].getName().equals("ir-master.txt")) goto _L7; else goto _L8
_L8:
        Object obj4;
        Object obj5;
        obj5 = null;
        obj = null;
        obj4 = null;
        Object obj1 = new FileInputStream(afile[i]);
        log.verbose("initialize", "about to parse file", new Object[] {
            "fileName", afile[i].getName()
        });
        parseConfig(((InputStream) (obj1)), mServiceEndpointCache);
        obj = obj2;
        if (obj1 == null) goto _L7; else goto _L9
_L9:
        ((FileInputStream) (obj1)).close();
        obj = obj2;
          goto _L7
        obj;
        log.warn("initialize", "error closing FileInputStream", new Object[] {
            "file", afile[i].getName(), obj
        });
        obj = obj2;
          goto _L7
        obj;
        obj1 = obj4;
        obj4 = obj;
_L22:
        obj = obj1;
        log.error("initialize", "error parsing file", new Object[] {
            "fileName", afile[i].getName(), obj4
        });
        obj = obj2;
        if (obj1 == null) goto _L7; else goto _L10
_L10:
        ((FileInputStream) (obj1)).close();
        obj = obj2;
          goto _L7
        obj;
        log.warn("initialize", "error closing FileInputStream", new Object[] {
            "file", afile[i].getName(), obj
        });
        obj = obj2;
          goto _L7
        InvalidIRFileFormatException invalidirfileformatexception;
        invalidirfileformatexception;
        obj1 = obj5;
_L21:
        obj = obj1;
        log.error("initialize", "error parsing file", new Object[] {
            "fileName", afile[i].getName(), invalidirfileformatexception
        });
        obj = obj2;
        if (obj1 == null) goto _L7; else goto _L11
_L11:
        ((FileInputStream) (obj1)).close();
        obj = obj2;
          goto _L7
        obj;
        log.warn("initialize", "error closing FileInputStream", new Object[] {
            "file", afile[i].getName(), obj
        });
        obj = obj2;
          goto _L7
        obj1;
_L20:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                log.warn("initialize", "error closing FileInputStream", new Object[] {
                    "file", afile[i].getName(), obj
                });
            }
        }
        throw obj1;
_L2:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        obj5 = null;
        obj = null;
        invalidirfileformatexception = null;
        obj1 = new FileInputStream(((File) (obj2)));
        log.verbose("initialize", "about to parse override file.", new Object[0]);
        parseConfig(((InputStream) (obj1)), mServiceEndpointCache);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        ((FileInputStream) (obj1)).close();
_L13:
        return;
        obj;
        log.warn("initialize", "error closing override FileInputStream", new Object[] {
            obj
        });
        return;
        Object obj3;
        obj3;
        obj1 = invalidirfileformatexception;
_L18:
        obj = obj1;
        log.error("initialize", "error parsing file", new Object[] {
            "fileName", "override.txt", obj3
        });
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        try
        {
            ((FileInputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.warn("initialize", "error closing override FileInputStream", new Object[] {
                obj
            });
        }
        return;
        obj3;
        obj1 = obj5;
_L17:
        obj = obj1;
        log.error("initialize", "error parsing file", new Object[] {
            "fileName", "override.txt", obj3
        });
        if (obj1 == null) goto _L13; else goto _L14
_L14:
        try
        {
            ((FileInputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.warn("initialize", "error closing override FileInputStream", new Object[] {
                obj
            });
        }
        return;
        obj1;
_L16:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                log.warn("initialize", "error closing override FileInputStream", new Object[] {
                    obj
                });
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L16; else goto _L15
_L15:
        obj3;
          goto _L17
        obj3;
          goto _L18
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L20; else goto _L19
_L19:
        invalidirfileformatexception;
          goto _L21
        invalidirfileformatexception;
          goto _L22
    }

    public void parseConfig(InputStream inputstream, Map map)
        throws JsonParseException, IOException, InvalidIRFileFormatException
    {
        JsonParser jsonparser = mJFactory.createJsonParser(inputstream);
        Integer integer;
        amazon.communication.identity.IRServiceEndpoint.ClearTextConnection cleartextconnection;
        String s;
        amazon.communication.identity.IRServiceEndpoint.DataCompression datacompression;
        amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection;
        String s1;
        String s2;
        String s3;
        Object obj;
        int i;
        boolean flag;
        if (jsonparser.nextToken() == JsonToken.START_OBJECT)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FailFast.expectTrue(flag);
        inputstream = jsonparser.nextToken();
_L6:
        if (inputstream == JsonToken.END_OBJECT || inputstream == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = jsonparser.getCurrentName();
        log.verbose("parseConfig", "parsing JSON for service", new Object[] {
            "serviceName", s1
        });
        jsonparser.nextToken();
        s = null;
        i = -1;
        directconnection = amazon.communication.identity.IRServiceEndpoint.DirectConnection.NOT_ALLOWED;
        datacompression = amazon.communication.identity.IRServiceEndpoint.DataCompression.NOT_NEEDED;
        cleartextconnection = amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.NOT_ALLOWED;
        integer = null;
        inputstream = null;
_L4:
        if (jsonparser.nextToken() == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_687;
        }
        s3 = jsonparser.getCurrentName();
        int j = s3.indexOf(".");
        s2 = s3.substring(0, j);
        s3 = s3.substring(j + 1);
        log.verbose("parseConfig", "entry found", new Object[] {
            "domain", s2, "realm", s3
        });
        jsonparser.nextToken();
_L3:
        if (jsonparser.nextToken() == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj = jsonparser.getCurrentName();
        jsonparser.nextToken();
        if (!((String) (obj)).equals("hostname")) goto _L2; else goto _L1
_L1:
        s = jsonparser.getText();
        verifyValidDomain(s);
          goto _L3
        inputstream;
        try
        {
            jsonparser.close();
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            log.warn("parseConfig", "Error closing JsonParser", new Object[] {
                map
            });
        }
        throw inputstream;
_L2:
label0:
        {
            if (!((String) (obj)).equals("timeout"))
            {
                break label0;
            }
            i = jsonparser.getValueAsInt();
        }
          goto _L3
        if (!((String) (obj)).equals("direct-connection"))
        {
            break MISSING_BLOCK_LABEL_351;
        }
        obj = jsonparser.getText();
        directconnection = amazon.communication.identity.IRServiceEndpoint.DirectConnection.parse(((String) (obj)));
          goto _L3
        inputstream;
        throw new InvalidIRFileFormatException((new StringBuilder()).append("Invalid direct-connection: <").append(((String) (obj))).append(">.").toString());
        if (!((String) (obj)).equals("data-compression"))
        {
            break MISSING_BLOCK_LABEL_415;
        }
        obj = jsonparser.getText();
        datacompression = amazon.communication.identity.IRServiceEndpoint.DataCompression.parse(((String) (obj)));
          goto _L3
        inputstream;
        throw new InvalidIRFileFormatException((new StringBuilder()).append("Invalid data-compression: <").append(((String) (obj))).append(">.").toString());
        if (!((String) (obj)).equals("clear-text-connection"))
        {
            break MISSING_BLOCK_LABEL_479;
        }
        obj = jsonparser.getText();
        cleartextconnection = amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.parse(((String) (obj)));
          goto _L3
        inputstream;
        throw new InvalidIRFileFormatException((new StringBuilder()).append("Invalid clear-text-connection: <").append(((String) (obj))).append(">.").toString());
        if (!((String) (obj)).equals("port"))
        {
            break MISSING_BLOCK_LABEL_502;
        }
        integer = Integer.valueOf(jsonparser.getIntValue());
          goto _L3
label1:
        {
            if (!((String) (obj)).equals("secure-port"))
            {
                break label1;
            }
            inputstream = Integer.valueOf(jsonparser.getIntValue());
        }
          goto _L3
        throw new InvalidIRFileFormatException((new StringBuilder()).append("Unexpected field name: <").append(((String) (obj))).append(">.").toString());
        if (directconnection == amazon.communication.identity.IRServiceEndpoint.DirectConnection.NOT_ALLOWED)
        {
            break MISSING_BLOCK_LABEL_641;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_603;
        }
        log.warn("parseConfig", "no hostname for endpoint", new Object[] {
            "serviceName", s1
        });
          goto _L4
        if (integer != null || inputstream != null)
        {
            break MISSING_BLOCK_LABEL_641;
        }
        log.warn("parseConfig", "no insecure or secure port for endpoint", new Object[] {
            "serviceName", s1
        });
          goto _L4
        obj = new IRServiceEndpointImpl(s, s2, s3, directconnection, datacompression, cleartextconnection, i, integer, inputstream);
        map.put(buildServiceEndpointKey(s1, s2, s3), obj);
          goto _L4
        inputstream = jsonparser.nextToken();
        if (true) goto _L6; else goto _L5
_L5:
        try
        {
            jsonparser.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            log.warn("parseConfig", "Error closing JsonParser", new Object[] {
                inputstream
            });
        }
        return;
    }

    public IRServiceEndpoint resolveServiceEndpoint(ServiceIdentity serviceidentity)
    {
        return getEndpointForServiceNameDomainAndRealm(serviceidentity.getServiceName(), serviceidentity.getDomain(), serviceidentity.getRealm());
    }

    public IRServiceEndpoint resolveServiceEndpoint(ServiceIdentity serviceidentity, Purpose purpose)
    {
        log.warn("resolveServiceEndpoint", "In this implementation, we'll ignore the purpose", new Object[] {
            "endpoint", serviceidentity, "purpose", purpose
        });
        return resolveServiceEndpoint(serviceidentity);
    }

    public void setAllowedDomains(List list)
    {
        if (list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("AllowedDomains cannot be null or empty");
        } else
        {
            mAllowedDomains = list;
            return;
        }
    }

    public void setDomain(String s)
    {
        mDomain = s;
    }

    public void setRealm(String s)
    {
        mRealm = s;
    }

}
