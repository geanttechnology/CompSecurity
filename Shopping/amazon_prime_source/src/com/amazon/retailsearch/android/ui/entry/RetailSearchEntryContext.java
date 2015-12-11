// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;


public class RetailSearchEntryContext
{

    private String currentDepartmentName;
    private boolean forceUpdatePastSearches;
    private boolean hasScanIt;
    private boolean hasSnapIt;
    boolean isFirstKeystrokeLogged;
    boolean isFirstSuggestionLogged;
    private boolean isFirstTimeEnter;
    private boolean isFlowEnabled;
    private String searchAlias;
    private boolean showBarcodeEntry;
    private boolean showBarcodeIconForFlow;
    private boolean voiceEnabled;

    public RetailSearchEntryContext()
    {
        showBarcodeEntry = false;
        hasScanIt = false;
        hasSnapIt = false;
        isFlowEnabled = false;
        searchAlias = "aps";
        forceUpdatePastSearches = true;
        isFirstTimeEnter = true;
        isFirstKeystrokeLogged = false;
        isFirstSuggestionLogged = false;
    }

    public String getCurrentDepartmentName()
    {
        return currentDepartmentName;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public boolean hasActionItems()
    {
        return hasScanIt || hasSnapIt || isFlowEnabled || showBarcodeEntry || voiceEnabled;
    }

    public boolean hasScanIt()
    {
        return hasScanIt;
    }

    public boolean hasSnapIt()
    {
        return hasSnapIt;
    }

    public boolean isFirstKeystrokeLogged()
    {
        return isFirstKeystrokeLogged;
    }

    public boolean isFirstSuggestionLogged()
    {
        return isFirstSuggestionLogged;
    }

    public boolean isFirstTimeEnter()
    {
        return isFirstTimeEnter;
    }

    public boolean isFlowEnabled()
    {
        return isFlowEnabled;
    }

    public boolean isForceUpdatePastSearches()
    {
        return forceUpdatePastSearches;
    }

    public void setCurrentDepartmentName(String s)
    {
        currentDepartmentName = s;
    }

    public void setFirstTimeEnter(boolean flag)
    {
        isFirstTimeEnter = flag;
    }

    public void setFlowEnabled(boolean flag)
    {
        isFlowEnabled = flag;
    }

    public void setForceUpdatePastSearches(boolean flag)
    {
        forceUpdatePastSearches = flag;
    }

    public void setHasScanIt(boolean flag)
    {
        hasScanIt = flag;
    }

    public void setHasSnapIt(boolean flag)
    {
        hasSnapIt = flag;
    }

    public void setIsFirstKeystrokeLogged(boolean flag)
    {
        isFirstKeystrokeLogged = flag;
    }

    public void setIsFirstSuggestionLogged(boolean flag)
    {
        isFirstSuggestionLogged = flag;
    }

    public void setSearchAlias(String s)
    {
        searchAlias = s;
    }

    public void setShowBarcodeEntry(boolean flag)
    {
        showBarcodeEntry = flag;
    }

    public void setShowBarcodeIconForFlow(boolean flag)
    {
        showBarcodeIconForFlow = flag;
    }

    public void setVoiceEnabled(boolean flag)
    {
        voiceEnabled = flag;
    }

    public boolean showBarcodeEntry()
    {
        return showBarcodeEntry;
    }

    public boolean showBarcodeIconForFlow()
    {
        return showBarcodeIconForFlow;
    }

    public boolean voiceEnabled()
    {
        return voiceEnabled;
    }
}
