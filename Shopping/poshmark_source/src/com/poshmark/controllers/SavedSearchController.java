// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.SuggestedSearchItem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SavedSearchController
{
    class SuggestionsData
    {

        List data;
        final SavedSearchController this$0;
        int versionCode;

        SuggestionsData()
        {
            this$0 = SavedSearchController.this;
            super();
            versionCode = 1;
            data = new ArrayList();
        }
    }


    static SavedSearchController globalSavedSearchController = null;
    final int VERSION;
    boolean dirtyFlag;
    FileInputStream inputStream;
    FileOutputStream outputStream;
    ArrayDeque recentSavedQueue;
    Map savedSearchHash;
    final String suggestionsFileName;

    SavedSearchController()
    {
        VERSION = 1;
        savedSearchHash = new HashMap();
        dirtyFlag = false;
        suggestionsFileName = "savedSuggestions";
        recentSavedQueue = new ArrayDeque();
        Object obj;
        Object obj1;
        if (inputStream == null)
        {
            inputStream = PMApplication.getContext().openFileInput("savedSuggestions");
        }
        obj = (new GsonBuilder()).create();
        obj1 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        if (obj instanceof Gson)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj = ((Gson) (obj)).fromJson(((java.io.Reader) (obj1)), com/poshmark/controllers/SavedSearchController$SuggestionsData);
_L1:
        obj1 = (SuggestionsData)obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (((SuggestionsData) (obj1)).data == null || ((SuggestionsData) (obj1)).versionCode == -1)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = obj1;
        if (((SuggestionsData) (obj1)).versionCode >= 1)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        obj = new SuggestionsData();
        populateQueue(((SuggestionsData) (obj)));
        return;
        try
        {
            obj = GsonInstrumentation.fromJson((Gson)obj, ((java.io.Reader) (obj1)), com/poshmark/controllers/SavedSearchController$SuggestionsData);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
          goto _L1
    }

    public static SavedSearchController getGlobalSavedSearchController()
    {
        if (globalSavedSearchController == null)
        {
            globalSavedSearchController = new SavedSearchController();
        }
        return globalSavedSearchController;
    }

    private void populateQueue(SuggestionsData suggestionsdata)
    {
        recentSavedQueue.addAll(suggestionsdata.data);
    }

    public void clearAll()
    {
        savedSearchHash.clear();
        recentSavedQueue.clear();
        dirtyFlag = true;
    }

    public void commit()
    {
        Object obj;
        BufferedWriter bufferedwriter;
        Gson gson;
        if (!dirtyFlag)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        if (outputStream == null)
        {
            outputStream = PMApplication.getContext().openFileOutput("savedSuggestions", 0);
        }
        obj = new SuggestionsData();
        ((SuggestionsData) (obj)).data.addAll(recentSavedQueue);
        gson = (new GsonBuilder()).create();
        bufferedwriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("UTF-8").newEncoder()));
        if (gson instanceof Gson)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj = gson.toJson(obj, com/poshmark/controllers/SavedSearchController$SuggestionsData);
_L2:
        bufferedwriter.write(((String) (obj)), 0, ((String) (obj)).length());
        bufferedwriter.flush();
        outputStream.close();
        outputStream = null;
        dirtyFlag = false;
        return;
        obj = GsonInstrumentation.toJson((Gson)gson, obj, com/poshmark/controllers/SavedSearchController$SuggestionsData);
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1;
        ((FileNotFoundException) (obj1)).printStackTrace();
        return;
        obj1;
        ((IOException) (obj1)).printStackTrace();
    }

    public List getAllSavedSearches()
    {
        ArrayList arraylist = new ArrayList();
        if (recentSavedQueue.size() != 0)
        {
            for (Iterator iterator = recentSavedQueue.descendingIterator(); iterator.hasNext(); arraylist.add((SuggestedSearchItem)iterator.next())) { }
        }
        return arraylist;
    }

}
