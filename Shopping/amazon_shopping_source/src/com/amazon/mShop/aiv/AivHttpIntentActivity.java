// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.ActivityUtils;
import java.util.Arrays;
import java.util.List;

public class AivHttpIntentActivity extends Activity
{
    static abstract class Command extends Enum
    {

        private static final Command $VALUES[];
        private static final int DEFAULT_LENGTH = 5;
        public static final Command DETAILPAGE;
        public static final Command PLAY;
        public static final Command PLAYTRAILER;
        public static final Command RESUME;
        private final int mLength;
        private final String mName;

        public static void performCommandForSegments(Activity activity, List list)
        {
            int j = list.size();
            if (j <= 5)
            {
                Log.e(AivHttpIntentActivity.TAG, String.format("Not enough segments. %d required, %d provided. %s", new Object[] {
                    Integer.valueOf(5), Integer.valueOf(j), list
                }));
                return;
            }
            String s = (String)list.get(5);
            Command acommand[] = values();
            int k = acommand.length;
            for (int i = 0; i < k; i++)
            {
                Command command = acommand[i];
                if (command.mName.equals(s))
                {
                    if (j >= command.mLength)
                    {
                        command.performCommand(activity, list);
                        return;
                    } else
                    {
                        Log.e(AivHttpIntentActivity.TAG, String.format("Command %s requires %d path elements. Only %d supplied.", new Object[] {
                            command, Integer.valueOf(command.mLength), Integer.valueOf(j)
                        }));
                        return;
                    }
                }
            }

            Log.e(AivHttpIntentActivity.TAG, String.format("Could not find command: %s, path: %s, available options: %s", new Object[] {
                s, list, Arrays.asList(values())
            }));
        }

        public static Command valueOf(String s)
        {
            return (Command)Enum.valueOf(com/amazon/mShop/aiv/AivHttpIntentActivity$Command, s);
        }

        public static Command[] values()
        {
            return (Command[])$VALUES.clone();
        }

        public abstract void performCommand(Activity activity, List list);

        static 
        {
            DETAILPAGE = new Command("DETAILPAGE", 0, "detailpage") {

                public void performCommand(Activity activity, List list)
                {
                    ActivityUtils.launchDetailsPage(activity, new ProductController((String)list.get(3), ClickStreamTag.ORIGIN_DEFAULT), new int[0]);
                }

            };
            PLAY = new Command("PLAY", 1, "play") {

                public void performCommand(Activity activity, List list)
                {
                    Log.e(AivHttpIntentActivity.TAG, String.format("Operation %s not currently supported", new Object[] {
                        this
                    }));
                }

            };
            RESUME = new Command("RESUME", 2, "resume", 6) {

                private static final int RESUME_POINT_POSITION = 5;

                public void performCommand(Activity activity, List list)
                {
                    activity = (String)list.get(5);
                    Log.e(AivHttpIntentActivity.TAG, String.format("Operation %s not currently supported", new Object[] {
                        this
                    }));
                }

            };
            PLAYTRAILER = new Command("PLAYTRAILER", 3, "playtrailer") {

                public void performCommand(Activity activity, List list)
                {
                    Log.e(AivHttpIntentActivity.TAG, String.format("Operation %s not currently supported", new Object[] {
                        this
                    }));
                }

            };
            $VALUES = (new Command[] {
                DETAILPAGE, PLAY, RESUME, PLAYTRAILER
            });
        }

        private Command(String s, int i, String s1)
        {
            this(s, i, s1, 5);
        }

        private Command(String s, int i, String s1, int j)
        {
            super(s, i);
            mName = s1;
            mLength = j;
        }


    }


    private static final int ASIN_POSITION = 3;
    private static final int COMMAND_POSITION = 5;
    private static final String TAG = com/amazon/mShop/aiv/AivHttpIntentActivity.getSimpleName();

    public AivHttpIntentActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Command.performCommandForSegments(this, getIntent().getData().getPathSegments());
        finish();
    }


}
