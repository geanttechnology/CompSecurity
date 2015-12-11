// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class ViewMatcher
{
    private static final class Empty extends ViewMatcher
        implements Serializable
    {

        static final Empty instance = new Empty();
        private static final long serialVersionUID = 1L;

        public boolean isVisibleForView(Class class1)
        {
            return false;
        }


        private Empty()
        {
        }
    }

    private static final class Multi extends ViewMatcher
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private final Class _views[];

        public boolean isVisibleForView(Class class1)
        {
            int i = 0;
            for (int j = _views.length; i < j; i++)
            {
                Class class2 = _views[i];
                if (class1 == class2 || class2.isAssignableFrom(class1))
                {
                    return true;
                }
            }

            return false;
        }

        public Multi(Class aclass[])
        {
            _views = aclass;
        }
    }

    private static final class Single extends ViewMatcher
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private final Class _view;

        public boolean isVisibleForView(Class class1)
        {
            return class1 == _view || _view.isAssignableFrom(class1);
        }

        public Single(Class class1)
        {
            _view = class1;
        }
    }


    public ViewMatcher()
    {
    }

    public static ViewMatcher construct(Class aclass[])
    {
        if (aclass == null)
        {
            return Empty.instance;
        }
        switch (aclass.length)
        {
        default:
            return new Multi(aclass);

        case 0: // '\0'
            return Empty.instance;

        case 1: // '\001'
            return new Single(aclass[0]);
        }
    }

    public abstract boolean isVisibleForView(Class class1);
}
