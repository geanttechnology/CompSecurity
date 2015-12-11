// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public class NewWebViewData
{
    public static final class ViewType extends Enum
    {

        private static final ViewType $VALUES[];
        public static final ViewType COMMENTS;
        private final String stringValue;

        public static ViewType fromString(String s)
        {
            ViewType aviewtype[] = values();
            int j = aviewtype.length;
            for (int i = 0; i < j; i++)
            {
                ViewType viewtype = aviewtype[i];
                if (viewtype.stringValue.equals(s))
                {
                    return viewtype;
                }
            }

            return null;
        }

        public static ViewType valueOf(String s)
        {
            return (ViewType)Enum.valueOf(com/shazam/android/web/bridge/command/data/NewWebViewData$ViewType, s);
        }

        public static ViewType[] values()
        {
            return (ViewType[])$VALUES.clone();
        }

        public final String getStringValue()
        {
            return stringValue;
        }

        static 
        {
            COMMENTS = new ViewType("COMMENTS", 0, "comments");
            $VALUES = (new ViewType[] {
                COMMENTS
            });
        }

        private ViewType(String s, int i, String s1)
        {
            super(s, i);
            stringValue = s1;
        }
    }

    public static class ViewType.Deserializer
        implements k
    {

        public ViewType deserialize(l l1, Type type, j j)
        {
            return ViewType.fromString(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public ViewType.Deserializer()
        {
        }
    }

    public static class ViewType.Serializer
        implements t
    {

        public l serialize(ViewType viewtype, Type type, s s)
        {
            return new r(viewtype.getStringValue());
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((ViewType)obj, type, s);
        }

        public ViewType.Serializer()
        {
        }
    }


    private boolean autoShowKeyboard;
    private String pageTitle;
    private String url;
    private ViewType viewType;

    private NewWebViewData()
    {
    }

    public NewWebViewData(String s, String s1, String s2, boolean flag)
    {
        url = s;
        pageTitle = s1;
        viewType = ViewType.fromString(s2);
        autoShowKeyboard = flag;
    }

    public String getPageTitle()
    {
        return pageTitle;
    }

    public String getUrl()
    {
        return url;
    }

    public ViewType getViewType()
    {
        return viewType;
    }

    public boolean isAutoShowKeyboard()
    {
        return autoShowKeyboard;
    }
}
