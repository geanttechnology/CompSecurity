// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.os.SystemClock;
import android.util.Log;
import dbb;
import evc;
import ewo;
import eyn;
import f;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Preferences, LocaleResources, Greco3Mode, Greco3ResourceManager, 
//            Greco3DataManager, EndpointerModelCopier, Greco3Recognizer, Greco3Grammar, 
//            Greco3Callback, GrecoEventLogger

public class Greco3EngineManager
    implements Greco3DataManager.PathDeleter
{

    private static final boolean DEBUG = false;
    private static final String TAG = "VS.G3EngineManager";
    private Future mCurrentRecognition;
    private Greco3Recognizer mCurrentRecognizer;
    private final EndpointerModelCopier mEndpointerModelCopier;
    private final Greco3DataManager mGreco3DataManager;
    private final Greco3Preferences mGreco3Preferences;
    private boolean mInitialized;
    private final ExecutorService mRecognitionExecutor = a.a("Greco3Thread", true);
    private final HashMap mResourcesByMode = new HashMap();

    public Greco3EngineManager(Greco3DataManager greco3datamanager, Greco3Preferences greco3preferences, EndpointerModelCopier endpointermodelcopier)
    {
        mGreco3DataManager = greco3datamanager;
        mGreco3Preferences = greco3preferences;
        mEndpointerModelCopier = endpointermodelcopier;
    }

    private static evc buildLanguagePackLog(eyn eyn1)
    {
        return (new evc()).a(eyn1.a).b(String.valueOf(eyn1.b));
    }

    private static void deleteSingleLevelTree(File file)
    {
        if (file.exists())
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                for (int i = 0; i < j; i++)
                {
                    File file1 = afile[i];
                    if (!file1.delete())
                    {
                        Log.e("VS.G3EngineManager", (new StringBuilder("Error deleting resource file: ")).append(file1.getAbsolutePath()).toString());
                    }
                }

            }
            if (!file.delete())
            {
                Log.e("VS.G3EngineManager", (new StringBuilder("Error deleting directory: ")).append(file.getAbsolutePath()).toString());
            }
        }
    }

    private void doResourceDelete(File file, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isUsedLocked(file))
        {
            break MISSING_BLOCK_LABEL_18;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        releaseAllResourcesLocked();
        deleteSingleLevelTree(file);
        this;
        JVM INSTR monitorexit ;
        return;
        file;
        throw file;
    }

    private String getCompiledGrammarPath(Greco3Grammar greco3grammar, LocaleResources localeresources)
    {
        if (greco3grammar != null && mGreco3Preferences != null)
        {
            return localeresources.getGrammarPath(greco3grammar, mGreco3Preferences.getCompiledGrammarRevisionId(greco3grammar));
        } else
        {
            return null;
        }
    }

    private Resources getResourcesInternal(String s, Greco3Mode greco3mode, Greco3Grammar greco3grammar)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        Resources resources;
        boolean flag;
        if (greco3mode == Greco3Mode.GRAMMAR && greco3grammar == null)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        f.a(flag);
        if (mCurrentRecognition == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f.b(flag);
        resources = (Resources)mResourcesByMode.get(greco3mode);
        if (resources == null) goto _L2; else goto _L1
_L1:
        flag = resources.isEquivalentTo(s, greco3grammar, greco3mode);
        if (!flag) goto _L4; else goto _L3
_L3:
        s = resources;
_L6:
        this;
        JVM INSTR monitorexit ;
        return s;
_L4:
        resources.resources.delete();
        mResourcesByMode.remove(greco3mode);
_L2:
        greco3grammar = loadResourcesFor(s, greco3mode, greco3grammar);
        s = greco3grammar;
        if (greco3grammar != null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        s = greco3grammar;
        if (greco3mode.isEndpointerMode())
        {
            s = loadResourcesFor("en-US", greco3mode, null);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        mResourcesByMode.put(greco3mode, s);
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean isUsedLocked(File file)
    {
        file = file.getAbsolutePath();
        for (Iterator iterator = mResourcesByMode.values().iterator(); iterator.hasNext();)
        {
            String as[] = ((Resources)iterator.next()).paths;
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                if (file.equals(as[i]))
                {
                    return true;
                }
                i++;
            }
        }

        return false;
    }

    private Resources loadResourcesFor(String s, Greco3Mode greco3mode, Greco3Grammar greco3grammar)
    {
        LocaleResources localeresources = mGreco3DataManager.getResources(s);
        if (localeresources != null) goto _L2; else goto _L1
_L1:
        String s2;
        return null;
_L2:
        if ((s2 = localeresources.getConfigFile(greco3mode)) == null) goto _L4; else goto _L3
_L3:
        String s3;
        s3 = localeresources.getResourcePath();
        if (s3 == null)
        {
            Log.e("VS.G3EngineManager", (new StringBuilder("No data for locale: ")).append(s).toString());
            return null;
        }
        if (greco3mode != Greco3Mode.GRAMMAR) goto _L6; else goto _L5
_L5:
        Object obj;
        String s1;
        s1 = getCompiledGrammarPath(greco3grammar, localeresources);
        obj = s1;
        if (s1 != null) goto _L8; else goto _L7
_L7:
        if (greco3mode == Greco3Mode.GRAMMAR) goto _L4; else goto _L9
_L9:
        obj = s1;
_L8:
        dbb dbb1 = new dbb();
        dbb1.a = SystemClock.elapsedRealtime();
        Greco3ResourceManager greco3resourcemanager;
        if (obj != null)
        {
            String as[] = new String[2];
            as[0] = s3;
            as[1] = ((String) (obj));
            obj = as;
        } else
        {
            obj = new String[1];
            obj[0] = s3;
        }
        (new StringBuilder("create_rm: m=")).append(greco3mode).append(",l=").append(s);
        greco3resourcemanager = Greco3ResourceManager.create(s2, ((String []) (obj)));
        if (greco3resourcemanager != null)
        {
            (new StringBuilder("Brought up new g3 instance :")).append(s2).append(" for: ").append(s).append("in: ").append((int)(SystemClock.elapsedRealtime() - dbb1.a)).append(" ms");
            return new Resources(greco3resourcemanager, localeresources.getConfigFile(greco3mode), s, greco3grammar, greco3mode, ((String []) (obj)), localeresources.getLanguageMetadata());
        }
_L4:
        if (true) goto _L1; else goto _L6
_L6:
        obj = null;
          goto _L8
    }

    private void releaseAllResourcesLocked()
    {
        if (mCurrentRecognizer != null)
        {
            Log.w("VS.G3EngineManager", "Terminating active recognition for shutdown.");
            release(mCurrentRecognizer);
        }
        for (Iterator iterator = mResourcesByMode.values().iterator(); iterator.hasNext(); ((Resources)iterator.next()).resources.delete()) { }
        mResourcesByMode.clear();
    }

    public void delete(File file, boolean flag, Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mInitialized || flag)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        mRecognitionExecutor.execute(new _cls2(flag, runnable));
        return;
        file;
        this;
        JVM INSTR monitorexit ;
        throw file;
    }

    public Resources getResources(String s, Greco3Mode greco3mode, Greco3Grammar greco3grammar)
    {
        return getResourcesInternal(s, greco3mode, greco3grammar);
    }

    public void maybeInitialize()
    {
        this;
        JVM INSTR monitorenter ;
        if (!mInitialized)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        mGreco3DataManager.blockingUpdateResources(false);
        if (mEndpointerModelCopier != null && mEndpointerModelCopier.copyEndpointerModels(mGreco3DataManager.getModelsDirSupplier(), mGreco3DataManager))
        {
            mGreco3DataManager.blockingUpdateResources(true);
        }
        this;
        JVM INSTR monitorenter ;
        mInitialized = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void release(Greco3Recognizer greco3recognizer)
    {
        boolean flag1 = true;
        boolean flag;
        if (mCurrentRecognition != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (greco3recognizer == mCurrentRecognizer)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f.b(flag);
        greco3recognizer.cancel();
        try
        {
            mCurrentRecognition.get();
        }
        // Misplaced declaration of an exception variable
        catch (Greco3Recognizer greco3recognizer)
        {
            Thread.currentThread().interrupt();
            Log.e("VS.G3EngineManager", "Interrupted waiting for recognition to complete.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Greco3Recognizer greco3recognizer)
        {
            Log.e("VS.G3EngineManager", (new StringBuilder("Exception while running recognition: ")).append(greco3recognizer).toString());
        }
        mCurrentRecognizer.delete();
        mCurrentRecognition = null;
        mCurrentRecognizer = null;
    }

    public void startRecognition(final Greco3Recognizer recognizer, InputStream inputstream, Greco3Callback greco3callback, final ewo recParams, final GrecoEventLogger eventLogger, final eyn languagePack)
    {
        boolean flag;
        if (mCurrentRecognition == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        recognizer.setAudioReader(inputstream);
        recognizer.setSamplingRate((int)recParams.a);
        recognizer.setCallback(greco3callback);
        mCurrentRecognition = mRecognitionExecutor.submit(new _cls1());
        mCurrentRecognizer = recognizer;
    }



    private class Resources
    {

        final String configFile;
        final Greco3Grammar grammarType;
        final eyn languagePack;
        final String locale;
        final Greco3Mode mode;
        final String paths[];
        final Greco3ResourceManager resources;

        public boolean equals(Object obj)
        {
            if (obj instanceof Resources)
            {
                if (locale.equals(((Resources) (obj = (Resources)obj)).locale) && mode == ((Resources) (obj)).mode && mode == Greco3Mode.GRAMMAR && grammarType == ((Resources) (obj)).grammarType)
                {
                    return true;
                }
            }
            return false;
        }

        boolean isEquivalentTo(String s, Greco3Grammar greco3grammar, Greco3Mode greco3mode)
        {
            return s.equals(locale) && greco3mode == mode && (greco3mode != Greco3Mode.GRAMMAR || greco3grammar == grammarType);
        }

        Resources(Greco3ResourceManager greco3resourcemanager, String s, String s1, Greco3Grammar greco3grammar, Greco3Mode greco3mode, String as[], eyn eyn1)
        {
            resources = greco3resourcemanager;
            configFile = s;
            locale = s1;
            grammarType = greco3grammar;
            mode = greco3mode;
            paths = as;
            languagePack = eyn1;
        }
    }


    private class _cls2 extends dav
    {

        final Greco3EngineManager this$0;
        final Runnable val$completionCb;
        final boolean val$force;
        final File val$path;

        public void run()
        {
            doResourceDelete(path, force);
            if (completionCb != null)
            {
                completionCb.run();
            }
        }

        transient _cls2(boolean flag, Runnable runnable)
        {
            this$0 = Greco3EngineManager.this;
            path = file;
            force = flag;
            completionCb = runnable;
            super(final_s, final_ai);
        }
    }


    private class _cls1
        implements Callable
    {

        final Greco3EngineManager this$0;
        final GrecoEventLogger val$eventLogger;
        final eyn val$languagePack;
        final ewo val$recParams;
        final Greco3Recognizer val$recognizer;

        public Greco3Recognizer call()
        {
            if (eventLogger != null)
            {
                eventLogger.recognitionStarted();
            }
            Object obj = recognizer.run(recParams);
            int i = ((ewe) (obj)).a;
            if (i != 0 && i != 4)
            {
                Log.e("VS.G3EngineManager", (new StringBuilder("Error running recognition: ")).append(i).toString());
            }
            if (eventLogger != null)
            {
                obj = ((ewe) (obj)).b;
                ((evg) (obj)).a(Greco3EngineManager.buildLanguagePackLog(languagePack));
                ((evg) (obj)).a(languagePack.a);
                eventLogger.recognitionCompleted(((evg) (obj)));
            }
            return recognizer;
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = Greco3EngineManager.this;
            eventLogger = grecoeventlogger;
            recognizer = greco3recognizer;
            recParams = ewo1;
            languagePack = eyn1;
            super();
        }
    }

}
