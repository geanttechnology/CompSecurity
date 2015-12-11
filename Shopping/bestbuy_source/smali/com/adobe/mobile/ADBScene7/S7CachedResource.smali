.class public Lcom/adobe/mobile/ADBScene7/S7CachedResource;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final S7_PARAM_BASE:Ljava/lang/String; = "?fmt=jpg&wid=%d&hei=%d&fit=crop,1"

.field private static final S7_URL_BASE:Ljava/lang/String; = "http://testvipd2.scene7.com/is/%s/%s/%s%s"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    return-void
.end method

.method private GetDefaultS7Params(II)Ljava/lang/String;
    .locals 4

    .prologue
    .line 35
    const-string v0, "?fmt=jpg&wid=%d&hei=%d&fit=crop,1"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public GetS7CachedResource(Ljava/lang/String;Lcom/adobe/mobile/ADBScene7/S7ResourceType;IILjava/lang/String;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/adobe/mobile/ADBScene7/S7ResourceType;",
            "II",
            "Ljava/lang/String;",
            "Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 20
    const-string v0, "http://testvipd2.scene7.com/is/%s/%s/%s%s"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p2}, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->getTypeName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    const/4 v2, 0x2

    aput-object p5, v1, v2

    const/4 v2, 0x3

    invoke-direct {p0, p4, p3}, Lcom/adobe/mobile/ADBScene7/S7CachedResource;->GetDefaultS7Params(II)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 22
    new-instance v1, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;

    new-instance v2, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;

    invoke-direct {v2, p0, p6}, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;-><init>(Lcom/adobe/mobile/ADBScene7/S7CachedResource;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V

    invoke-direct {v1, p0, v0, v2}, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;-><init>(Lcom/adobe/mobile/ADBScene7/S7CachedResource;Ljava/lang/String;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V

    .line 31
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 32
    return-void
.end method
