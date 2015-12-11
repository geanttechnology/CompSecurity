// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import com.elokence.limuleapi.Exceptions.AkException;
import com.elokence.limuleapi.exceptions.AkWsException;
import com.elokence.limuleapi.exceptions.AkWsMalformedResponseException;
import com.elokence.limuleapi.helper.ISUSimpleMultipartEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

// Referenced classes of package com.elokence.limuleapi:
//            SessionFactory, AkWsParameter, AkLog, AkAnswerWS, 
//            TestUrl

abstract class AkWebservice
{

    public static final boolean ENCRYPTION_MODE = true;
    protected static final int MULTIPART_ENTITY = 1;
    protected static final int STRING_ENTITY = 2;
    private static final String TAG = "Webservice";
    private static final int TIMEOUT_DEFAULT = 60000;
    protected static int TIMEOUT_DEFAULT_ANSWERS = 30000;
    int addEntity;
    ISUSimpleMultipartEntity entity;
    protected boolean isAlreadyRunning;
    protected ArrayList mWsParameters;
    protected String mWsService;
    String stringEntity;

    public AkWebservice()
    {
        mWsService = null;
        addEntity = 0;
        isAlreadyRunning = false;
        mWsParameters = new ArrayList();
        entity = new ISUSimpleMultipartEntity();
    }

    private void checkWsBaseUrlWithSavedConfig()
    {
        int j = SessionFactory.sharedInstance().getRankingLimit();
        int i = j;
        if (j < 500)
        {
            i = 500;
        }
        if (i <= 10000);
    }

    private void removeParameterWithKey(String s)
    {
        Object obj = null;
        Iterator iterator = mWsParameters.iterator();
        AkWsParameter akwsparameter;
        do
        {
            akwsparameter = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            akwsparameter = (AkWsParameter)iterator.next();
        } while (!akwsparameter.getKey().equals(s));
        mWsParameters.remove(akwsparameter);
    }

    public void addParameter(String s, String s1)
    {
        if (s1 != null && !s1.isEmpty())
        {
            removeParameterWithKey(s);
            mWsParameters.add(new AkWsParameter(s, s1));
            entity.addPart(s, s1);
            return;
        } else
        {
            AkLog.e("Webservice", (new StringBuilder()).append("value null or empty for key ").append(s).toString());
            return;
        }
    }

    public void addPostParam(String s, File file)
        throws FileNotFoundException
    {
        Log.d("Webservice", (new StringBuilder()).append(s).append(":").append(file.getName()).toString());
        entity.addPart(s, file.getName(), new FileInputStream(file), "multipart/form-data");
        addEntity = 1;
    }

    public int call()
    {
        if (isAlreadyRunning)
        {
            break MISSING_BLOCK_LABEL_618;
        }
        isAlreadyRunning = true;
        if (mWsService != null) goto _L2; else goto _L1
_L1:
        int i;
        AkLog.e("Webservice", "Service NULL");
        i = 400;
_L14:
        return i;
_L2:
        Object obj;
        String s;
        if (!isOnline())
        {
            AkLog.e("Webservice", "Device has no internet");
            return 400;
        }
        if (SessionFactory.sharedInstance().getBaseUrlFromSessionFactory() == null)
        {
            AkLog.e("Webservice", (new StringBuilder()).append("mBaseUrlToGiveToWS null for service ").append(mWsService).toString());
            return 400;
        }
        if (mWsService.equals(""))
        {
            break MISSING_BLOCK_LABEL_620;
        }
        s = (new StringBuilder()).append(SessionFactory.sharedInstance().getBaseUrlFromSessionFactory()).append("/").append(mWsService).toString();
        i = 0;
        obj = "?";
        for (Iterator iterator = mWsParameters.iterator(); iterator.hasNext();)
        {
            AkWsParameter akwsparameter = (AkWsParameter)iterator.next();
            Object obj1 = obj;
            if (i != 0)
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append("&").toString();
            }
            obj = (new StringBuilder()).append(((String) (obj1))).append(akwsparameter.getKey()).append("=").append(Uri.encode(akwsparameter.getValue())).toString();
            i = 1;
        }

        if (!((String) (obj)).equals("?")) goto _L4; else goto _L3
_L3:
        Object obj2 = new URL(s);
_L9:
        obj2 = (HttpURLConnection)((URL) (obj2)).openConnection();
        ((HttpURLConnection) (obj2)).setDoInput(true);
        if (!(this instanceof AkAnswerWS)) goto _L6; else goto _L5
_L5:
        ((HttpURLConnection) (obj2)).setConnectTimeout(TIMEOUT_DEFAULT_ANSWERS);
        ((HttpURLConnection) (obj2)).setReadTimeout(TIMEOUT_DEFAULT_ANSWERS);
_L10:
        if (addEntity != 1) goto _L8; else goto _L7
_L7:
        ((HttpURLConnection) (obj2)).setUseCaches(false);
        ((HttpURLConnection) (obj2)).setRequestProperty("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(entity.getBoundary()).toString());
        ((HttpURLConnection) (obj2)).setDoOutput(true);
        OutputStream outputstream = ((HttpURLConnection) (obj2)).getOutputStream();
        entity.writeTo(outputstream);
        outputstream.flush();
        outputstream.close();
_L12:
        AkLog.d("Webservice", (new StringBuilder()).append(s).append(((String) (obj))).toString());
        ((HttpURLConnection) (obj2)).connect();
        obj = null;
        OutputStream outputstream1;
        int j;
        try
        {
            if (((HttpURLConnection) (obj2)).getResponseCode() == 200)
            {
                obj = TestUrl.readInputStreamToString(((HttpURLConnection) (obj2)));
            }
            ((HttpURLConnection) (obj2)).disconnect();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return 600;
        }
        catch (UnknownHostException unknownhostexception)
        {
            return 610;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return 400;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_606;
        }
        AkLog.d("Webservice", ((String) (obj)));
        obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(((String) (obj)))));
        j = TestUrl.testNodeCompletion(((Document) (obj)));
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_584;
        }
        parseWSResponse(((Document) (obj)));
        return j;
_L4:
        obj2 = new URL((new StringBuilder()).append(s).append(((String) (obj))).toString());
          goto _L9
_L6:
        ((HttpURLConnection) (obj2)).setConnectTimeout(60000);
        ((HttpURLConnection) (obj2)).setReadTimeout(60000);
          goto _L10
_L8:
        if (addEntity != 2) goto _L12; else goto _L11
_L11:
        ((HttpURLConnection) (obj2)).setUseCaches(false);
        ((HttpURLConnection) (obj2)).setRequestProperty("Content-Type", "text/xml");
        ((HttpURLConnection) (obj2)).setDoOutput(true);
        outputstream1 = ((HttpURLConnection) (obj2)).getOutputStream();
        outputstream1.write(stringEntity.getBytes());
        outputstream1.flush();
        outputstream1.close();
          goto _L12
        i = j;
        if (j != 800) goto _L14; else goto _L13
_L13:
        parseWsResponseWithWarning(((Document) (obj)), j);
        return j;
        AkLog.e("Webservice", "XML null");
        return 400;
        return 0;
        return 400;
    }

    public final boolean isOnline()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (SessionFactory.sharedInstance() != null)
        {
            NetworkInfo networkinfo = ((ConnectivityManager)SessionFactory.sharedInstance().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            flag = flag1;
            if (networkinfo != null)
            {
                flag = flag1;
                if (networkinfo.isConnected())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    String parseWSProgression(Document document)
        throws AkWsException
    {
        document = document.getElementsByTagName("PROGRESSION");
        if (document.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("PROGRESSION NOT FOUND");
        } else
        {
            return document.item(0).getTextContent();
        }
    }

    String parseWSQuestionAnswers(Document document, ArrayList arraylist)
        throws AkWsException
    {
        NodeList nodelist = document.getElementsByTagName("ANSWER");
        if (nodelist.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("NONE ANSWER FOUND");
        }
        for (int i = 0; i < nodelist.getLength(); i++)
        {
            arraylist.add(new Session.ObjectAnswer(i, nodelist.item(i).getTextContent()));
        }

        document = document.getElementsByTagName("QUESTION");
        if (document.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("QUESTION NOT FOUND");
        } else
        {
            return document.item(0).getTextContent();
        }
    }

    abstract void parseWSResponse(Document document)
        throws AkException;

    String parseWSStep(Document document)
        throws AkWsException
    {
        document = document.getElementsByTagName("STEP");
        if (document.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("STEP NOT FOUND");
        } else
        {
            return document.item(0).getTextContent();
        }
    }

    void parseWsResponseWithWarning(Document document, int i)
        throws AkException
    {
    }

}
