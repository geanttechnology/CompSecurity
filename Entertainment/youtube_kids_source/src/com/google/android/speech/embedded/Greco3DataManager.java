// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import dbe;
import egf;
import eic;
import ejr;
import eyn;
import f;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.android.speech.embedded:
//            LocaleResources, Greco3Mode, Greco3Grammar, Greco3Preferences

public class Greco3DataManager
{

    private static final String COMPILED_GRAMMAR_CACHE = "g3_grammars";
    private static final boolean DEBUG = false;
    private static final FileFilter DIRECTORY_FILTER = new _cls5();
    public static final String EP_FALLBACK_LOCALE = "en-US";
    private static final int HOTWORD_MODEL_NOT_PRESENT = -2;
    private static final int HOTWORD_QUALITY_UNKNOWN = -1;
    public static final String MODELS_DIR = "g3_models";
    static final File SYSTEM_DATA_DIR = new File("/system/usr/srec");
    private static final String TAG = "VS.G3DataManager";
    private Map mAvailableLanguages;
    private final File mCompiledGrammarRoot;
    private final Context mContext;
    private final Greco3Preferences mGreco3Prefs;
    final List mInitializationCallbacks;
    private int mNumUpdatesInProgress;
    private PathDeleter mPathDeleter;
    private final eic mSearchPaths;
    private final int mSupportedFormatVersions[];
    private final Executor mUiThread;
    private final Executor mUpdateExecutor;

    public Greco3DataManager(Context context, Greco3Preferences greco3preferences, int ai[], eic eic1, File file, Executor executor, Executor executor1)
    {
        mContext = context;
        mGreco3Prefs = greco3preferences;
        mSupportedFormatVersions = ai;
        mSearchPaths = eic1;
        for (context = mSearchPaths.iterator(); context.hasNext(); f.b(((File)context.next()).isAbsolute())) { }
        mCompiledGrammarRoot = file;
        mUpdateExecutor = executor;
        mUiThread = executor1;
        mNumUpdatesInProgress = 0;
        mAvailableLanguages = null;
        mInitializationCallbacks = a.K();
    }

    public Greco3DataManager(Context context, Greco3Preferences greco3preferences, int ai[], Executor executor, Executor executor1)
    {
        this(context, greco3preferences, ai, getSearchPathList(new File[] {
            context.getDir("g3_models", 0), SYSTEM_DATA_DIR
        }), new File(context.getCacheDir(), "g3_grammars"), executor, executor1);
    }

    private void doLanguageDelete(eyn eyn1, Runnable runnable)
    {
        eyn1 = getOutputDirForLocale(eyn1.a);
        mPathDeleter.delete(eyn1, true, new _cls4(new int[0], runnable));
    }

    private File getOutputDirForLocale(String s)
    {
        return new File(mContext.getDir("g3_models", 0), s);
    }

    private static transient eic getSearchPathList(File afile[])
    {
        ArrayList arraylist = new ArrayList();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            if (file != null)
            {
                arraylist.add(file);
            }
        }

        return eic.a(arraylist);
    }

    private void handleLocale(File file, Map map)
    {
        String s = file.getName();
        if (!isValidLocale(s))
        {
            return;
        }
        LocaleResources localeresources1 = (LocaleResources)map.get(s);
        LocaleResources localeresources = localeresources1;
        if (localeresources1 == null)
        {
            localeresources = newLocaleResources();
            map.put(s, localeresources);
        }
        localeresources.addPath(file);
    }

    private boolean hasDictationOrGrammarResources(LocaleResources localeresources)
    {
        return localeresources != null && (localeresources.getConfigFile(Greco3Mode.DICTATION) != null || localeresources.getConfigFile(Greco3Mode.GRAMMAR) != null);
    }

    private boolean isValidLocale(String s)
    {
        return s.indexOf('-') == 2 || s.indexOf('-') == 3;
    }

    private void updateGrammars(Map map)
    {
        File afile[] = mCompiledGrammarRoot.listFiles(DIRECTORY_FILTER);
        if (afile != null && afile.length != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l = afile.length;
        for (int i = 0; i < l; i++)
        {
            File file = afile[i];
            Object obj = file.getName();
            if (!isValidLocale(((String) (obj))))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (LocaleResources)map.get(obj);
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            File afile1[] = file.listFiles(DIRECTORY_FILTER);
            if (afile1 == null || afile1.length == 0)
            {
                continue;
            }
            int i1 = afile1.length;
label0:
            for (int j = 0; j < i1; j++)
            {
                File file1 = afile1[j];
                Greco3Grammar greco3grammar = Greco3Grammar.valueOf(file1);
                if (greco3grammar == null)
                {
                    continue;
                }
                File afile2[] = file1.listFiles(DIRECTORY_FILTER);
                if (afile2 == null || afile2.length == 0)
                {
                    continue;
                }
                String s = mGreco3Prefs.getCompiledGrammarRevisionId(greco3grammar);
                int j1 = afile2.length;
                int k = 0;
                do
                {
                    if (k >= j1)
                    {
                        continue label0;
                    }
                    File file2 = afile2[k];
                    if (!file2.getName().equals(s))
                    {
                        mPathDeleter.delete(file2, false, null);
                    } else
                    {
                        ((LocaleResources) (obj)).addGrammar(greco3grammar, s, file2);
                    }
                    k++;
                } while (true);
            }

        }

        map = map.values().iterator();
        while (map.hasNext()) 
        {
            if (!((LocaleResources)map.next()).processAllGrammars())
            {
                map.remove();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void updateResourceListAndNotifyCallback()
    {
        Map map = doUpdateResourceList();
        Object obj = a.c(mInitializationCallbacks);
        this;
        JVM INSTR monitorenter ;
        mAvailableLanguages = map;
        mInitializationCallbacks.clear();
        mNumUpdatesInProgress = mNumUpdatesInProgress - 1;
        boolean flag;
        if (mNumUpdatesInProgress >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); mUiThread.execute(((Runnable) (obj))))
        {
            obj = (dbe)iterator.next();
        }

        break MISSING_BLOCK_LABEL_107;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void updateResources(Map map)
    {
        Iterator iterator = mSearchPaths.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            File afile[] = ((File)iterator.next()).listFiles(DIRECTORY_FILTER);
            if (afile != null)
            {
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    handleLocale(afile[i], map);
                    i++;
                }
            }
        } while (true);
        for (map = map.values().iterator(); map.hasNext(); ((LocaleResources)map.next()).processPaths()) { }
    }

    private void updateResourcesLocked(boolean flag)
    {
        boolean flag1;
        if (mPathDeleter != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        f.b(flag1);
        if (mNumUpdatesInProgress > 0 && !flag)
        {
            return;
        } else
        {
            mNumUpdatesInProgress = mNumUpdatesInProgress + 1;
            mUpdateExecutor.execute(new _cls1("update resource list", new int[0]));
            return;
        }
    }

    public void addInitializationCallback(dbe dbe1)
    {
        if (!isInitialized())
        {
            mInitializationCallbacks.add(dbe1);
            return;
        } else
        {
            mUiThread.execute(dbe1);
            return;
        }
    }

    public void blockingUpdateResources(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a.G();
        updateResourcesLocked(flag);
        waitForPendingUpdates();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public File createOuputPathForGrammarCache(Greco3Grammar greco3grammar, String s)
    {
        s = new File(new File(mCompiledGrammarRoot, s), greco3grammar.getDirectoryName());
        greco3grammar = s;
        if (!s.exists())
        {
            greco3grammar = s;
            if (!s.mkdirs())
            {
                greco3grammar = null;
            }
        }
        return greco3grammar;
    }

    public File createOutputPathForGrammar(Greco3Grammar greco3grammar, String s, String s1)
    {
        s = new File(new File(new File(mCompiledGrammarRoot, s), greco3grammar.getDirectoryName()), s1);
        greco3grammar = s;
        if (!s.exists())
        {
            greco3grammar = s;
            if (!s.mkdirs())
            {
                greco3grammar = null;
            }
        }
        return greco3grammar;
    }

    public void deleteLanguage(eyn eyn1, Executor executor, Runnable runnable)
    {
        executor.execute(new _cls3(eyn1, runnable));
    }

    protected Map doUpdateResourceList()
    {
        java.util.HashMap hashmap = ejr.a();
        updateResources(hashmap);
        if (mCompiledGrammarRoot != null)
        {
            updateGrammars(hashmap);
        }
        return hashmap;
    }

    public String getHotwordPrompt(String s)
    {
        f.b(isInitialized());
        s = (LocaleResources)mAvailableLanguages.get(s);
        if (s != null)
        {
            s = s.getHotwordPrompt();
            if (!TextUtils.isEmpty(s))
            {
                return s;
            }
        }
        return null;
    }

    public int getHotwordQuality(String s)
    {
        f.b(isInitialized());
        s = (LocaleResources)mAvailableLanguages.get(s);
        if (s != null)
        {
            if (s.getLanguageMetadata().g)
            {
                return s.getLanguageMetadata().h;
            } else
            {
                return -1;
            }
        } else
        {
            return -2;
        }
    }

    List getInitializationCallbacksForTesting()
    {
        return mInitializationCallbacks;
    }

    public Map getInstalledLanguages()
    {
        Object obj = ejr.a();
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        f.b(isInitialized());
        iterator = mAvailableLanguages.values().iterator();
_L2:
        LocaleResources localeresources;
        eyn eyn1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_88;
            }
            localeresources = (LocaleResources)iterator.next();
            eyn1 = localeresources.getLanguageMetadata();
        } while (eyn1 == null);
        if (!hasDictationOrGrammarResources(localeresources)) goto _L2; else goto _L1
_L1:
        ((Map) (obj)).put(eyn1.a, eyn1);
          goto _L2
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        this;
        JVM INSTR monitorexit ;
        return ((Map) (obj));
    }

    public egf getModelsDirSupplier()
    {
        return a.a(new _cls2());
    }

    public LocaleResources getResources(String s)
    {
        this;
        JVM INSTR monitorenter ;
        f.b(isInitialized());
        s = (LocaleResources)mAvailableLanguages.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getRevisionForGrammar(String s, Greco3Grammar greco3grammar)
    {
        s = getResources(s);
        String s1;
        if (s != null)
        {
            if ((s1 = mGreco3Prefs.getCompiledGrammarRevisionId(greco3grammar)) != null && s.getGrammarPath(greco3grammar, s1) != null)
            {
                return s1;
            }
        }
        return null;
    }

    public boolean hasCompiledGrammar(String s, Greco3Grammar greco3grammar)
    {
        return getRevisionForGrammar(s, greco3grammar) != null;
    }

    public boolean hasResources(String s, Greco3Mode greco3mode)
    {
        s = getResources(s);
        return s != null && s.getConfigFile(greco3mode) != null;
    }

    public boolean hasResourcesForCompilation(String s)
    {
        return hasResources(s, Greco3Mode.COMPILER) && hasResources(s, Greco3Mode.GRAMMAR);
    }

    public void initialize()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isInitialized())
        {
            updateResourcesLocked(false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void initialize(dbe dbe1)
    {
        this;
        JVM INSTR monitorenter ;
        addInitializationCallback(dbe1);
        initialize();
        this;
        JVM INSTR monitorexit ;
        return;
        dbe1;
        throw dbe1;
    }

    public boolean isInitialized()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = mAvailableLanguages;
        boolean flag;
        if (map != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isInstalledInSystemPartition(String s)
    {
        s = getResources(s);
        return s != null && s.isInstalledInSystemPartition();
    }

    public boolean isUsingDownloadedData(String s)
    {
        s = getResources(s);
        return s != null && s.isUsingDownloadedData();
    }

    protected LocaleResources newLocaleResources()
    {
        return new LocaleResources(mSupportedFormatVersions);
    }

    public void setPathDeleter(PathDeleter pathdeleter)
    {
        mPathDeleter = pathdeleter;
    }

    protected void waitForPendingUpdates()
    {
        this;
        JVM INSTR monitorenter ;
_L1:
        int i = mNumUpdatesInProgress;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        wait();
          goto _L1
        Object obj;
        obj;
        Thread.currentThread().interrupt();
        Log.e("VS.G3DataManager", "Interrupted waiting for resource update.");
          goto _L1
        obj;
        throw obj;
        this;
        JVM INSTR monitorexit ;
    }






    private class _cls4 extends dav
    {

        final Greco3DataManager this$0;
        final Runnable val$postDelete;

        public void run()
        {
            blockingUpdateResources(true);
            if (postDelete != null)
            {
                mUiThread.execute(postDelete);
            }
        }

        transient _cls4(int ai[], Runnable runnable)
        {
            this$0 = Greco3DataManager.this;
            postDelete = runnable;
            super(final_s, ai);
        }
    }


    private class PathDeleter
    {

        public abstract void delete(File file, boolean flag, Runnable runnable);
    }


    private class _cls1 extends dav
    {

        final Greco3DataManager this$0;

        public void run()
        {
            updateResourceListAndNotifyCallback();
        }

        transient _cls1(String s, int ai[])
        {
            this$0 = Greco3DataManager.this;
            super(s, ai);
        }
    }


    private class _cls3 extends dav
    {

        final Greco3DataManager this$0;
        final Runnable val$postDelete;
        final eyn val$resource;

        public void run()
        {
            doLanguageDelete(resource, postDelete);
        }

        transient _cls3(eyn eyn1, Runnable runnable)
        {
            this$0 = Greco3DataManager.this;
            resource = eyn1;
            postDelete = runnable;
            super(final_s, final_ai);
        }
    }


    private class _cls2
        implements egf
    {

        final Greco3DataManager this$0;

        public File get()
        {
            return mContext.getDir("g3_models", 0);
        }

        public volatile Object get()
        {
            return get();
        }

        _cls2()
        {
            this$0 = Greco3DataManager.this;
            super();
        }
    }


    private class _cls5
        implements FileFilter
    {

        public final boolean accept(File file)
        {
            return file.isDirectory();
        }

        _cls5()
        {
        }
    }

}
