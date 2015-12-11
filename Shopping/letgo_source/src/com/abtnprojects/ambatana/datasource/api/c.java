// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import android.support.v7.aev;
import android.support.v7.aqo;
import android.text.TextUtils;
import android.util.JsonReader;
import com.abtnprojects.ambatana.services.SendMessageService;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

// Referenced classes of package com.abtnprojects.ambatana.datasource.api:
//            DeleteProductService, MarkAsSoldService, UserFavoritesService, GetPlaceService, 
//            GetAddressByIpService, GetProductsService, ReportProductService, GetProductService, 
//            UploadImageService, CreateProductService, EditProductService, FavoriteReportedService

public class c
{
    public static final class a
        implements Converter
    {

        public JSONObject a(TypedInput typedinput, Type type)
            throws ConversionException
        {
            String s;
            String s1;
            try
            {
                type = new BufferedReader(new InputStreamReader(typedinput.in()));
                typedinput = new StringBuilder();
                s = System.getProperty("line.separator");
            }
            // Misplaced declaration of an exception variable
            catch (TypedInput typedinput)
            {
                aqo.b(typedinput, "fromBody : Unable to parse body", new Object[0]);
                return null;
            }
            s1 = type.readLine();
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_73;
            }
            try
            {
                typedinput.append(s1);
                typedinput.append(s);
                break MISSING_BLOCK_LABEL_35;
            }
            // Misplaced declaration of an exception variable
            catch (Type type) { }
            aqo.b(type, "fromBody : unable to readLine", new Object[0]);
            typedinput = JSONObjectInstrumentation.init(typedinput.toString());
            return typedinput;
            typedinput;
            aqo.b(typedinput, "fromBody : unable to parse to JSONArray", new Object[0]);
            return null;
        }

        public Object fromBody(TypedInput typedinput, Type type)
            throws ConversionException
        {
            return a(typedinput, type);
        }

        public TypedOutput toBody(Object obj)
        {
            return null;
        }

        public a()
        {
        }
    }

    public static class b
        implements Converter
    {

        private void a(TypedInput typedinput)
        {
            try
            {
                typedinput.in().close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (TypedInput typedinput)
            {
                typedinput.printStackTrace();
            }
        }

        public Object fromBody(TypedInput typedinput, Type type)
            throws ConversionException
        {
            (new JsonReader(new InputStreamReader(typedinput.in()))).setLenient(true);
            type = ((Type) (new Object()));
            a(typedinput);
            return type;
            typedinput;
            aqo.b(typedinput, "fromBody", new Object[0]);
            return null;
            typedinput;
            throw typedinput;
        }

        public TypedOutput toBody(Object obj)
        {
            return null;
        }

        public b()
        {
        }
    }


    public static DeleteProductService a(String s)
    {
        return (DeleteProductService)n(s).create(com/abtnprojects/ambatana/datasource/api/DeleteProductService);
    }

    public static Object a(String s, Class class1)
    {
        return a(s, "http://api.letgo.com").build().create(class1);
    }

    private static retrofit.RestAdapter.Builder a(String s, String s1)
    {
        s1 = (new retrofit.RestAdapter.Builder()).setLogLevel(retrofit.RestAdapter.LogLevel.FULL).setEndpoint(s1);
        if (!TextUtils.isEmpty(s))
        {
            s1.setRequestInterceptor(new RequestInterceptor(s) {

                final String a;

                public void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
                {
                    requestfacade.addHeader("X-Letgo-Parse-User-Token", a);
                }

            
            {
                a = s;
                super();
            }
            });
        }
        return s1;
    }

    public static MarkAsSoldService b(String s)
    {
        return (MarkAsSoldService)n(s).create(com/abtnprojects/ambatana/datasource/api/MarkAsSoldService);
    }

    public static UserFavoritesService c(String s)
    {
        return (UserFavoritesService)n(s).create(com/abtnprojects/ambatana/datasource/api/UserFavoritesService);
    }

    public static GetPlaceService d(String s)
    {
        return (GetPlaceService)a(s, "http://api.letgo.com").setConverter(new GsonConverter((new aev()).a())).setConverter(new a()).build().create(com/abtnprojects/ambatana/datasource/api/GetPlaceService);
    }

    public static GetAddressByIpService e(String s)
    {
        return (GetAddressByIpService)a(s, "http://api.letgo.com").setConverter(new GsonConverter((new aev()).a())).setConverter(new a()).build().create(com/abtnprojects/ambatana/datasource/api/GetAddressByIpService);
    }

    public static GetProductsService f(String s)
    {
        return (GetProductsService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/GetProductsService);
    }

    public static ReportProductService g(String s)
    {
        return (ReportProductService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/ReportProductService);
    }

    public static GetProductService h(String s)
    {
        return (GetProductService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/GetProductService);
    }

    public static UploadImageService i(String s)
    {
        return (UploadImageService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/UploadImageService);
    }

    public static CreateProductService j(String s)
    {
        return (CreateProductService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/CreateProductService);
    }

    public static EditProductService k(String s)
    {
        return (EditProductService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/EditProductService);
    }

    public static FavoriteReportedService l(String s)
    {
        return (FavoriteReportedService)a(s, "http://api.letgo.com").build().create(com/abtnprojects/ambatana/datasource/api/FavoriteReportedService);
    }

    public static SendMessageService m(String s)
    {
        return (SendMessageService)a(s, "http://api.letgo.com").setConverter(new GsonConverter((new aev()).a())).setConverter(new b()).build().create(com/abtnprojects/ambatana/services/SendMessageService);
    }

    private static RestAdapter n(String s)
    {
        return a(s, "http://api.letgo.com").build();
    }
}
