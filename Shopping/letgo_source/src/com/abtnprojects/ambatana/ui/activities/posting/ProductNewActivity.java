// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.aqo;
import android.support.v7.da;
import android.support.v7.du;
import android.support.v7.dw;
import android.support.v7.ed;
import android.support.v7.ee;
import android.support.v7.ej;
import android.support.v7.ek;
import android.support.v7.fg;
import android.support.v7.fs;
import android.support.v7.ft;
import android.support.v7.gh;
import android.support.v7.gx;
import android.support.v7.gy;
import android.support.v7.hp;
import android.support.v7.hu;
import android.support.v7.ia;
import android.support.v7.ic;
import android.support.v7.ig;
import android.support.v7.im;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.support.v7.kf;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.Category;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.abtnprojects.ambatana.models.product.AbstractImage;
import com.abtnprojects.ambatana.models.product.EmptyImage;
import com.abtnprojects.ambatana.models.product.Geo;
import com.abtnprojects.ambatana.models.product.LocalImage;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.RemoteImage;
import com.abtnprojects.ambatana.models.user.User;
import com.abtnprojects.ambatana.services.ProductCreationService;
import com.abtnprojects.ambatana.services.ProductEditionService;
import com.abtnprojects.ambatana.ui.activities.b;
import com.facebook.d;
import com.facebook.f;
import com.facebook.h;
import com.facebook.share.model.ShareLinkContent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductNewActivity extends com.abtnprojects.ambatana.ui.activities.b
{
    public class a
    {

        final boolean a;
        final Throwable b;
        final ProductNewActivity c;

        public a(boolean flag, Throwable throwable)
        {
            c = ProductNewActivity.this;
            super();
            a = flag;
            b = throwable;
        }
    }

    public class b extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final ProductNewActivity a;
        private final File b;
        private final File c;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient a a(Void avoid[])
        {
            Object obj;
            boolean flag;
            obj = null;
            flag = true;
            if (b == null)
            {
                aqo.d("Error bigImageFile is null", new Object[0]);
                return null;
            }
            Bitmap bitmap;
            Bitmap bitmap1;
            FileOutputStream fileoutputstream;
            bitmap = BitmapFactoryInstrumentation.decodeStream(new FileInputStream(b));
            avoid = ig.b(bitmap, 512);
            bitmap1 = ig.a(avoid, b.getAbsolutePath());
            fileoutputstream = new FileOutputStream(c);
            if (bitmap1 == null) goto _L2; else goto _L1
_L1:
            if (!bitmap1.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream)) goto _L2; else goto _L3
_L3:
            aqo.a("bitmap size : %d, %d", new Object[] {
                Integer.valueOf(bitmap1.getWidth()), Integer.valueOf(bitmap1.getHeight())
            });
_L9:
            fileoutputstream.close();
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            avoid.recycle();
            if (bitmap1 == null)
            {
                break MISSING_BLOCK_LABEL_146;
            }
            bitmap1.recycle();
            boolean flag1;
            avoid = obj;
            flag1 = flag;
            if (bitmap == null)
            {
                break MISSING_BLOCK_LABEL_166;
            }
            bitmap.recycle();
            flag1 = flag;
            avoid = obj;
_L4:
            return a. new a(flag1, avoid);
            avoid;
            flag = false;
_L7:
            aqo.b(avoid, "File not found ", new Object[0]);
            flag1 = flag;
              goto _L4
            avoid;
            flag = false;
_L6:
            aqo.b(avoid, "Error accessing file", new Object[0]);
            flag1 = flag;
              goto _L4
            avoid;
            flag = false;
_L5:
            aqo.b(avoid, "Other error", new Object[0]);
            flag1 = flag;
              goto _L4
            avoid;
            flag1 = false;
              goto _L4
            avoid;
            flag1 = flag;
              goto _L4
            avoid;
              goto _L5
            avoid;
              goto _L6
            avoid;
              goto _L7
_L2:
            flag = false;
            if (true) goto _L9; else goto _L8
_L8:
        }

        protected void a(a a1)
        {
            iv.a(com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.h(a));
            if (a1.a)
            {
                ProductNewActivity.a(a, Uri.fromFile(b), b.getAbsolutePath(), Uri.fromFile(c));
                return;
            }
            if ((a1.b instanceof da) || (a1.b instanceof OutOfMemoryError))
            {
                Toast.makeText(a.getApplicationContext(), 0x7f0900a1, 1).show();
                return;
            } else
            {
                ProductNewActivity.a(a, Uri.fromFile(b), b.getAbsolutePath(), Uri.fromFile(b));
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$b#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ProductNewActivity$b#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$b#onPostExecute", null);
_L1:
            a((a)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ProductNewActivity$b#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            ProductNewActivity.a(a, a, a.getString(0x7f09010b), a.getString(0x7f09010a), 0, 0);
        }

        public b(File file)
        {
            a = ProductNewActivity.this;
            super();
            b = file;
            c = iv.a(ProductNewActivity.this, "AmbatanaImageThumb_", "jpg");
        }
    }

    class c extends Handler
    {

        final ProductNewActivity a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                super.handleMessage(message);
                return;

            case 3: // '\003'
                a.c(message.arg1);
                return;

            case 4: // '\004'
                message = message.getData();
                break;
            }
            if (message != null && message.containsKey("productInserted"))
            {
                message = ProductInserted.fromJSON(message.getString("productInserted"));
                a.a(message);
                return;
            } else
            {
                a.a(null);
                return;
            }
        }

        c()
        {
            a = ProductNewActivity.this;
            super();
        }
    }

    public class d extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        WeakReference a;
        final ProductNewActivity b;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient File a(String as[])
        {
            Object obj;
            if (as.length <= 0)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            obj = as[0];
            if (TextUtils.isEmpty(((CharSequence) (obj))) || a.get() == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            as = iv.a((Context)a.get(), "AmbatanaImage_", "jpg");
            FileOutputStream fileoutputstream;
            obj = BitmapFactoryInstrumentation.decodeStream(new FileInputStream(new File(((String) (obj)))));
            fileoutputstream = new FileOutputStream(as);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            if (((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream))
            {
                return as;
            }
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                aqo.b(as, "Error Saving image", new Object[0]);
            }
            return null;
            return null;
        }

        protected void a(File file)
        {
            iv.a(com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.h(b));
            if (file != null && a != null)
            {
                ProductNewActivity.a(b, Uri.fromFile(file), file.getAbsolutePath());
                return;
            } else
            {
                ProductNewActivity.i(b);
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$d#doInBackground", null);
_L1:
            aobj = a((String[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ProductNewActivity$d#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$d#onPostExecute", null);
_L1:
            a((File)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ProductNewActivity$d#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            ProductNewActivity.a(b, b, b.getString(0x7f09010b), b.getString(0x7f09010a), 0, 0);
        }

        public d(ProductNewActivity productnewactivity1)
        {
            b = ProductNewActivity.this;
            super();
            a = new WeakReference(productnewactivity1);
        }
    }


    public static final String A[] = {
        "EUR"
    };
    private static final String D[] = {
        "USD"
    };
    public static final String n[] = {
        "USD", "EUR"
    };
    public File B;
    final Messenger C = new Messenger(new c());
    private gx E;
    private ProgressDialog F;
    private com.facebook.d G;
    private int H;
    private String I;
    private AbstractImage J;
    private hu K;
    private int L;
    private boolean M;
    private boolean N;
    private AlertDialog O;
    private ic P;
    private Product Q;
    Button btnProductSubmit;
    CheckBox cbFacebookShare;
    EditText etProductDescription;
    EditText etProductPrice;
    EditText etProductTitle;
    TextView productDescriptionLabel;
    Spinner spCategory;
    Spinner spCurrency;

    public ProductNewActivity()
    {
        B = null;
        F = null;
        H = 0;
        L = 1;
    }

    private void F()
    {
        int i1 = 0;
        RecyclerView recyclerview = (RecyclerView)findViewById(0x7f1000b2);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ArrayList arraylist = new ArrayList(5);
        for (; i1 < 5; i1++)
        {
            arraylist.add(new EmptyImage());
        }

        K = new hu(arraylist);
        recyclerview.setAdapter(K);
        recyclerview.addOnItemTouchListener(new ia(new android.support.v7.ia.a() {

            final ProductNewActivity a;

            public void a(View view, int j1)
            {
                int k1 = ProductNewActivity.a(a).getItemViewType(j1);
                if (k1 == 1)
                {
                    ProductNewActivity.a(a, j1);
                    com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.b(a);
                } else
                if (k1 == 2)
                {
                    ProductNewActivity.a(a, j1);
                    ProductNewActivity.c(a);
                    return;
                }
            }

            
            {
                a = ProductNewActivity.this;
                super();
            }
        }, this));
    }

    private void G()
    {
        etProductDescription.addTextChangedListener(new TextWatcher() {

            final ProductNewActivity a;

            public void afterTextChanged(Editable editable)
            {
                int i1 = a.getResources().getInteger(0x7f0d0001);
                int j1 = a.etProductDescription.getText().length();
                a.productDescriptionLabel.setText((new StringBuilder()).append(i1 - j1).append("").toString());
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = ProductNewActivity.this;
                super();
            }
        });
    }

    private void H()
    {
        btnProductSubmit.setEnabled(false);
    }

    private void I()
    {
        btnProductSubmit.setEnabled(true);
    }

    private void J()
    {
        fs fs1 = new fs(this);
        Void avoid[] = new Void[0];
        if (!(fs1 instanceof AsyncTask))
        {
            fs1.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)fs1, avoid);
            return;
        }
    }

    private void K()
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/services/ProductEditionService);
        intent.putExtra("messenger", C);
        List list = K.c();
        Geo geo = Q.getGeo();
        String s = etProductPrice.getText().toString();
        double d1;
        if (s == null)
        {
            d1 = 0.0D;
        } else
        {
            d1 = Double.parseDouble(s);
        }
        intent.putExtra("productToInsert", new Product(Q.getId(), etProductTitle.getText().toString(), H, Q.getLanguageCode(), etProductDescription.getText().toString(), null, I, 0, geo, list, null, null, null, false, false, Q.getOwner(), d1, 0));
        intent.putExtra("share_in_fb", cbFacebookShare.isChecked());
        startService(intent);
    }

    private int L()
    {
        int j1 = 0;
        if (K.b() > 0)
        {
            j1 = 0 + K.b();
        }
        int i1 = j1;
        if (cbFacebookShare.isChecked())
        {
            i1 = j1 + 1;
        }
        j1 = i1;
        if (i1 == 0)
        {
            j1 = 1;
        }
        return j1;
    }

    private void M()
    {
        etProductTitle.setError(null);
        etProductDescription.setError(null);
        etProductPrice.setError(null);
    }

    private void N()
    {
        String as[] = getResources().getStringArray(0x7f0e0004);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(0x7f09010f)).setItems(as, new android.content.DialogInterface.OnClickListener() {

            final ProductNewActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                switch (i1)
                {
                default:
                    throw new IllegalArgumentException("Option is not implemented");

                case 0: // '\0'
                    ProductNewActivity.e(a);
                    return;

                case 1: // '\001'
                    com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.f(a);
                    return;

                case 2: // '\002'
                    ProductNewActivity.g(a);
                    break;
                }
            }

            
            {
                a = ProductNewActivity.this;
                super();
            }
        });
        builder.setNeutralButton(getString(0x1040000), new android.content.DialogInterface.OnClickListener() {

            final ProductNewActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = ProductNewActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void O()
    {
        String as[] = getResources().getStringArray(0x7f0e0003);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(0x7f09010f));
        builder.setItems(as, new android.content.DialogInterface.OnClickListener() {

            final ProductNewActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                if (i1 == 0)
                {
                    ProductNewActivity.e(a);
                } else
                if (i1 == 1)
                {
                    com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.f(a);
                    return;
                }
            }

            
            {
                a = ProductNewActivity.this;
                super();
            }
        });
        builder.setNeutralButton(getString(0x1040000), new android.content.DialogInterface.OnClickListener() {

            final ProductNewActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = ProductNewActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void P()
    {
        aqo.b("onTakePhotoFromCameraClick", new Object[0]);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        B = iv.a(this, "AmbatanaImage_", "jpg");
        intent.putExtra("output", Uri.fromFile(B));
        aqo.b("onTakePhotoFromCameraClick : file path : %s", new Object[] {
            B.getPath()
        });
        if (iv.a(this, intent))
        {
            aqo.b("onTakePhotoFromCameraClick : will start intent", new Object[0]);
            startActivityForResult(intent, 0);
            return;
        } else
        {
            aqo.b("onTakePhotoFromCameraClick : intent not found", new Object[0]);
            Toast.makeText(getApplicationContext(), 0x7f090110, 1).show();
            return;
        }
    }

    private void Q()
    {
        startActivityForResult(Intent.createChooser((new Intent("android.intent.action.GET_CONTENT")).setType("image/*"), getString(0x7f09005d)), 1);
    }

    private void R()
    {
        K.c(J);
    }

    private void S()
    {
        Toast.makeText(this, getString(0x7f090104), 1).show();
    }

    private void T()
    {
        if (Q != null)
        {
            String s = Q.getCurrency();
            etProductTitle.setText(Q.getName());
            etProductPrice.setText(Double.toString(Q.getPrice()));
            etProductDescription.setText(Q.getDescription());
            List list = Q.getImages();
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                RemoteImage remoteimage = (RemoteImage)list.get(i1);
                K.a(remoteimage, i1);
            }

            i(s);
        }
    }

    private Uri a(Uri uri)
    {
        Object obj = null;
        Uri uri1 = obj;
        String s;
        try
        {
            s = b(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            aqo.b(uri, "Error getting mini uri", new Object[0]);
            return uri1;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        uri1 = obj;
        aqo.a("Thumb uri found %s", new Object[] {
            s
        });
        uri1 = obj;
        uri = Uri.fromFile(new File(s));
        uri1 = uri;
        aqo.a("thumb uri parsed : %s", new Object[] {
            uri
        });
        return uri;
        uri1 = obj;
        aqo.a("Thumb uri not found, using :  %s", new Object[] {
            uri
        });
        return null;
    }

    static hu a(ProductNewActivity productnewactivity)
    {
        return productnewactivity.K;
    }

    private LatitudeLongitude a(du du1)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (is.g(this))
        {
            obj = du1.a();
            if (obj == null)
            {
                obj = obj1;
            } else
            {
                obj = ((LetgoAddress) (obj)).getPoint();
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = du1.c();
        }
        return ((LatitudeLongitude) (obj1));
    }

    private void a(Context context, CharSequence charsequence, CharSequence charsequence1, int i1, int j1)
    {
        F = new ProgressDialog(context);
        F.setTitle(charsequence);
        F.setMessage(charsequence1);
        if (j1 > 0)
        {
            F.setIndeterminate(false);
            F.setProgressStyle(1);
            F.setProgress(i1);
            F.setMax(j1);
            F.setCancelable(false);
        } else
        {
            F.setIndeterminate(true);
            F.setProgress(0);
        }
        F.show();
    }

    private void a(Uri uri, String s)
    {
        a(uri, s, uri);
    }

    private void a(Uri uri, String s, Uri uri1)
    {
        if (uri == null || TextUtils.isEmpty(s))
        {
            aqo.c("updateEditedImageAndShowThumbnail: invalid image", new Object[0]);
            Toast.makeText(getApplicationContext(), 0x7f090104, 1).show();
        } else
        if (J != null)
        {
            if (J instanceof LocalImage)
            {
                LocalImage localimage = (LocalImage)J;
                localimage.setPath(s);
                localimage.setUri(uri);
                if (uri1 != null)
                {
                    localimage.setThumbUri(uri1);
                } else
                {
                    localimage.setThumbUri(uri);
                }
                J = localimage;
                K.a(J);
                return;
            }
            if (uri1 == null)
            {
                uri1 = uri;
            }
            uri = new LocalImage(s, uri, uri1);
            K.a(J, uri);
            J = uri;
            return;
        }
    }

    private void a(ft ft1)
    {
        String s = ft1.b;
        int i1 = 0;
        if (Q != null)
        {
            i1 = Q.getCategoryId();
            s = Q.getCurrency();
        }
        a(ft1.a, i1);
        i(s);
    }

    private void a(LatitudeLongitude latitudelongitude, LetgoAddress letgoaddress)
    {
        ParseUser parseuser = ParseUser.getCurrentUser();
        double d1;
        String s;
        String s1;
        String s2;
        List list;
        Intent intent;
        String s3;
        if (letgoaddress != null)
        {
            s = letgoaddress.getCountryCode();
        } else
        {
            s = parseuser.getString("country_code");
        }
        if (letgoaddress != null)
        {
            s1 = letgoaddress.getCity();
        } else
        {
            s1 = parseuser.getString("city");
        }
        if (letgoaddress != null)
        {
            s2 = letgoaddress.getStreetName();
        } else
        {
            s2 = parseuser.getString("address");
        }
        if (letgoaddress != null)
        {
            letgoaddress = letgoaddress.getZipCode();
        } else
        {
            letgoaddress = parseuser.getString("zip_code");
        }
        list = K.c();
        intent = new Intent(this, com/abtnprojects/ambatana/services/ProductCreationService);
        intent.putExtra("messenger", C);
        s3 = etProductPrice.getText().toString();
        if (s3 == null)
        {
            d1 = 0.0D;
        } else
        {
            d1 = Double.parseDouble(s3);
        }
        intent.putExtra("productToInsert", new Product(null, etProductTitle.getText().toString(), H, p, etProductDescription.getText().toString(), null, I, 0, new Geo(latitudelongitude.getLatitude(), latitudelongitude.getLongitude(), s, s1, letgoaddress), list, null, null, null, false, false, new User(parseuser.getObjectId(), null, null, false, null, null, null), d1, 0));
        intent.putExtra("address", s2);
        intent.putExtra("share_in_fb", cbFacebookShare.isChecked());
        startService(intent);
    }

    private void a(ProductInserted productinserted, boolean flag)
    {
        Object obj;
        String s;
        String s1;
        f f1;
        if (productinserted == null)
        {
            obj = null;
        } else
        {
            obj = productinserted.getImageUrl();
        }
        if (productinserted == null)
        {
            s = "";
        } else
        {
            s = productinserted.getTitle();
        }
        s1 = productinserted.getProductId();
        f1 = new f(s1) {

            final String a;
            final ProductNewActivity b;

            public void a(android.support.v7.ke.a a1)
            {
                if (a1 != null && a1.a() != null)
                {
                    aqo.a("Facebook share success %s", new Object[] {
                        a1.a()
                    });
                    ProductNewActivity.j(b).b(b, a);
                }
                com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.b(b, a);
            }

            public void onCancel()
            {
                com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.b(b, a);
            }

            public void onError(h h1)
            {
                aqo.b(h1, "Facebook share error ", new Object[0]);
                com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.b(b, a);
            }

            public void onSuccess(Object obj1)
            {
                a((android.support.v7.ke.a)obj1);
            }

            
            {
                b = ProductNewActivity.this;
                a = s;
                super();
            }
        };
        if (!TextUtils.isEmpty(((CharSequence) (obj))) && flag && kf.a(com/facebook/share/model/ShareLinkContent))
        {
            d(getString(0x7f0900f9));
            String s2 = ParseUser.getCurrentUser().getString("username_public");
            a(((String) (obj)), s, f1, ((android.app.Activity) (this)), G, s1, productinserted.getDescription(), s2);
            return;
        } else
        {
            e(s1);
            return;
        }
    }

    static void a(ProductNewActivity productnewactivity, int i1)
    {
        productnewactivity.d(i1);
    }

    static void a(ProductNewActivity productnewactivity, Context context, CharSequence charsequence, CharSequence charsequence1, int i1, int j1)
    {
        productnewactivity.a(context, charsequence, charsequence1, i1, j1);
    }

    static void a(ProductNewActivity productnewactivity, Uri uri, String s)
    {
        productnewactivity.a(uri, s);
    }

    static void a(ProductNewActivity productnewactivity, Uri uri, String s, Uri uri1)
    {
        productnewactivity.a(uri, s, uri1);
    }

    static void a(ProductNewActivity productnewactivity, String s)
    {
        productnewactivity.f(s);
    }

    static int b(ProductNewActivity productnewactivity, int i1)
    {
        productnewactivity.H = i1;
        return i1;
    }

    private String b(Uri uri)
    {
        Object obj = null;
        Cursor cursor = getContentResolver().query(uri, new String[] {
            "_id"
        }, null, null, null);
        uri = obj;
        if (cursor != null)
        {
            uri = obj;
            if (cursor.getCount() > 0)
            {
                int i1 = cursor.getColumnIndexOrThrow("_id");
                cursor.moveToFirst();
                long l1 = cursor.getLong(i1);
                cursor.close();
                cursor = android.provider.MediaStore.Images.Thumbnails.queryMiniThumbnail(getContentResolver(), l1, 1, null);
                uri = obj;
                if (cursor != null)
                {
                    uri = obj;
                    if (cursor.getCount() > 0)
                    {
                        cursor.moveToFirst();
                        uri = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        cursor.close();
                    }
                }
            }
        }
        return uri;
    }

    static void b(ProductNewActivity productnewactivity)
    {
        productnewactivity.O();
    }

    static void b(ProductNewActivity productnewactivity, String s)
    {
        productnewactivity.e(s);
    }

    static String c(ProductNewActivity productnewactivity, String s)
    {
        productnewactivity.I = s;
        return s;
    }

    static void c(ProductNewActivity productnewactivity)
    {
        productnewactivity.N();
    }

    private void d(int i1)
    {
        J = K.a(i1);
    }

    static void d(ProductNewActivity productnewactivity)
    {
        productnewactivity.I();
    }

    static void e(ProductNewActivity productnewactivity)
    {
        productnewactivity.P();
    }

    private void e(String s)
    {
        runOnUiThread(new Runnable(s) {

            final String a;
            final ProductNewActivity b;

            public void run()
            {
                ProductNewActivity.a(b, a);
                b.setResult(-1);
                b.finish();
            }

            
            {
                b = ProductNewActivity.this;
                a = s;
                super();
            }
        });
    }

    static void f(ProductNewActivity productnewactivity)
    {
        productnewactivity.Q();
    }

    private void f(String s)
    {
        if (P == null)
        {
            P = new ic(this);
        }
        P.a(s);
    }

    static void g(ProductNewActivity productnewactivity)
    {
        productnewactivity.R();
    }

    private boolean g(String s)
    {
        return !TextUtils.isEmpty(s) && h(s);
    }

    static ProgressDialog h(ProductNewActivity productnewactivity)
    {
        return productnewactivity.F;
    }

    private boolean h(String s)
    {
        boolean flag = false;
        double d1;
        try
        {
            d1 = Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (d1 > 0.0D)
        {
            flag = true;
        }
        return flag;
    }

    static void i(ProductNewActivity productnewactivity)
    {
        productnewactivity.S();
    }

    private void i(String s)
    {
        I = s;
        Object obj = new ArrayList();
        if (TextUtils.isEmpty(s))
        {
            ((ArrayList) (obj)).addAll(Arrays.asList(n));
        } else
        if ("USD".equals(s))
        {
            ((ArrayList) (obj)).add(s);
            ((ArrayList) (obj)).addAll(Arrays.asList(A));
        } else
        if ("EUR".equals(s))
        {
            ((ArrayList) (obj)).add(s);
            ((ArrayList) (obj)).addAll(Arrays.asList(D));
        } else
        {
            ((ArrayList) (obj)).add(s);
            ((ArrayList) (obj)).addAll(Arrays.asList(n));
        }
        s = new String[((ArrayList) (obj)).size()];
        ((ArrayList) (obj)).toArray(s);
        obj = new ArrayAdapter(this, 0x7f040031, 0x7f1000ec, s);
        if (spCurrency == null)
        {
            spCurrency = (Spinner)findViewById(0x7f1000b7);
        }
        spCurrency.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        spCurrency.setSelection(0);
        spCurrency.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(s) {

            final String a[];
            final ProductNewActivity b;

            public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
            {
                ProductNewActivity.c(b, a[i1]);
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                b = ProductNewActivity.this;
                a = as;
                super();
            }
        });
    }

    static gx j(ProductNewActivity productnewactivity)
    {
        return productnewactivity.E;
    }

    void C()
    {
        M = true;
        dw dw1 = new dw(this, new AddressMapper());
        LatitudeLongitude latitudelongitude = a(dw1);
        int i1;
        int j1;
        if (Q == null)
        {
            i1 = 0x7f090108;
        } else
        {
            i1 = 0x7f0900fb;
        }
        j1 = L();
        aqo.a("Max progress %d", new Object[] {
            Integer.valueOf(j1)
        });
        a(this, getString(0x7f090109), getString(i1), L, j1);
        if (Q == null)
        {
            a(latitudelongitude, dw1.a());
            return;
        } else
        {
            K();
            return;
        }
    }

    void D()
    {
        Toast.makeText(getApplicationContext(), 0x7f0900c0, 1).show();
        o();
    }

    void E()
    {
        boolean flag1 = true;
        M();
        H();
        StringBuilder stringbuilder = new StringBuilder(getString(0x7f090129));
        stringbuilder.append("\n").append("\n");
        String s = etProductTitle.getText().toString();
        String s1 = etProductDescription.getText().toString();
        String s2 = etProductPrice.getText().toString();
        boolean flag;
        if (K.a() == 0)
        {
            stringbuilder.append(" - ").append(getString(0x7f090102)).append("\n");
            flag = true;
        } else
        {
            flag = false;
        }
        if (H == 0)
        {
            stringbuilder.append(" - ").append(getString(0x7f0900fc)).append("\n");
            flag = true;
        }
        if (TextUtils.isEmpty(s))
        {
            stringbuilder.append(" - ").append(getString(0x7f090101)).append("\n");
            flag = true;
        }
        if (TextUtils.isEmpty(s1))
        {
            stringbuilder.append(" - ").append(getString(0x7f0900fd)).append("\n");
            flag = true;
        }
        if (!g(s2))
        {
            stringbuilder.append(" - ").append(getString(0x7f090100)).append("\n");
            flag = flag1;
        }
        if (flag)
        {
            E.a(this, stringbuilder.toString());
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(0x7f090103));
            builder.setMessage(stringbuilder);
            builder.setPositiveButton(getString(0x7f090060), new android.content.DialogInterface.OnClickListener() {

                final ProductNewActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.d(a);
                }

            
            {
                a = ProductNewActivity.this;
                super();
            }
            });
            builder.setCancelable(false);
            O = builder.create();
            O.show();
            N = false;
            return;
        } else
        {
            l();
            return;
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        Object obj = null;
        bundle = null;
        if (!flag)
        {
            getWindow().setSoftInputMode(3);
            G = com.facebook.d.a.a();
            P = new ic(this);
            a(0x7f0200d1);
            ButterKnife.bind(this);
            flag = kf.a(com/facebook/share/model/ShareLinkContent);
            boolean flag1 = ParseFacebookUtils.isLinked(ParseUser.getCurrentUser());
            Void avoid[];
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            cbFacebookShare.setVisibility(i1);
            if (flag && flag1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            cbFacebookShare.setChecked(flag);
            F();
            iv.a(this);
            Q = (Product)getIntent().getParcelableExtra("product");
            obj = new gy();
            if (Q != null)
            {
                bundle = Q.getId();
            }
            E = ((gy) (obj)).a(bundle, new gh(), new iu(), w);
            obj = new fg(getString(0x7f09010e), this, r, Q);
            avoid = new Void[0];
            if (!(obj instanceof AsyncTask))
            {
                ((fg) (obj)).execute(avoid);
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
            }
            E.a(this);
            G();
            btnProductSubmit.setOnClickListener(new android.view.View.OnClickListener() {

                final ProductNewActivity a;

                public void onClick(View view)
                {
                    a.onSellButtonClicked();
                }

            
            {
                a = ProductNewActivity.this;
                super();
            }
            });
            if (bundle == null)
            {
                i1 = 0x7f09005e;
            } else
            {
                i1 = 0x7f09009b;
            }
            setTitle(i1);
            if (bundle == null)
            {
                i1 = 0x7f0900f8;
            } else
            {
                i1 = 0x7f0900fa;
            }
            btnProductSubmit.setText(i1);
            T();
            return;
        }
        gy gy1 = new gy();
        if (Q == null)
        {
            bundle = ((Bundle) (obj));
        } else
        {
            bundle = Q.getId();
        }
        E = gy1.a(bundle, new gh(), new iu(), ParseUser.getCurrentUser());
    }

    protected void a(CountryCurrencyInfo countrycurrencyinfo)
    {
        super.a(countrycurrencyinfo);
        i(countrycurrencyinfo.getCurrencyCode());
    }

    public void a(ProductInserted productinserted)
    {
        if (productinserted != null)
        {
            String s;
            if (is.g(getApplicationContext()))
            {
                s = "manual";
            } else
            {
                s = "auto";
            }
            E.a(this, productinserted, s);
            a(productinserted, productinserted.isShareProduct());
            return;
        } else
        {
            iv.a(F);
            Toast.makeText(getApplicationContext(), 0x7f0900a7, 1).show();
            return;
        }
    }

    void a(String s, int i1)
    {
        if (F != null)
        {
            F.setMessage(s);
            F.setProgress(i1);
        }
    }

    public void a(List list, int i1)
    {
        if (spCategory == null)
        {
            spCategory = (Spinner)findViewById(0x7f1000b8);
        }
        list = new hp(this, list);
        spCategory.setAdapter(list);
        spCategory.setSelection(i1);
        spCategory.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(list) {

            final hp a;
            final ProductNewActivity b;

            public void onItemSelected(AdapterView adapterview, View view, int j1, long l1)
            {
                if (j1 >= 1)
                {
                    adapterview = a.a(j1);
                    com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.b(b, adapterview.getId());
                    return;
                } else
                {
                    com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity.b(b, 0);
                    return;
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                b = ProductNewActivity.this;
                a = hp1;
                super();
            }
        });
    }

    public void c(int i1)
    {
        d(getString(0x7f09010c, new Object[] {
            Integer.valueOf(i1)
        }));
    }

    public void d(String s)
    {
        L = L + 1;
        a(s, L);
    }

    protected void k()
    {
        setContentView(0x7f040024);
    }

    public void l()
    {
        LatitudeLongitude latitudelongitude = (new dw(this, new AddressMapper())).c();
        if (latitudelongitude == null || !latitudelongitude.isValid())
        {
            J();
            return;
        } else
        {
            C();
            return;
        }
    }

    protected boolean m()
    {
        boolean flag1 = false;
        Object obj = getIntent().getExtras();
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (((Bundle) (obj)).containsKey("referral"))
            {
                obj = ((Bundle) (obj)).getString("referral");
                flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if ("posting_completed".equals(obj))
                    {
                        flag = flag1;
                        if (!z())
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        G.a(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 0 4: default 56
    //                   0 194
    //                   1 57
    //                   2 56
    //                   3 56
    //                   4 251;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        return;
_L3:
        if (j1 == -1)
        {
            Object obj = intent.getData();
            boolean flag = im.a(((Uri) (obj)), this);
            intent = im.a(this, ((Uri) (obj)));
            if (intent == null)
            {
                if (obj == null)
                {
                    intent = "";
                } else
                {
                    intent = ((Uri) (obj)).toString();
                }
                aqo.c("Invalid file path : %s", new Object[] {
                    intent
                });
                S();
                return;
            }
            if (flag)
            {
                obj = new d(this);
                String as[] = new String[1];
                as[0] = intent;
                if (!(obj instanceof AsyncTask))
                {
                    ((d) (obj)).execute(as);
                    return;
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)obj, as);
                    return;
                }
            } else
            {
                a(((Uri) (obj)), intent, a(((Uri) (obj))));
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j1 == -1 && B != null)
        {
            intent = new b(B);
            Void avoid[] = new Void[0];
            if (!(intent instanceof AsyncTask))
            {
                intent.execute(avoid);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)intent, avoid);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (j1 == -1)
        {
            E();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), 0x7f0900a4, 1).show();
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onDestroy()
    {
        iv.a(O);
        super.onDestroy();
    }

    public void onEvent(ed ed)
    {
        D();
    }

    public void onEvent(ee ee1)
    {
        if (ee1.a == null)
        {
            D();
        } else
        if (N)
        {
            E();
            return;
        }
    }

    public void onEvent(ej ej1)
    {
        iv.a(F);
        a(ej1.a);
    }

    public void onEvent(ek ek)
    {
        a(this, getString(0x7f0900b1), getString(0x7f0900b0), 0, 0);
    }

    protected void onPause()
    {
        super.onPause();
        iv.a(F);
        iv.b(this);
    }

    protected void onResume()
    {
        super.onResume();
        iv.a(this);
    }

    public void onSellButtonClicked()
    {
        aqo.b("sell button clicked", new Object[0]);
        N = true;
        E();
    }

}
