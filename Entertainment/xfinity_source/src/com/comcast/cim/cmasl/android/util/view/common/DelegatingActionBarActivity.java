// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;

import android.support.v7.app.ActionBarActivity;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelegatingActionBarActivity extends ActionBarActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/view/common/DelegatingActionBarActivity);
    private List delegateList;

    public DelegatingActionBarActivity()
    {
        delegateList = new ArrayList();
    }

}
