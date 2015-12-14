// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import java.io.File;
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

    public void addCalendarEvent(final String callbackId)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: addCalendarEvent(").append(callbackId).append(")").toString());
        }
        JSONObject jsonobject = new JSONObject(callbackId);
        callbackId = jsonobject.optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(callbackId, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        jsonobject = jsonobject.optJSONObject("options");
        if (jsonobject == null)
        {
            MMLog.e(JSBridge.access$000(), "No options provided");
            invokeCallback(callbackId, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        final MMWebView mmWebView = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmWebView == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(callbackId, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        } else
        {
            CalendarUtils.addEvent(mmWebView.getContext(), jsonobject, new com.millennialmedia.internal.utils.CalendarUtils.CalendarListener() {

                final JSBridge.JSBridgeMMJS this$1;
                final String val$callbackId;
                final MMWebView val$mmWebView;

                public void onError(String s)
                {
                    MMLog.e(JSBridge.access$000(), s);
                    invokeCallback(callbackId, new Object[] {
                        Boolean.valueOf(false)
                    });
                }

                public void onSuccess()
                {
                    Utils.showToast(mmWebView.getContext(), "Event added to calendar");
                    invokeCallback(callbackId, new Object[] {
                        Boolean.valueOf(true)
                    });
                }

                public void onUIDisplayed()
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(JSBridge.access$000(), "Calendar activity started");
                    }
                    JSBridge.access$300(this$0).onAdLeftApplication();
                    invokeCallback(callbackId, new Object[] {
                        Boolean.valueOf(true)
                    });
                }

            
            {
                this$1 = JSBridge.JSBridgeMMJS.this;
                callbackId = s;
                mmWebView = mmwebview;
                super();
            }
            });
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

    public void getPictureFromPhotoLibrary(final String callbackId)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: getPictureFromPhotoLibrary(").append(callbackId).append(")").toString());
        }
        Object obj = new JSONObject(callbackId);
        callbackId = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        }
        obj = ((JSONObject) (obj)).optJSONObject("size");
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No size parameters provided");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        }
        android.util.DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
        final int maxWidth = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxWidth", 0), displaymetrics);
        final int maxHeight = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxHeight", 0), displaymetrics);
        final boolean maintainAspectRatio = ((JSONObject) (obj)).optBoolean("maintainAspectRatio", true);
        if (maxWidth <= 0 || maxHeight <= 0)
        {
            MMLog.e(JSBridge.access$000(), "maxWidth and maxHeight must be > 0");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        }
        obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        } else
        {
            MediaUtils.getPhotoFromGallery(((MMWebView) (obj)).getContext(), new com.millennialmedia.internal.utils.MediaUtils.PhotoListener() {

                final JSBridge.JSBridgeMMJS this$1;
                final String val$callbackId;
                final boolean val$maintainAspectRatio;
                final int val$maxHeight;
                final int val$maxWidth;

                public void onError(String s)
                {
                    MMLog.e(JSBridge.access$000(), s);
                    invokeCallback(callbackId, new Object[] {
                        null
                    });
                }

                public void onPhoto(File file)
                {
                    Object obj1 = null;
                    String s = MediaUtils.getMimeTypeFromFile(file);
                    Bitmap bitmap = MediaUtils.getScaledBitmapFromFile(file, maxWidth, maxHeight, maintainAspectRatio, true);
                    file = obj1;
                    if (bitmap != null)
                    {
                        file = MediaUtils.base64EncodeBitmap(bitmap, s);
                        bitmap.recycle();
                    }
                    invokeCallback(callbackId, new Object[] {
                        file
                    });
                }

            
            {
                this$1 = JSBridge.JSBridgeMMJS.this;
                maxWidth = i;
                maxHeight = j;
                maintainAspectRatio = flag;
                callbackId = s;
                super();
            }
            });
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

    public void openCamera(final String callbackId)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: openCamera(").append(callbackId).append(")").toString());
        }
        Object obj = new JSONObject(callbackId);
        callbackId = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        }
        obj = ((JSONObject) (obj)).optJSONObject("size");
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No size parameters provided");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        }
        android.util.DisplayMetrics displaymetrics = EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics();
        final int maxWidth = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxWidth", 0), displaymetrics);
        final int maxHeight = (int)TypedValue.applyDimension(1, ((JSONObject) (obj)).optInt("maxHeight", 0), displaymetrics);
        final boolean maintainAspectRatio = ((JSONObject) (obj)).optBoolean("maintainAspectRatio", true);
        if (maxWidth <= 0 || maxHeight <= 0)
        {
            MMLog.e(JSBridge.access$000(), "maxWidth and maxHeight must be > 0");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        }
        obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(callbackId, new Object[] {
                null
            });
            return;
        } else
        {
            MediaUtils.getPhotoFromCamera(((MMWebView) (obj)).getContext(), new com.millennialmedia.internal.utils.MediaUtils.PhotoListener() {

                final JSBridge.JSBridgeMMJS this$1;
                final String val$callbackId;
                final boolean val$maintainAspectRatio;
                final int val$maxHeight;
                final int val$maxWidth;

                public void onError(String s)
                {
                    MMLog.e(JSBridge.access$000(), s);
                    invokeCallback(callbackId, new Object[] {
                        null
                    });
                }

                public void onPhoto(File file)
                {
                    String s = null;
                    String s1 = MediaUtils.getMimeTypeFromFile(file);
                    Bitmap bitmap = MediaUtils.getScaledBitmapFromFile(file, maxWidth, maxHeight, maintainAspectRatio, true);
                    if (bitmap != null)
                    {
                        s = MediaUtils.base64EncodeBitmap(bitmap, s1);
                        bitmap.recycle();
                    }
                    file.delete();
                    invokeCallback(callbackId, new Object[] {
                        s
                    });
                }

            
            {
                this$1 = JSBridge.JSBridgeMMJS.this;
                maxWidth = i;
                maxHeight = j;
                maintainAspectRatio = flag;
                callbackId = s;
                super();
            }
            });
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

    public void savePictureToPhotoLibrary(final String callbackId)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: savePictureToPhotoLibrary(").append(callbackId).append(")").toString());
        }
        Object obj = new JSONObject(callbackId);
        callbackId = ((JSONObject) (obj)).optString("callbackId", null);
        if (!JSBridge.access$400(JSBridge.this))
        {
            MMLog.e(JSBridge.access$000(), "Ad has not been clicked");
            invokeCallback(callbackId, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        String s = ((JSONObject) (obj)).optString("name", null);
        final String description = ((JSONObject) (obj)).optString("description", null);
        obj = ((JSONObject) (obj)).optString("url", null);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            MMLog.e(JSBridge.access$000(), "No path specified for photo");
            invokeCallback(callbackId, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        final MMWebView mmWebView = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmWebView == null)
        {
            MMLog.e(JSBridge.access$000(), "Webview is no longer valid");
            invokeCallback(callbackId, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        } else
        {
            MediaUtils.savePicture(mmWebView.getContext(), ((String) (obj)), s, new com.millennialmedia.internal.utils.MediaUtils.SavePictureListener() {

                final JSBridge.JSBridgeMMJS this$1;
                final String val$callbackId;
                final String val$description;
                final MMWebView val$mmWebView;

                public void onError(String s1)
                {
                    MMLog.e(JSBridge.access$000(), s1);
                    invokeCallback(callbackId, new Object[] {
                        Boolean.valueOf(false)
                    });
                }

                public void onPictureSaved(File file)
                {
                    if (description != null)
                    {
                        MediaUtils.setFileDescription(file, description);
                    }
                    Utils.showToast(mmWebView.getContext(), (new StringBuilder()).append(file.getName()).append(" stored in gallery").toString());
                    invokeCallback(callbackId, new Object[] {
                        Boolean.valueOf(true)
                    });
                }

            
            {
                this$1 = JSBridge.JSBridgeMMJS.this;
                description = s;
                mmWebView = mmwebview;
                callbackId = s1;
                super();
            }
            });
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

    public void vibrate(final String onStartCallbackId)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("MMJS: vibrate(").append(onStartCallbackId).append(")").toString());
        }
        Object obj = new JSONObject(onStartCallbackId);
        onStartCallbackId = ((JSONObject) (obj)).optString("onStartCallbackId", null);
        final String onFinishCallbackId = ((JSONObject) (obj)).optString("onFinishCallbackId", null);
        obj = ((JSONObject) (obj)).optJSONArray("pattern");
        if (obj == null)
        {
            MMLog.e(JSBridge.access$000(), "No pattern provided");
            invokeCallback(onFinishCallbackId, new Object[] {
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

        Utils.vibrate(al, -1, new com.millennialmedia.internal.utils.Utils.VibrateListener() {

            final JSBridge.JSBridgeMMJS this$1;
            final String val$onFinishCallbackId;
            final String val$onStartCallbackId;

            public void onError()
            {
                invokeCallback(onFinishCallbackId, new Object[] {
                    Boolean.valueOf(false)
                });
            }

            public void onFinished()
            {
                invokeCallback(onFinishCallbackId, new Object[] {
                    Boolean.valueOf(true)
                });
            }

            public void onStarted()
            {
                invokeCallback(onStartCallbackId, new Object[0]);
            }

            
            {
                this$1 = JSBridge.JSBridgeMMJS.this;
                onStartCallbackId = s;
                onFinishCallbackId = s1;
                super();
            }
        });
    }

    _cls5.val.onFinishCallbackId()
    {
        this$0 = JSBridge.this;
        super();
    }
}
