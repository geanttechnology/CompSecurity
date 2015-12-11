// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.espn.androidplayersdk.datamanager.ESPNPlayerSdk;
import java.io.IOException;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.comcast.playerplatform.util.android:
//            AbstractResponseEventListener, ThreadManager, IConfigurationEventListener

public class ConfigurationManager extends AbstractResponseEventListener
{

    private static ConfigurationManager instance;
    private Map configValues;
    private ExecutorService executorService;
    private boolean isEspnReady;
    private boolean isReady;
    private CopyOnWriteArrayList listeners;

    private ConfigurationManager()
    {
        isReady = false;
        executorService = Executors.newSingleThreadExecutor();
        configValues = new Hashtable();
        listeners = new CopyOnWriteArrayList();
    }

    public static ConfigurationManager getInstance()
    {
        com/comcast/playerplatform/util/android/ConfigurationManager;
        JVM INSTR monitorenter ;
        ConfigurationManager configurationmanager;
        if (instance == null)
        {
            instance = new ConfigurationManager();
        }
        configurationmanager = instance;
        com/comcast/playerplatform/util/android/ConfigurationManager;
        JVM INSTR monitorexit ;
        return configurationmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private void parseConfiguration(String s)
    {
        Object obj1;
        obj1 = DocumentBuilderFactory.newInstance();
        setIsReady(false);
        Object obj = configValues;
        obj;
        JVM INSTR monitorenter ;
        configValues.clear();
        obj1 = ((DocumentBuilderFactory) (obj1)).newDocumentBuilder().parse(new InputSource(new StringReader(s))).getElementsByTagName("add");
        int i = 0;
_L2:
        NamedNodeMap namednodemap;
        if (i >= ((NodeList) (obj1)).getLength())
        {
            break MISSING_BLOCK_LABEL_328;
        }
        namednodemap = ((NodeList) (obj1)).item(i).getAttributes();
        if (namednodemap.getNamedItem("key").getTextContent().equals("CustomParams") || namednodemap.getNamedItem("key").getTextContent().equals("ComscoreParams"))
        {
            StringBuffer stringbuffer = new StringBuffer();
            if (configValues.containsKey(namednodemap.getNamedItem("key").getTextContent()))
            {
                stringbuffer.append(configValues.get(namednodemap.getNamedItem("key").getTextContent()));
            }
            stringbuffer.append(namednodemap.getNamedItem("paramKey").getTextContent()).append("=").append(namednodemap.getNamedItem("paramValue").getTextContent()).append(";");
            configValues.put(namednodemap.getNamedItem("key").getTextContent(), stringbuffer.toString());
            break MISSING_BLOCK_LABEL_357;
        }
        configValues.put(namednodemap.getNamedItem("key").getTextContent(), namednodemap.getNamedItem("value").getTextContent());
        break MISSING_BLOCK_LABEL_357;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((ParserConfigurationException) (obj)).printStackTrace();
            sendFailedEvent(s);
            return;
        }
        catch (SAXException saxexception)
        {
            saxexception.printStackTrace();
            sendFailedEvent(s);
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_351;
        obj;
        JVM INSTR monitorexit ;
        setConfigReady();
        return;
        sendFailedEvent(s);
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void sendFailedEvent(final String xmlString)
    {
        setIsReady(false);
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final ConfigurationManager this$0;
            final String val$xmlString;

            public void run()
            {
                CopyOnWriteArrayList copyonwritearraylist = listeners;
                copyonwritearraylist;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((IConfigurationEventListener)iterator.next()).configurationFailed((new StringBuilder()).append("Configuration Error. Unable to parse xml: ").append(xmlString).toString())) { }
                break MISSING_BLOCK_LABEL_74;
                Exception exception;
                exception;
                copyonwritearraylist;
                JVM INSTR monitorexit ;
                throw exception;
                copyonwritearraylist;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = ConfigurationManager.this;
                xmlString = s;
                super();
            }
        });
    }

    private void setConfigReady()
    {
        setIsReady(true);
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final ConfigurationManager this$0;

            public void run()
            {
                CopyOnWriteArrayList copyonwritearraylist = listeners;
                copyonwritearraylist;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((IConfigurationEventListener)iterator.next()).configurationLoaded()) { }
                break MISSING_BLOCK_LABEL_52;
                Exception exception;
                exception;
                copyonwritearraylist;
                JVM INSTR monitorexit ;
                throw exception;
                copyonwritearraylist;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = ConfigurationManager.this;
                super();
            }
        });
    }

    private void setIsReady(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        isReady = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void addListener(IConfigurationEventListener iconfigurationeventlistener)
    {
        listeners.add(iconfigurationeventlistener);
    }

    public boolean containsKey(String s)
    {
        return configValues.containsKey(s);
    }

    public String getConfigValue(String s)
    {
        if (configValues.containsKey(s) && configValues.get(s) != null)
        {
            return configValues.get(s).toString();
        } else
        {
            return null;
        }
    }

    public void initializeESPN(Context context, boolean flag)
    {
        ESPNPlayerSdk.setIsQA(flag);
        context.registerReceiver(new BroadcastReceiver() {

            final ConfigurationManager this$0;

            public void onReceive(Context context1, Intent intent)
            {
                isEspnReady = true;
                context1.unregisterReceiver(this);
            }

            
            {
                this$0 = ConfigurationManager.this;
                super();
            }
        }, new IntentFilter("com.espn.action.CONFIG_UPDATED"));
        ESPNPlayerSdk.init(context, "comcast");
    }

    public boolean isEspnReady()
    {
        return isEspnReady;
    }

    public boolean isReady()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isReady;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void loadConfigurationFromXml(final String xmlString)
    {
        executorService.execute(new Runnable() {

            final ConfigurationManager this$0;
            final String val$xmlString;

            public void run()
            {
                parseConfiguration(xmlString);
            }

            
            {
                this$0 = ConfigurationManager.this;
                xmlString = s;
                super();
            }
        });
    }

    public void removeListener(IConfigurationEventListener iconfigurationeventlistener)
    {
        listeners.remove(iconfigurationeventlistener);
    }

    public void requestFailed(final String response)
    {
        setIsReady(false);
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final ConfigurationManager this$0;
            final String val$response;

            public void run()
            {
                CopyOnWriteArrayList copyonwritearraylist = listeners;
                copyonwritearraylist;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((IConfigurationEventListener)iterator.next()).configurationFailed(response)) { }
                break MISSING_BLOCK_LABEL_56;
                Exception exception;
                exception;
                copyonwritearraylist;
                JVM INSTR monitorexit ;
                throw exception;
                copyonwritearraylist;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = ConfigurationManager.this;
                response = s;
                super();
            }
        });
    }

    public void responseReceived(final String response)
    {
        executorService.execute(new Runnable() {

            final ConfigurationManager this$0;
            final String val$response;

            public void run()
            {
                parseConfiguration(response);
            }

            
            {
                this$0 = ConfigurationManager.this;
                response = s;
                super();
            }
        });
    }

    public void unInitializeEspn()
    {
        isEspnReady = false;
        ESPNPlayerSdk.unInit();
    }




/*
    static boolean access$202(ConfigurationManager configurationmanager, boolean flag)
    {
        configurationmanager.isEspnReady = flag;
        return flag;
    }

*/
}
