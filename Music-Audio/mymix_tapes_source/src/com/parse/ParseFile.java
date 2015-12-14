// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.webkit.MimeTypeMap;
import bolts.Continuation;
import bolts.Task;
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
//            TaskQueue, Parse, ParseFileUtils, ParseCommand, 
//            ParseAWSRequest, ParseException, ProgressCallback, ParseDecoder, 
//            ParseCallback, GetDataCallback, SaveCallback, ParseUser

public class ParseFile
{

    private String contentType;
    private Set currentTasks;
    byte data[];
    private boolean dirty;
    private String name;
    private ParseAWSRequest request;
    final TaskQueue taskQueue;
    private String url;

    ParseFile(String s, String s1)
    {
        dirty = false;
        name = null;
        url = null;
        contentType = null;
        taskQueue = new TaskQueue();
        currentTasks = Collections.synchronizedSet(new HashSet());
        name = s;
        url = s1;
    }

    public ParseFile(String s, byte abyte0[])
    {
        this(s, abyte0, null);
    }

    public ParseFile(String s, byte abyte0[], String s1)
    {
        dirty = false;
        name = null;
        url = null;
        contentType = null;
        taskQueue = new TaskQueue();
        currentTasks = Collections.synchronizedSet(new HashSet());
        if (abyte0.length > Parse.maxParseFileSize)
        {
            throw new IllegalArgumentException(String.format("ParseFile must be less than %d bytes", new Object[] {
                Integer.valueOf(Parse.maxParseFileSize)
            }));
        } else
        {
            name = s;
            data = abyte0;
            contentType = s1;
            dirty = true;
            return;
        }
    }

    ParseFile(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        this(jsonobject.optString("name"), jsonobject.optString("url"));
    }

    public ParseFile(byte abyte0[])
    {
        this(null, abyte0, null);
    }

    public ParseFile(byte abyte0[], String s)
    {
        this(null, abyte0, s);
    }

    static void clearCache()
    {
        File afile[] = getCacheDir().listFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            ParseFileUtils.deleteQuietly(afile[i]);
        }

    }

    private ParseCommand constructFileUploadCommand(String s)
    {
        s = new ParseCommand("upload_file", s);
        s.enableRetrying();
        if (name != null)
        {
            s.put("name", name);
        }
        return s;
    }

    static File getCacheDir()
    {
        return Parse.getParseCacheDir("files");
    }

    private byte[] getCachedData()
    {
        if (data != null)
        {
            return data;
        }
        File file = getCacheFile();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        byte abyte0[] = ParseFileUtils.readFileToByteArray(file);
        return abyte0;
        IOException ioexception;
        ioexception;
        ioexception = getFilesFile();
        if (ioexception == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        ioexception = ParseFileUtils.readFileToByteArray(ioexception);
        return ioexception;
        ioexception;
        return null;
    }

    private Task getDataAsync(final ProgressCallback progressCallback, Task task)
    {
        if (data != null)
        {
            return Task.forResult(data);
        } else
        {
            final bolts.Task.TaskCompletionSource tcs = Task.create();
            currentTasks.add(tcs);
            task.continueWith(new Continuation() {

                final ParseFile this$0;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public byte[] then(Task task1)
                    throws Exception
                {
                    return getCachedData();
                }

            
            {
                this$0 = ParseFile.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation() {

                final ParseFile this$0;
                final ProgressCallback val$progressCallback;
                final bolts.Task.TaskCompletionSource val$tcs;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public Void then(Task task1)
                    throws Exception
                {
                    task1 = (byte[])task1.getResult();
                    if (task1 != null)
                    {
                        tcs.trySetResult(task1);
                        return null;
                    } else
                    {
                        (new ParseAWSRequest(url)).executeAsync(progressCallback).continueWithTask(new Continuation() {

                            final _cls5 this$1;

                            public Task then(Task task)
                                throws Exception
                            {
                                Task task1;
                                if (task.isFaulted() && (task.getError() instanceof IllegalStateException))
                                {
                                    task1 = Task.forError(new ParseException(100, task.getError().getMessage()));
                                } else
                                {
                                    if (tcs.getTask().isCancelled())
                                    {
                                        return tcs.getTask();
                                    }
                                    data = (byte[])task.getResult();
                                    task1 = task;
                                    if (data != null)
                                    {
                                        ParseFileUtils.writeByteArrayToFile(getCacheFile(), data);
                                        return task;
                                    }
                                }
                                return task1;
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$1 = _cls5.this;
                super();
            }
                        }).continueWith(new Continuation() {

                            final _cls5 this$1;

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

                            public Void then(Task task)
                                throws Exception
                            {
                                currentTasks.remove(tcs);
                                if (task.isCancelled())
                                {
                                    tcs.trySetCancelled();
                                } else
                                if (task.isFaulted())
                                {
                                    tcs.trySetError(task.getError());
                                } else
                                {
                                    tcs.trySetResult(task.getResult());
                                }
                                return null;
                            }

            
            {
                this$1 = _cls5.this;
                super();
            }
                        });
                        return null;
                    }
                }

            
            {
                this$0 = ParseFile.this;
                tcs = taskcompletionsource;
                progressCallback = progresscallback;
                super();
            }
            });
            return tcs.getTask();
        }
    }

    private String getFilename()
    {
        return name;
    }

    static File getFilesDir()
    {
        return Parse.getParseFilesDir("files");
    }

    private Task handleFileUploadResultAsync(JSONObject jsonobject, ProgressCallback progresscallback)
    {
        if (request == null)
        {
            prepareFileUploadPost(jsonobject, progresscallback);
        }
        return request.executeAsync().makeVoid();
    }

    private void prepareFileUploadPost(JSONObject jsonobject, ProgressCallback progresscallback)
    {
        String s = null;
        String s1;
        JSONObject jsonobject1;
        try
        {
            name = jsonobject.getString("name");
            url = jsonobject.getString("url");
            jsonobject1 = jsonobject.getJSONObject("post_params");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new RuntimeException(jsonobject.getMessage());
        }
        if (contentType != null)
        {
            s = contentType;
        } else
        if (name.lastIndexOf(".") != -1)
        {
            s = name.substring(name.lastIndexOf(".") + 1);
            s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
        }
        s1 = s;
        if (s == null)
        {
            s1 = "application/octet-stream";
        }
        try
        {
            request = new ParseAWSRequest(1, jsonobject.getString("post_url"));
            request.setProgressCallback(progresscallback);
            request.setMimeType(s1);
            request.setPostParams(jsonobject1);
            request.setData(getCachedData());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new RuntimeException(jsonobject.getMessage());
        }
    }

    private void save(ProgressCallback progresscallback)
        throws ParseException
    {
        Parse.waitForTask(saveInBackground(progresscallback));
    }

    private void setPinned(boolean flag)
        throws ParseException
    {
        Parse.waitForTask(setPinnedInBackground(flag));
    }

    private Task setPinnedInBackground(final boolean pinned)
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseFile this$0;

            public Task then(Task task)
                throws Exception
            {
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseFile.this;
                super();
            }
        }).continueWith(new Continuation() {

            final ParseFile this$0;
            final boolean val$pinned;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                if ((!pinned || !isPinned()) && (pinned || isPinned()))
                {
                    File file;
                    if (pinned)
                    {
                        file = getCacheFile();
                        task = getFilesFile();
                    } else
                    {
                        file = getFilesFile();
                        task = getCacheFile();
                    }
                    if (task == null)
                    {
                        throw new IllegalStateException("Unable to pin file before saving");
                    }
                    if (task.exists())
                    {
                        ParseFileUtils.deleteQuietly(task);
                    }
                    if (pinned && data != null)
                    {
                        ParseFileUtils.writeByteArrayToFile(task, data);
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
                        ParseFileUtils.moveFile(file, task);
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
        }, Task.BACKGROUND_EXECUTOR);
    }

    private void setPinnedInBackground(boolean flag, ParseCallback parsecallback)
    {
        Parse.callbackOnMainThreadAsync(setPinnedInBackground(flag), parsecallback);
    }

    public void cancel()
    {
        HashSet hashset = new HashSet(currentTasks);
        for (Iterator iterator = hashset.iterator(); iterator.hasNext(); ((bolts.Task.TaskCompletionSource)iterator.next()).trySetCancelled()) { }
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
        String s = getFilename();
        if (s != null)
        {
            return new File(getCacheDir(), s);
        } else
        {
            return null;
        }
    }

    public byte[] getData()
        throws ParseException
    {
        return (byte[])Parse.waitForTask(getDataInBackground());
    }

    public Task getDataInBackground()
    {
        return getDataInBackground((ProgressCallback)null);
    }

    public Task getDataInBackground(final ProgressCallback progressCallback)
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseFile this$0;
            final ProgressCallback val$progressCallback;

            public Task then(Task task)
                throws Exception
            {
                return getDataAsync(progressCallback, task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseFile.this;
                progressCallback = progresscallback;
                super();
            }
        });
    }

    public void getDataInBackground(GetDataCallback getdatacallback)
    {
        Parse.callbackOnMainThreadAsync(getDataInBackground(), getdatacallback);
    }

    public void getDataInBackground(GetDataCallback getdatacallback, ProgressCallback progresscallback)
    {
        Parse.callbackOnMainThreadAsync(getDataInBackground(progresscallback), getdatacallback);
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
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isDataAvailable()
    {
        return data != null || (isPinned() ? getFilesFile().exists() : getCacheFile().exists());
    }

    public boolean isDirty()
    {
        return dirty;
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

    Task pinInBackground()
    {
        return setPinnedInBackground(true);
    }

    void pinInBackground(ParseCallback parsecallback)
    {
        setPinnedInBackground(true, parsecallback);
    }

    public void save()
        throws ParseException
    {
        Parse.waitForTask(saveInBackground());
    }

    Task saveAsync(final ProgressCallback progressCallback, Task task)
    {
        if (!isDirty())
        {
            return Task.forResult(null);
        } else
        {
            final bolts.Task.TaskCompletionSource tcs = Task.create();
            currentTasks.add(tcs);
            task.continueWith(new Continuation() {

                final ParseFile this$0;
                final ProgressCallback val$progressCallback;
                final bolts.Task.TaskCompletionSource val$tcs;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public Void then(Task task1)
                    throws Exception
                {
                    if (!isDirty())
                    {
                        tcs.trySetResult(null);
                        return null;
                    } else
                    {
                        Task.call(ParseUser.getCurrentSessionToken(). new Callable() {

                            final _cls3 this$1;
                            final String val$sessionToken;

                            public ParseCommand call()
                                throws Exception
                            {
                                ParseCommand parsecommand = constructFileUploadCommand(sessionToken);
                                tcs.getTask().continueWith(parsecommand. new Continuation() {

                                    final _cls5 this$2;
                                    final ParseCommand val$command;

                                    public volatile Object then(Task task)
                                        throws Exception
                                    {
                                        return then(task);
                                    }

                                    public Void then(Task task)
                                        throws Exception
                                    {
                                        if (task.isCancelled())
                                        {
                                            command.cancel();
                                        }
                                        return null;
                                    }

            
            {
                this$2 = final__pcls5;
                command = ParseCommand.this;
                super();
            }
                                });
                                return parsecommand;
                            }

                            public volatile Object call()
                                throws Exception
                            {
                                return call();
                            }

            
            {
                this$1 = final__pcls3;
                sessionToken = String.this;
                super();
            }
                        }).onSuccessTask(new Continuation() {

                            final _cls3 this$1;

                            public Task then(Task task)
                                throws Exception
                            {
                                return ((ParseCommand)task.getResult()).executeAsync();
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        }).onSuccessTask(new Continuation() {

                            final _cls3 this$1;

                            public Task then(Task task)
                                throws Exception
                            {
                                return handleFileUploadResultAsync((JSONObject)task.getResult(), progressCallback);
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        }).continueWithTask(new Continuation() {

                            final _cls3 this$1;

                            public Task then(Task task)
                                throws Exception
                            {
                                if (!task.isFaulted())
                                {
                                    try
                                    {
                                        ParseFileUtils.writeByteArrayToFile(getCacheFile(), data);
                                    }
                                    catch (IOException ioexception) { }
                                    dirty = false;
                                }
                                return task;
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        }).continueWith(new Continuation() {

                            final _cls3 this$1;

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

                            public Void then(Task task)
                                throws Exception
                            {
                                currentTasks.remove(tcs);
                                if (task.isCancelled())
                                {
                                    tcs.trySetCancelled();
                                } else
                                if (task.isFaulted())
                                {
                                    tcs.trySetError(task.getError());
                                } else
                                {
                                    tcs.trySetResult(task.getResult());
                                }
                                return null;
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        return null;
                    }
                }

            
            {
                this$0 = ParseFile.this;
                tcs = taskcompletionsource;
                progressCallback = progresscallback;
                super();
            }
            });
            return tcs.getTask();
        }
    }

    public Task saveInBackground()
    {
        return saveInBackground((ProgressCallback)null);
    }

    public Task saveInBackground(final ProgressCallback progressCallback)
    {
        return taskQueue.enqueue(new Continuation() {

            final ParseFile this$0;
            final ProgressCallback val$progressCallback;

            public Task then(Task task)
                throws Exception
            {
                return saveAsync(progressCallback, task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseFile.this;
                progressCallback = progresscallback;
                super();
            }
        });
    }

    public void saveInBackground(SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(saveInBackground(), savecallback);
    }

    public void saveInBackground(SaveCallback savecallback, ProgressCallback progresscallback)
    {
        this;
        JVM INSTR monitorenter ;
        Parse.callbackOnMainThreadAsync(saveInBackground(progresscallback), savecallback);
        this;
        JVM INSTR monitorexit ;
        return;
        savecallback;
        throw savecallback;
    }

    void unpin()
        throws ParseException
    {
        setPinned(false);
    }

    Task unpinInBackground()
    {
        return setPinnedInBackground(false);
    }

    void unpinInBackground(ParseCallback parsecallback)
    {
        setPinnedInBackground(false, parsecallback);
    }



/*
    static boolean access$102(ParseFile parsefile, boolean flag)
    {
        parsefile.dirty = flag;
        return flag;
    }

*/





}
