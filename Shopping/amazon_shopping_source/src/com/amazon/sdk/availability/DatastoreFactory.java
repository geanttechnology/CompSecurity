// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            DataStoreException, FileStore, DropboxDataStore, DataStore

public final class DatastoreFactory
{

    private DatastoreFactory()
    {
    }

    public static DataStore getDataStore(Configuration.PersistenceFormat persistenceformat, Long long1, Long long2, String s)
    {
        if (persistenceformat == null)
        {
            throw new DataStoreException("'format' cannot be null");
        }
        if (s == null)
        {
            throw new DataStoreException("'clientId' cannot be null");
        }
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat[];

            static 
            {
                $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat = new int[Configuration.PersistenceFormat.values().length];
                try
                {
                    $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat[Configuration.PersistenceFormat.PRIVATE_DATA.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat[Configuration.PersistenceFormat.DROPBOX.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.sdk.availability.Configuration.PersistenceFormat[persistenceformat.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new FileStore(s, long1, long2);

        case 2: // '\002'
            return new DropboxDataStore(s);
        }
    }
}
