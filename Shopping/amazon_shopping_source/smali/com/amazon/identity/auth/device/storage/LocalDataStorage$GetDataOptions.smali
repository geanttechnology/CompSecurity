.class final enum Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;
.super Ljava/lang/Enum;
.source "LocalDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "GetDataOptions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

.field public static final enum Deleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

.field public static final enum DirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

.field public static final enum NotDeleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

.field public static final enum NotDirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 88
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    const-string/jumbo v1, "DirtyOnly"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->DirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    .line 89
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    const-string/jumbo v1, "NotDirtyOnly"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    .line 90
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    const-string/jumbo v1, "Deleted"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->Deleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    .line 91
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    const-string/jumbo v1, "NotDeleted"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDeleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    .line 86
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->DirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDirtyOnly:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->Deleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->NotDeleted:Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->$VALUES:[Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 86
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 86
    const-class v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;
    .locals 1

    .prologue
    .line 86
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->$VALUES:[Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions;

    return-object v0
.end method
