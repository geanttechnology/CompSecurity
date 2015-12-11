// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.Window;
import com.playhaven.android.Placement;
import com.playhaven.android.PlacementListener;
import com.playhaven.android.PlayHaven;
import com.playhaven.android.PlayHavenException;
import com.playhaven.android.compat.VendorCompat;
import com.playhaven.android.util.DisplayUtil;
import com.playhaven.android.util.JsonUtil;
import java.util.List;
import net.minidev.json.JSONObject;

// Referenced classes of package com.playhaven.android.view:
//            PlayHavenListener, FrameManager, PlayHavenView

public class FullScreen extends Activity
    implements PlayHavenListener, FrameManager
{

    private static final String TIMESTAMP = "closed.timestamp";
    private static PlacementListener dismissListener;
    private VendorCompat compat;
    private boolean fullscreenFlagCleared;
    private OrientationEventListener orientation;
    private Intent result;

    public FullScreen()
    {
        fullscreenFlagCleared = false;
    }

    public static boolean callerIsFullscreen(Context context)
    {
        if (context instanceof Activity)
        {
            return (((Activity)context).getWindow().getAttributes().flags & 0x400) != 0;
        } else
        {
            PlayHaven.v("Unable to retrieve window flags without an Activity context.", new Object[0]);
            return true;
        }
    }

    public static Intent createIntent(Context context, Placement placement)
    {
        return createIntent(context, placement, 1);
    }

    public static Intent createIntent(Context context, Placement placement, int i)
    {
        Intent intent = new Intent(context, com/playhaven/android/view/FullScreen);
        intent.putExtra("placement", placement);
        intent.putExtra("displayOptions", i);
        intent.putExtra(com.playhaven.android.PlayHaven.Config.FullScreen.toString(), callerIsFullscreen(context));
        return intent;
    }

    public static Intent createIntent(Context context, Placement placement, PlacementListener placementlistener)
    {
        dismissListener = placementlistener;
        return createIntent(context, placement, 1);
    }

    public static Intent createIntent(Context context, String s)
    {
        return createIntent(context, s, 1);
    }

    public static Intent createIntent(Context context, String s, int i)
    {
        Intent intent = new Intent(context, com/playhaven/android/view/FullScreen);
        intent.putExtra("placementTag", s);
        intent.putExtra("displayOptions", i);
        intent.putExtra(com.playhaven.android.PlayHaven.Config.FullScreen.toString(), callerIsFullscreen(context));
        return intent;
    }

    public static boolean timeElapsed(Context context, long l)
    {
        for (long l1 = PlayHaven.getPreferences(context).getLong("closed.timestamp", 0L); l1 == 0L || System.currentTimeMillis() - l1 >= l;)
        {
            return true;
        }

        return false;
    }

    public void doResult(int i, Intent intent, PlayHavenView playhavenview)
    {
        if (playhavenview != null)
        {
            intent.putExtra("placement", playhavenview.getPlacement());
            intent.putExtra("placementTag", playhavenview.getPlacementTag());
            intent.putExtra("displayOptions", playhavenview.getDisplayOptions());
        }
        setResult(i, intent);
    }

    public void finish()
    {
        if (orientation != null)
        {
            orientation.disable();
        }
        if (result == null && compat != null)
        {
            result = new Intent();
            PlayHavenView playhavenview = (PlayHavenView)findViewById(compat.getId(getApplicationContext(), com.playhaven.android.compat.VendorCompat.ID.playhaven_activity_view));
            result.putExtra("dismissType", PlayHavenView.DismissType.SelfClose);
            doResult(-1, result, playhavenview);
        }
        storeTimestamp();
        super.finish();
    }

    public void onBackPressed()
    {
        PlayHavenView playhavenview = (PlayHavenView)findViewById(compat.getId(getApplicationContext(), com.playhaven.android.compat.VendorCompat.ID.playhaven_activity_view));
        if (playhavenview != null)
        {
            playhavenview.dismissView(PlayHavenView.DismissType.BackButton);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if ((0x100000 & getIntent().getFlags()) != 0)
        {
            compat = PlayHaven.getVendorCompat(this);
            finish();
        } else
        {
            requestWindowFeature(1);
            compat = PlayHaven.getVendorCompat(this);
            if (getIntent().getBooleanExtra(com.playhaven.android.PlayHaven.Config.FullScreen.toString(), true))
            {
                getWindow().addFlags(1024);
            }
            setContentView(compat.getLayoutId(getApplicationContext(), com.playhaven.android.compat.VendorCompat.LAYOUT.playhaven_activity));
            bundle = (PlayHavenView)findViewById(compat.getId(getApplicationContext(), com.playhaven.android.compat.VendorCompat.ID.playhaven_activity_view));
            bundle.setPlayHavenListener(this);
            bundle.setFrameManager(this);
            Object obj = getIntent().getData();
            if (obj != null)
            {
                Object obj1 = ((Uri) (obj)).getPathSegments();
                if (((List) (obj1)).size() == 1)
                {
                    PlayHaven.d("path[0]: %s", new Object[] {
                        ((List) (obj1)).get(0)
                    });
                }
                try
                {
                    bundle.setDisplayOptions(Integer.parseInt(((Uri) (obj)).getQueryParameter("displayOptions")));
                }
                catch (NumberFormatException numberformatexception) { }
                bundle.setPlacementTag(((Uri) (obj)).getQueryParameter("placementTag"));
            }
            obj = getIntent().getExtras();
            if (obj != null)
            {
                bundle.setDisplayOptions(((Bundle) (obj)).getInt("displayOptions"));
                obj1 = (Placement)((Bundle) (obj)).getParcelable("placement");
                if (obj1 != null)
                {
                    bundle.setPlacement(((Placement) (obj1)));
                } else
                {
                    obj = ((Bundle) (obj)).getString("placementTag");
                    if (obj != null)
                    {
                        bundle.setPlacementTag(((String) (obj)));
                    } else
                    {
                        viewFailed(bundle, new PlayHavenException("FullScreen was launched without a valid placement or tag."));
                    }
                }
            }
            if (orientation == null)
            {
                orientation = new OrientationEventListener(this) {

                    final FullScreen this$0;

                    public void onOrientationChanged(int i)
                    {
                        updateFrame();
                    }

            
            {
                this$0 = FullScreen.this;
                super(context);
            }
                };
                orientation.enable();
                return;
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        PlayHavenView playhavenview = (PlayHavenView)findViewById(compat.getId(getApplicationContext(), com.playhaven.android.compat.VendorCompat.ID.playhaven_activity_view));
        if (playhavenview != null)
        {
            playhavenview.onPause();
            playhavenview.dismissView(PlayHavenView.DismissType.AppClose);
        }
    }

    protected void storeTimestamp()
    {
        android.content.SharedPreferences.Editor editor = PlayHaven.getPreferences(this).edit();
        editor.putLong("closed.timestamp", System.currentTimeMillis());
        editor.commit();
    }

    public void updateFrame()
    {
        if (compat != null) goto _L2; else goto _L1
_L1:
        PlayHavenView playhavenview;
        return;
_L2:
        Object obj;
        Object obj1;
        if ((playhavenview = (PlayHavenView)findViewById(compat.getId(this, com.playhaven.android.compat.VendorCompat.ID.playhaven_activity_view))) == null || (obj = playhavenview.getPlacement()) == null || (obj1 = ((Placement) (obj)).getModel()) == null) goto _L1; else goto _L3
_L3:
        if (((Placement) (obj)).isFullscreenCompatible() && !fullscreenFlagCleared)
        {
            getWindow().clearFlags(1024);
            PlayHaven.v("Placement should not be displayed fullscreen, clearing flag.", new Object[0]);
            fullscreenFlagCleared = true;
        }
        obj1 = (JSONObject)JsonUtil.getPath(((String) (obj1)), "$.response.frame");
        if (obj1 == null) goto _L1; else goto _L4
_L4:
        int i;
        int j;
        int k;
        int l;
        if (DisplayUtil.isPortrait(this))
        {
            obj = "$.PH_PORTRAIT";
        } else
        {
            obj = "$.PH_LANDSCAPE";
        }
        obj = (JSONObject)JsonUtil.getPath(((JSONObject) (obj1)), ((String) (obj)));
        i = JsonUtil.asInt(((JSONObject) (obj)), "$.x", 0);
        j = JsonUtil.asInt(((JSONObject) (obj)), "$.y", 0);
        if (i == 0 && j == 0) goto _L1; else goto _L5
_L5:
        k = JsonUtil.asInt(((JSONObject) (obj)), "$.w", 0);
        l = JsonUtil.asInt(((JSONObject) (obj)), "$.h", 0);
        obj = (android.view.ViewGroup.MarginLayoutParams)playhavenview.getLayoutParams();
        obj.height = l;
        obj.width = k;
        obj.leftMargin = i;
        obj.topMargin = j;
        if (android.os.Build.VERSION.SDK_INT != 10) goto _L7; else goto _L6
_L6:
        if (!(obj instanceof android.widget.LinearLayout.LayoutParams)) goto _L9; else goto _L8
_L8:
        ((android.widget.LinearLayout.LayoutParams)obj).gravity = 48;
_L7:
        playhavenview.requestLayout();
        return;
_L9:
        if (obj instanceof android.widget.FrameLayout.LayoutParams)
        {
            ((android.widget.FrameLayout.LayoutParams)obj).gravity = 48;
        }
        if (true) goto _L7; else goto _L10
_L10:
    }

    public void viewDismissed(PlayHavenView playhavenview, PlayHavenView.DismissType dismisstype, Bundle bundle)
    {
        if (dismissListener != null)
        {
            dismissListener.contentDismissed(playhavenview.getPlacement(), dismisstype, bundle);
        }
        result = new Intent();
        result.putExtra("dismissType", dismisstype);
        if (bundle != null)
        {
            result.putExtra("data", bundle);
        }
        doResult(-1, result, playhavenview);
        finish();
    }

    public void viewFailed(PlayHavenView playhavenview, PlayHavenException playhavenexception)
    {
        result = new Intent();
        result.putExtra("dismissType", PlayHavenView.DismissType.SelfClose);
        result.putExtra("exception", playhavenexception);
        doResult(0, result, playhavenview);
        finish();
    }
}
