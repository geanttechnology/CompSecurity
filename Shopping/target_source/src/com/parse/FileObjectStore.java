// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;

// Referenced classes of package com.parse:
//            ParseObjectStore, ParseObject, ParseFileUtils, ParseDecoder, 
//            ParseObjectCurrentCoder, PointerEncoder, ParseExecutors

class FileObjectStore
    implements ParseObjectStore
{

    private final String className;
    private final ParseObjectCurrentCoder coder;
    private final File file;

    public FileObjectStore(Class class1, File file1, ParseObjectCurrentCoder parseobjectcurrentcoder)
    {
        this(ParseObject.getClassName(class1), file1, parseobjectcurrentcoder);
    }

    public FileObjectStore(String s, File file1, ParseObjectCurrentCoder parseobjectcurrentcoder)
    {
        className = s;
        file = file1;
        coder = parseobjectcurrentcoder;
    }

    private static ParseObject getFromDisk(ParseObjectCurrentCoder parseobjectcurrentcoder, File file1, ParseObject.State.Init init)
    {
        file1 = ParseFileUtils.readFileToJSONObject(file1);
        return ParseObject.from(parseobjectcurrentcoder.decode(init, file1, ParseDecoder.get()).isComplete(true).build());
        parseobjectcurrentcoder;
_L2:
        return null;
        parseobjectcurrentcoder;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void saveToDisk(ParseObjectCurrentCoder parseobjectcurrentcoder, ParseObject parseobject, File file1)
    {
        parseobjectcurrentcoder = parseobjectcurrentcoder.encode(parseobject.getState(), null, PointerEncoder.get());
        try
        {
            ParseFileUtils.writeJSONObjectToFile(file1, parseobjectcurrentcoder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParseObjectCurrentCoder parseobjectcurrentcoder)
        {
            return;
        }
    }

    public j deleteAsync()
    {
        return j.a(new Callable() {

            final FileObjectStore this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                if (file.exists() && !ParseFileUtils.deleteQuietly(file))
                {
                    throw new RuntimeException("Unable to delete");
                } else
                {
                    return null;
                }
            }

            
            {
                this$0 = FileObjectStore.this;
                super();
            }
        }, ParseExecutors.io());
    }

    public j existsAsync()
    {
        return j.a(new Callable() {

            final FileObjectStore this$0;

            public Boolean call()
                throws Exception
            {
                return Boolean.valueOf(file.exists());
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = FileObjectStore.this;
                super();
            }
        }, ParseExecutors.io());
    }

    public j getAsync()
    {
        return j.a(new Callable() {

            final FileObjectStore this$0;

            public ParseObject call()
                throws Exception
            {
                if (!file.exists())
                {
                    return null;
                } else
                {
                    return FileObjectStore.getFromDisk(coder, file, ParseObject.State.newBuilder(className));
                }
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = FileObjectStore.this;
                super();
            }
        }, ParseExecutors.io());
    }

    public j setAsync(final ParseObject object)
    {
        return j.a(new Callable() {

            final FileObjectStore this$0;
            final ParseObject val$object;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                FileObjectStore.saveToDisk(coder, object, file);
                return null;
            }

            
            {
                this$0 = FileObjectStore.this;
                object = parseobject;
                super();
            }
        }, ParseExecutors.io());
    }





}
