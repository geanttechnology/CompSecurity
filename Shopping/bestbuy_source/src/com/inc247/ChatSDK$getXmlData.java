// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import java.io.StringReader;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import p;

// Referenced classes of package com.inc247:
//            ChatSDKResources, ChatSDK, ChatSDKEventsCallback, ChatSDKUtil

class <init> extends AsyncTask
{

    final ChatSDK this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        as = ChatSDKResources.Chatsdk_Config_URL;
        try
        {
            as = EntityUtils.toString(p.a(new DefaultHttpClient(new BasicHttpParams()), new HttpGet(as)).getEntity());
            DocumentBuilder documentbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource inputsource = new InputSource();
            inputsource.setCharacterStream(new StringReader(as));
            ChatSDK.documentDataForReturn = documentbuilder.parse(inputsource);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        ChatSDK.access$0().callback.sendonQueueIdParamRetrievalFinished();
        if (!ChatSDKResources.XML_DATA_LOADER_DIALOG.equalsIgnoreCase("false"))
        {
            try
            {
                if (progressDialog.isShowing())
                {
                    progressDialog.dismiss();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("ERROR dismissing progress dialog", "Please check that the activity used to initialize the dialog is still active and its finish() hasnt been called.");
                progressDialog = null;
            }
        }
        if (ChatSDK.documentDataForReturn != null)
        {
            ChatSDK.contactList = ChatSDK.documentDataForReturn.getElementsByTagName("CheckAvailability");
            int i = 0;
            do
            {
                if (i >= ChatSDK.contactList.getLength())
                {
                    checkAgentAvailability();
                    return;
                }
                s = ChatSDK.contactList.item(i);
                if (s.getNodeType() == 1)
                {
                    s = (Element)s;
                    ChatSDK.queue = s.getElementsByTagName("queue").item(0).getTextContent();
                    ChatSDK.url = s.getElementsByTagName("url").item(0).getTextContent();
                }
                queueIdAndUrl.put(ChatSDK.queue, ChatSDK.url);
                try
                {
                    s = queueIdFromAppDeveloper.get("queueId").toString();
                    ChatSDK.queueFromServerData = (String)queueIdAndUrl.get(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
                }
                i++;
            } while (true);
        } else
        {
            Log.d(ChatSDK.access$1(), "oops  documentDataForReturn is null ");
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ChatSDK.access$0().callback.sendonQueueIdParamRetrievalStarted();
        if (ChatSDKResources.XML_DATA_LOADER_DIALOG.equalsIgnoreCase("false"))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        progressDialog = new ProgressDialog(ChatSDK.access$0().activity);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        return;
        Exception exception;
        exception;
        Log.e("ERROR showing progress dialog", "Please check the activity used to initialize the dialog is still active and its finish() hasnt been called.");
        return;
    }

    private eToJSBridge()
    {
        this$0 = ChatSDK.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
