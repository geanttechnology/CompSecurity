// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.app.Activity;
import android.util.Log;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.ActivityUtils;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.mShop.aiv:
//            AivHttpIntentActivity

static abstract class <init> extends Enum
{

    private static final PLAYTRAILER $VALUES[];
    private static final int DEFAULT_LENGTH = 5;
    public static final PLAYTRAILER DETAILPAGE;
    public static final PLAYTRAILER PLAY;
    public static final PLAYTRAILER PLAYTRAILER;
    public static final PLAYTRAILER RESUME;
    private final int mLength;
    private final String mName;

    public static void performCommandForSegments(Activity activity, List list)
    {
        int j = list.size();
        if (j <= 5)
        {
            Log.e(AivHttpIntentActivity.access$100(), String.format("Not enough segments. %d required, %d provided. %s", new Object[] {
                Integer.valueOf(5), Integer.valueOf(j), list
            }));
            return;
        }
        String s = (String)list.get(5);
        <init> a_3C_init>[] = values();
        int k = a_3C_init>.length;
        for (int i = 0; i < k; i++)
        {
            <init> <init>1 = a_3C_init>[i];
            if (<init>1.mName.equals(s))
            {
                if (j >= <init>1.mLength)
                {
                    <init>1.performCommand(activity, list);
                    return;
                } else
                {
                    Log.e(AivHttpIntentActivity.access$100(), String.format("Command %s requires %d path elements. Only %d supplied.", new Object[] {
                        <init>1, Integer.valueOf(<init>1.mLength), Integer.valueOf(j)
                    }));
                    return;
                }
            }
        }

        Log.e(AivHttpIntentActivity.access$100(), String.format("Could not find command: %s, path: %s, available options: %s", new Object[] {
            s, list, Arrays.asList(values())
        }));
    }

    public static values valueOf(String s)
    {
        return (values)Enum.valueOf(com/amazon/mShop/aiv/AivHttpIntentActivity$Command, s);
    }

    public static values[] values()
    {
        return (values[])$VALUES.clone();
    }

    public abstract void performCommand(Activity activity, List list);

    static 
    {
        DETAILPAGE = new AivHttpIntentActivity.Command("DETAILPAGE", 0, "detailpage") {

            public void performCommand(Activity activity, List list)
            {
                ActivityUtils.launchDetailsPage(activity, new ProductController((String)list.get(3), ClickStreamTag.ORIGIN_DEFAULT), new int[0]);
            }

        };
        PLAY = new AivHttpIntentActivity.Command("PLAY", 1, "play") {

            public void performCommand(Activity activity, List list)
            {
                Log.e(AivHttpIntentActivity.access$100(), String.format("Operation %s not currently supported", new Object[] {
                    this
                }));
            }

        };
        RESUME = new AivHttpIntentActivity.Command("RESUME", 2, "resume", 6) {

            private static final int RESUME_POINT_POSITION = 5;

            public void performCommand(Activity activity, List list)
            {
                activity = (String)list.get(5);
                Log.e(AivHttpIntentActivity.access$100(), String.format("Operation %s not currently supported", new Object[] {
                    this
                }));
            }

        };
        PLAYTRAILER = new AivHttpIntentActivity.Command("PLAYTRAILER", 3, "playtrailer") {

            public void performCommand(Activity activity, List list)
            {
                Log.e(AivHttpIntentActivity.access$100(), String.format("Operation %s not currently supported", new Object[] {
                    this
                }));
            }

        };
        $VALUES = (new .VALUES[] {
            DETAILPAGE, PLAY, RESUME, PLAYTRAILER
        });
    }

    private _cls4(String s, int i, String s1)
    {
        this(s, i, s1, 5);
    }

    private <init>(String s, int i, String s1, int j)
    {
        super(s, i);
        mName = s1;
        mLength = j;
    }

    mLength(String s, int i, String s1, int j, mLength mlength)
    {
        this(s, i, s1, j);
    }

    <init>(String s, int i, String s1, <init> <init>1)
    {
        this(s, i, s1);
    }
}
