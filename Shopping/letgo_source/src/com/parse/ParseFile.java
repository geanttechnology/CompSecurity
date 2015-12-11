// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            TaskQueue, ParseCorePlugins, Parse, ParseException, 
//            ParseTaskUtils, ParseFileController, ProgressCallback, ParseUser, 
//            ParseDecoder, ParseCallback1, GetDataCallback, SaveCallback, 
//            ParseExecutors, ParseFileUtils

public class ParseFile
{
    static class State
    {

        private final String contentType;
        private final String name;
        private final String url;

        public String mimeType()
        {
            return contentType;
        }

        public String name()
        {
            return name;
        }

        public String url()
        {
            return url;
        }

        private State(Builder builder)
        {
            String s;
            if (builder.name != null)
            {
                s = builder.name;
            } else
            {
                s = "file";
            }
            name = s;
            contentType = builder.mimeType;
            url = builder.url;
        }

    }

    static class State.Builder
    {

        private String mimeType;
        private String name;
        private String url;

        public State build()
        {
            return new State(this);
        }

        public State.Builder mimeType(String s)
        {
            mimeType = s;
            return this;
        }

        public State.Builder name(String s)
        {
            name = s;
            return this;
        }

        public State.Builder url(String s)
        {
            url = s;
            return this;
        }




        public State.Builder()
        {
        }

        public State.Builder(State state1)
        {
            name = state1.name();
            mimeType = state1.mimeType();
            url = state1.url();
        }
    }


    static final int MAX_FILE_SIZE = 0xa00000;
    private Set currentTasks;
    byte data[];
    private State state;
    final TaskQueue taskQueue;

    ParseFile(State state1)
    {
        taskQueue = new TaskQueue();
        currentTasks = Collections.synchronizedSet(new HashSet());
        state = state1;
    }

    public ParseFile(String s, byte abyte0[])
    {
        this(s, abyte0, null);
    }

    public ParseFile(String s, byte abyte0[], String s1)
    {
        this((new State.Builder()).name(s).mimeType(s1).build());
        if (abyte0.length > 0xa00000)
        {
            throw new IllegalArgumentException(String.format("ParseFile must be less than %d bytes", new Object[] {
                Integer.valueOf(0xa00000)
            }));
        } else
        {
            data = abyte0;
            return;
        }
    }

    ParseFile(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        this((new State.Builder()).name(jsonobject.optString("name")).url(jsonobject.optString("url")).build());
    }

    public ParseFile(byte abyte0[])
    {
        this(null, abyte0, null);
    }

    public ParseFile(byte abyte0[], String s)
    {
        this(null, abyte0, s);
    }

    private cu getDataAsync(final ProgressCallback progressCallback, cu cu1, final cu cancellationToken)
    {
        if (data != null)
        {
            return cu.a(data);
        }
        if (cancellationToken != null && cancellationToken.c())
        {
            return cu.h();
        } else
        {
            return cu1.b(new ct() {

                final ParseFile this$0;
                final cu val$cancellationToken;
                final ProgressCallback val$progressCallback;

                public cu then(cu cu2)
                    throws Exception
                {
                    if (data != null)
                    {
                        return cu.a(data);
                    }
                    if (cancellationToken != null && cancellationToken.c())
                    {
                        return cu.h();
                    } else
                    {
                        return ParseFile.getFileController().fetchAsync(state, null, ParseFile.progressCallbackOnMainThread(progressCallback), cancellationToken).c(new ct() {

                            final _cls8 this$1;

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

                            public byte[] then(cu cu1)
                                throws Exception
                            {
                                cu1 = (File)cu1.e();
                                try
                                {
                                    data = ParseFileUtils.readFileToByteArray(cu1);
                                    cu1 = data;
                                }
                                // Misplaced declaration of an exception variable
                                catch (cu cu1)
                                {
                                    return null;
                                }
                                return cu1;
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        });
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseFile.this;
                cancellationToken = cu1;
                progressCallback = progresscallback;
                super();
            }
            });
        }
    }

    static ParseFileController getFileController()
    {
        return ParseCorePlugins.getInstance().getFileController();
    }

    private String getFilename()
    {
        return state.name();
    }

    static File getFilesDir()
    {
        return Parse.getParseFilesDir("files");
    }

    private boolean isPinnedDataAvailable()
    {
        return getFilesFile().exists();
    }

    private static ProgressCallback progressCallbackOnMainThread(ProgressCallback progresscallback)
    {
        if (progresscallback == null)
        {
            return null;
        } else
        {
            return new ProgressCallback(progresscallback) {

                final ProgressCallback val$progressCallback;

                public void done(Integer integer)
                {
                    cu.a(integer. new Callable() {

                        final _cls1 this$0;
                        final Integer val$percentDone;

                        public volatile Object call()
                            throws Exception
                        {
                            return call();
                        }

                        public Void call()
                            throws Exception
                        {
                            progressCallback.done(percentDone);
                            return null;
                        }

            
            {
                this$0 = final__pcls1;
                percentDone = Integer.this;
                super();
            }
                    }, ParseExecutors.main());
                }

            
            {
                progressCallback = progresscallback;
                super();
            }
            };
        }
    }

    private cu saveAsync(final String sessionToken, final ProgressCallback uploadProgressCallback, cu cu1, final cu cancellationToken)
    {
        if (!isDirty())
        {
            return cu.a(null);
        }
        if (cancellationToken != null && cancellationToken.c())
        {
            return cu.h();
        } else
        {
            return cu1.b(new ct() {

                final ParseFile this$0;
                final cu val$cancellationToken;
                final String val$sessionToken;
                final ProgressCallback val$uploadProgressCallback;

                public cu then(cu cu2)
                    throws Exception
                {
                    if (!isDirty())
                    {
                        return cu.a(null);
                    }
                    if (cancellationToken != null && cancellationToken.c())
                    {
                        return cu.h();
                    } else
                    {
                        return ParseFile.getFileController().saveAsync(state, data, sessionToken, ParseFile.progressCallbackOnMainThread(uploadProgressCallback), cancellationToken).d(new ct() {

                            final _cls4 this$1;

                            public cu then(cu cu1)
                                throws Exception
                            {
                                state = (State)cu1.e();
                                return cu1.j();
                            }

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        });
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseFile.this;
                cancellationToken = cu1;
                sessionToken = s;
                uploadProgressCallback = progresscallback;
                super();
            }
            });
        }
    }

    private void setPinned(boolean flag)
        throws ParseException
    {
        ParseTaskUtils.wait(setPinnedInBackground(flag));
    }

    private cu setPinnedInBackground(final boolean pinned)
    {
        return taskQueue.enqueue(new ct() {

            final ParseFile this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseFile.this;
                super();
            }
        }).a(new ct() {

            final ParseFile this$0;
            final boolean val$pinned;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                if (state.url() == null)
                {
                    throw new IllegalStateException("Unable to pin file before saving");
                }
                if ((!pinned || !isPinned()) && (pinned || isPinned()))
                {
                    File file;
                    if (pinned)
                    {
                        file = getCacheFile();
                        cu1 = getFilesFile();
                    } else
                    {
                        file = getFilesFile();
                        cu1 = getCacheFile();
                    }
                    if (cu1.exists())
                    {
                        ParseFileUtils.deleteQuietly(cu1);
                    }
                    if (pinned && data != null)
                    {
                        ParseFileUtils.writeByteArrayToFile(cu1, data);
                        if (file.exists())
                        {
                            ParseFileUtils.deleteQuietly(file);
                            return null;
                        }
                    } else
                    if (file == null || !file.exists())
                    {
                        throw new IllegalStateException("Unable to pin file before retrieving");
                    } else
                    {
                        ParseFileUtils.moveFile(file, cu1);
                        return null;
                    }
                }
                return null;
            }

            
            {
                this$0 = ParseFile.this;
                pinned = flag;
                super();
            }
        }, cu.a);
    }

    private void setPinnedInBackground(boolean flag, ParseCallback1 parsecallback1)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(setPinnedInBackground(flag), parsecallback1);
    }

    public void cancel()
    {
        HashSet hashset = new HashSet(currentTasks);
        for (Iterator iterator = hashset.iterator(); iterator.hasNext(); ((android.support.v7.cu.a)iterator.next()).b()) { }
        currentTasks.removeAll(hashset);
    }

    JSONObject encode()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("__type", "File");
        jsonobject.put("name", getName());
        if (getUrl() == null)
        {
            throw new IllegalStateException("Unable to encode an unsaved ParseFile.");
        } else
        {
            jsonobject.put("url", getUrl());
            return jsonobject;
        }
    }

    File getCacheFile()
    {
        return getFileController().getCacheFile(state);
    }

    public byte[] getData()
        throws ParseException
    {
        return (byte[])ParseTaskUtils.wait(getDataInBackground());
    }

    public cu getDataInBackground()
    {
        return getDataInBackground((ProgressCallback)null);
    }

    public cu getDataInBackground(final ProgressCallback progressCallback)
    {
        final android.support.v7.cu.a cts = cu.a();
        currentTasks.add(cts);
        return taskQueue.enqueue(new ct() {

            final ParseFile this$0;
            final android.support.v7.cu.a val$cts;
            final ProgressCallback val$progressCallback;

            public cu then(cu cu1)
                throws Exception
            {
                return getDataAsync(progressCallback, cu1, cts.a());
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseFile.this;
                progressCallback = progresscallback;
                cts = a;
                super();
            }
        }).b(new ct() {

            final ParseFile this$0;
            final android.support.v7.cu.a val$cts;

            public cu then(cu cu1)
                throws Exception
            {
                cts.a(null);
                currentTasks.remove(cts);
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseFile.this;
                cts = a;
                super();
            }
        });
    }

    public void getDataInBackground(GetDataCallback getdatacallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(), getdatacallback);
    }

    public void getDataInBackground(GetDataCallback getdatacallback, ProgressCallback progresscallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(progresscallback), getdatacallback);
    }

    File getFilesFile()
    {
        String s = getFilename();
        if (s != null)
        {
            return new File(getFilesDir(), s);
        } else
        {
            return null;
        }
    }

    public String getName()
    {
        return state.name();
    }

    State getState()
    {
        return state;
    }

    public String getUrl()
    {
        return state.url();
    }

    public boolean isDataAvailable()
    {
        return data != null || getFileController().isDataAvailable(state) || isPinnedDataAvailable();
    }

    public boolean isDirty()
    {
        return state.url() == null;
    }

    boolean isPinned()
    {
        File file = getFilesFile();
        return file != null && file.exists();
    }

    void pin()
        throws ParseException
    {
        setPinned(true);
    }

    cu pinInBackground()
    {
        return setPinnedInBackground(true);
    }

    void pinInBackground(ParseCallback1 parsecallback1)
    {
        setPinnedInBackground(true, parsecallback1);
    }

    public void save()
        throws ParseException
    {
        ParseTaskUtils.wait(saveInBackground());
    }

    cu saveAsync(final String sessionToken, final ProgressCallback uploadProgressCallback, final cu cancellationToken)
    {
        return taskQueue.enqueue(new ct() {

            final ParseFile this$0;
            final cu val$cancellationToken;
            final String val$sessionToken;
            final ProgressCallback val$uploadProgressCallback;

            public cu then(cu cu1)
                throws Exception
            {
                return saveAsync(sessionToken, uploadProgressCallback, cu1, cancellationToken);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseFile.this;
                sessionToken = s;
                uploadProgressCallback = progresscallback;
                cancellationToken = cu1;
                super();
            }
        });
    }

    public cu saveInBackground()
    {
        return saveInBackground((ProgressCallback)null);
    }

    public cu saveInBackground(final ProgressCallback uploadProgressCallback)
    {
        final android.support.v7.cu.a cts = cu.a();
        currentTasks.add(cts);
        return ParseUser.getCurrentSessionTokenAsync().d(new ct() {

            final ParseFile this$0;
            final android.support.v7.cu.a val$cts;
            final ProgressCallback val$uploadProgressCallback;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return saveAsync(cu1, uploadProgressCallback, cts.a());
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseFile.this;
                uploadProgressCallback = progresscallback;
                cts = a;
                super();
            }
        }).b(new ct() {

            final ParseFile this$0;
            final android.support.v7.cu.a val$cts;

            public cu then(cu cu1)
                throws Exception
            {
                cts.a(null);
                currentTasks.remove(cts);
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseFile.this;
                cts = a;
                super();
            }
        });
    }

    public void saveInBackground(SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(), savecallback);
    }

    public void saveInBackground(SaveCallback savecallback, ProgressCallback progresscallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(progresscallback), savecallback);
    }

    void unpin()
        throws ParseException
    {
        setPinned(false);
    }

    cu unpinInBackground()
    {
        return setPinnedInBackground(false);
    }

    void unpinInBackground(ParseCallback1 parsecallback1)
    {
        setPinnedInBackground(false, parsecallback1);
    }



/*
    static State access$402(ParseFile parsefile, State state1)
    {
        parsefile.state = state1;
        return state1;
    }

*/




}
