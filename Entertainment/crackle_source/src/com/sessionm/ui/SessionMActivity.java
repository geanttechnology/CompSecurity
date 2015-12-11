// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import com.sessionm.b.a;
import com.sessionm.core.f;
import com.sessionm.core.i;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.sessionm.ui:
//            ActivityController, ProgressViewController, SessionMViewContainer

public class SessionMActivity extends Activity
{

    public static final int FILE_CHOOSER_RESULT_CODE = 1;
    private static final String INTENT_PARAM_DATA = "com.sessionm.data";
    private static final String INTENT_PARAM_NOTIFY = "com.sessionm.notify";
    public static final String INTENT_PARAM_URL = "com.sessionm.url";
    private static final String TAG = "SessionM.Activity";
    private ActivityController controller;
    private boolean isInForeground;
    private ProgressViewController loadingIndicator;
    private boolean notifyAboutPresentation;
    private ValueCallback uploadFile;

    public SessionMActivity()
    {
        notifyAboutPresentation = true;
    }

    public static String convertSessionMUrl(String s)
    {
        Uri uri = Uri.parse(s);
        if (s == null)
        {
            return null;
        }
        s = f.E();
        if (uri.getHost().equals("ad"))
        {
            s = s.ac();
        } else
        {
            s = s.af();
        }
        return String.format(Locale.US, "%s/%s", new Object[] {
            s, uri.getPath()
        });
    }

    public static boolean isSessionMUrl(String s)
    {
        return s.startsWith(String.format(Locale.US, "sm%s", new Object[] {
            f.E().F()
        }));
    }

    private void loadContent()
    {
        if (controller.getState() == ActivityController.State.UNPRESENTABLE && !i.l(this))
        {
            loadingIndicator.setReloadPropmptState(ProgressViewController.ReloadPromptState.RELOAD);
            return;
        } else
        {
            controller.prepare(new ActivityController.PrepareListener() {

                final SessionMActivity this$0;

                public void onFailure(Throwable throwable)
                {
                    runOnUiThread(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            getLoadingIndicator().setReloadPropmptState(ProgressViewController.ReloadPromptState.RELOAD);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }

                public void onPrepared()
                {
                    dismissLoadingIndicator();
                    controller.displayView();
                }

            
            {
                this$0 = SessionMActivity.this;
                super();
            }
            });
            return;
        }
    }

    public static boolean startSessionMActivity(Context context, String s, a a1, boolean flag)
    {
        Intent intent = new Intent(context, com/sessionm/ui/SessionMActivity);
        if (!i.a(context, intent))
        {
            if (Log.isLoggable("SessionM.Activity", 6))
            {
                Log.e("SessionM.Activity", "Unable to resolve SessionMActivity. Please check that your manifest is setup correctly.");
            }
            return false;
        }
        Bundle bundle = new Bundle();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            bundle = ActivityOptions.makeCustomAnimation(context, 0x10a0002, 0x10a0003).toBundle();
        }
        bundle.putString("com.sessionm.url", s);
        if (a1 != null)
        {
            bundle.putString("com.sessionm.data", a1.aI().toString());
        }
        bundle.putBoolean("com.sessionm.notify", flag);
        intent.putExtras(bundle);
        context.startActivity(intent);
        return true;
    }

    protected void dismissLoadingIndicator()
    {
        loadingIndicator.dismiss();
        loadingIndicator = null;
    }

    public void finish()
    {
        finish(true);
    }

    void finish(boolean flag)
    {
        super.finish();
        if (flag && controller != null)
        {
            controller.dismiss();
        }
    }

    ProgressViewController getLoadingIndicator()
    {
        return loadingIndicator;
    }

    boolean isInForeground()
    {
        return isInForeground;
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        if (j != 1 || uploadFile == null)
        {
            return;
        }
        if (intent == null || k != -1)
        {
            intent = null;
        } else
        {
            intent = intent.getData();
        }
        uploadFile.onReceiveValue(intent);
        uploadFile = null;
    }

    public void onBackPressed()
    {
        if (controller == null)
        {
            if (Log.isLoggable("SessionM.Activity", 6))
            {
                Log.e("SessionM.Activity", String.format("null controller encountered while handling back button press. This shouldn't happen.", new Object[0]));
            }
            return;
        }
        if (controller.isBrowserDisplayed())
        {
            controller.dismissBrowser();
            return;
        } else
        {
            controller.dismiss();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        overridePendingTransition(0x10a0002, 0x10a0003);
        if (controller != null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        obj = getIntent();
        bundle = ((Intent) (obj)).getExtras();
        if (((Intent) (obj)).getAction() != "android.intent.action.VIEW") goto _L2; else goto _L1
_L1:
        bundle = ((Intent) (obj)).getData().toString();
        if (bundle == null || !isSessionMUrl(bundle)) goto _L4; else goto _L3
_L3:
        bundle = convertSessionMUrl(bundle);
        if (bundle != null) goto _L6; else goto _L5
_L5:
        finish();
_L9:
        return;
_L4:
        finish();
        return;
_L2:
        if (bundle != null)
        {
            String s = bundle.getString("com.sessionm.url");
            obj = bundle.getString("com.sessionm.data");
            if (notifyAboutPresentation)
            {
                notifyAboutPresentation = bundle.getBoolean("com.sessionm.notify");
            }
            bundle = s;
            if (s == null)
            {
                finish();
                return;
            }
        } else
        {
            finish();
            return;
        }
          goto _L7
_L6:
        obj = null;
_L7:
        controller = ActivityController.createActivityController(true, this, bundle, new Object[] {
            a.w(((String) (obj)))
        });
        f.E().a(controller);
_L10:
        loadingIndicator = new ProgressViewController(this, new ProgressViewController.Listener() {

            final SessionMActivity this$0;

            public void onCancel()
            {
                finish();
            }

            public void onReloadStarted()
            {
                loadContent();
            }

            
            {
                this$0 = SessionMActivity.this;
                super();
            }
        });
        bundle = controller.getViewContainer().getViewGroup();
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        bundle.setVisibility(4);
        relativelayout.addView(bundle);
        setContentView(relativelayout);
        bundle = controller.getState();
        if (bundle == ActivityController.State.DISMISSED || bundle == ActivityController.State.LOADED_CONTENT)
        {
            loadingIndicator.present(ProgressViewController.ReloadPromptState.LOADING);
            loadContent();
        } else
        if (bundle == ActivityController.State.LOADED_WEBVIEW)
        {
            if (f.E().getSessionState().isStarted())
            {
                controller.displayView();
            } else
            {
                loadingIndicator.setReloadPropmptState(ProgressViewController.ReloadPromptState.UNAVAILABLE);
            }
        } else
        if (bundle != ActivityController.State.PRESENTED)
        {
            loadingIndicator.present(ProgressViewController.ReloadPromptState.LOADING);
        }
        if (!controller.isBrowserDisplayed()) goto _L9; else goto _L8
_L8:
        controller.presentBrowser(null);
        return;
        controller.resetWebView();
          goto _L10
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (loadingIndicator != null)
        {
            loadingIndicator.dismiss();
        }
    }

    protected void onPause()
    {
        super.onPause();
        isInForeground = false;
        if (controller != null)
        {
            controller.notifyActivityPaused();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (notifyAboutPresentation)
        {
            f.E().ar();
            notifyAboutPresentation = false;
        }
        isInForeground = true;
        if (loadingIndicator == null || !loadingIndicator.isPresented() || !loadingIndicator.isReloadPromptState()) goto _L2; else goto _L1
_L1:
        if (!f.E().getSessionState().isStarted()) goto _L4; else goto _L3
_L3:
        loadingIndicator.setReloadPropmptState(ProgressViewController.ReloadPromptState.LOADING);
        loadContent();
_L6:
        return;
_L4:
        loadingIndicator.setReloadPropmptState(ProgressViewController.ReloadPromptState.UNAVAILABLE);
        return;
_L2:
        if (controller != null)
        {
            controller.notifyActivityResumed();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onStart()
    {
        super.onStart();
    }

    void pushActivityController(ActivityController activitycontroller)
    {
        if (Log.isLoggable("SessionM.Activity", 3))
        {
            Log.d("SessionM.Activity", String.format(Locale.US, "pushing activity controller: %s", new Object[] {
                activitycontroller
            }));
        }
        f.E().b(controller);
        controller = activitycontroller;
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        relativelayout.addView(activitycontroller.getViewContainer().getViewGroup());
        setContentView(relativelayout);
    }

    void setUploadFile(ValueCallback valuecallback)
    {
        uploadFile = valuecallback;
    }


}
