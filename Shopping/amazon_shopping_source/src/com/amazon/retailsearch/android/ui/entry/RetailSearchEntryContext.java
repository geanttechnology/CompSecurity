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
    private boolean isFirstTimeEnter;
    private boolean isFlowEnabled;
    boolean isISSLatencyLogged;
    private String searchAlias;
    private boolean showBarcodeEntry;
    private boolean showVisualScan;
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
        isISSLatencyLogged = false;
    }

    public String getCurrentDepartmentName()
    {
        return currentDepartmentName;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public boolean hasScanIt()
    {
        return hasScanIt;
    }

    public boolean hasSnapIt()
    {
        return hasSnapIt;
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

    public boolean isISSLatencyLogged()
    {
        return isISSLatencyLogged;
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

    public void setISSLatencyLogged(boolean flag)
    {
        isISSLatencyLogged = flag;
    }

    public void setSearchAlias(String s)
    {
        searchAlias = s;
    }

    public void setShowBarcodeEntry(boolean flag)
    {
        showBarcodeEntry = flag;
    }

    public void setShowVisualScan(boolean flag)
    {
        showVisualScan = flag;
    }

    public void setVoiceEnabled(boolean flag)
    {
        voiceEnabled = flag;
    }

    public boolean showBarcodeEntry()
    {
        return showBarcodeEntry;
    }

    public boolean showVisualScan()
    {
        return showVisualScan;
    }

    public boolean voiceEnabled()
    {
        return voiceEnabled;
    }
}
