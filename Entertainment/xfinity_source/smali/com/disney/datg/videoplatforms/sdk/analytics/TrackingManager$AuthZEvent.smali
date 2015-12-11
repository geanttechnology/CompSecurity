.class public final enum Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;
.super Ljava/lang/Enum;
.source "TrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AuthZEvent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

.field public static final enum AUTH_Z_FAILED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

.field public static final enum AUTH_Z_STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

.field public static final enum AUTH_Z_SUCCESS:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 19
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    const-string v1, "AUTH_Z_STARTED"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    const-string v1, "AUTH_Z_SUCCESS"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_SUCCESS:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    const-string v1, "AUTH_Z_FAILED"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_FAILED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_SUCCESS:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_FAILED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    aput-object v1, v0, v4

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

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
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 19
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    return-object v0
.end method
