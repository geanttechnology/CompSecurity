// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.cast.MediaInfo;
import com.google.sample.castcompanionlibrary.utils.Utils;
import com.gotv.crackle.data.ChannelDetails;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.model.ChannelItem;
import com.gotv.crackle.model.MediaDetailsItem;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle:
//            ShowWatchlistDetailsActivity, ChromeCastingDetailsActivity, MovieDetailsActivity, LoadingActivity

public class DetailsActivityResolver extends Activity
    implements com.gotv.crackle.data.DataRequest.DataRequestListener
{
    public static final class ActionType extends Enum
    {

        private static final ActionType $VALUES[];
        public static final ActionType CRACKLE_DEEPLINK;
        public static final ActionType NONE;
        public static final ActionType URI_DEEPLINK;
        public static final ActionType YOSEMITE_DEEPLINK;

        public static ActionType valueOf(String s)
        {
            return (ActionType)Enum.valueOf(com/gotv/crackle/DetailsActivityResolver$ActionType, s);
        }

        public static ActionType[] values()
        {
            return (ActionType[])$VALUES.clone();
        }

        static 
        {
            CRACKLE_DEEPLINK = new ActionType("CRACKLE_DEEPLINK", 0);
            YOSEMITE_DEEPLINK = new ActionType("YOSEMITE_DEEPLINK", 1);
            URI_DEEPLINK = new ActionType("URI_DEEPLINK", 2);
            NONE = new ActionType("NONE", 3);
            $VALUES = (new ActionType[] {
                CRACKLE_DEEPLINK, YOSEMITE_DEEPLINK, URI_DEEPLINK, NONE
            });
        }

        private ActionType(String s, int i)
        {
            super(s, i);
        }
    }


    public static String COMMAND = "COMMAND";
    private static final String CRACKLE_DEEPLINK_ACTION = "com.gotv.crackle.DEEPLINK";
    public static final String HEADER_TEXT_EXTRA = "HEADER_TEXT";
    public static final String MEDIA_ITEM_ID = "MEDIA_ITEM_ID";
    public static String PURCHASE_HD_BUY = "HD_BUY";
    public static String PURCHASE_HD_RENT = "HD_RENT";
    public static String PURCHASE_SD_BUY = "SD_BUY";
    public static String PURCHASE_SD_RENT = "SD_RENT";
    public static final String START_PLAYING_EXTRA = "START_PLAYING";
    public static final String SUPPRESS_RESUME_PROMPT_EXTRA = "SUPPRESS_RESUME_PROMPT";
    private ActionType mActionType;
    private ChannelDetails mChannelDetailsRequest;
    private String mChannelID;
    private MediaDetailsRequest mMediaDetailsRequest;
    private String mMediaID;
    private Intent mOriginalIntent;
    private boolean mStartPlaying;

    public DetailsActivityResolver()
    {
    }

    private void handleDirectIntent(Intent intent)
    {
        Bundle bundle = intent.getBundleExtra("media");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        intent = Utils.toMediaInfo(bundle).getCustomData();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        try
        {
            intent = intent.getJSONObject("media");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        mMediaID = intent.getString("ID");
        mChannelID = intent.getString("parentChannelID");
        mStartPlaying = true;
        return;
        mMediaID = intent.getStringExtra("MEDIA_ITEM_ID");
        mChannelID = intent.getStringExtra("ID");
        mStartPlaying = intent.getBooleanExtra("START_PLAYING", false);
        return;
    }

    private boolean handleUriIntent(Intent intent)
    {
        Object obj;
        mMediaID = null;
        obj = intent.getData();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ("IMMEDIATE_PLAYBACK".equals(intent.getStringExtra(COMMAND)))
        {
            mStartPlaying = true;
        }
        if (uriContainsMediaOrChannelId(((Uri) (obj))))
        {
            return true;
        }
        obj = ((Uri) (obj)).toString();
        intent = null;
        obj = URLDecoder.decode(((String) (obj)), "utf-8");
        intent = ((Intent) (obj));
_L4:
        if (intent != null && uriContainsMediaOrChannelId(Uri.parse(intent)))
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
          goto _L4
    }

    private boolean handleYosemiteIntent(Intent intent)
    {
        mMediaID = null;
        if (intent != null && "START_BY_YOSEMITE".equals(intent.getStringExtra("CONTROL")) && "IMMEDIATE_PLAYBACK".equals(intent.getStringExtra(COMMAND)))
        {
            mMediaID = intent.getStringExtra("CONTENT_ID");
            mStartPlaying = true;
        }
        return mMediaID != null;
    }

    private void loadData()
    {
        if (mChannelID != null)
        {
            mChannelDetailsRequest = new ChannelDetails(this, mChannelID);
            return;
        }
        if (mMediaID != null)
        {
            mMediaDetailsRequest = new MediaDetailsRequest(this, mMediaID);
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected boolean isInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030079);
        mActionType = ActionType.NONE;
        mOriginalIntent = getIntent();
        if (handleYosemiteIntent(mOriginalIntent))
        {
            mActionType = ActionType.YOSEMITE_DEEPLINK;
        } else
        if (handleUriIntent(mOriginalIntent))
        {
            mActionType = ActionType.URI_DEEPLINK;
        } else
        {
            handleDirectIntent(mOriginalIntent);
        }
        if (mOriginalIntent.getAction() != null && mOriginalIntent.getAction().equalsIgnoreCase("com.gotv.crackle.DEEPLINK"))
        {
            mActionType = ActionType.CRACKLE_DEEPLINK;
        }
        loadData();
    }

    public void onDataFailed(String s, final String Message)
    {
        runOnUiThread(new Runnable() {

            final DetailsActivityResolver this$0;
            final String val$Message;

            public void run()
            {
                if (mActionType == ActionType.NONE)
                {
                    (new android.app.AlertDialog.Builder(DetailsActivityResolver.this)).setIcon(0x1080027).setMessage(Message).setNegativeButton(getResources().getString(0x7f0b00a5), new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            loadData();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            finish();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).create().show();
                    return;
                } else
                {
                    (new android.app.AlertDialog.Builder(DetailsActivityResolver.this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b0114)).setNegativeButton(getResources().getString(0x7f0b0115), new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            finish();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).setPositiveButton(getResources().getString(0x7f0b0116), new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            dialoginterface = new Intent(_fld0, com/gotv/crackle/LoadingActivity);
                            dialoginterface.setFlags(0x10000000);
                            startActivity(dialoginterface);
                            finish();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).create().show();
                    return;
                }
            }

            
            {
                this$0 = DetailsActivityResolver.this;
                Message = s;
                super();
            }
        });
    }

    public void onDataSuccess(final String tag)
    {
        runOnUiThread(new Runnable() {

            final DetailsActivityResolver this$0;
            final String val$tag;

            public void run()
            {
                Intent intent1;
                Object obj;
                intent1 = null;
                obj = null;
                if (!tag.equalsIgnoreCase("MediaDetails")) goto _L2; else goto _L1
_L1:
                MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
                if (!mediadetailsitem.getRootChannelID().equalsIgnoreCase("46") && !mediadetailsitem.getRootChannelID().equalsIgnoreCase("114")) goto _L4; else goto _L3
_L3:
                Intent intent;
                String s;
                s = "shows";
                intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ShowWatchlistDetailsActivity);
                mChannelID = mediadetailsitem.getParentChannelID();
_L6:
                intent1 = intent;
                if (ChromeCastHelper.getInstance(DetailsActivityResolver.this).isConnected())
                {
                    intent1 = intent;
                    if (mStartPlaying)
                    {
                        intent1 = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ChromeCastingDetailsActivity);
                        intent1.addFlags(0x20000);
                    }
                }
                if (intent1 != null)
                {
                    if (mChannelID != null)
                    {
                        intent1.putExtra("ID", mChannelID);
                    }
                    if (mMediaID != null)
                    {
                        intent1.putExtra("MEDIA_ITEM_ID", mMediaID);
                    }
                    intent1.putExtra("EXTRA_CATEGORY", s);
                    intent1.putExtra("START_PLAYING", mStartPlaying);
                    startActivity(intent1);
                }
                finish();
                return;
_L4:
                s = obj;
                intent = intent1;
                if (mediadetailsitem.getRootChannelID().equalsIgnoreCase("82"))
                {
                    s = "movies";
                    intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/MovieDetailsActivity);
                    mChannelID = mediadetailsitem.getParentChannelID();
                }
                continue; /* Loop/switch isn't completed */
_L2:
                s = obj;
                intent = intent1;
                if (tag.equalsIgnoreCase("ChannelDetails"))
                {
                    ChannelItem channelitem = mChannelDetailsRequest.getItem();
                    if (channelitem.getRrootChannelID().equalsIgnoreCase("46") || channelitem.getRrootChannelID().equalsIgnoreCase("114"))
                    {
                        s = "shows";
                        intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ShowWatchlistDetailsActivity);
                    } else
                    if (channelitem.getRrootChannelID().equalsIgnoreCase("82"))
                    {
                        s = "movies";
                        intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/MovieDetailsActivity);
                    } else
                    {
                        s = obj;
                        intent = intent1;
                        if (channelitem.getRrootChannelID().equalsIgnoreCase("586"))
                        {
                            s = "watchlists";
                            intent = new Intent(DetailsActivityResolver.this, com/gotv/crackle/ShowWatchlistDetailsActivity);
                        }
                    }
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = DetailsActivityResolver.this;
                tag = s;
                super();
            }
        });
    }

    protected boolean uriContainsMediaOrChannelId(Uri uri)
    {
        String s = uri.getHost();
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s1 = uri.getQueryParameter("play");
        boolean flag;
        if (s1 != null && s1.equals("1"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mStartPlaying = flag;
        if (uri.getPathSegments().size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s.equalsIgnoreCase("Media"))
        {
            break; /* Loop/switch isn't completed */
        }
        uri = (String)uri.getPathSegments().get(0);
        if (isInteger(uri))
        {
            mMediaID = uri;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!s.equalsIgnoreCase("Channel"))
        {
            continue; /* Loop/switch isn't completed */
        }
        uri = (String)uri.getPathSegments().get(0);
        if (!isInteger(uri)) goto _L1; else goto _L4
_L4:
        mChannelID = uri;
        return true;
        if (!s.equalsIgnoreCase("www.crackle.com")) goto _L1; else goto _L5
_L5:
        uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 1);
        if (isInteger(uri))
        {
            mMediaID = uri;
            return true;
        } else
        {
            mChannelID = uri;
            return true;
        }
    }





/*
    static String access$102(DetailsActivityResolver detailsactivityresolver, String s)
    {
        detailsactivityresolver.mChannelID = s;
        return s;
    }

*/





}
