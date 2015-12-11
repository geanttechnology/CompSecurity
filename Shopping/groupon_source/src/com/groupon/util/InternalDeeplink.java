// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.net.Uri;
import roboguice.util.Ln;

public class InternalDeeplink
{
    public static final class InternalAction extends Enum
    {

        private static final InternalAction $VALUES[];
        public static final InternalAction CAMERA;
        public static final InternalAction CLOSE;
        public static final InternalAction INVALID;
        public static final InternalAction LOGIN;
        public static final InternalAction PHOTO;

        public static InternalAction valueOf(String s)
        {
            return (InternalAction)Enum.valueOf(com/groupon/util/InternalDeeplink$InternalAction, s);
        }

        public static InternalAction[] values()
        {
            return (InternalAction[])$VALUES.clone();
        }

        static 
        {
            PHOTO = new InternalAction("PHOTO", 0);
            CAMERA = new InternalAction("CAMERA", 1);
            CLOSE = new InternalAction("CLOSE", 2);
            LOGIN = new InternalAction("LOGIN", 3);
            INVALID = new InternalAction("INVALID", 4);
            $VALUES = (new InternalAction[] {
                PHOTO, CAMERA, CLOSE, LOGIN, INVALID
            });
        }

        private InternalAction(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String INTERNAL_DEEPLINK_PREFIX = "groupon:";
    public static final String PARAM_CALLBACK = "callback";
    public static final String PARAM_MAX_SIZE = "maxSize";
    private Uri fakeUri;
    private InternalAction internalAction;
    private String internalUrl;

    public InternalDeeplink(Context context, String s)
    {
        internalAction = InternalAction.INVALID;
        internalUrl = s;
        init();
    }

    private void init()
    {
        String as[] = internalUrl.split("\\?");
        parseAction(as[0].replace("groupon:", ""));
        if (as.length == 2)
        {
            fakeUri = Uri.parse((new StringBuilder()).append("http://www.groupon.com/?").append(as[1]).toString());
        }
    }

    public static boolean isUrlInternal(String s)
    {
        return s.startsWith("groupon:");
    }

    private void parseAction(String s)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$util$InternalDeeplink$InternalAction[];

            static 
            {
                $SwitchMap$com$groupon$util$InternalDeeplink$InternalAction = new int[InternalAction.values().length];
                try
                {
                    $SwitchMap$com$groupon$util$InternalDeeplink$InternalAction[InternalAction.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$util$InternalDeeplink$InternalAction[InternalAction.CAMERA.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$util$InternalDeeplink$InternalAction[InternalAction.CLOSE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$util$InternalDeeplink$InternalAction[InternalAction.LOGIN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.util.InternalDeeplink.InternalAction[InternalAction.valueOf(s.toUpperCase()).ordinal()];
        JVM INSTR tableswitch 1 4: default 83
    //                   1 44
    //                   2 59
    //                   3 67
    //                   4 75;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        internalAction = InternalAction.PHOTO;
        return;
_L3:
        try
        {
            internalAction = InternalAction.CAMERA;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s);
            return;
        }
_L4:
        internalAction = InternalAction.CLOSE;
        return;
_L5:
        internalAction = InternalAction.LOGIN;
        return;
_L1:
    }

    public int getIntParam(String s)
    {
        int i = 0;
        if (fakeUri != null)
        {
            try
            {
                i = Integer.parseInt(fakeUri.getQueryParameter(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return 0;
            }
        }
        return i;
    }

    public InternalAction getInternalAction()
    {
        return internalAction;
    }

    public String getParam(String s)
    {
        if (fakeUri != null)
        {
            return fakeUri.getQueryParameter(s);
        } else
        {
            return null;
        }
    }

    public boolean isCameraAction()
    {
        return internalAction.equals(InternalAction.CAMERA);
    }

    public boolean isCloseIntent()
    {
        return internalAction.equals(InternalAction.CLOSE);
    }

    public boolean isLoginIntent()
    {
        return internalAction.equals(InternalAction.LOGIN);
    }

    public boolean isPhotoAction()
    {
        return internalAction.equals(InternalAction.PHOTO);
    }
}
