.class public final enum Lcom/thin/downloadmanager/DownloadRequest$Priority;
.super Ljava/lang/Enum;
.source "DownloadRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/thin/downloadmanager/DownloadRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Priority"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/thin/downloadmanager/DownloadRequest$Priority;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/thin/downloadmanager/DownloadRequest$Priority;

.field public static final enum HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

.field public static final enum IMMEDIATE:Lcom/thin/downloadmanager/DownloadRequest$Priority;

.field public static final enum LOW:Lcom/thin/downloadmanager/DownloadRequest$Priority;

.field public static final enum NORMAL:Lcom/thin/downloadmanager/DownloadRequest$Priority;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 36
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;

    const-string v1, "LOW"

    invoke-direct {v0, v1, v2}, Lcom/thin/downloadmanager/DownloadRequest$Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;->LOW:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .line 37
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;

    const-string v1, "NORMAL"

    invoke-direct {v0, v1, v3}, Lcom/thin/downloadmanager/DownloadRequest$Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;->NORMAL:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .line 38
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;

    const-string v1, "HIGH"

    invoke-direct {v0, v1, v4}, Lcom/thin/downloadmanager/DownloadRequest$Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .line 39
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;

    const-string v1, "IMMEDIATE"

    invoke-direct {v0, v1, v5}, Lcom/thin/downloadmanager/DownloadRequest$Priority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;->IMMEDIATE:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .line 35
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/thin/downloadmanager/DownloadRequest$Priority;

    sget-object v1, Lcom/thin/downloadmanager/DownloadRequest$Priority;->LOW:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    aput-object v1, v0, v2

    sget-object v1, Lcom/thin/downloadmanager/DownloadRequest$Priority;->NORMAL:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    aput-object v1, v0, v3

    sget-object v1, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    aput-object v1, v0, v4

    sget-object v1, Lcom/thin/downloadmanager/DownloadRequest$Priority;->IMMEDIATE:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    aput-object v1, v0, v5

    sput-object v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;->$VALUES:[Lcom/thin/downloadmanager/DownloadRequest$Priority;

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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/thin/downloadmanager/DownloadRequest$Priority;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 35
    const-class v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;

    return-object v0
.end method

.method public static values()[Lcom/thin/downloadmanager/DownloadRequest$Priority;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/thin/downloadmanager/DownloadRequest$Priority;->$VALUES:[Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v0}, [Lcom/thin/downloadmanager/DownloadRequest$Priority;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/thin/downloadmanager/DownloadRequest$Priority;

    return-object v0
.end method
