.class public final enum Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;
.super Ljava/lang/Enum;
.source "AdViewEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/view/AdViewEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AdViewEventType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum AD_CLICK:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_COMPLETE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_ERROR:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_LOAD:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_LOG:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_PAUSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_PROGRESS:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_REPLAY:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_RESUME:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_SKIP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_START:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_STOP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_USER_CLOSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field public static final enum AD_VOLUME_CHANGE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field private static final synthetic ENUM$VALUES:[Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_START"

    invoke-direct {v0, v1, v3}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_START:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 12
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_REPLAY"

    invoke-direct {v0, v1, v4}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_REPLAY:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 13
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_STOP"

    invoke-direct {v0, v1, v5}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_STOP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 14
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_COMPLETE"

    invoke-direct {v0, v1, v6}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_COMPLETE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 15
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_LOAD"

    invoke-direct {v0, v1, v7}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_LOAD:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 16
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_PROGRESS"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_PROGRESS:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 17
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_PAUSE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_PAUSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 18
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_RESUME"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_RESUME:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 19
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_LOG"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_LOG:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 20
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_ERROR"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_ERROR:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 21
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_CLICK"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_CLICK:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 22
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_VOLUME_CHANGE"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_VOLUME_CHANGE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 23
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_USER_CLOSE"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_USER_CLOSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 24
    new-instance v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    const-string v1, "AD_SKIP"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_SKIP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    .line 9
    const/16 v0, 0xe

    new-array v0, v0, [Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_START:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_REPLAY:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_STOP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_COMPLETE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_LOAD:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_PROGRESS:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_PAUSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_RESUME:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_LOG:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_ERROR:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_CLICK:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_VOLUME_CHANGE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_USER_CLOSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_SKIP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ENUM$VALUES:[Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    return-object v0
.end method

.method public static values()[Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ENUM$VALUES:[Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    array-length v1, v0

    new-array v2, v1, [Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
