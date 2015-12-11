// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import com.elokence.limuleapi.db.AkDBAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.elokence.limuleapi:
//            AkLog, TestUrl

public class TraductionFactory
{
    public static class Language
    {

        private String mCode;
        private String mFlagUrl;
        private String mFontCoeffAndroid;
        private String mLabel;
        private String mLastTokensSync;
        private String mLastWsSync;
        private String mSmartphoneFont;

        public String getCode()
        {
            return mCode;
        }

        public String getFlagUrl()
        {
            return mFlagUrl;
        }

        public String getFontCoeffAndroid()
        {
            return mFontCoeffAndroid;
        }

        public String getLabel()
        {
            return mLabel;
        }

        public String getLastTokensSync()
        {
            return mLastTokensSync;
        }

        public String getLastWsSync()
        {
            return mLastWsSync;
        }

        public String getSmartphoneFont()
        {
            return mSmartphoneFont;
        }

        public String toString()
        {
            return (new StringBuilder()).append("AkLanguageModel [mCode=").append(mCode).append(", mLabel=").append(mLabel).append(", mFlagUrl=").append(mFlagUrl).append(", mLastTokensSync=").append(mLastTokensSync).append(", mLastWsSync=").append(mLastWsSync).append(", mFontCoeffAndroid=").append(mFontCoeffAndroid).append(", mSmartphoneFont=").append(mSmartphoneFont).append("]").toString();
        }


        public Language(String s, String s1, String s2, String s3, String s4, String s5, String s6)
        {
            mCode = s;
            mLabel = s1;
            mFlagUrl = s2;
            mLastTokensSync = s3;
            mLastWsSync = s4;
            mFontCoeffAndroid = s5;
            mSmartphoneFont = s6;
        }
    }


    private static final String CODE_LANG = "<lang>";
    private static final String KEY_LANG = "kayLang";
    private static final String NOM_SETTINGS_SHARED_PREFS = "TraductionSettings";
    private static final String TAG = "TraductionFactory";
    private static final int TIMEOUT_TRADUCTION = 30000;
    private static final String listMobileWsUrl = "http://traductions<variable>.akinator.com/languages/list/mobile";
    private static String mCodeLang = null;
    private static TraductionFactory msInstance = null;
    private static final String traductionWsUrl = "http://traductions<variable>.akinator.com/<lang>/traduction.php";
    private android.content.SharedPreferences.Editor editor;
    private Context mApplicationContext;
    private SharedPreferences settings;

    private TraductionFactory()
    {
        mApplicationContext = null;
        settings = null;
    }

    private boolean TokensMustBeRefreshed(Language language)
    {
label0:
        {
            if (language.getLastTokensSync() == null)
            {
                return true;
            }
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (language.getLastWsSync() == null)
            {
                break label0;
            }
            try
            {
                Date date = simpledateformat.parse(language.getLastWsSync());
                language = simpledateformat.parse(language.getLastTokensSync());
                AkLog.d("TraductionFactory", (new StringBuilder()).append("Last WS : ").append(date.toString()).append("  Last DB : ").append(language.toString()).toString());
                if (language.compareTo(date) >= 0)
                {
                    break label0;
                }
                AkLog.d("TraductionFactory", "TokensMustBeRefreshed");
            }
            // Misplaced declaration of an exception variable
            catch (Language language)
            {
                return true;
            }
            return true;
        }
        return false;
    }

    private int extractLanguageListFromXMLString(Document document, ArrayList arraylist)
    {
        document.getDocumentElement().normalize();
        document = document.getElementsByTagName("LANGUAGE");
        if (document == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        if (i >= document.getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        Node node = document.item(i);
        arraylist.add(new Language(((Element)((Element)node).getElementsByTagName("LANG_ID").item(0)).getTextContent(), ((Element)((Element)node).getElementsByTagName("LANG_LABEL").item(0)).getTextContent(), ((Element)((Element)node).getElementsByTagName("LANG_FLAG_URL").item(0)).getTextContent(), null, ((Element)((Element)node).getElementsByTagName("LANG_LAST_SYNC_DATE").item(0)).getTextContent(), ((Element)((Element)node).getElementsByTagName("LANG_FONT_COEF_ANDROID").item(0)).getTextContent(), ((Element)((Element)node).getElementsByTagName("LANG_SMARTPHONE_FONT").item(0)).getTextContent()));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        document = null;
        obj1 = null;
        Object obj = new AkDBAdapter(mApplicationContext);
        ((AkDBAdapter) (obj)).saveOrUpdateAllLanguages(arraylist);
        if (obj != null)
        {
            try
            {
                if (((AkDBAdapter) (obj)).isOpen())
                {
                    ((AkDBAdapter) (obj)).close();
                }
            }
            // Misplaced declaration of an exception variable
            catch (Document document)
            {
                document.printStackTrace();
            }
        }
        return 0;
        obj;
        arraylist = obj1;
_L8:
        document = arraylist;
        ((Exception) (obj)).printStackTrace();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        if (!arraylist.isOpen())
        {
            break MISSING_BLOCK_LABEL_256;
        }
        arraylist.close();
        break MISSING_BLOCK_LABEL_256;
        obj;
        arraylist = document;
        document = ((Document) (obj));
_L6:
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        if (arraylist.isOpen())
        {
            arraylist.close();
        }
        throw document;
_L2:
        AkLog.e("TraductionFactory", "LANGUAGE node not present");
        return 400;
        document;
        arraylist = ((ArrayList) (obj));
        if (true) goto _L6; else goto _L5
_L5:
        document;
        arraylist = ((ArrayList) (obj));
        obj = document;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int extractTokensAndUpdate(Document document, Language language)
    {
        NodeList nodelist;
        NodeList nodelist1;
        document.getDocumentElement().normalize();
        nodelist1 = document.getElementsByTagName("ELEMENT");
        if (nodelist1.getLength() == 0)
        {
            AkLog.e("TraductionFactory", "Token XML has no <ELMENT> node");
            return 100;
        }
        nodelist = null;
        document = new AkDBAdapter(mApplicationContext);
        int i = 0;
_L5:
        if (i >= nodelist1.getLength()) goto _L2; else goto _L1
_L1:
    /* block-local class not found */
    class Traduction {}

        Traduction traduction;
        nodelist = nodelist1.item(i).getChildNodes();
        traduction = new Traduction();
        traduction.setCode(mCodeLang);
        int j = 0;
_L7:
        if (j >= nodelist.getLength()) goto _L4; else goto _L3
_L3:
        Node node;
        node = nodelist.item(j);
        if (node.getNodeName().equals("MARQUEUR"))
        {
            traduction.setMarker(node.getTextContent());
            break MISSING_BLOCK_LABEL_251;
        }
        if (node.getNodeName().equals("LIBELLE"))
        {
            traduction.setLabel(node.getTextContent());
        }
        break MISSING_BLOCK_LABEL_251;
        language;
_L6:
        if (document != null && document.isOpen())
        {
            document.close();
        }
        throw language;
_L4:
        document.saveOneTraduction(traduction);
        i++;
          goto _L5
_L2:
        if (language == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        document.updateTokensDateSynchro(language);
        if (document != null && document.isOpen())
        {
            document.close();
        }
        return 0;
        language;
        document = nodelist;
          goto _L6
        j++;
          goto _L7
    }

    private String getTraductionFromDefaultFile(String s)
    {
        Object obj = mCodeLang;
        if (!mCodeLang.equals("en"))
        {
            obj = "en";
        }
        String s1 = s;
        Properties properties = new Properties();
        String s2 = s1;
        try
        {
            obj = mApplicationContext.getAssets().open((new StringBuilder()).append("tokens_").append(((String) (obj))).append(".properties").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return s2;
        }
        s2 = s1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s2 = s1;
        properties.load(((InputStream) (obj)));
        s2 = s1;
        s = properties.getProperty(s, s);
        s2 = s;
        ((InputStream) (obj)).close();
        s2 = s;
        return s2;
    }

    private void restoreLanguage()
    {
        settings = mApplicationContext.getSharedPreferences("TraductionSettings", 0);
        editor = settings.edit();
        if (settings != null)
        {
            mCodeLang = settings.getString("kayLang", null);
        }
    }

    private void saveLanguage()
    {
        settings = mApplicationContext.getSharedPreferences("TraductionSettings", 0);
        editor = settings.edit();
        if (editor != null)
        {
            editor.putString("kayLang", mCodeLang);
            editor.commit();
        }
    }

    public static TraductionFactory sharedInstance()
    {
        if (msInstance == null)
        {
            msInstance = new TraductionFactory();
        }
        return msInstance;
    }

    public int createTraductionFactory(ArrayList arraylist)
    {
        Object obj;
        while (mApplicationContext == null || arraylist == null) 
        {
            return 100;
        }
        obj = TestUrl.TryToConnectWithLoadBalancing("http://traductions<variable>.akinator.com/languages/list/mobile", 30000);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(((String) (obj)))));
        if (TestUrl.testNodeCompletion(((Document) (obj))) == 0)
        {
            return extractLanguageListFromXMLString(((Document) (obj)), arraylist);
        }
        obj = getListOfLanguages();
        if (((ArrayList) (obj)).size() != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        AkLog.e("TraductionFactory", "listOfLanguageModel vide");
        return 400;
        try
        {
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((Language)((Iterator) (obj)).next())) { }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
            return 400;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
            return 400;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
            return 400;
        }
        return 0;
        AkLog.e("TraductionFactory", "createTraductionFactory -> TryToConnectWithLoadBalancing return null XML");
        Object obj1 = getListOfLanguages();
        if (((ArrayList) (obj1)).size() == 0)
        {
            AkLog.e("TraductionFactory", "listOfLanguageModel vide");
            return 400;
        }
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); arraylist.add((Language)((Iterator) (obj1)).next())) { }
        return 0;
    }

    public String getApplicationLanguage()
    {
        return settings.getString("kayLang", null);
    }

    public ArrayList getListOfLanguages()
    {
        Object obj;
        new ArrayList();
        obj = null;
        Object obj1 = new AkDBAdapter(mApplicationContext);
        obj = ((AkDBAdapter) (obj1)).getAllLanguages();
        if (obj1 != null && ((AkDBAdapter) (obj1)).isOpen())
        {
            ((AkDBAdapter) (obj1)).close();
        }
        return ((ArrayList) (obj));
        obj1;
_L2:
        if (obj != null && ((AkDBAdapter) (obj)).isOpen())
        {
            ((AkDBAdapter) (obj)).close();
        }
        throw obj1;
        Exception exception;
        exception;
        obj = obj1;
        obj1 = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getTraductionFromToken(String s)
    {
        while (mApplicationContext == null || mCodeLang == null) 
        {
            return s;
        }
        Traduction traduction = (new AkDBAdapter(mApplicationContext)).getToken(mCodeLang, s);
        if (traduction == null)
        {
            return getTraductionFromDefaultFile(s);
        } else
        {
            return traduction.getLabel();
        }
    }

    public void init(Context context)
    {
        mApplicationContext = context;
        if (settings == null)
        {
            restoreLanguage();
        }
    }

    public int setApplicationLanguage(String s)
    {
        Object obj;
        mCodeLang = s;
        saveLanguage();
        obj = getListOfLanguages();
        if (((ArrayList) (obj)).size() == 0)
        {
            AkLog.e("TraductionFactory", "No language model in DB yet");
            return 100;
        }
        Object obj1 = null;
        Iterator iterator = ((ArrayList) (obj)).iterator();
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (Language)iterator.next();
        } while (!((Language) (obj)).mCode.equals(s));
        if (obj == null)
        {
            AkLog.e("TraductionFactory", "This language does not exist in DB");
            return 100;
        }
        if (!TokensMustBeRefreshed(((Language) (obj))))
        {
            break MISSING_BLOCK_LABEL_441;
        }
        s = TestUrl.TryToConnectWithLoadBalancing("http://traductions<variable>.akinator.com/<lang>/traduction.php".replace("<lang>", s), 30000);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        Exception exception;
        Properties properties;
        InputStream inputstream;
        ArrayList arraylist;
        try
        {
            s = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(s)));
            if (TestUrl.testNodeCompletion(s) == 0)
            {
                return extractTokensAndUpdate(s, ((Language) (obj)));
            }
            s = new AkDBAdapter(mApplicationContext);
            if (s.getTokensForOneLang(mCodeLang).size() != 0)
            {
                break MISSING_BLOCK_LABEL_392;
            }
            if (!mCodeLang.equals("en"))
            {
                break MISSING_BLOCK_LABEL_380;
            }
            properties = new Properties();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return 400;
        }
        inputstream = mApplicationContext.getAssets().open((new StringBuilder()).append("tokens_").append(mCodeLang).append(".properties").toString());
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        properties.load(inputstream);
        Enumeration enumeration = properties.propertyNames();
        arraylist = new ArrayList();
        do
        {
            String s1 = (String)enumeration.nextElement();
            Traduction traduction = new Traduction();
            traduction.setCode(mCodeLang);
            traduction.setMarker(s1);
            traduction.setLabel(properties.getProperty(s1));
            arraylist.add(traduction);
        } while (enumeration.hasMoreElements());
        inputstream.close();
        s.saveAllTokensForOneLang(arraylist);
        s.updateTokensDateSynchro(((Language) (obj)));
        if (s.isOpen())
        {
            s.close();
        }
        break MISSING_BLOCK_LABEL_443;
        exception;
        try
        {
            if (s.isOpen())
            {
                s.close();
            }
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return 400;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return 400;
        }
        s.printStackTrace();
        return 400;
        AkLog.e("TraductionFactory", "No translation files");
        return 420;
        AkLog.d("TraductionFactory", "utilisation des tokens enregistr\351 en bdd");
        return 0;
        AkLog.e("TraductionFactory", "setApplicationLanguage -> TryToConnectWithLoadBalancing returns a null XML");
        return 400;
        return 0;
        return 320;
    }

}
