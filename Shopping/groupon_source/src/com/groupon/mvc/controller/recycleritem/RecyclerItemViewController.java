// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import java.lang.annotation.Annotation;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class RecyclerItemViewController
{
    public static interface State
        extends Annotation
    {
    }


    protected static final String CSS_STYLING_NEW_DEAL_DETAILS = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
    protected static final String CSS_STYLING_RTL = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{ direction: rtl; margin:0px; } ul{padding-left:25px} blockquote{margin:0px;}</style>";
    public static final int EDITING = 1;
    public static final int READY = 2;
    public static final int UNAVAILABLE = 0;
    protected Context context;
    protected Object model;
    protected int state;

    public RecyclerItemViewController(Context context1)
    {
        context = context1;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public Object getCallback()
    {
        return null;
    }

    public Object getModel()
    {
        return model;
    }

    public boolean isEditing()
    {
        return 1 == state;
    }

    public boolean isReady()
    {
        return 2 == state;
    }

    public boolean isUnavailable()
    {
        return state == 0;
    }

    public abstract void processData();

    protected void setState(int i)
    {
        state = i;
    }
}
