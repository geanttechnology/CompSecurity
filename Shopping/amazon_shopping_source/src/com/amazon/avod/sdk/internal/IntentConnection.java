// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.amazon.avod.sdk.CacheLevel;
import com.amazon.avod.sdk.CallResponse;
import com.amazon.avod.sdk.PlaybackSupportResponse;
import com.amazon.avod.sdk.ResponseHandler;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            AivConnection, ModulePath, IntentColumn, ItemIntentColumn

public class IntentConnection
    implements AivConnection
{
    private static class ActivityStarter
    {

        public void startActivity(Context context, Intent intent)
        {
            if (context instanceof Activity)
            {
                intent.setFlags(0x24000000);
                intent.setAction("android.intent.action.VIEW");
                ((Activity)context).startActivityForResult(intent, 0);
                return;
            } else
            {
                intent.setFlags(0x34000000);
                context.startActivity(intent);
                return;
            }
        }

        private ActivityStarter()
        {
        }

    }


    private static final String NO_ASIN_REQUIRED = null;
    private static final String NO_SELECTION = null;
    private static final String NO_SELECTION_ARGS[] = null;
    private static final String NO_SORT_ORDER = null;
    private final ActivityStarter mActivityStarter;
    private final Context mContext;
    private final Handler mUiHandler;

    IntentConnection(Context context)
    {
        this(context, new Handler(Looper.getMainLooper()), new ActivityStarter());
    }

    private IntentConnection(Context context, Handler handler, ActivityStarter activitystarter)
    {
        mContext = context;
        mUiHandler = handler;
        mActivityStarter = activitystarter;
    }

    private String getIntent(ModulePath modulepath, String s, IntentColumn intentcolumn)
    {
        return makeProviderRequest(String.format("%s/%s/%s", new Object[] {
            "content://com.amazon.avod.intent", modulepath.get(), s
        }), intentcolumn);
    }

    private String getIntent(ModulePath modulepath, String s, Map map, IntentColumn intentcolumn)
    {
        modulepath = new StringBuilder(String.format("%s/%s/%s", new Object[] {
            "content://com.amazon.avod.intent", modulepath.get(), s
        }));
        if (!map.isEmpty())
        {
            modulepath.append("?");
            for (s = map.entrySet().iterator(); s.hasNext(); modulepath.append(String.format("%s=%s&", new Object[] {
    map.getKey(), map.getValue()
})))
            {
                map = (java.util.Map.Entry)s.next();
            }

        }
        return makeProviderRequest(modulepath.toString(), intentcolumn);
    }

    private void goToApp(String s)
    {
        try
        {
            Log.i("AmazonInstantVideoSDK", String.format("Invoking AIV intent to go to app: %s", new Object[] {
                s
            }));
            Intent intent = Intent.parseUri(s, 0);
            mActivityStarter.startActivity(mContext, intent);
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            Log.e("AmazonInstantVideoSDK", String.format("AIV app provided invalid intent uri to activity launcher: %s", new Object[] {
                s
            }));
        }
    }

    private void informApp(String s, final ResponseHandler responseHandler)
    {
        try
        {
            Log.i("AmazonInstantVideoSDK", String.format("Invoking AIV intent to inform app: %s", new Object[] {
                s
            }));
            Intent intent = Intent.parseUri(s, 0);
            mContext.sendOrderedBroadcast(intent, "com.amazon.avod.SDK_ACCESS", new BroadcastReceiver() {

                final IntentConnection this$0;
                final ResponseHandler val$responseHandler;

                public void onReceive(Context context, Intent intent1)
                {
                    context = getResultExtras(true);
                    if (responseHandler != null)
                    {
                        responseHandler.handleResponse(CallResponse.fromBundle(context));
                    }
                }

            
            {
                this$0 = IntentConnection.this;
                responseHandler = responsehandler;
                super();
            }
            }, null, -1, null, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final ResponseHandler responseHandler)
        {
            Log.e("AmazonInstantVideoSDK", String.format("AIV app provided invalid intent uri to activity launcher: %s", new Object[] {
                s
            }));
        }
    }

    private static String join(String s, Iterable iterable)
    {
        StringBuilder stringbuilder = new StringBuilder();
        iterable = iterable.iterator();
        if (iterable.hasNext())
        {
            stringbuilder.append(iterable.next().toString());
            for (; iterable.hasNext(); stringbuilder.append(iterable.next().toString()))
            {
                stringbuilder.append(s);
            }

        }
        return stringbuilder.toString();
    }

    private String makeProviderRequest(String s, IntentColumn intentcolumn)
    {
        Object obj;
        obj = mContext.getContentResolver();
        Uri uri = Uri.parse(s);
        String s1 = intentcolumn.getColumnName();
        String s2 = NO_SELECTION;
        String as[] = NO_SELECTION_ARGS;
        String s3 = NO_SORT_ORDER;
        obj = ((ContentResolver) (obj)).query(uri, new String[] {
            s1
        }, s2, as, s3);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (!((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = ((Cursor) (obj)).getString(0);
        ((Cursor) (obj)).close();
        return s;
        ((Cursor) (obj)).close();
        Log.e("AmazonInstantVideoSDK", String.format("com.amazon.avod.intent content provider returned null or empty cursor {URI=%s COLUMN=%s}", new Object[] {
            s, intentcolumn
        }));
        return null;
        s;
        ((Cursor) (obj)).close();
        throw s;
    }

    public void disconnect()
    {
    }

    public void playVideo(String s, Map map)
    {
        goToApp(getIntent(ModulePath.ITEM, s, map, ItemIntentColumn.PLAY_VIDEO));
    }

    public void queryPlaybackSupport(final PlaybackSupportResponse callback)
    {
        final com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport support = com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport.FULL_SUPPORT;
        mUiHandler.post(new Runnable() {

            final IntentConnection this$0;
            final PlaybackSupportResponse val$callback;
            final com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport val$support;

            public void run()
            {
                callback.onPlaybackSupport(support);
            }

            
            {
                this$0 = IntentConnection.this;
                callback = playbacksupportresponse;
                support = playbacksupport;
                super();
            }
        });
    }

    public void teardownPreparedVideo(ResponseHandler responsehandler)
    {
        informApp(getIntent(ModulePath.ITEM, NO_ASIN_REQUIRED, ItemIntentColumn.TEARDOWN_PLAYER), responsehandler);
    }

    public boolean tryConnect()
    {
        return true;
    }

    public void whisperCacheContent(List list, CacheLevel cachelevel)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put("asinList", join(",", list));
        hashmap.put("whisperCacheLevel", cachelevel.toString());
        hashmap.put("entryPoint", "SDK");
        informApp(getIntent(ModulePath.ITEM, NO_ASIN_REQUIRED, hashmap, ItemIntentColumn.WHISPER_CACHE_CONTENT), null);
    }

}
