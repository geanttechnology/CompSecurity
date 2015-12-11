// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import com.elokence.limuleapi.db.AkDBAdapter;
import com.elokence.limuleapi.utils.AkCryptoFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebServiceHandler, AkLog, AkMBAskChallengeWS, AkMBSignWS, 
//            AkMBSynchroWS, MinibaseListener, AkMBAddEntryWS, AkMBCreateWS, 
//            AkMBDeleteEntryWS, AkMBDeleteWS, Backuper, AkCancellingWS, 
//            SessionFactory, Session, AkMBModifyEntryWS, AkMBValidIdWS, 
//            AkWebservice

public class MinibaseFactory
    implements AkWebServiceHandler
{

    private static final String AK_CONFIG_MB_PRIVATE_KEY = "background_colors";
    private static final String AK_CONFIG_MB_SERVEUR_PUBKEY = "foreground_colors";
    private static final String AK_SETTING_MINIBASE_ID = "minibid";
    public static final int ERROR_MINIBASE_AUTH = 3;
    public static final int ERROR_MINIBASE_COMPLETION_WS_SYNCHRO = 4;
    public static final int ERROR_MINIBASE_DOES_NOT_EXISTS = 1;
    public static final int ERROR_MINIBASE_TECHNICAL = 2;
    public static final String NOM_SETTINGS_SHARED_PREFS = "MinibaseSettings";
    public static final String TAG = "AkinatorMinibase";
    public static final int WARNING_NEED_SYNCHRO = 10;
    private static MinibaseFactory instance = null;
    private String challenge;
    private Integer compteurMessageEntrant;
    private Integer compteurMessageSortant;
    private android.content.SharedPreferences.Editor editor;
    private boolean errorAuth;
    private boolean errorTech;
    private long lastKeepAlive;
    private Set listeners;
    private boolean loaded;
    private boolean loading;
    private Context mApplicationContext;
    private String mAuthChannel;
    private String mAuthSession;
    private String mAuthSignature;
    private Properties properties;
    private SharedPreferences settings;
    private String symKey;
    private ArrayList synchrosDuServeur;

    private MinibaseFactory()
    {
        settings = null;
        challenge = "";
        loaded = false;
        errorTech = false;
        errorAuth = false;
        loading = false;
        mAuthSession = "";
        mAuthSignature = "";
        mAuthChannel = "";
        compteurMessageSortant = Integer.valueOf(0);
        compteurMessageEntrant = Integer.valueOf(0);
        lastKeepAlive = 0L;
        synchrosDuServeur = new ArrayList();
        listeners = new CopyOnWriteArraySet();
        unload();
    }

    private void generateAESKey()
    {
        int j = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN1234567890".length();
        symKey = "";
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 32; i++)
        {
            symKey = (new StringBuilder()).append(symKey).append("azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN1234567890".charAt(random.nextInt(j))).toString();
        }

    }

    private void loadConfigFile()
    {
        AkLog.d("Akinator", "Load config file");
        Object obj = mApplicationContext.getResources().getAssets();
        try
        {
            obj = ((AssetManager) (obj)).open("config/config.properties");
            properties = new Properties();
            properties.load(((java.io.InputStream) (obj)));
            AkLog.d("Akinator", "The properties are now loaded");
            AkLog.d("Akinator", (new StringBuilder()).append("Properties: ").append(properties).toString());
            return;
        }
        catch (IOException ioexception)
        {
            AkLog.e("Akinator", (new StringBuilder()).append("Failed to open config property file ").append(ioexception.getClass()).toString());
            ioexception.printStackTrace();
            return;
        }
    }

    private int loadMinibaseInternal(boolean flag)
    {
        int i;
        if (loading)
        {
            signalLoading();
            i = 666;
        } else
        {
            setLoading();
            signalLoading();
            if (getMinibid() < 0)
            {
                signalLoadError(1);
                setNotLoaded();
                return 400;
            }
            Object obj = new AkMBAskChallengeWS(getDigest(), flag);
            i = ((AkMBAskChallengeWS) (obj)).call();
            if (i == 0)
            {
                if (((AkMBAskChallengeWS) (obj)).isAlreadyAuth())
                {
                    AkLog.d("AkinatorMinibase", "Ask challenge keepAlive OK");
                    setLoaded();
                    lastKeepAlive = System.currentTimeMillis();
                    signalLoadComplete();
                    return i;
                }
                AkLog.d("AkinatorMinibase", "Ask challenge completed");
                mAuthChannel = ((AkMBAskChallengeWS) (obj)).getChn();
                mAuthSession = ((AkMBAskChallengeWS) (obj)).getSess();
                mAuthSignature = ((AkMBAskChallengeWS) (obj)).getSign();
                challenge = ((AkMBAskChallengeWS) (obj)).getChallenge();
                compteurMessageEntrant = Integer.valueOf(0);
                compteurMessageSortant = Integer.valueOf(0);
                obj = new AkMBSignWS();
                int j = ((AkMBSignWS) (obj)).call();
                i = j;
                if (j == 0)
                {
                    AkLog.d("AkinatorMinibase", "Sign completed");
                    setLoaded();
                    lastKeepAlive = System.currentTimeMillis();
                    signalLoadComplete();
                    if (((AkMBSignWS) (obj)).getResynchro())
                    {
                        AkLog.d("AkinatorMinibase", "Resynchro needed");
                        synchrosDuServeur.clear();
                        Pair pair;
                        for (obj = ((AkMBSignWS) (obj)).getRetourSync().iterator(); ((Iterator) (obj)).hasNext(); synchrosDuServeur.add(pair.first))
                        {
                            pair = (Pair)((Iterator) (obj)).next();
                            Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase = new Session.ProposedLimuleObjectMinibase();
                            proposedlimuleobjectminibase.setElementMinibaseId(((Integer)pair.first).intValue());
                            proposedlimuleobjectminibase.setName((String)pair.second);
                            addOrModifyMBCharacter(proposedlimuleobjectminibase);
                            AkLog.d("AkinatorMinibase", (new StringBuilder()).append("Synchro : ajoute ").append(pair.first).toString());
                        }

                        if (!synchrosDuServeur.isEmpty())
                        {
                            i = (new AkMBSynchroWS()).call();
                            if (i == 0)
                            {
                                AkLog.d("AkinatorMinibase", "Resynchro completed");
                                return 0;
                            } else
                            {
                                signalLoadError(4);
                                return i;
                            }
                        }
                        signalSynchro();
                    }
                    i = j;
                    if (true)
                    {
                        return 0;
                    }
                }
            } else
            {
                signalLoadError(3);
                return i;
            }
        }
        return i;
    }

    private String random10Chars()
    {
        int j = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN1234567890".length();
        Random random = new Random(System.currentTimeMillis());
        char ac[] = new char[10];
        for (int i = 0; i < ac.length; i++)
        {
            ac[i] = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN1234567890".charAt(random.nextInt(j));
        }

        return new String(ac);
    }

    private void setErrorAuth()
    {
        errorAuth = true;
        loaded = false;
        errorTech = false;
        loading = false;
    }

    private void setErrorTech()
    {
        errorTech = true;
        loaded = false;
        errorAuth = false;
        loading = false;
    }

    private void setLoaded()
    {
        loaded = true;
        errorTech = false;
        errorAuth = false;
        loading = false;
    }

    private void setLoading()
    {
        loading = true;
        errorTech = false;
        errorAuth = false;
        loaded = false;
    }

    private void setNotLoaded()
    {
        errorTech = false;
        errorAuth = false;
        loaded = false;
        loading = false;
    }

    public static MinibaseFactory sharedInstance()
    {
        if (instance == null)
        {
            instance = new MinibaseFactory();
        }
        return instance;
    }

    private void signalChanged()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((MinibaseListener)iterator.next()).contentChanged()) { }
    }

    private void signalLoadComplete()
    {
        loaded = true;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((MinibaseListener)iterator.next()).loadingComplete()) { }
    }

    private void signalLoadError(int i)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((MinibaseListener)iterator.next()).errorLoading(i)) { }
    }

    private void signalLoading()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((MinibaseListener)iterator.next()).isLoading()) { }
    }

    private void signalSynchro()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((MinibaseListener)iterator.next()).resynchronized()) { }
    }

    public int addCharacterToMinibase(String s, Bitmap bitmap)
    {
        if (s == null || s.equals(""))
        {
            return 100;
        } else
        {
            return (new AkMBAddEntryWS(s, bitmap)).call();
        }
    }

    public void addOrModifyCharacterInLocalDB(Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        if (proposedlimuleobjectminibase.getElementMinibaseId() != -1) goto _L2; else goto _L1
_L1:
        AkLog.e("AkinatorMBFactoy", (new StringBuilder()).append("SET CHARACTER INCORRECT ID = ").append(proposedlimuleobjectminibase.getElementMinibaseId()).toString());
_L4:
        return;
_L2:
        Object obj;
        Object obj2;
        obj = null;
        obj2 = null;
        Object obj1 = new AkDBAdapter(mApplicationContext);
        ((AkDBAdapter) (obj1)).updateMinibaseCharacterToDB(proposedlimuleobjectminibase);
        Exception exception;
        if (obj1 != null)
        {
            ((AkDBAdapter) (obj1)).close();
            return;
        } else
        {
            return;
        }
        obj1;
        proposedlimuleobjectminibase = obj2;
_L7:
        obj = proposedlimuleobjectminibase;
        ((Exception) (obj1)).printStackTrace();
        if (proposedlimuleobjectminibase == null) goto _L4; else goto _L3
_L3:
        proposedlimuleobjectminibase.close();
        return;
        proposedlimuleobjectminibase;
_L6:
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
        throw proposedlimuleobjectminibase;
        proposedlimuleobjectminibase;
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        proposedlimuleobjectminibase = ((Session.ProposedLimuleObjectMinibase) (obj1));
        obj1 = exception;
          goto _L7
    }

    public void addOrModifyMBCharacter(Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        if (proposedlimuleobjectminibase.getElementMinibaseId() != -1) goto _L2; else goto _L1
_L1:
        AkLog.e("AkinatorMinibase", (new StringBuilder()).append("SET CHARACTER INCORRECT ID = ").append(proposedlimuleobjectminibase.getElementMinibaseId()).toString());
_L4:
        return;
_L2:
        Object obj;
        Object obj2;
        obj = null;
        obj2 = null;
        Object obj1 = new AkDBAdapter(mApplicationContext);
        ((AkDBAdapter) (obj1)).updateMinibaseCharacterToDB(proposedlimuleobjectminibase);
        Exception exception;
        if (obj1 != null)
        {
            ((AkDBAdapter) (obj1)).close();
            return;
        } else
        {
            return;
        }
        obj1;
        proposedlimuleobjectminibase = obj2;
_L7:
        obj = proposedlimuleobjectminibase;
        ((Exception) (obj1)).printStackTrace();
        if (proposedlimuleobjectminibase == null) goto _L4; else goto _L3
_L3:
        proposedlimuleobjectminibase.close();
        return;
        proposedlimuleobjectminibase;
_L6:
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
        throw proposedlimuleobjectminibase;
        proposedlimuleobjectminibase;
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        proposedlimuleobjectminibase = ((Session.ProposedLimuleObjectMinibase) (obj1));
        obj1 = exception;
          goto _L7
    }

    public void addUnJoue(Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        AkDBAdapter akdbadapter;
        proposedlimuleobjectminibase.setNbPlayed(proposedlimuleobjectminibase.getNbPlayed() + 1);
        AkDBAdapter akdbadapter1 = new AkDBAdapter(mApplicationContext);
        try
        {
            akdbadapter = new AkDBAdapter(mApplicationContext);
        }
        // Misplaced declaration of an exception variable
        catch (Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
        {
            proposedlimuleobjectminibase = akdbadapter1;
            continue; /* Loop/switch isn't completed */
        }
        akdbadapter.updateMinibaseCharacterToDB(proposedlimuleobjectminibase);
        proposedlimuleobjectminibase = akdbadapter;
_L2:
        proposedlimuleobjectminibase.close();
        return;
        proposedlimuleobjectminibase;
        proposedlimuleobjectminibase = akdbadapter;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int createMiniBase(String s, Bitmap bitmap)
    {
        if (s == null || s.equals(""))
        {
            return 100;
        } else
        {
            return (new AkMBCreateWS(s, bitmap)).call();
        }
    }

    public String decrypteEtDessaleNom(String s)
    {
        s = AkCryptoFactory.decryptAES(s, symKey);
        try
        {
            s = s.split("\\*");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AkLog.e("AkinatorMinibase", "ERREUR DECRYPTAGE NOM");
            return null;
        }
        compteurMessageEntrant = Integer.valueOf(Integer.parseInt(s[1]));
        return s[2];
    }

    public int eraseCharacterFromMinibase(int i)
    {
        if (i == -1)
        {
            return 100;
        } else
        {
            return (new AkMBDeleteEntryWS(this, i)).call();
        }
    }

    public int eraseMinibase()
    {
        int i = (new AkMBDeleteWS()).call();
        Object obj = getAllCharacters().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (Session.ProposedLimuleObjectMinibase)((Iterator) (obj)).next();
            if (getMBCharacterPicture(mApplicationContext, ((Session.ProposedLimuleObjectMinibase) (obj1))) != null)
            {
                obj1 = new File(mApplicationContext.getFilesDir(), (new StringBuilder()).append("MB").append(((Session.ProposedLimuleObjectMinibase) (obj1)).getElementMinibaseId()).append(".png").toString());
                if (((File) (obj1)).delete())
                {
                    AkLog.d("AkinatorMinibase", (new StringBuilder()).append("erase ").append(((File) (obj1)).toString()).toString());
                }
            }
        } while (true);
        obj = new AkDBAdapter(mApplicationContext);
        ((AkDBAdapter) (obj)).resetAllMinibaseCharacters();
        ((AkDBAdapter) (obj)).close();
        setMinibid(-1);
        Backuper.saveBackup(mApplicationContext);
        setNotLoaded();
        signalChanged();
        return i;
    }

    public String getAESKey()
    {
        return symKey;
    }

    public ArrayList getAllCharacters()
    {
        return getAllCharacters(false);
    }

    public ArrayList getAllCharacters(boolean flag)
    {
        AkDBAdapter akdbadapter = new AkDBAdapter(mApplicationContext);
        ArrayList arraylist = akdbadapter.getAllMBCharacters();
        for (int i = 0; i < arraylist.size(); i++)
        {
            Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase = (Session.ProposedLimuleObjectMinibase)arraylist.get(i);
            getMBCharacterPicture(mApplicationContext, proposedlimuleobjectminibase);
        }

        akdbadapter.close();
        if (flag)
        {
            Collections.sort(arraylist, new _cls1());
        }
        return arraylist;
    }

    public ArrayList getAllNonSynchroCharacters()
    {
        Object obj = "";
        for (int i = 0; i < synchrosDuServeur.size(); i++)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append("").append(synchrosDuServeur.get(i)).append(" ").toString();
        }

        obj = new AkDBAdapter(mApplicationContext);
        ArrayList arraylist = ((AkDBAdapter) (obj)).getAllMBCharacters();
        ((AkDBAdapter) (obj)).close();
        int k;
        for (int j = 0; j < arraylist.size(); j = k + 1)
        {
            int l = ((Session.ProposedLimuleObjectMinibase)arraylist.get(j)).getElementMinibaseId();
            k = j;
            if (synchrosDuServeur.contains(Integer.valueOf(l)))
            {
                arraylist.remove(j);
                k = j - 1;
            }
        }

        return arraylist;
    }

    public String getChallenge()
    {
        return challenge;
    }

    public String getChannel()
    {
        return mAuthChannel;
    }

    public Session.ProposedLimuleObjectMinibase getCharacter(int i)
    {
label0:
        {
            Object obj = null;
            Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase = new Session.ProposedLimuleObjectMinibase();
            proposedlimuleobjectminibase.setElementMinibaseId(i);
            AkDBAdapter akdbadapter;
            try
            {
                akdbadapter = new AkDBAdapter(mApplicationContext);
            }
            catch (Exception exception)
            {
                exception = obj;
                if (false)
                {
                } else
                {
                    break label0;
                }
            }
            try
            {
                akdbadapter.updateMinibaseCharacterFromDB(proposedlimuleobjectminibase);
                getMBCharacterPicture(mApplicationContext, proposedlimuleobjectminibase);
            }
            catch (Exception exception1) { }
        }
        if (akdbadapter != null)
        {
            akdbadapter.close();
        }
        return proposedlimuleobjectminibase;
    }

    public String getDigest()
    {
        ArrayList arraylist = getAllCharacters();
        String s = "";
        for (int i = 0; i < arraylist.size(); i++)
        {
            s = (new StringBuilder()).append(s).append(((Session.ProposedLimuleObjectMinibase)arraylist.get(i)).getElementMinibaseId()).append(((Session.ProposedLimuleObjectMinibase)arraylist.get(i)).getName()).toString();
            AkLog.d("AkinatorMinibase", (new StringBuilder()).append("Digest : element ").append(i).append(" : ").append(((Session.ProposedLimuleObjectMinibase)arraylist.get(i)).getElementMinibaseId()).append(" ").append(((Session.ProposedLimuleObjectMinibase)arraylist.get(i)).getName()).toString());
        }

        AkLog.d("AkinatorMinibase", (new StringBuilder()).append("Digest = md5 de : ").append(s).toString());
        return md5(s);
    }

    public long getLastKeepAlive()
    {
        return lastKeepAlive;
    }

    public Bitmap getMBCharacterPicture(Context context, Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        try
        {
            context = BitmapFactory.decodeStream(context.openFileInput((new StringBuilder()).append("MB").append(proposedlimuleobjectminibase.getElementMinibaseId()).append(".png").toString()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public String getMBPrivateKey()
    {
        return settings.getString("background_colors", null);
    }

    public int getMinibid()
    {
        return settings.getInt("minibid", -1);
    }

    public String getServerPublicKey()
    {
        return properties.getProperty("foreground_colors");
    }

    public String getSession()
    {
        return mAuthSession;
    }

    public String getSignature()
    {
        return mAuthSignature;
    }

    public void handleWSCallCompleted(AkWebservice akwebservice)
    {
        lastKeepAlive = System.currentTimeMillis();
        if (!(akwebservice instanceof AkMBDeleteEntryWS)) goto _L2; else goto _L1
_L1:
        AkLog.d("AkinatorMinibase", "Delete entry completed");
        Object obj = (AkMBDeleteEntryWS)akwebservice;
        akwebservice = new Session.ProposedLimuleObjectMinibase();
        akwebservice.setElementMinibaseId(((AkMBDeleteEntryWS) (obj)).getRelativeId());
        akwebservice.setName("");
        if (getMBCharacterPicture(mApplicationContext, akwebservice) != null)
        {
            obj = new File(mApplicationContext.getFilesDir(), (new StringBuilder()).append("MB").append(((AkMBDeleteEntryWS) (obj)).getRelativeId()).append(".png").toString());
            if (((File) (obj)).delete())
            {
                AkLog.d("AkinatorMinibase", (new StringBuilder()).append("erase ").append(((File) (obj)).toString()).toString());
            }
        }
        obj = new AkDBAdapter(mApplicationContext);
        ((AkDBAdapter) (obj)).eraseMinibaseCharacter(akwebservice);
        ((AkDBAdapter) (obj)).close();
        signalChanged();
_L4:
        return;
_L2:
        if (akwebservice instanceof AkMBDeleteWS)
        {
            AkLog.d("AkinatorMinibase", "Delete database completed");
            return;
        }
        if (akwebservice instanceof AkCancellingWS)
        {
            AkLog.d("AkinatorMinibase", "Session correctly ended");
            mAuthSignature = "";
            mAuthSession = "";
            mAuthChannel = "";
            return;
        }
        if (!(akwebservice instanceof AkMBCreateWS))
        {
            break; /* Loop/switch isn't completed */
        }
        akwebservice = (AkMBCreateWS)akwebservice;
        setMinibid(akwebservice.getMinibaseId());
        Backuper.saveBackup(mApplicationContext);
        Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase = new Session.ProposedLimuleObjectMinibase();
        proposedlimuleobjectminibase.setElementMinibaseId(akwebservice.getRelativeId());
        proposedlimuleobjectminibase.setName(akwebservice.getFirstCharacterName());
        addOrModifyCharacterInLocalDB(proposedlimuleobjectminibase);
        SessionFactory.sharedInstance().getSession().updateObjectProposedWithMinibaseParam(akwebservice.getFirstCharacterName(), akwebservice.getRelativeId());
        if (akwebservice.getImage() != null)
        {
            writePictureToMemory(mApplicationContext, proposedlimuleobjectminibase, akwebservice.getImage());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!(akwebservice instanceof AkMBAddEntryWS))
        {
            continue; /* Loop/switch isn't completed */
        }
        akwebservice = (AkMBAddEntryWS)akwebservice;
        Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase1 = new Session.ProposedLimuleObjectMinibase();
        proposedlimuleobjectminibase1.setName(akwebservice.getName());
        proposedlimuleobjectminibase1.setElementMinibaseId(akwebservice.getRelativeId());
        SessionFactory.sharedInstance().getSession().updateObjectProposedWithMinibaseParam(akwebservice.getName(), akwebservice.getRelativeId());
        addOrModifyCharacterInLocalDB(proposedlimuleobjectminibase1);
        if (akwebservice.getImage() != null)
        {
            writePictureToMemory(mApplicationContext, proposedlimuleobjectminibase1, akwebservice.getImage());
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!(akwebservice instanceof AkMBModifyEntryWS)) goto _L4; else goto _L5
_L5:
        akwebservice = (AkMBModifyEntryWS)akwebservice;
        Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase2 = new Session.ProposedLimuleObjectMinibase();
        proposedlimuleobjectminibase2.setName(akwebservice.getName());
        proposedlimuleobjectminibase2.setElementMinibaseId(akwebservice.getRelativeId());
        addOrModifyCharacterInLocalDB(proposedlimuleobjectminibase2);
        if (akwebservice.getImage() != null)
        {
            writePictureToMemory(mApplicationContext, proposedlimuleobjectminibase2, akwebservice.getImage());
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public boolean hasError()
    {
        return hasErrorTech() || hasErrorAuth();
    }

    public boolean hasErrorAuth()
    {
        return errorAuth;
    }

    public boolean hasErrorTech()
    {
        return errorTech;
    }

    public boolean hasMinibid()
    {
        return getMinibid() != -1;
    }

    public void init(Context context)
    {
        mApplicationContext = context;
        if (settings == null)
        {
            settings = mApplicationContext.getSharedPreferences("MinibaseSettings", 0);
            editor = settings.edit();
            if (properties == null)
            {
                loadConfigFile();
            }
            if (symKey == null)
            {
                generateAESKey();
            }
        }
    }

    public boolean isLoaded()
    {
        return loaded;
    }

    public void keepAlive()
    {
        if (System.currentTimeMillis() > lastKeepAlive + 0x2bf20L)
        {
            loadMinibase(false);
        }
    }

    public int loadMinibase(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i = loadMinibaseInternal(flag);
        if (i == 0 || i == 666)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        setNotLoaded();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void localErase(Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase)
    {
        AkDBAdapter akdbadapter = new AkDBAdapter(mApplicationContext);
        akdbadapter.eraseMinibaseCharacter(proposedlimuleobjectminibase);
        akdbadapter.close();
        signalChanged();
    }

    public String md5(String s)
    {
        String s1;
        byte abyte0[];
        StringBuilder stringbuilder;
        int i;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes("UTF-8"));
            abyte0 = messagedigest.digest();
            stringbuilder = new StringBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AkLog.e("AkinatorMinibase", (new StringBuilder()).append("Erreur dans le digest : ").append(s).toString());
            return "";
        }
        i = 0;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = Integer.toHexString(abyte0[i] & 0xff);
        s = s1;
        if (s1.length() != 2)
        {
            s = (new StringBuilder()).append("0").append(s1).toString();
        }
        stringbuilder.append(s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_35;
_L1:
        s = stringbuilder.toString();
        return s;
    }

    public int modifyCharacterMinibase(int i, String s, Bitmap bitmap)
    {
        if (i == -1 || s == null || s.equals(""))
        {
            return 100;
        } else
        {
            return (new AkMBModifyEntryWS(i, s, bitmap)).call();
        }
    }

    public void reinitCompteurs()
    {
        compteurMessageEntrant = Integer.valueOf(0);
        compteurMessageSortant = Integer.valueOf(0);
    }

    public String saleEtCrypteCompteur()
    {
        String s;
        synchronized (compteurMessageSortant)
        {
            s = (new StringBuilder()).append("Akinator*").append(compteurMessageSortant).append("*").append(random10Chars()).toString();
            Integer integer1 = compteurMessageSortant;
            compteurMessageSortant = Integer.valueOf(compteurMessageSortant.intValue() + 1);
            s = AkCryptoFactory.encryptAES(s, symKey);
        }
        return s;
        exception;
        integer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String saleEtCrypteNom(String s)
    {
        synchronized (compteurMessageSortant)
        {
            s = AkCryptoFactory.encryptAES((new StringBuilder()).append("Akinator*").append(compteurMessageSortant).append("*").append(s).append("*").append(random10Chars()).toString(), symKey);
            Integer integer1 = compteurMessageSortant;
            compteurMessageSortant = Integer.valueOf(compteurMessageSortant.intValue() + 1);
        }
        return s;
        s;
        integer;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setMBPrivateKey(String s)
    {
        editor.putString("background_colors", s);
        editor.commit();
    }

    public void setMinibid(int i)
    {
        editor.putInt("minibid", i);
        editor.commit();
    }

    public void subscribe(MinibaseListener minibaselistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.add(minibaselistener);
        this;
        JVM INSTR monitorexit ;
        return;
        minibaselistener;
        throw minibaselistener;
    }

    public void unload()
    {
        setNotLoaded();
    }

    public void unsubscribe(MinibaseListener minibaselistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.remove(minibaselistener);
        this;
        JVM INSTR monitorexit ;
        return;
        minibaselistener;
        throw minibaselistener;
    }

    public int validateMBCharacter(int i)
    {
        int j;
        if (i == -1)
        {
            j = 100;
        } else
        {
            int k = (new AkMBValidIdWS(i)).call();
            j = k;
            if (k == 0)
            {
                SessionFactory.sharedInstance().getSession().setActive(false);
                SessionFactory.sharedInstance().getSession().updateObjectProposed(getCharacter(i), -1);
                return k;
            }
        }
        return j;
    }

    public void writePictureToMemory(Context context, int i, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        }
        try
        {
            AkLog.w("AkinatorMinibase", "Ecriture de l'image MB commenc\351e");
            String s = (new StringBuilder()).append("MB").append(i).append(".png").toString();
            java.io.FileOutputStream fileoutputstream = context.openFileOutput(s, 0);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileoutputstream);
            context = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/").append(s).toString();
            AkLog.w("AkinatorMinibase", (new StringBuilder()).append("Ecriture de l'image MB terminee(").append(context).append(")").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        context.printStackTrace();
    }

    public void writePictureToMemory(Context context, Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        }
        try
        {
            AkLog.w("AkinatorMinibase", "Ecriture de l'image MB commenc\351e");
            proposedlimuleobjectminibase = (new StringBuilder()).append("MB").append(proposedlimuleobjectminibase.getElementMinibaseId()).append(".png").toString();
            java.io.FileOutputStream fileoutputstream = context.openFileOutput(proposedlimuleobjectminibase, 0);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileoutputstream);
            context = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/").append(proposedlimuleobjectminibase).toString();
            AkLog.w("AkinatorMinibase", (new StringBuilder()).append("Ecriture de l'image MB terminee(").append(context).append(")").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        context.printStackTrace();
    }


    /* member class not found */
    class _cls1 {}

}
