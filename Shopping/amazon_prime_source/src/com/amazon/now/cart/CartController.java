// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.amazon.now.AmazonActivity;
import com.amazon.now.account.User;
import com.amazon.now.account.UserListener;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.search.SearchActivity;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.NetUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.cart:
//            CartSubscriber, CartRequest, CartItem, CartResponse

public class CartController
    implements UserListener
{
    public static interface CartCallback
    {

        public abstract void onFailure(CartResponse cartresponse, String s);

        public abstract void onSuccess(CartResponse cartresponse);
    }

    private class CartTask extends AsyncTask
    {

        private CartCallback mCallback;
        private Context mContext;
        final CartController this$0;

        private void displayProgressDialog(Context context)
        {
            if (context instanceof AmazonActivity)
            {
                ((AmazonActivity)context).showSpinner();
            }
        }

        protected transient CartResponse doInBackground(CartRequest acartrequest[])
        {
            CartRequest cartrequest;
            Object obj7;
            cartrequest = acartrequest[0];
            obj7 = cartrequest.getRequestUrl();
            if (!TextUtils.isEmpty(((CharSequence) (obj7)))) goto _L2; else goto _L1
_L1:
            acartrequest = null;
_L13:
            return acartrequest;
_L2:
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            JSONObject jsonobject;
            JSONArray jsonarray;
            Object obj5;
            Object obj6;
            obj5 = null;
            obj6 = null;
            acartrequest = null;
            jsonarray = null;
            obj2 = null;
            jsonobject = null;
            obj = acartrequest;
            obj1 = obj2;
            obj3 = obj5;
            obj4 = obj6;
            obj7 = NetUtil.getURLConnection(((String) (obj7)));
            obj = acartrequest;
            obj1 = obj2;
            obj3 = obj5;
            obj4 = obj6;
            ((URLConnection) (obj7)).setConnectTimeout(5000);
            obj = acartrequest;
            obj1 = obj2;
            obj3 = obj5;
            obj4 = obj6;
            acartrequest = ((URLConnection) (obj7)).getInputStream();
            obj = acartrequest;
            obj1 = obj2;
            obj3 = acartrequest;
            obj4 = acartrequest;
            obj2 = new BufferedReader(new InputStreamReader(acartrequest, Charset.forName("UTF-8")));
            obj = new StringBuilder();
_L5:
            obj1 = ((BufferedReader) (obj2)).readLine();
            if (obj1 == null) goto _L4; else goto _L3
_L3:
            ((StringBuilder) (obj)).append(((String) (obj1)).trim());
              goto _L5
            obj3;
_L26:
            obj = acartrequest;
            obj1 = obj2;
            Log.e(CartController.TAG, ((IOException) (obj3)).toString(), ((Throwable) (obj3)));
            int i;
            boolean flag;
            if (acartrequest != null)
            {
                try
                {
                    acartrequest.close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                }
            }
            if (obj2 != null)
            {
                try
                {
                    ((BufferedReader) (obj2)).close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                }
            }
            return null;
_L4:
            jsonobject = new JSONObject(((StringBuilder) (obj)).toString());
            i = jsonobject.getJSONObject("cartSummary").getInt("totalQuantity");
            obj3 = new CartResponse();
            ((CartResponse) (obj3)).setCartAction(cartrequest.getCartAction());
            ((CartResponse) (obj3)).setCartCount(i);
            jsonarray = jsonobject.optJSONArray("activeItemList");
            mActiveItemList = jsonarray;
            obj4 = null;
            obj1 = null;
            flag = true;
            i = ((flag) ? 1 : 0);
            obj = obj4;
            if (jsonarray == null) goto _L7; else goto _L6
_L6:
            i = ((flag) ? 1 : 0);
            obj = obj4;
            if (jsonarray.length() <= 0) goto _L7; else goto _L8
_L8:
            if (TextUtils.isEmpty(cartrequest.getAsin()) || TextUtils.isEmpty(cartrequest.getMerchantId())) goto _L10; else goto _L9
_L9:
            obj = CartController.this;
            obj1 = cartrequest.getAsin();
            obj4 = cartrequest.getMerchantId();
            obj = ((CartController) (obj)).findItem(jsonarray, new String[] {
                "ASIN", "merchantID"
            }, new String[] {
                obj1, obj4
            });
_L15:
            obj1 = obj;
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_1037;
            }
            obj1 = obj;
            if (TextUtils.isEmpty(cartrequest.getAsin()))
            {
                break MISSING_BLOCK_LABEL_1037;
            }
            obj1 = obj;
            if (!TextUtils.isEmpty(cartrequest.getOfferId()))
            {
                obj = CartController.this;
                obj1 = cartrequest.getAsin();
                obj4 = cartrequest.getOfferId();
                obj1 = ((CartController) (obj)).findItem(jsonarray, new String[] {
                    "ASIN", "offerID"
                }, new String[] {
                    obj1, obj4
                });
            }
            break MISSING_BLOCK_LABEL_1037;
_L7:
            obj1 = jsonobject.optJSONObject("cartErrors");
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_505;
            }
            obj1 = ((JSONObject) (obj1)).optString("actionErrorMessage");
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                ((CartResponse) (obj3)).setCartError(((String) (obj1)));
            }
            if (i != 0) goto _L12; else goto _L11
_L11:
            if (acartrequest != null)
            {
                try
                {
                    acartrequest.close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                }
            }
            acartrequest = ((CartRequest []) (obj3));
            if (obj2 != null)
            {
                try
                {
                    ((BufferedReader) (obj2)).close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                    return ((CartResponse) (obj3));
                }
                return ((CartResponse) (obj3));
            }
              goto _L13
_L10:
            obj = obj1;
            if (TextUtils.isEmpty(cartrequest.getItemId())) goto _L15; else goto _L14
_L14:
            obj = CartController.this;
            obj1 = cartrequest.getItemId();
            obj = ((CartController) (obj)).findItem(jsonarray, new String[] {
                "itemID"
            }, new String[] {
                obj1
            });
              goto _L15
_L12:
            if (cartrequest.getCartAction() != CartRequest.CartAction.REMOVE && (cartrequest.getCartAction() != CartRequest.CartAction.UPDATE || cartrequest.getActionQuantity() != 0))
            {
                i = 0;
            } else
            {
                i = 1;
            }
            if (i == 0 || obj == null) goto _L17; else goto _L16
_L16:
            Log.e(CartController.TAG, "Unexpected item found in the activeItemList.");
            ((CartResponse) (obj3)).setIsValid(false);
_L20:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_743;
            }
            obj1 = ((JSONObject) (obj)).optString("error");
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                ((CartResponse) (obj3)).setCartError(((String) (obj1)));
            }
            ((CartResponse) (obj3)).setItemId(((JSONObject) (obj)).optString("itemID"));
            ((CartResponse) (obj3)).setStockOnHand(((JSONObject) (obj)).optInt("stockOnHand", -1));
            i = ((JSONObject) (obj)).optInt("quantity", -1);
            if (i <= -1)
            {
                break MISSING_BLOCK_LABEL_743;
            }
            ((CartResponse) (obj3)).setItemCount(i);
            if (acartrequest != null)
            {
                try
                {
                    acartrequest.close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                }
            }
            acartrequest = ((CartRequest []) (obj3));
            if (obj2 == null) goto _L13; else goto _L18
_L18:
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (CartRequest acartrequest[])
            {
                Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                return ((CartResponse) (obj3));
            }
            return ((CartResponse) (obj3));
_L17:
            if (i != 0) goto _L20; else goto _L19
_L19:
            if (cartrequest.getCartAction() == CartRequest.CartAction.GET || obj != null) goto _L20; else goto _L21
_L21:
            Log.e(CartController.TAG, "Expected item not found in the activeItemList.");
            ((CartResponse) (obj3)).setIsValid(false);
              goto _L20
            obj4;
_L25:
            obj = acartrequest;
            obj1 = obj2;
            Log.e(CartController.TAG, ((JSONException) (obj4)).toString(), ((Throwable) (obj4)));
            if (acartrequest != null)
            {
                try
                {
                    acartrequest.close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                }
            }
            if (obj2 != null)
            {
                try
                {
                    ((BufferedReader) (obj2)).close();
                }
                // Misplaced declaration of an exception variable
                catch (CartRequest acartrequest[])
                {
                    Log.e(CartController.TAG, acartrequest.toString(), acartrequest);
                }
            }
            break MISSING_BLOCK_LABEL_203;
            acartrequest;
_L23:
            if (obj != null)
            {
                try
                {
                    ((InputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.e(CartController.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                }
            }
            if (obj1 != null)
            {
                try
                {
                    ((BufferedReader) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.e(CartController.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                }
            }
            throw acartrequest;
            obj3;
            obj1 = obj2;
            obj = acartrequest;
            acartrequest = ((CartRequest []) (obj3));
            if (true) goto _L23; else goto _L22
_L22:
            obj4;
            acartrequest = ((CartRequest []) (obj3));
            obj2 = jsonarray;
            if (true) goto _L25; else goto _L24
_L24:
            obj3;
            acartrequest = ((CartRequest []) (obj4));
            obj2 = jsonobject;
              goto _L26
            i = ((flag) ? 1 : 0);
            obj = obj1;
            if (obj1 == null)
            {
                i = 0;
                obj = obj1;
            }
              goto _L7
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((CartRequest[])aobj);
        }

        protected void onPostExecute(CartResponse cartresponse)
        {
            if (mContext instanceof AmazonActivity)
            {
                ((AmazonActivity)mContext).hideSpinner();
            }
            if (cartresponse != null) goto _L2; else goto _L1
_L1:
            if (mCallback != null)
            {
                mCallback.onFailure(null, null);
            }
_L4:
            return;
_L2:
            String s;
            int i;
            boolean flag;
            i = cartresponse.getCartCount();
            s = cartresponse.getError();
            if (i <= -1)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag = cartresponse.isValid();
            static class _cls3
            {

                static final int $SwitchMap$com$amazon$now$cart$CartRequest$CartAction[];

                static 
                {
                    $SwitchMap$com$amazon$now$cart$CartRequest$CartAction = new int[CartRequest.CartAction.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$now$cart$CartRequest$CartAction[CartRequest.CartAction.ADD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$now$cart$CartRequest$CartAction[CartRequest.CartAction.REMOVE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3..SwitchMap.com.amazon.now.cart.CartRequest.CartAction[cartresponse.getCartAction().ordinal()])
            {
            default:
                break;

            case 1: // '\001'
                break; /* Loop/switch isn't completed */

            case 2: // '\002'
                break;
            }
            break MISSING_BLOCK_LABEL_152;
_L5:
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            mCartCount = i;
            updateCartCount();
            if (mCallback != null)
            {
                mCallback.onSuccess(cartresponse);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (i <= mCartCount)
            {
                flag = false;
            }
              goto _L5
            if (i >= mCartCount)
            {
                flag = false;
            }
              goto _L5
            if (mCallback == null) goto _L4; else goto _L6
_L6:
            mCallback.onFailure(cartresponse, s);
            return;
            if (mCallback == null) goto _L4; else goto _L7
_L7:
            mCallback.onFailure(cartresponse, s);
            return;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((CartResponse)obj);
        }

        protected void onPreExecute()
        {
            displayProgressDialog(mContext);
        }

        public CartTask(CartCallback cartcallback, Context context)
        {
            this$0 = CartController.this;
            super();
            mCallback = cartcallback;
            mContext = context;
        }
    }


    private static final String TAG = com/amazon/now/cart/CartController.getSimpleName();
    private static CartController sInstance = new CartController();
    private JSONArray mActiveItemList;
    private int mCartCount;
    private final List mSubscribers = new ArrayList();

    private CartController()
    {
        mCartCount = 0;
        User.addUserListener(this);
    }

    private void failureMessage(Context context, String s, String s1)
    {
        if (context == null || TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            Log.e(TAG, "unable to show failure message, invalid parameters");
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
            builder.setTitle(s1);
            builder.setMessage(s);
            builder.setPositiveButton(0x7f07006f, new android.content.DialogInterface.OnClickListener() {

                final CartController this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = CartController.this;
                super();
            }
            });
            s = builder.create();
            if (!((AmazonActivity)context).isFinishing())
            {
                s.show();
                return;
            }
        }
    }

    private JSONObject findItem(JSONArray jsonarray, String as[], String as1[])
        throws JSONException
    {
label0:
        {
            if (as == null || as1 == null || as.length != as1.length)
            {
                break label0;
            }
label1:
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                boolean flag1 = true;
                int j = 0;
                do
                {
label2:
                    {
                        boolean flag = flag1;
                        if (j < as.length)
                        {
                            String s = jsonobject.optString(as[j]);
                            if (TextUtils.equals(as1[j], s))
                            {
                                break label2;
                            }
                            flag = false;
                        }
                        if (flag)
                        {
                            return jsonarray.getJSONObject(i);
                        }
                        continue label1;
                    }
                    j++;
                } while (true);
            }

        }
        return null;
    }

    private Uri getCartUri()
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(AndroidPlatform.getInstance().getApplicationContext())).buildUpon();
        builder.appendPath("cart");
        return builder.build();
    }

    public static CartController getInstance()
    {
        return sInstance;
    }

    private void tryFetch(final int attempts)
    {
        fetchCartCount(null, new CartCallback() {

            final CartController this$0;
            final int val$attempts;

            public void onFailure(CartResponse cartresponse, String s)
            {
                if (attempts <= 0)
                {
                    Log.e(CartController.TAG, "Unable to retrieve cart.");
                }
                AndroidPlatform.getInstance().invokeLater(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        tryFetch(attempts - 1);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }, 5000L);
            }

            public void onSuccess(CartResponse cartresponse)
            {
            }

            
            {
                this$0 = CartController.this;
                attempts = i;
                super();
            }
        });
    }

    private void updateCartCount()
    {
        for (Iterator iterator = mSubscribers.iterator(); iterator.hasNext(); ((CartSubscriber)iterator.next()).cartCountUpdated(mCartCount)) { }
    }

    public void addSubscriber(CartSubscriber cartsubscriber)
    {
        mSubscribers.add(cartsubscriber);
    }

    public void addToCart(Context context, String s, String s1, String s2, String s3, String s4, String s5, 
            int i, CartCallback cartcallback)
    {
        android.net.Uri.Builder builder = getCartUri().buildUpon();
        builder.appendPath("ajax");
        builder.appendPath("additem");
        if (!TextUtils.isEmpty(s5))
        {
            builder.appendQueryParameter("ref", s5);
        } else
        {
            Log.w(TAG, "refMarker isEmpty, but it should be supplied for logging correctness");
        }
        builder.appendQueryParameter("itemAsin", s);
        builder.appendQueryParameter("offerId", s1);
        builder.appendQueryParameter("quantity", Integer.toString(i));
        if (!TextUtils.isEmpty(s3))
        {
            builder.appendQueryParameter("qid", s3);
        }
        if (!TextUtils.isEmpty(s4))
        {
            builder.appendQueryParameter("sr", s4);
        }
        if (context instanceof SearchActivity)
        {
            builder.appendQueryParameter("discoveredAsins.1", s);
        }
        s = new CartRequest(CartRequest.CartAction.ADD, builder.build().toString(), s, s1, s2);
        (new CartTask(cartcallback, context)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new CartRequest[] {
            s
        });
    }

    public void addToCartFailureMessage(Context context, String s)
    {
        if (context == null)
        {
            Log.e(TAG, "addToCartFailureMessage: activityContext is null");
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            s = context.getString(0x7f07006b);
        }
        failureMessage(context, s, context.getString(0x7f070073));
    }

    public void addToCartSuccessMessage(Context context)
    {
        if (context == null)
        {
            Log.e(TAG, "addToCartSuccessMessage: activityContext is null");
            return;
        } else
        {
            context = Toast.makeText(context, 0x7f07006c, 0);
            context.setGravity(16, 0, 0);
            context.show();
            return;
        }
    }

    public void cartDidUpdate(int i)
    {
        mCartCount = i;
        updateCartCount();
        if (i == 0)
        {
            mActiveItemList = null;
        }
    }

    public void fetchCartCount(Context context, CartCallback cartcallback)
    {
        Object obj = getCartUri().buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("ajax");
        obj = new CartRequest(CartRequest.CartAction.GET, ((android.net.Uri.Builder) (obj)).build().toString());
        (new CartTask(cartcallback, context)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new CartRequest[] {
            obj
        });
    }

    public int getCartCount()
    {
        return mCartCount;
    }

    public CartItem getCartItem(String s, String s1, String s2)
    {
        if (mActiveItemList != null && mActiveItemList.length() != 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        JSONObject jsonobject;
        Object obj;
        obj = null;
        jsonobject = obj;
        if (!TextUtils.isEmpty(s))
        {
            jsonobject = obj;
            try
            {
                if (!TextUtils.isEmpty(s1))
                {
                    jsonobject = findItem(mActiveItemList, new String[] {
                        "ASIN", "merchantID"
                    }, new String[] {
                        s, s1
                    });
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e(TAG, s.toString(), s);
                return null;
            }
        }
        s1 = jsonobject;
        if (jsonobject != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = jsonobject;
        if (TextUtils.isEmpty(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = jsonobject;
        if (!TextUtils.isEmpty(s2))
        {
            s1 = findItem(mActiveItemList, new String[] {
                "ASIN", "offerID"
            }, new String[] {
                s, s2
            });
        }
        if (s1 == null) goto _L1; else goto _L3
_L3:
        s = new CartItem.Builder();
        s.asin(s1.optString("ASIN"));
        s.offerId(s1.optString("offerID"));
        s.itemId(s1.optString("itemID"));
        s.title(s1.optString("title"));
        s.price(s1.optString("price"));
        s.merchantId(s1.optString("merchantID"));
        s.productDetailUrl(s1.optString("productDetailUrl"));
        s.stockOnHand(s1.optInt("stockOnHand", 0));
        s.quantity(s1.optInt("quantity", 0));
        s = s.build();
        return s;
    }

    public void quantityChangeFailureMessage(Context context, String s)
    {
        if (context == null)
        {
            Log.e(TAG, "quantityChangeFailureMessage: activityContext is null");
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            s = context.getString(0x7f07008c);
        }
        failureMessage(context, s, context.getString(0x7f070073));
    }

    public void quantityChangeSuccessMessage(Context context)
    {
        if (context == null)
        {
            Log.e(TAG, "quantityChangeSuccessMessage: activityContext is null");
            return;
        } else
        {
            context = Toast.makeText(context, 0x7f07008d, 0);
            context.setGravity(16, 0, 0);
            context.show();
            return;
        }
    }

    public void removeItem(Context context, String s, int i, String s1, CartCallback cartcallback)
    {
        android.net.Uri.Builder builder = getCartUri().buildUpon();
        builder.appendPath("ajax");
        builder.appendPath("removeitem");
        builder.appendQueryParameter(String.format("quantities[%s]", new Object[] {
            s
        }), Integer.toString(i));
        builder.appendQueryParameter("selectedItems", s);
        builder.appendQueryParameter(String.format("encodedOfferIdByItemId[%s]", new Object[] {
            s
        }), s1);
        builder.appendQueryParameter("removeSelected", "remove");
        builder.appendQueryParameter("actionItemID", s);
        s = new CartRequest(CartRequest.CartAction.REMOVE, builder.build().toString(), s);
        (new CartTask(cartcallback, context)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new CartRequest[] {
            s
        });
    }

    public void removeSubscriber(CartSubscriber cartsubscriber)
    {
        mSubscribers.remove(cartsubscriber);
    }

    public void updateQuantity(Context context, String s, int i, String s1, CartCallback cartcallback)
    {
        android.net.Uri.Builder builder = getCartUri().buildUpon();
        builder.appendPath("ajax");
        builder.appendPath("updatequantity");
        builder.appendQueryParameter(String.format("quantities[%s]", new Object[] {
            s
        }), Integer.toString(i));
        builder.appendQueryParameter(String.format("encodedOfferIdByItemId[%s]", new Object[] {
            s
        }), s1);
        builder.appendQueryParameter("updateQuantity", "update");
        builder.appendQueryParameter("actionItemID", s);
        builder.appendQueryParameter("actionType", "update-quantity");
        s = new CartRequest(CartRequest.CartAction.UPDATE, builder.build().toString(), s, i);
        (new CartTask(cartcallback, context)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new CartRequest[] {
            s
        });
    }

    public void userSignedIn()
    {
        tryFetch(3);
    }

    public void userSignedOut()
    {
        mCartCount = 0;
        mActiveItemList = null;
        updateCartCount();
    }





/*
    static JSONArray access$202(CartController cartcontroller, JSONArray jsonarray)
    {
        cartcontroller.mActiveItemList = jsonarray;
        return jsonarray;
    }

*/




/*
    static int access$402(CartController cartcontroller, int i)
    {
        cartcontroller.mCartCount = i;
        return i;
    }

*/

}
