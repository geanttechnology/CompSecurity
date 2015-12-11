// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.registry;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.registries.c;
import com.target.mothership.common.registries.e;
import com.target.mothership.common.registries.f;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistryRefineModel
    implements Parcelable
{
    public static class RegistryEventLabel
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RegistryEventLabel a(Parcel parcel)
            {
                return new RegistryEventLabel(parcel);
            }

            public RegistryEventLabel[] a(int l)
            {
                return new RegistryEventLabel[l];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int l)
            {
                return a(l);
            }

        };
        private final c mEventType;
        private int mRegistryEventLabelResId;

        public int a()
        {
            return mRegistryEventLabelResId;
        }

        public c b()
        {
            return mEventType;
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (RegistryEventLabel)obj;
                if (mRegistryEventLabelResId != ((RegistryEventLabel) (obj)).mRegistryEventLabelResId)
                {
                    return false;
                }
                if (mEventType != ((RegistryEventLabel) (obj)).mEventType)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int i1 = mRegistryEventLabelResId;
            int l;
            if (mEventType != null)
            {
                l = mEventType.hashCode();
            } else
            {
                l = 0;
            }
            return l + i1 * 31;
        }

        public void writeToParcel(Parcel parcel, int l)
        {
            parcel.writeInt(mRegistryEventLabelResId);
            if (mEventType == null)
            {
                l = -1;
            } else
            {
                l = mEventType.ordinal();
            }
            parcel.writeInt(l);
        }


        RegistryEventLabel(int l, c c1)
        {
            mRegistryEventLabelResId = l;
            mEventType = c1;
        }

        protected RegistryEventLabel(Parcel parcel)
        {
            mRegistryEventLabelResId = parcel.readInt();
            int l = parcel.readInt();
            if (l == -1)
            {
                parcel = null;
            } else
            {
                parcel = com.target.mothership.common.registries.c.values()[l];
            }
            mEventType = parcel;
        }
    }

    public static class RegistrySortLabel
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RegistrySortLabel a(Parcel parcel)
            {
                return new RegistrySortLabel(parcel);
            }

            public RegistrySortLabel[] a(int l)
            {
                return new RegistrySortLabel[l];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int l)
            {
                return a(l);
            }

        };
        private final f mSortOrder;
        private int mSortTitleResId;
        private final e mSortType;

        public int a()
        {
            return mSortTitleResId;
        }

        public e b()
        {
            return mSortType;
        }

        public f c()
        {
            return mSortOrder;
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            boolean flag2 = true;
            boolean flag3 = false;
            boolean flag;
            if (this == obj)
            {
                flag = true;
            } else
            {
                flag = flag3;
                if (obj != null)
                {
                    flag = flag3;
                    if (getClass() == obj.getClass())
                    {
                        obj = (RegistrySortLabel)obj;
                        flag = flag3;
                        if (mSortTitleResId == ((RegistrySortLabel) (obj)).mSortTitleResId)
                        {
                            flag = flag3;
                            if (mSortType == ((RegistrySortLabel) (obj)).mSortType)
                            {
                                boolean flag1;
                                if (mSortOrder == ((RegistrySortLabel) (obj)).mSortOrder)
                                {
                                    flag1 = flag2;
                                } else
                                {
                                    flag1 = false;
                                }
                                return flag1;
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            int i1 = 0;
            int j1 = mSortTitleResId;
            int l;
            if (mSortType != null)
            {
                l = mSortType.hashCode();
            } else
            {
                l = 0;
            }
            if (mSortOrder != null)
            {
                i1 = mSortOrder.hashCode();
            }
            return (l + j1 * 31) * 31 + i1;
        }

        public void writeToParcel(Parcel parcel, int l)
        {
            byte byte0 = -1;
            parcel.writeInt(mSortTitleResId);
            if (mSortType == null)
            {
                l = -1;
            } else
            {
                l = mSortType.ordinal();
            }
            parcel.writeInt(l);
            if (mSortOrder == null)
            {
                l = byte0;
            } else
            {
                l = mSortOrder.ordinal();
            }
            parcel.writeInt(l);
        }


        RegistrySortLabel(int l, e e1, f f1)
        {
            mSortTitleResId = l;
            mSortType = e1;
            mSortOrder = f1;
        }

        protected RegistrySortLabel(Parcel parcel)
        {
            Object obj = null;
            super();
            mSortTitleResId = parcel.readInt();
            int l = parcel.readInt();
            e e1;
            if (l == -1)
            {
                e1 = null;
            } else
            {
                e1 = com.target.mothership.common.registries.e.values()[l];
            }
            mSortType = e1;
            l = parcel.readInt();
            if (l == -1)
            {
                parcel = obj;
            } else
            {
                parcel = com.target.mothership.common.registries.f.values()[l];
            }
            mSortOrder = parcel;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RegistryRefineModel a(Parcel parcel)
        {
            return new RegistryRefineModel(parcel);
        }

        public RegistryRefineModel[] a(int l)
        {
            return new RegistryRefineModel[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private static final int INVALID_RESOURCE_ID = -1;
    private RegistrySortLabel mDefaultSort;
    private List mEventTypeOptions;
    private RegistryEventLabel mSelectedEvent;
    private RegistrySortLabel mSelectedSort;
    private List mSortingOptions;

    public RegistryRefineModel()
    {
        e();
    }

    protected RegistryRefineModel(Parcel parcel)
    {
        mDefaultSort = (RegistrySortLabel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel$RegistrySortLabel.getClassLoader());
        mSelectedSort = (RegistrySortLabel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel$RegistrySortLabel.getClassLoader());
        mSortingOptions = new ArrayList();
        parcel.readList(mSortingOptions, com/target/ui/model/registry/RegistryRefineModel$RegistrySortLabel.getClassLoader());
        mSelectedEvent = (RegistryEventLabel)parcel.readParcelable(com/target/ui/model/registry/RegistryRefineModel$RegistryEventLabel.getClassLoader());
        mEventTypeOptions = new ArrayList();
        parcel.readList(mSortingOptions, com/target/ui/model/registry/RegistryRefineModel$RegistryEventLabel.getClassLoader());
    }

    private static int a(c c1)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$mothership$common$registries$RegistryEventType[];
            static final int $SwitchMap$com$target$mothership$common$registries$RegistrySort[];

            static 
            {
                $SwitchMap$com$target$mothership$common$registries$RegistryEventType = new int[com.target.mothership.common.registries.c.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.COLLEGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.WEDDING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.BABY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$target$mothership$common$registries$RegistrySort = new int[com.target.mothership.common.registries.e.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$registries$RegistrySort[e.FIRST_NAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$registries$RegistrySort[e.CITY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$registries$RegistrySort[e.EVENT_DATE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.mothership.common.registries.RegistryEventType[c1.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return 0x7f0904c0;

        case 2: // '\002'
            return 0x7f0904c1;

        case 3: // '\003'
            return 0x7f0904bf;
        }
    }

    private static int a(e e1, f f1)
    {
        switch (_cls2..SwitchMap.com.target.mothership.common.registries.RegistrySort[e1.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return !f1.equals(f.ASCENDING_ORDER) ? 0x7f0904c5 : 0x7f0904c4;

        case 2: // '\002'
            return !f1.equals(f.ASCENDING_ORDER) ? 0x7f0904c3 : 0x7f0904c2;

        case 3: // '\003'
            break;
        }
        return !f1.equals(f.ASCENDING_ORDER) ? 0x7f0904be : 0x7f0904bd;
    }

    private void e()
    {
        f();
        g();
        mDefaultSort = k();
    }

    private void f()
    {
        mSortingOptions = new ArrayList();
        for (Iterator iterator = h().iterator(); iterator.hasNext();)
        {
            e e1 = (e)iterator.next();
            Iterator iterator1 = i().iterator();
            while (iterator1.hasNext()) 
            {
                Object obj = (f)iterator1.next();
                int l = a(e1, ((f) (obj)));
                if (l != -1)
                {
                    obj = new RegistrySortLabel(l, e1, ((f) (obj)));
                    mSortingOptions.add(obj);
                }
            }
        }

    }

    private void g()
    {
        mEventTypeOptions = new ArrayList();
        Object obj;
        for (Iterator iterator = j().iterator(); iterator.hasNext(); mEventTypeOptions.add(obj))
        {
            obj = (c)iterator.next();
            obj = new RegistryEventLabel(a(((c) (obj))), ((c) (obj)));
        }

    }

    private List h()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(e.FIRST_NAME);
        arraylist.add(e.CITY);
        arraylist.add(e.EVENT_DATE);
        return arraylist;
    }

    private List i()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(f.ASCENDING_ORDER);
        arraylist.add(f.DESCENDING_ORDER);
        return arraylist;
    }

    private List j()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(c.WEDDING);
        arraylist.add(c.BABY);
        arraylist.add(c.COLLEGE);
        return arraylist;
    }

    private RegistrySortLabel k()
    {
        return new RegistrySortLabel(0x7f0904c4, e.FIRST_NAME, f.ASCENDING_ORDER);
    }

    public List a()
    {
        return com.target.mothership.util.k.a(mSortingOptions);
    }

    public void a(RegistryEventLabel registryeventlabel)
    {
        mSelectedEvent = registryeventlabel;
    }

    public void a(RegistrySortLabel registrysortlabel)
    {
        mSelectedSort = registrysortlabel;
    }

    public List b()
    {
        return com.target.mothership.util.k.a(mEventTypeOptions);
    }

    public com.google.a.a.e c()
    {
        return com.google.a.a.e.c(mSelectedSort);
    }

    public com.google.a.a.e d()
    {
        return com.google.a.a.e.c(mSelectedEvent);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (RegistryRefineModel)obj;
        if (mSelectedSort == null ? ((RegistryRefineModel) (obj)).mSelectedSort != null : !mSelectedSort.equals(((RegistryRefineModel) (obj)).mSelectedSort))
        {
            return false;
        }
        if (mSelectedEvent == null) goto _L4; else goto _L3
_L3:
        if (mSelectedEvent.equals(((RegistryRefineModel) (obj)).mSelectedEvent)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((RegistryRefineModel) (obj)).mSelectedEvent == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int i1 = 0;
        int l;
        if (mSelectedSort != null)
        {
            l = mSelectedSort.hashCode();
        } else
        {
            l = 0;
        }
        if (mSelectedEvent != null)
        {
            i1 = mSelectedEvent.hashCode();
        }
        return l * 31 + i1;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeParcelable(mDefaultSort, 0);
        parcel.writeParcelable(mSelectedSort, 0);
        parcel.writeList(mSortingOptions);
        parcel.writeParcelable(mSelectedEvent, 0);
        parcel.writeList(mEventTypeOptions);
    }

}
