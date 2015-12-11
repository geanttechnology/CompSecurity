// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.a.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal.model.people:
//            a, b, c, d, 
//            e, f, g, h, 
//            i, j

public final class PersonEntity extends FastSafeParcelableJsonResponse
    implements a
{
    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.a
    {

        public static final b CREATOR = new b();
        private static final HashMap e;
        final Set a;
        final int b;
        int c;
        int d;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return Integer.valueOf(c);

            case 3: // '\003'
                return Integer.valueOf(d);
            }
        }

        public final Map b()
        {
            return e;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof AgeRangeEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (AgeRangeEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = e.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((AgeRangeEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((AgeRangeEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((AgeRangeEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = e.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.b.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            e = hashmap;
            hashmap.put("max", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("max", 2));
            e.put("min", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("min", 3));
        }

        public AgeRangeEntity()
        {
            b = 1;
            a = new HashSet();
        }

        AgeRangeEntity(Set set, int i1, int j1, int k1)
        {
            a = set;
            b = i1;
            c = j1;
            d = k1;
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.b
    {

        public static final c CREATOR = new c();
        private static final HashMap f;
        final Set a;
        final int b;
        CoverInfoEntity c;
        CoverPhotoEntity d;
        int e;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return c;

            case 3: // '\003'
                return d;

            case 4: // '\004'
                return Integer.valueOf(e);
            }
        }

        public final Map b()
        {
            return f;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof CoverEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = f.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((CoverEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((CoverEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = f.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.c.a(this, parcel, i1);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            f = hashmap;
            hashmap.put("coverInfo", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("coverInfo", 2, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverInfoEntity));
            f.put("coverPhoto", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("coverPhoto", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity$CoverPhotoEntity));
            f.put("layout", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("layout", 4, (new StringToIntConverter()).a("banner", 0)));
        }

        public CoverEntity()
        {
            b = 1;
            a = new HashSet();
        }

        CoverEntity(Set set, int i1, CoverInfoEntity coverinfoentity, CoverPhotoEntity coverphotoentity, int j1)
        {
            a = set;
            b = i1;
            c = coverinfoentity;
            d = coverphotoentity;
            e = j1;
        }
    }

    public static final class CoverEntity.CoverInfoEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.b.a
    {

        public static final d CREATOR = new d();
        private static final HashMap e;
        final Set a;
        final int b;
        int c;
        int d;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return Integer.valueOf(c);

            case 3: // '\003'
                return Integer.valueOf(d);
            }
        }

        public final Map b()
        {
            return e;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof CoverEntity.CoverInfoEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverEntity.CoverInfoEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = e.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((CoverEntity.CoverInfoEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((CoverEntity.CoverInfoEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverEntity.CoverInfoEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = e.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.d.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            e = hashmap;
            hashmap.put("leftImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("leftImageOffset", 2));
            e.put("topImageOffset", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("topImageOffset", 3));
        }

        public CoverEntity.CoverInfoEntity()
        {
            b = 1;
            a = new HashSet();
        }

        CoverEntity.CoverInfoEntity(Set set, int i1, int j1, int k1)
        {
            a = set;
            b = i1;
            c = j1;
            d = k1;
        }
    }

    public static final class CoverEntity.CoverPhotoEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.b.b
    {

        public static final e CREATOR = new e();
        private static final HashMap f;
        final Set a;
        final int b;
        int c;
        String d;
        int e;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return Integer.valueOf(c);

            case 3: // '\003'
                return d;

            case 4: // '\004'
                return Integer.valueOf(e);
            }
        }

        public final Map b()
        {
            return f;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof CoverEntity.CoverPhotoEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (CoverEntity.CoverPhotoEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = f.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((CoverEntity.CoverPhotoEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((CoverEntity.CoverPhotoEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((CoverEntity.CoverPhotoEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = f.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.e.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            f = hashmap;
            hashmap.put("height", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("height", 2));
            f.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("url", 3));
            f.put("width", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("width", 4));
        }

        public CoverEntity.CoverPhotoEntity()
        {
            b = 1;
            a = new HashSet();
        }

        CoverEntity.CoverPhotoEntity(Set set, int i1, int j1, String s1, int k1)
        {
            a = set;
            b = i1;
            c = j1;
            d = s1;
            e = k1;
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.c
    {

        public static final f CREATOR = new f();
        private static final HashMap d;
        final Set a;
        final int b;
        String c;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return c;
            }
        }

        public final Map b()
        {
            return d;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final String e()
        {
            return c;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof ImageEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (ImageEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = d.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((ImageEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((ImageEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((ImageEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = d.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.f.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            d = hashmap;
            hashmap.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("url", 2));
        }

        public ImageEntity()
        {
            b = 1;
            a = new HashSet();
        }

        ImageEntity(Set set, int i1, String s1)
        {
            a = set;
            b = i1;
            c = s1;
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.d
    {

        public static final g CREATOR = new g();
        private static final HashMap i;
        final Set a;
        final int b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return c;

            case 3: // '\003'
                return d;

            case 4: // '\004'
                return e;

            case 5: // '\005'
                return f;

            case 6: // '\006'
                return g;

            case 7: // '\007'
                return h;
            }
        }

        public final Map b()
        {
            return i;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof NameEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (NameEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = i.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((NameEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((NameEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((NameEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = i.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.g.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            i = hashmap;
            hashmap.put("familyName", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("familyName", 2));
            i.put("formatted", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("formatted", 3));
            i.put("givenName", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("givenName", 4));
            i.put("honorificPrefix", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("honorificPrefix", 5));
            i.put("honorificSuffix", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("honorificSuffix", 6));
            i.put("middleName", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("middleName", 7));
        }

        public NameEntity()
        {
            b = 1;
            a = new HashSet();
        }

        NameEntity(Set set, int i1, String s1, String s2, String s3, String s4, String s5, 
                String s6)
        {
            a = set;
            b = i1;
            c = s1;
            d = s2;
            e = s3;
            f = s4;
            g = s5;
            h = s6;
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.e
    {

        public static final h CREATOR = new h();
        private static final HashMap l;
        final Set a;
        final int b;
        String c;
        String d;
        String e;
        String f;
        String g;
        boolean h;
        String i;
        String j;
        int k;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return c;

            case 3: // '\003'
                return d;

            case 4: // '\004'
                return e;

            case 5: // '\005'
                return f;

            case 6: // '\006'
                return g;

            case 7: // '\007'
                return Boolean.valueOf(h);

            case 8: // '\b'
                return i;

            case 9: // '\t'
                return j;

            case 10: // '\n'
                return Integer.valueOf(k);
            }
        }

        public final Map b()
        {
            return l;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof OrganizationsEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (OrganizationsEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = l.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((OrganizationsEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((OrganizationsEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((OrganizationsEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = l.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.h.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            l = hashmap;
            hashmap.put("department", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("department", 2));
            l.put("description", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("description", 3));
            l.put("endDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("endDate", 4));
            l.put("location", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("location", 5));
            l.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("name", 6));
            l.put("primary", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("primary", 7));
            l.put("startDate", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("startDate", 8));
            l.put("title", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("title", 9));
            l.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("type", 10, (new StringToIntConverter()).a("work", 0).a("school", 1)));
        }

        public OrganizationsEntity()
        {
            b = 1;
            a = new HashSet();
        }

        OrganizationsEntity(Set set, int i1, String s1, String s2, String s3, String s4, String s5, 
                boolean flag, String s6, String s7, int j1)
        {
            a = set;
            b = i1;
            c = s1;
            d = s2;
            e = s3;
            f = s4;
            g = s5;
            h = flag;
            i = s6;
            j = s7;
            k = j1;
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.f
    {

        public static final i CREATOR = new i();
        private static final HashMap e;
        final Set a;
        final int b;
        boolean c;
        String d;

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 2: // '\002'
                return Boolean.valueOf(c);

            case 3: // '\003'
                return d;
            }
        }

        public final Map b()
        {
            return e;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof PlacesLivedEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (PlacesLivedEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = e.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((PlacesLivedEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((PlacesLivedEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((PlacesLivedEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = e.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.i.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            e = hashmap;
            hashmap.put("primary", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("primary", 2));
            e.put("value", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("value", 3));
        }

        public PlacesLivedEntity()
        {
            b = 1;
            a = new HashSet();
        }

        PlacesLivedEntity(Set set, int i1, boolean flag, String s1)
        {
            a = set;
            b = i1;
            c = flag;
            d = s1;
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse
        implements com.google.android.gms.plus.a.a.a.g
    {

        public static final j CREATOR = new j();
        private static final HashMap f;
        final Set a;
        final int b;
        String c;
        int d;
        String e;
        private final int g;

        public static int e()
        {
            return 4;
        }

        public final Object a()
        {
            return this;
        }

        protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            return a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
        {
            switch (field.f())
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

            case 5: // '\005'
                return c;

            case 6: // '\006'
                return Integer.valueOf(d);

            case 4: // '\004'
                return e;
            }
        }

        public final Map b()
        {
            return f;
        }

        public final int describeContents()
        {
            return 0;
        }

        public final boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof UrlsEntity))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (UrlsEntity)obj;
                com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
                do
                {
                    for (Iterator iterator = f.values().iterator(); iterator.hasNext();)
                    {
                        field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                        if (!a(field))
                        {
                            continue label1;
                        }
                        if (((UrlsEntity) (obj)).a(field))
                        {
                            if (!b(field).equals(((UrlsEntity) (obj)).b(field)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((UrlsEntity) (obj)).a(field));
                return false;
            }
            return true;
        }

        public final int hashCode()
        {
            Iterator iterator = f.values().iterator();
            int i1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                if (a(field))
                {
                    int j1 = field.f();
                    i1 = b(field).hashCode() + (i1 + j1);
                }
            } while (true);
            return i1;
        }

        public final void writeToParcel(Parcel parcel, int i1)
        {
            com.google.android.gms.plus.internal.model.people.j.a(this, parcel);
        }

        static 
        {
            HashMap hashmap = new HashMap();
            f = hashmap;
            hashmap.put("label", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("label", 5));
            f.put("type", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("type", 6, (new StringToIntConverter()).a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7)));
            f.put("value", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("value", 4));
        }

        public UrlsEntity()
        {
            g = 4;
            b = 1;
            a = new HashSet();
        }

        UrlsEntity(Set set, int i1, String s1, int j1, String s2)
        {
            g = 4;
            a = set;
            b = i1;
            c = s1;
            d = j1;
            e = s2;
        }
    }


    private static final HashMap A;
    public static final com.google.android.gms.plus.internal.model.people.a CREATOR = new com.google.android.gms.plus.internal.model.people.a();
    final Set a;
    final int b;
    String c;
    AgeRangeEntity d;
    String e;
    String f;
    int g;
    CoverEntity h;
    String i;
    String j;
    int k;
    String l;
    ImageEntity m;
    boolean n;
    String o;
    NameEntity p;
    String q;
    int r;
    List s;
    List t;
    int u;
    int v;
    String w;
    String x;
    List y;
    boolean z;

    public PersonEntity()
    {
        b = 1;
        a = new HashSet();
    }

    PersonEntity(Set set, int i1, String s1, AgeRangeEntity agerangeentity, String s2, String s3, int j1, 
            CoverEntity coverentity, String s4, String s5, int k1, String s6, ImageEntity imageentity, boolean flag, 
            String s7, NameEntity nameentity, String s8, int l1, List list, List list1, int i2, 
            int j2, String s9, String s10, List list2, boolean flag1)
    {
        a = set;
        b = i1;
        c = s1;
        d = agerangeentity;
        e = s2;
        f = s3;
        g = j1;
        h = coverentity;
        i = s4;
        j = s5;
        k = k1;
        l = s6;
        m = imageentity;
        n = flag;
        o = s7;
        p = nameentity;
        q = s8;
        r = l1;
        s = list;
        t = list1;
        u = i2;
        v = j2;
        w = s9;
        x = s10;
        y = list2;
        z = flag1;
    }

    public static PersonEntity a(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = com.google.android.gms.plus.internal.model.people.a.a(parcel);
        parcel.recycle();
        return abyte0;
    }

    public final Object a()
    {
        return this;
    }

    protected final boolean a(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        return a.contains(Integer.valueOf(field.f()));
    }

    protected final Object b(com.google.android.gms.common.server.response.FastJsonResponse.Field field)
    {
        switch (field.f())
        {
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(field.f()).toString());

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return d;

        case 4: // '\004'
            return e;

        case 5: // '\005'
            return f;

        case 6: // '\006'
            return Integer.valueOf(g);

        case 7: // '\007'
            return h;

        case 8: // '\b'
            return i;

        case 9: // '\t'
            return j;

        case 12: // '\f'
            return Integer.valueOf(k);

        case 14: // '\016'
            return l;

        case 15: // '\017'
            return m;

        case 16: // '\020'
            return Boolean.valueOf(n);

        case 18: // '\022'
            return o;

        case 19: // '\023'
            return p;

        case 20: // '\024'
            return q;

        case 21: // '\025'
            return Integer.valueOf(r);

        case 22: // '\026'
            return s;

        case 23: // '\027'
            return t;

        case 24: // '\030'
            return Integer.valueOf(u);

        case 25: // '\031'
            return Integer.valueOf(v);

        case 26: // '\032'
            return w;

        case 27: // '\033'
            return x;

        case 28: // '\034'
            return y;

        case 29: // '\035'
            return Boolean.valueOf(z);
        }
    }

    public final Map b()
    {
        return A;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final com.google.android.gms.plus.a.a.a.c e()
    {
        return m;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof PersonEntity))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (PersonEntity)obj;
            com.google.android.gms.common.server.response.FastJsonResponse.Field field;
label1:
            do
            {
                for (Iterator iterator = A.values().iterator(); iterator.hasNext();)
                {
                    field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
                    if (!a(field))
                    {
                        continue label1;
                    }
                    if (((PersonEntity) (obj)).a(field))
                    {
                        if (!b(field).equals(((PersonEntity) (obj)).b(field)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((PersonEntity) (obj)).a(field));
            return false;
        }
        return true;
    }

    public final int hashCode()
    {
        Iterator iterator = A.values().iterator();
        int i1 = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.server.response.FastJsonResponse.Field field = (com.google.android.gms.common.server.response.FastJsonResponse.Field)iterator.next();
            if (a(field))
            {
                int j1 = field.f();
                i1 = b(field).hashCode() + (i1 + j1);
            }
        } while (true);
        return i1;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.plus.internal.model.people.a.a(this, parcel, i1);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        A = hashmap;
        hashmap.put("aboutMe", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("aboutMe", 2));
        A.put("ageRange", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("ageRange", 3, com/google/android/gms/plus/internal/model/people/PersonEntity$AgeRangeEntity));
        A.put("birthday", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("birthday", 4));
        A.put("braggingRights", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("braggingRights", 5));
        A.put("circledByCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("circledByCount", 6));
        A.put("cover", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("cover", 7, com/google/android/gms/plus/internal/model/people/PersonEntity$CoverEntity));
        A.put("currentLocation", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("currentLocation", 8));
        A.put("displayName", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("displayName", 9));
        A.put("gender", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("gender", 12, (new StringToIntConverter()).a("male", 0).a("female", 1).a("other", 2)));
        A.put("id", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("id", 14));
        A.put("image", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("image", 15, com/google/android/gms/plus/internal/model/people/PersonEntity$ImageEntity));
        A.put("isPlusUser", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("isPlusUser", 16));
        A.put("language", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("language", 18));
        A.put("name", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("name", 19, com/google/android/gms/plus/internal/model/people/PersonEntity$NameEntity));
        A.put("nickname", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("nickname", 20));
        A.put("objectType", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("objectType", 21, (new StringToIntConverter()).a("person", 0).a("page", 1)));
        A.put("organizations", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("organizations", 22, com/google/android/gms/plus/internal/model/people/PersonEntity$OrganizationsEntity));
        A.put("placesLived", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("placesLived", 23, com/google/android/gms/plus/internal/model/people/PersonEntity$PlacesLivedEntity));
        A.put("plusOneCount", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("plusOneCount", 24));
        A.put("relationshipStatus", com.google.android.gms.common.server.response.FastJsonResponse.Field.a("relationshipStatus", 25, (new StringToIntConverter()).a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8)));
        A.put("tagline", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("tagline", 26));
        A.put("url", com.google.android.gms.common.server.response.FastJsonResponse.Field.c("url", 27));
        A.put("urls", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("urls", 28, com/google/android/gms/plus/internal/model/people/PersonEntity$UrlsEntity));
        A.put("verified", com.google.android.gms.common.server.response.FastJsonResponse.Field.b("verified", 29));
    }
}
