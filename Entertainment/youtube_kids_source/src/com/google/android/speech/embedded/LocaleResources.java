// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.text.TextUtils;
import android.util.Log;
import ejr;
import emp;
import eud;
import eyn;
import f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Grammar, Greco3GrammarCompiler, Greco3DataManager, LanguagePackUtils, 
//            Greco3Mode

public class LocaleResources
{

    private static final String HOTWORD_PROMPT_FILE_NAME = "hotword_prompt.txt";
    public static final String METADATA_FILE_NAME = "metadata";
    private static final String TAG = "LocaleResources";
    private final Map mConfigPaths = ejr.a();
    private final List mGrammars;
    private String mHotwordPrompt;
    private eyn mLanguagePackMetadata;
    private String mResourceAbsolutePath;
    private final int mSupportedFormatVersions[];
    private boolean mSystemPartition;
    public final List mUnprocessedGrammars;
    public final List mUnprocessedPaths = a.e(4);

    LocaleResources(int ai[])
    {
        mSupportedFormatVersions = ai;
        mUnprocessedGrammars = a.e(Greco3Grammar.SIZE);
        mGrammars = a.e(Greco3Grammar.SIZE);
    }

    void addGrammar(Greco3Grammar greco3grammar, String s, File file)
    {
        f.b(mGrammars.isEmpty(), "Grammars have already been processed, cannot add another.");
        File afile[] = file.listFiles();
        if (afile == null || afile.length < Greco3GrammarCompiler.NUM_GENERATED_FILES)
        {
            Log.e("LocaleResources", (new StringBuilder("Expected ")).append(Greco3GrammarCompiler.NUM_GENERATED_FILES).append(" files in ").append(file).append(" but found ").append(afile.length).toString());
        } else
        {
            eyn eyn1 = parseMetadata(file);
            if (eyn1 != null)
            {
                mUnprocessedGrammars.add(new GrammarInfo(greco3grammar, s, file, eyn1));
                return;
            }
        }
    }

    protected void addHotwordPrompt(File file)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        file = new BufferedReader(new FileReader(file), 100);
        obj = file;
        obj1 = file.readLine();
        obj = file;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = file;
        mHotwordPrompt = ((String) (obj1));
        emp.a(file);
        return;
        obj1;
        file = null;
_L6:
        obj = file;
        Log.e("LocaleResources", "Could not open hotword prompt file.", ((Throwable) (obj1)));
        emp.a(file);
        return;
        obj;
        file = ((File) (obj1));
        obj1 = obj;
_L4:
        obj = file;
        Log.e("LocaleResources", "Could not read hotword prompt file.", ((Throwable) (obj1)));
        emp.a(file);
        return;
        file;
_L2:
        emp.a(((java.io.Closeable) (obj)));
        throw file;
        file;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void addPath(File file)
    {
        boolean flag;
        if (mLanguagePackMetadata == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag, "Paths have already been processed, cannot add a new path.");
        mUnprocessedPaths.add(file);
    }

    public String getConfigFile(Greco3Mode greco3mode)
    {
        return (String)mConfigPaths.get(greco3mode);
    }

    public String getGrammarPath(Greco3Grammar greco3grammar, String s)
    {
        for (Iterator iterator = mGrammars.iterator(); iterator.hasNext();)
        {
            GrammarInfo grammarinfo = (GrammarInfo)iterator.next();
            if (grammarinfo.grammar == greco3grammar && TextUtils.equals(grammarinfo.revisionName, s))
            {
                return grammarinfo.directory.getAbsolutePath();
            }
        }

        return null;
    }

    public String getHotwordPrompt()
    {
        return mHotwordPrompt;
    }

    public eyn getLanguageMetadata()
    {
        return mLanguagePackMetadata;
    }

    public String getResourcePath()
    {
        return mResourceAbsolutePath;
    }

    public boolean isInstalledInSystemPartition()
    {
        return mSystemPartition;
    }

    public boolean isUsingDownloadedData()
    {
        return mResourceAbsolutePath.indexOf("g3_models") > 0;
    }

    protected eyn parseMetadata(File file)
    {
        file = new File(file, "metadata");
        file = new FileInputStream(file);
        Object obj;
        obj = eud.a(file);
        obj = (new eyn()).b(((eud) (obj)));
        emp.a(file);
        return ((eyn) (obj));
        file;
        file = null;
_L4:
        emp.a(file);
        return null;
        file;
        Object obj1;
        obj1 = null;
        obj = file;
_L2:
        emp.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        obj1 = file;
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean processAllGrammars()
    {
        if (mLanguagePackMetadata != null && mConfigPaths.size() > 0)
        {
            Iterator iterator = mUnprocessedGrammars.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                GrammarInfo grammarinfo = (GrammarInfo)iterator.next();
                if (grammarinfo.metadata.c.equals(mLanguagePackMetadata.c))
                {
                    mGrammars.add(grammarinfo);
                }
            } while (true);
            mUnprocessedGrammars.clear();
            return true;
        } else
        {
            return false;
        }
    }

    public void processPaths()
    {
        if (mUnprocessedPaths.isEmpty())
        {
            Log.e("LocaleResources", "No paths have been added, cannot process.");
        } else
        {
            File file = null;
            String s = Greco3DataManager.SYSTEM_DATA_DIR.getAbsolutePath();
            Iterator iterator = mUnprocessedPaths.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                File file1 = (File)iterator.next();
                eyn eyn1 = parseMetadata(file1);
                if (eyn1 == null)
                {
                    Log.e("LocaleResources", (new StringBuilder("Unparsable metadata at: ")).append(file1).toString());
                } else
                {
                    if (!mSystemPartition && file1.getAbsolutePath().startsWith(s))
                    {
                        mSystemPartition = true;
                    }
                    if (LanguagePackUtils.isCompatible(eyn1, mSupportedFormatVersions, 0x7fffffff) && (mLanguagePackMetadata == null || eyn1.b > mLanguagePackMetadata.b))
                    {
                        mResourceAbsolutePath = file1.getAbsolutePath();
                        mLanguagePackMetadata = eyn1;
                        file = file1;
                    }
                }
            } while (true);
            mUnprocessedPaths.clear();
            if (mLanguagePackMetadata == null)
            {
                Log.e("LocaleResources", "No compatible language pack metadata found.");
                return;
            }
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    File file2 = afile[i];
                    Greco3Mode greco3mode = Greco3Mode.valueOf(file2);
                    if (greco3mode != null)
                    {
                        mConfigPaths.put(greco3mode, file2.getAbsolutePath());
                    } else
                    if ("hotword_prompt.txt".equals(file2.getName()))
                    {
                        addHotwordPrompt(file2);
                    }
                    i++;
                }
            }
        }
    }

    private class GrammarInfo
    {

        final File directory;
        final Greco3Grammar grammar;
        final eyn metadata;
        final String revisionName;

        GrammarInfo(Greco3Grammar greco3grammar, String s, File file, eyn eyn1)
        {
            grammar = greco3grammar;
            revisionName = s;
            directory = file;
            metadata = eyn1;
        }
    }

}
