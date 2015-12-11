// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.net.Uri;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import oauth.signpost.OAuth;
import oauth.signpost.http.HttpParameters;
import roboguice.util.Strings;

public class Uris
{
    public static class Builder
    {

        private android.net.Uri.Builder _flddelegate;

        public Builder appendEncodedPath(String s)
        {
            _flddelegate.appendEncodedPath(s);
            return this;
        }

        public Builder appendPath(String s)
        {
            _flddelegate.appendPath(s);
            return this;
        }

        public Builder appendQueryParameter(String s, String s1)
        {
            _flddelegate.appendQueryParameter(s, s1);
            return this;
        }

        public Builder authority(String s)
        {
            _flddelegate.authority(s);
            return this;
        }

        public Uri build()
        {
            return _flddelegate.build();
        }

        public Builder clearQuery()
        {
            _flddelegate.query(null);
            return this;
        }

        public Builder encodedAuthority(String s)
        {
            _flddelegate.encodedAuthority(s);
            return this;
        }

        public Builder encodedFragment(String s)
        {
            _flddelegate.encodedFragment(s);
            return this;
        }

        public Builder encodedOpaquePart(String s)
        {
            _flddelegate.encodedOpaquePart(s);
            return this;
        }

        public Builder encodedPath(String s)
        {
            _flddelegate.encodedPath(s);
            return this;
        }

        public Builder encodedQuery(String s)
        {
            _flddelegate.encodedQuery(s);
            return this;
        }

        public Builder fragment(String s)
        {
            _flddelegate.fragment(s);
            return this;
        }

        public Builder opaquePart(String s)
        {
            _flddelegate.opaquePart(s);
            return this;
        }

        public Builder path(String s)
        {
            _flddelegate.path(s);
            return this;
        }

        public Builder query(String s)
        {
            _flddelegate.query(s);
            return this;
        }

        public Builder removeQueryParameter(String s)
        {
            Object obj = _flddelegate.build().getEncodedQuery();
            clearQuery();
            obj = OAuth.decodeForm(((String) (obj)));
            ((HttpParameters) (obj)).remove(s);
            for (s = ((HttpParameters) (obj)).keySet().iterator(); s.hasNext();)
            {
                String s1 = (String)s.next();
                Iterator iterator = ((HttpParameters) (obj)).get(s1).iterator();
                while (iterator.hasNext()) 
                {
                    appendQueryParameter(s1, (String)iterator.next());
                }
            }

            return this;
        }

        public Builder scheme(String s)
        {
            _flddelegate.scheme(s);
            return this;
        }

        public transient Builder setQueryParameter(String s, String as[])
        {
            removeQueryParameter(s);
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                appendQueryParameter(s, as[i]);
            }

            return this;
        }

        public String toString()
        {
            return _flddelegate.toString();
        }

        public Builder(Uri uri)
        {
            _flddelegate = uri.buildUpon();
        }

        public Builder(Object obj)
        {
            _flddelegate = Uris.toUri(obj).buildUpon();
        }
    }


    public Uris()
    {
    }

    public static Builder buildUpon(Object obj)
    {
        return new Builder(toUri(obj));
    }

    public static Uri toUri(Object obj)
    {
        if (obj instanceof Uri)
        {
            return (Uri)obj;
        } else
        {
            return Uri.parse(Strings.toString(obj));
        }
    }
}
