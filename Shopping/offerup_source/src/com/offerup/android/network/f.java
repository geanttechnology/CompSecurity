// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.b.a.a.g;
import com.offerup.android.dto.IndexedItemPostPhoto;
import com.offerup.android.dto.ItemPostPhoto;
import com.offerup.android.dto.S3Photo;
import e.a;
import e.d.a.aa;
import e.g.j;
import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import retrofit.mime.TypedFile;

// Referenced classes of package com.offerup.android.network:
//            n, l, o, PhotosUploadService, 
//            PhotosService, m, k, j, 
//            i, h, g

public final class f
{

    private Context a;

    public f(Context context)
    {
        a = context.getApplicationContext();
    }

    static a a(f f1, n n1)
    {
        String s = null;
        S3Photo s3photo = com.offerup.android.network.n.a(n1);
        Object obj = n.b(n1).getItemPostPhoto();
        TypedFile typedfile = s;
        Object obj1;
        if (obj != null)
        {
            if (((ItemPostPhoto) (obj)).getImageUri() == null)
            {
                typedfile = s;
            } else
            {
                String s1;
                String s2;
                String s3;
                if ("file".equalsIgnoreCase(((ItemPostPhoto) (obj)).getImageUri().getScheme()))
                {
                    obj = new File(((ItemPostPhoto) (obj)).getImageUri().getPath());
                } else
                if ("content".equalsIgnoreCase(((ItemPostPhoto) (obj)).getImageUri().getScheme()))
                {
                    obj = f1.a(f1.a, ((ItemPostPhoto) (obj)).getImageUri());
                } else
                {
                    obj = null;
                }
                typedfile = s;
                if (obj != null)
                {
                    typedfile = new TypedFile("image/jpeg", ((File) (obj)));
                }
            }
        }
        obj1 = s3photo.getUploadUrl();
        if (obj1 == null)
        {
            obj = e.a.a(new Throwable(String.format("photo[%s] had null upload location", new Object[] {
                s3photo.getUuid()
            })));
        } else
        {
            obj = ((Uri) (obj1)).getQueryParameter("Signature");
            s = ((Uri) (obj1)).getQueryParameter("x-amz-acl");
            s1 = ((Uri) (obj1)).getQueryParameter("Expires");
            s2 = ((Uri) (obj1)).getQueryParameter("AWSAccessKeyId");
            s3 = ((Uri) (obj1)).getQueryParameter("x-amz-security-token");
            obj1 = String.format("%s://%s", new Object[] {
                ((Uri) (obj1)).getScheme(), ((Uri) (obj1)).getHost()
            });
            obj = o.p(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor(), ((String) (obj1)))).upload(s3photo.getUuid(), ((String) (obj)), s1, s2, s, s3, typedfile).b(j.b());
        }
        return e.a.a(((a) (obj)), e.a.a(n1), new l(f1)).b(j.a());
    }

    static a a(f f1, List list)
    {
        a a1 = e.a.a(list).b(j.a());
        int i1 = list.size();
        return e.a.a(a1, o.o(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).generateUrls(Integer.valueOf(i1)).b(j.b()).b(new m(f1)).b(j.a()), new k(f1)).b(j.a());
    }

    private File a(Context context, Uri uri)
    {
        context = context.getApplicationContext().getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        uri = new File(context.getString(0));
        context.close();
        return uri;
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(this, context);
        }
        break MISSING_BLOCK_LABEL_87;
        uri;
        context.close();
        throw uri;
        return null;
    }

    public final a a(List list)
    {
        Integer ainteger[] = new Integer[list.size()];
        for (int i1 = 0; i1 < ainteger.length; i1++)
        {
            ainteger[i1] = Integer.valueOf(i1);
        }

        return e.a.a(e.a.a(ainteger).b(j.a()), e.a.a(list).b(j.a()), new com.offerup.android.network.j(this)).b(j.a()).a(new e.d.a.f(new i(this))).b(j.a()).a(aa.a()).b(j.a()).b(new h(this)).b(j.a()).b(new com.offerup.android.network.g(this)).b(j.a());
    }
}
