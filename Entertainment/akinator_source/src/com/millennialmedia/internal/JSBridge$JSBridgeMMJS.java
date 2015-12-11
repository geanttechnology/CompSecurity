// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.CalendarUtils;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.JSONUtils;
import com.millennialmedia.internal.utils.MediaUtils;
import com.millennialmedia.internal.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class this._cls0
{

    final JSBridge this$0;

    public void addCalendarEvent(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: addCalendarEvent(").append(s).append(")").toString());
        }
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        jsonobject = jsonobject.optJSONObject("options");
        if (jsonobject == null)
        {
            MMLog.e(JSBridge.access$000(), "No options provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        } else
        {
    /* block-local class not found */
    class _cls1 {}

            CalendarUtils.addEvent(mmwebview.getContext(), jsonobject, new _cls1(s, mmwebview));
            return;
        }
    }

    public void call(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: call(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        obj = ((JSONObject) (obj)).optString("number", null);
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No number provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("tel:").append(((String) (obj))).toString()));
        boolean flag = Utils.startActivity(EnvironmentUtils.getApplicationContext(), ((Intent) (obj)));
        if (flag)
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
        }
        invokeCallback(s, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void email(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: email(").append(s).append(")").toString());
        }
        JSONObject jsonobject = new JSONObject(s);
        String s1 = jsonobject.optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        JSONArray jsonarray1 = null;
        JSONArray jsonarray = null;
        s = null;
        Object obj = jsonobject.optJSONObject("recipients");
        if (obj != null)
        {
            jsonarray1 = ((JSONObject) (obj)).optJSONArray("to");
            jsonarray = ((JSONObject) (obj)).optJSONArray("cc");
            s = ((JSONObject) (obj)).optJSONArray("bcc");
        }
        obj = jsonobject.optString("subject", null);
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No subject provided");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        String s2 = jsonobject.optString("message", null);
        if (s2 == null)
        {
            MMLog.e(JSBridge.access$000(), "No message provided");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(jsonobject.optString("type", "text/plain"));
        if (jsonarray1 != null)
        {
            intent.putExtra("android.intent.extra.EMAIL", JSONUtils.convertToStringArray(jsonarray1));
        }
        if (jsonarray != null)
        {
            intent.putExtra("android.intent.extra.CC", JSONUtils.convertToStringArray(jsonarray));
        }
        if (s != null)
        {
            intent.putExtra("android.intent.extra.BCC", JSONUtils.convertToStringArray(s));
        }
        intent.putExtra("android.intent.extra.SUBJECT", ((String) (obj)));
        intent.putExtra("android.intent.extra.TEXT", s2);
        boolean flag = Utils.startActivity(EnvironmentUtils.getApplicationContext(), intent);
        if (flag)
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
        }
        invokeCallback(s1, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void getAvailableSourceTypes(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: getAvailableSourceTypes(").append(s).append(")").toString());
        }
        s = (new JSONObject(s)).optString("callbackId", null);
        JSONArray jsonarray = new JSONArray();
        com.millennialmedia.internal.utils.ableCameras ablecameras = EnvironmentUtils.getAvailableCameras();
        if (ablecameras.backCamera)
        {
            jsonarray.put("Rear Camera");
        }
        if (ablecameras.frontCamera)
        {
            jsonarray.put("Front Camera");
        }
        if (ablecameras.frontCamera || ablecameras.backCamera)
        {
            jsonarray.put("Camera");
        }
        if (MediaUtils.isPictureChooserAvailable())
        {
            jsonarray.put("Photo Library");
        }
        invokeCallback(s, new Object[] {
            jsonarray
        });
    }

    public void getPictureFromPhotoLibrary(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: getPictureFromPhotoLibrary(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        }
        obj = ((JSONObject) (obj)).optJSONObject("size");
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No size parameters provided");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        }
        android.util.DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
        int i = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxWidth", 0), displaymetrics);
        int j = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxHeight", 0), displaymetrics);
        boolean flag = ((JSONObject) (obj)).optBoolean("maintainAspectRatio", true);
        if (i <= 0 || j <= 0)
        {
            MMLog.e(JSBridge.access$000(), "maxWidth and maxHeight must be > 0");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        }
        obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        } else
        {
    /* block-local class not found */
    class _cls2 {}

            MediaUtils.getPhotoFromGallery(((MMWebView) (obj)).getContext(), new _cls2(i, j, flag, s));
            return;
        }
    }

    public void isPackageAvailable(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: isPackageAvailable(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        obj = ((JSONObject) (obj)).optString("name", null);
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "name was not provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        } else
        {
            boolean flag = Utils.isPackageAvailable(((String) (obj)));
            invokeCallback(s, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
    }

    public void isSchemeAvailable(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: isSchemeAvailable(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        obj = ((JSONObject) (obj)).optString("name", null);
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "name was not provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        } else
        {
            boolean flag = Utils.isSchemeAvailable(((String) (obj)));
            invokeCallback(s, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
    }

    public void isSourceTypeAvailable(String s)
        throws JSONException
    {
        Object obj;
        boolean flag;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: isSourceTypeAvailable(").append(s).append(")").toString());
        }
        obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        obj = ((JSONObject) (obj)).optString("sourceType", null);
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "sourceType was not provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        flag = false;
        if (!"Photo Library".equals(obj)) goto _L2; else goto _L1
_L1:
        flag = MediaUtils.isPictureChooserAvailable();
_L4:
        invokeCallback(s, new Object[] {
            Boolean.valueOf(flag)
        });
        return;
_L2:
        com.millennialmedia.internal.utils.ableCameras ablecameras = EnvironmentUtils.getAvailableCameras();
        if ("Camera".equals(obj))
        {
            if (ablecameras.frontCamera || ablecameras.backCamera)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if ("Rear Camera".equals(obj))
        {
            flag = ablecameras.backCamera;
        } else
        if ("Front Camera".equals(obj))
        {
            flag = ablecameras.frontCamera;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void location(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: location(").append(s).append(")").toString());
        }
        s = (new JSONObject(s)).optString("callbackId", null);
        Location location1 = EnvironmentUtils.getLocation();
        if (location1 == null)
        {
            invokeCallback(s, new Object[] {
                null
            });
            return;
        } else
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("latitude", location1.getLatitude());
            jsonobject.put("longitude", location1.getLongitude());
            jsonobject.put("altitude", location1.getAltitude());
            jsonobject.put("accuracy", location1.getAccuracy());
            jsonobject.put("altitudeAccuracy", 0.0D);
            jsonobject.put("heading", location1.getBearing());
            jsonobject.put("speed", location1.getSpeed());
            invokeCallback(s, new Object[] {
                jsonobject
            });
            return;
        }
    }

    public void openAppStore(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: openAppStore(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        String s1 = s.optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false), "Ad has not been clicked"
            });
            return;
        }
        s = s.optString("appId", null);
        if (s == null)
        {
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false), "appId was not provided"
            });
            return;
        }
        if (Build.MANUFACTURER.equals("Amazon"))
        {
            s = (new StringBuilder()).append("amzn://apps/android?p=").append(s).toString();
        } else
        {
            s = (new StringBuilder()).append("market://details?id=").append(s).toString();
        }
        if (Utils.startActivityFromUrl(s))
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        } else
        {
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false), "Unable to open app store"
            });
            return;
        }
    }

    public void openCamera(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: openCamera(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        }
        obj = ((JSONObject) (obj)).optJSONObject("size");
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No size parameters provided");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        }
        android.util.DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
        int i = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxWidth", 0), displaymetrics);
        int j = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxHeight", 0), displaymetrics);
        boolean flag = ((JSONObject) (obj)).optBoolean("maintainAspectRatio", true);
        if (i <= 0 || j <= 0)
        {
            MMLog.e(JSBridge.access$000(), "maxWidth and maxHeight must be > 0");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        }
        obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(s, new Object[] {
                null
            });
            return;
        } else
        {
    /* block-local class not found */
    class _cls3 {}

            MediaUtils.getPhotoFromCamera(((MMWebView) (obj)).getContext(), new _cls3(i, j, flag, s));
            return;
        }
    }

    public void openInBrowser(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: openInBrowser(").append(s).append(")").toString());
        }
        s = new JSONObject(s);
        String s1 = s.optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        boolean flag = Utils.startActivityFromUrl(s.optString("url", null));
        if (flag)
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
        }
        invokeCallback(s1, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void openMap(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: openMap(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        String s1 = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        if (((JSONObject) (obj)).has("address"))
        {
            s = ((JSONObject) (obj)).optString("address");
            try
            {
                s = (new StringBuilder()).append("geo:0,0?q=").append(URLEncoder.encode(s, "utf-8")).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                invokeCallback(s1, new Object[] {
                    Boolean.valueOf(false), "Unable to encode address"
                });
                return;
            }
        } else
        if (((JSONObject) (obj)).has("longitude") && ((JSONObject) (obj)).has("latitude"))
        {
            s = Double.valueOf(((JSONObject) (obj)).optDouble("latitude"));
            obj = Double.valueOf(((JSONObject) (obj)).optDouble("longitude"));
            s = String.format("geo:%f,%f?q=%f,%f", new Object[] {
                s, obj, s, obj
            });
        } else
        {
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false), "address or latitude and longitude must be specified"
            });
            return;
        }
        if (Utils.startActivityFromUrl(s))
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        } else
        {
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false), "Unable to open map"
            });
            return;
        }
    }

    public void savePictureToPhotoLibrary(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: savePictureToPhotoLibrary(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        String s1 = ((JSONObject) (obj)).optString("name", null);
        String s2 = ((JSONObject) (obj)).optString("description", null);
        obj = ((JSONObject) (obj)).optString("url", null);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            MMLog.e(JSBridge.access$000(), "No path specified for photo");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        } else
        {
    /* block-local class not found */
    class _cls4 {}

            MediaUtils.savePicture(mmwebview.getContext(), ((String) (obj)), s1, new _cls4(s2, mmwebview, s));
            return;
        }
    }

    public void sms(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: sms(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        Object obj1 = ((JSONObject) (obj)).optJSONArray("recipients");
        if (obj1 == null || ((JSONArray) (obj1)).length() == 0)
        {
            MMLog.e(JSBridge.access$000(), "No recipients provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        obj = ((JSONObject) (obj)).optString("message", null);
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No message provided");
            invokeCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        obj1 = TextUtils.join(",", JSONUtils.convertToStringArray(((JSONArray) (obj1))));
        obj1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("sms:").append(((String) (obj1))).toString()));
        ((Intent) (obj1)).putExtra("sms_body", ((String) (obj)));
        boolean flag = Utils.startActivity(EnvironmentUtils.getApplicationContext(), ((Intent) (obj1)));
        if (flag)
        {
            JSBridge.access$300(JSBridge.this).onAdLeftApplication();
        }
        invokeCallback(s, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void vibrate(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: vibrate(").append(s).append(")").toString());
        }
        Object obj = new JSONObject(s);
        s = ((JSONObject) (obj)).optString("onStartCallbackId", null);
        String s1 = ((JSONObject) (obj)).optString("onFinishCallbackId", null);
        obj = ((JSONObject) (obj)).optJSONArray("pattern");
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No pattern provided");
            invokeCallback(s1, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        long al[] = new long[((JSONArray) (obj)).length() + 1];
        al[0] = 0L;
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            al[i + 1] = ((JSONArray) (obj)).getLong(i);
        }

    /* block-local class not found */
    class _cls5 {}

        Utils.vibrate(al, -1, new _cls5(s, s1));
    }

    _cls5()
    {
        this$0 = JSBridge.this;
        super();
    }
}
