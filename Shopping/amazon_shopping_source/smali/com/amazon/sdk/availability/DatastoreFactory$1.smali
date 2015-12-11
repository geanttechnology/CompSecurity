.class synthetic Lcom/amazon/sdk/availability/DatastoreFactory$1;
.super Ljava/lang/Object;
.source "DatastoreFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/DatastoreFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->values()[Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/amazon/sdk/availability/DatastoreFactory$1;->$SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat:[I

    :try_start_0
    sget-object v0, Lcom/amazon/sdk/availability/DatastoreFactory$1;->$SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat:[I

    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->PRIVATE_DATA:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    :try_start_1
    sget-object v0, Lcom/amazon/sdk/availability/DatastoreFactory$1;->$SwitchMap$com$amazon$sdk$availability$Configuration$PersistenceFormat:[I

    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->DROPBOX:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    :goto_1
    return-void

    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_0
.end method
