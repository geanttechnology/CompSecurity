.class public final enum Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;
.super Ljava/lang/Enum;
.source "TrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AdEvent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum BREAKCOMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum BREAKSTARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum COMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum FIRSTQUARTILE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum MIDPOINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

.field public static final enum THIRDQUARTILE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 17
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "BREAKSTARTED"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->BREAKSTARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "BREAKCOMPLETED"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->BREAKCOMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "STARTED"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "COMPLETED"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->COMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "FIRSTQUARTILE"

    invoke-direct {v0, v1, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->FIRSTQUARTILE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "MIDPOINT"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->MIDPOINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "THIRDQUARTILE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->THIRDQUARTILE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const-string v1, "ERROR"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    const/16 v0, 0x8

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->BREAKSTARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->BREAKCOMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->COMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v1, v0, v6

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->FIRSTQUARTILE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->MIDPOINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->THIRDQUARTILE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    aput-object v2, v0, v1

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

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
    .line 17
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 17
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    return-object v0
.end method
