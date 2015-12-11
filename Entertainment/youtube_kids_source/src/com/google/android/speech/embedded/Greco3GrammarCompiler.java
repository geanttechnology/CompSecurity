// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Mode

public class Greco3GrammarCompiler
{

    public static int NUM_GENERATED_FILES = 0;
    private static final String TAG = "G3GrammarCompiler";
    private GrammarCompilerImpl mCompiler;
    private final String mConfigFile;
    private final String mResourcePath;

    public Greco3GrammarCompiler(String s, String s1)
    {
        mConfigFile = s;
        mResourcePath = s1;
    }

    public boolean compile(String s, String s1, String s2)
    {
        long l = SystemClock.elapsedRealtime();
        if (!mCompiler.readCache(s2))
        {
            Log.e("G3GrammarCompiler", (new StringBuilder("Error reading cache file: ")).append(s2).toString());
        }
        while (!mCompiler.compileAbnf(s) || !mCompiler.writeClgFst((new StringBuilder()).append(s1).append("/grammar_clg").toString(), (new StringBuilder()).append(s1).append("/grammar_symbols").toString()) || !mCompiler.writeSemanticFst((new StringBuilder()).append(s1).append("/semantic_fst").toString(), (new StringBuilder()).append(s1).append("/semantic_symbols").toString())) 
        {
            return false;
        }
        if (!mCompiler.writeCache(s2, true))
        {
            Log.e("G3GrammarCompiler", (new StringBuilder("Error writing cache to: ")).append(s2).toString());
            return true;
        } else
        {
            (new StringBuilder("Compilation complete, time = ")).append((float)(SystemClock.elapsedRealtime() - l) / 1000F).append(" s");
            return true;
        }
    }

    public void delete()
    {
        mCompiler.delete();
    }

    public boolean init()
    {
        mCompiler = new GrammarCompilerImpl(null);
        boolean flag;
        try
        {
            if (Greco3Mode.isAsciiConfiguration(new File(mConfigFile)))
            {
                return mCompiler.initFromFile(mConfigFile, mResourcePath);
            }
            byte abyte0[] = a.a(new File(mConfigFile));
            flag = mCompiler.initFromProto(abyte0, mResourcePath);
        }
        catch (IOException ioexception)
        {
            Log.w("G3GrammarCompiler", (new StringBuilder("I/O Exception reading binary config file: ")).append(ioexception).toString());
            return false;
        }
        return flag;
    }

    static 
    {
        NUM_GENERATED_FILES = 4;
    }

    private class GrammarCompilerImpl extends AbstractGrammarCompiler
    {

        private GrammarCompilerImpl()
        {
        }

        GrammarCompilerImpl(_cls1 _pcls1)
        {
            this();
        }
    }

}
