// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            TaskQueue, ParseCorePlugins, ParseException, ParseTaskUtils, 
//            ProgressCallback, ParseFileController, ParseUser, ParseDecoder, 
//            GetDataCallback, GetDataStreamCallback, GetFileCallback, SaveCallback, 
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
    File file;
    private State state;
    final TaskQueue taskQueue;

    ParseFile(State state1)
    {
        taskQueue = new TaskQueue();
        currentTasks = Collections.synchronizedSet(new HashSet());
        state = state1;
    }

    public ParseFile(File file1)
    {
        this(file1, ((String) (null)));
    }

    public ParseFile(File file1, String s)
    {
        this((new State.Builder()).name(file1.getName()).mimeType(s).build());
        if (file1.length() > 0xa00000L)
        {
            throw new IllegalArgumentException(String.format("ParseFile must be less than %d bytes", new Object[] {
                Integer.valueOf(0xa00000)
            }));
        } else
        {
            file = file1;
            return;
        }
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

    private j fetchInBackground(final ProgressCallback progressCallback, j j1, final j cancellationToken)
    {
        if (cancellationToken != null && cancellationToken.c())
        {
            return j.h();
        } else
        {
            return j1.b(new i() {

                final ParseFile this$0;
                final j val$cancellationToken;
                final ProgressCallback val$progressCallback;

                public j then(j j2)
                    throws Exception
                {
                    if (cancellationToken != null && cancellationToken.c())
                    {
                        return j.h();
                    } else
                    {
                        return ParseFile.getFileController().fetchAsync(state, null, ParseFile.progressCallbackOnMainThread(progressCallback), cancellationToken);
                    }
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseFile.this;
                cancellationToken = j1;
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
                    j.a(integer. new Callable() {

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

    private j saveAsync(final String sessionToken, final ProgressCallback uploadProgressCallback, j j1, final j cancellationToken)
    {
        if (!isDirty())
        {
            return j.a(null);
        }
        if (cancellationToken != null && cancellationToken.c())
        {
            return j.h();
        } else
        {
            return j1.b(new i() {

                final ParseFile this$0;
                final j val$cancellationToken;
                final String val$sessionToken;
                final ProgressCallback val$uploadProgressCallback;

                public j then(j j2)
                    throws Exception
                {
                    if (!isDirty())
                    {
                        return j.a(null);
                    }
                    if (cancellationToken != null && cancellationToken.c())
                    {
                        return j.h();
                    }
                    if (data != null)
                    {
                        j2 = ParseFile.getFileController().saveAsync(state, data, sessionToken, ParseFile.progressCallbackOnMainThread(uploadProgressCallback), cancellationToken);
                    } else
                    {
                        j2 = ParseFile.getFileController().saveAsync(state, file, sessionToken, ParseFile.progressCallbackOnMainThread(uploadProgressCallback), cancellationToken);
                    }
                    return j2.d(new i() {

                        final _cls2 this$1;

                        public j then(j j1)
                            throws Exception
                        {
                            state = (State)j1.e();
                            file = null;
                            return j1.j();
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseFile.this;
                cancellationToken = j1;
                sessionToken = s;
                uploadProgressCallback = progresscallback;
                super();
            }
            });
        }
    }

    public void cancel()
    {
        HashSet hashset = new HashSet(currentTasks);
        for (Iterator iterator = hashset.iterator(); iterator.hasNext(); ((a.j.a)iterator.next()).b()) { }
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

    public byte[] getData()
        throws ParseException
    {
        return (byte[])ParseTaskUtils.wait(getDataInBackground());
    }

    public j getDataInBackground()
    {
        return getDataInBackground((ProgressCallback)null);
    }

    public j getDataInBackground(final ProgressCallback progressCallback)
    {
        if (data != null)
        {
            return j.a(data);
        } else
        {
            final a.j.a cts = j.a();
            currentTasks.add(cts);
            return taskQueue.enqueue(new i() {

                final ParseFile this$0;
                final a.j.a val$cts;
                final ProgressCallback val$progressCallback;

                public j then(j j1)
                    throws Exception
                {
                    if (data != null)
                    {
                        return j.a(data);
                    } else
                    {
                        return fetchInBackground(progressCallback, j1, cts.a()).c(new i() {

                            final _cls7 this$1;

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

                            public byte[] then(j j1)
                                throws Exception
                            {
                                j1 = (File)j1.e();
                                try
                                {
                                    data = ParseFileUtils.readFileToByteArray(j1);
                                    j1 = data;
                                }
                                // Misplaced declaration of an exception variable
                                catch (j j1)
                                {
                                    return null;
                                }
                                return j1;
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        });
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseFile.this;
                progressCallback = progresscallback;
                cts = a;
                super();
            }
            }).b(new i() {

                final ParseFile this$0;
                final a.j.a val$cts;

                public j then(j j1)
                    throws Exception
                {
                    cts.a(null);
                    currentTasks.remove(cts);
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseFile.this;
                cts = a;
                super();
            }
            });
        }
    }

    public void getDataInBackground(GetDataCallback getdatacallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(), getdatacallback);
    }

    public void getDataInBackground(GetDataCallback getdatacallback, ProgressCallback progresscallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(progresscallback), getdatacallback);
    }

    public InputStream getDataStream()
        throws ParseException
    {
        return (InputStream)ParseTaskUtils.wait(getDataStreamInBackground());
    }

    public j getDataStreamInBackground()
    {
        return getDataStreamInBackground((ProgressCallback)null);
    }

    public j getDataStreamInBackground(final ProgressCallback progressCallback)
    {
        final a.j.a cts = j.a();
        currentTasks.add(cts);
        return taskQueue.enqueue(new i() {

            final ParseFile this$0;
            final a.j.a val$cts;
            final ProgressCallback val$progressCallback;

            public j then(j j1)
                throws Exception
            {
                return fetchInBackground(progressCallback, j1, cts.a()).c(new i() {

                    final _cls11 this$1;

                    public InputStream then(j j1)
                        throws Exception
                    {
                        return new FileInputStream((File)j1.e());
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls11.this;
                super();
            }
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseFile.this;
                progressCallback = progresscallback;
                cts = a;
                super();
            }
        }).b(new i() {

            final ParseFile this$0;
            final a.j.a val$cts;

            public j then(j j1)
                throws Exception
            {
                cts.a(null);
                currentTasks.remove(cts);
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseFile.this;
                cts = a;
                super();
            }
        });
    }

    public void getDataStreamInBackground(GetDataStreamCallback getdatastreamcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataStreamInBackground(), getdatastreamcallback);
    }

    public void getDataStreamInBackground(GetDataStreamCallback getdatastreamcallback, ProgressCallback progresscallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataStreamInBackground(progresscallback), getdatastreamcallback);
    }

    public File getFile()
        throws ParseException
    {
        return (File)ParseTaskUtils.wait(getFileInBackground());
    }

    public j getFileInBackground()
    {
        return getFileInBackground((ProgressCallback)null);
    }

    public j getFileInBackground(final ProgressCallback progressCallback)
    {
        final a.j.a cts = j.a();
        currentTasks.add(cts);
        return taskQueue.enqueue(new i() {

            final ParseFile this$0;
            final a.j.a val$cts;
            final ProgressCallback val$progressCallback;

            public j then(j j1)
                throws Exception
            {
                return fetchInBackground(progressCallback, j1, cts.a());
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseFile.this;
                progressCallback = progresscallback;
                cts = a;
                super();
            }
        }).b(new i() {

            final ParseFile this$0;
            final a.j.a val$cts;

            public j then(j j1)
                throws Exception
            {
                cts.a(null);
                currentTasks.remove(cts);
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseFile.this;
                cts = a;
                super();
            }
        });
    }

    public void getFileInBackground(GetFileCallback getfilecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getFileInBackground(), getfilecallback);
    }

    public void getFileInBackground(GetFileCallback getfilecallback, ProgressCallback progresscallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(getFileInBackground(progresscallback), getfilecallback);
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
        return data != null || getFileController().isDataAvailable(state);
    }

    public boolean isDirty()
    {
        return state.url() == null;
    }

    public void save()
        throws ParseException
    {
        ParseTaskUtils.wait(saveInBackground());
    }

    j saveAsync(final String sessionToken, final ProgressCallback uploadProgressCallback, final j cancellationToken)
    {
        return taskQueue.enqueue(new i() {

            final ParseFile this$0;
            final j val$cancellationToken;
            final String val$sessionToken;
            final ProgressCallback val$uploadProgressCallback;

            public j then(j j1)
                throws Exception
            {
                return saveAsync(sessionToken, uploadProgressCallback, j1, cancellationToken);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseFile.this;
                sessionToken = s;
                uploadProgressCallback = progresscallback;
                cancellationToken = j1;
                super();
            }
        });
    }

    public j saveInBackground()
    {
        return saveInBackground((ProgressCallback)null);
    }

    public j saveInBackground(final ProgressCallback uploadProgressCallback)
    {
        final a.j.a cts = j.a();
        currentTasks.add(cts);
        return ParseUser.getCurrentSessionTokenAsync().d(new i() {

            final ParseFile this$0;
            final a.j.a val$cts;
            final ProgressCallback val$uploadProgressCallback;

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                return saveAsync(j1, uploadProgressCallback, cts.a());
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseFile.this;
                uploadProgressCallback = progresscallback;
                cts = a;
                super();
            }
        }).b(new i() {

            final ParseFile this$0;
            final a.j.a val$cts;

            public j then(j j1)
                throws Exception
            {
                cts.a(null);
                currentTasks.remove(cts);
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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



/*
    static State access$402(ParseFile parsefile, State state1)
    {
        parsefile.state = state1;
        return state1;
    }

*/




}
