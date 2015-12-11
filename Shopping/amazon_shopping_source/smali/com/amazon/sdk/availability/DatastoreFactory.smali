.class public final Lcom/amazon/sdk/availability/DatastoreFactory;
.super Ljava/lang/Object;
.source "DatastoreFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/DatastoreFactory$1;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    return-void
.end method

.method public static getDataStore(Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/amazon/sdk/availability/DataStore;
    .locals 3
    .param p0, "format"    # Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    .param p1, "localStorageMaxRollOver"    # Ljava/lang/Long;
    .param p2, "localStorageMaxRollOverSize"    # Ljava/lang/Long;
    .param p3, "clientId"    # Ljava/lang/String;

    .prologue
    .line 28
    if-nez p0, :cond_0

    .line 29
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v2, "\'format\' cannot be null"

    invoke-direct {v1, v2}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 32
    :cond_0
    if-nez p3, :cond_1

    .line 33
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v2, "\'clientId\' cannot be null"

    invoke-direct {v1, v2}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 36
    :cond_1
    const/4 v0, 0x0

    .line 39
    .local v0, "result":Lcom/amazon/sdk/availability/DataStore;
    sget-object v1, Lcom/amazon/sdk/availability/DatastoreFactory$1;->$SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat:[I

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 49
    :goto_0
    return-object v0

    .line 41
    :pswitch_0
    new-instance v0, Lcom/amazon/sdk/availability/FileStore;

    .end local v0    # "result":Lcom/amazon/sdk/availability/DataStore;
    invoke-direct {v0, p3, p1, p2}, Lcom/amazon/sdk/availability/FileStore;-><init>(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V

    .line 42
    .restart local v0    # "result":Lcom/amazon/sdk/availability/DataStore;
    goto :goto_0

    .line 44
    :pswitch_1
    new-instance v0, Lcom/amazon/sdk/availability/DropboxDataStore;

    .end local v0    # "result":Lcom/amazon/sdk/availability/DataStore;
    invoke-direct {v0, p3}, Lcom/amazon/sdk/availability/DropboxDataStore;-><init>(Ljava/lang/String;)V

    .restart local v0    # "result":Lcom/amazon/sdk/availability/DataStore;
    goto :goto_0

    .line 39
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
